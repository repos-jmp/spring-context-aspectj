package net.jayanth.entities

import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

/**
 * Created by jmp on 6/2/2017.
 */

class BaseballGame (override  var homeTeam : Team,
                    override var awayTeam: Team,
                    var datasource : DriverManagerDataSource) : Game {

    override fun playGame(): String {
        return if (Math.random() < 0.5) homeTeam.getName() else awayTeam.getName()
    }

    override fun toString(): String {
        return "Game between ${homeTeam.getName()} and ${awayTeam.getName()}"
    }

    @PostConstruct
    fun startGame(){
        println("Playing National Anthem")
    }

    @PreDestroy
    fun endGame(){
        println("Sending highlights to the network")
    }
}