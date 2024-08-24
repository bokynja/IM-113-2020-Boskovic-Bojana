package drawing;

import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel implements MouseListener {
	

static int obj = 0;
public int mx;
public int my;
public static ArrayList<Shape> shapesArrList = new ArrayList<Shape>();
private Point startLine = null;
Point endLine;


public PnlDrawing() {
	addMouseListener(this);
}



@Override
public void mouseClicked(MouseEvent e) {
	mx = e.getX();
	my = e.getY();


		switch (obj) {
		
		
		case 1:
			Point p = new Point(mx, my, false);
			p.setOutline(DrawingFrm.outline);
			shapesArrList.add(p);
			System.out.println(shapesArrList);
			break;
		case 2:
			if (startLine == null) {
				startLine = new Point(mx, my);
			} else {
				Point endLine = new Point(mx, my);
				Line line = new Line(startLine, endLine, false);
				line.setOutline(DrawingFrm.outline);
				shapesArrList.add(line);
				startLine = null;
			}
			break;
		case 3:
			DigRectangle digRectangle = new DigRectangle();
			digRectangle.getTxtXCoord().setText(String.valueOf(mx));
			digRectangle.getTxtXCoord().setEditable(false);
			digRectangle.getTxtYCoord().setText(String.valueOf(my));
			digRectangle.getTxtYCoord().setEditable(false);
			digRectangle.setVisible(true);
			if (digRectangle.isOk == true) {
				Rectangle r = new Rectangle(new Point(mx, my), Integer.parseInt(digRectangle.getTxtWidth().getText()),
						Integer.parseInt(digRectangle.getTxtHeight().getText()), false);
				r.setOutline(DrawingFrm.outline);
				r.setFill(DrawingFrm.area);
				if(digRectangle.isOutLineBoolean()) {
					r.setOutline(digRectangle.getOutline());
				}
				if(digRectangle.isFillBoolean()) {
					r.setFill(digRectangle.getFill());
				}
				System.out.println(r);
				shapesArrList.add(r);
			}
			break;
			
		case 4:
			DigCircle digCircle = new DigCircle();
			digCircle.getTxtXCoord().setText(String.valueOf(mx));
			digCircle.getTxtYCoord().setText(String.valueOf(my));
			digCircle.getTxtXCoord().setEditable(false);
			digCircle.getTxtYCoord().setEditable(false);
			digCircle.setVisible(true);
			if (digCircle.isOk == true) {
				Circle c = new Circle(new Point(mx, my), Integer.parseInt(digCircle.getTxtRadius().getText()), false);
				c.setOutline(DrawingFrm.outline);
				c.setFill(DrawingFrm.area);
				if(digCircle.isOutLineBoolean()) {
					c.setOutline(digCircle.getOutline());
				}
				if(digCircle.isFillBoolean()) {
					c.setFill(digCircle.getFill());
				}
				shapesArrList.add(c);
			}
			break;
		case 5:
			DigDonut digDonut = new DigDonut();
			digDonut.getTxtXCoord().setText(String.valueOf(mx));
			digDonut.getTxtXCoord().setEditable(false);
			digDonut.getTxtYCoord().setText(String.valueOf(my));
			digDonut.getTxtYCoord().setEditable(false);
			digDonut.setVisible(true);
			if (digDonut.isOk == true) {
				Donut d = new Donut(new Point(mx, my), Integer.parseInt(digDonut.getTxtRadius().getText()),
						Integer.parseInt(digDonut.getTxtInnerRadius().getText()), false);
				d.setOutline(DrawingFrm.outline);
				d.setFill(DrawingFrm.area);
				if(digDonut.isOutLineBoolean()) {
					d.setOutline(digDonut.getOutline());
				}
				if(digDonut.isFillBoolean()) {
					d.setFill(digDonut.getFill());
				}
				shapesArrList.add(d);
			}
			break;
		case 6:
			boolean match = false;
			Collections.reverse(shapesArrList);
			for (Shape shape : shapesArrList) {
				shape.setSelected(false);
				if (match == false) {
					if (shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesArrList);
			break;
		}
	}

public void paint(Graphics g) {
	super.paint(g);
	for (Shape shape : shapesArrList) {
		shape.AreaPainter(g);
		shape.draw(g);
	}
	repaint();
}
//@Override
//protected void paintComponent(Graphics g) {
//    super.paintComponent(g);
//    for (Shape shape : shapesArrList) {
//        shape.draw(g);
//    }
//}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

}
