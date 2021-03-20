package com.ayo4u.metricsystem.model.length;

import com.ayo4u.metricsystem.model.InputUnitBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class LengthInput extends InputUnitBase<LengthUnit> implements Serializable {
}
