package Juego;

import java.awt.Color;
import javax.swing.*;

public class Ventana extends JFrame {

    JPanel panelCambiante = new JPanel();

    public Ventana() {
        iniciarComponentes();
        this.setVisible(true);
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Torres De Hanoi");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        MenuPrincipal panelMP = new MenuPrincipal();
        cambiarPanel(panelMP);
        this.add(panelCambiante);
    }

    public void cambiarPanel(JPanel panel) {
        panelCambiante.setBackground(Color.PINK);
        panelCambiante.setLayout(null);
        panel.setSize(800, 500);
        panel.setLocation(0, 0);
        panelCambiante.removeAll();
        panelCambiante.add(panel);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }

}
