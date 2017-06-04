package net.jayanth.aspects

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component
import java.util.logging.Logger

/**
 * Created by jmp on 6/3/2017.
 */

@Aspect
@Component
class LoggingAspect {

    var logger: Logger = Logger.getLogger(javaClass.name)

    @Before("execution(void net.jayanth..*.set*(*))")
    fun callSetters(joinpoint: JoinPoint) {
        var methodName = joinpoint.signature.name.toString()
        var arguments = joinpoint.args[0].toString()
        logger.info("Called $methodName with arguments: $arguments on" + joinpoint.target.toString())
    }

    @Around("execution(String playGame())")
    fun checkForRain(pjp: ProceedingJoinPoint): Any? {
        var rain: Boolean = Math.random() < 0.5
        var result: Any? = null
        if (rain) {
            logger.info(pjp.target.toString() + " rained out")
        } else {
            result = pjp.proceed()
            logger.info(result.toString())
        }
        return result
    }
}