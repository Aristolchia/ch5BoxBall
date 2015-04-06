import java.awt.Color;
import java.util.Random;

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
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        //int ground = 400;   // position of the ground line
        myCanvas.setVisible(true);
        for(int i = 0; i< numBalls;i++)
        {
            int posX = randomGenerator.nextInt(450) + 75;
            int posY = randomGenerator.nextInt(300) + 75;
            int ballD = randomGenerator.nextInt(15)+ 5;
            int ballS = randomGenerator.nextInt(5) + 1;
            int red = randomGenerator.nextInt(128)+64;
            int green = randomGenerator.nextInt(128+64);
            int blue = randomGenerator.nextInt(128)+64;
            Color randomColor = new Color(red, green, blue);
            BallList[i] = new BoxBall(posX, posY, ballD, randomColor, 50, 450, 50, 550, myCanvas, ballS);
            BallList[i].draw();
            
        }
        // draw the ground
        myCanvas.drawLine(50, 50, 550, 50);
        myCanvas.drawLine(50, 50, 50, 450);
        myCanvas.drawLine(50, 450, 550, 450);
        myCanvas.drawLine(550, 50, 550, 450);
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
                myCanvas.drawLine(50, 50, 550, 50);
                myCanvas.drawLine(50, 50, 50, 450);
                myCanvas.drawLine(50, 450, 550, 450);
                myCanvas.drawLine(550, 50, 550, 450);
            }
            
        }
    }
}
