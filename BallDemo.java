import java.awt.Color;
import java.util.Random;
import java.awt.Dimension;
/**
 * Class BallDemo - a short demonstration showing animation with the
 * Canvas class.
 *
 *@author: Chris Wallace
 *@version: March 16, 2015
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo
{
    private Canvas myCanvas;
    Random randomGenerator = new Random();
    int numBalls = randomGenerator.nextInt(35) + 15;
    BoxBall[] BallList = new BoxBall[numBalls];
    final int offset = 50;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        //myCanvas = new Canvas("Ball Demo", 800, 200);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        //int ground = 400;   // position of the ground line
        Dimension d = myCanvas.getSize();
        double wid = d.getWidth();
        int w = (int)wid;
        double hei = d.getHeight();
        int h = (int)hei;
        myCanvas.setVisible(true);
        for(int i = 0; i< numBalls;i++)
        {
            int posX = randomGenerator.nextInt(w-16-2*offset) + offset+8;
            int posY = randomGenerator.nextInt(h-16-2*offset) + offset+8;
            int ballD = randomGenerator.nextInt(15)+ 5;
            int ballS = randomGenerator.nextInt(5) + 1;
            int red = randomGenerator.nextInt(128)+64;
            int green = randomGenerator.nextInt(128+64);
            int blue = randomGenerator.nextInt(128)+64;
            Color randomColor = new Color(red, green, blue);
            BallList[i] = new BoxBall(posX, posY, ballD, randomColor, offset, h-offset, offset, w-offset, myCanvas, ballS);
            BallList[i].draw();
            
        }
        // draw the ground
        myCanvas.drawLine(offset, offset, w - offset, offset);
        myCanvas.drawLine(offset, offset, offset, h-offset);
        myCanvas.drawLine(offset, h-offset, w-offset, h-offset);
        myCanvas.drawLine(w-offset, offset, w-offset, h-offset);
        // crate and show the balls
        //BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        //ball.draw();
        //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        //ball2.draw();

        // make them bounce
        
        boolean finished =  false;
        while(!finished) 
        {
            myCanvas.wait(50);           // small delay
            for(int j = 0; j<numBalls;j++)            
            {
                BallList[j].move();
                myCanvas.drawLine(offset, offset, w - offset, offset);
                myCanvas.drawLine(offset, offset, offset, h-offset);
                myCanvas.drawLine(offset, h-offset, w-offset, h-offset);
                myCanvas.drawLine(w-offset, offset, w-offset, h-offset);
            }
            
        }
    }
}
