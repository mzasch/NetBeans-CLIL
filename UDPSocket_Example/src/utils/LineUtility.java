package utils;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LineUtility {

    /* Metodo per recuperare una certa linea di un certo file */
    static public String getLine(String nomeFile, int numLinea) {
        String linea;
        try {
            BufferedReader in = new BufferedReader(new FileReader(nomeFile));

            for (int i = 1; i < numLinea; i++) {
                in.readLine();
            }
            if ((linea = in.readLine()) == null) {
                linea = "Linea non trovata";
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
            linea = "File non trovato";
        } catch (IOException e) {
            Logger.getLogger(LineUtility.class.getName()).log(Level.SEVERE, null, e);
            linea = "Linea non trovata";
        }
        return linea;
    }
}
