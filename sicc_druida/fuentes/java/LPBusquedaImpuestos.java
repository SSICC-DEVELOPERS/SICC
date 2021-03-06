///import LPSICCBase;

import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;
import es.indra.sicc.dtos.mae.DTOImpuestoUBIGEO;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.*;

import java.lang.Boolean;
import java.lang.reflect.InvocationTargetException;

import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class LPBusquedaImpuestos extends LPSICCBase {	

    String casoDeUso = "";
    String accion = "";
    
	
	public LPBusquedaImpuestos() {
		super();
	}

	
	public void inicio() throws Exception {
     pagina("contenido_impuestos_ubigeo_modificar");
     accion     = conectorParametroLimpia("accion", "", true);
     casoDeUso  = conectorParametroLimpia("hidCasodeUso", "", true);

     traza("casoDeUso: " + casoDeUso);
     if (casoDeUso.equals("consultar") )
     {
      traza("NoReq");
       this.asignarAtributo("CTEXTO", "txtCodigoSap", "req", "N");
       this.asignarAtributo("COMBO", "cbIndicadorImpuesto", "req", "N");
       this.asignarAtributo("COMBO", "cbCanal", "req", "N");       
       this.asignarAtributo("COMBO", "cbAcceso", "req", "N");              
       this.asignarAtributo("COMBO", "cbSubacceso", "req", "N");                     
     }
	  Long idioma = UtilidadesSession.getIdioma(this);
      asignarAtributo("VAR","oidIdioma","valor",idioma.toString());
      Long aPais = UtilidadesSession.getPais(this);   
		asignarAtributo("VAR","oidPais","valor",aPais.toString());
  }

  public void ejecucion() throws Exception {
	  setTrazaFichero();
	  UtilidadesSession paisSesion = new UtilidadesSession();
	  UtilidadesSession idiomaSesion = new UtilidadesSession();
	

	try{
	     
      traza("casoDeUso   " + casoDeUso);
			traza("accion   " + accion);

      setearBarra();

			if (accion.equals("")){
         
          Vector paramEntrada_1 = new Vector();
					MareBusinessID id_combos = new MareBusinessID("MAERellenarCombosImpuestos");
					DTOBelcorp dtoe = new DTOBelcorp();
					dtoe.setOidPais(UtilidadesSession.getPais(this));
          dtoe.setOidIdioma( UtilidadesSession.getIdioma(this));

					paramEntrada_1.addElement(dtoe); 
					paramEntrada_1.addElement(id_combos);
          DruidaConector conectorCombosImpuestos = new DruidaConector();
          traza("los parametros de entrada son " + paramEntrada_1);     
					conectorCombosImpuestos = conectar("ConectorCombosImpuestos",paramEntrada_1);
			    DTOCombosImpuestos dtoCombos = (DTOCombosImpuestos) conectorCombosImpuestos.objeto("DTOSalida");
                
                 
          RecordSet rsTasas      = dtoCombos.getTasasImpuestos();
          Vector colTasas     = rsTasas.getColumnIdentifiers();
          int numColTasas     = rsTasas.getColumnCount();
          DruidaConector tasas  = this.generarConector("DTOSalida.resultado_ROWSET",rsTasas, colTasas);
          asignar("COMBO","cbIndicadorImpuesto", tasas, "DTOSalida.resultado_ROWSET");

          RecordSet rsCanales    = dtoCombos.getCanales();
          Vector colCanales     = rsCanales.getColumnIdentifiers();
          int numColCanales     = rsCanales.getColumnCount();
          DruidaConector canales  = this.generarConector("DTOSalida.resultado_ROWSET",rsCanales, colCanales);
          asignar("COMBO","cbCanal", canales, "DTOSalida.resultado_ROWSET");

          RecordSet rsAccesos    = dtoCombos.getAccesos();
          Vector colAccesos     = rsAccesos.getColumnIdentifiers();
          int numColAccesos     = rsAccesos.getColumnCount();
          DruidaConector accesos  = this.generarConector("DTOSalida.resultado_ROWSET",rsAccesos, colAccesos);
          this.crearListaLP(colAccesos , numColAccesos, "Capa1", "Lista1", "14", "200");
          asignar("LISTA", "Lista1", accesos, "DTOSalida.resultado_ROWSET");

          RecordSet rsSubaccesos    = dtoCombos.getSubaccesos();
          Vector colSubaccesos    = rsSubaccesos.getColumnIdentifiers();
          int numColSubaccesos     = rsSubaccesos.getColumnCount();
          DruidaConector subaccesos  = this.generarConector("DTOSalida.resultado_ROWSET",rsSubaccesos, colSubaccesos);
          this.crearListaLP(colSubaccesos , numColSubaccesos, "Capa2", "Lista2", "14", "200");
          asignar("LISTA", "Lista2", subaccesos, "DTOSalida.resultado_ROWSET");
          traza("el caso de uso al final es " + casoDeUso);
          asignarAtributo("VAR", "hidCasodeUso", "valor", casoDeUso.toString());
                     
      }
	
	
	 } catch (Exception ex) {
           traza("EXCEPCION " + ex);
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           ex.printStackTrace(out);
           traza("EXCEPCION:" + stack.toString());
           lanzarPaginaError(ex);
                              
      }				    
		
		}

     private void setearBarra() throws Exception{

    	if (casoDeUso.equals("consultar")) {
        traza("entro en el primer if");
				asignarAtributoPagina("cod","0400");
			}

      if( casoDeUso.equals("eliminar")){
			   asignarAtributoPagina("cod","0399");
			}

      if (casoDeUso.equals("modificar")){
         asignarAtributoPagina("cod","0398");
	    }
      getConfiguracionMenu();
    }

    private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)throws DOMException,Exception{
    
     StringBuffer salida = new StringBuffer();
     int sizeColums = datos.getColumnCount();
     int sizeRows = datos.getRowCount();

     if ( columns == null ){
        columns = new Vector();
     }

     Vector columsDesc = datos.getColumnIdentifiers();		
     traza("datos de generar conector:" + datos);
     DruidaConector conectorValoresPosibles = new DruidaConector();				
     XMLDocument xmlDoc  = new XMLDocument();
     Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
     Element e_rows = docDestino.createElement("ROWSET");
     e_rows.setAttribute("ID",rowsetID);
     docDestino.getDocumentElement().appendChild(e_rows);
                 
     for (int i=0; i < sizeRows; i++){
        Element e_row = docDestino.createElement("ROW");
        e_rows.appendChild(e_row);

        for (int j=0; j < sizeColums; j++){
           if ( columns.contains(columsDesc.elementAt(j)) ){
              Element e_campo2   = docDestino.createElement("CAMPO");
              e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
              e_campo2.setAttribute("TIPO","OBJECTO");
              e_campo2.setAttribute("LONGITUD","50");
              Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
              e_campo2.appendChild(txt);
              e_row.appendChild(e_campo2);
           }
        }
      }	

      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      return conectorValoresPosibles;
  }

  private void crearListaLP(Vector nomColumns, int cantColumns, String nomCapa, String nomLista, String XCapa, String YCapa) throws Exception {
        //traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);
        Document document = getXML();
        traza("esta en crear lista");

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

        //traza("despues de poner en variables los titulos " + columnas + " " +      cantColumns);
        if (cantColumns >= 1) {
            eCOL_1.appendChild((Element) columnas.get(0));
            eCABECERA.appendChild(eCOL_1);

            //traza("1");
        }

        if (cantColumns >= 2) {
            eCOL_2.appendChild((Element) columnas.get(1));
            eCABECERA.appendChild(eCOL_2);

            //traza("1");
        }

        if (cantColumns >= 3) {
            eCOL_3.appendChild((Element) columnas.get(2));
            eCABECERA.appendChild(eCOL_3);

            //traza("1");
        }

        if (cantColumns >= 4) {
            eCOL_4.appendChild((Element) columnas.get(3));
            eCABECERA.appendChild(eCOL_4);

            //traza("1");
        }

        if (cantColumns >= 5) {
            eCOL_5.appendChild((Element) columnas.get(4));
            eCABECERA.appendChild(eCOL_5);

            //traza("1");
        }

        if (cantColumns >= 6) {
            eCOL_6.appendChild((Element) columnas.get(5));
            eCABECERA.appendChild(eCOL_6);

            //traza("1");
        }

        Element ePRESENTACION = document.createElement("PRESENTACION");
        Integer ancho = new Integer(cantColumns * anchoCab.intValue());
        ePRESENTACION.setAttribute("ancho", ancho.toString());
        ePRESENTACION.setAttribute("filas", "1");

        int swX1 = 0;
        StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");

        //traza("break brain");
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

        //traza("### " + cadena.toString());
        ePRESENTACION.setAttribute("bloquesid", cadena.toString());

        Element eROWSET = document.createElement("ROWSET");

        eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
        eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
        eLista.appendChild(eROWSET); //Agrego el rowset de la lista

        eCapa.appendChild(eLista);

        getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }


    

 }
