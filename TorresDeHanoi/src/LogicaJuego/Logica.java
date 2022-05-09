package LogicaJuego;

import Jugador.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Logica extends JPanel implements ActionListener, MouseListener {
    
    ArrayList <Usuario> personas = new ArrayList<Usuario>();

    Varios hanoi = new Varios();
    int numeroDeDiscos;
    int numeroDeMovimientos;
    int discosEnJuego;

    Torre torre1 = new Torre();
    Torre torre2 = new Torre();
    Torre torre3 = new Torre();

    JButton iniciar = new JButton();
    JButton truco = new JButton();

    JComboBox numeroAros = new JComboBox();

    JLabel pasosRealizado = new JLabel();
    JLabel etiquetaNoDiscos = new JLabel();
    JLabel etiquetaNombre = new JLabel();
    JLabel mostrarNombre = new JLabel();
    JLabel etiquetaTiempo = new JLabel();
    JLabel cronometro = new JLabel();

    JTextField ingresarNombre = new JTextField();

    boolean seleccionado;
    Disco discoSeleccionado;

    public Logica() throws IOException {
        numeroDeMovimientos = 0;
        numeroDeDiscos = 3;
        discoSeleccionado = null;
        seleccionado = false;
        //hanoi.hanoi(numeroDeDiscos, 1, 2, 3);
        discosEnJuego = 3;
        this.setBackground(Color.PINK);
        this.setLayout(null);
        pasosRealizado = new JLabel("Numero de Movimientos: ");
        pasosRealizado.setBounds(0, 80, 180, 10);
        this.add(pasosRealizado);

        torre1.setBounds(0, 100, 220, 300);
        torre1.addMouseListener(this);
        this.add(torre1);

        torre2.setBounds(220, 100, 220, 300);
        torre2.addMouseListener(this);
        this.add(torre2);

        torre3.setBounds(440, 100, 220, 300);
        torre3.addMouseListener(this);
        this.add(torre3);

        etiquetaTiempo = new JLabel();
        etiquetaTiempo.setBounds(600, 0, 90, 30);
        etiquetaTiempo.setText("Tiempo");
        this.add(etiquetaTiempo);

        cronometro.setBounds(600, 30, 90, 30);
        cronometro.setText("0:0");
        this.add(cronometro);

        ingresarNombre.setBounds(200, 30, 90, 30);
        this.add(ingresarNombre);

        etiquetaNombre = new JLabel();
        etiquetaNombre.setBounds(200, 0, 90, 30);
        etiquetaNombre.setText("Nombre:");
        this.add(etiquetaNombre);

        mostrarNombre = new JLabel();
        mostrarNombre.setBounds(500, 30, 90, 30);
        mostrarNombre.setText("Jugador");
        this.add(mostrarNombre);

        etiquetaNoDiscos = new JLabel("Numero de Discos:");
        etiquetaNoDiscos.setBounds(0, 0, 150, 20);
        this.add(etiquetaNoDiscos);

        truco = new JButton("Truco");
        truco.setBounds(400, 30, 90, 30);
        truco.addActionListener(this);
        truco.setBackground(Color.LIGHT_GRAY);
        this.add(truco);

        iniciar = new JButton("Iniciar");
        iniciar.setBounds(100, 30, 90, 30);
        iniciar.addActionListener(this);
        iniciar.setBackground(Color.LIGHT_GRAY);
        this.add(iniciar);

        for (int i = 3; i <= 8; i++) {
            numeroAros.addItem(i);
        }
        numeroAros.setBounds(0, 30, 90, 30);
        numeroAros.setBackground(Color.LIGHT_GRAY);
        this.add(numeroAros);
    }

    public void AgregarDiscos(int n) {

        Disco disco = new Disco();
        disco.setBounds(90, 250, 45, 20);
        disco.addMouseListener((MouseListener) this);
        torre1.add(disco);
        torre1.updateUI();

        for (int i = 1; i <= n - 1; i++) {
            torre1.add(new Disco());
            torre1.getComponent(i).addMouseListener(this);
        }
        Ordenar(n);
        torre1.updateUI();

    }

    public void Ordenar(int n) {
        if (n >= 0) {
            for (int j = 1; j <= n - 1; j++) {

                JPanel discoAnterior = (JPanel) torre1.getComponent(j - 1);
                int x = discoAnterior.getX();
                int y = discoAnterior.getY();
                int w = discoAnterior.getWidth();
                int h = discoAnterior.getHeight();

                JPanel disco = (JPanel) torre1.getComponent(j);
                disco.setBounds(x, y - h, w, h);
                discoAnterior.setBounds(x - 10, y, w + 20, h);
                torre1.setComponentZOrder(disco, j);
                torre1.setComponentZOrder(discoAnterior, j - 1);

            }
            Ordenar(n - 1);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == iniciar) {
            //try {
                //cronometro();
                mostrarNombre.setText(ingresarNombre.getText());
                ingresarNombre.setText("");

                numeroDeMovimientos = 0;
                int n = (int) numeroAros.getSelectedItem();
                discosEnJuego = n;
                hanoi.setContador(0);
                numeroDeDiscos = n;
                hanoi.setContador(0);

                int pasosMinimos = hanoi.getContador();

                torre1.removeAll();
                torre2.removeAll();
                torre3.removeAll();

                torre1.updateUI();
                torre2.updateUI();
                torre3.updateUI();

                hanoi.setContador(0);
                pasosRealizado.setText("Numero de Movimientos: ");
                AgregarDiscos(n);

            }

        }


    @Override
    public void mouseClicked(MouseEvent e) {

        if (torre1.getComponentCount() > 0) {
            if (e.getSource() == torre1.getComponent(torre1.getComponentCount() - 1) && seleccionado == false) {
                discoSeleccionado = (Disco) torre1.getComponent(torre1.getComponentCount() - 1);
                seleccionado = true;
                torre1.remove(torre1.getComponentCount() - 1);
                torre1.updateUI();
            }
        }
        if (torre2.getComponentCount() > 0) {
            if (e.getSource() == torre2.getComponent(torre2.getComponentCount() - 1) && seleccionado == false) {
                discoSeleccionado = (Disco) torre2.getComponent(torre2.getComponentCount() - 1);
                seleccionado = true;
                torre2.remove(torre2.getComponentCount() - 1);
                torre2.updateUI();
            }
        }

        if (torre3.getComponentCount() > 0) {
            if (e.getSource() == torre3.getComponent(torre3.getComponentCount() - 1) && seleccionado == false) {
                discoSeleccionado = (Disco) torre3.getComponent(torre3.getComponentCount() - 1);
                seleccionado = true;
                torre3.remove(torre3.getComponentCount() - 1);
                torre3.updateUI();
            }
        }

        if (e.getSource() == torre1 && seleccionado == true) {
            if (discoSeleccionado != null) {
                int x = discoSeleccionado.getX();
                int h = discoSeleccionado.getHeight();
                int w = discoSeleccionado.getWidth();
                if (torre1.getComponentCount() == 0) {
                    discoSeleccionado.setBounds(x, 250, w, h);
                    torre1.add(discoSeleccionado);
                    torre1.updateUI();
                    numeroDeMovimientos++;
                    discoSeleccionado = null;
                    seleccionado = false;

                } else {
                    Disco discoP = (Disco) torre1.getComponent(torre1.getComponentCount() - 1);
                    if (verificar(discoP, discoSeleccionado)) {
                        discoSeleccionado.setBounds(x, 250 - (20 * torre1.getComponentCount() - 1), w, 20);
                        torre1.add(discoSeleccionado);
                        torre1.updateUI();
                        numeroDeMovimientos++;
                        discoSeleccionado = null;
                        seleccionado = false;

                    } else {
                        JOptionPane.showMessageDialog(null, "El disco de abajo debe ser mayor");
                    }
                }
            }
        }

        if (e.getSource() == torre2 && seleccionado == true) {
            if (discoSeleccionado != null) {
                int x = discoSeleccionado.getX();
                int w = discoSeleccionado.getWidth();
                if (torre2.getComponentCount() == 0) {
                    discoSeleccionado.setBounds(x, 250, w, 20);
                    torre2.add(discoSeleccionado);
                    torre2.updateUI();
                    numeroDeMovimientos++;
                    pasosRealizado.setText("Numero de Movimientos: " + numeroDeMovimientos);

                    discoSeleccionado = null;
                    seleccionado = false;

                } else {
                    Disco discoP = (Disco) torre2.getComponent(torre2.getComponentCount() - 1);

                    if (verificar(discoP, discoSeleccionado)) {
                        discoSeleccionado.setBounds(x, 250 - (20 * torre2.getComponentCount() - 1), w, 20);
                        torre2.add(discoSeleccionado);
                        torre2.updateUI();
                        numeroDeMovimientos++;
                        pasosRealizado.setText("Numero de Movimientos: " + numeroDeMovimientos);
                        discoSeleccionado = null;
                        seleccionado = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "El disco de abajo debe ser mayor");
                    }
                }
            }
        }

        if (e.getSource() == torre3 && seleccionado == true) {
            if (discoSeleccionado != null) {

                int x = discoSeleccionado.getX();
                int h = discoSeleccionado.getHeight();
                int w = discoSeleccionado.getWidth();
                if (torre3.getComponentCount() == 0) {
                    discoSeleccionado.setBounds(x, 250, w, h);
                    torre3.add(discoSeleccionado);
                    torre3.updateUI();
                    discoSeleccionado = null;
                    numeroDeMovimientos++;
                    pasosRealizado.setText("Numero de movimientos: " + numeroDeMovimientos);
                    seleccionado = false;
                } else {
                    Disco discoP = (Disco) torre3.getComponent(torre3.getComponentCount() - 1);
                    if (verificar(discoP, discoSeleccionado)) {
                        discoSeleccionado.setBounds(x, 250 - (20 * torre3.getComponentCount() - 1), w, 20);
                        torre3.add(discoSeleccionado);
                        torre3.updateUI();
                        numeroDeMovimientos++;
                        pasosRealizado.setText("Tu numero de movimientos: " + numeroDeMovimientos);
                        discoSeleccionado = null;
                        seleccionado = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "El disco de abajo debe ser mayor");
                    }
                }
            }
        }

        if (e.getSource() == torre3) {
            if (hanoi.verificarFinalJuego(numeroDeDiscos, torre3.getComponentCount()) == true) {
                JOptionPane.showMessageDialog(null, "Felicidades "+mostrarNombre.getText()+" Ganaste!!!\n con "
                        + numeroDeMovimientos+" Movimientos realizados");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public boolean verificar(Disco discoAbajo, Disco discoArriba) {
        int w = discoAbajo.getWidth();
        int w2 = discoArriba.getWidth();

        if (w > w2) {
            return true;
        } else {
            return false;
        }
    }

    private static void delaySegundo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

    public void cronometro() {
        int segundos = 0;
        int minutos = 0;
        for (minutos = 0; minutos < 60; minutos++) {
            for (segundos = 0; segundos < 60; segundos++) {
                System.out.println(minutos + ":" + segundos);
                cronometro.setText(minutos + ":" + segundos);
                delaySegundo();
            }
        }
    }

}
