package server;

import utils.LineUtility;
import utils.DatagramUtility;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPServer {

    public static final int PORT = 9090;

    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(PORT);
            while (true) {
                System.out.println("In attesa di richieste...");
                int mittPort = 0;

                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                InetAddress mittAddr = packet.getAddress();
                mittPort = packet.getPort();
                
                int numLinea;
                String richiesta = DatagramUtility.getContent(packet);
                numLinea = Integer.parseInt(richiesta);
                
                System.out.println("Richiesta: " + mittAddr + ":" + mittPort + " - " + numLinea);

                String linea = LineUtility.getLine("D:\\prova.txt", numLinea);
                packet = DatagramUtility.buildPacket(mittAddr, mittPort, linea);
                socket.send(packet);
            }
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (IOException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
