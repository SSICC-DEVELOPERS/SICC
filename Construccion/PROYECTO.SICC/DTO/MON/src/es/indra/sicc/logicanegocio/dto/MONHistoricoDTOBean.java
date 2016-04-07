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
import es.indra.sicc.dtos.dto.DTOEBuscarClientesDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarDetalleSolicitudDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarSolicitudesClienteDTO;
import es.indra.sicc.dtos.dto.DTOHistoricoDescuento;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.dto.DAODescuento;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:            
 * Componente:        MONHistoricoDTOBean
 * Fecha:             28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
public class MONHistoricoDTOBean implements SessionBean {

    private static int CANT_DECIMALES = 2; 

    private SessionContext sessionContext;

    public void ejbCreate() { }

    public void ejbActivate() { } 

    public void ejbPassivate() { }

    public void ejbRemove() { }

    public void setSessionContext(SessionContext ctx) {
        this.sessionContext = ctx;
    }



    /**
     * Genera los Historicos de Descuentos para una solicitud.
     * Para cada uno de los descuentos aplicados a cada posicion de la solicitud se genera el historico.
     * Si no hay un registro para el descuento lo crea y asigna valores del dto.
     * Si hay un registro para el descuento acumula los valores del dto sobre la entidad.
     * @autor gdmarzi
     */
    public void generarHistoricoDescuentos(ArrayList historicosDescuentos, Long oidPais, Long oidSolicitud) throws MareException {
        UtilidadesLog.info("MONHistoricoDTO.generarHistoricoDescuentos() - entrada");        
        Iterator iter = historicosDescuentos.iterator();
        DTOHistoricoDescuento dtoHistoricoDescuento;
        Hashtable hashHistoricos;
        String clave;
        // 1.- Recuperamos los historicos de descuentos para una solicitud.
        hashHistoricos = this.obtenerHistoricosSolicitud(oidPais,oidSolicitud);
        // 2.- Actualizamos los historicos de descuentos o los agregamos si no existe.
        while (iter.hasNext()) {
            dtoHistoricoDescuento = (DTOHistoricoDescuento)iter.next();
            clave = this.obtenerClaveHistorico(dtoHistoricoDescuento);
            if (hashHistoricos.containsKey(clave)) {
                hashHistoricos = this.actualizarHistorico(hashHistoricos, clave, dtoHistoricoDescuento);
            } else {
                hashHistoricos.put(clave,dtoHistoricoDescuento);
            }
        }
        // 3.- Grabar historicos descuentos actualizados y creados.
        this.grabarHistoricosDescuentos(hashHistoricos);
        
        UtilidadesLog.info("MONHistoricoDTO.generarHistoricoDescuentos() - salida");        
    }


    /**
     * Retorna un hash con los historicos de descuentos para un pais y una solicitud dada.
     * @autor gdmarzi
     */
    private Hashtable obtenerHistoricosSolicitud(Long oidPais, Long oidSolicitud) throws MareException {
        UtilidadesLog.info("MONHistoricoDTO.obtenerHistoricosSolicitud() - entrada");        
        BelcorpService belcorpService;
        StringBuffer query = new StringBuffer();
        RecordSet rsHistoricosActuales = null;
        Hashtable hashHistoricos = new Hashtable();
        String clave;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
			query.append(" SELECT ");
            query.append("  OID_HIST_DTO, DCTO_OID_DESC, SOCA_OID_SOLI_CABE, IMP_FIJO, ");
            query.append("  IMP_DESC_APLI, VAL_PORC_APLI, VAL_VENT_REAL, VAL_BASE_CALC, VAL_BASE_CALC_ACUM, ");
            query.append("  MAFA_OID_MATR_FACT, CLIE_OID_CLIE ");
			query.append(" FROM ");
            query.append("  DTO_HISTO_DTO ");
			query.append(" WHERE ");
            query.append(" PAIS_OID_PAIS = ? AND SOCA_OID_SOLI_CABE = ? ");
            Vector parametros = new Vector();
            parametros.add(oidPais);
            parametros.add(oidSolicitud);
            rsHistoricosActuales = belcorpService.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i=0; i<rsHistoricosActuales.getRowCount(); i++) {
            DTOHistoricoDescuento dtoHistoricoDescuento = new DTOHistoricoDescuento();
            dtoHistoricoDescuento.setOidHistoricoDescuento(new Long(((BigDecimal)rsHistoricosActuales.getValueAt(i,"OID_HIST_DTO")).toString()));
            dtoHistoricoDescuento.setOidDescuento(new Long(((BigDecimal)rsHistoricosActuales.getValueAt(i,"DCTO_OID_DESC")).toString()));
            dtoHistoricoDescuento.setOidSolicitud(new Long(((BigDecimal)rsHistoricosActuales.getValueAt(i,"SOCA_OID_SOLI_CABE")).toString()));
            dtoHistoricoDescuento.setImporteFijo((BigDecimal)rsHistoricosActuales.getValueAt(i,"IMP_FIJO"));
            dtoHistoricoDescuento.setImporteDescuentoAplicado((BigDecimal)rsHistoricosActuales.getValueAt(i,"IMP_DESC_APLI"));
            dtoHistoricoDescuento.setPorcentaje((BigDecimal)rsHistoricosActuales.getValueAt(i,"VAL_PORC_APLI"));
            dtoHistoricoDescuento.setImporteVentaReal((BigDecimal)rsHistoricosActuales.getValueAt(i,"VAL_VENT_REAL"));
            dtoHistoricoDescuento.setBaseCalculo((BigDecimal)rsHistoricosActuales.getValueAt(i,"VAL_BASE_CALC"));
            dtoHistoricoDescuento.setBaseCalculoAcumulada((BigDecimal)rsHistoricosActuales.getValueAt(i,"VAL_BASE_CALC_ACUM"));
            dtoHistoricoDescuento.setOidMatrizFacturacion(new Long(((BigDecimal)rsHistoricosActuales.getValueAt(i,"MAFA_OID_MATR_FACT")).toString()));
            dtoHistoricoDescuento.setOidCliente(new Long(((BigDecimal)rsHistoricosActuales.getValueAt(i,"CLIE_OID_CLIE")).toString()));
            clave = this.obtenerClaveHistorico(dtoHistoricoDescuento);
            hashHistoricos.put(clave, dtoHistoricoDescuento);
        }
        UtilidadesLog.info("MONHistoricoDTO.obtenerHistoricosSolicitud() - salida");        
        return hashHistoricos;
    }


    /**
     * La clave se forma con oidDescuento y oidMatrizFacturacionDetalle por posicion o solo con oidDescuento.
     * @autor gdmarzi
     */
    private String obtenerClaveHistorico(DTOHistoricoDescuento dtoHistoricoDescuento) throws MareException {
        String clave;
        if (dtoHistoricoDescuento.getOidMatrizFacturacion() == null) {
            clave = dtoHistoricoDescuento.getOidDescuento().toString();
        } else {
            clave = dtoHistoricoDescuento.getOidDescuento().toString() + "-" + dtoHistoricoDescuento.getOidMatrizFacturacion().toString();
        }
        return clave;
    }


    /**
     * Se actualiza, acumulando algunos valores, el historico descuento segun la clave oidDescuento, oidMatrizFacturacionDetalle.
     * @autor gdmarzi
     */
    private Hashtable actualizarHistorico(Hashtable hashHistoricos, String clave, DTOHistoricoDescuento dtoHistoricoActual) throws MareException {
        UtilidadesLog.info("MONHistoricoDTO.actualizarHistorico() - entrada");        
        DTOHistoricoDescuento dtoHistoricoDescuento;
        //obtenemos el historico de descuento a actualizar
        dtoHistoricoDescuento = (DTOHistoricoDescuento)hashHistoricos.get(clave);
        UtilidadesLog.debug("va a actualizar OidDescuento:" + dtoHistoricoActual.getOidDescuento() + " OidMatrizFacturacion: "+ dtoHistoricoActual.getOidMatrizFacturacion() ); 

        UtilidadesLog.debug("HistoricoDescuento dto.getImporteVentaReal(): " + dtoHistoricoActual.getImporteVentaReal()); 
        UtilidadesLog.debug("HistoricoDescuento dto.getBaseCalculo(): " + dtoHistoricoActual.getBaseCalculo()); 
        UtilidadesLog.debug("HistoricoDescuento dto.getBaseCalculoAcumulada(): " + dtoHistoricoActual.getBaseCalculoAcumulada()); 
        // -> Segun incidencia 21031 estos tres atributos no deben de acumularse.
        dtoHistoricoDescuento.setImporteVentaReal(dtoHistoricoActual.getImporteVentaReal());
        dtoHistoricoDescuento.setBaseCalculo(dtoHistoricoActual.getBaseCalculo());
        dtoHistoricoDescuento.setBaseCalculoAcumulada(dtoHistoricoActual.getBaseCalculoAcumulada());

        // -> Acumular los siguientes atributos: porcentajeAplicado, importeFijoDescuento
        // porcentajeAplicado eq porcentaje, (Segun Incidencia 7378:)
        if (dtoHistoricoActual.getPorcentaje() != null) {
            if (dtoHistoricoDescuento.getPorcentaje() == null) {
                dtoHistoricoDescuento.setPorcentaje(new BigDecimal(0));    //valor por defecto
            }
            BigDecimal porcentajeAcc = dtoHistoricoDescuento.getPorcentaje().add(dtoHistoricoActual.getPorcentaje());
            UtilidadesLog.debug("HistoricoDescuento porcentajeAcc: " + porcentajeAcc); 
            dtoHistoricoDescuento.setPorcentaje(porcentajeAcc);
        }
        
        //importeFijoDescuento eq importeFijo, 
        if (dtoHistoricoActual.getImporteFijo() != null) {
            if (dtoHistoricoDescuento.getImporteFijo() == null) {
                dtoHistoricoDescuento.setImporteFijo(new BigDecimal(0));    //valor por defecto
            }
            BigDecimal importeFijoAcc = dtoHistoricoDescuento.getImporteFijo().add(dtoHistoricoActual.getImporteFijo());
            UtilidadesLog.debug("HistoricoDescuento importeFijoAcc: " + importeFijoAcc); 
            dtoHistoricoDescuento.setImporteFijo(importeFijoAcc);
        }

        //descuento eq importe descuento aplicado: el porcentaje aplicado a la venta real (porcentaje/100 * venta real)
        BigDecimal importeDescuentoAplicado = new BigDecimal(0);
        if  ( (dtoHistoricoDescuento.getPorcentaje() != null ) && (dtoHistoricoDescuento.getImporteVentaReal() != null ) ) {
            importeDescuentoAplicado = (dtoHistoricoDescuento.getPorcentaje().divide(new BigDecimal(100), CANT_DECIMALES, BigDecimal.ROUND_UNNECESSARY).multiply(dtoHistoricoDescuento.getImporteVentaReal()));
            UtilidadesLog.debug("HistoricoDescuento importeDescuentoAplicado: " + importeDescuentoAplicado); 
        }
        dtoHistoricoDescuento.setImporteDescuentoAplicado(importeDescuentoAplicado);
        
        UtilidadesLog.info("MONHistoricoDTO.actualizarHistorico() - salida");        
        return hashHistoricos;
    }
                

    /**
     * Inserta o Actualiza los historicos de descuentos.
     * @autor gdmarzi
     */
    private void grabarHistoricosDescuentos(Hashtable hashHistoricosDescuentos) throws MareException {
        UtilidadesLog.info("MONHistoricoDTO.grabarHistoricosDescuentos() - entrada");        
        DTOHistoricoDescuento dtoHistoricoDescuento;
        BelcorpService bs;
        StringBuffer querySimple = new StringBuffer();
        StringBuffer variasQuerys = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        Collection historicos = hashHistoricosDescuentos.values();
        Iterator iter = historicos.iterator();

        // -> Armamos querys de insert o update segun el oidHistoricoDescuento
        while(iter.hasNext()) {
            dtoHistoricoDescuento = (DTOHistoricoDescuento)iter.next();
            if (dtoHistoricoDescuento.getOidHistoricoDescuento() == null) {
                querySimple = this.armarInsertHisotricoDescuento(dtoHistoricoDescuento);     
            } else {
                querySimple = this.armarUpdateHisotricoDescuento(dtoHistoricoDescuento);     
            }
            variasQuerys.append(querySimple);
            variasQuerys.append(";");
        }
        // -> Ejecutamos multiples inserts y updates            
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", variasQuerys.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONHistoricoDTO.grabarHistoricosDescuentos() - salida");        
    }


    /**
     * Arma un update de historico descuento.
     * @autor gdmarzi
     */
    private StringBuffer armarUpdateHisotricoDescuento(DTOHistoricoDescuento dtoHistoricoDescuento) throws MareException {
        StringBuffer query = new StringBuffer();
        query.append(" UPDATE ");
        query.append("  DTO_HISTO_DTO ");
        query.append(" SET ");
        query.append("  VAL_PORC_APLI = " + dtoHistoricoDescuento.getPorcentaje() + ", ");
        query.append("  IMP_FIJO = " + dtoHistoricoDescuento.getImporteFijo() + ", ");
        query.append("  IMP_DESC_APLI = " + dtoHistoricoDescuento.getImporteDescuentoAplicado() + ", ");
        query.append("  VAL_VENT_REAL = " + dtoHistoricoDescuento.getImporteVentaReal() + ", ");
        query.append("  VAL_BASE_CALC = " + dtoHistoricoDescuento.getBaseCalculo() + ", ");
        query.append("  VAL_BASE_CALC_ACUM = " + dtoHistoricoDescuento.getBaseCalculoAcumulada());
        query.append(" WHERE ");
        query.append("  OID_HIST_DTO = " + dtoHistoricoDescuento.getOidHistoricoDescuento());
        return query;
    }    


    /**
     * Arma un insert de historico descuento.
     * @autor gdmarzi
     */
    private StringBuffer armarInsertHisotricoDescuento(DTOHistoricoDescuento dtoHistoricoDescuento) throws MareException {
        StringBuffer query = new StringBuffer();
        Long oidHistoDescuento = SecuenciadorOID.obtenerSiguienteValor("DTO_HDTO_SEQ");
        query.append(" INSERT INTO DTO_HISTO_DTO ( ");
        query.append("  OID_HIST_DTO,  ");
        query.append("  DCTO_OID_DESC, ");
        query.append("  SOCA_OID_SOLI_CABE, ");
        query.append("  FEC_PROC, ");
        query.append("  IMP_FIJO, ");
        query.append("  IMP_DESC_APLI, ");
        query.append("  VAL_PORC_APLI, ");
        query.append("  VAL_VENT_REAL, ");
        query.append("  VAL_BASE_CALC, ");
        query.append("  VAL_BASE_CALC_ACUM, ");
        query.append("  MAFA_OID_MATR_FACT, ");
        query.append("  NUM_BUZO_MENS, ");
        query.append("  PAIS_OID_PAIS, ");
        query.append("  CLIE_OID_CLIE, ");
        query.append("  IND_CC, ");
        query.append("  IND_FACT ");
        query.append(" ) VALUES ( ");
        query.append( oidHistoDescuento + ", ");
        query.append( dtoHistoricoDescuento.getOidDescuento() + ", ");
        query.append( dtoHistoricoDescuento.getOidSolicitud() + ", ");
        DTOBuzonMensajes dtoB = dtoHistoricoDescuento.getDtoBuzonMensajes();
        if (dtoB!=null){
            query.append( " trunc(sysdate)" + ", ");                
        } else {
            query.append( " null" + ", ");
        }
        query.append( dtoHistoricoDescuento.getImporteFijo()  + ", ");
        query.append( dtoHistoricoDescuento.getImporteDescuentoAplicado() + ", ");
        query.append( dtoHistoricoDescuento.getPorcentaje() + ", ");
        query.append( dtoHistoricoDescuento.getImporteVentaReal() + ", ");
        query.append( dtoHistoricoDescuento.getBaseCalculo() + ", ");
        query.append( dtoHistoricoDescuento.getBaseCalculoAcumulada() + ", ");
        query.append( dtoHistoricoDescuento.getOidMatrizFacturacion() + ", ");
        
        if (dtoB!=null){
            query.append( dtoB.getNumeroSecuencial() + ", ");
        }else{
            query.append( "NULL, ");
        }
        query.append( dtoHistoricoDescuento.getOidPais() + ", ");
        query.append( dtoHistoricoDescuento.getOidCliente() + ", ");
        if (dtoHistoricoDescuento.getCuentaCorriente().booleanValue()) {
            query.append(" 1 " + ", ");
        } else {
            query.append(" 0 " + ", ");
        }
        if (dtoHistoricoDescuento.getFacturacion().booleanValue()) {
            query.append(" 1 ");
        } else {
            query.append(" 0 ");
        }
        query.append(" ) ");
        return query;
    }    


    /**
     * Cristian Valenzuela
     * 10/08/2004
     * 
     * Este metodo borra registros de la tabla DTO_HISTO_DTO filtrando por el campo
     * SOCA_OID_SOLI_CABE
     */
    public void borrarHistoricoSolicitud(DTOOID dto) throws MareException {
      UtilidadesLog.info("********* Entre a borrarHistoricoSolicitud - MONHistoricoDTOBean");
      StringBuffer query = new StringBuffer();
      query.append(" DELETE ");     
      query.append(" FROM DTO_HISTO_DTO d ");
      query.append(" WHERE d.SOCA_OID_SOLI_CABE = " + dto.getOid().toString());  
      
      try {
        BelcorpService.getInstance().dbService.executeUpdate(query.toString());
      }
      catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      
    }


    /**
     * 
     */
    public DTOSalida buscarClientesDTO(DTOEBuscarClientesDTO dto) throws MareException {
      UtilidadesLog.info("********* Entre a buscarClientesDTO - MONHistoricoDTOBean");
      DTOSalida dtoSalida = new DTOSalida();
      DAODescuento dao = new DAODescuento();
      dtoSalida = dao.buscarClientesDTO(dto);      
      return dtoSalida;
    }


    /**
     * 
     */
    public DTOSalida buscarSolicitudesPorClienteDTO(DTOEBuscarSolicitudesClienteDTO dto) throws MareException {
      UtilidadesLog.info("********* Entre a buscarSolicitudesPorClienteDTO - MONHistoricoDTOBean");
      DTOSalida dtoSalida = new DTOSalida();
      DAODescuento dao = new DAODescuento();
      dtoSalida = dao.buscarSolicitudesPorClienteDTO(dto);      
      return dtoSalida;
    }


    /**
     * 
     */
    public DTOSalida buscarDetalleSolicitudDTO(DTOEBuscarDetalleSolicitudDTO dto) throws MareException {
      UtilidadesLog.info("********* Entre a buscarDetalleSolicitudDTO - MONHistoricoDTOBean");
      DTOSalida dtoSalida = new DTOSalida();
      DAODescuento dao = new DAODescuento();
      dtoSalida = dao.buscarDetalleSolicitudDTO(dto);      
      return dtoSalida;
    }


    
}