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
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.session.MBDayView;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBSaveCalendar")
@RequestScoped
public class MBSaveCalendar implements Serializable{

    @ManagedProperty("#{mBDayView}")
    private MBDayView dayView;

    public void save() {

        System.out.println("save");
        List<Day> days = dayView.getDaysOfWeek();
        System.out.println(days.size());
        for (Day day : days) {
            System.out.println(day);
        }

    }

    public MBDayView getDayView() {
        return dayView;
    }

    public void setDayView(MBDayView dayView) {
        this.dayView = dayView;
    }
}
