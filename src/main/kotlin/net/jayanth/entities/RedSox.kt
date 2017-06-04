package net.jayanth.entities

import org.springframework.stereotype.Component

/**
 * Created by jmp on 6/2/2017.
 */

@Component
 class RedSox : Team {

    override fun getName(): String {
        return "Boston Red Sox"
    }
}