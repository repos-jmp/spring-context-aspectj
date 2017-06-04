package net.jayanth.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource


/**
 * Created by jmp on 6/3/2017.
 */
@Configuration
open class InfrastructureConfig {

    @Bean
    open fun  datasource(): DriverManagerDataSource {
        return DriverManagerDataSource()
    }
}