package notebook.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Loging {

    @Before("execution(* notebook.service.authentication.AuthenticationManagerInterface.authenticate(..))")
    public void logBeforeLogin(){
        System.out.println("AOP: try to enter");
    }
}
