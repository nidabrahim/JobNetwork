package Models.Utilitaire;
import Models.Beans.Etudiant;
import java.io.IOException;
import java.util.List;

public class TestReadExcel {

	public TestReadExcel() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws IOException {
		/*
		 * Replace the file path in your code..
		 */
		String excelFilePath = "etudiants.xlsx";
		List<Etudiant> subjects = ReadExcelUtils.lireUneFichierXlsx_xls(excelFilePath);

		System.out.println(subjects);

	}

}
