/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.model.Series;
import org.qbi.seriescalendar.web.view.MBDayView;
import org.qbi.seriescalendar.web.session.MBWeekView;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBUpdateDay")
@RequestScoped
public class MBUpdateDay implements Serializable {

    @ManagedProperty("#{mBWeekView}")
    private MBWeekView weekView;

    @ManagedProperty("#{mBDayView}")
    private MBDayView dayView;

    private Day selectedDay;
    private String seriesDay;
    private List<Series> seriesList;

    final static Logger logger = Logger.getLogger(MBUpdateDay.class);

    @PostConstruct
    public void init() {
        selectedDay = weekView.getSelectedDay();
        seriesDay = selectedDay.getDay();
        seriesList = selectedDay.getSeriesList();
    }

    public void update() {
        logger.debug("update day");
        logger.debug(selectedDay);

        dayView.setSeriesDay(seriesDay);
        dayView.setSeriesList(seriesList);
    }

    public void add() {
        seriesList.add(new Series(seriesDay, "New"));

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "A new series has been added to " + seriesDay + ".", "Please scroll down!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void delete() {
        logger.debug("delete day");
        logger.debug(selectedDay);
        String deletedSeriesTitle = dayView.getSelectedSeries().getTitle();
        seriesList.remove(dayView.getSelectedSeries());
        dayView.setSelectedSeries(null);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, deletedSeriesTitle + " has been deleted from " + seriesDay + "!", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void moveTo(ActionEvent event) {
        String dayTo = (String) event.getComponent().getAttributes().get("dayTo");
        selectedDay.setDay(dayTo);
        
    }

    public void onRowEdit(RowEditEvent event) {
        Series series = (Series) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, series.getTitle() + " has been saved.", "");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public MBWeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(MBWeekView weekView) {
        this.weekView = weekView;
    }

    public MBDayView getDayView() {
        return dayView;
    }

    public void setDayView(MBDayView dayView) {
        this.dayView = dayView;
    }

}
