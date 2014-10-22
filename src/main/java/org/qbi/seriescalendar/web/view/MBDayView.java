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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.model.Series;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDayView")
@ViewScoped
public class MBDayView implements Serializable {

    private List<Day> daysOfWeek;
    private Day testDay;

    @PostConstruct
    public void init() {

        daysOfWeek = new ArrayList<>();
        testDay = new Day("Test");
    }

    public List<Day> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Day> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Day getTestDay() {
        return testDay;
    }

    public void setTestDay(Day testDay) {
        this.testDay = testDay;
    }

    public List<Series> printSeries(){
        List<Series> list = new ArrayList<>();
        
        for (Day d : daysOfWeek) {
            for (Series s : d.getSeriesList()) {
                list.add(s);
            }
        }
        
        return list;
    }
}
