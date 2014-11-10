/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.qbi.seriescalendar.web.model.db.User;
import org.qbi.seriescalendar.web.session.MBUser;
import org.qbi.seriescalendar.web.utils.HibernateUtil;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBUserLogin")
@RequestScoped
public class MBUserLogin {

    @ManagedProperty("#{mBUser}")
    private MBUser mBUser;

    final static Logger logger = Logger.getLogger(MBUserLogin.class);

    public void login(ActionEvent event) {

        logger.debug("login");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        User user = findUserByLoginData(mBUser.getUsername(), mBUser.getPassword());
        mBUser.setUser(user);

        if (user != null) {
            mBUser.setLoggedIn(true);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", mBUser.getUser().getFullname());
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mBUser.isLoggedIn());
            context.update("weekForm:weekData");
        } else {
            mBUser.setLoggedIn(false);
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mBUser.isLoggedIn());
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
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            String hql = "from User u where u.username = :username and u.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", un);
            query.setParameter("password", pw);
            u = (User) query.uniqueResult();
            tx.commit();
        }

        return u;
    }

    public void logout(ActionEvent event) {

        logger.debug("logout");
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        mBUser.setLoggedIn(false);
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bye bye", mBUser.getUser().getFullname());
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.update("weekForm:weekData");
        mBUser.setUser(null);
    }

    public MBUser getmBUser() {
        return mBUser;
    }

    public void setmBUser(MBUser mBUser) {
        this.mBUser = mBUser;
    }

}
