package com.springboot.YouHuiWang.Config;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class WebXMLConfig {


    /**
     * 因为这里是使用main方法加载的所以没有配置文件这里需要将struts2的核心拦截器实例
     * 否则无法访问struts2
     * 而web项目中struts2的配置文件如下：
     * <filter>
     * <filter-name>struts2</filter-name>
     * <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
     * </filter>
     * <filter-mapping>
     * <filter-name>struts2</filter-name>
     * <url-pattern>/*</url-pattern>
     * </filter-mapping>
     * 所以我们需要在这个配置类中将web中配置的拦截器类创建这样才实现了struts2的核心配置
     * 而路径如果不配置的话默认的就是拦截所有路径
     *
     * @return
     */
    @Bean
    public StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter() {
        return new StrutsPrepareAndExecuteFilter();
    }


    /**
     * 注册一个跨域的过滤器
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }


}
