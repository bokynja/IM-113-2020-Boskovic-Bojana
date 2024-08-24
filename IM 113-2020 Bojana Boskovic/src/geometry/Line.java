package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DigLine;
import drawing.PnlDrawing;


public class Line extends Shape {
	private Point start;
	private Point end;
	
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}

	public Line() {
		
	}
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	public Line(Point start, Point end, boolean selected) {
		this.start = start;
		this.end = end;
		setSelected(selected);
	}
	
	public String toString() {
		return "Line [start=" + start + " , end= " + end + isSelected() + "]";
	}
	
	public Point middleOfLine() {
		int middleX = (this.getStart().getX() + this.getEnd().getX())/2;
		int middleY = (this.getStart().getY() + this.getEnd().getY())/2;
		Point middle = new Point (middleX, middleY);
		return middle;
		}
	public double length() {
		return start.distance(end); 
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(),
				this.getEnd().getY());
		if (isSelected() == true) {
			g.setColor(Color.black);

			g.drawRect(this.getStart().getX() - 3, this.getStart().getY() - 3, 6, 6);
			g.drawRect(this.getEnd().getX() - 3, this.getEnd().getY() - 3, 6, 6);
			g.drawRect(this.middleOfLine().getX() - 3, this.middleOfLine().getY() - 3, 6, 6);
		}

	}
	@Override
	public boolean contains(int x, int y) {
		Point click  = new Point(x,y);
		return (start.distance(click) + end.distance(click)) - length() < 0.1;
	}
	@Override
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DialogEdit() {
		DigLine digLine = new DigLine();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				digLine.getTxtXStart().setText(split[4]);
				digLine.getTxtYStart().setText(split[7]);
				digLine.getTxtXEnd().setText(split[15]);
				digLine.getTxtYEnd().setText(split[18]);
			}
		}
		digLine.setVisible(true);
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