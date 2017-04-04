public class Planet{

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, 
				  double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) + 
			   (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		return 6.67 * Math.pow(10, -11) * this.mass * p.mass / 
		(this.calcDistance(p) * this.calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet [] allPlanets){
		double res = 0;
		for (int i = 0; i < allPlanets.length; i++){
			if (!this.equals(allPlanets[i])){
				res += this.calcForceExertedByX(allPlanets[i]);
			} 
		}
		return res;
	}

	public double calcNetForceExertedByY(Planet [] allPlanets){
		double res = 0;
		for (int i = 0; i < allPlanets.length; i++){
			if (!this.equals(allPlanets[i])){
				res += this.calcForceExertedByY(allPlanets[i]);
			} 
		}
		return res;
	}

	public void update(double dt, double fX, double fY){
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+imgFileName);
	}

}