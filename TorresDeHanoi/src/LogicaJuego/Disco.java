package LogicaJuego;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

public class Disco extends JPanel {

    public Disco() {
        Random color = new Random();

        float color1 = color.nextFloat();
        float color2 = color.nextFloat();
        float color3 = color.nextFloat();

        Color colorDisco = new Color(color1, color2, color3);
        this.setBackground(colorDisco);
    }

}
