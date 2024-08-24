package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DigRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel pnlCenter = new JPanel();
	private JTextField txtXCoord;
	private JTextField txtYCoord;
	public boolean isOk;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private Color outline = Color.BLACK;
	private Color fill = Color.WHITE;
	private boolean OutLineBoolean;
	private boolean FillBoolean;

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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtXCoord() {
		return txtXCoord;
	}

	public void setxCoord(JTextField txtXCoord) {
		this.txtXCoord = txtXCoord;
	}

	public JTextField getTxtYCoord() {
		return txtYCoord;
	}

	public void setTxtYCoord(JTextField txtYCoord) {
		this.txtYCoord = txtYCoord;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DigRectangle dialog = new DigRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DigRectangle() {
		setModal(true);
		setBounds(100, 100, 380, 420);
		getContentPane().setLayout(new BorderLayout());
		pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCenter, BorderLayout.CENTER);
		{
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
		}

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

		JLabel lblNewLabel = new JLabel("X coordinate:");

		JLabel lblNewLabel_1 = new JLabel("");

		JLabel lblNewLabel_2 = new JLabel("Y coordinate:");

		JLabel lblNewLabel_3 = new JLabel("Width:");

		JLabel lblNewLabel_4 = new JLabel("Height:");

		txtWidth = new JTextField();
		txtWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtWidth.setColumns(10);

		txtHeight = new JTextField();
		txtHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		txtHeight.setColumns(10);

		JButton btnNewButton = new JButton("Outline color");
		btnNewButton.addActionListener(new ActionListener() {
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
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnlCenter.createSequentialGroup().addGap(27).addGroup(gl_pnlCenter
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addGroup(gl_pnlCenter.createSequentialGroup()
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4))
								.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
								.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtHeight).addComponent(txtWidth).addComponent(txtYCoord)
										.addGroup(gl_pnlCenter.createSequentialGroup()
												.addComponent(txtXCoord, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))))
						.addGap(30)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlCenter
				.createSequentialGroup().addGap(62)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
				.addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2))
				.addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3).addComponent(
						txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4).addComponent(
						txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
				.addContainerGap(101, Short.MAX_VALUE)));
		pnlCenter.setLayout(gl_pnlCenter);
		{
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(btnPanel, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()
								|| txtWidth.getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "You need to fill all values", "Error",
									JOptionPane.ERROR_MESSAGE);
							getToolkit().beep();
						} else {
							for (Shape shape : PnlDrawing.shapesArrList) {
								if (shape.isSelected()) {
									shape.move(Integer.parseInt(txtXCoord.getText()), Integer.parseInt(txtYCoord.getText()));
									((Rectangle) shape).setWidth(Integer.parseInt(txtWidth.getText()));
									((Rectangle) shape).setHeight(Integer.parseInt(txtHeight.getText()));
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
				btnPanel.add(okButton);
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
				btnPanel.add(cancelButton);
			}
		}
	}
}
