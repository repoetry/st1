/**
 * 
 */
package info.rue.web.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rue
 *
 */
@Component
@Aspect
public class LoggerAspect {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    static String name = "";
    static String type = "";

    @Around("execution(* *..controller.*.*(..))")
    public Object logPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        type = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("=================>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        if(type.indexOf("Controller") > -1) {
            name = "Controller \t: ";
        } else if(type.indexOf("Service") > -1) {
            name = "Service \t : ";
        } else if(type.indexOf("DAO") > -1) {
            name = "DAO \t\t: ";
        }
        
        logger.debug("{}{}.{}", name, type, joinPoint.getSignature());
        Object obj = joinPoint.proceed();
        
        if(obj instanceof ModelAndView) {
            ModelAndView mv = (ModelAndView) obj;
            mv.addObject("aaa", "aaa입니다.");
            logger.debug("2222222222222222");
        } else {
            logger.debug("=======>>>> {}", obj.toString());
        }
        return obj;
    }

}
