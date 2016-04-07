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

//import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPModificarReclamos extends LPSICCBase {

          public LPModificarReclamos() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          	rastreo();
          	setTrazaFichero();
          	traza("*** Entrada - LPModificarReclamos - ejecucion ***");
                try  {
                   	conectorAction("LPMantenimientoReclamos"); 
			conectorActionParametro("accion","modificar_menu_principal"); 
                }catch ( Exception e ) {
                        logStackTrace(e);
                        lanzarPaginaError(e);
                }
           traza("*** Salida - LPModificarReclamos - ejecucion ***");
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
import es.indra.sicc.dtos.ccc.DTOCargaInicialReclamos;
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
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class LPModificarReclamos extends LPSICCBase {
	
	private String accion = null;
	
	public LPModificarReclamos() {
		super();
	}


	public void inicio() throws Exception {
		pagina("contenido_reclamos_insertar");

	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {	
			traza("LPModificarReclamos Entrada");
			this.accion = conectorParametroLimpia("accion", "", true);
			Long idioma = UtilidadesSession.getIdioma(this);
			traza("accion : "+accion);
			asignar("VAR", "idioma", idioma.toString());
			Long pais = UtilidadesSession.getPais(this);
			asignar("VAR", "pais", pais.toString());	
			if(this.accion.equals("")){		
				this.accionVacia(idioma, pais);							
			}else if(this.accion.equals("guardar")){
				this.accionGuardar(idioma,pais);
			}
			traza("LPModificarReclamos Salida");			
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
	}
	private void accionVacia(Long idioma,Long pais) throws Exception{
		traza("LPModificarReclamos.accionVacia Entrada");		
		try{
			String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
			String separadorMiles = ",";
			if (separadorDecimales.equals(",")){
				separadorMiles = ".";
			}
			asignar("VAR","hid_SeparadorMiles", separadorMiles);
			asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
			asignar("VAR","hid_SeparadorDecimales", separadorDecimales);		
			asignarAtributo("VAR","casoUso","valor","modificarReclamo");
			asignarAtributo("PAGINA","reclamos_insertar","cod","0533");	
			asignarAtributo("PAGINA","reclamos_insertar","msgle","Modificar reclamos");	
			getConfiguracionMenu("LPModificarReclamos", "");
			Byte longitud = this.obtenerLongitudCodigoCliente();
			Long longitudCodigoCliente = new Long(longitud.longValue());
			asignarAtributo("VAR","longitudCodigoCliente","valor",longitudCodigoCliente.toString());
												
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
			traza("Antes de Conectar ConectorObtenerReclamo");
			DruidaConector conector = conectar("ConectorObtenerReclamo", paramConector);							
			traza("Despues de Conectar ConectorObtenerReclamo");
			Object objeto=conector.objeto("DTOReclamo");
			traza("Objeto recogido"+objeto);
			DTOReclamo  dtoReclamo = (DTOReclamo)conector.objeto("DTOReclamo");	
			traza("DTOReclamo obtenido");
			
			
			///acuerdate DE FECHA VALOR?????
			
			
			this.generarHiddenFormatoFecha();
			paramConector = new Vector();
			DTOBancoSucursal dtoBancoSucursal=new DTOBancoSucursal();			
			dtoBancoSucursal.setOidIdioma(idioma);
			dtoBancoSucursal.setOidPais(pais);	
			
			dtoBancoSucursal.setBanco(dtoReclamo.getBancoRecaudacion());		
			dtoBancoSucursal.setSucursal(dtoReclamo.getSucursal());
			paramConector.add(dtoBancoSucursal);
			paramConector.add(new MareBusinessID("CCCCargaInicialReclamos"));          
			traza("Antes de Conectar ConectorCargaInicialReclamo");
			conector = conectar("ConectorCargaInicialReclamo", paramConector);							
			traza("Despues de Conectar ConectorCargaInicialReclamo");
			objeto=conector.objeto("DTOSalida");
			traza("Objeto recogido"+objeto);
			DTOCargaInicialReclamos  dtoCargaInicial = (DTOCargaInicialReclamos)conector.objeto("DTOSalida");	
			traza("DTOCargaInicialReclamos obtenido");									
			asignar("VAR", "oid", oidRecibido.toString());
			
			RecordSet rsCanal=dtoCargaInicial.getCanales();
			Vector cols = rsCanal.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsCanal, cols);
			if(dtoReclamo.getCanal()!=null){
				asignar("VAR", "canal", dtoReclamo.getCanal().toString());
				asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getCanal().toString());								
			}else{
				asignar("COMBO", "cbCanal", conectorCargaCombo, "DTOSalida.combo_ROWSET");								
			}

			RecordSet rsAcceso=dtoCargaInicial.getAccesos();
			cols = rsAcceso.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosAccesos", rsAcceso, cols);
			asignar("MATRIZJS", "datosAccesos", conectorCargaCombo);
			if(dtoReclamo.getAcceso()!=null){				
				asignar("VAR", "acceso", dtoReclamo.getAcceso().toString());
			}
			if(dtoReclamo.getCanal()!=null){
				RecordSet rsCargaAcceso=new RecordSet();
				String sOid="OID";
				String sDescripcion="DESCRIPCION";
				Vector vectorDatos=null;
				rsCargaAcceso.addColumn(sOid);
				rsCargaAcceso.addColumn(sDescripcion);	
				for (int i=0;i<rsAcceso.getRowCount();i++){
					Long canalAcceso=new Long(rsAcceso.getValueAt(i,2).toString());
					if(canalAcceso.equals(dtoReclamo.getCanal())){
						vectorDatos=new Vector();					
						vectorDatos.add(rsAcceso.getValueAt(i,0));
						vectorDatos.add(rsAcceso.getValueAt(i,1));						
						rsCargaAcceso.addRow(vectorDatos);				
					}
				}
				cols = rsCargaAcceso.getColumnIdentifiers();
				conectorCargaCombo = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rsCargaAcceso, cols);	
				if(dtoReclamo.getAcceso()!=null){
					asignar("COMBO", "cbAcceso", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getAcceso().toString());
				}else{
					asignar("COMBO", "cbAcceso", conectorCargaCombo, "DTOSalida.combo_ROWSET");
				}
			}

			RecordSet rsSubAcceso=dtoCargaInicial.getSubaccesos();
			cols = rsSubAcceso.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "datosSubaccesos", rsSubAcceso, cols);
			asignar("MATRIZJS", "datosSubaccesos", conectorCargaCombo);
			if(dtoReclamo.getSubacceso()!=null){
				asignar("VAR", "subacceso", dtoReclamo.getSubacceso().toString());
			}
			if(dtoReclamo.getAcceso()!=null){				
				
				RecordSet rsCargaSubAcceso=new RecordSet();
				String sOid="OID";
				String sDescripcion="DESCRIPCION";
				Vector vectorDatos=null;
				rsCargaSubAcceso.addColumn(sOid);
				rsCargaSubAcceso.addColumn(sDescripcion);	
				for (int i=0;i<rsSubAcceso.getRowCount();i++){
					Long canalSubAcceso=new Long(rsSubAcceso.getValueAt(i,2).toString());
					Long accesoSubAcceso=new Long(rsSubAcceso.getValueAt(i,3).toString());
					if(canalSubAcceso.equals(dtoReclamo.getCanal())&&accesoSubAcceso.equals(dtoReclamo.getAcceso())){
						vectorDatos=new Vector();					
						vectorDatos.add(rsSubAcceso.getValueAt(i,0));
						vectorDatos.add(rsSubAcceso.getValueAt(i,1));						
						rsCargaSubAcceso.addRow(vectorDatos);				
					}
				}
				cols = rsCargaSubAcceso.getColumnIdentifiers();
				conectorCargaCombo = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rsCargaSubAcceso, cols);	
				if(dtoReclamo.getSubacceso()!=null){
					asignar("COMBO", "cbSubacceso", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSubacceso().toString());				
				}else{
					asignar("COMBO", "cbSubacceso", conectorCargaCombo, "DTOSalida.combo_ROWSET");
				}
			}
				
			
			
			RecordSet rsBancoR=dtoCargaInicial.getBancos();
			cols = rsBancoR.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsBancoR, cols);
			if(dtoReclamo.getBancoRecaudacion()!=null){
				asignar("VAR", "bancoRecaudacion", dtoReclamo.getBancoRecaudacion().toString());
				asignar("COMBO", "cbBancoRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getBancoRecaudacion().toString());								
			}else{
				asignar("COMBO", "cbBancoRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet rsCC=dtoCargaInicial.getCuentas();
			cols = rsCC.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsCC, cols);
			if(dtoReclamo.getCuentaCorriente()!=null){
				asignar("VAR", "cuenta", dtoReclamo.getCuentaCorriente().toString());
				asignar("COMBO", "cbCuenta", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getCuentaCorriente().toString());
			}else{
				asignar("COMBO", "cbCuenta", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet rsMedioPago=dtoCargaInicial.getMediosPago();
			cols = rsMedioPago.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsMedioPago, cols);
			if(dtoReclamo.getMedioPago()!=null){
				asignar("VAR", "medioPago", dtoReclamo.getMedioPago().toString());
				asignar("COMBO", "cbMedioPago", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getMedioPago().toString());								
			}else{
				asignar("COMBO", "cbMedioPago", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet sMotivoRechazo=dtoCargaInicial.getMotivosRechazoDesbloqueo();
			cols = sMotivoRechazo.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", sMotivoRechazo, cols);
			if(dtoReclamo.getMotivoDesbloqueoRechazo()!=null){
				asignar("VAR", "codigoSolucionRechazo", dtoReclamo.getMotivoDesbloqueoRechazo().toString());
				asignar("COMBO", "cbCodigoSolucionRechazo", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getMotivoDesbloqueoRechazo().toString());
			}else{
				asignar("COMBO", "cbCodigoSolucionRechazo", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet rsPeriodoReclamante=dtoCargaInicial.getPeriodos();
			cols = rsPeriodoReclamante.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsPeriodoReclamante,cols);
			if(dtoReclamo.getPeriodoReclamante()!=null){
				asignar("VAR", "periodoReclamante", dtoReclamo.getPeriodoReclamante().toString());
				asignar("COMBO", "cbPeriodoReclamante", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getPeriodoReclamante().toString());
			}else{
				asignar("COMBO", "cbPeriodoReclamante", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet rsSituacion=dtoCargaInicial.getSituaciones();
			cols = rsSituacion.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsSituacion, cols);
			if(dtoReclamo.getSituacion()!=null){
				asignar("VAR", "situacion", dtoReclamo.getSituacion().toString());
				asignar("COMBO", "cbSituacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSituacion().toString());
			}else{
				asignar("COMBO", "cbSituacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}


			RecordSet rsSucursal=dtoCargaInicial.getSucursales();
			cols = rsSucursal.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsSucursal, cols);
			if(dtoReclamo.getSucursal()!=null){
				asignar("VAR", "sucursalRecaudacion", dtoReclamo.getSucursal().toString());
				asignar("COMBO", "cbSucursalRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getSucursal().toString());
			}else{
				asignar("COMBO", "cbSucursalRecaudacion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

			RecordSet rsEmpresa=dtoCargaInicial.getEmpresas();
			cols = rsEmpresa.getColumnIdentifiers();
			conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rsEmpresa, cols);
			if(dtoReclamo.getEmpresa()!=null){
				asignar("VAR", "empresa", dtoReclamo.getEmpresa().toString());								
				asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET",cols.get(0).toString(),dtoReclamo.getEmpresa().toString());
			}else{
				asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET");
			}

traza("1");

			if(dtoReclamo.getAnyoAbonoDirecto()!=null){
				
				asignar("CTEXTO", "txtAnoCargoAbonoDirecto",dtoReclamo.getAnyoAbonoDirecto()+"");
			}

			if(dtoReclamo.getEjercicioCuota()!=null){
				asignar("CTEXTO", "textEjercicioCuota",dtoReclamo.getEjercicioCuota()+"");
			}

			if(dtoReclamo.getFechaResolucionPrevista()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionPrevista(), 
																		 UtilidadesSession.getFormatoFecha(this));
				asignar("CTEXTO", "textFechaResolucionReclamoPrevista",fechaFormateada);
			}

			if(dtoReclamo.getFechaResolucionReal()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaResolucionReal(), 
																		 UtilidadesSession.getFormatoFecha(this));				
				asignar("CTEXTO", "txtFechaResolucionReclamoReal",fechaFormateada);
			}
traza("2");
			if(dtoReclamo.getFicheroDocumentalAdjunto()!=null){
				asignar("CTEXTO", "textFicheroDocAdjunto",dtoReclamo.getFicheroDocumentalAdjunto());
			}
			
			if(dtoReclamo.getImporteReclamado()!=null){
				BigDecimal importeBig=new BigDecimal(dtoReclamo.getImporteReclamado().doubleValue()+0.0001);				 
				String ImporteFormateado=formatearImporte(importeBig,separadorMiles.charAt(0),separadorDecimales.charAt(0));
				asignar("CTEXTO", "textImporteReclamado",ImporteFormateado);
			}
			
			if(dtoReclamo.getNumeroCargoAbonoDirecto()!=null){
				asignar("CTEXTO", "txtNumCargoAbonoDirecto",dtoReclamo.getNumeroCargoAbonoDirecto()+"");
			}
	traza("3");		
			if(dtoReclamo.getNumeroIdentificadorCuota()!=null){
				asignar("CTEXTO", "textNumeroIdentificadorCuota",dtoReclamo.getNumeroIdentificadorCuota()+"");
			}
			
			if(dtoReclamo.getNumeroOrdenCuota()!=null){
				asignar("CTEXTO", "textNumeroOrdenCuota",dtoReclamo.getNumeroOrdenCuota()+"");
			}
			
			//if(dtoReclamo.getNumeroSerieCuota()!=null){
			//	asignar("CTEXTO", "textNumeroSerieCuota",dtoReclamo.getNumeroSerieCuota()+"");
			//}
	traza("4");		
			if(dtoReclamo.getObservacionesAreaReclamos()!=null){
				asignar("VAR", "observacionesAreaReclamos", dtoReclamo.getObservacionesAreaReclamos());
				//asignar("AREATEXTO", "textObservacionesAreaReclamos",dtoReclamo.getObservacionesAreaReclamos());
				asignarAtributoElemento("textObservacionesAreaReclamos","valor",dtoReclamo.getObservacionesAreaReclamos()+"");
			}
			
			if(dtoReclamo.getObservacionesClienteReclamante()!=null){
				asignar("VAR", "observacionesClienteReclamante", dtoReclamo.getObservacionesClienteReclamante());
				//asignar("AREATEXTO", "textObservacionesClienteReclamante",dtoReclamo.getObservacionesClienteReclamante());
				asignarAtributoElemento("textObservacionesClienteReclamante","valor",dtoReclamo.getObservacionesClienteReclamante()+"");
			}
			
			if(dtoReclamo.getObservacionesResolucion()!=null){
				asignar("VAR", "observacionesResolucionReclamos", dtoReclamo.getObservacionesResolucion());
				//asignar("AREATEXTO", "atxtObservacionesResolucionReclamos",dtoReclamo.getObservacionesResolucion());
				asignarAtributoElemento("atxtObservacionesResolucionReclamos","valor",dtoReclamo.getObservacionesResolucion()+"");
			}
	traza("5");		
			if(dtoReclamo.getPeriodoMesAbonoDirecto()!=null){
				asignar("CTEXTO", "txtMesCargoAbonoDirecto",dtoReclamo.getPeriodoMesAbonoDirecto());
			}
			
			if(dtoReclamo.getAnyo()!=null){
				//asignar("LABELC", "lblAnyoActual",dtoReclamo.getAnyo());
				asignarAtributo("LABELC","lbldtAño","valor",dtoReclamo.getAnyo());
				asignar("VAR", "hAnyo",dtoReclamo.getAnyo());
			
			}
		traza("6");	
			if(dtoReclamo.getCodigoCliente()!=null){
				asignar("CTEXTO", "textCodigoClienteReclamante",dtoReclamo.getCodigoCliente()+"");
			}
			
			if(dtoReclamo.getFechaDocumento()!=null){//DATE
				String fechaFormateada=UtilidadesBelcorp.fechaFormateada(dtoReclamo.getFechaDocumento(), 
															UtilidadesSession.getFormatoFecha(this));						
				//asignar("CTEXTO", "lbldtFechaDoc",fechaFormateada);
				asignarAtributo("LABELC","lbldtFechaDoc","valor",fechaFormateada);
			}
			
			if(dtoReclamo.getNumeroLote()!=null){
				//asignar("LABELC", "lblNumeroLoteActual",dtoReclamo.getNumeroLote()+"");
				asignarAtributo("LABELC","lbldtNumIdentificacion","valor",dtoReclamo.getNumeroLote()+"");
			}
traza("7");			
			if(dtoReclamo.getPeriodoMes()!=null){
				//asignar("LABELC", "lblMesActual",dtoReclamo.getPeriodoMes());
				asignarAtributo("LABELC","lbldtMes","valor",dtoReclamo.getPeriodoMes()+"");
				asignar("VAR", "hPeriodoMes",dtoReclamo.getPeriodoMes());
				
			}
			

			if(dtoReclamo.getUsuarioGestorPrevisto()!=null){
				asignar("CTEXTO", "cbUsuarioGestorReclamoPrevisto",dtoReclamo.getUsuarioGestorPrevisto());
			}
			
			if(dtoReclamo.getUsuarioGestorReal()!=null){
				asignar("CTEXTO", "cbUsuarioGestorReclamoReal",dtoReclamo.getUsuarioGestorReal());
			}
			
			if(dtoReclamo.getUsuarioSolicitante()!=null){
				//asignar("LABELC", "lblUsuarioSolicitantedt",dtoReclamo.getUsuarioSolicitante());
				asignarAtributo("LABELC","lblUsuarioSolicitantedt","valor",dtoReclamo.getUsuarioSolicitante()+"");
				asignar("VAR", "hUsuarioSolicitante",dtoReclamo.getUsuarioSolicitante());
traza("8");				
			}
			String descPais = UtilidadesSession.getDescripcionPais(this);			
			//asignar("LABELC", "lblPaisActual", descPais);	
				
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
		traza("LPModificarReclamos.accionVacia Salida");		
	}			
	private void accionGuardar(Long idioma,Long pais) throws Exception{
		traza("LPModificarReclamos.accionGuardar Entrada");		
		try{
        	pagina("salidaGenerica");
        	asignar("VAR", "cerrarVentana", "true");			
			String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
			String separadorMiles = ",";
			if (separadorDecimales.equals(",")){
				separadorMiles = ".";
			}
traza("enpieza accion guardar 9");			
			DTOReclamo dtoReclamo=new DTOReclamo();
			dtoReclamo.setOidPais(pais);
			dtoReclamo.setOidIdioma(idioma);
			if(!conectorParametroLimpia("cbAcceso", "", true).equals("")){
				dtoReclamo.setAcceso(new Long(conectorParametroLimpia("cbAcceso", "", true)) );//Long
			}
			if(!conectorParametroLimpia("txtAnoCargoAbonoDirecto", "", true).equals("")){
				dtoReclamo.setAnyoAbonoDirecto(conectorParametroLimpia("txtAnoCargoAbonoDirecto", "", true) );//String
			}
			if(!conectorParametroLimpia("cbCanal", "", true).equals("")){
				dtoReclamo.setCanal(new Long(conectorParametroLimpia("cbCanal", "", true)) );//Long	
			}
			if(!conectorParametroLimpia("textEjercicioCuota", "", true).equals("")){		
				dtoReclamo.setEjercicioCuota(conectorParametroLimpia("textEjercicioCuota", "", true) );//String
			}
			if(!conectorParametroLimpia("cbEmpresa", "", true).equals("")){
				dtoReclamo.setEmpresa(new Long(conectorParametroLimpia("cbEmpresa", "", true)) );//Long
			}
			if(!conectorParametroLimpia("textFechaResolucionReclamoPrevista", "", true).equals("")){
				dtoReclamo.setFechaResolucionPrevista(UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("textFechaResolucionReclamoPrevista", "", true),UtilidadesSession.getFormatoFecha(this)));//Date
			}
			if(!conectorParametroLimpia("textFechaResolucionReclamoReal", "", true).equals("")){
				dtoReclamo.setFechaResolucionReal(UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("textFechaResolucionReclamoReal", "", true),UtilidadesSession.getFormatoFecha(this)) );//Date
			}
traza(" 10");
			if(!conectorParametroLimpia("textFicheroDocAdjunto", "", true).equals("")){
				dtoReclamo.setFicheroDocumentalAdjunto(conectorParametroLimpia("textFicheroDocAdjunto", "", true) );//String
			}
			if(!conectorParametroLimpia("textImporteReclamado", "", true).equals("")){
				Double iporteDesformateado=desformatearImporte(conectorParametroLimpia("textImporteReclamado", "", true),separadorMiles.charAt(0),separadorDecimales.charAt(0));				
				dtoReclamo.setImporteReclamado(iporteDesformateado);//Double
			}
			if(!conectorParametroLimpia("cbMedioPago", "", true).equals("")){
				dtoReclamo.setMedioPago(new Long(conectorParametroLimpia("cbMedioPago", "", true)) );//Long
			}
			if(!conectorParametroLimpia("cbCodigoSolucionRechazo", "", true).equals("")){
				dtoReclamo.setMotivoDesbloqueoRechazo( new Long(conectorParametroLimpia("cbCodigoSolucionRechazo", "", true)) );//Long
			}
			if(!conectorParametroLimpia("txtNumCargoAbonoDirecto", "", true).equals("")){
				dtoReclamo.setNumeroCargoAbonoDirecto( new Integer(conectorParametroLimpia("textNumeroCargoAbonoDirecto", "", true)) );//Integer
			}
			if(!conectorParametroLimpia("textNumeroIdentificadorCuota", "", true).equals("")){
				dtoReclamo.setNumeroIdentificadorCuota( new Integer(conectorParametroLimpia("textNumeroIdentificadorCuota", "", true)) );//Integer
			}
			if(!conectorParametroLimpia("textNumeroOrdenCuota", "", true).equals("")){
				dtoReclamo.setNumeroOrdenCuota( new Integer(conectorParametroLimpia("textNumeroOrdenCuota", "", true)) );//Integer
			}
			//if(!conectorParametroLimpia("textNumeroSerieCuota", "", true).equals("")){
			//	dtoReclamo.setNumeroSerieCuota(conectorParametroLimpia("textNumeroSerieCuota", "", true) );//String
			//}
			if(!conectorParametroLimpia("textObservacionesAreaReclamos", "", true).equals("")){
				dtoReclamo.setObservacionesAreaReclamos(conectorParametroLimpia("textObservacionesAreaReclamos", "", true) );//String
			}
			if(!conectorParametroLimpia("textObservacionesClienteReclamante", "", true).equals("")){
				dtoReclamo.setObservacionesClienteReclamante(conectorParametroLimpia("textObservacionesClienteReclamante", "", true) );//String
			}
			if(!conectorParametroLimpia("atxtObservacionesResolucionReclamos", "", true).equals("")){
				dtoReclamo.setObservacionesResolucion(conectorParametroLimpia("textObservacionesResolucionReclamos", "", true) );//String
			}
			
			dtoReclamo.setOid( new Long(conectorParametroLimpia("oid", "", true)) );//Long
			
traza(" 11");
			if(!conectorParametroLimpia("cbPeriodoReclamante", "", true).equals("")){
				dtoReclamo.setPeriodoReclamante( new Long(conectorParametroLimpia("cbPeriodoReclamante", "", true)) );//Long
			}
			if(!conectorParametroLimpia("cbSubacceso", "", true).equals("")){
				dtoReclamo.setSubacceso( new Long(conectorParametroLimpia("cbSubacceso", "", true)) );//Long
			}
			if(!conectorParametroLimpia("hAnyo", "", true).equals("")){
				dtoReclamo.setAnyo(conectorParametroLimpia("hAnyo", "", true) );//String
			}
			if(!conectorParametroLimpia("cbBancoRecaudacion", "", true).equals("")){
				dtoReclamo.setBancoRecaudacion( new Long(conectorParametroLimpia("cbBancoRecaudacion", "", true)) );//Long
			}
			if(!conectorParametroLimpia("textCodigoClienteReclamante", "", true).equals("")){
				dtoReclamo.setCodigoCliente(conectorParametroLimpia("textCodigoClienteReclamante", "", true) );//String
			}
			if(!conectorParametroLimpia("cbCuenta", "", true).equals("")){
				dtoReclamo.setCuentaCorriente( new Long(conectorParametroLimpia("cbCuenta", "", true)) );//Long
			}
			if(!conectorParametroLimpia("lbldtFechaDoc", "", true).equals("")){
				dtoReclamo.setFechaDocumento(UtilidadesBelcorp.getDatefromSICCStringFormat(conectorParametroLimpia("lbldtFechaDoc", "", true),UtilidadesSession.getFormatoFecha(this)) );//Date
			}
			if(!conectorParametroLimpia("cbSituacion", "", true).equals("")){
				dtoReclamo.setSituacion( new Long(conectorParametroLimpia("cbSituacion", "", true)) );//Long
			}
			if(!conectorParametroLimpia("cbSucursalRecaudacion", "", true).equals("")){
				dtoReclamo.setSucursal( new Long(conectorParametroLimpia("cbSucursalRecaudacion", "", true)) );//Long
			}
			if(!conectorParametroLimpia("cbUsuarioGestorReclamoPrevisto", "", true).equals("")){
				dtoReclamo.setUsuarioGestorPrevisto( conectorParametroLimpia("cbUsuarioGestorReclamoPrevisto", "", true) );//String
			}
			if(!conectorParametroLimpia("cbUsuarioGestorReclamoReal", "", true).equals("")){
				dtoReclamo.setUsuarioGestorReal( conectorParametroLimpia("cbUsuarioGestorReclamoReal", "", true) );//String
			}
			traza(" 12");
			if(!conectorParametroLimpia("txtMesCargoAbonoDirecto", "", true).equals("")){
				dtoReclamo.setPeriodoMesAbonoDirecto( conectorParametroLimpia("txtMesCargoAbonoDirecto", "", true));//String
			}
			if(!conectorParametroLimpia("hUsuarioSolicitante", "", true).equals("")){//es un label
				dtoReclamo.setUsuarioSolicitante( conectorParametroLimpia("hUsuarioSolicitante", "", true) );//String
			}			
			if(!conectorParametroLimpia("hPeriodoMes", "", true).equals("")){//es un label
				dtoReclamo.setPeriodoMes(conectorParametroLimpia("hPeriodoMes", "", true) );//String
			}		
			
			traza("*******GUARDA*********DTOReclamo Formado: "+ dtoReclamo);
			Vector paramConector = new Vector();
			paramConector.add(dtoReclamo);
			paramConector.add(new MareBusinessID("CCCGuardarReclamo"));          
			traza("Antes de Conectar ConectorGuardarReclamo ");
			DruidaConector conector = conectar("ConectorGuardarReclamo", paramConector);							
			traza("Despues de Conectar ConectorGuardarReclamo");		
		}catch ( Exception e )  {
			traza("exception de LPModificarReclamos");
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
		traza("LPModificarReclamos.accionGuardar Salida");		
	}					
	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}	
	private String formatearImporte(BigDecimal dineroEntrada,char separadorMiles,char separadorDecimales){
		StringTokenizer tokens=new StringTokenizer(dineroEntrada.toString(),".");		
		StringBuffer bufferDecimal=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
	
		int miles=0;
		while(bufferDecimal.length()>0){
			miles++;
			bufferDinero.insert(0,bufferDecimal.charAt(bufferDecimal.length()-1));
			bufferDecimal.deleteCharAt(bufferDecimal.length()-1);
			if(miles==3&&bufferDecimal.length()>0){
				miles=0;
				bufferDinero.insert(0,separadorMiles);
			}
		}

		if((tokens.hasMoreTokens())){
			bufferDecimales.append(tokens.nextToken());
			String comprobacion=bufferDecimales.toString();
			if(bufferDecimales.length()>1){
				if(!bufferDecimales.substring(0,2).equals("00")){
					if(!bufferDecimales.substring(1,2).equals("0")){
						bufferDinero.append(separadorDecimales+bufferDecimales.substring(0,2));
					}else{
						bufferDinero.append(separadorDecimales+bufferDecimales.substring(0,1));
					}
				}
			}else{
				if(!bufferDecimales.substring(0,1).equals("0")){
					bufferDinero.append(separadorDecimales+bufferDecimales.toString());
				}
			}
		}
		return bufferDinero.toString();
		
	}	
	private Double desformatearImporte(String dineroEntrada,char separadorMiles,char separadorDecimales){
		String dineroSalida="";
		StringTokenizer tokens=new StringTokenizer(dineroEntrada,separadorMiles+"");					
		while(tokens.hasMoreTokens()){
			dineroSalida=dineroSalida+tokens.nextToken();
		}
		dineroSalida=dineroSalida.replace(separadorDecimales,'.');
		return new Double(dineroSalida);
	}
}
		*/ 