package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DigPoint;
import drawing.PnlDrawing;
import geometry.Point;

public class Point extends Shape {

	public int x;
	public int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}

	public double distance(Point p1) {
		int dx = x - p1.x;
		int dy = y - p1.y;

		return Math.sqrt(dx * dx + dy * dy);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if (p.x == this.x && p.y == this.y)
				return true;
			else
				return false;
		} else
			return false;
	}

	public String toString() {
		return "Point [x= " + x + " , y= " + y + " , selected= " + selected + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getX() - 2, this.getY(), this.getX() + 2, this.getY());
		g.drawLine(this.getX(), this.getY() - 2, this.getX(), this.getY() + 2);
		if (isSelected() == true) {
			g.setColor(Color.black);
			g.drawRect(this.getX() - 3, this.getY() - 3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		return distance(new Point(x, y)) <= 3;
	}
	@Override
	public void move(int newX, int newY) {
		this.x = newX;
		this.y = newY;
	}

	@Override
	public void DialogEdit() {
		DigPoint digPoint = new DigPoint();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				digPoint.getTxtXCoord().setText(split[2]);
				digPoint.getTxtYCoord().setText(split[5]);
			}
		}
		digPoint.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {

	}
	

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}