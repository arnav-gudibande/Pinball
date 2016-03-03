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
import java.util.Random;//imports all neccessary components

public class Ball extends JComponent implements ActionListener
{
    // instance variables - replace the example below with your own
    public double dx=0, dy=0;
    public double x,y,d;
    Ellipse2D.Double ball;
    Color c;//instance field variables for the Ball class

    public Ball(int x, int y, int dx, int dy, int o, int d)//the explicit parameters for the BAll constructor
    {
        switch(o){//switch stamenment
            case 1://if its the users ball - then make it obey key strokes
                this.x = x;
                this.y = y;//sets all the instance field variables to whatever was specified
                this.dx = dx;
                this.dy = dy;
                c = setBallColor();
                break;
            case 2://if its a random spawned ball - then make it erratic in nature
                Random ran = new Random();//hence the random object is constructed 
                int n = ran.nextInt(1);
                if(n == 0) {
                    this.dx = -ran.nextInt(20)+1;//sets the dx and dy to random values based whatever value was chosen
                    this.dy = -ran.nextInt(20)+1;
                }
                else {
                    this.dx = ran.nextInt(20)+1;//sets the dx and dy to random values based whatever value was chosen
                    this.dy = ran.nextInt(20)+1;
                } 
                break;
        }
        this.d = d;//sets the dimensions of the ball
    }

    public void paintComponent(Graphics g)//necessary overriden method, the result of extending JFrame
    {
        Graphics2D g2 = (Graphics2D) g;//creates a new Graphics2D object, and casts it b/c u are going from higher to lower dependency
        ball = new Ellipse2D.Double(x, y, d, d);//creates a new ball, uses the instance field variables specified by the user
        g2.setColor(setBallColor());//sets the ball to a random color, RAINBOW 
        g2.fill(ball);//fills the ball in the graphics2d object
    }

    public void actionPerformed(ActionEvent e)
    {
        move();//when the timer calls itself, move the ball
    }
    
    public void move(){
        repaint();//repaints the frame and also adds to the speed that the ball is moving in
        x+=dx;//speed is added to the dx
        y+=dy;//speed is added to dy
        if(y<=0) moveDown();//if any of the bounds are breached, then make the ball move accordingly
        if(y>=540)moveUp();
        if(x<=0) moveRight();
        if(x>=760) moveLeft();
    }

    public void moveUp()
    {
        dy += -1;//make the dx go down to move up in the frame
    }

    public void moveDown()
    {
        dy += 1;//to move up, vice versa
    }

    public void moveLeft()
    {
        dx += -1;//to move left, dx is subtracted from
    }

    public void moveRight()
    {
        dx += 1;//to move right, dx is added to 
    }
    
    public Color setBallColor(){//this is just for fun...
        ArrayList<Color> colors = new ArrayList<Color>();//creating a new arraylist of random colors
        colors.add(Color.red);//adding a multitude of colors to this
        colors.add(Color.yellow);
        colors.add(Color.blue);
        colors.add(Color.orange);
        colors.add(Color.green);
        colors.add(Color.magenta);
        colors.add(Color.cyan);
        Random beast = new Random();//creating a new random object called beast
        int x = beast.nextInt(colors.size());//picking a color based on beast's value
        return colors.get(x);//returning that color
    }
    
}