import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorTriangleOutline {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//setting the frame
        frame.setBounds(0,0,1000,1000);//setting the bounds of the frame
        frame.setDefaultCloseOperation(3);
        JPanel panel = new JPanel(){//creating the panel
            /*
             *@param graphics object
             */
            @Override
            public void paint(Graphics g) {//overriding paint method
                Random random = new Random();
                Graphics2D g2 = (Graphics2D) g.create();
                for(int i=0;i<500;i++) {
                    int x1 = random.nextInt(0, 1001);//inserting random values
                    int y1 = random.nextInt(0, 1001);
                    int x2 = random.nextInt(0, 1001);
                    int y2 = random.nextInt(0, 1001);
                    int x3 = random.nextInt(0, 1001);
                    int y3 = random.nextInt(0, 1001);
                    int red = random.nextInt(0,256);
                    int green = random.nextInt(0,256);
                    int blue = random.nextInt(0,256);
                    g2.setColor(new Color(red,green,blue));
                    g2.drawPolygon(new Polygon(new int[]{x1,x2,x3},new int[]{y1,y2,y3}, 3));//drawing triangle using polygon
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);//setting visibility
    }
}
