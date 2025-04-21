package com.uzma.config;

import com.uzma.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@ComponentScan (basePackages = "com.uzma.beans")
public class ProjectConfig {

}
