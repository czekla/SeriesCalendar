/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Qbi
 */
public class Day implements Serializable{

    protected String day;
    protected List<String> series;

    /**
     * Creates a new instance of SeriesDay
     *
     * @param day
     */
    public Day(String day) {
        this.day = day;
        series = new ArrayList<>();
        series.add("1");
        series.add("2");
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getSeries() {
        return series;
    }

    public void setSeries(List<String> series) {
        this.series = series;
    }
}
