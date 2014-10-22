/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.request;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.apache.myfaces.component.visit.FullVisitContext;
import org.primefaces.component.panel.Panel;
import org.primefaces.event.DragDropEvent;
import org.qbi.seriescalendar.web.model.Series;

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
        Series se = (Series) event.getData();
//        Panel panel = (Panel) event.getComponent().findComponent(event.getDragId());
//        Panel panel = (Panel) findComponent(event.getDragId());
//        logger.debug(panel);
//        String day = panel.getAttributes().get("seriesDay").toString();
//        String title = panel.getAttributes().get("seriesTitle").toString();
        String day = se.getDay();
        String title = se.getTitle();
        System.out.println(day);
        System.out.println(title);
        StringBuilder sb = new StringBuilder();
        sb.append("Day: ").append(day);
        sb.append("<br/>");
        sb.append("Title: ").append(title);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                sb.toString(), null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//                "Day: " + "" + "<br/>" + "Title:" + "", null);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public UIComponent findComponent(final String id) {

        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        final UIComponent[] found = new UIComponent[1];

        root.visitTree(new FullVisitContext(context), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent component) {
                if (component.getId().equals(id)) {
                    found[0] = component;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });

        return found[0];

    }
}
