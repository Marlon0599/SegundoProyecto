package LogicaJuego;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Torre extends JPanel {

    public Torre() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(10, 270, 200, 15);
        g.fillRect(105, 30, 15, 240);

    }
}
