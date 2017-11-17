package com.asiainfo.onlineLog.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.asiainfo.onlineLog.dao"}, sqlSessionFactoryRef = "onlineLogSqlSessionFactory")
public class OnlineLogConfig {
    @Bean(name = "onlineLogDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.onlineLog")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "onlineLogSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("onlineLogDataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;
    }

    @Bean(name = "onlineLogTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("onlineLogDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
