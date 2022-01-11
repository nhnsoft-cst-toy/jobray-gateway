package com.nhn.nhnsoft.jobray.gateway.common.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <h1>라우팅 관련 Property 클래스</h1>
 */
@Getter
@Configuration
@EnableConfigurationProperties(RoutesProperties.class)
@ConfigurationProperties(prefix = "app.config.routes")
public class RoutesProperties {

    /**
     * user 서비스로 요청을 라우팅할 context-path
     */
    private String userPath = "/user-api/**";
    /**
     * user context-path 에서 strip 할 부분 수
     */
    private int userStripSize = 1;
    /**
     * user 서비스로 요청을 라우팅할 domain
     */
    private String userHost = "user.jobray.com";
    /**
     * user 서비스 URL
     */
    private String userUrl = "http://jobray-user:8080";

    /**
     * commerce 서비스로 요청을 라우팅할 context-path
     */
    private String commercePath = "/commerce-api/**";
    /**
     * commerce context-path 에서 strip 할 부분 수
     */
    private int commerceStripSize = 1;
    /**
     * commerce 서비스로 요청을 라우팅할 domain
     */
    private String commerceHost = "commerce.jobray.com";
    /**
     * commerce 서비스 URL
     */
    private String commerceUrl = "http://jobray-commerce:8080";

    /**
     * messenger 서비스로 요청을 라우팅할 context-path
     */
    private String messengerPath = "/messenger-api/**";
    /**
     * messenger context-path 에서 strip 할 부분 수
     */
    private int messengerStripSize = 1;
    /**
     * messenger 서비스로 요청을 라우팅할 domain
     */
    private String messengerHost = "messenger.jobray.com";
    /**
     * messenger 서비스 URL
     */
    private String messengerUrl = "http://jobray-messenger:8080";
}
