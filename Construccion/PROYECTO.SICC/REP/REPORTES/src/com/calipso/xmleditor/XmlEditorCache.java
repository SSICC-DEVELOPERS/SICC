package com.calipso.xmleditor;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by IntelliJ IDEA.
 * User: jbassino
 * Date: 25/06/2004
 * Time: 15:49:52
 * To change this template use Options | File Templates.
 */
public class XmlEditorCache {
  private Map cachedXml = new HashMap();
  private Map cachedXsd = new HashMap();
  private Map cachedXmlWithXsd = new HashMap();
  private XmlEditorUI xmlEditorUI;

  public XmlEditorCache(XmlEditorUI ui) {
    this.xmlEditorUI = ui;
  }

  public void putXml(Object key, Object value){
    cachedXml.put(key, value);
  }

  public void putXsd(Object key, Object value){
    cachedXsd.put(key, value);
  }

  public void putXmlWithXsd(Object key, Object xml, Object xsd){
    Vector value = new Vector(2);
    value.add(xml);
    value.add(xsd);
    cachedXmlWithXsd.put(key, new Vector());
  }
}
