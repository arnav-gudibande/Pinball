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


public class Ball extends JComponent implements ActionListener
{
    public int x,y,diameter,dx,dy;
    private Ellipse2D.Double ball;

    public Ball(int x, int y){
        this.x = x;
        this.y = y;
        dx = 0;
        dy = 0;
    }
    
    public void paintComponent(Graphics g){
        int diameter = 50;
        Graphics2D g2 = (Graphics2D) g;
        dx = x+dx;
        dy = y+dy;
        ball = new Ellipse2D.Double(x,y,diameter,diameter);
        g2.setColor(Color.BLUE);
        g2.fill(ball);
        g2.draw(ball);
    }

    public void actionPerformed(ActionEvent e) {
        ball.setFrame(x, y, diameter, diameter);
        repaint();
    }

}
