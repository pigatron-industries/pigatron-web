package com.pigatron.shop.service.setup;

import com.pigatron.shop.domain.entity.catalogue.ProductCategory;
import com.pigatron.shop.domain.repository.ProductCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Service responsible for initial repository setup.
 * Checks to see if it needs to do anything on startup.
 */
@Service
public class RepositorySetupService {

    private static final Logger logger = LoggerFactory.getLogger(RepositorySetupService.class);

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @EventListener
    public void setupRepositories(ContextRefreshedEvent event) {
        logger.info("Checking repository setup...");
        addRootCategory();
    }

    private void addRootCategory() {
        ProductCategory root = productCategoryRepository.findOne(ProductCategory.ROOT_ID);
        if(root == null) {
            logger.info("Creating root product category.");
            ProductCategory rootCategory = new ProductCategory(ProductCategory.ROOT_ID, "Root");
            productCategoryRepository.save(rootCategory);
        }
    }

}
