package com.calipso.xmleditor;

import org.exolab.castor.xml.schema.AttributeDecl;
import org.exolab.castor.xml.schema.SimpleTypesFactory;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 25-sep-2003
 * Time: 14:19:12
 * To change this template use Options | File Templates.
 */

public class XmlEditorTreeDefinitionNode {

  private Map subNodes;
  private String value;
  private boolean mustHaveChilds;
  private Vector itemsKeys;
  private HashMap items;

  public XmlEditorTreeDefinitionNode(String value) {
    this.value = value;
  }

  /**
   * Agrega un nodo a los hijos del nodo.
   * @param value
   * @return
   */
  public XmlEditorTreeDefinitionNode addNodeFrom(String value) {
    XmlEditorTreeDefinitionNode node = null;
    node = new XmlEditorTreeDefinitionNode(value);
    getSubnodes().put(value, node);
    return node;
  }

  /**
   * Agrega los atributos al nodo.
   * @param enumeration
   * @throws XmlEditorException
   */
  public void addNodeAttributes(Enumeration enumeration) throws XmlEditorException{
    while(enumeration.hasMoreElements()) {
      AttributeDecl attributeDecl = (AttributeDecl) enumeration.nextElement();
      int type = attributeDecl.getSimpleType().getBuiltInBaseType().getTypeCode();
      switch(type){
        case SimpleTypesFactory.STRING_TYPE:
          getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.STRING , attributeDecl.getName()));
          break;
        case SimpleTypesFactory.NMTOKEN_TYPE:
          Enumeration facets = attributeDecl.getSimpleType().getLocalFacets();
          getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.TOKENS, facets));
          break;
        case SimpleTypesFactory.BOOLEAN_TYPE:
          getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.BOOLEAN, attributeDecl.getName()));
          break;
        case SimpleTypesFactory.INTEGER_TYPE:
        case SimpleTypesFactory.INT_TYPE:
        case SimpleTypesFactory.DECIMAL_TYPE: //Todo: Mejorar el tratamiento de este tipo en particular
          getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.INTEGER, attributeDecl.getName()));
          break;
        default: throw new XmlEditorException("No existe el tipo de dato solicitado");
      }
/*      if(attributeDecl.getSimpleType().getBuiltInBaseType().getTypeCode() == SimpleTypesFactory.STRING_TYPE) {
        getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.STRING, attributeDecl.getName()));
      } else if (attributeDecl.getSimpleType().getBuiltInBaseType().getTypeCode() == SimpleTypesFactory.NMTOKEN_TYPE) {
        Enumeration facets = attributeDecl.getSimpleType().getLocalFacets();
        getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.TOKENS, facets));
      } else if (attributeDecl.getSimpleType().getBuiltInBaseType().getTypeCode() == SimpleTypesFactory.BOOLEAN_TYPE) {
        getItems().put(attributeDecl.getName(), new XmlEditorTreeNodeItemDefinition(attributeDecl.getName().toUpperCase(), attributeDecl.isOptional(), XmlEditorDataType.BOOLEAN, attributeDecl.getName()));
      }*/
      getItemsKeys().add(attributeDecl.getName());
    }
  }

  public String getValue() {
    return value;
  }

  public void setMustHaveChilds(int childs) {
    if(childs >= 1) {
      this.mustHaveChilds = true;
    } else {
      this.mustHaveChilds = false;
    }
  }

  public Map getSubnodes() {
    if(subNodes == null) {
      subNodes = new HashMap();
    }
    return subNodes;
  }

  public Vector getItemsKeys() {
    if(itemsKeys == null) {
      itemsKeys = new Vector();
    }
    return itemsKeys;
  }

  public HashMap getItems() {
    if(items == null) {
      items = new HashMap();
    }
    return items;
  }
}
