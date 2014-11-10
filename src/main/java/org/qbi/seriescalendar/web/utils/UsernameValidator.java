/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.utils;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.validate.ClientValidator;
import org.qbi.seriescalendar.web.model.db.User;

/**
 *
 * @author Qbi
 */
@FacesValidator("custom.usernameValidator")
public class UsernameValidator implements Validator, ClientValidator {

    final static Logger logger = Logger.getLogger(UsernameValidator.class);

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        String username = value.toString();

        User u = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        String hql = "from User u where u.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        u = (User) query.uniqueResult();
        tx.commit();

        if (u != null) {
            throw new ValidatorException(new FacesMessage("This username is taken."));
        }
    }

    @Override
    public Map<String, Object> getMetadata() {
        return null;
    }

    @Override
    public String getValidatorId() {
        return "custom.usernameValidator";
    }

}
