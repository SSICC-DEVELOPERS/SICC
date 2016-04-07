package com.calipso.xmleditor;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 07-oct-2003
 * Time: 15:55:17
 * To change this template use Options | File Templates.
 */

public class XmlEditorLoader {

  private DefaultTreeModel model;
  private XmlEditorTreeDefinitionNode definition;
  private Node domRoot;

  public XmlEditorLoader(DefaultTreeModel model, XmlEditorTreeDefinitionNode definition) {
    this.model = model;
    this.definition = definition;
  }

  public XmlEditorLoader() {
  }

  /**
   * Carga un archivo. Puede o no tener una definicion Xsd cargada (segun parametro).
   * @param file
   * @param hasXsd
   * @return
   * @throws XmlEditorException
   */
  public DefaultTreeModel loadFrom(File file, boolean hasXsd) throws XmlEditorException{
    Document document = getNewDocumentFrom(file);
    Node docRoot = document.getDocumentElement();
    this.domRoot = docRoot;
    if(hasXsd) {
      fillModelFrom(docRoot, (XmlEditorTreeModelNode) model.getRoot(), definition);
      return model;
    } else {
      XmlEditorTreeModelNode root = new XmlEditorTreeModelNode(docRoot.getNodeName());
      fillModelFrom(root, docRoot);
      return new DefaultTreeModel(root);
    }
  }

  /**
   * Obtiene los atributos para un nodo.
   * @param node
   * @return
   */
  private Vector getAttrsFrom(Node node) {
    Vector vector = new Vector();
    NamedNodeMap attrs = node.getAttributes();
    for(int i = 0 ; i < attrs.getLength() ; i++) {
      Node attr = attrs.item(i);
      vector.add(attr.getNodeName());
    }
    return vector;
  }

  /**
   * Llena el modelo en base al documento cargado. Luego toma los hijos del nodo y los recorre recursivamente llamando a sus hijos.
   * @param root
   * @param docRoot
   */
  private void fillModelFrom(XmlEditorTreeModelNode root, Node docRoot) {
    Vector attrsNames = getAttrsFrom(docRoot);
    XmlEditorTreeModelNode newModelNode = new XmlEditorTreeModelNode(getIdValueFrom(docRoot)/*docRoot.getAttributes().item(attrsNames.indexOf("Id")).toString()*/);//getIdValueFrom(docRoot));
    newModelNode.addAttributesFrom(attrsNames, getAttrs(docRoot,attrsNames));
    root.add(newModelNode);
    fillModelFrom(docRoot.getChildNodes(), root);
  }

  private void fillModelFrom(NodeList children, XmlEditorTreeModelNode modelNode) {
    XmlEditorTreeModelNode newParentModelNode = null;
    boolean elementCreated = false;
    for(int i = 0 ; i < children.getLength() ; i++) {
      Node node = children.item(i);
      if(node.getNodeType() == Node.ELEMENT_NODE) {
        if(node.getAttributes().getLength() > 0) {
          if(!elementCreated) {
            newParentModelNode = new XmlEditorTreeModelNode(node.getNodeName());
            elementCreated = true;
            modelNode.add(newParentModelNode);
          }
          XmlEditorTreeModelNode newModelNode = new XmlEditorTreeModelNode(getIdValueFrom(node));
          Vector attrsNames = getAttrsFrom(node);
          newModelNode.addAttributesFrom(attrsNames, getAttrs(node,attrsNames));
          newParentModelNode.add(newModelNode);
        } else {
          XmlEditorTreeModelNode newModelNode = new XmlEditorTreeModelNode(node.getNodeName());
          modelNode.add(newModelNode);
          fillModelFrom(node.getChildNodes(), newModelNode);
        }
      }
    }
  }

  private void fillModelFrom(Node domRoot, XmlEditorTreeModelNode modelNode, XmlEditorTreeDefinitionNode definition) {
    //XmlEditorTreeModelNode newModelNode = new XmlEditorTreeModelNode(definition.getValue());
    //Vector attrsNames = getAttrsFrom(definition);
    //newModelNode.addAttributesFrom(attrsNames, getAttrs(domRoot,attrsNames));
    //modelNode.addAttributesFrom(attrsNames, getAttrs(domRoot,attrsNames));
    //modelNode.add(newModelNode);
    XmlEditorTreeModelNode newModelNode = getModelNodeFrom(modelNode.children(),definition.getValue(),false);
    Vector attrsNames = getAttrsFrom(definition);
    newModelNode.addAttributesFrom(attrsNames, getAttrs(domRoot,attrsNames));
    fillFrom(domRoot.getChildNodes(), definition);
  }

  /**
   * Obtiene los atributos para un nodo de definicion.
   * @param definition
   * @return
   */
  private Vector getAttrsFrom(XmlEditorTreeDefinitionNode definition) {
    Vector vector = new Vector();
    Enumeration enumeration = definition.getItemsKeys().elements();
    while(enumeration.hasMoreElements()) {
      vector.add(enumeration.nextElement().toString());
    }
    return vector;
  }

  private void fillFrom(NodeList childNodes, XmlEditorTreeDefinitionNode rootDefinition) {
    for(int i = 0 ; i < childNodes.getLength() ; i++) {
      Node node = childNodes.item(i);
      if(node.getNodeType() == Node.ELEMENT_NODE) {
        if(node.getAttributes() != null && node.getAttributes().getLength() > 0) {
          XmlEditorTreeModelNode parent = getModelNodeFrom(node.getNodeName());
          XmlEditorTreeModelNode child = new XmlEditorTreeModelNode(getIdValueFrom(node));
          Vector attrNames = getAttrsFrom(getNodeDefinitionFrom(rootDefinition, node.getNodeName()));
          child.addAttributesFrom(attrNames, getAttrs(node, attrNames));
          parent.add(child);
        } else {
          fillFrom(node.getChildNodes(), rootDefinition);
        }
      }
    }
  }

  /**
   * Obtiene un nodo definicion en base a la definicion "root" y un nombre. Si no es esa, busca recursivamente entre los hijos.
   * @param rootDefinition
   * @param nodeName
   * @return
   */
  private XmlEditorTreeDefinitionNode getNodeDefinitionFrom(XmlEditorTreeDefinitionNode rootDefinition, String nodeName) {
    if(rootDefinition.getValue().equals(nodeName)) {
      return rootDefinition;
    } else {
      return getNodeDefinitionFrom(rootDefinition.getSubnodes(), nodeName, false);
    }
  }

  private XmlEditorTreeDefinitionNode getNodeDefinitionFrom(Map rootDefinition, String nodeName, boolean found) {
    XmlEditorTreeDefinitionNode returnVal = null;
    Iterator iterator = rootDefinition.keySet().iterator();
    while(iterator.hasNext() && !found) {
      XmlEditorTreeDefinitionNode definition = (XmlEditorTreeDefinitionNode) rootDefinition.get(iterator.next().toString());
      if(definition.getValue().equals(nodeName)) {
        return definition;
      } else {
        returnVal = getNodeDefinitionFrom(definition.getSubnodes(), nodeName, found);
        if(returnVal != null) {
          found = true;
        }
      }
    }
    return returnVal;
  }

  private String getIdValueFrom(Node node) {
    Vector names = getAttrsFrom(node);
    int pos = names.indexOf("Id");
    if(pos >= 0){
      return node.getAttributes().item(pos).getNodeValue().toString();
    }else if(names.indexOf("Name")>=0){
      return node.getAttributes().item(names.indexOf("Name")).getNodeValue().toString();
    }else{
      Node attrNode = node.getAttributes().item(0);
      return attrNode.getNodeValue();
    }
  }

/*  private Vector getAttrsNames(Node node) {
    node.getAttributes()
  }*/

  /**
   * Busca el nodo con el nombre dado. Si no es el root busca recursivamente en sus hijos.
   * @param nodeName
   * @return
   */
  private XmlEditorTreeModelNode getModelNodeFrom(String nodeName) {
    if(((XmlEditorTreeModelNode)model.getRoot()).getUserObject().equals(nodeName)) {
      return (XmlEditorTreeModelNode)model.getRoot();
    } else {
      return getModelNodeFrom(((XmlEditorTreeModelNode)model.getRoot()).children(), nodeName, false);
    }
  }

  private XmlEditorTreeModelNode getModelNodeFrom(Enumeration children, String nodeName, boolean found) {
    XmlEditorTreeModelNode returnVal = null;
    while(children.hasMoreElements() && !found) {
      XmlEditorTreeModelNode current = (XmlEditorTreeModelNode) children.nextElement();
      if(current.getUserObject().equals(nodeName)) {
        return current;
      } else {
        returnVal = getModelNodeFrom(current.children(), nodeName, found);
        if(returnVal != null) {
          found = true;
        }
      }
    }
    return returnVal;
  }

  private Vector getAttrs(Node node, Vector attrNames) {
    Vector vector = new Vector();
    NamedNodeMap attrs = node.getAttributes();
    Enumeration enumeration = attrNames.elements();
    while(enumeration.hasMoreElements()) {
      Node attr = attrs.getNamedItem(enumeration.nextElement().toString());
      if(attr == null) {
        vector.add("");
      } else {
        vector.add(attr.getNodeValue());
      }
    }
    return vector;
  }

  /**
   * Obtiene el documento en base al archivo XML
   * @param file
   * @return
   * @throws XmlEditorException
   */
  private Document getNewDocumentFrom(File file) throws XmlEditorException{
    Document document = null;
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      document = builder.parse(file);
    } catch (Exception e) {
      throw new XmlEditorException(e);
    }
    return document;
  }

  public Node getDomRoot() {
    return domRoot;
  }
}
