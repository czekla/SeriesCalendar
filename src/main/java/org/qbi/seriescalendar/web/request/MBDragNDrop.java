/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.primefaces.component.panel.Panel;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDragNDrop")
@RequestScoped
public class MBDragNDrop {

    final static Logger logger = Logger.getLogger(MBDragNDrop.class);
    
    public void onDragNDrop(DragDropEvent event) {

        System.out.println("drop");
        System.out.println(event.getDragId());
        System.out.println(event.getData());
        Panel panel = (Panel) event.getComponent().findComponent(event.getDragId());
        logger.debug(panel);
        String day = panel.getAttributes().get("seriesDay").toString();
        String title = panel.getAttributes().get("seriesTitle").toString();
        System.out.println(day);
        System.out.println(title);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Day: " + day + "<br/>" + "Title:" + title, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//                "Day: " + "" + "<br/>" + "Title:" + "", null);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
