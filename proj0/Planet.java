public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }



    public double calcDistance(Planet p){
        /** calculate the distance between two planets*/
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double dist = dx*dx + dy*dy;
        return Math.sqrt(dist);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return (6.67E-11)*this.mass*p.mass/r/r;

    }

    public double calcForceExertedByX(Planet p){
        double totalF = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        return totalF*dx/r;
    }

    public double calcForceExertedByY(Planet p){
        double totalF = this.calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        return totalF*dy/r;
    }

    public double calcNetForceExertedByX(Planet[] Ps){
        int i = 0;
        double fx = 0;
        while (i < Ps.length){
            if (!this.equals(Ps[i])){
                fx += this.calcForceExertedByX(Ps[i]);
            }
            i++;
        }
        return fx;

    }

    public double calcNetForceExertedByY(Planet[] Ps){
        int i = 0;
        double fy = 0;
        while (i < Ps.length){
            if (!this.equals(Ps[i])){
                fy += this.calcForceExertedByY(Ps[i]);
            }
            i++;
        }
        return fy;

    }

    public void update(double t, double fx, double fy){
        double ax = fx/this.mass;
        double ay =  fy/this.mass;

        this.xxVel =  this.xxVel + ax*t;
        this.yyVel = this.yyVel + ay*t;

        this.xxPos = this.xxPos + this.xxVel*t;
        this.yyPos = this.yyPos + this.yyVel*t;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }


}