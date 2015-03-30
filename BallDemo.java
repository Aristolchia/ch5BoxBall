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
        int ground = 400;   // position of the ground line
        int numBalls = randomGenerator.nextInt(35) + 15;
        myCanvas.setVisible(true);
        for(int i = 0; i<numBalls;i++)
        {
            int posX = randomGenerator.nextInt(550) + 25;
            int posY = randomGenerator.nextInt(450) + 25;
            int ballD = randomGenerator.nextInt(15)+ 5;
            int ballC = randomGenerator.nextInt(3);
            
            if(ballC == 0)
            {
                BallList[i] = new BoxBall(posX, posY, ballD, Color.RED, 0, 500, 0, 600, myCanvas);
                BallList[i].draw();
            }
            if(ballC == 1)
            {
                BallList[i] = new BoxBall(posX, posY, ballD, Color.BLUE, 0, 500, 0, 600, myCanvas);
                BallList[i].draw();
            }       
            if(ballC == 2)
            {
                BallList[i] = new BoxBall(posX, posY, ballD, Color.GREEN, 0, 500, 0, 600, myCanvas);
                BallList[i].draw();
            }
        }
        // draw the ground
        myCanvas.drawLine(50, 50, 550, 50);
        myCanvas.drawLine(50, 50, 50, 450);
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
            for(int j = 1; j<numBalls;j++)
            {
                BallList[j].move();
            }

        }
    }
}
