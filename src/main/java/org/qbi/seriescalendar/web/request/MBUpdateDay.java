/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.apache.log4j.Logger;
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


    final static Logger logger = Logger.getLogger(MBUpdateDay.class);

    public void update() {
        System.out.println("update day");
        logger.debug(weekView.getSelectedDay());
        String seriesDay = weekView.getSelectedDay().getDay();
        List<Series> seriesList = weekView.getSelectedDay().getSeriesList();
        
        dayView.setSeriesDay(seriesDay);
        dayView.setSeriesList(seriesList);
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
