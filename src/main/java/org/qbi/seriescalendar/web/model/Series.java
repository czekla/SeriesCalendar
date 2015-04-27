/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Qbi
 */
public class Series implements Serializable {

    private String id;
    private String day;
    private String title;
    private String torrentLink;
    private String subtitleLink;

    public Series(String day) {
        this(day, "");
    }

    public Series(String day, String title) {
        this.day = day;
        this.title = title;
        this.id = getRandomId();
        setLinks();
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void setLinks() {
        //torrentLink = "http://thepiratebay.se/search/" + title.replaceAll(" ", "%20") + "/0/99/0";
        torrentLink = "https://kickass.to/usearch/" + title.replaceAll(" ", "%20")+"/?field=time_add&sorder=desc";
        subtitleLink = "http://www.feliratok.info/?search=" + title.replaceAll(" ", "+");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        setLinks();
    }

    public String getTorrentLink() {
        return torrentLink;
    }

    public void setTorrentLink(String torrentLink) {
        this.torrentLink = torrentLink;
    }

    public String getSubtitleLink() {
        return subtitleLink;
    }

    public void setSubtitleLink(String subtitleLink) {
        this.subtitleLink = subtitleLink;
    }

    @Override
    public String toString() {
        return day + "##" + title;
    }

	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Series)) return false;
		
		Series ser = (Series)obj;
		return this.day.equals(ser.day) && this.title.equals(ser.title);
	}

}
