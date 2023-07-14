package com.bezkoder.spring.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Field {
	public String name;
	public String type;
	public String alias;
}
