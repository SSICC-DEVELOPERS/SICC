/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPConsultarReclamos extends LPSICCBase {

          public LPConsultarReclamos() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          	rastreo();
          	setTrazaFichero();
          	traza("*** Entrada - LPConsultarReclamos - ejecucion ***");
                try  {
                   	conectorAction("LPMantenimientoReclamos"); 
			conectorActionParametro("accion","consultar_menu_principal"); 
                }catch ( Exception e ) {
                        logStackTrace(e);
                        lanzarPaginaError(e);
                }
           traza("*** Salida - LPConsultarReclamos - ejecucion ***");
          }

    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    traza("Stack Trace: " + baos.toString());
     }

}

























/*
 

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import es.indra.sicc.dtos.ccc.DTOBancoSucursal;
import es.indra.sicc.dtos.ccc.DTOReclamo ;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ccc.DTOCargaInicialReclamos;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;

public class LPConsultarReclamos extends LPSICCBase {
	
	private String accion = null;
	
	public LPConsultarReclamos() {
		super();
	}


	public void inicio() throws Exception {
		pagina("contenido_reclamos_insertar");

	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {	
			traza("LPConsultarReclamos Entrada");
			this.accion = conectorParametroLimpia("accion", "", true);
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("Idioma de Session: "+idioma);
			asignar("VAR", "idioma", idioma.toString());
			Long pais = UtilidadesSession.getPais(this);
			asignar("VAR", "pais", pais.toString());			
			this.accionVacia(idioma, pais);							
			traza("LPConsultarReclamos Salida");			
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
	}
	private void accionVacia(Long idioma,Long pais) throws Exception{
		traza("LPConsultarReclamos.accionVacia Entrada");		
		try{
			asignarAtributo("VAR","casoUso","valor","consultarReclamo");
			asignarAtributo("PAGINA","reclamos_insertar","cod","0534");	
			asignarAtributo("PAGINA","reclamos_insertar","msgle","Consultar reclamos");	
			getConfiguracionMenu("LPConsultarReclamos", "");												
			
			traza("oidRecibido String: "+conectorParametroLimpia("oidSeleccionado", "", true));			
			Long oidRecibido=new Long(conectorParametroLimpia("oidSeleccionado", "", true));
			traza("oidRecibido : "+oidRecibido);
			
			Vector paramConector = new Vector();
			DTOOID dtoOid=new DTOOID();
			dtoOid.setOidIdioma(idioma);
			dtoOid.setOidPais(pais);
			dtoOid.setOid(oidRecibido);
			paramConector.add(dtoOid);
			paramConector.add(new MareBusinessID("CCCObtenerReclamo"));          
			traza("Antes de Conectar");
			DruidaConector conector = conectar("ConectorObtenerReclamo", paramConector);							
			traza("Despues de Conectar");
			Object objeto=conector.objeto("DTOReclamo");
			traza("Objeto recogido"+objeto);
			DTOReclamo  dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");	
			traza("DTOReclamo obtenido " +dtoReclamo);
			asignar("VAR", "oid", oidRecibido.toString());			

			if(dtoReclamo.getCanal()!=null){
				RecordSet rsCanal=this.construirRecordsetSimple(dtoReclamo.getCanal(),dtoReclamo.getDescCanal());
				Vector cols = rsCanal.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsCanal, cols);
				asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getCanal().toString());					
			
			}

			if(dtoReclamo.getAcceso()!=null){
				RecordSet rsAcceso=this.construirRecordsetSimple(dtoReclamo.getAcceso(),dtoReclamo.getDescAcceso());
				Vector cols = rsAcceso.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsAcceso, cols);
				asignar("COMBO", "cbAcceso", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getAcceso().toString());								
			}

			if(dtoReclamo.getBancoRecaudacion()!=null){
				RecordSet rsBancoR=this.construirRecordsetSimple(dtoReclamo.getBancoRecaudacion(),dtoReclamo.getDescBancoRecaudacion());
				Vector cols = rsBancoR.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsBancoR, cols);
				asignar("COMBO", "cbBancoRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getBancoRecaudacion().toString());								
			}
			traza("1");
			if(dtoReclamo.getCuentaCorriente()!=null){
				RecordSet rsCC=this.construirRecordsetSimple(dtoReclamo.getCuentaCorriente(),dtoReclamo.getDescCuentaCorriente());
				Vector cols = rsCC.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsCC, cols);
				asignar("COMBO", "cbCuenta", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getCuentaCorriente().toString());								
			}

			if(dtoReclamo.getMedioPago()!=null){
				RecordSet rsMedioPago=this.construirRecordsetSimple(dtoReclamo.getMedioPago(),dtoReclamo.getDescMedioPago());
				Vector cols = rsMedioPago.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsMedioPago, cols);
				asignar("COMBO", "cbMedioPago", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getMedioPago().toString());								
			}
traza("2");
			if(dtoReclamo.getMotivoDesbloqueoRechazo()!=null){
				RecordSet sMotivoRechazo=this.construirRecordsetSimple(dtoReclamo.getMotivoDesbloqueoRechazo(),
																	   dtoReclamo.getDescMotivoRechazo());
				Vector cols = sMotivoRechazo.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", sMotivoRechazo, cols);
				asignar("COMBO", "cbCodigoSolucionRechazo", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getMotivoDesbloqueoRechazo().toString());																					   
			}

			if(dtoReclamo.getPeriodoReclamante()!=null){
				RecordSet rsPeriodoReclamante=this.construirRecordsetSimple(dtoReclamo.getPeriodoReclamante(),
																			dtoReclamo.getDescPeriodoReclamante());
				Vector cols = rsPeriodoReclamante.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsPeriodoReclamante
																					  , cols);
				asignar("COMBO", "cbPeriodoReclamante", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getPeriodoReclamante().toString());
			}
traza("3");
			if(dtoReclamo.getSituacion()!=null){
				RecordSet rsSituacion=this.construirRecordsetSimple(dtoReclamo.getSituacion(),dtoReclamo.getDescSituacion());
				Vector cols = rsSituacion.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsSituacion, cols);
				asignar("COMBO", "cbSituacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSituacion().toString());								
			}
traza("4");
			if(dtoReclamo.getSubacceso()!=null){
				RecordSet rsSubAcceso=this.construirRecordsetSimple(dtoReclamo.getSubacceso(),dtoReclamo.getDescSubacceso());
				Vector cols = rsSubAcceso.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsSubAcceso, cols);
				asignar("COMBO", "cbSubacceso", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSubacceso().toString());								
			}

			if(dtoReclamo.getSucursal()!=null){
				RecordSet rsSucursal=this.construirRecordsetSimple(dtoReclamo.getSucursal(),dtoReclamo.getDescSucursal());
				Vector cols = rsSucursal.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsSucursal, cols);
				asignar("COMBO", "cbSucursalRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSucursal().toString());								
			}
traza("5");
			if(dtoReclamo.getEmpresa()!=null){
				RecordSet rsEmpresa=this.construirRecordsetSimple(dtoReclamo.getEmpresa(),dtoReclamo.getEmpresaDesc());
				Vector cols = rsEmpresa.getColumnIdentifiers();
				DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsEmpresa, cols);
				asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getEmpresa().toString());								
				
			}

			if(dtoReclamo.getAnyoAbonoDirecto()!=null){
				asignar("CTEXTO", "txtAnoCargoAbonoDirecto",dtoReclamo.getAnyoAbonoDirecto()+"");
			}
traza("6");
			if(dtoReclamo.getEjercicioCuota()!=null){
				asignar("CTEXTO", "textEjercicioCuota",dtoReclamo.getEjercicioCuota()+"");
			}
traza("7");
			if(dtoReclamo.getFechaResolucionPrevista()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionPrevista(), 
														UtilidadesSession.getFormatoFecha(this));
				asignar("CTEXTO", "textFechaResolucionReclamoPrevista",fechaFormateada);
			}
traza("8");
			if(dtoReclamo.getFechaResolucionReal()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionReal(), 
														 UtilidadesSession.getFormatoFecha(this));				
				asignar("CTEXTO", "txtFechaResolucionReclamoReal",fechaFormateada);
			}

			if(dtoReclamo.getFicheroDocumentalAdjunto()!=null){
				asignar("CTEXTO", "textFicheroDocAdjunto",dtoReclamo.getFicheroDocumentalAdjunto());
			}
			
			if(dtoReclamo.getImporteReclamado()!=null){
				asignar("CTEXTO", "textImporteReclamado",dtoReclamo.getImporteReclamado()+"");
			}
			
			if(dtoReclamo.getNumeroCargoAbonoDirecto()!=null){
				asignar("CTEXTO", "txtNumCargoAbonoDirecto",dtoReclamo.getNumeroCargoAbonoDirecto()+"");
			}
	traza("9");		
			if(dtoReclamo.getNumeroIdentificadorCuota()!=null){
				asignar("CTEXTO", "textNumeroIdentificadorCuota",dtoReclamo.getNumeroIdentificadorCuota()+"");
			}
			
			if(dtoReclamo.getNumeroOrdenCuota()!=null){
				asignar("CTEXTO", "textNumeroOrdenCuota",dtoReclamo.getNumeroOrdenCuota()+"");
			}
			
			//if(dtoReclamo.getNumeroSerieCuota()!=null){
			//	asignar("CTEXTO", "textNumeroSerieCuota",dtoReclamo.getNumeroSerieCuota()+"");
			//}
			
			if(dtoReclamo.getObservacionesAreaReclamos()!=null){
				//asignar("AREATEXTO", "textObservacionesAreaReclamos",dtoReclamo.getObservacionesAreaReclamos());
				asignarAtributoElemento("textObservacionesAreaReclamos","valor",dtoReclamo.getObservacionesAreaReclamos()+"");
			}
	traza("10");		
			if(dtoReclamo.getObservacionesClienteReclamante()!=null){
				//asignar("AREATEXTO", "textObservacionesClienteReclamante",dtoReclamo.getObservacionesClienteReclamante());
				asignarAtributoElemento("textObservacionesClienteReclamante","valor",dtoReclamo.getObservacionesClienteReclamante()+"");
			}
			
			if(dtoReclamo.getObservacionesResolucion()!=null){
				//asignar("AREATEXTO", "atxtObservacionesResolucionReclamos",dtoReclamo.getObservacionesResolucion());
				asignarAtributoElemento("atxtObservacionesResolucionReclamos","valor",dtoReclamo.getObservacionesResolucion()+"");

			}
			
			if(dtoReclamo.getPeriodoMesAbonoDirecto()!=null){
				asignar("CTEXTO", "txtMesCargoAbonoDirecto",dtoReclamo.getPeriodoMesAbonoDirecto());
			}
			
			if(dtoReclamo.getAnyo()!=null){
				asignar("LABELC", "lbldtAño",dtoReclamo.getAnyo());
			}
	traza("11");	
			if(dtoReclamo.getCodigoCliente()!=null){
				asignar("CTEXTO", "textCodigoClienteReclamante",dtoReclamo.getCodigoCliente()+"");
				
				
			}
			//if(dtoReclamo.getFechaValor!=null){ ?????????????incidencia
			//	asignar("CTEXTO", "textFechaValor",dtoReclamo.getCodigoCliente()+"");
			//}
			
			if(dtoReclamo.getFechaDocumento()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaDocumento(), 
													 UtilidadesSession.getFormatoFecha(this));						
				//asignar("CTEXTO", "lbldtFechaDoc",fechaFormateada);
				asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaFormateada);
			}
			
			if(dtoReclamo.getNumeroLote()!=null){//??????????????????????????
				//asignar("LABELC", "lbldtNumIdentificacion",dtoReclamo.getNumeroLote()+"");
				asignarAtributo("LABELC","lbldtNumIdentificacion","valor",dtoReclamo.getNumeroLote()+"");
			}
	traza("12");		
			if(dtoReclamo.getPeriodoMes()!=null){
				//asignar("LABELC", "lbldtMes",dtoReclamo.getPeriodoMes());
				asignarAtributo("LABELC","lbldtMes","valor",dtoReclamo.getPeriodoMes());
			}
			
			if(dtoReclamo.getUsuarioGestorPrevisto()!=null){
				asignar("COMBO", "cbUsuarioGestorReclamoPrevisto",dtoReclamo.getUsuarioGestorPrevisto());
			}
			
			if(dtoReclamo.getUsuarioGestorReal()!=null){
				asignar("COMBO", "cbUsuarioGestorReclamoReal",dtoReclamo.getUsuarioGestorReal());
			}
			
			if(dtoReclamo.getUsuarioSolicitante()!=null){
				//asignar("LABELC", "lblUsuarioSolicitantedt",dtoReclamo.getUsuarioSolicitante());
				asignarAtributo("LABELC","lbldtMes","valor",dtoReclamo.getUsuarioSolicitante());
			}
			String descPais = UtilidadesSession.getDescripcionPais(this);			
			//asignar("LABELC", "lblPaisActual", descPais);	
traza("DISABLED");
			//se deshabilitan los campos.
			asignarAtributoElemento("cbCanal","disabled","S");								
			asignarAtributoElemento("cbAcceso","disabled","S");								
			asignarAtributoElemento("cbBancoRecaudacion","disabled","S");
			asignarAtributoElemento("cbCuenta","disabled","S");
			asignarAtributoElemento("cbMedioPago","disabled","S");
			asignarAtributoElemento("cbCodigoSolucionRechazo","disabled","S");
			asignarAtributoElemento("cbPeriodoReclamante","disabled","S");
			asignarAtributoElemento("cbSituacion","disabled","S");
			asignarAtributoElemento("cbSubacceso","disabled","S");
			asignarAtributoElemento("cbSucursalRecaudacion","disabled","S");
			asignarAtributoElemento("cbEmpresa","disabled","S");
			asignarAtributoElemento("txtAnoCargoAbonoDirecto","disabled","S");
			asignarAtributoElemento("textEjercicioCuota","disabled","S");
			asignarAtributoElemento("textFechaResolucionReclamoPrevista","disabled","S");
			asignarAtributoElemento("txtFechaResolucionReclamoReal","disabled","S");
			asignarAtributoElemento("textFicheroDocAdjunto","disabled","S");
			asignarAtributoElemento("textImporteReclamado","disabled","S");
			asignarAtributoElemento("txtNumCargoAbonoDirecto","disabled","S");
			asignarAtributoElemento("textNumeroIdentificadorCuota","disabled","S");
			asignarAtributoElemento("textNumeroOrdenCuota","disabled","S");
			asignarAtributoElemento("textNumeroSerieCuota","disabled","S");
			asignarAtributoElemento("textObservacionesAreaReclamos","disabled","S");
			asignarAtributoElemento("textObservacionesClienteReclamante","disabled","S");
			asignarAtributoElemento("atxtObservacionesResolucionReclamos","disabled","S");
			asignarAtributoElemento("txtMesCargoAbonoDirecto","disabled","S");
			asignarAtributoElemento("textCodigoClienteReclamante","disabled","S");
			asignarAtributoElemento("textFechaDocumento","disabled","S");
			asignarAtributoElemento("textUsuarioGestorReclamoPrevisto","disabled","S");
			asignarAtributoElemento("textUsuarioGestorReclamoReal","disabled","S");			




				
		}catch ( Exception e )  {
			traza("exception de LPconsulatrReclamos");
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
		traza("LPConsultarReclamos.accionVacia Salida");		
	}			
	private RecordSet construirRecordsetSimple(Long oid, String descripcion) throws Exception{
		RecordSet rcsSalida=new RecordSet();
		try{
			traza("LPConsultarReclamos.construirRecordsetSimple Entrada");			
			String sOid="OID";
			String sDescripcion="DESCRIPCION";
			Vector vectorDatos=new Vector();
			vectorDatos.add(oid);
			
			if (descripcion!=null){
				vectorDatos.add(descripcion);
			}else{
				vectorDatos.add("");
			}
			
			rcsSalida.addColumn(sOid);
			rcsSalida.addColumn(sDescripcion);	
			rcsSalida.addRow(vectorDatos);
			traza("LPConsultarReclamos.construirRecordsetSimple Salida");			
		}catch(Exception e){
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);			
		}
		return rcsSalida;
		
		
	}
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}	
}
	*/	 