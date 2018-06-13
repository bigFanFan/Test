package com.lhiot.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // spring-boot
@EnableDiscoveryClient // 服务注册
@EnableHystrix // 启用熔断
@EnableFeignClients // 启用Feign
@EnableScheduling // 启用调度
@EnableTransactionManagement // 启用声明式事务管理
@Slf4j
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BasicDataCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicDataCenterApplication.class, args);
        /**
         * 出现这个吉祥马就是程序启动成功的标识， 勿删 ！！
         */
        log.info(" application startup success !\n" +
                "                           _(\\_/) \n" +
                "                         ,((((^`\\\n" +
                "                        ((((  (6 \\ \n" +
                "                      ,((((( ,    \\\n" +
                "  ,,,_              ,(((((  /\"._  ,`,\n" +
                " ((((\\\\ ,...       ,((((   /    `-.-'\n" +
                " )))  ;'    `\"'\"'\"\"((((   (      \n" +
                "(((  /            (((      \\\n" +
                " )) |   basic-data-center  |\n" +
                "((  |        .       '     |\n" +
                "))  \\     _ '      `t   ,.')\n" +
                "(   |   y;- -,-\"\"'\"-.\\   \\/  \n" +
                ")   / ./  ) /         `\\  \\\n" +
                "   |./   ( (           / /'\n" +
                "   ||     \\\\          //'|\n" +
                "   ||      \\\\       _//'||\n" +
                "   ||       ))     |_/  ||\n" +
                "   \\_\\     |_/          ||\n" +
                "   `'\"                  \\_\\\n" +
                "                        `'\"");
    }
}
