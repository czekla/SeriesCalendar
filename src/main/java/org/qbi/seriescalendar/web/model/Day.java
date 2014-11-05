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

    public Day(String day) {
        this.day = day;
        seriesList = new ArrayList<>();
    }

    public Day(String day, List<Series> seriesList) {
        this.day = day;
        this.seriesList = seriesList;
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
        return "Day{" + "day=" + day + ", seriesList=" + seriesList + '}';
    }

}
