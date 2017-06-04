package net.jayanth.entites

import net.jayanth.config.AppConfig
import net.jayanth.entities.Game
import net.jayanth.entities.Team
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by jmp on 6/3/2017.
 */

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(AppConfig::class))
class BaseBallGameTest(@Autowired var game : Game,
                       @Autowired var ctx : ApplicationContext) {

    //Kotlin no-arg plugin needs to be configured correctly for this to work.

    /*lateinit  var game : Game
    lateinit  var ctx : ApplicationContext

    @Before
    fun setUp() {
       ctx  = AnnotationConfigApplicationContext(AppConfig::class.java)
       game = ctx.getBean("game", Game::class.java)
    }*/

    @Test
    fun testPlayGame() {
        var home = game.homeTeam.getName()
        var away = game.awayTeam.getName()
        var result = game.playGame()
        assertTrue { result.contains(home) || result.contains(away) }
    }

    @Test
    fun testSetAndGetHomeTeam(){
        var royals = ctx.getBean("royals", Team::class.java)
        game.homeTeam = royals
        assertEquals(royals.getName(), game.homeTeam.getName())
    }
}