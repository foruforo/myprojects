/**
 * 
 */
package com.springjavaconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * @author Programmers
 *
 */
@Configuration
@EnableWebMvc
@Import({DBConfiguration.class})
@ComponentScan({"com.springjavaconfig.web", "com.springjavaconfig.service.impl"})
public class WebAppConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public UrlBasedViewResolver setupViewResolver(){ /* if we pass on one vie resolver */
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	/* if we pass multiple view reolver use ContentNegotiationManager */
	/*@Bean
	public ViewResolver setupViewResolver(ContentNegotiationManager manager){
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		resolvers.add(resolver);
		
		ContentNegotiatingViewResolver resolver2 = new ContentNegotiatingViewResolver();
		resolver2.setViewResolvers(resolvers);
		resolver2.setContentNegotiationManager(manager);
		return resolver2;
	}*/
}
