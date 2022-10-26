import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SierpinskiTriangle {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//setting the frame
        frame.setBounds(0,0,1024,768);//setting the bounds of the frame
        frame.setDefaultCloseOperation(3);
        JPanel panel = new JPanel(){//creating the panel
            /*
             *@param graphics object
             */
            @Override
            public void paint(Graphics g) {//overriding paint method
                Random random = new Random();
                int x1 = 512,y1 = 109;
                int x2 = 146,y2 = 654;
                int x3 = 876,y3 = 654;
                int x = 512,y = 382;
                int n=50000;
                for(int i=0;i<n;i++){
                    g.drawLine(x,y,x,y);//plotting a point
                    int randValue = random.nextInt(1,4);//picking random values
                    int dx,dy;
                    if(randValue==1){
                        dx=x-x1;
                        dy=y-y1;//calculating distances
                    }
                    else if(randValue==2){
                        dx=x-x2;
                        dy=y-y2;//calculating distances
                    }
                    else{
                        dx=x-x3;
                        dy=y-y3;//calculating distances
                    }
                    x=x-dx/2;
                    y=y-dy/2;//updating x and y values
                }
                g.drawString("Sierpinski Triangle",462,484);//printing string at specific values
            }
        };
        frame.add(panel);
        frame.setVisible(true);//setting visibility
    }
}
