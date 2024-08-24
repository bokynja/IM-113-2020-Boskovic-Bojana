package stack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StackDig extends JDialog {
	
    private static final long serialVersionUID = 1L;
    private final JPanel pnlCenter = new JPanel();
    private JButton okButton;
    private JButton cancelButton;
    private JTextField txtXCoord;
    private JTextField txtYCoord;
    private JTextField txtRadius;

    public boolean isOk;
    public boolean delete;
    

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            StackDig stackDig = new StackDig();
            stackDig.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            stackDig.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public StackDig() {
    	setModal(true);
        setBounds(100, 100, 450, 300);
        pnlCenter.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlCenter, BorderLayout.CENTER);

        txtXCoord = new JTextField();
        txtXCoord.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
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
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
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
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    getToolkit().beep();
                }
            }
        });
        txtRadius.setColumns(10);

        JLabel XCordLbl = new JLabel("X Coordinate: ");
        JLabel YCoordLbl = new JLabel("Y Coordinate:");
        JLabel RadiusLbl = new JLabel("Radius:");

        GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
        gl_pnlCenter.setHorizontalGroup(
        	gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnlCenter.createSequentialGroup()
        			.addGap(33)
        			.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
        				.addComponent(YCoordLbl)
        				.addComponent(XCordLbl)
        				.addComponent(RadiusLbl))
        			.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnlCenter.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(txtXCoord, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(gl_pnlCenter.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtRadius, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        						.addComponent(txtYCoord, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        					.addContainerGap())))
        );
        gl_pnlCenter.setVerticalGroup(
        	gl_pnlCenter.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnlCenter.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
        				.addComponent(XCordLbl)
        				.addComponent(txtXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
        				.addComponent(YCoordLbl)
        				.addComponent(txtYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
        				.addComponent(RadiusLbl)
        				.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(116, Short.MAX_VALUE))
        );
        pnlCenter.setLayout(gl_pnlCenter);

        JPanel pnlBtn = new JPanel();
        getContentPane().add(pnlBtn, BorderLayout.SOUTH);

        okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtXCoord.getText().trim().isEmpty() || txtYCoord.getText().trim().isEmpty()
                        || txtRadius.getText().trim().isEmpty()) {
                    isOk = false;
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "You need to fill in all blank spaces", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    isOk = true;
                    setDelete(true);
                    dispose();
                }
            }
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                setDelete(false);
            }
        });

        GroupLayout gl_pnlBtn = new GroupLayout(pnlBtn);
        gl_pnlBtn.setHorizontalGroup(
            gl_pnlBtn.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pnlBtn.createSequentialGroup()
                    .addGap(312)
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

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
    }

	public boolean isDelete() {
		return delete;
	}
	
	public void setDelete(boolean delete) {
		this.delete = delete;
	}

}
