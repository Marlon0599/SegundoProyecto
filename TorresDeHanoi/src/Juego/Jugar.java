package Juego;

import LogicaJuego.Logica;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Jugar extends JPanel {

    JButton regresar = new JButton();
    JPanel panel = new JPanel();
    Logica juego;

    public Jugar() {
        iniciarComponentes();
        this.setLayout(null);
    }

    private void iniciarComponentes() {
        configBotones();
        try {
            this.juego = new Logica();
            juego.setSize(1000, 500);
            juego.setLocation(0, 0);
            panel.setBackground(Color.YELLOW);
            panel.setLayout(null);
            panel.add(juego);
        } catch (IOException ex) {
        }
        panel.setBackground(Color.PINK);
        panel.setSize(1000, 500);
        panel.setLocation(0, 0);
        this.add(regresar);
        this.add(panel);

    }

    private void configBotones() {
        ActionListener clickRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal panelMP = new MenuPrincipal();
                Ventana cambiarPanel = new Ventana();
                cambiarPanel.cambiarPanel(panelMP);

            }
        };
        regresar.setBounds(300, 30, 90, 30);
        regresar.setBackground(Color.LIGHT_GRAY);
        regresar.addActionListener(clickRegresar);
        regresar.setText("Regresar");

    }
}
