package com.uzma.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// * To Tell Spring it needs to search for classes annotated
// * with stereotype annotation, we use the @ComponentScan annotation over
// * the configuration class
// */
@Configuration
@ComponentScan (basePackages = "com.uzma.beans")
public class ProjectConfig {
}
