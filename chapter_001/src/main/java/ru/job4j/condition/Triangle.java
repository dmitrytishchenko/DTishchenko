package ru.job4j.condition;
/**
 * Это шестая моя программа
 * @version 1.06 6.12.2017
 * @author Dmitriy Tishchenko
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double distance(Point a, Point b){
        double ab = Math.sqrt(Math.pow((xb - xa), 2) + Math.pow((yb - ya), 2));
        return ab>0 ? ab: -1.0;
    }
    public double distance(Point b, Point c){
        double bc = Math.sqrt(Math.pow((xc - xb), 2) + Math.pow((yc - yb), 2));
        return bc>0 ? bc: -1.0;
    }
    public double distance(Point a, Point c){
        double ac = Math.sqrt(Math.pow((xc - xa), 2) + Math.pow((yc - ya), 2));
        return ac>0 ? ac: -1.0;
    }
    public double period(double ab, double ac, double bc){
        double per = (ab + bc+ ac)/2;
        return per>0 ? per : -1.0;
    }

    public double area(){
        double rsl = -1;
        double ab = this.distance(this.a, this.b);
        double ac = this.distance(this.a, this.c);
        double bc = this.distance(this.b, this.c);
        double p = this.period(ab, ac, bc);
        if(this.exist(ab,ac,bc)){
            rsl = Math.sqrt(p*(p - ab)*(p - ac)*(p - bc));
        }
        return rsl>0 ? rsl : -1.0;
    }
    private boolean exist(double ab, double ac, double bc){
        return (ab = 0, bc = 0, ac = 0) ? false : true;
    }
}
