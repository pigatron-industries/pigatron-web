package com.pigatron.shop.catalogue.service;

import com.pigatron.admin.sequence.SequenceService;
import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.pigatron.shop.catalogue.entity.Product.ProductBuilder.aProduct;
import static com.pigatron.shop.catalogue.entity.option.SelectProduct.SelectProductBuilder.aSelectProduct;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private SequenceService sequenceService;
    @InjectMocks
    private ProductService productService;


    @Test
    public void testGenerateUrlKey() {
        Product product = aProduct().id("1").name("Product Name").build();
        productService.save(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name");
    }

    @Test
    public void testGenerateUrlKey2() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(aProduct().id("2").name("2").build());
        productService.save(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name2");
    }

    @Test
    public void testGenerateUrlKey3() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(aProduct().id("2").name("2").build());
        given(productRepository.findByUrlKey("product_name2")).willReturn(aProduct().id("3").name("3").build());
        productService.save(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name3");
    }

    @Test
    public void testGenerateUrlKeySameProduct() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(productRepository.findByUrlKey("product_name")).willReturn(product);
        productService.save(product);
        assertThat(product.getUrlKey()).isEqualTo("product_name");
    }

    @Test
    public void testGenerateSku() {
        Product product = aProduct().id("1").name("Product Name").build();
        given(sequenceService.getNextValue(ProductService.SKU_SEQUENCE)).willReturn(101);
        productService.save(product);
        assertThat(product.getSku()).isEqualTo("101");
    }

    @Test
    public void testGenerateSkuOnParentAndOptions() {
        Product optionProduct1 = aProduct()
                .id("2")
                .name("Option Name 1")
                .build();
        Product optionProduct2 = aProduct()
                .id("3")
                .name("Option Name 2")
                .build();
        Product product = aProduct()
                .id("1")
                .name("Product Name")
                .option(aSelectProduct()
                        .product(optionProduct1)
                        .build())
                .option(aSelectProduct()
                        .product(optionProduct2)
                        .build())
                .build();
        given(sequenceService.getNextValue(ProductService.SKU_SEQUENCE)).willReturn(101);
        productService.save(product);
        assertThat(product.getSku()).isEqualTo("101");
        assertThat(optionProduct1.getSku()).isEqualTo("101-1");
        assertThat(optionProduct2.getSku()).isEqualTo("101-2");
    }

    @Test
    public void testGenerateSkuOnOption() {
        Product optionProduct1 = aProduct()
                .id("2")
                .name("Option Name 1")
                .sku("optionsku")
                .build();
        Product optionProduct2 = aProduct()
                .id("3")
                .name("Option Name 2")
                .build();
        Product product = aProduct()
                .id("1")
                .name("Product Name")
                .sku("parentsku")
                .option(aSelectProduct()
                        .product(optionProduct1)
                        .build())
                .option(aSelectProduct()
                        .product(optionProduct2)
                        .build())
                .build();
        given(sequenceService.getNextValue(ProductService.SKU_SEQUENCE)).willReturn(101);
        productService.save(product);
        assertThat(product.getSku()).isEqualTo("parentsku");
        assertThat(optionProduct1.getSku()).isEqualTo("optionsku");
        assertThat(optionProduct2.getSku()).isEqualTo("parentsku-1");
    }

    @Test
    public void testGenerateSkuOnOptionExisting() {
        Product optionProduct1 = aProduct()
                .id("2")
                .name("Option Name 1")
                .build();
        Product optionProduct2 = aProduct()
                .id("3")
                .name("Option Name 2")
                .sku("parentsku-1")
                .build();
        Product product = aProduct()
                .id("1")
                .name("Product Name")
                .sku("parentsku")
                .option(aSelectProduct()
                        .product(optionProduct1)
                        .build())
                .option(aSelectProduct()
                        .product(optionProduct2)
                        .build())
                .build();
        given(sequenceService.getNextValue(ProductService.SKU_SEQUENCE)).willReturn(101);
        productService.save(product);
        assertThat(product.getSku()).isEqualTo("parentsku");
        assertThat(optionProduct1.getSku()).isEqualTo("parentsku-2");
        assertThat(optionProduct2.getSku()).isEqualTo("parentsku-1");
    }

    @Test
    public void testSaveOptionsAddOne() {
        Product oldProduct = aProduct()
                .id("1")
                .name("Product Name")
                .build();
        Product newProduct = aProduct()
                .id("1")
                .name("Product Name")
                .option(aSelectProduct()
                        .product(aProduct()
                                .name("Option 1")
                                .build())
                        .build())
                .build();
        given(productRepository.findOne(oldProduct.getId())).willReturn(oldProduct);

        productService.save(newProduct);

        assertThat(newProduct.findAllOptionProducts().get(0).getIsOption()).isTrue();
        assertThat(newProduct.findAllOptionProducts().get(0).getParentProduct()).isEqualTo(newProduct);
    }

    @Test
    public void testSaveOptionsDeleteOne() {
        Product oldProduct = aProduct()
                .id("1")
                .name("Product Name")
                .option(aSelectProduct()
                        .product(aProduct()
                                .name("Option 1")
                                .build())
                        .build())
                .build();
        Product newProduct = aProduct()
                .id("1")
                .name("Product Name")
                .build();
        given(productRepository.findOne(oldProduct.getId())).willReturn(oldProduct);

        productService.save(newProduct);

        assertThat(oldProduct.findAllOptionProducts().get(0).getIsOption()).isFalse();
        assertThat(oldProduct.findAllOptionProducts().get(0).getParentProduct()).isNull();
    }
}
