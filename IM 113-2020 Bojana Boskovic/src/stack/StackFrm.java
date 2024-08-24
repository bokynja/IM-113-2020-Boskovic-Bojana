package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.util.Stack;

import geometry.Circle;
import geometry.Point;

public class StackFrm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtXCoord;
    private JTextField txtYCoord;
    private JTextField txtRadius;

    private boolean isOk = false;

    DefaultListModel<String> dlm = new DefaultListModel<String>();
    Stack<Circle> stack = new Stack<Circle>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StackFrm frame = new StackFrm();
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
    public StackFrm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Boskovic Bojana, IM-113-2020");

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel pnl_center = new JPanel();
        contentPane.add(pnl_center, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_pnl_center = new GroupLayout(pnl_center);
        gl_pnl_center.setHorizontalGroup(
            gl_pnl_center.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_pnl_center.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        gl_pnl_center.setVerticalGroup(
            gl_pnl_center.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pnl_center.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE))
        );

        JList<String> list = new  JList<String>();
        list.setModel(dlm);
        scrollPane.setViewportView(list);
        pnl_center.setLayout(gl_pnl_center);

        JPanel pnlDown = new JPanel();
        contentPane.add(pnlDown, BorderLayout.SOUTH);

        txtXCoord = new JTextField();
        txtXCoord.setColumns(10);
        txtYCoord = new JTextField();
        txtYCoord.setColumns(10);
        txtRadius = new JTextField();
        txtRadius.setColumns(10);

        JLabel lblXCoord = new JLabel("X Coord:");
        JLabel lblYCoord = new JLabel("Y Coord:");
        JLabel lblRadius = new JLabel("Radius:");



        JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDig stackDig = new StackDig();
				stackDig.setVisible(true);
				if (stackDig.isOk == true) {
					Circle c = new Circle( 
							new Point(Integer.parseInt(stackDig.getTxtXCoord().getText()),
							(Integer.parseInt(stackDig.getTxtYCoord().getText()))),
							Integer.parseInt(stackDig.getTxtRadius().getText()));
					stack.push(c);
					dlm.add(0, "X: " + c.getCenter().getX() + " , Y: " + c.getCenter().getY() + " , Radius: "
							+ c.getRadius());
					System.out.println(stack);
				}
			}
		});

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (dlm.isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Nothing to remove", "Error", JOptionPane.ERROR_MESSAGE);
                	getToolkit().beep();
                } 
                	StackDig stackDigDelete = new StackDig();
                	String[] split = dlm.firstElement().toString().split(" ");
                	stackDigDelete.getTxtXCoord().setText(split[1]);
    				stackDigDelete.getTxtYCoord().setText(split[4]);
    				stackDigDelete.getTxtRadius().setText(split[7]);
    				stackDigDelete.getTxtXCoord().setEditable(false);
    				stackDigDelete.getTxtYCoord().setEditable(false);
    				stackDigDelete.getTxtRadius().setEditable(false);
    				stackDigDelete.setVisible(true);
    				if (stackDigDelete.isDelete() == true) {
    					stack.pop();
    					dlm.removeElementAt(0);
    				}
                }
        });

        GroupLayout gl_pnlDown = new GroupLayout(pnlDown);
        gl_pnlDown.setHorizontalGroup(
            gl_pnlDown.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pnlDown.createSequentialGroup()
                    .addGap(46)
                    .addComponent(btnAdd)
                    .addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                    .addComponent(btnRemove)
                    .addGap(90))
        );
        gl_pnlDown.setVerticalGroup(
            gl_pnlDown.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_pnlDown.createSequentialGroup()
                    .addGroup(gl_pnlDown.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnRemove))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDown.setLayout(gl_pnlDown);
    }
}
