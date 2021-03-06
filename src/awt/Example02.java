package awt;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example02 {
    
    static class MyView extends JPanel {
        //static을 붙인것과 안붙인것의 차이 - 이너클래스가 static이면 아우터클래스의 static멤버만 사용가능
        @Override
        public void paint(Graphics graphics) {
            super.paint(graphics);
            Graphics2D g = (Graphics2D)graphics;
            
            float x1 = 50, width = 100;
            float y1 = 50, height = 100;
            
            Rectangle2D.Float rect = new Rectangle2D.Float(x1, y1, width, height);
            
            g.setPaint(Color.CYAN);
            g.fill(rect);
            g.setPaint(Color.BLUE);        
            g.draw(rect);       
            
            x1 = 200;
            rect = new Rectangle2D.Float(x1, y1, width, height);
            g.setPaint(Color.YELLOW);
            g.fill(rect);
            g.setPaint(Color.GREEN);
            g.setStroke(new BasicStroke(3));
            g.draw(rect);
            
            x1 = 350;
            Ellipse2D.Float ellipse = new Ellipse2D.Float(x1, y1, width, height);
            g.setPaint(Color.PINK);
            g.fill(ellipse);
            g.setPaint(Color.RED);
            g.setStroke(new BasicStroke(6));
            g.draw(ellipse);
            
            x1 = 500;
            float arcWidth = 40, arcHeight = 40;
            RoundRectangle2D.Float roundRect = 
                    new RoundRectangle2D.Float(x1, y1, width, height, arcWidth, arcHeight);
            g.setPaint(Color.LIGHT_GRAY);
            g.fill(roundRect);
            g.setPaint(Color.GRAY);
            g.draw(roundRect);                       
        }    
    }
    
    public static void main(String[] args) {
        
        MyView myView = new MyView();
        myView.setBackground(Color.WHITE);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(myView);
        frame.setVisible(true);
    }
}
 
