package caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FacebookLookupService {

    RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookLookupService.class);

    @Autowired
    public FacebookLookupService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("pages")
    public Page findPage(String page) {
        LOGGER.info("calling facebookLookupService with {}", page);
        return restTemplate.getForObject("http://graph.facebook.com/" + page, Page.class);
    }

}
