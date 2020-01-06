package com.iu.b1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CustomSchedule {

	//@Scheduled(fixedRate = 1000)
	//@Scheduled(fixedRateString = "1000")
	public void fixRateSchedule() throws Exception {
		System.out.println("fixRate : "+Thread.currentThread().getName());

		Thread.sleep(2000);
		
	}
	
	//@Scheduled(fixedDelay = 1000)
	//@Scheduled(fixedDelayString = "1000", initialDelay = 1000)
	public void fixedDelaySchedule()throws Exception{
		System.out.println("fixdelay : "+Thread.currentThread().getName());
		Thread.sleep(2000);
	}
	
	//@Scheduled(cron = "*/3 * * * * *")
	public void cronSchedule()throws Exception{
		System.out.println("쉬는시간 : " + Thread.currentThread().getName());
	}
	
	
}
