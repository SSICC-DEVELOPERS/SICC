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
 * @autor: Cristian Valenzuela / Dante Castiglione
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 *
 * NOTA: LOS BLOQUES DE CODIGO ESTAN DENTRO DE UN PAR DE LLAVES { }
 * PARA QUE NO SE MEZCLE EL SCOPE DE LOS ATRIBUTOS LOCALES.
 * RECOMIENDO NO SACARLAS.
 *
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;

public class DAOSolicitudes {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOSolicitudes() {
    }

    /**
     * Metodo: obtenerSolicitud
     * Autor: Cristian Valenzuela
     * Fecha: 3/3/2005
     */
    public Solicitud obtenerSolicitud(DTOSolicitudValidacion dtoSolicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerSolicitud(DTOSolicitudVali"
            +"dacion dtoSolicitud):Entrada");

        /*Descripcion: este metodo retorna un objeto del tipo Solicitud en
          base al DTOSolicitudValidacion recibido por parametro.

          Implementacion: este metodo debe crear un objeto del tipo Solicitud,
          completar todos sus atributos y retornar dicho objeto a su llamador.
          Para ello se debe seguir la siguiente secuencia:

          1- Crear un objeto de la clase Solicitud e invocar al metodo
          obtenerDatosGeneralesSolicitud pasandole por parametro el
          DTOSolicitudValidacion y la solicitud. Este metodo completara la
          solicitud con los valores del DTOSolicitudValidacion y los atributos
          periodo y periodoCalculo.

          2- Invocar al metodo obtenerCliente pasandole por parametro el 
          oidCliente
          del DTOSolicitudValidacion y la solicitud. Este metodo crea un objeto
          del tipo Cliente con el oidCliente pasado por parametro y lo asigna
          al atributo cliente de la solicitud.

          3- Invocar al metodo obtenerPosicionesSolicitud pasandole por 
          parametro
          el objeto solicitud. Este metodo crea un array de objetos de la clase
          Posicion en base a la solicitud pasada por parametro y lo asigna a la
          propiedad de la posiciones de la solicitud.

          4- Invocar al metodo DAOSolicitudConcurso.obtenerSolicitudConcurso
          pasandole por parametro el objeto solicitud. */

        //1
        Solicitud solicitud = new Solicitud();
        // vbongiov 6/03/2006 - inc 22675
        solicitud.setOidIdioma(dtoSolicitud.getOidIdioma());
        
        this.obtenerDatosGeneralesSolicitud(dtoSolicitud, solicitud);
        //2
        // vbongiov
        // 9/9/2005 inc 18885
        // vbongiov -- 07/07/2006 -- inc DBLG500000896
        //if(!solicitud.getIndAnulacion()) {
            long comienzo2 = System.currentTimeMillis();
            this.obtenerCliente(dtoSolicitud.getOidCliente(), solicitud);
            
            //3
            comienzo2 = System.currentTimeMillis();
            this.obtenerPosicionesSolicitud(solicitud);
            UtilidadesLog.debug("******TRES******");            
    
            //4
            comienzo2 = System.currentTimeMillis();
            DAOSolicitudConcurso dao = new DAOSolicitudConcurso();
            dao.obtenerSolicitudConcurso(solicitud);
            UtilidadesLog.debug("******CUATRO******");
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug(" al final solicitud.getOidIdioma()" + solicitud.getOidIdioma() );
        //}
        
        //5.- jrivas 25/7/2006 DBLG50000902
        comienzo2 = System.currentTimeMillis();
        this.obtenerMontoUnidadesAcumuladasPedido(solicitud);
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerSolicitud(DTOSolicitudVali"
            +"dacion dtoSolicitud):Salida");
        return solicitud;
    }

    /**
     * Metodo: obtenerDatosGeneralesSolicitud
     * @author: Cristian Valenzuela
     * @date: 3/3/2005
     * @author: Gustavo Viñales (cambio java.util.Date a java.sql.Date y 
     * correcciones correspondientes)
     * @date: 19/04/2005
     */
    private void obtenerDatosGeneralesSolicitud(DTOSolicitudValidacion 
        dtoSolicitud, Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesSolicitud("
            +"DTOSolicitudValidacion dtoSolicitud, Solicitud solicitud):Entrada");
        //UtilidadesLog.debug("DAOSolicitudes.obtenerDatosGeneralesSolicitud() con DTOSolicitudValidacion: " + dtoSolicitud + "Solicitud: " + solicitud);

        //1
        solicitud.setOidSolicitud(dtoSolicitud.getOidSolicitud());
        solicitud.setOidPais(dtoSolicitud.getOidPais());
        solicitud.setOidMarca(dtoSolicitud.getOidMarca());
        solicitud.setOidCanal(dtoSolicitud.getOidCanal());
        solicitud.setOidAcceso(dtoSolicitud.getOidAcceso());
        solicitud.setOidZona(dtoSolicitud.getZona());

        if (dtoSolicitud.getIndOrdenCompra() != null) {
            solicitud.setOrdenDeCompra(dtoSolicitud.getIndOrdenCompra()
                .booleanValue());
        } else {
            solicitud.setOrdenDeCompra(false);
        }
        
        // 1.1
        Cliente cliente = new Cliente();
        cliente.setOidCliente(dtoSolicitud.getOidCliente());
        
        solicitud.setCliente(cliente);

        //2 C
        StringBuffer query4 = new StringBuffer();
        RecordSet rs4 = new RecordSet();
        BelcorpService belcorpService4 = null;

        //jrivas 1/8/2006 Inc DBLG500001003
        query4.append(" SELECT pts.IND_ANUL, pts.IND_DEVO,  ");
        query4.append("       pts.COD_TIPO_SOLI,  "); // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
        query4.append(" sol_anul.FEC_CRON fecCronAnul, sol_anul.FEC_FACT fecFactAnul ");
        query4.append(" FROM PED_SOLIC_CABEC sol_anul,  ");
        query4.append(" PED_TIPO_SOLIC_PAIS ptsp,  ");
        query4.append(" PED_TIPO_SOLIC pts  ");
        query4.append(" WHERE sol_anul.OID_SOLI_CABE = " + solicitud.getOidSolicitud());
        query4.append(" AND sol_anul.TSPA_OID_TIPO_SOLI_PAIS = ptsp.OID_TIPO_SOLI_PAIS  ");
        query4.append(" AND ptsp.TSOL_OID_TIPO_SOLI = pts.OID_TIPO_SOLI  ");

      
        try {
            rs4 = belcorpService4.getInstance().dbService.executeStaticQuery(query4.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs4 " + rs4);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs4.getRowCount(); i++) {
            BigDecimal indAnul = (BigDecimal) rs4.getValueAt(i, "IND_ANUL");
            BigDecimal indDevo = (BigDecimal) rs4.getValueAt(i, "IND_DEVO");
            
            if (indAnul.intValue() == 1) {
                solicitud.setIndAnulacion(true);
            } else {
                solicitud.setIndAnulacion(false);
            }

            if (indDevo.intValue() == 1) {
                solicitud.setIndDevolucion(true);
            } else {
                solicitud.setIndDevolucion(false);
            }
            
            Date fechaCronAnul = (Date) rs4.getValueAt(i, "FECCRONANUL");
            solicitud.setFechaDocumento(fechaCronAnul);
            
            // vbongiov -- 28/08/2006 -- DBLG500000680
            Date fechaFactAnul = rs4.getValueAt(i, "FECFACTANUL")!=null?(Date)rs4.getValueAt(i, "FECFACTANUL"):null;
            solicitud.setFechaFacturacion(fechaFactAnul);
            
            // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
            solicitud.setCodigoTipoSolPais((String) rs4.getValueAt(i, "COD_TIPO_SOLI"));
            
            // sapaza -- PER-SiCC-2011-0279 -- 07/06/2011
            solicitud.setValidaReemplazo(false);
            if(solicitud.getCodigoTipoSolPais().equals(ConstantesINC.COD_TIPO_PEDIDO_DEVOLUCION_NORMAL)) {
                String valParametro = obtenerIndicadorParametroPais(solicitud.getOidPais(), "INC", "001");
                
                if(valParametro != null && valParametro.equals("1"))
                    solicitud.setValidaReemplazo(true);
            }
            
           //jrivas 1/8/2006 Inc DBLG500001003
            /*Date fechaCronOrig = (Date) rs4.getValueAt(i, "FECCRONORIG");
            BigDecimal oidSolicitudOrig = (BigDecimal) rs4.getValueAt(i, "OID_SOLI_CABE");
            BigDecimal oidPeriodoOrig = (BigDecimal) rs4.getValueAt(i, "PERD_OID_PERI");
            
            if(solicitud.getIndAnulacion() && oidSolicitudOrig!=null){
                solicitud.setFechaDocumento(fechaCronOrig);
            } else {
                solicitud.setFechaDocumento(fechaCronAnul);
            }
            
            if(solicitud.getIndAnulacion() && oidSolicitudOrig!=null){
                solicitud.setOidSolicitud(Long.valueOf(oidSolicitudOrig
                    .toString()));
                dtoSolicitud.setOidSolicitud(Long.valueOf(oidSolicitudOrig
                    .toString()));
                dtoSolicitud.setOidPeriodo(Long.valueOf(oidPeriodoOrig
                    .toString()));
            }*/
            
            
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("DTOSolicitudValidacion: " + dtoSolicitud);
        
        //2 A      
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT cp.OID_PERI, cp.FEC_INIC, cp.FEC_FINA, ");
        query.append(" spc.COD_PERI, cp.PAIS_OID_PAIS, cp.MARC_OID_MARC, ");
        query.append(" cp.CANA_OID_CANA ");
        query.append(" FROM CRA_PERIO cp, ");
        query.append(" SEG_PERIO_CORPO spc ");
        query.append(" WHERE cp.OID_PERI = " + dtoSolicitud.getOidPeriodo());
        query.append(" AND cp.PERI_OID_PERI = spc.OID_PERI ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal oidPer = (BigDecimal) rs.getValueAt(i, "OID_PERI");
            Date fechaInicio = (Date) rs.getValueAt(i, "FEC_INIC");
            Date fechaFin = (Date) rs.getValueAt(i, "FEC_FINA");
            String codigoPer = (String) rs.getValueAt(i, "COD_PERI");
            BigDecimal pais = (BigDecimal) rs.getValueAt(i, "PAIS_OID_PAIS");
            BigDecimal marca = (BigDecimal) rs.getValueAt(i, "MARC_OID_MARC");
            BigDecimal canal = (BigDecimal) rs.getValueAt(i, "CANA_OID_CANA");

            Periodo periodo = new Periodo();

            periodo.setOidPeriodo(new Long(oidPer.longValue()));
            periodo.setFechaDesde(fechaInicio);
            periodo.setFechaHasta(fechaFin);
            periodo.setCodperiodo(codigoPer);
            periodo.setOidPais(new Long(pais.longValue()));
            periodo.setOidMarca(new Long(marca.longValue()));
            periodo.setOidCanal(new Long(canal.longValue()));

            solicitud.setPeriodo(periodo);
        }

        //2 B
        StringBuffer query2 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        BelcorpService belcorpService2 = null;

        SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date(new java.util.Date().getTime());
        String sFecha = sdfFormato.format(fecha);

        query2.append(" SELECT cc.PERD_OID_PERI, MIN(cc.FEC_INIC) ");
        query2.append(" FROM CRA_CRONO cc, CRA_PERIO cp, ");
        query2.append(" CRA_ACTIV ca, CRA_CLASE_ACTIV cca ");
        query2.append(" WHERE cc.PERD_OID_PERI = cp.OID_PERI ");
        query2.append(" AND cp.PAIS_OID_PAIS = " + solicitud.getOidPais());
        query2.append(" AND cp.MARC_OID_MARC = " + solicitud.getOidMarca());
        query2.append(" AND cp.CANA_OID_CANA = " + solicitud.getOidCanal());
        query2.append(" AND cc.ZZON_OID_ZONA = " + solicitud.getOidZona());
        query2.append(" AND cc.CACT_OID_ACTI = ca.OID_ACTI ");
        query2.append(" AND ca.CLAC_OID_CLAS_ACTI = cca.OID_CLAS_ACTI ");
        query2.append(" AND cca.COD_CLAS_ACTI = 'FAC'  ");
        query2.append(" AND cc.FEC_INIC >= to_date('" + sFecha + "', 'dd/MM/yyyy')");
        query2.append(" GROUP BY cc.PERD_OID_PERI ");
        //jrivas 15/5/2009 20090918
        query2.append(" ORDER BY 2 ");

        try {
            rs2 = belcorpService2.getInstance().dbService.executeStaticQuery(query2.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
              UtilidadesLog.debug("******* rs2 " + rs2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs2.esVacio()) {
            BigDecimal oidPer = null;

            //for(int i=0; i<rs2.getRowCount(); i++) {
            oidPer = (BigDecimal) rs2.getValueAt(0, "PERD_OID_PERI");

            //}
            //Ultima parte      
            StringBuffer query3 = new StringBuffer();
            RecordSet rs3 = new RecordSet();
            BelcorpService belcorpService3 = null;

            query3.append(" SELECT cp.OID_PERI, cp.FEC_INIC, cp.FEC_FINA, ");
            query3.append(" spc.COD_PERI, cp.PAIS_OID_PAIS, ");
            query3.append(" cp.MARC_OID_MARC, ");
            query3.append(" cp.CANA_OID_CANA ");
            query3.append(" FROM CRA_PERIO cp, SEG_PERIO_CORPO spc ");
            query3.append(" WHERE cp.OID_PERI = " + oidPer.toString());
            query3.append(" AND cp.PERI_OID_PERI = spc.OID_PERI ");

            try {
                rs3 = belcorpService3.getInstance().dbService
                    .executeStaticQuery(query3.toString());
                    
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                    
                  UtilidadesLog.debug("******* rs3 " + rs3);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            for (int i = 0; i < rs3.getRowCount(); i++) {
                BigDecimal oidPeriodo = (BigDecimal) rs3
                    .getValueAt(i, "OID_PERI");
                Date fechaInicio = (Date) rs3.getValueAt(i, "FEC_INIC");
                Date fechaFin = (Date) rs3.getValueAt(i, "FEC_FINA");
                String codigoPer = (String) rs3.getValueAt(i, "COD_PERI");
                BigDecimal pais = (BigDecimal) rs3
                    .getValueAt(i, "PAIS_OID_PAIS");
                BigDecimal marca = (BigDecimal) rs3
                    .getValueAt(i, "MARC_OID_MARC");
                BigDecimal canal = (BigDecimal) rs3
                    .getValueAt(i, "CANA_OID_CANA");

                Periodo periodo = new Periodo();

                periodo.setOidPeriodo(new Long(oidPeriodo.longValue()));
                periodo.setFechaDesde(fechaInicio);
                periodo.setFechaHasta(fechaFin);
                periodo.setCodperiodo(codigoPer);
                periodo.setOidPais(new Long(pais.longValue()));
                periodo.setOidMarca(new Long(marca.longValue()));
                periodo.setOidCanal(new Long(canal.longValue()));

                solicitud.setPeriodoCalculo(periodo);
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* PeriodoCalculo " + solicitud.getPeriodoCalculo().getOidPeriodo());                
            }
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesSolicitud(DTO"
            +"SolicitudValidacion dtoSolicitud, Solicitud solicitud):Salida");
    }

    /**
     * Metodo: obtenerCliente
     * Autor: Cristian Valenzuela
     * Fecha: 3/3/2005
     * Modificado: Carlos Leal 15/06/2005
     */
    private Cliente obtenerCliente(Long oidCliente, Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerCliente(Long oidCliente,"
            +"Solicitud solicitud):Entrada");

        /*Descripcion: este metodo retorna un objeto de la clase Cliente
          con todos sus datos recuperados.

          Implementacion:

          1- Invocar al metodo obtenerDatosGeneralesCliente pasandole por
          parametro el oidCliente. Este metodo retornara un objeto de la clase
          Cliente el cual debe ser asignado a la propiedad cliente de la 
          Solicitud.
          2- Invocar al metodo obtenerTipificacionesCliente pasandole por
          parametro el objeto cliente. Este metodo creara un array de objetos
          de la clase TipificacionCliente el cual asignara al atributo
          tipificacionCliente del cliente pasado por parametro.
          3- Invocar al metodo obtenerHistoricoEstatusCliente pasandole por
          parametro el objeto cliente. Este metodo asignara un array de objetos
          de la clase HistoricoEstatusCliente al atributo 
          historicoEstatusCliente
          del cliente pasado por parametro.
          4- Invocar al metodo obtenerPeriodosConPedidosCliente pasandole por
          parametro el objeto cliente. Este metodo asignara un array de objetos
          de la clase Periodo al atributo periodosConPedidos del cliente pasado
          por parametro.
          5- Invocar al metodo obtenerClienteRecomendante pasandole por
          parametro el objeto cliente. Este metodo asignara un objeto de la
          calse ClienteRecomendante al atributo clienteRecomendante del cliente
          recibido por parametro.
          6- Invocar al metodo obtenerDatosGerentes pasandole por parametro el
          objeto cliente.
          */

        //1
        Cliente cliente = this.obtenerDatosGeneralesCliente(oidCliente, 
        solicitud.getPeriodo());
        solicitud.setCliente(cliente);

        //2
        UtilidadesLog.debug("****obtenerCliente 1****");
        this.obtenerTipificacionesCliente(cliente);
        UtilidadesLog.debug("****obtenerCliente 2****");

        //3
        this.obtenerHistoricoEstatusCliente(cliente);
        UtilidadesLog.debug("****obtenerCliente 3****");

        //4
        this.obtenerPeriodosConPedidosCliente(cliente);
        UtilidadesLog.debug("****obtenerCliente 4****");

        //5
        //jrivas 4/7/2005
        //Inc 16978      
        this.obtenerClienteRecomendante(cliente, solicitud.getOidPais());

        // 5.1
        // JVM - sicc 20070237, calling obtenerClienteRecomendado
        this.obtenerClienteRecomendado(cliente, solicitud.getOidPais());

        //6
        this.obtenerDatosGerentes(cliente, solicitud.getPeriodo());
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("Salio de obtenerCliente - DAOSolicitudes");
        
        // vbongiov 22/9/2005 inc 20940
        cliente.setIndRecomendante(this.esClienteRecomendante(cliente.getOidCliente(), solicitud.getPeriodo()));

        // jrivas 30/8//2006 inc DBLG5000839
        cliente.setIndRecomendado(this.esClienteRecomendado(cliente.getOidCliente(), solicitud.getPeriodo()));
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerCliente(Long oidCliente, "
            +"Solicitud solicitud):Salida");
        return cliente;
    }

    /**
     * Metodo: obtenerDatosGeneralesCliente
     *
     * Descripcion: este metodo retorna un Cliente con sus datos
     * principales cargados en base al oidCliente recibido por parametro
     *
     * Autor: Dante Castiglione
     *
     */
    private Cliente obtenerDatosGeneralesCliente(Long oidCliente, Periodo peri)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesCliente(Long oidCliente, Periodo peri):Entrada");
        
        StringBuffer nombreCli = new StringBuffer();

        // crear cliente
        Cliente cliente = new Cliente();
        cliente.setOidCliente(oidCliente);

        // completar oidEstatus
        BigDecimal oidEstatus = null;

        {
            BelcorpService bs1;
            RecordSet respuesta1;
            String codigoError1;
            StringBuffer query1 = new StringBuffer();

            try {
                bs1 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError1 = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError1));
            }

            try {
                query1.append(" SELECT CLIE_OID_CLIE, ");
                query1.append(" ESTA_OID_ESTA_CLIE ");
                query1.append(" FROM MAE_CLIEN_DATOS_ADICI ");
                query1.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
                respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuesta1 " + respuesta1);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError1 = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError1));
            }

            if (respuesta1.esVacio()) {
                cliente.setOidEstatus(null);
            } else {
                oidEstatus = (BigDecimal) respuesta1
                    .getValueAt(0, "ESTA_OID_ESTA_CLIE");
                cliente.setOidEstatus((oidEstatus != null) ? new Long(
                    oidEstatus.longValue()) : null);
            }
        }
        // completar oidEstatusFuturo
        {
            BelcorpService bs2;
            RecordSet respuesta2;
            String codigoError2;
            StringBuffer query2 = new StringBuffer();

            try {
                bs2 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError2 = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError2));
            }

            try {
                query2.append(" SELECT OID_ESTA_CLIE, ");
                query2.append(" ESTA_OID_ESTA_CLIE ");
                query2.append(" FROM MAE_ESTAT_CLIEN ");
                query2.append(" WHERE OID_ESTA_CLIE = " + oidEstatus);
                respuesta2 = bs2.dbService.executeStaticQuery(query2.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuesta2 " + respuesta2);                    
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError2 = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError2));
            }

            if (respuesta2.esVacio()) {
                cliente.setOidEstatusFuturo(null);
            } else {
                {
                    BigDecimal oidEstatusFuturo = (BigDecimal) respuesta2
                        .getValueAt(0, "ESTA_OID_ESTA_CLIE");
                    cliente.setOidEstatusFuturo((oidEstatusFuturo != null) 
                        ? new Long(oidEstatusFuturo.longValue()) : null);
                }
            }
        }
        // completar periodoPrimerContacto 
        {
            BelcorpService bs3;
            RecordSet respuesta3;
            String codigoError3;
            StringBuffer query3 = new StringBuffer();

            try {
                bs3 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError3 = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError3));
            }

            try {
                query3.append(" SELECT A.CLIE_OID_CLIE, ");
                query3.append(" A.PERD_OID_PERI, ");
                query3.append(" B.PAIS_OID_PAIS, ");
                query3.append(" B.CANA_OID_CANA, ");
                query3.append(" B.MARC_OID_MARC, ");
                query3.append(" B.FEC_INIC, ");
                query3.append(" B.FEC_FINA, ");
                query3.append(" C.COD_PERI ");
                query3.append(" FROM MAE_CLIEN_PRIME_CONTA A, ");
                query3.append(" CRA_PERIO B, ");
                query3.append(" SEG_PERIO_CORPO C ");
                query3.append(" WHERE A.CLIE_OID_CLIE = " + oidCliente);
                query3.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
                query3.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
                respuesta3 = bs3.dbService.executeStaticQuery(query3.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuesta3 " + respuesta3);                                        
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError3 = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError3));
            }

            if (respuesta3.esVacio()) {
                cliente.setPeriodoPrimerContacto(null);
            } else {
                Periodo periodo = new Periodo();

                {
                    BigDecimal oidPeriodo = (BigDecimal) respuesta3
                        .getValueAt(0, "PERD_OID_PERI");
                    periodo.setOidPeriodo((oidPeriodo != null) 
                        ? new Long(oidPeriodo.longValue()) : null);
                }

                periodo.setCodperiodo((String) respuesta3
                    .getValueAt(0, "COD_PERI"));
                periodo.setFechaDesde((Date) respuesta3
                    .getValueAt(0, "FEC_INIC"));
                periodo.setFechaHasta((Date) respuesta3
                    .getValueAt(0, "FEC_FINA"));
                periodo.setOidPais(new Long(((BigDecimal) respuesta3
                    .getValueAt(0, "PAIS_OID_PAIS")).longValue()));
                periodo.setOidCanal(new Long(((BigDecimal) respuesta3
                    .getValueAt(0, "CANA_OID_CANA")).longValue()));
                periodo.setOidMarca(new Long(((BigDecimal) respuesta3
                    .getValueAt(0, "MARC_OID_MARC")).longValue()));
                cliente.setPeriodoPrimerContacto(periodo);
            }
        }
        // completar AmbitoGeografico
        {
            BelcorpService bs4;
            RecordSet respuesta4;
            String codigoError4;
            StringBuffer query4 = new StringBuffer();

            try {
                bs4 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError4 = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError4));
            }

            try {
                //jrivas 29/6/2005
                //Modificado INC. 19479
                SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaDesde = sdfFormato.format(peri.getFechaDesde());
                String fechaHasta = sdfFormato.format(peri.getFechaHasta());

                query4.append(" SELECT sub.oid_subg_vent, reg.oid_regi,  ");
                query4.append(" zon.oid_zona, sec.oid_secc, ");
                query4.append("       terr.terr_oid_terr,  ");
                query4.append(" sec.clie_oid_clie oid_lider, ");
                query4.append("       zon.clie_oid_clie oid_gerente_zona, ");
                query4.append("       reg.clie_oid_clie oid_gerente_region,  ");
                query4.append(" sub.clie_oid_clie oid_subgerente ");
                query4.append("  FROM mae_clien_unida_admin una, ");
                query4.append("       zon_terri_admin terr, ");
                query4.append("       zon_secci sec, ");
                query4.append("       zon_zona zon, ");
                query4.append("       zon_regio reg, ");
                query4.append("       zon_sub_geren_venta sub ");
                //jrivas 27/04/2006 INC DBLG50000361
                //query4.append("       , cra_perio per1,  ");
                //query4.append("      cra_perio per2 ");
                query4.append(" WHERE una.clie_oid_clie = " + oidCliente);
                query4.append("   AND una.ztad_oid_terr_admi =  ");
                query4.append(" terr.oid_terr_admi ");
                query4.append("   AND terr.zscc_oid_secc = sec.oid_secc ");
                query4.append("   AND sec.zzon_oid_zona = zon.oid_zona ");
                query4.append("   AND zon.zorg_oid_regi = reg.oid_regi ");
                query4.append("   AND reg.zsgv_oid_subg_vent =  ");
                query4.append(" sub.oid_subg_vent ");
                //jrivas 27/04/2006 INC DBLG50000361
                query4.append("   AND una.perd_oid_peri_fin IS NULL ");
                
                // sapaza -- PER-SiCC-2013-0960 -- 03/09/2013
                //query4.append("   AND una.ind_acti = 1 ");
                
                /*query4.append("   AND una.perd_oid_peri_fin =  ");
                query4.append("   AND una.perd_oid_peri_ini = per1.oid_peri ");
                query4.append(" per2.oid_peri(+) ");
                query4.append("   AND per1.fec_inic <= TO_DATE ('" + 
                    fechaDesde + "', 'dd/MM/yyyy') ");
                query4.append("   AND (   per2.fec_fina IS NULL  OR  ");
                query4.append(" per2.fec_fina >= TO_DATE ('" + fechaHasta 
                    + "', 'dd/MM/yyyy')    ) ");*/

                respuesta4 = bs4.dbService.executeStaticQuery(query4.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("respuesta4: " + respuesta4);
                
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError4 = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError4));
            }

            Gerente lider = new Gerente();
            Gerente gerenteZona = new Gerente();
            Gerente gerenteRegion = new Gerente();
            Gerente subGerente = new Gerente();

            if (respuesta4.esVacio()) {
                cliente.setAmbitoGeografico(null);
            } else {
                AmbitoGeografico ambito = new AmbitoGeografico();
                ambito.setOidSubgerencia(new Long(((BigDecimal) respuesta4
                    .getValueAt(0, "OID_SUBG_VENT")).longValue()));
                ambito.setOidRegion(new Long(((BigDecimal) respuesta4
                    .getValueAt(0, "OID_REGI")).longValue()));
                ambito.setOidZona(new Long(((BigDecimal) respuesta4
                    .getValueAt(0, "OID_ZONA")).longValue()));
                ambito.setOidSeccion(new Long(((BigDecimal) respuesta4
                    .getValueAt(0, "OID_SECC")).longValue()));

                //jrivas 29/6/2005
                //Modificado INC. 19479
                ambito.setOidTerritorio(new Long(((BigDecimal) respuesta4
                    .getValueAt(0, "TERR_OID_TERR")).longValue()));

                if (respuesta4.getValueAt(0, "OID_LIDER") != null) {
                    lider.setOidCliente(new Long(((BigDecimal) respuesta4
                        .getValueAt(0, "OID_LIDER")).longValue()));
                }

                if (respuesta4.getValueAt(0, "OID_GERENTE_ZONA") != null) {
                    gerenteZona.setOidCliente(new Long(((BigDecimal) respuesta4
                        .getValueAt(0, "OID_GERENTE_ZONA")).longValue()));
                    ;
                }

                if (respuesta4.getValueAt(0, "OID_GERENTE_REGION") != null) {
                    gerenteRegion.setOidCliente(new Long(((BigDecimal) 
                        respuesta4.getValueAt(0, "OID_GERENTE_REGION"))
                            .longValue()));
                }

                if (respuesta4.getValueAt(0, "OID_SUBGERENTE") != null) {
                    subGerente.setOidCliente(new Long(((BigDecimal) respuesta4
                        .getValueAt(0, "OID_SUBGERENTE")).longValue()));
                }

                ambito.setLider(lider);
                ambito.setGerenteZona(gerenteZona);
                ambito.setGerenteRegion(gerenteRegion);
                ambito.setSubgerente(subGerente);

                cliente.setAmbitoGeografico(ambito);
            }
        }
        // completar nombre
        {
            BelcorpService bs5;
            RecordSet respuesta5;
            String codigoError5;
            StringBuffer query5 = new StringBuffer();

            try {
                bs5 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError5 = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError5));
            }

            try {
                query5.append(" SELECT OID_CLIE, ");
                query5.append(" VAL_APE1, ");
                query5.append(" VAL_APE2, ");
                query5.append(" VAL_NOM1, ");
                query5.append(" VAL_NOM2 ");
                query5.append(" FROM MAE_CLIEN ");
                query5.append(" WHERE OID_CLIE = " + oidCliente.longValue());
                respuesta5 = bs5.dbService.executeStaticQuery(query5.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuesta5 " + respuesta5);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError5 = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError5));
            }

            if (respuesta5.esVacio()) {
                cliente.setNombre(null);
            } else {
            
                if(respuesta5.getValueAt(0, "VAL_NOM1")!=null) {
                    nombreCli.append((String) respuesta5.getValueAt(0, "VAL_NOM1"));
                }
                
                if(respuesta5.getValueAt(0, "VAL_NOM2")!=null) {
                    if(nombreCli.length()!=0) {
                        nombreCli.append(" ");
                    }
                    nombreCli.append((String) respuesta5.getValueAt(0, "VAL_NOM2"));
                }
                
                if(respuesta5.getValueAt(0, "VAL_APE1")!=null) {
                    if(nombreCli.length()!=0) {
                        nombreCli.append(" ");
                    }
                    nombreCli.append((String) respuesta5.getValueAt(0, "VAL_APE1"));
                }
                
                if(respuesta5.getValueAt(0, "VAL_APE2")!=null) {
                    if(nombreCli.length()!=0) {
                        nombreCli.append(" ");
                    }
                    nombreCli.append((String) respuesta5.getValueAt(0, "VAL_APE2"));
                }
                
                cliente.setNombre(nombreCli.toString());
            }
        }

        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesCliente(Long oidCliente, Periodo peri):Salida");
        return cliente;
    }

    /**
     * Metodo: obtenerTipificacionesCliente
     * Autor: Dante Castiglione
     * Fecha: 2005/03/09
     *
     * Descripcion este metodo obtiene las tipificaciones de un cliente 
     * determinado.
     *
     */

    // Cambiado por Noziglia C. Cliente por Participante
    public void obtenerTipificacionesCliente(Participante cliente)
            throws MareException {
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerTipificacionesCliente(Par"
            +"ticipante cliente):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if (cliente.getOidCliente() == null) {
            cliente.setTipificacionCliente(null);
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("---- NULO : ");
              UtilidadesLog.debug("---- cliente : " + cliente.getOidCliente());
            }  
        } else {
            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError));
            }

            try {
                query.append(" SELECT CLIE_OID_CLIE, ");
                query.append(" CLAS_OID_CLAS, ");
                query.append(" SBTI_OID_SUBT_CLIE, ");
                query.append(" TCCL_OID_TIPO_CLASI, ");
                query.append(" TICL_OID_TIPO_CLIE ");
                query.append(" FROM V_MAE_TIPIF_CLIEN ");
                query.append(" WHERE CLIE_OID_CLIE = " + cliente
                    .getOidCliente());
                respuesta = bs.dbService.executeStaticQuery(query.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("---- TIPIF : " + respuesta);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    codigoError));
            }

            if (respuesta.esVacio()) {
                cliente.setTipificacionCliente(null);
            } else {
                TipificacionCliente[] tipificaciones = new TipificacionCliente[
                    respuesta.getRowCount()];

                for (int i = 0; i < respuesta.getRowCount(); i++) {
                    tipificaciones[i] = new TipificacionCliente();

                    {
                        BigDecimal oidClasificacionCliente = (BigDecimal) 
                            respuesta.getValueAt(i, "CLAS_OID_CLAS");
                        tipificaciones[i].setOidClasificacionCliente((
                            oidClasificacionCliente != null) ? new Long(
                                oidClasificacionCliente.longValue()) : null);
                    }

                    tipificaciones[i].setOidSubTipoCliente(new Long((
                        (BigDecimal) respuesta
                         .getValueAt(i, "SBTI_OID_SUBT_CLIE")).longValue()));

                    {
                        BigDecimal oidTipoClasificacionCliente = (BigDecimal) 
                            respuesta.getValueAt(i, "TCCL_OID_TIPO_CLASI");
                        tipificaciones[i].setOidTipoClasificacionCliente(
                            (oidTipoClasificacionCliente != null)? new Long(
                                oidTipoClasificacionCliente.longValue()) 
                                    : null);
                    }

                    tipificaciones[i].setOidTipoCliente(new Long(((BigDecimal)
                        respuesta.getValueAt(i, "TICL_OID_TIPO_CLIE"))
                            .longValue()));
                }

                cliente.setTipificacionCliente(tipificaciones);
            }
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerTipificacionesCliente(Par"
            +"ticipante cliente):Salida");
    }

    /**
     * Metodo: obtenerHistoricoEstatusCliente
     * Autor: Dante Castiglione
     * Fecha: 2005/03/09
     *
     * Descripcion: este metodo recupera los estatus del cliente
     * a lo largo de su historia.
     *
     */
    public void obtenerHistoricoEstatusCliente(Cliente cliente)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerHistoricoEstatusCliente("
            +"Cliente cliente):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            query.append(" SELECT ESTA_OID_ESTA_CLIE, OID_HIST_ESTA, ");
            query.append(" PERD_OID_PERI, ");
            query.append(" PERD_OID_PERI_PERI_FIN, ");
            query.append(" PED.FEC_INIC as PED_FEC_INIC,  ");
            query.append(" PED.FEC_FINA as PED_FEC_FINA, ");
            query.append(" PED.MARC_OID_MARC as PED_MARC_OID_MARC,  ");
            query.append(" PED.CANA_OID_CANA as PED_CANA_OID_CANA, ");
            query.append(" PED.PAIS_OID_PAIS as PED_PAIS_OID_PAIS, ");
            query.append(" PCD.COD_PERI as PCD_COD_PERI, ");
            query.append(" PEH.FEC_INIC as PEH_FEC_INIC,  ");
            query.append(" PEH.FEC_FINA as PEH_FEC_FINA, ");
            query.append(" PEH.MARC_OID_MARC as PEH_MARC_OID_MARC,  ");
            query.append(" PEH.CANA_OID_CANA as PEH_CANA_OID_CANA, ");
            query.append(" PEH.PAIS_OID_PAIS as PEH_PAIS_OID_PAIS, ");
            query.append(" PCH.COD_PERI as PCH_COD_PERI ");
            query.append(" FROM MAE_CLIEN_HISTO_ESTAT, ");
            query.append(" CRA_PERIO            PED, ");
            query.append(" SEG_PERIO_CORPO      PCD, ");
            query.append(" CRA_PERIO            PEH, ");
            query.append(" SEG_PERIO_CORPO      PCH ");
            query.append(" WHERE PERD_OID_PERI        = PED.OID_PERI ");
            query.append(" AND PED.PERI_OID_PERI      = PCD.OID_PERI ");
            query.append(" AND PERD_OID_PERI_PERI_FIN = PEH.OID_PERI(+) ");
            query.append(" AND PEH.PERI_OID_PERI      = PCH.OID_PERI(+) ");
            query.append(" AND CLIE_OID_CLIE = ").append(cliente
                .getOidCliente());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug(" obtenerHistoricoEstatusCliente respuesta " + respuesta);            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (respuesta.esVacio()) {
            cliente.setHistoricoEstatusCliente(new HistoricoEstatusCliente[0]);
        } else {
            HistoricoEstatusCliente[] historico = new HistoricoEstatusCliente[
                respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("Pongo un historico");

                Periodo periodoDesde = new Periodo();
                periodoDesde.setOidPeriodo(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PERD_OID_PERI")).longValue()));
                periodoDesde.setFechaDesde((Date) respuesta
                    .getValueAt(i, "PED_FEC_INIC"));
                periodoDesde.setFechaHasta((Date) respuesta
                    .getValueAt(i, "PED_FEC_FINA"));
                periodoDesde.setOidMarca(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PED_MARC_OID_MARC")).longValue()));
                periodoDesde.setOidCanal(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PED_CANA_OID_CANA")).longValue()));
                periodoDesde.setOidPais(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PED_PAIS_OID_PAIS")).longValue()));
                periodoDesde.setCodperiodo((String) respuesta
                    .getValueAt(i, "PCD_COD_PERI"));

                Periodo periodoHasta;
                BigDecimal periodoFin = (BigDecimal) respuesta
                    .getValueAt(i, "PERD_OID_PERI_PERI_FIN");

                if (periodoFin == null) {
                    periodoHasta = null;
                } else {
                    periodoHasta = new Periodo();
                    periodoHasta.setOidPeriodo(new Long(periodoFin
                        .longValue()));
                    periodoHasta.setFechaDesde((Date) respuesta
                        .getValueAt(i, "PEH_FEC_INIC"));
                    periodoHasta.setFechaHasta((Date) respuesta
                        .getValueAt(i, "PEH_FEC_FINA"));
                    periodoHasta.setOidMarca((respuesta
                        .getValueAt(i, "PEH_MARC_OID_MARC") != null)
                         ? new Long(((BigDecimal) respuesta
                         .getValueAt(i, "PEH_MARC_OID_MARC")).longValue()) 
                            : null);
                    periodoHasta.setOidCanal((respuesta
                        .getValueAt(i, "PEH_CANA_OID_CANA") != null) 
                        ? new Long(((BigDecimal) respuesta
                        .getValueAt(i, "PEH_CANA_OID_CANA")).longValue()) 
                        : null);
                    periodoHasta.setOidPais((respuesta
                        .getValueAt(i, "PEH_PAIS_OID_PAIS") != null)
                        ? new Long(((BigDecimal) respuesta
                        .getValueAt(i, "PEH_PAIS_OID_PAIS")).longValue()) 
                        : null);
                    periodoHasta.setCodperiodo((String) respuesta
                    .getValueAt(i, "PCH_COD_PERI"));
                }

                historico[i] = new HistoricoEstatusCliente();
                historico[i].setOidEstatus(respuesta.getValueAt(i, "ESTA_OID_ESTA_CLIE")==null?null:
                    new Long(((BigDecimal) respuesta.getValueAt(i, "ESTA_OID_ESTA_CLIE")).longValue()));
                historico[i].setPeriodoInicio(periodoDesde);
                historico[i].setPeriodoFin(periodoHasta);
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("Pongo un historico historico[i].setOidEs"
                    +"tatus " + historico[i].getOidEstatus());
                  UtilidadesLog.debug("Pongo un historico historico[i].setPerio"
                    +"doInicio " + historico[i].getPeriodoInicio());
                  UtilidadesLog.debug("Pongo un historico historico[i].setPerio"
                    +"doFin " + historico[i].getPeriodoFin());
                }   
            }

            cliente.setHistoricoEstatusCliente(historico);
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerHistoricoEstatusCliente("
            +"Cliente cliente):Salida");
    }

    /**
     * Metodo: obtenerPeriodosConPedidosCliente
     * Autor: Dante Castiglione
     * Fecha: 2005/03/09
     *
     * Descripcion: obtiene los Periodos para los cuales el cliente pasó al 
     * menos un pedido
     */
    private void obtenerPeriodosConPedidosCliente(Cliente cliente)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerPeriodosConPedidosCliente("
            +"Cliente cliente):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {

            //jrivas 20/9/2006 Uso de acumulador
            query.append(" SELECT DISTINCT A.PERD_OID_PERI, COD_PERI, B.FEC_INIC, B.FEC_FINA, ");
            query.append(" B.CANA_OID_CANA, B.MARC_OID_MARC, B.PAIS_OID_PAIS ");
            query.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
            query.append(" CRA_PERIO B, ");
            query.append(" SEG_PERIO_CORPO C ");
            query.append(" WHERE A.PERD_OID_PERI = B.OID_PERI ");
            query.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
            query.append(" AND A.CLIE_OID_CLIE = " + cliente.getOidCliente());
            query.append(" AND A.VAL_CANT_PEDI > 0 ");                          // JVM, sicc 20070376
        
            /*query.append(" SELECT A.PERD_OID_PERI, FEC_INIC, FEC_FINA, COD_PERI, B.PAIS_OID_PAIS, ");
            query.append("  B.MARC_OID_MARC, B.CANA_OID_CANA ");
            query.append(" FROM PED_SOLIC_CABEC A, CRA_PERIO B, SEG_PERIO_CORPO C, ");
            query.append(" PED_TIPO_SOLIC_PAIS PTSP, PED_TIPO_SOLIC PTS, PED_SOLIC_CABEC CONSO ");
            query.append(" WHERE A.CLIE_OID_CLIE = " + cliente.getOidCliente());
            query.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
            query.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
            query.append(" AND A.TSPA_OID_TIPO_SOLI_PAIS =  PTSP.OID_TIPO_SOLI_PAIS  ");
            query.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
            query.append(" AND PTS.IND_ANUL <> 1 ");
            query.append(" AND PTS.IND_DEVO <> 1 ");
            query.append(" AND A.IND_OC = 1 ");
            query.append(" AND A.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+) ");
            query.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> 4 ");            
            query.append(" GROUP BY A.PERD_OID_PERI, ");
            query.append(" FEC_INIC, ");
            query.append(" FEC_FINA, ");
            query.append(" COD_PERI, ");
            query.append(" B.PAIS_OID_PAIS, ");
            query.append(" B.MARC_OID_MARC, ");
            query.append(" B.CANA_OID_CANA ");
            query.append(" ORDER BY PERD_OID_PERI ");*/

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("La respuesta es: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.debug("VACIO ");
            cliente.setPeriodosConPedidos(new HashMap());
        } else {
            UtilidadesLog.debug("NO VACIO ");

            HashMap output = new HashMap();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                Periodo periodo = new Periodo();
                periodo.setOidPeriodo(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PERD_OID_PERI")).longValue()));
                periodo.setCodperiodo((String) respuesta
                    .getValueAt(i, "COD_PERI"));
                periodo.setFechaDesde((Date) respuesta
                    .getValueAt(i, "FEC_INIC"));
                periodo.setFechaHasta((Date) respuesta
                    .getValueAt(i, "FEC_FINA"));
                periodo.setOidPais(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "PAIS_OID_PAIS")).longValue()));
                periodo.setOidCanal(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "CANA_OID_CANA")).longValue()));
                periodo.setOidMarca(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "MARC_OID_MARC")).longValue()));
                output.put(periodo.getOidPeriodo(), periodo);
            }

            cliente.setPeriodosConPedidos(output);
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("cliente.setPeriodosConPedidos " + cliente.getPeriodosConPedidos());
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerPeriodosConPedidosCliente("
            +"Cliente cliente):Salida");
    }

    /**
     * Metodo: obtenerClienteRecomendante
     * Autor: Dante Castiglione
     * Fecha: 2005/03/10
     *
     * Descripcion: este metodo obtiene el cliente recomendante y sus 
     * atributos.
     */
    private void obtenerClienteRecomendante(Cliente clienteParametro, Long 
        oidPais) throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerClienteRecomendante(Cliente"
            +"clienteParametro, Long oidPais):Entrada");
        // query sobre INC
        BelcorpService bsInc = null;
        RecordSet respuestaInc = null;
        StringBuffer queryInc = new StringBuffer();

        try {
            bsInc = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //jrivas 17/8/2005
            //Inc 20556        
            queryInc.append(" SELECT RECT.CLIE_OID_CLIE, FEC_INIC, FEC_FINA ");
            queryInc.append("   FROM INC_CLIEN_RECDO RDO, CRA_PERIO,  ");
            queryInc.append("   INC_CLIEN_RECTE RECT ");
            queryInc.append("  WHERE PERD_OID_PERI = OID_PERI ");
            queryInc.append("    AND RDO.CLIE_OID_CLIE = " + clienteParametro.getOidCliente());
            queryInc.append("    AND CLR3_OID_CLIE_RETE = OID_CLIE_RETE ");
            respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* respuestaInc " + respuestaInc);                
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // query sobre MAE
        BelcorpService bsMae = null;
        RecordSet respuestaMae = null;
        StringBuffer queryMae = new StringBuffer();

        try {
            bsInc = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        ClienteRecomendante clienteRecomendante = new ClienteRecomendante();
        boolean hayRecomendante;

        if (!respuestaInc.esVacio()) {
            // tomo los datos de INC
            hayRecomendante = true;

            {
                BigDecimal recomendante = (BigDecimal) respuestaInc
                    .getValueAt(0, "CLIE_OID_CLIE");
                clienteRecomendante.setRecomendante((recomendante != null) 
                    ? new Long(recomendante.longValue()) : null);
            }

            clienteRecomendante.setFechaInicio((Date) respuestaInc
                .getValueAt(0, "FEC_INIC"));
            // fecha fin de INC
            {
                Date fechaFin = (Date) respuestaInc.getValueAt(0, "FEC_FINA");
                clienteRecomendante.setFechaFin((fechaFin != null) 
                    ? fechaFin : null);
            }
            
            /* */
           // JVM, sicc 20070381 , agrega bloque que recupera datos del periodo 
            // {
            Date fec_desd = (Date) respuestaInc.getValueAt(0, "FEC_INIC");

            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                
            try {
                bsInc = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }       
                
            queryInc = new StringBuffer();
            
            try {
                queryInc.append(" select   x.n, x.oid_peri, x.fec_inic, x.fec_fina, x.pais_oid_pais, x.marc_oid_marc, x.cana_oid_cana ");    
                queryInc.append("     from (  ");    
                queryInc.append("             select 1 n, b.oid_peri      as oid_peri, ");    
                queryInc.append("                         b.fec_inic      as fec_inic, ");    
                queryInc.append("                         b.fec_fina      as fec_fina, ");    
                queryInc.append("                         b.pais_oid_pais as pais_oid_pais, ");    
                queryInc.append("                         b.marc_oid_marc as marc_oid_marc, ");    
                queryInc.append("                         b.cana_oid_cana as cana_oid_cana ");    
                queryInc.append("               from mae_clien_prime_conta a, cra_perio b, seg_perio_corpo c ");    
                queryInc.append("              where a.clie_oid_clie = " + clienteParametro.getOidCliente());       
                queryInc.append("                and a.perd_oid_peri = b.oid_peri ");    
                queryInc.append("                and b.peri_oid_peri = c.oid_peri ");    
                queryInc.append("                and b.oid_peri in ( ");    
                queryInc.append("                       select oid_peri  ");    
                queryInc.append("                         from cra_perio ");    
                queryInc.append("                        where fec_inic <= to_date ('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') ");
                queryInc.append("                          and to_date ('"+ df.format(fec_desd) +"', 'DD/MM/YYYY') <= fec_fina ) ");
                queryInc.append("           union ");    
                queryInc.append("                 select rownum + 1 as n, oid_peri      as oid_peri, ");    
                queryInc.append("                                         fec_inic      as fec_inic, ");    
                queryInc.append("                                         fec_fina      as fec_fina, ");    
                queryInc.append("                                         pais_oid_pais as pais_oid_pais, ");    
                queryInc.append("                                         marc_oid_marc as marc_oid_marc, ");    
                queryInc.append("                                         cana_oid_cana as cana_oid_cana ");    
                queryInc.append("                   from cra_perio ");    
                queryInc.append("                  where fec_inic <= to_date ('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') ");
                queryInc.append("                    and to_date('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') <= fec_fina ");
                queryInc.append("               order by oid_peri asc ");    
                queryInc.append("           ) x                                                                                       ");    
                queryInc.append(" order by n ");    
    
                respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuestaInc " + respuestaInc);   
    
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
    
            BigDecimal bd;
            Periodo periodo = new Periodo();
            
            if (!respuestaInc.esVacio()) {
                bd = (BigDecimal) respuestaInc.getValueAt(0, "OID_PERI");
                periodo.setOidPeriodo(new Long(bd.longValue()));
                periodo.setFechaDesde((Date) respuestaInc.getValueAt(0, "FEC_INIC"));
                periodo.setFechaHasta((Date) respuestaInc.getValueAt(0, "FEC_FINA"));                    
                bd = (BigDecimal) respuestaInc.getValueAt(0, "PAIS_OID_PAIS");
                periodo.setOidPais(new Long(bd.longValue()));
                bd = (BigDecimal) respuestaInc.getValueAt(0, "MARC_OID_MARC");
                periodo.setOidMarca(new Long(bd.longValue()));
                bd = (BigDecimal) respuestaInc.getValueAt(0, "CANA_OID_CANA");
                periodo.setOidCanal(new Long(bd.longValue()));
            }  
    
            clienteParametro.setPeriodo(periodo);

/* */
        } else {
            // BELC300022542 - gPineda - 24/08/06
            try {
                queryInc = new StringBuffer();
    
                //jrivas 4/7/2005
                //Inc 16978
                queryInc.append(" SELECT CLIE_OID_CLIE_VNTE, FEC_DESD, FEC_HAST ");
                queryInc.append(" FROM MAE_CLIEN_VINCU, MAE_TIPO_VINCU ");
                queryInc.append(" WHERE CLIE_OID_CLIE_VNDO = " + clienteParametro.getOidCliente());
                queryInc.append(" AND TIVC_OID_TIPO_VINC = OID_TIPO_VINC ");
                queryInc.append(" AND PAIS_OID_PAIS = " + oidPais);
                
                // BELC300022542 - gPineda - 24/08/06
                //queryInc.append(" AND COD_TIPO_VINC = '" + ConstantesMAE.TIPO_VINCULO_RECOMENDADA + "'");
                queryInc.append(" AND IND_RECO = 1 ");
    
                respuestaMae = bsInc.dbService.executeStaticQuery(queryInc.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
                  UtilidadesLog.debug("******* respuestaMae " + respuestaMae); 
                
                
                // JVM, sicc 20070381 , agrega bloque que recupera datos del periodo 
                // {
                if (!respuestaMae.esVacio()) {                
                    Date fec_desd = (Date) respuestaMae.getValueAt(0, "FEC_DESD");
    
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    
                    try {
                        bsInc = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }       
                    
                    queryInc = new StringBuffer();
                    
                    try {
                        queryInc.append(" select   x.n, x.oid_peri, x.fec_inic, x.fec_fina, x.pais_oid_pais, x.marc_oid_marc, x.cana_oid_cana ");    
                        queryInc.append("     from (  ");    
                        queryInc.append("             select 1 n, b.oid_peri      as oid_peri, ");    
                        queryInc.append("                         b.fec_inic      as fec_inic, ");    
                        queryInc.append("                         b.fec_fina      as fec_fina, ");    
                        queryInc.append("                         b.pais_oid_pais as pais_oid_pais, ");    
                        queryInc.append("                         b.marc_oid_marc as marc_oid_marc, ");    
                        queryInc.append("                         b.cana_oid_cana as cana_oid_cana ");    
                        queryInc.append("               from mae_clien_prime_conta a, cra_perio b, seg_perio_corpo c ");    
                        queryInc.append("              where a.clie_oid_clie = " + clienteParametro.getOidCliente());       
                        queryInc.append("                and a.perd_oid_peri = b.oid_peri ");    
                        queryInc.append("                and b.peri_oid_peri = c.oid_peri ");    
                        queryInc.append("                and b.oid_peri in ( ");    
                        queryInc.append("                       select oid_peri  ");    
                        queryInc.append("                         from cra_perio ");    
                        queryInc.append("                        where fec_inic <= to_date ('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') ");
                        queryInc.append("                          and to_date ('"+ df.format(fec_desd) +"', 'DD/MM/YYYY') <= fec_fina ) ");
                        queryInc.append("           union ");    
                        queryInc.append("                 select rownum + 1 as n, oid_peri      as oid_peri, ");    
                        queryInc.append("                                         fec_inic      as fec_inic, ");    
                        queryInc.append("                                         fec_fina      as fec_fina, ");    
                        queryInc.append("                                         pais_oid_pais as pais_oid_pais, ");    
                        queryInc.append("                                         marc_oid_marc as marc_oid_marc, ");    
                        queryInc.append("                                         cana_oid_cana as cana_oid_cana ");    
                        queryInc.append("                   from cra_perio ");    
                        queryInc.append("                  where fec_inic <= to_date ('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') ");
                        queryInc.append("                    and to_date('"+ df.format(fec_desd) +"', 'DD-MM-YYYY') <= fec_fina ");
                        queryInc.append("               order by oid_peri asc ");    
                        queryInc.append("           ) x                                                                                       ");    
                        queryInc.append(" order by n ");    
            
                        respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                        
                          UtilidadesLog.debug("******* respuestaInc " + respuestaInc);   
            
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
            
                    BigDecimal bd;
                    Periodo periodo = new Periodo();
                    
                    if (!respuestaInc.esVacio()) {
                        bd = (BigDecimal) respuestaInc.getValueAt(0, "OID_PERI");
                        periodo.setOidPeriodo(new Long(bd.longValue()));
                        periodo.setFechaDesde((Date) respuestaInc.getValueAt(0, "FEC_INIC"));
                        periodo.setFechaHasta((Date) respuestaInc.getValueAt(0, "FEC_FINA"));                    
                        bd = (BigDecimal) respuestaInc.getValueAt(0, "PAIS_OID_PAIS");
                        periodo.setOidPais(new Long(bd.longValue()));
                        bd = (BigDecimal) respuestaInc.getValueAt(0, "MARC_OID_MARC");
                        periodo.setOidMarca(new Long(bd.longValue()));
                        bd = (BigDecimal) respuestaInc.getValueAt(0, "CANA_OID_CANA");
                        periodo.setOidCanal(new Long(bd.longValue()));
                    }  
            
                    clienteParametro.setPeriodo(periodo);
                }                
                // }                 
                
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            
            if (!respuestaMae.esVacio()) {
                hayRecomendante = true;
                clienteRecomendante.setRecomendante(new Long(((BigDecimal) 
                    respuestaMae.getValueAt(0, "CLIE_OID_CLIE_VNTE"))
                        .longValue()));

                {
                    Date fechaInicio = (Date) respuestaMae
                        .getValueAt(0, "FEC_DESD");
                    clienteRecomendante.setFechaInicio((fechaInicio != null) 
                        ? fechaInicio : null);
                }
                // fecha fin de MAE
                {
                    Date fechaFin = (Date) respuestaMae
                        .getValueAt(0, "FEC_HAST");
                    clienteRecomendante.setFechaFin((fechaFin != null) 
                        ? fechaFin : null);
                }
            } else {
                hayRecomendante = false;
            }
        }
        // tomo los datos de MAE
        if (hayRecomendante) {
        
            // JVM, sicc 20070381 , agrega bloque que recupera datos del periodo 
            // {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                bsInc = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }       
            
            queryInc = new StringBuffer();
            
            try {
                queryInc.append(" select   x.n, x.oid_peri, x.fec_inic, x.fec_fina, x.pais_oid_pais, x.marc_oid_marc, x.cana_oid_cana ");    
                queryInc.append("     from (  ");    
                queryInc.append("             select 1 n, b.oid_peri      as oid_peri, ");    
                queryInc.append("                         b.fec_inic      as fec_inic, ");    
                queryInc.append("                         b.fec_fina      as fec_fina, ");    
                queryInc.append("                         b.pais_oid_pais as pais_oid_pais, ");    
                queryInc.append("                         b.marc_oid_marc as marc_oid_marc, ");    
                queryInc.append("                         b.cana_oid_cana as cana_oid_cana ");    
                queryInc.append("               from mae_clien_prime_conta a, cra_perio b, seg_perio_corpo c ");    
                queryInc.append("              where a.clie_oid_clie = " + clienteRecomendante.getRecomendante());       
                queryInc.append("                and a.perd_oid_peri = b.oid_peri ");    
                queryInc.append("                and b.peri_oid_peri = c.oid_peri ");    
                queryInc.append("                and b.oid_peri in ( ");    
                queryInc.append("                       select oid_peri  ");    
                queryInc.append("                         from cra_perio ");    
                queryInc.append("                        where fec_inic <= to_date ('"+ df.format(clienteRecomendante.getFechaInicio()) +"', 'DD-MM-YYYY') ");
                queryInc.append("                          and to_date ('"+ df.format(clienteRecomendante.getFechaInicio()) +"', 'DD/MM/YYYY') <= fec_fina ) ");
                queryInc.append("           union ");    
                queryInc.append("                 select rownum + 1 as n, oid_peri      as oid_peri, ");    
                queryInc.append("                                         fec_inic      as fec_inic, ");    
                queryInc.append("                                         fec_fina      as fec_fina, ");    
                queryInc.append("                                         pais_oid_pais as pais_oid_pais, ");    
                queryInc.append("                                         marc_oid_marc as marc_oid_marc, ");    
                queryInc.append("                                         cana_oid_cana as cana_oid_cana ");    
                queryInc.append("                   from cra_perio ");    
                queryInc.append("                  where fec_inic <= to_date ('"+ df.format(clienteRecomendante.getFechaInicio()) +"', 'DD-MM-YYYY') ");
                queryInc.append("                    and to_date('"+ df.format(clienteRecomendante.getFechaInicio()) +"', 'DD-MM-YYYY') <= fec_fina ");
                queryInc.append("               order by oid_peri asc ");    
                queryInc.append("           ) x                                                                                       ");    
                queryInc.append(" order by n ");    
    
                respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
                  UtilidadesLog.debug("******* respuestaInc " + respuestaInc);   
    
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
    
            BigDecimal bd;
            Periodo periodo = new Periodo();
            
            if (!respuestaInc.esVacio()) {
                bd = (BigDecimal) respuestaInc.getValueAt(0, "OID_PERI");
                periodo.setOidPeriodo(new Long(bd.longValue()));
                periodo.setFechaDesde((Date) respuestaInc.getValueAt(0, "FEC_INIC"));
                periodo.setFechaHasta((Date) respuestaInc.getValueAt(0, "FEC_FINA"));                    
                bd = (BigDecimal) respuestaInc.getValueAt(0, "PAIS_OID_PAIS");
                periodo.setOidPais(new Long(bd.longValue()));
                bd = (BigDecimal) respuestaInc.getValueAt(0, "MARC_OID_MARC");
                periodo.setOidMarca(new Long(bd.longValue()));
                bd = (BigDecimal) respuestaInc.getValueAt(0, "CANA_OID_CANA");
                periodo.setOidCanal(new Long(bd.longValue()));
            }  

            clienteRecomendante.setPeriodo(periodo);
            // } 
            
            Cliente clienteLocal = new Cliente();
            clienteLocal.setOidCliente(clienteRecomendante.getRecomendante());
            this.obtenerPeriodosConPedidosCliente(clienteLocal);
            clienteRecomendante.setPeriodosConPedidos(clienteLocal.getPeriodosConPedidos());
            clienteParametro.setClienteRecomendante(clienteRecomendante);
            
        } else {
            clienteParametro.setClienteRecomendante(null);
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerClienteRecomendante(Cliente"
            +" clienteParametro, Long oidPais):Salida");
    }

    /**
     * Metodo: obtenerPosicionesSolicitud
     * Autor: Dante Castiglione
     * Fecha: 2005/03/10
     *
     * Descripcion: este metodo recupera las posiciones de la solicitud
     * recibida por parametro.
     */
    public void obtenerPosicionesSolicitud(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerPosicionesSolicitud(Solici"
            +"tud solicitud):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            //jrivas 20/7/2006 (indDevolucion) DBLG5000974 / DBLG5000981 / DBLG5001011
            //jrivas 1/8/2006 (indAnulacion) DBLG50001003
            if (!solicitud.getIndDevolucion() && !solicitud.getIndAnulacion()) {
                query.append(" SELECT OID_SOLI_POSI, ");
                query.append("  ESPO_OID_ESTA_POSI, ");
                //jrivas 27/04/2006 INC DBLG50000354
                //query.append("  VAL_PREC_CATA_TOTA_LOCA_UNID, ");
                query.append("  NUM_UNID_POR_ATEN, ");
                query.append("  NUM_UNID_COMPR, ");
                query.append("  VAL_PREC_CATA_UNIT_LOCA,  ");
                //jrivas 27/04/2006 INC DBLG50000354
                //query.append(" VAL_PREC_CONT_UNIT_LOCA, ");
                query.append("  IND_CTRL_STOC, ");
                query.append("  IND_CTRL_LIQU, ");
                query.append("  IND_LIMI_VENT, ");
                query.append("  NUM_UNID_DEMA_REAL, ");
                query.append("  MAPR_OID_MARC_PROD, ");
                query.append("  UNEG_OID_UNID_NEGO, ");
                query.append("  NEGO_OID_NEGO, ");
                query.append("  GENE_OID_GENE, ");
                query.append("  SGEN_OID_SUPE_GENE, ");
                query.append("  TOFE_OID_TIPO_OFER, ");
                query.append("  CIVI_OID_CICLO_VIDA, ");
                query.append("  SP.NUM_UNID_DEMA, ");
                query.append("  PR.OID_PROD, ");
                query.append("  VAL_PREC_FACT_UNIT_LOCA, ");
                query.append("  VAL_PREC_NETO_UNIT_LOCA ");
                
                // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013    
                query.append("  ,OFDE_OID_DETA_OFER ");
                
                query.append(" FROM PED_SOLIC_POSIC SP, ");
                query.append("  MAE_PRODU PR, ");
                query.append("  PRE_OFERT_DETAL OD ");
                query.append(" WHERE SP.PROD_OID_PROD = PR.OID_PROD ");
                query.append("  AND SP.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER(+) ");
                query.append("  AND SP.SOCA_OID_SOLI_CABE = ").append(solicitud.getOidSolicitud());
            } else {
                query.append(" SELECT OID_SOLI_POSI, ESPO_OID_ESTA_POSI, NUM_UNID_POR_ATEN, NUM_UNID_COMPR, ");
                query.append(" VAL_PREC_CATA_UNIT_LOCA, IND_CTRL_STOC, IND_CTRL_LIQU, IND_LIMI_VENT, ");
                query.append(" NUM_UNID_DEMA_REAL, MAPR_OID_MARC_PROD, UNEG_OID_UNID_NEGO, ");
                query.append(" NEGO_OID_NEGO, GENE_OID_GENE, SGEN_OID_SUPE_GENE, ");
                query.append(" A.CIVI_OID_CICLO_VIDA, A.TOFE_OID_TIPO_OFER, SP.NUM_UNID_DEMA, ");
                query.append(" PR.OID_PROD, VAL_PREC_FACT_UNIT_LOCA, VAL_PREC_NETO_UNIT_LOCA ");
                
                // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013    
                query.append("  ,OFDE_OID_DETA_OFER ");
                
                // sapaza -- PER-SiCC-2011-0279 -- 07/06/2011
                if(solicitud.isValidaReemplazo()) {
                    query.append(" ,(SELECT COUNT(1) FROM pre_matri_factu mf, PRE_MATRI_REEMP mr ");
                    query.append("         WHERE mf.OID_MATR_FACT = mr.MAFA_OID_COD_REEM ");   
                    query.append("           AND mf.ofde_oid_deta_ofer = SP.OFDE_OID_DETA_OFER) COD_REEM ");
                }
                
                query.append(" FROM PED_SOLIC_POSIC SP, ");
                query.append(" MAE_PRODU PR, ");
                query.append(" (SELECT DISTINCT OD.CIVI_OID_CICLO_VIDA, OD.TOFE_OID_TIPO_OFER, ");
                query.append(" OD.PROD_OID_PROD ");
                query.append(" FROM PRE_OFERT_DETAL OD, ");
                query.append(" PRE_OFERT O, ");
                query.append(" PRE_MATRI_FACTU_CABEC MFC ");
                query.append(" WHERE OD.OFER_OID_OFER = O.OID_OFER ");
                query.append(" AND O.MFCA_OID_CABE = MFC.OID_CABE ");
                query.append(" AND MFC.PERD_OID_PERI = ");
                query.append(" (SELECT DISTINCT SC3.PERD_OID_PERI ");
                query.append(" FROM PED_SOLIC_POSIC SP, ");
                query.append(" PED_SOLIC_CABEC SC, ");
                query.append(" PED_SOLIC_CABEC SC2, ");
                query.append(" PED_SOLIC_CABEC SC3 ");
                query.append(" WHERE SC.OID_SOLI_CABE = ").append(solicitud.getOidSolicitud());
                query.append(" AND SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
                query.append(" AND SC.SOCA_OID_DOCU_REFE = SC2.OID_SOLI_CABE ");
                query.append(" AND SC3.SOCA_OID_SOLI_CABE = SC2.OID_SOLI_CABE ");
                query.append(" AND OD.VAL_CODI_VENT = SP.VAL_CODI_VENT ");
                query.append(" AND OD.PROD_OID_PROD = SP.PROD_OID_PROD)) A ");
                query.append(" WHERE SP.PROD_OID_PROD = PR.OID_PROD ");
                query.append(" AND SP.SOCA_OID_SOLI_CABE = ").append(solicitud.getOidSolicitud());
                query.append(" AND A.PROD_OID_PROD = SP.PROD_OID_PROD ");
            }

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* Posiciones " + respuesta);                                
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        if (respuesta.esVacio()) {
            solicitud.setPosiciones(new Posicion[0]);
        } else {
            Posicion[] posiciones = new Posicion[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                posiciones[i] = new Posicion();
                posiciones[i].setSolicitud(solicitud);
                posiciones[i].setOidPosicion(new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "OID_SOLI_POSI")).longValue()));

                {
                    BigDecimal oidPosicion = (BigDecimal) respuesta
                        .getValueAt(i, "ESPO_OID_ESTA_POSI");
                    posiciones[i].setEstado((oidPosicion != null) ? new Long(
                        oidPosicion.longValue()) : null);
                }

                //jrivas 27/04/2006 INC DBLG50000354
                /*{
                    BigDecimal precio1 = (BigDecimal) respuesta
                        .getValueAt(i, "VAL_PREC_CATA_TOTA_LOCA_UNID");
                    posiciones[i].setPrecioCatalogTotalUniDemandaReal(
                        (precio1 != null) ? precio1 : new BigDecimal(0));
                }*/

                {
                    BigDecimal unidadesPorAtender = (BigDecimal) respuesta
                        .getValueAt(i, "NUM_UNID_POR_ATEN");
                    posiciones[i].setUnidadesPorAtender(
                        (unidadesPorAtender != null) ? new Long(
                            unidadesPorAtender.longValue()) : new Long(0));
                }

                {
                    BigDecimal unidadesComprometidas = (BigDecimal) respuesta
                        .getValueAt(i, "NUM_UNID_COMPR");
                    posiciones[i].setUnidadesComprometidas(
                        (unidadesComprometidas != null) ? new Long(
                            unidadesComprometidas.longValue()) : new Long(0));
                }

                {
                    BigDecimal precio2 = (BigDecimal) respuesta
                        .getValueAt(i, "VAL_PREC_CATA_UNIT_LOCA");
                    posiciones[i].setPrecioCatalogoUnitarioLocal(
                        (precio2 != null) ? precio2 : new BigDecimal(0));
                }

                //jrivas 27/04/2006 INC DBLG50000354
                /*    BigDecimal precio3 = (BigDecimal) respuesta
                        .getValueAt(i, "VAL_PREC_CONT_UNIT_LOCA");
                    posiciones[i].setPrecioContableUnitarioLocal(
                        (precio3 != null) ? precio3 : new BigDecimal(0));*/


                {
                    BigDecimal controlStock = (BigDecimal) respuesta
                        .getValueAt(i, "IND_CTRL_STOC");

                    if (controlStock == null) {
                        posiciones[i].setControlStock(false);
                    } else {
                        if (controlStock.intValue() == 1) {
                            posiciones[i].setControlStock(true);
                        } else {
                            posiciones[i].setControlStock(false);
                        }
                    }
                }

                {
                    BigDecimal controlLiquidacion = (BigDecimal) respuesta
                        .getValueAt(i, "IND_CTRL_LIQU");

                    if (controlLiquidacion == null) {
                        posiciones[i].setControlLiquidacion(false);
                    } else {
                        if (controlLiquidacion.intValue() == 1) {
                            posiciones[i].setControlLiquidacion(true);
                        } else {
                            posiciones[i].setControlLiquidacion(false);
                        }
                    }
                }

                {
                    BigDecimal limiteVenta = (BigDecimal) respuesta
                        .getValueAt(i, "IND_LIMI_VENT");

                    if (limiteVenta == null) {
                        posiciones[i].setLimiteVenta(false);
                    } else {
                        if (limiteVenta.intValue() == 1) {
                            posiciones[i].setLimiteVenta(true);
                        } else {
                            posiciones[i].setLimiteVenta(false);
                        }
                    }
                }

                {
                    BigDecimal unidades = (BigDecimal) respuesta
                        .getValueAt(i, "NUM_UNID_DEMA_REAL");
                    posiciones[i].setUnidadesDemandaReal((unidades != null) 
                        ? new Long(unidades.longValue()) : new Long(0));
                }

                {
                    BigDecimal oidMarcaProducto = (BigDecimal) respuesta
                        .getValueAt(i, "MAPR_OID_MARC_PROD");
                    posiciones[i].setOidMarcaProducto(
                        (oidMarcaProducto != null) ? new Long(oidMarcaProducto
                            .longValue()) : null);
                }

                {
                    BigDecimal oidUnidadNegocio = (BigDecimal) respuesta
                        .getValueAt(i, "UNEG_OID_UNID_NEGO");
                    posiciones[i].setOidUnidadNegocio(
                        (oidUnidadNegocio != null) ? new Long(oidUnidadNegocio
                            .longValue()) : null);
                }

                {
                    BigDecimal oidNegocio = (BigDecimal) respuesta
                        .getValueAt(i, "NEGO_OID_NEGO");
                    posiciones[i].setOidNegocio((oidNegocio != null) 
                        ? new Long(oidNegocio.longValue()) : null);
                }

                {
                    BigDecimal oidGenerico = (BigDecimal) respuesta
                        .getValueAt(i, "GENE_OID_GENE");
                    posiciones[i].setOidGenerico((oidGenerico != null) 
                        ? new Long(oidGenerico.longValue()) : null);
                }

                {
                    BigDecimal oidSuperGenerico = (BigDecimal) respuesta    
                        .getValueAt(i, "SGEN_OID_SUPE_GENE");
                    posiciones[i].setOidSuperGenerico(
                        (oidSuperGenerico != null) ? new Long(oidSuperGenerico
                            .longValue()) : null);
                }

                BigDecimal uniDemandadas = (BigDecimal) respuesta
                    .getValueAt(i, "NUM_UNID_DEMA");
                posiciones[i].setUnidadesDemandadas((uniDemandadas != null) 
                    ? new Long(uniDemandadas.longValue()) : new Long(0));

                posiciones[i].setOidProducto(new Long(((BigDecimal) respuesta
                    .getValueAt(i, "OID_PROD")).longValue()));
                    
                BigDecimal oidTipoOferta = (BigDecimal) respuesta    
                        .getValueAt(i, "TOFE_OID_TIPO_OFER");    
                posiciones[i].setOidTipoOferta(
                            (oidTipoOferta != null) ? new Long(oidTipoOferta
                            .longValue()) : null);
                    
                BigDecimal oidCicloVida = (BigDecimal) respuesta    
                        .getValueAt(i, "CIVI_OID_CICLO_VIDA");    
                posiciones[i].setOidCicloVida(
                    (oidCicloVida != null) ? new Long(oidCicloVida
                            .longValue()) : null);
                    
                posiciones[i].setPrecioFacturaUnitarioLocal((BigDecimal) respuesta
                    .getValueAt(i, "VAL_PREC_FACT_UNIT_LOCA"));
                
                posiciones[i].setPrecioNetoUnitarioLocal((BigDecimal) respuesta
                    .getValueAt(i, "VAL_PREC_NETO_UNIT_LOCA"));
                    
                // sapaza -- PER-SiCC-2011-0279 -- 07/06/2011
                if (solicitud.getIndDevolucion() && solicitud.isValidaReemplazo()) {    
                    BigDecimal codigoReemplazo = (BigDecimal) respuesta.getValueAt(i, "COD_REEM");
    
                    if (codigoReemplazo == null) {
                        posiciones[i].setProductoReemplazo(false);
                    } else {
                        if (codigoReemplazo.intValue() > 0) {
                            posiciones[i].setProductoReemplazo(true);
                        } else {
                            posiciones[i].setProductoReemplazo(false);
                        }
                    }
                } else   
                    posiciones[i].setProductoReemplazo(false);
                    
                // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013    
                BigDecimal oidDetalleOferta = (BigDecimal) respuesta    
                        .getValueAt(i, "OFDE_OID_DETA_OFER");    
                posiciones[i].setOidDetalleOferta(
                            (oidDetalleOferta != null) ? new Long(oidDetalleOferta.longValue()) : null);    
                    
            } // posiciones

            solicitud.setPosiciones(posiciones);
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerPosicionesSolicitud(Solici"
            +"tud solicitud):Salida");
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Cliente cliente, Gerente gerente
     * @return void
     * @documentation  este metodo completa los datos del cada gerente en el 
     * ambito gegrafico del cliente recibido por parametro.
     *
     * @date
     */
    private void obtenerDatosGerentes(Cliente cliente, Periodo periodo)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGerentes(Cliente "
            +"cliente, Periodo periodo):Entrada");
        AmbitoGeografico clienAmbitoGeo = cliente.getAmbitoGeografico();

        if (clienAmbitoGeo != null) {
            obtenerTipificacionesCliente(clienAmbitoGeo.getSubgerente()); //1
            obtenerTipificacionesCliente(clienAmbitoGeo.getGerenteRegion()); //2
            obtenerTipificacionesCliente(clienAmbitoGeo.getGerenteZona()); //3
            obtenerTipificacionesCliente(clienAmbitoGeo.getLider()); //4

            //jrivas 29/6/2005
            //modificado inc 19479
            clienAmbitoGeo.getSubgerente().setAmbitoGeografico(
                obtenerAmbitoGeograficoParticipante(clienAmbitoGeo
                    .getSubgerente().getOidCliente(), periodo)); //5
            clienAmbitoGeo.getGerenteRegion().setAmbitoGeografico(
                obtenerAmbitoGeograficoParticipante(clienAmbitoGeo
                    .getGerenteRegion().getOidCliente(),periodo)); //6
            clienAmbitoGeo.getGerenteZona().setAmbitoGeografico(
                obtenerAmbitoGeograficoParticipante(clienAmbitoGeo
                    .getGerenteZona().getOidCliente(),periodo)); //7
            clienAmbitoGeo.getLider().setAmbitoGeografico(
                obtenerAmbitoGeograficoParticipante(clienAmbitoGeo.getLider()
                    .getOidCliente(), periodo)); //8
            //9        
            obtenerDatosGeneralesParticipante(clienAmbitoGeo.getSubgerente());
            //20
            obtenerDatosGeneralesParticipante(clienAmbitoGeo
                .getGerenteRegion()); 
            //21                
            obtenerDatosGeneralesParticipante(clienAmbitoGeo.getGerenteZona());
            //22
            obtenerDatosGeneralesParticipante(clienAmbitoGeo.getLider()); 
        }
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGerentes(Cliente "
            +"cliente, Periodo periodo):Salida");
    }
    
    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Long oidCliente
     * @return AmbitoGeografico
     * @documentation completa el ambito geografico del participante recibido 
     * por parametro sin cargar los gerentes.
     *
     * @date
     */
    private AmbitoGeografico obtenerAmbitoGeograficoParticipante(Long 
        oidCliente, Periodo periodo) throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerAmbitoGeograficoParticipan"
            +"te(Long oidCliente, Periodo periodo):Entrada");

    /*
    Implementacion:
    Con los datos obtenidos de la siguiente query crear un objeto de la clase 
    AmbitoGeografico y asignarselo a la propiedad del participante
    como se detalla a continuacion:
    SELECT G.OID_SUBG_VENT,
    F.OID_REGI,
    E.OID_ZONA,
    D.OID_SECC,
    B.COD_TERR
    FROM MAE_CLIEN_DIREC A,
    ZON_TERRI B,
    ZON_TERRI_ADMIN C,
    ZON_SECCI D,
    ZON_ZONA E,
    ZON_REGIO F,
    ZON_SUB_GEREN_VENTA G,
    MAE_CLIEN_UNIDA_ADMIN H,
    CRA_PERIO I,
    SEG_PERIO_CORPO J,
    SEG_TIPO_PERIO K,
    SEG_MARCA L,
    SEG_CANAL M
    WHERE A.CLIE_OID_CLIE = oidCliente
    AND A.IND_DIRE_PPAL = ConstantesCAL.ACTIVO
    AND B.OID_TERR = A.TERR_OID_TERR
    AND C.TERR_OID_TERR = B.OID_TERR
    AND D.OID_SECC = C.ZSCC_OID_SECC
    AND E.OID_ZONA = D.ZZON_OID_ZONA
    AND F.OID_REGI = E.ZORG_OID_REGI
    AND G.OID_SUBG_VENT = F.ZSGV_OID_SUBG_VENT
    AND H.CLIE_OID_CLIE = A.CLIE_OID_CLIE
    AND H.IND_ACTI = ConstantesCAL.ACTIVO
    AND I.OID_PERI = H.PERD_OID_PERI_INI
    AND J.OID_PERI = I.PERI_OID_PERI
    AND K.OID_TIPO_PERI = J.TIPE_OID_TIPO_PERI
    AND L.OID_MARC = I.MARC_OID_MARC
    AND M.OID_CANA = I.CANA_OID_CANA
    ORDER BY I.FEC_INIC DESC
    Por cada registro obtenido hacer lo siguiente:
    1.- Crear un objeto de la clase AmbitoGeografico (ambGeo).
    2.- Asignar los siguientes atributos:
    2.1.- ambGeo.oidSubgerencia = OID_SUBG_VENT
    2.2.- ambGeo.oidRegion = OID_REGI
    2.3.- ambGeo.oidZona = OID_ZONA
    2.4.- ambGeo.oidSeccion = OID_SECC
    2.5.- ambGeo.oidTerritorio = COD_TERR
    3.-Retornar el objeto de la clase AmbitoGeografico obtenido en el punto 
    anterior.
    */ 
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        AmbitoGeografico ambGeo = new AmbitoGeografico();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //jrivas 29/6/2005
            //Modificado INC. 19479
            SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaDesde = sdfFormato.format(periodo.getFechaDesde());
            String fechaHasta = sdfFormato.format(periodo.getFechaHasta());
            buf.append(" SELECT sub.oid_subg_vent, reg.oid_regi, ");
            buf.append(" zon.oid_zona, sec.oid_secc, ");
            buf.append("        terr.terr_oid_terr ");
            buf.append("   FROM mae_clien_unida_admin una, ");
            buf.append("        zon_terri_admin terr, ");
            buf.append("        zon_secci sec, ");
            buf.append("        zon_zona zon, ");
            buf.append("        zon_regio reg, ");
            buf.append("        zon_sub_geren_venta sub ");
            //jrivas 27/04/2006 INC DBLG50000361
            //buf.append("       , cra_perio per1,  ");
            //buf.append("       cra_perio per2 ");
            buf.append("  WHERE una.clie_oid_clie = " + oidCliente);
            buf.append("    AND una.ztad_oid_terr_admi = terr.oid_terr_admi ");
            buf.append("    AND terr.zscc_oid_secc = sec.oid_secc ");
            buf.append("    AND sec.zzon_oid_zona = zon.oid_zona ");
            buf.append("    AND zon.zorg_oid_regi = reg.oid_regi ");
            buf.append("    AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");
            //jrivas 27/04/2006 INC DBLG50000361
            buf.append("   AND una.perd_oid_peri_fin IS NULL ");
            
            // sapaza -- PER-SiCC-2013-0960 -- 03/09/2013
            //buf.append("   AND una.ind_acti = 1 ");
            
            /*buf.append("    AND una.perd_oid_peri_fin = per2.oid_peri(+) ");
            buf.append("    AND una.perd_oid_peri_ini = per1.oid_peri ");
            buf.append("   AND per1.fec_inic <= TO_DATE ('" + fechaDesde 
                + "', 'dd/MM/yyyy') ");
            buf.append("   AND (   per2.fec_fina IS NULL  OR ");
            buf.append(" per2.fec_fina >= TO_DATE ('" + fechaHasta + 
                "', 'dd/MM/yyyy')    ) ");*/
            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* Ambitos " + rs);                                

            if ( (rs == null) || rs.esVacio()) {
                UtilidadesLog.info(" DAOSolicitudes.obtenerAmbitoGeografico"
                    +"Participante(Long oidCliente, Periodo periodo):Salida");
                return null;
            } else {
                ambGeo.setOidSubgerencia(Long.valueOf(rs
                    .getValueAt(0, "OID_SUBG_VENT").toString()));
                ambGeo.setOidRegion(Long.valueOf(rs
                    .getValueAt(0, "OID_REGI").toString()));
                ambGeo.setOidZona(Long.valueOf(rs.getValueAt(0, "OID_ZONA")
                    .toString()));
                ambGeo.setOidSeccion(Long.valueOf(rs.getValueAt(0, "OID_SECC")
                    .toString()));
                ambGeo.setOidTerritorio(Long.valueOf(rs
                    .getValueAt(0, "TERR_OID_TERR").toString()));
                UtilidadesLog.info(" DAOSolicitudes.obtenerAmbitoGeografico"
                    +"Participante(Long oidCliente, Periodo periodo):Salida");
                return ambGeo;
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Participante participante
     * @return void
     * @documentation
        obtiene atributos que tengan la misma cardinalidad propios del
        participante.

     *
     * @date
     */
    private void obtenerDatosGeneralesParticipante(Participante participante)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesParticipante("
            +"Participante participante):Entrada");        
            /*
        
    Autor:DVJUIZ
    Fecha:08/04/2005

    Descripcion: obtener atributos que tengan la misma cardinalidad propios 
    del participante.

    Implementacion:

    Completar el atributo nombre del participante recibido por parametro de 
    la siguiente manera:
    Se obtiene de la entidad MAE:ClienteDatosBasicos filtrando por el 
    participante.oidCliente.
    Se deben concatenar los campos: apellido1+" "+apellido2+", "+nombre1+" 
    "+nombre2
    */ 
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("participante.getOidCliente(): " +  participante.getOidCliente());
        
        if(participante.getOidCliente()!= null){
            try {            
                ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = 
                    this.getClienteDatosBasicosLocalHome();
                ClienteDatosBasicosLocal clienteDatosBasicosLocal = 
                    clienteDatosBasicosLocalHome.findByPrimaryKey(participante
                        .getOidCliente());
    
                participante.setNombre(clienteDatosBasicosLocal.getVal_ape1() +
                    " " + clienteDatosBasicosLocal.getVal_ape2() + ", " +
                    clienteDatosBasicosLocal.getVal_nom1() + " " + 
                    clienteDatosBasicosLocal.getVal_nom2());
                    
            } catch (NoResultException nre) {
                participante.setNombre("");
            } catch (PersistenceException pe) {
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        } else {
            participante.setNombre("");
        }
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerDatosGeneralesParticipante("
            +"Participante participante):Salida");        
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs obtenerSolicitudesConsolidado(Long oidSolicitudConsolidado) 
      throws MareException {
      UtilidadesLog.info(" DAOSolicitudes.obtenerSolicitudesConsolidado(Long "
          +"oidSolicitudConsolidado):Entrada");        
      UtilidadesLog.debug("Entre a obtenerSolicitudesConsolidado con oidSolici"
          +"tudConsolidado: " + oidSolicitudConsolidado);
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConRecom = null;
      Long oid = null;
    
      query.append(" SELECT DISTINCT solCab.OID_SOLI_CABE ");
      query.append(" FROM PED_SOLIC_CABEC solCab,  ");
      query.append(" INC_SOLIC_CONCU_PUNTA solConPunt ");
      query.append(" WHERE solConPunt.SOCA_OID_SOLI_CABE =  ");
      query.append(" solCab.OID_SOLI_CABE ");
      query.append(" AND solCab.SOCA_OID_SOLI_CABE = " + 
        oidSolicitudConsolidado);
    
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(
            query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("resultado: " + rs);
      
      // Coloco en el DTO los OIDs que devolvió la consulta
      int rows = rs.getRowCount();
      Long[] oids = new Long[rows];

      for (int i = 0; i < rows; i++) {
          oidSoliConRecom = (BigDecimal) rs.getValueAt(i, "OID_SOLI_CABE");
          oid = Long.valueOf(oidSoliConRecom.toString());
          oids[i] = oid;
      }

      dtoOids.setOids(oids);
      UtilidadesLog.info(" DAOSolicitudes.obtenerSolicitudesConsolidado(Long "
         +"oidSolicitudConsolidado):Salida");        
      return dtoOids;
  }
  
  /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   22/09/2005
     * @version 1.00
     * @autor   Viviana Bongiovanni
     */
  public boolean esClienteRecomendante(Long oidCliente, Periodo periodoCalculo) throws MareException {
      UtilidadesLog.info("DAOSolicitudes.esClienteRecomendante(Long oidCliente, Periodo periodoCalculo):Entrada");
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
        UtilidadesLog.debug("Entre con oidCliente: " + oidCliente + " y periodoCalculo: " + periodoCalculo.getOidPeriodo());
      
      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      String fechaDesde = sdfFormato.format(periodoCalculo.getFechaDesde());
      String fechaHasta = sdfFormato.format(periodoCalculo.getFechaHasta());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
    
      query.append(" SELECT vinc.OID_CLIE_VINC ");
      query.append(" FROM MAE_CLIEN_VINCU vinc, MAE_TIPO_VINCU tipo ");
      query.append(" WHERE vinc.CLIE_OID_CLIE_VNTE = " + oidCliente);
      query.append(" AND vinc.TIVC_OID_TIPO_VINC =  tipo.OID_TIPO_VINC ");
      
      // BELC300022542 - gPineda - 24/08/06
      //query.append(" AND tipo.COD_TIPO_VINC = '" + ConstantesMAE.TIPO_VINCULO_RECOMENDADA + "' ");
      query.append(" AND tipo.ind_reco = 1 ");
      
      query.append(" AND vinc.FEC_DESD <= TO_DATE('" + fechaDesde + "', 'dd/MM/yyyy')");
      query.append(" AND vinc.FEC_HAST >= TO_DATE('" + fechaHasta + "', 'dd/MM/yyyy')");
    
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
        UtilidadesLog.debug("resultado: " + rs);
      
      if(!rs.esVacio()){
           UtilidadesLog.info("DAOSolicitudes.esClienteRecomendante(Long oidCliente, Periodo periodoCalculo):Salida");
           return true;
      } else {
          UtilidadesLog.info("DAOSolicitudes.esClienteRecomendante(Long oidCliente, Periodo periodoCalculo):Salida");
          return false;
      }
  }
  
    /**
     * @author Juliàn Rivas
     * 25/7/2006
     * DBLG50000902
     */
    public void obtenerMontoUnidadesAcumuladasPedido(Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicictudes.obtenerMontoUnidadesAcumuladasPedido:Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT  NVL(SUM(NUM_UNID_DEMA_REAL), 0) UNIDADES_PEDIDO,  ");
            query.append(" NVL(SUM(NUM_UNID_DEMA_REAL * VAL_PREC_CATA_UNIT_LOCA), 0) MONTO_PEDIDO ");
            query.append(" FROM PED_SOLIC_CABEC PSC, ");
            query.append(" PED_SOLIC_POSIC PSP, ");
            query.append(" PED_TIPO_SOLIC_PAIS PTP, ");                                 // JVM, sicc 20070354
            query.append(" PED_TIPO_SOLIC PTS ");                                       // JVM, sicc 20070354
            query.append(" WHERE PSC.OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE ");
            query.append(" AND PSC.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
            query.append(" AND PSC.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
            query.append(" AND PSC.IND_OC = 1 ");
            query.append(" AND ptp.OID_TIPO_SOLI_PAIS = psc.TSPA_OID_TIPO_SOLI_PAIS "); // JVM, sicc 20070354
            query.append(" AND ptp.tsol_oid_tipo_soli = pts.OID_TIPO_SOLI ");           // JVM, sicc 20070354
            query.append(" AND pts.ind_anul = 0 ");                                     // JVM, sicc 20070354
            query.append(" AND pts.ind_devo = 0  ");                                    // JVM, sicc 20070354            
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }


        solicitud.setMontoAcumuladoPedido((BigDecimal) respuesta.getValueAt(0, "MONTO_PEDIDO"));
        solicitud.setUnidadesAcumuladasPedido(new Long(((BigDecimal)respuesta.getValueAt(0, "UNIDADES_PEDIDO")).longValue()));

        UtilidadesLog.info("DAOSolicictudes.obtenerMontoUnidadesAcumuladasPedido:Salida");
    }  

    /**
     * Metodo: obtenerDatosGeneralesSolicitud
     * @author: Julián Rivas
     * @date: 1/8/2006
     * Inc DBLG500001003
     */
    public void rellenarAnulaciones(DTOSolicitudValidacion dtoSolicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudes.rellenarAnulaciones("
            +"DTOSolicitudValidacion dtoSolicitud):Entrada");


        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService4 = null;

        query.append(" SELECT MAX(sol_orig.oid_soli_cabe) OID_SOLI_CABE, MAX(sol_orig.perd_oid_peri) PERD_OID_PERI ");
        query.append("   FROM ped_solic_cabec sol_anul, ");
        query.append("        ped_solic_cabec sol_orig, ");
        query.append("        ped_tipo_solic_pais ptsp, ");
        query.append("        ped_tipo_solic pts ");
        query.append("  WHERE sol_anul.oid_soli_cabe = " + dtoSolicitud.getOidSolicitud());
        query.append("    AND sol_anul.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais ");
        query.append("    AND ptsp.tsol_oid_tipo_soli = pts.oid_tipo_soli ");
        query.append("    AND sol_anul.soca_oid_docu_refe = sol_orig.oid_soli_cabe(+) ");
        query.append("    AND pts.ind_anul = 1 ");
        
        //jrivas 21/11/2007 20070447
        query.append("    AND sol_anul.COPA_OID_PARA_GENE IS NULL ");
        query.append("    AND sol_anul.ICTP_OID_TIPO_PROG IS NULL ");        
      
        try {
            rs = belcorpService4.getInstance().dbService.executeStaticQuery(query.toString());
            
            UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal consolidado = (BigDecimal) rs.getValueAt(0, "OID_SOLI_CABE");
        BigDecimal periodo = (BigDecimal) rs.getValueAt(0, "PERD_OID_PERI");
        
        if (consolidado != null) {
            dtoSolicitud.setOidSolicitud(new Long(consolidado.longValue()));
            dtoSolicitud.setOidPeriodo(new Long(periodo.longValue()));
        } else {
            //jrivas 21/11/2007 20070447
            //Si no encuentro datos del consolidado, no se procesa.
            dtoSolicitud.setOidSolicitud(null);            
        }

        UtilidadesLog.info(" DAOSolicitudes.rellenarAnulaciones("
            +"DTOSolicitudValidacion dtoSolicitud):Salida");
    }

  /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   30/08/2006
     * @version 1.00
     * @autor   Julián Rivas
     * Inc. DBLG50000839
     */
  public boolean esClienteRecomendado(Long oidCliente, Periodo periodoCalculo) throws MareException {
      UtilidadesLog.info("DAOSolicitudes.esClienteRecomendado(Long oidCliente, Periodo periodoCalculo):Entrada");
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
        UtilidadesLog.debug("Entre con oidCliente: " + oidCliente + " y periodoCalculo: " + periodoCalculo.getOidPeriodo());
      
      SimpleDateFormat sdfFormato = new SimpleDateFormat("dd/MM/yyyy");
      String fechaDesde = sdfFormato.format(periodoCalculo.getFechaDesde());
      String fechaHasta = sdfFormato.format(periodoCalculo.getFechaHasta());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
    
      query.append(" SELECT vinc.OID_CLIE_VINC ");
      query.append(" FROM MAE_CLIEN_VINCU vinc, MAE_TIPO_VINCU tipo ");
      query.append(" WHERE vinc.CLIE_OID_CLIE_VNDO = " + oidCliente);
      query.append(" AND vinc.TIVC_OID_TIPO_VINC =  tipo.OID_TIPO_VINC ");
      query.append(" AND tipo.ind_reco = 1 ");
      query.append(" AND vinc.FEC_DESD <= TO_DATE('" + fechaDesde + "', 'dd/MM/yyyy')");
      query.append(" AND vinc.FEC_HAST >= TO_DATE('" + fechaHasta + "', 'dd/MM/yyyy')");
    
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
        UtilidadesLog.debug("resultado: " + rs);
      
      if(!rs.esVacio()){
           UtilidadesLog.info("DAOSolicitudes.esClienteRecomendado(Long oidCliente, Periodo periodoCalculo):Salida TRUE");
           return true;
      } else {
          UtilidadesLog.info("DAOSolicitudes.esClienteRecomendado(Long oidCliente, Periodo periodoCalculo):Salida FALSE");
          return false;
      }
  }

  /**
   * Obtiene datos de la solicitud devuelta relacionada 
   * con la devolucion recibida por parametro, valida que sea una solicitud de devolucion 
   * y que se devuelva una posicion de una solicitud que haya generado puntos.
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoSolicitud con oid
   * @author gPineda
   */
  public void rellenarDevoluciones(DTOSolicitudValidacion dtoSolicitud)
    throws MareException{
    UtilidadesLog.info("DAOSolicitudes.rellenarDevoluciones(DTOSolicitudValidacion dtoSolicitud):Entrada");
    Long oidConsolidado = null, oidPeriodo = null;
    RecordSet rs;
    StringBuffer query = new StringBuffer();

    query.append(" SELECT MAX(SOL_ORIG.OID_SOLI_CABE) OID_SOLI_CABE, MAX(SOL_ORIG.PERD_OID_PERI) PERD_OID_PERI  ");

    query.append(" FROM PED_SOLIC_CABEC SOL_DEVO,  ");
    query.append("      PED_SOLIC_CABEC SOL_ORIG, ");
    query.append("      PED_SOLIC_CABEC SOL_DEVUELTA, ");
    query.append("      INC_SOLIC_CONCU_PUNTA SCP, ");
    query.append("      PED_TIPO_SOLIC_PAIS PTSP, ");
    query.append("      PED_TIPO_SOLIC PTS ");
    
    query.append(" WHERE SOL_DEVO.OID_SOLI_CABE = " + dtoSolicitud.getOidSolicitud().toString() );
    query.append("       AND SOL_DEVO.SOCA_OID_DOCU_REFE = SOL_ORIG.OID_SOLI_CABE  ");
    query.append("       AND SOL_ORIG.OID_SOLI_CABE = SOL_DEVUELTA.SOCA_OID_SOLI_CABE ");
    query.append("       AND SOL_DEVUELTA.OID_SOLI_CABE = SCP.SOCA_OID_SOLI_CABE ");
    query.append("       AND SOL_DEVO.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS  ");
    query.append("       AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI  ");
    query.append("       AND PTS.IND_DEVO = 1   ");
 
    try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    if(! rs.esVacio() ){
      oidConsolidado = rs.getValueAt(0,"OID_SOLI_CABE" )!=null?
                  new Long( ((BigDecimal)rs.getValueAt(0,"OID_SOLI_CABE" ) ).longValue() ):null;
    }
    
    if( oidConsolidado != null ){
      oidPeriodo = rs.getValueAt(0,"PERD_OID_PERI" )!=null?
                    new Long( ((BigDecimal)rs.getValueAt(0,"PERD_OID_PERI" ) ).longValue() ):null;    
      
      dtoSolicitud.setOidSolicitud( oidConsolidado );
      dtoSolicitud.setOidPeriodo( oidPeriodo );
    }

    UtilidadesLog.info("DAOSolicitudes.rellenarDevoluciones(DTOSolicitudValidacion dtoSolicitud):Salida");
  }
  
  /**
   * Obtiene la solicitud de devolucion utilizando el periodo original de la solicitud devuelta
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return solicitudDevolucion
   * @param dtoSolicitud
   * @author gPineda
   */
  public Solicitud obtenerSolicitudDevolucion(DTOSolicitudValidacion dtoSolicitud)
    throws MareException{
    UtilidadesLog.info("DAOSolicitudes.obtenerSolicitudDevolucion(DTOSolicitudValidacion dtoSolicitud):Entrada");
    Solicitud solicitudDevolucion = null;
    DTOSolicitudValidacion dtoDevolucionPeriodoOriginal = new DTOSolicitudValidacion();
    dtoDevolucionPeriodoOriginal.setOidSolicitud( dtoSolicitud.getOidSolicitud() );
    
    //Este metodo modificara el oidSolicitud y el periodo de la solicitud de devolucion al de la solicitud devuelta.
    this.rellenarDevoluciones( dtoDevolucionPeriodoOriginal );
    
    if( ! dtoDevolucionPeriodoOriginal.getOidSolicitud().
            equals( dtoSolicitud.getOidSolicitud() ) ){
      //Si son distintos quiere decir que es una devolucion de una solicitud que genero puntos. 
      
      dtoDevolucionPeriodoOriginal.setFechaProceso( dtoSolicitud.getFechaProceso() );
      dtoDevolucionPeriodoOriginal.setGP( dtoSolicitud.getGP() );
      dtoDevolucionPeriodoOriginal.setIndNoConso( dtoSolicitud.getIndNoConso() );
      dtoDevolucionPeriodoOriginal.setIndOrdenCompra( dtoSolicitud.getIndOrdenCompra() );
      dtoDevolucionPeriodoOriginal.setIndPedGTZona( dtoSolicitud.getIndPedGTZona() );
      dtoDevolucionPeriodoOriginal.setIndSimulacion( dtoSolicitud.getIndSimulacion() );
      dtoDevolucionPeriodoOriginal.setIndUnionSolicitud( dtoSolicitud.getIndUnionSolicitud() );
      dtoDevolucionPeriodoOriginal.setNumDecimales( dtoSolicitud.getNumDecimales());
      dtoDevolucionPeriodoOriginal.setNumSolicitud( dtoSolicitud.getNumSolicitud() );
      dtoDevolucionPeriodoOriginal.setOidAcceso( dtoSolicitud.getOidAcceso() );
      dtoDevolucionPeriodoOriginal.setOidCanal( dtoSolicitud.getOidCanal() );
      dtoDevolucionPeriodoOriginal.setOidCliente( dtoSolicitud.getOidCliente() );
      dtoDevolucionPeriodoOriginal.setOidMarca( dtoSolicitud.getOidMarca() );
      dtoDevolucionPeriodoOriginal.setOidModulo( dtoSolicitud.getOidModulo() );
      dtoDevolucionPeriodoOriginal.setOidMoneda( dtoSolicitud.getOidMoneda() );
      //BELC300024526 - gPineda - 29/11/2006
      //dtoDevolucionPeriodoOriginal.setOidPeriodo( dtoSolicitud.getOidPeriodo() );
      dtoDevolucionPeriodoOriginal.setOidSolicitud( dtoSolicitud.getOidSolicitud() );
      dtoDevolucionPeriodoOriginal.setOidSubAcceso( dtoSolicitud.getOidSubAcceso() );
      dtoDevolucionPeriodoOriginal.setOidTipoSolPais( dtoSolicitud.getOidTipoSolPais() );      
      dtoDevolucionPeriodoOriginal.setOrden( dtoSolicitud.getOrden() );      
      dtoDevolucionPeriodoOriginal.setOrdenMonitor( dtoSolicitud.getOrdenMonitor() );
      dtoDevolucionPeriodoOriginal.setProceso( dtoSolicitud.getProceso() );
      dtoDevolucionPeriodoOriginal.setTipoCambio( dtoSolicitud.getTipoCambio() );
      dtoDevolucionPeriodoOriginal.setUbigeo( dtoSolicitud.getUbigeo() );
      dtoDevolucionPeriodoOriginal.setZona( dtoSolicitud.getZona() );
      //cvalenzu - 7/12/2006 - faltaba el pais
      dtoDevolucionPeriodoOriginal.setOidPais(dtoSolicitud.getOidPais());
      //cvalenzu - 7/12/2006 - faltaba el pais
      
      solicitudDevolucion = this.obtenerSolicitud( dtoDevolucionPeriodoOriginal );
    }
    
    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
      UtilidadesLog.debug("solicitudDevolucion: "+ solicitudDevolucion );
      
    UtilidadesLog.info("DAOSolicitudes.obtenerSolicitudDevolucion(DTOSolicitudValidacion dtoSolicitud):Salida");    
    return solicitudDevolucion;
  }
  
  /**
   * recupera las solicitudes que se deben anular en incentivos que estan relacionadas con las posiciones de una devolucion. 
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return arrSolicitudesADevolver - Si no hay, un ArrayList vacío
   * @param oidPeriodo
   * @param oidSolicitudDevolucion
   * @author gPineda
   */
  public ArrayList obtenerSolicitudesADevolverIncentivos(Long oidSolicitudDevolucion, Long oidPeriodo)
    throws MareException{
    UtilidadesLog.info("DAOSolicitudes.obtenerSolicitudesADevolverIncentivos(Long oidSolicitudDevolucion, Long oidPeriodo):Entrada");
    RecordSet rs;
    ArrayList arrSolicitudesADevolver = new ArrayList();
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT SOL_DEVUELTA.OID_SOLI_CABE SOL_DEVUELTA, SOL_DEVUELTA.PAIS_OID_PAIS, CPE.MARC_OID_MARC,  ");
    query.append("        CPE.CANA_OID_CANA, SUB.ACCE_OID_ACCE, SOL_DEVUELTA.ZZON_OID_ZONA, SOL_DEVUELTA.PERD_OID_PERI  ");

    query.append("        , SOL_DEVUELTA.CLIE_OID_CLIE ");

    query.append(" FROM PED_SOLIC_CABEC SOL_DEVOLUCION,  ");
    query.append("      INC_SOLIC_CONCU_PUNTA SCP,  ");
    query.append("      PED_SOLIC_CABEC SOL_DEVUELTA,  ");
    query.append("      CRA_PERIO CPE, ");
    query.append("      SEG_SUBAC SUB  ");

    query.append(" WHERE SOL_DEVOLUCION.OID_SOLI_CABE =  "+ oidSolicitudDevolucion );
    query.append("      AND SCP.CLIE_OID_CLIE = SOL_DEVOLUCION.CLIE_OID_CLIE  ");
    query.append("      AND SCP.PERD_OID_PERI =  "+ oidPeriodo );
    query.append("      AND SCP.SOCA_OID_SOLI_CABE = SOL_DEVUELTA.OID_SOLI_CABE  ");
    query.append("      AND SOL_DEVUELTA.PERD_OID_PERI = CPE.OID_PERI  ");
    query.append("      AND SOL_DEVUELTA.SBAC_OID_SBAC = SUB.OID_SBAC  ");
    
    query.append(" GROUP BY SOL_DEVUELTA.OID_SOLI_CABE, SOL_DEVUELTA.PAIS_OID_PAIS, CPE.MARC_OID_MARC,  ");
    query.append("          CPE.CANA_OID_CANA, SUB.ACCE_OID_ACCE, SOL_DEVUELTA.ZZON_OID_ZONA, SOL_DEVUELTA.PERD_OID_PERI  ");

    query.append("        , SOL_DEVUELTA.CLIE_OID_CLIE ");
    
    
    try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    int tamanio = rs.getRowCount();
    for( int i = 0; i < tamanio; i++){
      DTOSolicitudValidacion solicitud = new DTOSolicitudValidacion();
      
      solicitud.setOidSolicitud( rs.getValueAt(i,"SOL_DEVUELTA")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"SOL_DEVUELTA") ).longValue() ):null );

      solicitud.setOidPais( rs.getValueAt(i,"PAIS_OID_PAIS")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS") ).longValue() ):null );      

      solicitud.setOidPeriodo( rs.getValueAt(i,"PERD_OID_PERI")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"PERD_OID_PERI") ).longValue() ):null );
        
      solicitud.setOidMarca( rs.getValueAt(i,"MARC_OID_MARC")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"MARC_OID_MARC") ).longValue() ):null );
      
      solicitud.setOidCanal( rs.getValueAt(i,"CANA_OID_CANA")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"CANA_OID_CANA") ).longValue() ):null );

      solicitud.setOidAcceso( rs.getValueAt(i,"ACCE_OID_ACCE")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"ACCE_OID_ACCE") ).longValue() ):null );

      solicitud.setZona( rs.getValueAt(i,"ZZON_OID_ZONA")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"ZZON_OID_ZONA") ).longValue() ):null );

      solicitud.setOidCliente( rs.getValueAt(i,"CLIE_OID_CLIE")!=null?
        new Long( ( (BigDecimal)rs.getValueAt(i,"CLIE_OID_CLIE") ).longValue() ):null );

      solicitud.setIndOrdenCompra( new Boolean(true) );
      
      arrSolicitudesADevolver.add( solicitud );
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
        UtilidadesLog.debug("arrSolicitudesADevolver["+ i +"]:"+ solicitud );
    }
    
    UtilidadesLog.info("DAOSolicitudes.obtenerSolicitudesADevolverIncentivos(Long oidSolicitudDevolucion, Long oidPeriodo):Salida");
    return arrSolicitudesADevolver;
  }


  public Long obtenerOidRecomenEfectivaConsultora(Long oidClienteRecomendante, Long oidRecomendado)
    throws MareException{
    UtilidadesLog.info("DAOSolicitudes.obtenerOidRecomenEfectivaConsultora(Long oidClienteRecomendante, Long oidRecomendado):Entrada");
    // vbongiov -- 09/01/2007 -- DBLG500001077    
    RecordSet rs;
    Long oidClienteRecomendado = null;
    StringBuffer query = new StringBuffer();

    if( oidClienteRecomendante != null ){ 
      query.append(" SELECT OID_CLIE_REDO  ");
      query.append(" FROM INC_CLIEN_RECDO CRO,  ");
      // vbongiov -- 27/11/2006 -- DBLG500001077    
      query.append(" inc_clien_recte clirecte  ");
      query.append(" WHERE clirecte.OID_CLIE_RETE = cro.clr3_oid_clie_rete ");
      // vbongiov -- 09/01/2007 -- DBLG500001077    
      query.append(" AND clirecte.CLIE_OID_CLIE = "+ oidClienteRecomendante);
      query.append(" AND CRO.CLIE_OID_CLIE = "+ oidRecomendado);
      // vbongiov -- 27/11/2006 -- DBLG500001077    
      //query.append("   AND PERD_OID_PERI = "+ solicitud.getPeriodo().getOidPeriodo().toString() );
      query.append("   AND IND_EFEC = 1  ");
      
      try {
          rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      if( ! rs.esVacio() ){
        oidClienteRecomendado = rs.getValueAt(0,"OID_CLIE_REDO")!=null? 
            new Long( ( (BigDecimal)rs.getValueAt(0,"OID_CLIE_REDO") ).longValue() ):null;
      }
    }

    UtilidadesLog.info("DAOSolicitudes.obtenerOidRecomenEfectivaConsultora(Long oidClienteRecomendante, Long oidRecomendado):Salida");    
    return oidClienteRecomendado;
  }
  
    /**
     * JVM - sicc 20070237, void obtenerClienteRecomendado(Cliente clienteParametro, Long oidPais)
     */
    private void obtenerClienteRecomendado(Cliente clienteParametro, Long oidPais) throws MareException {
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerClienteRecomendado(ClienteclienteParametro, Long oidPais):Entrada");

        BelcorpService bsInc = null;
        RecordSet respuestaInc = null;
        StringBuffer queryInc = new StringBuffer();
        ArrayList   lstRecomendados;

        if ( clienteParametro.getClienteRecomendante() != null){
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("oidClienteRecomendante="+clienteParametro.getClienteRecomendante().getRecomendante());
        }

        try {
            bsInc = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            queryInc.append(" SELECT ");
            queryInc.append("    CLIE_OID_CLIE_VNDO CLIE_OID_CLIE, ");
            queryInc.append("    FEC_DESD           FEC_INIC,      ");
            queryInc.append("    FEC_HAST           FEC_FINA       ");
            queryInc.append(" FROM MAE_CLIEN_VINCU, MAE_TIPO_VINCU ");
            queryInc.append(" WHERE CLIE_OID_CLIE_VNTE = " + clienteParametro.getOidCliente());
            queryInc.append(" AND TIVC_OID_TIPO_VINC = OID_TIPO_VINC ");
            queryInc.append(" AND PAIS_OID_PAIS = " + oidPais);
            queryInc.append(" AND IND_RECO = 1 ");
            queryInc.append(" AND CLIE_OID_CLIE_VNDO NOT IN ( ");
        
            // queryInc.append(" SELECT RDO.CLIE_OID_CLIE, FEC_INIC, FEC_FINA ");
            queryInc.append(" SELECT DISTINCT RDO.CLIE_OID_CLIE ");
            queryInc.append("   FROM INC_CLIEN_RECDO RDO, CRA_PERIO,  ");
            queryInc.append("   INC_CLIEN_RECTE RECT ");
            queryInc.append("  WHERE PERD_OID_PERI = OID_PERI ");
            queryInc.append("    AND RECT.CLIE_OID_CLIE = " + clienteParametro.getOidCliente());
            queryInc.append("    AND CLR3_OID_CLIE_RETE = OID_CLIE_RETE ");
            
            queryInc.append(" ) ");
            
            respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* respuestaInc " + respuestaInc);   

        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //BelcorpService bsMae = null;
        RecordSet respuestaMae = null;
        //StringBuffer queryMae = new StringBuffer();

        try {
            bsInc = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                
        boolean hayRecomendado = false;
        Cliente clienteLocal = new Cliente();
        lstRecomendados = clienteParametro.getClienteRecomendado();

        if (!respuestaInc.esVacio()) {
                    
            hayRecomendado = true;
            
            clienteParametro.setIndRecomendadosEnINC(true);
            
            /* vbongiov -- RI SiCC 20090941 -- 16/06/2009 
             * no lleno lstRecomendados con estos valores solo mantengo el indicador IndRecomendadosEnINC           
              
            lstRecomendados.clear();
            
            for(int i=0; i<respuestaInc.getRowCount();i++){                        
                ClienteRecomendado clienteRecomendado = new ClienteRecomendado();                        

                clienteRecomendado.setRecomendante(clienteParametro.getOidCliente());                   
                
                BigDecimal recomendado = (BigDecimal) respuestaInc.getValueAt(i, "CLIE_OID_CLIE");
                clienteRecomendado.setRecomendado((recomendado != null) ? new Long(recomendado.longValue()) : null);
    
                clienteRecomendado.setFechaInicio((Date) respuestaInc.getValueAt(i, "FEC_INIC"));
                Date fechaFin = (Date) respuestaInc.getValueAt(i, "FEC_FINA");
                clienteRecomendado.setFechaFin((fechaFin != null) ? fechaFin : null);

                clienteLocal.setOidCliente(clienteRecomendado.getRecomendado());
                this.obtenerPeriodosConPedidosCliente(clienteLocal);
                clienteRecomendado.setPeriodosConPedidos(clienteLocal.getPeriodosConPedidos());
                
                lstRecomendados.add(clienteRecomendado);                                                
            }*/
        } 
        
        // vbongiov -- RI SiCC 20090941 -- 16/06/2009 
        //        
        
        try {
            queryInc = new StringBuffer();   
            queryInc.append(" SELECT CLIE_OID_CLIE_VNDO, FEC_DESD, FEC_HAST ");
            queryInc.append(" FROM MAE_CLIEN_VINCU, MAE_TIPO_VINCU ");
            queryInc.append(" WHERE CLIE_OID_CLIE_VNTE = " + clienteParametro.getOidCliente());
            queryInc.append(" AND TIVC_OID_TIPO_VINC = OID_TIPO_VINC ");
            queryInc.append(" AND PAIS_OID_PAIS = " + oidPais);
            queryInc.append(" AND IND_RECO = 1 ");

            respuestaMae = bsInc.dbService.executeStaticQuery(queryInc.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* respuestaMae " + respuestaMae);                                
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!respuestaMae.esVacio()) {
            
            hayRecomendado = true;
            
            clienteParametro.setIndRecomendadosEnMAE(true);
            
            lstRecomendados.clear();
            
            for(int i=0; i<respuestaMae.getRowCount();i++){            
        
                ClienteRecomendado clienteRecomendado = new ClienteRecomendado();        

                clienteRecomendado.setRecomendante(clienteParametro.getOidCliente());

                clienteRecomendado.setRecomendado(new Long(((BigDecimal) 
                    respuestaMae.getValueAt(i, "CLIE_OID_CLIE_VNDO")).longValue()));
                {
                    Date fechaInicio = (Date) respuestaMae.getValueAt(i, "FEC_DESD");
                    clienteRecomendado.setFechaInicio((fechaInicio != null) ? fechaInicio : null);
                }

                {
                    Date fechaFin = (Date) respuestaMae.getValueAt(i, "FEC_HAST");
                    clienteRecomendado.setFechaFin((fechaFin != null) ? fechaFin : null);
                }
                
                clienteLocal.setOidCliente(clienteRecomendado.getRecomendado());
                this.obtenerPeriodosConPedidosCliente(clienteLocal);
                clienteRecomendado.setPeriodosConPedidos(clienteLocal.getPeriodosConPedidos());
            
                lstRecomendados.add(clienteRecomendado);                
                
            }
            
            clienteParametro.setClienteRecomendado(lstRecomendados);
            
        } else {
            hayRecomendado = false;
        }

        if (!hayRecomendado) {
            clienteParametro.setClienteRecomendado(null);
        }
        
        // JVM, sicc 20070381, if, manejo del Recomendador, bloque de recuparacion de periodo
        if (lstRecomendados.size() > 0)
        {   
            try {
                bsInc = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }       
            
            RecordSet respuestaMaeRdr = null;

            try {                     
                queryInc = new StringBuffer();
                queryInc.append(" SELECT DISTINCT CLIE_OID_CLIE_VNTE , FEC_DESD , FEC_HAST ");
                queryInc.append("   FROM MAE_CLIEN_VINCU   ");
                queryInc.append("  WHERE CLIE_OID_CLIE_VNTE = " + clienteParametro.getOidCliente());
                respuestaMaeRdr = bsInc.dbService.executeStaticQuery(queryInc.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("******* respuestaMaeRdr " + respuestaMaeRdr);                
                
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        
            ClienteRecomendante clienteRecomendador = new ClienteRecomendante();
    
            if (!respuestaMaeRdr.esVacio()) {
    
                {
                    BigDecimal recomendador = (BigDecimal) respuestaMaeRdr.getValueAt(0, "CLIE_OID_CLIE_VNTE");
                    clienteRecomendador.setRecomendante((recomendador != null) ? new Long(recomendador.longValue()) : null);
                }
    
                clienteRecomendador.setFechaInicio((Date) respuestaMaeRdr.getValueAt(0, "FEC_DESD"));
                // fecha fin de INC
                {
                    Date fechaFin = (Date) respuestaMaeRdr.getValueAt(0, "FEC_HAST");
                    clienteRecomendador.setFechaFin((fechaFin != null)? fechaFin : null);
                }
                
                clienteParametro.setClienteRecomendador(clienteRecomendador);
            }
            
            for (int i=0; i<lstRecomendados.size(); i++){

                ClienteRecomendado clienteRecomendados = new ClienteRecomendado();            
                
                clienteRecomendados = (ClienteRecomendado) lstRecomendados.get(i);
                                            
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                
                try {
                    bsInc = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }                 

                queryInc = new StringBuffer();
                
                try {
                    queryInc.append(" select   x.n, x.oid_peri, x.fec_inic, x.fec_fina, x.pais_oid_pais, x.marc_oid_marc, x.cana_oid_cana ");    
                    queryInc.append("     from (  ");    
                    queryInc.append("             select 1 n, b.oid_peri      as oid_peri, ");    
                    queryInc.append("                         b.fec_inic      as fec_inic, ");    
                    queryInc.append("                         b.fec_fina      as fec_fina, ");    
                    queryInc.append("                         b.pais_oid_pais as pais_oid_pais, ");    
                    queryInc.append("                         b.marc_oid_marc as marc_oid_marc, ");    
                    queryInc.append("                         b.cana_oid_cana as cana_oid_cana ");    
                    queryInc.append("               from mae_clien_prime_conta a, cra_perio b, seg_perio_corpo c ");    
                    queryInc.append("              where a.clie_oid_clie = " + clienteRecomendados.getRecomendado());       
                    queryInc.append("                and a.perd_oid_peri = b.oid_peri ");    
                    queryInc.append("                and b.peri_oid_peri = c.oid_peri ");    
                    queryInc.append("                and b.oid_peri in ( ");    
                    queryInc.append("                       select oid_peri  ");    
                    queryInc.append("                         from cra_perio ");    
                    queryInc.append("                        where fec_inic <= to_date ('"+ df.format(clienteRecomendados.getFechaInicio()) +"', 'DD-MM-YYYY') ");
                    queryInc.append("                          and to_date ('"+ df.format(clienteRecomendados.getFechaInicio()) +"', 'DD/MM/YYYY') <= fec_fina ) ");
                    queryInc.append("           union ");    
                    queryInc.append("                 select rownum + 1 as n, oid_peri      as oid_peri, ");    
                    queryInc.append("                                         fec_inic      as fec_inic, ");    
                    queryInc.append("                                         fec_fina      as fec_fina, ");    
                    queryInc.append("                                         pais_oid_pais as pais_oid_pais, ");    
                    queryInc.append("                                         marc_oid_marc as marc_oid_marc, ");    
                    queryInc.append("                                         cana_oid_cana as cana_oid_cana ");    
                    queryInc.append("                   from cra_perio ");    
                    queryInc.append("                  where fec_inic <= to_date ('"+ df.format(clienteRecomendados.getFechaInicio()) +"', 'DD-MM-YYYY') ");
                    queryInc.append("                    and to_date('"+ df.format(clienteRecomendados.getFechaInicio()) +"', 'DD-MM-YYYY') <= fec_fina ");
                    queryInc.append("               order by oid_peri asc ");    
                    queryInc.append("           ) x                                                                                       ");    
                    queryInc.append(" order by n ");    

                    respuestaInc = bsInc.dbService.executeStaticQuery(queryInc.toString());
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("******* respuestaInc " + respuestaInc);   

                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                BigDecimal bd;
                
                if (!respuestaInc.esVacio()) {

                    Periodo periodo = new Periodo();
                    
                    bd = (BigDecimal) respuestaInc.getValueAt(0, "OID_PERI");
                    periodo.setOidPeriodo(new Long(bd.longValue()));
                    
                    periodo.setFechaDesde((Date) respuestaInc.getValueAt(0, "FEC_INIC"));

                    periodo.setFechaHasta((Date) respuestaInc.getValueAt(0, "FEC_FINA"));                    
                    
                    bd = (BigDecimal) respuestaInc.getValueAt(0, "PAIS_OID_PAIS");
                    periodo.setOidPais(new Long(bd.longValue()));
                    
                    bd = (BigDecimal) respuestaInc.getValueAt(0, "MARC_OID_MARC");
                    periodo.setOidMarca(new Long(bd.longValue()));

                    bd = (BigDecimal) respuestaInc.getValueAt(0, "CANA_OID_CANA");
                    periodo.setOidCanal(new Long(bd.longValue()));
                    
                    clienteRecomendados.setPeriodo(periodo);
                }                                       
            }
        }

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
          UtilidadesLog.debug("lstRecomendados("+lstRecomendados.size() + 
                            ") getIndRecomendadosEnMAE("+clienteParametro.getIndRecomendadosEnMAE() +
                            ") getIndRecomendadosEnINC("+clienteParametro.getIndRecomendadosEnINC() +")");        
        
        UtilidadesLog.info(" DAOSolicitudes.obtenerClienteRecomendado(ClienteclienteParametro, Long oidPais):Salida");        
        
    }

    /**
     * 07-06-2011       Agregado por Sapaza, cambio RCR PER-SiCC-2011-0279 No quitar puntos 
     *                  en una devolución normal de un reemplazo
     * @throws es.indra.mare.common.exception.MareException
     */
    public String obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOSolicitudes.obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pp.val_para      ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + oidPais.toString());
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = '" + codigoModulo + "'");
        consulta.append("    AND pp.cod_para = '" + codigoParametro + "'");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOSolicitudes.obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Salida");

        return null;
    }


    //sapaza -- COL-SiCC-2014-0201 -- 24/06/2014
    public String obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro, String valorDefecto) throws MareException {
        UtilidadesLog.info("DAOSolicitudes.obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro, String valorDefecto): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT NVL(GEN_PKG_GENER.GEN_FN_PARAM_PAIS(sp.COD_PAIS,'"+codigoModulo+"','"+codigoParametro+"'),'" + valorDefecto + "')");
        consulta.append("   FROM seg_pais sp  ");
        consulta.append("  WHERE sp.oid_pais =  " + oidPais.toString());
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (!rs.esVacio()) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOSolicitudes.obtenerIndicadorParametroPais(Long oidPais, String codigoModulo, String codigoParametro, String valorDefecto): Salida");

        return null;
    }
  
}
