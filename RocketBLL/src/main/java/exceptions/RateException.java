package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	private RateDomainModel r = new RateDomainModel();
	
	public RateDomainModel getR() {
		return r;
	}
 
	public RateException(RateDomainModel r){
		this.r=r;
		this.printStackTrace();
		
	}
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
