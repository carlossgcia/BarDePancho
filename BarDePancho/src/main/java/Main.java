import controlador.ControladorLogin;
import modelo.entidades.LoginModelo;
import vista.logIn.InterfaceLogIn;
import vista.logIn.LogIn;

public class Main {
    public static void main(String[] args) {
        InterfaceLogIn interfaceLogIn = new LogIn();
        LoginModelo loginModelo = new LoginModelo();
        ControladorLogin controladorLogin = new ControladorLogin(loginModelo,interfaceLogIn);
        interfaceLogIn.setControlador(controladorLogin);
    }
}
