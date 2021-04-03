package com.cobi.chatbot.config

import com.fasterxml.classmate.TypeResolver
import io.swagger.annotations.ApiModelProperty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Configuration
class SwaggerConfiguration {

    @Autowired
    private lateinit var typeResolver: TypeResolver

    @Bean
    fun internal(): Docket = Docket(DocumentationType.SWAGGER_2)
            .directModelSubstitute(LocalDate::class.java, String::class.java)
            .directModelSubstitute(LocalDateTime::class.java, String::class.java)
            .directModelSubstitute(LocalTime::class.java, String::class.java)
            .groupName("chatbot")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.cobi.chatbot"))
            .build()
            .additionalModels(typeResolver.resolve((GlobalErrorFormat::class.java)))
}

data class GlobalErrorFormat(
        val timestamp: String,

        @ApiModelProperty(value = "Http Status Code")
        val status: Int,
        @ApiModelProperty(value = "Error Cdoe")
        val code: String,
        @ApiModelProperty(value = "사용자 화면 노출용 설명")
        val description: String,
        @ApiModelProperty(value = "Exception Message")
        val message: String
)

