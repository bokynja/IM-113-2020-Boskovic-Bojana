package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Shape;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DigPoint extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private Color outline = Color.BLACK;
	private boolean OutLineBoolean;

	public boolean isOutLineBoolean() {
		return OutLineBoolean;
	}

	public void setOutLineBoolean(boolean outLineBoolean) {
		OutLineBoolean = outLineBoolean;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigPoint dialog = new DigPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigPoint() {
		setModal(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		txtXCoord = new JTextField();
		txtXCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtXCoord.setColumns(10);
		txtYCoord = new JTextField();
		txtYCoord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtYCoord.setColumns(10);
		JLabel lblNewLabel = new JLabel("X Coordinate:");
		JLabel lblNewLabel_1 = new JLabel("Y Coordinate:");

		JButton btnOutline = new JButton("Outline color");
		btnOutline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				OutLineBoolean = true;
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCenter
				.createSequentialGroup().addGap(68)
				.addGroup(gl_pnlCenter
						.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel).addComponent(lblNewLabel_1))
				.addGap(46)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnOutline, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(txtXCoord, Alignment.LEADING)
						.addComponent(txtYCoord, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
				.addContainerGap(89, Short.MAX_VALUE)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(39)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
						.addGap(18).addComponent(btnOutline).addContainerGap(80, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			pnlBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Enter in all values!", "Error",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							for (Shape shape : PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									shape.move(Integer.parseInt((txtXCoord).getText()),
											Integer.parseInt((txtYCoord).getText()));
									if (OutLineBoolean == true) {
										shape.setOutline(outline);
										OutLineBoolean = false;
									}
								}
							}
						}
						dispose();
						return;
					}
				});
				okButton.setActionCommand("OK");
				pnlBtn.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				pnlBtn.add(cancelButton);
			}
		}
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setTxtXCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}
}
