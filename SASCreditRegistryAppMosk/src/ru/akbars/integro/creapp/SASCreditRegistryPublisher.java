package ru.akbars.integro.creapp;

import javax.xml.ws.Endpoint;

public class SASCreditRegistryPublisher {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:8886/SASCreditRegistryPortImplService/services",
				new SASCreditRegistryPortImpl());
		
		System.out.println("Server is published!");
		
	}
}