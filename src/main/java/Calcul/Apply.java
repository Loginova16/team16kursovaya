package Calcul;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Apply implements ActionListener {
	public static File file;
	public static String k1;
	public static PrintWriter writer;
	@Override
	public void actionPerformed(ActionEvent arg0) {

	file = new File("prem.txt");

	k1 = admin.log.getText();	
	try {
		writer = new PrintWriter(file, "UTF-8");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		writer.println(k1);
		writer.close();
		System.out.println("Операция прошла успешно");

}
}
