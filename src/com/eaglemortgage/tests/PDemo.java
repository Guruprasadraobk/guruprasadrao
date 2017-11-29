package com.eaglemortgage.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String path = "./config.properties";
		Properties p = new Properties ();
		p.load(new FileInputStream(path));
		System.out.println(p.getProperty("URL"));
	}
}
