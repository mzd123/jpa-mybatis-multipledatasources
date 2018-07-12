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
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary", basePackages = "com.mzd.multipledatasources.dao.test01.jpa", transactionManagerRef = "transactionManagerPrimary")
@MapperScan(basePackages = "com.mzd.multipledatasources.mapper.test01", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSourceConfig1 {
	@Autowired
	private JpaProperties jpaProperties;

	@Bean(name = "test1DataSource")
	// @Primary
	@ConfigurationProperties(prefix = "spring.datasource.test1")
	public DataSource getDateSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "test1SqlSessionFactory")
	// @Primary
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/test01/*.xml"));
		return bean.getObject();
	}

	@Bean("test1SqlSessionTemplate")
	// @Primary
	public SqlSessionTemplate test1sqlsessiontemplate(
			@Qualifier("test1SqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}

	// @Primary
	@Bean(name = "entityManagerPrimary")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("test1DataSource") DataSource datasource) {
		return entityManagerFactoryPrimary(builder, datasource).getObject().createEntityManager();
	}

	// @Primary
	@Bean(name = "entityManagerFactoryPrimary")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder,
			@Qualifier("test1DataSource") DataSource datasource) {
		return builder.dataSource(datasource).properties(getVendorProperties(datasource))
				.packages("com.mzd.multipledatasources.bean.Single1") // 设置实体类所在位置
				.persistenceUnit("datasource1").build();
	}

	@Bean(name = "transactionManagerPrimary")
	public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder,
			@Qualifier("test1DataSource") DataSource datasource) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder, datasource).getObject());
	}

	private Map<String, String> getVendorProperties(@Qualifier("test1DataSource") DataSource datasource) {
		return jpaProperties.getHibernateProperties(datasource);
	}

}
