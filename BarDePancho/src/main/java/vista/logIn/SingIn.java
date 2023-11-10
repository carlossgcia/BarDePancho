package vista.logIn;

import controlador.ControladorSingIn;

import javax.swing.*;

public class SingIn extends JFrame implements InterfaceSingIn {
    private JPanel panelPrincipal;
    private JTextField textFieldCorreo;
    private JPasswordField textFieldPassword;
    private JButton registrarButton;
    private JButton volverButton;
    private JComboBox<String> comboBoxRol;
    private JTextField textFieldNombre;

    public SingIn() {
        inicializarVentana();
        inicializarComponentes();
    }

    private void inicializarVentana() {
        setContentPane(panelPrincipal);
        setTitle("Sing In");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
        registrarButton.setActionCommand("REGISTRO");
        volverButton.setActionCommand("VOLVER");

        comboBoxRol.addItem("Propierario");
        comboBoxRol.addItem("Camarero");
        comboBoxRol.addItem("Cocinero");

    }


    @Override
    public void setControlador(ControladorSingIn controladorSingIn) {
        registrarButton.addActionListener(controladorSingIn);
        volverButton.addActionListener(controladorSingIn);

    }

    @Override
    public String getUsuario() {
        return textFieldCorreo.getText().toString();
    }

    @Override
    public String getPassword() {
        char[] arrayC = textFieldPassword.getPassword();
        String pass = new String(arrayC);
        return pass;
    }


    @Override
    public String getNombre() {
        return textFieldNombre.getText().toString();
    }

    @Override
    public String getRol() {
        return (String) comboBoxRol.getSelectedItem();
    }


}
