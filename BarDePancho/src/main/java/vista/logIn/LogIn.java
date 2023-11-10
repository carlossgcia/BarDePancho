package vista.logIn;

import controlador.ControladorLogin;

import javax.swing.*;

public class LogIn extends JFrame implements InterfaceLogIn {

    private JTextField textFieldUsuario;
    private JPasswordField textFieldPassword;
    private JPanel panelTitulo;
    private JPanel panelLog;
    private JPanel panelPrincipal;
    private JButton logInButton;
    private JButton singInButton;
    private JLabel imagenLogin;

    public LogIn(){
        inicializaVentana();
        inicializaComponentes();

    }

    private void inicializaVentana() {
        setContentPane(panelPrincipal);
        setTitle("Log In");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void inicializaComponentes() {

        imagenLogin.setIcon(new ImageIcon("src/main/java/imagenes/iniciar.png"));
        logInButton.setActionCommand("LOGIN");
        singInButton.setActionCommand("SINGIN");

    }

    @Override
    public void setControlador(ControladorLogin controladorLogin) {
        logInButton.addActionListener(controladorLogin);
        singInButton.addActionListener(controladorLogin);
    }

    @Override
    public JPanel getPanel() {
        return panelPrincipal;
    }

    @Override
    public String getUsuario() {
        return textFieldUsuario.getText().toString();
    }

    @Override
    public String getPassword() {
        char[] arrayC = textFieldPassword.getPassword();
        String pass = new String(arrayC);
        return pass;
    }


}
