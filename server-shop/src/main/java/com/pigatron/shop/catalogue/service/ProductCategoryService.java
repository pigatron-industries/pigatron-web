package com.pigatron.shop.catalogue.service;

import com.google.common.collect.Lists;
import com.pigatron.shop.catalogue.entity.ProductCategory;
import com.pigatron.server.service.AbstractRepositoryService;
import com.pigatron.shop.catalogue.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public void delete(String id) {
		List<ProductCategory> all = Lists.newArrayList(repository.findAll());
		ProductCategory deleteCategory = repository.findOne(id);
		//remove reference from parent
		all.stream()
				.filter(c -> c.getSubcategories().contains(deleteCategory))
				.forEach(c -> removeSubcategoryFromParent(c, deleteCategory));
		repository.delete(id);
	}

	private void removeSubcategoryFromParent(ProductCategory parent, ProductCategory child) {
		parent.getSubcategories().remove(child);
		repository.save(parent);
	}

}
