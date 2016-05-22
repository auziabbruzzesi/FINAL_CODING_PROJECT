package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	
	public static rocketBase.RateDAL rate = new rocketBase.RateDAL();
	
	

	@Test 
	public void test() { 
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	} 

}
