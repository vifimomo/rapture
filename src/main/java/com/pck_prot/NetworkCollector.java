/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

/**
 *
 * @author victor
 */
public class NetworkCollector {
    
    private final SystemInfo system_info;
    
    private final Map<String, long[]> previousCounters = new HashMap<>();
    
    private long previousTimestamp = 1L;
    
    public NetworkCollector(){
    
        this.system_info = new SystemInfo();
    }
    public Network capture(){
    
        List<NetworkIF> nifs = system_info.getHardware().getNetworkIFs();
        
        long now  = System.currentTimeMillis();
        
        List<NetworkInterfaceInfo> result = new ArrayList<>(nifs.size());
        
        for(NetworkIF nif : nifs){
        
            nif.updateAttributes();
            
            String name = nif.getName();
            
            long[] prev = previousCounters.get(name);
            
            double bytesSentRate = -1, bytesRecvRate = -1;
            double packetsSentRate = -1, packetsRecvRate = -1;
            
            if (prev != null && previousTimestamp > 0 && now > previousTimestamp) {
                double seconds = (now - previousTimestamp) / 1000.0;
                if (seconds > 0) {
                    bytesSentRate   = (nif.getBytesSent()   - prev[0]) / seconds;
                    bytesRecvRate   = (nif.getBytesRecv()   - prev[1]) / seconds;
                    packetsSentRate = (nif.getPacketsSent() - prev[2]) / seconds;
                    packetsRecvRate = (nif.getPacketsRecv() - prev[3]) / seconds;
                }
            }
            // Save current counters
            previousCounters.put(name, new long[]{
                    nif.getBytesSent(),
                    nif.getBytesRecv(),
                    nif.getPacketsSent(),
                    nif.getPacketsRecv()
            });

            // Normalize speed
            long speed = nif.getSpeed();
            if (speed <= 0) speed = -1;
            
            boolean if_status = false;
            
            switch (nif.getIfOperStatus()) {
                case NetworkIF.IfOperStatus.UP: if_status = true ;break;
                case NetworkIF.IfOperStatus.DOWN: if_status = false ;break;
            }
            result.add(new NetworkInterfaceInfo(
                    name,
                    nif.getDisplayName(),
                    nif.getMacaddr(),
                    if_status,
                    speed,
                    nif.getMTU(),
                    nif.getBytesSent(),
                    nif.getBytesRecv(),
                    nif.getPacketsSent(),
                    nif.getPacketsRecv(),
                    nif.getInErrors(),
                    nif.getOutErrors(),
                    nif.getInDrops(),
                    bytesSentRate,
                    bytesRecvRate,
                    packetsSentRate,
                    packetsRecvRate
            ));   
        }
        this.previousTimestamp = now;
        return new Network(result, now);
    }
}
