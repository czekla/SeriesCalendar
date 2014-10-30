/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Qbi
 */
@XmlRootElement(name = "schedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Schedule {
    
    @XmlElement(name = "day")
    private List<ScheduleDay> day;

    public List<ScheduleDay> getDay() {
        return day;
    }

    public void setDay(List<ScheduleDay> day) {
        this.day = day;
    }
    
    
}
