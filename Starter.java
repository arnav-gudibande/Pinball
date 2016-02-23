import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.JComponent;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Starter
{
    private static Ball bC;
    private int s;

    public static void main(String[] args){
        final int frameH = 500;
        final int frameW = 500;    
        JFrame frame = new JFrame("Pinball");
        frame.setSize(frameW,frameH);
        frame.setResizable(false);
        bC = new Ball(250,250);
        frame.add(bC);
        frame.setVisible(true);
        class MKeyListener implements KeyListener {

            public void keyPressed(KeyEvent e){
                if (e.getKeyCode()==KeyEvent.VK_LEFT){
                    moveL(10);
                }
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    moveR(10);
                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    moveU(10);
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    moveD(10);
                }
            } 

            public void keyReleased(KeyEvent e) {  }

            public void keyTyped(KeyEvent e) { }

        }
        
        MKeyListener mc = new MKeyListener();
        frame.addKeyListener(mc);
        
        move();
    }

    public static void move()
    {
        Timer s = new Timer(15,bC);
        s.start();
    }
    
    public static void moveL(int beastnum){
        bC.x = bC.x - beastnum;
        bC.dx = 
    }
    
    public static void moveR(int beastnum){
        bC.y = bC.y - beastnum;
    }
    
    public static void moveU(int beastnum){
        bC.x = bC.x + beastnum;
    }
    
    public static void moveD(int beastnum){
        bC.y = bC.y + beastnum;
    }

}
