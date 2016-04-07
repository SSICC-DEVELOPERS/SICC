package es.indra.sicc.util.siccDruidaBridge;

import es.indra.druida.DruidaConector;

import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.util.xml.XMLEngine;
import es.indra.sicc.util.xml.XSLTFactory;
import es.indra.sicc.util.xml.filters.Filters;
import es.indra.sicc.util.xml.filters.FiltersValues;

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;


/**
 * Sistema:           Belcorp
 * Modulo:            SICCDruidaBridge
 * Componente:        DRUIDA
 * Fecha:             25/06/2003
 * Observaciones:     Depende de los servicios del paquete de xml del sicc.
 * Descripcion:       Clase que facilita la manipulacion de los conectores
 *                    de Druida.
 * @version           1.0
 * @autor             Gaston Acevedo
 */
public class SICCDruidaBridge {
   public SICCDruidaBridge() {
      super();
   }

   public DruidaConector getRowsetConector(DruidaConector conector, String id)
      throws Exception {
      /*
       * De un conector de Multiples Rowsets, extrae el que se indica en el parametro
       * id, devolviendo un nuevo conector con este rowset
       */
      try {
         Element ele = getRowsetAsElement(conector, id);
         DruidaConector drSalida = null;

         if (ele != null) {
            drSalida = new DruidaConector();

            XMLDocument docu = new XMLDocument();
            Document xDoc = docu.makeDocument("<ROWSET2/>");
            Node tmp = xDoc.importNode((Node) ele, true);
            xDoc.getDocumentElement().appendChild(tmp);

            //drSalida.setXML(docu.makeElement("<ROWSET2>" + docu.getStringFromElement(ele) + "</ROWSET2>"));
            drSalida.setXML(xDoc.getDocumentElement());
         } else {
            throw new Exception("No existe el Rowset con el id " + id);
         }

         return drSalida;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   private Element getRowsetAsElement(DruidaConector conector, String id)
      throws Exception {
      /*
       * Metodo utilizado internamente por los demas, implementacion.
       */
      try {
         NodeList nodelist = conector.getXML().getElementsByTagName("ROWSET");
         Element ele = null;
         int largo = nodelist.getLength();

         for (int i = 0; i < largo; i++) {
            ele = (Element) nodelist.item(i);

            if (ele.getAttribute("ID").equals(id)) {
               break;
            } else {
               ele = null;
            }
         }

         if (ele != null) {
            return (Element) ele.cloneNode(true);
         } else {
            throw new Exception("No se ha encontrado el ROWSET: " + id);
         }
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public String getRowsetString(DruidaConector conector, String id)
      throws Exception {
      try {
         StringBuffer salida = new StringBuffer();
         Element con = getRowsetAsElement(conector, id);

         if (con != null) {
            XMLDocument doc = new XMLDocument();
            Document xDoc = doc.makeDocument("<ROWSET2/>");
            Node tmp = xDoc.importNode((Node) con, true);
            xDoc.getDocumentElement().appendChild(tmp);
            salida.append(doc.getStringFromElement(xDoc.getDocumentElement()));
         }

         return salida.toString();
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public DruidaConector getRowsetsConector(DruidaConector conector, String id,
      String separator) throws Exception {
      /*
       * Extrae una serie de Rowset del conector de entrada, especificados
       * mediante el parametro id, que toma la forma de "id1|id2|id3".
       * El parametro separator indica el separador para el StringTokenizer
       */
      try {
         StringTokenizer tokens = new StringTokenizer(id, separator);
         Vector buffer = new Vector();
         Element newRowset = null;
         XMLDocument docu = new XMLDocument();
         Document xDoc = docu.makeDocument("<ROWSET2/>");

         while (tokens.hasMoreTokens()) {
            newRowset = getRowsetAsElement(conector, tokens.nextToken());

            if (newRowset != null) {
               Node tmp = xDoc.importNode((Node) newRowset, true);
               xDoc.getDocumentElement().appendChild(tmp);
            }
         }

         newRowset = null;
         docu = null;

         DruidaConector drSalida = new DruidaConector();
         drSalida.setXML(xDoc.getDocumentElement());

         return drSalida;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public DruidaConector getReorderRowsetsFields(DruidaConector conector,
      SICCDruidaParams parametros, boolean includeAllRowsets)
      throws Exception {
      /*
       * Reordena los campos de los distintos Rowsets de un conector.
       *
       * PARAMETROS:
       *
       * Conector: el conector a procesar.
       * id: vector con los ids de Rowsets de los cuales se reordenaran los campos.(Tipo String)
       *
       * fieldList: Vector con la lista de campos ordenada segun necesidad, se aplicara de
       * acuerdo al id correspondiente del vector "id".(Tipo String, separado por "|").
       *
       * includeAllFieds: Vector que indica si deben incorporarse  todos los campos,
       * inclusive aquellos que no se reordenan en la salida de cada Rowset(Tipo boolean)
       *
       * includeAllRowsets: Indica si deben incluirse todos los Rowsets del conector
       * en la salida, tanto aquellos indicados en el parametro id, como los no incluidos.
       */
      try {
         XMLEngine engine = new XMLEngine();
         XMLDocument classDoc = new XMLDocument();
         NodeList listaRowsets = null;
         Document docSalida = classDoc.makeDocument("<ROWSET2/>");
         Document docEntrada = conector.getXML().getOwnerDocument();
         listaRowsets = docEntrada.getDocumentElement().getElementsByTagName("ROWSET");

         String strRowset = "";
         int largo = listaRowsets.getLength();

         //si van todos los nodos copio el documentElement y listo
         if (includeAllRowsets) {
            for (int i = 0; i < largo; i++) {
               Node nodoActual = listaRowsets.item(i);
               strRowset = ((Element) nodoActual).getAttribute("ID");

               if (parametros.contains(strRowset)) {
                  SICCDruidaParam param = parametros.get(strRowset);
                  Node proc = (Node) engine.getReorderedXML((Element) nodoActual,
                        param.getFieldNames(), "|", param.getIncludeAll());
                  Node tmp2 = docSalida.importNode(proc, true);
                  docSalida.getDocumentElement().appendChild(tmp2);
               } else {
                  Node tmp2 = docSalida.importNode(nodoActual, true);
                  docSalida.getDocumentElement().appendChild(tmp2);
               }
            }
         } else { //armo un documento nuevo con los rowsets a trabajar solamente

            for (int i = 0; i < largo; i++) {
               Node nodoActual = listaRowsets.item(i);
               strRowset = ((Element) nodoActual).getAttribute("ID");

               if (parametros.contains(strRowset)) {
                  SICCDruidaParam param = parametros.get(strRowset);
                  Node proc = (Node) engine.getReorderedXML((Element) nodoActual,
                        param.getFieldNames(), "|", param.getIncludeAll());
                  Node tmp2 = docSalida.importNode(proc, true);
                  docSalida.getDocumentElement().appendChild(tmp2);
               }
            }
         }

         DruidaConector retorno = new DruidaConector();
         retorno.setXML(docSalida.getDocumentElement());

         return retorno;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public DruidaConector appendRowset(DruidaConector conectorOrigen,
      DruidaConector conectorDestino, String id, String separator)
      throws Exception {
      /*
       * Copia en el conector de destino, desde el conector origen,
       * los rowsets indicados en el parametro id, que toma la forma:
       * "id1|id2|id3".Devolviendo el nuevo conector
       */
      try {
         StringTokenizer tokens = new StringTokenizer(id, separator);
         StringBuffer buffer = new StringBuffer();
         XMLDocument classDoc = new XMLDocument();
         NodeList lista = conectorDestino.getXML().getElementsByTagName("ROWSET");

         Document docSalida = classDoc.makeDocument("<ROWSET2/>");

         int largo = lista.getLength();

         for (int i = 0; i < largo; i++) {
            Node tmp = docSalida.importNode(lista.item(i), true);
            docSalida.getDocumentElement().appendChild(tmp);
         }

         while (tokens.hasMoreTokens()) {
            Element el = getRowsetAsElement(conectorOrigen, tokens.nextToken());

            if (el != null) {
               Node tmp = docSalida.importNode((Node) el, true);
               docSalida.getDocumentElement().appendChild(tmp);
            }
         }

         DruidaConector drSalida = new DruidaConector();
         drSalida.setXML(docSalida.getDocumentElement());

         return drSalida;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public DruidaConector setNewIds(DruidaConector conector, HashMap ids)
      throws Exception {
      /*
       * Modifica los ids de los Rowsets del conector de entrada, por los nuevos ids
       * el HashMap debe complertase indicando como key, el id actual del Rowset, y como
       * valor, el nuevo id
       */
      try {
         XMLDocument classDoc = new XMLDocument();

         Document doc = classDoc.makeDocument(classDoc.getStringFromElement(
                  conector.getXML()));
         NodeList lista = doc.getElementsByTagName("ROWSET");

         for (int i = 0; i < lista.getLength(); i++) {
            String nombreRowset = ((Element) lista.item(i)).getAttribute("ID");

            if (ids.containsKey(nombreRowset)) {
               ((Element) lista.item(i)).setAttribute("ID",
                  (String) ids.get(nombreRowset));
            }
         }

         DruidaConector drCon = new DruidaConector();
         drCon.setXML(doc.getDocumentElement());

         return drCon;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public DruidaConector getMergedConector(DruidaConector conectorDestino,
      DruidaConector conectorOrigen, String idDestino, HashMap idsOrigen)
      throws Exception {
      /*
       * Metodo para mezclar el contenido de conectores a nivel CAMPO,
       * es decir, partiendo de un conector de base, permite adjuntar
       * registros desde otros conectores al mismo.
       *Parametros:
       * conectorDestino = Conector que se usara de base para la salida.
       *
       * conectorOrigen = Conector que contiene los datos a agregar.
       *
       * idDestino = String con el nombre del Rowset del conector origen al
       * cual se agregaran los datos
       *
       * idsOrigen = HashMap con los ids de los rowsets a tener en cuenta.
       *
       * Supongo que este metodo se puede optimizar, y bastante, feel free.
       *
       */
      try {
         XMLDocument classDoc = new XMLDocument();
         XMLEngine engine = new XMLEngine();
         Document docDestino = classDoc.makeDocument(engine.getElementAsString(
                  conectorDestino.getXML()));
         Element eleOrigen = classDoc.makeElement(engine.getElementAsString(
                  conectorOrigen.getXML()));

         Element nodoDestino = null;

         NodeList list = docDestino.getDocumentElement().getElementsByTagName("ROWSET");

         for (int i = 0; i < list.getLength(); i++) { //busco donde agregarlos

            if (((Element) list.item(i)).getAttribute("ID").equals(idDestino)) {
               nodoDestino = (Element) list.item(i);

               break;
            }
         }

         Element eleSalida = null;

         if (nodoDestino != null) { //ya tengo donde agregarlos

            Iterator keys = idsOrigen.keySet().iterator();
            list = eleOrigen.getElementsByTagName("ROWSET");

            Element rowsetOrigen = null;
            String idRowsetOrigen = null;

            while (keys.hasNext()) {
               idRowsetOrigen = (String) keys.next();

               for (int i = 0; i < list.getLength(); i++) {
                  if (((Element) list.item(i)).getAttribute("ID").equals(idRowsetOrigen)) {
                     rowsetOrigen = (Element) list.item(i);

                     break;
                  }
               }

               if (rowsetOrigen != null) {
                  Element eleFiltrado = engine.getReorderedXML(rowsetOrigen,
                        (String) idsOrigen.get(idRowsetOrigen), "|", false);
                  NodeList nodosHijos = eleFiltrado.getChildNodes();
                  int intNodosHijos = nodosHijos.getLength();

                  for (int j = 0; j < intNodosHijos; j++) {
                     Node nuevoNodo = nodosHijos.item(j);
                     Node nodoCopia = docDestino.importNode(nuevoNodo, true);
                     nodoDestino.appendChild(nodoCopia);
                  }
               }
            }
         }

         DruidaConector conSalida = new DruidaConector();
         conSalida.setXML(classDoc.makeElement(classDoc.getStringFromElement(
                  nodoDestino)));

         return conSalida;
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   public Iterator getIterator(DruidaConector conector)
      throws Exception {
      try {
         return new SiccIterator(conector);
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }

   private Document convertToDocument(Element el) throws Exception {
      /*
       * Metodo de implementacion utilizado internamente
       */
      try {
         XMLDocument doc = new XMLDocument();
         String tmp = doc.getStringFromElement(el);

         //UtilidadesLog.debug(tmp);
         return doc.makeDocument(tmp);
      } catch (Exception e) {
         UtilidadesLog.error(e);
         throw new Exception(e.toString());
      }
   }
}
