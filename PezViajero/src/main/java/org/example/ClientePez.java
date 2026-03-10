package org.example;

import java.net.Socket;
import java.io.PrintWriter;

public class ClientePez {

    public static void enviar(String ip){

        try{

            Socket socket = new Socket(ip,5000);

            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);

            salida.println("PEZ");

            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}