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
public class Memory implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private final long totalMemorySize;
    private final long freeMemorySize;
    private final long usedMemorySize;
    private final long totalSwapSpaceSize;
    private final long freeSwapSpaceSize;
    private final long usedSwapSpaceSize;

    public Memory(long totalMemorySize,
                  long freeMemorySize,
                  long totalSwapSpaceSize,
                  long freeSwapSpaceSize) {
        
        this.totalMemorySize = totalMemorySize;
        this.freeMemorySize = freeMemorySize;
        this.usedMemorySize = totalMemorySize - freeMemorySize;
        this.totalSwapSpaceSize = totalSwapSpaceSize;
        this.freeSwapSpaceSize = freeSwapSpaceSize;
        this.usedSwapSpaceSize = totalSwapSpaceSize - freeSwapSpaceSize;
    }

    public long getTotalMemorySize()      { return totalMemorySize; }
    public long getFreeMemorySize()       { return freeMemorySize; }
    public long getUsedMemorySize()       { return usedMemorySize; }
    public long getTotalSwapSpaceSize()   { return totalSwapSpaceSize; }
    public long getFreeSwapSpaceSize()    { return freeSwapSpaceSize; }
    public long getUsedSwapSpaceSize()    { return usedSwapSpaceSize; }
}
