package org.sid.viewResolver;


import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import java.util.Locale;
import org.sid.view.CsvView;

public class CsvViewResolver implements ViewResolver{

	@Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        return new CsvView();
    }
}
