package com.ayo4u.metricsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class InputUnitBase<T> implements Serializable {
    private T fromUnit;
    private T toUnit;
    private double value;

}
