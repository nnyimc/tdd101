package fr.nnyimc.business;

import java.util.HashSet;
import java.util.Set;

public class Calculator {
	
	public int add(int firstInteger, int secondInteger) {
		return firstInteger+secondInteger;
	}

	public int multiply(int firstInteger, int secondInteger) {
		return firstInteger * secondInteger;
	}

	public Set<Integer> listDigits(int number) {
		
		String convertedNumber = ((Integer) number).toString();
		Set<Integer> listedDigits = new HashSet<>();
		for (int i = 0; i < convertedNumber.length(); i++) {
			listedDigits.add(Integer.parseInt("" + convertedNumber.charAt(i)));
		}
		return listedDigits;
	}

}
