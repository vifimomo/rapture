/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Sensors;

/**
 *
 * @author victor
 */
public class CPUCollector {
    
    private final CentralProcessor processor;
    private final Sensors sensors;
    private long[] previousTicks;
    
    public CPUCollector(){
    
        SystemInfo si = new SystemInfo();
        
        this.processor = si.getHardware().getProcessor();
        this.sensors = si.getHardware().getSensors();
        this.previousTicks = processor.getSystemCpuLoadTicks();
    }
    public CPU capture(){
    
        // System load between ticks
        long[] currentTicks = processor.getSystemCpuLoadTicks();
        
        double systemLoad = processor.getSystemCpuLoadBetweenTicks(previousTicks);
        
        this.previousTicks = currentTicks;
        
        // Charge per core
        double[] perCore = processor.getProcessorCpuLoadBetweenTicks(processor.getProcessorCpuLoadTicks());
        
        // System load average
        double loadAvg = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
        
        // System CPU time
        long systemCpuTime  = 0L;
        
        OperatingSystemMXBean mxbean = ManagementFactory.getOperatingSystemMXBean();
        
        if(mxbean instanceof com.sun.management.OperatingSystemMXBean){
        
            systemCpuTime = ((com.sun.management.OperatingSystemMXBean) mxbean).getProcessCpuTime();
        }    
        // Static processor information
        String name = processor.getProcessorIdentifier().getName();
        int physicalCoreCount = processor.getPhysicalProcessorCount();
        int logicalCoreCount = processor.getLogicalProcessorCount();
        long maxFrequencyHz = processor.getMaxFreq();
        
        // Sensors Normalize NaN/0 to -1 (not available)
        double temp = sensors.getCpuTemperature();
        
        if(Double.isNaN(temp) || temp <= 0) temp = -1.0; 
        
        double volt = sensors.getCpuVoltage();
        
        if(Double.isNaN(volt) || volt <= 0) volt = -1.0;
        
        return new CPU(systemLoad, perCore, loadAvg, systemCpuTime, name, physicalCoreCount, logicalCoreCount, maxFrequencyHz, temp, volt);
    }
}
