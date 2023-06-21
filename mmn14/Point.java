//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Point {
    private int _x;
    private int _y;
    private final int MIN_COORDINATE = 0;

    public Point(int x, int y) {
        this._x = x > 0 ? x : 0;
        this._y = y > 0 ? y : 0;
    }

    public Point(Point other) {
        this._x = other._x;
        this._y = other._y;
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void setX(int num) {
        if (num >= 0) {
            this._x = num;
        }

    }

    public void setY(int num) {
        if (num >= 0) {
            this._y = num;
        }

    }

    public boolean equals(Point other) {
        return this._x == other._x && this._y == other._y;
    }

    public boolean isAbove(Point other) {
        return this._y > other._y;
    }

    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        return this._x < other._x;
    }

    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow((double)(p._y - this._y), 2.0) + Math.pow((double)(p._x - this._x), 2.0));
    }

    public void move(int deltaX, int deltaY) {
        if (this._x + deltaX >= 0 && this._y + deltaY >= 0) {
            this.setX(this._x + deltaX);
            this.setY(this._y + deltaY);
        }

    }

    public Point middle(Point p) {
        return new Point((this._x + p._x) / 2, (this._y + p._y) / 2);
    }

    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }
}
