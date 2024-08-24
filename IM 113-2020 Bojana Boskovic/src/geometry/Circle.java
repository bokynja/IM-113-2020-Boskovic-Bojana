package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DigCircle;
import drawing.PnlDrawing;
import geometry.Circle;

public class Circle extends Shape {

	private Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;

	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	public double area() {
		return radius * radius * Math.PI;
	}
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	

	public String toString() {
		return "Circle [center= " + center + " , radius= " + radius + " , selected= " + selected + "]";
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}



	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(),
				this.getRadius() * 2, this.getRadius() * 2);
		if (isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + this.getRadius() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + this.getRadius() - 3, this.getCenter().getY() - 3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return center.distance(new Point(x,y))<= this.radius;
	}

	@Override
	public void move(int newX, int newY) {
		center.move(newX, newY);
	}

	@Override
	public void DialogEdit() {
		DigCircle digCircle = new DigCircle();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				digCircle.getTxtXCoord().setText(split[4]);
				digCircle.getTxtYCoord().setText(split[7]);
				digCircle.getTxtRadius().setText(split[13]);
			}
		}
		digCircle.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(),
				this.getRadius() * 2, this.getRadius() * 2);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle) o;
			if(radius==temp.getRadius() && center.equals(temp.getCenter())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Object o) { 
		if (o instanceof Circle) {
			return (int) (this.area() - ((Circle) o).area());
		}
		return 0; 
	}
	
	
	
}

