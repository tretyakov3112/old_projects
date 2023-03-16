package Kartoha_Engine2D.geometry;

import Kartoha_Engine2D.utils.FloatComparator;
import lombok.Getter;
import lombok.Setter;

public class Vector2 {

    @Getter @Setter
    private float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vector2 vector1, Vector2 vector2) {
        this.x = vector1.x + vector2.x;
        this.y = vector1.y + vector2.y;
    }

    public Vector2(Point2 point1, Point2 point2) {
        this.x = point2.x - point1.x;
        this.y = point2.y - point1.y;
    }

    public Vector2(Line line) {
        this.x = line.x2 - line.x1;
        this.y = line.y2 - line.y1;
    }

    public Vector2 (Point2 point){
        this.x = point.x;
        this.y = point.y;
    }

    public static float getLeftTurn(Point2 a, Point2 b, Point2 c){
        float result = 0f;
        if (getCrossProduct(new Vector2(a,b), new Vector2(a,c)) > 0) result = 1f;
        else if (getCrossProduct(new Vector2(a,b), new Vector2(a,c)) < 0) result = -1f;
        return result;
    }

    public void mul(float m) {
        x *= m;
        y *= m;
    }
    public void add(Vector2 vector){
        x += vector.x;
        y += vector.y;
    }

    public Vector2 getMultipliedVector(float mul) {
        return new Vector2(x * mul, y * mul);
    }

    public void addY(float a) {
        y += a;
    }

    public void addX(float a) {
        this.x += a;
    }

    public void makeOpX() {
        this.x = -this.x;
    }

    public Vector2 getCrossProduct(float c){
        return new Vector2(-c * y, c * x);
    }

    public static float getConstByCrossProduct(Vector2 resultVector, Vector2 mulVector){

        if (FloatComparator.equals(resultVector.length(), 0f)) return 0f;

        if (mulVector.getX() == 0f){
            assert mulVector.getY() == 0.0f : "Division by zero";
            return -resultVector.getX()/ mulVector.getY();
        }

        return resultVector.getY()/ mulVector.getX();
    }

    public void makeOpY() {
        this.y = -this.y;
    }

    public void makeOp() {
        makeOpX();
        makeOpY();
    }

    public float getSquare() {
        return x * x + y * y;
    }

    public Vector2 createOpVect() {
        return new Vector2(-x, -y);
    }

    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void makeUnit() {
        double d = this.length();
        x /= d;
        y /= d;
    }

    public Vector2 createByFloat(float l) {
        float d = this.length();
        return new Vector2((x / d) * l, (y / d) * l);
    }

    public float dot(Vector2 vector) {
        return this.getY() * vector.getY() + this.getX() * vector.getX();
    }

    public void mul(double number) {
        this.x *= number;
        this.y *= number;
    }

    public Point2 movePoint(Point2 point, float movement) {
        Vector2 mv = createByFloat(movement);
        return new Point2(point.x + mv.getX(), point.y + mv.getY());

    }

    public void rotate(float angle) {
        double x1, y1;
        x1 = x;
        y1 = y;
        x = (float) (x1 * Math.cos(angle) - y1 * Math.sin(angle));
        y = (float) (y1 * Math.cos(angle) + x1 * Math.sin(angle));
    }

    public Vector2 getRotatedVector(float angle) {
        float x1, y1;
        x1 = (float) (x * Math.cos(angle) - y * Math.sin(angle));
        y1 = (float) (y * Math.cos(angle) + x * Math.sin(angle));
        return new Vector2(x1, y1);
    }

    public void setLength(float len) {
        float d = length();
        x = (x / d) * len;
        y = (y / d) * len;
    }

    public Vector2 createNormal() {
        return new Vector2(-y, x);
    }

    public float countProjectionOn(Vector2 vector) {
        return this.dot(vector) / vector.length();
    }

    public static float getCrossProduct(Vector2 vector1, Vector2 vector2){
        return vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX();
    }

    @Override
    public String toString() {
        return x + "; " + y;
    }
}
