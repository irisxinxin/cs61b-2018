public class NBody{
    public double readRadius(String fileName){
	In in = new In(fileName);

	int number = in.readInt();
	double radius = in.readDouble();
	
	return radius;
    }

    public Planet[] readPlanets(String fileName){
	In in = new In(fileName);

	int numbers = in.readInt();
	double radius = in.readDouble();
	int i = 0;
	Planet[] planets = new Planet[numbers];
	while(i < numbers){
	    Planet b = new Planet(0,0,0,0,0," ");
	    b.xxPos = in.readDouble();
	    b.yyPos = in.readDouble();
	    b.xxVel = in.readDouble();
	    b.yyVel = in.readDouble();
	    b.mass = in.readDouble();
	    b.imgFileName = in.readString();
	    planets[i] = b;
	    i++;
}
	return planets;
    }

    public static void main(String[] args){

	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	NBody nbody = new NBody();
	Planet[] planets = nbody.readPlanets(filename);
	double radius = nbody.readRadius(filename);

	/**  Clears the drawing windows **/
	StdDraw.clear();
	/** Set up the background **/
	StdDraw.setScale(-radius, radius);

	
	for(double time = 0; time < T; time += 100000){
	    StdDraw.enableDoubleBuffering();
	    StdDraw.picture(0, 0, "images/starfield.jpg");
	    double[] xForces = new double[planets.length];
	    double[] yForces = new double[planets.length];
	    for(int i = 0; i < planets.length; i++){
		xForces[i] = planets[i].calcNetForceExertedByX(planets);
		yForces[i] = planets[i].calcNetForceExertedByY(planets);
		planets[i].update(100000, xForces[i],yForces[i]);
		planets[i].draw();
		StdDraw.show();
		StdDraw.pause(10);
	}
	}
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < planets.length; i++) {
	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
			  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
			  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
	}
    }
}