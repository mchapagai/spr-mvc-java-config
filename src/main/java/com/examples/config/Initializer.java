package com.examples.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Equivalent to xml-equivalent/web.xml Deployment Descriptor file for the web
 * applications
 * 
 * @author mchapagai
 *
 */
public class Initializer implements WebApplicationInitializer {

	/**
	 * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContect)
	 * 
	 *      Create the 'root' Spring application context Create the dispatcher
	 *      servlet's Spring application context Manage the lifecycle of the
	 *      root application context Register and map the dispatcher servlet
	 * @param servletContext
	 * @throws ServletException
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebAppConfig.class, MultipartConfig.class,
				TilesConfig.class, DataSourceConfig.class,
				MessageSourceConfig.class);
		context.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

}
