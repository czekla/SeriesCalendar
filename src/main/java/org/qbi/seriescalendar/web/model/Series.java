/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model;

import java.io.Serializable;

/**
 *
 * @author Qbi
 */
public class Series implements Serializable {
    
    private String day;
    private String title;

    public Series(String day) {
        this.day = day;
        this.title = "";
    }

    public Series(String day, String title) {
        this.day = day;
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return day + "##" + title;
    }
    
    
    
}
