package org.example;
import javax.swing.*;
import java.awt.*;

public class PezAnimacion extends JPanel {

    int x = -100;
    int y = 150;
    boolean activo = false;

    String siguienteIP = "192.168.1.20";

    public PezAnimacion(){

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

            if(x > 550){
                activo = false;
                ClientePez.enviar(siguienteIP);
            }

            repaint();
        }
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);

        if(activo){
            g.setColor(Color.ORANGE);
            g.fillOval(x,y,60,30);
        }
    }
}