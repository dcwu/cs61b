

/**
 * import huglife.*;
 * Created by DC1 on 9/2/18.
 */
public class NBody {

    public static double readRadius(String path){
        In in = new In(path);
        int num =  in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path){
        In in  = new In(path);
        int num = in.readInt();
        double r = in.readDouble();

        Planet[] Ps = new Planet[num];
        int row = 0;
        while (row<num){
            double xp = in.readDouble();
            double yp = in.readDouble();
            double xv = in.readDouble();
            double yv = in.readDouble();
            double m = in.readDouble();
            String IMGname = in.readString();
            Ps[row] =  new Planet(xp,yp,xv,yv,m,IMGname);
            row += 1;
        }
        return Ps;

    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] ps = readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.clear();
        StdDraw.picture(0,0,"./images/starfield.jpg");
        for (Planet p: ps){
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        double t = 0;
        while(t!=T){
            Double[] xForces = new Double[ps.length];
            Double[] yForces = new Double[ps.length];
            StdDraw.clear();
            StdDraw.picture(0,0,"./images/starfield.jpg");
            for (int i=0;i<ps.length;i++){
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
            }

            for (int i=0;i<ps.length;i++){
            ps[i].update(dt,xForces[i],yForces[i]);
            }

            for (int i=0;i<ps.length;i++){
                ps[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;



        }

        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
    }
}
}



