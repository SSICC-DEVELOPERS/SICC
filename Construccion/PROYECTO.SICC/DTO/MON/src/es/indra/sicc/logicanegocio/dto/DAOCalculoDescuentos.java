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
 *
 */
package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.dto.DTOCriteriosSeleccionDTO;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;


/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:           
 * Componente:        DAOCalculoDescuentos
 * Fecha:             28/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
public class DAOCalculoDescuentos {

    private String usuario;

    public DAOCalculoDescuentos() {

    }


    /**
     * Constructor de la clase. 
     * Se asigna el parámetro de entrada "usuario" a la variable privada "usuario" de esta clase.
     */
    public DAOCalculoDescuentos(String usuario) {
        this.usuario = usuario;
    }


    /**
     * Aplicando los criterios del dto de entrada se selecciona una lista de descuentos aplicables.
     * Entrada: DTOCriteriosSeleccionDTO atributos; oidPais, oidMarca, oidCanal, oidAcceso, oidSubacceso,
     * oidPeriodo, oidCliente, oidSubgerencia, oidRegion, oidZona
     * @autor gdmarzi
     * @cambio Se cambia toda la query por la propuesta en la inc. 17876
     * @autor Jrivas 10/5/2005
     * @cambio Se elimina la tabla dto_alcan_dto_clasi_clien y el distinct
     * @autor gdmarzi 10/6/2005
     * 
     * @autor pperez 05/08/2005
     * @cambio SE MODIFICA TODA LA CONSULTA A RAIZ DE LA INCIDENCIA 19110 v32 PERU
     */
     
     
    public static RecordSet seleccionarDescuentosSolicitud(DTOCriteriosSeleccionDTO dto) throws MareException {
        UtilidadesLog.info("DAOCalculoDDescuento.seleccionarDescuentosSolicitud(): Entrada");
        BelcorpService belcorpService;
        RecordSet rsDescuentosSeleccionados;
        String codigoError;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            ArrayList parametros = new ArrayList();
            parametros.add(dto.getOidPeriodo().toString());
            parametros.add(dto.getOidMarca().toString());
            parametros.add(dto.getOidCanal().toString());
            parametros.add(dto.getOidAcceso().toString());
            parametros.add(dto.getOidSubacceso().toString());
            parametros.add(dto.getOidZona().toString());
            parametros.add(dto.getOidPais().toString());            
            parametros.add(dto.getOidRegion().toString());
            parametros.add(dto.getOidSubgerencia().toString());
            parametros.add(dto.getOidCliente().toString());
            rsDescuentosSeleccionados = belcorpService.dbService.executeProcedure("PQ_PLANI.DTO_OBTENER_DESCUENTOS",parametros);
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCalculoDDescuento.seleccionarDescuentosSolicitud(): Salida");
        if (rsDescuentosSeleccionados == null){
            rsDescuentosSeleccionados = new RecordSet();
        }
        // -> Devolver RecordSet obtenido
        return rsDescuentosSeleccionados;
    }


    /**
     * Retorna un RecordSet con los descuento por tipo cliente.
     * Filtra por oidDescuento y oidCliente.
     * @autor gdmarzi
     * @deprecated
     * @cambio DTO-08
     */
    public RecordSet obtenerDescuentosTipoCliente(Long oidDescuento, Long oidCliente) throws MareException {
        return null;
    }


    /**
     * Retorna un ArrayList con las posiciones de la solicitud OC de referencia.
     * Considera que un reclamo puede tener como solicitud de referencia a otro reclamo.
     * Se obtiene la solicitud OC de referencia del reclamo de n nivel para retornar las posiciones.
     * @autor gdmarzi
     */
    public ArrayList obtenerPosicionesSolicitudReferencia(Long oidSolicitudReclamo) throws MareException {
        UtilidadesLog.info("DAOCalculoDescuentos.obtenerPosicionesSolicitudReferencia(): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        RecordSet rsPosiciones;
        Vector parametros = new Vector();
        ArrayList posicionesSolRef = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ");
        query.append("  soli.OID_SOLI_CABE oidSolicitudCabecera, ");
        query.append("  posi.OID_SOLI_POSI oidSolicitudPosicion, ");
        query.append("  posi.VAL_CODI_VENT codigoVenta, ");
        query.append("  posi.PROD_OID_PROD oidProducto, ");
        query.append("  posi.NUM_UNID_DEMA cantidad, ");
        query.append("  posi.NUM_UNID_POR_ATEN unidadesPorAtender, ");
        query.append("  posi.VAL_PREC_CATA_UNIT_LOCA precioUnitarioCatalogoLocal, ");
        query.append("  (posi.NUM_UNID_POR_ATEN * posi.VAL_PREC_CATA_UNIT_LOCA) valorTotal, ");
        query.append("  posi.VAL_IMPO_DESC_TOTA_LOCA descuento, ");
        query.append("  posi.VAL_PORC_DESC porcentajeDescuento, ");
        query.append("  posi.ESPO_OID_ESTA_POSI estadoPosicion, ");
        query.append("  oferDetal.TOFE_OID_TIPO_OFER oidTipoOferta, ");
        query.append("  oferDetal.CIVI_OID_CICLO_VIDA oidCicloVida, ");
        query.append("  produ.DES_CORT descripcionProducto, ");
        query.append("  produ.MAPR_OID_MARC_PROD oidMarcaProducto, ");
        query.append("  produ.UNEG_OID_UNID_NEGO oidUnidadNegocio, ");
        query.append("  produ.NEGO_OID_NEGO oidNegocio, ");
        query.append("  produ.SGEN_OID_SUPE_GENE oidSuperGenerico, ");
        query.append("  produ.GENE_OID_GENE oidGenerico, ");
        query.append("  tipoOfer.IND_COMI productoComisionable, ");
        query.append("  tipoOfer.IND_APOR_MONT_ESCA productoAportaMontoAEscala, ");
        query.append("  posi.OFDE_OID_DETA_OFER, ");
        query.append("  matri.OID_MATR_FACT ");
        query.append(" FROM ");
        query.append("  ped_solic_cabec conso, ped_solic_cabec soli, ped_solic_posic posi, ");
        query.append("  pre_ofert_detal oferDetal, mae_produ produ, pre_tipo_ofert tipoOfer, pre_matri_factu matri ");
        query.append(" WHERE ");
        // cambio en la busqueda de la solicitud de referencia segun incidencia 20080682 gdmarzi
        query.append("  conso.oid_soli_cabe = (SELECT soliRecla.SOCA_OID_DOCU_REFE FROM ped_solic_cabec soliRecla WHERE soliRecla.OID_SOLI_CABE = ? ) ");
        query.append("  AND conso.OID_SOLI_CABE = soli.SOCA_OID_SOLI_CABE and soli.IND_OC = 1 ");
        query.append("  AND soli.OID_SOLI_CABE = posi.SOCA_OID_SOLI_CABE ");
        query.append("  AND oferDetal.OID_DETA_OFER = posi.OFDE_OID_DETA_OFER ");
        query.append("  AND produ.OID_PROD = posi.PROD_OID_PROD ");
        query.append("  AND tipoOfer.OID_TIPO_OFER = oferDetal.TOFE_OID_TIPO_OFER ");
        query.append("  AND 1E12 >= -ESPO_OID_ESTA_POSI ");
        query.append("  AND oferDetal.OID_DETA_OFER = matri.OFDE_OID_DETA_OFER ");
        query.append(" ORDER BY soli.OID_SOLI_CABE, posi.OID_SOLI_POSI ");
        parametros.add(oidSolicitudReclamo);

        try {
            rsPosiciones = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i=0; i<rsPosiciones.getRowCount(); i++) {
            DTOSolicitudPosicionDescuento dtoPosicion = new DTOSolicitudPosicionDescuento();
            dtoPosicion.setOidSolicitud(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSOLICITUDCABECERA")).toString()));
            dtoPosicion.setOidPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSOLICITUDPOSICION")).toString()));
            dtoPosicion.setCodigoVenta((String)rsPosiciones.getValueAt(i,"CODIGOVENTA"));
            dtoPosicion.setOidProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDPRODUCTO")).toString()));
            dtoPosicion.setDescripcionProducto((String)rsPosiciones.getValueAt(i,"DESCRIPCIONPRODUCTO"));
            dtoPosicion.setCantidad(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"CANTIDAD")).toString()));

            dtoPosicion.setUnidadesPorAtender(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"UNIDADESPORATENDER")).toString()));
            dtoPosicion.setPrecioUnitarioCatalogoLocal((BigDecimal)rsPosiciones.getValueAt(i,"PRECIOUNITARIOCATALOGOLOCAL"));
            dtoPosicion.setValorTotal( dtoPosicion.getPrecioUnitarioCatalogoLocal().multiply(new BigDecimal(dtoPosicion.getUnidadesPorAtender().floatValue())) );
            dtoPosicion.setImporteDescuentoUnitarioLocal((BigDecimal)rsPosiciones.getValueAt(i,"DESCUENTO"));
            dtoPosicion.setPorcentajeDescuento((BigDecimal)rsPosiciones.getValueAt(i,"PORCENTAJEDESCUENTO"));

            if (rsPosiciones.getValueAt(i,"PRODUCTOCOMISIONABLE") != null) {
                if ((new Long(((BigDecimal)rsPosiciones.getValueAt(i,"PRODUCTOCOMISIONABLE")).toString())).longValue() == 1) {
                    dtoPosicion.setProductoComisionable(Boolean.TRUE);
                } else {
                    dtoPosicion.setProductoComisionable(Boolean.FALSE);
                }
            }            
            if (rsPosiciones.getValueAt(i,"PRODUCTOAPORTAMONTOAESCALA") != null) {
                if ((new Long(((BigDecimal)rsPosiciones.getValueAt(i,"PRODUCTOAPORTAMONTOAESCALA")).toString())).longValue() == 1) {
                    dtoPosicion.setProductoAportaMontoAEscala(Boolean.TRUE);
                } else {
                    dtoPosicion.setProductoAportaMontoAEscala(Boolean.FALSE);
                }
            }            

            dtoPosicion.setEstadoPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"ESTADOPOSICION")).toString()));
            dtoPosicion.setOidTipoOferta(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDTIPOOFERTA")).toString()));
            dtoPosicion.setOidCicloVida(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDCICLOVIDA")).toString()));

            if (rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO") != null) {
                dtoPosicion.setOidMarcaProducto(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDMARCAPRODUCTO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO") != null) {
                dtoPosicion.setOidUnidadNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDUNIDADNEGOCIO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDNEGOCIO") != null) {
                dtoPosicion.setOidNegocio(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDNEGOCIO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDSUPERGENERICO") != null) {
                dtoPosicion.setOidSupergenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDSUPERGENERICO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OIDGENERICO") != null) {
                dtoPosicion.setOidGenerico(new Long(((BigDecimal)rsPosiciones.getValueAt(i,"OIDGENERICO")).toString()));
            }
            if (rsPosiciones.getValueAt(i,"OFDE_OID_DETA_OFER") != null) {
                dtoPosicion.setOidDetalleOferta(new Long(rsPosiciones.getValueAt(i,"OFDE_OID_DETA_OFER").toString()));
            }
            if (rsPosiciones.getValueAt(i,"OID_MATR_FACT") != null) {
                dtoPosicion.setOidMatriFactu(new Long(rsPosiciones.getValueAt(i,"OID_MATR_FACT").toString()));
            }
            posicionesSolRef.add(dtoPosicion);
        }
        UtilidadesLog.info("DAOCalculoDescuentos.obtenerPosicionesSolicitudReferencia(): Salida ");
        return posicionesSolRef;
    }


}