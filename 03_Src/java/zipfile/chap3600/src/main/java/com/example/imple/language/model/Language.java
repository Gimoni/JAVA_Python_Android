package com.example.imple.language.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor(staticName ="of")
@NoArgsConstructor
@Builder
public class Language {
	@NonNull String countryCode;
	@NonNull String	language;
			 Character isOfficial;
			 Double	percentage;
//			 Country country;
}
