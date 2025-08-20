package com.jumboalimentos.SystemCallAndTask.config;


import com.oiis.libs.java.spring.commons.BaseClientSsoSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SsoClientCheck extends BaseClientSsoSecurityConfig {

}
