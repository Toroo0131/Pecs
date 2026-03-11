package org.example;

import javax.swing.*;
import java.awt.*;

public class PezAnimacion extends JPanel {

    int x = -100;
    int y = 150;
    boolean activo = false;

    String ip = "127.0.0.1";
    int puertoDestino;

    Image fondo;
    Image pez;

    public PezAnimacion(int puertoDestino){

        this.puertoDestino = puertoDestino;

        // cargar imágenes desde resources
        fondo = new ImageIcon(getClass().getResource("/Images/fondo.png")).getImage();
        pez = new ImageIcon(getClass().getResource("/Images/pez-payaso.png")).getImage();

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

        // dibujar fondo
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

        if(activo){

            int ancho = 160;
            int alto = 100;

            // dibujar pez con imagen
            g.drawImage(pez, x, y, ancho, alto, this);
        }
    }
}