/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.util.StringTokenizer;

import java.util.Date;


import es.indra.sicc.dtos.mae.DTOTipoSubtipo;



import es.indra.sicc.dtos.intsys.DTOINTEnviarConsultorasDeuda;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;


import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.ccc.DTONumero;
	
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialConsultorasDeudas;			 

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

import java.util.Vector;
import java.util.Date;
import java.util.Arrays;

public class LPEnviarConsultorasDeudasMovsDeudaPdte extends LPSICCBase {
	
	private String accion = null;
	private Long idioma;
   	private Long pais;
   	private String numLot = null;
   
  	public LPEnviarConsultorasDeudasMovsDeudaPdte() {
	    super();
  	}
    
	public void inicio() throws Exception {
 		pagina("contenido_consultoras_deudas_enviar");
 		getConfiguracionMenu("LPEnviarConsultorasDeudasMovsDeudaPdte","");
  	}

  public void ejecucion() throws Exception {
	//cambio segun nuevo diseño, Cambio_Carga_Inicial

      rastreo();
      setTrazaFichero();
      this.accion = conectorParametroLimpia("accion", "", true);
      this.idioma = UtilidadesSession.getIdioma(this);
      this.pais = UtilidadesSession.getPais(this);

      traza("accion de entrada " + accion);  
      asignarAtributo("PAGINA","contenido_consultoras_deudas_enviar", "cod", "0255");
      asignarAtributo("PAGINA","contenido_consultoras_deudas_enviar", "msgle", "Enviar Consultoras y Deudas/Movimientos de deuda pendiente");
      this.generarHiddenFormatoFecha();       
      try{
      		if(accion.equals("")){
      			traza("Entara en accion vacia ");  
      			cargaInicial();
		}else{  	
	 		if(accion.equals("enviar")){
	 			traza("Entara en enviar ");  
	 			enviar();
	 		}
	 	}
      }catch(Exception  e){
         traza("ERROR: " + e);
         e.printStackTrace();
         lanzarPaginaError(e);  
      }
  }
  

  	private void cargaInicial() throws Exception {
		traza("ENTRADA cargaInicial LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
		
		//asignacion fecha actual a las cajas Fecha Desde y Fecha hasta
		String fecha = UtilidadesBelcorp.fechaFormateada(new java.util.Date(), UtilidadesSession.getFormatoFecha(this));
		traza("******* FECHA ACTUAL: "+fecha);
		asignar("CTEXTO", "FechaDesde", fecha);
		asignar("CTEXTO", "FechaHasta", fecha);		
		
      		DTOINTCargaInicialConsultorasDeudas dtoCI = obtenerDatosIniciales() ;
      		traza(dtoCI);
      		//Con el objeto obtenido cargamos los campos: 
		asignar("LABELC","lblvalorLote",dtoCI.getNumeroLote().toString());
		asignar("VAR","numeroLote",dtoCI.getNumeroLote().toString());
		traza("label numero lote asignado: "+ dtoCI.getNumeroLote().toString());
		asignar("CTEXTO","Descripcion",dtoCI.getDescripcionLote());
		traza("descri asignado");
		DTOSalida dtoSalida = (DTOSalida)dtoCI.getListaEmpresas();
		traza("recogido empresas asignado");
		RecordSet empresa= null;
		if (dtoSalida.getResultado()!= null) {
			traza("dentro if 1");
          		empresa = dtoSalida.getResultado();
          		traza("empresas asignado");
          		Vector cols = empresa.getColumnIdentifiers();
        		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", empresa, cols);
             		traza("conector carga combo empresas asignado");
            		asignar("COMBO", "cbEmpresa", conectorCargaCombo, "DTOSalida.combo_ROWSET");
            		traza("empresas fin asignado");
        	}
       		traza("sino1");
        	DTOSalida dtoSalida1 = (DTOSalida)dtoCI.getListaRegiones();
       		traza("regiones asignado");
		RecordSet region= null;
		if (dtoSalida1.getResultado()!= null) {
			traza("if2 asignado");
        		region = dtoSalida1.getResultado();
        	  	
        	  	
        	  	
  			//Recorremos todas las filas recuperadas en el recordSet: 

		        RecordSet rs = new RecordSet();
			rs.addColumn(new String("OID"));
                        rs.addColumn(new String("DES"));

                        Vector cols= rs.getColumnIdentifiers();
                        Vector row = null;
                        traza("Antes for");
		        for (int i=0;i<region.getRowCount();i++){
		        	row = new Vector();
		        	traza("Vector creado");
		        	row.add(region.getValueAt(i,0));
		        	traza("parametro anadido");
                        	row.add(region.getValueAt(i,5));
                        	traza("parametro anadido");
				rs.addRow(row);	
				traza("row anadida al rs");
		        }
			traza(rs);
        	  	Vector cols1 = rs.getColumnIdentifiers();
	              	DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols1);
        	      	asignar("COMBO", "cbRegion", conectorCargaCombo, "DTOSalida.combo_ROWSET");
        	}
        	DTOTipoSubtipo dtoTipo = (DTOTipoSubtipo)dtoCI.getListaTiposSubtiposClientes();
		RecordSet tipos= null;
		if (dtoTipo.getTipos()!= null) {
			traza("if3 asignado");
        		tipos = dtoTipo.getTipos();
        	  	Vector cols3 = tipos.getColumnIdentifiers();
	              	DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", tipos, cols3);
        	      	asignar("COMBO", "cbTipoCliente", conectorCargaCombo, "DTOSalida.combo_ROWSET");
        	}
	
		//El resto de las listas recibidas en el objeto retornado se guardan en arrays: 
		RecordSet zonas= null;
		if (dtoCI.getListaZonas().getResultado() != null) {
			traza("if4 asignado");
        	 	zonas = dtoCI.getListaZonas().getResultado();
        	 	Vector cols2 = zonas.getColumnIdentifiers();
             		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", zonas, cols2);
             		asignar("MATRIZJS", "listaZonas", conectorCargaCombo, "DTOSalida.combo_ROWSET");
        	}
        	RecordSet subTipos= null;
		if (dtoCI.getListaTiposSubtiposClientes().getSubtipos() != null) {
			traza("if5 asignado");
        		subTipos = dtoCI.getListaTiposSubtiposClientes().getSubtipos();
        	 	Vector cols4 = subTipos.getColumnIdentifiers();
             		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.subtipos_ROWSET", subTipos, cols4);
             		asignar("MATRIZJS", "listaSubtipos", conectorCargaCombo, "DTOSalida.subtipos_ROWSET");
		}
        	RecordSet tiposClasificacion= null;
		if (dtoCI.getListaTiposClasificacion().getTipoClasificacion() != null) {	
			traza("if6 asignado");
			tiposClasificacion = dtoCI.getListaTiposClasificacion().getTipoClasificacion();
			Vector cols5 = tiposClasificacion.getColumnIdentifiers();
			DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "dtoClasifi.tipoclasificacion_ROWSET", tiposClasificacion, cols5);
			asignar("MATRIZJS", "listaTiposClasificacion", conectorCargaCombo, "dtoClasifi.tipoclasificacion_ROWSET");
		}
		RecordSet clasifica= null;
		if (dtoCI.getListaTiposClasificacion().getClasificacion() != null) {
			traza("if7 asignado");
        	 	clasifica = dtoCI.getListaTiposClasificacion().getClasificacion();
        	 	Vector cols6 = clasifica.getColumnIdentifiers();
             		DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "dtoClasifi.clasificacion_ROWSET", clasifica, cols6);
             		asignar("MATRIZJS", "listaClasificacionCliente", conectorCargaCombo, "dtoClasifi.clasificacion_ROWSET");
	        }
	        traza("SALIDA cargaInicial LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
	}

  	private void enviar() throws Exception {
  		traza("ENTRADA ENVIAR LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
  		pagina("salidaGenerica");
		DTOINTEnviarConsultorasDeuda dtoIntEnviar = new DTOINTEnviarConsultorasDeuda();
		traza("Se asigna pais e idioma");
		dtoIntEnviar.setOidIdioma(idioma);
		dtoIntEnviar.setOidPais(pais);
		
		traza("Cominezan obtencion de datos");
		
		String numeroLote = conectorParametroLimpia("numeroLote", "", true);
		if (numeroLote!=null){
			traza("Numero lote"+numeroLote);
		}else{
			traza("Numero lote ES NULL");
		}
		String descripcionLote = conectorParametroLimpia("descripcionLote", "", true);
		if (descripcionLote!=null){
			traza("Descripcion lote"+descripcionLote);
		}else{
			traza("Descripcion lote ES NULL");
		}

		String fechaDesde = conectorParametroLimpia("fechaDesde", "", true);
		if (fechaDesde!=null){
			traza("FechaDesde lote"+fechaDesde);
		}else{
			traza("FechaDesde lote ES NULL");
		}

		String fechaHasta = conectorParametroLimpia("fechaHasta", "", true);
		if (fechaHasta!=null){
			traza("FechaHasta lote"+fechaHasta);
		}else{
			traza("FechaHasta lote ES NULL");
		}

		String observaciones = conectorParametroLimpia("observaciones", "", true);
		if (observaciones!=null){
			traza("Observaciones lote"+observaciones);
		}else{
			traza("Observaciones lote ES NULL");
		}

		String empresa = conectorParametroLimpia("empresa", "", true);
		if (empresa!=null){
			traza("empresa lote"+empresa);
		}else{
			traza("empresa lote ES NULL");
		}

		String regiones = conectorParametroLimpia("regiones", "", true);
		if (regiones!=null){
			traza("regiones lote"+regiones);
		}else{
			traza("regiones lote ES NULL");
		}

		String zonas = conectorParametroLimpia("zonas", "", true);
		if (zonas!=null){
			traza("zonas lote"+zonas);
		}else{
			traza("zonas lote ES NULL");
		}

		String tiposCliente = conectorParametroLimpia("tiposCliente", "", true);
		if (tiposCliente!=null){
			traza("tiposCliente lote"+tiposCliente);
		}else{
			traza("tiposCliente lote ES NULL");
		}

		String subTiposCliente = conectorParametroLimpia("subTiposCliente", "", true);
		if (subTiposCliente!=null){
			traza("subTiposCliente lote"+subTiposCliente);
		}else{
			traza("subTiposCliente lote ES NULL");
		}

		String tiposClasificacion = conectorParametroLimpia("tiposClasificacion", "", true);
		if (tiposClasificacion!=null){
			traza("tiposClasificacion lote"+tiposClasificacion);
		}else{
			traza("tiposClasificacion lote ES NULL");
		}

		String clasificaciones = conectorParametroLimpia("clasificaciones", "", true);
		if (clasificaciones!=null){
			traza("clasificaciones lote"+clasificaciones);
		}else{
			traza("clasificaciones lote ES NULL");
		}

		String ckConsultora = conectorParametroLimpia("ckConsultora", "", true);
		if (ckConsultora!=null){
			traza("ckConsultora lote"+ckConsultora);
		}else{
			traza("ckConsultora lote ES NULL");
		}

		String ckMovimientos = conectorParametroLimpia("ckMovimientos", "", true);
		if (ckMovimientos!=null){
			traza("ckMovimientos lote"+numeroLote);
		}else{
			traza("ckMovimientos lote ES NULL");
		}

		traza("INICIO asignaciones");
		
		dtoIntEnviar.setNumeroLote(numeroLote);
		dtoIntEnviar.setDescripcionLote(descripcionLote);
		dtoIntEnviar.setObservaciones(observaciones);
		
		if (ckConsultora.equals("S")){
			dtoIntEnviar.setEnviarConsultoras(Boolean.TRUE);	
		}else {
			dtoIntEnviar.setEnviarConsultoras(Boolean.FALSE);
		}

		if (ckMovimientos.equals("S")){
			dtoIntEnviar.setEnviarMovimientos(Boolean.TRUE);	
		}else {
			dtoIntEnviar.setEnviarMovimientos(Boolean.FALSE);
		}
        	dtoIntEnviar.setFechaDesde(new Date((this.fecha(fechaDesde)).getTime()));
		dtoIntEnviar.setFechaHasta(new Date((this.fecha(fechaHasta)).getTime())); 

		traza("Antes de empresa");	
    		StringTokenizer strEmpresa = new StringTokenizer(empresa,",");
		String tokenEmpresa = null;
		Long [] oidEmpresa = new Long[strEmpresa.countTokens()];
		int i=0;
    		while (strEmpresa.hasMoreTokens()){
				tokenEmpresa = strEmpresa.nextToken();
				oidEmpresa[i]=new Long(tokenEmpresa);
				i++;
    		}
    		DTOOIDs listaEmp = new DTOOIDs();
		listaEmp.setOids(oidEmpresa);
    		dtoIntEnviar.setListaEmpresa(listaEmp);


		traza("Antes de regiones");	
    		StringTokenizer strRegiones = new StringTokenizer(regiones,",");
		String tokenRegiones = null;
		Long [] oidRegiones = new Long[strRegiones.countTokens()];
		i=0;
    		while (strRegiones.hasMoreTokens()){
				tokenRegiones = strRegiones.nextToken();
				oidRegiones[i]=new Long(tokenRegiones);
				i++;
    		}
    		DTOOIDs listaReg = new DTOOIDs();
		listaReg.setOids(oidRegiones);
    		dtoIntEnviar.setListaRegiones(listaReg);

		traza("Antes de zonas");	
		StringTokenizer strZonas = new StringTokenizer(zonas,",");
		String tokenZonas = null;
		Long [] oidZonas = new Long[strZonas.countTokens()];
		i=0;
    		while (strZonas.hasMoreTokens()){
				tokenZonas = strZonas.nextToken();
				oidZonas[i]=new Long(tokenZonas);
				i++;
    		}
    		DTOOIDs listaZon = new DTOOIDs();
		listaZon.setOids(oidZonas);
    		dtoIntEnviar.setListaZonas(listaZon);		

		traza("Antes de tiposcliente");	
		StringTokenizer strTipos = new StringTokenizer(tiposCliente,",");
		String tokenTipos = null;
		Long [] oidTipos = new Long[strTipos.countTokens()];
		i=0;
    		while (strTipos.hasMoreTokens()){
				tokenTipos = strTipos.nextToken();
				oidTipos[i]=new Long(tokenTipos);
				i++;
    		}
    		DTOOIDs listaTip = new DTOOIDs();
		listaTip.setOids(oidTipos);
    		dtoIntEnviar.setListaTiposCliente(listaTip);		



		traza("Antes de subtipos");		
		StringTokenizer strSubTipos = new StringTokenizer(subTiposCliente,",");
		String tokenSubTipos = null;
		Long [] oidSubTipos = new Long[strSubTipos.countTokens()];
		i=0;
    		while (strSubTipos.hasMoreTokens()){
				tokenSubTipos = strSubTipos.nextToken();
				oidSubTipos[i]=new Long(tokenSubTipos);
				i++;
    		}
    		DTOOIDs listaSub = new DTOOIDs();
		listaSub.setOids(oidSubTipos);
    		dtoIntEnviar.setListaSubtiposCliente(listaSub);		

		
		traza("Antes de tiposclasifi");	
		StringTokenizer strTiposClasificacion = new StringTokenizer(tiposClasificacion,",");
		String tokenTiposClasificacion = null;
		Long [] oidTiposClasificacion = new Long[strTiposClasificacion.countTokens()];
		i=0;
		while (strTiposClasificacion.hasMoreTokens()){
				tokenTiposClasificacion = strTiposClasificacion.nextToken();
				oidTiposClasificacion[i]=new Long(tokenTiposClasificacion);
				i++;
    		}
    		DTOOIDs listaTCl = new DTOOIDs();
		listaTCl.setOids(oidTiposClasificacion);
    		dtoIntEnviar.setListaTiposClasificacion(listaTCl);		



		traza("Antes de clasifi");	
		StringTokenizer strClasificacion = new StringTokenizer(clasificaciones,",");
		String tokenClasificacion = null;
		Long [] oidClasificacion = new Long[strClasificacion.countTokens()];
		i=0;
    		while (strClasificacion.hasMoreTokens()){
				tokenClasificacion = strClasificacion.nextToken();
				oidClasificacion[i]=new Long(tokenClasificacion);
				i++;
    		}
    		DTOOIDs listaCLA = new DTOOIDs();
		listaCLA.setOids(oidClasificacion);
    		dtoIntEnviar.setListaClasificacion(listaCLA);		
		traza(dtoIntEnviar);
		traza("Despues de casi todo");	
		//dtoIntEnviar.falta saber como me lo envia todos los campos
		Vector paramConector2 = new Vector();
		paramConector2.add(dtoIntEnviar);
		paramConector2.add(new MareBusinessID("INTEnviarConsultorasDeudaMovsDeudaPdte"));                 		
    		traza("***** Antes de Conectar2");       		
    		DruidaConector conector2 = conectar("ConectorEnviarConsultorasDeudaMovsDeudaPdte", paramConector2);                                                                              
         	traza("***** Despues de Conectar2");   
         	
         	asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
         	
         	traza("SALIDA ENVIAR LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
      	}


  	
  	private DTOINTCargaInicialConsultorasDeudas obtenerDatosIniciales () throws Exception {
  		traza("ENTRADA ObtenerDatosIniciales LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
		DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
		dtoUA.setOidPais(this.pais);
        	dtoUA.setOidIdioma(this.idioma);
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoUA);
        	paramEntrada.add(new MareBusinessID("INTCargaInicialConsultorasDeudas"));
        	traza("entra 1");
  		DruidaConector conCarga = conectar("ConectorCargaInicialConsultorasDeudas", paramEntrada);
  		traza("sale 1");
  		Object objeto = conCarga.objeto("DTOINTCargaInicialConsultorasDeudas");
  		traza("sale 2");
  		traza(objeto);
  		traza(objeto.getClass());
  		DTOINTCargaInicialConsultorasDeudas dtoINTCargaInicialConsultorasDeudas = (DTOINTCargaInicialConsultorasDeudas)conCarga.objeto("DTOINTCargaInicialConsultorasDeudas");
  		traza(dtoINTCargaInicialConsultorasDeudas);
  		traza("Salida ObtenerDatosIniciales LPENVIARCONSULTORASDEUDASMOVSDEUDAPDTE");
  		return dtoINTCargaInicialConsultorasDeudas;
	}





	
	private java.sql.Date fecha(String entrada)  throws Exception {
          if (entrada != null && !entrada.equals("-")) return new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(entrada, UtilidadesSession.getFormatoFecha(this))).getTime());
              return null;
    }
 


	
}