/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.qbi.seriescalendar.web.model.db.User;
import org.qbi.seriescalendar.web.utils.HibernateUtil;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 *
 * @author Qbi
 */
public class NewEmptyTestNGTest {

    public NewEmptyTestNGTest() {
    }

    @BeforeSuite
    public void setup() {
    }

    @Test
    public void testSelectQuery() {
        User u = null;
        String username = "czekla";
        String password = "b166er";
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User u where u.username = :username and u.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        u = (User) query.uniqueResult();
        System.out.println(u.toString());
        tx.commit();
        //session.close();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
