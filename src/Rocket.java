public class Rocket
{

    private final double gravity = 9.8;
    private final double velocity;
    private final double angle;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    /**
     *
     * @param time in seconds
     * @return the x location of the Rocket at the specified time
     */
    public double getX(double time){
        double xVelocity = Math.cos(Math.toRadians(angle)) * velocity;
        double x = xVelocity * time;
        return x;
    }

    /**
     *
     * @param time in seconds
     * @returns the Y location of the Rocket at the specified time
     */
    public double getY(double time){
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double y = yVelocity * time - 0.5 * gravity * time * time;
        return y;
    }

    /**
     *
     * @returns the time the Rocket will land at a specified time
     */
    public double getFlightTime(){
        double time = Math.sin(Math.toRadians(angle))*velocity / 0.5*gravity;
        return time;
    }

}
