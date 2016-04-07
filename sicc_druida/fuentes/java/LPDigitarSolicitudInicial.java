import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOError;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesError;


import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.cmn.presentacion.cache.Cache;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.dtos.ped.DTOEstadisticasDigitacion;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;

import es.indra.sicc.logicanegocio.ped.ConstantesProcesosPED;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ConstantesValoresDefecto;

import es.indra.sicc.dtos.cra.DTOPeriodo;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.Vector;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import org.w3c.dom.Text;


import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.math.BigDecimal;

public class LPDigitarSolicitudInicial extends LPSICCBase {
    private Long aPais;
    private Long aIdioma;
    private String accion;
    private Long tipoSolicitud;
    private Long oidPeriodo;
    private Long numeroOC;
    private Long errorOC;
    private Long numeroCV;
    private Long errorCV;
    private String verificacion;
    private Timestamp inicioSesion;
    private Timestamp finSesion;
    private Long aMarca;
    private Long aCanal;
    private Long aAcceso;
    private Long aSubacceso;
    private Cache sesion;
    private Long indMasSolicitud;
    private String strDatosDetalleKO;
    private String sPosicionesDigitacion;
    private String sOidTipoSolicitud;
    private String sPeriodo;
    private String sOidCliente;


    public LPDigitarSolicitudInicial() {
    }

    public void inicio() throws Exception {
        traza("Entro a inicio Inicio");
        pagina("contenido_cabecera_digitar");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        accion = conectorParametroLimpia("accion", "", true);
        verificacion = conectorParametroLimpia("verificacion", "", true);
        traza("verificacion: " + verificacion);
        conectorParametroLimpia("accion", "", true);
        aPais = UtilidadesSession.getPais(this);
        aIdioma = UtilidadesSession.getIdioma(this);
        asignarAtributo("VAR", "hBotonSeleccionHabilitado", "valor", verificacion);
        asignarAtributo("VAR", "verificacion", "valor", verificacion);
        asignarAtributo("VAR", "hPais", "valor", aPais.toString());
        asignarAtributo("VAR", "hIdioma", "valor", aIdioma.toString());
        asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

        try {
            rastreo();
            traza("Entrando a Ejecucion");
            traza("LA ACCION jaja ES:" + accion);

            if (accion.equals("")) {
                traza("Antes de llamar al metodo inicializar.. ");
                limpiarAtributosSesion();
                inicializar();
                traza("Despues de llamar al metodo inicializar.. ");
            } else if (accion.equals("Cambiar_tipo_solicitud")) {
                traza("Antes de llamar al metodo cambiarTipoSolicitud ..");
                tipoSolicitud = conectorParametro("hOidTipoSolicitud").equals("")? null : new Long(conectorParametro("hOidTipoSolicitud"));
                sesion = getSessionCache();
                sesion.put("TIPO_SOLICITUD", tipoSolicitud);
                cambiarTipoSolicitud();
                traza("Despues de llamar al metodo cambiarTipoSolicitud ..");
            } else if (accion.equals("Cambiar_periodo")) {
                traza("Este es el periodo: #"  + conectorParametro("hPeriodo") + "#");
                oidPeriodo = conectorParametro("hPeriodo").equals("") ? null : new Long(conectorParametro("hPeriodo"));
                traza("Despues de asignar el periodo..!!");
                pagina("salidaGenerica");
                cambiarPeriodos();
            } else if (accion.equals("Aceptar_cabecera")) {
                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutarError", "valor", "validacionKO");
                validarCabeceraSolicitud();
            } else if (accion.equals("Guardar_solicitud")) {
                aMarca = conectorParametro("hMarca").equals("") ? null : new Long(conectorParametro("hMarca"));
                aCanal = conectorParametro("hCanal").equals("") ? null : new Long(conectorParametro("hCanal"));
                aAcceso = conectorParametro("hAcceso").equals("") ? null: new Long(conectorParametro("hAcceso"));
                aSubacceso = conectorParametro("hSubacceso").equals("") ? null : new Long(conectorParametro("hSubacceso"));

                traza("Esta es la marca: " + aMarca);
                traza("Este es el canal: " + aCanal);
                traza("Este es el acceso: " + aAcceso);
                traza("Este es el subacceso: " + aSubacceso);
                
                sPosicionesDigitacion = conectorParametro("hPosicionesDigitacion");
                sOidTipoSolicitud = conectorParametro("hOidTipoSolicitud");
                sPeriodo = conectorParametro("hPeriodo");
                sOidCliente = conectorParametro("hOidCliente");

                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutar", "valor", "guardarOK()");
                asignarAtributo("VAR", "ejecutarError", "valor", "guardarKO()");
                traza("Antes de llamar a grabarSolicitud()...");
                grabarSolicitud();
//				      asignarAtributo("VAR","accion","valor",this.accion);
            } else if (accion.equals("Recargar_pagina")) {
		        cargarCabecera();
			// MODIFICACION -------------------------------
			// Autor: Maximiliano Dello Russo (grusso).
			// Motivo: Incidencia BELC300010043
			//
			} else if( accion.equals("Modificar cliente") ){
				modificarCliente();
			} else if( accion.equals("Seleccionar_solicitud") ){
                seleccionarSolicitud();
            }

            getConfiguracionMenu();
        } catch (Exception exception) {
            lanzarPaginaError(exception);
        }
    }

    public void obtenerDatosIniciales() throws Exception {
        DTOBelcorp dtobelcorp = new DTOBelcorp();
        dtobelcorp.setOidIdioma(aIdioma);
        dtobelcorp.setOidPais(aPais);

        ComposerViewElementList composerviewelementlist = crearParametrosEntradaDatosINI(dtobelcorp);
        ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist,
                getRequest());
        conectorcomposerview.ejecucion();

        DruidaConector druidaconector = conectorcomposerview.getConector();
        traza("ESTE ES EL CONECTOR: " + druidaconector.getXML());
        asignar("COMBO", "cbTipoSolicitud", druidaconector,
            "PEDObtenerTiposSolicitudDigitacionVD");
        asignar("COMBO", "cbAccesoFisico", druidaconector,
            "PEDObtenerAccesoFisico");
        asignar("COMBO", "cbFormaPago", druidaconector, "BELFormasPagoPais");
        asignar("COMBO", "cbTipoDespacho", druidaconector,
            "PEDObtenerTipoDespacho");
    }

    private ComposerViewElementList crearParametrosEntradaDatosINI(
        DTOBelcorp dtobelcorp) throws Exception {
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness(
            "PEDObtenerTiposSolicitudDigitacionVD");
        composerviewelement.setDTOE(dtobelcorp);
        composerviewelementlist.addViewElement(composerviewelement);

        ComposerViewElement composerviewelement1 = new ComposerViewElement();
        composerviewelement1.setIDBusiness("PEDObtenerAccesoFisico");
        composerviewelement1.setDTOE(dtobelcorp);
        composerviewelementlist.addViewElement(composerviewelement1);

        ComposerViewElement composerviewelement2 = new ComposerViewElement();
        composerviewelement2.setIDBusiness("BELFormasPagoPais");
        composerviewelement2.setDTOE(dtobelcorp);
        composerviewelementlist.addViewElement(composerviewelement2);

        ComposerViewElement composerviewelement3 = new ComposerViewElement();
        composerviewelement3.setIDBusiness("PEDObtenerTipoDespacho");
        composerviewelement3.setDTOE(dtobelcorp);
        composerviewelementlist.addViewElement(composerviewelement3);

        return composerviewelementlist;
    }

    public void inicializar() throws Exception {
    
        traza("Antes de llamar al metodo cargarCabecera ");
        cargarCabecera();
        traza("Despues de llamar al metodo cargarCabecera ");
        traza("Antes de llamar al metodo InicializarEstadisticas ");
        inicializarEstadisticas();
        traza("Despues de llamar al metodo InicializarEstadisticas ");
    }

    public void cambiarTipoSolicitud() throws Exception {
        traza("Antes de llamar al metodo obtenerDatosIniciales() ");
        obtenerDatosIniciales();
        traza("Antes de llamar al metodo seleccionarTipoSolicitud() ");
        seleccionarTipoSolicitud();
        traza("Antes de llamar al metodo obtenerValoresAsociadosTipoSolicitud() ");
        obtenerValoresAsociadosTipoSolicitud();
        traza("Antes de llamar al metodo obtenerPeriodos()  ");
        obtenerPeriodos();
        traza("Antes de llamar al metodo seleccionarPeriodo()  ");
        seleccionarPeriodo();
        traza("Despues de llamar al metodo seleccionarPeriodo()  ");
        DTOValoresDefecto dtovaloresdefecto1 = obtenerValoresDefecto();
		if (dtovaloresdefecto1.getValor()[1] != null) {
			asignarAtributo("VAR", "destinoVD", "valor",dtovaloresdefecto1.getValor()[1]);
		}
		traza("destinoVD: " + dtovaloresdefecto1.getValor()[1]);
		traza("Despues de llamar al metodo obtenerValoresDefecto()  ");
		
    }

    private ComposerViewElementList crearParametrosEntradaCliente(DTOOID dtooid)
        throws Exception {
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness("MAEObtenerTiposDocumentoCliente");
        composerviewelement.setDTOE(dtooid);
        composerviewelementlist.addViewElement(composerviewelement);

        ComposerViewElement composerviewelement1 = new ComposerViewElement();
        composerviewelement1.setIDBusiness("MAEObtenerTiposDireccionCliente");
        composerviewelement1.setDTOE(dtooid);
        composerviewelementlist.addViewElement(composerviewelement1);

        return composerviewelementlist;
    }

    public void cambiarPeriodos() throws Exception {
        Long long1 = conectorParametro("hPeriodo").equals("") ? null : new Long(conectorParametro("hPeriodo"));
        sesion = getSessionCache();
        sesion.put("PERIODO", long1);

        Date date = new Date(System.currentTimeMillis());
        sesion.put("FECHA_FIN", date);
        guardarEstadisticas();
    }

    public void validarCabeceraSolicitud() throws Exception {
        Boolean boolean1 = comprobarDatosObligatorios();
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        sesion = getSessionCache();

        if (boolean1.booleanValue()) {
            Long long1 = (Long) sesion.get("MARCA");
            Long long2 = (Long) sesion.get("CANAL");
            Long long3 = (Long) sesion.get("ACCESSO");
            Long long4 = (Long) sesion.get("SUBACCESO");
            Long long5 = (Long) sesion.get("TIPO_CLIENTE");

            traza("tipo soplicitud " + conectorParametro("hOidTipoSolicitud"));
            Long long6 = conectorParametro("hOidTipoSolicitud").equals("") ? null : new Long(conectorParametro("hOidTipoSolicitud"));

            traza("hOidTipoDespacho " + conectorParametro("hOidTipoDespacho"));
            Long long7 = conectorParametro("hOidTipoDespacho").equals("")? null : new Long(conectorParametro("hOidTipoDespacho"));

            traza("hPeriodo " + conectorParametro("hPeriodo"));
            Long long8 = conectorParametro("hPeriodo").equals("") ? null : new Long(conectorParametro("hPeriodo"));

            traza("hCodCliente " + conectorParametro("hCodCliente"));
            String s = conectorParametro("hCodCliente");

            traza("hOidCliente " + conectorParametro("hOidCliente"));
            Long longCliente = conectorParametro("hOidCliente").equals("") ? null : new Long(conectorParametro("hOidCliente"));

            traza("hNumeroClientes " + conectorParametro("hNumeroClientes"));
            Integer integer = conectorParametro("hNumeroClientes").equals("") ? null : new Integer(conectorParametro("hNumeroClientes"));

            traza("hReceptorFac " + conectorParametro("hReceptorFac"));
            String s1 = conectorParametro("hReceptorFac");
            traza("hOidReceptorFac " + conectorParametro("hOidReceptorFac"));
            Long longRecepFac = conectorParametro("hOidReceptorFac").equals("") ? null : new Long(conectorParametro("hOidReceptorFac"));


            traza("hPagadorFac " + conectorParametro("hPagadorFac"));
            String s2 = conectorParametro("hPagadorFac");
            traza("hOidPagadorFac " + conectorParametro("hOidPagadorFac"));
            Long longPagFac = conectorParametro("hOidPagadorFac").equals("") ? null : new Long(conectorParametro("hOidPagadorFac"));


            traza("hAccesoFisico" + conectorParametro("hAccesoFisico"));
            Long long9 = conectorParametro("hAccesoFisico").equals("") ? null : new Long(conectorParametro("hAccesoFisico"));

            traza("hTipoDocumento " + conectorParametro("hTipoDocumento"));
            Long long10 = conectorParametro("hTipoDocumento").equals("") ? null : new Long(conectorParametro("hTipoDocumento"));

            traza("hTipoDocumentoLegal " + conectorParametro("hTipoDocumentoLegal"));
            Long long11 = conectorParametro("hTipoDocumentoLegal").equals("") ? null : new Long(conectorParametro("hTipoDocumentoLegal"));

            traza("hFormaPago " + conectorParametro("hFormaPago"));
            Long long12 = conectorParametro("hFormaPago").equals("") ? null : new Long(conectorParametro("hFormaPago"));

            traza("hDestino " + conectorParametro("hDestino"));
            Long long13 = conectorParametro("hDestino").equals("") ? null : new Long(conectorParametro("hDestino"));

            traza("hObservacion " + conectorParametro("hObservacion"));
            String s3 = conectorParametro("hObservacion");
			
            Boolean boolean2 = new Boolean(true);

            MareBusinessID marebusinessid = new MareBusinessID("PEDValidacionesGeneralesSolicitud");
			
            DTOCabeceraSolicitud dtocabecerasolicitud = new DTOCabeceraSolicitud();

            dtocabecerasolicitud.setOidPais(this.aPais);
            dtocabecerasolicitud.setOidIdioma(this.aIdioma);
            
            dtocabecerasolicitud.setTipoSolicitud(long6);
            dtocabecerasolicitud.setMarca(long1);
            dtocabecerasolicitud.setCanal(long2);
            dtocabecerasolicitud.setAcceso(long3);
            dtocabecerasolicitud.setSubacceso(long4);
            traza("El tipo Cliente es: " + long5);
            dtocabecerasolicitud.setTipoCliente(long5);
            dtocabecerasolicitud.setTipoDespacho(long7);
            dtocabecerasolicitud.setFecha(new Date(System.currentTimeMillis()));
            if (verificacion.equals("SI"))
                dtocabecerasolicitud.setProceso(ConstantesProcesosPED.VERIFICAR_SOLICITUD);
            else
                dtocabecerasolicitud.setProceso(ConstantesProcesosPED.DIGITAR_SOLICITUD);
            dtocabecerasolicitud.setPeriodo(long8);
            dtocabecerasolicitud.setCliente(s);
            dtocabecerasolicitud.setOidCliente(longCliente);
            dtocabecerasolicitud.setNumeroClientes(integer);
            dtocabecerasolicitud.setReceptorFactura(s1);
            dtocabecerasolicitud.setOidReceptorFactura(longRecepFac);
            dtocabecerasolicitud.setOidPagadorFactura(longPagFac);
            dtocabecerasolicitud.setPagadorFactura(s2);
            dtocabecerasolicitud.setAccesoFisico(long9);
            dtocabecerasolicitud.setTipoDocumento(long10);
            dtocabecerasolicitud.setTipoDocumentoLegal(long11);
            dtocabecerasolicitud.setFormaPago(long12);
            dtocabecerasolicitud.setDestino(long13);
            dtocabecerasolicitud.setObservaciones(s3);
            dtocabecerasolicitud.setIndicadorDigitacion(boolean2);

            Vector vector = new Vector();
            vector.addElement(dtocabecerasolicitud);
            vector.addElement(marebusinessid);

            traza(" ANTES DE CONECTAR");
            DruidaConector druidaconector = conectar("ConectorValidacionesGeneralesSolicitud",vector);
            traza(" DESPUES DE CONECTAR");

            DTOCabeceraSolicitud dtocabecerasolicitud1 = (DTOCabeceraSolicitud) druidaconector.objeto("DTOSalida");

            traza("Antes del IF: " + dtocabecerasolicitud1.getOK());
            if (dtocabecerasolicitud1.getOK().booleanValue()) {
                traza("Este es el DTO que volvio victorioso de la Validacion....!!!: " + dtocabecerasolicitud1);
                dtocabecerasolicitud1.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);

                Boolean indMasSol = dtocabecerasolicitud1.getIndMasSolicitudes();
                traza("El indMasSol es: " + indMasSol);
                if (indMasSol != null  &&  indMasSol.booleanValue()) {
					//asignarAtributo("VAR","ejecutar","valor","validacionKO('1373');");
					//Muestra mensaje de aviso PED-0017 ;
                }
                Long long14 = obtenerOC();
          			traza("Este es en OC: " + long14);
				Long long16 = null;
				
				if (long14 != null) {
					long16 = new Long(long14.longValue() + 1L);
				}

                traza("Antes de llamar a ActualizarEstadisticas...!!");
                actualizarEstadisticas(long16, null, null, null);
                traza("Despues de llamar a ActualizarEstadisticas...!!");
                traza("Antes de llamar a guardarEstadisticas...!!");
                //guardarEstadisticas();
        				traza("Despues de llamar a guardarEstadisticas...!!");
                traza("Antes de llamar a detalleSolicitud...!!");
                detalleSolicitud(dtocabecerasolicitud1);
                traza("Despues de llamar a detalleSolicitud...!!");
            } else {
                //Muestra mensaje de aviso PED-0016 ;
                asignarAtributo("VAR","ejecutar","valor","validacionKO('1367');");
                traza("Vino al else..");
                errorOC = obtenerErrorOC();
				traza("Este es el OC: " + errorOC);
				Long long15 = null;
				
				if (errorOC != null) {
					long15 = new Long(errorOC.longValue() + 1L);
				}
                actualizarEstadisticas(null, long15, null, null);
            }
        }
    }

    public void grabarSolicitud() throws Exception {
        traza("Antes de generarCabecera()...");
        DTOCabeceraSolicitud dtocabecerasolicitud = generarCabecera();
        
        if (verificacion.equals("SI"))  {
            dtocabecerasolicitud.setVerificacion(new Boolean(true));
        }
        
        
        dtocabecerasolicitud.setPosiciones(new ArrayList());
        String sDatosDetalle = conectorParametro("strDatosDetalle");
        String[] as = construirLineas(sDatosDetalle, "|");

        for (int i = 0; i < as.length; i++) {
            String[] as1 = construirLineas(as[i], ",");
            Integer integer = new Integer(i+1);
            String s1 = as1[0];
            Long long1 = new Long(as1[1]);
            generarPosicion(dtocabecerasolicitud, integer, s1, long1);
        }

        MareBusinessID marebusinessid = new MareBusinessID(
                "PEDGrabarSolicitudDigitacion");

        traza("ESTE ES EL PAIS: " + dtocabecerasolicitud.getOidPais());

        Vector vector = new Vector();
        vector.addElement(dtocabecerasolicitud);
        vector.addElement(marebusinessid);
        traza(" ANTES DE CONECTAR");

        DruidaConector druidaconector = conectar("ConectorGrabarSolicitudDigitacion",
                vector);
        traza(" DESPUES DE CONECTAR");

        DTOCabeceraSolicitud dtocabecerasolicitud1 = (DTOCabeceraSolicitud) druidaconector.objeto("DTOSalida");

        if (!dtocabecerasolicitud1.getOK().booleanValue()) {
            reportarErrores(dtocabecerasolicitud1);
//			asignarAtributo("VAR","strDatosDetalle","valor",strDatosDetalle);
          asignarAtributo("VAR", "ejecutar", "valor", "guardarKO('" + strDatosDetalleKO + "')");
        } else {
          if (verificacion.equals("SI")){
              seleccionarSolicitud();
          } else {
              asignarAtributo("VAR", "ejecutar", "valor", "guardarOK()");          
          }
		}

    // Guardamos las estadisticas de digitación 
    guardarEstadisticas();

//        cargarCabecera();
    }

    public DTOValoresDefecto obtenerValoresDefecto() throws Exception {
        Long long1 = tipoSolicitud;
        String[] as = {new String(ConstantesValoresDefecto.CB_ACCESO_FISICO), new String(ConstantesValoresDefecto.CB_DESTINO),
            new String(ConstantesValoresDefecto.CB_TIPO_DESPACHO) };

		traza("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		traza("Estas son las constantes:   ");
		traza("ConstantesValoresDefecto.CB_TIPO_DESPACHO: "  + ConstantesValoresDefecto.CB_TIPO_DESPACHO);
		traza("ConstantesValoresDefecto.CB_ACCESO_FISICO: " + ConstantesValoresDefecto.CB_ACCESO_FISICO);
		traza("ConstantesValoresDefecto.CB_DESTINO: " + ConstantesValoresDefecto.CB_DESTINO);
		traza("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        MareBusinessID marebusinessid = new MareBusinessID("PEDObtenerValoresDefecto");
        DTOValoresDefecto dtovaloresdefecto = new DTOValoresDefecto();
        dtovaloresdefecto.setModulo(new Long(
                ConstantesValoresDefecto.MODULO_PED.longValue()));
        dtovaloresdefecto.setFormulario(ConstantesValoresDefecto.PG_DATOS_SOLICITUD);
        dtovaloresdefecto.setTipoSolicitud(long1);
        dtovaloresdefecto.setCampo(as);

        Vector vector = new Vector();
        vector.addElement(dtovaloresdefecto);
        vector.addElement(marebusinessid);
        traza(" ANTES DE CONECTAR");

        DruidaConector druidaconector = conectar("ConectorObtenerValorDefecto",
                vector);
        traza(" DESPUES DE CONECTAR");

        DTOValoresDefecto dtovaloresdefecto1 = (DTOValoresDefecto) druidaconector.objeto("DTOSalida");

        traza("Este es el DTO que recibo: " + dtovaloresdefecto1);

		traza("Esta es la longitud de Valor: " + dtovaloresdefecto1.getValor().length);

		traza("Esta es la longitud de Obligatorio: " + dtovaloresdefecto1.getObligatorio().length);

		traza("Esta es la longitud de Editable: " + dtovaloresdefecto1.getEditable().length);

		for (int i=0;i<dtovaloresdefecto1.getValor().length ;i++)  {
			traza("Valor " + i + ": " + dtovaloresdefecto1.getValor()[i]);			
		}
		for (int i=0;i<dtovaloresdefecto1.getObligatorio().length ;i++)  {
			traza("Obligatorio " + i + ": " + dtovaloresdefecto1.getObligatorio()[i]);			
		}
		for (int i=0;i<dtovaloresdefecto1.getEditable().length ;i++)  {
			traza("Editable " + i + ": " + dtovaloresdefecto1.getEditable()[i]);			
		}

        if (dtovaloresdefecto1.getValor() != null) {
            if (dtovaloresdefecto1.getValor()[0] != null) {
                asignarAtributo("VAR", "accesoFisicoVD", "valor",dtovaloresdefecto1.getValor()[0]);               
            }

			/*
			* Autor Cortaberris
			* Fecha 20/04/2005
			* incidencia BELC300016478
			*/
			if (Boolean.FALSE.equals(dtovaloresdefecto1.getEditable()[0])) {
                asignarAtributo("VAR", "accesoFisicoHabilitado", "valor","N");
            } 

            if (dtovaloresdefecto1.getValor()[1] != null) {

                if (!dtovaloresdefecto1.getEditable()[1].booleanValue()) {
                    asignarAtributo("VAR", "destinoHabilitado", "valor", "N");
                }
            }

            if (dtovaloresdefecto1.getValor()[2] != null) {
                asignarAtributo("VAR", "tipoDespachoVD", "valor",
                    dtovaloresdefecto1.getValor()[2]);

			} else {
				Long tDespacho = obtenerPrimerElementoCombo("cbTipoDespacho");
				asignarAtributo("VAR", "tipoDespachoVD", "valor",tDespacho.toString());				
			}

			if (Boolean.FALSE.equals(dtovaloresdefecto1.getEditable()[2])) {
                asignarAtributo("VAR", "tipoDespachoHabilitado", "valor","N");
            }
			if (Boolean.TRUE.equals(dtovaloresdefecto1.getObligatorio()[2]))  {
				asignarAtributo("COMBO","cbTipoDespacho","req","S");
				asignarAtributoElementoValidacion("cbTipoDespacho","required","true");						
			}

        }
		return dtovaloresdefecto1;
    }

    public Boolean comprobarDatosObligatorios() throws Exception {
        Boolean boolean1 = new Boolean(conectorParametro(
                    "tipoDespachoObligatorioVD"));

        if (boolean1.booleanValue()) {
            Long long1 = new Long(conectorParametro("hPeriodo"));

            if (long1 == null) {
                return new Boolean(false);
            }

            Long long2 = new Long(conectorParametro("hOidTipoSolicitud"));

            if (long2 == null) {
                return new Boolean(false);
            }

            String s = conectorParametro("hCodCliente");

            if ((s == null) || s.equals("")) {
                return new Boolean(false);
            }

            String s1 = conectorParametro("hReceptorFac");

            if ((s1 == null) || s1.equals("")) {
                return new Boolean(false);
            }

            String s2 = conectorParametro("hPagadorFactura");

            if ((s2 == null) || s2.equals("")) {
                return new Boolean(false);
            }

            Long long3 = new Long(conectorParametro("hAccesoFisico"));

            if (long3 == null) {
                return new Boolean(false);
            }

            Long long4 = new Long(conectorParametro("hTipoDocumento"));

            if (long4 == null) {
                return new Boolean(false);
            }

            Long long5 = new Long(conectorParametro("hDestino"));

            if (long5 == null) {
                return new Boolean(false);
            }
        }

        return new Boolean(true);
    }

    public void actualizarEstadisticas(Long long1, Long long2, Long long3,
        Long long4) throws Exception {
		traza("Entro a actualizarEstadisticas...");
        sesion = getSessionCache();
        numeroOC = (Long) sesion.get("NUMERO_OC");
        errorOC = (Long) sesion.get("ERROR_OC");
        numeroCV = (Long) sesion.get("NUMERO_CV");
        errorCV = (Long) sesion.get("ERROR_CV");

        traza("NUMERO_OC" + numeroOC);
        traza("ERROR_OC" +  errorOC);
        traza("NUMERO_CV" +  numeroCV);
        traza("ERROR_OC" +  errorCV);

        if (long1 != null) {
            numeroOC = long1;
        }

        if (long2 != null) {
            errorOC = long2;
        }

        if (long3 != null) {
            numeroCV = long3;
        }

        if (long4 != null) {
            errorCV = long4;
        }

        sesion.put("NUMERO_OC", numeroOC);
        sesion.put("ERROR_OC", errorOC);
        sesion.put("NUMERO_CV", numeroCV);
        sesion.put("ERROR_CV", errorCV);
		traza("Salio de actualizarEstadisticas...");
    }

    public void guardarEstadisticas() throws Exception {
        Long long1 = tipoSolicitud;
        Long long2 = oidPeriodo;
        sesion = getSessionCache();

        Long long3 = (Long) sesion.get("OID_ESTADISTICAS");
        numeroOC = (Long) sesion.get("NUMERO_OC");
        errorOC = (Long) sesion.get("ERROR_OC");
        numeroCV = (Long) sesion.get("NUMERO_CV");
        errorCV = (Long) sesion.get("NUMERO_CV");

        Date date = (Date) sesion.get("FECHA_INICIO");
        Date date1 = (Date) sesion.get("FECHA_FIN");
        DTOEstadisticasDigitacion dtoestadisticasdigitacion = new DTOEstadisticasDigitacion();
        dtoestadisticasdigitacion.setOidEstadisticas(long3);
        dtoestadisticasdigitacion.setInicioSesion(new Timestamp(date.getTime()));
        dtoestadisticasdigitacion.setFinSesion(new Timestamp(date1.getTime()));
        dtoestadisticasdigitacion.setUsuario(null);
        dtoestadisticasdigitacion.setNumeroCV(numeroCV);
        dtoestadisticasdigitacion.setErrorCV(errorCV);
        dtoestadisticasdigitacion.setNumeroOC(numeroOC);
        dtoestadisticasdigitacion.setErrorOC(errorOC);
        dtoestadisticasdigitacion.setProcesoPedidos(ConstantesProcesosPED.DIGITAR_SOLICITUD);
        dtoestadisticasdigitacion.setTipoSolicitud(long1);
        dtoestadisticasdigitacion.setPeriodo(long2);
        
        if (verificacion.equals("SI")){
				
		       traza  ("SI  - ConstantesProcesosPED.VERIFICAR_SOLICITUD");
			   dtoestadisticasdigitacion.setProcesoPedidos(ConstantesProcesosPED.VERIFICAR_SOLICITUD);

		}    else {
		       traza  ("NO  - ConstantesProcesosPED.VERIFICAR_SOLICITUD");
              dtoestadisticasdigitacion.setProcesoPedidos(ConstantesProcesosPED.DIGITAR_SOLICITUD);        
		}
            
        if (dtoestadisticasdigitacion.getPeriodo() != null)  {
            traza("Este es el DTO que va a guardar: " + dtoestadisticasdigitacion);
    
            MareBusinessID marebusinessid = new MareBusinessID(
                    "PEDGuardarEstadisticasDigitacion");
            Vector vector = new Vector();
            vector.addElement(dtoestadisticasdigitacion);
            vector.addElement(marebusinessid);
            traza(" ANTES DE CONECTAR");
    
            DruidaConector druidaconector = conectar("ConectorGuardarEstadisticasDigitacion",
                    vector);
            traza(" DESPUES DE CONECTAR");
            traza("Recupero el DTOOID..");
    
            DTOOID dtooid = (DTOOID) druidaconector.objeto("DTOSalida");
            traza("No tuvo problema el casteo del DTOOID..");
            sesion.put("OID_ESTADISTICAS", dtooid.getOid());                
        }
        
    }

    public void detalleSolicitud(DTOCabeceraSolicitud dtocabecerasolicitud)
        throws Exception {

		StringBuffer parametros = new StringBuffer();

		traza("Estes es el DTO: " + dtocabecerasolicitud);



		parametros.append(dtocabecerasolicitud.getTipoSolicitud() + "|");
		parametros.append(dtocabecerasolicitud.getTipoDespacho() + "|");
		parametros.append(dtocabecerasolicitud.getMoneda() + "|");
		parametros.append(dtocabecerasolicitud.getAlmacen() + "|");
		parametros.append(dtocabecerasolicitud.getModulo() + "|");
		parametros.append(dtocabecerasolicitud.getPeriodo() + "|");
		parametros.append(dtocabecerasolicitud.getCliente() + "|");
		parametros.append(dtocabecerasolicitud.getOidCliente() + "|");
		parametros.append(dtocabecerasolicitud.getNumeroClientes() + "|");
		parametros.append(dtocabecerasolicitud.getReceptorFactura() + "|");
		parametros.append(dtocabecerasolicitud.getOidReceptorFactura() + "|");
		parametros.append(dtocabecerasolicitud.getPagadorFactura() + "|");
		parametros.append(dtocabecerasolicitud.getOidPagadorFactura() + "|");
		parametros.append(dtocabecerasolicitud.getAccesoFisico() + "|");
		parametros.append(dtocabecerasolicitud.getTipoDocumento() + "|");
		parametros.append(dtocabecerasolicitud.getTipoDocumentoLegal() + "|");
		parametros.append(dtocabecerasolicitud.getDestino() + "|");
		parametros.append(dtocabecerasolicitud.getObservaciones() + "|");
		parametros.append(dtocabecerasolicitud.getIndicadorDigitacion() + "|");
		parametros.append(dtocabecerasolicitud.getMarca() + "|");
		parametros.append(dtocabecerasolicitud.getCanal() + "|");
		parametros.append(dtocabecerasolicitud.getAcceso() + "|");
		parametros.append(dtocabecerasolicitud.getSubacceso() + "|");
		parametros.append(dtocabecerasolicitud.getSociedad() + "|");
		parametros.append(dtocabecerasolicitud.getFormaPago() + "|");
		parametros.append(dtocabecerasolicitud.getEstado() + "|");
		parametros.append(dtocabecerasolicitud.getSubgerencia() + "|");
		parametros.append(dtocabecerasolicitud.getTerritorio() + "|");
		parametros.append(dtocabecerasolicitud.getZona() + "|");
		parametros.append(dtocabecerasolicitud.getNumeroSolicitud() + "|");
		parametros.append(dtocabecerasolicitud.getUsuario() + "|");
		parametros.append(dtocabecerasolicitud.getFecha() + "|");
		parametros.append(dtocabecerasolicitud.getPermiteUnionSolicitudes() + "|");
		parametros.append(dtocabecerasolicitud.getIndPedidoPrueba() + "|");
		parametros.append(dtocabecerasolicitud.getIndTSNoConsolidado() + "|");
		parametros.append(dtocabecerasolicitud.getUbigeo() + "|");
		parametros.append(dtocabecerasolicitud.getSubtipoCliente() + "|");
		parametros.append(dtocabecerasolicitud.getClaseSolicitud() + "|");
		parametros.append(dtocabecerasolicitud.getOperacion() + "|");
		parametros.append(dtocabecerasolicitud.getProceso() + "|");
		parametros.append(dtocabecerasolicitud.getOrdenCompra() + "|");
		parametros.append(dtocabecerasolicitud.getTipoConsolidado() + "|");
		parametros.append(dtocabecerasolicitud.getRegion() + "|");
		parametros.append(dtocabecerasolicitud.getSeccion() + "|");
//		parametros.append(dtocabecerasolicitud.getMonofacturacion() + "|");
		parametros.append(dtocabecerasolicitud.getOK() + "|");
		parametros.append(dtocabecerasolicitud.getMensajeError() + "|");
		parametros.append(dtocabecerasolicitud.getIndMasSolicitudes() + "|");
		parametros.append(dtocabecerasolicitud.getDestinatario() + "|");
		parametros.append(dtocabecerasolicitud.getOidConcursoParametros() + "|");
		parametros.append(dtocabecerasolicitud.getOidDocumentoReferencia() + "|");
		parametros.append(dtocabecerasolicitud.getNumeroPremio() + "|");

        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
        String s = simpledateformat.format(new Date(dtocabecerasolicitud.getFechaPrevistaFacturacion().getTime()));
		parametros.append(s + "|");
		parametros.append(dtocabecerasolicitud.getTipoCliente() + "|");
		parametros.append(dtocabecerasolicitud.getOidTerritorioAdministrativo() + "|");
		parametros.append(dtocabecerasolicitud.getTipoCambio());

    if (verificacion.equals("SI"))  {
      asignarAtributo("VAR","hBotonSeleccionHabilitado","valor","SI");
    }
    
    

		traza("Esto es lo que me queda: " + parametros.toString());
		asignarAtributo("VAR","ejecutar","valor","validacionOK('" + parametros.toString() + "');"); 

		traza("Sale de DetalleSolicitud......!!!");
    }

    public Long obtenerErrorOC() throws Exception {
        sesion = getSessionCache();

        Long long1 = (Long) sesion.get("ERROR_OC");

        return long1;
    }

    public Long obtenerCV() throws Exception {
        sesion = getSessionCache();

        Long long1 = (Long) sesion.get("NUMERO_CV");

        return long1;
    }

    public Long obtenerErrorCV() throws Exception {
        sesion = getSessionCache();

        Long long1 = (Long) sesion.get("ERROR_CV");
		traza("Entro a obtenerErrorCV...");
		traza("Este es el ErrorCV");
		traza("Salio de obtenerErrorCV...");
        return long1;
    }

    public Long obtenerOC() throws Exception {
        sesion = getSessionCache();

        Long long1 = (Long) sesion.get("NUMERO_OC");

        return long1;
    }

    public void inicializarEstadisticas() throws Exception {
        Date date = new Date(System.currentTimeMillis());
        Date date1 = date;
        sesion = getSessionCache();
        sesion.put("NUMERO_OC", new Long(0L));
        sesion.put("ERROR_OC", new Long(0L));
        sesion.put("NUMERO_CV", new Long(0L));
        sesion.put("ERROR_CV", new Long(0L));
        sesion.put("FECHA_INICIO", date);
        sesion.put("FECHA_FIN", date1);
        traza("Antes de llamar al metodo guardarEstadisticas() ");
        guardarEstadisticas();
    }

    public void obtenerValoresAsociadosTipoSolicitud()
        throws Exception {
        traza("EL OIDTIPOSOLICUTUD ES: " + tipoSolicitud);

        MareBusinessID marebusinessid = new MareBusinessID(
                "PEDObtenerValoresAsociadosTipoSolicitud");
        DTOOID dtooid = new DTOOID();
        dtooid.setOidPais(aPais);
        dtooid.setOidIdioma(aIdioma);
        dtooid.setOid(tipoSolicitud);

        Vector vector = new Vector();
        vector.addElement(dtooid);
        vector.addElement(marebusinessid);
        traza(" ANTES DE CONECTAR");

        DruidaConector druidaconector = conectar("ConectorObtenerValoresAsociadosTipoSolicitud",
                vector);
        traza(" DESPUES DE CONECTAR");

        DTOTipoSolicitud dtotiposolicitud = (DTOTipoSolicitud) druidaconector.objeto(
                "DTOSalida");
        traza("Este es el DTO....: " + dtotiposolicitud);

        traza("Este es el Acceso por defecto: " + UtilidadesSession.getAccesoPorDefecto(this));
        traza("Este es el Canal por defecto: " + UtilidadesSession.getCanalPorDefecto(this));
        traza("Este es el SubAcceso por defecto: " + UtilidadesSession.getSubaccesoPorDefecto(this));

        if (dtotiposolicitud.getSubacceso() == null) {
            dtotiposolicitud.setSubacceso(UtilidadesSession.getSubaccesoPorDefecto(this));
            /* Incidencia 12446 02/02/2005 cambio hecho por Pperez
            Si DTOTipoSolicitud.acceso != acceso por defecto del usuario OR DTOTipoSolicitud.canal != canal
            por defecto del usuario
             {
            Lanza una Excepción con código de error: PED-039 "Canal y/o Acceso del usuario no coinciden
            con Canal y/o Acceso del Tipo de solicitud"
             }
             */
             if (dtotiposolicitud.getAcceso().longValue() != UtilidadesSession.getAccesoPorDefecto(this).longValue() ||
                 dtotiposolicitud.getCanal().longValue()  != UtilidadesSession.getCanalPorDefecto(this).longValue()) {
                 asignarAtributo("VAR","hCanalAccesosErroneo","valor","S");
             }
             
        }

        traza("Este es el DTO....: " + dtotiposolicitud.getSubacceso());
        sesion = getSessionCache();
        sesion.put("MARCA", dtotiposolicitud.getMarca());
        sesion.put("CANAL", dtotiposolicitud.getCanal());
        sesion.put("ACCESO", dtotiposolicitud.getAcceso());
        sesion.put("SUBACCESO", dtotiposolicitud.getSubacceso());
        sesion.put("TIPO_CLIENTE", dtotiposolicitud.getTipoCliente());
        sesion.put("TIPO_SOLICITUD", dtotiposolicitud.getOid());
        asignarAtributo("VAR", "hMarca", "valor",
            dtotiposolicitud.getMarca().toString());
        asignarAtributo("VAR", "hCanal", "valor",
            dtotiposolicitud.getCanal().toString());
        asignarAtributo("VAR", "hAcceso", "valor",
            dtotiposolicitud.getAcceso().toString());
        asignarAtributo("VAR", "hSubacceso", "valor",
            dtotiposolicitud.getSubacceso().toString());
        traza("Termino de subir los datos a sesion...!!!!!");
    }

    public void seleccionarPeriodo() throws Exception {
        sesion = getSessionCache();

        Long long1 = (Long) sesion.get("PERIODO");

        if (long1 == null) {
            traza("El periodo es igual a null....");
            oidPeriodo = obtenerPrimerElementoCombo("cbPeriodo");
            asignarAtributo("VAR", "hPeriodo", "valor", oidPeriodo.toString());
            sesion.put("PERIODO", oidPeriodo);
        } else {
            traza("El periodo es diferente de null....");
            asignarAtributo("VAR", "hPeriodo", "valor", long1.toString());
            oidPeriodo = long1;
        }
    }

    public void obtenerPeriodos() throws Exception {
        traza("Entro al metodo obtenerPeriodos()");

        DTOPeriodo dtoperiodo = new DTOPeriodo();
        dtoperiodo.setOidIdioma(aIdioma);
        dtoperiodo.setOidPais(aPais);
        dtoperiodo.setPais(aPais);
        dtoperiodo.setMarca((Long) sesion.get("MARCA"));
        dtoperiodo.setCanal((Long) sesion.get("CANAL"));

        Date date = new Date(System.currentTimeMillis());
        dtoperiodo.setFechaFin(date);
        dtoperiodo.setFechaInicio(date);

        ComposerViewElementList composerviewelementlist = crearParametrosEntradaPeriodos(dtoperiodo);
        ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist,
                getRequest());
        conectorcomposerview.ejecucion();

        DruidaConector druidaconector = conectorcomposerview.getConector();
        asignar("COMBO", "cbPeriodo", druidaconector, "CRAObtienePeriodosFecha");
        traza("Salio al metodo obtenerPeriodos()");
    }

    public DTOCabeceraSolicitud generarCabecera() throws Exception {
		Timestamp fechaPrevista = null;
        DTOCabeceraSolicitud dtocabecerasolicitud = new DTOCabeceraSolicitud();
        
        traza("tipo soplicitud " + conectorParametro("hOidTipoSolicitud"));
        Long long1 = conectorParametro("hOidTipoSolicitud").equals("") ? null : new Long(conectorParametro("hOidTipoSolicitud"));

        traza("hOidTipoDespacho " + conectorParametro("hOidTipoDespacho"));
        Long long2 = conectorParametro("hOidTipoDespacho").equals("") ? null : new Long(conectorParametro("hOidTipoDespacho"));

        traza("hPeriodo " + conectorParametro("hPeriodo"));
        Long long3 = conectorParametro("hPeriodo").equals("") ? null : new Long(conectorParametro("hPeriodo"));

        traza("hCodCliente " + conectorParametro("hCodCliente"));
        String s = conectorParametro("hCodCliente");

        traza("hOidCliente " + conectorParametro("hOidCliente"));
        Long longCliente = conectorParametro("hOidCliente").equals("") ? null : new Long(conectorParametro("hOidCliente"));
		
        traza("hNumeroClientes " + conectorParametro("hNumeroClientes"));
        Integer integer = conectorParametro("hNumeroClientes").equals("") ? null : new Integer(conectorParametro("hNumeroClientes"));

        traza("hReceptorFac " + conectorParametro("hReceptorFac"));
        String s1 = conectorParametro("hReceptorFac");
        traza("hOidReceptorFac " + conectorParametro("hOidReceptorFac"));
        Long longRecepFac = conectorParametro("hOidReceptorFac").equals("") ? null : new Long(conectorParametro("hOidReceptorFac"));

        traza("hPagadorFac " + conectorParametro("hPagadorFac"));
        String s2 = conectorParametro("hPagadorFac");
        traza("hOidPagadorFac " + conectorParametro("hOidPagadorFac"));
        Long longPagFac = conectorParametro("hOidPagadorFac").equals("") ? null : new Long(conectorParametro("hOidPagadorFac"));

        traza("hAccesoFisico" + conectorParametro("hAccesoFisico"));
        Long long4 = conectorParametro("hAccesoFisico").equals("") ? null : new Long(conectorParametro("hAccesoFisico"));

        traza("hTipoDocumento " + conectorParametro("hTipoDocumento"));
        Long long5 = conectorParametro("hTipoDocumento").equals("") ? null : new Long(conectorParametro("hTipoDocumento"));

        traza("hTipoDocumentoLegal " + conectorParametro("hTipoDocumentoLegal"));
        Long long6 = conectorParametro("hTipoDocumentoLegal").equals("") ? null : new Long(conectorParametro("hTipoDocumentoLegal"));

        traza("hFormaPago " + conectorParametro("hFormaPago"));
        Long long7 = conectorParametro("hFormaPago").equals("") ? null : new Long(conectorParametro("hFormaPago"));

        traza("hDestino " + conectorParametro("hDestino"));
        Long long8 = conectorParametro("hDestino").equals("") ? null : new Long(conectorParametro("hDestino"));

        traza("hObservacion " + conectorParametro("hObservacion"));
        String s3 = conectorParametro("hObservacion");

        traza("hIndicadorDigitacion " + conectorParametro("hIndicadorDigitacion"));
        Boolean boolean1 = conectorParametro("hIndicadorDigitacion").equals("") ? null : new Boolean(conectorParametro("hIndicadorDigitacion"));

        traza("hFechaPrevistaFact " + conectorParametro("hFechaPrevistaFact"));
        String s4 = conectorParametro("hFechaPrevistaFact");

        traza("hMoneda " + conectorParametro("hMoneda"));
        Long moneda = conectorParametro("hMoneda").equals("") ? null : new Long(conectorParametro("hMoneda"));

        traza("hAlmacen " + conectorParametro("hAlmacen"));
        Long almacen = conectorParametro("hAlmacen").equals("") ? null : new Long(conectorParametro("hAlmacen"));

        traza("hModulo " + conectorParametro("hModulo"));
        Long modulo = conectorParametro("hModulo").equals("") ? null : new Long(conectorParametro("hModulo"));

        traza("hTipoCliente " + conectorParametro("hTipoCliente"));
        Long tipoCliente = conectorParametro("hTipoCliente").equals("") ? null : new Long(conectorParametro("hTipoCliente"));

        traza("hSociedad " + conectorParametro("hSociedad"));
        Long sociedad = conectorParametro("hSociedad").equals("") ? null : new Long(conectorParametro("hSociedad"));

        traza("hTerritorio " + conectorParametro("hTerritorio"));
        Long territorio = conectorParametro("hTerritorio").equals("") ? null : new Long(conectorParametro("hTerritorio"));

        traza("hZona " + conectorParametro("hZona"));
        Long zona = conectorParametro("hZona").equals("") ? null : new Long(conectorParametro("hZona"));

        traza("hNumeroSolicitud " + conectorParametro("hNumeroSolicitud"));
        String numeroSolicitud = conectorParametro("hNumeroSolicitud");

        traza("hUsuario " + conectorParametro("hUsuario"));
        String usuario = conectorParametro("hUsuario");

        traza("hFecha " + conectorParametro("hFecha"));
        Date fecha = conectorParametro("hFecha").equals("") ? null : Date.valueOf(conectorParametro("hFecha"));

        traza("hPermiteUnionSolicitudes " + conectorParametro("hPermiteUnionSolicitudes"));
        Boolean permiteUnionSolicitudes = conectorParametro("hPermiteUnionSolicitudes").equals("") ? null : new Boolean(conectorParametro("hPermiteUnionSolicitudes"));

        traza("hIndPedidoPrueba " + conectorParametro("hIndPedidoPrueba"));
        Boolean indPedidoPrueba = conectorParametro("hIndPedidoPrueba").equals("") ? null : new Boolean(conectorParametro("hIndPedidoPrueba"));

        traza("hIndTSNoConsolidado " + conectorParametro("hIndTSNoConsolidado"));
        Boolean indTSNoConsolidado = conectorParametro("hIndTSNoConsolidado").equals("") ? null : new Boolean(conectorParametro("hIndTSNoConsolidado"));

        traza("hUbigeo " + conectorParametro("hUbigeo"));
        Long ubigeo = conectorParametro("hUbigeo").equals("") ? null : new Long(conectorParametro("hUbigeo"));

        traza("hEstado " + conectorParametro("hEstado"));
        Long estado = conectorParametro("hEstado").equals("") ? null : new Long(conectorParametro("hEstado"));

        traza("hSubtipoCliente " + conectorParametro("hSubtipoCliente"));
        Long subtipoCliente = conectorParametro("hSubtipoCliente").equals("") ? null : new Long(conectorParametro("hSubtipoCliente"));

        traza("hClaseSolicitud " + conectorParametro("hClaseSolicitud"));
        Long claseSolicitud = conectorParametro("hClaseSolicitud").equals("") ? null : new Long(conectorParametro("hClaseSolicitud"));

        traza("hOperacion " + conectorParametro("hOperacion"));
        Long operacion = conectorParametro("hOperacion").equals("") ? null : new Long(conectorParametro("hOperacion"));

        traza("hProceso " + conectorParametro("hProceso"));
        Long proceso = conectorParametro("hProceso").equals("") ? null : new Long(conectorParametro("hProceso"));

        traza("hOrdenCompra " + conectorParametro("hOrdenCompra"));
        Boolean ordenCompra = conectorParametro("hOrdenCompra").equals("") ? null : new Boolean(conectorParametro("hOrdenCompra"));

        traza("hTipoConsolidado " + conectorParametro("hTipoConsolidado"));
        Long tipoConsolidado = conectorParametro("hTipoConsolidado").equals("") ? null : new Long(conectorParametro("hTipoConsolidado"));

        traza("hSubgerencia " + conectorParametro("hSubgerencia"));
        Long subgerencia = conectorParametro("hSubgerencia").equals("") ? null : new Long(conectorParametro("hSubgerencia"));

        traza("hRegion " + conectorParametro("hRegion"));
        Long region = conectorParametro("hRegion").equals("") ? null : new Long(conectorParametro("hRegion"));

        traza("hSeccion " + conectorParametro("hSeccion"));
        Long seccion = conectorParametro("hSeccion").equals("") ? null : new Long(conectorParametro("hSeccion"));

        traza("hMonofacturacion " + conectorParametro("hMonofacturacion"));
        Boolean monofacturacion = conectorParametro("hMonofacturacion").equals("") ? null : new Boolean(conectorParametro("hMonofacturacion"));

        traza("hOK " + conectorParametro("hOK"));
        Boolean OK = conectorParametro("hOK").equals("") ? null : new Boolean(conectorParametro("hOK"));

        traza("hMensajeError " + conectorParametro("hMensajeError"));
        String mensajeError = conectorParametro("hMensajeError");

        traza("hIndMasSolicitudes " + conectorParametro("hIndMasSolicitudes"));
        Boolean indMasSolicitudes = conectorParametro("hIndMasSolicitudes").equals("") ? null : new Boolean(conectorParametro("hIndMasSolicitudes"));

        traza("hDestinatario " + conectorParametro("hDestinatario"));
        Long destinatario = conectorParametro("hDestinatario").equals("") ? null : new Long(conectorParametro("hDestinatario"));

        traza("hOidConcursoParametros " + conectorParametro("hOidConcursoParametros"));
        Long oidConcursoParametros = conectorParametro("hOidConcursoParametros").equals("") ? null : new Long(conectorParametro("hOidConcursoParametros"));

        traza("hOidDocumentoReferencia " + conectorParametro("hOidDocumentoReferencia"));
        Long oidDocumentoReferencia = conectorParametro("hOidDocumentoReferencia").equals("") ? null : new Long(conectorParametro("hOidDocumentoReferencia"));

        traza("hNumeroPremio " + conectorParametro("hNumeroPremio"));
        Integer numeroPremio = conectorParametro("hNumeroPremio").equals("") ? null : new Integer(conectorParametro("hNumeroPremio"));

        traza("hOidTerritorioAdministrativo " + conectorParametro("hOidTerritorioAdministrativo"));
        Long oidTerritorioAdministrativo = conectorParametro("hOidTerritorioAdministrativo").equals("") ? null : new Long(conectorParametro("hOidTerritorioAdministrativo"));

		traza("hTipoCambio " + conectorParametro("hTipoCambio"));
        Double tipoCambio = conectorParametro("hTipoCambio").equals("") ? null : new Double(conectorParametro("hTipoCambio"));

		if ((s4 != null) && !s4.equals(""))  {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date fechaDate = sdf.parse(s4);
			fechaPrevista = new Timestamp(fechaDate.getTime());				
		}

        dtocabecerasolicitud.setOidPais(this.aPais);
        dtocabecerasolicitud.setOidIdioma(this.aIdioma);
		dtocabecerasolicitud.setIpCliente(es.indra.sicc.util.UtilidadesBelcorp.getIPCliente(this));

        dtocabecerasolicitud.setTipoSolicitud(long1);
        dtocabecerasolicitud.setTipoDespacho(long2);
        dtocabecerasolicitud.setPeriodo(long3);
        dtocabecerasolicitud.setCliente(s);
        dtocabecerasolicitud.setOidCliente(longCliente);
        dtocabecerasolicitud.setNumeroClientes(integer);
        dtocabecerasolicitud.setReceptorFactura(s1);
        dtocabecerasolicitud.setOidReceptorFactura(longRecepFac);
        dtocabecerasolicitud.setPagadorFactura(s2);
        dtocabecerasolicitud.setOidPagadorFactura(longPagFac);
        dtocabecerasolicitud.setAccesoFisico(long4);
        dtocabecerasolicitud.setTipoDocumento(long5);
        dtocabecerasolicitud.setTipoDocumentoLegal(long6);
        dtocabecerasolicitud.setFormaPago(long7);
        dtocabecerasolicitud.setDestino(long8);
        dtocabecerasolicitud.setObservaciones(s3);
        dtocabecerasolicitud.setIndicadorDigitacion(boolean1);
        dtocabecerasolicitud.setMarca(this.aMarca);
        dtocabecerasolicitud.setCanal(this.aCanal);
        dtocabecerasolicitud.setAcceso(this.aAcceso);
        dtocabecerasolicitud.setSubacceso(this.aSubacceso);
        dtocabecerasolicitud.setMoneda(moneda);
        dtocabecerasolicitud.setAlmacen(almacen);
        dtocabecerasolicitud.setModulo(modulo);
        dtocabecerasolicitud.setTipoCliente(tipoCliente);
        dtocabecerasolicitud.setSociedad(sociedad);
        dtocabecerasolicitud.setTerritorio(territorio);
        dtocabecerasolicitud.setZona(zona);
        dtocabecerasolicitud.setNumeroSolicitud(numeroSolicitud);
        dtocabecerasolicitud.setUsuario(usuario);
        dtocabecerasolicitud.setFecha(fecha);
        dtocabecerasolicitud.setPermiteUnionSolicitudes(permiteUnionSolicitudes);
        dtocabecerasolicitud.setIndPedidoPrueba(indPedidoPrueba);
        dtocabecerasolicitud.setIndTSNoConsolidado(indTSNoConsolidado);
        dtocabecerasolicitud.setUbigeo(ubigeo);
        dtocabecerasolicitud.setEstado(estado);
        dtocabecerasolicitud.setSubtipoCliente(subtipoCliente);
        dtocabecerasolicitud.setClaseSolicitud(claseSolicitud);
        dtocabecerasolicitud.setOperacion(operacion);
        dtocabecerasolicitud.setProceso(proceso);
        dtocabecerasolicitud.setOrdenCompra(ordenCompra);
        dtocabecerasolicitud.setTipoConsolidado(tipoConsolidado);
        dtocabecerasolicitud.setSubgerencia(subgerencia);
        dtocabecerasolicitud.setRegion(region);
        dtocabecerasolicitud.setSeccion(seccion);
    //		dtocabecerasolicitud.setMonofacturacion(monofacturacion);
        dtocabecerasolicitud.setOK(OK);
        dtocabecerasolicitud.setMensajeError(mensajeError);		
        dtocabecerasolicitud.setIndMasSolicitudes(indMasSolicitudes);
		if (destinatario != null){
			dtocabecerasolicitud.setDestinatario(destinatario);		
		}else{
	        dtocabecerasolicitud.setDestinatario(longCliente);
		}
        dtocabecerasolicitud.setOidConcursoParametros(oidConcursoParametros);
        dtocabecerasolicitud.setOidDocumentoReferencia(oidDocumentoReferencia);
        dtocabecerasolicitud.setNumeroPremio(numeroPremio);
        dtocabecerasolicitud.setFechaPrevistaFacturacion(fechaPrevista);
        dtocabecerasolicitud.setOidTerritorioAdministrativo(oidTerritorioAdministrativo);
		dtocabecerasolicitud.setTipoCambio(tipoCambio);
        return dtocabecerasolicitud;
    }

    public DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dtocabecerasolicitud, Integer integer, String s,
        Long long1) throws Exception {

        traza("Entro al metodo generarPosicion().....");
        DTOPosicionSolicitud dtoposicionsolicitud = new DTOPosicionSolicitud();
        dtoposicionsolicitud.setNumeroPosicion(new Long(integer.longValue()));
        dtoposicionsolicitud.setCodigoVenta(s);
        dtoposicionsolicitud.setUnidadesDemandadas(long1);
        dtoposicionsolicitud.setOK(new Boolean(true));
        dtocabecerasolicitud.getPosiciones().add(dtoposicionsolicitud);
        traza("Sale del metodo generarPosicion().....");
        
        return dtocabecerasolicitud;

    }

    public void reportarErrores(DTOCabeceraSolicitud dtocabecerasolicitud)
        throws Exception {
        Long long1 = new Long(0L);
        Long long2 = new Long(0L);
        ArrayList arraylist = dtocabecerasolicitud.getPosiciones();
		StringBuffer datosDetalle = new StringBuffer();

        for (int i = 0; i < arraylist.size(); i++) {
            DTOPosicionSolicitud dtoposicionsolicitud = (DTOPosicionSolicitud) arraylist.get(i);
				traza("ESTE ES EL DTOPosicionSolictud: " + dtoposicionsolicitud);

            if (!dtoposicionsolicitud.getOK().booleanValue()) {

//				Mostramos el mensaje correspondiente (DTOPosicionSolicitud.mensajeError) en la 
//				tercera columna de la lista de posiciones para la linea indicada 
//				Utilizaremos el color rojo para mostrar los mensajes de error. 

				traza("Esto es el codigo del mensaje del DTO: " + dtoposicionsolicitud.getMensajeError());

				String descripcionError = obtenerDescripcionError(dtoposicionsolicitud.getMensajeError());
				if (dtoposicionsolicitud.getUnidadesMaximas() != null)  {
					descripcionError += " " + dtoposicionsolicitud.getUnidadesMaximas();						
				}
				
				
				traza("Esta es la decripcion del error: " + descripcionError);
				String codigoVTA = dtoposicionsolicitud.getCodigoVenta();
				datosDetalle.append(codigoVTA + "," + descripcionError + "|");
				
				if(dtoposicionsolicitud.getCvOK() != null){				
					if (!dtoposicionsolicitud.getCvOK().booleanValue()) {
						long1 = new Long(long1.longValue() + 1L);
					} else {
						long2 = new Long(long2.longValue() + 1L);
					}
				}
            }
			
        }


		datosDetalle.deleteCharAt(datosDetalle.length()-1);
		traza("Asi quedaron los detalles erroneos para enviar a la pagina: " + datosDetalle.toString());
		this.strDatosDetalleKO = datosDetalle.toString();
		traza("Esto es long1: " + long1);
        long1 = new Long(obtenerErrorCV().longValue() + long1.longValue());
		traza("Esto es long2: " + long2);
        long2 = new Long(obtenerCV().longValue() + long2.longValue());
        actualizarEstadisticas(null, null, long2, long1);
        //guardarEstadisticas();
    }


    public Long cargarCabecera() throws Exception {
        traza("Antes de llamar al metodo obtenerDatosIniciales() ");
        obtenerDatosIniciales();
        traza("Antes de llamar al metodo seleccionarTipoSolicitud() ");
        seleccionarTipoSolicitud();
        traza("Antes de llamar al metodo seleccionarPeriodo() ");
        obtenerPeriodos();
        traza("Antes de  llamar al metodo seleccionarPeriodo() ");
        seleccionarPeriodo();
        traza("Antes de llamar al metodo obtenerValoresDefecto() ");
        DTOValoresDefecto dtovaloresdefecto1 = obtenerValoresDefecto();
		if (dtovaloresdefecto1.getValor()[1] != null) {
			asignarAtributo("VAR", "destinoVD", "valor",dtovaloresdefecto1.getValor()[1]);
		}
		traza("destinoVD: " + dtovaloresdefecto1.getValor()[1]);
        traza("Despues de llamar al metodo obtenerValoresDefecto() ");

        return null;
    }

    private String[] construirLineas(String s, String s1)
        throws Exception {
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        String[] as = new String[stringtokenizer.countTokens()];

        for (int i = 0; stringtokenizer.hasMoreTokens(); i++) {
            as[i] = stringtokenizer.nextToken();
        }

        return as;
    }

    public void seleccionarTipoSolicitud() throws Exception {
        traza("Antes de obtener de sesion TIPO_SOLICITUD ..");
        sesion = getSessionCache();
        tipoSolicitud = (Long) sesion.get("TIPO_SOLICITUD");
        traza("Despues de obtener de sesion TIPO_SOLICITUD ..");

        if (tipoSolicitud == null) {
            traza("El TIPO_SOLICITUD es : " + tipoSolicitud);
            tipoSolicitud = obtenerPrimerElementoCombo("cbTipoSolicitud");
            traza("El TIPO_SOLICITUD es : " + tipoSolicitud);
            asignarAtributo("VAR", "hOidTipoSolicitud", "valor",
                tipoSolicitud.toString());
            obtenerValoresAsociadosTipoSolicitud();
        } else {
            traza("El TIPO_SOLICITUD no es null: " + tipoSolicitud);
            asignarAtributo("VAR", "hOidTipoSolicitud", "valor",
                tipoSolicitud.toString());
        }
    }

    private ComposerViewElementList crearParametrosEntradaPeriodos(
        DTOPeriodo dtoperiodo) throws Exception {
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness("CRAObtienePeriodosFecha");
        composerviewelement.setDTOE(dtoperiodo);
        composerviewelementlist.addViewElement(composerviewelement);

        return composerviewelementlist;
    }

    private Long obtenerPrimerElementoCombo(String s) throws Exception {
        Document document = getXML();
        Object obj = null;
        Object obj1 = null;
        NodeList nodelist = null;
        Object obj2 = null;
        Object obj3 = null;
        String s1 = null;
        nodelist = document.getDocumentElement().getElementsByTagName("COMBO");

        int i = nodelist.getLength();

        try  {
            for (int j = 0; j < i; j++) {
                if (((Element) nodelist.item(j)).getAttribute("nombre").equals(s)) {
                    NodeList nodelist1 = ((Element) nodelist.item(j)).getElementsByTagName(
                            "ROW");
                    NodeList nodelist2 = ((Element) nodelist1.item(0)).getElementsByTagName(
                            "CAMPO");
                    s1 = ((Text) nodelist2.item(0).getFirstChild()).getData();
                }
            }
        } catch (Exception ex)  {
            return null;
        } 

        return new Long(s1);
    }

	private String obtenerDescripcionError(String codigoError) throws Exception {

		MareException me = new MareException(null,null,UtilidadesError.armarCodigoError(codigoError));
		DTOError dtoError = (new BelcorpError()).obtenerError( me, UtilidadesSession.getIdioma_ISO(this), 
																UtilidadesSession._ISO(this));
		return dtoError.getDescripcionError();
	}

	private void limpiarAtributosSesion() throws Exception {
		sesion = getSessionCache();
		sesion.put("TIPO_SOLICITUD", null);
        sesion.put("PERIODO", null);
        sesion.put("NUMERO_OC", null);
        sesion.put("ERROR_OC", null);
        sesion.put("NUMERO_CV", null);
        sesion.put("ERROR_CV", null);
        sesion.put("OID_ESTADISTICAS", null);
        sesion.put("FECHA_INICIO", null);
        sesion.put("FECHA_FIN", null);
        sesion.put("MARCA", null);
        sesion.put("CANAL", null);
        sesion.put("ACCESO", null);
        sesion.put("SUBACCESO", null);
        sesion.put("TIPO_CLIENTE", null);
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/11/2004
	 * @version     3.1
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Método agregado por la incidencia BELC300010043.  Detalles
	 * 				de la implementación en el cuerpo del método.
	 */
	private void modificarCliente() throws Exception{
		traza("### Entro a modificarCliente ###");
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
		// idBusiness= "MAEBusquedaRapidaClientes" 
		MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
        // Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
		// - pais 
		// - idioma 
		// - codigoCliente: Valor introducido en txtCliente 
		DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
		dto.setIndicadorSituacion(new Long(0));
		dto.setTamanioPagina(new Integer(1));
		dto.setOidPais(UtilidadesSession.getPais(this));
		dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		//pperez 11/12/2004 incidencia 10044

		String codigoCliente = new String();
		String indBusquedaCodigo = conectorParametroLimpia("hIndicadorBusquedaCliente", "", true);
		if (indBusquedaCodigo.equals("P"))  {
			codigoCliente = conectorParametroLimpia("txtPagadorFactura", "", true);
		} else if (indBusquedaCodigo.equals("R"))  {
			codigoCliente = conectorParametroLimpia("txtReceptorFactura", "", true);
		} else {
			codigoCliente = conectorParametroLimpia("txtCodCliente", "", true);
		}
		//pperez 11/12/2004 incidencia 10044

		asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda('" + indBusquedaCodigo + "')");
		traza("Código de cliente capturado: " + codigoCliente);
		dto.setCodigoCliente(codigoCliente);		
		// Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(idBusiness);
		traza("Conectando a ConectorBusquedaRapidaCliente... ");
		DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", parametros);
		traza("Conectó.");
		// Recibe un DTOSalida (con un registro) 
		DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
		RecordSet retorno = dtoRetornado.getResultado();
		traza("Retornó: ");
		traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID"));
		traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));
		traza(" - VAL_NOM1: " + (String)retorno.getValueAt(0, "VAL_NOM1"));
		traza(" - VAL_APE1: " + (String)retorno.getValueAt(0, "VAL_APE1"));		
		// Asigna la pagina PGOcultaCliente y pasa los parámetros: 
		// - oid 
		// - nombre1 
		// - apellido1
//		asignarAtributo("VAR", "hOidCliente", "valor", ((BigDecimal)retorno.getValueAt(0, "OID")).toString());
//		asignarAtributo("VAR", "nombreUsuario", "valor", (String)retorno.getValueAt(0, "VAL_NOM1"));
//		asignarAtributo("VAR", "apellidoUsuario", "valor", (String)retorno.getValueAt(0, "VAL_APE1"));

		String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
		String nombreUsuario = (String)retorno.getValueAt(0, "VAL_NOM1");
		String apellidoUsuario = (String)retorno.getValueAt(0, "VAL_APE1");
		
		String funcion = new String("asignarDatosCliente('" + oidCliente + "','" + nombreUsuario + "','" + apellidoUsuario + "','" + indBusquedaCodigo + "')");

		traza("Funcion a ejecutar: " + funcion);
		
		asignarAtributo("VAR", "ejecutar", "valor", funcion);
		traza("PASO");
	}
    
    
    public void seleccionarSolicitud() throws Exception{
        /*Activa la LPVerificarSolicitud con: 
        - accion = "Seleccionar solicitud" 
        - posicionesDigitacion 
        - oidTipoSolicitud = oid del valor seleccionado en cbTipoSolicitud 
        - oidPeriodo = oid del valor seleccionado en cbPeriodo 
        - oidCliente = oid del valor seleccionado en txtCliente 
        */
        conectorAction("LPVerificarSolicitud");
        conectorActionParametro("accion","Seleccionar_solicitud");
        conectorActionParametro("hPosicionesDigitacion",sPosicionesDigitacion);
        conectorActionParametro("hOidTipoSolicitud",sOidTipoSolicitud);
        conectorActionParametro("hPeriodo",sPeriodo);
        conectorActionParametro("hOidCliente",sOidCliente);
        pagina("salidaGenerica");
    }

}

