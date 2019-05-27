package se.lnu.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@EnableConfigurationProperties({ FileStorageProperties.class })
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
                PersistenceJPAConfig.class
                
        };
    }
    @Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class
        };
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] {
                "/"
        };
    }
   
}
