package spring.cloud.example.zuul;

import spring.cloud.example.zuul.filter.pre.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created 2016-11-13 23:16:53
 *
 * @author Michael.Zhang
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication
public class ZuulProxyApplication {

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

}