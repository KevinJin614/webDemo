package day07;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChoosr implements ChangeListener{
	private JFrame jf;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JSlider js1;
	private JSlider js2;
	private JSlider js3;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextArea jta;
	
	public ColorChoosr() {
		jf=new JFrame();
		jl1=new JLabel("R:");
		jl2=new JLabel("G:");
		jl3=new JLabel("B:");
		js1=new JSlider(0,255,127);
		js2=new JSlider(0,255,127);
		js3=new JSlider(0,255,127);
		jtf1=new JTextField("127");
		jtf2=new JTextField("127");
		jtf3=new JTextField("127");
		jta=new JTextArea(5,10);
	}
	
	private void init(){
		JPanel jp1=new JPanel();
		jp1.add(jl1);
		jp1.add(js1);
		jp1.add(jtf1);
		
		jp1.add(jl2);
		jp1.add(js2);
		jp1.add(jtf2);
		
		jp1.add(jl3);
		jp1.add(js3);
		jp1.add(jtf3);
		
		JPanel jp2=new JPanel();
		jp2.add(jta);
		
		jf.add(jp1);
		jf.add(jp2,BorderLayout.EAST);
	}
	
	private void setStyle(){
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		jtf3.setEditable(false);
		jta.setBackground(new Color(127,127,127));
	}
	
	private void addEventHandler(){
		js1.addChangeListener(this);
		js2.addChangeListener(this);
		js3.addChangeListener(this);
	}
	
	public void show(){
		init();
		setStyle();
		addEventHandler();
		jf.setSize(380,180);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ColorChoosr().show();
	}

	public void stateChanged(ChangeEvent e) {
		int r=js1.getValue();
		int g=js2.getValue();
		int b=js3.getValue();
		
		jtf1.setText(r+"");
		jtf2.setText(g+"");
		jtf3.setText(b+"");
		
		jta.setBackground(new Color(r,g,b));
	}
	
	
	
}
