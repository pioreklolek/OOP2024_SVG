package com.example;
public class Segment {
    private Vec2 startVec2;
    private Vec2 endVec2;
    public Segment(Vec2 startVec2, Vec2 endVec2) {
        this.startVec2 = startVec2;
        this.endVec2 = endVec2;
    }
    public Vec2 getStartPoint() {
        return startVec2;
    }
    public Vec2 getEndPoint() {
        return endVec2;
    }
    public double length() {
        return Math.sqrt(Math.pow(endVec2.x - startVec2.x, 2) + Math.pow(endVec2.y - startVec2.y, 2));

    }
    public String toSvg() {
        return "<line x1='" + this.startVec2.x + "' y1='" + this.startVec2.y +
                "' x2='" + this.endVec2.x + "' y2='" + this.endVec2.y +"' stroke='black' />";
    }
    @Override
    public String toString() {
        return this.toSvg();
    }
    public static Segment[] perpendicularSegments(Segment segment, Vec2 point) {
        double dx = segment.getEndPoint().x - segment.getStartPoint().x;
        double dy = segment.getEndPoint().y - segment.getStartPoint().y;
        //w skrocie:
        return new Segment[] {
                new Segment(point, new Vec2(
                        point.x - dy, point.y + dx
                )),
                new Segment(point, new Vec2(
                        point.x + dy, point.y - dx
                )),
        };

    public static Segment[] perpendicularSegments(Segment segment, Vec2 center, double length) {

        double dx = ((segment.getEndPoint().getX() - segment.getStartPoint().getX())/segment.length())*length ;
        double dy = ((segment.getEndPoint().getY() - segment.getStartPoint().getY())/segment.length())*length  ;
        return new Segment[] {
                new Segment(center, new Vec2(
                        center.x - dy, center.y + dx
                )),
                new Segment(center, new Vec2(
                        center.x + dy, center.y - dx
                )),
        };
    }
}