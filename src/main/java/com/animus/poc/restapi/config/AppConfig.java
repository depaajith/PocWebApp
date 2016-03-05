package com.animus.poc.restapi.config;

import javax.servlet.ServletContext;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.EnableCaching;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.ServletContextAware;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

 

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;

import com.mangofactory.swagger.models.dto.ApiInfo;

import com.mangofactory.swagger.paths.RelativeSwaggerPathProvider;

import com.mangofactory.swagger.plugin.EnableSwagger;

import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

 
  

@Configuration

@EnableWebMvc

@EnableSwagger

@ComponentScan("com.animus.poc")

//@EnableCaching

public class AppConfig  implements ServletContextAware{ 

 

             private SpringSwaggerConfig springSwaggerConfig;

            

             private ServletContext servletContext;

 

             @Autowired

             public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {

                this.springSwaggerConfig = springSwaggerConfig;

             }

 

            

              @Bean

              public SwaggerSpringMvcPlugin customImplementation() {

                  RelativeSwaggerPathProvider relativeSwaggerPathProvider = new RelativeSwaggerPathProvider(servletContext);

                  return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)

                          .apiInfo(apiInfo())

                          .pathProvider(relativeSwaggerPathProvider);

              }


    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfo(

                "Poc API's",

                "",

                "",

                "",

                "",

                ""
          );

        return apiInfo;

      }

   

    @Override

    public void setServletContext(ServletContext servletContext) {

        this.servletContext = servletContext;

    }

         

} 

