package gameprocessing;
import processing.core.*;

public class Obstacle extends PApplet{

    private float posX;
    private float posY;
    private int height;
    private int width;

    public Obstacle(float posX, float posY, int width, int height){
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    void display(PApplet screen){
        screen.fill(255);
        screen.rect(this.posX, this.posY, this.width, this.height);
    }

    boolean isCollidingWith(Obstacle obstacle){
        return this.getPosX() < obstacle.getPosX() + obstacle.getWidth() &&
                this.getPosX() + this.getWidth() > obstacle.getPosX() &&
                this.getPosY() < obstacle.getPosY() + obstacle.getHeight() &&
                this.getPosY() + this.getHeight() > obstacle.getPosY();
    }


}
