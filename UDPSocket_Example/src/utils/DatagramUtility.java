package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramUtility { 
    /*Metodo per creare un pacchetto da una stringa: */
    static public DatagramPacket buildPacket(InetAddress addr, int port, String msg) throws IOException{ 
        ByteArrayOutputStream boStream = new ByteArrayOutputStream(); 
        DataOutputStream doStream = new DataOutputStream(boStream); 
        doStream.writeUTF(msg); 
        byte[] data = boStream.toByteArray(); 
        return new DatagramPacket(data, data.length, addr, port);
    } 

    /*Metodo per recuperare una stringa da un pacchetto: */
    static public String getContent(DatagramPacket dp) throws IOException{ 
        ByteArrayInputStream biStream = new ByteArrayInputStream(dp.getData(), 0, dp.getLength()); 
        DataInputStream diStream = new DataInputStream(biStream); 
        String msg = diStream.readUTF(); 
        return msg; 
    } 
} 
