package es.indra.sicc.util.siccDruidaBridge;

import es.indra.druida.DruidaConector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.Vector;


public class SiccIterator implements Iterator {
   private Element element = null;
   private int intPosicion = 0;
   private int intLength = 0;
   private NodeList lista = null;

   public SiccIterator(DruidaConector conector) {
      this.element = conector.getXML();
      lista = this.element.getElementsByTagName("ROW");
      intLength = lista.getLength();
   }

   public boolean hasNext() {
      return intPosicion < intLength;
   }

   public Object next() {
      Vector salida = new Vector();
      Node actual = lista.item(intPosicion);

      for (int j = 0; j < actual.getChildNodes().getLength(); j++) {
         Node contexto = actual.getChildNodes().item(j);

         if (contexto.getNodeType() == Node.ELEMENT_NODE) {
            NodeList listaInterna = contexto.getChildNodes();

            for (int i = 0; i < listaInterna.getLength(); i++) {
               Node campo = listaInterna.item(i);
               salida.add(campo.getNodeValue());
            }
         }
      }

      intPosicion++;

      return salida;
   }

   public void remove() {
      this.element.removeChild(this.element.getChildNodes().item(intPosicion));
   }
}
