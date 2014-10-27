/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.qbi.seriescalendar.web.model;

import java.io.Serializable;
import java.util.Random;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Qbi
 */
public class Day implements Serializable {

    protected String day;
    protected TreeNode dayRoot;
    private final String nodeType = "dayLeaf";

    public Day() {
        day = "";
        dayRoot = new DefaultTreeNode("Root", "Root", null);
    }

    /**
     * Creates a new instance of SeriesDay
     *
     * @param day
     */
    public Day(String day) {
        this.day = day;
        Random rnd = new Random();
        this.dayRoot = new DefaultTreeNode("Root", "Root", null);
        TreeNode node = null;
        node = new DefaultTreeNode(nodeType, new Series(day, "" + rnd.nextInt(100)), dayRoot);
        node = new DefaultTreeNode(nodeType, new Series(day, "" + rnd.nextInt(100)), dayRoot);
        node = new DefaultTreeNode(nodeType, new Series(day, "" + rnd.nextInt(100)), dayRoot);
        node = new DefaultTreeNode(nodeType, new Series(day, "" + rnd.nextInt(100)), dayRoot);
        node = new DefaultTreeNode(nodeType, new Series(day, "" + rnd.nextInt(100)), dayRoot);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public TreeNode getDayRoot() {
        return dayRoot;
    }

    public void setDayRoot(TreeNode dayRoot) {
        this.dayRoot = dayRoot;
    }

    public String getNodeType() {
        return nodeType;
    }
    
    

    @Override
    public String toString() {
        return "Day{" + "day=" + day + ", dayRoot=" + printNodes() + '}';
    }

    public String printNodes() {
        StringBuilder sb = new StringBuilder();
        for (TreeNode node : dayRoot.getChildren()) {
            sb.append(node.toString());
            sb.append(", ");
        }
        return sb.toString();
    }

}
