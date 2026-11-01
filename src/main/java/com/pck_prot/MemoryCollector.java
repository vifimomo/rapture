/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 *
 * @author victor
 */
public class MemoryCollector {
    
    public Memory capture(){
    
        OperatingSystemMXBean mxbean = ManagementFactory.getOperatingSystemMXBean();
        
        long totalMem, freeMem, totalSwap, freeSwap;
        
        if(mxbean instanceof com.sun.management.OperatingSystemMXBean){
        
            com.sun.management.OperatingSystemMXBean sun = (com.sun.management.OperatingSystemMXBean) mxbean;
         
            totalMem = sun.getTotalMemorySize();
            freeMem = sun.getFreeMemorySize();
            totalSwap = sun.getTotalSwapSpaceSize();
            freeSwap = sun.getFreeSwapSpaceSize();
        }  
        else{
            totalMem = Runtime.getRuntime().totalMemory();
            freeMem = Runtime.getRuntime().freeMemory();
            totalSwap = 0L;
            freeSwap = 0L;
        }
        return new Memory(totalMem, freeMem, totalSwap, freeSwap);
    }
}
