package vista.logIn;

import controlador.ControladorLogin;

import javax.swing.*;

public interface InterfaceLogIn {

    void setControlador(ControladorLogin controladorLogin);

    JPanel getPanel();
    String getUsuario();
    String getPassword();


    void dispose();

}
