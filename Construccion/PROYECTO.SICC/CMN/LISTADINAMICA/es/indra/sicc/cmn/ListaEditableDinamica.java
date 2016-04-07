package es.indra.sicc.cmn;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class ListaEditableDinamica {
   /*
   public static final int COLUMNA_TIPO_COMBO = 0;
   public static final int COLUMNA_TIPO_CAJA_TEXTO = 1;
   public static final int COLUMNA_TIPO_CHECKBOX = 2;
   public static final int COLUMNA_TIPO_RADIO = 3;
   public static final int COLUMNA_TIPO_TEXTO = 4;
   */
   private Element lista;
   private boolean esPaginada = false;
   private final int corrimiento_paginado_Y = 298;
   private NodeList listaColumnasCabecera;
   private NodeList listaColumnas;
   private Element boton = null;

   public ListaEditableDinamica(DruidaBase lp) throws Exception {
      crearLista(lp, "listado1", 4, 10, false, "mipgndo1");
   }

   public ListaEditableDinamica(DruidaBase lp, String nombreLista,
      int columnas, int filas) throws Exception {
      crearLista(lp, nombreLista, columnas, filas, false, "");
   }

   public ListaEditableDinamica(DruidaBase lp, String nombreLista,
      int columnas, int filas, boolean esPaginado, String nombrePaginado)
      throws Exception {
      crearLista(lp, nombreLista, columnas, filas, esPaginado, nombrePaginado);
   }

   private void crearLista(DruidaBase lp, String nombreLista, int columnas,
      int filas, boolean esPaginado, String nombrePaginado)
      throws Exception {
      Element el = lp.getXML().createElement("ROWSET");
      DruidaConector con1 = new DruidaConector();
      con1.setXML(el);

      HashMap mapa = new HashMap();
      mapa.put("nombre", nombreLista);
      mapa.put("columnas", columnas + "");
      mapa.put("filas", filas + "");

      if (esPaginado) {
         mapa.put("esPaginado", "1");
      } else {
         mapa.put("esPaginado", "0");
      }
      mapa.put("nombrePaginado", nombrePaginado + "");
      esPaginada = esPaginado;
      DruidaConector salida = lp.transformar("XSLListaEditableDinamica", con1, mapa);
      lista = salida.getXML();
      NodeList listaNodos = lista.getElementsByTagName("CABECERA");
      listaColumnasCabecera = ((Element) listaNodos.item(0)).getElementsByTagName("COL");
      listaNodos = lista.getElementsByTagName("COLUMNAS");
      listaColumnas = ((Element) listaNodos.item(0)).getElementsByTagName("COL");
   }

   public int getX(){
      return new Integer(lista.getAttribute("x")).intValue();
   }
   public void setX(int x) {
      int diferencia = x - new Integer(lista.getAttribute("x")).intValue();
      lista.setAttribute("x", String.valueOf(x));

      if (esPaginada) {
         NodeList listaNodos = lista.getElementsByTagName("PAGINADO");
         if (listaNodos.getLength() > 0) {
            ((Element) listaNodos.item(0)).setAttribute("x", String.valueOf(x));
            NodeList listaBotones = ((Element) listaNodos.item(0)).getElementsByTagName("BOTON");
            if (listaBotones.getLength() > 0) {
               int largo = listaBotones.getLength();
               for (int i = 0; i < largo; i++) {
                  Element boton = (Element) listaBotones.item(i);
                  int posicionBoton = new Integer(boton.getAttribute("x")).intValue();
                  boton.setAttribute("x",  String.valueOf(posicionBoton + diferencia));
               }
            }
         }
      }
   }

   public int getY(){
      return new Integer(lista.getAttribute("y")).intValue();
   }
   
   public void setY(int y) {
      lista.setAttribute("y", String.valueOf(y));

      if (esPaginada) {
         NodeList listaNodos = lista.getElementsByTagName("PAGINADO");

         if (listaNodos.getLength() > 0) {
            int nuevaPosicion = y + corrimiento_paginado_Y;
            ((Element) listaNodos.item(0)).setAttribute("y", String.valueOf(nuevaPosicion));
            NodeList listaBotones = ((Element) listaNodos.item(0)).getElementsByTagName("BOTON");
            if (listaBotones.getLength() > 0) {
               int largo = listaBotones.getLength();
               for (int i = 0; i < largo; i++) {
                  ((Element) listaBotones.item(i)).setAttribute("y", String.valueOf(nuevaPosicion));
               }
            }
         }
      }
   }

   public void setAlto(int alto) {
      int diferenciaAlto = alto-new Integer(lista.getAttribute("alto")).intValue();
      lista.setAttribute("alto", String.valueOf(alto));
      //ahora si es paginado lo muevo para que no quede en cualquier lugar
      if (esPaginada) {
         NodeList listaNodos = lista.getElementsByTagName("PAGINADO");
         if (listaNodos.getLength() > 0) {
            int nuevaPosicion = new Integer(((Element) listaNodos.item(0)).getAttribute("y")).intValue() + diferenciaAlto;
            ((Element) listaNodos.item(0)).setAttribute("y", String.valueOf(nuevaPosicion));
            NodeList listaBotones = ((Element) listaNodos.item(0)).getElementsByTagName("BOTON");
            if (listaBotones.getLength() > 0) {
               int largo = listaBotones.getLength();
               for (int i = 0; i < largo; i++) {
                  int nuevaPosicionBoton = new Integer(((Element) listaBotones.item(1)).getAttribute("y")).intValue() + diferenciaAlto;
                  ((Element) listaBotones.item(i)).setAttribute("y", String.valueOf(nuevaPosicionBoton));
               }
            }
         }         
      }
   }

   public void addFila(String[] columnas) {
      if (columnas == null) {
         return;
      }

      NodeList rowsets = ((Element) lista).getElementsByTagName("ROWSET");
      Element rowset = null;
      for (int i = 0; i < rowsets.getLength(); i++) {
         String nodeName = rowsets.item(i).getParentNode().getNodeName();
         if (nodeName.equals("LISTAEDITABLE")) {
            rowset = (Element) rowsets.item(i);
            break;
         }
      }

      int numFila = rowset.getChildNodes().getLength() + 1;

      Document doc = rowset.getOwnerDocument();
      Element row = doc.createElement("ROW");
      rowset.appendChild(row);
      row.setAttribute("ID", String.valueOf(numFila));
      for (int i = 0; i < columnas.length; i++) {
         row.appendChild(crearCampo(doc, columnas[i], i == 0));
      }
   }

   public void setXBoton(int newX){
      if(boton!=null){
         boton.setAttribute("x",String.valueOf(newX));
      }
   }

   public void setYBoton(int newY){
      if(boton!=null){
         boton.setAttribute("y",String.valueOf(newY));
      }
   }


   private Element crearCampo(Document doc, String valor, boolean oculta) {
      Element campo = doc.createElement("CAMPO");

      if (oculta) {
         campo.setAttribute("NOMBRE", "dato1");
      } else {
         campo.setAttribute("NOMBRE", "dato4");
      }
      campo.setAttribute("TIPO", "STRING");
      campo.setAttribute("VALOR", valor);
      return campo;
   }

   public void setCodigoColumna(int columna, String codigo) {
      if (columna <= listaColumnasCabecera.getLength()) {
         ((Element) listaColumnasCabecera.item(columna)).setAttribute("cod",  codigo);
      }
   }

   public void setAnchoColumna(int columna, int ancho) {
      if (columna <= listaColumnas.getLength()) {
         ((Element) listaColumnas.item(columna)).setAttribute("ancho", String.valueOf(ancho));
      }
   }

   public void setColumnaInvisible(int columna) {
      if (columna <= listaColumnas.getLength()) {
         ((Element) listaColumnas.item(columna)).setAttribute("ancho", "0");
         ((Element) listaColumnas.item(columna)).removeAttribute("minimizable");
         ((Element) listaColumnas.item(columna)).removeAttribute("minimizada");
      }

      if (columna <= listaColumnasCabecera.getLength()) {
         ((Element) listaColumnasCabecera.item(columna)).setAttribute("ID", "");
         ((Element) listaColumnasCabecera.item(columna)).setAttribute("colFondo", "");
         ((Element) listaColumnasCabecera.item(columna)).removeAttribute("align");
         ((Element) listaColumnasCabecera.item(columna)).removeAttribute("cod");
      }
   }

   public Element getLista() {
      return lista;
   }

   public void agregarBoton(String nombre, String id, Boolean estado, int codigo, String accion) {
      if (!esPaginada) {
         throw new UnsupportedOperationException("La Lista no es paginada, no pueden crearse botones para ella");
      }

      boton = lista.getOwnerDocument().createElement("BOTON");
      boton.setAttribute("tipo", "html");
      boton.setAttribute("ID", id);
      boton.setAttribute("nombre", nombre);
      boton.setAttribute("estado", estado.toString());
      boton.setAttribute("cod", String.valueOf(codigo));

      if (accion != null) {
         boton.setAttribute("accion", accion);
      } else {
         boton.setAttribute("accion", "");
      }

      int xLista = new Integer(lista.getAttribute("x")).intValue();
      int yLista = new Integer(lista.getAttribute("y")).intValue();
      int altoLista = new Integer(lista.getAttribute("alto")).intValue();
      boton.setAttribute("x",String.valueOf(xLista+1));
      boton.setAttribute("y",String.valueOf((altoLista+yLista)-38));
      NodeList listaNodos = lista.getElementsByTagName("PAGINADO");

      if (listaNodos.getLength() > 0) {
         listaNodos.item(0).appendChild(boton);
      }
   }
}
