
package modelo.entidades;

public class Mesa {
    private int id;
    private boolean ocupada;

    public Mesa() {
    }

    public Mesa(int id, boolean ocupada) {
        this.id = id;
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int isOcupada() {
        //Ocupada  = 1  asique color rojo
        if (ocupada == true)
            return 1;
            //Ocupada  =0  asique color verde
        else
            return 0;
    }

    public void setOcupada(int ocupada) {
        boolean oc;
        if (ocupada == 1) {
            oc = true;
        } else {
            oc = false;
        }
        this.ocupada = oc;
    }

    @Override
    public String toString() {

        return "Mesa{" +
                "id=" + id +
                ", ocupada=" + ocupada +
                '}';
    }
}
