package com.bezkoder.spring.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FieldAliases {
	@JsonProperty("SHAPE.LEN")
	String shapeLength;
}
