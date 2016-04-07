package es.indra.sicc.cmn.presentacion.filtrador;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.sicc.util.*;
import es.indra.sicc.util.xml.*;

import java.io.*;

import java.util.*;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jaxen.*;
import org.jaxen.dom.*;

import org.w3c.dom.*;


public class Filtrador {

  public static DruidaDOMObjeto filtrar( Element e, HashSet hash, int i ){
    String expression = null;
    List list = null;
    DruidaDOMObjeto dom = null;

    expression = generateExpression( hash );
    list = selectNodes( expression, e );
    dom = generateConector( list, e );
  
    return dom;
  }


  //****************************************************************************
  //****************************************************************************
  // METODOS DE SERVICIO
  //****************************************************************************
  //genera el string de la consulta
  private static String generateExpression( HashSet set ){
    boolean isFirst = true;
    String nodo = null;
    Iterator it = set.iterator();

    StringBuffer sb = new StringBuffer( "//ROWSET2/ROWSET/ROW[" );

    while( it.hasNext() ){
      nodo = (String)it.next();

      //    ROW[ CAMPO[@NOMBRE='anio']!='2002' and CAMPO[@NOMBRE='anio']!='2003' ]
      sb.append( ((isFirst) ? "" : " and ") + "CAMPO[@NOMBRE='acceso']!='" + nodo + "'" );
      if( isFirst ) isFirst = false;
    }

    sb.append("]");

    return sb.toString();
  }

  //realiza la consulta y devuelve un List con los nodes
  //doc es el Element correspondiente al conector
  private static List selectNodes( String expression, Element doc ){
    List nodes = null;
    try{
      XPath exp = new DOMXPath( expression );
      nodes = exp.selectNodes(doc);
    }
    catch(Exception e){
      e.printStackTrace();
    }

    return nodes;
  }

  //Genera el DruidaDOMObjeto a devolver clonando nodos
  private static DruidaDOMObjeto generateConector(List nodes, Element doc){
    List lista2 = null;

    //primero clonar los nodos externos (#document, rowset2 y rowset)
    Node nodoRowset2 = null;
    Node nodoRowset = null;
    DocumentBuilder docBuild = null;
    Document newDoc = null;
    DruidaDOMObjeto dom = null;
    Node row = null;

    lista2 = selectNodes( "//ROWSET2", doc );
    if( lista2.size() > 0 ){
      nodoRowset2 = ((Node)lista2.get( 0 )).cloneNode(false) ;
    }

    lista2 = selectNodes( "//ROWSET2/ROWSET", doc );
    if( lista2.size() > 0 ){
      nodoRowset = ((Node)lista2.get( 0 )).cloneNode(false) ;
    }

    nodoRowset2.appendChild( nodoRowset );

    for( int i = 0; i < nodes.size(); i++ ){
      row = ((Node)nodes.get( i )).cloneNode( true );
      nodoRowset.appendChild( row );
    }
    
    try{
      //Crear un nuevo documento
      docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      newDoc = docBuild.newDocument();

      //Importar y aniadir el arbol de nodos creado
      Node importedNode = newDoc.importNode( nodoRowset2, true );
      newDoc.appendChild( importedNode );

      //Crear el DruidaDOMObjeto que se va a devolver
      dom = new DruidaDOMObjeto();
      dom.setXML( newDoc.getDocumentElement() );
    }
    catch( ParserConfigurationException pce ){
      pce.printStackTrace();
    }
    catch( Exception e ){
      e.printStackTrace();
    }

    return dom;
  }
  
}
