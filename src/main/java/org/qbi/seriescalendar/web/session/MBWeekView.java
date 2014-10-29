/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.session;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import org.qbi.seriescalendar.web.model.Day;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBWeekView")
@SessionScoped
public class MBWeekView implements Serializable {

    private List<Day> daysOfWeek;
    private Day selectedDay;
    @PostConstruct
    public void init() {

        System.out.println("init");
        
    }

    public List<Day> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Day> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Day getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(Day selectedDay) {
        this.selectedDay = selectedDay;
    }

}
