package geometry;

import java.awt.Color;
import java.awt.Graphics;
import drawing.DigRectangle;
import drawing.PnlDrawing;

public class Rectangle extends Shape {
	
	private Point upperLeftPoint;
	private int width; 
	private int height;
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Rectangle() {
		super();
	}
	public Rectangle(Point upperLeftPoint, int width, int height) {
		super();
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		super();
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		setSelected(selected);
	}

	public String toString() {
		return "Rectangle [ulp= " +upperLeftPoint + " , width= " + width + " , height=" + height + " , selected= " + isSelected() + "]";
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.setColor(Color.black);
		g.drawRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.getHeight());
		if (isSelected() == true) {
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.getWidth() - 3, this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() + this.getHeight() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + this.getWidth() - 3,
					this.getUpperLeftPoint().getY() + this.getHeight() - 3, 6, 6);
		}

		
		
	}
	@Override
	public boolean contains(int x, int y) {
		return (this.getUpperLeftPoint().getX() <= x && x <= this.getUpperLeftPoint().getX() + width
				&& this.getUpperLeftPoint().getY() <= y && y <= this.getUpperLeftPoint().getY() + height);

	}
	@Override
	public void move(int newX, int newY) {
		upperLeftPoint.move(newX, newY);
	}

	@Override
	public void DialogEdit() {
		DigRectangle digRectangle = new DigRectangle();
		for (Shape shape : PnlDrawing.shapesArrList) {
			if (shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				digRectangle.getTxtXCoord().setText(split[4]);
				digRectangle.getTxtYCoord().setText(split[7]);
				digRectangle.getTxtWidth().setText(split[13]);
				digRectangle.getTxtHeight().setText(split[16]);
			}
		}
		digRectangle.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.getHeight());
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
