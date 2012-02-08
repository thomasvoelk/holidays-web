package org.voelk.holidays.web.util;

import java.util.*;

public class I18nBean {
    private static ResourceBundle labelsBundle = ResourceBundle.getBundle("i18n.labelsBundle");

    public static String getText(String key) {
        return labelsBundle.getString(key);
    }
}
