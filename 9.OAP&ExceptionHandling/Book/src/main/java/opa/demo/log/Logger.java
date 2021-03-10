package opa.demo.log;

import opa.demo.controllers.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Aspect
public class Logger {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @AfterReturning("execution(* opa.demo.controllers.BookController.rentBook(*,*))")
    public void afterRenting(JoinPoint joinPoint) {
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("rent" + args);
    }

    @AfterReturning("execution(* opa.demo.controllers.BookController.returnBook(*,*))")
    public void afterReturning(JoinPoint joinPoint){
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("return" + args);
    }

}

