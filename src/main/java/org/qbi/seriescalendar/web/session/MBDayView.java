/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.qbi.seriescalendar.web.model.Day;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDayView")
@SessionScoped
public class MBDayView implements Serializable {

    private List<Day> daysOfWeek;

    @PostConstruct
    public void init() {

        daysOfWeek = new ArrayList<>();

    }

    public List<Day> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<Day> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

}
