package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import infixtopostfix.*;

public class Calculator extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;
		private JButton jbtDot;
		private JButton jbtNum1;
	    private JButton jbtNum2;
	    private JButton jbtNum3;
	    private JButton jbtNum4;
	    private JButton jbtNum5;
	    private JButton jbtNum6;
	    private JButton jbtNum7;
	    private JButton jbtNum8;
	    private JButton jbtNum9;
	    private JButton jbtNum0;
	    private JButton jbtEqual;
	    private JButton jbtAdd;
	    private JButton jbtSubtract;
	    private JButton jbtMultiply;
	    private JButton jbtDivide;
	    private JButton jbtPower;
	    private JButton jbtClear;
	    private JButton jbtLeftPar;
	    private JButton jbtRightPar;
	    private JTextField jtfResult;
	    private String display = "";
	public Calculator() {
		JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 4));
        p1.add(jbtClear = new JButton("C"));
        p1.add(jbtLeftPar = new JButton("("));
        p1.add(jbtRightPar = new JButton(")"));
        p1.add(jbtDivide = new JButton("/"));
        p1.add(jbtNum7 = new JButton("7"));
        p1.add(jbtNum8 = new JButton("8"));
        p1.add(jbtNum9 = new JButton("9"));
        p1.add(jbtMultiply = new JButton("*"));
        p1.add(jbtNum4 = new JButton("4"));
        p1.add(jbtNum5 = new JButton("5"));
        p1.add(jbtNum6 = new JButton("6"));
        p1.add(jbtSubtract = new JButton("-"));
        p1.add(jbtNum1 = new JButton("1"));
        p1.add(jbtNum2 = new JButton("2"));
        p1.add(jbtNum3 = new JButton("3"));
        p1.add(jbtAdd = new JButton("+"));
        p1.add(jbtNum0 = new JButton("0"));
        p1.add(jbtDot = new JButton("."));
        p1.add(jbtPower = new JButton("^"));
        p1.add(jbtEqual = new JButton("="));


        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(jtfResult = new JTextField(32));
        jtfResult.setHorizontalAlignment(JTextField.CENTER);
        jtfResult.setEditable(false);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(p2 , BorderLayout.NORTH);
        p.add(p1 , BorderLayout.CENTER);
        add(p);
        jbtDot.addActionListener(this);
		jbtNum1.addActionListener(this);
	    jbtNum2.addActionListener(this);
	    jbtNum3.addActionListener(this);
	    jbtNum4.addActionListener(this);
	    jbtNum5.addActionListener(this);
	    jbtNum6.addActionListener(this);
	    jbtNum7.addActionListener(this);
	    jbtNum8.addActionListener(this);
	    jbtNum9.addActionListener(this);
	    jbtNum0.addActionListener(this);
	    jbtEqual.addActionListener(this);
	    jbtAdd.addActionListener(this);
	    jbtSubtract.addActionListener(this);
	    jbtMultiply.addActionListener(this);
	    jbtDivide.addActionListener(this);
	    jbtPower.addActionListener(this);
	    jbtClear.addActionListener(this);
	    jbtLeftPar.addActionListener(this);
	    jbtRightPar.addActionListener(this);
        jbtDot.setActionCommand(".");
		jbtNum1.setActionCommand("1");
	    jbtNum2.setActionCommand("2");
	    jbtNum3.setActionCommand("3");
	    jbtNum4.setActionCommand("4");
	    jbtNum5.setActionCommand("5");
	    jbtNum6.setActionCommand("6");
	    jbtNum7.setActionCommand("7");
	    jbtNum8.setActionCommand("8");
	    jbtNum9.setActionCommand("9");
	    jbtNum0.setActionCommand("0");
	    jbtEqual.setActionCommand("=");
	    jbtAdd.setActionCommand("+");
	    jbtSubtract.setActionCommand("-");
	    jbtMultiply.setActionCommand("*");
	    jbtDivide.setActionCommand("/");
	    jbtPower.setActionCommand("^");
	    jbtClear.setActionCommand("C");
	    jbtLeftPar.setActionCommand("(");
	    jbtRightPar.setActionCommand(")");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if(c.equals("C")) display = "";
		else if(c.equals("=")){
			String postfix = InfixToPostfix.infixToPostfix(display); 
			System.out.println("Infix: "+ display);
			System.out.println("Postfix: "+ postfix);
			
		}
		else display += c;
		
		jtfResult.setText(display);
	}
}
