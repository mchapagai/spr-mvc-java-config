package com.examples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
 
/**
 * @author mchapagai
 * View Resolver
 */
@Configuration
public class TilesConfig {
 
    private static final String TILES_VIEW_RESOLVER_DEFINITION = "WEB-INF/tiles/tiles-configuration.xml";
    private static final String CHILD_VIEW_RESOLVER_DEFINITION = "WEB-INF/tiles/child-configuration.xml";
    private static final String JDBC_VIEW_RESOLVER_DEFINITION = "WEB-INF/tiles/jdbc-view-configuration.xml";

    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        tilesViewResolver.setOrder(2);
        return tilesViewResolver;
    }
 
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }
 
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {TILES_VIEW_RESOLVER_DEFINITION, CHILD_VIEW_RESOLVER_DEFINITION,
                JDBC_VIEW_RESOLVER_DEFINITION});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
 
}