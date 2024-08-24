package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Shape;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DigCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	private JTextField txtRadius;
	public boolean isOk;
	private Color outline = Color.BLACK;
	private Color fill = Color.WHITE;
	public boolean OutLineBoolean;
	public boolean FillBoolean;
	

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
	
	public Color getOutline() {
		return outline;
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
			DigCircle dialog = new DigCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigCircle() {
		setTitle("Bojana Boskovic IM-113-2020");
		setModal(true);
		setBounds(100, 100, 450, 300);
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

		JLabel lblNewLabel3 = new JLabel("X coordinate:");

		JLabel lblNewLabel_2 = new JLabel("Radius:");

		JLabel lblNewLabel = new JLabel("Y coordinate:");

		JButton btnFill = new JButton("Fill color");
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fill = JColorChooser.showDialog(null, "Choose color", Color.WHITE);
				FillBoolean = true;
			}
		});

		JButton btnOutlineColor = new JButton("Outline color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outline = JColorChooser.showDialog(null, "Choose color", Color.BLACK);
				OutLineBoolean = true;

			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCenter
				.createSequentialGroup().addGap(72)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnlCenter.createSequentialGroup()
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel3)
										.addComponent(lblNewLabel_2).addComponent(lblNewLabel))
								.addGap(18)
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtYCoord, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
										.addComponent(txtXCoord).addComponent(txtRadius)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
								.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 108,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(btnFill, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGap(143)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(39)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel3))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
						.addGap(18)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
						.addGap(18).addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOutlineColor).addComponent(btnFill))
						.addContainerGap(42, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel pnlBtn = new JPanel();
			pnlBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBtn, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()
								|| txtRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "You need to fill in all blank spaces", "Error",
									JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							for (Shape shape : PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoord.getText()), Integer.parseInt(txtYCoord.getText()));
									((Circle) shape).setRadius(Integer.parseInt(txtRadius.getText()));
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
						}
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
}
