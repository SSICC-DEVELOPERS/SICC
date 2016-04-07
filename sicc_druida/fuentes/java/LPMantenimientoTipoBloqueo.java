/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.mae.DTOTipoBloqueo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
import java.math.BigDecimal;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

 
public class LPMantenimientoTipoBloqueo extends LPSICCBase {

    private Long oidPais = null;
    private Long oidIdioma = null;
    
    private String opcionMenu = null;
    private String accion = null;
    
    
    public LPMantenimientoTipoBloqueo() {
        super();
    }
    
    
    public void inicio() throws Exception {
        
    }
    
    
    public void ejecucion() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - ejecucion ***");
      
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
                if (opcionMenu.equals("insertar")) {
					this.cargarPGInsertarTipoBloqueo();
				} else if (opcionMenu.equals("consultar") || opcionMenu.equals("modificar") || opcionMenu.equals("eliminar") ) {
					this.cargarPGModificarTipoBloqueo();
				}
            } else if (accion.equals("validarBloqueoFinanciero")) {
                this.validarBloqueoFinanciero();
            } else if (accion.equals("guardar")) {
                this.guardar();
            } else if (accion.equals("detalle")) {
                this.cargarModalDetalle();
            } else if (accion.equals("modificar")) {
				this.cargarModalModificar();
            }
            
        } catch (Exception e) {
            traza(" --- Excepcion - LPMantenimientoTipoBloqueo");
            logStackTrace(e);
            lanzarPaginaError(e);
        }
           
        traza("*** Salida  - LPMantenimientoTipoBloqueo - ejecucion ***");
    }

	private void cargarPGInsertarTipoBloqueo() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - cargarPGInsertarTipoBloqueo ***");

		pagina("contenido_tipos_bloqueo_insertar");
		asignarAtributoPagina("cod", "MaeTipoBloqu.create.label");
		getConfiguracionMenu("LPMantenimientoTipoBloqueo", opcionMenu);
		getFormatosValidaciones();
		cargarCombos();

		asignar("VAR", "pais", this.oidPais.toString());
		asignar("VAR", "idioma", this.oidIdioma.toString());
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcionMenu", this.opcionMenu);

		anyadeHiddensI18N(true, "MAE_TIPO_BLOQU", null, new Integer(1), "formulario", "txtDescripcion", false);

        traza("*** Salida  - LPMantenimientoTipoBloqueo - cargarPGInsertarTipoBloqueo ***");
	}

	private void cargarPGModificarTipoBloqueo() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - cargarPGModificarTipoBloqueo ***");

		pagina("contenido_tipos_bloqueo_modificar");
		getConfiguracionMenu("LPMantenimientoTipoBloqueo", opcionMenu);
		if (opcionMenu.equals("consultar")) {
			asignarAtributoPagina("cod", "MaeTipoBloqu.query.label");
		} else if (opcionMenu.equals("modificar")) {
			asignarAtributoPagina("cod", "MaeTipoBloqu.update.label");
		} else if (opcionMenu.equals("eliminar")) {
			asignarAtributoPagina("cod", "MaeTipoBloqu.remove.label");
		}
		getFormatosValidaciones();

		asignar("VAR", "varPais", this.oidPais.toString());
		asignar("VAR", "varIdioma", this.oidIdioma.toString());
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcionMenu", this.opcionMenu);

		traza("*** Salida  - LPMantenimientoTipoBloqueo - cargarPGModificarTipoBloqueo ***");
	}


	private void cargarModalModificar() throws Exception {
		traza("*** Entrada - LPMantenimientoTipoBloqueo - cargarModalModificar ***");

		// Obtengo las variables para pasar a la modal
		String strOidTipoBloqueo = conectorParametroLimpia("hOidTipoBloqueo", "", true);
		String strCodTipoBloqueo = conectorParametroLimpia("hCodTipoBloqueo", "", true);
		String strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
		String strIndBloqueoFinanciero = conectorParametroLimpia("hIndBloqueoFinanciero", "", true);
		String strOidFormaBloqueo = conectorParametroLimpia("hOidFormaBloqueo", "", true);
		String strOidFormaDesbloqueo = conectorParametroLimpia("hOidFormaDesbloqueo", "", true);
		String strNivelGravedad = conectorParametroLimpia("hNivelGravedad", "", true);
		String strOidMotivoRechazo = conectorParametroLimpia("hOidMotivoRechazo", "", true);

		traza("strOidTipoBloqueo: " + strOidTipoBloqueo);
		traza("strCodTipoBloqueo: " + strCodTipoBloqueo);
		traza("strDescripcion: " + strDescripcion);
		traza("strIndBloqueoFinanciero: " + strIndBloqueoFinanciero);
		traza("strOidFormaBloqueo: " + strOidFormaBloqueo);
		traza("strOidFormaDesbloqueo: " + strOidFormaDesbloqueo);
		traza("strNivelGravedad: " + strNivelGravedad);
		traza("strOidMotivoRechazo: " + strOidMotivoRechazo);

		// Cargo la pagina
		pagina("contenido_tipos_bloqueo_insertar");
		asignarAtributoPagina("cod", "MaeTipoBloqu.update.label");
		getConfiguracionMenu("LPMantenimientoTipoBloqueo", "detalleModificar");
		getFormatosValidaciones();
		cargarCombos();

		// Asigno las variables hidden
		asignar("VAR", "pais", this.oidPais.toString());
		asignar("VAR", "idioma", this.oidIdioma.toString());
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcionMenu", this.opcionMenu);

		asignar("VAR", "hOidTipoBloqueo", strOidTipoBloqueo);
		asignar("VAR", "hCodTipoBloqueo", strCodTipoBloqueo);
		asignar("VAR", "hDescripcion", strDescripcion);
		asignar("VAR", "hIndBloqueoFinanciero", strIndBloqueoFinanciero);
		asignar("VAR", "hOidFormaBloqueo", strOidFormaBloqueo);
		asignar("VAR", "hOidFormaDesbloqueo", strOidFormaDesbloqueo);
		asignar("VAR", "hNivelGravedad", strNivelGravedad);
		asignar("VAR", "hOidMotivoRechazo", strOidMotivoRechazo);

		anyadeHiddensI18N(false, "MAE_TIPO_BLOQU", new Long(strOidTipoBloqueo), new Integer(1),
		                  "formulario", "txtDescripcion", false);

		traza("*** Salida  - LPMantenimientoTipoBloqueo - cargarModalModificar ***");
	}


	private void cargarModalDetalle() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - cargarModalDetalle ***");

		// Obtengo las variables para pasar a la modal
		String strOidTipoBloqueo = conectorParametroLimpia("hOidTipoBloqueo", "", true);
		String strCodTipoBloqueo = conectorParametroLimpia("hCodTipoBloqueo", "", true);
		String strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
		String strIndBloqueoFinanciero = conectorParametroLimpia("hIndBloqueoFinanciero", "", true);
		String strDescFormaBloqueo = conectorParametroLimpia("hDescFormaBloqueo", "", true);
		String strDescFormaDesbloqueo = conectorParametroLimpia("hDescFormaDesbloqueo", "", true);
		String strNivelGravedad = conectorParametroLimpia("hNivelGravedad", "", true);
		String strDescMotivoRechazo = conectorParametroLimpia("hDescMotivoRechazo", "", true);

		traza("strOidTipoBloqueo: " + strOidTipoBloqueo);
		traza("strCodTipoBloqueo: " + strCodTipoBloqueo);
		traza("strDescripcion: " + strDescripcion);
		traza("strIndBloqueoFinanciero: " + strIndBloqueoFinanciero);
		traza("strDescFormaBloqueo: " + strDescFormaBloqueo);
		traza("strDescFormaDesbloqueo: " + strDescFormaDesbloqueo);
		traza("strNivelGravedad: " + strNivelGravedad);
		traza("strDescMotivoRechazo: " + strDescMotivoRechazo);

		// Cargo la pagina
		pagina("contenido_tipos_bloqueo_insertar");
		asignarAtributoPagina("cod", "MaeTipoBloqu.view.label");
		getConfiguracionMenu("LPMantenimientoTipoBloqueo", "detalle");
		getFormatosValidaciones();

		// Asigno las variables hidden
		asignar("VAR", "pais", this.oidPais.toString());
		asignar("VAR", "idioma", this.oidIdioma.toString());
		asignar("VAR", "accion", this.accion);
		asignar("VAR", "opcionMenu", this.opcionMenu);

		asignar("VAR", "hOidTipoBloqueo", strOidTipoBloqueo);
		asignar("VAR", "hCodTipoBloqueo", strCodTipoBloqueo);
		asignar("VAR", "hDescripcion", strDescripcion);
		asignar("VAR", "hIndBloqueoFinanciero", strIndBloqueoFinanciero);
		asignar("VAR", "hDescFormaBloqueo", strDescFormaBloqueo);
		asignar("VAR", "hDescFormaDesbloqueo", strDescFormaDesbloqueo);
		asignar("VAR", "hNivelGravedad", strNivelGravedad);
		asignar("VAR", "hDescMotivoRechazo", strDescMotivoRechazo);

		anyadeHiddensI18N(false, "MAE_TIPO_BLOQU", new Long(strOidTipoBloqueo), new Integer(1),
		                  "formulario", "txtDescripcion", true);

        traza("*** Salida  - LPMantenimientoTipoBloqueo - cargarModalDetalle ***");
	}

	private void cargarCombos() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - cargarCombos ***");

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement element;

		// Para cargar combos cbFormaBloqueo y cbFormaDesbloqueo
		element = new ComposerViewElement();
		element.setIDBusiness("MAEObtenerValoresAccionesBloqueo");
		element.setDTOE(null);
		list.addViewElement(element);

		// Para cargar combo cbMotivoRechazo
		element = new ComposerViewElement();
		element.setIDBusiness("MAEObtenerMotivosRechazo");
		element.setDTOE(null);
		list.addViewElement(element);

		// Conecto...
		ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
		conector.ejecucion();
		traza("*** antes de conectar");    
		DruidaConector drdConector = conector.getConector();
		traza("*** despues de conectar ");

		// ...y seteo los combos
		asignar("COMBO", "cbFormaBloqueo", drdConector, "MAEObtenerValoresAccionesBloqueo");
		asignar("COMBO", "cbFormaDesbloqueo", drdConector, "MAEObtenerValoresAccionesBloqueo");
		asignar("COMBO", "cbMotivoRechazo", drdConector, "MAEObtenerMotivosRechazo");

        traza("*** Salida  - LPMantenimientoTipoBloqueo - cargarCombos ***");
	}
    

	private void validarBloqueoFinanciero() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - validarBloqueoFinanciero ***");

		try {

			pagina("salidaGenerica");

			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais(this.oidPais);
			dtoe.setOidIdioma(this.oidIdioma);

			MareBusinessID id = new MareBusinessID("MAEObtenerBloqueosFinancieros");
			Vector paramsEntrada = new Vector();
			paramsEntrada.add(dtoe); // El metodo a ejecutar no recibe parametros
			paramsEntrada.add(id);

			traza("*** Antes de conectar");
			DruidaConector conector = conectar("ConectorObtenerBloqueosFinancieros", paramsEntrada);
			traza("*** Despues de conectar");
			
			// Verifico si, en el RecordSet recibido, hay un bloqueo financiero que no sea el actual
			DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
			RecordSet rs = dtoSalida.getResultado();
			if (rs.getRowCount() > 0) {

				// Obtengo el OID del tipo de bloqueo actual (si lo hay)
				String strOidActual = conectorParametroLimpia("hOidTipoBloqueo", "", true);
				BigDecimal oidActual = null;
				if (strOidActual != null && strOidActual.length() > 0) {
					oidActual = new BigDecimal(strOidActual);
				}

				boolean yaExisteBloq = false;

				// Recorro el recordset
				for (int i = 0; i < rs.getRowCount(); i++) {
					BigDecimal oid = (BigDecimal)rs.getValueAt(i,0);
					if (oidActual == null || !oid.equals(oidActual)) {
						yaExisteBloq = true;
						break;
					}
				}

				// Si ya hay un bloqueo financiero, mando el mensaje
				if (yaExisteBloq) {
					asignarAtributo("VAR", "ejecutar", "valor", "mostrarMsjExisteBloqFinanciero()");
				}
			}

			if (opcionMenu.equals("modificar")) {
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");
			}

		} catch (Exception e) {
			preservaHiddensI18n(new Integer(1), "MAE_TIPO_BLOQU", "formulario", "txtDescripcion", false);
			throw e;
		}


        traza("*** Salida  - LPMantenimientoTipoBloqueo - validarBloqueoFinanciero ***");
	}


	private void guardar() throws Exception {
        traza("*** Entrada - LPMantenimientoTipoBloqueo - guardar ***");

		pagina("salidaGenerica");

		// Obtengo datos para guardar
		String strOid = conectorParametroLimpia("hOidTipoBloqueo", "", true);
		String strCodigo = conectorParametroLimpia("hCodTipoBloqueo", "", true);
		String strDescripcion = conectorParametroLimpia("hDescripcion", "", true);
		String strIndBloqFina = conectorParametroLimpia("hIndBloqueoFinanciero", "", true);
		String strNivelGravedad = conectorParametroLimpia("hNivelGravedad", "", true);
		String strOidMotivoRechazo = conectorParametroLimpia("hOidMotivoRechazo", "", true);
		String strOidValorAccionBloqueo = conectorParametroLimpia("hOidFormaBloqueo", "", true);
		String strOidValorAccionDesbloqueo = conectorParametroLimpia("hOidFormaDesbloqueo", "", true);

		// Armo el DTO
		DTOTipoBloqueo dto = new DTOTipoBloqueo();
		if (strOid.length() > 0) {
			dto.setOid(new Long(strOid));
		}
		dto.setCodigo(strCodigo);
		dto.setDescripcion(strDescripcion);
		if (strIndBloqFina.length() > 0) {
			if (strIndBloqFina.equals("S")) {
				dto.setIndBloqueoFinanciero(Boolean.TRUE);
			} else if (strIndBloqFina.equals("N")) {
				dto.setIndBloqueoFinanciero(Boolean.FALSE);
			}
		}
		dto.setNivelGravedad(new Integer(strNivelGravedad));
		dto.setOidMotivoRechazo(new Long(strOidMotivoRechazo));
		dto.setOidValorAccionBloqueo(new Long(strOidValorAccionBloqueo));
		dto.setOidValorAccionDesbloqueo(new Long(strOidValorAccionDesbloqueo));

		Vector traducciones = recuperaTraduccionesI18N(new Integer(1));
		if (opcionMenu.equals("insertar")) {
			traducciones = quitarTraduccionesEnBlanco(traducciones);
		}
		dto.setAttTraducible(traducciones);

		// Guardo
		try {
			MareBusinessID businessID = new MareBusinessID("MAEGuardarTipoBloqueo");

			Vector parametros = new Vector();
			parametros.add(dto);  
			parametros.add(businessID);
			
			conectar("ConectorGuardarTipoBloqueo", parametros);
			asignarAtributo("VAR", "ejecutar", "valor", "guardoCorrectamente()");
			if (opcionMenu.equals("modificar")) {
						asignarAtributo("VAR", "cerrarVentana", "valor", "true");
			}

		} catch (Exception e) {
			preservaHiddensI18n(new Integer(1), "MAE_TIPO_BLOQU", "formulario", "txtDescripcion", false);
			throw e;
		}

        traza("*** Salida  - LPMantenimientoTipoBloqueo - guardar ***");
	}
   
    /**
     * Limpieza de descripciones internacionalizables en blanco. Quitamos los
     * dto de los idiomas que no tienen una descripcion para que no se
     * inserte en blanco ya que sino no funciona la recuperacion de la
     * descripcion por defecto cuando no se guardo una alternativa.
     */
    private Vector quitarTraduccionesEnBlanco(Vector traducciones) throws Exception {
            ArrayList traduccionesEnBlanco = new ArrayList();
            traza(" traducciones antes_" + traducciones);
            
            Iterator iter = traducciones.iterator();
            
            while (iter.hasNext()) {
                DTOI18nSICC i18n = (DTOI18nSICC) iter.next();
                String descripcionI18n = (String)i18n.getValorI18n();
                
                if (descripcionI18n == null || descripcionI18n.equals(" ")) {
                    traduccionesEnBlanco.add(i18n);
                }
            }
            traducciones.removeAll(traduccionesEnBlanco);
            traza(" traducciones despues_" + traducciones);
            return traducciones;
    }
    
    
    private String getDescripcionI18N(Vector vec, Long idioma) throws Exception {
        Iterator iter = vec.iterator();

        while (iter.hasNext()) {
            DTOI18nSICC dtoI18 = (DTOI18nSICC)iter.next();
            
            if (dtoI18.getOidIdioma().equals(idioma)) {
                return dtoI18.getValorI18n();
            }
        }
        return "";
    }
    
    
    private void logStackTrace(Throwable e) throws Exception {
        traza(" --- Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza(" --- Stack Trace: " + baos.toString());
    }
    
}

