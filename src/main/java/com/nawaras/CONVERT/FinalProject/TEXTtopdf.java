package com.nawaras.CONVERT.FinalProject;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.spire.doc.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import com.itextpdf.text.Paragraph;

import com.spire.doc.ToPdfParameterList;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class TEXTtopdf extends JFrame{


	public static JTextField textField;
	public JButton btnNewButton_1;
	
	public JLabel label;

	public String userName ;
	public	 String pathh;
	
	public	String filename;
public	String filename1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TEXTtopdf window = new TEXTtopdf();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TEXTtopdf() {
		getContentPane().setForeground(new Color(0, 128, 128));
		setTitle("ConVe App");
		setBounds(800, 150, 550, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

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
		textField = new JTextField();
		textField.setBounds(10, 129, 370, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnNewButton_1 = new JButton("Convert to PDF");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				


		String real;
		
		int len=filename.length();
		
		char cha=filename.charAt(len-4);
		
		
			
			real=filename.replace(".txt", ".pdf");
			
		

		String pdfFil=filename+"Demo.pdf";
//     	     System.out.println(real);
//     	     System.out.println(pdfFil);
//     	     System.out.println(filename);

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
            JOptionPane.showMessageDialog(null,"Converted");
        } catch (Exception error) {
        	error.printStackTrace();
        	 JOptionPane.showMessageDialog(null,"Invalid");
        }
    	 clear();
	     	     
	     	           
		
					
				}
			});

		btnNewButton_1.setBounds(158, 186, 122, 30);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("TEXT to .pdf");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setBounds(182, 27, 266, 29);
		getContentPane().add(lblNewLabel);

	JButton btnNewButton_2 = new JButton("For for .DOCX next Page >>");
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		setVisible(true);
			DOCX dn=new DOCX();
			dn.setVisible(true);
			
			
			 dispose(); 
	//		
		}
			});
		btnNewButton_2.setForeground(SystemColor.desktop);
		btnNewButton_2.setBounds(114, 238, 199, 30);
		
		
		getContentPane().add(btnNewButton_2);
		
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
