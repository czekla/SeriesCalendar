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
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Qbi
 */
@ManagedBean(name = "mBDragNDrop")
@RequestScoped
public class MBDragNDrop {

    final static Logger logger = Logger.getLogger(MBDragNDrop.class);

    public void onDragNDrop(TreeDragDropEvent event) {
        System.out.println("drop");
        TreeNode dragNode = event.getDragNode();
        TreeNode dropNode = event.getDropNode();
        int dropIndex = event.getDropIndex();

        logger.debug(dropNode.getType());

        if ("dayLeaf".equals(dropNode.getType())) {
            TreeNode parent = dropNode.getParent();
            parent.getChildren().add(dragNode);
            dropNode.getChildren().clear();
        }

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dragged " + dragNode.getData(), "Dropped on " + dropNode.getData() + " at " + dropIndex);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
