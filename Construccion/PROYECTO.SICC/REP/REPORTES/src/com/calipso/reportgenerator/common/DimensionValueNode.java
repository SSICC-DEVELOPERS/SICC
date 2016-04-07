package com.calipso.reportgenerator.common;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.Vector;
import java.util.HashMap;
import java.io.Serializable;
public class DimensionValueNode implements Serializable {

  private Object value;
  private Map subNodes;
  private Collection subNodesList;
  private int dimensionCount;
  private int dimensionIndex;
  private boolean collapsed;
  private DimensionValueNode parentNode;
  private Map allSubNodes;

  public DimensionValueNode(Object value){
    this.value = value;
    this.dimensionCount = -1;
    this.dimensionIndex = -1;
    collapsed = false;
  }

  public DimensionValueNode(Object value, DimensionValueNode parentNode){
    this(value);
    this.parentNode = parentNode;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  public int getDimensionCount() {
    return dimensionCount;
  }

  public void setDimensionCount(int dimensionCount) {
    this.dimensionCount = dimensionCount;
  }

  public Map getSubNodes() {
    if (subNodes == null){
      subNodes = new HashMap();
    }
    return subNodes;
  }

  public Iterator iterator() {
    if (getCollapsed()){
      return new ArrayList().iterator();
    }
    return getSubNodesList().iterator();
  }


  public Collection getSubNodesList() {
    if (subNodesList == null){
      subNodesList = new Vector();
    }
    return subNodesList;
  }

  public int getDimesionIndex() {
    return dimensionIndex;
  }

  public void setDimensionIndex(int dimensionIndex) {
    this.dimensionIndex = dimensionIndex;
  }

  public void addSubNode(DimensionValueNode node) {
    getSubNodes().put(node.getValue(), node);
    getSubNodesList().add(node);
  }

  public boolean getCollapsed() {
    return collapsed;
  }

  public void changeDimensionValueNodeState(){
    collapsed = !collapsed;
  }

  public DimensionValueNode getParentNode() {
    return parentNode;
  }

  public Map getAllSubNodes(){
    if (allSubNodes == null){
      allSubNodes = new HashMap();
    }
    return allSubNodes;
  }
}
