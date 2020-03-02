package Utilities;

import javax.swing.*;
import java.awt.*;


public class JEasyFrameFull extends JFrame {
  public final static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
  public final static GraphicsDevice device = env.getScreenDevices()[0];
  public static final Rectangle RECTANGLE = device.getDefaultConfiguration().getBounds();
  public static final int WIDTH = RECTANGLE.width;
  public static final int HEIGHT = RECTANGLE.height;

  public Component comp;

  public JEasyFrameFull(Component comp) {
    super();
    this.comp = comp;
    getContentPane().add(BorderLayout.CENTER, comp);
    comp.setPreferredSize(new Dimension (WIDTH, HEIGHT));
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setUndecorated(true);
    pack();
    this.setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    repaint();
  }
}

