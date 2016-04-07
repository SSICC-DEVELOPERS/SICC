import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;

public class LPEvaluarCambiosYSolicitudes extends LPSICCBase {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;
	private Long oidEstado = null;
    private String oidEstadoConcurso = null;
    private String oid = null;
	private String opcionMenu = null;

	public LPEvaluarCambiosYSolicitudes() { super(); }

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {        
        setTrazaFichero();
	    try	{ 
		    this.rastreo();    
			traza("************ Entre a LPEvaluarCambiosYSolicitudes");
			accion = conectorParametroLimpia("accion", "", true);
            traza(" accion: " + accion);
			oid = conectorParametroLimpia("oid", "", true);
			sPais = UtilidadesSession.getPais(this).toString();
			sIdioma = UtilidadesSession.getIdioma(this).toString();
			sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
			lIdioma = UtilidadesSession.getIdioma(this);
			lPais = UtilidadesSession.getPais(this);

			if (accion != null && accion.length() == 0) { 
		        cargarPantalla();
			}
			else if ("autorizar".equals(accion)) {
                oidEstadoConcurso = conectorParametroLimpia("oidEstadoConcurso", "", true);
			    traza(" oidEstadoConcurso: " + oidEstadoConcurso);
                oidEstado = Long.valueOf(oidEstadoConcurso);
			    traza(" oidEstado: " + oidEstado);
				if (oidEstado != null) {
				    autorizar(oidEstado);
				}
			}
			else if ("rechazar".equals(accion)) {
			    oidEstado = Long.valueOf(conectorParametroLimpia("oidEstadoConcurso", "", true));
				if (oidEstado != null) {
				    rechazar(oidEstado);
				}
			}
	    }
		catch(Exception e) {
		    ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		}

		getConfiguracionMenu();
	}

	public void cargarPantalla() throws Exception {
		traza("************ Entre a cargaPantalla");
		pagina("contenido_cambios_solicitudes_evaluar");        

		asignarAtributoPagina("cod", "0696");
		traza("************ accion:" + accion);         
		if (accion != null && accion.length() > 0) {
		    asignarAtributo("VAR", "accion", "valor", accion);
		}
		asignarAtributo("VAR", "varPais", "valor", sPais);
		asignarAtributo("VAR", "varIdioma", "valor", sIdioma);
    }

	public void autorizar(Long oidEstadoConcurso) throws Exception {
	    if (oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION)) {
            oidEstado = ConstantesINC.OID_ESTADO_AUTORIZADO;
		}

		if (oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_SOLICITADA_APROBACION)) {
            oidEstado = ConstantesINC.OID_ESTADO_APROBADO;
		}
		if (oidEstado != null) {
		    modificar(oidEstado);
		}
	}

	public void rechazar(Long oidEstadoConcurso) throws Exception {
		if (oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_SOLICITADA_AUTORIZACION)) {
            oidEstado = ConstantesINC.OID_ESTADO_RECHAZADA_AUTORIZACION;
		}

		if (oidEstadoConcurso.equals(ConstantesINC.OID_ESTADO_SOLICITADA_APROBACION)) {
            oidEstado = ConstantesINC.OID_ESTADO_RECHAZADA_APROBACION;
		}

		if (oidEstado != null) {
		    modificar(oidEstado);
		}		
	}
    
	public void modificar(Long oidEstado) throws Exception {
		traza("LPEvaluarCambiosYSolicitudes.modificar() - Entrada");
	    pagina("salidaGenerica");        
        traza("**** oid modificar: " + oid);

	    DTOVersion dtoVersion = new DTOVersion();
	    dtoVersion.setOid(Long.valueOf(oid));
	    dtoVersion.setOidEstado(oidEstado);

		/* Agregado por ssantana, 10/05/2006, Versionado */
		if (accion.equals("autorizar")) {
			dtoVersion.setIndAutoriza(Boolean.TRUE);
		} 
		if (accion.equals("rechazar")) {
			dtoVersion.setIndAutoriza(Boolean.FALSE);
		}

		traza("**************** DTOVersion: " + dtoVersion);

	    Vector pms = new Vector();
	    pms.add(dtoVersion);
	    pms.add(new MareBusinessID("INCActualizarEstadoVersion"));
	    DruidaConector con = conectar("ConectorActualizarEstadoVersion", pms);
		traza("LPEvaluarCambiosYSolicitudes.modificar() - Salida");
		asignarAtributo("VAR", "ejecutar", "valor", "vuelveEnviaOculto()");				
	}    
}