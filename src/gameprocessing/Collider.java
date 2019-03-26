package gameprocessing;

public class Collider {
    static boolean areColliding(Obstacle ob1, Obstacle ob2){
        return ob1.getPosX() < ob2.getPosX() + ob2.getWidth() &&
                ob1.getPosX() + ob1.getWidth() > ob2.getPosX() &&
                ob1.getPosY() < ob2.getPosY() + ob2.getHeight() &&
                ob1.getPosY() + ob1.getHeight() > ob2.getPosY();
    }

    static float getDistanceBetweenCentersX(Obstacle ob1, Obstacle ob2){
        if((ob1.getPosX() + ob1.getWidth() > ob2.getPosX()) && (ob1.getPosX() < ob2.getPosX())){
            return -(ob2.getPosX() - ob1.getPosX()) + ob1.getWidth();
        }
        else{
            return -(ob2.getPosX() + (ob2.getWidth() - ob1.getPosX()));
        }
    }

    static float getDistanceBetweenCentersY(Obstacle ob1, Obstacle ob2){
        if((ob1.getPosY() + ob1.getHeight() > ob2.getPosY()) && (ob1.getPosY() < ob2.getPosY())){
            return -(ob2.getPosY() - ob1.getPosY()) + ob1.getHeight();
        }
        else{
            return -(ob2.getPosY() + (ob2.getHeight() - ob1.getPosY()));
        }
    }
}
