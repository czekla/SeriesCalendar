/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.qbi.seriescalendar.web.model.db.User;
import org.qbi.seriescalendar.web.utils.HibernateUtil;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBUserRegister")
@ViewScoped
public class MBUserRegister {

    private String fullname;
    private String username;
    private String password;

    final static Logger logger = Logger.getLogger(MBUserRegister.class);

    public void register() {

        logger.debug(fullname);
        logger.debug(username);
        logger.debug(password);

        User user = new User();
        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success.", "Now you can log in.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

}
