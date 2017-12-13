package com.dev.neo;

import java.beans.PropertyVetoException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	 @Resource
     private Environment env;
	 
	 
	 private static final String PROPERTY_NAME_DATABASE_DRIVER = "spring.datasource.driver-class-name";
	 private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
	 private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.jdbc-url";
	 private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
     private static final String MAX_POOL_SIZE="jdbc.maxPoolSize";	 
     private static final String MIN_POOL_SIZE="jdbc.minPoolSize";
     private static final String MAX_STATEMENTS="jdbc.maxStatements";



    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
    	 ComboPooledDataSource combopool= new ComboPooledDataSource();
    	 
    	 combopool.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    	 combopool.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
    	 combopool.setUser(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
    	 combopool.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    	 int i = Integer.parseInt(env.getRequiredProperty(MAX_POOL_SIZE));
    	 int j = Integer.parseInt(env.getRequiredProperty(MIN_POOL_SIZE));
    	 int k = Integer.parseInt(env.getRequiredProperty(MAX_STATEMENTS));
         combopool.setMaxPoolSize(i);
         combopool.setMinPoolSize(j);
         combopool.setMaxStatements(k);

            return combopool;
    }
    
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	//registry.addResourceHandler("/static/**").addResourceLocations("/*");
    	registry.addResourceHandler("/static/**").addResourceLocations("/*");
    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

    
  
}
