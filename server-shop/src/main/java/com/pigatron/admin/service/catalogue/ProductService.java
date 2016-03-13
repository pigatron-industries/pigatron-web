package com.pigatron.admin.service.catalogue;

import com.pigatron.admin.domain.entity.catalogue.Product;
import com.pigatron.admin.domain.repository.ProductRepository;
import com.pigatron.server.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractRepositoryService<Product> {

	@Autowired
	public ProductService(ProductRepository repository) {
		super(repository);
	}

}
