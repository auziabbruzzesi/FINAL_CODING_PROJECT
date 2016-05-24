package rocketBase;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;


public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		ArrayList<RateDomainModel> rdm = _RateDAL.getAllRates();
		for(RateDomainModel r: rdm){ 
			if(GivenCreditScore < r.getiMinCreditScore()){
				continue;
			}
			else{
				return r.getdInterestRate();
			}
			
		} 
		
		throw new RateException(new RateDomainModel());
		
	}
		//TODONE - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		
		//TODONE - RocketBLL RateBLL.getRate
		//			obviously this should be changed to return the determined rate

		
	
	public static boolean enoughMula(double income, double expenses, double payment){
		boolean enoughMula = false;
		if((income*.28>payment) || ((income-expenses)*.36>payment)){
			enoughMula = true;
			return enoughMula;
			}else{
				return enoughMula;
			}
		
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	//TODONE - RocketBLL RateBLL.getPayment 
	//		how to use: 
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double rate, double num_periods, double present_value, double future_value, boolean type)
	{		
		return FinanceLib.pmt((rate/12/100), (num_periods*12), present_value, future_value, type);
	}
}
 