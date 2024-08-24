package drawing;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class DrawingTest extends JFrame {
	
	public void paint(Graphics g) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		Point p1 = new Point(50, 50, false);
		p1.draw(g);

		Point p2 = new Point(70, 50, true);
		p2.draw(g);

		Line l1 = new Line(new Point(50, 100), new Point(250, 100), false);
		l1.draw(g);

		Line l2 = new Line(new Point(350, 100), new Point(550, 100), true);
		l2.draw(g);

		Rectangle r1 = new Rectangle(new Point(50, 200), 100, 70, false);
		r1.draw(g);

		Rectangle r2 = new Rectangle(new Point(200, 200), 100, 70, true);
		r2.draw(g);

		Circle c1 = new Circle(new Point(100, 400), 50, false);
		c1.draw(g);

		Circle c2 = new Circle(new Point(250, 400), 50, true);
		c2.draw(g);

		Donut d1 = new Donut(new Point(500, 400), 80, 50, false);
		d1.draw(g);

		Donut d2 = new Donut(new Point(700, 400), 80, 50, true);
		d2.draw(g);

		
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingTest frame = new DrawingTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DrawingTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
