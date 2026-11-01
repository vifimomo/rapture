/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author victor
 */
public class Network implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private final List<NetworkInterfaceInfo> interfaces;
    private final long timestamp; 

    public Network(List<NetworkInterfaceInfo> interfaces, long timestamp) {
        this.interfaces = Collections.unmodifiableList(interfaces);
        this.timestamp  = timestamp;
    }

    public List<NetworkInterfaceInfo> getInterfaces() { return interfaces; }
    public long getTimestamp()                        { return timestamp; }
}
