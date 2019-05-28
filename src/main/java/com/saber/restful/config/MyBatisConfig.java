package com.saber.restful.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/5/7
 */
@Configuration
public class MyBatisConfig {

    /**
     * 开启myBatis的驼峰命名
     * @return 定制器
     */
    @Bean
    public ConfigurationCustomizer customizer (){
        return configuration -> configuration.setMapUnderscoreToCamelCase(true);
    }
}
