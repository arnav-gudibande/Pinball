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

public class Starter implements ActionListener
{
    public static Ball s;//creates a new static object of type ball 
    public static ArrayList<Ball> bList;//creates a new ball arraylist
    public static void main(String[] args)
    {
        JFrame f = new JFrame("Rainbow Ballz");//new jframe
        f.setResizable(false);//cant resize the frame
        f.setSize(800, 600);//the size of the frame
        s = new Ball(400,300,0,0,1,40);//creating the users ball, passing values using explicit parameters
        f.add(s);//adding the ball to the jframe
        f.setVisible(true);//setting it visible
        Timer t = new Timer(3, s);//refreshes every 3 ms (this will be hard on the processor)
        bList = new ArrayList<Ball>();//creating a new arraylist of balls - keeps track of how many balls are on the jframe at one time
        
        class bListener implements KeyListener {//new blistener class - implements the interface keylistener, therfore it needs to override three methods
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {//using the getkeycode method on object e
                    case KeyEvent.VK_UP: s.moveUp();//if up arrow key, then it moves up
                    break;
                    case KeyEvent.VK_DOWN: s.moveDown();//if down arrow key, then it moves down
                    break;
                    case KeyEvent.VK_LEFT: s.moveLeft();//if left arrow key, .....
                    break;
                    case KeyEvent.VK_RIGHT: s.moveRight();//,..
                    break;
                    case KeyEvent.VK_N: //if the n button is tapped
                        Ball beast = new Ball(400,300,0,0,2,20); //it creates a new ball object called beast with many parameters and a size of 20
                        bList.add(beast);
                        f.add(beast);//adds beast to the frame
                        f.setVisible(true);
                        t.addActionListener(beast);//adds the actionlistener of beast to the timer
                        break;
                    default: break;
                }
            }
            public void keyReleased(KeyEvent e){}//overriding two methods, needs to be done if you implement an interface
            public void keyTyped(KeyEvent e){}
        }
        f.addKeyListener(new bListener());//creating a new keylistener and adding it to the frame
        f.add(s);//adding the users ball to the frame
        f.setVisible(true);//setting it to visible and starting the timer
        t.start();// refer to above line
    }
    
    public void actionPerformed(ActionEvent e) {//this method must be overriden b/c this class implements Actionlistener
        for (Ball b : bList) {//for every ball in the arraylist, this method will move each one
            b.move();//moves each ball
        }
    }

}