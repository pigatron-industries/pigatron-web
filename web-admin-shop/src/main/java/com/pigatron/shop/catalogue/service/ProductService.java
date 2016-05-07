package com.pigatron.shop.catalogue.service;

import com.pigatron.admin.sequence.SequenceService;
import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.admin.service.AbstractRepositoryService;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

@Service
public class ProductService extends AbstractRepositoryService<Product> {

	public static final String SKU_SEQUENCE = "productSku";

	ProductRepository productRepository;
	SequenceService sequenceService;

	@Autowired
	public ProductService(ProductRepository repository, SequenceService sequenceService) {
		super(repository);
		this.productRepository = repository;
		this.sequenceService = sequenceService;
	}

	public Product getBySku(String sku) {
		return productRepository.findBySku(sku);
	}

	public Product getByUrlKey(String urlKey) {
		return productRepository.findByUrlKey(urlKey);
	}

	public List<Product> find(ProductQuery query) {
		return productRepository.find(query);
	}

	@Override
	public Product save(Product product) {
		generateSku(product);
		generateUrlKey(product);
		saveOptions(product);
		return super.save(product);
	}

	/**
	 * Generate an auto increment based SKU. For product options concatenates a unique number onto the parent SKU.
	 * @param product
     */
	private void generateSku(Product product) {
		if(product.getSku() == null || product.getSku().isEmpty()) {
			if(product.getParentProduct() == null) {
				// Main Product
				int sku = sequenceService.getNextValue(SKU_SEQUENCE);
				product.setSku(sku+"");
			} else {
				// Product Options
				List<Product> allOptionProducts = product.getParentProduct().getAllOptionProducts();
				String skuPrefix = product.getParentProduct().getSku() + "-";
				int i = 1;
				String sku = skuPrefix + i;
				while(skuExists(sku, product, allOptionProducts)) {
					i++;
					sku = skuPrefix + i;
				}
				product.setSku(sku);
			}
		}
	}

	private boolean skuExists(String sku, Product product, List<Product> productsToSave) {
		if(productsToSave.stream().filter(p->p.getSku().equals(sku)).findFirst().isPresent()) {
			return true;
		} else {
			Product existing = productRepository.findBySku(sku);
			return existing != null && !existing.getId().equals(product.getId());
		}
	}

	/**
	 * Generates a url key for the product by making the name lower case and replacing spaces with underscores,
	 * then adds a number on the end if the url key already exists for another product.
	 * @param product
     */
	void generateUrlKey(Product product) {
		if(product.getUrlKey() == null || product.getUrlKey().isEmpty()) {
			String urlKey = "";
			if(product.getParentProduct() != null) {
				urlKey += product.getParentProduct().getUrlKey() + "_";
			}
			urlKey += product.getName().toLowerCase().replaceAll("\\W", "_");

			if (urlKeyExists(urlKey, product)) {
				int i = 2;
				while (urlKeyExists(urlKey+i, product)) {
					i++;
				}
				product.setUrlKey(urlKey + i);
			}
			else {
				product.setUrlKey(urlKey);
			}
		}
	}

	private boolean urlKeyExists(String urlKey, Product product) {
		Product existing = productRepository.findByUrlKey(urlKey);
		return existing != null && !existing.getId().equals(product.getId());
	}

	/**
	 * Sets option flag on product options added or removed and saves them seperately.
	 * @param product
     */
	private void saveOptions(Product product) {
		List<Product> optionProducts = product.getAllOptionProducts();

		// Removed options
		if(product.getId() != null) {
			Product oldProduct = repository.findOne(product.getId());
			List<Product> oldOptionProducts = oldProduct.getAllOptionProducts();
			oldOptionProducts.stream().filter(p -> !optionProducts.contains(p)).forEach((p) -> {
				p.setIsOption(false);
				p.setParentProduct(null);
				save(p);
			});
		}

		// Added options
		optionProducts.stream().forEach((p) -> {
			p.setIsOption(true);
			p.setParentProduct(product);
			save(p);
		});
	}

}
