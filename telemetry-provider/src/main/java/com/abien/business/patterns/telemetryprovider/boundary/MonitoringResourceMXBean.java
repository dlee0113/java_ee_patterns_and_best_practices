package com.abien.business.patterns.telemetryprovider.boundary;

import com.abien.business.patterns.telemetryprovider.entity.Invocation;
import java.util.List;
import java.util.Map;

/**
 * adam-bien.com
 */
public interface MonitoringResourceMXBean {
    List<Invocation> getSlowestMethods();
    Map<String,String> getDiagnostics();
    Map<String,Integer> getExceptionStatistics();
    String getNumberOfExceptions();
    String getExceptions();
    void clear();
}
