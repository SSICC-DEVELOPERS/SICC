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
 
 /*
    INDRA/CAR/PROY
    $Id: LPConsultarLote.java,v 1.1 2009/12/03 18:40:45 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            CCC
 * Submódulo:         
 * Componente:        LP
 * Fecha:             15/03/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-CCC-201-303
 */ 
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.dtos.ccc.DTONumerosLineaVistaLotes;

public class LPConsultarLote extends LPSICCBase {

   private String accion    	= null;
   private String oid         	= null;
   private String casoDeUso     = null; 
   private String idioma    	= null;
   private String pais     		= null; 

   public LPConsultarLote() {
		super();
   }

   public void inicio() throws Exception {
      pagina("contenido_movimientos_bancarios_mantenimiento");
   }
  
   public void ejecucion() throws Exception {
    setTrazaFichero();

    accion     				= conectorParametroLimpia("accion", "", true);  
	traza("accion >>>" + accion);
    oid        				= conectorParametro("oid");
	traza("oid::.. "+ oid);

	idioma     				= UtilidadesSession.getIdioma(this).toString();	
	traza("idioma : "+ idioma);
	pais       				= UtilidadesSession.getPais(this).toString();
	traza("pais : "+ pais);

    try  {
			rastreo();
			cargarMenuSecundario();
			asignarAtributo("VAR","accion","valor",accion);

			if(accion.equals("")){
				/*			   
					Creamos un DTONumeroLineaVistaLotes con el numeroLinea recibido 
					Llamamos al ConectorMovimientosLote con el dto y el idBusiness
					"CCCConsultarMovimientosLote" 
					Con el DTOSalida obtenido cargamos la lista movimientos					
				*/

						 DTONumerosLineaVistaLotes dtoNumLote = new DTONumerosLineaVistaLotes();
						 dtoNumLote.setNumeroLinea(new Long(oid));
						 dtoNumLote.setOidIdioma(new Long(idioma));
						 dtoNumLote.setOidPais(new Long(pais));
				
						 traza("el oid es: " +oid);
						 MareBusinessID id = new MareBusinessID("CCCConsultarMovimientosLote");				 
						 traza("despues de declarar dto  e id");						
				
						 traza("contenido de idiomo >>>>" + new Long(idioma) );
				
						 traza("contenido de idiomo >>>>" + new Long(pais) );

						 traza("contenido del dto :::: " + dtoNumLote);

						 Vector paramEntrada = new Vector();
						 paramEntrada.add(dtoNumLote);
						 traza("contenido de paramEntrada>>> " + paramEntrada);
						 paramEntrada.add(id);
				 
						 traza("antes del conector");
						 DruidaConector conectorObjeto = conectar("ConectorObtenerMovimientosLote", paramEntrada);
						 traza("despues del conector");
					  
						 DTOSalida dtoDatos = (DTOSalida) conectorObjeto.objeto("dtoSalida");
						 traza("despues dtoDatos :::: " + dtoDatos);

						 RecordSet recLista = dtoDatos.getResultado();

						 traza("contenido de recLista:::::  " +recLista);
						 

						 asignar("LISTAEDITABLE", "listado1", generarConectorListEditCF("ROWSET", recLista, (Vector)recLista.getColumnIdentifiers()),"ROWSET");
						  
				 }
		}

	
	catch ( Exception e )  {
		traza("pincho la lp principal");
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        e.printStackTrace(out);
        traza("EL STACK ES COMO SIGUE : " +  pila.toString());
    	e.printStackTrace(); 
		e.getMessage();
		lanzarPaginaError(e);
    }
    

  }

  private void cargarMenuSecundario() throws Exception { 
  traza("accion >>>>" + accion);
      if (accion.equals("")) {
		traza("asigna a la lp el menu secundario");
        getConfiguracionMenu("LPConsultarLote","");
        asignarAtributoPagina("cod","0346");
      }
  }


  private DruidaConector generarConectorListEditCF(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		
		if ( columns == null )
		{
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();
		
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++)
		{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			Element e_campo0   = docDestino.createElement("CAMPO");
			e_campo0.setAttribute("NOMBRE","oculto");
			e_campo0.setAttribute("TIPO","OBJECTO");
			e_campo0.setAttribute("LONGITUD","50");
			Text txt = docDestino.createTextNode(String.valueOf(i));
			e_campo0.appendChild(txt);
			e_row.appendChild(e_campo0);

	for (int j=1; j < sizeColums; j++)
			{
				if ( columns.contains(columsDesc.elementAt(j)) )
				{
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
				}
			}
		}
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		traza("conectorValoresPosibles >>>" + conectorValoresPosibles.getXML());
		return conectorValoresPosibles;
	}// Fin metodo generarConectorListEditCF

}
