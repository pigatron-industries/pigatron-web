package com.pigatron.shop.catalogue;

import com.pigatron.shop.catalogue.entity.Product;
import com.pigatron.server.service.AbstractRepositoryService;
import com.pigatron.shop.catalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractRepositoryService<Product> {

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
	}

}
