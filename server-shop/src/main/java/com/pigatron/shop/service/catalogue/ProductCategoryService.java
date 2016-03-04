package com.pigatron.shop.service.catalogue;

import com.pigatron.shop.domain.entity.catalogue.ProductCategory;
import com.pigatron.shop.domain.repository.ProductCategoryRepository;
import com.pigatron.shop.service.AbstractRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService extends AbstractRepositoryService<ProductCategory> {

	@Autowired
	public ProductCategoryService(ProductCategoryRepository repository) {
		super(repository);
	}

	public ProductCategory addSubcategory(String parentId, ProductCategory newCategory) {
		ProductCategory parentCategory = repository.findOne(parentId);
		parentCategory.getSubcategories().add(newCategory);
		newCategory = repository.save(newCategory);
		repository.save(parentCategory);
		return newCategory;
	}

}
