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

 //import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.dto.DTODescuentoOrden;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPOrdenacionDTO
 * Fecha:               06/07/2004
 * Dcoumentacion:       
 *                      documentos: SICC-DMCO-DTO-201-324
 * Observaciones:
 * @version             3.0
 * @author              Cintia Verónica Argain
 */
public class LPOrdenacionDTO extends LPSICCBase {

	private String sListaGuardar	= null;
	private Long oidMarca	= null;
	private Long oidCanal	= null;
	private Vector vParamEntrada	= new Vector();
	private Vector vResultado		= new Vector();
	DTOBelcorp		dtoBelcorp		= null;
	DTODescuentoDG	dtoDescuentoDG	= null;
	DTOEBuscarDescuentosOrdenacion dtoeBuscarDescuentosOrdenacion;
	DTOSalida dtoSalida = new DTOSalida();
	MareBusinessID idBuscarDescuentosOrd;
	MareBusinessID idDtoGuardarOrdenacion;
	MareBusinessID idDtoBuscarDescuentosOrdenacion;

    public LPOrdenacionDTO() {
    }

    public void inicio() throws Exception {
        pagina("contenido_descuentos_ordenar");
    }

    public void ejecucion() throws Exception {
        this.rastreo();
        setTrazaFichero();
		 try {

	 		dtoBelcorp = new DTOBelcorp();
			dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
			dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
			String accion = conectorParametro("accion")==null?"":conectorParametro("accion");

			if (accion.equals("")){
					   pagina("contenido_descuentos_ordenar");
						asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this).toString());
						cargaCombos();
			}
			if (accion.equals("descuentoDefinido")){
		        pagina("contenido_descuentos_ordenar");
				  asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this).toString());
				  cargaCombos();
				  dtoDescuentoDG = (DTODescuentoDG) this.conectorParametroSesion("DTODatosGenerales");
				  traza("obtuvo el dtoDescuentoDG");
	           asignarAtributo("VAR", "casoDeUso", "valor", "descuentoDefinido");
				  oidCanal = dtoDescuentoDG.getOidCanal();
				  asignarAtributo("VAR", "canalInit", "valor", oidCanal.toString());
				  oidMarca = dtoDescuentoDG.getOidMarca();
				  asignarAtributo("VAR", "marcaInit", "valor", oidMarca.toString());
				  idDtoBuscarDescuentosOrdenacion = new MareBusinessID("DTOBuscarDescuentosOrdenacion");
				  dtoeBuscarDescuentosOrdenacion = new DTOEBuscarDescuentosOrdenacion();
				  dtoeBuscarDescuentosOrdenacion.setOidCanal(oidCanal);
				  dtoeBuscarDescuentosOrdenacion.setOidMarca(oidMarca);
				  dtoeBuscarDescuentosOrdenacion.setOidPais(UtilidadesSession.getPais(this));
				  dtoeBuscarDescuentosOrdenacion.setOidIdioma(UtilidadesSession.getIdioma(this));
                  traza("dto: "+dtoeBuscarDescuentosOrdenacion);
				  vParamEntrada.add(dtoeBuscarDescuentosOrdenacion);
				  vParamEntrada.add(idDtoBuscarDescuentosOrdenacion);
					traza("antes de conetar");
					DruidaConector conector = conectar("ConectorBuscarDescuentosOrdenacion", vParamEntrada);
					traza("conectó");
				   dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
					RecordSet recLista = dtoSalida.getResultado();
					traza("recordset: "+recLista);
					int colCount = recLista.getColumnCount();
					String nombreListado = "listado1";
					if (! recLista.esVacio())
						asignar("LISTADOA", nombreListado, generarConectorListEditCF("ROWSET", recLista, (Vector)recLista.getColumnIdentifiers()),"ROWSET");
					else asignarAtributo("VAR","vacia","valor","S");

			}
			if (accion.equals("buscar")){
			         pagina("contenido_descuentos_ordenar");
						asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this).toString());
						cargaCombos();
		            asignarAtributo("VAR", "casoDeUso", "valor", "buscar");
						idBuscarDescuentosOrd = new MareBusinessID("DTOBuscarDescuentosOrdenacion");
						dtoeBuscarDescuentosOrdenacion = new DTOEBuscarDescuentosOrdenacion();
						if (!conectorParametro("cbCanal").equals("")){
							asignarAtributo("VAR", "canalInit", "valor",conectorParametro("cbCanal").toString() );
							dtoeBuscarDescuentosOrdenacion.setOidCanal(new Long(conectorParametro("cbCanal")));
						}
						if (!conectorParametro("cbMarca").equals("")){
							asignarAtributo("VAR", "marcaInit", "valor",conectorParametro("cbMarca").toString() );
							dtoeBuscarDescuentosOrdenacion.setOidMarca(new Long(conectorParametro("cbMarca")));
						}
						dtoeBuscarDescuentosOrdenacion.setOidPais(UtilidadesSession.getPais(this));
						dtoeBuscarDescuentosOrdenacion.setOidIdioma(UtilidadesSession.getIdioma(this));
						vParamEntrada.add(dtoeBuscarDescuentosOrdenacion);
						vParamEntrada.add(idBuscarDescuentosOrd);
						traza("antes de conectar buscar");
						DruidaConector conector = conectar("ConectorBuscarDescuentosOrdenacion", vParamEntrada);
						traza("despues de conectar buscar");
						dtoSalida = (DTOSalida)conector.objeto("dtoSalida");
						RecordSet recLista = dtoSalida.getResultado();
						traza("recordset: "+recLista);
						int colCount = recLista.getColumnCount();
						String nombreListado = "listado1";
					if (! recLista.esVacio())
						asignar("LISTADOA", nombreListado, generarConectorListEditCF("ROWSET", recLista, (Vector)recLista.getColumnIdentifiers()),"ROWSET");
					else asignarAtributo("VAR","vacia","valor","S");
			}
			if (accion.equals("guardar")){
							int col	= 9;	//	Cantidad de columnas
							int tic	= 6;	//	Posicion de Culminacion
							int oid	= 0;	//	Oid
							int cor	= 1;	//	N° correlativo de descuento
							int fila	= 0;
							
							String can = conectorParametro("cbCanal")==null?"":conectorParametro("cbCanal"); 
							String mar = conectorParametro("cbMarca")==null?"":conectorParametro("cbMarca");
							DTOEDescuentosOrdenacion dtoeDescOrd = new DTOEDescuentosOrdenacion();
							ArrayList arLista = new ArrayList();
							
							idDtoGuardarOrdenacion = new MareBusinessID("DTOGuardarOrdenacion");
							sListaGuardar = this.conectorParametro("stream");
							StringTokenizer st = new StringTokenizer(sListaGuardar, "|");
							while (st.hasMoreTokens())	{
									vResultado.add(st.nextToken());
							}
							int modulo	= vResultado.size()/col;
							for (fila = 0; fila < modulo; fila ++){
										DTODescuentoOrden dtoDescOrd = new DTODescuentoOrden();
										try{
											Long a = new Long ((vResultado.elementAt(oid + fila*col)).toString());
										} catch (NumberFormatException ne){
											traza ("oid"+(vResultado.elementAt(oid + fila*col)).toString());
											traza ("fila"+fila);
										}
										try{
											Long a = new Long ((vResultado.elementAt(cor + fila*col)).toString());
										} catch (NumberFormatException ne){
											traza ("cor"+(vResultado.elementAt(cor + fila*col)).toString());
											traza ("fila"+fila);
										}

										dtoDescOrd.setOidDescuento(new Long ((vResultado.elementAt(oid + fila*col)).toString()));
										dtoDescOrd.setNumeroCorrelativoDTO(new Long ((vResultado.elementAt((cor + fila*col))).toString()));
										if(((String)vResultado.elementAt(tic+fila*col)).equals("S"))	{
											dtoDescOrd.setIndicadorCulminacion(new Boolean(true));
										}else{
											dtoDescOrd.setIndicadorCulminacion(new Boolean(false));
										}
									arLista.add(dtoDescOrd);
								}
							dtoeDescOrd.setLista(arLista);

							vParamEntrada.add(dtoeDescOrd);
							vParamEntrada.add(idDtoGuardarOrdenacion);
							traza("antes de guardar");
							DruidaConector conector = conectar("ConectorGuardarOrdenacion", vParamEntrada);
							traza("guardooooo");
							accion = "";
						   pagina("contenido_descuentos_ordenar");
							cargaCombos();
							asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this).toString());
							asignarAtributo("VAR", "canalInit", "valor",can);
							asignarAtributo("VAR", "marcaInit", "valor",mar);
			}
       getConfiguracionMenu();
		 }catch (Exception ex){
					  logStackTrace(ex);
					  this.lanzarPaginaError(ex);
		  }
	 }
	 
	 private void logStackTrace(Throwable e) throws Exception {
       traza("Se produjo la excepcion: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       if (e instanceof MareException) {
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
    }

 	private void cargaCombos() throws Exception{
		ComposerViewElementList comViElList = crearParametrosEntrada();
		ConectorComposerView conectorComView = new ConectorComposerView(comViElList, this.getRequest());
		conectorComView.ejecucion();
		DruidaConector resultados = conectorComView.getConector();
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
	} 

	 private ComposerViewElementList crearParametrosEntrada(){
		ComposerViewElementList lista = new ComposerViewElementList();
		// Primer combo
		ComposerViewElement combo1 = new ComposerViewElement();
		combo1.setIDBusiness("SEGConsultaMarcas");
		combo1.setDTOE(dtoBelcorp);
		// Segundo combo
		ComposerViewElement combo2 = new ComposerViewElement();
		combo2.setIDBusiness("SEGConsultaCanales");
		combo2.setDTOE(dtoBelcorp);

	   lista.addViewElement(combo1);
		lista.addViewElement(combo2);
		return lista;
	} 

	private DruidaConector generarConectorListEditCF(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		
		if ( columns == null ){
			columns = new Vector();
		}

       for (int i=0; i < datos.getRowCount();i++){
            String ok = (String) datos.getValueAt(i,6);
                if(ok.equals("Si"))
                    datos.setValueAt("S",i,6);
                else if(ok.equals("No"))
                    datos.setValueAt("N",i,6);
        }

		Vector columsDesc = datos.getColumnIdentifiers();		
		DruidaConector conectorValoresPosibles = new DruidaConector();
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++){
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);
			for (int j=0; j < sizeColums; j++)	{
				if ( columns.contains(columsDesc.elementAt(j)) )	{
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
		return conectorValoresPosibles;
	}
}
