package Juego;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuPrincipal extends JPanel {

    JButton jugar = new JButton();
    JButton reportes = new JButton();
    JButton salir = new JButton();
    JPanel panelMP = new JPanel();

    public MenuPrincipal() {
        this.setLayout(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        configBottones();
        panelMP.setBackground(Color.PINK);
        panelMP.setLayout(null);
        panelMP.setSize(800, 500);
        panelMP.add(jugar);
        panelMP.add(reportes);
        panelMP.add(salir);
        this.add(panelMP);

    }

    private void configBottones() {
        Jugar panelJ = new Jugar();
        Reportes panelR = new Reportes();
        ActionListener clickJugar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana cambiarPanel = new Ventana();
                cambiarPanel.cambiarPanel(panelJ);
            }
        };
        ActionListener clickReportes = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana cambiarPanel = new Ventana();
                cambiarPanel.cambiarPanel(panelR);
            }
        };
        ActionListener clickSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        };

        jugar.setBounds(200, 100, 300, 80);
        jugar.setText("Jugar");
        jugar.setBackground(Color.LIGHT_GRAY);
        jugar.addActionListener(clickJugar);

        reportes.setBounds(200, 200, 300, 80);
        reportes.setText("Reportes");
        reportes.setBackground(Color.LIGHT_GRAY);
        reportes.addActionListener(clickReportes);

        salir.setBounds(200, 300, 300, 80);
        salir.setText("Salir");
        salir.setBackground(Color.LIGHT_GRAY);
        salir.addActionListener(clickSalir);
    }
}
