package org.example;

import javax.swing.*;
import java.awt.*;

public class PezAnimacion extends JPanel {

    int x = -100;
    int y = 150;
    boolean activo = false;

    String ip = "127.0.0.1";
    int puertoDestino;

    public PezAnimacion(int puertoDestino){

        this.puertoDestino = puertoDestino;

        Timer timer = new Timer(50, e -> mover());
        timer.start();
    }

    public void aparecerPez(){
        activo = true;
        x = 0;
    }

    public void mover(){

        if(activo){

            x += 5;

            if(x > getWidth()){
                activo = false;
                ClientePez.enviar(ip, puertoDestino);
            }

            repaint();
        }
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        // fondo azul
        g.setColor(new Color(0,150,255));
        g.fillRect(0,0,getWidth(),getHeight());

        if(activo){

            Graphics2D g2 = (Graphics2D) g;

            int ancho = 160;
            int alto = 80;

            // cuerpo
            g2.setColor(new Color(255,140,0));
            g2.fillOval(x, y, ancho, alto);

            // cola
            int[] colaX = {x, x-40, x};
            int[] colaY = {y+20, y+40, y+60};
            g2.fillPolygon(colaX, colaY, 3);

            // aleta superior
            int[] aletaX = {x+40, x+80, x+120};
            int[] aletaY = {y, y-40, y};
            g2.fillPolygon(aletaX, aletaY, 3);

            // ojo
            g2.setColor(Color.WHITE);
            g2.fillOval(x+120, y+20, 20,20);

            g2.setColor(Color.BLACK);
            g2.fillOval(x+128, y+28, 10,10);
        }
    }
}