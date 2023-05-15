package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.example.model.Clock;
import com.example.service.ClockServiceImpl;

@ContextConfiguration
class DemoApplicationTests {
	
	@Autowired
	private ClockServiceImpl clockServiceImpl;

	@Test
	public void testConvert() {
		
		clockServiceImpl = Mockito.mock(ClockServiceImpl.class);
		String time = "16:34";
		Clock clock = new Clock();
		clock.setText(time);
		
		Mockito.when(clockServiceImpl.convert(clock)).thenCallRealMethod();
		
		String result = clockServiceImpl.convert(clock);
		String actual = "It's four thirty four";
		
		assertEquals(actual, result);
	}
}
