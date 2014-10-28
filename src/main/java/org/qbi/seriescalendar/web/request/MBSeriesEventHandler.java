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
import org.apache.log4j.Logger;
import org.primefaces.model.TreeNode;
import org.qbi.seriescalendar.web.view.MBDayView;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBSeriesEventHandler")
@RequestScoped
public class MBSeriesEventHandler {

    @ManagedProperty("#{mBDayView}")
    private MBDayView dayView;
    
    final static Logger logger = Logger.getLogger(MBDragNDrop.class);

    public void displaySelectedNode() {

        logger.debug("display");
        TreeNode selectedNode = dayView.getSelectedSeries();
        
        logger.debug(selectedNode);

        if (selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void deleteNode() {

        logger.debug("delete");
        TreeNode selectedNode = dayView.getSelectedSeries();
        
        logger.debug(selectedNode);
        
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;

    }

    public MBDayView getDayView() {
        return dayView;
    }

    public void setDayView(MBDayView dayView) {
        this.dayView = dayView;
    }
}
