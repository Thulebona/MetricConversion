package com.ayo4u.metricsystem.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class ErrorMessage {
    private String message;
}