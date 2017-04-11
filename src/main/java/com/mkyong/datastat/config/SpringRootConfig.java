package com.mkyong.datastat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.mkyong.datastat.service" })
public class SpringRootConfig {
}