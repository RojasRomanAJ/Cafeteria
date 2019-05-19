package excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {


	public static void main(String[] args) {
		
		crearExcel();

	}
	
	public static void crearExcel() {
		
		Sheet sheet = (Sheet<?, ?>) new XSSFWorkbook().createSheet("Hola Java");
		String ruta = "C:\\Users\\Rojas\\Documents\\Cafeteria\\cafeteria\\src\\excel\\Excel.xlsx";
		try {
			FileOutputStream fileout = new FileOutputStream(ruta);
			new XSSFWorkbook().write(fileout);
			fileout.close();
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
