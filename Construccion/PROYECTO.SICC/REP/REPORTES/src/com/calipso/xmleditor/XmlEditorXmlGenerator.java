package com.calipso.xmleditor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

import javax.swing.tree.DefaultTreeModel;
import java.util.Vector;
import java.util.Enumeration;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 06-oct-2003
 * Time: 15:45:07
 * To change this template use Options | File Templates.
 */

public class XmlEditorXmlGenerator {

  private static String outputPath;

  public XmlEditorXmlGenerator(DefaultTreeModel model, String fileName) throws XmlEditorException{
    this.outputPath = fileName;
    generateFrom(model, fileName);
  }

  /**
   * Genera un XML en base al modelo en el archivo especificado
   * @param model
   * @param fileName
   * @throws XmlEditorException
   */
  public static void generateFrom(DefaultTreeModel model, String fileName) throws XmlEditorException{
    outputPath = fileName;
    Document document = new DocumentImpl();
    XmlEditorTreeModelNode modelNode = (XmlEditorTreeModelNode) model.getRoot();
    Element element = document.createElement(modelNode.getUserObject().toString());
    XmlEditorTreeModelNode rootSpecs = getRootSpecs(modelNode.children());
    document.appendChild(element);
    fillElementFrom(rootSpecs.getAttributes(), rootSpecs.getAttributeNames(), element);
    generateFrom(modelNode.children(), element, document, rootSpecs);
    printOutputFrom(document, rootSpecs);
  }

  private static XmlEditorTreeModelNode getRootSpecs(Enumeration children) {
    while(children.hasMoreElements()) {
      XmlEditorTreeModelNode modelNode = (XmlEditorTreeModelNode) children.nextElement();
      if(modelNode.isLeaf()) {
        return modelNode;
      }
    }
    return null;
  }

  private static void printOutputFrom(Document document, XmlEditorTreeModelNode rootSpecs) throws XmlEditorException{
    OutputFormat format = new OutputFormat(document,"ISO-8859-1", true);
    if(outputPath.equalsIgnoreCase("")) {
      outputPath = System.getProperty("user.dir") +  rootSpecs.getAttributes().elementAt(rootSpecs.getAttributeNames().indexOf("Id")).toString();
    }
    try {
      XMLSerializer serial = new XMLSerializer(new FileOutputStream(getFileFrom(outputPath)), format);
      serial.serialize(document);
    } catch (IOException e) {
      throw new XmlEditorException(e);
    }
  }

  private static File getFileFrom(String outputPath) {
    File file;
    if(outputPath.endsWith(".xml")) {
      file = new File(outputPath);
    } else {
      file = new File(outputPath + ".xml");
    }
    return file;
  }

  private static void generateFrom(Enumeration childrens, Element element, Document document, XmlEditorTreeModelNode rootSpec) {
    while(childrens.hasMoreElements()) {
      XmlEditorTreeModelNode modelNode = (XmlEditorTreeModelNode) childrens.nextElement();
      if(modelNode != rootSpec) {
        for(int i = 0 ; i < modelNode.getChildCount() ; i++) {
          XmlEditorTreeModelNode child = (XmlEditorTreeModelNode) modelNode.getChildAt(i);
          if(child.getAttributes().size() > 0 && child.isLeaf()) {
            Element newElement = document.createElement(modelNode.getUserObject().toString());
            fillElementFrom(child.getAttributes(), child.getAttributeNames(), newElement);
            element.appendChild(newElement);
          } else if(!child.isLeaf()){
            Element newElement = document.createElement(modelNode.getUserObject().toString());
            element.appendChild(newElement);
            generateFrom(modelNode.children(), newElement, document, rootSpec);
          }
        }
      }
    }
  }

  private static void fillElementFrom(Vector attributes, Vector attrNames, Element element) {
    for(int i = 0 ; i < attributes.size() ; i++) {
      element.setAttribute(attrNames.elementAt(i).toString(), attributes.elementAt(i).toString());
    }
  }
}
