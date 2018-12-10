package org.sid.view;

import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.sid.dao.UserRepository;
import org.sid.entities.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.view.document.AbstractXlsView;


@EnableJpaRepositories("org.sid.*")
public class ExcelView extends AbstractXlsView {

	@Autowired
	UserRepository userRepository;

	 
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
	                                  Workbook workbook,
	                                  HttpServletRequest request,
	                                  HttpServletResponse response) throws Exception {

	    // change the file name
	    response.setHeader("Content-Disposition", "attachment; filename=\"éditique.xls\"");

	    
//	    List<Users> users=new ArrayList<Users>();
//	    users= (List<Users>) userRepository.findAll();
	    @SuppressWarnings("unchecked")
	    List<Dossier> dossiersMoved = ( List<Dossier>) model.get("dossiersMoved");

	    // create excel xls sheet
	    Sheet sheet = workbook.createSheet("éditique");
	    sheet.setDefaultColumnWidth(30);

	    // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.BLUE.index);
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    font.setBold(true);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);
	 // create header row
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Utilisateur");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("Code Dossier");
	    header.getCell(1).setCellStyle(style);
	    header.createCell(2).setCellValue("Date Création");
	    header.getCell(2).setCellStyle(style);
	    header.createCell(3).setCellValue("Durée Legale(Ans)");
	    header.getCell(3).setCellStyle(style);
	    header.createCell(4).setCellValue("Boite");
	    header.getCell(4).setCellStyle(style);
	    header.createCell(5).setCellValue("Armoire");
	    header.getCell(5).setCellStyle(style);
	    header.createCell(6).setCellValue("Motif mouvement");
	    header.getCell(6).setCellStyle(style);
	    header.createCell(7).setCellValue("Date mouvement");
	    header.getCell(7).setCellStyle(style);
	    header.createCell(8).setCellValue("Date restitution");
	    header.getCell(8).setCellStyle(style);
	    header.createCell(9).setCellValue("Numéro Conteneur");
	    header.getCell(9).setCellStyle(style);
	    



	    int rowCount = 1;
	   // if (users != null)
	    	
	    	//if (users.size() > 0)

	    for(Dossier dossier : dossiersMoved){
	        Row dossierRow =  sheet.createRow(rowCount++);
	        dossierRow.createCell(0).setCellValue(dossier.getMvmntDossier().getUserMvmnt().getMatricule());
	        dossierRow.createCell(1).setCellValue(dossier.getCodeDossier());
	        dossierRow.createCell(2).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(dossier.getDateCreation()));
	        dossierRow.createCell(3).setCellValue(dossier.getDureeLegale());
	        dossierRow.createCell(4).setCellValue(dossier.getBoiteDossier().getCodeBoite());
	        dossierRow.createCell(5).setCellValue(dossier.getBoiteDossier().getArmoire().getCodeArmoire());
	        dossierRow.createCell(6).setCellValue(dossier.getMvmntDossier().getMotifMvmnt().getNomMotif());
	        dossierRow.createCell(7).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(dossier.getMvmntDossier().getDateMvmnt()));
	        dossierRow.createCell(8).setCellValue(new SimpleDateFormat("dd/MM/yyyy").format(dossier.getMvmntDossier().getDateRest()));
	        dossierRow.createCell(9).setCellValue(dossier.getMvmntDossier().getNumcont());

        }

	}
	
	
}
