/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.model.xml.ScheduleConverter;
import org.qbi.seriescalendar.web.session.MBWeekView;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBUpdateCalendar")
@RequestScoped
public class MBUpdateCalendar implements Serializable {

    @ManagedProperty("#{mBWeekView}")
    private MBWeekView weekView;

    public void info() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Please upload the schedule.xml file first!", "");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void update(FileUploadEvent event) {

        System.out.println("update");

        UploadedFile file = event.getFile();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "upload.successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        weekView.setDaysOfWeek(ScheduleConverter.convertToList(file));

    }

    public void clear() {
        System.out.println("clear");
        List<Day> days = new ArrayList<>();

        weekView.setDaysOfWeek(days);
    }

    public MBWeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(MBWeekView weekView) {
        this.weekView = weekView;
    }

}
