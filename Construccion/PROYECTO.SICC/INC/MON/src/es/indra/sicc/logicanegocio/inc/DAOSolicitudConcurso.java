/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * @autor: Cristian Valenzuela
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import es.indra.sicc.util.DTOOIDs;
 
 
public class DAOSolicitudConcurso {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOSolicitudConcurso() {
    }

    /** Metodo: obtenerSolicitudConcurso
      * Autor: Cristian Valenzuela
      * Fecha: 23/2/2005
      */
    public void obtenerSolicitudConcurso(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerSolicitudConcurso(Solicitud solicitud):Entrada");
        /*1- Invocar al metodo obtenerProductosExigidosSolicConcurso pasandole
          por parametro del objeto solicitud. Este metodo invoca a
          sol.getSolicitudConcurso y agrega productos exigidos al concurso que
          corresponda.
          2- Invocar a obtenerNumeroPeriodosEvaluadosSolicConcurso pasandole
          por parametro el objeto solicitud. Este metodo invoca a sol.
          getSolicitudConcurso
          y asigna numero de pedidos evaluados por concurso.
          3- Invocar a obtenerPosicionesPuntajeSolicConcurso pasandole
          por parametro el objeto solicitud.
          4- Invocar a obtenerDescalificacionesCliente pasandole por parametro
          el objeto solicitud.
          5- Invocar a obtenerTipoVinculo pasandole por parametro el objeto 
          solicitud.
          6- Invocar a obtenerFinEvaluacion pasandole por parametro el objeto 
          solicitud.
          7- Invocar a obtenerNumeroPeriodosEvaluados pasandole por parametro 
          el objeto solicitud.
          8- Invocar a obtenerMontoAcumulado pasandole por parametro el objeto 
          solicitud.
          9- Invocar a obtenerUnidadesAcumuladas pasandole por parametro el 
          objeto solicitud.
          10- Invocar a obtenerPuntosAcumulados pasandole por parametro el 
          objeto solicitud.
          11- Invocar a obtenerIndPeriodoCalculado pasandole por parametro el 
          objeto solicitud. */
        this.obtenerProductosExigidosSolicConcurso(solicitud);
        //this.obtenerNumeroPeriodosEvaluadosSolicConcurso(solicitud);
        //3 La llamada al metodo obtenerPosicionesPuntajeSolicConcurso se ha 
        //eliminado del diseño, Incidencia BELC300013771        
        this.obtenerDescalificacionesCliente(solicitud);
        this.obtenerTipoVinculo(solicitud);
        this.obtenerFinEvaluacion(solicitud);
        this.obtenerNumeroPeriodosEvaluados(solicitud);
        this.obtenerMontoAcumulado(solicitud);
        this.obtenerUnidadesAcumuladas(solicitud);
        this.obtenerPuntosAcumulados(solicitud);
        this.obtenerIndPeriodoCalculado(solicitud);
        //jrivas 18/7/2005
        this.obtenerMetasClienteConcurso(solicitud);
        this.obtenerPeriodosVinculo(solicitud);
        //INC-132 jrivas 28/6/2006
        this.obtenerPuntosAcumuladosCC(solicitud);
        //Julian Rivas 17/7/2006
        //DBLG500000721 / DBLG500000932 / DBLG500001009
        this.obtenerCumplimientoExigencias(solicitud);
        
        //jrivas 30/08/2006 DBLG5000839
        this.obtenerSolicitudesGerentesProcesadas(solicitud);
        
        // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
        this.obtenerPremioEntregados(solicitud);
        
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerSolicitudConcurso(So"
            +"licitud solicitud):Salida");
    }

    /** Metodo: obtenerProductosExigidosSolicConcurso
      * Autor: Cristian Valenzuela
      * Fecha: 23/2/2005
      */
    private void obtenerProductosExigidosSolicConcurso(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerProductosExigidosSo"
            +"licConcurso(Solicitud solicitud):Entrada");
        /*Hacemos una consulta contra la tabla INC:CalculoProductosExigidos
          filtrando por el solicitud.periodo y solicitud.cliente.oidCliente
          haciendo un join contra INC:ProductosExigidos y INC:Productos ,
          ordenados por oidConcurso. (Solo se cargan los datos asociados a
          concursos del pais, activos de INC:ConcursoParametrosGenerales)

          Se obtienen: oidConcurso -> INC:Productos
          oidProductoExigido -> INC:CalculoProductosExigidos.productoExigido
          monto -> INC:CalculoProductosExigidos.montoPedido
          unidades -> INC:CalculoProductosExigidos.unidadesPedido
          puntos -> INC:CalculoProductosExigidos.puntosPedido

          Para cada uno de los registros encontrados hacemos
          sol.getConcursoSolicitud(oidConcurso del registro).addProductoExigido
          (oidProductoExigido,
          monto, unidades, puntaje). */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT iprodu.COPA_OID_PARA_GRAL ,  ");
        query.append(" icpe.PRE2_OID_PROD_EXIG, ");
        query.append(" icpe.IMP_MONT_PEDI, icpe.NUM_UNID_PEDI,  ");
        query.append(" icpe.NUM_PUNT_PEDI ");
        query.append(" FROM INC_CALCU_PRODU_EXIGI icpe,  ");
        query.append(" INC_PRODU_EXIGI ipe , ");
        query.append(" INC_PRODU iprodu, INC_CONCU_PARAM_GENER icpg ");
        query.append(" WHERE icpe.PERD_OID_PERI = " + solicitud.getPeriodo()
            .getOidPeriodo());
        query.append(" AND icpe.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND icpe.PRE2_OID_PROD_EXIG = ipe.OID_PROD_EXIG ");
        query.append(" AND ipe.PRDU_OID_PROD = iprodu.OID_PROD ");
        query.append(" AND iprodu.COPA_OID_PARA_GRAL = icpg.OID_PARA_GRAL ");
        query.append(" AND icpg.IND_ACTI = 1 ");
        query.append(" ORDER BY iprodu.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug(" rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerProductosExigidos"
                +"SolicConcurso(Solicitud solicitud):Salida");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdOidProdExi = (BigDecimal) rs
                .getValueAt(i, "PRE2_OID_PROD_EXIG");
            BigDecimal bdMonto = (BigDecimal) rs
                .getValueAt(i, "IMP_MONT_PEDI");
            BigDecimal bdUnidades = (BigDecimal) rs
                .getValueAt(i, "NUM_UNID_PEDI");
            BigDecimal bdPuntos = (BigDecimal) rs
                .getValueAt(i, "NUM_PUNT_PEDI");

            //CAMBIO ANUL_DEVO - gPineda - 30/10/2006
            //jrivas 17/8/2006 DBLG50000721
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .addProductoExigido(new Long(bdOidProdExi.longValue()), 
                    bdMonto, new Long(bdUnidades.longValue()),  new Double(
                        bdPuntos.doubleValue()), true, false);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerProductosExigidosSo"
            +"licConcurso(Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerNumeroPeriodosEvaluadosSolicConcurso
      * Autor: Cristian Valenzuela
      * Fecha: 24/2/2005
      * Modificado: Cristian Valenzuela
      * Incidencia: BELC300019771
      * Fecha modificacion: 14/7/2005
      */
    private void obtenerNumeroPeriodosEvaluadosSolicConcurso(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerNumeroPeriodosEvalua"
            +"dosSolicConcurso(Solicitud solicitud):Salida");
        /*Descripcion: este metodo debe recuperar la cantidad de periodos
          evaluados por SolicitudConcurso y actualizarlos en el elemento
          SolicitudConcurso correspondiente.
          Implementacion:
          1- Recuperar de la entidad INC:SolicitudConcursoPuntaje la
          cantidad de periodos por concurso y el oidConcurso filtrando el
          campo consultora igual al oidCliente del cliente de la solicitud
          y el periodo distinto del periodo de la solicitud agrupando por 
          concurso.
          Para cada registro obtenido en el punto 1
          A- Llamar al metodo solicitud.getSolicitudConcurso() pasandole
          por parametro el registro.oidConcurso. Este metodo retornara un
          objeto de la clase SolicitudConcurso.

          B- Asignar el valor de registro.cantidadPeriodos del elemento
          de la consulta que se este tratando, a la propiedad
          numeroPeriodosEvaluados del objeto solicitudConcurso obtenido
          en el punto 2 - A
          FPara */
        UtilidadesLog.debug("*** DAOSolicitudConcurso.obtenerNumeroPeriodosEva"
          +"luadosSolicConcurso()");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT iscp.COPA_OID_PARA_GRAL, ");
        query.append(" COUNT(iscp.PERD_OID_PERI) AS CANT ");
        query.append(" FROM INC_SOLIC_CONCU_PUNTA iscp, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente()
          .getOidCliente());
        query.append(" AND iscp.PERD_OID_PERI != " + solicitud.getPeriodo()
          .getOidPeriodo());
        query.append(" AND iscp.CLIE_OID_CLIE_GERE IS NULL ");
        query.append(" AND iscp.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
        query.append(" GROUP BY iscp.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
              query.toString());
            UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
              .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdCant = (BigDecimal) rs.getValueAt(i, "CANT");

            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
              .setNumeroPeriodosEvaluados(bdCant.intValue());
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerNumeroPeriodosEvalua"
          +"dosSolicConcurso(Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerDescalificacionesCliente
      * Autor: Cristian Valenzuela
      * Fecha: 24/2/2005
      */
    private void obtenerDescalificacionesCliente(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerDescalificaciones"
          +"Cliente(Solicitud solicitud):Entrada");
        /*Descripcion: este metodo obtiene las descalificaciones del
          cliente de la solicitud por concurso.

          Implementacion:
          Recuperar los registros de la entidad INC:Descalificaciones
          filtrando por solicitud.cliente.oidCliente y solicitud.periodo.
          oidPeriodo
          Para cada elemento recuperado
          1- Obtener solicitudConcurso = solicitud.getSolicitudConcurso(
          registro.oidConcurso)
          2- Asignar solicitudConcurso.clienteDescalificado = TRUE
          FPara */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT id.OID_DESC, id.FEC_DESC, id.CLIE_OID_CLIE, ");
        query.append(" id.COPA_OID_PARA_GRAL, id.PERD_OID_PERI,  ");
        query.append(" id.CADE_OID_CAUS_DESC ");
        query.append(" FROM INC_DESCA id, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE id.CLIE_OID_CLIE = " + solicitud.getCliente()
          .getOidCliente());
        /*query.append(" AND id.PERD_OID_PERI = " + solicitud.getPeriodo()
          .getOidPeriodo());*/
        query.append(" AND id.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
          
        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
              query.toString());
              
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                  
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerDescalificaciones"
                +"Cliente(Solicitud solicitud):Salida");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
              .getValueAt(i, "COPA_OID_PARA_GRAL");

            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
              .setClienteDescalificado(true);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerDescalificaciones"
            +"Cliente(Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerTipoVinculo
      * Autor: Cristian Valenzuela
      * Fecha: 25/2/2005
      */
    private void obtenerTipoVinculo(Solicitud solicitud) throws MareException{
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerTipoVinculo(Solicitud"
            +"solicitud):Entrada");
        /*Descripcion: este metodo obtiene por concurso.

          Implementacion:
          Recuperar el campo oidConcurso de la entidad INC:ClienteRecomendante
          filtrando por INC:ClienteRecomendante.recomendado = solicitud.cliente
          .oidCliente,
          agregar cada oidConcurso a un ArrayList y llamarlo 
          concursosClienteRecomendante.
          Recuperar el campo oidConcurso de la entidad INC:ClienteRecomendante
          haciendo un join con INC:ClienteRecomendado por oidClienteRecomen
          dante
          y filtrando INC:ClienteRecomendado por
          INC:ClienteRecomendado.recomendado = solicitud.cliente.oidCliente,
          agregar cada oidConcurso a un ArrayList y llamarlo concursoCliente
          Recomendado.
          Para cada elemento de concursoClienteRecomendante
          Buscar el oidConcurso en concursoClienteRecomendado
          Si existe entonces
          solicitud.getSolicitudConcurso(oidConcurso).tipoVinculo = 
          ConstantesINC.TIPO_VINC_AMBOS
          Remover el elemento de concursoClienteRecomendado.
          Si no existe entonces
          solicitud.getSolicitudConcurso(oidConcurso).tipoVinculo = 
          ConstantesINC.TIPO_VINC_RECOMENDANTE
          FPara
          Para cada elemento restante en concursoClienteRecomendado
          solicitud.getSolicitudConcurso(oidConcurso).tipoVinculo = 
          ConstantesINC.TIPO_VINC_RECOMENDADO
          FPara  */

        //Comienzo de primer consulta
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT icr.COPA_OID_PARA_GRAL ");
        query.append(" FROM INC_CLIEN_RECTE icr, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE icr.CLIE_OID_CLIE = " + solicitud.getCliente()
          .getOidCliente());
        query.append(" AND icr.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
          

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
              query.toString());
             
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                  
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        ArrayList concursosClienteRecomendante = new ArrayList();
        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
              .getValueAt(i, "COPA_OID_PARA_GRAL");
            concursosClienteRecomendante.add(i, bdOidCon);
        }
        //Fin de primer consulta
        //*****************************
        //Comienzo de segunda consulta
        StringBuffer query2 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        BelcorpService belcorpService2 = null;

        query2.append(" SELECT icrte.COPA_OID_PARA_GRAL ");
        query2.append(" FROM INC_CLIEN_RECTE icrte, INC_CLIEN_RECDO icrdo, INC_CONCU_PARAM_GENER concu ");
        query2.append(" WHERE icrdo.CLR3_OID_CLIE_RETE = icrte.OID_CLIE_RETE ");
        query2.append(" AND icrdo.CLIE_OID_CLIE = " + solicitud.getCliente()
          .getOidCliente());
        query2.append(" AND icrte.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query2.append(" AND concu.IND_ACTI = 1 ");
          

        try {
            rs2 = belcorpService2.getInstance().dbService.executeStaticQuery( 
                query2.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("******* rs2 " + rs2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        ArrayList concursoClienteRecomendado = new ArrayList();

        for (int i = 0; i < rs2.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs2.getValueAt(i, "COPA_OID_PARA_GRAL");
            concursoClienteRecomendado.add(i, bdOidCon);
        }
        //Fin de segunda consulta
        //***********************
        for (int i = 0; i < concursosClienteRecomendante.size(); i++) {
            BigDecimal bdOidCon1 = (BigDecimal) concursosClienteRecomendante.get(i);
            
            boolean resultado = this.coincideRecomendanteConRecomendado(
                bdOidCon1, concursoClienteRecomendado);
            if (resultado) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("AMBOS: " + bdOidCon1 + " Solici: " + solicitud.getCliente().getOidCliente());
                solicitud.getSolicitudConcurso(new Long(bdOidCon1.longValue()))
                    .setTipoVinculo(ConstantesINC.TIPO_VINC_AMBOS);
            } else {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("RECOMTE: " + bdOidCon1 + " Solici: " + solicitud.getCliente().getOidCliente());
                solicitud.getSolicitudConcurso(new Long(bdOidCon1.longValue()))
                    .setTipoVinculo(ConstantesINC.TIPO_VINC_RECOMENDANTE);
            }
        }
        for (int i = 0; i < concursoClienteRecomendado.size(); i++) {
            BigDecimal bdOidCon = (BigDecimal) concursoClienteRecomendado.get(i);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("RECONDADO: " + bdOidCon + " Solici: " + solicitud.getCliente().getOidCliente());
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setTipoVinculo(ConstantesINC.TIPO_VINC_RECOMENDADO);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerTipoVinculo(Solicitud"
            +"solicitud):Salida");
    }

    private boolean coincideRecomendanteConRecomendado(BigDecimal oidConcurso,
        ArrayList concursoClienteRecomendado) {
        UtilidadesLog.info(" DAOSolicitudConcurso.coincideRecomendanteConReco"
            +"mendado(BigDecimal oidConcurso, ArrayList concursoClienteReco"
            +"mendado):Entrada");
        boolean coincide = false;

        for (int j = 0; (coincide == false) && (j < concursoClienteRecomendado
          .size()); j++) {
            BigDecimal bdOidCon = (BigDecimal) concursoClienteRecomendado
              .get(j);

            if (oidConcurso.longValue() == bdOidCon.longValue()) {
                coincide = true;
                concursoClienteRecomendado.remove(j);
            }
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.coincideRecomendanteConReco"
            +"mendado(BigDecimal oidConcurso, ArrayList concursoClienteRecomen"
            +"dado):Salida");
        return coincide;
    }

    /** Metodo: obtenerFinEvaluacion
      * Autor: Cristian Valenzuela
      * Fecha: 25/2/2005
      */
    private void obtenerFinEvaluacion(Solicitud solicitud) 
        throws MareException{
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerFinEvaluacion(Solici"
            +"tud solicitud):Entrada");
        //Especificacion modificada por Diego Juiz el 25/2/2005

        /*Descripción: este método obtiene el indicador de fin de evaluación 
         * por concurso.
          Implementación:
          Recuperar los campos oidConcurso y finVinculo de la entidad
          INC:ClienteRecomendante filtrando por INC:ClienteRecomendante.
          recomendante =
          solicitud.cliente.oidCliente.  Incorporar cada registro en una
          colección donde la clave será el campo oidConcurso y el valor
          del elemento será el valor del campo finVinculo
          Para cada elemento recuperado
          1- Obtener solicitudConcurso = solicitud.getSolicitudConcurso(
          oidConcurso)
          2- Asignar solicitudConcurso.finEvaluacion = valor del elemento 
          recuperadodel campo finVinculo
          FPara
          Comentarios: el atributo a asignar es finEvaluacion con el dato
          recuperado del campo finVinculo */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT icr.COPA_OID_PARA_GRAL, icr.IND_FIN_VINC ");
        query.append(" FROM INC_CLIEN_RECTE icr, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE icr.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND icr.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
            

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerFinEvaluacion("
                +"Solicitud solicitud):Salida");
            return;
        }
        boolean finEvaluacion;
        
        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) 
                rs.getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdIndFin = (BigDecimal) 
                rs.getValueAt(i, "IND_FIN_VINC");
                
            if (bdIndFin != null) {
                if (bdIndFin.intValue() == 0) {
                    solicitud.getSolicitudConcurso(new Long(bdOidCon
                        .longValue())).setFinEvaluacion(false);
                } else {
                    if (bdIndFin.intValue() == 1) {
                        solicitud.getSolicitudConcurso(new Long(bdOidCon
                            .longValue())).setFinEvaluacion(true);
                    }
                }
            }
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerFinEvaluacion(Soli"
            +"citud solicitud):Salida");
    }

    /** Metodo: obtenerNumeroPeriodosEvaluados
      * Autor: Cristian Valenzuela
      * Fecha: 28/2/2005
      * Modificado: Cristian Valenzuela
      * Incidencia: BELC300019771
      * Fecha: 14/7/2005
      */
    private void obtenerNumeroPeriodosEvaluados(Solicitud solicitud)
            throws MareException {
         UtilidadesLog.info(" DAOSolicitudConcurso.obtenerNumeroPeriodosEvalua"
            +"dos(Solicitud solicitud):Entrada");
        /*Descripcion: este metodo obtiene la cantidad de periodos evaluados
          para el cliente de la solicitud para cada concurso

          Implementacion:

          Obtener la cantidad de registros y el oidConcurso correspondiente
          de la entidad INC:SolicitudConcursoPuntaje filtrando por el oidCliente
          igual al oid del cliente de la solicitud recibida por parametro y
          el periodo distinto al de la solicitud del parametro agrupando por 
          oidConcurso.
          Agregar cada registro obtenido en una coleccion donde la clave sera
          el oidConcurso y el valor sera la cantidad de registros.

          Para cada elemento de la coleccion
          solicitud.getSolicitudConcurso(oidConcurso).numeroPeriodosEvaluados =
          valor del elemento de la coleccion.
          FPara. */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT iscp.COPA_OID_PARA_GRAL, COUNT(*) AS CANT ");
        query.append(" FROM INC_SOLIC_CONCU_PUNTA iscp, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());

        //jrivas DBLG50000355 19/4/2006
        /*query.append(" AND iscp.PERD_OID_PERI != " + solicitud.getPeriodo()
            .getOidPeriodo());*/
        query.append(" AND iscp.SOCA_OID_SOLI_CABE != " + solicitud.getOidSolicitud());
            
        query.append(" AND iscp.CLIE_OID_CLIE_GERE IS NULL ");
        query.append(" AND iscp.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
        
        // DBLG500001017 - gPineda - 13/10/06
        query.append(" AND iscp.IND_ANUL = 0 ");
        
        query.append(" GROUP BY iscp.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdCant = (BigDecimal) rs.getValueAt(i, "CANT");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setNumeroPeriodosEvaluados(bdCant.intValue());
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerNumeroPeriodosEva"
            +"luados(Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerMontoAcumulado
      * Autor: Cristian Valenzuela
      * Fecha: 28/2/2005
      * Modificado: Cristian Valenzuela
      * Incidencia: BELC300019771
      * Fecha: 14/7/2005
      */
    private void obtenerMontoAcumulado(Solicitud solicitud)
        throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerMontoAcumulado(Soli"
            +"citud solicitud):Entrada");
        /*Descripcion: obtiene el monto acumulado por concurso para el
          cliente y el periodo de la solicitud recibida por parametro.
          Implementacion:
          Obtener la suma del campo monto y el oidConcurso correspondiente
          de la entidad INC:SolicitudConcursoPuntaje filtrando por
          oidCliente = solicitud.cliente.oidCliente y oidPeriodo = solicitud.
          periodo.oidPeriodo
          agrupando por oidConcurso.
          Para cada elemento recuperado
          solicitud.getSolicitudConcurso(oidConcurso).montoAcumulado = suma del 
          monto FPara.*/

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT iscp.COPA_OID_PARA_GRAL, SUM(iscp.IMP_MONT) AS SUMA ");
        query.append(" FROM INC_SOLIC_CONCU_PUNTA iscp, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND iscp.PERD_OID_PERI = " + solicitud.getPeriodo()
            .getOidPeriodo());
        query.append(" AND iscp.CLIE_OID_CLIE_GERE IS NULL ");
        query.append(" AND iscp.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
        query.append(" GROUP BY iscp.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerMontoAcumulado(So"
                +"licitud solicitud):Salida");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdSuma = (BigDecimal) rs.getValueAt(i, "SUMA");

            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setMontoAcumulado(bdSuma);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerMontoAcumulado(So"
            +"licitud solicitud):Salida");
    }

    /** Metodo: obtenerUnidadesAcumuladas
      * Autor: Cristian Valenzuela
      * Fecha: 28/2/2005
      * Modificado: Cristian Valenzuela
      * Incidencia: BELC300019771
      * Fecha: 14/7/2005
      */
    private void obtenerUnidadesAcumuladas(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerUnidadesAcumuladas(So"
            +"licitud solicitud):Salida");
        /*Descripcion: obtiene las unidades acumuladas por concurso
          para el cliente y el periodo de la solicitud recibida por parametro.
          Implementacion:
          Obtener la suma del campo unidades y el oidConcurso correspondiente
          de la entidad INC:SolicitudConcursoPuntaje filtrando por
          oidCliente = solicitud.cliente.oidCliente y oidPeriodo = solicitud.
          periodo.oidPeriodo agrupando por oidConcurso.
          Para cada elemento recuperado solicitud.getSolicitudConcurso
          (oidConcurso).unidadesAcumuladas = suma
          de las unidades
          FPara.*/

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT iscp.COPA_OID_PARA_GRAL,  ");
        query.append(" SUM(NVL(iscp.NUM_UNID,0)) AS SUMA ");
        query.append(" FROM INC_SOLIC_CONCU_PUNTA iscp, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND iscp.PERD_OID_PERI = " + solicitud.getPeriodo()
            .getOidPeriodo());
        query.append(" AND iscp.CLIE_OID_CLIE_GERE IS NULL ");
        query.append(" AND iscp.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
        query.append(" GROUP BY iscp.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
             UtilidadesLog.info(" DAOSolicitudConcurso.obtenerUnidadesAcumu"
                 +"ladas(Solicitud solicitud):Salida");
             return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdSuma = (BigDecimal) rs.getValueAt(i, "SUMA");

            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setUnidadesAcumuladas(new Long(bdSuma.longValue()));
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerUnidadesAcumuladas("
            +"Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerPuntosAcumulados
      * Autor: Cristian Valenzuela
      * Fecha: 28/2/2005
      * Modificado: Cristian Valenzuela
      * Incidencia: BELC300019771
      * Fecha: 14/7/2005
      */
    private void obtenerPuntosAcumulados(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumulados(So"
            +"licitud solicitud):Entrada");
        /*Descripcion: obtiene los puntos acumulados por concurso para
          el cliente y el periodo de la solicitud recibida por parametro.

          Implementacion:

          Se debe recuperar el oidConcurso y totalizar el campo puntos
          de la entidad INC:SolicitudConcursoPuntaje restando los registros
          que contengan el campo anulado == true y sumando el resto de los
          registros, agrupando por oidConcurso.

          Para cada elemento recuperado
          solicitud.getSolicitudConcurso(oidConcurso).puntosAcumulados = total
          de puntos para el oidConcurso que se este tratando.
          FPara. */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        /*query.append(" SELECT iscp.copa_oid_para_gral, ");
        query.append(" (SELECT NVL (SUM (iscp.num_punt), 0) ");
        query.append(" FROM inc_solic_concu_punta iscp ");
        query.append(" WHERE iscp.ind_anul != 1 OR iscp.IND_ANUL IS NULL) - ");
        query.append(" (SELECT NVL (SUM (iscp.num_punt), 0) ");
        query.append(" FROM inc_solic_concu_punta iscp ");
        query.append(" WHERE iscp.ind_anul = 1) ");
        query.append(" AS total ");
        query.append(" FROM inc_solic_concu_punta iscp, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND iscp.PERD_OID_PERI = " + solicitud.getPeriodo()
            .getOidPeriodo());
        query.append(" AND iscp.CLIE_OID_CLIE_GERE IS NULL ");
        query.append(" AND iscp.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
        query.append(" GROUP BY iscp.copa_oid_para_gral ");*/
        
        query.append(" SELECT NVL(A.copa_oid_para_gral,B.copa_oid_para_gral) COPA_OID_PARA_GRAL, NVL(A.Suma,0) - NVL(B.Resta,0) total ");
        query.append(" from  ");
        query.append(" (SELECT   iscp.copa_oid_para_gral, ");
        query.append("           NVL (SUM (iscp.num_punt), 0) Suma ");
        query.append("     FROM inc_solic_concu_punta iscp, inc_concu_param_gener concu ");
        query.append("    WHERE iscp.clie_oid_clie = " + solicitud.getCliente()
                    .getOidCliente());
        query.append("      AND iscp.perd_oid_peri = " + solicitud.getPeriodo()
                    .getOidPeriodo());
        query.append("      AND iscp.clie_oid_clie_gere IS NULL ");
        query.append("      AND iscp.copa_oid_para_gral = concu.oid_para_gral ");
        query.append("      AND concu.ind_acti = 1 ");
        query.append("      AND (iscp.ind_anul != 1 OR iscp.ind_anul IS NULL) ");
        query.append(" GROUP BY iscp.copa_oid_para_gral) A ");
        query.append(" FULL OUTER JOIN  ");
        query.append(" (SELECT   iscp.copa_oid_para_gral, ");
        query.append("           NVL (SUM (iscp.num_punt), 0) Resta ");
        query.append("     FROM inc_solic_concu_punta iscp, inc_concu_param_gener concu ");
        query.append("    WHERE iscp.clie_oid_clie = " + solicitud.getCliente()
                    .getOidCliente());
        query.append("      AND iscp.perd_oid_peri = " + solicitud.getPeriodo()
                    .getOidPeriodo());
        query.append("      AND iscp.clie_oid_clie_gere IS NULL ");
        query.append("      AND iscp.copa_oid_para_gral = concu.oid_para_gral ");
        query.append("      AND concu.ind_acti = 1 ");
        query.append("      AND iscp.ind_anul = 1	  ");
        query.append(" GROUP BY iscp.copa_oid_para_gral) B ");
        query.append(" on A.copa_oid_para_gral = B.copa_oid_para_gral ");        

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumulados(S"
                +"olicitud solicitud):Salida");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdTotal = (BigDecimal) rs.getValueAt(i, "TOTAL");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setPuntosAcumulados(new Double(bdTotal.doubleValue()));
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumulados(So"
            +"licitud solicitud):Salida");
    }

    /** Metodo: obtenerIndPeriodoCalculado
      * Autor: Cristian Valenzuela
      * Fecha: 1/3/2005
      */
    private void obtenerIndPeriodoCalculado(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerIndPeriodoCalculado("
            +"Solicitud solicitud):Entrada");
        /*Descripcion: indica si el periodo ya ha sido calculado
         * por concurso para el cliente y periodo de la solicitud.

          Implementacion:
          Obtener una sola vez (Select Distinct) cada oidConcurso de
          la entidad INC:CandidataGanadora filtrando por
          oidCliente = solicitud.cliente.oidCliente y oidPeriodo = solicitud.          
          periodo.oidPeriodo.
          Para cada elemento recuperado
          solicitud.getSolicitudConcurso(oidConcurso).indPeriodoCalculado = 
          true  FPara.*/

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT DISTINCT icg.COPA_OID_PARA_GRAL ");
        query.append(" FROM INC_CANDI_GANAD icg, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE icg.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND icg.PERD_OID_PERI = " + solicitud.getPeriodo()
            .getOidPeriodo());
        query.append(" AND icg.COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
            

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerIndPeriodoCalcu"
                +"lado(Solicitud solicitud):Salida");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setIndPeriodoCalculado(true);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerIndPeriodoCalculado("
            +"Solicitud solicitud):Salida");
    }

    /** Metodo: obtenerPeriodosVinculo
      * Autor: Cristian Valenzuela
      * Fecha: 2/3/2005
      */
    private void obtenerPeriodosVinculo(Solicitud solicitud)
        throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPeriodosVinculo(Soli"
            +"citud solicitud):Entrada");
        /*Descripcion: obtiene los atributos periodoInicioVinculo y
          periodoFinVinculo de un cliente para todos sus concursos.
          Implementacion:
          Efectuar una consulta que contemple lo siguiente:
          - Filtrar INC:ClienteRecomendado por el campo
          recomendado = solicitud.cliente.oidCliente
          - Hacer un join entre INC:ClienteRecomendado e INC:ClienteRecomen
          dante por recomendante.          
          - Hacer un join de la entidad INC:ClienteRecomendado con la entidad
          CRA:Periodo (PeriodoInicio) y SEG:PeriodoCorporativo (PeriodoCorpInicio)
          por el campo periodoInicioVinculo.
          - Hacer un join con la entidad INC:ConcursoParametrosConsultoras por
          el oidConcurso
          - Con INC:ClienteRecomendado.periodoInicioVinculo ir a la tabla de
          CRA:Periodo (PeriodoFin) y SEG:PeriodoCorporativo (PeriodoCorpFin)
          para obtener los INC:ConcursoParametrosConsultoras.periodosAEvaluar -1
          posteriores a periodoInicioVinculo y obtener el periodo con la
          fechaFin mayor.
          Obteniendo los siguientes campos:
          oidConcurso: INC:ClienteRecomendante.oidConcurso
          oidPeriodoInicio: PeriodoInicio.oidPeriodo
          fechaDesdeInicio: PeriodoInicio.fechaIni
          fechaHastaInicio: PeriodoInicio.fechaFin
          codPeriodoInicio: PeriodoCorpInicio.codigoPeriodoCorporativo
          oidPaisInicio: PeriodoInicio.pais
          oidMarcaInicio: PeriodoInicio.marca
          oidCanalInicio: PeriodoInicio.canal
          oidPeriodoFin: PeriodoFin.oidPeriodo
          fechaDesdeFin: PeriodoFin.fechaIni
          fechaHastaFin:PeriodoFin.fechaFin
          codPeriodoFin: PeriodoCorpFin.codigoPeriodoCorporativo
          oidPaisFin: PeriodoFin.pais
          oidMarcaFin: PeriodoFin.marca
          oidCanalFin: PeriodoFin.canal

          Para cada elemento recuperado
          solicitudConcurso = solicitud.getSolicitudConcurso(elemento.oidConcurso)
          solicitudConcurso.periodoInicioVinculo = crear un objeto de la
          clase Periodo con los datos obtenidos de periodo de Inicio.
          solicitudConcurso.periodoFinVinculo = crear un objeto de la clase
          Periodo con los datos obtenidos de periodo de Fin.
          FPara */

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT icrte.COPA_OID_PARA_GRAL AS OIDCONCURSO, ");
        query.append(" cp1.OID_PERI AS OIDPERIODOINI, ");
        query.append(" cp1.FEC_INIC AS FECHAINIPERIODOINI, ");
        query.append(" cp1.FEC_FINA AS FECHAFINPERIODOINI, ");
        query.append(" spc1.COD_PERI AS CODIGOPERIODOINI, ");
        query.append(" cp1.PAIS_OID_PAIS AS PAISPERIODOINI, ");
        query.append(" cp1.MARC_OID_MARC AS MARCAPERIODOINI, ");
        query.append(" cp1.CANA_OID_CANA AS CANALPERIODOINI, ");
        query.append(" icrdo1.PERD_OID_PERI, ");
        query.append(" icpc.VAL_PERI_EVAL ");
        query.append(" FROM INC_CLIEN_RECTE icrte, ");
        query.append(" INC_CLIEN_RECDO icrdo1, ");
        query.append(" CRA_PERIO cp1, ");
        query.append(" SEG_PERIO_CORPO spc1, ");
        query.append(" INC_CONCU_PARAM_CONSU icpc, ");
        query.append(" INC_CONCU_PARAM_GENER icpg ");
        query.append(" WHERE icrdo1.CLIE_OID_CLIE = " + solicitud.getCliente()
            .getOidCliente());
        query.append(" AND icrdo1.CLR3_OID_CLIE_RETE = icrte.OID_CLIE_RETE ");
        query.append(" AND icrdo1.PERD_OID_PERI = cp1.OID_PERI ");
        query.append(" AND cp1.PERI_OID_PERI = spc1.OID_PERI ");
        query.append(" AND icpg.OID_PARA_GRAL = icrte.COPA_OID_PARA_GRAL ");
        query.append(" AND icpg.OID_PARA_GRAL = icpc.COPA_OID_PARA_GRAL ");
        query.append(" AND icpg.IND_ACTI = 1 ");
        

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
                for (int i = 0; i < rs.getRowCount(); i++) {
                    //Oid del concurso
                    BigDecimal bdOidCon = (BigDecimal) 
                        rs.getValueAt(i, "OIDCONCURSO");
        
                    Periodo periodoInicio = new Periodo();
        
                    //Datos del periodo inicio        
                    BigDecimal bdOidPerIni = (BigDecimal) rs
                        .getValueAt(i, "OIDPERIODOINI");
                    Date fechaInicioPerIni = (Date) rs
                        .getValueAt(i, "FECHAINIPERIODOINI");
                    Date fechaFinPerIni = (Date) rs
                        .getValueAt(i, "FECHAFINPERIODOINI");
                    String codigoPerIni = (String) rs
                        .getValueAt(i, "CODIGOPERIODOINI");
                    BigDecimal paisPerIni = (BigDecimal) rs
                        .getValueAt(i, "PAISPERIODOINI");
                    BigDecimal marcaPerIni = (BigDecimal) rs
                        .getValueAt(i, "MARCAPERIODOINI");
                    BigDecimal canalPerIni = (BigDecimal) rs
                        .getValueAt(i, "CANALPERIODOINI");
        
                    //Seteo de valores para periodo inicio
                    periodoInicio.setOidPeriodo(new Long(bdOidPerIni
                        .longValue()));
                    periodoInicio.setFechaDesde(fechaInicioPerIni);
                    periodoInicio.setFechaHasta(fechaFinPerIni);
                    periodoInicio.setCodperiodo(codigoPerIni);
                    periodoInicio.setOidPais(new Long(paisPerIni
                        .longValue()));
                    periodoInicio.setOidMarca(new Long(marcaPerIni
                        .longValue()));
                    periodoInicio.setOidCanal(new Long(canalPerIni
                        .longValue()));
        
                    solicitud.getSolicitudConcurso(new Long(bdOidCon
                        .longValue())).setPeriodoInicioVinculo(periodoInicio);
        
                    // obtener el periodo de fin
                    // INC:ClienteRecomendado.periodoInicioVinculo 
                    Long periodoInicioVinculo = new Long(((BigDecimal) rs
                        .getValueAt(i, "PERD_OID_PERI")).longValue());
        
                    // INC:ConcursoParametrosConsultoras.periodosAEvaluar -1
                    int periodosAEvaluar;
                    BigDecimal periodos = (BigDecimal) rs
                        .getValueAt(i, "VAL_PERI_EVAL");
        
                    if (periodos != null) {
                        periodosAEvaluar = periodos.intValue() - 1;
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                          UtilidadesLog.debug("periodosAEvaluar " + periodosAEvaluar);                        
                    } else {
                        solicitud.getSolicitudConcurso(new Long(bdOidCon
                            .longValue())).setPeriodoFinVinculo(null);
                        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPerio"
                            +"dosVinculo(Solicitud solicitud):Salida");
                        return;
                    }
        
                    StringBuffer query2 = new StringBuffer();
                    RecordSet rs2 = new RecordSet();
                    BelcorpService belcorpService2 = null;

                    query2.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
                    query2.append(" p.fec_inic FECHAINIPERIODOFIN, ");
                    query2.append(" p.fec_fina FECHAFINPERIODOFIN, ");
                    query2.append(" pc.cod_peri CODIGOPERIODOFIN, ");
                    query2.append(" p.pais_oid_pais PAISPERIODOFIN, ");
                    query2.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
                    query2.append(" p.cana_oid_cana CANALPERIODOFIN");
                    query2.append(" FROM cra_perio pent, cra_perio p, ");
                    query2.append(" seg_perio_corpo pc ");
                    query2.append(" WHERE pent.oid_peri = ").append(
                        periodoInicioVinculo);
                    query2.append(" AND p.fec_inic >= pent.fec_inic ");
                    query2.append(" AND pc.oid_peri = p.peri_oid_peri ");
                    query2.append(" AND p.pais_oid_pais =  ");
                    query2.append(" pent.pais_oid_pais ");
                    query2.append(" AND p.marc_oid_marc =  ");
                    query2.append(" pent.marc_oid_marc ");
                    query2.append(" AND p.cana_oid_cana = ");
                    query2.append(" pent.cana_oid_cana ");
                    query2.append(" ORDER BY p.fec_inic, pc.cod_peri, ");
                    query2.append(" p.fec_fina ");
                    /*query2.append(" SELECT OIDPERIODO  AS OIDPERIODOFIN, ");
                    query2.append("     FEC_INIC  AS FECHAINIPERIODOFIN, ");
                    query2.append("     FEC_FINA AS FECHAFINPERIODOFIN, ");
                    query2.append("     COD_PERI      AS CODIGOPERIODOFIN, ");
                    query2.append("     PAIS_OID_PAIS AS PAISPERIODOFIN, ");
                    query2.append("     MARC_OID_MARC AS MARCAPERIODOFIN, ");
                    query2.append("     CANA_OID_CANA AS CANALPERIODOFIN ");
                    query2.append("   FROM ( ");
                    query2.append("        SELECT ROWNUM Q, ");
                    query2.append("               P.OID_PERI AS OIDPERIODO, ");
                    query2.append("               P.FEC_INIC, ");
                    query2.append("               P.FEC_FINA, ");
                    query2.append("               PC.COD_PERI, ");
                    query2.append("               P.PAIS_OID_PAIS, ");
                    query2.append("               P.MARC_OID_MARC, ");
                    query2.append("               P.CANA_OID_CANA ");
                    query2.append("          FROM CRA_PERIO PENT, CRA_PERIO P, 
                    SEG_PERIO_CORPO PC ");
                    query2.append("         WHERE PENT.OID_PERI = ").append(
                    periodoInicioVinculo.toString());
                    query2.append("AND P.FEC_INIC > PENT.FEC_INIC ");
                    query2.append(" AND PC.OID_PERI = P.OID_PERI ");
                    query2.append(" AND P.PAIS_OID_PAIS = 
                      PENT.PAIS_OID_PAIS ");
                    query2.append(" AND P.MARC_OID_MARC = 
                      PENT.MARC_OID_MARC ");
                    query2.append(" AND P.CANA_OID_CANA = 
                      PENT.CANA_OID_CANA ");
                    query2.append(" ORDER BY P.FEC_INIC, PC.COD_PERI ");
                    query2.append("        ) ");
                    query2.append("  WHERE Q < ").append(periodosAEvaluar);
                    query2.append("  ORDER BY FECHAFINPERIODOFIN DESC ");*/
        
                    try {
                        rs2 = belcorpService2.getInstance().dbService.executeStaticQuery(query2.toString());
                        
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                          UtilidadesLog.debug("******* rs " + rs2);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e, UtilidadesError
                          .armarCodigoError(CodigosError
                            .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
        
                    if (rs2.esVacio()) {
                        solicitud.getSolicitudConcurso(new Long(bdOidCon
                          .longValue())).setPeriodoFinVinculo(null);
                        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPerio"
                            +"dosVinculo(Solicitud solicitud):Salida");
                        return;
                    }
                    
                    if (!rs2.esVacio() && (rs2.existeFila(periodosAEvaluar) )) {
                        Periodo periodoFin = new Periodo();

                        // datos del ultimo periodo premiacion
                        BigDecimal bdOidPerPre = (BigDecimal) rs2.getValueAt(
                            periodosAEvaluar, "OIDPERIODOFIN");
                        Date fechaInicioPerPre = (Date) rs2.getValueAt(
                            periodosAEvaluar, "FECHAINIPERIODOFIN");
                        Date fechaFinPerPre = (Date) rs2.getValueAt(
                            periodosAEvaluar, "FECHAFINPERIODOFIN");
                        String codigoPerPre = (String) rs2.getValueAt(
                            periodosAEvaluar, "CODIGOPERIODOFIN");
                        BigDecimal paisPerPre = (BigDecimal) rs2.getValueAt(
                            periodosAEvaluar, "PAISPERIODOFIN");
                        BigDecimal marcaPerPre = (BigDecimal) rs2.getValueAt(
                            periodosAEvaluar, "MARCAPERIODOFIN");
                        BigDecimal canalPerPre = (BigDecimal) rs2.getValueAt(
                            periodosAEvaluar, "CANALPERIODOFIN");

                        //Seteo de valores para periodo fin
                        periodoFin.setOidPeriodo(new Long(bdOidPerPre
                            .longValue()));
                        periodoFin.setFechaDesde(fechaInicioPerPre);
                        periodoFin.setFechaHasta(fechaFinPerPre);
                        periodoFin.setCodperiodo(codigoPerPre);
                        periodoFin.setOidPais(new Long(paisPerPre
                            .longValue()));
                        periodoFin.setOidMarca(new Long(marcaPerPre
                            .longValue()));
                        periodoFin.setOidCanal(new Long(canalPerPre
                            .longValue()));

                        solicitud.getSolicitudConcurso(new Long(bdOidCon
                            .longValue())).setPeriodoFinVinculo(periodoFin);
                    }
                }
            }
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPeriodosVinculo("
                +"Solicitud solicitud):Salida");
        }            
    //Jrivas 18/7/2005
    //Inc 19840

    /**
     * autor jrivas
     * fecha 18/7/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param solicitud
     */
    public void obtenerMetasClienteConcurso(Solicitud solicitud)
        throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerMetasClienteConcurso("
            +"Solicitud solicitud):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        //query.append(" SELECT VAL_META, COPA_OID_PARA_GRAL ");
        query.append(" SELECT OID_META_TIPO_VENTA, IMP_MONTO_VENTA, NUM_UNID_VEND, ");
        query.append("    VAL_INCR, VAL_META, CLIE_OID_CLIE, ");
        query.append("    COPA_OID_PARA_GRAL   ");
        
        query.append(" FROM INC_METAS_TIPO_VENTA, INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE CLIE_OID_CLIE = " + solicitud.getCliente() 
            .getOidCliente());
        query.append(" AND COPA_OID_PARA_GRAL = concu.OID_PARA_GRAL ");
        query.append(" AND concu.IND_ACTI = 1 ");
            
        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long oidConcurso;
        SolicitudConcurso solicitudConcurso;
        MetaTipoVenta meta;
        for (int i = 0; i < rs.getRowCount(); i++) {
            oidConcurso = new Long(((BigDecimal) rs.getValueAt(i, "COPA_OID_PARA_GRAL")).longValue());
            solicitud.getSolicitudConcurso(oidConcurso).setMetasCliente( (BigDecimal) rs.getValueAt(i, "VAL_META") );

            // BELC300024358 - gPineda - 18/10/2006            
            meta = new MetaTipoVenta();
            meta.setValMeta(          rs.getValueAt(i, "VAL_META")!=null?(BigDecimal)rs.getValueAt(i, "VAL_META") : new BigDecimal(0)  );
            meta.setMontoVenta(       rs.getValueAt(i, "IMP_MONTO_VENTA")!=null?(BigDecimal)rs.getValueAt(i, "IMP_MONTO_VENTA") : new BigDecimal(0) );
            meta.setValorIncremento(  rs.getValueAt(i, "VAL_INCR")!=null?(BigDecimal)rs.getValueAt(i, "VAL_INCR") : new BigDecimal(0) );
            meta.setOid( new Long( (  (BigDecimal)rs.getValueAt(i, "OID_META_TIPO_VENTA") ).longValue() ) );
            
            meta.setOidConcurso( new Long( ( (BigDecimal)rs.getValueAt(i, "COPA_OID_PARA_GRAL") ).longValue() ) );
            meta.setUnidadesVendidas( rs.getValueAt(i, "NUM_UNID_VEND")!=null?
                  new Integer( ( (BigDecimal)rs.getValueAt(i, "NUM_UNID_VEND") ).intValue() ): new Integer(0) );
                  
            
            solicitud.getSolicitudConcurso(oidConcurso).setMetaTipoVenta( meta );
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug( "MetaTipoVenta["+i+"]: "+ meta.toString() );    
        }
        
        
        
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerMetasClienteConcurso("
            +"Solicitud solicitud):Salida");
    }
  
   /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       8/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs recuperarSolicitudesConcursos(Long oidSolicitud, 
      Long oidConcurso) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarSolicitudesConcursos("
          +"Long oidSolicitud, Long oidConcurso):Entrada");
      UtilidadesLog.debug("Entre a recuperarSolicitudesConcursos con oidSoli"
          +"citud: " + oidSolicitud + " y oidConcurso: " + oidConcurso);
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConPunt = null;
      Long oid = null;
    
      query.append(" SELECT OID_SOLI_CONC_PUNT ");
      query.append(" FROM INC_SOLIC_CONCU_PUNTA ");
      query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
      query.append(" AND SOCA_OID_SOLI_CABE = " + oidSolicitud);
      
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
          oidSoliConPunt = (BigDecimal) rs.getValueAt(i, "OID_SOLI_CONC_PUNT");
          oid = Long.valueOf(oidSoliConPunt.toString());
          oids[i] = oid;
      }
      dtoOids.setOids(oids);
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarSolicitudesConcursos("
          +"Long oidSolicitud, Long oidConcurso):Salida");
      return dtoOids;
      
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs recuperarSolicitudesConcursosRecomendadas (Long oidSolicitud, 
      Long oidConcurso) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarSolicitudesConcursos"
          +"Recomendadas(Long oidSolicitud, Long oidConcurso):Entrada");
      UtilidadesLog.debug("Entre a recuperarSolicitudesConcursosRecomendadas "
          +"con oidSolicitud: " + oidSolicitud + " y oidConcurso: " + 
            oidConcurso);
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConRecom = null;
      Long oid = null;
    
      query.append(" SELECT OID_SOLI_CONC_RECO ");
      query.append(" FROM INC_SOLIC_CONCU_RECOM ");
      query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
      query.append(" AND SOCA_OID_SOLI_CABE = " + oidSolicitud);
    
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(
            query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("resultado: " + rs);
      
      // Coloco en el DTO los OIDs que devolvió la consulta
      int rows = rs.getRowCount();
      Long[] oids = new Long[rows];

      for (int i = 0; i < rows; i++) {
          oidSoliConRecom = (BigDecimal) rs
            .getValueAt(i, "OID_SOLI_CONC_RECO");
          oid = Long.valueOf(oidSoliConRecom.toString());
          oids[i] = oid;
      }

      dtoOids.setOids(oids);
    UtilidadesLog.info(" DAOSolicitudConcurso.recuperarSolicitudesConcursosRe"
      +"comendadas(Long oidSolicitud, Long oidConcurso):Salida");
      return dtoOids;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs recuperarPedidosConcursosRecomendadas(Solicitud solicitud, 
      SolicitudConcurso solicitudConc, Long dirigidoA) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosConcursosReco"
          +"mendadas(Solicitud solicitud, SolicitudConcurso solicitudConc):"
          +"Entrada");
      UtilidadesLog.debug("Entre a recuperarPedidosConcursosRecomendadas con "
          +"Solicitud: " + solicitud.getOidSolicitud() + " y SolicitudConcurso"
          +": " + solicitudConc.getOidConcurso());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConRecom = null;
      Long oid = null;
      
      // vbongiov -- 2/11/2006
      if(solicitud.getCliente().getClienteRecomendante()!= null && 
         solicitud.getCliente().getClienteRecomendante().getRecomendante()!=null) {
    
          query.append(" SELECT pedRec.OID_PEDI_CONC_RECO ");
          query.append(" FROM INC_PEDID_CONCU_RECOM pedRec,  ");
          query.append(" INC_CLIEN_RECTE cliRecte, ");
          // vbongiov -- 27/11/2006 -- DBLG500001077
          query.append(" INC_CLIEN_RECDO clido ");
          query.append(" WHERE pedRec.CLR3_OID_CLIE_RETE =  ");
          query.append(" cliRecte.OID_CLIE_RETE ");
          query.append(" AND cliRecte.CLIE_OID_CLIE = " + solicitud.getCliente()
              .getClienteRecomendante().getRecomendante());
          query.append(" AND pedRec.PERD_OID_PERI = " + solicitud.getPeriodo()
              .getOidPeriodo());
          query.append(" AND pedRec.COPA_OID_PARA_GRAL = " + solicitudConc
              .getOidConcurso());              
          // vbongiov -- 27/11/2006 -- DBLG500001077    
          query.append(" AND clido.OID_CLIE_REDO = pedrec.CLRE_OID_CLIE_REDO ");
          query.append(" AND clido.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());

          if(dirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)) {
          
              if(solicitud.getCliente().getAmbitoGeografico().getSubgerente()
                  != null) {
                  query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                      .getCliente().getAmbitoGeografico().getSubgerente()
                          .getOidCliente());
                  
              } else if(solicitud.getCliente().getAmbitoGeografico()
                  .getGerenteRegion()!= null) {
                  query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                      .getCliente().getAmbitoGeografico().getGerenteRegion()
                          .getOidCliente());
                  
              } else if(solicitud.getCliente().getAmbitoGeografico()
                  .getGerenteZona()!= null) {
                  query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                      .getCliente().getAmbitoGeografico().getGerenteZona()
                          .getOidCliente());
                  
              } else if(solicitud.getCliente().getAmbitoGeografico()
                  .getLider()!= null) {
                  query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                      .getCliente().getAmbitoGeografico().getLider()
                          .getOidCliente());
              }
              
          } else if(dirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)) {
               query.append(" AND pedRec.CLIE_OID_CLIE IS NULL ");
          }
          
          //jrivas 29/1/2007 BELG50001077 
          query.append(" UNION ");
      }
      
      //jrivas 29/1/2007 BELG50001077 
      query.append(" SELECT pedRec.OID_PEDI_CONC_RECO  ");
      query.append(" FROM INC_PEDID_CONCU_RECOM pedRec,   ");
      query.append(" INC_CLIEN_RECTE cliRecte ");
      query.append(" WHERE pedRec.CLR3_OID_CLIE_RETE =   ");
      query.append(" cliRecte.OID_CLIE_RETE  ");
      query.append(" AND cliRecte.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente()); 
      query.append(" AND pedRec.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
      query.append(" AND pedRec.COPA_OID_PARA_GRAL = " + solicitudConc.getOidConcurso());              
      query.append(" AND pedRec.CLRE_OID_CLIE_REDO IS NULL ");
      
      if(dirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)) {
      
          if(solicitud.getCliente().getAmbitoGeografico().getSubgerente()
              != null) {
              query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                  .getCliente().getAmbitoGeografico().getSubgerente()
                      .getOidCliente());
              
          } else if(solicitud.getCliente().getAmbitoGeografico()
              .getGerenteRegion()!= null) {
              query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                  .getCliente().getAmbitoGeografico().getGerenteRegion()
                      .getOidCliente());
              
          } else if(solicitud.getCliente().getAmbitoGeografico()
              .getGerenteZona()!= null) {
              query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                  .getCliente().getAmbitoGeografico().getGerenteZona()
                      .getOidCliente());
              
          } else if(solicitud.getCliente().getAmbitoGeografico()
              .getLider()!= null) {
              query.append(" AND pedRec.CLIE_OID_CLIE = " + solicitud
                  .getCliente().getAmbitoGeografico().getLider()
                      .getOidCliente());
          }
          
      } else if(dirigidoA.equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)) {
           query.append(" AND pedRec.CLIE_OID_CLIE IS NULL ");
      }
          
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
          oidSoliConRecom = (BigDecimal) rs
              .getValueAt(i, "OID_PEDI_CONC_RECO");
          oid = Long.valueOf(oidSoliConRecom.toString());
          oids[i] = oid;
      }

      dtoOids.setOids(oids);
      
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosConcursosReco"
          +"mendadas(Solicitud solicitud, SolicitudConcurso solicitudConc):Sa"
          +"lida");
      return dtoOids;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs recuperarPedidosRecomendadosMultinivel(Solicitud solicitud, 
      SolicitudConcurso solicitudConc) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosRecomendados"
          +"Multinivel(Solicitud solicitud, SolicitudConcurso solicitudConc):"
          +"Entrada");
      UtilidadesLog.debug("Entre a recuperarPedidosRecomendadosMultinivel con "
          +"Solicitud: " + solicitud.getOidSolicitud() +" y SolicitudConcurso:"
          +" " + solicitudConc.getOidConcurso());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConRecom = null;
      Long oid = null;
    
      query.append(" SELECT pedRecMul.OID_PEDI_RECO_MULT ");
      query.append(" FROM INC_PEDID_RECDA_MULTI pedRecMul, ");
      query.append(" INC_CLIEN_RECDO_MULTI cliRecomMul, ");
      query.append(" INC_CLIEN_RECTE_MULTI cliRecteMul ");
      query.append(" WHERE pedRecMul.CLRM_OID_CLIE_RECO_MULT =  ");
      query.append(" cliRecomMul.OID_CLIE_RECO_MULT ");
      query.append(" AND cliRecomMul.CLR2_CLIE_OID_CLIE =  ");
      query.append(" cliRecteMul.OID_CLIE_RECO_MULT ");
      query.append(" AND cliRecteMul.CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());
      query.append(" AND pedRecMul.PERD_OID_PERI = " + solicitud.getPeriodo()
          .getOidPeriodo());
      query.append(" AND cliRecteMul.COPA_OID_PARA_GRAL = " + solicitudConc
          .getOidConcurso());
        
     
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
          oidSoliConRecom = (BigDecimal) rs
              .getValueAt(i, "OID_PEDI_RECO_MULT");
          oid = Long.valueOf(oidSoliConRecom.toString());
          oids[i] = oid;
      }

      dtoOids.setOids(oids);
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosRecomendados"
          +"Multinivel(Solicitud solicitud, SolicitudConcurso solicitudConc):"
          +"Salida");
      return dtoOids;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOOIDs recuperarPedidosRecomendantesMultinivel(Solicitud solicitud, 
      SolicitudConcurso solicitudConc) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosRecomendantes"
          +"Multinivel(Solicitud solicitud, SolicitudConcurso solicitudConc):"
          +"Entrada");
      UtilidadesLog.debug("Entre a recuperarPedidosRecomendantesMultinivel con"
          +" Solicitud: " + solicitud.getOidSolicitud() + " y SolicitudConcur"
          +"so: " + solicitudConc.getOidConcurso());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
      DTOOIDs dtoOids= new DTOOIDs();
      BigDecimal oidSoliConRecom = null;
      Long oid = null;
    
      query.append(" SELECT pedRecteMul.OID_PEDI_RETE_MULT ");
      query.append(" FROM INC_PEDID_RECTE_MULTI pedRecteMul, ");
      query.append(" INC_CLIEN_RECTE_MULTI cliRecteMul ");
      query.append(" WHERE pedRecteMul.CLR2_CLIE_OID_CLIE = cliRecteMul.OID_CLIE_RECO_MULT  ");
      query.append(" AND cliRecteMul.CLIE_OID_CLIE = " + solicitud.getCliente()
          .getOidCliente());
      query.append(" AND pedRecteMul.PERD_OID_PERI = " + solicitud.getPeriodo()
          .getOidPeriodo());
      query.append(" AND cliRecteMul.COPA_OID_PARA_GRAL = " + solicitudConc
          .getOidConcurso());
   
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
          oidSoliConRecom = (BigDecimal) rs
              .getValueAt(i, "OID_PEDI_RETE_MULT");
          oid = Long.valueOf(oidSoliConRecom.toString());
          oids[i] = oid;
      }

      dtoOids.setOids(oids);
      UtilidadesLog.info(" DAOSolicitudConcurso.recuperarPedidosRecomendantes"
          +"Multinivel(Solicitud solicitud, SolicitudConcurso solicitudConc):"
          +"Salida");
      return dtoOids;
  }

    /** Metodo: obtenerPuntosAcumuladosCC
      * Autor: Julian Rivas
      * Fecha: 28/6/2006
      * Incidencia: INC-132
      */
    private void obtenerPuntosAcumuladosCC(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumuladosCC(Solicitud solicitud):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = null;

        try {
             query.append(" SELECT COPA_OID_PARA_GRAL, ");
             query.append(" SUM (NUM_PUNT) AS SUMA_PUNTOS  ");
             query.append(" FROM INC_CUENT_CORRI_PUNTO CCP, INC_CONCU_PARAM_GENER CONCU ");
             query.append(" WHERE CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
             query.append(" AND CCP.COPA_OID_PARA_GRAL = CONCU.OID_PARA_GRAL ");
             query.append(" AND IND_ACTI = 1 ");
             query.append(" GROUP BY COPA_OID_PARA_GRAL  ");

            rs = bs.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("*** obtenerPuntosAcumuladosCC: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumuladosCC(S"
                +"olicitud solicitud):Salida VACIO");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            BigDecimal bdTotal = (BigDecimal) rs.getValueAt(i, "SUMA_PUNTOS");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setPuntosAcumuladosCC(new Double(bdTotal.doubleValue()));
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosAcumuladosCC(So"
            +"licitud solicitud):Salida");
    }

    /** Metodo: obtenerPuntosAcumuladosCC
      * Autor: Julian Rivas
      * Fecha: 17/7/2006
      * Incidencia: DBLG500000721 / DBLG500000932 / DBLG500001009 
      */
    private void obtenerCumplimientoExigencias(Solicitud solicitud)
            throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerCumplimientoExigencias(Solicitud solicitud):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaDeProceso = new Date(System.currentTimeMillis());
            String strfechaDeProceso = sdf.format(fechaDeProceso); 
            
            query.append(" SELECT ECU.COPA_OID_PARA_GRAL ");
            query.append(" FROM INC_EXIGE_CUMPL ECU, INC_CONCU_PARAM_GENER cpg ");
            query.append(" WHERE ECU.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
            query.append(" AND ECU.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
            query.append(" AND ECU.FEC_CUMP <= TO_DATE('" + strfechaDeProceso + "', 'dd-MM-yyyy') ");
            query.append(" AND CPG.OID_PARA_GRAL = ECU.COPA_OID_PARA_GRAL ");
            query.append(" AND ECU.IND_EXIG_CUMP =  1 AND IND_ACTI = 1");

            rs = bs.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("*** obtenerCumplimientoExigencias: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }    

        if (rs.esVacio()) {
            UtilidadesLog.info(" DAOSolicitudConcurso.obtenerCumplimientoExigencias(S"
                +"olicitud solicitud):Salida VACIO");
            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs
                .getValueAt(i, "COPA_OID_PARA_GRAL");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue()))
                .setIndExigenciasCumplidas(true);
        }
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerCumplimientoExigencias(So"
            +"licitud solicitud):Salida");
    }

  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   31/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500001091
   */
  public Long obtenerPuntosBonificados(Solicitud solicitud, Concurso concurso) throws MareException {
      UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosBonificados(Solicitud solicitud, Concurso concurso:Entrada");
      
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
  
      query.append(" SELECT SUM(iscp.VAL_PUNT_BONI) AS CANT ");
      query.append(" FROM INC_SOLIC_CONCU_PUNTA iscp ");
      query.append(" WHERE iscp.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
      query.append(" AND iscp.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
      query.append(" AND iscp.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
      
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
          UtilidadesLog.debug("******* rs " + rs);
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
  
      BigDecimal cantidad = (BigDecimal) rs.getValueAt(0, "CANT");
          
      UtilidadesLog.debug("cantidad: " + cantidad);
      
      UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPuntosBonificados(Solicitud solicitud, Concurso concurso:Salida");
      return  Long.valueOf(cantidad.toString());
  }
  
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   30/08/2006
     * @version 1.00
     * @autor   Julián Rivas
     * Inc. DBLG50000839
     */    
    private void obtenerSolicitudesGerentesProcesadas(Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudConcurso.obtenerSolicitudesGerentesProcesadas(Solicitud solicitud):Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        
        query.append(" SELECT COPA_OID_PARA_GRAL FROM INC_SOLIC_GEREN_RECOM, INC_CONCU_PARAM_GENER ");
        query.append(" WHERE SOCA_OID_SOLI_CABE = " + solicitud.getOidSolicitud());
        query.append(" AND PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
        query.append(" AND OID_PARA_GRAL = COPA_OID_PARA_GRAL ");
        query.append(" AND IND_ACTI = 1 ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("resultado: " + rs);

        BigDecimal oidConcurso = null;
        for (int i = 0; i < rs.getRowCount(); i++) {
            oidConcurso = (BigDecimal) rs.getValueAt(i, "COPA_OID_PARA_GRAL");
            solicitud.getSolicitudConcurso(new Long(oidConcurso.longValue())).setRechazado(true);
        }
        UtilidadesLog.info("DAOSolicitudConcurso.obtenerSolicitudesGerentesProcesadas(Solicitud solicitud):Salida");        
    }

    // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
    private void obtenerPremioEntregados(Solicitud solicitud) throws MareException {
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPremioEntregados(Solicitud solicitud):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT PARAM.OID_PARA_GRAL ");
        query.append("   FROM INC_GANAD GAN, INC_PARAM_NIVEL_PREMI NIVEL, ");
        query.append("        INC_PARAM_GENER_PREMI GENP, INC_CONCU_PARAM_GENER PARAM ");
        query.append("  WHERE GAN.PANP_OID_PARA_NIVE_PREM = NIVEL.OID_PARA_NIVE_PREM ");
        query.append("    AND NIVEL.PAGP_OID_PARA_GENE_PREM = GENP.OID_PARA_GENE_PREM ");
        query.append("    AND GENP.COPA_OID_PARA_GRAL = PARAM.OID_PARA_GRAL ");
        query.append("    AND PARAM.IND_ACTI = 1 ");
        query.append("    AND GAN.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
        query.append(" GROUP BY PARAM.OID_PARA_GRAL ");

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
            BigDecimal bdOidCon = (BigDecimal) rs.getValueAt(i, "OID_PARA_GRAL");
            solicitud.getSolicitudConcurso(new Long(bdOidCon.longValue())).setPremioDespachado(true);
        }
        
        UtilidadesLog.info(" DAOSolicitudConcurso.obtenerPremioEntregados(Solicitud solicitud):Salida");
    }


}
