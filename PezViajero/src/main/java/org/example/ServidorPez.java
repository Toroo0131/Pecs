package org.example;

import java.net.*;
import java.io.*;

public class ServidorPez extends Thread {

    PezAnimacion panel;
    int puerto;

    public ServidorPez(PezAnimacion panel, int puerto) {
        this.panel = panel;
        this.puerto = puerto;
    }

    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(puerto);

            while(true){

                Socket socket = servidor.accept();

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                String mensaje = entrada.readLine();

                if(mensaje.equals("PEZ")){
                    panel.aparecerPez();
                }

                socket.close();
            }

        } catch(Exception e){
            System.out.println(e);
        }
    }
}