package client;

import utils.DatagramUtility;
import java.io.*;
import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket; 
        try {
            socket = new DatagramSocket();
            socket.setSoTimeout(30000); 

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); 
            System.out.print("Numero linea: "); 
            String richiesta = Integer.parseInt(stdIn.readLine()) + "";
            
            InetAddress addr=InetAddress.getByName("localhost");
            
            DatagramPacket packetOUT = DatagramUtility.buildPacket(addr, 9090, richiesta); 
            socket.send(packetOUT);
            
            System.out.println("Inviata richiesta per la linea " + richiesta);
            
            byte[] buf = new byte[256]; 
            DatagramPacket packetIN = new DatagramPacket(buf, buf.length); 
            socket.receive(packetIN); 

            String risposta=null; 
            risposta = DatagramUtility.getContent(packetIN); 
            System.out.println("Risposta: " + risposta); 
            System.out.println("UDPClient: termino.."); 
            socket.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}