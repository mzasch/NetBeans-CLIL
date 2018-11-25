package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineUtility { 
    /*Metodo per recuperare una certa linea di un certo file: */
    static public String getLine(String nomeFile, int numLinea) { 
        String linea;
        BufferedReader in; 
        try { 
            in = new BufferedReader(new FileReader(nomeFile)); 
        } catch (FileNotFoundException e) { 
            Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
            linea = "File non trovato";
            return linea; 
        } 
        
        try { 
            for (int i=1; i<numLinea; i++)  
                in.readLine(); 
            if ((linea = in.readLine()) == null)  
                linea = "Linea non trovata"; 
        } catch (IOException e) { 
          Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
          linea = "Linea non trovata";
          return linea; 
        } 
        return linea; 
    }
    
    static public String getNextLine(BufferedReader in) { 
        String linea; 
        try { 
            if ((linea = in.readLine()) == null) { 
                in.close(); 
                linea = "Nessuna linea disponibile"; 
            } 
        } catch (FileNotFoundException e) { 
            Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
            linea = "File non trovato";
            return linea; 
        } catch (IOException e) {
            Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
            linea = "Nessuna linea disponibile"; 
        } 
        return linea; 
    }  
}