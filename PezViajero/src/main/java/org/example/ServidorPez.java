package org.example;
import java.net.*;
import java.io.*;

public class ServidorPez extends Thread {

    PezAnimacion panel;

    public ServidorPez(PezAnimacion panel) {
        this.panel = panel;
    }

    public void run() {

        try {

            ServerSocket servidor = new ServerSocket(5000);

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