package gameprocessing;

//to improve - add, substract
public class PositionXY<T> {
    private T coorX;
    private T coorY;

    public PositionXY(T x, T y){
        coorX = x;
        coorY = y;
    }

    public T getCoorX() {
        return coorX;
    }

    public void setCoorX(T coorX) {
        this.coorX = coorX;
    }

    public T getCoorY() {
        return coorY;
    }

    public void setCoorY(T coorY) {
        this.coorY = coorY;
    }
}
