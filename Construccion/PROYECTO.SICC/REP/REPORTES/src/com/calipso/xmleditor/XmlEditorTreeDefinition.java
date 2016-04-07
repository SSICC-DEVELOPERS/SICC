package com.calipso.xmleditor;

import org.exolab.castor.xml.schema.Group;
import org.exolab.castor.xml.schema.ContentModelGroup;
import org.exolab.castor.xml.schema.Schema;
import org.exolab.castor.xml.schema.ElementDecl;

import org.exolab.castor.xml.schema.ComplexType;
import org.exolab.castor.xml.schema.reader.SchemaReader;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 25-sep-2003
 * Time: 13:54:52
 * To change this template use Options | File Templates.
 */

public class XmlEditorTreeDefinition {

  private Schema schema;
  private String rootName;
  private XmlEditorTreeDefinitionNode root;

  public XmlEditorTreeDefinition(String schemaLocation) throws XmlEditorException{
    try {
      initialize(schemaLocation);
      this.rootName = SchemaRootSearcher.searchRootFrom(schema);
      buildTree();
    } catch (IOException e) {
      throw new XmlEditorException(e);
    }
  }

  private void buildTree() throws XmlEditorException{
    ElementDecl elementDecl = schema.getElementDecl(rootName);
    ComplexType complexType = (ComplexType) elementDecl.getType();
    Enumeration groups = complexType.enumerate();
    XmlEditorTreeDefinitionNode current = getRoot().addNodeFrom(elementDecl.getName());
    current.setMustHaveChilds(complexType.getMinOccurs());
    current.addNodeAttributes(complexType.getAttributeDecls());
    while(groups.hasMoreElements()) {
      Group group = (Group) groups.nextElement();
      ContentModelGroup modelGroup = group.getContentModelGroup();
      Enumeration rootChilds = modelGroup.enumerate();
      fillTree(rootChilds, getRoot());
    }
  }

  private void fillTree(Enumeration elements, XmlEditorTreeDefinitionNode node) throws XmlEditorException{
    while(elements.hasMoreElements()) {
      Object object = elements.nextElement();
      if(object instanceof Group) {
        Group group = (Group) object;
        ContentModelGroup modelGroup = group.getContentModelGroup();
        Enumeration enumeration = modelGroup.enumerate();
        fillTree(enumeration, node);
      }
      else {
        ComplexType type = null;
        ElementDecl elementDecl = (ElementDecl) object;
        XmlEditorTreeDefinitionNode current = node.addNodeFrom(elementDecl.getName());
        if(schema.getElementDecl(current.getValue()) == null) {
          type = (ComplexType) elementDecl.getType();
        } else {
          type = (ComplexType) (schema.getElementDecl(current.getValue())).getType();
        }
        current.setMustHaveChilds(type.getMinOccurs());
        current.addNodeAttributes(type.getAttributeDecls());
        fillTree(type.enumerate(), current);
      }
    }
  }

  private XmlEditorTreeDefinitionNode getRoot() throws XmlEditorException{
    if(root == null) {
      root = new XmlEditorTreeDefinitionNode(rootName);
      root.addNodeAttributes(((ComplexType)schema.getElementDecl(rootName).getType()).getAttributeDecls());
      root.setMustHaveChilds(1);
    }
    return root;
  }

  private void initialize(String schemaLocation) throws IOException {
    this.schema = loadSchema(schemaLocation);
  }

  private Schema loadSchema(String url) throws IOException {
    FileInputStream stream = new FileInputStream(url);
    InputSource inputSource = new InputSource(stream);
    SchemaReader reader = new SchemaReader(inputSource);
    return reader.read();
  }

  public String getRootName() {
    return rootName;
  }

  public XmlEditorTreeDefinitionNode getRootDefinition() {
    return root;
  }
}
