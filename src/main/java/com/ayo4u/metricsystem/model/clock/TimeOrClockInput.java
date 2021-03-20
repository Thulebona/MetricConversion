package com.ayo4u.metricsystem.model.clock;

import com.ayo4u.metricsystem.model.InputUnitBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TimeOrClockInput extends InputUnitBase<TimeOrClockUnit> implements Serializable {
}
