package Juego;

import Jugador.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Reportes extends JPanel {
    JTextArea tablaDeDatos = new JTextArea();
    JButton regresar = new JButton();
    public Reportes() {
        iniciarComponentes();
        this.setSize(800, 500);
        this.setBackground(Color.PINK);
        this.setLayout(null);
     
    }
    
    private void iniciarComponentes(){
        configComponentes();
        tablaDeDatos.setBounds(0,0,600,400);
        tablaDeDatos.setEditable(false);
        this.add(tablaDeDatos);
        this.add(regresar);
    }
    private void configComponentes(){
        ActionListener clickRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana cambiarPanel = new Ventana();
                MenuPrincipal panelMP = new MenuPrincipal();
                cambiarPanel.cambiarPanel(panelMP);
            }
        };
       Usuario persona = new Usuario("",0,0,0,0,0,0);
       tablaDeDatos.setText(persona.toString());
       tablaDeDatos.setBackground(Color.PINK);
       regresar.setBounds(650,0,100,30);
       regresar.setText("Regresar");
       regresar.setBackground(Color.LIGHT_GRAY);
       regresar.addActionListener(clickRegresar);
    }
}
