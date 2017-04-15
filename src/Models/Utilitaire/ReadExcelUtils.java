package Models.Utilitaire;

import Models.Beans.Etudiant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtils {
	public ReadExcelUtils() {
		// TODO Auto-generated constructor stub
	}

	private static Workbook getWorkbook(FileInputStream inputStream,
			String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException(
					"The specified file is not Excel file");
		}

		return workbook;
	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	private static FileInputStream getInputStreamFromExcelFile(String excelFilePath) {
            File file = new File(excelFilePath);	
            FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("\n Error while getting a Input Stream from the Excel file "+e.getMessage());
			
		}
		return inputStream;
	}

	public static List<Etudiant> lireUneFichierXlsx_xls(String excelFilePath) throws IOException {

		List<Etudiant> listEtudiants = new ArrayList<>();
		FileInputStream inputStream = getInputStreamFromExcelFile(excelFilePath);

		Workbook workbook = getWorkbook(inputStream, excelFilePath);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {

			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Etudiant etudiant = new Etudiant();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					etudiant.setNom_etudiant((String) getCellValue(nextCell));
					break;
				case 1:
					etudiant.setPrenom_etudiant((String) getCellValue(nextCell));
					break;
                                case 2:
					etudiant.setEmail_etudiant((String) getCellValue(nextCell));
					break;
				}
			}

			listEtudiants.add(etudiant);
		}

		
		inputStream.close();

		return listEtudiants;

	}
}
