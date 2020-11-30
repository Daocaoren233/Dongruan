package com.neusoft.springbootsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan("com.neusoft.springbootsell")
public class SpringbootsellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootsellApplication.class, args);
    }

}

//@Configuration
//public class BeanConfig {
//    @Bean
////    ImageService imageService(){
////        return new ImageServiceImpl("test");
////    }
//}
