package com.nawaras.CONVERT;
import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class App 
{
    public static void main( String[] args )
    {
    	try {
            // Open the text file
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Mr.Nobody\\Desktop\\chat.txt"));
            // Create a new PDF document
            Document document = new Document();
            // Get the PDF writer
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Mr.Nobody\\Desktop\\chat.pdf"));
            // Open the document for writing
            document.open();
            // Read the text file line by line and add it to the PDF
            String line;
            while ((line = br.readLine()) != null) {
                document.add(new Paragraph(line));
            }
            // Close the document and the text file
            document.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
