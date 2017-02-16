package aop;

/**
 * Created by maximus on 16-8-30.
 */
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class HelloWorldAspect {
    @Before(value="execution(* aop.HelloWorld.*(..))")
    public void beforeSayHello(JoinPoint joinPoint){

        System.out.println("Before :"+joinPoint.getArgs()[0]);
    }

    @After(value="execution(public void aop.HelloWorld.sayHello(..)) && args(message)")
    public void afterSayHello(String message){
        System.out.println("After : "+message);
    }

    @Around(value="execution(public void aop.HelloWorld.sayHello(..))")
    public void aroundSayHello(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Before !! ");
        joinPoint.proceed();
        System.out.println("Around After !! ");
    }

    @AfterThrowing(value="execution(public void aop.HelloWorld.sayHello(..))",throwing="ex")
    public void afterThrowingSayHello(Exception ex){
        System.out.println("After Throwing : "+ex.getMessage());
    }

    @AfterReturning(value="execution(public void aop.HelloWorld.sayHello(..))",returning="reval")
    public void afterReturningSayHello(String reval){
        System.out.println("After Returning : "+reval);
    }
}