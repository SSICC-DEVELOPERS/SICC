import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.pre.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import LPSICCBase;

public class LPPruebaGrupo extends LPSICCBase {
/*  ******GRUPOS********   */
   Document doc = null;
   XMLDocument xml = null;

   private Element fieldset1 = null;
   private Element tr = null;
   private Element listaEditableObtenida = null;
   DTOPromocion elemPromocion = null;
   long indice = 0;
   //Integer yLista = new Integer(913);
   static int TAMANOPAGINASINDINAMICA = 728;
   Integer yLista;
   private Element table1 = null;
   private Element table2 = null;
   private Element table3 = null;
   private Element table5 = null;
   private Element table6 = null;
   private Element tablaAfueraG = null;
   private Element div = null;

   private Element tr1 = null;
   private Element tr2 = null;
   private Element tr3 = null;
   private Element tr5 = null;
   private Element tr6 = null;
   private Element fieldset2 = null;
   private Element fieldset3 = null;
   private Element fieldset4 = null;
   private Element legend1 = null;

   private String nombreLista="";


   public LPPruebaGrupo() {
      super();
   }

   public void inicio() throws Exception {
   }

   public void ejecucion() throws Exception {
      pagina("contenido_prueba_grupo");
      setTrazaFichero();
      Vector vecGrupos = new Vector();
      DTOGrupo dtoG = new DTOGrupo();
      dtoG.setOidGrupo(new Long(1));
      dtoG.setCondicionado(Boolean.FALSE);
      dtoG.setCondicionante(Boolean.FALSE);
      dtoG.setNumeroGrupo(new Integer(1));
      dtoG.setDescripcionIndicadorCuadre("Bla");
      dtoG.setFactorCuadre(new Integer(1));
      dtoG.setOidIndicadorCuadre(new Long(1));
      vecGrupos.add(dtoG);
      Vector vecDetalles = new Vector();
      DTODetalleOferta dtoD = new DTODetalleOferta();
      dtoD.setAtributo1("atri1");
      dtoD.setAtributo2("atri2");
      dtoD.setAtributo3("atri3");
      dtoD.setCentro("centro");
      dtoD.setCodigoSAP("codigo sap");
      //dtoD.setCosteEstandar(null);
      dtoD.setDescripcion("desc");
      dtoD.setDescripcionFormaPago("formapago");
      dtoD.setFactorRepeticion(new Integer(1));
      dtoD.setLineaOferta(new Integer(1));
      dtoD.setNumeroGrupo(new Integer(1));
      dtoD.setOidCatalogo(new Long(1));
      dtoD.setOidCicloVida(new Long(1));
      dtoD.setOidDetalleOferta(new Long(1));
      dtoD.setOidCondicionPromocion(new Long(1));
      dtoD.setOidGrupo(new Long(1));
      dtoD.setOidFormaPago(new Long(1));
      vecDetalles.add(dtoD);
      Long tipoEstra = new Long(3);
      xml = new XMLDocument();
      doc = xml.makeDocument("<table/>");
      Element listadoG = armarListaGrupos(vecGrupos, vecDetalles, tipoEstra.longValue());
      DruidaConector conG = new DruidaConector();
      conG.setXML(listadoG);
      asignar("REJILLA", "rejlistado4", conG);
   }
   
    private Element armarListaGrupos(Vector vectorDtoGrupo, Vector vectorDtoDetalles, long tipoEstr)
           throws Exception {
      Iterator grupos = vectorDtoGrupo.iterator();
      traza("armarListaGrupos 0");
      //tablaEnglobaG = doc.createElement("table");
      div = doc.createElement("DIV");
      yLista = new Integer(TAMANOPAGINASINDINAMICA);
      Element listaEditableObtenida = null;
      traza("armarListaGrupos 1");
      Element capaPrincipalG = doc.createElement("CAPA");
      capaPrincipalG.setAttribute("nombre", "capaGrupos");
      capaPrincipalG.setAttribute("alto", "100%");
      capaPrincipalG.setAttribute("ancho", "100%");
      capaPrincipalG.setAttribute("colorf", "");
      capaPrincipalG.setAttribute("borde", "0");
      capaPrincipalG.setAttribute("imagenf", "");
      capaPrincipalG.setAttribute("repeat", "");
      capaPrincipalG.setAttribute("padding", "");
      capaPrincipalG.setAttribute("visibilidad", "visible");
      capaPrincipalG.setAttribute("contravsb", "");
      capaPrincipalG.setAttribute("x", "0");
      capaPrincipalG.setAttribute("y", yLista.toString());
      capaPrincipalG.setAttribute("zindex", "");

      div.appendChild(capaPrincipalG);
      //T1 TABLA 1
      tablaAfueraG = doc.createElement("table");
      tablaAfueraG.setAttribute("width", "100%");
      tablaAfueraG.setAttribute("border", "0");
      tablaAfueraG.setAttribute("cellspacing", "0");
      tablaAfueraG.setAttribute("cellpadding", "0");
      traza("armarListaGrupos 4");
      //PRIMERA FILA DE LA TABLA AFUERA
      /*-----------------------------------------------------------------------------------------------------*/
      tr = getTR(3);

      //T1 F1 C1 Col 1
      tr.getChildNodes().item(0).appendChild(getIMG(12, 12));

      //T1 F1 C2 Col 2
      tr.getChildNodes().item(1).appendChild(getIMG(1, 1));
      ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");

      //System.out.println("metodo armar lista1 ");
      //T1 F1 C3 Col 3
      tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
      //cierre de tr
      tablaAfueraG.appendChild(tr);

      //T1 F1 fin primera fila
      /*-----------------------------------------------------------------------------------------------------*/
      //SEGUNDA FILA DE LA TABLA AFUERA
      tr = getTR(3);
      tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
      fieldset1 = getFIELDSET();
      legend1 = getLEGENDGrupos();
      fieldset1.appendChild(legend1);
      DTOGrupo grupo = null;
      while (grupos.hasNext()) {
         grupo = (DTOGrupo) grupos.next();
         traza("****************************************************");
         traza("DTO GRUPO!!!!!   = " + grupo.getNumeroGrupo());
         traza("****************************************************");
         table1 = doc.createElement("table");
         table1.setAttribute("width", "100%");
         table1.setAttribute("border", "0");
         table1.setAttribute("align", "center");
         table1.setAttribute("cellspacing", "0");
         table1.setAttribute("cellpadding", "0");

         // Tabla 1 fila 1
         tr1 = getTR(1);
         tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
         ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
         table1.appendChild(tr1);

         //2
         tr1 = getTR(3);
         tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));
         ((Element) tr1.getChildNodes().item(1)).setAttribute("width", "100%");
         table2 = doc.createElement("table");
         table2.setAttribute("width", "100%");
         table2.setAttribute("border", "0");
         table2.setAttribute("cellspacing", "0");
         table2.setAttribute("cellpadding", "0");

         tr2 = getTR(1);

         fieldset2 = getFIELDSET();

         table3 = doc.createElement("table");
         table3.setAttribute("width", "100%");
         table3.setAttribute("border", "0");
         table3.setAttribute("cellspacing", "0");
         table3.setAttribute("align", "center");
         table3.setAttribute("cellpadding", "0");

         //1
         tr3 = getTR(1);
         tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
         ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
         table3.appendChild(tr3);

         //2
         tr3 = getTR(10);
         tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));

         Element labelC2 = getLABELC("lblNumeroCondicion123" + indice, "110", "17", "1", "",
                                     "datosTitle", "533");
         tr3.getChildNodes().item(1).appendChild(labelC2);
         tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));
         labelC2 = getLABELC("lblIndicadorCuadre123" + indice, "110", "17", "1", "", "datosTitle", "005");
         tr3.getChildNodes().item(3).appendChild(labelC2);
         tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));
         labelC2 = getLABELC("lblFactorCuadre123" + indice, "120", "17", "1", "", "datosTitle", "006");
         tr3.getChildNodes().item(5).appendChild(labelC2);
         tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));
         labelC2 = getLABELC("lblTipoGrupo1" + indice, "130", "17", "1", "", "datosTitle", "479");
         tr3.getChildNodes().item(7).appendChild(labelC2);
         tr3.getChildNodes().item(8).appendChild(getIMG(81, 8));
         ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "88");
         tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
         ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");
         table3.appendChild(tr3);

         //3
         tr3 = getTR(10);

         tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
         labelC2 = getLABEL("lblNumeroCondicionXX23" + indice, "60", "17", "1", ((grupo.getNumeroGrupo() == null) ? "" : grupo.getNumeroGrupo().toString()),
                            "datosCampos");

         tr3.getChildNodes().item(1).appendChild(labelC2);

         tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));

         labelC2 = getLABEL("lblIndicadorCuadreXX23" + indice, "", "17", "1",
                            ((grupo.getOidIndicadorCuadre() == null) ? ""
                             : grupo.getDescripcionIndicadorCuadre()
                            ), "datosCampos");
         tr3.getChildNodes().item(3).appendChild(labelC2);

         tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));

         labelC2 = getLABEL("lblFactorCuadreXX23" + indice, "130", "17", "1",
                            ((grupo.getFactorCuadre() == null) ? "" : grupo.getFactorCuadre().toString()),
                            "datosCampos");
         tr3.getChildNodes().item(5).appendChild(labelC2);

         tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));

         String tipoGrupo = new String();

         /*+ Grupos: (Se muestran si se recogieron datos para los grupos, es decir DTOOferta.grupo != Null). Se muestra una cabecera por grupo (DTOGrupo) con los valores
            - Número grupo = DTOGrupo.numeroGrupo
            - Indicador cuadre = DTOGrupo.descripcionIndicadorCuadre
            - Factor cuadre = DTOGrupo.factorCuadre
            - Tipo grupo
                                          "Paquete" -> Si DTOGrupo.indicadorGrupo == False
                                          "Grupo" -> Si DTOGrupo.condicionante == False AND DTOGrupo.condicionado == False
                                          "Grupo condicionante" -> Si DTOGrupo.condicionante == True
                                          "Grupo condicionado" -> Si DTOGrupo.condicionado == True */
         if ((grupo.getIndicadorGrupo().booleanValue() == true)) {
            tipoGrupo = new String("Paquete");
         } else if ((grupo.getCondicionado().booleanValue() == false) &&
                    (grupo.getCondicionante().booleanValue() == false)) {
            tipoGrupo = "Grupo";
         } else if (grupo.getCondicionado().booleanValue() == true) {
            tipoGrupo = "Grupo Condicionado";
         } else if (grupo.getCondicionante().booleanValue() == true) {
            tipoGrupo = "Grupo Condicionante";
         }

         labelC2 = getLABEL("lblTipoGrupoXX1" + indice, "130", "17", "1", "" + tipoGrupo, "datosCampos");
         tr3.getChildNodes().item(7).appendChild(labelC2);

         tr3.getChildNodes().item(8).appendChild(getIMG(8, 8));
         ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "1");
         tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
         ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");

         table3.appendChild(tr3);

         //4
         tr3 = getTR(1);
         tr3.getChildNodes().item(0).appendChild(getIMG(8, 310));
         ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
         table3.appendChild(tr3);

         //fin filas tabla 3
         fieldset2.appendChild(table3);
         tr2.getChildNodes().item(0).appendChild(fieldset2);
         table2.appendChild(tr2);
         tr1.getChildNodes().item(1).appendChild(table2);

         //3
         tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));

         table1.appendChild(tr1);

         //FIN FILA 2
         //F3
         tr1 = getTR(3);

         tr1.getChildNodes().item(0).appendChild(getIMG(0, 0));
         fieldset3 = getFIELDSET();
         table5 = doc.createElement("table");
         table5.setAttribute("width", "100%");
         table5.setAttribute("border", "0");
         table5.setAttribute("align", "center");
         table5.setAttribute("cellspacing", "0");
         table5.setAttribute("cellpadding", "0");
         tr5 = getTR(1);
         tr5.getChildNodes().item(0).appendChild(getBOTONEliminar("btnEliminar" + String.valueOf(indice), "botonContenido", "html", "accionEliminarGrupo    ('btnEliminar" + String.valueOf(indice) + "');", "false", "1254", (grupo.getNumeroGrupo() == null ? "" : grupo.getNumeroGrupo().toString())));
         traza("Nro Grupo: " + grupo.getNumeroGrupo());

         ((Element) tr5.getChildNodes().item(0)).setAttribute("class", "botonera");
         ((Element) tr5.getChildNodes().item(0)).setAttribute("width", "100%");
         table5.appendChild(tr5);
         fieldset3.appendChild(table5);
         tr1.getChildNodes().item(1).appendChild(fieldset3);
         tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));
         table1.appendChild(tr1);

         //fin fila 3


         //F4
         tr1 = getTR(1);
         tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
         ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
         table1.appendChild(tr1);

         //fin fila 4


         fieldset1.appendChild(table1);
         listaEditableObtenida = (Element) (doc.importNode((Node) armarListaEditableGrupos(vectorDtoDetalles, grupo.getNumeroGrupo()), true));
         yLista = new Integer(yLista.intValue() + 395);
         div.appendChild(listaEditableObtenida);
      }
      //F5
      tr1 = getTR(3);
      tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));

      tr1.getChildNodes().item(2).appendChild(getIMG(8, 8));
      ((Element) tr1.getChildNodes().item(2)).setAttribute("width", "100%");
      table1.appendChild(tr1);

      //fin fila 5
      //F6
      tr1 = getTR(3);
      tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));

      //Tomar el tipo de estrategia
      Element combo = getCOMBO("cbTipoGrupo2", "datosCampos", "1", "N", "N");
      //contador = contador+1;
      Element rowset = getROWSET();

      if (tipoEstr == 3) {
         traza("estrategia 3");
         Element campos = getCAMPOS(2, "1");
         ((Element) campos.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
         ((Element) campos.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
         ((Element) campos.getChildNodes().item(0)).setAttribute("VALOR", "1");

         ((Element) campos.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
         ((Element) campos.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
         ((Element) campos.getChildNodes().item(1)).setAttribute("VALOR", "Grupo");

         rowset.appendChild(campos);
      } else if (tipoEstr == 4) {
         traza("estrategia 4");
         Element campos3 = getCAMPOS(2, "3");
         ((Element) campos3.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
         ((Element) campos3.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
         ((Element) campos3.getChildNodes().item(0)).setAttribute("VALOR", "3");
         ((Element) campos3.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
         ((Element) campos3.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
         ((Element) campos3.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionantes");
         rowset.appendChild(campos3);

         Element campos4 = getCAMPOS(2, "4");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "4");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
         rowset.appendChild(campos4);
      } else if (tipoEstr == 6) {
         traza("estrategia 6");
         Element campos2 = getCAMPOS(2, "2");
         ((Element) campos2.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
         ((Element) campos2.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
         ((Element) campos2.getChildNodes().item(0)).setAttribute("VALOR", "2");

         ((Element) campos2.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
         ((Element) campos2.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
         ((Element) campos2.getChildNodes().item(1)).setAttribute("VALOR", "Paquete");
         rowset.appendChild(campos2);
      } else if (tipoEstr == 7) {
         traza("estrategia 7");
         Element campos4 = getCAMPOS(2, "4");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
         ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "4");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
         ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
         rowset.appendChild(campos4);
      }

      combo.appendChild(rowset);
      tr1.getChildNodes().item(1).appendChild(combo);
      tr1.getChildNodes().item(2).appendChild(getIMG(8, 8));
      ((Element) tr1.getChildNodes().item(2)).setAttribute("width", "100%");
      table1.appendChild(tr1);

      //fin fila 6
      //F7
      tr1 = getTR(1);
      tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
      ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
      table1.appendChild(tr1);

      yLista = new Integer(yLista.intValue() + 100);
      tr.getChildNodes().item(1).appendChild(fieldset1);
      tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
      //((Element)tr.getChildNodes().item(0)).setAttribute("style","background-color:silver");
      tablaAfueraG.appendChild(tr);

      //FIN SEGUNDA FILA DE LA TABLA AFUERA

      /*-----------------------------------------------------------------------------------------------------*/
      /*-----------------------------------------------------------------------------------------------------*/

      //TERCERA FILA DE LA TABLA AFUERA
      tr = getTR(3);
      tr.getChildNodes().item(0).appendChild(getIMG(0, 0));

      fieldset4 = getFIELDSET();
      table6 = doc.createElement("table");
      table6.setAttribute("width", "100%");
      table6.setAttribute("align", "center");
      table6.setAttribute("border", "0");
      table6.setAttribute("cellspacing", "0");
      table6.setAttribute("cellpadding", "0");
      tr6 = getTR(1);
      ((Element) tr6.getChildNodes().item(0)).setAttribute("class", "botonera");
      ((Element) tr6.getChildNodes().item(0)).setAttribute("width", "100%");

      Element boton = getBOTON("btnAnadir2", "botonContenido", "html", "accionAniadirGrupo();", "false", "404");

      tr6.getChildNodes().item(0).appendChild(boton);
      table6.appendChild(tr6);
      fieldset4.appendChild(table6);

      tr.getChildNodes().item(1).appendChild(fieldset4);

      tr.getChildNodes().item(2).appendChild(getIMG(12, 12));

      tablaAfueraG.appendChild(tr);

      //FIN TERCERA FILA DE LA TABLA AFUERA

      /*------------------------------------------------------------------------------------------------------*/

      //CUARTA FILA DE LA TABLA AFUERA
      tr = getTR(3);
      tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
      ((Element) tr.getChildNodes().item(0)).setAttribute("width", "12");
      ((Element) tr.getChildNodes().item(0)).setAttribute("align", "center");

      tr.getChildNodes().item(1).appendChild(getIMG(0, 0));
      ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");

      tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
      ((Element) tr.getChildNodes().item(2)).setAttribute("width", "12");

      tablaAfueraG.appendChild(tr);

      //FIN CUARTA FILA DE LA TABLA AFUERA
      capaPrincipalG.appendChild(tablaAfueraG);

      /*-------------------------------------------------------------------------------------------------------*/
      return div;
   }


    /*------------------------------------------------------------------------------------------------*/
    private Element armarListaEditableGrupos(Vector v, Integer nroGrupo) throws Exception {
        traza("metodo armarListaEditable()");
        ListaEditableDinamica listado = new ListaEditableDinamica(this, "listado4" + String.valueOf(indice), 7, 0, true, "mipgndo4" + String.valueOf(indice));
        if (nombreLista.equals("")) {
            nombreLista = "listado4" + String.valueOf(indice);
        } else {
            nombreLista = nombreLista + "|" + "listado4" + String.valueOf(indice);
        }

        listado.setCodigoColumna(0, "8");
        listado.setCodigoColumna(1, "9");
        listado.setCodigoColumna(2, "529");
        listado.setCodigoColumna(3, "530");
        listado.setCodigoColumna(4, "481");
        listado.setCodigoColumna(5, "482");
        listado.setCodigoColumna(6, "483");
        listado.setAnchoColumna(0, 100);
        listado.setAnchoColumna(1, 100);
        listado.setAnchoColumna(2, 100);
        listado.setAnchoColumna(3, 100);
        listado.setAnchoColumna(4, 100);
        listado.setAnchoColumna(5, 100);
        listado.setAnchoColumna(6, 100);

        Iterator detalles = v.iterator();

        while (detalles.hasNext()) {

            DTODetalleOferta ofertaDetalle = (DTODetalleOferta) detalles.next();

            traza("Oid Grupo Oferta = " + ofertaDetalle.getNumeroGrupo());
            traza("Nro Grupo = " + nroGrupo);
            if ((ofertaDetalle.getNumeroGrupo() != null) && ofertaDetalle.getNumeroGrupo().equals(nroGrupo)) {

                traza("traza 19");

                ofertaDetalle.setNumeroGrupo(nroGrupo);
                String oid = "" + (ofertaDetalle.getOidDetalleOferta() == null ? "" : ofertaDetalle.getOidDetalleOferta().toString());
                String codSap = (ofertaDetalle.getCodigoSAP()!=null)?ofertaDetalle.getCodigoSAP().toString():"";
                String desc = (ofertaDetalle.getDescripcion()!=null)?ofertaDetalle.getDescripcion().toString():"";
                String factRep = "" + (ofertaDetalle.getFactorRepeticion() == null ? "" : ofertaDetalle.getFactorRepeticion().toString());
                String precCatalogo = "" + (ofertaDetalle.getPrecioCatalogo() == null ? "" : ofertaDetalle.getPrecioCatalogo().toString());
                String atr1 = (ofertaDetalle.getAtributo1()!=null)?ofertaDetalle.getAtributo1().toString():"";
                String atr2 = (ofertaDetalle.getAtributo2()!=null)?ofertaDetalle.getAtributo2().toString():"";
                String atr3 = (ofertaDetalle.getAtributo3()!=null)?ofertaDetalle.getAtributo3().toString():"";
                listado.addFila(new String[]{oid, codSap, desc, factRep, precCatalogo, atr1, atr2, atr3});
            }
        }
        indice = indice + 1;
        traza("nroGrupo" + nroGrupo);
        listado.agregarBoton("Modificar4" + String.valueOf(indice), "botonContenido", new Boolean("True"), 2, "accionModificarGrupo(" + String.valueOf(nroGrupo) + ");");
        listado.setAlto(290);
        listado.setX(32);
        listado.setY(yLista.intValue() + 90);
        listado.setYBoton(yLista.intValue() + 342);
        return listado.getLista();
    }


/* ---------------------------------------------------------------------------------------------------*/
    private Element getROWSET() {
        Element rowset = doc.createElement("ROWSET");

        return rowset;
    }


    private Element getCAMPOS(int cps, String id) {
        Element tr = doc.createElement("ROW");
        tr.setAttribute("ID", id);
        while (cps > 0) {
            tr.appendChild(doc.createElement("CAMPO"));
            cps--;
        }
        return tr;
    }

    private Element getBOTON(String nombre, String id, String tipo, String accion, String estado, String cod) {
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre", nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);
        return boton;
    }

    private Element getBOTONEliminar(String nombre, String id, String tipo, String accion, String estado, String cod, String codigo) {
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre", nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);
        boton.setAttribute("codigo", codigo);
        return boton;
    }

    private Element getIMG(int width, int height) {
        Element img = doc.createElement("IMG");
        img.setAttribute("src", "b.gif");
        img.setAttribute("width", "" + width);
        img.setAttribute("height", "" + height);
        return img;
    }

    private Element getTR(int tds) {
        Element tr = doc.createElement("tr");
        while (tds > 0) {
            tr.appendChild(doc.createElement("td"));
            tds--;
        }
        return tr;
    }

    private Element getFIELDSET() {
        Element fieldset = doc.createElement("fieldset");
        return fieldset;
    }

    private Element getLegend() {
        Element legend = doc.createElement("legend");
        legend.setAttribute("class", "legend");
        legend.appendChild(getLABELC("lblPromociones", "105", "13", "1", "", "legend", "00117"));
        return legend;
    }

    private Element getLABELC(String nombre, String ancho, String alto, String filas, String valor, String id, String cod) {
      Element labelC = doc.createElement("LABELC");
        labelC.setAttribute("nombre", nombre);
        labelC.setAttribute("ancho", ancho);
        labelC.setAttribute("alto", alto);
        labelC.setAttribute("filas", filas);
        labelC.setAttribute("valor", valor);
        labelC.setAttribute("id", id);
        labelC.setAttribute("cod", cod);
        return labelC;
    }

    private Element getLABEL(String nombre, String ancho, String alto,
                        String filas, String valor, String id) {
        Element label = doc.createElement("LABEL");
        label.setAttribute("nombre", nombre);
        label.setAttribute("ancho", ancho);
        label.setAttribute("alto", alto);
        label.setAttribute("filas", filas);
        label.setAttribute("valor", valor);
        label.setAttribute("id", id);
        //label.setAttribute("cod", cod);

        return label;
    }

   private Element getCOMBO(String nombre, String id, String size, String multiple, String req) {
      Element combo = doc.createElement("COMBO");
      combo.setAttribute("nombre", nombre);
      combo.setAttribute("id", id);
      combo.setAttribute("size", size);
      combo.setAttribute("multiple", multiple);
      combo.setAttribute("req", req);
      // combo.setAttribute("valorinicial",valorinicial);
      // combo.setAttribute("textoinicial",textoinicial);
      combo.appendChild(doc.createElement("ROWSET"));
      return combo;
   }
   private Element getLEGENDGrupos() {
      Element legend = doc.createElement("legend");
      legend.setAttribute("class", "legend");
      legend.appendChild(getLABELC("lblGrupos", "50", "13", "1", "", "legend", "545"));
      return legend;
   }

}
