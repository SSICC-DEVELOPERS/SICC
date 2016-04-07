package com.calipso.xmleditor;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 25-sep-2003
 * Time: 18:20:35
 * To change this template use Options | File Templates.
 */

public class XmlEditorTreeNodeItemDefinition {

  private String name;
  private Object value;
  private boolean isOptional;
  private int type;

  public XmlEditorTreeNodeItemDefinition(String name, boolean optional, int type, Object value) {
    this.name = name;
    this.value = value;
    this.isOptional = optional;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public Object getValue() {
    return value;
  }

  public boolean isOptional() {
    return isOptional;
  }

  public int getType() {
    return type;
  }
}
