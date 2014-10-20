/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.panel.Panel;
import org.primefaces.event.DragDropEvent;
import org.qbi.seriescalendar.web.model.Day;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDayView")
@ViewScoped
public class MBDayView implements Serializable {

    private List<Day> daysOfWeek;

    @PostConstruct
    public void init() {

        daysOfWeek = new ArrayList<>();

    }

    public void onDragNDrop(DragDropEvent event) {

        System.out.println("drop");
        Panel panel = (Panel) event.getComponent().findComponent(event.getDragId());
        String day = panel.getAttributes().get("seriesDay").toString();
        String title = panel.getAttributes().get("seriesTitle").toString();
        System.out.println(day);
        System.out.println(title);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Day: " + day + "<br/>" + "Title:" + title, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Day> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Day> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

}
