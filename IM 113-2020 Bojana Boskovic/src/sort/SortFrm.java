package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

public class SortFrm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<Circle> arrayCircle = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrm frame = new SortFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SortFrm() {
		setTitle("Boskovic Bojana, IM-113-2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
					.addContainerGap())
		);
		JList list = new JList();
		list.setModel(dlm);
		
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("Add");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SortDig sortDig = new SortDig();
						sortDig.setVisible(true);
						if (sortDig.isOk == true) {
							Circle c = new Circle(
									new Point(Integer.parseInt(sortDig.getTxtXCoord().getText()),
											(Integer.parseInt(sortDig.getTxtYCoord().getText()))),
									Integer.parseInt(sortDig.getTxtRadius().getText()));
							arrayCircle.add(c);
							Collections.sort(arrayCircle);
							dlm.add(arrayCircle.indexOf(c), "X: " + c.getCenter().getX() + " , Y: " + c.getCenter().getY()
									+ " , Radius " + c.getRadius());
						}
					}
				});
				
			
				JButton removeButton = new JButton("Remove");
				removeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(dlm.isEmpty()) {
							JOptionPane.showMessageDialog(null, "The list is empty", "Error", JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						}
						SortDig sortDigDel = new SortDig();
						String[] split = dlm.firstElement().toString().split(" ");
						sortDigDel.getTxtXCoord().setText(split[1]);
						sortDigDel.getTxtYCoord().setText(split[4]);
						sortDigDel.getTxtRadius().setText(split[7]);
						sortDigDel.getTxtXCoord().setEditable(false);
						sortDigDel.getTxtYCoord().setEditable(false);
						sortDigDel.getTxtRadius().setEditable(false);
						sortDigDel.setVisible(true);
						if(sortDigDel.isDelete()==true) {
							arrayCircle.remove(0);
							dlm.removeElementAt(0);
							}
					}
				});
				
				GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
				gl_buttonPane.setHorizontalGroup(
					gl_buttonPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_buttonPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(okButton)
							.addGap(108)
							.addComponent(removeButton)
							.addContainerGap(186, Short.MAX_VALUE))
				);
				gl_buttonPane.setVerticalGroup(
						gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(okButton)
									.addComponent(removeButton)))
				);
				
				buttonPane.setLayout(gl_buttonPane);
			
			
		

	}
}
