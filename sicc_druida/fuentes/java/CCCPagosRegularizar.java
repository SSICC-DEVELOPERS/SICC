import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class CCCPagosRegularizar extends LPSICCBase {           
   public CCCPagosRegularizar() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("CCCPagosRegularizar");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
     pagina("contenido_informe_pagos_regularizar_generar");  
     
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     dto.setOidPais(UtilidadesSession.getPais(this));
          
     MareBusinessID id = new MareBusinessID("CCCObtieneBancos");
     Vector vec = new Vector();
          
     vec.add(dto);
     vec.add(id);
     DTOSalida dtoTP = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
     RecordSet mc = (RecordSet)dtoTP.getResultado();
     Vector colMC = mc.getColumnIdentifiers();
     DruidaConector mcs = generarConector("DTOSalida.mc_ROWSET",mc, colMC);
     
     asignar("COMBO", "cbBanco", mcs, "DTOSalida.mc_ROWSET");  
     
     DTOBelcorp dtoBEL = new DTOBelcorp();
     dtoBEL.setOidPais(UtilidadesSession.getPais(this));
     MareBusinessID idNum = new MareBusinessID("CCCRecargaCC");
     Vector vecNUM= new Vector();
     vecNUM.add(dtoBEL);
     vecNUM.add(idNum);
     DTOSalida dtoNum = (DTOSalida) conectar("ConectorUA",vecNUM).objeto("dtoSalida"); 
     RecordSet numero = (RecordSet)dtoNum.getResultado();
     Vector colNumero = numero.getColumnIdentifiers();
     DruidaConector numeros = generarConector("DTOSalida.numeros_ROWSET",numero, colNumero);
     traza("colNumero "+dtoNum.getResultado());
     traza("colNumero "+dtoNum.getResultado().getColumnIdentifiers());
     this.crearListaLP(colNumero, numero.getColumnCount(), "CapaCC","ListaCC", "14", "200");
     asignar("LISTA", "ListaCC", numeros, "DTOSalida.numeros_ROWSET"); 
     
     this.generarHiddenFormatoFecha();
     String fechaActual = null;
     java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
     String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
     formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
            
     SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
     fechaActual = simpleDate.format(fecha);
     traza("la fecha actual " + fechaActual);
     asignarAtributo("VAR", "fechaActual", "valor", fechaActual);     
      
  }
  
   private void crearListaLP(Vector nomColumns, int cantColumns,
          String nomCapa, String nomLista, String XCapa, String YCapa)
          throws Exception {
          traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);

          Document document = getXML();

          Element eCapa = document.createElement("CAPA");
          eCapa.setAttribute("nombre", nomCapa);
          eCapa.setAttribute("alto", "162");
          eCapa.setAttribute("ancho", "580");
          eCapa.setAttribute("colorf", "");
          eCapa.setAttribute("borde", "1");
          eCapa.setAttribute("imagenf", "");
          eCapa.setAttribute("repeat", "");
          eCapa.setAttribute("padding", "");
          eCapa.setAttribute("visibilidad", "hidden");
          eCapa.setAttribute("contravsb", "");
          eCapa.setAttribute("zindex", "");
          eCapa.setAttribute("x", XCapa);
          eCapa.setAttribute("y", YCapa);

          Element eLista = document.createElement("LISTA");

          eLista.setAttribute("seleccion", "boton");
          eLista.setAttribute("nombre", nomLista);
          eLista.setAttribute("ancho", "580");
          eLista.setAttribute("alto", "150");
          eLista.setAttribute("multisel", "0");
          eLista.setAttribute("incy", "1");
          eLista.setAttribute("incx", "10");
          eLista.setAttribute("colorf", "#EFEFEF");
          eLista.setAttribute("imagenoff", "close_no.gif");
          eLista.setAttribute("imagenon", "close_up.gif");
          eLista.setAttribute("accion", "");
          eLista.setAttribute("sep", "|");
          eLista.setAttribute("pixelsborde", "3");
          eLista.setAttribute("colorborde", "#CCCCCC");

          Element eCABECERA = document.createElement("CABECERA");
          eCABECERA.setAttribute("nombre", "cabecera");
          eCABECERA.setAttribute("height", "20");

          Integer anchoCab;

          if (cantColumns < 4) {
              anchoCab = new Integer(580 / cantColumns);
          } else {
              anchoCab = new Integer(150);
          }

          Element eCOL_1 = document.createElement("COL");
          eCOL_1.setAttribute("id", "fondoCabecera");
          eCOL_1.setAttribute("ancho", anchoCab.toString());

          Element eCOL_2 = document.createElement("COL");
          eCOL_2.setAttribute("id", "fondoCabecera");
          eCOL_2.setAttribute("ancho", anchoCab.toString());

          Element eCOL_3 = document.createElement("COL");
          eCOL_3.setAttribute("id", "fondoCabecera");
          eCOL_3.setAttribute("ancho", anchoCab.toString());

          Element eCOL_4 = document.createElement("COL");
          eCOL_4.setAttribute("id", "fondoCabecera");
          eCOL_4.setAttribute("ancho", anchoCab.toString());

          Element eCOL_5 = document.createElement("COL");
          eCOL_5.setAttribute("id", "fondoCabecera");
          eCOL_5.setAttribute("ancho", anchoCab.toString());

          Element eCOL_6 = document.createElement("COL");
          eCOL_6.setAttribute("id", "fondoCabecera");
          eCOL_6.setAttribute("ancho", anchoCab.toString());

          Vector columnas = new Vector();

          for (int i = 0; i < cantColumns; i++) {
              Element eLABEL_2 = document.createElement("LABELC");
              eLABEL_2.setAttribute("id", "fondoCabecera");
              eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
              eLABEL_2.setAttribute("ancho", anchoCab.toString());
              eLABEL_2.setAttribute("alto", "20");
              eLABEL_2.setAttribute("filas", "1");
              eLABEL_2.setAttribute("id", "datosCamposCabecera");

              if (i != 0) {
                    eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
              } else {
                    eLABEL_2.setAttribute("cod", "199");
              }

              eLABEL_2.setAttribute("enviaroculto", "N");
              columnas.add(eLABEL_2); //Agrego label a la columna
          }

          traza("despues de poner en variables los titulos " + columnas + " " +
              cantColumns);

          if (cantColumns >= 1) {
              eCOL_1.appendChild((Element) columnas.get(0));
              eCABECERA.appendChild(eCOL_1);
              traza("1");
          }

          if (cantColumns >= 2) {
              eCOL_2.appendChild((Element) columnas.get(1));
              eCABECERA.appendChild(eCOL_2);
              traza("1");
          }

          if (cantColumns >= 3) {
              eCOL_3.appendChild((Element) columnas.get(2));
              eCABECERA.appendChild(eCOL_3);
              traza("1");
          }

          if (cantColumns >= 4) {
              eCOL_4.appendChild((Element) columnas.get(3));
              eCABECERA.appendChild(eCOL_4);
              traza("1");
          }

          if (cantColumns >= 5) {
              eCOL_5.appendChild((Element) columnas.get(4));
              eCABECERA.appendChild(eCOL_5);
              traza("1");
          }

          if (cantColumns >= 6) {
              eCOL_6.appendChild((Element) columnas.get(5));
              eCABECERA.appendChild(eCOL_6);
              traza("1");
          }

          Element ePRESENTACION = document.createElement("PRESENTACION");
          Integer ancho = new Integer(cantColumns * anchoCab.intValue());
          ePRESENTACION.setAttribute("ancho", ancho.toString());
          ePRESENTACION.setAttribute("filas", "1");

          int swX1 = 0;
          StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
          traza("break brain");

          for (int i = 1; i < cantColumns; i++) {
              if (swX1 == 0) {
                    cadena.append(", 'datosCamposCenterPar'");
                    swX1 = 1;
              } else {
                    cadena.append(", 'datosCamposCenterImpar'");
                    swX1 = 0;
              }
          }

          for (int i = 0; i < cantColumns; i++) {
              Element eCOLP_2 = document.createElement("COL");
              eCOLP_2.setAttribute("ancho", anchoCab.toString());
              eCOLP_2.setAttribute("caracteres", "150");
              ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
          }

          cadena.append("]");

          traza("### " + cadena.toString());
          ePRESENTACION.setAttribute("bloquesid", cadena.toString());

          Element eROWSET = document.createElement("ROWSET");

          eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
          eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
          eLista.appendChild(eROWSET); //Agrego el rowset de la lista

          eCapa.appendChild(eLista);

          getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }

          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CCC");
     
     //comienzo de los parametrso de filtrado
     
     String fechaProcesoDesde        = conectorParametroLimpia("fechaProcesoDesde", "", true);
     datos.put(ConstantesREP.FECHADEPROCESODESDE, fechaProcesoDesde);
     
     String fechaProcesoHasta        = conectorParametroLimpia("fechaProcesoHasta", "", true);
     datos.put(ConstantesREP.FECHADEPROCESOHASTA, fechaProcesoHasta);
     
     String banco        = conectorParametroLimpia("banco", "", true);
     if(!banco.equals("")){
        datos.put(ConstantesREP.BANCOS, banco);
     }
     
     String cuentaCorriente        = conectorParametroLimpia("cuentaCorriente", "", true);
     if(!cuentaCorriente.equals("")){
        datos.put(ConstantesREP.CUENTASCORRIENTESBANCARIAS, cuentaCorriente);
     }    
     
       
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
      }else{
        formato = "pdf";
     }
     
     String orden        = conectorParametroLimpia("orden", "", true);
     if(orden.equals("1")){
        datos.put(ConstantesREP.ORDEN, "'CODIGO ,FECHA_VALOR'");
     }else{
        datos.put(ConstantesREP.ORDEN, "'FECHA_VALOR, CODIGO'");
     } 
     
     String ordenDesc = conectorParametroLimpia("ordenDesc", "", true);
     datos.put(ConstantesREP.ORDENDESC,ordenDesc);
      
     
     datos.put(ConstantesREP.TITULO, "Pagos por Regularizar");
     traza("++++++Antes de enviar a reportes " + datos); 
        
     
     traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-142", formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-142", formato);
          
  } 
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,
           Vector columns) throws DOMException, Exception {
           StringBuffer salida = new StringBuffer();

           int sizeColums = datos.getColumnCount();
           int sizeRows = datos.getRowCount();

           if (columns == null) {
                columns = new Vector();
           }

           Vector columsDesc = datos.getColumnIdentifiers();

           DruidaConector conectorValoresPosibles = new DruidaConector();
           XMLDocument xmlDoc = new XMLDocument();
           Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
           Element e_rows = docDestino.createElement("ROWSET");
           e_rows.setAttribute("ID", rowsetID);
           docDestino.getDocumentElement().appendChild(e_rows);

           for (int i = 0; i < sizeRows; i++) {
                Element e_row = docDestino.createElement("ROW");
                e_rows.appendChild(e_row);

                for (int j = 0; j < sizeColums; j++) {
                      if (columns.contains(columsDesc.elementAt(j))) {
                            Element e_campo2 = docDestino.createElement("CAMPO");
                            e_campo2.setAttribute("NOMBRE",
                                  columsDesc.elementAt(j).toString());
                            e_campo2.setAttribute("TIPO", "OBJECTO");
                            e_campo2.setAttribute("LONGITUD", "50");

                            Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                         ? "" : datos.getValueAt(i, j).toString()));
                            e_campo2.appendChild(txt);
                            e_row.appendChild(e_campo2);
                      }
                }
           }

           conectorValoresPosibles.setXML(docDestino.getDocumentElement());

           return conectorValoresPosibles;
    }
  
  
    private Object obtenerDatosSalida(String bID, String conector, Object dto) throws Exception {
      
             //traza("entro a ObtenerDatos Salida");
             Vector paramEntrada = new Vector();
             MareBusinessID id = new MareBusinessID(bID);
             paramEntrada.add(dto);
             paramEntrada.add(id);

             //traza("****************dto del obtener: " + dto);
             //traza("****************id del obtener: " + id.getBusinessID());
             //traza("*********Conector " + conector);
             DruidaConector ver = conectar(conector, paramEntrada);
             Object obj = ver.objeto("DTOSalida");

             //traza("ver DTOSalida " + obj.toString());
             return obj;
         
    }

  
   
    
  

  
            
}
















