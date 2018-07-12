package com.mzd.multipledatasources.datasource;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySecondary", basePackages = 
		"com.mzd.multipledatasources.dao.test02.jpa" ,
		transactionManagerRef="transactionManagerSecondary")
@MapperScan(basePackages = "com.mzd.multipledatasources.mapper.test02", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceConfig2 {

	@Autowired
	private JpaProperties jpaProperties;

	@Primary
	@Bean(name = "test2DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.test2")
	public DataSource getDateSource2() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/test02/*.xml"));
		return bean.getObject();
	}

	@Primary
	@Bean("test2SqlSessionTemplate")
	public SqlSessionTemplate test2sqlsessiontemplate(
			@Qualifier("test2SqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}

	@Primary
	@Bean(name = "entityManagerSecondary")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("test2DataSource") DataSource datasource) {
		return entityManagerFactorySecondary(builder, datasource).getObject().createEntityManager();
	}

	@Primary
	@Bean(name = "entityManagerFactorySecondary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary(EntityManagerFactoryBuilder builder,
			@Qualifier("test2DataSource") DataSource datasource) {
		return builder.dataSource(datasource).properties(getVendorProperties(datasource))
				.packages("com.mzd.multipledatasources.bean.Single2") // 设置实体类所在位置
				.persistenceUnit("datasource2").build();
	}

	@Primary
	@Bean(name = "transactionManagerSecondary")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder,
			@Qualifier("test2DataSource") DataSource datasource) {
		return new JpaTransactionManager(entityManagerFactorySecondary(builder, datasource).getObject());
	}

	private Map<String, String> getVendorProperties(@Qualifier("test2DataSource") DataSource datasource) {
		return jpaProperties.getHibernateProperties(datasource);
	}

}
