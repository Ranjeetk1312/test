package com.zensar.CityMockitoDemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BusinessAppTest {

	@Test
	public void testBusinessApp() {
		CityService cityService= new CityServiceStub();
		BusinessApp businessApp=new BusinessApp(cityService);
		assertEquals(businessApp.retrieveCityListByCountry("INDIA").size(),3);
	}

}
