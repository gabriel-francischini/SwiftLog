package core.janela;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {


    public Janela(int width, int height) {
        super("SwiftLog");
        this.setPreferredSize(new Dimension(width, height));
        int x = ( Toolkit.getDefaultToolkit().getScreenSize().width - width ) / 2;
        int y = ( Toolkit.getDefaultToolkit().getScreenSize().height - height ) / 2;
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
