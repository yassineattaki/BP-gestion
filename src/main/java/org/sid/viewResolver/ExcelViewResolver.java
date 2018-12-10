package org.sid.viewResolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.sid.view.ExcelView;
import java.util.Locale;

public class ExcelViewResolver  implements ViewResolver {

	
    public View resolveViewName(String s, Locale locale) throws Exception {

    	if(s.equals("404")) {
    		return new ExcelView();
    	}
      
		return null;
    }
}
