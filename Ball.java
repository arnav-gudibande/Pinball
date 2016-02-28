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

public class Ball extends JPanel implements ActionListener, KeyListener
{
    // instance variables - replace the example below with your own
    public double dx=0, dy=0;
    public double x,y;
    Ellipse2D.Double ball;
    Timer t = new Timer(5, this);

    public Ball(int x, int y, int dx, int dy)
    {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        ball = new Ellipse2D.Double(x, y, 40, 40);
        g2.setColor(Color.BLUE);
        g2.fill(ball);
    }

    public void actionPerformed(ActionEvent e)
    {
        repaint();
        x+=dx;
        y+=dy;
        if(y<=0) moveDown();
        if(y>=540)moveUp();
        if(x<=0) moveRight();
        if(x>=760) moveLeft();
    }

    public void moveUp()
    {
        dy += -1;
    }

    public void moveDown()
    {
        dy += 1;
    }

    public void moveLeft()
    {
        dx += -1;
    }

    public void moveRight()
    {
        dx += 1;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP)
        {
            moveUp();
        }

        if(code == KeyEvent.VK_DOWN)
        {
            moveDown();
        }

        if(code == KeyEvent.VK_LEFT)
        {
            moveLeft();
        }

        if(code == KeyEvent.VK_RIGHT)
        {
            moveRight();
        }
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
