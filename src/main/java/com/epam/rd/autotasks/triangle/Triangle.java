package com.epam.rd.autotasks.triangle;

class Triangle {
    final private Point a,b,c;
    final private double ab,bc,ca;
    public Triangle(Point a, Point b, Point c) {
        double  ab=length(a,b),
                bc=length(b,c),
                ca=length(c,a);
        if (ab+bc<=ca || ab+ca<=bc || bc+ca<=ab)
            throw new IllegalArgumentException();
        this.a=a;
        this.b=b;
        this.c=c;
        this.ab=ab;
        this.bc=bc;
        this.ca=ca;
    }

    private static double length (Point start, Point end){
        double deltaX=start.getX()-end.getX();
        double deltaY=start.getY()-end.getY();
        return Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
    }

    public double area() {
        double s = (ab+bc+ca)/2;
        return Math.sqrt(s*(s-ab)*(s-bc)*(s-ca));
    }

    public Point centroid(){
        double cartesianX = (a.getX()+b.getX()+c.getX())/3;
        double cartesianY = (a.getY()+b.getY()+c.getY())/3;
        return new Point(cartesianX,cartesianY);
    }

}
