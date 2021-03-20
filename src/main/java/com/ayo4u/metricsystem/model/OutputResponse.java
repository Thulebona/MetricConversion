package com.ayo4u.metricsystem.model;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder(toBuilder = true)
public class OutputResponse implements Serializable {
    private String result;
}
