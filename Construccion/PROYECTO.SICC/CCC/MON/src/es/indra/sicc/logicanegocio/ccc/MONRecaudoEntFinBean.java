/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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



package es.indra.sicc.logicanegocio.ccc;

//~--- non-JDK imports --------------------------------------------------------

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTOBuscarConfirmarMovBanc;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancConsultar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancDepurar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovCCConfirmar;
import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOMovBanc;
import es.indra.sicc.dtos.ccc.DTOMovBancIndicadores;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ccc.DTONumeroLote;
import es.indra.sicc.dtos.ccc.DTONumerosLote;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOSituacionCupones;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOBloqueo;
import es.indra.sicc.entidades.ccc.CopiaMovimientoBancarioLocal;
import es.indra.sicc.entidades.ccc.CopiaMovimientoBancarioLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCuponesTramiteDepuracionLocal;
import es.indra.sicc.entidades.ccc.DetalleCuponesTramiteDepuracionLocalHome;
import es.indra.sicc.entidades.ccc.HistoricoMovimientosBancLocalHome;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocal;
import es.indra.sicc.entidades.ccc.MovimientosBancariosLocalHome;
import es.indra.sicc.entidades.ccc.SituacionCuponesLocal;
import es.indra.sicc.entidades.ccc.SituacionCuponesLocalHome;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.ccc.DAOCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONActualizarCCporAplicacion;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

//~--- JDK imports ------------------------------------------------------------

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

//~--- classes ----------------------------------------------------------------

public class MONRecaudoEntFinBean implements SessionBean {
   private SessionContext ctx;

   public void ejbCreate() {}

   public void ejbActivate() {}

   public void ejbPassivate() {}

   public void ejbRemove() {}

   public void setSessionContext(SessionContext ctx){
      this.ctx = ctx;
   }

   /**
    * Método para obtener los registros que cumplen
    * los criterios de busqueda determinados en el parámetro de entrada
    * @param dto DTOConsultarCupon3 con los criterios de busqueda
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron datos que cumplieran los criterios de busqueda
    */
   public DTOSalida consultarCupon3(DTOConsultarCupon3 dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOConsultarCupon3 dto): Entrada");

      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.consultarCupon3(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.consultarCupon3(dto): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOConsultarCupon3 dto): Salida");
      return dtoS;
   }

   /**
    * Establece a "Conciliado" cada uno de los registros que llegan de entrada
    * @param dtoOIDs DTOOIDs con los oids de los registros
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * pudo realizar la cancelación
    */
   public void cancelarCupon3(DTOOIDs dtoOIDs) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOConsultarCupon3 dto): Entrada");
      // se validan los accesos
      validaAccesos(dtoOIDs.getOidPais(), null, null, null, null, null, null, null, null, null, null);

      // Localizamos la entidad SituacionCupon correspondiente a "(C)onciliado":
      SituacionCuponesLocal sitCupon = null;

      try{
         sitCupon = this.getSituacionCuponesLocalHome().findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_CONCILIADO);

         Long oidSitu = sitCupon.getOid();
         // Localizamos la interface "Home" (detalleHome) de la entidad "DetalleCuponesTramiteDepuracion"
         DetalleCuponesTramiteDepuracionLocalHome detalleLH = this.getDetalleCuponesTramiteDepuracionLocalHome();
         Long[] oids = dtoOIDs.getOids();

         for (int i = 0; i < oids.length; i++){
            // Localizamos cada entidad a través de su OID:
            DetalleCuponesTramiteDepuracionLocal detalle = detalleLH.findByPrimaryKey(oids[i]);

            detalle.setSituacion(oidSitu);
         }
      }catch (NoResultException e){
         ctx.setRollbackOnly();

         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;

         this.logearError(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOConsultarCupon3 dto): Salida");
   }

   /**
    * Método para obtener las situaciones a cancelar
    * @return DTOColeccion con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos
    */
   public DTOColeccion situacionesACancelar() throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.situacionesACancelar(): Entrada");

      ArrayList lista = new ArrayList();
      DTOSituacionCupones dto = null;
      DTOColeccion coleccion = null;
      // Localizamos la interface Home de la entidad SituacioCupones
      SituacionCuponesLocal situ = null;

      try{
         situ = this.getSituacionCuponesLocalHome().findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_TRAMITE);
         dto = new DTOSituacionCupones();
         dto.setOid(situ.getOid());
         dto.setCodigoSituacion(situ.getCodigoSituacion());
         dto.setDescripcion(situ.getDescripcion());
         lista.add(dto);
         situ = this.getSituacionCuponesLocalHome().findByCodigoSituacion(CCCConstantes.SITUACION_CUPON_DEPURACION);
         dto = new DTOSituacionCupones();
         dto.setOid(situ.getOid());
         dto.setCodigoSituacion(situ.getCodigoSituacion());
         dto.setDescripcion(situ.getDescripcion());
         lista.add(dto);
         coleccion = new DTOColeccion();
         coleccion.setLista(lista);
      }catch (NoResultException e){
         ctx.setRollbackOnly();

         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;

         this.logearError(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.situacionesACancelar(): Salida");
      return coleccion;
   }

   /**
    * Método para obtener los registros que cumplen
    * los criterios de busqueda determinados en el parámetro de entrada
    * @param dto DTOBuscarMovBancDepurar con los criterios de busqueda
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron datos que cumplieran los criterios de busqueda
    */
   public DTOSalida buscarMovBancDepurar(DTOBuscarMovBancDepurar dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancDepurar(DTOBuscarMovBancDepurar dto): Entrada");

      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.buscarMovBancDepurar(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.buscarMovBancDepurar(dto): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancDepurar(DTOBuscarMovBancDepurar dto): Salida");
      return dtoS;
   }

   /**
    * Método para obtener el detalle de un Movimiento Bancario
    * @param dto DTOOID con el oid del movimiento bancario
    * @return DTOSalida con los datos del registro encontrado
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontró el registro
    */
   public DTOSalida detalleMovBanc(DTOMovBanc dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.detalleMovBanc(DTOMovBanc dto): Entrada");
      UtilidadesLog.info("Contenido DTOMovBanc: " + dto);

      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.detalleMovBanc(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.detalleMovBanc(DTOMovBanc): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.detalleMovBanc(DTOMovBanc dto): Salida");
      return dtoS;
   }

   /**
    * Método para traspasar movimientos bancarios
    * @param dto DTOOIDs con los oids de los movimientos bancarios a traspasar
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron los movimientos bancarios
    */
   public void traspasarMovBanc(DTOOIDs dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.traspasarMovBanc(DTOOIDs dto): Entrada");
//    Comentado hasta que se resuelva la BELC300010166
      // se validan los accesos
      validaAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null);

      // Interfaces Home de los Entity
      MovimientosBancariosLocalHome homeMovBanc = getMovimientosBancariosLocalHome();
      // HistoricoMovimientosBancLocalHome homeHistMovBanc = getHistoricoMovimientosBancLocalHome();
      CopiaMovimientoBancarioLocalHome homeCopiaMovimientoBancario = getCopiaMovimientoBancarioLocalHome();
      // interfaces remotas
      MovimientosBancariosLocal movBanc = null;
      // HistoricoMovimientosBancLocal histMovBanc= null;

      for (int i = 0; i < dto.getOids().length; i++){
         // Localizamos el MovimientoBancario
         try{
            movBanc = homeMovBanc.findByPrimaryKey(dto.getOids()[i]);
         }catch (FinderException e){
            ctx.setRollbackOnly();

            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;

            this.logearError(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }

         // Traspasamos el movimiento anterior al Historico
         // Es decir copiamos los datos de los campos del movBanc en un
         // nuevo registro en Histórico movimiento bancario.
         try{
            CopiaMovimientoBancarioLocal copiaLocal = homeCopiaMovimientoBancario.create(movBanc.getEmpresa(), movBanc.getSubprocesoMarcaCreacion(), movBanc.getCuentaCorriente(), movBanc.getPais(),
                                                         movBanc.getConsultoraReal(), movBanc.getTipoAbonoCreacion());

            // copiaLocal.setFechaPasoAHistorico(new Date()); // Date fechaPasoAHistorico no existe columna
            copiaLocal.setUsuarioProceso(movBanc.getUsuarioProceso());                                            // String usuarioProceso,
            copiaLocal.setCodigoUsuario(movBanc.getCodigoUsuario());                                              // String codigoUsuario
            copiaLocal.setConsecutivoTransaccion(movBanc.getConsecutivoTransaccion());                            // Integer cons transaccion,
            copiaLocal.setNumeroHistoria(movBanc.getNumeroHistoria());                                            // Integer numeroHistoria,
            copiaLocal.setNumeroLote(movBanc.getNumeroLote());                                                    // Long numeroLote,*/
            copiaLocal.setSubacceso(movBanc.getSubacceso());                                                      // Long subacceso,
            copiaLocal.setNumeroFacturaBoleta(movBanc.getNumeroFacturaBoleta());                                  // Long numeroFacturaOBoleta,
            copiaLocal.setFechaPago(movBanc.getFechaPago());                                                      // Date fechaPago,
            copiaLocal.setImportePago(movBanc.getImportePago());                                                  // BigDecimal importePago,
            copiaLocal.setImporteAplicado(movBanc.getImporteAplicado());                                          // BigDecimal importeAplicado,
            copiaLocal.setSaldoPendiente(movBanc.getSaldoPendiente());                                            // BigDecimal saldoPendiente,
            copiaLocal.setNumeroCupon(movBanc.getNumeroCupon());                                                  // Long numeroCupon,
            copiaLocal.setCodigoConsultora(movBanc.getCodigoConsultora());                                        // String codigoConsultora,
            copiaLocal.setDigitoChequeoFactura(movBanc.getDigitoChequeoFactura());                                // Integer digitoChequeoNumFac,
            copiaLocal.setOficinaRecaudadora(movBanc.getOficinaRecaudadora());                                    // Integer oficinaRecaudadora,
            copiaLocal.setNombreOficina(movBanc.getNombreOficina());                                              // String nombreOficina,
            copiaLocal.setNumeroDocumento(movBanc.getNumeroDocumento());                                          // String numeroDocumento,
            copiaLocal.setHorarioNormalAdicional(movBanc.getHorarioNormalAdicional());                            // String horarioNormalAdicional,
            copiaLocal.setFechaProceso(movBanc.getFechaProceso());                                                // Date fechaProceso,
            copiaLocal.setHoraProceso(movBanc.getHoraProceso());                                                  // Timestamp horaProceso,
            copiaLocal.setDocumentoCreacionMesSerie(movBanc.getDocumentoCreacionMesSerie());                      // String documentoCreacionMes,
            copiaLocal.setDocumentoCreacionAnyo(movBanc.getDocumentoCreacionAnyo());                              // String documentoCreacionAnio,
            copiaLocal.setDocumentoCreacionNumero(movBanc.getDocumentoCreacionNumero());                          // Integer documentoCreacionNumero,
            copiaLocal.setDocumentoAplicacionMesSerie(movBanc.getDocumentoAplicacionMesSerie());                  // String documentoAplicacionMes,
            copiaLocal.setDocumentoAplicacionAnyo(movBanc.getDocumentoAplicacionAnyo());                          // String documentoAplicacionAnio,
            copiaLocal.setDocumentoAplicacionNumero(movBanc.getDocumentoAplicacionNumero());                      // Integer documentoAplicacionNumero,
            copiaLocal.setFechaMovimientoAplicacion(movBanc.getFechaMovimientoAplicacion());                      // Timestamp fechaMovimientoAplicacion,
            copiaLocal.setCodigoError(movBanc.getCodigoError());                                                  // String codigoError,
            copiaLocal.setEstatusMovimientoPendienteAplicado(movBanc.getEstatusMovimientoPendienteAplicado());    // String estatusMovimientoTesoreria,
            copiaLocal.setIdentificadorProceso(movBanc.getIdentificadorProceso());                                // String identificadorProceso,
            copiaLocal.setNumeroLoteContabilizacion(movBanc.getNumeroLoteContabilizacion());                      // String numeroLoteContabilizacion,
            copiaLocal.setFechaContabilizacion(movBanc.getFechaContabilizacion());                                // Date fechaContabilizacion,
            copiaLocal.setObservaciones(movBanc.getObservaciones());                                              // String observaciones,
            copiaLocal.setNumeroLoteExterno(movBanc.getNumeroLoteExterno());                                      // Long numeroLoteExterno,
            copiaLocal.setSubprocesoMarcasUltimo(movBanc.getSubprocesoMarcasUltimo());                            // Long subprocesoMarcasUltimo,
            copiaLocal.setTipoAbonoUltimo(movBanc.getTipoAbonoUltimo());                                          // Long tiposAbonoUltimo,
            copiaLocal.setTipoTransaccion(movBanc.getTipoTransaccion());                                          // Long transaccion,
            copiaLocal.setNMovimientoCaja(movBanc.getNMovimientoCaja());                                          // Long movimiento CAJA ORIGEN,
            copiaLocal.setError(movBanc.getError());                                                              // Long tipoError,
         }catch (CreateException e){
            this.logearError(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }

         // Eliminamos todos los detalles de la entidad
         // DetalleCuponesTramiteDepuracion
         // cuyo movimientoBancario se corresponda con el actual
         // Creamos un DTOOID dtoOID con movBanc.getOID().
         // De momento, según la BELC300010166 al producirse una eliminación en
         // cascada, esto ya no es necesario
         // DTOOID dtoOID = new DTOOID();
         // dtoOID.setOid(dto.getOids()[i]);
         // new DAORecaudoEntFin().eliminarDetalleCuponesTramitePorMovBanc(dtoOID);
         // Eliminamos el MovimientoBancario
         try{
            movBanc.remove();
         }catch (RemoveException e){
            ctx.setRollbackOnly();
            this.logearError(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.traspasarMovBanc(DTOOIDs dto): Salida");
   }

   /**
    * Método para obtener los registros que cumplen
    * los criterios de busqueda determinados en el parámetro de entrada
    * @param dto DTOBuscarMovBancConsultar con los criterios de busqueda
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron datos que cumplieran los criterios de busqueda
    */
   public DTOSalida buscarMovBancConsultar(DTOBuscarMovBancConsultar dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancConsultar(DTOBuscarMovBancConsultar dto): Entrada");

      // El DTOSalida tiene una columna "saldo" vacía
      DTOSalida dtoSalida = new DAORecaudoEntFin().buscarMovBancConsultar(dto);
      RecordSet rs = dtoSalida.getResultado();
      int longitud = rs.getRowCount();
      BigDecimal saldoActual = null;

      for (int i = 0; i < longitud; i++){    // Recorremos las filas del recordset
         if (i == 0){                        // Calculamos el saldoInicial en la primera pasada
            if ((dto.getSaldoInicial() != null) && dto.getSaldoInicial().booleanValue() && (dto.getFechaMovimiento() != null)){
               /*
                *  for(int h=0; h < longitud; h++) {
                *
                *   String codigoIdentifProceso = (String)rs.getValueAt(h, "COD_IDEN_PROC");
                *   Date fechaPago = (Date)rs.getValueAt(h, "FEC_PAGO");
                *
                *   if ( fechaPago.before(dto.getFechaMovimiento())
                *      && codigoIdentifProceso.equals(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO)) {
                *
                *      saldoActual += ((BigDecimal)rs.getValueAt(h, "IMP_PAGO")).doubleValue();
                *   }
                * }
                */
               saldoActual = new DAORecaudoEntFin().obtenerSaldoInicialFechaMovimiento(dto);
               // if ((BigDecimal)rs.getValueAt(0, "IMP_PAGO") != null)
               saldoActual = saldoActual.add((BigDecimal) rs.getValueAt(0, "IMP_PAGO"));
            }else{
               saldoActual = (BigDecimal) rs.getValueAt(0, "IMP_PAGO");
            }

            BigDecimal saldoInicialPaginasAnteriores = new BigDecimal(0);

            // Se obtienen el saldo inicial de las paginas anteriores
            if (dto.getIndicadorSituacion().longValue() != 0){
               saldoInicialPaginasAnteriores = new DAORecaudoEntFin().obtenerSaldoInicialPaginasAnteriores(dto);
            }

            // Se asigna el saldo actual calculo al saldo del primer importe
            saldoActual = saldoActual.add(saldoInicialPaginasAnteriores);
            rs.setValueAt(saldoActual, 0, rs.getColumnPosition("saldo"));
            continue;
         }

         // El resto de pasadas
         saldoActual = saldoActual.add((BigDecimal) rs.getValueAt(i, "IMP_PAGO"));
         // rs[i].saldo = saldoActual;
         rs.setValueAt(saldoActual, i, rs.getColumnPosition("saldo"));
      }

      // retorna el DTOSalida con la columna de saldos actualizada.
      dtoSalida = new DTOSalida(rs);
      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancConsultar(DTOBuscarMovBancConsultar dto): Salida");
      return dtoSalida;
   }

   /**
    *  Método para realizar la confirmación de movimientos bancarios
    *  @param dto DTONumerosLote con el número de lote
    *  @exception MareException si no se pudo acceder a la base de datos o no se
    *  encontraron registros
    */
    
    
    
   public void confirmarMovBanc(DTONumerosLote dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.confirmarMovBanc(DTONumerosLote dto): Entrada");
      
      String usuario = ctx.getCallerPrincipal().getName();
           
      DTOBloqueo dtoB = new DTOBloqueo();
      dtoB.setDescripcionProceso("Confirmar movimientos bancarios");
      dtoB.setUsuario(usuario);
      new DAOCCC().insertarBloqueo(dtoB);

      long inicio = System.currentTimeMillis();

      UtilidadesLog.warn("- GA - INICIO DE PROCESO DE CONFIRMACION DE MOVIMIENTOS BANCARIOS: ");
      // se validan los accesos
      validaAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null);

      TiposAbonoSubprocesoLocal tiposAbonoSubprocesoLocal = null;
     

      try{
         // aquí colocaremos todos los DTOMovimientoBancario sin errores para enviárselos
         // a MONActualizarCCporAplicacion.procesarMovBancporAplicacion()
         ArrayList movimientosAProcesar = new ArrayList();
         StringBuffer cadenaUpdateBancos = null;
         StringBuffer InsertDetalleCargoAbono = null;
         RecordSet rs = null;
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
         Long cero = daoRecaudoEntFin.obtenerOidCueContCero(new String("0"));
         // obtenemos la fecha del sistema.
         // devuelve un array de 3 Strings: año, mes y dia
         String[] partesFechaDelSistema = obtenerAnioMesDiaDelSistema();
         String anio = null;
         String periodoMes = null;

         anio = partesFechaDelSistema[0].substring(2, 4);
         periodoMes = partesFechaDelSistema[1];

         Long oidSubprocesoUltimo = null;
         // Gacevedo. V-CCC010. Por incidencia de validación, se cambia la forma de
         // obtener el OidSubprocesoMarcaUltimo.
         String proceso = CCCConstantes.APLIC_AUTOMATICA_MOV_BANC;
         Integer subproceso = new Integer(1);
         DAOCCC daoCCC = new DAOCCC();
         //long a = System.currentTimeMillis();
         RecordSet rs2 = daoCCC.obtenerTiposAbonoSubproceso(proceso, subproceso, dto.getOidPais());

         if (!rs2.esVacio()){
            // respuesta.tipoAbonoTES = oid del primer registro del RecordSet obtenido en la llamada anterior
            if (rs2.getValueAt(0, 1) != null){
               // dtoMovBanc.setOidSubprocesoMarcaUltimo(new Long(rs2.getValueAt(0,1).toString()));
               oidSubprocesoUltimo = new Long(rs2.getValueAt(0, 1).toString());
            }
         }

         String codigoProceso = "TES001";
         Long oidProceso = new DAOCCC().obtieneProceso(codigoProceso, dto.getOidPais());
         PaisLocal pais = getPaisLocalHome().findByPrimaryKey(dto.getOidPais());
         MONRecaudoEntFinLocal monRecaudoEntFinLocal = getMONRecaudoEntFinLocalHome().create();

         // Cada numeroLote puede corresponderse con varios registros (agrupados)
         for (int i = 0; i < dto.getNumerosLote().length; i++){
            try{
               // Comprobamos que no se haya procesado el mismo lote.
               UtilidadesLog.warn("- GA - Se marca como procesado el lote " + dto.getNumerosLote()[i]);
               monRecaudoEntFinLocal.BloquearLote(dto.getNumerosLote()[i]);
            }catch (Exception e){
               // e.printStackTrace();
               // Asumimos que el lote esta procesado
               UtilidadesLog.debug("Ya se ha procesado el lote: " + dto.getNumerosLote()[i]);
               continue;
            }

            // Localizamos los registros correspondientes al numeroLote ( dto.numerosLote[i] )
            DTONumeroLote dtoLote = new DTONumeroLote();

            dtoLote.setNumeroLote(dto.getNumerosLote()[i]);

            DTOSalida dtoS = new DAOCuentasCorrientes(ctx.getCallerPrincipal().getName()).movBancPorNumLote(dtoLote);

            // se obtiene el RecordSet
            rs = dtoS.getResultado();

            int numeroLinea = 0;
            Long oidCabecera = null;
            Integer numeroCabecera = null;
            Integer numero = null;
            int numeroRegistros = rs.getRowCount();

            tiposAbonoSubprocesoLocal = null;

            StringBuffer updateBancos = new StringBuffer();

            for (int h = 0; h < numeroRegistros; h++){
               // Creamos un DTOMovimientoBancario (dtoMovBanc) con el dtoS.recordset[h];
               DTOMovimientoBancario dtoMovBanc = new DTOMovimientoBancario();

               UtilidadesLog.warn("- GA - Registro :" + h);
               dtoMovBanc.setOid(new Long(((BigDecimal) rs.getValueAt(h, "OID_MOVI_BANC")).longValue()));                                    // Long oid
               dtoMovBanc.setEmpresa(new Long(((BigDecimal) rs.getValueAt(h, "SOCI_OID_SOCI")).longValue()));                                // Long empresa

               if (rs.getValueAt(h, "IMP_SALD_PEND") != null){
                  dtoMovBanc.setImporteSaldo((BigDecimal) rs.getValueAt(h, "IMP_SALD_PEND"));
               }else{
                  dtoMovBanc.setImporteSaldo(new BigDecimal("0"));
               }

               if (rs.getValueAt(h, "IMP_PAGO") != null){
                  dtoMovBanc.setImportePago((BigDecimal) rs.getValueAt(h, "IMP_PAGO"));                                                      // BigDecimal importePago
               }

               if (rs.getValueAt(h, "IMP_APLI") != null){
                  dtoMovBanc.setImporteAplicado((BigDecimal) rs.getValueAt(h, "IMP_APLI"));                                                  // BigDecimal
               }

               if (rs.getValueAt(h, "VAL_IMPO_MOVI") != null){
                  dtoMovBanc.setImporteMovimiento((BigDecimal) rs.getValueAt(h, "VAL_IMPO_MOVI"));                                           // BigDecimal importePago
               }

               if (rs.getValueAt(h, "NUM_LOTE") != null){
                  dtoMovBanc.setNumeroLote(new Long(((BigDecimal) rs.getValueAt(h, "NUM_LOTE")).longValue()));                               // Long numeroLote
               }

               if (rs.getValueAt(h, "FEC_PAGO") != null){
                  dtoMovBanc.setFechaPago((Date) rs.getValueAt(h, "FEC_PAGO"));                                                              // Date fechaPago
               }

               dtoMovBanc.setCuentaCorrienteBancaria(new Long(((BigDecimal) rs.getValueAt(h, "CCBA_OID_CC_BANC")).longValue()));             // Long cuentaCorrienteBancaria

               if (rs.getValueAt(h, "NUM_CONS_TRAN") != null){
                  dtoMovBanc.setConsecutivoTransaccion(new Long(((BigDecimal) rs.getValueAt(h, "NUM_CONS_TRAN")).longValue()));              // Long consecutivoTransaccion
               }

               if (rs.getValueAt(h, "NUM_FACT_BOLE") != null){
                  dtoMovBanc.setNumeroFactura(new Long(((BigDecimal) rs.getValueAt(h, "NUM_FACT_BOLE")).longValue()));                       // Long numeroFactura
               }

               if (rs.getValueAt(h, "VAL_DIGI_CHEQ_FACT") != null){
                  dtoMovBanc.setDigitoChequeo(new Integer(((BigDecimal) rs.getValueAt(h, "VAL_DIGI_CHEQ_FACT")).intValue()));                // Integer digitoChequeo
               }

               if (rs.getValueAt(h, "NUM_CUPO") != null){
                  dtoMovBanc.setNumeroCupon(new Long(((BigDecimal) rs.getValueAt(h, "NUM_CUPO")).longValue()));                              // Long numeroCupon
               }

               if (rs.getValueAt(h, "COD_OFIC_RECA") != null){
                  dtoMovBanc.setOficinaRecaudadora((String) rs.getValueAt(h, "COD_OFIC_RECA"));                                              // Integer oficinaRecaudadora
               }

               if (rs.getValueAt(h, "VAL_NOMB_OFIC") != null){
                  dtoMovBanc.setNombreOficina((String) rs.getValueAt(h, "VAL_NOMB_OFIC"));                                                   // String nombreOficina
               }

               if (rs.getValueAt(h, "TTRA_OID_TIPO_TRANS") != null){
                  dtoMovBanc.setTipoTransaccion(new Long(((BigDecimal) rs.getValueAt(h, "TTRA_OID_TIPO_TRANS")).longValue()));               // Long tipoTransaccion
               }

               if (rs.getValueAt(h, "VAL_HORA_NORM_ADIC") != null){
                  dtoMovBanc.setHorario((String) rs.getValueAt(h, "VAL_HORA_NORM_ADIC"));                                                    // String horario
               }

               if (rs.getValueAt(h, "VAL_USUA_PROC") != null){
                  dtoMovBanc.setUsuarioProceso((String) rs.getValueAt(h, "VAL_USUA_PROC"));                                                  // String usuarioProceso
               }

               if (rs.getValueAt(h, "COD_CONS") != null){
                  dtoMovBanc.setCodConsultoraReal((String) rs.getValueAt(h, "COD_CONS"));                                                    // String codConsultoraReal
               }

               if (rs.getValueAt(h, "VAL_DOCU_CREA_MES_SERI") != null){
                  dtoMovBanc.setSerieDocumentoCreacion((String) rs.getValueAt(h, "VAL_DOCU_CREA_MES_SERI"));                                 // String serieDocumentoCreacion
               }

               if (rs.getValueAt(h, "VAL_DOCU_CREA_ANIO") != null){
                  dtoMovBanc.setAnioDocumentoCreacion((String) rs.getValueAt(h, "VAL_DOCU_CREA_ANIO"));                                      // String anioDocumentoCreacion
               }

               if (rs.getValueAt(h, "VAL_DOCU_CREA_NUME") != null){
                  dtoMovBanc.setNumeroDocumentoCreacion(new Integer(((BigDecimal) rs.getValueAt(h, "VAL_DOCU_CREA_NUME")).intValue()));      // Integer numeroDocumentoCreacion
               }

               if (rs.getValueAt(h, "VAL_DOCU_APLI_MES_SERI") != null){
                  dtoMovBanc.setSerieDocumentoAplicacion((String) rs.getValueAt(h, "VAL_DOCU_APLI_MES_SERI"));                               // String serieDocumentoAplicacion
               }

               if (rs.getValueAt(h, "VAL_DOCU_APLI_ANIO") != null){
                  dtoMovBanc.setAnioDocumentoAplicacion((String) rs.getValueAt(h, "VAL_DOCU_APLI_ANIO"));                                    // String anioDocumentoAplicacion
               }

               if (rs.getValueAt(h, "VAL_DOCU_APLI_NUME") != null){
                  dtoMovBanc.setNumeroDocumentoAplicacion(new Integer(((BigDecimal) rs.getValueAt(h, "VAL_DOCU_APLI_NUME")).intValue()));    // Integer numeroDocumentoAplicacion
               }

               if (rs.getValueAt(h, "FEC_MOVI_APLI") != null){
                  dtoMovBanc.setFechaMovimientoAplicacion((Date) rs.getValueAt(h, "FEC_MOVI_APLI"));                                         // Date fechaMovimientoAplicacion
               }

               if (rs.getValueAt(h, "COD_ERRO") != null){
                  dtoMovBanc.setCodError((String) rs.getValueAt(h, "COD_ERRO"));                                                             // String codError
               }

               if (rs.getValueAt(h, "VAL_ESTA_MOVI_PEND") != null){
                  dtoMovBanc.setEstatusMovimientoTesoreria(new Character(((String) rs.getValueAt(h, "VAL_ESTA_MOVI_PEND")).charAt(0)));      // Character estatusMovimientoTesoreria
               }

               if (rs.getValueAt(h, "COD_IDEN_PROC") != null){
                  dtoMovBanc.setIdentificadorProceso((String) rs.getValueAt(h, "COD_IDEN_PROC"));                                            // String identificadorProceso
               }

               if (rs.getValueAt(h, "VAL_NUME_LOTE_CONT") != null){
                  dtoMovBanc.setNumeroLoteContabilizacion((String) rs.getValueAt(h, "VAL_NUME_LOTE_CONT"));                                  // String numeroLoteContabilizacion
               }

               if (rs.getValueAt(h, "FEC_CONT") != null){
                  dtoMovBanc.setFechaContabilizacion((Date) rs.getValueAt(h, "FEC_CONT"));                                                   // Date fechaContabilizacion
               }

               if (rs.getValueAt(h, "VAL_OBSE") != null){
                  dtoMovBanc.setObservaciones((String) rs.getValueAt(h, "VAL_OBSE"));                                                        // String observaciones
               }

               if (rs.getValueAt(h, "CLIE_OID_CLIE") != null){
                  dtoMovBanc.setOidConsultoraReal(new Long(((BigDecimal) rs.getValueAt(h, "CLIE_OID_CLIE")).longValue()));                   // Long oidConsultoraReal
               }

               // los campos de DTOBelcorp
               if (rs.getValueAt(h, "PAIS_OID_PAIS") != null){
                  dtoMovBanc.setOidPais(new Long(((BigDecimal) rs.getValueAt(h, "PAIS_OID_PAIS")).longValue()));                             // Long pais
               }

               dtoMovBanc.setOidIdioma(dto.getOidIdioma());

               // incidencia 10078
               if (rs.getValueAt(h, "SUBP_OID_MARC_CREA") != null){
                  dtoMovBanc.setOidSubprocesoMarcaCreacion(new Long(((BigDecimal) rs.getValueAt(h, "SUBP_OID_MARC_CREA")).longValue()));
               }

               if (rs.getValueAt(h, "TCAB_OID_ABON_CREA") != null){
                  dtoMovBanc.setOidTipoAbonoCreacion(new Long(((BigDecimal) rs.getValueAt(h, "TCAB_OID_ABON_CREA")).longValue()));
               }

               if (rs.getValueAt(h, "SBAC_OID_SBAC") != null){
                  dtoMovBanc.setSubacceso(new Long(((BigDecimal) rs.getValueAt(h, "SBAC_OID_SBAC")).longValue()));
               }

               if (rs.getValueAt(h, "NUM_HIST") != null){
                  dtoMovBanc.setNumeroHistoria(new Integer(rs.getValueAt(h, "NUM_HIST").toString()));
               }else{
                  dtoMovBanc.setNumeroHistoria(new Integer("0"));
               }

               // Como se procesan de a lotes, el tipo de abono creacion y la marca de creacion son iguales para todos los del lote
               // osea que es correcto buscarlo 1 sola vez por lote.
               if (tiposAbonoSubprocesoLocal == null){
                  tiposAbonoSubprocesoLocal = getTiposAbonoSubprocesoLocalHome().findByUK(dtoMovBanc.getOidTipoAbonoCreacion(), dtoMovBanc.getOidSubprocesoMarcaCreacion());
               }

               if (oidSubprocesoUltimo != null){
                  dtoMovBanc.setOidSubprocesoMarcaUltimo(oidSubprocesoUltimo);
               }else{
                  dtoMovBanc.setOidSubprocesoMarcaUltimo(dtoMovBanc.getOidSubprocesoMarcaCreacion());
               }

               dtoMovBanc.setOidTipoAbonoUltimo(dtoMovBanc.getOidTipoAbonoCreacion());

               // Generamos la cabecera en el primer registro del lote
               if (h == 0){
                  // Creamos una CabeceraCargosAbonosDirectos por cada numeroLote
                  // Obtenemos una referencia a la interfaz Home del Entity: CabeceraCargosAbonosDirectos
                  // Invocamos al método create() pasándole los parámetros:
                  String codigoUsuario = ctx.getCallerPrincipal().getName();
                  DTOBelcorp dtoBelcorp = new DTOBelcorp();

                  dtoBelcorp.setOidPais(dto.getOidPais());
                  dtoBelcorp.setOidIdioma(dto.getOidIdioma());
                  numero = daoCCC.obtenerSecuenciaPais(dtoBelcorp);

                  Date fechaActual = new Date(System.currentTimeMillis());
                  Long empresa = new Long(((BigDecimal) rs.getValueAt(0, "SOCI_OID_SOCI")).longValue());
                  StringBuffer insertCabecera = new StringBuffer();

                  oidCabecera = SecuenciadorOID.obtenerSiguienteValor("CCC_CCAD_SEQ");
                  numeroCabecera = numero;
                  insertCabecera.append("INSERT INTO CCC_CABEC_CARGA_ABONO_DIREC ");
                  insertCabecera.append("(OID_CABE_CARG,");
                  insertCabecera.append("NUM_CABE,");
                  insertCabecera.append("ANIO,");
                  insertCabecera.append("VAL_PERI_MES,");
                  insertCabecera.append("FEC_DOCU,");
                  insertCabecera.append("PAIS_OID_PAIS,");
                  insertCabecera.append("SOCI_OID_SOCI,");
                  insertCabecera.append("COD_USUA,");
                  insertCabecera.append("FEC_VALO,");
                  insertCabecera.append("CCPR_OID_PROC,");
                  insertCabecera.append("SBAC_OID_SBAC,");
                  insertCabecera.append("CCBA_OID_CUEN_CORR_BANC,");
                  insertCabecera.append("VAL_OBSE) VALUES (");
                  insertCabecera.append(oidCabecera).append(",");
                  insertCabecera.append(numeroCabecera).append(",");
                  insertCabecera.append("'").append(anio).append("',");
                  insertCabecera.append("'").append(periodoMes).append("',");
                  insertCabecera.append("TO_DATE('").append(formato.format(fechaActual)).append("','DD/MM/YYYY'),");
                  insertCabecera.append(dto.getOidPais()).append(",");
                  insertCabecera.append(empresa).append(",");
                  insertCabecera.append("'").append(codigoUsuario).append("',");
                  insertCabecera.append("TO_DATE('").append(formato.format(fechaActual)).append("','DD/MM/YYYY'),");
                  insertCabecera.append(oidProceso).append(",");

                  if (dtoMovBanc.getSubacceso() != null){
                     insertCabecera.append(dtoMovBanc.getSubacceso()).append(",");
                  }else{
                     insertCabecera.append("null,");
                  }

                  if (dtoMovBanc.getCuentaCorrienteBancaria() != null){
                     insertCabecera.append(dtoMovBanc.getCuentaCorrienteBancaria()).append(",");
                  }else{
                     insertCabecera.append("null,");
                  }

                  if (dto.getNumerosLote()[i] != null){
                     insertCabecera.append("'").append((dto.getNumerosLote()[i]).toString()).append("')");
                  }else{
                     insertCabecera.append("null)");
                  }

                  try{
                     BelcorpService.getInstance().dbService.executeUpdate(insertCabecera.toString());
                  }catch (Exception e){
                     UtilidadesLog.warn("- GA - String erroneo(0): " + insertCabecera.toString());
                     throw new MareException(e);
                  }

                  InsertDetalleCargoAbono = new StringBuffer();
                  cadenaUpdateBancos = new StringBuffer();
                  cadenaUpdateBancos.append("UPDATE CCC_MOVIM_BANCA SET ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_ANIO = '" + anio + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_ANIO = '" + anio + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_MES_SERI = '" + periodoMes + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_MES_SERI = '" + periodoMes + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_NUME = " + numeroCabecera + ", ");    // cabecera de cargos y abonos
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_NUME = " + numeroCabecera + " ");     // cabecera de cargos y abonos
                  cadenaUpdateBancos.append("WHERE OID_MOVI_BANC IN( ");
               }                                                                                 // end if (h == 0)

               // Agregado de Gacevedo
               // Se actualiza el movimiento bancario con la referencia al cargo y abono
               dtoMovBanc.setAnioDocumentoAplicacion(anio);
               dtoMovBanc.setAnioDocumentoCreacion(anio);
               dtoMovBanc.setNumeroDocumentoCreacion(numeroCabecera);      // cabecera de cargos y abonos
               dtoMovBanc.setNumeroDocumentoAplicacion(numeroCabecera);    // cabecera de cargos y abonos
               dtoMovBanc.setSerieDocumentoAplicacion(periodoMes);
               dtoMovBanc.setSerieDocumentoCreacion(periodoMes);
               // ak se arma el IN
               cadenaUpdateBancos.append(dtoMovBanc.getOid());
               cadenaUpdateBancos.append(",");

               Integer numeroLineaInt = new Integer(++numeroLinea);

               UtilidadesLog.debug("-GA- Numero de linea del detalle de cargos y abonos: " + numeroLineaInt.toString());
               InsertDetalleCargoAbono.append("INSERT INTO CCC_DETAL_CARGO_ABONO_DIREC (");
               InsertDetalleCargoAbono.append("OID_DETA_CARG_ABON_DIRE,CCAD_OID_CABE_CARG,");
               InsertDetalleCargoAbono.append("NUM_LINE,COD_USUA,SOCI_OID_SOCI,TASP_OID_TIPO_ABON_SUBP,");
               InsertDetalleCargoAbono.append("CUCO_OID_CUEN_CONT_CUOT_NUEV,CUCO_OID_CUEN_CONT_CUOT_ANTE,");
               InsertDetalleCargoAbono.append("CMBA_OID_MOVI_BANC,CLIE_OID_CLIE,FEC_MOVI,");
               InsertDetalleCargoAbono.append("IMP,NUM_HIST_GENE,FEC_PAGO_BANC,IMP_MONE,CCBA_OID_CUEN_CORR_BANC");
               InsertDetalleCargoAbono.append(") VALUES (");
               InsertDetalleCargoAbono.append("CCC_DCAD_SEQ.NEXTVAL,").append(oidCabecera).append(",");
               InsertDetalleCargoAbono.append(numeroLineaInt).append(",");
               InsertDetalleCargoAbono.append("'").append(usuario).append("',");
               InsertDetalleCargoAbono.append(new Long(((BigDecimal) rs.getValueAt(h, "SOCI_OID_SOCI")).longValue())).append(",");
               InsertDetalleCargoAbono.append(tiposAbonoSubprocesoLocal.getOid()).append(",");
               InsertDetalleCargoAbono.append(cero).append(",");
               InsertDetalleCargoAbono.append(cero).append(",");
               InsertDetalleCargoAbono.append(dtoMovBanc.getOid()).append(",");
               InsertDetalleCargoAbono.append(dtoMovBanc.getOidConsultoraReal()).append(",");
               InsertDetalleCargoAbono.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'),");
               InsertDetalleCargoAbono.append(dtoMovBanc.getImportePago()).append(",");
               InsertDetalleCargoAbono.append("0,");
               InsertDetalleCargoAbono.append("TO_DATE('").append(formato.format(dtoMovBanc.getFechaPago())).append("','DD/MM/YYYY'),");
               InsertDetalleCargoAbono.append("0,");
               InsertDetalleCargoAbono.append(dtoMovBanc.getCuentaCorrienteBancaria()).append(");");
               // Validaciones
               dtoMovBanc.setCodError(validar(dtoMovBanc, pais.getInd_sald_unic()));

               if (!dtoMovBanc.getCodError().equals("00")){      // Si hay error
                  dtoMovBanc.setOidError(daoRecaudoEntFin.obtenerOidError(dtoMovBanc.getCodError()));

                  if (dtoMovBanc.getCodError().equals("04")){    // segun incidencia DBLG70000242 Gacevedo.
                     dtoMovBanc.setIdentificadorProceso("P");
                     // LogAPP.info("El movimiento bancario "+dtoMovBanc.getOid() +" esta pagando una suma superior a lo adeudado.");
                  }else{
                     dtoMovBanc.setIdentificadorProceso("I");
                  }
               }else{
                  dtoMovBanc.setIdentificadorProceso("P");
               }

               if (!rs.getValueAt(h, "COD_TIPO_TRAN_CHEQ").toString().equalsIgnoreCase("C") && dtoMovBanc.getIdentificadorProceso().equals("P")
                       && (dtoMovBanc.getCodError().equals("00") || dtoMovBanc.getCodError().equals("04"))){
                  if (dtoMovBanc.getImporteSaldo().doubleValue() > 0){
                     movimientosAProcesar.add(dtoMovBanc);
                  }
               }

               updateBancos.append(this.actualizarMovimientoBancario(dtoMovBanc));

               if ((h > 0) && (h % 50) == 0){                                                    
               // grabamos cada 50 registros porque se pueden procesar hast 8000 por lote.
                  this.grabarMovBancario(updateBancos);
                  updateBancos = new StringBuffer();

                  if (cadenaUpdateBancos.toString().endsWith(",")){
                     cadenaUpdateBancos.delete(cadenaUpdateBancos.length() - 1, cadenaUpdateBancos.length());
                     cadenaUpdateBancos.append(");");
                     cadenaUpdateBancos.append(InsertDetalleCargoAbono);
                      try{
                         BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", cadenaUpdateBancos.toString());
                         // UtilidadesLog.warn("- GA - Ejecucion de insert(1): "+((System.currentTimeMillis()-a)/1000)+" segundos.");
                      }catch (Exception e){
                         UtilidadesLog.warn("- GA - String erroneo: " + cadenaUpdateBancos.toString());
                         throw new MareException(e);
                      }
                  }
                  InsertDetalleCargoAbono = new StringBuffer();
                  cadenaUpdateBancos = new StringBuffer();
                  cadenaUpdateBancos.append("UPDATE CCC_MOVIM_BANCA SET ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_ANIO = '" + anio + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_ANIO = '" + anio + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_MES_SERI = '" + periodoMes + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_MES_SERI = '" + periodoMes + "', ");
                  cadenaUpdateBancos.append("VAL_DOCU_APLI_NUME = " + numeroCabecera + ", ");    // cabecera de cargos y abonos
                  cadenaUpdateBancos.append("VAL_DOCU_CREA_NUME = " + numeroCabecera + " ");     // cabecera de cargos y abonos
                  cadenaUpdateBancos.append("WHERE OID_MOVI_BANC IN( ");
               }
            }                                                                                    // end for de cada numeroLote

           if (cadenaUpdateBancos.toString().endsWith(",")){//si tiene coma es que al menos un oid tiene
              cadenaUpdateBancos.delete(cadenaUpdateBancos.length() - 1, cadenaUpdateBancos.length());
              cadenaUpdateBancos.append(");");
              cadenaUpdateBancos.append(InsertDetalleCargoAbono);
               try{
                  BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", cadenaUpdateBancos.toString());
               }catch (Exception e){
                  UtilidadesLog.warn("- GA - String Erroneo(2): " + cadenaUpdateBancos.toString());
                  throw new MareException(e);
               }
           }
           if (updateBancos.length() > 0){
              this.grabarMovBancario(updateBancos);
              //updateBancos = new StringBuffer();
           }
         }// end for de numerosLote agrupados

         if (movimientosAProcesar.size() > 0){
            // Obtenemos la interface Home (home) del Entity Pais.
            DTOMovBancIndicadores dtoIndic = new DTOMovBancIndicadores();
            DTOMovimientoBancario[] movsProcesar = new DTOMovimientoBancario[movimientosAProcesar.size()];

            for (int i = 0; i < movimientosAProcesar.size(); i++){
               movsProcesar[i] = (DTOMovimientoBancario) movimientosAProcesar.get(i);
            }

            // UtilidadesLog.warn("- GA - armado Array: "+((System.currentTimeMillis()-a)/1000)+" segundos.");
            dtoIndic.setDtoMovimientosBancarios(movsProcesar);

            if (pais.getInd_sald_unic().longValue() == 1){
               dtoIndic.setIndicadorSaldoUnico(Boolean.TRUE);
            }else{
               dtoIndic.setIndicadorSaldoUnico(Boolean.FALSE);
            }

            dtoIndic.setIndicadorSimulacion(Boolean.FALSE);
            dtoIndic.setOidPais(dto.getOidPais());
            dtoIndic.setOidIdioma(dto.getOidIdioma());
            // Incidencias 9971,10001,10002,9966,9959 y sobre todo 10432
            UtilidadesLog.debug("voy a: ActualizarCCporAplicacion");
            getMONActualizarCCporAplicacion().procesarMovBancporAplicacion(dtoIndic);
            UtilidadesLog.debug("voy a salir de: ActualizarCCporAplicacion");
         }
      }catch (NoResultException fe){
         ctx.setRollbackOnly();   
         this.logearError(fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }catch (RemoteException re){
         this.logearError(re);

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      }catch (NamingException ne){
         this.logearError(ne);

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(ne, UtilidadesError.armarCodigoError(codigoError));
      }catch (Exception ex){
         ex.printStackTrace();

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }finally{
         try{
            new DAOCCC().eliminarBloqueo();
            /*ArrayList dummy = new ArrayList();
            dummy.add(new String(""));
            BelcorpService.getInstance().dbService.executeProcedure("pq_apl_aux.Borrar_Bloqueo_CCC",dummy);*/
         }catch (Exception e){
            e.printStackTrace();
         }
      }

      UtilidadesLog.warn("- GA - FIN DE PROCESO DE CONFIRMACION DE MOVIMIENTOS BANCARIOS : " + ((System.currentTimeMillis() - inicio) / 1000) + " SEGUNDOS TOTAL.");
      UtilidadesLog.info("MONRecaudoEntFinBean.confirmarMovBanc(DTONumerosLote dto): Salida");
   }

   /**
    * Método para obtener los detalles de movimientos Bancarios
    * @param dto DTONumeroLote
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron registros
    */
   public DTOSalida detalleMovBanc(DTONumeroLote dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.detalleMovBanc(DTONumeroLote dto): Entrada");

      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.detalleMovBanc(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.detalleMovBanc(DTONumeroLote): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.detalleMovBanc(DTONumeroLote dto): Salida");
      return dtoS;
   }

   /**
    * Método para obtener los registros que cumplen
    * los criterios de busqueda determinados en el parámetro de entrada
    * @param dto DTOBuscarConfirmarMovBanc con los criterios de busqueda
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron datos que cumplieran los criterios de busqueda
    */
   public DTOSalida buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto): Entrada");
       
      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.buscarMovBancConfirmar(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.buscarMovBancConfirmar(dto): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto): Salida");
      return dtoS;
   }

   /**
    * Método para validar un movimiento bancario    
    * @return String con el codigo de error
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontró el registro  a validar
    */
   private String validar(DTOMovimientoBancario dtoMovBanc, Long indicadorSaldoUnico) throws MareException{
      // Validaciones
      UtilidadesLog.info("MONRecaudoEntFinBean.validar(DTOMovimientoBancario dtoMovBanc): Entrada");

      // El Cliente no existe en el sistema - Error 01
      // Segun modificacion pedida por incidencia V-CCC036
      if (dtoMovBanc.getOidConsultoraReal() == null){
         return CCCConstantes.TIPOERROR_CLIENTE_NO_EXISTE;
      }

      Date fechaFactura = null;
      DAORecaudoEntFin dao = new DAORecaudoEntFin();    // poner usuario // no es necesario por incidencia 9844

      // Número factura no existe o es nulo - Error 03
      if (indicadorSaldoUnico.longValue() == 0){    // Si no va por Saldo Unico
         DTOBuscarMovCCConfirmar dtoBMovCCC = new DTOBuscarMovCCConfirmar();
         // dtoBMovCCC.setNumeroIdentCuota();
         // dtoBMovCCC.setoidCliente();
         // Se puede pasar el dto vacio
         DTOSalida dtoS = dao.buscarMovCCConfirmar(dtoBMovCCC);

         if (!dtoS.getResultado().esVacio()){
            fechaFactura = (java.sql.Date) dtoS.getResultado().getValueAt(0, "FEC_DOCU");    // Tomamos la fecha del primer registro
         }else{
            UtilidadesLog.debug("****Metodo  MONRecaudoEntFin.validar: Salida");
            return CCCConstantes.TIPOERROR_NUMFAC_NOEXISTE_ANULADO;
         }

         // La fecha de la factura es posterior a la de pago - Error 02
         if ((fechaFactura != null) && (dtoMovBanc.getFechaPago() != null) && fechaFactura.after(dtoMovBanc.getFechaPago())){
            UtilidadesLog.debug("****Metodo  MONRecaudoEntFin.validar: Salida");
            return CCCConstantes.TIPOERROR_FECFACTURA_POSTERIORPAGO;
         }
      }

      // Importe superior deuda - Error 04
      DTOSaldosPorFechasyVtos dtoSaldos = new DTOSaldosPorFechasyVtos();

      dtoSaldos.setOidCliente(dtoMovBanc.getOidConsultoraReal());
      dtoSaldos.setOidPais(dtoMovBanc.getOidPais());

      try{
         DTOTotal dtoTotal = this.getMONInterfaceModulos().calcularSaldoCCCliente(dtoSaldos);

         UtilidadesLog.debug("- GA - dtoMovBanc.getOidConsultoraReal(): " + dtoMovBanc.getOidConsultoraReal());
         UtilidadesLog.debug("- GA - dtoTotal.getTotal(): " + dtoTotal.getTotal());
         UtilidadesLog.debug("- GA - dtoMovBanc.getImportePago(): " + dtoMovBanc.getImportePago());

         if ((dtoTotal.getTotal() != null) && (dtoMovBanc.getImportePago() != null) && (dtoTotal.getTotal().doubleValue() < dtoMovBanc.getImportePago().doubleValue())){
            UtilidadesLog.debug("****Metodo  MONRecaudoEntFin.validar: Salida");
            return CCCConstantes.TIPOERROR_IMPORTE_SUPERIOR_DEUDA;
         }else{
            UtilidadesLog.debug("- GA - Importe de pago no superior a la deuda");
         }
      }catch (RemoteException e){
         ctx.setRollbackOnly();

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         this.logearError(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.validar(DTOMovimientoBancario dtoMovBanc): Salida");
      return CCCConstantes.TIPOERROR_NO_ERROR;    // Sin errores
   }

   /**
    * Método para obtener los registros que cumplen
    * los criterios de busqueda determinados en el parámetro de entrada
    * @param dto DTOCancelarCupon3 con los criterios de busqueda
    * @return DTOSalida con los registros encontrados
    * @exception MareException si no se pudo acceder a la base de datos o no se
    * encontraron datos que cumplieran los criterios de busqueda
    */
   public DTOSalida consultarCupon3(DTOCancelarCupon3 dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOCancelarCupon3 dto): Entrada");

      RecordSet rs = new RecordSet();
      DAORecaudoEntFin daoRecaudoEntFin = new DAORecaudoEntFin();
      DTOSalida dtoS = new DTOSalida();

      dtoS = daoRecaudoEntFin.consultarCupon3(dto);
      rs = dtoS.getResultado();

      if (rs.esVacio()){
         // GEN-0007 --> 005
         UtilidadesLog.debug("****DAORecaudoEntFin.consultarCupon3(dto): No hay datos ");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.consultarCupon3(DTOCancelarCupon3 dto): Salida");
      return dtoS;
   }

   /**
    * @param dto DTONumerosLote
    * @return void
    * @exception MareException
    */
   public void simularMovBanc(DTONumerosLote dto) throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.simularMovBanc(DTONumerosLote dto): Entrada");

      ArrayList movimientosAProcesar = new ArrayList();
      RecordSet rs = null;
      DTOSalida dtoS = null;
      String usuario = ctx.getCallerPrincipal().getName();
      DAOCuentasCorrientes dao = new DAOCuentasCorrientes(usuario);
      DTOMovimientoBancario dtoMovBanc = null;

      // Cada numeroLote puede corresponderse con varios registros (agrupados)
      for (int i = 0; i < dto.getNumerosLote().length; i++){
         // Localizamos los registros correspondientes al numeroLote ( dto.numerosLote[i] )
         DTONumeroLote dtoLote = new DTONumeroLote();

         dtoLote.setNumeroLote(dto.getNumerosLote()[i]);
         dtoS = dao.movBancPorNumLote(dtoLote);
         rs = dtoS.getResultado();

         for (int h = 0; h < rs.getRowCount(); h++){
            // Creamos un DTOMovimientoBancario (dtoMovBanc) con el dtoS.recordset[h];
            dtoMovBanc = new DTOMovimientoBancario();

            if (rs.getValueAt(h, "VAL_DOCU_APLI_ANIO") != null){
               dtoMovBanc.setAnioDocumentoAplicacion((String) rs.getValueAt(h, "VAL_DOCU_APLI_ANIO"));
            }

            if (rs.getValueAt(h, "VAL_DOCU_CREA_ANIO") != null){
               dtoMovBanc.setAnioDocumentoCreacion((String) rs.getValueAt(h, "VAL_DOCU_CREA_ANIO"));
            }

            if (rs.getValueAt(h, "COD_CONS") != null){
               dtoMovBanc.setCodConsultoraReal((String) rs.getValueAt(h, "COD_CONS"));
            }

            if (rs.getValueAt(h, "COD_ERRO") != null){
               dtoMovBanc.setCodError((String) rs.getValueAt(h, "COD_ERRO"));
            }

            if (rs.getValueAt(h, "NUM_CONS_TRAN") != null){
               dtoMovBanc.setConsecutivoTransaccion(new Long(rs.getValueAt(h, "NUM_CONS_TRAN").toString()));
            }

            if (rs.getValueAt(h, "CCAB_OID_CC_BANC") != null){
               dtoMovBanc.setCuentaCorrienteBancaria(new Long(rs.getValueAt(h, "CCAB_OID_CC_BANC").toString()));
            }

            if (rs.getValueAt(h, "VAL_DIGI_CHEQ_FACT") != null){
               dtoMovBanc.setDigitoChequeo(new Integer(rs.getValueAt(h, "VAL_DIGI_CHEQ_FACT").toString()));
            }

            if (rs.getValueAt(h, "SOCI_OID_SOCI") != null){
               dtoMovBanc.setEmpresa(new Long(rs.getValueAt(h, "SOCI_OID_SOCI").toString()));
            }

            if (rs.getValueAt(h, "VAL_ESTA_MOVI_PEND") != null){
               dtoMovBanc.setEstatusMovimientoTesoreria(new Character(rs.getValueAt(h, "VAL_ESTA_MOVI_PEND").toString().charAt(0)));
            }

            if (rs.getValueAt(h, "FEC_CONT") != null){
               dtoMovBanc.setFechaContabilizacion((Date) rs.getValueAt(h, "FEC_CONT"));
            }

            if (rs.getValueAt(h, "FEC_MOVI_APLI") != null){
               dtoMovBanc.setFechaMovimientoAplicacion((Date) rs.getValueAt(h, "FEC_MOVI_APLI"));
            }

            if (rs.getValueAt(h, "FEC_PAGO") != null){
               dtoMovBanc.setFechaPago((Date) rs.getValueAt(h, "FEC_PAGO"));
            }

            if (rs.getValueAt(h, "VAL_HORA_NORM_ADIC") != null){
               dtoMovBanc.setHorario((String) rs.getValueAt(h, "VAL_HORA_NORM_ADIC"));
            }

            if (rs.getValueAt(h, "COD_IDEN_PROC") != null){
               dtoMovBanc.setIdentificadorProceso((String) rs.getValueAt(h, "COD_IDEN_PROC"));
            }

            if (rs.getValueAt(h, "IMP_PAGO") != null){
               dtoMovBanc.setImportePago((BigDecimal) rs.getValueAt(h, "IMP_PAGO"));
            }

            if (rs.getValueAt(h, "VAL_NOMB_OFIC") != null){
               dtoMovBanc.setNombreOficina((String) rs.getValueAt(h, "VAL_NOMB_OFIC"));
            }

            if (rs.getValueAt(h, "NUM_CUPO") != null){
               dtoMovBanc.setNumeroCupon(new Long(rs.getValueAt(h, "NUM_CUPO").toString()));
            }

            if (rs.getValueAt(h, "VAL_DOCU_APLI_NUME") != null){
               dtoMovBanc.setNumeroDocumentoAplicacion(new Integer(rs.getValueAt(h, "VAL_DOCU_APLI_NUME").toString()));
            }

            if (rs.getValueAt(h, "VAL_DOCU_CREA_NUME") != null){
               dtoMovBanc.setNumeroDocumentoCreacion(new Integer(rs.getValueAt(h, "VAL_DOCU_CREA_NUME").toString()));
            }

            if (rs.getValueAt(h, "NUM_FACT_BOLE") != null){
               dtoMovBanc.setNumeroFactura(new Long(rs.getValueAt(h, "NUM_FACT_BOLE").toString()));
            }

            if (rs.getValueAt(h, "NUM_LOTE") != null){
               dtoMovBanc.setNumeroLote(new Long(rs.getValueAt(h, "NUM_LOTE").toString()));
            }

            if (rs.getValueAt(h, "VAL_NUME_LOTE_CONT") != null){
               dtoMovBanc.setNumeroLoteContabilizacion((String) rs.getValueAt(h, "VAL_NUME_LOTE_CONT"));
            }

            if (rs.getValueAt(h, "VAL_OBSE") != null){
               dtoMovBanc.setObservaciones((String) rs.getValueAt(h, "VAL_OBSE"));
            }

            if (rs.getValueAt(h, "COD_OFIC_RECA") != null){
               dtoMovBanc.setOficinaRecaudadora((String) rs.getValueAt(h, "COD_OFIC_RECA"));
            }

            if (rs.getValueAt(h, "OID_MOVI_BANC") != null){
               dtoMovBanc.setOid(new Long(rs.getValueAt(h, "OID_MOVI_BANC").toString()));
            }

            if (rs.getValueAt(h, "VAL_DOCU_APLI_MES_SERI") != null){
               dtoMovBanc.setSerieDocumentoAplicacion((String) rs.getValueAt(h, "VAL_DOCU_APLI_MES_SERI"));
            }

            if (rs.getValueAt(h, "VAL_DOCU_CREA_MES_SERI") != null){
               dtoMovBanc.setSerieDocumentoCreacion((String) rs.getValueAt(h, "VAL_DOCU_CREA_MES_SERI"));
            }

            if (rs.getValueAt(h, "TTRA_OID_TIPO_TRANS") != null){
               dtoMovBanc.setTipoTransaccion(new Long(rs.getValueAt(h, "TTRA_OID_TIPO_TRANS").toString()));
            }

            if (rs.getValueAt(h, "VAL_USUA_PROC") != null){
               dtoMovBanc.setUsuarioProceso((String) rs.getValueAt(h, "VAL_USUA_PROC"));
            }

            // En la inc BELC300019677 nos hace dar cuenta que hace falta setearle el pais
            if (rs.getValueAt(h, "PAIS_OID_PAIS") != null){
               dtoMovBanc.setOidPais(new Long(rs.getValueAt(h, "PAIS_OID_PAIS").toString()));
            }

            if (rs.getValueAt(h, "CLIE_OID_CLIE") != null){
               dtoMovBanc.setOidConsultoraReal(new Long(rs.getValueAt(h, "CLIE_OID_CLIE").toString()));
            }

            movimientosAProcesar.add(dtoMovBanc);
         }
      }

      // Obtenemos la interface Home (home) del Entity Pais.
      PaisLocalHome plh = this.getPaisLocalHome();
      PaisLocal pais = null;

      try{
         pais = plh.findByPrimaryKey(dto.getOidPais());
      }catch (NoResultException fe){
         ctx.setRollbackOnly();

         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;

         UtilidadesLog.error("simularMovBanc: FinderException", fe);
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }

      DTOMovBancIndicadores dtoMovBancIndicadores = new DTOMovBancIndicadores();
      DTOMovimientoBancario[] movsProcesar = new DTOMovimientoBancario[movimientosAProcesar.size()];

      for (int i = 0; i < movimientosAProcesar.size(); i++){
         movsProcesar[i] = (DTOMovimientoBancario) movimientosAProcesar.get(i);
      }

      dtoMovBancIndicadores.setDtoMovimientosBancarios(movsProcesar);
      dtoMovBancIndicadores.setIndicadorSaldoUnico(Boolean.valueOf((pais.getInd_sald_unic().longValue() == 1) ? true
              : false));
      dtoMovBancIndicadores.setIndicadorSimulacion(Boolean.valueOf(true));
      dtoMovBancIndicadores.setOidPais(dto.getOidPais());
      dtoMovBancIndicadores.setOidIdioma(dto.getOidIdioma());

      MONActualizarCCporAplicacion monActualizarCCporAplicacion = this.getMONActualizarCCporAplicacion();

      try{
         monActualizarCCporAplicacion.procesarMovBancporAplicacion(dtoMovBancIndicadores);
      }catch (RemoteException re){
         ctx.setRollbackOnly();

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         this.logearError(re);
         throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.simularMovBanc(DTONumerosLote dto): Salida");
   }

   private SituacionCuponesLocalHome getSituacionCuponesLocalHome() throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.getSituacionCuponesLocalHome(): Entrada");
      UtilidadesLog.info("MONRecaudoEntFinBean.getSituacionCuponesLocalHome(): Salida");
      return new SituacionCuponesLocalHome();
   }

   private DetalleCuponesTramiteDepuracionLocalHome getDetalleCuponesTramiteDepuracionLocalHome() throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.getDetalleCuponesTramiteDepuracionLocalHome(): Entrada");
      UtilidadesLog.info("MONRecaudoEntFinBean.getDetalleCuponesTramiteDepuracionLocalHome(): Salida");
      return new DetalleCuponesTramiteDepuracionLocalHome();
   }

   private PaisLocalHome getPaisLocalHome() throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.getPaisLocalHome(): Entrada");
      UtilidadesLog.info("MONRecaudoEntFinBean.getPaisLocalHome(): Salida");
      return new PaisLocalHome();
   }

   private MONInterfaceModulos getMONInterfaceModulos() throws MareException{
      // Se obtiene el interfaz home
      UtilidadesLog.info("MONRecaudoEntFinBean.getMONInterfaceModulos(): Entrada");

      MONInterfaceModulosHome home = (MONInterfaceModulosHome) UtilidadesEJB.getHome("MONInterfaceModulos", MONInterfaceModulosHome.class);
      // Se obtiene el interfaz remoto
      MONInterfaceModulos ejb = null;

      try{
         ejb = home.create();
      }catch (Exception e){
         this.logearError(e);

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.getMONInterfaceModulos(): Salida");
      return ejb;
   }

   private MovimientosBancariosLocalHome getMovimientosBancariosLocalHome() throws MareException{//BMP
      UtilidadesLog.info("MONRecaudoEntFinBean.getMovimientosBancariosLocalHome(): Entrada");

      MovimientosBancariosLocalHome movBancLocalHome = (MovimientosBancariosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MovimientosBancarios");

      UtilidadesLog.info("MONRecaudoEntFinBean.getMovimientosBancariosLocalHome(): Salida");
      return movBancLocalHome;
   }

   private HistoricoMovimientosBancLocalHome getHistoricoMovimientosBancLocalHome() throws MareException{//BMP
      UtilidadesLog.info("MONRecaudoEntFinBean.getHistoricoMovimientosBancLocalHome(): Entrada");

      HistoricoMovimientosBancLocalHome histMovBancLocalHome = (HistoricoMovimientosBancLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/HistoricoMovimientosBanc");

      UtilidadesLog.info("MONRecaudoEntFinBean.getHistoricoMovimientosBancLocalHome(): Salida");
      return histMovBancLocalHome;
   }

   private CopiaMovimientoBancarioLocalHome getCopiaMovimientoBancarioLocalHome() throws MareException{//BMP
      UtilidadesLog.info("MONRecaudoEntFinBean.getCopiaMovimientoBancarioLocalHome(): Entrada");

      CopiaMovimientoBancarioLocalHome home = (CopiaMovimientoBancarioLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/CopiaMovimientoBancario");

      UtilidadesLog.info("MONRecaudoEntFinBean.getCopiaMovimientoBancarioLocalHome(): Salida");
      return home;
   }

   private void logearError(Throwable e){
      // mensaje: nombreMetodo: tipoExcepcion
      UtilidadesLog.error(e);
   }

   /**
    * Método para obtener el día, el mes  y el año del sistema
    */
   private String[] obtenerAnioMesDiaDelSistema(){
      UtilidadesLog.info("MONRecaudoEntFinBean.obtenerAnioMesDiaDelSistema(): Entrada");

      String fecha[] = new String[3];
      // Obtenemos la fecha en formato aaaa-mm-dd
      Date fechaSql = new Date(System.currentTimeMillis());
      StringTokenizer st = new StringTokenizer(fechaSql.toString(), "-");

      if (st.countTokens() > 0){
         String anio = st.nextToken().toString();

         fecha[0] = anio;

         String mes = st.nextToken().toString();

         fecha[1] = mes;

         String dia = st.nextToken().toString();

         fecha[2] = dia;
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.obtenerAnioMesDiaDelSistema(): Salida");
      return fecha;
   }

   private MONActualizarCCporAplicacion getMONActualizarCCporAplicacion() throws MareException{
      // Se obtiene el interfaz home
      UtilidadesLog.info("MONRecaudoEntFinBean.getMONActualizarCCporAplicacion(): Entrada");

      MONActualizarCCporAplicacionHome home = (MONActualizarCCporAplicacionHome) UtilidadesEJB.getHome("MONActualizarCCporAplicacion", MONActualizarCCporAplicacionHome.class);
      // Se obtiene el interfaz remoto
      MONActualizarCCporAplicacion ejb = null;

      try{
         ejb = home.create();
      }catch (Exception e){
         this.logearError(e);

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.getMONActualizarCCporAplicacion(): Salida");
      return ejb;
   }

   private MONValidacion getMONValidacion() throws MareException{
      UtilidadesLog.info("MONRecaudoEntFinBean.getMONValidacion(): Entrada");

      // Se obtiene el interfaz home
      MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion", MONValidacionHome.class);
      // Se obtiene el interfaz remoto
      MONValidacion ejb = null;

      try{
         ejb = home.create();
      }catch (Exception e){
         this.logearError(e);

         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;

         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      UtilidadesLog.info("MONRecaudoEntFinBean.getMONValidacion(): Salida");
      return ejb;
   }

   // Validaciones
   private void validaAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
           throws MareException{
      UtilidadesLog.info(
          "MONRecaudoEntFinBean.validaAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

      MONValidacion monValidacion = this.getMONValidacion();
      Boolean b = Boolean.valueOf(true);

      UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad + ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = " + subacceso
                          + ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" + zona + ", seccion=" + seccion + ", territorio=" + territorio);

      try{
         b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio);
      }catch (RemoteException rExc){
         ctx.setRollbackOnly();
         this.logearError(rExc);
         UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

      if (!b.booleanValue()){
         ctx.setRollbackOnly();
         UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
      }

      UtilidadesLog.info(
          "MONRecaudoEntFinBean.validaAccesos(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
   }

   private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() {
      return new TiposAbonoSubprocesoLocalHome();
   }

   private StringBuffer actualizarMovimientoBancario(DTOMovimientoBancario dtoMovBanc) throws MareException{
      StringBuffer cadena = new StringBuffer();

      cadena.append("UPDATE CCC_MOVIM_BANCA SET COD_IDEN_PROC = '" + dtoMovBanc.getIdentificadorProceso() + "'");
      cadena.append(", COD_ERRO = '" + dtoMovBanc.getCodError() + "'");
      cadena.append(", TIER_OID_ERRO = " + dtoMovBanc.getOidError());
      cadena.append(" WHERE OID_MOVI_BANC = " + dtoMovBanc.getOid() + ";");
      return cadena;
   }

   private void grabarMovBancario(StringBuffer query) throws MareException{
      BelcorpService bs = BelcorpService.getInstance();

      try{
         bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
      }catch (Exception e){
         ctx.setRollbackOnly();
         UtilidadesLog.error("Error en grabarMovBancario ", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
   }

   public void BloquearLote(Long numeroLote) throws MareException{
      // este metodo se usa para marcar el lote como procesado,
      // agregandolo a la tabla ccc_num_lote_proc, si el insert falla
      // el lote ya fue procesado con anterioridad.
      StringBuffer buff = new StringBuffer();

      buff.append("INSERT INTO ccc_num_lote_proc(VAL_NUME_LOTE_FACT, FEC_proc) VALUES (");
      buff.append(numeroLote).append(",");

      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

      buff.append("TO_DATE('").append(formato.format(new java.util.Date())).append("','DD/MM/YYYY'))");

      try{
         BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
      }catch (Exception e){
         throw new MareException("No se pudo insertar el lote", e);
      }
   }

   private MONRecaudoEntFinLocalHome getMONRecaudoEntFinLocalHome() throws NamingException{
      final InitialContext context = new InitialContext();

      return (MONRecaudoEntFinLocalHome) context.lookup("java:comp/env/MONRecaudoEntFin");
   }

   private MONCuentasCorrientesLocalHome getMONCuentasCorrientesLocalHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONCuentasCorrientesLocalHome)context.lookup("java:comp/env/ejb/local/MONCuentasCorrientes");
   }
}
