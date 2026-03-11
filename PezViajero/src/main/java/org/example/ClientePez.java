package org.example;

import java.net.Socket;
import java.io.PrintWriter;

public class ClientePez {

    public static void enviar(String ip, int puerto){

        try{

            Socket socket = new Socket(ip, puerto);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);

            salida.println("PEZ");

            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}