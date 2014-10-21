/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.qbi.seriescalendar.web.model.Day;

/**
 *
 * @author Qbi
 */
@FacesConverter(value = "dayConverter")
//@ManagedBean(name = "dayConverter")
//@RequestScoped
public class DayConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || (value.trim().length() == 0)) {
            return value;
        }

        Day day = null;
        return day;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value instanceof Day) {
            Day day = (Day) value;
            return day.toString();
        }
        return "";
        
    }

}
