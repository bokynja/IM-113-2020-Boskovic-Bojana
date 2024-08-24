package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DigDonut;
import drawing.PnlDrawing;
import geometry.Donut;


public class Donut extends Circle {

	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	public double area() {
		return super.area() - Math.PI * innerRadius * innerRadius;
	}

	@Override
	public String toString() {
		return "Donut [innerRadius= " + innerRadius + " outer " + super.toString()+ "]";
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
	}

	public boolean contains(int x, int y) {
		return super.contains(x,y) && getCenter().distance(new Point(x,y)) >= innerRadius;
	}

	public void DialogEdit() {
		DigDonut digDonut = new DigDonut();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				for(String idk : split) {
					System.out.println(idk);
				}
				digDonut.getTxtXCoord().setText(split[8].trim());
				digDonut.getTxtYCoord().setText(split[11].trim());
				digDonut.getTxtRadius().setText(split[17].trim());
				digDonut.getTxtInnerRadius().setText(split[2].trim());
			}
		}
		digDonut.setVisible(true);
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut) o;
			if(getRadius()==temp.getRadius() && getCenter().equals(temp.getCenter()) && innerRadius==temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void AreaPainter(Graphics g) {
		super.AreaPainter(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius() * 2, this.getInnerRadius() * 2);
	}
}
