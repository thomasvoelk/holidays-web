package org.voelk.holidays.web.pages;

import com.google.common.collect.*;

import java.util.*;

public class CalculatorPageResource extends PageResource {


    @Override
    protected String getTemplatePath() {
        return "calculator.ftl";
    }

    @Override
    protected Map<String, Object> getPageData() {
        return Maps.newHashMap();
    }
}
