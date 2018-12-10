package org.sid.view;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import org.sid.dao.UserRepository;
import org.sid.entities.Users;

public class CsvView extends AbstractCsvView{
	

    @Override
    protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse
            response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

        List<Users> users = ( List<Users>) model.get("users");
        String[] header = {"matricule", "nomUser", "prenomUser", "adresseUser", "cinUser"};
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        csvWriter.writeHeader(header);

        for (Users user : users) {
            csvWriter.write(user, header);
        }
        csvWriter.close();

    }

}
