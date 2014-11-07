/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.test;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.qbi.seriescalendar.web.model.db.User;
import org.qbi.seriescalendar.web.request.MBUserLogin;
import org.qbi.seriescalendar.web.utils.HibernateUtil;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Qbi
 */
public class NewEmptyTestNGTest {

    final static Logger logger = Logger.getLogger(NewEmptyTestNGTest.class);
    
    SessionFactory factory;
    
    public NewEmptyTestNGTest() {
    }

    @Test
    public void testSelectQuery() {
        User u = null;
        String username = "czekla";
        String password = "b166er";
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User u where u.username = :username and u.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        u = (User) query.uniqueResult();
        
        tx.commit();
        //session.close();
        assertNotNull(u);
        logger.info(u.toString());
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        factory = HibernateUtil.getSessionFactory();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        factory.close();
    }
}
