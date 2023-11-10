package controlador;

import modelo.conexiones.LoginDao;
import modelo.entidades.LoginModelo;
import vista.logIn.BarraProgreso;

import vista.logIn.InterfaceLogIn;
import vista.logIn.InterfaceSingIn;
import vista.logIn.SingIn;
import vista.restaurante.InterfaceRestaurante;
import vista.restaurante.VistaRestaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLogin implements ActionListener {

    private LoginModelo logIn;
    private LoginDao loginDao;
    private InterfaceLogIn vistaLogIn;
    private InterfaceSingIn vistaSingIn;
    private ControladorSingIn controladorSingIn;

    public ControladorLogin(LoginModelo logIn, InterfaceLogIn vistaLogIn) {
        this.logIn = logIn;
        this.vistaLogIn = vistaLogIn;
        this.loginDao = new LoginDao();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("LOGIN")) {

            String usuario = vistaLogIn.getUsuario();
            String password = vistaLogIn.getPassword();

            if (!"".equals(usuario) || !"".equals(password)) {

                if (loginDao.validar(usuario, password)) {

                    vistaLogIn.dispose();

                    BarraProgreso barra = new BarraProgreso();

                    barra.iniciaCuenta();




                } else {
                    JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellena todos los campos");
            }


        } else if (e.getActionCommand().equals("SINGIN")) {

            vistaSingIn = new SingIn();
            controladorSingIn = new ControladorSingIn(vistaSingIn, loginDao);
            vistaSingIn.setControlador(controladorSingIn);


        }
    }
}
