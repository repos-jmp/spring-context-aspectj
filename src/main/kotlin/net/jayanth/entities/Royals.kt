package net.jayanth.entities

import org.springframework.stereotype.Component

/**
 * Created by jmp on 6/2/2017.
 */
@Component
class Royals : Team{
    override fun getName(): String {
        return "Kansas City Royals"
    }
}