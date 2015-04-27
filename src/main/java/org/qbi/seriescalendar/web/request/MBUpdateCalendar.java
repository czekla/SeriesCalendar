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
import org.qbi.seriescalendar.web.utils.ScheduleConverter;
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

    public void infoXML() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Please upload the schedule.xml file first!", "");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void updateXML(FileUploadEvent event) {

        System.out.println("update");

        UploadedFile file = event.getFile();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "upload.successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        weekView.setDaysOfWeek(ScheduleConverter.convertToListFromXML(file));

    }
    
    public void infoICS() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Please upload the *.ics file first!", "");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public void updateICS(FileUploadEvent event) {

        System.out.println("update");

        UploadedFile file = event.getFile();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "upload.successful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        weekView.setDaysOfWeek(ScheduleConverter.convertToListFromICS(file));

    }

    public void emptyWeek() {
        System.out.println("new");
        List<Day> days = new ArrayList<>();
        days.add(new Day("Monday"));
        days.add(new Day("Tuesday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));
        days.add(new Day("Saturday"));
        days.add(new Day("Sunday"));

        weekView.setDaysOfWeek(days);
    }

    public MBWeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(MBWeekView weekView) {
        this.weekView = weekView;
    }

}
