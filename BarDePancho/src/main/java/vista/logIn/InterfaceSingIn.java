package vista.logIn;

import controlador.ControladorSingIn;

public interface InterfaceSingIn {
    void setControlador(ControladorSingIn controladorSingIn);
    String getUsuario();
    String getPassword();
    String getNombre();
    String getRol();
    void dispose();
}
