package com.ayo4u.metricsystem;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.ayo4u.metricsystem")
@ExcludePackages({"com.ayo4u.metricsystem.fatories", "com.ayo4u.metricsystem.utils"})
public class MetricConversionTestSuite {
}
