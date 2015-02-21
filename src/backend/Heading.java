package backend;

import java.lang.Math;

public class Heading {

	private double angle;

	public Heading(double angle) {
		this.angle = angle;
	}

	public void setAngle(double newAngle) {
		angle = newAngle;
	}

	public double getAngle() {
		return angle;
	}

	public double getAngleRads() {
		return (angle / 180) * Math.PI;
	}

}
