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
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
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
    private Series selectedSeries;

    @PostConstruct
    public void init() {

        daysOfWeek = new ArrayList<>();
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
//        daysOfWeek.add(new Day());
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

    public Series getSelectedSeries() {
        return selectedSeries;
    }

    public void setSelectedSeries(Series selectedSeries) {
        this.selectedSeries = selectedSeries;
    }

    public TreeNode printDay_0() {
        try {
            return daysOfWeek.get(0).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public TreeNode printDay_1() {
        try {
            return daysOfWeek.get(1).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public TreeNode printDay_2() {
        try {
            return daysOfWeek.get(2).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public TreeNode printDay_3() {
        try {
            return daysOfWeek.get(3).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public TreeNode printDay_4() {
        try {
            return daysOfWeek.get(4).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public TreeNode printDay_5() {
        try {
            return daysOfWeek.get(5).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public TreeNode printDay_6() {
        try {
            return daysOfWeek.get(6).getDayRoot();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
