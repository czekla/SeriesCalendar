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
import org.primefaces.model.StreamedContent;
import org.qbi.seriescalendar.web.model.Day;
import org.qbi.seriescalendar.web.utils.ScheduleConverter;
import org.qbi.seriescalendar.web.session.MBWeekView;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBSaveCalendar")
@RequestScoped
public class MBSaveCalendar implements Serializable {

    @ManagedProperty("#{mBWeekView}")
    private MBWeekView weekView;

    public void save() {

        System.out.println("save");
        List<Day> days = weekView.getDaysOfWeek();
        System.out.println(days.size());
        for (Day day : days) {
            System.out.println(day);
        }

    }

    public StreamedContent export() {
        System.out.println("export");
        return ScheduleConverter.convertToXml(weekView.getDaysOfWeek());
    }

    public MBWeekView getWeekView() {
        return weekView;
    }

    public void setWeekView(MBWeekView weekView) {
        this.weekView = weekView;
    }

}
