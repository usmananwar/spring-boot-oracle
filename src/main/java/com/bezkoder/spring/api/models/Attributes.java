package com.bezkoder.spring.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Attributes {
	@JsonProperty("SHAPE.LEN")
	Double shapeLen;

	@JsonProperty("SHAPE_Length")
	Double shapeLength;

	@JsonProperty("Shape_Length")
	Double shapeLength2;
}
