import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.Random;

public class Starter
{
    
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setResizable(false);
        f.setSize(800, 600);
        Ball s = new Ball(400,300,0,0);
        f.add(s);
        f.setVisible(true);
    }

}
