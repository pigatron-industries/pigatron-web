package com.pigatron.web.cms.setup;

import com.pigatron.web.core.settings.Settings;
import com.pigatron.web.core.settings.SettingsRepository;
import com.pigatron.web.core.settings.website.LinkPosition;
import com.pigatron.web.core.settings.website.LinkType;
import com.pigatron.web.core.settings.website.WebSiteSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.pigatron.web.core.settings.website.Link.aLink;
import static com.pigatron.web.core.settings.website.WebSiteSettings.aWebSiteSettings;

@Service
@Profile("cms")
public class CmsRepositorySetupService {

    private static final Logger logger = LoggerFactory.getLogger(CmsRepositorySetupService.class);

    @Autowired
    private SettingsRepository settingsRepository;

    @EventListener
    public void setupRepositories(ContextRefreshedEvent event) {
        logger.info("Checking repository setup...");
        addDefaultWebSiteSettings();
    }

    protected void addDefaultWebSiteSettings() {
        Optional<Settings> settings = settingsRepository.findById(WebSiteSettings.ID);
        if(!settings.isPresent()) {
            WebSiteSettings webSiteSettings = aWebSiteSettings()
                    .withTitle("Site Title")
                    .withLink(aLink()
                            .withLinkType(LinkType.ROUTE)
                            .withPosition(LinkPosition.TOP_LEFT)
                            .withTitle("Home")
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
                    .build();
            settingsRepository.save(webSiteSettings);
        }
    }


}
