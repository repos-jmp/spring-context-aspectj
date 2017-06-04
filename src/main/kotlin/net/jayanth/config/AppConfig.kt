package net.jayanth.config

import net.jayanth.entities.BaseballGame
import net.jayanth.entities.Game
import net.jayanth.entities.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.jdbc.datasource.DriverManagerDataSource

/**
 * Created by jmp on 6/2/2017.
 */

@Configuration
@ComponentScan(basePackages = arrayOf("net.jayanth"))
@EnableAspectJAutoProxy
open class AppConfig(@Autowired var dataSource: DriverManagerDataSource,
                     @Autowired @Qualifier("redSox") var home : Team,
                     @Autowired @Qualifier("cubs") var away : Team) {

    @Bean /*(initMethod = "startGame", destroyMethod = "endGame")*/
   /* @Scope("prototype")*/
    open fun game(): Game {
        return BaseballGame(home, away, dataSource)
    }
}