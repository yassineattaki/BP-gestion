package org.sid.viewResolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.sid.view.PdfView;
import java.util.Locale;

public class PdfViewResolver implements ViewResolver{
	
	 @Override
	    public View resolveViewName(String s, Locale locale) throws Exception {

	        return new PdfView();
	    }

}
