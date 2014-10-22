/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Qbi
 */
public class Day implements Serializable {

    protected String day;
    protected List<Series> seriesList;

    public Day() {
        day = "";
        seriesList = new ArrayList<>();
    }

    /**
     * Creates a new instance of SeriesDay
     *
     * @param day
     */
    public Day(String day) {
        this.day = day;
        seriesList = new ArrayList<>();
        Random rnd = new Random();
        seriesList.add(new Series(day, "" + rnd.nextInt(100)));
        seriesList.add(new Series(day, "" + rnd.nextInt(100)));
        seriesList.add(new Series(day, "" + rnd.nextInt(100)));
        seriesList.add(new Series(day, "" + rnd.nextInt(100)));
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Series> getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(List<Series> seriesList) {
        this.seriesList = seriesList;
    }

    @Override
    public String toString() {
        return "Day{" + "day=" + day + ", series=" + seriesList + '}';
    }

}
