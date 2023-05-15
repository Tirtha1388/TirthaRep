package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Clock;
import com.example.model.ClockDTO;
import com.example.service.ClockService;

@RestController
public class ClockController {
	
	@Autowired
	ClockService clockService;
	
	@RequestMapping(value="/")
	public ResponseEntity<?> convertTime() {
		
		String pattern = "HH:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		Clock clock = new Clock();
		clock.setText(date);
		return new ResponseEntity<String>(clockService.convert(clock),HttpStatusCode.valueOf(400));
	}
	
	@RequestMapping(value="/convert", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<?> convertUserTime(@RequestBody ClockDTO clockDTO){
		
		Clock clock = new Clock();
		clock.setText(clockDTO.getText());
		
		return new ResponseEntity<String>(clockService.convert(clock),HttpStatusCode.valueOf(400));
		
	}

}
