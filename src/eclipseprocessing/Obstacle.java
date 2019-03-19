package eclipseprocessing;
import processing.core.*;

public class Obstacle extends PApplet{

    private int posX;
    private int posY;
    private int height;
    private int width;

    public Obstacle(int posX, int posY, int width, int height){
        this.posX = posX;
        this.posY = posY;
        this.height = height;
        this.width = width;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
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

}
