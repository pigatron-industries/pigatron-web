package com.pigatron.shop.service.catalogue;

import com.pigatron.shop.domain.entity.catalogue.Product;
import com.pigatron.shop.domain.repository.ProductRepository;
import com.pigatron.shop.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractRepositoryService<Product> {

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
	}

}
