/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.session;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.qbi.seriescalendar.web.model.db.User;
import org.qbi.seriescalendar.web.utils.HibernateUtil;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBUser")
@SessionScoped
public class MBUser implements Serializable {

    private String username;
    private String password;
    private boolean loggedIn;
    private User user;

    @PostConstruct
    public void init() {

        System.out.println("init mBUser");
        HibernateUtil.getSessionFactory();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
