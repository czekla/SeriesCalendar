/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.session;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

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

    @PostConstruct
    public void init() {
        
        System.out.println("init mBUser");
    }

    public void login(ActionEvent event) {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        if (username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
            context.update("weekForm:weekData");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", loggedIn);
        }

    }

    public void logout() {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bye bye", username);
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.update("weekForm:weekData");
        
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

}
