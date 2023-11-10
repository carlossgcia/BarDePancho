package vista.restaurante;

import modelo.entidades.Mesa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaMesas extends JPanel {
    private JPanel panelPrincipal;
    private JLabel imagenMesa;


    public VistaMesas(ArrayList<Mesa> mesas) {
        imagenMesa.setIcon(new ImageIcon("src/main/java/imagenes/mesa.png"));

        for (Mesa mesa : mesas) {

            if (mesa.isOcupada() == 1) {
                panelPrincipal.setBackground(Color.GREEN);
            } else if (mesa.isOcupada() ==0){
                panelPrincipal.setBackground(Color.RED);
            }
        }

        setSize(130, 130);
        add(panelPrincipal);

    }
}
