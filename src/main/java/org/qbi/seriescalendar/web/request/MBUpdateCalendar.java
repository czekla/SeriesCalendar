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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.qbi.seriescalendar.web.model.Day;
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

    public void update() {

        System.out.println("update");
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
