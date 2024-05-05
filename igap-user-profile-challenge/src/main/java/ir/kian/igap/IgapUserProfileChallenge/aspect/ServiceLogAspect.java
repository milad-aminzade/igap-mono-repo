package ir.kian.igap.IgapUserProfileChallenge.aspect;

import ir.kian.igap.common.domain.dto.response.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ServiceLogAspect {
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void withinServiceAnnotation() {
    }

    @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void annotationScheduleOnMethod() {
    }

    @Pointcut("execution(public * *(..))")
    public void executionPublicMethod() {
    }

    @Before("withinServiceAnnotation() && executionPublicMethod() && !annotationScheduleOnMethod()")
    public void beforeAllController(JoinPoint joinPoint) {
        log.info("""
                before class: {}
                       method: {}
                       inputs: {}
                """,joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    @AfterReturning(value = "withinServiceAnnotation() && executionPublicMethod() && !annotationScheduleOnMethod()", returning = "responseDto")
    public void AfterServicesMethod(JoinPoint joinPoint, ResponseDto responseDto) {
        log.info("""
                after class : {}
                      method : {}
                      inputs : {}
                      response : {}
                """, joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs(),
                responseDto);
    }
}
