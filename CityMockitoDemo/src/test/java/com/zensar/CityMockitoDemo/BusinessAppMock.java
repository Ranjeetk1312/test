package com.zensar.CityMockitoDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BusinessAppMock {
	
	@Test
	public void testVMockVsSpy() {
		List<String> mockList=mock(List.class);
		mockList.add("ABC");mockList.add("XYZ");
		System.out.println("MOCK :"+mockList.get(1));
		
		List<String> list=new ArrayList<>();
		List<String> spyList=spy(list);
		spyList.add("ABC");
		spyList.add("XYZ");
		System.out.println("SPY :"+spyList.get(1));
		
		
	}

	@Test
	public void testBusinessApp() {
		CityService cityService= mock(CityService.class);
		
		when(cityService.findCitiesByCountries("INDIA")).
		thenReturn(Arrays.asList("Pune","Mumbai","Delhi"));
		when(cityService.findCitiesByCountries("USA")).
		thenReturn(Arrays.asList("NEW York","Wasington"));
		when(cityService.findCitiesByCountries(anyString())).
		thenReturn(Arrays.asList("city1","city2","city3"));
		
		BusinessApp businessApp=new BusinessApp(cityService);
		assertEquals(businessApp.retrieveCityListByCountry("INDIA").size(),3);
	}

}
