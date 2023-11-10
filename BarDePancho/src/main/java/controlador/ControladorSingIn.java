package controlador;

import modelo.conexiones.LoginDao;
import modelo.entidades.LoginModelo;
import vista.logIn.InterfaceSingIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSingIn implements ActionListener {
    InterfaceSingIn vistaSingin;

    LoginDao loginDao;
    LoginModelo loginModelo;

    public ControladorSingIn(InterfaceSingIn vistaSingin, LoginDao loginDao) {
        this.vistaSingin = vistaSingin;
        this.loginDao = loginDao;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals("REGISTRO")) {
            if (vistaSingin.getNombre().isEmpty() || vistaSingin.getUsuario().isEmpty() || vistaSingin.getPassword().isEmpty() || vistaSingin.getRol().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan Datos");
            } else {
                obtenerEmpleado();

                if (loginDao.registrar(loginModelo)) {
                    JOptionPane.showMessageDialog(null, "Registrado Correctamente");
                    vistaSingin.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar");
                }
            }
        } else if (actionEvent.getActionCommand().equals("VOLVER")) {

            vistaSingin.dispose();
        }

    }

    private void obtenerEmpleado() {

        loginModelo = new LoginModelo(vistaSingin.getNombre(), vistaSingin.getUsuario(), vistaSingin.getPassword(), vistaSingin.getRol());

    }
}
