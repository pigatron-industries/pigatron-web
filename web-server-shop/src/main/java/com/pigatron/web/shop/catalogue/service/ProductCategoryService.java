package com.pigatron.web.shop.catalogue.service;

import com.google.common.collect.Lists;
import com.pigatron.web.core.service.AbstractRepositoryService;
import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import com.pigatron.web.shop.catalogue.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService extends AbstractRepositoryService<ProductCategory> {

	public ProductCategory addSubcategory(String parentId, ProductCategory newCategory) {
		ProductCategory parentCategory = findById(parentId);
		parentCategory.getSubcategories().add(newCategory);
		ProductCategory category = repository.save(newCategory);
		repository.save(parentCategory);
		return category;
	}

	@Override
	public void delete(String id) {
		List<ProductCategory> all = Lists.newArrayList(repository.findAll());
		ProductCategory deleteCategory = findById(id);
		//remove reference from parent
		all.stream()
				.filter(c -> c.getSubcategories().contains(deleteCategory))
				.forEach(c -> removeSubcategoryFromParent(c, deleteCategory));
		repository.deleteById(id);
	}

	private void removeSubcategoryFromParent(ProductCategory parent, ProductCategory child) {
		parent.getSubcategories().remove(child);
		repository.save(parent);
	}

}
