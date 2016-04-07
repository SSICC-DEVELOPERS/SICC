/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Españaamo
 *
 * Privado y Confidencial.c
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;


public class LPConsultaGeneralConcurso extends LPConsultaIntegralInc {    
	private String oidDefault = new String();
    
    public LPConsultaGeneralConcurso() { super(); }

    public void inicio() throws Exception {
		pagina("contenido_general_concursos_consultar");
	}

    public void ejecucion() throws Exception {
        setTrazaFichero();
		traza("LPConsultaGeneralConcurso.ejecucion - Entrada");

        try{
            accion = conectorParametroLimpia("accion", "", true);
			traza("*********** accion " + accion);

			lIdioma = UtilidadesSession.getIdioma(this);
			lPais = UtilidadesSession.getPais(this);
		
            if (accion.equals("") || accion.equals("gestionarContacto") ){
                cargarPantalla();
            }
            else if (accion.equals("cargaClienteConcurso")) {
                cargaClienteConcurso(); 
            }            
            else if (accion.equals("direccionaPeticionDetalle")) {
                direccionaPeticionDetalle(); 
            }            
            else if (accion.equals("recuperarValoresUA")) {
                recuperarValoresUA(); 
            }            			

			traza("LPConsultaGeneralConcurso.ejecucion - Salida");
			cargarMenuSecundario();
         }
		 catch(Exception ex) {
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

	private void cargarMenuSecundario() throws Exception {     
		traza("LPConsultaGeneralConcurso.cargarMenuSecundario - Entrada");
		String varBotonPresionado = 
		this.conectorParametroLimpia("varBotonPresionado", "", true);
		traza("********* varBotonPresionado " + varBotonPresionado);

		getConfiguracionMenu("LPConsultaGeneralConcurso","");    

		if (accion.equals("")){	
			asignarAtributoPagina("cod", "0945");         		 
        }
        else if (accion.equals("direccionaPeticionDetalle")) {
			if(varBotonPresionado.equals("premiosProcesados")) {			 
	 			asignarAtributoPagina("cod", "2871");       
				
              // vbongiov -- INC-014 -- 8/10/2008
			} else if(varBotonPresionado.equals("premiosAsociadosNivel")) {			 
	 			asignarAtributoPagina("cod", "3373");         		
			}
		}      
		traza("LPConsultaGeneralConcurso.cargarMenuSecundario - Salida");
	}
    
	public void cargarPantalla() throws Exception {
		traza("LPConsultaGeneralConcurso.cargarPantalla - Entrada");		
		getFormatosValidaciones();
		asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		asignarAtributo("CTEXTO", "txtCodCliente", "valor", conectorParametroLimpia("codigoCliente", "", true));
		// vbongiov -- INC-014 -- 6/09/2008
		this.cargarCombos();

		traza("LPConsultaGeneralConcurso.cargarPantalla - Salida");
	}

    // vbongiov -- INC-014 -- 6/09/2008
	private void cargarCombos() throws Exception{
  
    traza("antes de ComposerViewElementList  ");
    ComposerViewElementList lista = new ComposerViewElementList();

	DTOBelcorp dtoBel = new DTOBelcorp();
	traza("antes de asignar al dtobelcorp");
	dtoBel.setOidPais(lPais);
	dtoBel.setOidIdioma(lIdioma);
		   
    ComposerViewElement descripcionesTipoConcurso = new ComposerViewElement();
	descripcionesTipoConcurso.setIDBusiness("INCConsultaTiposConcursoIVR");
	descripcionesTipoConcurso.setDTOE(dtoBel);
		   
	lista.addViewElement(descripcionesTipoConcurso);

	ComposerViewElement descripcionesEstadoConcurso = new ComposerViewElement();
	descripcionesEstadoConcurso.setIDBusiness("INCConsultarEstadoConcurso");
	descripcionesEstadoConcurso.setDTOE(dtoBel);
		   
	lista.addViewElement(descripcionesEstadoConcurso);

    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    traza("antes del conector.ejecucion");
    conector.ejecucion();
    traza("despues del conector");
    DruidaConector resultados = conector.getConector();
         
    asignar("COMBO","cbTipoConcurso",resultados,"INCConsultaTiposConcursoIVR");       
	asignar("COMBO","cbEstadoConcurso",resultados,"INCConsultarEstadoConcurso");      
    
  }



	public void cargaClienteConcurso() throws Exception {
		traza("LPConsultaGeneralConcurso.cargaClienteConcurso - Entrada");
		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		try {
			dtoCabecera = new DTOCabeceraConsultaIntegral();		
			
			String codigoCliente = 
			conectorParametroLimpia("codigoCliente", "", true);
			traza("***** codigoCliente " + codigoCliente);	
			if(!codigoCliente.equals("")) {
				dtoCabecera.setCodigoCliente(codigoCliente);
			}

			String numeroConcurso = 
			conectorParametroLimpia("numeroConcurso", "", true);
			traza("***** numeroConcurso " + numeroConcurso);
			if(!numeroConcurso.equals("")) {
				dtoCabecera.setNumeroConcurso(numeroConcurso);
			}

			MareBusinessID businessID = 
			new MareBusinessID("INCRecuperarClienteConcurso");

			Vector parametros = new Vector();      
      
		    parametros.add(dtoCabecera);
			parametros.add(businessID);

		    traza("******************* Antes de conectar " + dtoCabecera);
			DruidaConector con = 
			conectar("ConectorRecuperaClienteConcurso", parametros);

			DTOCabeceraConsultaIntegral dtoCabeceraConsulta = 
			(DTOCabeceraConsultaIntegral)con.objeto("DTOSalida");    
			traza("******************* Despues de conectar " + dtoCabeceraConsulta);

			setCabecera(dtoCabeceraConsulta);

			String oidClienteParam;
			String codigoClienteParam;
			String nombreApellidosParam;
			String oidConcursoParam;
			String numeroConcursoParam;

			if(dtoCabeceraConsulta.getOidCliente()!=null) {
				oidClienteParam = 
				new String(dtoCabeceraConsulta.getOidCliente().toString());
			}
			else {
				oidClienteParam = new String("");
			}

			if(dtoCabeceraConsulta.getCodigoCliente()!=null) {
				codigoClienteParam = 
				new String(dtoCabeceraConsulta.getCodigoCliente());
			}
			else {
				codigoClienteParam = new String("");
			}

			if(dtoCabeceraConsulta.getNombreApellidos()!=null) {
				nombreApellidosParam = 
				new String(dtoCabeceraConsulta.getNombreApellidos());
			}
			else {
				nombreApellidosParam = new String("");
			}

			if(dtoCabeceraConsulta.getOidConcurso()!=null) {
				oidConcursoParam = 
				new String(dtoCabeceraConsulta.getOidConcurso().toString());
			}
			else {
				oidConcursoParam = new String("");
			}

			if(dtoCabeceraConsulta.getNumeroConcurso()!=null) {
				numeroConcursoParam =
				new String(dtoCabeceraConsulta.getNumeroConcurso());
			}
			else {
				numeroConcursoParam = new String("");			
			}

			String unidades = cargaUnidadesAdminCliente(oidClienteParam);			
			traza("********** unidades " + unidades);

			traza("LPConsultaGeneralConcurso.cargaClienteConcurso - Salida");

			asignarAtributo("VAR", "ejecutar", "valor", 
				"finalizaCargaClienteConcurso('" 
				+ oidClienteParam + "','" 
				+ codigoClienteParam + "','" 
				+ nombreApellidosParam + "','"
				+ oidConcursoParam + "','" 
				+ unidades + "','" 
				+ oidDefault + "','" 
				+ numeroConcursoParam + "');");   
		}
		catch(Exception e) {
			asignarAtributo("VAR", "ejecutarError", "valor", 
			"errorFinalizaCargaClienteConcurso()");          
			throw e;
		} 
	}

	private String cargaUnidadesAdminCliente(String oidClienteParam) throws Exception {
		traza("LPConsultaGeneralConcurso.cargaUnidadesAdminCliente - Entrada");
		traza("***** oidClienteParam " + oidClienteParam);	
		
		DTOUnidadAdministrativa dtoe = new DTOUnidadAdministrativa();
		dtoe.setOidCliente(Long.valueOf(oidClienteParam));		
		
		MareBusinessID businessID = 
		new MareBusinessID("ZONRecargaUnidadesAdministrativasCliente");

		Vector parametros = new Vector();           
		parametros.add(dtoe);
		parametros.add(businessID);

		traza("******************* Antes de conectar");
		DruidaConector con = 
		conectar("ConectorUnidadesAdministrativasCliente", parametros);
		traza("******************* Despues de conectar");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");    
		traza("***** dtoSalida " + dtoSalida);

		RecordSet rs = dtoSalida.getResultado();
		traza("***** rs " + rs);

		RecordSet rsFinal = new RecordSet();
		Vector v = null;    
		rsFinal.addColumn("OID");
		rsFinal.addColumn("DESC");		

		for(int i=0; i<rs.getRowCount(); i++) {
			BigDecimal oid = (BigDecimal)rs.getValueAt(i, "OID");
			BigDecimal ind_act = (BigDecimal)rs.getValueAt(i, "IND_ACTI");
			String desc = (String)rs.getValueAt(i, "DESCRIP");

			traza("***** oid " + oid);
			traza("***** ind_act " + ind_act);
			traza("***** desc " + desc);

			if(ind_act!=null) {
				if(ind_act.intValue() == ConstantesINC.IND_ACTIVO.intValue()) {
					oidDefault = oid.toString();	
					traza("***** SETEANDO OID POR DEFECTO");					
				}
			}

			v = new Vector();

			v.add(oid);
			v.add(desc);
			rsFinal.addRow(v);			
		}

		String unidades = transformarRecordSetToString(rsFinal);
		traza("LPConsultaGeneralConcurso.cargaUnidadesAdminCliente - Salida");
		return unidades;		
	}

	private String transformarRecordSetToString(RecordSet rs) throws Exception  {
		String cadena = "";
		
		for(int i=0; i<rs.getRowCount() ;i++){
 			String oidTemp = rs.getValueAt(i,"OID").toString();
			String desTemp = rs.getValueAt(i,"DESC").toString();
			
			if(i==0) {
				cadena = cadena + oidTemp + "," + desTemp;
			}
			else {
				cadena = cadena + "|" +oidTemp + "," + desTemp;
			}					
		}
		
		traza("*************** cadena " + cadena);
		return cadena;
	}

	private void asignaDTOEncabezado() throws Exception {
		traza("LPConsultaGeneralConcurso.asignaDTOEncabezado - Entrada");

		dtoCabecera = getCabecera();
		traza("***** dtoCabecera " + dtoCabecera);

		if(dtoCabecera==null) {
			dtoCabecera = new DTOCabeceraConsultaIntegral();		
		}

		String busquedaCodClien = 
		conectorParametroLimpia("busquedaCodClien", "", true);
		traza("***** busquedaCodClien " + busquedaCodClien);	

		String busquedaOidClien = 
		conectorParametroLimpia("busquedaOidClien", "", true);
		traza("***** busquedaOidClien " + busquedaOidClien);	

		String busquedaNomApe = 
		conectorParametroLimpia("busquedaNomApe", "", true);
		traza("***** busquedaNomApe " + busquedaNomApe);	

		String busquedaNumConcu = 
		conectorParametroLimpia("busquedaNumConcu", "", true);
		traza("***** busquedaNumConcu " + busquedaNumConcu);	
		
		dtoCabecera.setOidConcurso(null);

		if(busquedaCodClien.equals("")) {
			dtoCabecera.setCodigoCliente(null);
		}
		else {
			dtoCabecera.setCodigoCliente(busquedaCodClien);
		}

		if(busquedaOidClien.equals("")) {
			dtoCabecera.setOidCliente(null);
		}
		else {
			dtoCabecera.setOidCliente(Long.valueOf(busquedaOidClien));
		}

		if(busquedaNomApe.equals("")) {
			dtoCabecera.setNombreApellidos(null);
		}
		else {
			dtoCabecera.setNombreApellidos(busquedaNomApe);
		}

		if(busquedaNumConcu.equals("")) {
			dtoCabecera.setNumeroConcurso(null);
		}
		else {
			dtoCabecera.setNumeroConcurso(busquedaNumConcu);
		}

		traza("***** dtoCabecera " + dtoCabecera);
		setCabecera(dtoCabecera);
		traza("LPConsultaGeneralConcurso.asignaDTOEncabezado - Salida");
	}

	public void direccionaPeticionDetalle() throws Exception {
		traza("LPConsultaGeneralConcurso.direccionaPeticionDetalle - Entrada");

		String varBotonPresionado = 
		this.conectorParametroLimpia("varBotonPresionado", "", true);
		traza("********* varBotonPresionado " + varBotonPresionado);

		if(!varBotonPresionado.equals("detalle")) {
			asignaDTOEncabezado();
		}

		if(varBotonPresionado.equals("detalle")) {
			 asignaDTOCabecera();
			 conectorAction("LPConsultaConcursoSeleccionado");
	         conectorActionParametro("accion", "");
		}
		else if(varBotonPresionado.equals("premiosProcesados")) {			 
			 cargarPantallaPremiosProcesados();
		}
		else if(varBotonPresionado.equals("recomendacion")) {
			 conectorAction("LPConsultaIntegralVarios");
	         conectorActionParametro("accion", 
			 "consultarRecomendacionGral");
		}
		else if(varBotonPresionado.equals("premiosSeleccionados")) {
			 conectorAction("LPConsultaIntegralVarios");
	         conectorActionParametro("accion", 
			 "consultarPremiosSeleccionadosGral");
		}
		else if(varBotonPresionado.equals("motivosDescalificacion")) {
			 conectorAction("LPConsultaIntegralVarios");
	         conectorActionParametro("accion", 
			 "consultarMotivosDescalificacionGral");

           // vbongiov -- INC-014 -- 8/10/2008
		} else if(varBotonPresionado.equals("premiosAsociadosNivel")) {			 
			 cargarPantallaPremiosAsociadosNivel();
		}

		traza("LPConsultaGeneralConcurso.direccionaPeticionDetalle - Salida");
	}

	public void asignaDTOCabecera() throws Exception {
		traza("LPConsultaGeneralConcurso.asignaDTOCabecera - Entrada");

		dtoCabecera = getCabecera();
		traza("***** dtoCabecera " + dtoCabecera);

		if(dtoCabecera==null) {
			dtoCabecera = new DTOCabeceraConsultaIntegral();
		}		

	    String oidConcurso = 
		this.conectorParametroLimpia("oidConcurso", "", true);

	    String numeroConcurso = 
		this.conectorParametroLimpia("numeroConcurso", "", true);

	    String nombreConcurso = 
		this.conectorParametroLimpia("nombreConcurso", "", true);

	    String oidPeriodoInicial = 
		this.conectorParametroLimpia("oidPeriodoInicial", "", true);

	    String periodoInicial = 
		this.conectorParametroLimpia("periodoInicial", "", true);

	    String oidPeriodoFinal = 
		this.conectorParametroLimpia("oidPeriodoFinal", "", true);

	    String periodoFinal = 
		this.conectorParametroLimpia("periodoFinal", "", true);

	    String faseCalificacion = 
		this.conectorParametroLimpia("faseCalificacion", "", true);

	    String oidBaseCalculo = 
		this.conectorParametroLimpia("oidBaseCalculo", "", true);

	    String multinivel = 
		this.conectorParametroLimpia("multinivel", "", true);

	    String oidPlantilla = 
		this.conectorParametroLimpia("oidPlantilla", "", true);

		traza("***** oidConcurso " + oidConcurso);
		traza("***** numeroConcurso " + numeroConcurso);
		traza("***** nombreConcurso " + nombreConcurso);
		traza("***** oidPeriodoInicial " + oidPeriodoInicial);
		traza("***** periodoInicial " + periodoInicial);
		traza("***** oidPeriodoFinal " + oidPeriodoFinal);
		traza("***** periodoFinal " + periodoFinal);
		traza("***** faseCalificacion " + faseCalificacion);
		traza("***** oidBaseCalculo " + oidBaseCalculo);
		traza("***** multinivel " + multinivel);
		traza("***** oidPlantilla " + oidPlantilla);

		if(!oidConcurso.equals("")) {
			dtoCabecera.setOidConcurso(Long.valueOf(oidConcurso));
		}

		if(!numeroConcurso.equals("")) {			
			dtoCabecera.setNumeroConcurso(numeroConcurso);
		}
		
		if(!nombreConcurso.equals("")) {
			dtoCabecera.setNombreConcurso(nombreConcurso);
		}
		
		if(!oidPeriodoInicial.equals("")) {
			dtoCabecera.setOidPeriodoInicial(Long.valueOf(oidPeriodoInicial));
		}
		
		if(!periodoInicial.equals("")) {
			dtoCabecera.setPeriodoInicial(periodoInicial);
		}
		
		if(!oidPeriodoFinal.equals("")) {
			dtoCabecera.setOidPeriodoFinal(Long.valueOf(oidPeriodoFinal));
		}
		
		if(!periodoFinal.equals("")) {
			dtoCabecera.setPeriodoFinal(periodoFinal);
		}

		if(faseCalificacion.equals("1")) {
			dtoCabecera.setFaseCalificacion(Boolean.TRUE);
		}
		else { 
			dtoCabecera.setFaseCalificacion(Boolean.FALSE);
		}

		if(!oidBaseCalculo.equals("")) {
			dtoCabecera.setOidBaseCalculo(Long.valueOf(oidBaseCalculo));
		}

		if(multinivel.equals("1")) {
			dtoCabecera.setMultinivel(Boolean.TRUE);
		}
		else { 
			dtoCabecera.setMultinivel(Boolean.FALSE);
		}

		if(!oidPlantilla.equals("")) {
			dtoCabecera.setOidPlantilla(Long.valueOf(oidPlantilla));
		}

		dtoCabecera.setOidIdioma(lIdioma);
		dtoCabecera.setOidPais(lPais);   

		setCabecera(dtoCabecera);
		traza("LPConsultaGeneralConcurso.asignaDTOCabecera - Salida");
	}	  

	public void recuperarValoresUA() throws Exception {
		traza("LPConsultaGeneralConcurso.recuperarValoresUA - Entrada");				
		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		try {
			String oidUA = conectorParametroLimpia("oidUA", "", true);
			traza("******** oidUA " + oidUA);

			DTOOID dto = new DTOOID();
			dto.setOid(Long.valueOf(oidUA));

			MareBusinessID businessID = new MareBusinessID("INCRecuperarValoresUA");

			Vector parametros = new Vector();           
			parametros.add(dto);
			parametros.add(businessID);

			traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorRecuperarValoresUA", parametros);
			traza("******************* Despues de conectar");

			DTOOIDs dtoOids = (DTOOIDs)con.objeto("DTOSalida");    
			traza("***** dtoOids " + dtoOids);

			dtoCabecera = getCabecera();
			traza("***** dtoCabecera " + dtoCabecera);
		
			if(dtoCabecera==null) {
				dtoCabecera = new DTOCabeceraConsultaIntegral();
			}

			Long[] oids = dtoOids.getOids();

			String oidSeccion = "";
			String oidZona = "";
			String oidRegion = "";

			dtoCabecera.setOidSeccion(oids[0]);
			dtoCabecera.setOidZona(oids[1]);
			dtoCabecera.setOidRegion(oids[2]);

			setCabecera(dtoCabecera);       
					  
			if(oids[0]!=null) {				
				oidSeccion = oids[0].toString();     
			}

			if(oids[1]!=null) {
				oidZona = oids[1].toString();           
			}

			if(oids[2]!=null) {
				oidRegion = oids[2].toString();           
			}

			traza("***** oidSeccion " + oidSeccion);
			traza("***** oidZona " + oidZona);
			traza("***** oidRegion " + oidRegion);

			asignarAtributo("VAR", "ejecutar", "valor", 
				"asignarOidsOcultos('" 
				+ oidSeccion + "','" 
				+ oidZona + "','" 
				+ oidRegion + "');");          
		}
		catch(Exception e) {
			asignarAtributo("VAR", "ejecutarError", "valor", 
			"errorAsignarOidsOcultos()");          
			throw e;
		} 

		traza("LPConsultaGeneralConcurso.recuperarValoresUA - Salida");
	}

	// vbongiov -- INC-014 -- 8/10/2008
	public void cargarPantallaPremiosAsociadosNivel() throws Exception {
		traza("LPConsultaGeneralConcurso.cargarPantallaPremiosAsociadosNivel - Entrada");
		pagina("contenido_premios_asociados_nivel");

		dtoCabecera = getCabecera();
		traza("***** dtoCabecera " + dtoCabecera);
	
		if(dtoCabecera==null) {
			dtoCabecera = new DTOCabeceraConsultaIntegral();
		}

		String codigoCliente = dtoCabecera.getCodigoCliente();
		String nombreApellidos = dtoCabecera.getNombreApellidos();
		Long oidCliente = dtoCabecera.getOidCliente();		
		Long oidRegion = dtoCabecera.getOidRegion();
        Long oidZona = dtoCabecera.getOidZona();
        Long oidSeccion = dtoCabecera.getOidSeccion();

		String oidConcurso = conectorParametroLimpia("oidConcurso", "", true);

		Long oidPais = null;		
		if(dtoCabecera.getOidPais()!=null) {
			oidPais = dtoCabecera.getOidPais();
		}
		else {
			oidPais = UtilidadesSession.getPais(this);
		}

		Long oidIdioma = null;
		if(dtoCabecera.getOidIdioma()!=null) {
			oidIdioma = dtoCabecera.getOidIdioma();
		}
		else {
			oidIdioma =  UtilidadesSession.getIdioma(this);
		}
		
		String numeroConcurso = dtoCabecera.getNumeroConcurso();

		traza("***** codigoCliente " + codigoCliente);
		traza("***** nombreApellidos " + nombreApellidos);
		traza("***** oidConcurso " + oidConcurso);
		traza("***** oidCliente " + oidCliente);
		traza("***** oidRegion " + oidRegion);
        traza("***** oidZona " + oidZona);
        traza("***** oidSeccion " + oidSeccion);
		traza("***** oidPais " + oidPais);
		traza("***** oidIdioma " + oidIdioma);
		traza("***** numeroConcurso " + numeroConcurso);

		if(codigoCliente!=null) {
			asignarAtributo("VAR", "codigoCliente", "valor", 
			codigoCliente);          
		}

		if(nombreApellidos!=null) {
			asignarAtributo("VAR", "nombreApellidos", "valor", 
			nombreApellidos);          
		}
		
		if(oidConcurso!=null) {
			asignarAtributo("VAR", "oidConcurso", "valor", 
			oidConcurso.toString());          
		}
		
		if(oidCliente!=null) {
			asignarAtributo("VAR", "oidCliente", "valor", 
			oidCliente.toString());          
		}

		if(oidRegion!=null) {
	        asignarAtributo("VAR", "oidRegion", "valor", 
            oidRegion.toString());           
        }
                  
        if(oidZona!=null) {
			asignarAtributo("VAR", "oidZona", "valor", 
            oidZona.toString());           
        }
                  
        if(oidSeccion!=null) {
			asignarAtributo("VAR", "oidSeccion", "valor", 
            oidSeccion.toString());           
        }
		
		if(oidPais!=null) {
			asignarAtributo("VAR", "oidPais", "valor", 
			oidPais.toString());          
		}
		
		if(oidIdioma!=null) {
			asignarAtributo("VAR", "oidIdioma", "valor", 
			oidIdioma.toString());          
		}
		
		if(numeroConcurso!=null) {
			asignarAtributo("VAR", "numeroConcurso", "valor", 
			numeroConcurso);          
		}

		traza("LPConsultaGeneralConcurso.cargarPantallaPremiosAsociadosNivel - Salida");
	}	 

	public void cargarPantallaPremiosProcesados() throws Exception {
		traza("LPConsultaGeneralConcurso.cargarPantallaPremiosProcesados - Entrada");
		pagina("contenido_premios_procesados_consultar");

		dtoCabecera = getCabecera();
		traza("***** dtoCabecera " + dtoCabecera);
	
		if(dtoCabecera==null) {
			dtoCabecera = new DTOCabeceraConsultaIntegral();
		}

		String codigoCliente = dtoCabecera.getCodigoCliente();
		String nombreApellidos = dtoCabecera.getNombreApellidos();
		Long oidConcurso = dtoCabecera.getOidConcurso();
		Long oidCliente = dtoCabecera.getOidCliente();		
		Long oidRegion = dtoCabecera.getOidRegion();
        Long oidZona = dtoCabecera.getOidZona();
        Long oidSeccion = dtoCabecera.getOidSeccion();

		Long oidPais = null;		
		if(dtoCabecera.getOidPais()!=null) {
			oidPais = dtoCabecera.getOidPais();
		}
		else {
			oidPais = UtilidadesSession.getPais(this);
		}

		Long oidIdioma = null;
		if(dtoCabecera.getOidIdioma()!=null) {
			oidIdioma = dtoCabecera.getOidIdioma();
		}
		else {
			oidIdioma =  UtilidadesSession.getIdioma(this);
		}
		
		String numeroConcurso = dtoCabecera.getNumeroConcurso();

		traza("***** codigoCliente " + codigoCliente);
		traza("***** nombreApellidos " + nombreApellidos);
		traza("***** oidConcurso " + oidConcurso);
		traza("***** oidCliente " + oidCliente);
		traza("***** oidRegion " + oidRegion);
        traza("***** oidZona " + oidZona);
        traza("***** oidSeccion " + oidSeccion);
		traza("***** oidPais " + oidPais);
		traza("***** oidIdioma " + oidIdioma);
		traza("***** numeroConcurso " + numeroConcurso);

		if(codigoCliente!=null) {
			asignarAtributo("VAR", "codigoCliente", "valor", 
			codigoCliente);          
		}

		if(nombreApellidos!=null) {
			asignarAtributo("VAR", "nombreApellidos", "valor", 
			nombreApellidos);          
		}
		
		if(oidConcurso!=null) {
			asignarAtributo("VAR", "oidConcurso", "valor", 
			oidConcurso.toString());          
		}
		
		if(oidCliente!=null) {
			asignarAtributo("VAR", "oidCliente", "valor", 
			oidCliente.toString());          
		}

		if(oidRegion!=null) {
	        asignarAtributo("VAR", "oidRegion", "valor", 
            oidRegion.toString());           
        }
                  
        if(oidZona!=null) {
			asignarAtributo("VAR", "oidZona", "valor", 
            oidZona.toString());           
        }
                  
        if(oidSeccion!=null) {
			asignarAtributo("VAR", "oidSeccion", "valor", 
            oidSeccion.toString());           
        }
		
		if(oidPais!=null) {
			asignarAtributo("VAR", "oidPais", "valor", 
			oidPais.toString());          
		}
		
		if(oidIdioma!=null) {
			asignarAtributo("VAR", "oidIdioma", "valor", 
			oidIdioma.toString());          
		}
		
		if(numeroConcurso!=null) {
			asignarAtributo("VAR", "numeroConcurso", "valor", 
			numeroConcurso);          
		}

		traza("LPConsultaGeneralConcurso.cargarPantallaPremiosProcesados - Salida");
	}	 
}