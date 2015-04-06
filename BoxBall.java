import java.awt.*;
import java.awt.geom.*;
/**
 * Write a description of class BoxBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int topPosition;
    private final int leftPosition;
    private final int rightPosition;
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;
    private int ballSpeed;

    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor, int groundPos, int topPos, int leftPos, int rightPos, Canvas drawingCanvas, int ballS)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        topPosition = topPos;
        rightPosition = rightPos;
        leftPosition = leftPos;
        canvas = drawingCanvas;
        ballSpeed = ballS;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += (ballSpeed*ySpeed);
        xPosition += (ballSpeed*xSpeed);

        // check if it has hit the ground
        if(yPosition <= (groundPosition)) {
            //yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        }
         if(yPosition >= (topPosition - diameter)) 
        {
            //yPosition = (int)(topPosition - diameter);
            ySpeed = -ySpeed;
        } 
        if(xPosition <= leftPosition)
        {
            //xPosition = (int)(leftPosition - diameter);
            xSpeed = -xSpeed;
        } if(xPosition >= (rightPosition - diameter)){
            //xPosition = (int)(rightPosition - diameter);
            xSpeed = -xSpeed;
        }
        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
