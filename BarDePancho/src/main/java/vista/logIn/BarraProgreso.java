package vista.logIn;

import controlador.ControladorRestaurante;
import modelo.entidades.LoginModelo;
import vista.restaurante.InterfaceRestaurante;
import vista.restaurante.VistaRestaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BarraProgreso extends JFrame {
    private JProgressBar barra;
    private JPanel panelBarra;


    Thread hilo;
    Object objeto = new Object();


    public BarraProgreso() {
        setContentPane(panelBarra);
        setTitle("cargando");
        setSize(500, 50);
        setLocationRelativeTo(null);
        setVisible(true);
        barra.setValue(0);


    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public JPanel getPanelBarra() {
        return panelBarra;
    }

    public void setPanelBarra(JPanel panelBarra) {
        this.panelBarra = panelBarra;
    }

    public void iniciaCuenta() {
        if (hilo == null) {
            hilo = new ThreadCarga();
            hilo.start();
        }
    }

    class ThreadCarga extends Thread {

        public void run() {
            int min = 0;
            int max = 100;

            barra.setValue(min);
            barra.setMinimum(min);
            barra.setMaximum(max);

            for (int i = min; i <= max; i++) {
                barra.setValue(i);

                synchronized (objeto) {

                    try {
                        objeto.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (barra.getValue() == 100) {

                    InterfaceRestaurante vistaRestaurante = new VistaRestaurante();
                    ControladorRestaurante controladorRestaurante = new ControladorRestaurante();
                    vistaRestaurante.setControlador(controladorRestaurante);
                    vistaRestaurante.introduce();

                }

            }
            hilo = null;
        }
    }


}

