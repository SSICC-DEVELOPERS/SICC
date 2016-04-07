/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.mae.DTOBuscarTiposBloqueoUsuario;
import es.indra.sicc.dtos.mae.DTOClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOTipoBloqueo;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.math.BigDecimal;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

 
public class LPBloquearDesbloquearCliente extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPBloquearDesbloquearCliente() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - ejecucion ***");
      
        try {
            rastreo();
            setTrazaFichero();

            accion = conectorParametroLimpia("accion", "", true);
            opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
            oidPais = UtilidadesSession.getPais(this); 
            oidIdioma = UtilidadesSession.getIdioma(this);
			
            traza("*** accion: " + accion);
            traza("*** opcionMenu: " + opcionMenu);
			traza("*** pais: " + oidPais);
            traza("*** idioma: " + oidIdioma);
            
            if (accion.equals("")) {
				this.cargarPaginaBloquearDesbloquear();
            } else if (accion.equals("bloquear")) {
				this.cargarPaginaBloquear();
            } else if (accion.equals("detalle")) {
				this.cargarPaginaDetalleBloqueo();
            } else if (accion.equals("historico")) {
				this.cargarPaginaHistoricoBloqueos();
            } else if (accion.equals("modificar")) {
				this.cargarPaginaModificarBloqueo();
            } else if (accion.equals("validarPermisoDesbloquear")) {
				this.validarPermisoDesbloquear();
            } else if (accion.equals("desbloquear")) {
				this.cargarPaginaDesbloquear();
            } else if (accion.equals("guardarBloqueo")) {
				this.guardarBloqueo();
            }
            
        } catch (Exception e) {
            traza(" --- Excepcion - LPBloquearDesbloquearCliente");
            logStackTrace(e);
            lanzarPaginaError(e);
        }
           
        traza("*** Salida  - LPBloquearDesbloquearCliente - ejecucion ***");
    }
	
	private void cargarPaginaBloquearDesbloquear() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaBloquearDesbloquear ***");
		
		pagina("contenido_clientes_bloquear_desbloquear");
		asignarAtributoPagina("cod", "0396");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "buscar");
		getFormatosValidaciones();
		Byte longitud = this.obtenerLongitudCodigoCliente();
		asignar("VAR", "hLongitudCodCliente", longitud.toString());

		// Busco la información de tipos de documento para el combo cbTipoDocumento

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(this.oidPais);
		dtoe.setOidIdioma(this.oidIdioma);

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setIDBusiness("MAEObtenerTiposDocumentoPais");
		elem.setDTOE(dtoe);
		list.addViewElement(elem);

		ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
		conector.ejecucion();

		traza("*** Antes de conectar");
		DruidaConector drdConector = conector.getConector();
		traza("*** Despues de conectar");

		asignar("COMBO", "cbTipoDocumento", drdConector, "MAEObtenerTiposDocumentoPais");

		// Busco el primer tipo doc con IND_DNI activo y lo selecciono en el combo
		MareBusinessID id = new MareBusinessID("MAEObtenerTiposDocumentoPais");
		Vector paramsEntrada = new Vector();
		paramsEntrada.add(dtoe);
		paramsEntrada.add(id);

		traza("*** Antes de conectar");
		DruidaConector drdConector2 = conectar("ConectorObtenerTiposDocumentoPais", paramsEntrada);
		traza("*** Despues de conectar");

		DTOSalida dtoSalida = (DTOSalida)drdConector2.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		int size = rs.getRowCount();
		BigDecimal oidDNI = null;
		for (int i = 0; i < size && oidDNI == null; i++) {
			BigDecimal indDNI = (BigDecimal)rs.getValueAt(i, "IND_DNI");
			if (indDNI != null && indDNI.longValue() == 1) {
				oidDNI = (BigDecimal)rs.getValueAt(i, "OID");
			}
		}

		if (oidDNI != null) {
			asignar("VAR", "hOidTipoDocumentoDNI", oidDNI.toString());
		}

		asignar("VAR", "varPais", this.oidPais.toString());
		asignar("VAR", "varIdioma", this.oidIdioma.toString());
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcionMenu", this.opcionMenu);

        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaBloquearDesbloquear ***");
	}

	private void cargarPaginaBloquear() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaBloquear ***");
		
		String strOidCliente = conectorParametroLimpia("hOidCliente", "", true);
		String strCodCliente = conectorParametroLimpia("hCodCliente", "", true);
		String strNombre1 = conectorParametroLimpia("hNombre1", "", true);
		String strNombre2 = conectorParametroLimpia("hNombre2", "", true);
		String strApellido1 = conectorParametroLimpia("hApellido1", "", true);
		String strApellido2 = conectorParametroLimpia("hApellido2", "", true);
		String strBloqueado = conectorParametroLimpia("hBloqueado", "", true);

		traza("*** strOidCliente: " + strOidCliente);
		traza("*** strCodCliente: " + strCodCliente);
		traza("*** strNombre1: " + strNombre1);
		traza("*** strNombre2: " + strNombre2);
		traza("*** strApellido1: " + strApellido1);
		traza("*** strApellido2: " + strApellido2);
		traza("*** strBloqueado: " + strBloqueado);

		pagina("contenido_cliente_bloquear");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "bloquear");
		getFormatosValidaciones();

		asignar("VAR", "hOidCliente", strOidCliente);
		asignar("VAR", "hCodCliente", strCodCliente);
		asignar("VAR", "hNombre1", strNombre1);
		asignar("VAR", "hNombre2", strNombre2);
		asignar("VAR", "hApellido1", strApellido1);
		asignar("VAR", "hApellido2", strApellido2);
		asignar("VAR", "hBloqueado", strBloqueado);

		this.cargarComboTiposBloqueoUsuario();

        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaBloquear ***");
	}

	private void cargarPaginaDetalleBloqueo() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaDetalleBloqueo ***");

		String codCliente = conectorParametroLimpia("hCodCliente", "", false);
		String nombre1 = conectorParametroLimpia("hNombre1", "", false);
		String nombre2 = conectorParametroLimpia("hNombre2", "", false);
		String apellido1 = conectorParametroLimpia("hApellido1", "", false);
		String apellido2 = conectorParametroLimpia("hApellido2", "", false);
		String bloqueado = conectorParametroLimpia("hBloqueado", "", false);
		String descTipoBloqueo = conectorParametroLimpia("hDescTipoBloqueo", "", false);
		String motivoBloqueo = conectorParametroLimpia("hMotivoBloqueo", "", false);
		String fechaBloqueo = conectorParametroLimpia("hFechaBloqueo", "", false);
		String fechaDesbloqueo = conectorParametroLimpia("hFechaDesbloqueo", "", false);
		String usuarioBloqueo = conectorParametroLimpia("hUsuarioBloqueo", "", false);
		String usuarioDesbloqueo = conectorParametroLimpia("hUsuarioDesbloqueo", "", false);
		String indicadorBloqueo = conectorParametroLimpia("hIndicadorBloqueo", "", false);
		String indicadorDesbloqueo = conectorParametroLimpia("hIndicadorDesbloqueo", "", false);
		String observBloqueo = conectorParametroLimpia("hObservBloqueo", "", false);
		String observDesbloqueo = conectorParametroLimpia("hObservDesbloqueo", "", false);

		traza("codCliente: " + codCliente);
		traza("nombre1: " + nombre1);
		traza("nombre2: " + nombre2);
		traza("apellido1: " + apellido1);
		traza("apellido2: " + apellido2);
		traza("bloqueado: " + bloqueado);
		traza("descTipoBloqueo: " + descTipoBloqueo);
		traza("motivoBloqueo: " + motivoBloqueo);
		traza("fechaBloqueo: " + fechaBloqueo);
		traza("fechaDesbloqueo: " + fechaDesbloqueo);
		traza("usuarioBloqueo: " + usuarioBloqueo);
		traza("usuarioDesbloqueo: " + usuarioDesbloqueo);
		traza("indicadorBloqueo: " + indicadorBloqueo);
		traza("indicadorDesbloqueo: " + indicadorDesbloqueo);
		traza("observBloqueo: " + observBloqueo);
		traza("observDesbloqueo: " + observDesbloqueo);

		pagina("contenido_cliente_bloqueo_detalle");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "detalle");

		asignar("VAR", "hCodCliente", codCliente);
		asignar("VAR", "hNombre1", nombre1);
		asignar("VAR", "hNombre2", nombre2);
		asignar("VAR", "hApellido1", apellido1);
		asignar("VAR", "hApellido2", apellido2);
		asignarAtributo("CHECKBOX", "chkBloqueado", "check", bloqueado);
		asignar("VAR", "hDescTipoBloqueo", descTipoBloqueo);
		asignar("VAR", "hFechaBloqueo", fechaBloqueo);
		asignar("VAR", "hIndicadorBloqueo", indicadorBloqueo);
		asignar("VAR", "hUsuarioBloqueo", usuarioBloqueo);
		asignar("VAR", "hUsuarioDesbloqueo", usuarioDesbloqueo);
		asignar("VAR", "hObservBloqueo", observBloqueo);
		asignar("VAR", "hFechaDesbloqueo", fechaDesbloqueo);
		asignar("VAR", "hIndicadorDesbloqueo", indicadorDesbloqueo);
		asignar("VAR", "hMotivoBloqueo", motivoBloqueo);
		asignar("VAR", "hObservDesbloqueo", observDesbloqueo);
		
        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaDetalleBloqueo ***");
	}

	private void cargarPaginaHistoricoBloqueos() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaHistoricoBloqueos ***");

		String strOidCliente = conectorParametroLimpia("hOidCliente", "", false);
		String strCodCliente = conectorParametroLimpia("hCodCliente", "", false);
		String strNombre1 = conectorParametroLimpia("hNombre1", "", false);
		String strNombre2 = conectorParametroLimpia("hNombre2", "", false);
		String strApellido1 = conectorParametroLimpia("hApellido1", "", false);
		String strApellido2 = conectorParametroLimpia("hApellido2", "", false);
		String strBloqueado = conectorParametroLimpia("hBloqueado", "", false);

		traza("strOidCliente:" + strOidCliente);
		traza("strCodCliente:" + strCodCliente);
		traza("strNombre1:" + strNombre1);
		traza("strNombre2:" + strNombre2);
		traza("strApellido1:" + strApellido1);
		traza("strApellido2:" + strApellido2);
		traza("strBloqueado:" + strBloqueado);
		
		pagina("contenido_cliente_bloqueo_historico");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "historico");

		asignar("VAR", "hOidCliente", strOidCliente);
		asignar("VAR", "hCodCliente", strCodCliente);
		asignar("VAR", "hNombre1", strNombre1);
		asignar("VAR", "hNombre2", strNombre2);
		asignar("VAR", "hApellido1", strApellido1);
		asignar("VAR", "hApellido2", strApellido2);
		asignarAtributo("CHECKBOX", "chkBloqueado", "check", strBloqueado);
		
        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaHistoricoBloqueos ***");
	}

	private void cargarPaginaModificarBloqueo() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaModificarBloqueo ***");

		String strOidBloqueo = conectorParametroLimpia("hOidBloqueo", "", false);
		String strOidCliente = conectorParametroLimpia("hOidCliente", "", false);
		String strCodCliente = conectorParametroLimpia("hCodCliente", "", false);
		String strNombre1 = conectorParametroLimpia("hNombre1", "", false);
		String strNombre2 = conectorParametroLimpia("hNombre2", "", false);
		String strApellido1 = conectorParametroLimpia("hApellido1", "", false);
		String strApellido2 = conectorParametroLimpia("hApellido2", "", false);
		String strBloqueado = conectorParametroLimpia("hBloqueado", "", false);
		String strDescTipoBloqueo = conectorParametroLimpia("hDescTipoBloqueo", "", false);
		String strFechaBloqueo = conectorParametroLimpia("hFechaBloqueo", "", false);
		String strMotivoBloqueo = conectorParametroLimpia("hMotivoBloqueo", "", false);
		String strUsuarioBloqueo = conectorParametroLimpia("hUsuarioBloqueo", "", false);
		String strIndicadorBloqueo = conectorParametroLimpia("hIndicadorBloqueo", "", false);
		String strObservBloqueo = conectorParametroLimpia("hObservBloqueo", "", false);

		traza("strOidBloqueo: " + strOidBloqueo);
		traza("strOidCliente: " + strOidCliente);
		traza("strCodCliente: " + strCodCliente);
		traza("strNombre1: " + strNombre1);
		traza("strNombre2: " + strNombre2);
		traza("strApellido1: " + strApellido1);
		traza("strApellido2: " + strApellido2);
		traza("strBloqueado: " + strBloqueado);
		traza("strDescTipoBloqueo: " + strDescTipoBloqueo);
		traza("strFechaBloqueo: " + strFechaBloqueo);
		traza("strMotivoBloqueo: " + strMotivoBloqueo);
		traza("strUsuarioBloqueo: " + strUsuarioBloqueo);
		traza("strIndicadorBloqueo: " + strIndicadorBloqueo);
		traza("strObservBloqueo: " + strObservBloqueo);

		pagina("contenido_cliente_bloqueo_modificar");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "modificar");
		getFormatosValidaciones();

		asignarAtributo("VAR", "hOidBloqueo", "valor", strOidBloqueo);
		asignarAtributo("VAR", "hOidCliente", "valor", strOidCliente);
		asignarAtributo("VAR", "hCodCliente", "valor", strCodCliente);
		asignarAtributo("VAR", "hNombre1", "valor", strNombre1);
		asignarAtributo("VAR", "hNombre2", "valor", strNombre2);
		asignarAtributo("VAR", "hApellido1", "valor", strApellido1);
		asignarAtributo("VAR", "hApellido2", "valor", strApellido2);
		asignarAtributo("CHECKBOX", "chkBloqueado", "check", strBloqueado);
		asignarAtributo("VAR", "hDescTipoBloqueo", "valor", strDescTipoBloqueo);
		asignarAtributo("VAR", "hFechaBloqueo", "valor", strFechaBloqueo);
		asignarAtributo("VAR", "hMotivoBloqueo", "valor", strMotivoBloqueo);
		asignarAtributo("VAR", "hUsuarioBloqueo", "valor", strUsuarioBloqueo);
		asignarAtributo("VAR", "hIndicadorBloqueo", "valor", strIndicadorBloqueo);
		asignarAtributo("AREATEXTO", "txtObservBloqueoActual", "valor", strObservBloqueo);

		this.cargarComboTiposBloqueoUsuario();
		
        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaModificarBloqueo ***");
	}


	private void validarPermisoDesbloquear() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - validarPermisoDesbloquear ***");

		String strOidTipoBloqueo = conectorParametroLimpia("hOidTipoBloqueoElemSeleccionado", "", false);
		String strUsuario = UtilidadesSession.getIdUsuario(this);

		traza("strOidTipoBloqueo: " + strOidTipoBloqueo);
		traza("strUsuario: " + strUsuario);
		
		pagina("salidaGenerica");

		DTOBuscarTiposBloqueoUsuario dto = new DTOBuscarTiposBloqueoUsuario();
		dto.setUsuario(strUsuario);
		dto.setOidTipoBloqueo(new Long(strOidTipoBloqueo));
		dto.setOidPais(this.oidPais);
		dto.setOidIdioma(this.oidIdioma);

		Vector params = new Vector();
		params.add(dto);
		params.add(new MareBusinessID("MAEObtenerTiposBloqueoUsuarioPermisos"));

		traza("*** Antes de conectar para validar permiso desbloquear");
		DruidaConector conector = conectar("ConectorObtenerTiposBloqueoUsuarioPermisos", params);
		traza("*** Luego de conectar para validar permiso desbloquear");
		
		// El recordSet recibido tiene un único registro
		// correspondiente al OID tipo bloqueo pasado en el DTO
		DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();

		// Verifico que el tipo de bloqueo pueda desbloquearse manualmente
		String desbloqueoManual = rs.getValueAt(0, "DESBLOQUEO_MANUAL").toString();
		if (desbloqueoManual.equals("S")) {
			// Ahora veo que el usuario tenga permiso para desbloquear ese tipo de bloqueo
			String permisoDesbloquear = rs.getValueAt(0, "PERMISO_DESBLOQUEAR").toString();
			if (permisoDesbloquear.equals("S")) {
				// El usuario puede desbloquear, levanto ventana modal para desbloquear
				asignar("VAR", "ejecutar", "cargarModalDesbloquear()");
			} else {
				// El usuario no tiene permiso
				asignar("VAR", "ejecutar", "usuarioSinPermisoDesbloquear()");
			}
		} else {
			// El tipo de bloqueo no puede desbloquearse manualmente
			asignar("VAR", "ejecutar", "tipoBloqueoSinDesbloqueoManual()");
		}

        traza("*** Salida  - LPBloquearDesbloquearCliente - validarPermisoDesbloquear ***");
	}
    
	private void cargarPaginaDesbloquear() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarPaginaDesbloquear ***");

		String strOidBloqueo = conectorParametroLimpia("hOidBloqueo", "", false);
		String strOidCliente = conectorParametroLimpia("hOidCliente", "", false);
		String strCodCliente = conectorParametroLimpia("hCodCliente", "", false);
		String strNombre1 = conectorParametroLimpia("hNombre1", "", false);
		String strNombre2 = conectorParametroLimpia("hNombre2", "", false);
		String strApellido1 = conectorParametroLimpia("hApellido1", "", false);
		String strApellido2 = conectorParametroLimpia("hApellido2", "", false);
		String strBloqueado = conectorParametroLimpia("hBloqueado", "", false);
		String strDescTipoBloqueo = conectorParametroLimpia("hDescTipoBloqueo", "", false);
		String strFechaBloqueo = conectorParametroLimpia("hFechaBloqueo", "", false);
		String strMotivoBloqueo = conectorParametroLimpia("hMotivoBloqueo", "", false);
		String strUsuarioBloqueo = conectorParametroLimpia("hUsuarioBloqueo", "", false);
		String strIndicadorBloqueo = conectorParametroLimpia("hIndicadorBloqueo", "", false);
		String strObservBloqueo = conectorParametroLimpia("hObservBloqueo", "", false);

		traza("strOidBloqueo: " + strOidBloqueo);
		traza("strOidCliente: " + strOidCliente);
		traza("strCodCliente: " + strCodCliente);
		traza("strNombre1: " + strNombre1);
		traza("strNombre2: " + strNombre2);
		traza("strApellido1: " + strApellido1);
		traza("strApellido2: " + strApellido2);
		traza("strBloqueado: " + strBloqueado);
		traza("strDescTipoBloqueo: " + strDescTipoBloqueo);
		traza("strFechaBloqueo: " + strFechaBloqueo);
		traza("strMotivoBloqueo: " + strMotivoBloqueo);
		traza("strUsuarioBloqueo: " + strUsuarioBloqueo);
		traza("strIndicadorBloqueo: " + strIndicadorBloqueo);
		traza("strObservBloqueo: " + strObservBloqueo);
		
		pagina("contenido_cliente_desbloquear");
		getConfiguracionMenu("LPBloquearDesbloquearCliente", "desbloquear");
		getFormatosValidaciones();

		asignarAtributo("VAR", "hOidBloqueo", "valor", strOidBloqueo);
		asignarAtributo("VAR", "hOidCliente", "valor", strOidCliente);
		asignarAtributo("VAR", "hCodCliente", "valor", strCodCliente);
		asignarAtributo("VAR", "hNombre1", "valor", strNombre1);
		asignarAtributo("VAR", "hNombre2", "valor", strNombre2);
		asignarAtributo("VAR", "hApellido1", "valor", strApellido1);
		asignarAtributo("VAR", "hApellido2", "valor", strApellido2);
		asignarAtributo("CHECKBOX", "chkBloqueado", "check", strBloqueado);
		asignarAtributo("VAR", "hDescTipoBloqueo", "valor", strDescTipoBloqueo);
		asignarAtributo("VAR", "hFechaBloqueo", "valor", strFechaBloqueo);
		asignarAtributo("VAR", "hMotivoBloqueo", "valor", strMotivoBloqueo);
		asignarAtributo("VAR", "hUsuarioBloqueo", "valor", strUsuarioBloqueo);
		asignarAtributo("VAR", "hIndicadorBloqueo", "valor", strIndicadorBloqueo);
		asignarAtributo("AREATEXTO", "txtObservBloqueoActual", "valor", strObservBloqueo);

        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarPaginaDesbloquear ***");
	}

	private void cargarComboTiposBloqueoUsuario() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - cargarComboTiposBloqueoUsuario ***");

		DTOString dtoUsuario = new DTOString();
		dtoUsuario.setCadena(UtilidadesSession.getIdUsuario(this));
		dtoUsuario.setOidPais(this.oidPais);
		dtoUsuario.setOidIdioma(this.oidIdioma);

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement elem = new ComposerViewElement();
		elem.setDTOE(dtoUsuario);
		elem.setIDBusiness("MAEObtenerTiposBloqueoUsuario");
		list.addViewElement(elem);

		ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
		conector.ejecucion();

		traza("*** antes de conectar");    
		DruidaConector drdConector = conector.getConector();
		traza("*** despues de conectar ");

		asignar("COMBO", "cbTipoBloqueo", drdConector, "MAEObtenerTiposBloqueoUsuario");

        traza("*** Salida  - LPBloquearDesbloquearCliente - cargarComboTiposBloqueoUsuario ***");
	}

	private void guardarBloqueo() throws Exception {
        traza("*** Entrada - LPBloquearDesbloquearCliente - guardarBloqueo ***");

		DTOClienteBloqueo dto = new DTOClienteBloqueo();

		// Lleno los datos del DTO según sea bloqueo, desbloqueo o modificación
		String casoDeUso = conectorParametroLimpia("casoDeUso", "", false);
		if (casoDeUso.equals("bloquear") || casoDeUso.equals("modificarBloqueo")) {

			// Tomo los hiddens de la pagina contenido_cliente_bloquear
			// La fecha de bloqueo se tomará luego en el servidor
			String strOidCliente = conectorParametroLimpia("hOidCliente", "", false);
			String strOidTipoBloqueo = conectorParametroLimpia("hOidTipoBloqueo", "", false);
			String strMotivoBloqueo = conectorParametroLimpia("txtMotivoBloqueo", "", false);
			String strObservBloqueo = null;

			traza("strOidCliente: " + strOidCliente);
			traza("strOidTipoBloqueo: " + strOidTipoBloqueo);
			traza("strMotivoBloqueo: " + strMotivoBloqueo);

			dto.setOidCliente(new Long(strOidCliente));
			dto.setOidTipoBloqueo(new Long(strOidTipoBloqueo));
			dto.setCodFormaBloqueo(ConstantesMAE.COD_VALOR_ACCION_MANUAL);
			dto.setMotivoBloqueo(strMotivoBloqueo);
			dto.setIndDesbloqueo(Boolean.FALSE);
			dto.setUsuarioBloqueo(UtilidadesSession.getIdUsuario(this));

			if (casoDeUso.equals("modificarBloqueo")) {
				String strOidBloqueo = conectorParametroLimpia("hOidBloqueo", "", false);
				strObservBloqueo = conectorParametroLimpia("hObservBloqueoNuevo", "", false);
				traza("strOidBloqueo: " + strOidBloqueo);
				dto.setOid(new Long(strOidBloqueo));
			} else { // bloquear
				strObservBloqueo = conectorParametroLimpia("hObservBloqueo", "", false);
			}

			traza("strObservBloqueo: " + strObservBloqueo);
			if (strObservBloqueo.length() > 0) {
				dto.setObservacionesBloqueo(strObservBloqueo);
			}

		} else if (casoDeUso.equals("desbloquear")) {
			String strOidBloqueo = conectorParametroLimpia("hOidBloqueo", "", false);
			String strObservDesbloqueo = conectorParametroLimpia("hObservDesbloqueo", "", false);

			traza("strOidBloqueo: " + strOidBloqueo);
			traza("strObservDesbloqueo: " + strObservDesbloqueo);

			dto.setOid(new Long(strOidBloqueo));
			dto.setObservacionesDesbloqueo(strObservDesbloqueo);
			dto.setUsuarioDesbloqueo(UtilidadesSession.getIdUsuario(this));
			dto.setIndDesbloqueo(Boolean.TRUE);
		}

		pagina("salidaGenerica");

		Vector params = new Vector();
		params.add(dto);
		params.add(new MareBusinessID("MAEGuardarBloqueo"));

		try {
			traza("*** Antes de conectar para guardar");
			DruidaConector conector = conectar("ConectorGuardarBloqueo", params);
			traza("*** Luego de conectar para guardar");
			asignar("VAR", "ejecutar", "fGuardarOK()");
		} catch (Exception e) {
			asignar("VAR", "ejecutarError", "fGuardarError()");
			asignar("VAR", "cerrarVentana", "false");
			throw e;
		}



        traza("*** Entrada - LPBloquearDesbloquearCliente - guardarBloqueo ***");
	}

    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }
    
}

