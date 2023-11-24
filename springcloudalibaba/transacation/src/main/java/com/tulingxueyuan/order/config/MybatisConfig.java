package com.tulingxueyuan.order.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = {"com.tulingxueyuan.order.dao"})
public class MybatisConfig {

    //（1）如果配置了DataSource可以把application.yml中的spring.datasource注释
    //（2）如果配置了DataSource，springboot不会自动创建dataSource
    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/seata_order");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("mqq2005");
        druidDataSource.setDbType("com.alibaba.druid.pool.DruidDataSource");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setMaxActive(20);
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(3);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        return druidDataSource;
    }

    //（1）如果配置了sqlSessionFactory可以把application.yml中的mybatis.mapper-locations给注释
    //（2）如果配置了sqlSessionFactory，springboot不会自动创建sqlSessionFactory和PlatformTransactionManager,
    //如果不配置，spring会自动创建
    //（3）如果没引入springboot，spring是不会自动创建sqlSessionFactory和PlatformTransactionManager的
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }

    //（1）如果创建了PlatformTransactionManager，springboot就不会自动创建PlatformTransactionManager了
    //（2）如果创建了sqlSessionFactory，springboot也不会自动创建PlatformTransactionManager了
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
