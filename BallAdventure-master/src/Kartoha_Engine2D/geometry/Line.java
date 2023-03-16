package Kartoha_Engine2D.geometry;

import Kartoha_Engine2D.drawing.Drawable;
import Kartoha_Engine2D.limiters.Intersectional;
import Kartoha_Engine2D.utils.Tools;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class Line implements Drawable, Intersectional {

    public float x1, x2, y1, y2;
    @Getter @Setter
    private int z;
    private float k, b;
    private float A, B, C;

    {
        z = 0;
    }

    public Line(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

        calcEq();
        calcNormalEq();
    }

    public Line(Point2 point1, Point2 point2) {
        this.x1 = point1.x;
        this.x2 = point2.x;
        this.y1 = point1.y;
        this.y2 = point2.y;

        calcEq();
        calcNormalEq();
    }

    public Line(Point2 point, Vector2 vector) {
        this.x1 = point.x;
        this.x2 = point.x + vector.getX();
        this.y1 = point.y;
        this.y2 = point.y + vector.getY();

        calcEq();
        calcNormalEq();
    }

    void calcEq() {
        k = (y2 - y1) / (x2 - x1);
        b = y1 - k * x1;
    }

    void calcNormalEq() {
        A = y1 - y2;
        B = x2 - x1;
        C = x1 * y2 - x2 * y1;
    }

    public float maxY() {
        return Math.max(y1, y2);
    }

    public float maxX() {
        return Math.max(x1, x2);
    }

    public float minY() {
        return Math.min(y1, y2);
    }

    public float minX() {
        return Math.min(x1, x2);
    }


    public float calcDistance(float x, float y) {
        return (float) (Math.abs(A * x + B * y + C)
                / Math.sqrt(A * A + B * B));
    }

    public float calcDistance(Point2 point){
        return calcDistance(point.x, point.y);
    }

    public boolean doesIntersectBySegmentsWith(Line line) {
        return Vector2.getLeftTurn(new Point2(x1, y1), new Point2(x2, y2), new Point2(line.x1, line.y1))
                != Vector2.getLeftTurn(new Point2(x1, y1), new Point2(x2, y2), new Point2(line.x2, line.y2))
                && Vector2.getLeftTurn(new Point2(line.x1, line.y1), new Point2(line.x2, line.y2), new Point2(x1, y1))
                != Vector2.getLeftTurn(new Point2(line.x1, line.y1), new Point2(line.x2, line.y2), new Point2(x2, y2));
    }

    public boolean doesIntersect(Line line){
        return this.A * line.B == this.B * line.A;
    }

    public boolean doesIntersectSegmentOf(Line line){
        if (this.A * line.B != this.B * line.A) {
            float ix = -(this.C * line.B - line.C * this.B) / (this.A * line.B - this.B * line.A);
            float iy = -(this.A * line.C - line.A * this.C) / (this.A * line.B - this.B * line.A);
            return (line.minX() <= ix && ix <= line.maxX() && line.minY() <= iy && iy <= line.maxY());
        }

        return false;
    }



    public Point2 findIntPointWith(Line line) {
        float ix = -(this.C * line.B - line.C * this.B) / (this.A * line.B - this.B * line.A);
        float iy = -(this.A * line.C - line.A * this.C) / (this.A * line.B - this.B * line.A);

        return new Point2(ix, iy);
    }

    public boolean isPointInBoundingBox(Point2 point) {
        return point.x <= maxX() && point.x >= minX() && point.y >= minY() && point.y <= maxY();
    }

    @Override
    public String toString() {
        return x1 + "; " + y1 + "  " + x2 + "; " + y2;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(Tools.transformFloat(x1),
                Tools.transformFloat(y1),
                Tools.transformFloat(x2),
                Tools.transformFloat(y2));
    }

}
