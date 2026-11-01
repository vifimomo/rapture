/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pck_prot;

/**
 *
 * @author victor
 */
public class NetworkInterfaceInfo {
    
    private static final long serialVersionUID = 1L;

    private final String name;           // eth0 - wlan0 - lo
    private final String displayName;    // Ethernet - Wi-Fi
    private final String macAddress;
    private final boolean up;
    private final long speedBitsPerSec;  // -1 (unknown)
    private final long mtu;

    // Cumulative counters
    private final long bytesSent;
    private final long bytesRecv;
    private final long packetsSent;
    private final long packetsRecv;
    private final long errorsIn;
    private final long errorsOut;
    private final long dropsIn;

    // Calculated rates (bytes/s, packet/s)
    private final double bytesSentRate;
    private final double bytesRecvRate;
    private final double packetsSentRate;
    private final double packetsRecvRate;

    public NetworkInterfaceInfo(String name,
                                String displayName,
                                String macAddress,
                                boolean up,
                                long speedBitsPerSec,
                                long mtu,
                                long bytesSent,
                                long bytesRecv,
                                long packetsSent,
                                long packetsRecv,
                                long errorsIn,
                                long errorsOut,
                                long dropsIn,
                                double bytesSentRate,
                                double bytesRecvRate,
                                double packetsSentRate,
                                double packetsRecvRate) {
        this.name            = name;
        this.displayName     = displayName;
        this.macAddress      = macAddress;
        this.up              = up;
        this.speedBitsPerSec = speedBitsPerSec;
        this.mtu             = mtu;
        this.bytesSent       = bytesSent;
        this.bytesRecv       = bytesRecv;
        this.packetsSent     = packetsSent;
        this.packetsRecv     = packetsRecv;
        this.errorsIn        = errorsIn;
        this.errorsOut       = errorsOut;
        this.dropsIn         = dropsIn;
        this.bytesSentRate   = bytesSentRate;
        this.bytesRecvRate   = bytesRecvRate;
        this.packetsSentRate = packetsSentRate;
        this.packetsRecvRate = packetsRecvRate;
    }

    public String getName()            { return name; }
    public String getDisplayName()     { return displayName; }
    public String getMacAddress()      { return macAddress; }
    public boolean isUp()              { return up; }
    public long getSpeedBitsPerSec()   { return speedBitsPerSec; }
    public long getMtu()               { return mtu; }
    public long getBytesSent()         { return bytesSent; }
    public long getBytesRecv()         { return bytesRecv; }
    public long getPacketsSent()       { return packetsSent; }
    public long getPacketsRecv()       { return packetsRecv; }
    public long getErrorsIn()          { return errorsIn; }
    public long getErrorsOut()         { return errorsOut; }
    public long getDropsIn()           { return dropsIn; }
    public double getBytesSentRate()   { return bytesSentRate; }
    public double getBytesRecvRate()   { return bytesRecvRate; }
    public double getPacketsSentRate() { return packetsSentRate; }
    public double getPacketsRecvRate() { return packetsRecvRate; }
}
