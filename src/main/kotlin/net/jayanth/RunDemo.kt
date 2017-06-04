package net.jayanth

import net.jayanth.config.AppConfig
import net.jayanth.entities.Game
import net.jayanth.entities.Team
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Created by jmp on 6/2/2017.
 */
class RunDemo {
    companion object{
        @JvmStatic
        fun main(args: Array<String>){

            var context : AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
            var game  = context.getBean("game", Game::class.java)
            var royals = context.getBean("royals", Team::class.java)
            var cubs = context.getBean("cubs", Team::class.java)
            var redSox = context.getBean("redSox", Team::class.java)

            game.homeTeam = redSox
            game.awayTeam = cubs
            println(game.playGame())

            game.homeTeam = cubs
            game.awayTeam = royals
            println(game.playGame())

           /* var replacementTeam = context.getBean("royals", Team::class)

            var game1 : Game = context.getBean("game", Game::class.java)
            println(game1)


            var game2 : Game = context.getBean("game", Game::class.java)

            if(replacementTeam is Team) {
                game2.awayTeam = replacementTeam
            }

            println(game2)
            println("Singleton : " + game1)

            context.beanDefinitionNames.forEach { println(it)}
            */
            context.close()
        }
    }
}