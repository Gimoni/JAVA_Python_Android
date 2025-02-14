package com.example.imple.standard.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.standard.util.Continent;
import com.example.standard.util.Gender;

public class ContinentTest {

	@Test
	void enumToString() {
		for (var c : Continent.values())
			System.out.println(c);
		System.out.println("======================");
		System.out.println(Continent.Asia.getSymbol());
		System.out.println(Continent.Europe.getSymbol());
		System.out.println(Continent.NorthAmerica.getSymbol());
		System.out.println(Continent.Africa.getSymbol());
		System.out.println(Continent.Oceania.getSymbol());
		System.out.println(Continent.Antarctica.getSymbol());
		System.out.println(Continent.SouthAmerica.getSymbol());
	}
	
	@Test
	void stringToEnum() {
		Continent c1 = Continent.valueOf("Asia");
		Continent c2 = Continent.valueOf("Europe");
		Continent c3 = Continent.valueOf("NorthAmerica");
		Continent c4 = Continent.valueOf("Africa");
		Continent c5 = Continent.valueOf("Oceania");
		Continent c6 = Continent.valueOf("Antarctica");
		Continent c7 = Continent.valueOf("SouthAmerica");
		
		assertThrows(IllegalArgumentException.class, () -> {
			Continent.valueOf("North America");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Continent.valueOf("South America");
		});
		
		Continent.valueOf("North America".replace(" ", ""));
		Continent.valueOf("South America".replace(" ", ""));
	}
}
