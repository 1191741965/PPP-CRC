import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Jframe extends JDialog {
	private static final long UID = 1L;
	
	public Jframe() {
		this.setTitle("CRCУ��");
		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		JLabel label1 = new JLabel("                                                                                                                                        PPPУ��                                                                                                                                        ");
		JLabel label2 = new JLabel("PPP�е�FCS 	(������)��");
		JLabel label3 = new JLabel("CRCУ������	(������)��");
		JTextField textPPP = new JTextField(15);
		JTextField textCRC = new JTextField(15);
		JTextArea area = new JTextArea(10, 20);
		JLabel label4 = new JLabel("                                                                                                                                        ������                                                                                                                                       ");
		JButton button = new JButton("����������");
		
		container.add(BorderLayout.NORTH,label1);
		container.add(BorderLayout.CENTER,label2);	container.add(textPPP);
		container.add(label3);	container.add(textCRC);
		container.add(button);
		container.add(label4);
		container.add(area);
		this.setSize(250, 350);
		//���ô��ھ���
		this.setLocationRelativeTo(null);
		//���ô��ڲ����϶�
		this.setResizable(false);
		//���ô�����ʾ
		this.setVisible(true);
		//���ô��ڹر�
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pppString = textPPP.getText();
				String crcString = textCRC.getText();
				String mycode = getString(pppString, crcString);
				area.setText(mycode);
			}
		});
	}
	public String getString(String pppString, String crcString) {
		int pppInt = Integer.parseInt(pppString);
		ArrayTool arrayTool = new ArrayTool();
		int pppLength = arrayTool.setPppLength(pppString);
		int crcArrayLength = arrayTool.setCrcLength(crcString);
		int pppArrayLength = pppLength + crcArrayLength-1;
		int [] pppArray = arrayTool.setPppToArray(pppString, crcString);
		int [] crcArray = arrayTool.setCrcToArray(crcString);
		CRCTool crcTool = new CRCTool();
		String crcCode  = crcTool.setCrcCode(pppArray, crcArray, pppArrayLength, crcArrayLength);
		return crcCode;
	}
	public static void main(String[] args) {
		new Jframe();
	}
}
