package vista.restaurante;

import controlador.ControladorRestaurante;
import modelo.conexiones.MesasDao;
import modelo.entidades.Mesa;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaRestaurante extends JFrame implements InterfaceRestaurante {
    private JPanel panelPrincipal;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JPanel jPanelMesas;
    private JTabbedPane tabbedPane;
    private JScrollPane jScrollPaneMesas;
    private JPanel platos;
    private JTable tablePlatos;

    private ArrayList<Mesa> mesas;

    private MesasDao mesasDao = new MesasDao();

    private VistaMesas vistaMesas;

    public VistaRestaurante() {


        inicializarVentana();
        inicializarComponentes();

    }


    private void inicializarVentana() {


        setContentPane(panelPrincipal);
        setTitle("Bar Pancho");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 900);
        setLocationRelativeTo(null);

    }

    private void inicializarComponentes() {
        mesas = mesasDao.getListaMesas();
        jPanelMesas.setLayout(new GridLayout(0,3));


    }


    @Override
    public void setControlador(ControladorRestaurante controlador) {


        setVisible(true);
    }

    @Override
    public void introduce() {
        System.out.println(mesas.toString());
        for (Mesa mesa : mesas) {
            vistaMesas = new VistaMesas(mesas);
            jPanelMesas.add(vistaMesas);
            jPanelMesas.revalidate();

        }


    }
}
