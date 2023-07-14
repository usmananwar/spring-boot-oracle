package com.bezkoder.spring.api.models;

import java.util.ArrayList;

import com.bezkoder.spring.api.models.Feature;
import com.bezkoder.spring.api.models.Field;
import com.bezkoder.spring.api.models.FieldAliases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiFeaturesResult {
	String displayFieldName;
	FieldAliases fieldAliases;
	ArrayList<Field> fields;
	ArrayList<Feature> features;
}
