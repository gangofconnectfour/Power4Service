package com.gangofconnectfour.powerfourservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
@EnableWebMvc
class PowerfourserviceApplication : WebMvcConfigurer {

    override fun addResourceHandlers(registery :ResourceHandlerRegistry){
        registery.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
        registery.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
    }

    override fun addViewControllers(registry :ViewControllerRegistry) {
        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs")
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui")
        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security")
        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources")
    }

}

fun main(args: Array<String>) {
    runApplication<PowerfourserviceApplication>(*args)
}
