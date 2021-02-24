package gerstle.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Draws the rocket on the canvas
 */
public class RocketCanvas extends Canvas
{
    /**
     * Draws the path of the Rocket starting from time = 0 to the Rocket's flight time with one second intervals.
     * @param rocket
     */
    public void draw(Rocket rocket)
    {
        GraphicsContext context = getGraphicsContext2D();

        context.setFill(Color.VIOLET);
        context.fillRect(0,0, getWidth(), getHeight());
        context.setFill(Color.BLUE);

        context.translate(0, getHeight());
        context.beginPath();
        for(double time = 0; time<rocket.getFlightTime(); time+=0.5)
        {
            double x = rocket.getX(time);
            double y = rocket.getY(time);
            context.fillOval(x, -y, 8, 8);
            context.moveTo(x, -y);
            context.lineTo(rocket.getX(time+.5), -rocket.getY(time+.5));
            context.stroke();
        }
        context.restore();
    }
}
