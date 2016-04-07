/**
 * Sistema:     Belcorp
 * Modulo:      MAV
 * Fecha:       10/08/2004
 * @version     2.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */
//import LPSICCBase;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.dtos.mav.DTOLineaCombo;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;


public class LPMantenimientoActividadesMAV extends LPSICCBase {

	private String accion;
	private String casoDeUso;
	private Long oidI18N;
	
	public LPMantenimientoActividadesMAV() {
		super();
	}

	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();

		accion = conectorParametroLimpia("accion", "", true);
		casoDeUso = conectorParametroLimpia("casodeuso", "", true);
		traza("Accion: " + accion + ", CasoDeUso: " + casoDeUso);
		try{
			if( accion.equals("consultar") ){
				cargaPaginaBuscar();
				if( casoDeUso.equals("eliminar") ){
					traza("Actualizando menu a eliminar");
					getConfiguracionMenu("LPMantenimientoActividadesMAV", "eliminar");
					asignarAtributoPagina("cod", "093");
				}
				if( casoDeUso.equals("consultar") ){
					getConfiguracionMenu("LPMantenimientoActividadesMAV", "consultar");
					asignarAtributoPagina("cod", "092");
					traza("Actualizando menu a consultar");
				}
				if( casoDeUso.equals("modificar") ){
					getConfiguracionMenu("LPMantenimientoActividadesMAV", "buscar/modificar");
					asignarAtributoPagina("cod", "091");
					traza("Actualizando menu a buscar/modificar");
				}
			}
			if( accion.equals("detalle") ){
				traza("Entro en detalle");
				cargaPaginaInsertar();
				//traza("EL OID ES: " + oidI18N.toString());
				this.anyadeHiddensI18N(true, "MAV_ACTIV", oidI18N, new Integer(1), "frmInsertarActividades", "txtDescripcionActividad", true);
				getConfiguracionMenu("LPMantenimientoActividadesMAV", "detalle");
				asignarAtributoPagina("cod", "092");
				traza("Actualizando menu a detalle");
			}
			if( accion.equals("insertar") ){
				cargaPaginaInsertar();
				anyadeHiddensI18N(false, "MAV_ACTIV", oidI18N, new Integer(1), "frmInsertarActividades", "txtDescripcionActividad", false);
				getConfiguracionMenu("LPMantenimientoActividadesMAV", "insertar");
				asignarAtributoPagina("cod", "050");
				traza("Actualizando menu a insertar");
			}
			if( accion.equals("modificar") ){
				cargaPaginaInsertar();
				anyadeHiddensI18N(true, "MAV_ACTIV", oidI18N, new Integer(1), "frmInsertarActividades", "txtDescripcionActividad", false);
				getConfiguracionMenu("LPMantenimientoActividadesMAV", "modificar");
				asignarAtributoPagina("cod","091");
				traza("Actualizando menu a modificar");
			}
			if( accion.equals("guardar") ){
				traza("Procedo a guardar la actividad");
				guardar();
				/*
				 * 23024 - dmorello, 08/05/2006
				 * Si el CU es insertar, se limpiarán los datos simulando la recarga de página
				 */
				if (casoDeUso.equals("insertar")) {
					traza("casoDeUso es insertar, entra al IF");
					asignarAtributo("VAR", "accion", "valor", "insertar");
					this.limpiarDatos();
				} else {
					traza("casoDeUso es distinto de insertar, entra al ELSE");
					asignarAtributo("VAR", "cerrarVentana", "valor", "true");
					asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
				}
			}
		} catch(Exception e){
			e.printStackTrace();
			lanzarPaginaError(e);
		}
	}

	private void cargaPaginaInsertar() throws Exception{	
		traza("Entro en cargaPaginaInsertar");
		DTOActividadMAV dtoActividad = null;
		// -> Asignar página "contenido_actividades_insertar" 
		pagina("contenido_actividades_insertar_mav");
		this.getFormatosValidaciones();
		asignar("VAR", "casodeuso", casoDeUso);
		asignar("VAR", "accion", accion);
		asignar("VAR", "oidIdioma", UtilidadesSession.getIdioma(this).toString());
		asignar("VAR", "oidPais", UtilidadesSession.getPais(this).toString());

		// Si el caso de uso es inserción o modificación se cargan los combos, si no los combos se cargan con los datos recuperados 
		// Si (casodeuso = "insertar" ó "modificar") entonces 
		if( casoDeUso.equals("insertar") || casoDeUso.equals("modificar") ){
			// -> Crear objeto DTOBelcorp 
			DTOBelcorp dto = new DTOBelcorp();
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			dto.setOidPais(UtilidadesSession.getPais(this));
			asignar("VAR", "oidIdioma", UtilidadesSession.getIdioma(this).toString());
			asignar("LABELC", "lbldtPais", UtilidadesSession.getDescripcionPais(this));
			
			// -> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
			ComposerViewElement c1 = new ComposerViewElement();
			ComposerViewElementList compList = new ComposerViewElementList();			
			// - idBusiness "SEGConsultaMarcas" => llena combo "marca" 
			c1.setIDBusiness("SEGConsultaMarcas");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "SEGConsultaCanales" y "DTOBelcorp" => llena combo "canal" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("SEGConsultaCanales");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAEObtenerTipos" y "DTOBelcorp" => llena combo "tipoCliente" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAEObtenerTipos");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "PREObtenerCiclosVida" y "DTOBelcorp" => llena combo "cicloVida" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("PREObtenerCiclosVida");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAVObtenerTiposDespacho" => llena combo "tiposDespacho" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAVObtenerTiposDespacho");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAVObtenerEnvioConSolicitud" => llena combo "envioConSolicitud" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAVObtenerEnvioConSolicitud");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAVObtenerEstadosMAV" y "DTOBelcorp" => llena combo "estado" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAVObtenerEstadosMAV");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAVObtenerTiposCondicionPago" => llena combo "condicionPago" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAVObtenerTiposCondicionPago");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "BELFormasPagoPais" y "DTOBelcorp" => llema combo "formaPago" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("BELFormasPagoPais");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "MAVObtenerCriteriosAsignacion" => llena combo "criterioAsignacion" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("MAVObtenerCriteriosAsignacion");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			// - idBusiness "SEGObtenerEmpresasPorPais" y "DTOBelcorp" => llena combo "razonSocialQueFactura" 
			c1 = new ComposerViewElement();
			c1.setIDBusiness("SEGObtenerEmpresasPorPais");
			c1.setDTOE(dto);
			compList.addViewElement(c1);
			
			ConectorComposerView conector = new ConectorComposerView(compList, this.getRequest());
			conector.ejecucion();
			DruidaConector resultados = conector.getConector();
			asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
			asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
			asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipos");
			asignar("COMBO", "cbCicloVida", resultados, "PREObtenerCiclosVida");
			asignar("COMBO", "cbTipoDespacho", resultados, "MAVObtenerTiposDespacho");
			asignar("COMBO", "cbEnvioSolicitud", resultados, "MAVObtenerEnvioConSolicitud");
			asignar("COMBO", "cbEstado", resultados, "MAVObtenerEstadosMAV");
			asignar("COMBO", "cbCondicionPago", resultados, "MAVObtenerTiposCondicionPago");
			asignar("COMBO", "cbFormaPago", resultados, "BELFormasPagoPais");
			asignar("COMBO", "cbCriterioAsignacion", resultados, "MAVObtenerCriteriosAsignacion");
			asignar("COMBO", "cbRazonSocialFactura", resultados, "SEGObtenerEmpresasPorPais");
			// -> Mapear los campos ocultos de pantalla "operacionMAV012" y 
			// "operacionMAV023" con los valores de las constantes ConstantesBEL.MAV012 
			// y ConstantesBEL.MAV023 respectivamente. 
			asignar("VAR", "operacionMAV012", ConstantesBEL.MAV012.toString());
			asignar("VAR", "operacionMAV023", ConstantesBEL.MAV023.toString());
			// Se reemplazará por ConstantesBEL una vez que se responda la inicidencia 7534
//			asignar("VAR", "operacionMAV012", "12");
//			asignar("VAR", "operacionMAV023", "27");
			
			//recuperamos el oid Forma Pago Gratis 
			DTOBelcorp dtox = new DTOBelcorp();
			dtox.setOidIdioma(UtilidadesSession.getIdioma(this));
			dtox.setOidPais(UtilidadesSession.getPais(this));

			// sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
			MareBusinessID bizId = new MareBusinessID("BELFormasPagoPais");
			Vector params = new Vector();
		    params.addElement( dtox );  
		    params.addElement( bizId ); 
		    DruidaConector dc  = conectar( "ConectorObtenerDatosPeriodo" , params );
		    DTOSalida dtoSalida = (DTOSalida)dc.objeto("rsSalida");
			String oidFormaPagoGratis = this.obtieneFormaPagoGratis(dtoSalida);
			asignar("VAR", "oidFormaPagoGratis", oidFormaPagoGratis);
		}
		
		// -> Tomar el valor del parámetro http "casodeuso" 
		// Si el caso de uso es consulta, modificación o eliminación se recuperan los datos de la actividad seleccionada 
		// Si (casodeuso = "consultar", "modificar" ó "eliminar") entonces 
		traza("En cargaPaginaInsertar con caso de uso: " + casoDeUso);

		if( casoDeUso.equals("consultar") || casoDeUso.equals("modificar") || casoDeUso.equals("eliminar") ){
			
			// -> Tomar de la pantalla llamante el oid del registro seleccionado 
			traza("Obteniendo seleccion");
			String seleccion = conectorParametro("seleccion");
			traza("seleccion: " + seleccion);
			// -> Crear objeto DTOOID 
			DTOOID dto = new DTOOID();
			dto.setOid(new Long(seleccion));
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			dto.setOidPais(UtilidadesSession.getPais(this));
			// -> Crear idBusiness = "MAVConsultarActividad" 
			MareBusinessID businessId = new MareBusinessID("MAVConsultarActividad");
			Vector parametros = new Vector();
			parametros.add(dto);
			parametros.add(businessId);
			// -> Asignar conector "ConectorConsultarActividadMAV" 
			DruidaConector conector = conectar("ConectorConsultarActividadMAV",	parametros);
			traza("Conecto.");
			// -> Recuperar objeto "DTOActividadMAV" de salida 
			dtoActividad = (DTOActividadMAV)conector.objeto("DTOActividadMAV");
			traza("Retorno DTOActividad");
			oidI18N = dtoActividad.getOidActividad();
			// Fin Si 
			traza("##### SETEANDO VARIABLES OCULTAS DE LA PÁGINA #####");
			traza("dto: "+dtoActividad);
			
			if( dtoActividad.getDescripcionPais() != null ){
				asignar("LABELC", "lbldtPais", dtoActividad.getDescripcionPais());
			}

			if( dtoActividad.getOidActividad() != null ){
				asignar("LABELC", "lbldtCodActividad", dtoActividad.getOidActividad().toString());
				asignar("VAR", "oidActividad", dtoActividad.getOidActividad().toString());
			}

			if( dtoActividad.getDescripcion() != null ){
				asignar("CTEXTO", "txtDescripcionActividad", dtoActividad.getDescripcion());
			}

			if( dtoActividad.getDescripcionDetallada() != null ){
				traza("descripcion detallada: "+dtoActividad.getDescripcionDetallada());
				asignar("AREATEXTO", "areatxtObservaciones", dtoActividad.getDescripcionDetallada());
			}

			if( dtoActividad.getOidMarca() != null ){
				asignar("VAR", "marca", dtoActividad.getOidMarca().toString());
			}
			if( dtoActividad.getOidCanal() != null ){
				asignar("VAR", "canal", dtoActividad.getOidCanal().toString());
			}

			if( dtoActividad.getOidTipoCliente() != null ){
				asignar("VAR", "tipoCliente", dtoActividad.getOidTipoCliente().toString());
			}

			armarDataCombo("tipoOferta", dtoActividad.getTipoOferta());

//			traza("" + dtoActividad.getCicloVida());
			armarDataCombo("cicloVida", dtoActividad.getCicloVida());

			armarDataCombo("tipoDespacho", dtoActividad.getTipoDespacho());
			if( dtoActividad.getOidEnvioConSolicitud() != null ){
				asignar("VAR", "envioConSolicitud", dtoActividad.getOidEnvioConSolicitud().toString());
			}

			armarDataCombo("tipoSolicitudOrigen", dtoActividad.getTipoSolicitudOrigen());

			traza("Tipo Solicitud Destino: " + dtoActividad.getOidTipoSolicitudDestino() );
			if( dtoActividad.getOidTipoSolicitudDestino() != null ){
				asignar("VAR", "tipoSolicitudDestino", dtoActividad.getOidTipoSolicitudDestino().toString());
			}

			traza("Tipo Posicion Envio: " + dtoActividad.getOidTipoPosicionEnvio() );
			if( dtoActividad.getOidTipoPosicionEnvio() != null ){
				asignar("VAR", "tipoPosicionEnvio", dtoActividad.getOidTipoPosicionEnvio().toString());
			}

			if( dtoActividad.getOidSubtipoPosicionEnvio() != null ){
				asignar("VAR", "subtipoPosicionEnvio", dtoActividad.getOidSubtipoPosicionEnvio().toString());
			}

			armarDataCombo("subtipoCliente", dtoActividad.getSubtipoCliente());

			armarDataCombo("estados", dtoActividad.getEstado());

			traza("TipoCondicionPago: " + dtoActividad.getOidTipoCondicionPago());
			if( dtoActividad.getOidTipoCondicionPago() != null ){
				asignar("VAR", "condicionPago", dtoActividad.getOidTipoCondicionPago().toString());
			}
			if( dtoActividad.getOidFormaPago() != null ){
				asignar("VAR", "formaPago", dtoActividad.getOidFormaPago().toString());
			}
	
			armarDataCombo("criterioAsignacion", dtoActividad.getCriterioAsignacion());
	
			if( dtoActividad.getCampagnaEvaluacion() != null ){
				asignar("VAR", "campagnaEvaluacion", dtoActividad.getCampagnaEvaluacion().toString());
			}
	
			if( dtoActividad.getFacturaIntercompanias() != null ){
				asignar("VAR", "isFacturaIntercompanias", dtoActividad.getFacturaIntercompanias().toString());
			}
	
			if( dtoActividad.getCosto() != null ){
				asignar("CTEXTO", "txtCosto", dtoActividad.getCosto().toString());
			}
			
			if( dtoActividad.getOidEmpresa() != null ){
				asignar("VAR", "razonSocialQueFactura", dtoActividad.getOidEmpresa().toString());
			}
	
			if( dtoActividad.getCodigoCliente() != null ){
				traza(">>>>> CodigoCliente: " + dtoActividad.getCodigoCliente());
				Long codigo = new Long(dtoActividad.getCodigoCliente());
				traza(">>>>> - CodigoCliente: " + codigo.toString());
				asignar("CTEXTO", "txtRazonSocialF", codigo.toString());
			}

			if( dtoActividad.getOidTipoSolicitudParaPago() != null ){
				asignar("VAR", "tipoSolicitudParaPago", dtoActividad.getOidTipoSolicitudParaPago().toString());
			}

			if( dtoActividad.getOidTipoPosicionParaPago() != null ){
				asignar("VAR", "tipoPosicionParaPago", dtoActividad.getOidTipoPosicionParaPago().toString());
			}

			if( dtoActividad.getOidSubtipoPosicionParaPago() != null ){
				asignar("VAR", "subtipoPosicionPago", dtoActividad.getOidSubtipoPosicionParaPago().toString());
			}

			if( casoDeUso.equals("consultar") || casoDeUso.equals("eliminar") || casoDeUso.equals("detalle") ){
				traza("Seteando valores a la página");
				// Si no entonces 
				// -> Cargar los combos con la información recuperada en el objeto DTOActividadMAV que contiene los siguientes campos 
				if( dtoActividad.getDescripcionPais() != null ){
					asignar("LABELC", "lbldtPais", dtoActividad.getDescripcionPais());
				}

				if( dtoActividad.getOidActividad() != null ){
					asignar("LABELC", "lbldtCodActividad", dtoActividad.getOidActividad().toString());
				}

				if( dtoActividad.getDescripcion() != null ){
					asignar("CTEXTO", "txtDescripcionActividad", dtoActividad.getDescripcion());
				}

				if( dtoActividad.getDescripcionDetallada() != null ){
					asignar("AREATEXTO", "areatxtObservaciones", dtoActividad.getDescripcionDetallada());
				}

				traza("Marca: " + dtoActividad.getOidMarca() + ", " + dtoActividad.getDescripcionMarca());
				cargaCombo("cbMarca", dtoActividad.getOidMarca(), dtoActividad.getDescripcionMarca());

				cargaCombo("cbCanal", dtoActividad.getOidCanal(), dtoActividad.getDescripcionCanal());

				cargaCombo("cbTipoCliente", dtoActividad.getOidTipoCliente(), dtoActividad.getDescripcionTipoCliente());

				cargaCombo("cbTipoOferta", dtoActividad.getTipoOferta());

				cargaCombo("cbCicloVida", dtoActividad.getCicloVida());

				cargaCombo("cbTipoDespacho", dtoActividad.getTipoDespacho());

				cargaCombo("cbEnvioSolicitud", dtoActividad.getOidEnvioConSolicitud(), dtoActividad.getDescripcionEnvioConSolicitud() );

				cargaCombo("cbTipoSolicitudOrigen", dtoActividad.getTipoSolicitudOrigen());			

				cargaCombo("cbTipoSolicitudDestino", dtoActividad.getOidTipoSolicitudDestino(), dtoActividad.getDescripcionTipoSolicitudDestino());

				cargaCombo("cbTipoPosicionEnvio", dtoActividad.getOidTipoPosicionEnvio(), dtoActividad.getDescripcionTipoPosicionEnvio());

				cargaCombo("cbSubtipoPosicionEnvio", dtoActividad.getOidSubtipoPosicionEnvio(), dtoActividad.getDescripcionSubtipoPosicionEnvio());

				cargaCombo("cbSubtipoCliente", dtoActividad.getSubtipoCliente());

				cargaCombo("cbEstado", dtoActividad.getEstado());

				cargaCombo("cbCondicionPago", dtoActividad.getOidTipoCondicionPago(), dtoActividad.getDescripcionTipoCondicionPago());

				cargaCombo("cbFormaPago", dtoActividad.getOidFormaPago(), dtoActividad.getDescripcionFormaPago());

				cargaCombo("cbCriterioAsignacion", dtoActividad.getCriterioAsignacion());

				if( dtoActividad.getCampagnaEvaluacion() != null )
					asignar("VAR", "campagnaEvaluacion", dtoActividad.getCampagnaEvaluacion().toString());

				traza("Boolean: " + dtoActividad.getFacturaIntercompanias());
				if( dtoActividad.getFacturaIntercompanias() != null )
					asignar("VAR", "isFacturaIntercompanias", dtoActividad.getFacturaIntercompanias().toString());

				if( dtoActividad.getCosto() != null )
					asignar("CTEXTO", "txtCosto", dtoActividad.getCosto().toString());

				cargaCombo("cbRazonSocialFactura", dtoActividad.getOidEmpresa(), dtoActividad.getDescripcionEmpresa());

				if( dtoActividad.getOidCliente() != null )
					asignar("VAR", "oidCliente", dtoActividad.getOidCliente().toString());

/*				if( dtoActividad.getCodigoCliente() != null ){
					Long codigo = new Long(dtoActividad.getCodigoCliente());
					asignar("CTEXTO", "txtRazonSocialF", codigo.toString());
				}*/

				cargaCombo("cbTipoSolicitudPago", dtoActividad.getOidTipoSolicitudParaPago(), dtoActividad.getDescripcionTipoSolicitudParaPago());

				cargaCombo("cbTipoPosicionPago", dtoActividad.getOidTipoPosicionParaPago(), dtoActividad.getDescripcionTipoPosicionParaPago());

				cargaCombo("cbSubtipoPosicionPago", dtoActividad.getOidSubtipoPosicionParaPago(), dtoActividad.getDescripcionSubtipoPosicionParaPago());
				traza("Todo seleteado");
			}

		}
		
		
		// Fin Si 
		// Si (casodeuso = "consultar" ó "eliminar") entonces 
		// -> Sólo se permite la consulta, porque se trata de un detalle de la actividad 
		// -> Se muestra la información y se deshabilitan todos los campos 
		// Si no entonces 
		// -> Se deja que el usuario pueda modificar los campos que desee 
		// Fin Si 
		// ESTO ÚLTIMO SE RESOLVERA POR MEDIO DE JAVASCRIPT DESDE LA PÁGINA
	}

	private void cargaPaginaBuscar() throws Exception{
		// -> Asignar pantalla "contenido_actividades_consultar" y presentar vacía 
		pagina("contenido_actividades_consultar_mav");
		this.getFormatosValidaciones();
		// -> Crear objeto DTOBelcorp introduciendo pais e idioma de la sesión 
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		dto.setOidPais(UtilidadesSession.getPais(this));
		// -> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
		// - idBusiness "SEGConsultaMarcas" => llena combo "marca" 
		// - idBusiness "SEGConsultaCanales" y "DTOBelcorp" => llena combo "canal" 
		ComposerViewElement c1 = new ComposerViewElement();
        ComposerViewElementList compList = new ComposerViewElementList();
        c1.setIDBusiness("SEGConsultaCanales");
        c1.setDTOE(dto);
        compList.addViewElement(c1);

		ComposerViewElement c2 = new ComposerViewElement();
		c2.setIDBusiness("SEGConsultaMarcas");
		c2.setDTOE(dto);
		compList.addViewElement(c2);
		
		ConectorComposerView conector = new ConectorComposerView(compList,
                this.getRequest());
        conector.ejecucion();

        DruidaConector resultados = conector.getConector();
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		// -> Tomar el valor del parámetro http "casodeuso" 
		// Si (casodeuso = "consultar" ó "eliminar") entonces 
		// -> mostrar el botón "detalle" y ocultar el botón "modificar" 
		// Si no entonces 
		// -> ocultar el botón "detalle" y mostrar el botón "modificar" 
		// Fin Si
		// ESTO SE HARÁ POR MEDIO DE JAVASCRIPT EN LA PÁGINA
		asignarAtributo("VAR", "casodeuso", "valor", casoDeUso);
		asignarAtributo("VAR", "accion", "valor", accion);
	}

	private void guardar() throws Exception{
		DTOActividadMAV dtoActiv = new DTOActividadMAV();
        String datosCombo = null;
		Vector vecOids = new Vector();
		
		pagina("salidaGenerica");
		asignarAtributo("VAR", "cerrarVentana", "valor", "false");

		traza("*** Datos capturados de la página ***");

        dtoActiv.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
        dtoActiv.setPrograma(UtilidadesSession.getFuncion(this));

		datosCombo = conectorParametroLimpia("oidIdioma", "", true);
		dtoActiv.setOidIdioma(new Long(datosCombo));
		traza("Oid Idioma: " + dtoActiv.getOidIdioma());

		datosCombo = conectorParametroLimpia("oidPais", "", true);
        dtoActiv.setOidPais(new Long(datosCombo));
        traza("Oid Pais: " + dtoActiv.getOidPais());
		
		datosCombo = conectorParametroLimpia("oidActividad", "", true);
		if( !datosCombo.equals("") ){
			traza("codActividad: " + datosCombo);
			dtoActiv.setOidActividad(new Long(datosCombo));
		}

		datosCombo = conectorParametroLimpia("txtDescripcionActividad", "", true);
		if( !datosCombo.equals("") ){
			Vector descripciones = this.recuperaTraduccionesI18N(new Integer(1));

			traza("<<<<<< Descripciones Guardadas >>>>>>");
			Iterator it = descripciones.iterator();
			DTOI18nSICC dtoI18n = null;
			String descripcion = null;
			while(it.hasNext()){
				dtoI18n = (DTOI18nSICC)it.next();
				// Elimino traducciones en blanco
				descripcion = dtoI18n.getValorI18n();
				if (descripcion != null && descripcion.length() > 0) {
					traza("        Idioma:   " + dtoI18n.getOidIdioma());
					traza("        Atributo: " + dtoI18n.getOidAtriuto());
					traza("        Valor   : " + dtoI18n.getValorI18n());
					traza("-----------------------------------------");
				} else {
					it.remove();
				}
			}

			dtoActiv.setAttTraducible(descripciones);
		}

        datosCombo = conectorParametroLimpia("areatxtObservaciones", "", true);
        traza("Descripcion detallada: " + datosCombo);
        dtoActiv.setDescripcionDetallada(datosCombo);

		datosCombo = conectorParametroLimpia("cbMarca", "", true);
		traza("Marca: " + datosCombo);
		dtoActiv.setOidMarca(new Long(datosCombo));
	
		datosCombo = conectorParametroLimpia("cbCanal", "", true);
		traza("Canal: " + datosCombo);
		dtoActiv.setOidCanal(new Long(datosCombo));	

        datosCombo = conectorParametroLimpia("cbTipoCliente", "", true);
        traza("Tipo Cliente: " + datosCombo);
		dtoActiv.setOidTipoCliente(new Long(datosCombo));

        datosCombo = conectorParametroLimpia("cbTipoOferta", "", true);
        vecOids = parseaDatosCombo(datosCombo);
        traza("Tipo oferta: " + datosCombo);
        dtoActiv.setTipoOferta(vecOids);

        datosCombo = conectorParametroLimpia("cbCicloVida", "", true);
        vecOids = parseaDatosCombo(datosCombo);
		traza("Ciclo vida: " + datosCombo);
        dtoActiv.setCicloVida(vecOids);

        datosCombo = conectorParametroLimpia("cbTipoDespacho", "", true);
        vecOids = parseaDatosCombo(datosCombo);
        traza("Tipo Despacho: " + datosCombo);
        dtoActiv.setTipoDespacho(vecOids);

    
		//datosCombo = conectorParametroLimpia("cbTipoSolicitudOrigen", "", true);
    datosCombo = conectorParametroLimpia("tipoSolicitudOrigen", "", true);
		if( !datosCombo.equals("") )
    {
      traza("TipoSolicitudOrigen: " + datosCombo);
			vecOids = parseaDatosCombo(datosCombo);
			//traza("Tipo Origen: " + datosCombo);
      traza("Tipo Origen Vector:  " + vecOids);
			dtoActiv.setTipoSolicitudOrigen(vecOids);
		}
				
		datosCombo = conectorParametro("cbTipoSolicitudDestino");
		if( !datosCombo.equals("") ){
			traza("Tipo solicitud destino: " + datosCombo);
			dtoActiv.setOidTipoSolicitudDestino(new Long(datosCombo));
		}

        datosCombo = conectorParametroLimpia("cbEnvioSolicitud", "", true);
		if (!datosCombo.equals("")) {
            traza("Envio con solicitud: " + datosCombo);
            dtoActiv.setOidEnvioConSolicitud(new Long(datosCombo));
        }

		datosCombo = conectorParametroLimpia("cbTipoPosicionEnvio", "", true);
		if (!datosCombo.equals("")) {
            traza("Tipo posicion envio: " + datosCombo);
            dtoActiv.setOidTipoPosicionEnvio(new Long(datosCombo));
        }

		datosCombo = conectorParametroLimpia("cbSubtipoPosicionEnvio", "", true);
		if (!datosCombo.equals("")) {
            traza("Subtipo posicion envio: " + datosCombo);
            dtoActiv.setOidSubtipoPosicionEnvio(new Long(datosCombo));
        }		

        // 23115 - dmorello, 09/05/2006: Paso a tomar los subtipos de un VAR que los contiene
		datosCombo = conectorParametroLimpia("subtiposCliente", "", true);
		traza("subtiposCliente: " + datosCombo);
		if( !datosCombo.equals("") ){
			vecOids = parseaDatosCombo(datosCombo);
			dtoActiv.setSubtipoCliente(vecOids);
		}

        datosCombo = conectorParametroLimpia("cbEstado", "", true);
		if( !datosCombo.equals("") ){
	        vecOids = parseaDatosCombo(datosCombo);
		    traza("Estados: " + datosCombo);
			dtoActiv.setEstado(vecOids);
		}

        datosCombo = conectorParametroLimpia("cbCondicionPago", "", true);
		traza("Condición pago: " + datosCombo);
        dtoActiv.setOidTipoCondicionPago(new Long(datosCombo));
		
        datosCombo = conectorParametroLimpia("cbFormaPago", "", true);
        traza("Forma pago: " + datosCombo);
        // Modific x ssantana, 25/11/2004 - Se necesita ahora validar si forma de
        // pago fue seleccionado (ya que con "Gratis" este campo no se selecciona)
        // Por eso el If siguiente que chequea si es "" o null.
        if (datosCombo == null || datosCombo.equals("") )
          dtoActiv.setOidFormaPago(null);
        else
          dtoActiv.setOidFormaPago(new Long(datosCombo));
		
	    datosCombo = conectorParametroLimpia("cbCriterioAsignacion", "", true);
		if( !datosCombo.equals("") ){
	        vecOids = parseaDatosCombo(datosCombo);
			traza("Criterios Asignación: " + datosCombo);
			dtoActiv.setCriterioAsignacion(vecOids);
		}

		datosCombo = conectorParametroLimpia("cbCampana", "", true);
        traza("Valor original campaña: " + datosCombo);
		Integer auxInt = null;
        if (datosCombo.charAt(0) == '+') {
            traza("Con +");
            auxInt = new Integer(datosCombo.charAt(1) - '0');
            traza("Casteado a: " + auxInt);
        } else {
            traza("Es 0 o -");
            auxInt = new Integer(datosCombo);
        }
        traza("Campaña: " + auxInt);
        dtoActiv.setCampagnaEvaluacion(auxInt);

        datosCombo = conectorParametroLimpia("FacturaIntercompanias", "", true);
		if( !datosCombo.equals("") ){
			Boolean facturaInter = new Boolean(datosCombo.equals("S") ||
					datosCombo.equals("s"));
			dtoActiv.setFacturaIntercompanias(facturaInter);
		}

        datosCombo = conectorParametroLimpia("txtCosto", "", true);
		if( !datosCombo.equals("") ){
		    traza("Costo: " + datosCombo);
	        dtoActiv.setCosto(new Integer(datosCombo));
		}

		datosCombo = conectorParametroLimpia("cbRazonSocialFactura", "", true);
		if( !datosCombo.equals("") ){
			traza("Empresa: " + datosCombo);
			dtoActiv.setOidEmpresa(new Long(datosCombo));
		}

		datosCombo = conectorParametroLimpia("oidCliente", "", true);
		if( !datosCombo.equals("") ){
			traza("OidCliente: " + datosCombo);
			dtoActiv.setOidCliente(new Long(datosCombo));
		}

		datosCombo = conectorParametroLimpia("txtRazonSocialF", "", true);
		if( !datosCombo.equals("") ){
			traza("Razon Social Facturada: " + datosCombo);
			dtoActiv.setCodigoCliente(datosCombo);
		}

        datosCombo = conectorParametroLimpia("cbTipoSolicitudPago", "", true);
		if( !datosCombo.equals("") ){
			traza("Tipo solicitud pago: " + datosCombo);
			dtoActiv.setOidTipoSolicitudParaPago(new Long(datosCombo));
		}
		
        datosCombo = conectorParametroLimpia("cbTipoPosicionPago", "", true);
		if( !datosCombo.equals("") ){
			traza("Tipo Posicion pago: " + datosCombo);
			dtoActiv.setOidTipoPosicionParaPago(new Long(datosCombo));
		}

		datosCombo = conectorParametroLimpia("cbSubtipoPosicionPago", "", true);
		if( !datosCombo.equals("") ){
			traza("Subtipo posicion pago: " + datosCombo);
			dtoActiv.setOidSubtipoPosicionParaPago(new Long(datosCombo));
		}
		

        MareBusinessID businessID = new MareBusinessID("MAVGuardarActividad");
        Vector parametros = new Vector();
        parametros.add(dtoActiv);
        parametros.add(businessID);
        traza("Conectando a ConectorGuardarActividadMAV");

        DruidaConector conector = conectar("ConectorGuardarActividadMAV",  parametros);
        traza("Guardado.");		
		datosCombo = conectorParametro("casodeuso");
		traza("Caso de uso: " + datosCombo);
 }


    // Carga un Vector con las selecciones de un combo multiselección.
    private Vector parseaDatosCombo(String datosCombo) {
		Vector vecOids = new Vector();
		//DTOLineaCombo dto = null;
        StringTokenizer strTokens = new StringTokenizer(datosCombo, "|");

        while ( strTokens.hasMoreTokens() )
        {
          DTOLineaCombo	dto = new DTOLineaCombo();
          dto.setOid(new Long(strTokens.nextToken()));
          vecOids.add(dto);
        }
		
        return vecOids;
    }


	private void cargaCombo(String combo, Long oid, String descripcion) throws Exception {
		RecordSet rs = new RecordSet();
		String [] nombreColumnas = {"oid", "descripcion"};
		rs.setColumnIdentifiers(nombreColumnas);
		rs.setColumnCount(nombreColumnas.length);
		Vector datos = new Vector();
		datos.add(oid);
		datos.add(descripcion);
		rs.addRow(datos);	
		DruidaConector conector = UtilidadesBelcorp.generarConector("RowSet", rs, rs.getColumnIdentifiers());
		asignar("COMBO", combo, conector, "RowSet");
	}

	private void cargaCombo(String combo, Vector dtos) throws Exception{
		if(dtos == null) return;
		DTOLineaCombo dtoLineaCombo = null;
		RecordSet rs = new RecordSet();
		String [] nombreColumnas = {"oid", "descripcion"};
		rs.setColumnIdentifiers(nombreColumnas);
		rs.setColumnCount(nombreColumnas.length);
		Vector datos = null;
		Iterator it = dtos.iterator();
		while(it.hasNext()){
			dtoLineaCombo = (DTOLineaCombo)it.next();
			datos = new Vector();
			datos.add(dtoLineaCombo.getOid());
			datos.add(dtoLineaCombo.getDescripcion());
			rs.addRow(datos);
		}
		DruidaConector conector = UtilidadesBelcorp.generarConector("RowSet", rs, rs.getColumnIdentifiers());
		asignar("COMBO", combo, conector, "RowSet");
	}

	private void armarDataCombo(String var, Vector vecLineaCombo) throws Exception{
		if( vecLineaCombo != null ){
			StringBuffer data = new StringBuffer();
			DTOLineaCombo dto = null;
			Iterator it = vecLineaCombo.iterator();
			while( it.hasNext() ){
				dto = (DTOLineaCombo)it.next();
				data.append(dto.getOid() + "|");
			}
			asignar("VAR", var, data.toString());
		}else{
			asignar("VAR", var, "");
			traza("Es nulo para " + var);
		}
	}

	/**
	 * 23024 - dmorello, 08/05/2006
	 * DT: Se limpian los datos introducibles por pantalla para que el usuario realice una nueva inserción
	 * Construcción: esta función JS también llama a la función onLoad() para recargar la página
	 */
	private void limpiarDatos() throws Exception {
		asignarAtributo("VAR","ejecutar","valor","limpiarDatos()");
	}

	// sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
	private String obtieneFormaPagoGratis(DTOSalida dtoSalida) throws Exception {
		traza("************ Entre a obtieneFormaPagoGratis");
        //DTOSalida dtoSalida = (DTOSalida)resultados.objeto("rsSalida");
        RecordSet rs = dtoSalida.getResultado(); 
        Long oidFPGratis = null;
		
		if(!rs.esVacio()){
			for(int i = 0; i <rs.getRowCount(); i++){
				String codigoFPGratis = (String)rs.getValueAt(i,"COD_FORM_PAGO");
				
				if(codigoFPGratis.equalsIgnoreCase("GRT"))
					oidFPGratis = new Long(((BigDecimal)rs.getValueAt(i,"OID_FORM_PAGO")).toString());
			}				
		}
		traza("************ oidFPGratis : " + oidFPGratis);
		
		if(oidFPGratis == null)
			return " ";
		else
			return oidFPGratis.toString();
	}	
	
}

