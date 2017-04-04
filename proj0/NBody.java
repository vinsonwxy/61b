public class NBody {
	public static double readRadius(String filename){
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[N];
		for(int i = 0; i < N; i++){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			Planet p = new Planet(xP, yP, xV, yV, m, img);
			planets[i] = p;
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for (int i = 0; i < planets.length; i++){
			planets[i].draw();
		}
		double time = 0;
		StdAudio.play("audio/2001.mid");
		while (time < T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for (int j = 0; j < planets.length; j++){
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
			}
			for (int k = 0; k < planets.length; k++){
				planets[k].update(dt, xForces[k], yForces[k]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (int i = 0; i < planets.length; i++){
				planets[i].draw();
			}
			StdDraw.show(10);
			time += dt;
		}
	}
}
