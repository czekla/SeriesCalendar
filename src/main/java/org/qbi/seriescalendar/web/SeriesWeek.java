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
    
    private int count;
    private int countA = 1;
    
    @PostConstruct
    public void init(){
        days = new ArrayList<>();
        countA = 2;
        System.out.println("asd");
//        days = new ArrayList<>();
//        days.add(new Day("Monday"));
//        days.add(new Day("Tuesday"));
//        days.add(new Day("Wednesday"));
//        days.add(new Day("Thursday"));
//        days.add(new Day("Friday"));
//        days.add(new Day("Saturday"));
//        days.add(new Day("Sunday"));
        count = days.size();
        
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountA() {
        return countA;
    }

    public void setCountA(int countA) {
        this.countA = countA;
    }
    
    

    
    
    
}
