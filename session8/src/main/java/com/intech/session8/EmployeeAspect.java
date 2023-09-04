package com.intech.session8;


import com.intech.session8.domain.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Date;

@Aspect   //scan the aspect annotation to register
@Component  //create bean and add in spring container
public class EmployeeAspect {
    /**
     * create the pointer on any EmployeeServiceImpl class call
     */
    @Pointcut("within(com.intech.session8.service.EmployeeServiceImpl)")
    public void employeeServerPointCut() {

    }

    /**
     * before the above employeeServerPointCut() point cut call
     */
    @Before("employeeServerPointCut()")
    public void employeeServerPointCutBefore() {
        System.out.println("This is AOP before Aspect call");
    }

    /**
     * After successfully employeeServerPointCut() point cut call
     */
    @After("employeeServerPointCut()")
    public void employeeServerPointCutAfter() {
        System.out.println("This is AOP after Aspect call");
    }

    /**
     * similar point cut above using *
     */

    @Pointcut("within(com.intech.session8.service.EmployeeServiceImpl.*)")
    public void saveEmployeePointcut() {

    }

    /**
     * User expression create point cut on save() method call
     */
    @Pointcut("execution(* com.intech.session8.service.EmployeeServiceImpl.save(..))")
    public void saveMethodPointcut() {

    }

    /**
     * saveMethodPointcut() pointcut before
     */
    @Before("saveMethodPointcut()")
    public void saveMethodPointcutBefore() {
        System.out.println("saveMethodPointcut before");
    }

    /**
     * save() method Before Aspect
     * we can use JoinPoint interface to get more info. about pointcut
     *
     * @param joinPoint
     */
    @Before(value = "execution(* com.intech.session8.service.EmployeeServiceImpl.save(..))")
    public void BeforeSave(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature());
        ;
        System.out.println("before save method call");
    }

    /**
     * Hold the execution of actual business method to add something before or after
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around(value = "execution(* com.intech.session8.service.EmployeeServiceImpl.save(..))")
    public void roundSave(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(MessageFormat.format("Log time before save employee {0} ", new Date()));
        joinPoint.proceed();
        System.out.println(MessageFormat.format("Log time after save employee {0} ", new Date()));
    }

    /**
     * Get use the buiness method return values
     *
     * @param retVal
     */
    @AfterReturning(value = "execution(* com.intech.session8.service.EmployeeServiceImpl.save(..))", returning = "retVal")
    public void AfterRetruningSave(Object retVal) {
        Employee employee = (Employee) retVal;
        System.out.println("This is a after get retrun from save call");
        System.out.println(employee);
    }

    /**
     * if the business method returns the exception
     */
    @AfterThrowing(value = "execution(* com.intech.session8.service.EmployeeServiceImpl.save(..))")
    public void AfterThrowingSave() {
        System.out.println("got error");
    }

    /**
     * get the method parameter in the aspect
     *
     * @param employee
     */
    @Before(value = "execution(* com.intech.session8.service.EmployeeServiceImpl.save(..)) and args(employee)")
    public void Beforesave(Object employee) {
        Employee employee1 = (Employee) employee;


    }
    //execution(* * *)
}
