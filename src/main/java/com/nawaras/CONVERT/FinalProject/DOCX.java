package com.nawaras.CONVERT.FinalProject;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.spire.doc.Document;
import com.spire.doc.ToPdfParameterList;

public class DOCX extends JFrame{


	public JLabel label;

	public String userName ;
	public	 String pathh;
	
	public	String filename;
public	String filename1;
public  JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DOCX window = new DOCX();
					window.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DOCX() {
		
	
		setBounds(800, 150, 550, 400);
		setTitle("ConVe App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("DOCX to .pdf");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setBounds(182, 27, 266, 29);
	getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 129, 370, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("OPEN");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userName = new com.sun.security.auth.module.NTSystem().getName();
				  pathh="C:\\Users\\"+userName+"\\Desktop";
				JFileChooser jc= new JFileChooser(pathh);
				jc.showOpenDialog(null);
				File f= jc.getSelectedFile();
				filename =f.getAbsolutePath();
				
				textField.setText(filename);
				
				
			}
		});
		btnNewButton.setBounds(407, 128, 85, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Convert to PDF");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String real;
				int len=filename.length();

				char cha=filename.charAt(len-4);
				
				if(cha=='d') {
	
					real=filename.replace(".docx", ".pdf");
	
				}else {
	
					real=filename.replace(".txt", ".pdf");
	
				}

				try {
					
					String pdfFil=filename+".pdf";
					Document doc = new Document();
				    doc.loadFromFile(filename);
				    ToPdfParameterList ppl=new ToPdfParameterList();
				    ppl.isEmbeddedAllFonts(true);
				    ppl.setDisableLink(true);
				    doc.setJPEGQuality(40);

	 	        doc.saveToFile(real, ppl);
	 	       
	  	      
	  	      
	 	 	     JOptionPane jop= new JOptionPane ();
	 	 	     
	 	 	    jop.showMessageDialog(null,"Converted");
	 	 	    
				}catch(Exception error) {
					 JOptionPane.showMessageDialog(null,"Invalid");
					 System.out.println("the error is"+error);
					 
				}
				clear();

				
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(158, 186, 122, 30);
		getContentPane().add(btnNewButton_2);
		JButton btnNewButton_23 = new JButton("For for .TXT next Page >>");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(true);
				TEXTtopdf dn=new TEXTtopdf();
				dn.setVisible(true);
							
				  dispose(); 
			}
		});
		
		
		
		btnNewButton_23.setForeground(SystemColor.desktop);
		btnNewButton_23.setBounds(114, 238, 199, 30);
		
		
		getContentPane().add(btnNewButton_23);
		
	}

	
	
	public  void clear() {
		
		
		try {
			textField.setText(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
