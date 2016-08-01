package com.endava.training.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Created by iciuta on 8/1/2016.
 */
@Configuration
public class DozerConfiguration {
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper getDozerBeanMapper() {
        List<String> configurationFiles = Arrays.asList(
                "dozer/dozer-mappings.xml"
        );

        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(configurationFiles);
        return dozerBeanMapper;
    }
}
