package org.sid.view;

import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.sid.entities.Users;


public class PdfView extends AbstractPdfView {

	
	 @Override
	    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
	        // change the file name
	        response.setHeader("Content-Disposition", "attachment; filename=\"my-pdf-file.pdf\"");

	        List<Users> users = ( List<Users>) model.get("users");
	        document.add(new Paragraph("Generated Users " + LocalDate.now()));

	        PdfPTable table = new PdfPTable(users.stream().findAny().get().getColumnCount());
	        table.setWidthPercentage(100.0f);
	        table.setSpacingBefore(10);

	        // define font for table header row
	        Font font = FontFactory.getFont(FontFactory.TIMES);
	        font.setColor(BaseColor.WHITE);

	        // define table header cell
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(BaseColor.DARK_GRAY);
	        cell.setPadding(5);

	        // write table header
	        cell.setPhrase(new Phrase("matricule", font));
	        table.addCell(cell);

	        cell.setPhrase(new Phrase("nomUser", font));
	        table.addCell(cell);

	        cell.setPhrase(new Phrase("prenomUser", font));
	        table.addCell(cell);

	        cell.setPhrase(new Phrase("adresseUser", font));
	        table.addCell(cell);

	        cell.setPhrase(new Phrase("cinUser", font));
	        table.addCell(cell);

	        

	        for(Users user : users){
	            table.addCell(user.getMatricule());
	            table.addCell(user.getNomUser());
	            table.addCell(user.getPrenomUser());
	            table.addCell(user.getAdresseUser());
	            table.addCell(user.getCinUser());
	           

	        }

	        document.add(table);
	    }
}
