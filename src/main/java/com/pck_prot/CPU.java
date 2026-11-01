/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

import java.io.Serializable;

/**
 *
 * @author victor
 */
public class CPU implements Serializable{
    
    private static final long serialVersioUID = 1L;
    
    // System Information
    private final double systemCpuLoad;
    private final double[] perCoreLoad;
    private final double loadAverage;
    private final long systemCpuTime;
    
    // Static processor information
    private final String processorName;
    private final int physicalCoreCount;
    private final int logicalCoreCount;
    private final long maxFrequencyHz;
    
    // Sensors
    private final double cpuTemperatureCelsius;
    private final double cpuVoltage;
    
    public CPU(double systemCpuLoad,
               double[] perCoreLoad,
               double loadAverage,
               long systemCpuTime,
               String processorName,
               int physicalCoreCount,
               int logicalCoreCount,
               long maxFrequencyHz,
               double cpuTemperatureCelsius,
               double cpuVoltage) {
        
        this.systemCpuLoad         = systemCpuLoad;
        this.perCoreLoad           = perCoreLoad;
        this.loadAverage           = loadAverage;
        this.systemCpuTime         = systemCpuTime;
        this.processorName         = processorName;
        this.physicalCoreCount     = physicalCoreCount;
        this.logicalCoreCount      = logicalCoreCount;
        this.maxFrequencyHz        = maxFrequencyHz;
        this.cpuTemperatureCelsius = cpuTemperatureCelsius;
        this.cpuVoltage            = cpuVoltage;
    }
    public double getSystemCpuLoad()         { return systemCpuLoad; }
    public double[] getPerCoreLoad()         { return perCoreLoad; }
    public double getLoadAverage()           { return loadAverage; }
    public long getSystemCpuTime()           { return systemCpuTime; }
    public String getProcessorName()         { return processorName; }
    public int getPhysicalCoreCount()        { return physicalCoreCount; }
    public int getLogicalCoreCount()         { return logicalCoreCount; }
    public long getMaxFrequencyHz()          { return maxFrequencyHz; }
    public double getCpuTemperatureCelsius() { return cpuTemperatureCelsius; }
    public double getCpuVoltage()            { return cpuVoltage; }
}
