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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
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

    public void login(ActionEvent event) {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        user = findUserByLoginData(username, password);

        if (user != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getFullname());
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

    private User findUserById(int id) {
        User u = null;

        if (id > 0) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hql = "from User u where u.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            u = (User) query.uniqueResult();
            tx.commit();
            session.close();
        }

        return u;
    }

    private User findUserByLoginData(String un, String pw) {
        User u = null;

        if (un != null && pw != null) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String hql = "from User u where u.username = :username and u.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", un);
            query.setParameter("password", pw);
            u = (User) query.uniqueResult();
            tx.commit();
            session.close();
        }

        return u;
    }

    public void logout() {

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bye bye", user.getFullname());
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
