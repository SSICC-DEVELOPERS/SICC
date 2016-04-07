//import LPSICCBase;
//--Pcabrera 29/08/2005
//--Para poder ver la inc BELC300019421
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.car.DTOUsuarioJerarquia;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.car.DTODatosLiberacion;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import java.math.BigDecimal;
import java.lang.Double;
import es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud;


public class LPSolicitudesBloqueadas extends LPSICCBase{

	String accion;

	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		Long oidPais=null;
		this.rastreo();
		accion = conectorParametroLimpia("accion", "", true);
		try{
			if( accion.equals("") ){
				pagina("contenido_solicitudes_bloqueadas_liberar");
				getConfiguracionMenu("LPSolicitudesBloqueadas", "liberar");
				this.getFormatosValidaciones();
				oidPais = UtilidadesSession.getPais(this);
				cargarPantalla();
				asignar("VAR", "pais", oidPais.toString());
				asignar("VAR", "ESTATUS_BLOQUEADO", ConstantesCAR.ESTATUS_BLOQUEADO.toString());
				asignar("VAR", "ESTATUS_LIBERADO", ConstantesCAR.ESTATUS_LIBERADO.toString());
				asignar("VAR", "ESTATUS_REASIGNADO", ConstantesCAR.ESTATUS_REASIGNADO.toString());
				asignar("VAR", "ESTATUS_RECHAZADO", ConstantesCAR.ESTATUS_RECHAZADO.toString());
				//[1] Integer formato = new Integer(LPSICCBase.FORMATO_DEFAULT);
				asignar("VAR", "formato", (new Integer(LPSICCBase.FORMATO_DEFAULT)).toString());//[1] formato.toString());
				
				DTOUsuarioJerarquia dto = new DTOUsuarioJerarquia();
				dto.setUsuario(UtilidadesSession.getIdUsuario(this));
				dto.setOidIdioma(UtilidadesSession.getIdioma(this));
				dto.setOidPais(oidPais);//[1] UtilidadesSession.getPais(this));
				MareBusinessID businessID = new MareBusinessID("CARObtenerJerarquiaUsuario");
				Vector param = new Vector();
				param.add(dto);
				param.add(businessID);
				DruidaConector conector = conectar("CARObtenerJerarquiaUsuario", param);
				DTOUsuarioJerarquia dtoSalida = (DTOUsuarioJerarquia)conector.objeto("DTOUsuarioJerarquia");
				asignar("VAR", "varNivelJerarquiaUsuario", dtoSalida.getOidJerarquia().toString());
				asignar("VAR", "varEjecutivoCuenta", dtoSalida.getOidEjecutivo().toString());
			
			} else if( accion.equals("rechazar") ){
				rechazar();
			
			} else if( accion.equals("reasignar") ){
				String nivelJerarquico = conectorParametroLimpia("NivelJerarquico", "", true);
				String ejecutivoCuentaAsig = conectorParametroLimpia("EjecutivoCuenta", "", true);
				String oidSolicitudBloqueada = conectorParametroLimpia("oidSolicitudBloqueada", "", true);
				pagina("contenido_solicitudes_bloqueadas_reasignar");
				getConfiguracionMenu("LPSolicitudesBloqueadas", "reasignar");
				asignar("LABELC", "lblNJerarUsuAprobX", nivelJerarquico);
				asignar("LABELC", "lblEjecutivoCuentaX", ejecutivoCuentaAsig);
				asignarAtributo("VAR", "oidSolicitudBloqueada", "valor", oidSolicitudBloqueada);
			
			} else if( accion.equals("liberar") ){
				String oidSolicitudBloqueada = conectorParametro("oidSolicitudBloqueada");
				String varEjecutivoCuenta = conectorParametro("varEjecutivoCuenta");
				pagina("contenido_solicitudes_bloqueadas_aprobar");
				getConfiguracionMenu("LPSolicitudesBloqueadas", "aprobar");
				asignarAtributo("VAR", "oidSolicitudBloqueada", "valor", oidSolicitudBloqueada);
				asignarAtributo("VAR", "varEjecutivoCuenta", "valor", varEjecutivoCuenta);
				cargaPantallaAprobacion();
			
			} else if( accion.equals("guardarAprobacion") ){
				guardarAprobacion();

			} else if( accion.equals("guardarReasignacion") ){
				guardarReasignacion();
			}			
			
		} catch(Exception ex) {
			traza("EXCEPCION: " + ex.toString());
			ex.printStackTrace();
			this.lanzarPaginaError(ex);
		}
	}

	private void rechazar() throws Exception{
		pagina("salidaGenerica");
		String seleccion = conectorParametroLimpia("seleccion", "", true );
		DTOOID dto = new DTOOID();
		dto.setOid(new Long(seleccion));
		MareBusinessID businessID = new MareBusinessID("CARRechazarSolicitud");
		Vector param = new Vector();
		param.add(dto);
		param.add(businessID);
		DruidaConector conector = conectar("ConectorCARRechazarSolicitud", param);
		asignarAtributo("VAR", "ejecutar", "valor", "buscar_click()");
	}

	private void cargarPantalla() throws Exception{
		Long pais= UtilidadesSession.getPais(this);//[1]
		Long idioma = UtilidadesSession.getIdioma(this); //[1]

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(idioma);//[1] UtilidadesSession.getIdioma(this));
		dtoBelcorp.setOidPais(pais);//[1] UtilidadesSession.getPais(this));
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOidIdioma(idioma);//[1] UtilidadesSession.getIdioma(this));
		dtoOid.setOidPais(pais);//[1] UtilidadesSession.getPais(this));
		ComposerViewElement c1 = new ComposerViewElement();
		ComposerViewElementList compList = new ComposerViewElementList();			
		c1.setIDBusiness("CARNivelesRiesgo");
		c1.setDTOE(dtoOid);
		compList.addViewElement(c1);
	    c1 = new ComposerViewElement();
		c1.setIDBusiness("CARGruposSolicitud");
		DTOFiltroGrupoSolicitud dtoF = new DTOFiltroGrupoSolicitud();

		dtoF.setOidIdioma(idioma);//[1]UtilidadesSession.getIdioma(this));
		dtoF.setOidPais(pais);//[1] UtilidadesSession.getPais(this));
		c1.setDTOE(dtoF);
		compList.addViewElement(c1);
		c1 = new ComposerViewElement();
		c1.setIDBusiness("CARObtenerJerarquias");
		c1.setDTOE(dtoBelcorp);
		compList.addViewElement(c1);
		c1 = new ComposerViewElement();
		c1.setIDBusiness("SEGConsultaMarcas");
		c1.setDTOE(dtoBelcorp);
		compList.addViewElement(c1);
		c1 = new ComposerViewElement();
		c1.setIDBusiness("SEGConsultaCanales");
		c1.setDTOE(dtoBelcorp);
		compList.addViewElement(c1);
		c1 = new ComposerViewElement();
		c1.setIDBusiness("CARObtenerEstatusPedido");
		c1.setDTOE(dtoBelcorp);
		compList.addViewElement(c1);		     
		ConectorComposerView conector = new ConectorComposerView(compList, this.getRequest());
        conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		asignar("COMBO", "cbNivelRiesgo", resultados, "CARNivelesRiesgo");
		asignar("COMBO", "cbGrupoSolicitud", resultados, "CARGruposSolicitud");
		asignar("COMBO", "cbNJerarUsu", resultados, "CARObtenerJerarquias");
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
		asignar("COMBO", "cbEstatus", resultados, "CARObtenerEstatusPedido");
	}

	private void cargaPantallaAprobacion() throws Exception{
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		dto.setOidPais(UtilidadesSession.getPais(this));
		// Se crea un ComposerViewElementList y se le agregan los siguientes ComposerViewElement:
		ComposerViewElement c1 = new ComposerViewElement();
		ComposerViewElementList compList = new ComposerViewElementList();		
		// 1,. ComposerViewElement con: 
		// dtooid 
		// MareBusinessID="CARCodigosAprobacion" 
		c1 = new ComposerViewElement();
		c1.setIDBusiness("CARObtenerCodigosAprobacion");
		c1.setDTOE(dto);
		compList.addViewElement(c1);
		// Asociando el ROW_SET obtenido al campo codigo de aprobacion de la pantalla pantallaAprobacionSolicitud. 
		ConectorComposerView conector = new ConectorComposerView(compList, this.getRequest());
        conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		asignar("COMBO", "cbMotivoAprobacion", resultados, "CARObtenerCodigosAprobacion");
	}

	private void guardarReasignacion() throws Exception{
		pagina("salidaGenerica");		
		// Se cre un DTODatosLiberacion y se asignan los datos correspondientes a 
		// observacion, oidEjecutivo y oidSolicitudBloqueada. 
		DTODatosLiberacion dto = new DTODatosLiberacion();
		dto.setObservacion(conectorParametro("areaObservacionesAprob"));
		dto.setOidEjecutivo(new Long(conectorParametro("seleccion")));
		dto.setOidSolicitudBloqueada(new Long(conectorParametro("oidSolicitudBloqueada")));
		// Se ejecuta el conector "ConectorCARReasignarSolicitud" con el IDBusiness="CARReasignarSolicitud"
		MareBusinessID businessID = new MareBusinessID("CARReasignarSolicitud");
		Vector param = new Vector();
		param.add(dto);
		param.add(businessID);
		DruidaConector conector = conectar("ConectorCARReasignarSolicitud", param);
	}

	private void guardarAprobacion() throws Exception{
		// Se crea un DTODatosLiberacion y se asignan los datos correspondientes 
		// a oidCodigoAprobacion, observacion, usuario (se toma de la sesion) y oidSolicitudBloqueada. 
		pagina("salidaGenerica");
		DTODatosLiberacion dto = new DTODatosLiberacion();
		dto.setOidCodigoAprobacion(new Long(conectorParametroLimpia("cbMotivoAprobacion", "", true)));
		dto.setObservacion(conectorParametroLimpia("areaObservacionesAprob", "", true));

		dto.setOidEjecutivo(new Long(conectorParametro("varEjecutivoCuenta")));
		dto.setOidSolicitudBloqueada(new Long(conectorParametroLimpia("oidSolicitudBloqueada", "", true)));
		MareBusinessID businessID = new MareBusinessID("CARLiberarSolicitud");
		Vector param = new Vector();
		param.add(dto);
		param.add(businessID);
		DruidaConector conector = conectar("ConectorCARLiberarSolicitud", param);
		asignarAtributo("VAR", "ejecutar", "valor", "fVolver()");
	}
}