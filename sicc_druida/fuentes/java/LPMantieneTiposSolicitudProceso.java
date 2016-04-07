/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         Pedidos
 * Componente:        LP
 * Fecha:             13/07/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Hugo Andrés Mansi
 */

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Iterator;
import java.util.Vector;


public class LPMantieneTiposSolicitudProceso extends LPSICCBase {
    private String casoDeUso;
    private String accion;
    private String seleccion;
    private Long idioma;
    private Long pais;
    private DruidaConector criterioBusqueda;
    private DTOBelcorp dtoBelcorp;
    private Vector paramEntrada;
    private MareBusinessID id;
    private Long oidI18N;

    public LPMantieneTiposSolicitudProceso() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            setTrazaFichero();
            this.rastreo();
            traza("entro a ejecucion");
            setTrazaFichero();
            accion = conectorParametroLimpia("accion", "", true);
            casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

            traza("entro al try");

            if (accion.equals("")) {
                traza("Entro en accion vacío");
                pagina("contenido_tipo_solicitud_proceso_insertar");
                anyadeHiddensI18N(true, "PED_TIPO_SOLIC_PROCE", oidI18N,
                    new Integer(1), "frmModificarI", "txtDescripcion", false);
            } else if (accion.equals("modificar")) {
                traza("Entro a modificar");
                muestraCarga(true);
                modifica();
                anyadeHiddensI18N(true, "PED_TIPO_SOLIC_PROCE", oidI18N,
                    new Integer(1), "frmModificarI", "txtDescripcion", false);
                getConfiguracionMenu("LPMantieneTiposSolicitudProceso","modificar");
                asignarAtributoPagina("cod", "0623");
            } else if (accion.equals("muestraConsulta")) {
                traza("Entro a muestra consulta");
                muestraCarga(false);
                getConfiguracionMenu("LPMantieneTiposSolicitudProceso",
                    "muestraConsulta");
                asignarAtributoPagina("cod", "0624");
            } else if (accion.equals("muestraBorrado")) {
                traza("Entro a muestra borrado");
                muestraCarga(false);
                getConfiguracionMenu("LPMantieneTiposSolicitudProceso",
                    "muestraBorrado");
                asignarAtributoPagina("cod", "0724");
            } else if (accion.equals("muestraModificacion")) {
                traza("Entro a muestra modificacion");
                muestraCarga(false);
                getConfiguracionMenu("LPMantieneTiposSolicitudProceso",
                    "muestraModificacion");
                asignarAtributoPagina("cod", "0623");
			} else if (accion.equals("muestraDetalle")) {
                traza("Entro a muestra detalle");
                traza("caso de uso   -> " + casoDeUso );  
                muestraCarga(true);
				modifica();
			    anyadeHiddensI18N(true, "PED_TIPO_SOLIC_PROCE", oidI18N,
                    new Integer(1), "frmModificarI", "txtDescripcion", true);
                if (casoDeUso.equals("eliminar")){
                  traza("gfgfg");
                  getConfiguracionMenu("LPMantieneTiposSolicitudProceso", "muestraDetalle");
                  asignarAtributoPagina("cod", "0724");

                }else{
                  traza("fdsfd");
                  getConfiguracionMenu("LPMantieneTiposSolicitudProceso", "muestraDetalle");
				  asignarAtributoPagina("cod", "0624");
				}
				  
            } else if (accion.equals("muestraInsercion")) {
                traza("Entro a muestra insercion");
			    muestraCarga(true);
                anyadeHiddensI18N(true, "PED_TIPO_SOLIC_PROCE", null, new Integer(1), "frmModificarI", "txtDescripcion", false);
                getConfiguracionMenu("LPMantieneTiposSolicitudProceso",
                    "insertar");
                asignarAtributoPagina("cod", "0723");
            } else if (accion.equals("guardar")) {
                traza("Entro a Guardar");
                guarda();
            }
        } catch (Exception e) {
            //preservaHiddensI18n(new Integer(1), "PED_TIPO_SOLIC_PROCE", "frmModificarI", "txtDescripcion", false);
           if (accion.equals("modificar"))
             asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");
           if (accion.equals("muestraInsercion"))
             asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");                 	  
 		   if (accion.equals("guardar"))
		     asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");                 	  
            traza(e);
            lanzarPaginaError(e);
        }

        
    }

    //fin de ejecución
    private void muestraCarga(boolean esInsercion) throws Exception {
        traza("entro a muestra carga");

        if (esInsercion) {
            traza("es insercion");
            pagina("contenido_tipo_solicitud_proceso_insertar");
            asignar("VAR", "casoDeUso", casoDeUso);
            asignar("VAR", "accion", accion);
            asignarAtributoPagina("casoDeUso", casoDeUso);
       
		}else {
            traza("no es insercion");
            pagina("contenido_tipo_solicitud_proceso_buscar");
            asignar("VAR", "casoDeUso", casoDeUso);
            asignar("VAR", "accion", accion);

        }

        cargarCombos();
    }//fin muestraCarga



    private void modifica() throws Exception {
        traza("entro a modifica");

        seleccion = conectorParametroLimpia("seleccion", "", true);
        traza("Seleccionado: " + seleccion);

        DTOOID dto = new DTOOID();
        dto.setOid(((seleccion == "") ? null : Long.valueOf(seleccion)));

        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        dto.setOidPais(UtilidadesSession.getPais(this));
        traza(dto);

        //crea el idNegocio
        id = new MareBusinessID("PEDdetallesTipoSolicitudProceso");
        paramEntrada = new Vector();
        paramEntrada.add(dto);
        paramEntrada.add(id);
        traza("antes del conector");

        criterioBusqueda = conectar("ConectorDetallesTiposSolicitudProceso",
                paramEntrada);

        traza("despues del conector");

        DTOTipoSolicitudProceso dtoProceso = (DTOTipoSolicitudProceso) criterioBusqueda.objeto(
                "dtoSalida");

        traza("AA" + dtoProceso);

        asignar("VAR", "hidCodOperacion",
            (dtoProceso.getOperacion() == null) ? ""
                                                : dtoProceso.getOperacion()
                                                            .toString());
        traza("BB");

        // dto.attriTraducible -> txtDescripcion 
        if (dtoProceso.getAttriTraducible() != null) {
            traza("CC");

            Iterator it = dtoProceso.getAttriTraducible().iterator();
            DTOI18nSICC dtoTraducible = null;

            while (it.hasNext()) {
                dtoTraducible = (DTOI18nSICC) it.next();

                if (dtoTraducible.getOidIdioma().equals(UtilidadesSession.getIdioma(
                                this))) {
                    traza("DD");
                    asignar("VAR", "hidTxtDescripcion",
                        dtoTraducible.getValorI18n());
                    oidI18N = new Long(dtoProceso.getOid().longValue());

                    break;
                }
            }
        }

        traza("FF");
        asignar("VAR", "hidTipoSolicitud",
            (dtoProceso.getTipoSolicitud() == null) ? ""
                                                    : dtoProceso.getTipoSolicitud()
                                                                .toString());
        traza("GG");
        asignar("VAR", "hidTipoPosicion",
            (dtoProceso.getTipoPosicion() == null) ? ""
                                                   : dtoProceso.getTipoPosicion()
                                                               .toString());
        traza("HH");
        asignar("VAR", "hidTipoSubposicion",
            (dtoProceso.getSubtipoPosicion() == null) ? ""
                                                      : dtoProceso.getSubtipoPosicion()
                                                                  .toString());
        traza("II");
        asignar("VAR", "hidTxtProducto",(dtoProceso.getProducto() == null) ? "": dtoProceso.getProducto());

        traza("JJ");
        asignar("VAR", "hidChkProducto",
            (dtoProceso.getIndProducto() == null) ? ""
                                                  : dtoProceso.getIndProducto()
                                                              .toString());

        traza("KK");
        asignar("VAR", "hidVarOid",
            (dtoProceso.getOid() == null) ? "" : dtoProceso.getOid().toString());
    }//fin modifica


/* Método Guarda()
 * Autor: Hugo Mansi
 * Fecha de realización: 19 de julio de 2004 
 * Última Modificación: 28 de julio de 2004
 * Descripción: Guarda los datos correspondientes a un
 * alta o modificación de un Tipo de Solicitud por Proceso. Si el OID en el deto
 */  

    private void guarda() throws Exception {
        traza("ENTRO AL METODO GUARDAR");

        Long oid;
        Long subTipoPos;
        String codProducto;
        Long tipoPosi;
        Long tipoSolic;
        String decript;
        Long codOper;
        String indProd;
    
        traza("hidVarOid:" + conectorParametroLimpia("hidVarOid", "", true));
        oid = ((conectorParametroLimpia("hidVarOid", "", true) == null) ||
            conectorParametroLimpia("hidVarOid", "", true).equals("")) ? null
                                                                       : Long.valueOf(conectorParametroLimpia(
                    "hidVarOid", "", true));

        traza("Oid  " + oid);
        traza("dsds  " + conectorParametroLimpia("cbSubtipoPosicion", "", true)); 
        subTipoPos = ((conectorParametroLimpia("cbSubtipoPosicion", "", true) == null) ||
            conectorParametroLimpia("cbSubtipoPosicion", "", true).equals("") ||
            conectorParametroLimpia("cbSubtipoPosicion", "", true).equals("|"))
            ? null:Long.valueOf(conectorParametroLimpia("cbSubtipoPosicion", "", true));
        traza("subTipoPos  " + subTipoPos);

        tipoPosi = ((conectorParametroLimpia("cbTipoPosicion", "", true) == null) ||
            conectorParametroLimpia("cbTipoPosicion", "", true).equals(""))
            ? null
            : Long.valueOf(conectorParametroLimpia("cbTipoPosicion", "", true));

        traza("tipoPosi= " + tipoPosi);

        codOper = ((conectorParametroLimpia("cbCodOperacion", "", true) == null) ||
            conectorParametroLimpia("cbCodOperacion", "", true).equals(""))
            ? null
            : Long.valueOf(conectorParametroLimpia("cbCodOperacion", "", true));

        traza("Cod Opera = " + codOper);

        codProducto = (conectorParametroLimpia("txtCodProducto", "", true)
                           .equals("")) ? ""
                                        : conectorParametroLimpia("txtCodProducto",
                "", true);
        traza("Cod Produ = " + codProducto);

        tipoSolic = ((conectorParametroLimpia("cbTipoSolicitud", "", true) == null) ||
            conectorParametroLimpia("cbTipoSolicitud", "", true).equals(""))
            ? null
            : Long.valueOf(conectorParametroLimpia("cbTipoSolicitud", "", true));

        traza("Tipo Solic = " + tipoSolic);

        decript = ((conectorParametroLimpia("txtDescripcion", "", true) == null) ||
            conectorParametroLimpia("txtDescripcion", "", true).equals(""))
            ? "" : conectorParametroLimpia("txtDescripcion", "", true);

        traza("Descripcion = " + decript);
        traza("-----> " + conectorParametroLimpia("CkProducto", "", true));  
        indProd = ((conectorParametroLimpia("CkProducto", "", true) == null)
		            ||
                    conectorParametroLimpia("CkProducto", "", true).equals(""))? 
					null : conectorParametroLimpia("CkProducto", "", true); 

        traza("Indicador Produ = " + indProd);

        DTOTipoSolicitudProceso dto = new DTOTipoSolicitudProceso();
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
		// Auditoria
		dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
        dto.setPrograma(UtilidadesSession.getFuncion(this));

        dto.setSubtipoPosicion(subTipoPos);
        dto.setTipoPosicion(tipoPosi);
        dto.setOperacion(codOper);
        dto.setProducto(codProducto);
        dto.setTipoSolicitud(tipoSolic);
        if (!indProd.equals("")){ 
           if (indProd.equals("S")){
             dto.setIndProducto(new Boolean(true));
		   }else{
		     dto.setIndProducto(new Boolean(false));
           }
		}else{
            dto.setIndProducto(null);
		}   
      
        dto.setOid(oid);
        dto.setAttriTraducible(recuperaTraduccionesI18N(new Integer(1)));
        traza("DTOOOOOOOOO  " + dto);
        traza("DTO I18 " + recuperaTraduccionesI18N(new Integer(1)));
        id = new MareBusinessID("PEDguardaTipoSolicitudProceso");

        paramEntrada = new Vector();
        paramEntrada.add(dto);
        paramEntrada.add(id);

        pagina("salidaGenerica");

        traza("antes del conector");

  	  
            criterioBusqueda = conectar("ConectorGuardarTiposSolicitudProceso",
                paramEntrada);
        traza("despues del conector");
        traza("ACCIONNNNN   " + accion) ;
		traza("caso de uso  " + casoDeUso);
        if (casoDeUso.equals("modificar")){
           
          asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
    	  
		}else{
		  asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar()");
  	      
        } 
    



    }//fin guarda


    //carga inicial de combos
    private void cargarCombos() throws Exception {
        traza("entro a cargar combos");

        //se preparan los parámetros del subsistema
        ComposerViewElementList cvList = crearParametrosEntrada();
        traza("1");

        ConectorComposerView conector = new ConectorComposerView(cvList,
                this.getRequest());
        traza("2");
        conector.ejecucion();
        traza("3");

        DruidaConector resultados = conector.getConector();
        traza("4");

        //cargamos los combos con los resultados 
        asignar("COMBO", "cbCodOperacion", resultados, "BELObtenerOperaciones");
        traza("5");
        asignar("COMBO", "cbTipoSolicitud", resultados,
            "PEDobtieneTiposSolicitudPorPais");
        traza("6");
        asignar("COMBO", "cbTipoPosicion", resultados,
            "PEDconsultaTiposPosicion");
    }

    private ComposerViewElementList crearParametrosEntrada()
        throws Exception {
        traza("entro en crear parametros");

        DTOBelcorp dto = new DTOBelcorp();
        traza("a");
        dto.setOidIdioma(idioma);
        traza("b");
        dto.setOidPais(pais);
        traza("c");

        ComposerViewElementList lista = new ComposerViewElementList();
        traza("d");

        //primer combo
        ComposerViewElement cmb1 = new ComposerViewElement();
        traza("e");
        cmb1.setIDBusiness("BELObtenerOperaciones");
        traza("f");
        cmb1.setDTOE(dto);
        traza("g");

        //segundo combo
        ComposerViewElement cmb2 = new ComposerViewElement();
        traza("h");
        cmb2.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
        traza("i");
        cmb2.setDTOE(dto);

        //tercer combo
        ComposerViewElement cmb3 = new ComposerViewElement();
        traza("j");
        cmb3.setIDBusiness("PEDconsultaTiposPosicion");
        traza("k");
        cmb3.setDTOE(dto);
        traza("l");
        lista.addViewElement(cmb1);
        traza("m");

        lista.addViewElement(cmb2);

        //traza("n");
        lista.addViewElement(cmb3);
        traza("ñ");
        traza("lista: " + lista.getSize());

        return lista;
    }

  
}


//Fin LPEliminaTiposSolicitudProceso 
