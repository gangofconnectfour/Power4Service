package com.gangofconnectfour.powerfourservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseMessageBuilder
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {

    val API_VERSION = "V1"

    @Bean
    fun api () : Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gangofconnectfour.powerfourservice.facade"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                    Arrays.asList(
                            // gestion 500
                        ResponseMessageBuilder()
                            .code(500)
                            .message("500 message")
                            .responseModel(ModelRef("Error"))
                            .build(),
                            // gestion 403
                        ResponseMessageBuilder()
                            .code(403)
                            .message("Forbidden!")
                            .build()
                    )
                );
    }


    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Power4 API DOCS")
                .description("Api de gestion de jeu de puissance 4 !!!")
                .version(API_VERSION)
                .build();
    }
}