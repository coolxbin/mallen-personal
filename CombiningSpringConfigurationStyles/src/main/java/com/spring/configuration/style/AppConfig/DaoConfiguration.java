package com.spring.configuration.style.AppConfig;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.config.java.annotation.ImportXml;
import org.springframework.config.java.plugin.context.AnnotationDrivenConfig;

@Configurable
@AnnotationDrivenConfig
@ImportXml(locations={"classpath:com/company/app/datasource-config.xml"})
public class DaoConfiguration {
	@PersistenceContext
	private EntityManager em;
	
}
