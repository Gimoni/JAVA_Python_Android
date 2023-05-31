package com.example.imple.country.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor(staticName="of")
@NoArgsConstructor
@Builder
public class Country {
	@NonNull String 	code; 						
	@NonNull String 	name; 
	         String 	continent;					
			 String 	region;									
			 Double 	surfaceArea;			
			 Integer 	indepYear;								
			 Long		population;					
			 Double		lifeExpectancy;								
			 Double 	gnp;					
			 Double 	gnpOld;				
			 String 	localName;									
			 String 	governmentForm;		
			 String 	headOfState;		
			 Long 		capital;			
			 String 	code2;			
}
