package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.exception.InputErrorException;
import com.example.model.Clock;

@Service
public class ClockServiceImpl implements ClockService{
	
	private static Map<String, String> clockMap = new HashMap<String, String>();
	
	static {
		clockMap.put("0", "");
		clockMap.put("1", "one");
		clockMap.put("2", "two");
		clockMap.put("3", "three");
		clockMap.put("4", "four");
		clockMap.put("5", "five");
		clockMap.put("6", "six");
		clockMap.put("7", "seven");
		clockMap.put("8", "eight");
		clockMap.put("9", "nine");
		clockMap.put("10", "ten");
		clockMap.put("11", "eleven");
		clockMap.put("12", "twelve");
		clockMap.put("13", "thirteen");
		clockMap.put("14", "fourteen");
		clockMap.put("15", "fifteen");
		clockMap.put("16", "sixteen");
		clockMap.put("17", "seventeen");
		clockMap.put("18", "eighteen");
		clockMap.put("19", "nineteen");
		clockMap.put("20", "twenty");
		clockMap.put("21", "twenty one");
		clockMap.put("22", "twenty two");
		clockMap.put("23", "twenty three");
		clockMap.put("24", "twenty four");
		clockMap.put("25", "twenty five");
		clockMap.put("26", "twenty six");
		clockMap.put("27", "twenty seven");
		clockMap.put("28", "twenty nine");
		clockMap.put("29", "twenty nine");
		clockMap.put("30", "thirty");
		clockMap.put("31", "thirty one");
		clockMap.put("32", "thirty two");
		clockMap.put("33", "thirty three");
		clockMap.put("34", "thirty four");
		clockMap.put("35", "thirty five");
		clockMap.put("36", "thirty six");
		clockMap.put("37", "thirty seven");
		clockMap.put("38", "thirty eight");
		clockMap.put("39", "thirty nine");
		clockMap.put("40", "forty");
		clockMap.put("41", "forty one");
		clockMap.put("42", "forty two");
		clockMap.put("43", "forty three");
		clockMap.put("44", "forty four");
		clockMap.put("45", "forty five");
		clockMap.put("46", "forty six");
		clockMap.put("47", "forty seven");
		clockMap.put("48", "forty eight");
		clockMap.put("49", "forty nine");
		clockMap.put("50", "fifty");
		clockMap.put("51", "fifty one");
		clockMap.put("52", "fifty two");
		clockMap.put("53", "fifty three");
		clockMap.put("54", "fifty four");
		clockMap.put("55", "fifty five");
		clockMap.put("56", "fifty six");
		clockMap.put("57", "fifty seven");
		clockMap.put("58", "fifty eight");
		clockMap.put("59", "fifty nine");
		clockMap.put("60", "sixty");
	}

	@Override
	public String convert(Clock clock) {
		
		String text = clock.getText();
		String st[]=null;
		if(!text.isEmpty()) {
			if(text.contains(":")) {
				 st= text.split(":");
			}
			else {
				throw new InputErrorException("Incorrect input format");
			}
			
			StringBuilder sb = new StringBuilder();
			
			String hour = st[0];
			String min = st[1];
			
			if(Integer.parseInt(hour)>12 && Integer.parseInt(hour)<=24) {
				int h = Integer.parseInt(hour);
				h=h-12;
				hour = h+"";
			}
			if(Integer.parseInt(hour)>24) {
				throw new InputErrorException("Incorrect input format");
			}
			
			if(hour.startsWith("0")) {
				hour = Integer.parseInt(hour)+"";
			}
			if(min.startsWith("0")) {
				min = Integer.parseInt(min)+"";
			}
			
			hour = clockMap.get(hour);
			min = clockMap.get(min);
			
			if(hour==null || min==null) {
				throw new InputErrorException("Incorrect input");
			}
			
			sb.append("It's ");
			if(hour.equals("twelve") && st[0].equals("12") && st[1].equals("00")) {
				sb.append("Midday");
				return sb.toString();
			}
			else if(hour.equals("twelve") && st[0].equals("24") && st[1].equals("00")) {
				sb.append("Midnight");
				return sb.toString();
			}
			
			sb.append(hour+" ");
			sb.append(min);
			
			return sb.toString();
		}
		else {
			throw new InputErrorException("Blank input");
		}
		
	}

}
