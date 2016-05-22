package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {
	static ArrayList<Double> knowninterest = new ArrayList<Double>();
	@BeforeClass
	public static void setup(){
	RateDAL rdal = new RateDAL();
	RateDomainModel r = new RateDomainModel();
	 
	for (RateDomainModel rdm: rdal.getAllRates()){
		knowninterest.add(rdm.getdInterestRate());
	}
	}
	
	
	
	@Test
	public void testRateFinder() throws Exception {
		
		assertTrue(knowninterest.contains(RateBLL.getRate(730)));
	}
	@Test(expected=RateException.class)
	public void testException() throws RateException{
		RateBLL.getRate(4);
	} 
	@Test
	public void getPaymentTest(){
		System.out.print(RateBLL.getPayment(.04, 360, 300000, 0, false));
	}
		 
		 
		 
		   
		
	 

	//TODONE - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODONE - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		assert(1==1);
	}
 
}
