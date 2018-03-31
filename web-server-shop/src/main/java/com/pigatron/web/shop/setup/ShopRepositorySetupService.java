package com.pigatron.web.shop.setup;

import com.pigatron.web.core.settings.Settings;
import com.pigatron.web.core.settings.SettingsRepository;
import com.pigatron.web.core.settings.website.LinkPosition;
import com.pigatron.web.core.settings.website.LinkType;
import com.pigatron.web.core.settings.website.WebSiteSettings;
import com.pigatron.web.shop.catalogue.entity.ProductCategory;
import com.pigatron.web.shop.catalogue.repository.ProductCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pigatron.web.core.settings.website.Link.aLink;
import static com.pigatron.web.core.settings.website.WebSiteSettings.aWebSiteSettings;

/**
 * Service responsible for initial repository setup.
 * Checks to see if it needs to do anything on startup.
 */
@Service
public class ShopRepositorySetupService {

    private static final Logger logger = LoggerFactory.getLogger(ShopRepositorySetupService.class);

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private SettingsRepository settingsRepository;


    @EventListener
    public void setupRepositories(ContextRefreshedEvent event) {
        logger.info("Checking repository setup...");
        addRootCategory();
        addDefaultWebSiteSettings();
    }

    private void addRootCategory() {
        Optional<ProductCategory> root = productCategoryRepository.findById(ProductCategory.ROOT_ID);
        if(!root.isPresent()) {
            logger.info("Creating root product category.");
            ProductCategory rootCategory = new ProductCategory(ProductCategory.ROOT_ID, ProductCategory.ROOT_NAME);
            productCategoryRepository.save(rootCategory);
        }
    }

    protected void addDefaultWebSiteSettings() {
        Optional<Settings> settings = settingsRepository.findById(WebSiteSettings.ID);
        if(!settings.isPresent()) {
            logger.info("Creating default web site settings.");
            WebSiteSettings webSiteSettings = aWebSiteSettings()
                    .withTitle("Site Title")
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_LEFT)
                            .withTitle("Shop")
                            .withAction("/")
                            .build())
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_LEFT)
                            .withTitle("Blog")
                            .withAction("/posts")
                            .build())
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_LEFT)
                            .withTitle("About")
                            .withAction("/page/about")
                            .build())
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_RIGHT)
                            .withTitle("<span class=\"fa fa-lg fa-shopping-cart\"></span> Basket")
                            .withAction("/basket")
                            .build())
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_RIGHT)
                            .withTitle("<span class=\"fa fa-lg fa-user\"></span> Account")
                            .withAction("/account")
                            .build())
                    .build();
            settingsRepository.save(webSiteSettings);
        }
    }

}
