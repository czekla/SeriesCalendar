/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.view;

import org.qbi.seriescalendar.web.session.MBWeekView;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.qbi.seriescalendar.web.model.Series;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDayView")
@ViewScoped
public class MBDayView implements Serializable {

    private List<Series> seriesList;
    private Series selectedSeries;
    private String seriesDay;

    @ManagedProperty("#{mBWeekView}")
    private MBWeekView weekView;
    
    final static Logger logger = Logger.getLogger(MBDayView.class);

    @PostConstruct
    public void init() {

    }

    public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
        this.seriesList = seriesList;
    }

    public Series getSelectedSeries() {
        return selectedSeries;
    }

    public void setSelectedSeries(Series selectedSeries) {
        this.selectedSeries = selectedSeries;
    }

    public String getSeriesDay() {
        return seriesDay;
    }

    public void setSeriesDay(String seriesDay) {
        this.seriesDay = seriesDay;
    }

    public MBWeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(MBWeekView weekView) {
        this.weekView = weekView;
    }

}
