package com.pigatron.web.shop.catalogue.service;

import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import com.pigatron.web.shop.catalogue.repository.ProductCategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ProductCategoryServiceTest {

	@Mock
	private ProductCategoryRepository productCategoryRepository;

	private ProductCategoryService productCategoryService;

	@Before
	public void setup() {
		productCategoryService = new ProductCategoryService(productCategoryRepository);
	}

	@Test
	public void testDelete() {
		ProductCategory root = new ProductCategory("root", "Root");
		ProductCategory child = new ProductCategory("child", "Child");
		root.getSubcategories().add(child);

		given(productCategoryRepository.findAll()).willReturn(Arrays.asList(root, child));
		given(productCategoryRepository.findById("child")).willReturn(Optional.of(child));

		productCategoryService.delete("child");

		assertThat(root.getSubcategories().size()).isEqualTo(0);
	}

}
