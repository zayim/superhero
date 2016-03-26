package org.zayim.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SuperheroService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperheroService.class);

    @Value("${test.prop}")
    private String testProp;

    public String foo() {
        LOGGER.debug("foo");
        return "foo" + testProp;
    }
}
