import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOProducto;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.StringBufferInputStream;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.Date;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.dtos.inc.DTONuevaVersion;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
//quitar este import luego de probar la activacion de concursos
import es.indra.mare.common.dto.MareDTO;

public class LPMantenimientoVersiones extends LPSICCBase {	
    private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;
    private String opcionMenu = null;
    private String oid = null;
	private String oidConcursoOrigen = null;
	private int version;
	private String numeroConcurso = null;
    private String oidConcurso = null;
	private String oidEstado = null;
	private String oidPeriodoDesde = null;
	private String fechaInicio = null;
	private String fechaFin = null;
	private String oidRequisitoPremiacion = null;
	private String periodoFin = null;
	private String periodPuestaMarcha = null;
	private String indPagoTiempo = null;
	private String diasGracia = null;
	private String periodoDesde = null;
	private String periodoHasta = null;
	//Agregado por cvalenzu - 10/5/2006 - versionado
	private String oidEstadoConcurso = null;
	private String maxVersion = null;
	private int maximaVersion;
	//FIN - Agregado por cvalenzu - 10/5/2006 - versionado

	public LPMantenimientoVersiones() { super(); }

    public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {        
	    setTrazaFichero();

		try	{ 
			this.rastreo();
		    traza("LPMantenimientoVersiones.ejecucion() - Entrada"); 

		    accion = conectorParametroLimpia("accion", "", true);   			
		    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);            
			lIdioma = UtilidadesSession.getIdioma(this);
		    lPais = UtilidadesSession.getPais(this);     
	        oid = conectorParametroLimpia("oid", "", true);
			numeroConcurso = conectorParametroLimpia("numeroConcurso", "", true);
	        fechaInicio = conectorParametroLimpia("fechaInicio", "", true);
		    fechaFin = conectorParametroLimpia("fechaFin", "", true);
		    oidConcursoOrigen = conectorParametroLimpia("oidConcursoOrigen", "", true);
	        oidPeriodoDesde = conectorParametroLimpia("oidPeriodoDesde", "", true);
		    String vers = conectorParametroLimpia("_version", "", true);
			oidConcurso = conectorParametroLimpia("oidConcurso", "", true);	
			//Agregado por cvalenzu - 10/5/2006 - versionado
			oidEstadoConcurso = conectorParametroLimpia("oidEstadoConcurso", "", true);
	        maxVersion = conectorParametroLimpia("maxVersion", "0", true);
			traza("*********** maxVersion " + maxVersion);
			if(maxVersion!=null && maxVersion.length()>0) {
			    maximaVersion = (new Integer(maxVersion)).intValue();
			}
			//FIN - Agregado por cvalenzu - 10/5/2006 - versionado	        
        
		    if (vers != null && vers.length() > 0) {            
			    version = (new Integer(vers)).intValue();
	        }
			else {
		        version = 1;
			}
	
			traza("************ accion:" + accion); 
			traza("************ opcionMenu:" + opcionMenu); 
		    traza("************ oid:" + oid);
			traza("************ oidConcursoOrigen:" + oidConcursoOrigen);
	        traza("************ oidConcurso:" + oidConcurso);
			traza("************ version: " + version);
	        traza("************ oidEstadoConcurso:" + oidEstadoConcurso);
			traza("************ maximaVersion: " + maximaVersion);

		    if ("".equals(accion)) {			    
				 pagina("contenido_versiones_concurso_mantener");
				 asignarAtributo("VAR", "oidPais", "valor", 
					 lPais.toString());
				 asignarAtributo("VAR", "oidIdioma", "valor", 
					 lIdioma.toString());
				 asignarAtributo("VAR", "cteEstadoAutorizado", "valor", 
					 ConstantesINC.OID_ESTADO_AUTORIZADO.toString());
				 asignarAtributo("VAR", "cteEstadoModificacion", "valor", 
					 ConstantesINC.OID_ESTADO_MODIFICACION.toString());
				 asignarAtributo("VAR", "cteEstadoRechazadaAutorizacion", "valor", 
					 ConstantesINC.OID_ESTADO_RECHAZADA_AUTORIZACION.toString());
				 asignarAtributo("VAR", "cteEstadoRechazadaAprobacion", "valor", 
					 ConstantesINC.OID_ESTADO_RECHAZADA_APROBACION.toString());
		    }
			else if ("generar".equals(accion)) {
				String oidConc = cargarPGGenerarNuevaVersion();
				if (oidConc != null) {
					inicializar(oidConc);
				}                
		    }
			else if ("autorizacion".equals(accion)) {
                solicitarAutorizacion();
		    }
			else if ("modificar".equals(accion)) {
                modificarConcurso();
		    }
			else if ("puesta marcha".equals(accion)) {
                solicitarAprobacionPuestaMarcha();
		    }
			else if ("actualizar solicitud rechazada".equals(accion)) {
                actualizarSolicitudRechazada();
		    }
			else if ("borrar modificacion rechazada".equals(accion) 
                       || "borrar modificacion".equals(accion)) {
                borrarModificacion();
		    }
			else if (accion.equals("validar modificacion cambios")) {
	            this.validarModificacionCambios();
			}
		}
		catch ( Exception e )	{ 
		    traza("Exception en LPMantenimientoVersiones");
		    ByteArrayOutputStream pila = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(pila);
		    e.printStackTrace(out);
		    traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace();
		    e.getMessage();
		    lanzarPaginaError(e);
	    }
		
		if(accion.equals("")) {
			getConfiguracionMenu("LPMantenimientoVersiones", "");      
		}
		else {
			getConfiguracionMenu("LPMantenimientoVersiones", "modificar");      
		}        

	    traza("LPMantenimientoVersiones.ejecucion() - Salida"); 
	}
    
	public void cargarPGVersionesConcurso() throws Exception {
		traza("LPMantenimientoVersiones.cargarPGVersionesConcurso() - Entrada");
		pagina("contenido_versiones_concurso_mantener");		
		asignarAtributo("VAR", "oidPais", "valor", lPais.toString());
 		asignarAtributo("VAR", "oidIdioma", "valor", lIdioma.toString());
		asignarAtributo("VAR", "cteEstadoAutorizado", "valor",         
		ConstantesINC.OID_ESTADO_AUTORIZADO.toString());
		asignarAtributo("VAR", "cteEstadoModificacion", "valor",         
		ConstantesINC.OID_ESTADO_MODIFICACION.toString());
		asignarAtributo("VAR", "cteEstadoRechazadaAutorizacion", "valor", 
        ConstantesINC.OID_ESTADO_RECHAZADA_AUTORIZACION.toString());		
		asignarAtributo("VAR", "cteEstadoRechazadaAprobacion", "valor", 
        ConstantesINC.OID_ESTADO_RECHAZADA_APROBACION.toString());		
		traza("LPMantenimientoVersiones.cargarPGVersionesConcurso() - Salida");
	}


    public String cargarPGGenerarNuevaVersion() throws Exception {    
		traza("LPMantenimientoVersiones.cargarPGGenerarNuevaVersion() - Entrada");
        DTONuevaVersion dtoNuevaVersion = crearConcursoNuevaVersion();        
        traza("************ DTONuevaVersion creado en cargarPGGenerarNuevaVersion:  " + dtoNuevaVersion);

        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        dtoPeriodo.setPais(dtoNuevaVersion.getOidPais());
        dtoPeriodo.setMarca(dtoNuevaVersion.getOidMarca());
        dtoPeriodo.setCanal(dtoNuevaVersion.getOidCanal());
   		dtoPeriodo.setStatus((ConstantesINC.IND_ACTIVO.
        equals(new Integer(1))) ? Boolean.TRUE : Boolean.FALSE);
		traza("**************** dtoPeriodo " + dtoPeriodo);
        
		pagina("contenido_nueva_version_generar");

        DTOPeriodo dtoMayorDesde = new DTOPeriodo();
        dtoMayorDesde.setPais(dtoNuevaVersion.getOidPais());
        dtoMayorDesde.setMarca(dtoNuevaVersion.getOidMarca());
        dtoMayorDesde.setCanal(dtoNuevaVersion.getOidCanal());
   		dtoMayorDesde.setOid(dtoNuevaVersion.getOidPeriodoDesde());
		traza("**************** dtoMayorDesde " + dtoMayorDesde);

        ComposerViewElementList list = new ComposerViewElementList();
        
		//0 Periodo fin --------------------------------------------
		ComposerViewElement cve = new ComposerViewElement();
        cve.setIDBusiness("CRAObtenerPeriodosPosterioresActivos");
        cve.setDTOE(dtoMayorDesde);
		//0 Periodo fin --------------------------------------------

        list.addViewElement(cve);

		//1 Periodo puesta en marcha -------------------------------
		ComposerViewElement cve1 = new ComposerViewElement();
        cve1.setIDBusiness("CRAObtenerPeriodosPosterioresActual");		
        cve1.setDTOE(dtoPeriodo);
		//1 Periodo puesta en marcha -------------------------------

        list.addViewElement(cve1);

		//2 Periodo desde -------------------------------------------
		ComposerViewElement cve2 = new ComposerViewElement();
        cve2.setIDBusiness("CRAObtenerPeriodosPosterioresActual");		
        cve2.setDTOE(dtoPeriodo);
		//2 Periodo desde -------------------------------------------

        list.addViewElement(cve2);

        ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();

		traza("*********** asignando combos");

        asignar("COMBO", "cbPeriodoFin", con, "CRAObtenerPeriodosPosterioresActivos");
		asignar("COMBO", "cbPeriodoPuestaMarcha", con, "CRAObtenerPeriodosPosterioresActual");        
		asignar("COMBO", "cbPeriodoDesde", con, "CRAObtenerPeriodosPosterioresActual");

        // INC 21463
		// No se preguntará si indPagoTiempo==ConstantesINC.IND_ACTIVO, ya que son Boolean e Integer, resp.
		if (dtoNuevaVersion.getIndPagoTiempo() != null && 
            dtoNuevaVersion.getIndPagoTiempo().booleanValue()) {   
           
            asignarAtributo("VAR", "varChkPagoATiempo", "valor", "S");            
            asignarAtributo("CHECKBOX", "ckPagoTiempo", "check", "S");
             
            Integer lnDiasGracia = dtoNuevaVersion.getDiasGracia();
            if (lnDiasGracia != null) {
               this.asignar("CTEXTO", "txtDiasGracia", lnDiasGracia.toString());
               this.asignarAtributo("VAR", "diasGracia", "valor", 
               dtoNuevaVersion.getDiasGracia().toString());
            }
            
            // INC 21463
			// En los combos cbPeriodoDesde y cbPeriodoHasta se seleccionarán los valores
			// correspondientes a dtoNuevaVersion.oidPeriodoDesdeReq y dtoNuevaVersion.oidPeriodoHastaReq
			// en lugar de oidPeriodoDesde y oidPeriodoHasta, respectivamente.
            if (dtoNuevaVersion.getOidPeriodoDesdeReq() != null) {
              this.asignarAtributo("VAR", "periodoDesde", "valor", 
                          dtoNuevaVersion.getOidPeriodoDesdeReq().toString());
            }
  
            if (dtoNuevaVersion.getOidPeriodoHastaReq() != null) {
              this.asignarAtributo("VAR", "periodoHasta", "valor", 
                           dtoNuevaVersion.getOidPeriodoHastaReq().toString()); 
            }// Fin correcciones INC 21463			
		}
		else {   
    		asignarAtributo("VAR", "varChkPagoATiempo", "valor", "N");
            asignarAtributo("CHECKBOX", "ckPagoTiempo", "check", "N"); 
		}

	    asignarAtributo("VAR", "oid", "valor", oid);
		asignarAtributo("VAR", "oidConcurso", "valor", 
        dtoNuevaVersion.getOidConcurso().toString());

        if (dtoNuevaVersion.getOidRequisitoPremiacion() != null) {
            asignarAtributo("VAR", "oidRequisitoPremiacion", "valor", 
            dtoNuevaVersion.getOidRequisitoPremiacion().toString());
        }
		
        if (dtoNuevaVersion.getOidPeriodoHasta() != null) {
            asignarAtributo("VAR", "periodoFin", "valor", 
            dtoNuevaVersion.getOidPeriodoHasta().toString());
        }
		
        if (dtoNuevaVersion.getOidPeriodoPuestaMarcha() != null) {
            asignarAtributo("VAR", "periodoPuestaMarcha", "valor", 
            dtoNuevaVersion.getOidPeriodoPuestaMarcha().toString());
        }       

		if(dtoNuevaVersion.getOidPais()!=null) {
            asignarAtributo("VAR", "oidPais", "valor", 
            dtoNuevaVersion.getOidPais().toString());
		}

		if(dtoNuevaVersion.getOidMarca()!=null) {
            asignarAtributo("VAR", "marca", "valor", 
            dtoNuevaVersion.getOidMarca().toString());
		}

		if(dtoNuevaVersion.getOidCanal()!=null) {
            asignarAtributo("VAR", "canal", "valor", 
            dtoNuevaVersion.getOidCanal().toString());
		}

		if(dtoNuevaVersion.getCodPeriodoHasta()!=null) {
            asignarAtributo("VAR", "codPeriodoHasta", "valor", 
            dtoNuevaVersion.getCodPeriodoHasta().toString());
		}

		traza("LPMantenimientoVersiones.cargarPGGenerarNuevaVersion() - Salida");
    
 	    //Habilitar el botón "Guardar" del menú secundario
        return (dtoNuevaVersion.getOidConcurso() != null) ?
                dtoNuevaVersion.getOidConcurso().toString() : "";        
	}
    
	public void actualizarEstadoVersion(DTOVersion dtoe) throws Exception {      
	   traza("LPMantenimientoVersiones.actualizarEstadoVersion() - Entrada");
	   Vector params = new Vector();
       traza(" metod actualizarEstadoVersion ");
       traza("DTOVersion: " + dtoe);
	   params.add(dtoe);
	   params.add(new MareBusinessID("INCActualizarEstadoVersion"));
	   traza("# conectar ->  ConectorActualizarEstadoVersion ");
	   conectar("ConectorActualizarEstadoVersion", params);
	   traza("LPMantenimientoVersiones.actualizarEstadoVersion() - Salida");
	}

	private void loadCmb(String bid, String cmb_name) throws Exception {        
		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);
		cve.setIDBusiness(bid);
		cve.setDTOE(dtoe);
		list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list, 
                                                            this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();
        asignar("COMBO", cmb_name, con, bid);
	}

	private void loadCmb(String bid, String cmb_name, ComposerViewElement cve) 
    throws Exception { 
        
		ComposerViewElementList list = new ComposerViewElementList();
	    cve.setIDBusiness(bid);
		list.addViewElement(cve);
		ConectorComposerView conector = new ConectorComposerView(list, 
                                                             this.getRequest());
        conector.ejecucion();
        DruidaConector con = conector.getConector();
        asignar("COMBO", cmb_name, con, bid);
	}

	//METODO PARA PROBAR ACTIVACION Y CERRADO DE CONCUROS
	/*public void solicitarAutorizacion() throws Exception { 
		traza("LPMantenimientoVersiones.solicitarAutorizacion() - Entrada");
		pagina("salidaGenerica");
	
		MareDTO dtoe = new MareDTO();
		dtoe.setProperty("pais", new Long(1));
		dtoe.setProperty("marca", new Long(1));
		dtoe.setProperty("canal", new Long(1));
			
        Vector params = new Vector();
        params.add(dtoe); 
        //params.add(new MareBusinessID("INCActivarConcursosQuartz"));
		//params.add(new MareBusinessID("INCCerrarConcursosQuartz"));
		traza("************* ANTES DE CONECTAR **");
		//conectar("ConectorActivarConcursos", params);
		//conectar("ConectorCerrarConcursos", params);
		traza("************* DESPUES DE CONECTAR **");

		traza("LPMantenimientoVersiones.solicitarAutorizacion() - Salida");
		asignarAtributo( "VAR", "ejecutar", "valor", "fin()");				
	}*/
    
	public void solicitarAutorizacion() throws Exception { 
		traza("LPMantenimientoVersiones.solicitarAutorizacion() - Entrada");
        pagina("salidaGenerica");
        traza("fechaInicio: " + fechaInicio);
        traza("fechaFin: " + fechaFin);        
		
		if(oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_ACTIVO.toString()) ||
		oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_APROBADO.toString())) {

            Date fechaSistema  = new Date(System.currentTimeMillis());
            Date d_fechaInicio = toDate(fechaInicio);
            Date d_fechaFin = toDate(fechaFin); 

            traza("fechaSistema: " + fechaSistema.toString());
            traza("d_fechaInicio: " + d_fechaInicio.toString());
            traza("d_fechaFin: " + d_fechaFin.toString());            

            if ((fechaSistema.after(d_fechaInicio) || fechaSistema.equals(d_fechaInicio)) && 
                ((d_fechaFin).after(fechaSistema) || (d_fechaFin).equals(fechaSistema))) { 
                
                DTOVersion dtoVersion = new DTOVersion();
                dtoVersion.setNumeroConcurso(numeroConcurso);
                dtoVersion.setVersionNueva(new Integer(version));
                Vector params = new Vector();
                params.add(dtoVersion); 
                params.add(new MareBusinessID("INCObtenerVersionesSuperiores"));
                traza("# conectar ->  ConectorObtenerVersionesSuperiores ");
                DruidaConector con = conectar("ConectorObtenerVersionesSuperiores", params);
                DTOBoolean dtoBoolean = (DTOBoolean)con.objeto("DTOBoolean");
                traza("dtoBoolean.getValor() : " + dtoBoolean.getValor());

                if (dtoBoolean.getValor()) { 
                    // Mostrar mensaje INC-0005: No se puede solicitar autorización 
                    // para modificar un concurso que tiene modificaciones en vigor 
                    throw new MareException(new Exception(), 130005);                    
                }
				else {  
                    DTOVersion dtoVersion2 = new DTOVersion();

					traza("oidConcursoOrigen: " + oidConcursoOrigen);                    
					if (oidConcursoOrigen != null && oidConcursoOrigen.length() > 0) {
                        dtoVersion2.setOidConcursoOrigen(Long.valueOf(oidConcursoOrigen));
                    }
                    
					traza("maximaVersion: " + maximaVersion);
					dtoVersion2.setVersionNueva(new Integer(maximaVersion + 1));                    
					
					traza("numeroConcurso: " + numeroConcurso);
                    if (numeroConcurso != null && numeroConcurso.length() > 0) {
                        dtoVersion2.setNumeroConcurso(numeroConcurso);
                    }

                    traza("ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION" +
                    ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION);
                    dtoVersion2.setOidEstado(ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION);

                    traza("oidPeriodoDesde: " + oidPeriodoDesde);

                    if (oidPeriodoDesde != null && oidPeriodoDesde.length() > 0) {
                        dtoVersion2.setOidPeriodoInicioVigor(Long.valueOf(oidPeriodoDesde));
                    }

                    Vector params2 = new Vector();
                    params2.add(dtoVersion2); 
                    params2.add(new MareBusinessID("INCInsertarVersion"));
                    traza("# conectar ->  ConectorInsertarVersion ");
                    DruidaConector con2 = conectar("ConectorInsertarVersion", params2);

                    // Asignamos funcion a ejecutar luego de solicitar autorizacion
					asignarAtributo("VAR", "oidPais", "valor", lPais.toString());
					asignarAtributo("VAR", "oidIdioma", "valor", lIdioma.toString());
					asignarAtributo( "VAR", "ejecutar", "valor", "vueltaSolicitarAutorizacion()");				
				}
            }
			else { //muestra mensaje INC-0004: El concurso no está en vigor
                throw new MareException(new Exception(), 130004);
            }
        }
		else {
            throw new MareException(new Exception(), 130004);
        } 
		traza("LPMantenimientoVersiones.solicitarAutorizacion() - Salida");
	}
    
  public void modificarConcurso() throws Exception {         
    traza("LPMantenimientoVersiones.modificarConcurso() - Entrada");
    this.pagina("salidaGenerica");
    traza(" metod modificarConcurso SSSSSS");
    DTOVersion dtoVersion = new DTOVersion();
    traza(" oid para DTOVersion  1 : " + oid);
    if (oid != null) {
       dtoVersion.setOid(Long.valueOf(oid));
    }		
    dtoVersion.setOidEstado(ConstantesINC.OID_ESTADO_MODIFICACION);
    traza("dtoVersion: " + dtoVersion);

    String dnv = conectorParametroLimpia("datosNuevaVersion", "", true);
    traza("dnv: " + dnv); 
    if (dnv != null && dnv.length() > 0) {	            
       actualizarNuevaVersion(getElem(dnv));
       traza(" oid para DTOVersion  1 : " + oid);
       traza(" DTOVersion  para actualizar estado : " + dtoVersion);
       actualizarEstadoVersion(dtoVersion);
    }
    traza("LPMantenimientoVersiones.modificarConcurso() - Salida");
	asignarAtributo("VAR", "ejecutar", "valor", "onLoadPag()");	
	}

	private Element getElem(String arg)	
    throws javax.xml.parsers.ParserConfigurationException, 
           org.xml.sax.SAXException, 
           java.io.IOException, Exception {       

        return javax.xml.parsers.DocumentBuilderFactory.newInstance().
               newDocumentBuilder().
               parse(new java.io.StringBufferInputStream(arg)).
                                                          getDocumentElement();
	}

	private String getValElem(Element elem, String fld) throws Exception {  
	    org.w3c.dom.Node child = elem.getFirstChild();
        int i = 0;
	    while (child != null) { 
		    if (child instanceof Element) { 
		        Element el = (Element)child;
		        if (el.getAttribute(fld) != null) 
		            return el.getAttribute(fld); 
		    }             
		    child = child.getNextSibling();
	    } 
        return null;
	}

	public void solicitarAprobacionPuestaMarcha() throws Exception {   
	    traza("LPMantenimientoVersiones.solicitarAprobacionPuestaMarcha() - Entrada");
		pagina("salidaGenerica");
		DTOVersion dtoVersion = new DTOVersion();
		dtoVersion.setOid(new Long(oid));
		dtoVersion.setOidEstado(ConstantesINC.OID_ESTADO_SOLICITADA_APROBACION);
		actualizarEstadoVersion(dtoVersion);
	    traza("LPMantenimientoVersiones.solicitarAprobacionPuestaMarcha() - Salida");
		asignarAtributo("VAR", "ejecutar", "valor", "vueltaSolicitarAutorizacion()");
	}    
	
	public void actualizarSolicitudRechazada() throws Exception	{
	    traza("LPMantenimientoVersiones.actualizarSolicitudRechazada() - Entrada");
		pagina("salidaGenerica");
		DTOOID dtoe = new DTOOID();
		dtoe.setOid(Long.valueOf(oid));
		Vector params = new Vector();
	    params.add(dtoe);
	    params.add(new MareBusinessID("INCBorrarVersionConcurso"));
	    conectar("ConectorBorrarVersionConcurso", params);		
	    traza("LPMantenimientoVersiones.actualizarSolicitudRechazada() - Salida");
		asignarAtributo("VAR", "ejecutar", "valor", "vueltaActualizarSolicitudRechazada()");
	}
    
	public void borrarModificacion() throws Exception {
	    traza("LPMantenimientoVersiones.borrarModificacion() - Entrada");
		pagina("salidaGenerica");
		//cargarPGVersionesConcurso();

        DTOVersion dtoV = new DTOVersion();
        
		if (oidConcurso != null && oidConcurso.length() > 0) {
           dtoV.setOidConcurso(Long.valueOf(oidConcurso));
           asignarAtributo("VAR", "oidConcurso", "valor", oidConcurso);
        }
        if (oid != null && oid.length() > 0) {
		   dtoV.setOid(Long.valueOf(oid));
           asignarAtributo("VAR", "oid", "valor", oid);
		}

		if(accion.equals("borrar modificacion")) {
			dtoV.setIndBorrado(new Integer(1));
		}
		else if(accion.equals("borrar modificacion rechazada")) {
			dtoV.setIndBorrado(new Integer(2));
		}

        borrarConcurso(dtoV);
		
		if(accion.equals("borrar modificacion")) {
			DTOVersion dtoVersion = new DTOVersion();
			dtoVersion.setOid(Long.valueOf(oid));
			dtoVersion.setOidEstado(ConstantesINC.OID_ESTADO_AUTORIZADO);
			actualizarEstadoVersion(dtoVersion);      
		}
	    traza("LPMantenimientoVersiones.borrarModificacion() - Salida");
		asignarAtributo("VAR", "ejecutar", "valor", "vueltaBorrarModificacion()");
	}

	public void borrarConcurso(DTOVersion dtoe) throws Exception {      
	    traza("LPMantenimientoVersiones.borrarConcurso() - Entrada");
	    Vector params = new Vector();
	    params.add(dtoe);
	    params.add(new MareBusinessID("INCBorrarConcurso"));
	    traza("# conectar ->  ConectorBorrarConcurso ");
	    conectar("ConectorBorrarConcurso", params);
	    traza("LPMantenimientoVersiones.borrarConcurso() - Salida");
	}
    
	public DTONuevaVersion crearConcursoNuevaVersion() throws Exception	{        
	    traza("LPMantenimientoVersiones.crearConcursoNuevaVersion() - Entrada");
		DTOVersion dtoVersion = new DTOVersion();	
		dtoVersion.setOid(Long.valueOf(oid));
		dtoVersion.setOidConcursoOrigen(Long.valueOf(oidConcursoOrigen));
	    dtoVersion.setNumeroConcurso(numeroConcurso);
		dtoVersion.setVersionNueva(new Integer(version));			
		Vector params = new Vector();
		params.add(dtoVersion);
		params.add(new MareBusinessID("INCCrearConcursoNuevaVersion"));
	    traza(" params: " + params.toString());
		traza("# conectar-> ConectorCrearConcursoNuevaVersion ");
		DruidaConector con = conectar("ConectorCrearConcursoNuevaVersion", params);
		traza("# ConectorCrearConcursoNuevaVersion ........ [ok] ");    
	    traza("LPMantenimientoVersiones.crearConcursoNuevaVersion() - Salida");
	    return (DTONuevaVersion)con.objeto("DTO_OUTPUT");
	}

	public void actualizarNuevaVersion(Element datosNuevaVersion) 
    throws Exception { 
        
	    DTONuevaVersion dtoNueva = new DTONuevaVersion();
      traza("datosNuevaVersion: " + datosNuevaVersion);
	  // INC 21471 - dmorello, 26/12/2005
	  // El OID de la versión debe ser recuperado del Element utilizando el String "oid" y no "oidVersion".
	    String sOidVersion = getValElem(datosNuevaVersion, "oid");
      traza("sOidVersion: " + sOidVersion);
	    if (sOidVersion != null && sOidVersion.length() > 0) {
	        dtoNueva.setOidVersion(Long.valueOf(sOidVersion));
	    }
      
	    String sOidConcurso = getValElem(datosNuevaVersion, "oidConcurso");
      traza("sOidConcurso: " + sOidConcurso);
      if (sOidConcurso != null && sOidConcurso.length() > 0) {
         dtoNueva.setOidConcurso(Long.valueOf(sOidConcurso));
	    }
      
	    String sOidRequisitoPremiacion = getValElem(datosNuevaVersion, 
                                                          "oidRequisitoPremiacion");
      traza("sOidRequisitoPremiacion: " + sOidRequisitoPremiacion);
      if (sOidRequisitoPremiacion != null && sOidRequisitoPremiacion.length() > 0) {
        dtoNueva.setOidRequisitoPremiacion(Long.valueOf(sOidRequisitoPremiacion));
	    }
      
      String sOidPeriodoFin = getValElem(datosNuevaVersion, "periodoFin");      
      traza("sOidPeriodoFin: " + sOidPeriodoFin);
	    if (sOidPeriodoFin != null && sOidPeriodoFin.length() > 0) {
	        dtoNueva.setOidPeriodoHasta(Long.valueOf(sOidPeriodoFin));
	    }
      
      String sOidPeriodoPuestaMarcha = getValElem(datosNuevaVersion, 
                                                   "periodoPuestaMarcha");                                                   
      traza("sOidPeriodoPuestaMarcha: " + sOidPeriodoPuestaMarcha);
      if (sOidPeriodoPuestaMarcha != null && sOidPeriodoPuestaMarcha.length() > 0) {
         dtoNueva.setOidPeriodoPuestaMarcha(Long.valueOf(sOidPeriodoPuestaMarcha));
	    }
      
	    String sDiasGracia = getValElem(datosNuevaVersion, "diasGracia");
      traza("sDiasGracia: " + sDiasGracia);
      if (sDiasGracia != null && sDiasGracia.length() > 0) {
	        dtoNueva.setDiasGracia(Integer.valueOf(sDiasGracia));
	    }
      
      String sOidPeriodoDesdeReq = getValElem(datosNuevaVersion, "periodoDesde");      
      if (sOidPeriodoDesdeReq != null && sOidPeriodoDesdeReq.length() > 0) {
	        dtoNueva.setOidPeriodoDesdeReq(Long.valueOf(sOidPeriodoDesdeReq));
	    }
      
      String sOidPeriodoHastaReq = getValElem(datosNuevaVersion, "periodoHasta");      
      if (sOidPeriodoHastaReq != null && sOidPeriodoHastaReq.length() > 0) {
	        dtoNueva.setOidPeriodoHastaReq(Long.valueOf(sOidPeriodoHastaReq));
	    } 
      
      // Agregado por ssantana, 30/8/2005
      String sIndPagoTiempo = getValElem(datosNuevaVersion, "indPagoTiempo");
      traza("sIndPagoTiempo: " + sIndPagoTiempo);
      if ( sIndPagoTiempo != null && sIndPagoTiempo.length() > 0) {
          if ( sIndPagoTiempo.equals("S") ) {
            traza("IndPagoTiempo es TRUE");
            dtoNueva.setIndPagoTiempo(Boolean.TRUE );
          } else {
            traza("IndPagoTiempo es FALSE");          
            dtoNueva.setIndPagoTiempo(Boolean.FALSE );
          }
      } else { 
          traza("IndPagoTiempo es FALSE");
          dtoNueva.setIndPagoTiempo(Boolean.FALSE );
      }
      // Fin agregado ssantana, 30/8/2005
        
      traza("dtoNueva: " + dtoNueva);

      // *****************AGREGADO**********************
      // Obtener de sesión dtoConcurso
      traza("Antes de obtener de sesion");
      DTOConcurso dtoConcurso = (DTOConcurso) this.
                                conectorParametroSesion("dtoConcursoBufferSS");
                                
      // Le seteo a DTOConcurso, "false" los indicadores de los dos productos restantes 
      // by ssantana, 23/8/2005 - Evita nullPointer en Parte Servidora. 
      /*dtoConcurso.setIndObligProductosACalificar(Boolean.FALSE);
      dtoConcurso.setIndObligProductosExcluidosCalificacion(Boolean.FALSE);*/
      
      traza("Despues de obtener de sesion");                                
      traza("dtoConcurso Sesion: " + dtoConcurso );
      
      if ( dtoConcurso.getParamGenerales().getIndActivo().booleanValue() ) {
      
         traza("Concurso Activo");
         if ( (dtoConcurso.getIndProductosValidos().booleanValue() && 
                 dtoConcurso.getIndObligProductosValidos().booleanValue() ) || 
              (dtoConcurso.getPlantilla().getIndProductosValidos().booleanValue()) ) {
            traza("ACA 1");
            if ( dtoConcurso.getIndPremios().booleanValue() && 
                    dtoConcurso.getIndObligPremios().booleanValue() ) {
               traza("ACA 2");
               MareBusinessID bussID1 = new MareBusinessID("INCActualizarNuevaVersion");
               MareBusinessID bussID2 = new MareBusinessID("INCGuardarProductosNuevaVersion");
               MareBusinessID bussID3 = new MareBusinessID("INCGuardarPremiosNuevaVersion");
                     
               Vector vParams1 = new Vector();
               Vector vParams2 = new Vector();
               Vector vParams3 = new Vector();              

  			   traza("++++ SETEANDO PAIS ++++");
			   if(dtoConcurso.getListaNivelesPremiacion()!=null) {
					dtoConcurso.getListaNivelesPremiacion().setOidPais(UtilidadesSession.getPais(this));
					traza("++++ PAIS ++++" + UtilidadesSession.getPais(this));
			   }
   			   traza("++++ FIN SETEANDO PAIS ++++");
               
               vParams1.add(dtoNueva);
               vParams1.add(bussID1);
               
               vParams2.add(dtoConcurso);
               vParams2.add(bussID2);
               
               vParams3.add(dtoConcurso);
               vParams3.add(bussID3);
               
               UtilidadesLog.info("Se conecta con INCActualizarNuevaVersion");
               this.conectar("ConectorActualizarNuevaVersion", vParams1);
               
               UtilidadesLog.info("Se conecta con INCGuardarProductosNuevaVersion");
               this.conectar("ConectorGuardarProductosNuevaVersion", vParams2);
               
               UtilidadesLog.info("Se conecta con INCGuardarPremiosNuevaVersion");
               this.conectar("ConectorGuardarPremiosNuevaVersion", vParams3);
               
           }
         } else {
            UtilidadesLog.info("Error - La Lista de Productos debe contener al menos 1 elem.");
            // "La lista de productos válidos debe contener al menos un elemento"
            throw new MareException(new Exception(), 130007);
         }

      } else {  // Concurso Inactivo
         traza("Concurso Inactivo");
         MareBusinessID bussID1 = new MareBusinessID("INCActualizarNuevaVersion");
         MareBusinessID bussID2 = new MareBusinessID("INCGuardarProductosNuevaVersion");
         MareBusinessID bussID3 = new MareBusinessID("INCGuardarPremiosNuevaVersion");
               
         Vector vParams1 = new Vector();
         Vector vParams2 = new Vector();
         Vector vParams3 = new Vector();              

         /*if ( dtoConcurso.getParamGralesPremiacion() != null) {
            traza("paramGralesPremiacion no es nullo");
            dtoConcurso.getParamGralesPremiacion().
                                     setOidParamGralesPremiacion(dtoNueva.getOidConcurso());
         }*/
         
         vParams1.add(dtoNueva);
         vParams1.add(bussID1);
         
         vParams2.add(dtoConcurso);
         vParams2.add(bussID2);
         
         vParams3.add(dtoConcurso);
         vParams3.add(bussID3);
         
         UtilidadesLog.info("Se conecta con INCActualizarNuevaVersion");
         this.conectar("ConectorActualizarNuevaVersion", vParams1);
         
         UtilidadesLog.info("Se conecta con INCGuardarProductosNuevaVersion");
         this.conectar("ConectorGuardarProductosNuevaVersion", vParams2);
         
         UtilidadesLog.info("Se conecta con INCGuardarPremiosNuevaVersion");
         this.conectar("ConectorGuardarPremiosNuevaVersion", vParams3);
      }             
    }

  private void validarModificacionCambios() throws Exception {      
      traza("LPMantenimientoVersiones.validarModificacionCambios() - Entrada");
      pagina("salidaGenerica");
	  this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");

	  /*
       * Se obtienen los DTOs originales de sesión para comparar con 
       * con lo que se ha modificado.
       */
      Boolean bIndCambio = Boolean.FALSE; // El indicador de cambio por defecto
                                          // se setea en FALSE.-
      String sIndCambio = null;
      
      DTOConcurso dtoConcurso = (DTOConcurso) this.conectorParametroSesion("dtoConcursoBufferSS"); //CLONADO!!!

	  DTOProducto dtoProductosValidosAux = (DTOProducto) this.conectorParametroSesion("dtoProductosValidosAuxSS"); //oRIGINAL	  
	  DTOProducto dtoProductosExcluidosAux = (DTOProducto) this.conectorParametroSesion("dtoProductosExcluidosAuxSS"); //oRIGINAL      
	  DTOProducto dtoProductosBonificadosAux = (DTOProducto) this.conectorParametroSesion("dtoProductosBonificadosAuxSS");//oRIGINAL      
	  DTOProducto dtoProductosExigidosAux = (DTOProducto) this.conectorParametroSesion("dtoProductosExigidosAuxSS");//oRIGINAL                  
      
	  DTOParametrosGeneralesPremiacion dtoParamGeneralesPremiacionAux = (DTOParametrosGeneralesPremiacion)this.conectorParametroSesion("dtoParamGralesPremiacionAux");                          
      DTONivelesPremiacion dtoListaNivelesPremiacionAux = (DTONivelesPremiacion)this.conectorParametroSesion("dtoListaNivelesPremiacionAux");
      
      sIndCambio = conectorParametroLimpia("indCambio", "", true);        
	  traza("******** sIndCambio " + sIndCambio);
      if (sIndCambio.equals("true")) {
        bIndCambio = Boolean.TRUE;
      }
      
      /*
       * Obtenemos los datos que pueden haber cambiado durante la ejecucion del caso de uso.
       */
      DTOProducto dtoProductosValidosCambio = dtoConcurso.getProductosValidos(); //sALE DEL cLONADO
      DTOProducto dtoProductosExcluidosCambio = dtoConcurso.getProductosExcluidos();
      DTOProducto dtoProductosBonificadosCambio = dtoConcurso.getProductosBonificados();
      DTOProducto dtoProductosExigidosCambio = dtoConcurso.getProductosExigidos();
     
	  DTOParametrosGeneralesPremiacion dtoParamGeneralesPremiacionCambio = dtoConcurso.getParamGralesPremiacion();
      DTONivelesPremiacion dtoNivelesPremiacionCambio = dtoConcurso.getListaNivelesPremiacion();

      traza("************* dtoProductosValidosCambio " + dtoProductosValidosCambio);
      traza("************* dtoProductosExcluidosCambio " + dtoProductosExcluidosCambio);
      traza("************* dtoProductosBonificadosCambio " + dtoProductosBonificadosCambio);
      traza("************* dtoProductosExigidosCambio: " + dtoProductosExigidosCambio);
      traza("************* dtoParamGeneralesPremiacionCambio: " + dtoParamGeneralesPremiacionCambio);
      traza("************* dtoNivelesPremiacionCambio: " + dtoNivelesPremiacionCambio);
	  traza("************* dtoListaNivelesPremiacionAux: " + dtoListaNivelesPremiacionAux);
      traza("************* dtoNivelesPremiacionCambio: " + dtoNivelesPremiacionCambio);
              
      /*
       * Comparamos los datos antiguos con los nuevos, a ver si ha habido algun cambio.
       */
       
      // Clausulas Ifs modificadas por ssantana, 18/8/2005
	  
	  //1° - COMPARANDO PRODUCTOS VALIDOS
      traza("********* Validando modificacion validos...");
      if ( (dtoProductosValidosAux != null && 
              !dtoProductosValidosAux.equals(dtoProductosValidosCambio)) ||
           (dtoProductosValidosCambio != null && 
              !dtoProductosValidosCambio.equals(dtoProductosValidosAux) )) {
		traza("*********** Valida Modificacion P. Validos");
		bIndCambio = Boolean.TRUE;                   
      }

	  //2° - COMPARANDO PRODUCTOS EXCLUIDOS
      traza("*********** Validando modificacion excluidos...");      
      if ( (dtoProductosExcluidosAux != null && 
              !dtoProductosExcluidosAux.equals(dtoProductosExcluidosCambio)) ||
           (dtoProductosExcluidosCambio != null && 
              !dtoProductosExcluidosCambio.equals(dtoProductosExcluidosAux) ) ) {
        traza("*********** Valida Modificacion P. Excluidos");
        bIndCambio = Boolean.TRUE; 
      } 

	  //3° - COMPARANDO PRODUCTOS BONIFICADOS
      traza("*********** Validando modificacion bonificados...");                  
      if ( (dtoProductosBonificadosAux != null && 
              !dtoProductosBonificadosAux.equals(dtoProductosBonificadosCambio)) ||
           (dtoProductosBonificadosCambio != null && 
              !dtoProductosBonificadosCambio.equals(dtoProductosBonificadosAux) )) {
        traza("*********** Valida Modificacion P. Bonificados");
        bIndCambio = Boolean.TRUE; 
      } 

	  //4° - COMPARANDO PRODUCTOS EXIGIDOS
      traza("*********** Validando modificacion exigidos...");
      if ( (dtoProductosExigidosAux != null && 
              !dtoProductosExigidosAux.equals(dtoProductosExigidosCambio)) ||
           (dtoProductosExigidosCambio != null && 
              !dtoProductosExigidosCambio.equals(dtoProductosExigidosAux) )) {
        traza("*********** Valida Modificacion P. Exigidos");
        bIndCambio = Boolean.TRUE; 
      } 

	  //5° - COMPARANDO PARAMETROS GENERALES PREMIACION
      traza("*********** Validando modificacion param. grales. premiacion...");
      if ( (dtoParamGeneralesPremiacionAux != null && 
              !dtoParamGeneralesPremiacionAux.equals(dtoParamGeneralesPremiacionCambio)) ||
           (dtoParamGeneralesPremiacionCambio != null && 
              !dtoParamGeneralesPremiacionCambio.equals(dtoParamGeneralesPremiacionAux) )) {
        traza("*********** Valida Modificacion P. Grales Premiacion");
        bIndCambio = Boolean.TRUE; 
      }

  	  //6° - COMPARANDO LISTA NIVELES PREMIACION
      traza("*********** Validando modificacion listaNivelesPremiacion...");      
      if ((dtoListaNivelesPremiacionAux != null && 
              !dtoListaNivelesPremiacionAux.equals(dtoNivelesPremiacionCambio)) ||
          (dtoNivelesPremiacionCambio != null && 
              !dtoNivelesPremiacionCambio.equals(dtoListaNivelesPremiacionAux) )) {
        traza("*********** Valida Modificacion Lista Niveles Premiacion");
        bIndCambio = Boolean.TRUE; 
      }        

      if (bIndCambio.booleanValue()) {
          traza("*********** Hubo cambios...");
		  String strPeriodoPuestaMarcha = conectorParametroLimpia("strPeriodoPuestaMarcha", "", true);   	
          traza("*********** strPeriodoPuestaMarcha " + strPeriodoPuestaMarcha);

		  if(!strPeriodoPuestaMarcha.equals("")) {
              traza("*********** enviarEstructura...");
	          asignarAtributo("VAR", "ejecutar", "valor", "enviarEstructura()");
		  }
		  else {
              traza("*********** validaComboPuestaMarcha...");
			  asignarAtributo("VAR", "ejecutar", "valor", "validaComboPuestaMarcha()");
		  }
      }
	  else {
          traza("*********** No se han detectado cambios en los datos de esta pantalla");
          traza("*********** Se muestra un mensaje");
          // Mostrar el mensaje INC004: No se han detectado cambios 
          // en los datos de esta pantalla "Datos Nueva Versión"
          throw new MareException(new Exception(), 130343);
      }             
  }     

     private void inicializar(String oidConc) throws Exception {
		 traza("LPMantenimientoVersiones.inicializar() - Entrada");
         DTOConcurso dtoConcurso = new DTOConcurso();
         DTOOID dtoOid = new DTOOID();
         traza(" oidConcurso: " + oidConc);     

         if (oidConc != null && oidConc.length() > 0) {
    		traza("********* Entro al if");
            dtoOid.setOid(new Long(oidConc));            
            dtoOid.setOidIdioma(lIdioma);
            dtoOid.setOidPais(lPais);

            traza(" dtoOid:  " + dtoOid);
            Vector params = new Vector();
  	        params.add(dtoOid);
            params.add(new MareBusinessID("INCObtenerConcursoParaCambios"));
            traza("# conectar ->  ConectorObtenerConcursoParaCambios ");
            DruidaConector con = conectar("ConectorObtenerConcursoParaCambios", params);            
            dtoConcurso = (DTOConcurso)con.objeto("dtoSalida");

			dtoConcurso.setOidPais(lPais);
            dtoConcurso.setOidIdioma(lIdioma);

			DTOConcurso dtoClonado = (DTOConcurso) this.deepCopy(dtoConcurso);
			traza("dtoClonado: "+dtoClonado);

            traza("dtoConcurso obtenido por ConectorObtenerDatosConcurso: " + dtoConcurso);

            if (dtoConcurso != null) {
                this.conectorParametroSesion("dtoConcursoBufferSS", 
                                         dtoClonado);
            }


            DTOProducto dtoProductosValidosAux = dtoConcurso.getProductosValidos();
            
            DTOProducto dtoProductosExcluidosAux = dtoConcurso.getProductosExcluidos();
            
            DTOProducto dtoProductosBonificadosAux = dtoConcurso.getProductosBonificados();
            
            DTOProducto dtoProductosExigidosAux = dtoConcurso.getProductosExigidos();


            
            // Agregado por ssantana, 16/8/2005
            DTOParametrosGeneralesPremiacion dtoParamGralesPremiacionAux = 
                                              dtoConcurso.getParamGralesPremiacion();
            
            DTONivelesPremiacion dtoListaNivelesPremiacionAux = 
                                                    dtoConcurso.getListaNivelesPremiacion();
                                                    
            if (dtoParamGralesPremiacionAux != null ) {
                this.conectorParametroSesion("dtoParamGralesPremiacionAux", 
                                             dtoParamGralesPremiacionAux);
            }
            
            if (dtoListaNivelesPremiacionAux != null ) {
                this.conectorParametroSesion("dtoListaNivelesPremiacionAux",
                                             dtoListaNivelesPremiacionAux);
            }
            // Fin agregado ssantana, 16/8/2005
            
            traza("2");
            
            if (dtoProductosValidosAux != null) {
                this.conectorParametroSesion("dtoProductosValidosAuxSS", 
                                         dtoProductosValidosAux);
            }
                         
            traza("3");
            if (dtoProductosExcluidosAux != null) {
                this.conectorParametroSesion("dtoProductosExcluidosAuxSS", 
                                         dtoProductosExcluidosAux);
            }
            
            traza("4");
            if (dtoProductosBonificadosAux != null) {
                this.conectorParametroSesion("dtoProductosBonificadosAuxSS", 
                                         dtoProductosBonificadosAux);
            }
            
            traza("5");
            if (dtoProductosExigidosAux != null) {
                this.conectorParametroSesion("dtoProductosExigidosAuxSS", 
                                         dtoProductosExigidosAux);
            }
            
            traza("6");
            
            traza("7");
         }

		 traza("LPMantenimientoVersiones.inicializar() - Salida");
     }



	//------------------------- UTILITIES --------------------------------------
    private Date toDate(String sFecha) throws Exception {        
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        return this.toDate(sFecha, formatoFecha);
    }

    private Date toDate(String sFecha, String formatoFecha) throws Exception {        
        formatoFecha = formatoFecha.replace('m', 'M');	
        SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
        java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);
        String fechaRes = miFecha.format(fecha);
        fecha = miFecha.parse(fechaRes);
        //java.sql.Date sql = new java.sql.Date(fecha.getTime());     	  	  
        return new java.sql.Date(fecha.getTime());
    }

	private String dateToString(Date dFecha) throws Exception {
        String formato = UtilidadesSession.getFormatoFecha(this);
        formato = formato.replace('m', 'M');
        SimpleDateFormat miFecha = new SimpleDateFormat(formato);
        return miFecha.format(dFecha);		  	  	  
    }

	    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
 
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            return ois.readObject();
        } catch(Exception e) {
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
	            throw new MareException(ex);
            }
        }
    }
}