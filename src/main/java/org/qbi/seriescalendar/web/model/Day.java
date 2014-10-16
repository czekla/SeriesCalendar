/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Qbi
 */
public class Day implements Serializable {

    protected String day;
    protected List<String> series;

    public Day() {
        day = "";
        series = new ArrayList<>();
    }

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
        series.add("3");
        series.add("4");
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

    @Override
    public String toString() {
        return "Day{" + "day=" + day + ", series=" + series + '}';
    }

    public static Day toDay(String input) {
        Day d = new Day();
        String[] split = input.split(", ");
        d.setDay(split[0].substring(8));
        List<String> l = new ArrayList<>();
        for (String s : split) {
            if (s.equals(split[0])) {
                continue;
            }
            l.add(s);
        }
        d.setSeries(l);
        return d;
    }

}
