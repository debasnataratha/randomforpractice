package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class practice {
	public static void main(String args[]) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Debasnata Rath\\Documents\\Book1.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		//String value=book.getSheet("Sheet2").getRow(0).getCell(0).getStringCellValue();
		//System.out.println(value);
		//book.close();
		//write back data to excel
		Sheet sh=book.getSheet("Sheet2");
		Row row=sh.getRow(1);
		Cell cell=row.createCell(5,CellType.STRING);
		cell.setCellValue("PASS");
		book.close();
		System.out.println("code executed sucessfully");
		
	}

}
