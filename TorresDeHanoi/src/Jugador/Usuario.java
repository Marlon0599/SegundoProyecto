package Jugador;

public class Usuario {

    private String nombre;
    private int victorias;
    private int derrotas;
    private int abandonadas;
    private int totalMovimientos;
    private int noPartidas;
    private int tiempoPromedio;

    public Usuario(String nombre, int victorias, int derrotas, int abandonadas, int totalMovimientos, int noPartidas, int tiempoPromedio) {
        this.nombre = nombre;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.abandonadas = abandonadas;
        this.totalMovimientos = totalMovimientos;
        this.noPartidas = noPartidas;
        this.tiempoPromedio = tiempoPromedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getAbandonadas() {
        return abandonadas;
    }

    public void setAbandonadas(int abandonadas) {
        this.abandonadas = abandonadas;
    }

    public int getTotalMovimientos() {
        return totalMovimientos;
    }

    public void setTotalMovimientos(int totalMovimientos) {
        this.totalMovimientos = totalMovimientos;
    }

    public int getNoPartidas() {
        return noPartidas;
    }

    public void setNoPartidas(int noPartidas) {
        this.noPartidas = noPartidas;
    }

    public int getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(int tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", victorias=" + victorias + ", derrotas=" + derrotas + ", abandonadas=" + abandonadas + ", totalMovimientos=" + totalMovimientos + ", noPartidas=" + noPartidas + ", tiempoPromedio=" + tiempoPromedio;
    }

}
