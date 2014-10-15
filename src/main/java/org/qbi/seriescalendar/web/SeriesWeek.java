/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "seriesWeek")
@ViewScoped
public class SeriesWeek implements Serializable{

    private List<Day> days;

    @ManagedProperty("#{seriesDayService}")
    private SeriesDayService service;
    
    @PostConstruct
    public void init(){
        days = new ArrayList<>();
        
    }

    public void update(){
        days = service.createDays();
    }
    
    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public SeriesDayService getService() {
        return service;
    }

    public void setService(SeriesDayService service) {
        this.service = service;
    }
    
}
