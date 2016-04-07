//$Id: LPEliminacionImpuestos.java,v 1.1 2009/12/03 18:36:00 pecbazalar Exp $ 
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
/**
 * Sistema:           Belcorp
 * Modulo:            MAE
 * Submódulo:         Materiales
 * Componente:        LP
 * Fecha:             13/05/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-SEG-001-202
 *                    (Subido al portal el 01/05/2003)
 * @version           1.0
 * @autor             Marta Montiel
 */ 
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTOModificarImpuesto;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOImpuestoUBIGEO;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;


public class LPEliminacionImpuestos extends LPSICCBase {	
	
	public LPEliminacionImpuestos() {
		super();
	}

	private String casoDeUso=null;
	private String oid = null;
	private String territorio = null;

	public void inicio() throws Exception {
        pagina("contenido_impuestos_ubigeo_modificar");
		asignarAtributoPagina("cod","0399");
	}
	
/*private void rastreo() throws Exception
{
  MareCredentials credenciales = (MareCredentials)conectorParametroSesion("credenciales");
  String nombre   =  credenciales.getUser().getName();
  String idFuncion = (String)conectorParametroSesion("idFuncion");
  IRastreador tracer = Rastreador.getInstance();
  
  Date fechaHora = new Date( Calendar.getInstance().getTime().getTime() ) ;

  try
  {
	tracer.RastrearFuncion(fechaHora, idFuncion, nombre );      
  } catch (MareException ex)
  {
	ex.printStackTrace();
  }
  
}   
*/

public void ejecucion() throws Exception {
	setTrazaFichero();
	UtilidadesSession paisSesion = new UtilidadesSession();
	UtilidadesSession idiomaSesion = new UtilidadesSession();
	
	String accion = conectorParametroLimpia( "accion","",true );
	
	String oidImpuestoStr = conectorParametroLimpia( "hidOidImpuesto","",true );

	String eleSeleccionados = conectorParametroLimpia( "elementosSeleccionados","",true );

	String oidIndicardorImp = conectorParametroLimpia( "hidTasaImpuesto","",true );
	String productoStr = conectorParametroLimpia( "hidProducto","",true );
	String oidTerritorioStr = conectorParametroLimpia( "hidTerritorio","",true );
	String territorio1 = conectorParametroLimpia( "hidCampoTerritorio1","",true );
	String territorio2 = conectorParametroLimpia( "hidCampoTerritorio2","",true );
	String territorio3 = conectorParametroLimpia( "hidCampoTerritorio3","",true );

	Long pais = paisSesion.getPais(this);
	Long idioma = idiomaSesion.getIdioma(this);
	Vector paramEntrada  = new Vector();
	Vector paramEntImpuesto  = new Vector();
	MareBusinessID id;
	MareBusinessID idConsulta;
	DruidaConector ConectorElimina;


	
	try
		{
			asignarAtributo("VAR","hidCasodeUso", "valor","eliminar") ;

			if ( accion.equals("") ) {
				conectorAction("LPBusquedaImpuestos");
				conectorActionParametro("accion","");
				conectorActionParametro("hidCasodeUso", "eliminar");			
			}

			else if ( accion.equals("Eliminar") ) {
				/*
				-idBusiness = "MAEEliminarImpuestos" 
				-Se crea un DTOOids y se meten los oid's de las filas que haya marcado el usuario para eliminar. 
				-Se llama al conector ConectorEliminar pasandole el dto. 
				*/
				traza("elementos a eliminar  " + eleSeleccionados );
				DTOOIDs dtoOIDS = new DTOOIDs();
				StringTokenizer stk = new StringTokenizer(eleSeleccionados,",");			
				Long miArr[] = new Long[stk.countTokens()];
				int i=0;
				while (stk.hasMoreTokens()){
					miArr[i] = Long.valueOf(stk.nextToken());
					i++;
				}
				dtoOIDS.setOids(miArr);				

				id = new MareBusinessID("MAEEliminarImpuestos");
				paramEntrada.addElement(dtoOIDS);
				paramEntrada.addElement(id);
				ConectorElimina = conectar("ConectorEliminarImpuesto", paramEntrada);

				asignarAtributo("VAR", "hidTasaImpuesto", "valor", oidIndicardorImp);
				asignarAtributo("CTEXTO", "txtCodigoSap", "valor", productoStr);
				traza(territorio1 + "   " + territorio2  + "   "  + territorio3);
				
				asignarAtributo("VAR", "hidTerritorio", "valor", oidTerritorioStr);
				asignarAtributo("VAR", "hidCampoTerritorio1", "valor", territorio1);
				asignarAtributo("VAR", "hidCampoTerritorio2", "valor", territorio2);
				asignarAtributo("VAR", "hidCampoTerritorio3", "valor", territorio3);
				
				conectorAction("LPBusquedaImpuestos");
				conectorActionParametro("accion","");
				conectorActionParametro("hidCasodeUso", "vuelveEliminar");
				conectorActionParametro("hidTasaImpuesto", oidIndicardorImp);
				conectorActionParametro("txtCodigoSap", productoStr);
				conectorActionParametro("hidTerritorio", oidTerritorioStr);
				conectorActionParametro("hidCampoTerritorio1", territorio1);
				conectorActionParametro("hidCampoTerritorio2", territorio2);
				conectorActionParametro("hidCampoTerritorio3", territorio3);
			}
		
		}
	catch (Throwable ex)
		{
			BelcorpError belcorpError = new BelcorpError();

			DTOError dtoError = belcorpError.obtenerError(ex, ( idioma.toString() ),( pais.toString() ) );
			asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
			asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError());
			asignarAtributo("VAR", "hidCasodeUso", "valor", casoDeUso);
			/*conectorAvisoModa l("LPPantallaError");			
			conectorAvisoModalParametro("errCodigo","5");*/
			}
			getConfiguracionMenu();
		}

 }//fin clase