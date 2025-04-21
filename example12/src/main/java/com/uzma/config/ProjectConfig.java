package com.uzma.config;

import com.uzma.implementation.BoseSpeaker;
import com.uzma.implementation.BridgeStoneTyre;
import com.uzma.interfaces.Speaker;
import com.uzma.interfaces.Tyre;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring @Configuration annotation is a part of spring core framework.
 * Spring Configuration annotation indicates that the class has @Bean definition
 * methods. So Spring container can process the class and generate spring beans to
 * be used in the application.
 * -
 * To Tell Spring it needs to search for classes annotated
 * with stereotype annotation, we use the @ComponentScan annotation over
 * the configuration class
 */

@Configuration
@ComponentScan(basePackages = {"com.uzma.beans",
                             "com.uzma.implementation",
                             "com.uzma.services"})

public class ProjectConfig {
    @Primary
   @Bean
    Speaker boseSpeaker()
   {
       return new BoseSpeaker();
   }

   @Bean
    Tyre bridgeStoneTyre(){
       return new BridgeStoneTyre();

   }
}
