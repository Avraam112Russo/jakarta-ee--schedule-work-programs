package com.example.ejbasynchronusex;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.interceptor.AroundTimeout;
import jakarta.interceptor.InvocationContext;

@Singleton
public class ProgramWorkSchedule {
//
//    @Schedule(hour = "22", minute = "8", second = "0")
//    public void example(){
//        System.out.println("Hello");
//    }
    @Resource
    private SessionContext sessionContext;
    public void example(){
        TimerService timerService = sessionContext.getTimerService();
        ScheduleExpression scheduleExpression = new ScheduleExpression().hour("*").minute("*").second("*");
//        ScheduleExpression scheduleExpression = new ScheduleExpression().hour("22").minute("25").second("45");
        timerService.createCalendarTimer(scheduleExpression, new TimerConfig("String from timer config", false));
        //timer service automatic search methods which mark as @Timeout and running him
    }
    @Timeout
    public void workToTimer(Timer timer){
        System.out.println("Time to work");
        System.out.println(timer.getInfo());
    }
    @AroundTimeout
    Object aroundTimeOutMethod(InvocationContext invocationContext) throws Exception {
        System.out.println("Around timeout method work...");
        return invocationContext.proceed();
    }
}
