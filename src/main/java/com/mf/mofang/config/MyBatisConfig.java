//package com.mf.mofang.config;
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author pt
// * @email plexpt@gmail.com
// * @date 2019-09-17 14:56
// */
//@Configuration
//public class MyBatisConfig {
//    @Autowired
//    private DataSourceProperties dataSourceProperties;
//
////    @Bean
////    public DataSource dataSource() {
//////        SQLiteDataSource dataSource = new SQLiteDataSource();
//////        dataSource.setUrl(dataSourceProperties.getUrl());
//////        dataSource.setDatabaseName("main");
//////        return dataSource;
////
////        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//////        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
////        dataSourceBuilder.driverClassName(dataSourceProperties.getDriverClassName());
////        dataSourceBuilder.url(dataSourceProperties.getUrl());
////        dataSourceBuilder.type(SQLiteDataSource.class);
////        DataSource source = dataSourceBuilder.build();
////
////        return source;
////
////    }
//
////    public SqlSessionFactory sqlSessionFactory() throws Exception {
////        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
////        sqlSessionFactoryBean.setDataSource(dataSource());
////        return sqlSessionFactoryBean.getObject();
////    }
//
////    @Bean
////    public MapperScannerConfigurer mapperScannerConfigurer() {
////        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
////        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
////
////        //com.example.demo.dal.mapper 这个包名是所有的Mapper.java文件所在的路径，该包下面的子包里面的文件同样会扫描到。
////        //此包名与具体的应用的名称相关
////        mapperScannerConfigurer.setBasePackage("com.mf.mofang.dao");
////
////        return mapperScannerConfigurer;
////    }
//}
