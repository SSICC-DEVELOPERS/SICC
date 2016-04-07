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

/*
    INDRA/CAR/PROY
    $Id: LPMantieneGestionStock.java,v 1.1 2009/12/03 18:35:21 pecbazalar Exp $
    DESC
*/

//import LPUtilGestionStock;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ped.DTOGestionCV;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.sicc.dtos.ped.DTOListaGestionStock;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.math.BigDecimal;

import java.util.Vector;


public class LPMantieneGestionStock extends LPUtilGestionStock {
    String accion = "";
    Long idioma;
    String marca;
    String canal;
    String periodo;
    String codigoVenta;
    String codSeleccionados;
    String region;
    String zona;
    String tipoCliente;
    String subTipoCliente;
    String tipoClasificacion;
    String clasificacion;
    String controlLiquidacion;
    String ultimasNoticias;
    String varGestionStock;
    String varIdGestionStock;
    String limiteVenta;
    String controlStock;
    String controlStockPorcentual;
    String codSeleccionadosEnListaEditable;
    String oid;
    String indSecuencial;
    String txtCatalogo;
    String txtClasificacion;
    String txtCodigoVenta;
    String txtRegion;
    String txtSubtipoCliente;
    String txtTipoClasificacion;
    String txtTipoCliente;
    String txtZona;
    String codigosVentaSeleccionados;
    // [1] String deshabilitarControlesCodigoVenta;
    // [1] String mostrarLista;
    // [1] String mostrarCapaDetalles;
    String marcaDefecto;
    String canalDefecto;
    Long lMarcaDefecto;
    Long lCanalDefecto;

    //Usados para actualizar la lista editable en el anyadir
    String txtRegionPagina;
    String txtZonaPagina;
    String txtTipoClientePagina;
    String txtSubtipoClentePagina;
    String txtTipoClasificacionPagina;
    String txtClasificacionPagina;
    String codigosVentaAEliminar;

    public LPMantieneGestionStock() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_gestion_stock_mantenimiento");        
    }

    public void ejecucion() throws Exception {
        try {
            rastreo();

            this.setTrazaFichero();

            this.getFormatosValidaciones();

            asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString() );

            //Se obtiene de sesion el dtoGestionStock. Si no existe en sesion se inicializa
            //a null.
            //dtoGestionStock = (DTOListaGestionStock) getSessionCache().get(sesionGestionStock); 
            //traza("Cache en sesion: " + getSessionCache());

            //dtoGestionStock = (DTOListaGestionStock) getSessionCache().get("sesionGestionStock");


			/*if (dtoGestionStock != null) {
                traza(dtoGestionStock.toString());
            } else {
                traza("null");
            }*/

            //-Obtencion de idioma----------------------------------------------------
            idioma = UtilidadesSession.getIdioma(this);
            this.asignarAtributo("VAR", "hIdioma", "valor",
                ((idioma == null) ? "" : idioma.toString()));

			Integer formato = new Integer(LPSICCBase.FORMATO_DEFAULT);
			asignar("VAR", "formato", formato.toString());
			
            //------------------------------------------------------------------------
            //-Obtencion de campos del formulario-------------------------------------
            accion = this.conectorParametroLimpia("accion", "", true);
            marca = this.conectorParametroLimpia("hMarca", "", true);
            canal = this.conectorParametroLimpia("hCanal", "", true);
            periodo = this.conectorParametroLimpia("hPeriodo", "", true);
	        
			/* [1] mostrarCapaDetalles = this.conectorParametroLimpia("hMostrarCapaDetalles",
                    "", true);*/
			/* [1] mostrarLista = this.conectorParametroLimpia("hMostrarLista", "",
                    true);*/
         
			siI18N = this.conectorParametroLimpia("hSiI18N", "", true);
            noI18N = this.conectorParametroLimpia("hNoI18N", "", true);

            marcaDefecto = this.conectorParametroLimpia("hMarcaDefecto", "",
                    true);
            canalDefecto = this.conectorParametroLimpia("hCanalDefecto", "",
                    true);
			// [1] deshabilitarControlesCodigoVenta = this.conectorParametroLimpia("hDeshabilitarControlesCodigoVenta","", true);

            //traza("accion: " + accion);
            //traza("marca: " + marca);
            //traza("canal: " + canal);
            //traza("periodo: " + periodo);

			///*[1]
			/*codigoVenta = this.conectorParametroLimpia("txtCodigoVenta", "",
                    true);
            codSeleccionados = this.conectorParametroLimpia("hCodSeleccionados",
                    "", true);

            region = this.conectorParametroLimpia("hRegion", "", true);
            zona = this.conectorParametroLimpia("hZona", "", true);
            tipoCliente = this.conectorParametroLimpia("hTipoCliente", "", true);
            subTipoCliente = this.conectorParametroLimpia("hSubtipoCliente",
                    "", true);
            tipoClasificacion = this.conectorParametroLimpia("hTipoClasificacion",
                    "", true);
            clasificacion = this.conectorParametroLimpia("hClasificacion", "",
                    true);
            controlLiquidacion = this.conectorParametroLimpia("hControlLiquidacion",
                    "", true);
            ultimasNoticias = this.conectorParametroLimpia("hUltimasNoticias",
                    "", true);

            limiteVenta = conectorParametroNumero("txtLimiteVenta",
                    this.FORMATO_DEFAULT);
            controlStock = conectorParametroNumero("txtControlStock",
                    this.FORMATO_DEFAULT);
            controlStockPorcentual = conectorParametroNumero("txtControlStockPorcentual",
                    this.FORMATO_DEFAULT);

            varGestionStock = this.conectorParametroLimpia("varGestionStock",
                    "", true);
            varIdGestionStock = this.conectorParametroLimpia("varIdGestionStock",
                    "", true);

            codSeleccionadosEnListaEditable = this.conectorParametroLimpia("hCodSeleccionadosEnListaEditable",
                    "", true);
            codigosVentaSeleccionados = this.conectorParametroLimpia("registrosSeleccionados",
                    "", true);
            
           
            indSecuencial = this.conectorParametroLimpia("hCodSeleccionadosEnListaEditable",
                    "", true);


            //Usados para actualizar la lista editable en el anyadir
            txtRegionPagina = this.conectorParametroLimpia("hTxtRegion", "",
                    true);
            txtZonaPagina = this.conectorParametroLimpia("hTxtZona", "", true);
            txtTipoClientePagina = this.conectorParametroLimpia("hTxtTipoCliente",
                    "", true);
            txtSubtipoClentePagina = this.conectorParametroLimpia("hTxtSubtipoCliente",
                    "", true);
            txtTipoClasificacionPagina = this.conectorParametroLimpia("hTxtTipoClasificacion",
                    "", true);
            txtClasificacionPagina = this.conectorParametroLimpia("hTxtClasificacion",
                    "", true);

            codigosVentaAEliminar = this.conectorParametroLimpia("hCodigosVentaAEliminar",
                    "", true);

			traza("----------------------------------------------------------------");
            traza("accion: " + accion);
            traza("----------------------------------------------------------------");
            traza("marca: " + marca);
            traza("canal: " + canal);
            traza("periodo: " + periodo);
			[1] */
			if (accion.equals("")) {
                lMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
                lCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);
                marcaDefecto = ((lMarcaDefecto == null) ? ""
                                                        : lMarcaDefecto.toString());
                canalDefecto = ((lCanalDefecto == null) ? ""
                                                        : lCanalDefecto.toString());

                asignarAtributo("VAR", "hCargarMarcaCanalDefecto", "valor", "S");

                //[1] asignarNoRequeridoACamposDeModificacion();
                
				muestra();

                getConfiguracionMenu("LPMantieneGestionStock", "");
				asignarAtributo("VAR", "hMarcaDefecto", "valor", marcaDefecto);
				asignarAtributo("VAR", "hCanalDefecto", "valor", canalDefecto);

				asignarAtributo("VAR", "hMarca", "valor", marca);
				asignarAtributo("VAR", "hCanal", "valor", canal);
				asignarAtributo("VAR", "hPeriodo", "valor", periodo);

            } /*else if (accion.equals("buscar")) {
                consulta();
                getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            } else if (accion.equals("guardar")) {
                guarda();
                asignarAtributo("VAR", "hCargarMarcaCanalDefecto", "valor", "S");
                asignarNoRequeridoACamposDeModificacion();
                muestra();
                mostrarLista = "N";
                mostrarCapaDetalles = "N";
                getConfiguracionMenu("LPMantieneGestionStock", "");
            } else if (accion.equals("modificar")) {
                modifica();
                getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            } else if (accion.equals("anyadir")) {
                actualiza();
                getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            } else if (accion.equals("eliminar")) {
                elimina();
                getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            } else if (accion.equals("eliminarCodVenta")) {
                eliminarCodigoVenta();
            }*/ else if (accion.equals("buscarCodVenta")) {
                muestraBuscarCV();
                getConfiguracionMenu("LPMantieneGestionStock", "buscarCodVenta");
            }/*else if (accion.equals("aceptaCodVenta")) {
                aceptaCodigosVenta();
                getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            } else if (accion.equals("anyadirCodigo")) {
                anyadeCodigoVenta();
               getConfiguracionMenu("LPMantieneGestionStock", "modificar");
            }*/ else if (accion.equals("guarda2")) {
				guarda2();
            }else if (accion.equals("anyadeCodigoVenta2")) {
				anyadeCodigoVenta2();
            } 

            // [1] asignarAtributo("VAR", "hDeshabilitarControlesCodigoVenta","valor", deshabilitarControlesCodigoVenta);
            // [1] asignarAtributo("VAR", "hMostrarLista", "valor", mostrarLista);
            /* [1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor",
                mostrarCapaDetalles);*/

           
            //Guardar el dto en sesion
            //3.- Se almacena en sesión el dtoGestionStock: 
            //[1] getSessionCache().put("sesionGestionStock", dtoGestionStock);
        } catch (Exception ex) {
			traza("1");
            traza(ex);
			traza("2");

			/*if( !accion.equals("anyadirCodigo") ){
	            muestra();
			}
			traza("### DESPUES DE MUESTRA");

            asignarAtributo("VAR", "hMarca", "valor", marca);
            asignarAtributo("VAR", "hCanal", "valor", canal);
            asignarAtributo("VAR", "hPeriodo", "valor", periodo);

            asignarAtributo("VAR", "hAsignarCombosBusqueda", "valor", "S");

            asignarAtributo("VAR", "hMarcaDefecto", "valor", marcaDefecto);
            asignarAtributo("VAR", "hCanalDefecto", "valor", canalDefecto);*/

            lanzarPaginaError(ex);
        }
    }

    /*private void modifica() throws Exception {
        traza(
            "******************************************************************");
        traza("ENTRA A MODIFICA");
        traza("DTO EN SESION");
        traza(dtoGestionStock);
        traza(
            "******************************************************************");

        Vector v = null;
        Enumeration e = null;
        DTOGestionStock dtoGS = null;
        Integer i = null;
        Long j = null;

        traza("codSeleccionadosEnListaEditable: " +
            codSeleccionadosEnListaEditable);

        //Se eliminan los codigos de venta
        dtoGestionStock.setCodigosVenta(new Vector());

        if ((codSeleccionadosEnListaEditable != null) &&
                (codSeleccionadosEnListaEditable.length() > 0)) {
            //i = new Integer( codSeleccionadosEnListaEditable );
            j = new Long(codSeleccionadosEnListaEditable);
        }

        v = dtoGestionStock.getDetalles();

        if (v != null) {
            e = v.elements();
        }

        while ((e != null) && e.hasMoreElements()) {
            dtoGS = (DTOGestionStock) e.nextElement();

            if (dtoGS.getOid().equals(j)) {
                break;
            }
        }

        //Asignar los valores de dtoGS a la pagina
        clasificacion = ((dtoGS != null && dtoGS.getClasificacion()!=null ) ? dtoGS.getClasificacion().toString(): "");
        codigoVenta = (((dtoGS != null) && (dtoGS.getCodigoVenta() != null))
            ? dtoGS.getCodigoVenta().toString() : ""); //long
        controlLiquidacion = (((dtoGS != null) &&
            (dtoGS.getControlLiquidacion() != null) &&
            dtoGS.getControlLiquidacion().booleanValue()) ? "S" : "N"); //Boolean
        varIdGestionStock = (((dtoGS != null) && (dtoGS.getId() != null))
            ? dtoGS.getId().toString() : ""); //integer

        //dtoGS.getIndEliminar() //Boolean
        indSecuencial = (((dtoGS != null) &&
            (dtoGS.getIndSecuencial() != null))
            ? dtoGS.getIndSecuencial().toString() : ""); //integer
        ultimasNoticias = (((dtoGS != null) &&
            (dtoGS.getIndUltNoticias() != null) &&
            dtoGS.getIndUltNoticias().booleanValue()) ? "S" : "N"); //Boolean
        limiteVenta = (((dtoGS != null) && (dtoGS.getLimiteVenta() != null))
            ? dtoGS.getLimiteVenta().toString() : ""); //long

        //dtoGS.getNumPagina() //integer
        oid = (((dtoGS != null) && (dtoGS.getOid() != null))
            ? dtoGS.getOid().toString() : ""); //long
        region = (((dtoGS != null) && (dtoGS.getRegion() != null))
            ? dtoGS.getRegion().toString() : ""); //long
        subTipoCliente = (((dtoGS != null) &&
            (dtoGS.getSubtipoCliente() != null))
            ? dtoGS.getSubtipoCliente().toString() : ""); //long
        tipoClasificacion = (((dtoGS != null) &&
            (dtoGS.getTipoClasificacion() != null))
            ? dtoGS.getTipoClasificacion().toString() : ""); //long
        tipoCliente = (((dtoGS != null) && (dtoGS.getTipoCliente() != null))
            ? dtoGS.getTipoCliente().toString() : ""); //long
        txtCatalogo = (((dtoGS != null) && (dtoGS.getTxtCatalogo() != null))
            ? dtoGS.getTxtCatalogo() : ""); //string
        txtClasificacion = (((dtoGS != null) &&
            (dtoGS.getTxtClasificacion() != null))
            ? dtoGS.getTxtClasificacion() : ""); //string

        txtCodigoVenta = (((dtoGS != null) &&
            (dtoGS.getTxtCodigoVenta() != null))
            ? dtoGS.getTxtCodigoVenta().toUpperCase() : ""); //string
        txtRegion = (((dtoGS != null) && (dtoGS.getTxtRegion() != null))
            ? dtoGS.getTxtRegion() : ""); //string
        txtSubtipoCliente = (((dtoGS != null) &&
            (dtoGS.getTxtSubtipoCliente() != null))
            ? dtoGS.getTxtSubtipoCliente() : "");
        txtTipoClasificacion = (((dtoGS != null) &&
            (dtoGS.getTxtTipoClasificacion() != null))
            ? dtoGS.getTxtTipoClasificacion() : "");
        txtTipoCliente = (((dtoGS != null) &&
            (dtoGS.getTxtTipoCliente() != null)) ? dtoGS.getTxtTipoCliente() : "");
        txtZona = (((dtoGS != null) && (dtoGS.getTxtZona() != null))
            ? dtoGS.getTxtZona() : "");
        controlStockPorcentual = (((dtoGS != null) &&
            (dtoGS.getValorPorcentual() != null))
            ? dtoGS.getValorPorcentual().toString() : ""); //Double
        controlStock = (((dtoGS != null) && (dtoGS.getValorUnidades() != null))
            ? dtoGS.getValorUnidades().toString() : ""); //long
        zona = (((dtoGS != null) && (dtoGS.getZona() != null))
            ? dtoGS.getZona().toString() : ""); //long

        traza(
            "------------------------------------------------------------------");
        traza("VALORES PASADOS A CAMPOS PARA MODIFICAR");
        traza("oid: " + oid);
        traza("cod venta: " + codigoVenta);
        traza("region: " + region);
        traza("zona: " + zona);
        traza("tipo cliente: " + tipoCliente);
        traza("subtipo cliente: " + subTipoCliente);
        traza("tipo clasificacion: " + tipoClasificacion);
        traza("clasificacion: " + clasificacion);
        traza("limite venta: " + limiteVenta);
        traza("control stock: " + controlStock);
        traza("control stock porcentual: " + controlStockPorcentual);
        traza("control liquidacion: " + controlLiquidacion);
        traza("ultimas noticias: " + ultimasNoticias);
        traza("indSecuencial: " + indSecuencial);
        traza(
            "------------------------------------------------------------------");

        asignarAtributo("VAR", "hOid", "valor", oid);
        asignarAtributo("VAR", "varGestionStock", "valor", oid);
        asignarAtributo("VAR", "hRegion", "valor", region);
        asignarAtributo("VAR", "hSubtipoCliente", "valor", subTipoCliente);
        asignarAtributo("VAR", "hTipoClasificacion", "valor", tipoClasificacion);
        asignarAtributo("VAR", "hTipoCliente", "valor", tipoCliente);
        asignarAtributo("VAR", "hZona", "valor", zona);
        asignarAtributo("VAR", "hClasificacion", "valor", clasificacion);
        asignarAtributo("VAR", "hControlLiquidacion", "valor",
            controlLiquidacion);
        asignarAtributo("VAR", "hUltimasNoticias", "valor", ultimasNoticias);

        //asignarAtributo( "VAR", "hIndSecuencial", "valor", indSecuencial );
        asignarAtributo("VAR", "hCodSeleccionadosEnListaEditable", "valor",
            indSecuencial);

        //--------------------------------------------------------------------------
        traza(
            "------------------------------------------------------------------");
        traza("VALORES DE CAMPOS DE BUSQUEDA EN MODIFICAR");
        traza("marca: " + marca);
        traza("canal: " + canal);
        traza("periodo: " + periodo);
        traza(
            "------------------------------------------------------------------");

        //Cargar lista editable con datos de dtoGestionStock
        if ((dtoGestionStock != null) &&
                (dtoGestionStock.getDetalles() != null)) {
            muestraListaGestion(dtoGestionStock.getDetalles());
        }

        //Carga los combos de busqueda
        muestra();
		asignarAtributo("VAR", "accion", "valor", "modificar");

        //Combos de busqueda
        asignarAtributo("VAR", "hMarca", "valor", marca);
        asignarAtributo("VAR", "hCanal", "valor", canal);
        asignarAtributo("VAR", "hPeriodo", "valor", periodo);

        asignarAtributo("VAR", "hAsignarCombosBusqueda", "valor", "S");
        asignarAtributo("VAR", "hAsignarCamposModificar", "valor", "S");
        // [1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor", "S");

        //--------------------------------------------------------------------------
        RecordSet rsCodVenta = new RecordSet();

        Vector colIds = new Vector();
        colIds.add("OID");
        colIds.add("DESC");

        Vector row = new Vector();
        row.add(codigoVenta);
        row.add(txtCodigoVenta);

        rsCodVenta.setColumnIdentifiers(colIds);
        rsCodVenta.addRow(row);

        DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida",
                rsCodVenta, rsCodVenta.getColumnIdentifiers());

        //--------------------------------------------------------------------------
        traza("-------------------------------------------");
        traza("conector de codigos de venta");
        traza(con.getXML().toString());
        traza("-------------------------------------------");

        asignar("COMBO", "cbCodVenta2", con, "dtoSalida");

        try {
            asignarAtributo("CTEXTO", "txtLimiteVenta", "valor",
                UtilidadesBelcorp.formateaNumeroSICC(((limiteVenta == null)
                    ? "" : limiteVenta), LPSICCBase.FORMATO_DEFAULT, this));
        } catch (Exception nsee1) {
        }

        try {
            asignarAtributo("CTEXTO", "txtControlStock", "valor",
                UtilidadesBelcorp.formateaNumeroSICC(((controlStock == null)
                    ? "" : controlStock), LPSICCBase.FORMATO_DEFAULT, this));
        } catch (Exception nsee2) {
        }

        try {
            asignarAtributo("CTEXTO", "txtControlStockPorcentual", "valor",
                UtilidadesBelcorp.formateaNumeroSICC(((controlStockPorcentual == null)
                    ? "" : controlStockPorcentual), LPSICCBase.FORMATO_DEFAULT,
                    this));
        } catch (Exception nsee3) {
        }

        // [1] deshabilitarControlesCodigoVenta = "S";

        traza("SALE DE modifica()");
    }
*/
    private void muestra() throws Exception {
        // -1
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(UtilidadesSession.getPais(this));
        dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

        // -2
        ComposerViewElementList lista = new ComposerViewElementList();

        // -3
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("SEGConsultaCanales");
        elem.setDTOE(dtoe);
        elem.setPosOID((byte) 0);
        elem.setPosDesc((byte) 1);
        lista.addViewElement(elem);

        elem = new ComposerViewElement();
        elem.setIDBusiness("SEGConsultaMarcas");
        elem.setDTOE(dtoe);
        elem.setPosOID((byte) 0);
        elem.setPosDesc((byte) 1);
        lista.addViewElement(elem);

        elem = new ComposerViewElement();
        elem.setIDBusiness("MAEObtenerTipos");
        elem.setDTOE(dtoe);
        lista.addViewElement(elem);

        DTOUnidadAdministrativa dtoe2 = new DTOUnidadAdministrativa();
        dtoe2.setOidPais(UtilidadesSession.getPais(this));
        dtoe2.setOidIdioma(UtilidadesSession.getIdioma(this));

        elem = new ComposerViewElement();
        elem.setIDBusiness("ZONRecargaRegiones");
        elem.setDTOE(dtoe2);
        elem.setPosOID((byte) 0);
        elem.setPosDesc((byte) 1);
        lista.addViewElement(elem);

        // -4
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        if (conector != null) {
            conector.ejecucion();
            DruidaConector resultados = null;
            resultados = conector.getConector();
            // -5
            if (resultados != null) {
                asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
                asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
                asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipos");
                asignar("COMBO", "cbRegion", resultados, "ZONRecargaRegiones");
            }
        }
    }

   /* private void guarda() throws Exception {
        Vector params = new Vector();
        MareBusinessID id = new MareBusinessID("PEDGuardaGestionStock");
        params.add(dtoGestionStock);
        params.add(id);

        this.asignarParametrosAuditoria();

        DruidaConector con = conectar("ConectorGuardaGestionStock", params);
    }*/

	private void guarda2() throws Exception {
		pagina("salidaGenerica");
        Vector params = new Vector();
        MareBusinessID id = new MareBusinessID("PEDGuardaGestionStock");
		
		DTOListaGestionStock dtoListaGestion = new DTOListaGestionStock();
		Vector vDetalles = null ;
		String nombreItemsNuevos = "nuevoItem";
		String claves = this.conectorParametroLimpia("keys", "", true);
        String[] bufferClaves = null;
        String[] bufferAnyadidos = null;
        String auxClaves = null;
		String ipCliente = UtilidadesBelcorp.getIPCliente(this);
		String programa = UtilidadesSession.getFuncion(this);
		String periodo = this.conectorParametroLimpia("hPeriodo", "", true);;
		Long oidEnModificado= null;
		int blnElimina = 0;
		traza ("claves: "+claves);
        if (!claves.equals("")){
           bufferClaves =  claves.split(",");
           int i;
           int j;
		   vDetalles = new Vector();
		   traza ("claves: "+claves);
           for (i = 0; i<bufferClaves.length; i++){
			   DTOGestionStock dtoGestionStock = new DTOGestionStock();
               String valoresAnyadidos = this.conectorParametroLimpia(bufferClaves[i], "", true);
			   bufferAnyadidos = valoresAnyadidos.split(",");
			   traza ("valoresAnyadidos: "+valoresAnyadidos);
			   if (bufferAnyadidos[0].length() <= nombreItemsNuevos.length()){
				   dtoGestionStock.setOid((bufferAnyadidos[0]!=null)? Long.valueOf(bufferAnyadidos[0]):null);   
				   
			   } else if(!bufferAnyadidos[0].substring(0,nombreItemsNuevos.length()).equalsIgnoreCase(nombreItemsNuevos)){
					dtoGestionStock.setOid((bufferAnyadidos[0]!=null)? Long.valueOf(bufferAnyadidos[0]):null);   
			   }

			   if (bufferAnyadidos[20] != null && bufferAnyadidos[20].equalsIgnoreCase("S")){
					dtoGestionStock.setIndEliminar(Boolean.TRUE);
					blnElimina = 1;

			   }else{
			   
				   oidEnModificado = dtoGestionStock.getOid();
				   dtoGestionStock.setRegion( (bufferAnyadidos[1]!=null && !bufferAnyadidos[1].equals(""))? Long.valueOf(bufferAnyadidos[1]):null);
				   dtoGestionStock.setZona((bufferAnyadidos[3]!=null && !bufferAnyadidos[3].equals(""))?Long.valueOf(bufferAnyadidos[3]):null);
				   dtoGestionStock.setTipoCliente((bufferAnyadidos[5]!=null && !bufferAnyadidos[5].equals(""))?Long.valueOf(bufferAnyadidos[5]):null);
				   dtoGestionStock.setSubtipoCliente((bufferAnyadidos[7]!=null && !bufferAnyadidos[7].equals(""))?Long.valueOf(bufferAnyadidos[7]):null);
				   dtoGestionStock.setTipoClasificacion((bufferAnyadidos[9]!=null && !bufferAnyadidos[9].equals(""))?Long.valueOf(bufferAnyadidos[9]):null);
				   dtoGestionStock.setClasificacion((bufferAnyadidos[11]!=null && !bufferAnyadidos[11].equals(""))? Long.valueOf(bufferAnyadidos[11]):null);
				   dtoGestionStock.setLimiteVenta((bufferAnyadidos[13]!=null && !bufferAnyadidos[13].equals(""))? Long.valueOf(bufferAnyadidos[13]):null);
				   dtoGestionStock.setValorUnidades((bufferAnyadidos[14]!=null && !bufferAnyadidos[14].equals(""))?Long.valueOf(bufferAnyadidos[14]):null);
				   dtoGestionStock.setValorPorcentual((bufferAnyadidos[15]!=null && !bufferAnyadidos[15].equals(""))?Double.valueOf(bufferAnyadidos[15]):null);
				   dtoGestionStock.setIndUltNoticias(Boolean.FALSE);

				   dtoGestionStock.setControlLiquidacion(Boolean.FALSE);
				   if (bufferAnyadidos[16] != null && bufferAnyadidos[16].equalsIgnoreCase("S")){
						dtoGestionStock.setControlLiquidacion(Boolean.TRUE);
				   }

				   if (bufferAnyadidos[17] != null && bufferAnyadidos[17].equalsIgnoreCase("S")){
						dtoGestionStock.setIndUltNoticias(Boolean.TRUE);
				   } 
				   
				   dtoGestionStock.setCodigoVenta((bufferAnyadidos[18]!=null)? Long.valueOf(bufferAnyadidos[18]):null);

				   dtoGestionStock.setIndEliminar(Boolean.FALSE);
				   /*if (bufferAnyadidos[20] != null && bufferAnyadidos[20].equalsIgnoreCase("S")){
						dtoGestionStock.setIndEliminar(Boolean.TRUE);
				   } */
			   }
			   dtoGestionStock.setIpCliente(ipCliente);
		       dtoGestionStock.setPrograma(programa);
			   vDetalles.add(dtoGestionStock);
			   traza ("dtoGestionStock.getIndEliminar: "+dtoGestionStock.getIndEliminar());
			   traza ("dtoGestionStock.getOid(): "+dtoGestionStock.getOid());

           }// fin for
	       
		  
        }// fin if
		dtoListaGestion.setDetalles(vDetalles);
		dtoListaGestion.setPeriodo(Long.valueOf(periodo));
		traza ("periodo:" + periodo);
        params.add(dtoListaGestion);
        params.add(id);

        DruidaConector con = conectar("ConectorGuardaGestionStock", params);
		
        asignarAtributo("VAR","ejecutar","valor","resultadoGuardado("+ oidEnModificado +", "+ blnElimina +")");

    }

   /* private void asignarParametrosAuditoria() throws Exception {
        //lalalala
        //DTOListaGestionStock dtoGestionStock;
        String ipCliente = UtilidadesBelcorp.getIPCliente(this);
        String programa = UtilidadesSession.getFuncion(this);

        dtoGestionStock.setIpCliente(ipCliente);
        dtoGestionStock.setPrograma(programa);

        Vector vDetalle = null;
        DTOGestionStock dtoGS = null;
        Enumeration eGS = null;
        vDetalle = dtoGestionStock.getDetalles();

        if ((vDetalle != null) && (vDetalle.size() > 0)) {
            eGS = vDetalle.elements();

            while ((eGS != null) && eGS.hasMoreElements()) {
                dtoGS = (DTOGestionStock) eGS.nextElement();
                dtoGS.setIpCliente(ipCliente);
                dtoGS.setPrograma(programa);
            }
        }
    }
*/
    /*private void consulta() throws Exception {
        DTOListaGestionStock dtoS = new DTOListaGestionStock();

        dtoS.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoS.setMarca((((marca != null) && !marca.equals("")) ? new Long(marca) : null));
        dtoS.setCanal((((canal != null) && !canal.equals("")) ? new Long(canal) : null));
        dtoS.setPeriodo((((periodo != null) && !periodo.equals("")) ? new Long(periodo) : null));
        dtoS.setNumID(new Long(-1));
        dtoS.setDetalles(null);

        MareBusinessID id = new MareBusinessID("PEDConsultaGestionStock");

        Vector params = new Vector();
        params.add(dtoS);
        params.add(id);

        DruidaConector con = conectar("ConectorConsultaGestionStock", params);
        dtoS = (DTOListaGestionStock) con.objeto("DTOListaGestionStock");

        traza("---------------------------------------------------------------------");
        traza("dto obtenido en consulta");
        traza(dtoS);
        traza("---------------------------------------------------------------------");

       
        traza("********** va a llamar a muestraListaGestion( dtoS.getDetalles() )");

        if ((dtoS != null) && (dtoS.getDetalles() != null) && (dtoS.getDetalles().size() > 0)) {
            muestraListaGestion(dtoS.getDetalles());
        }

        traza("************ va a llamar a muestra");

        muestra();

        asignarAtributo("VAR", "hMarca", "valor", marca);
        asignarAtributo("VAR", "hCanal", "valor", canal);
        asignarAtributo("VAR", "hPeriodo", "valor", periodo);
        asignarAtributo("VAR", "hAsignarCombosBusqueda", "valor", "S");

        //[1] mostrarCapaDetalles = "S";
        //[1] mostrarLista = "S";
        dtoGestionStock = dtoS;
        // [1] deshabilitarControlesCodigoVenta = "N";

		
        traza("************** dtoGestionStock " + dtoGestionStock);
        traza("************** TERMINO");
    }
*/
   /* private void actualiza() throws Exception {
        traza("************* Entre a actualiza");
    
        Vector v = null;
//        Enumeration e = null;
        DTOGestionStock dtoGS = null;
        DTOGestionCV dtoGestionCV = null;
		
        //SI HAY ELEMENTOS ES UNA INSERCION
        traza("*************varGestionStock.");

		
        //		HARCODEADO		
        //		HARCODEADO	
        if (dtoGestionStock.getDetalles() == null) 	{
          traza("************* Entro el if - dtoGestionStock.getDetalles() es null");
          dtoGestionStock.setDetalles(new Vector());
        }	
		
        if (varGestionStock.equals("")) {
//            v = dtoGestionStock.getCodigosVenta();
//            traza("********** v " + v);
//            if ((v != null) && (v.size() > 0)) {
			  if( dtoGestionStock.getCodigosVenta() != null && dtoGestionStock.getCodigosVenta().size() > 0 ){
//                if (v != null) {
					traza("V.SIZE: " + dtoGestionStock.getCodigosVenta().size());
					Iterator it = dtoGestionStock.getCodigosVenta().iterator();
//                    e = v.elements();
//                }
			  

                //borrar
                //DTOListaGestionStock dtoGestionStock;
//                while ((e != null) && e.hasMoreElements()) {
				while( (it != null) && it.hasNext() ){
                    traza("************* WHILE *****************");
//                    dtoGestionCV = (DTOGestionCV) e.nextElement();
					dtoGestionCV = (DTOGestionCV)it.next();
                    traza("************* dtoGestionCV " + dtoGestionCV);
                    
                    dtoGS = new DTOGestionStock();

                    dtoGS.setOid(dtoGestionStock.getNumID());
                    dtoGestionStock.setNumID(new Long(dtoGestionStock.getNumID().longValue() - 1));

                    traza("*************** Antes del try");

                    try {
                      dtoGS.setId((((varIdGestionStock != null) && (varIdGestionStock.length() > 0)) ? new Integer(varIdGestionStock) : null));
                    } catch (NumberFormatException nfe) {
                      dtoGS.setId(null);
                    }


                    traza("*************** Seteando atributos al dtoGS ");
              
                    dtoGS.setCodigoVenta(dtoGestionCV.getCodigoVenta());
                    traza("*********** 1");
                    dtoGS.setTxtCodigoVenta(dtoGestionCV.getTxtCodigoVenta());
                    traza("*********** 2");
                    dtoGS.setRegion((((region == null) || (region.length() == 0)) ? null : new Long(region)));
                    traza("*********** 3");
                    dtoGS.setZona((((zona == null) || (zona.length() == 0)) ? null : new Long(zona)));
                    traza("*********** 4");
                    dtoGS.setTipoCliente((((tipoCliente == null) || (tipoCliente.length() == 0)) ? null : new Long(tipoCliente)));
                    traza("*********** 5");
                    dtoGS.setSubtipoCliente((((subTipoCliente == null) || (subTipoCliente.length() == 0)) ? null : new Long(subTipoCliente)));
                    traza("*********** 6");
                    dtoGS.setTipoClasificacion((((tipoClasificacion == null) || (tipoClasificacion.length() == 0)) ? null : new Long(tipoClasificacion)));
                    traza("*********** 7");
                    dtoGS.setClasificacion((((clasificacion == null) || (clasificacion.length() == 0)) ? null : new Long(clasificacion)));
                    traza("*********** 8");
                    dtoGS.setLimiteVenta((((limiteVenta == null) || (limiteVenta.length() == 0)) ? null : new Long(limiteVenta)));
                    traza("*********** 9");
                    dtoGS.setValorUnidades((((controlStock == null) || (controlStock.length() == 0)) ? null : new Long(controlStock)));
                    traza("***********Traza 10");
                    dtoGS.setValorPorcentual((((controlStockPorcentual == null) ||  (controlStockPorcentual.length() == 0)) ? null : new Double(controlStockPorcentual)));
                    traza("***********Traza 11");
                    dtoGS.setControlLiquidacion((((controlLiquidacion != null) &&  controlLiquidacion.equals("S")) ? Boolean.TRUE : Boolean.FALSE));
                    traza("***********Traza 12");
                    dtoGS.setIndUltNoticias((((ultimasNoticias != null) && ultimasNoticias.equals("S")) ? Boolean.TRUE : Boolean.FALSE));
                    traza("***********Traza 13");
                    dtoGS.setTxtCatalogo(dtoGestionCV.getCatalogo());
                    traza("***********Traza 14");
                    dtoGS.setNumPagina(dtoGestionCV.getNumPagina());
                    traza("***********Traza 15");
                    dtoGS.setTxtRegion(((txtRegionPagina == null) ? "" : txtRegionPagina));
                    traza("***********Traza 16");
                    dtoGS.setTxtZona(((txtZonaPagina == null) ? "" : txtZonaPagina));
                    traza("***********Traza 17");
                    dtoGS.setTxtTipoCliente(((txtTipoClientePagina == null) ? "" : txtTipoClientePagina));
                    traza("***********Traza 18");
                    dtoGS.setTxtSubtipoCliente(((txtSubtipoClentePagina == null) ? "" : txtSubtipoClentePagina));
                    traza("***********Traza 19");
                    dtoGS.setTxtTipoClasificacion(((txtTipoClasificacionPagina == null) ? "" : txtTipoClasificacionPagina));
                    traza("***********Traza 20");
                    dtoGS.setTxtClasificacion(((txtClasificacionPagina == null) ? "" : txtClasificacionPagina));

                    traza("***********lo agrego al dto de detalles para que se vea en la lista y posteriormente se guarde");              
              
                    dtoGestionStock.getDetalles().add(dtoGS);
                    traza("***********Despues de setear el detalle...!!!!!");

                    //2-
                    //traza("llama a esIgualZonTipo");
                    //esIgualZonTipo(dtoGS);
                    //3-
//                  traza("***********llama a v.remove");
					traza("***********llama a it.remove");

					it.remove();					
//                    dtoGestionStock.getCodigosVenta().remove(dtoGestionCV);

                    traza("*********** VALORES ");
                    traza("*********** dtoGS " + dtoGS);
                    traza("*********** dtoGestionStock " + dtoGestionStock);
                    
                    dtoGS = new DTOGestionStock();

                    //Habilitar campos
                    //Limpiar componentes
                }
				traza("############################################");
				traza("DTO con remocion: " + dtoGestionStock.getCodigosVenta());
				traza("############################################");
	        }
            //NO HAY ELEMENTOS, POR LO TANTO ES UNA MODIFICACION
        } else {
            //1 - de dtoGestionStock (el dto en sesion), obtener el DTOGestionStock que se corresponde
            //con el registro que estamos modificando. La busque se realiza por indSecuencial.
            Vector dtos = dtoGestionStock.getDetalles();
            Enumeration eDtos = null;
            DTOGestionStock dto = null;
            boolean found = false;

            //deprecated
            Integer iIndSecuencial = null;

            Long lVarGestionStock = null;

            try {
                lVarGestionStock = new Long(varGestionStock);

                if ((dtos != null) && (dtos.size() > 0)) {
                    eDtos = dtos.elements();

                    while (eDtos.hasMoreElements()) {
                        dto = (DTOGestionStock) eDtos.nextElement();

                        if ((dto != null) && (dto.getOid() != null) &&
                                dto.getOid().equals(lVarGestionStock)) {
                            found = true;

                            break;
                        }
                    }

                    if (found) {
                        traza("---------------------------------------------");
                        traza("ZONA EN DTO: " + dto.getZona());
                        traza("ZONA MODIFICADA: " + zona);
                        traza("---------------------------------------------");

                        //Se actualiza el dto
                        //dto.setCodigoVenta( dtoGestionCV.getCodigoVenta() );
                        //dto.setTxtCodigoVenta( dtoGestionCV.getTxtCodigoVenta() );
                        dto.setRegion((((region == null) || (region.length() == 0)) ? null : new Long(region)));
                        dto.setZona((((zona == null) || (zona.length() == 0)) ? null : new Long(zona)));
                        dto.setTipoCliente((((tipoCliente == null) || (tipoCliente.length() == 0)) ? null : new Long(tipoCliente)));
                        dto.setSubtipoCliente((((subTipoCliente == null) || (subTipoCliente.length() == 0)) ? null : new Long(subTipoCliente)));
                        dto.setTipoClasificacion((((tipoClasificacion == null) || (tipoClasificacion.length() == 0)) ? null : new Long(tipoClasificacion)));
                        dto.setClasificacion((((clasificacion == null) || (clasificacion.length() == 0)) ? null : new Long(clasificacion)));
                        dto.setLimiteVenta((((limiteVenta == null) || (limiteVenta.length() == 0)) ? null : new Long(limiteVenta)));
                        dto.setValorUnidades((((controlStock == null) || (controlStock.length() == 0)) ? null : new Long(controlStock)));
                        dto.setValorPorcentual((((controlStockPorcentual == null) || (controlStockPorcentual.length() == 0)) ? null : new Double(controlStockPorcentual)));
                        dto.setControlLiquidacion((((controlLiquidacion != null) && controlLiquidacion.equals("S")) ? Boolean.TRUE : Boolean.FALSE));
                        dto.setIndUltNoticias((((ultimasNoticias != null) &&  ultimasNoticias.equals("S")) ? Boolean.TRUE : Boolean.FALSE));
                        dto.setTxtRegion(((txtRegionPagina == null) ? ""  : txtRegionPagina));
                        dto.setTxtZona(((txtZonaPagina == null) ? "" : txtZonaPagina));
                        dto.setTxtTipoCliente(((txtTipoClientePagina == null) ? "" : txtTipoClientePagina));
                        dto.setTxtSubtipoCliente(((txtSubtipoClentePagina == null) ? "" : txtSubtipoClentePagina));
                        dto.setTxtTipoClasificacion(((txtTipoClasificacionPagina == null) ? "" : txtTipoClasificacionPagina));
                        dto.setTxtClasificacion(((txtClasificacionPagina == null) ? "" : txtClasificacionPagina));

                        //dto.setTxtCatalogo( dtoGestionCV.getCatalogo() );
                        //dto.setNumPagina( dtoGestionCV.getNumPagina() );
                    } else {
                        traza("********** NOT FOUND");
                    }
                }
            } catch (NumberFormatException nfe) {
            }

           
        }

            traza("------------------------------------------");
            traza("Vector de sesion despues de actualizar");
            traza(dtoGestionStock.getDetalles());
            traza("------------------------------------------");

            // [1] deshabilitarControlesCodigoVenta = "N";

            //Asigna a lista editable
            traza("************** va a asignar a la lista editable");
            traza("************** lo siguiente");
            traza(dtoGestionStock.getDetalles());
            muestraListaGestion(dtoGestionStock.getDetalles());

            //==========================================================================
            //RECARGAR CAMPOS PAGINA
            //==========================================================================
            //Carga los combos de busqueda
            muestra();

            //Combos de busqueda
            asignarAtributo("VAR", "hMarca", "valor", marca);
            asignarAtributo("VAR", "hCanal", "valor", canal);
            asignarAtributo("VAR", "hPeriodo", "valor", periodo);

            asignarAtributo("VAR", "hAsignarCombosBusqueda", "valor", "S");
            asignarAtributo("VAR", "hAsignarCamposModificar", "valor", "S");
            //[1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor", "S");

            // [1] deshabilitarControlesCodigoVenta = "N";
    }
*/
/*    private void elimina() throws Exception {
        traza("*********** Entre a elimina");
        traza("*********** codSeleccionados: " + codSeleccionados);

        //codSeleccionados
        StringTokenizer sb = new StringTokenizer(codSeleccionados, "|");
        Vector v = new Vector();

        while (sb.hasMoreTokens()) {
            v.add(sb.nextToken());
        }

        Enumeration e = null;

        Vector dtoGSCV = dtoGestionStock.getDetalles();
        Enumeration eDtoGSCV = dtoGSCV.elements();
        DTOGestionStock dtoGS = null;
        String oidSeleccionado = null;

        traza("---------------------------------------------");
        traza("Vector ANTES de eliminar");
        traza(dtoGSCV);
        traza("---------------------------------------------");

        e = v.elements();

        traza("********** vector con oids a eliminar: " + v);

        while (e.hasMoreElements()) {
            oidSeleccionado = (String) e.nextElement();

            for (int j = 0; j < dtoGSCV.size(); j++) {
                dtoGS = (DTOGestionStock) dtoGSCV.get(j);

                if ((dtoGS != null) && (dtoGS.getOid() != null) &&
                        (oidSeleccionado != null) &&
                        dtoGS.getOid().toString().equals(oidSeleccionado)) {
                    //Si el dto no tiene oid, se elimina del vector directamente, ya que fue un dto agregado 
                    //a la lista
                    //y no esta presente en la BBDD.
                    //Por el contrario, si tiene oid, significa que fue recuperado de la BBDD, por lo tanto 
                    //se asigna el
                    //true al flag indEliminar para que posteriormente sea borrado de la BBDD.
                    //Cuando se asignen datos a la lista (en LPUtilGestionStock.muestraListaGestion(...)) 
                    //se filtraran 
                    //por indEliminar.booleanValue==false.
                    dtoGS.setIndEliminar(Boolean.TRUE);

                   
                }
            }
        }

        traza("---------------------------------------------");
        traza("Vector DESPUES de eliminar");
        traza(dtoGSCV);
        traza("---------------------------------------------");

        if ((dtoGSCV != null) && (dtoGSCV.size() > 0)) {
            muestraListaGestion(dtoGSCV);
        }

        muestra();

        asignarAtributo("VAR", "hMarca", "valor", marca);
        asignarAtributo("VAR", "hCanal", "valor", canal);
        asignarAtributo("VAR", "hPeriodo", "valor", periodo);

        asignarAtributo("VAR", "hAsignarCombosBusqueda", "valor", "S");
        asignarAtributo("VAR", "hAsignarCamposModificar", "valor", "S");
        //[1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor", "S");

        //----------------------------------------------------------------------
        asignarAtributo("CTEXTO", "txtCodigoVenta", "valor", codigoVenta);
        asignarAtributo("CTEXTO", "txtLimiteVenta", "valor", limiteVenta);
        asignarAtributo("CTEXTO", "txtControlStock", "valor", controlStock);
        asignarAtributo("CTEXTO", "txtControlStockPorcentual", "valor", controlStockPorcentual);
        asignarAtributo("VAR", "hControlLiquidacion", "valor",  controlLiquidacion);
        asignarAtributo("VAR", "hUltimasNoticias", "valor", ultimasNoticias);
        asignarAtributo("VAR", "hTipoCliente", "valor", tipoCliente);
        asignarAtributo("VAR", "hRegion", "valor", region);
        asignarAtributo("VAR", "hZona", "valor", zona);
        asignarAtributo("VAR", "hSubtipoCliente", "valor", subTipoCliente);
        asignarAtributo("VAR", "hTipoClasificacion", "valor", tipoClasificacion);
        asignarAtributo("VAR", "hClasificacion", "valor", clasificacion);
    }
*/
    private void muestraBuscarCV() throws Exception {
        pagina("contenido_gestion_stock_mantenimiento_2");

        this.getFormatosValidaciones();

        DTOBelcorp dtoe = new DTOBelcorp();

        dtoe.setOidPais(UtilidadesSession.getPais(this));
        dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

        traza("DTOBelcorp:");
        traza(dtoe);

        ComposerViewElementList composerViewElementList = new ComposerViewElementList();
        ComposerViewElement composer = new ComposerViewElement();

        //PREObtenerCatalogos
        composer.setIDBusiness("MAVCargarCatalagosBP");
        composer.setDTOE(dtoe);
        composer.setPosOID((byte) 0);
        composer.setPosDesc((byte) 1);

        composerViewElementList.addViewElement(composer);

        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(composerViewElementList,
                this.getRequest());

        traza("Conector obtenido:");
        traza(conector);

        if (conector != null) {
            conector.ejecucion();

            DruidaConector resultados = null;
            resultados = conector.getConector();

            if (resultados != null) {
                //PREObtenerCatalogos
                asignar("COMBO", "cbCodCatalogo", resultados,
                    "MAVCargarCatalagosBP");
            }
        }

        /*asignarAtributo("VAR", "varPeriodo", "valor",
            (((dtoGestionStock != null) &&
            (dtoGestionStock.getPeriodo() != null))
            ? dtoGestionStock.getPeriodo().toString() : ""));*/

        asignarAtributo("VAR","hIdioma","valor",idioma.toString());
        this.getConfiguracionMenu();
    }

/*    private void aceptaCodigosVenta() throws Exception {
         * SiCC 20070284 - Rafael Romero - 08/07/2007
         * Se establecen las propiedades nuevas para el DTOGestionCV
         * - codigoSAP
         * - descripcionSAP
         * - precioCatalogo
        pagina("contenido_gestion_stock_mantenimiento_2");
        codigosVentaSeleccionados = this.conectorParametroLimpia("registrosSeleccionados", "", true);
        //traza("codigosVentaSeleccionados: " + codigosVentaSeleccionados);
        //traza("codigosVentaSeleccionados.length(): " + codigosVentaSeleccionados.length());

        //Se agregan los codigos de venta seleccionados en la ventana modal al dto en sesion.
        if (codigosVentaSeleccionados.length() > 0) {
            //Se parsea el string que tiene el siguiente formato:
            // D.OID_DETA_OFER OID,D.VAL_CODI_VENT,C.COD_CATA,D.VAL_POSI_PAGI|
            // D.OID_DETA_OFER OID,D.VAL_CODI_VENT,C.COD_CATA,D.VAL_POSI_PAGI|...
            DTOGestionCV dtoGestionCV = null;
            StringTokenizer stPipes = new StringTokenizer(codigosVentaSeleccionados, "|");
			
            StringTokenizer stComas = null;
            String oid = null;
            String codVent = null;
            String codSAP = null;
            String desSAP = null;
            String codCata = null;
            String posPagi = null;
            String preCata = null;

            while (stPipes.hasMoreTokens()) {
                stComas = new StringTokenizer(stPipes.nextToken(), ",");
                //Se sacan los tokens
                if (stComas.hasMoreTokens()) oid = stComas.nextToken();
                if (stComas.hasMoreTokens()) codVent = stComas.nextToken();
                if (stComas.hasMoreTokens()) codSAP = stComas.nextToken();
                if (stComas.hasMoreTokens()) desSAP = stComas.nextToken();
                if (stComas.hasMoreTokens()) codCata = stComas.nextToken();
                if (stComas.hasMoreTokens()) posPagi = stComas.nextToken();
                if (stComas.hasMoreTokens()) preCata = stComas.nextToken();
                
                UtilidadesLog.debug("REG=oid["+oid+"],codVent["+codVent+"],codSAP[],desSAP[],codCata["+codCata+"posPagi["+posPagi+"],preCata["+preCata+"]");

                //Se crea el DTOGestionCV
                dtoGestionCV = new DTOGestionCV();

                try {
                    dtoGestionCV.setCodigoVenta((((oid != null) && (oid.length() > 0)) ? new Long(oid) : null));
                } catch (NumberFormatException nfe1) {
                    UtilidadesLog.error("Error al asignar OID CODIGO VENTA. Valor a asignar ["+oid+"]");
                }
                dtoGestionCV.setTxtCodigoVenta(codVent);
                dtoGestionCV.setCodigoSAP(codSAP);
                dtoGestionCV.setDescripcionSAP(desSAP);
                dtoGestionCV.setCatalogo(codCata);
                try {
                    dtoGestionCV.setNumPagina((((posPagi != null) && (posPagi.length() > 0)) ? new Integer(posPagi) : null));
                } catch (NumberFormatException nfe2) {
                    UtilidadesLog.error("Error al asignar NUM. PAGINA. Valor a asignar ["+posPagi+"].");
                }
                try {
                    dtoGestionCV.setPrecioCatalogo((((preCata != null) && (preCata.length() > 0)) ? new BigDecimal(preCata) : null));
                } catch (NumberFormatException nfe2) {
                    UtilidadesLog.error("Error al asignar PRECIO CATALOGO. Valor a asignar ["+preCata+"].");
                }

                //y se agrega al dto en sesion
                if (dtoGestionStock != null) {
                    if (dtoGestionStock.getCodigosVenta() == null) {
                        dtoGestionStock.setCodigosVenta(new Vector());
                    }

                    dtoGestionStock.getCodigosVenta().add(dtoGestionCV);
                }
            }
        }
        asignarAtributo("VAR", "cerrarVentana", "valor", "S");
        asignarAtributo("VAR", "registrosSeleccionados", "valor", codigosVentaSeleccionados);
	}
*/

   /* private void anyadeCodigoVenta() throws Exception {
        traza("***************************** Entre a anyadeCodigoVenta");
        DTOBuscarCodigoVentaPeriodo dtob = new DTOBuscarCodigoVentaPeriodo();

        dtob.setPeriodo(((dtoGestionStock == null) ? null : dtoGestionStock.getPeriodo()));
        dtob.setCodigoVenta(codigoVenta);

        traza("------------------------------------------------------");
        traza("DTOBuscarCodigoVentaPeriodo: " + dtob);
        traza("codigoVenta: " + codigoVenta);
        traza("------------------------------------------------------");

        //Se llama al activador activator/mons/pre/MLNFBuscarCodigoVentaPeriodo.xml
        MareBusinessID id = new MareBusinessID("PREBuscarCodigoVentaPeriodo");
		
        Vector params = new Vector();
        params.add(dtob);
        params.add(id);

        pagina("salidaGenerica");

        try {
          DruidaConector con = null;
			
          traza("************* Conectado1...");
          con = conectar("ConectorAnyadeCodigoVenta", params);
          traza("************* Conecto.");
			
          DTOSalida dtoSalida = null;
          RecordSet rs = null;
          DTOGestionCV dtoGestionCV = null;

          StringBuffer oidCodigoVenta = new StringBuffer();
          StringBuffer txtCodigoVenta = new StringBuffer();

            
          dtoSalida = (DTOSalida) con.objeto("dtoSalida");
          traza("************* dtoSalida");
          RecordSet rsPrueba = dtoSalida.getResultado();
          traza("************* rsPrueba " + rsPrueba);
          

          if (dtoSalida != null) {
            rs = dtoSalida.getResultado();

            if ((rs != null) && !rs.esVacio()) {
              oidCodigoVenta.append("[");
              txtCodigoVenta.append("[");

              Vector vTemp = null;
              DTOGestionCV dtoTemp = null;
              boolean existe = false;

              for (int i = 0; i < rs.getRowCount(); i++) {
                dtoGestionCV = new DTOGestionCV();
                dtoGestionCV.setCodigoVenta(((rs.getValueAt(i, "OID") == null) ? null : new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString())));
                dtoGestionCV.setTxtCodigoVenta((String) rs.getValueAt(i, "VAL_CODI_VENT"));
                dtoGestionCV.setCatalogo(((rs.getValueAt(i,"COD_CATA") == null) ? null : ((BigDecimal) rs.getValueAt(i, "COD_CATA")).toString()));
                dtoGestionCV.setNumPagina(((rs.getValueAt(i,"VAL_POSI_PAGI") == null) ? null : new Integer(((BigDecimal) rs.getValueAt(i, "VAL_POSI_PAGI")).toString()))); //-- YYY FALTA!!!!

                existe = false;

                vTemp = dtoGestionStock.getCodigosVenta();

                //Verificar que el elemento no existe en el vector
                if ((vTemp != null) && (vTemp.size() > 0)) {
                  for (int j = 0; j < vTemp.size(); j++) {
                    dtoTemp = (DTOGestionCV) vTemp.get(j);

                    if ((dtoTemp != null) && (dtoTemp.getCodigoVenta() != null) && (dtoGestionCV.getCodigoVenta() != null)) {
                      if (dtoGestionCV.getCodigoVenta().equals(dtoTemp.getCodigoVenta())) {
                        existe = true;
                      }
                    }
                  }
                }

                //Si no existe, se agrega al vector
                if (!existe){
                  //Actualizar array
                  if (dtoGestionStock != null) {
                    if (dtoGestionStock.getCodigosVenta() == null) {
                      dtoGestionStock.setCodigosVenta(new Vector());
                    }
                    dtoGestionStock.getCodigosVenta().add(dtoGestionCV);
                  }

                  oidCodigoVenta.append(((i == 0)? dtoGestionCV.getCodigoVenta().toString(): ("," + dtoGestionCV.getCodigoVenta().toString())));
                  txtCodigoVenta.append(((i == 0)? dtoGestionCV.getTxtCodigoVenta(): ("," + dtoGestionCV.getTxtCodigoVenta())));
                }

              }

              oidCodigoVenta.append("]");
              txtCodigoVenta.append("]");
            }
//                }

                //Lo que sigue es:
                //-Agregar el nuevo codigo venta a la lista
                //-Limpiar txtCodigoVenta
                //Se hace en el javascript
                //asignarAtributo( "VAR", "hAnyadirCodigoVenta", "valor", "S" );
                //asignarAtributo( "VAR", "hOidCodigoVenta", "valor", oidCodigoVenta.toString() );
                //asignarAtributo( "VAR", "hTxtCodigoVenta", "valor", txtCodigoVenta.toString() );
                //OID_DETA_OFER OID, 
                //VAL_CODI_VENT, 
                //COD_CATA
                //numero de pagina (falta)
                
            traza("*********** Despues de setearle los codigos de venta");
            traza(dtoGestionStock.toString());
                
            traza("------------------------------------------------");
            traza("oidCodigoVenta: " + oidCodigoVenta.toString());
            traza("txtCodigoVenta: " + txtCodigoVenta.toString());
            traza("------------------------------------------------");

            traza("***************** oidCodigoVenta " + oidCodigoVenta.toString());
            traza("***************** txtCodigoVenta " + txtCodigoVenta.toString());

            traza("***************** valores " + "anyadeCodigosVenta( " + oidCodigoVenta.toString() + ", " +  txtCodigoVenta.toString() + " )");

            asignarAtributo("VAR", "ejecutar", "valor", "anyadeCodigosVenta( '" + oidCodigoVenta.toString() + "', '" + txtCodigoVenta.toString() + "' )");
            }
        }
        catch(Exception me){
          traza("Entro para tirar MareException");
          DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(me, this);
          if( Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) == Integer.parseInt(dtoError.getCodigoError()) ){
            traza("Tirando MAreException");
            throw new MareException(new Exception(),  Integer.parseInt("10019"));
          }
          else{
            throw me;
          }
        }
        // [1] asignarAtributo("VAR", "hMostrarLista", "valor", "S");
        //[1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor", "S");
    }
*/
	///* [1]
	private void anyadeCodigoVenta2() throws Exception {
        traza("***************************** Entre a anyadeCodigoVent2a");
		pagina("salidaGenerica");
        DTOBuscarCodigoVentaPeriodo dtob = new DTOBuscarCodigoVentaPeriodo();
		String periodo = this.conectorParametroLimpia("hPeriodo", "", true);
		String strCodigoVenta = this.conectorParametroLimpia("txtCodigoVenta", "", true);
        dtob.setPeriodo((periodo == null) ? null : Long.valueOf (periodo));
        dtob.setCodigoVenta(strCodigoVenta);
        dtob.setOidIdioma(idioma);

        traza(" [pp] DTOBuscarCodigoVentaPeriodo: " + periodo);
        traza(" [pp] codigoVenta: " + codigoVenta);

        //Se llama al activador activator/mons/pre/MLNFBuscarCodigoVentaPeriodo.xml
        MareBusinessID id = new MareBusinessID("PREBuscarCodigoVentaPeriodo2");
		
        Vector params = new Vector();
        params.add(dtob);
        params.add(id);
        
		String[] vTemp = null;

        try {
          DruidaConector con = null;
			
          traza("************* Conectado...");
          con = conectar("ConectorAnyadeCodigoVenta", params);
          traza("************* Conecto.");
			
          DTOSalida dtoSalida = null;
          RecordSet rs = null;
          DTOGestionCV dtoGestionCV = null;

          StringBuffer oidCodigoVenta = new StringBuffer();
          StringBuffer txtCodigoVenta = new StringBuffer();

          dtoSalida = (DTOSalida) con.objeto("dtoSalida");
         
          if (dtoSalida != null) {
			String tmpCodsVentas = this.conectorParametroLimpia("hOidCodigoVenta", "", true);
			traza ("tmpCodsVentas: " + tmpCodsVentas);
			vTemp = tmpCodsVentas.split(",");
            
			rs = dtoSalida.getResultado();

            if ((rs != null) && !rs.esVacio()) {
              oidCodigoVenta.append("[");
              txtCodigoVenta.append("[");

              Long oidAuxi= null;
              boolean existe = false;
				
              for (int i = 0; i < rs.getRowCount(); i++) {
                dtoGestionCV = new DTOGestionCV();
                dtoGestionCV.setCodigoVenta(((rs.getValueAt(i, "OID") == null) ? null : new Long(((BigDecimal) rs.getValueAt(i, "OID")).toString())));
                dtoGestionCV.setTxtCodigoVenta((String) rs.getValueAt(i, "VAL_CODI_VENT"));
                dtoGestionCV.setCodigoSAP((String) rs.getValueAt(i, "COD_SAP"));
                dtoGestionCV.setDescripcionSAP((String) rs.getValueAt(i, "DES_SAP"));
                dtoGestionCV.setCatalogo(((rs.getValueAt(i,"COD_CATA") == null) ? null : ((BigDecimal) rs.getValueAt(i, "COD_CATA")).toString()));
                dtoGestionCV.setNumPagina(((rs.getValueAt(i,"VAL_POSI_PAGI") == null) ? null : new Integer(((BigDecimal) rs.getValueAt(i, "VAL_POSI_PAGI")).toString())));
                dtoGestionCV.setPrecioCatalogo(((rs.getValueAt(i,"IMP_PREC_CATA") == null) ? null : (BigDecimal) rs.getValueAt(i, "VAL_POSI_PAGI")));

                existe = false;

                //vTemp = dtoGestionStock.getCodigosVenta();
                //Verificar que el elemento no existe en el vector
                if (!tmpCodsVentas.equals("") && (vTemp != null) && (vTemp.length > 0) ) {
                  for (int j = 0; j < vTemp.length; j++) {
                    oidAuxi = Long.valueOf(vTemp[j]);

                    if ((oidAuxi != null) && (dtoGestionCV.getCodigoVenta() != null)) {
                      if (dtoGestionCV.getCodigoVenta().equals(oidAuxi)) {
                        existe = true;
                      }
                    }
                  }
                }

                //Si no existe, se agrega al vector
                if (!existe){
                  //Actualizar array
                  /*if (dtoGestionStock != null) {
                    if (dtoGestionStock.getCodigosVenta() == null) {
                      dtoGestionStock.setCodigosVenta(new Vector());
                    }
                    dtoGestionStock.getCodigosVenta().add(dtoGestionCV);
                  }*/

                  oidCodigoVenta.append(((i == 0)? dtoGestionCV.getCodigoVenta().toString(): ("," + dtoGestionCV.getCodigoVenta().toString())));
                  txtCodigoVenta.append(((i == 0)? "": ",")+dtoGestionCV.getTxtCodigoVenta()+" - "+dtoGestionCV.getDescripcionSAP());
                }
              }

              oidCodigoVenta.append("]");
              txtCodigoVenta.append("]");
            }
                
            traza("*********** Despues de setearle los codigos de venta");
                
            traza("oidCodigoVenta " + oidCodigoVenta.toString());
            traza("txtCodigoVenta " + txtCodigoVenta.toString());

            asignarAtributo("VAR", "ejecutar", "valor", "anyadeCodigosVenta( '" + oidCodigoVenta.toString() + "', '" + txtCodigoVenta.toString() + "' )");
          }
        }
        catch(Exception me){
          traza("Entro para tirar MareException");
          DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(me, this);
          if( Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) == Integer.parseInt(dtoError.getCodigoError()) ){
            traza("Tirando MAreException");
            throw new MareException(new Exception(),  Integer.parseInt("10019"));
          }
          else{
            throw me;
          }
        }
        //[1] asignarAtributo("VAR", "hMostrarLista", "valor", "S");
        //[1] asignarAtributo("VAR", "hMostrarCapaDetalles", "valor", "S");
    }

	//*/ [1]

   /* private void asignarNoRequeridoACamposDeModificacion()
        throws Exception {
        asignarAtributo("CTEXTO", "txtCodigoVenta", "req", "N");
        asignarAtributoElementoValidacion("txtCodigoVenta", "required", "false");

        asignarAtributo("COMBO", "cbTipoCliente", "req", "N");
        asignarAtributoElementoValidacion("cbTipoCliente", "required", "false");
    }*/

   /* private void eliminarCodigoVenta() throws Exception {
        pagina("salidaGenerica");

        traza(
            "==================================================================");
        traza(
            "==================================================================");

        traza("ENTRA A eliminarCodigoVenta");

        StringTokenizer strToken = null;
        Vector vCodigosAEliminar = new Vector();
        String token = null;
        Long lToken = null;

        DTOGestionCV dtoGestionCV = null;
        Vector vDtoGestionCV = null;
        Enumeration eDtoGestionCV = null;

        traza("codigosVentaAEliminar: " + codigosVentaAEliminar);

        if ((codigosVentaAEliminar != null) &&
                (codigosVentaAEliminar.length() > 0)) {
            strToken = new StringTokenizer(codigosVentaAEliminar, "|");

            while (strToken.hasMoreTokens()) {
                token = strToken.nextToken();

                if ((token != null) && (token.length() > 0)) {
                    try {
                        lToken = new Long(token);
                        vDtoGestionCV = dtoGestionStock.getCodigosVenta();

                        traza("vDtoGestionCV antes de eliminar");
                        traza("------------------");
                        traza(vDtoGestionCV);
                        traza("------------------");

                        if ((vDtoGestionCV != null) &&
                                (vDtoGestionCV.size() > 0)) {
                            for (int i = 0; i < vDtoGestionCV.size(); i++) {
                                dtoGestionCV = (DTOGestionCV) vDtoGestionCV.get(i);

                                if (dtoGestionCV != null) {
                                    if ((dtoGestionCV.getCodigoVenta() != null) &&
                                            dtoGestionCV.getCodigoVenta()
                                                            .equals(lToken)) {
                                        vDtoGestionCV.remove(i);
                                    }
                                }
                            }
                        }
                    } catch (NumberFormatException nfe) {
                    }
                }
            }
        }

        traza("vDtoGestionCV despues de eliminar");
        traza("------------------");
        traza(vDtoGestionCV);
        traza("------------------");

        traza(
            "==================================================================");
        traza(
            "==================================================================");
    }*/
}
