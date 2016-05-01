package com.pigatron.shop.catalogue.service;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.admin.service.AbstractRepositoryService;
import com.pigatron.shop.catalogue.entity.query.ProductQuery;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractRepositoryService<Product> {

	ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
		this.productRepository = repository;
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
		List<Product> optionProducts = product.getAllOptionProducts();
		optionProducts.forEach(p -> p.setIsOption(true));
		repository.save(optionProducts);
		return super.save(product);
	}

}
