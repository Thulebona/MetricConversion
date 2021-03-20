package com.ayo4u.metricsystem.model.area;


import com.ayo4u.metricsystem.model.InputUnitBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class AreaInput extends InputUnitBase<AreaUnit> implements Serializable {

}
