package com.nawaras.CONVERT;


import java.awt.EventQueue;
import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.spire.doc.ToPdfParameterList;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class TEXTT {

	private JFrame frame;
	private static JTextField textField;
	private JButton btnNewButton_1;
	
	private JLabel label;

	public String userName ;
	public	 String pathh;
	
private	String filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEXTT window = new TEXTT();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}

	public TEXTT() {
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
				
				userName = new com.sun.security.auth.module.NTSystem().getName();
				  pathh="C:\\Users\\"+userName+"\\Desktop";
				JFileChooser jc= new JFileChooser(pathh);
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


				String pdfFil=filename+"Demo.pdf";
//    	     	     System.out.println(real);
//    	     	     System.out.println(pdfFil);
//    	     	     System.out.println(filename);

		    	try {
		         
		            BufferedReader br = new BufferedReader(new FileReader(filename));
		        
		            Document document = new Document();
		         
		            PdfWriter.getInstance(document, new FileOutputStream(real));
		           
		            document.open();
		            
		            String line;
		            while ((line = br.readLine()) != null) {
		                document.add(new Paragraph(line));
		            }
		            // Close the document and the text file
		            document.close();
		            br.close();
		        } catch (Exception error) {
		        	error.printStackTrace();
		        }
				
				
	    	     	      
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
