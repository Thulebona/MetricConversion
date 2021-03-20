package com.ayo4u.metricsystem.model.weight;

import com.ayo4u.metricsystem.model.InputUnitBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class WeightInput extends InputUnitBase<WeightUnit> implements Serializable {

}
