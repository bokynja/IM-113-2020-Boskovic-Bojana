package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
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

public class DigDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	public boolean isOk;
	private Color outline = Color.BLACK;
	private Color fill = Color.WHITE;
	public boolean OutLineBoolean;
	public boolean FillBoolean;
	private JButton okButton;
	private JButton cancelButton;

	public Color getOutline() {
		return outline;
	}
	
	public void setOutline(Color outline) {
		this.outline = outline;
	}
	
	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
	
	public boolean isOutLineBoolean() {
		return OutLineBoolean;
	}
	
	public void setOutLineBoolean(boolean outLineBoolean) {
		OutLineBoolean = outLineBoolean;
	}
	
	public boolean isFillBoolean() {
		return FillBoolean;
	}

	public void setFillBoolean(boolean fillBoolean) {
		FillBoolean = fillBoolean;
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

//	public boolean isOk() {
//		return isOk;
//	}
//
//	public void setOk(boolean isOk) {
//		this.isOk = isOk;
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigDonut dialog = new DigDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigDonut() {
		setModal(true);
		setBounds(100, 100, 500, 400);
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
		txtRadius = new JTextField();
		txtRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtRadius.setColumns(10);
		txtInnerRadius = new JTextField();
		txtInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtInnerRadius.setColumns(10);
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		JLabel lblOuterRadius = new JLabel("Outer Radius:");
		JLabel lblInnerRadius = new JLabel("Inner Radius:");

		JButton btnFillColor = new JButton("Outline color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				OutLineBoolean = true;
			}
		});

		JButton btnNewButton_1 = new JButton("Fill color");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				FillBoolean = true;
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCenter
				.createSequentialGroup().addGap(73)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false).addGroup(gl_pnlCenter
						.createSequentialGroup()
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblXCoordinate)
								.addComponent(lblYCoordinate).addComponent(lblOuterRadius).addComponent(lblInnerRadius))
						.addGap(39)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtXCoord, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
								.addComponent(txtYCoord).addComponent(txtRadius).addComponent(txtInnerRadius)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
								.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap(123, Short.MAX_VALUE)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(38)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblXCoordinate))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYCoordinate))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOuterRadius))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerRadius))
						.addGap(18).addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnFillColor).addComponent(btnNewButton_1))
						.addContainerGap(105, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()
								|| txtRadius.getText().trim().isEmpty() || txtInnerRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "You need to fill in all blank spaces", "Error",
									JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							if (Integer.parseInt(txtRadius.getText()) > (Integer.parseInt(txtInnerRadius.getText()))) {
								for (Shape shape : PnlDrawing.shapesArrList) {
									if (shape.isSelected()) {
										shape.move(Integer.parseInt(txtXCoord.getText()),
												Integer.parseInt(txtYCoord.getText()));
										((Donut) shape).setRadius(Integer.parseInt(txtRadius.getText()));
										((Donut) shape).setInnerRadius(Integer.parseInt(txtInnerRadius.getText()));
										if (isOutLineBoolean() == true) {
											shape.setOutline(outline);
											setOutLineBoolean(false);
										}
										if (isFillBoolean() == true) {
											shape.setFill(fill);
											setFillBoolean(false);
										}
									}
								}
								isOk = true;
								dispose();
							} else {
								isOk = false;
								JOptionPane.showMessageDialog(null, "Inner radius must be smaller than outer radius.",
										"Error", JOptionPane.ERROR_MESSAGE);
							}

						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_pnlBtn = new GroupLayout(pnlBtn);
			gl_pnlBtn.setHorizontalGroup(
				gl_pnlBtn.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlBtn.createSequentialGroup()
						.addGap(362)
						.addComponent(okButton)
						.addGap(5)
						.addComponent(cancelButton))
			);
			gl_pnlBtn.setVerticalGroup(
				gl_pnlBtn.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlBtn.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_pnlBtn.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton)))
			);
			pnlBtn.setLayout(gl_pnlBtn);
		}
	}

}
