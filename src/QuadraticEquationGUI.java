import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class QuadraticEquationGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1739961653189121420L;
	private static final int NUMBEROFCOLUMNS = 5;
	private JTextField jtfCoeffA;
	private JTextField jtfCoeffB;
	private JTextField jtfCoeffC;
	private JPanel jpMainPanel;
	private JPanel jpSubPanelUpper;
	private JButton jbSolve;
	private double discriminant;
	private JLabel jlSolution;
	
	public QuadraticEquationGUI() {
		setTitle("Quadratic Equation Solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setComponents();
		pack();
	}
	
	public void setComponents() {
		jpMainPanel = new JPanel(new GridLayout(8,2));
		jpSubPanelUpper = new JPanel();
		jtfCoeffA = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffA);
		jpSubPanelUpper.add(new JLabel("x^2 + "));
		jtfCoeffB = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffB);
		jpSubPanelUpper.add(new JLabel("x +"));
		jtfCoeffC = new JTextField(NUMBEROFCOLUMNS);
		jpSubPanelUpper.add(jtfCoeffC);
		jpSubPanelUpper.add(new JLabel("= 0"));
		jpMainPanel.add(jpSubPanelUpper);
		jbSolve = new JButton("Solve!");
		jbSolve.addActionListener(this);
		jpMainPanel.add(jbSolve);
		jlSolution = new JLabel("");
		jpMainPanel.add(jlSolution);
		jtfCoeffA.setText("0");
		jtfCoeffB.setText("0");
		jtfCoeffC.setText("0");
		this.add(jpMainPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double a = Integer.parseInt(jtfCoeffA.getText());
		double b = Integer.parseInt(jtfCoeffB.getText());
		double c = Integer.parseInt(jtfCoeffC.getText());
		discriminant = (b * b) - (4 * a * c);
		if (discriminant >= 0){
			discriminant = Math.sqrt(discriminant);
			String answer = "x = " + (-b + discriminant)/(2 * a);
			answer = answer + " or x = " + (-b - discriminant)/(2 * a);
			jlSolution.setText(answer);
		}
		else {
			jlSolution.setText("There are no real roots for your equation!");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new QuadraticEquationGUI().setVisible(true);
			}
		});
	}
}
