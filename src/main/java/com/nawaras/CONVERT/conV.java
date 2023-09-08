package com.nawaras.CONVERT;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import com.spire.doc.Document;
import com.spire.doc.ToPdfParameterList;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class conV {

	JFrame frame;
	private static JTextField textField;
	private JButton btnNewButton_1;
	
	private JLabel label;
	
private	String filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					conV window = new conV();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
								
	}

	/**
	 * Create the application.
	 */
	public conV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JFileChooser jc= new JFileChooser();
				jc.showOpenDialog(null);
				File f= jc.getSelectedFile();
				filename =f.getAbsolutePath();
				
				textField.setText(filename);
											
			}
		});
		btnNewButton.setBounds(391, 20, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 21, 371, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Convert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
												
				String real;
								int len=filename.length();
				
				char cha=filename.charAt(len-4);
								
				if(cha=='d') {
					
					real=filename.replace(".docx", ".pdf");
					
				}else {
					
					real=filename.replace(".txt", ".pdf");
					
				}
			
				String pdfFil=filename+".pdf";
				 Document doc = new Document();
	    	        doc.loadFromFile(filename);
	    	        ToPdfParameterList ppl=new ToPdfParameterList();
	    	        ppl.isEmbeddedAllFonts(true);
	    	        ppl.setDisableLink(true);
	    	        doc.setJPEGQuality(40);
	    	
	    	     	        doc.saveToFile(real, ppl);
	    	     	      clear();
	    	     	      
	    	     	      
	    	     	     JOptionPane jop= new JOptionPane ();
	    	     	     
	    	     	    jop.showMessageDialog(null,"Converted");
    	      	  
;				
			}
		});
		btnNewButton_1.setBounds(122, 130, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		

}
	public static void clear() {
		
		
			try {
				textField.setText(null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
