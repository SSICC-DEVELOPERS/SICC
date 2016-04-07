import es.indra.sicc.logicanegocio.zon.ConstantesZON;
import es.indra.sicc.dtos.zon.DTOResponsable;
import es.indra.sicc.dtos.zon.DTOBuscarUA;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.ped.DTOCargaInicialMonitor;

import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Collection;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import java.lang.reflect.InvocationTargetException;
import es.indra.mare.common.exception.MareException;

public class LPAsignarResponsable extends LPSICCBase {

	public LPAsignarResponsable() {
		super();
	}

	public void inicio() throws Exception {
	}   

	public void ejecucion() throws Exception {
		this.rastreo();
		this.setTrazaFichero();
		traza("*** Entrada - LPAsignarResponsable - ejecucion ***");

		try {
     	String accion = conectorParametroLimpia("accion", "", true);
			if (accion.equals("")) {
				 this.cargarPantalla();
				 getConfiguracionMenu("LPAsignarResponsable", accion);
			} else if (accion.equals("Asignar")) {
				 this.asignar();
			} else if (accion.equals("continuarAsignar")) {
				 this.continuoAsignar();
			} else if (accion.equals("Detalle")) {
        this.modificarDetalle(); 
      }
	  /*
	   * BELC300022921 - dmorello, 28/03/2006
	   * Dado que se elimina el método validarCliente(), se elimina este ELSE
	   */
	  /*
	  else if (accion.equals("validarCliente") ) {
        this.validarCliente();
      }
	  */
      
      // Agregado por ssantana, 
      
		} catch(Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		traza("*** Salida - LPAsignarResponsable - ejecucion ***");
    
	}


	public void cargarPantalla() throws Exception {
		traza("*** Entrada - LPAsignarResponsable - cargarPantalla ***");
		pagina("contenido_responsables_unidades_asignar");

		this.cargarCombos();
		asignar("VAR", "cteSubgerencia", ConstantesZON.IND_SUBGERENCIA.toString());
		asignar("VAR", "cteRegion", ConstantesZON.IND_REGION.toString());
		asignar("VAR", "cteZona", ConstantesZON.IND_ZONA.toString());
		asignar("VAR", "cteSeccion", ConstantesZON.IND_SECCION.toString());
		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
		asignarAtributo("CTEXTO", "txtCodClienteResponsable", "max", longitudCodigoCliente.toString());

		DTOBuscarUA dto = new DTOBuscarUA();
		traza("*** 1 ***");
		dto.setIndicadorSituacion(new Long(0));
		traza("*** 2 ***");
		dto.setTamanioPagina(new Integer(0));
		traza("*** 3 ***");
		dto.setOidMarca(new Long(0));
		traza("*** 4 ***");
		dto.setOidCanal(new Long(0));
		traza("*** 5 ***");
		dto.setIndUA(new Integer(0));
        
		cargaPeriodoProceso();
		
		traza("*** Salida - LPAsignarResponsable - cargarPantalla ***");
	}
	
	// sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
	private void cargaPeriodoProceso() throws Exception {
		traza("Inicio cargaPeriodoProceso");
	    DTOBelcorp dtoBel = new DTOBelcorp();
	    dtoBel.setOidPais(UtilidadesSession.getPais(this));
	    dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

	    MareBusinessID bizId = new MareBusinessID("PEDCargaInicialMonitor");

	    Vector params = new Vector();
	    params.addElement( dtoBel );
	    params.addElement( bizId );

	    traza( "Antes conector: " + dtoBel);
	    DruidaConector dc  =	conectar( "ConectorCargaInicialMonitor" , params );
	    traza( "dc ");

	    DTOCargaInicialMonitor dtoS = (DTOCargaInicialMonitor) dc.objeto("dtoSalida");
	    
	    if(dtoS.getCodigoPeriodo()!=null)
	    	asignarAtributo( "VAR", "hCodigoPeriodo", "valor", dtoS.getCodigoPeriodo());
	    if(dtoS.getOidPeriodo()!=null)
	    	asignarAtributo( "VAR", "hOidPeriodo", "valor", dtoS.getOidPeriodo().toString());
	    if(dtoS.getFechaProceso()!=null) {      
	    	String formato = UtilidadesSession.getFormatoFecha(this);
	    	traza("Formato fecha: "+formato);
		    int pos = formato.indexOf("mm");
		    if ( pos > -1) 
		        formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
		    SimpleDateFormat sdf = new SimpleDateFormat(formato);
		      
	    	asignarAtributo( "VAR", "hFechaProceso", "valor", sdf.format(dtoS.getFechaProceso()));
	    }
	}	

	  
 private void cargarCombos() throws Exception {
    traza("*** Entrada -  LPAsignarResponsable- cargarCombos ***");

    ComposerViewElementList listelem = new ComposerViewElementList();
    ComposerViewElement elem = null;

		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);

		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());

    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    dtoBelcorp.setOidPais(pais);
    dtoBelcorp.setOidIdioma(idioma);

    elem = new ComposerViewElement(); 
    elem.setIDBusiness("SEGConsultaMarcas");
    elem.setDTOE(dtoBelcorp);
    listelem.addViewElement(elem);
    /*elem.posOID=1; 
    elem.posDesc = 3; */

    elem = new ComposerViewElement(); 
    elem.setIDBusiness("SEGConsultaCanales");
    elem.setDTOE(dtoBelcorp);
    listelem.addViewElement(elem);
    /*elem.posOID=1; 
    elem.posDesc = 3; */
        
    // Llamamos al subsistema GestorCargaPantalla. 
    ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
    conector.ejecucion();
    DruidaConector conConsulta = conector.getConector();
            
    asignar("COMBO", "cbMarca", conConsulta, "SEGConsultaMarcas");
    asignar("COMBO", "cbCanal", conConsulta, "SEGConsultaCanales");

    traza("*** Salida -  LPAsignarResponsable- cargarCombos ***");
 }


 public void asignar() throws Exception {
		traza("*** Entrada - LPAsignarResponsable - asignar ***");
		this.pagina("salidaGenerica");
    //asignar("VAR", "ejecutar", "retornoAsignar()");
    this.asignarAtributo("VAR", "ejecutar", "valor", "retornoAsignar()");
    this.asignarAtributo("VAR", "ejecutarError", "valor", "retornoError()");
        
    //añadido por incidencia 20289
    Long marca =  new Long (conectorParametroLimpia("hMarca", "", true));
    Long canal = new Long(conectorParametroLimpia("hCanal", "", true));
    //fin añadido
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);
    String oidUA = conectorParametroLimpia("oidUA", "", true);
		traza("*** oidUA ***: " + oidUA);
        
    String codigoResponsable = 
          this.conectorParametroLimpia("txtCodClienteResponsable", "", true);
    String sOidCliente = 
          this.conectorParametroLimpia("hidOidClienteBusquedaRapida", "", true);
    String indUA = conectorParametroLimpia("indUA", "", true);


	traza("codigoResponsable: " + codigoResponsable);
	traza("sOidCliente: " + sOidCliente);
	traza("indUA: " + indUA);
    
    /*Incidencia 22532 pzerbino 08/03/2006 */
    
    String codUat = this.conectorParametroLimpia("hcoddUA","",true);
    
		DTOResponsable dtoin = new DTOResponsable();
		dtoin.setOidPais(pais);
		dtoin.setOidIdioma(idioma);
		dtoin.setOidUA(Long.valueOf(oidUA));
    dtoin.setCodigoResponsable((codigoResponsable.length() > 0)? codigoResponsable : null);
		dtoin.setIndUA(Integer.valueOf(indUA));
    
    dtoin.setCodigoUA(codUat);

    String subgRegZonSecc = conectorParametroLimpia("subgRegZonSecc", "", true);
	traza("subgRegZonSecc: " + subgRegZonSecc);
    //zon-5
	dtoin.setSubgerRegZonSecc(Long.valueOf(subgRegZonSecc));
	/*
	 * BELC300022921 - dmorello, 30/03/2006
	 * El OID de responsable viene vacío si no se pasó por la búsqueda rápida; se verificará...
	 */
	dtoin.setOidResponsable((sOidCliente != null && sOidCliente.length() > 0)? Long.valueOf(sOidCliente) : null);
		//añadido por incidencia 20289
		dtoin.setOidMarca(marca);
		dtoin.setOidCanal(canal);
		// fin añadido

		// sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
		String periodo = conectorParametroLimpia( "hOidPeriodo", "", true );
        dtoin.setOidPeriodo(Long.valueOf(periodo));

        String fechaProceso = conectorParametroLimpia( "hFechaProceso", "", true );
        String formato = UtilidadesSession.getFormatoFecha(this);
        int pos = formato.indexOf("mm");
        if ( pos > -1) 
            formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        dtoin.setFechaProceso(new java.sql.Date(sdf.parse(fechaProceso).getTime()));
		
		traza ("\n***DTOResponsable: "+dtoin);
		//Se crea el idbusiness "ZONAsignarResponsable" 
		MareBusinessID idBussiness = new MareBusinessID("ZONAsignarResponsable");
		
		// Se almacenan los parametros de entrada
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoin);
		paramEntrada.addElement(idBussiness);
		
		try {
  		    //Se ejecuta el conector "ConectorAsignarResponsable"" 
		    traza("*** invocamos conector ***");
		    DruidaConector conector = conectar("ConectorAsignarResponsable", paramEntrada);
		    traza("*** Salida - LPAsignarResponsable - asignar ***");
        } catch (Exception e) {
		    if(e instanceof InvocationTargetException) {
                if (((InvocationTargetException) e).getTargetException() instanceof MareException) {
                      MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();

                      traza("la mare-exc. que me retorna, tiene el codigo : " + mareException.getCode());	                 

                      if (mareException.getCode() == 240605) {  
						  //Número de Periodos de Diferencia no es >= al Número Mínimo de Campañas se mostrará el mensaje 
						  //"Responsable no cumple campañas para reingreso. ¿Desea continuar?
						  //Si la respuesta es Sí, se continúa con la siguiente actividad (actividad 10); caso contrario 
						  //se retorna a la actividad 5 del flujo normal para que el usuario tenga la posibilidad de ingresar 
						  //otro código de cliente.
						  this.asignarAtributo("VAR", "ejecutar", "valor", "deseaContinuar()");
					  }	else {
			 		      logStackTrace(e);
				  		  lanzarPaginaError(e);
					  }
				}
			}
		}
    }


 public void continuoAsignar() throws Exception {
		traza("*** Entrada - LPAsignarResponsable - continuoAsignar ***");
		this.pagina("salidaGenerica");
	    this.asignarAtributo("VAR", "ejecutar", "valor", "retornoAsignar()");
	    this.asignarAtributo("VAR", "ejecutarError", "valor", "retornoError()");
        
	    Long marca =  new Long (conectorParametroLimpia("hMarca", "", true));
		Long canal = new Long(conectorParametroLimpia("hCanal", "", true));
		Long pais = UtilidadesSession.getPais(this); 
		Long idioma = UtilidadesSession.getIdioma(this);
	    String oidUA = conectorParametroLimpia("oidUA", "", true);
		traza("*** oidUA ***: " + oidUA);
        
	    String codigoResponsable = 
          this.conectorParametroLimpia("txtCodClienteResponsable", "", true);
		String sOidCliente = 
          this.conectorParametroLimpia("hidOidClienteBusquedaRapida", "", true);
	    String indUA = conectorParametroLimpia("indUA", "", true);

		traza("codigoResponsable: " + codigoResponsable);
		traza("sOidCliente: " + sOidCliente);
		traza("indUA: " + indUA);
		traza("subgRegZonSecc: " + conectorParametroLimpia("subgRegZonSecc", "", true));
    
	    String codUat = this.conectorParametroLimpia("hcoddUA","",true);
    
		DTOResponsable dtoin = new DTOResponsable();
		dtoin.setOidPais(pais);
		dtoin.setOidIdioma(idioma);
		dtoin.setOidUA(Long.valueOf(oidUA));
	    dtoin.setCodigoResponsable((codigoResponsable.length() > 0)? codigoResponsable : null);
		dtoin.setIndUA(Integer.valueOf(indUA));

		//zon-5
	    String subgRegZonSecc = conectorParametroLimpia("subgRegZonSecc", "", true);
		traza("subgRegZonSecc: " + subgRegZonSecc);
		dtoin.setSubgerRegZonSecc(Long.valueOf(subgRegZonSecc));

		dtoin.setCodigoUA(codUat);
    
		dtoin.setOidResponsable((sOidCliente != null && sOidCliente.length() > 0)? Long.valueOf(sOidCliente) : null);
	
		dtoin.setOidMarca(marca);
		dtoin.setOidCanal(canal);
	
		traza ("\n***DTOResponsable: "+dtoin);
	
		MareBusinessID idBussiness = new MareBusinessID("ZONContinuarAsignarResponsable");
		
	
		Vector paramEntrada = new Vector();
		paramEntrada.addElement(dtoin);
		paramEntrada.addElement(idBussiness);
		
	
	    traza("*** invocamos conector ***");
	    DruidaConector conector = conectar("ConectorContinuarAsignarResponsable", paramEntrada);
	    traza("*** Salida - LPAsignarResponsable - continuoAsignar ***");
    }

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	}
  
  
  /**
   * @author: ssantana, 30/11/2005, SICC-GCC-ZON-003
   * @throws java.lang.Exception
   */
  private void modificarDetalle() throws Exception {
  
    String sOidCliente = 
              this.conectorParametroLimpia("oidResponsableLista", "", true);
    this.pagina("contenido_responsables_unidades_asignar_detalle");
    this.getConfiguracionMenu("LPAsignarResponsable", "modificarDetalle");
    traza("LPAsignarResponsable.modificarDetalle()");
    traza("sOidCliente: " + sOidCliente);
    
    DTOOID dtoOid = new DTOOID(); 
    dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
    dtoOid.setOidPais(UtilidadesSession.getPais(this));
    dtoOid.setOid(Long.valueOf(sOidCliente));
    
    Vector vParams = new Vector(); 
    MareBusinessID bussID = new MareBusinessID("ZONObtenerDetalleResponsable");
    
    vParams.add(dtoOid);
    vParams.add(bussID);
    
    DruidaConector con = this.conectar("ConectorObtenerDetalleResponsable", 
                                       vParams);
    DTOSalida dtoSal = (DTOSalida) con.objeto("DTOSalida");
    traza("dtoS: " + dtoSal);
    RecordSet r = dtoSal.getResultado();
    if (!r.esVacio()) {
      String sTipoCliente = (String) r.getValueAt(0, 0);    
      String sSubtipoCliente = (String) r.getValueAt(0, 1);
      String sClasificacion = (String) r.getValueAt(0, 2);      
      String sTipoClasificacion = (String) r.getValueAt(0, 3);

      if (sTipoCliente != null ) {
         this.asignarAtributo("LABELC", "lbldtTipoCliente", "valor", sTipoCliente);
      }
      
      if (sSubtipoCliente != null) {
         this.asignarAtributo("LABELC", "lbldtSubtipoCliente", "valor", sSubtipoCliente);
      }
      
      if (sClasificacion != null) {
         this.asignarAtributo("LABELC", "lbldtClasificacion", "valor", sClasificacion);
      }
      
      if (sTipoClasificacion != null) {
         this.asignarAtributo("LABELC", "lbldtTipoClasificacion", "valor", sTipoClasificacion);
      }      
    }
  }
  
  
  /*
   * BELC300022921 - dmorello, 28/03/2006
   * SE ELIMINA ESTE MÉTODO
   */
  /**
   * @author: ssantana, 30/11/2005, SICC-GCC-ZON-003
   * @throws java.lang.Exception
   */
  /*
  private void validarCliente() throws Exception {
     traza("LPAsignarResponsable.validarCliente()");
     Vector parametros = new Vector();
     String sCodigoCliente = this.conectorParametroLimpia("hidCodClienteTemp", 
                                                          "", 
                                                          true);
     this.pagina("salidaGenerica");
     this.asignarAtributo("VAR", 
                          "ejecutarError", 
                          "valor", 
                          "errorClienteBusqueda()");
     
     MareBusinessID bussId = new MareBusinessID("MAEBusquedaRapidaCliente");
     DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
     
     dto.setIndicadorSituacion(new Integer(0));
     dto.setTamanioPagina(new Integer(1));
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     
     traza("Código de cliente capturado: " + sCodigoCliente);
     dto.setCodigoCliente(sCodigoCliente);		
     // Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
     
     parametros.add(dto);
     parametros.add(bussId);
     traza("Conectando a ConectorBusquedaRapidaCliente... ");
     DruidaConector conector = this.conectar("ConectorBusquedaRapidaCliente", 
                                             parametros);
     traza("Ya termino...");
     DTOSalida dtoRetornado = (DTOSalida) conector.objeto("DTOSalida");
     RecordSet retorno = dtoRetornado.getResultado();
     
     String oidCliente = ((BigDecimal) retorno.getValueAt(0, "OID")).toString();
     traza(" - OID: " + oidCliente);
     this.asignarAtributo("VAR", 
                          "ejecutar", 
                          "valor", 
                          "validoCliente('" + oidCliente +"')");
  }
  */
}