package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nt.config.AppConfig;
import com.nt.sbeans.VoterDetails;

//@ComponentScan("com\nt\sbeans")
public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		//create the IOC container
		
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get Springbean class obj ref
		
		VoterDetails details=ctx.getBean("voterDetails",VoterDetails.class);
		
		//invoke the b.method
		
		String resultMsg=details.checkVotingEligibility();
		System.out.println(resultMsg);
		
		//close the container
		
		ctx.close();
			}

}
