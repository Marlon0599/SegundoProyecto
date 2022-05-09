package LogicaJuego;

public class Varios{

    String cadena;
    int contador;



    public boolean verificarFinalJuego(int n, int numeroArosTorre3) {

        return n == numeroArosTorre3;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

}
