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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOCargaPaginaMCD;
import es.indra.sicc.dtos.bel.DTOImporte;
import es.indra.sicc.dtos.bel.DTOImportesFisicos;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocalHome;
import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.entidades.bel.CajaLocalHome;
import es.indra.sicc.entidades.bel.CierreDeCajaCabeceraLocal;
import es.indra.sicc.entidades.bel.CierreDeCajaCabeceraLocalHome;
import es.indra.sicc.entidades.bel.CierreDeCajaDetalleLocal;
import es.indra.sicc.entidades.bel.CierreDeCajaDetalleLocalHome;
import es.indra.sicc.entidades.bel.MovimientosDeCajaCabeceraLocal;
import es.indra.sicc.entidades.bel.MovimientosDeCajaCabeceraLocalHome;
import es.indra.sicc.entidades.bel.MovimientosDeCajaDetalleLocal;
import es.indra.sicc.entidades.bel.MovimientosDeCajaDetalleLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.entidades.bel.MediosDePagoBelcenterLocal;
import es.indra.sicc.entidades.bel.MediosDePagoBelcenterLocalHome;
import es.indra.sicc.entidades.bel.MediosDePagoLocal;
import es.indra.sicc.entidades.bel.MediosDePagoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.logicanegocio.bel.DAOCajas;
import es.indra.sicc.logicanegocio.bel.DAOServicioBel;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

import es.indra.sicc.logicanegocio.bel.MONRegistroAbastecimiento;
import es.indra.sicc.logicanegocio.bel.MONRegistroAbastecimientoHome;
import es.indra.sicc.logicanegocio.bel.MONCambiosVentas;
import es.indra.sicc.logicanegocio.bel.MONCambiosVentasHome;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.*;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.bel.DTOMantenimientoCaja;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Sistema:           Belcorp
 * Modulo:            BEL
 * Submódulo:           
 * Componente:        MON's
 * Fecha:             08/11/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-BEL-201-374-N046
 *
 * @version           1.0
 * @autor             mdolce
 */

public class MONCajasBean implements SessionBean  {
    private SessionContext ctx;
    public void setSessionContext(SessionContext ctx) { this.ctx = ctx;  }
    public void ejbCreate() {   }
    public void ejbActivate() {   }
    public void ejbPassivate() {   }
    public void ejbRemove() {   }  

  /** 
   * Método para buscar Cajas
   * @param dto DTOOID con el subacceso por los que se filtrará la busqueda
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException
   * @author mdolce
   */
  public DTOSalida abrirCajasConsulta(DTOString dto) throws  MareException {
    UtilidadesLog.debug("MONCajasBean.abrirCajasConsulta(DTOString dto):Entrada");
    try{
       UtilidadesLog.debug("entro al metodo dde consultar cajas");       
       DTOSalida dtoSalida = new DTOSalida();
       
       MONServicioBELHome mSERVLH = this.getMONServicioBELHome();        
       MONServicioBEL     mSERVH  = mSERVLH.create();
       
       /**paso de un dto a otro porque son de dos path diferentes**/
       es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString dtoS = new  es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString();
       dtoS.setCadena(dto.getCadena());
       dtoS.setOidPais(dto.getOidPais());
       /***********************************************************/
           
       DAOCajas daoCajas = new DAOCajas();
       dtoSalida = daoCajas.abrirCajasConsulta( mSERVH.obtenerSubaccesoAsociado(dtoS));
       
       UtilidadesLog.debug("MONCajasBean.abrirCajasConsulta(DTOString dto):Salida");
       return dtoSalida;

   
    }catch (NamingException namingException) {
           UtilidadesLog.error(namingException);
          ctx.setRollbackOnly();
          throw new MareException(namingException,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ce) {
          UtilidadesLog.debug(ce);
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    } catch (RemoteException ne) {
          UtilidadesLog.error(ne);
          ctx.setRollbackOnly();
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
  }


  /** 
   * Método para abrir cajas
   * @param dto DTOOIDs con los oids de las cajas a abrir
   * @return void
   * @exception MareException 
   * @author mdolce
   */
  public void abrirCajas(DTOOIDs dto) throws MareException {
     UtilidadesLog.debug("MONCajasBean.abrirCajas(DTOOIDs dto):Entrada");
     Long[] array = dto.getOids();
     UtilidadesLog.debug("**************entro al metodo de abrir cajas");

     try{
       for (int i = 0; i < array.length; i++) {
          UtilidadesLog.debug("*******************dentro del for");
          CajaLocalHome cLH = this.getCajaLocalHome();
          CajaLocal     cL  = cLH.findByPrimaryKey(array[i]);
          cL.setEstadoCaja(ConstantesBEL.CAJA_ABIERTA);
          cL.setFechaCierre(null);
          cLH.merge(cL);
       }
     }catch(NoResultException fex) {
          UtilidadesLog.error(fex);
          ctx.setRollbackOnly();
          throw new MareException(fex,
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }  catch (PersistenceException ce) {   
         UtilidadesLog.error("ERROR ", ce);
         throw new MareException(ce, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
     }
     UtilidadesLog.debug("MONCajasBean.abrirCajas(DTOOIDs dto):Salida");
  }


    /**
     * Obtiene los datos de una caja segun la maquina asociada. 
     * @param DTOString con la ipCliente
     * @return DTOCaja
     * @exception MareException 
     * @author gdmarzi
     */
    public DTOCaja obtenerDatosCaja(DTOString dto) throws MareException {
        UtilidadesLog.debug("MONCajasBean.obtenerDatosCaja(DTOString dto):Entrada");
        DTOCaja caja;        
        try {
            // -> Llamar al método "findByUK(maquina : String)" de la entidad "AsociacionMaquinaCaja" 
            UtilidadesLog.debug("dto : " + dto);
            AsociacionMaquinaCajaLocalHome asociacionMaquinaCajaLocalHome = this.getAsociacionMaquinaCajaLocalHome();
            UtilidadesLog.debug("Antes de findByUK" );
            AsociacionMaquinaCajaLocal asociacionMaquinaCajaLocal = asociacionMaquinaCajaLocalHome.findByUK(dto.getCadena());
            UtilidadesLog.debug("Despues de findByUK" );
            
            caja = new DTOCaja();
            caja.setOidCaja(asociacionMaquinaCajaLocal.getOidCaja());
            
            // -> Hacer findByPrimaryKey sobre la entidad Caja
            CajaLocalHome cajaLocalHome = this.getCajaLocalHome();
            CajaLocal cajaLocal = cajaLocalHome.findByPrimaryKey(caja.getOidCaja());
            caja.setEstadoCaja(cajaLocal.getEstadoCaja().toString());
            caja.setCodigoCaja(cajaLocal.getCodigoCaja());
            /** INCIDENCIA 10267 */ 
            caja.setOidTipoCaja(cajaLocal.getOidTipoCaja());
            caja.setOidSubacceso(cajaLocal.getSubAcceso());
        
            // -> Hacer findByPrimaryKey sobre la entidad Subacceso tomando Caja.oidSubacceso 
            SubaccesoLocalHome subaccesoLocalHome = this.getSubaccesoLocalHome();
            SubaccesoLocal subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(cajaLocal.getSubAcceso());
            caja.setCodigoSubacceso(subaccesoLocal.getCodigo());
            caja.setOidAcceso(subaccesoLocal.getOidAcceso());

            // -> Hacer findByPrimaryKey sobre la entidad Acceso tomando Subacceso.oidAcceso 
            AccesoLocalHome accesoLocalHome = this.getAccesoLocalHome();
            AccesoLocal accesoLocal = accesoLocalHome.findByPrimaryKey(subaccesoLocal.getOidAcceso());
            caja.setCodigoAcceso(accesoLocal.getCodigo());
            caja.setOidCanal(accesoLocal.getOidCanal());

            // -> Hacer findByPrimaryKey sobre la entidad Canal tomando Acceso.oidCanal 
            CanalLocalHome canalLocalHome = this.getCanalLocalHome();
            CanalLocal canalLocal = canalLocalHome.findByPrimaryKey(accesoLocal.getOidCanal());
            caja.setCodigoCanal(canalLocal.getCodCanal());
            caja.setFecha(new Date(System.currentTimeMillis()));

            // Si (Caja.estadoCaja = ConstantesBEL.CAJA_ABIERTA) entonces 
            if (cajaLocal.getEstadoCaja().equals(ConstantesBEL.CAJA_ABIERTA)) {
                DTONumeroSolicitud numeroSolicitud = new DTONumeroSolicitud();
                numeroSolicitud.setOidPais(dto.getOidPais());
                numeroSolicitud.setOidIdioma(dto.getOidIdioma());
                numeroSolicitud.setOperacion(ConstantesBEL.BEL005.toString());//"BEL005"
                numeroSolicitud.setOidCanal(caja.getOidCanal());
                numeroSolicitud.setOidAcceso(caja.getOidAcceso());
                numeroSolicitud.setOidSubacceso(caja.getOidSubacceso());

                //-> Llamar al método "MONProcesosPED.generaNumeroDocumento(dto : DTONumeroSolicitud) : String" 
                MONProcesosPEDHome mpHome = this.getMONProcesosPEDHome();
                MONProcesosPED mpLocal = mpHome.create();
                String numeroMovimiento = mpLocal.generaNumeroDocumento(numeroSolicitud);
                caja.setNumeroMovimiento(numeroMovimiento);
            }

        } catch(NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.debug(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(MareException me) {            
           UtilidadesLog.debug(me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("MONCajasBean.obtenerDatosCaja(DTOString dto):Salida");
        return caja;
    }


    /**
     * Comentario
     * @param DTOMovimientoCaja
     * @return void
     * @exception MareException 
     * @author enozigli
     */
    public void guardarMovimientoCaja(DTOMovimientoCaja dto) throws MareException {
      UtilidadesLog.debug("MONCajasBean.guardarMovimientoCaja(DTOMovimientoCaja dto):Entrada");
      try {
          UtilidadesLog.debug("entro al try");

        MovimientosDeCajaCabeceraLocalHome mdchome = this.getMovimientosDeCajaCabeceraLocalHome();
        UtilidadesLog.debug("paso 1");
        Timestamp fechahora = new Timestamp(dto.getFecha().getTime());
        UtilidadesLog.debug("paso 2");
        MovimientosDeCajaCabeceraLocal instmdc = mdchome.create(dto.getOidCaja(),new Long(dto.getNumeroMovimiento()),fechahora,dto.getUsuario());
        UtilidadesLog.debug("paso 3");
        instmdc.setObservaciones(dto.getObservaciones());
        UtilidadesLog.debug("paso 4");
        instmdc.setDiferenciaVuelto(dto.getDiferenciaVuelto());
        UtilidadesLog.debug("paso 5");
        mdchome.merge(instmdc);
        
        Long oidMovimientoDeCajaCabecera = instmdc.getOid();
        UtilidadesLog.debug("paso 7");
        int numeroLinea = 1;
        BigDecimal totalEfectivoMovimiento = new BigDecimal(0);
        UtilidadesLog.debug("paso 8");
        MovimientosDeCajaDetalleLocalHome mcdhome = this.getMovimientosDeCajaDetalleLocalHome();
        UtilidadesLog.debug("paso 9");

        for (int i=0;i<dto.getDetalle().size();i++){
            DTOMovimientoCajaDetalle movimientoDetalle = (DTOMovimientoCajaDetalle)dto.getDetalle().get(i);
            UtilidadesLog.debug("paso 10");
            MovimientosDeCajaDetalleLocal instmcd = mcdhome.create(oidMovimientoDeCajaCabecera,movimientoDetalle.getOidMedioPagoBelcenter(),new Integer(numeroLinea),movimientoDetalle.getOidTipoMovimientoCaja());
            UtilidadesLog.debug("paso 11");
            numeroLinea++;
            UtilidadesLog.debug("paso 12");
            instmcd.setOidMovimientoDeCajaDetalleOrigen(movimientoDetalle.getOidMovimientoDeCajaDetalleOrigen());
            UtilidadesLog.debug("paso 13");
            instmcd.setImporte(movimientoDetalle.getImporte());
            UtilidadesLog.debug("paso 14");
            instmcd.setDiferenciaVuelto(movimientoDetalle.getDiferenciaVuelto());
            UtilidadesLog.debug("paso 15");
            instmcd.setImporteDivisa(movimientoDetalle.getImporteDivisa());
            UtilidadesLog.debug("paso 16");
            if(movimientoDetalle.getNumeroCheque()!=null && !movimientoDetalle.getNumeroCheque().equals(" ")){
                instmcd.setNumeroCheque(movimientoDetalle.getNumeroCheque());
            }
            UtilidadesLog.debug("paso 17");
            if(movimientoDetalle.getNumeroTarjeta()!=null &&  !movimientoDetalle.getNumeroTarjeta().equals(" ")){
                instmcd.setNumeroTarjeta(movimientoDetalle.getNumeroTarjeta());
            }
            UtilidadesLog.debug("paso 18");
            if(movimientoDetalle.getNumeroValeCompra()!=null && !movimientoDetalle.getNumeroValeCompra().equals(" ")){
                instmcd.setNumeroValeCompra(movimientoDetalle.getNumeroValeCompra());
            }
            UtilidadesLog.debug("paso 19");
                    
            Timestamp fechahoradeta = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            instmcd.setFecha(fechahoradeta);
                        
            UtilidadesLog.debug("paso 20");
            
            UtilidadesLog.debug("paso 21");
            instmcd.setTipoTarjeta(movimientoDetalle.getOidTipoTarjeta());
            UtilidadesLog.debug("paso 22");
            instmcd.setOidSolicitudCabecera(movimientoDetalle.getOidSolicitudCabecera());
            UtilidadesLog.debug("paso 23");
            instmcd.setMonedaAlternativa(movimientoDetalle.getOidMonedaAlternativa());
            UtilidadesLog.debug("paso 24");
            instmcd.setOidBanco(movimientoDetalle.getOidBancos());  
            
            mcdhome.merge(instmcd);
           /*MOdificacion incidencia 11655 mdolce*/ 
           /*Habia problemas porque se inserta con entities y no actualizaba los montos*/
            try{
               MediosDePagoBelcenterLocalHome mPBLH = this.getMediosDePagoBelcenterLocalHome();
               MediosDePagoBelcenterLocal     mPBL = mPBLH.findByPrimaryKey(movimientoDetalle.getOidMedioPagoBelcenter());
               
               UtilidadesLog.debug("el medio de pago belcenter es " + mPBL.getMediosDePago());
               
               try{
                  MediosDePagoLocalHome mPLH = this.getMediosDePagoLocalHome();
                  MediosDePagoLocal     mPL  = mPLH.findByPrimaryKey(mPBL.getMediosDePago());
                  
                  UtilidadesLog.debug("el tipo medio de pago es " + mPL.getTipoMedioPago());
                  
                  if(mPL.getTipoMedioPago().toString().equals(ConstantesBEL.TIPO_MP_EFECTIVO.toString())){
                     UtilidadesLog.debug("el get impoprte del dto " + movimientoDetalle.getImporte());
                     if (movimientoDetalle.getImporte() != null) {
                        totalEfectivoMovimiento = totalEfectivoMovimiento.add(movimientoDetalle.getImporte());
                     }                     
                     UtilidadesLog.debug("++++++el total movimiento efectivo " + totalEfectivoMovimiento);
                  }
              
               }catch (NoResultException fe){
                 throw fe;
               }  catch (PersistenceException ce) {   
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, 
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
               }
            }catch (NoResultException fe2){
               throw fe2;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        
        
        DTOMovimientoCajaDetalle movimientoCajaDetalle = new DTOMovimientoCajaDetalle();
        
        movimientoCajaDetalle.setTipoMedioPago(ConstantesBEL.TIPO_MP_EFECTIVO);
        movimientoCajaDetalle.setCaja(dto.getOidCaja());
        movimientoCajaDetalle.setFecha(new Date(System.currentTimeMillis()));
        
        MONServicioBELHome msbelhome = this.getMONServicioBELHome();        
        UtilidadesLog.debug("paso 29");
        MONServicioBEL instserbel = msbelhome.create();
        UtilidadesLog.debug("paso 30");
       
        BigDecimal saldoEfectivo = new BigDecimal(0);
        UtilidadesLog.debug("antes del if de llamada al metodo");
        
        if(instserbel.calcularSaldoMovimientosCajaDetalle(movimientoCajaDetalle) != null){
           UtilidadesLog.debug("no es null");
           saldoEfectivo = saldoEfectivo.add(instserbel.calcularSaldoMovimientosCajaDetalle(movimientoCajaDetalle)); 
        }
        
        saldoEfectivo = saldoEfectivo.add(totalEfectivoMovimiento);
        
        
        try{
           CajaLocalHome cLH = this.getCajaLocalHome();
           CajaLocal     cL  = cLH.findByPrimaryKey(dto.getOidCaja());
           
           try{
              ParametrosBelcenterLocalHome pBLH = this.getParametrosBelcenterLocalHome();
              ParametrosBelcenterLocal     pBL  = pBLH.findByUK(dto.getOidPais(), cL.getSubAcceso());
              UtilidadesLog.debug("el saldo efectivo " + saldoEfectivo);
              UtilidadesLog.debug("el limite efectivo " + pBL.getLimiteEfectivoCaja());
              if(pBL.getLimiteEfectivoCaja().compareTo(saldoEfectivo) == -1){
                 instserbel.emitirMensajeAdministrador( dto.getOidCaja(), saldoEfectivo, pBL.getLimiteEfectivoCaja());
              
              }
           }catch(NoResultException fe4){
              throw fe4;          
           }  catch (PersistenceException ce) {   
               UtilidadesLog.error("ERROR ", ce);
               throw new MareException(ce, 
               UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
           }
        }catch (NoResultException fe5){
          throw fe5;       
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
              
      } catch (NamingException ne){
          UtilidadesLog.error(ne);
          ctx.setRollbackOnly();
          throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException ce) {
          UtilidadesLog.error(ce);
          ctx.setRollbackOnly();
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } catch (NoResultException nr) {
          UtilidadesLog.error(nr);
          ctx.setRollbackOnly();
          throw new MareException(nr, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (PersistenceException pe) {
          UtilidadesLog.error(pe);
          ctx.setRollbackOnly();
          throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      } catch (RemoteException ne) {
          UtilidadesLog.error(ne);
          ctx.setRollbackOnly();
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      
      UtilidadesLog.debug("MONCajasBean.guardarMovimientoCaja(DTOMovimientoCaja dto):Salida");
    }


    /**
     * Comentario
     * @param DTOOID
     * @return DTOCargaPaginaMCD
     * @exception MareException 
     * @author enozigli
     */
    public DTOCargaPaginaMCD cargaPaginaMCD(DTOOID dto) throws MareException {
      /** MONCajas.cargaPaginaMCD(dto : DTOOID) : DTOCargaPaginaMCD *
      Entrada: 
      - dto : DTOOID (oid de subacceso) 
      Proceso: 
      -> Crear variable llamada "respuesta" de tipo DTOCargaPaginaMCD 
      -> Hacer findByPrimaryKey sobre la entidad Pais tomando dto.pais 
      -> respuesta.oidMonedaAlternativa = Pais.oidMonedaAlternativa 
      -> respuesta.descripcionMonedaAlternativa = descripción internacionalizada de la moneda para Pais.oidMonedaAlternativa 
      -> Tomar Pais.oidMoneda y Pais.oidMonedaAlternativa respectivamente para la siguiente llamada 
      -> Llamar al método "IServicioSEG.obtenerTipoCambio(moneda1 : Long, moneda2 : Long) : BigDecimal" 
      -> respuesta.tipoCambio = respuesta a la llamada anterior 
      -> Tomar dto de entrada para la siguiente llamada 
      -> Llamar al método "DAOServicioBEL.obtenerMediosPagoBelcenterCierre(dto : DTOOID) : DTOSalida" 
      -> respuesta.mediosDePago = RecordSet obtenido en llamada anterior 
      -> Devolver "respuesta" 
      */
      UtilidadesLog.debug("MONCajasBean.cargaPaginaMCD(DTOOID dto):Entrada");
      try{
        DTOCargaPaginaMCD respuesta = new DTOCargaPaginaMCD();
      
        PaisLocalHome plh = this.getPaisLocalHome();
        PaisLocal paisinst = plh.findByPrimaryKey(dto.getOidPais());

        Entidadi18nLocalHome i18nLH = this.getEntidadi18nLocalHome();
        Entidadi18nLocal i18n = i18nLH.findByEntAtrIdioPK("SEG_MONED",new Long(1),dto.getOidIdioma(),paisinst.getMone_oid_mone_alt());
          //el idioma que se pase aqui deberá ser el idioma por defecto español.

        respuesta.setOidMonedaAlternativa(paisinst.getMone_oid_mone_alt());
        respuesta.setDescripcionMonedaAlternativa(i18n.getDetalle());

        MONMantenimientoSEG iseg = this.getMONMantenimientoSEGHome().create();
        BigDecimal tipocambio = iseg.obtenerTipoCambio(paisinst.getMone_oid_mone(), paisinst.getMone_oid_mone_alt());

        respuesta.setTipoCambio(tipocambio);        
        
        String usuario = ctx.getCallerPrincipal().getName();      
        DAOServicioBel daobel = new DAOServicioBel(usuario);

        respuesta.setMediosDePago(daobel.obtenerMediosPagoBelcenterCierre(dto).getResultado());           
        UtilidadesLog.debug("MONCajasBean.cargaPaginaMCD(DTOOID dto):Salida");
        return respuesta;
        
      } catch(NoResultException fex) {
          UtilidadesLog.error(fex);
          ctx.setRollbackOnly();
          throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(NamingException ne) {
          UtilidadesLog.error(ne);
          ctx.setRollbackOnly();
          throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException ne) {
          UtilidadesLog.error(ne);
          ctx.setRollbackOnly();
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException ce) {
          UtilidadesLog.error(ce);
          ctx.setRollbackOnly();
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      
    }


    /**
     * Comentario
     * @param DTOImportesFisicos
     * @return DTOBoolean
     * @exception MareException 
     * @author mdolce
     */
    public DTOBoolean cerrarCaja(DTOImportesFisicos dto) throws MareException {
        UtilidadesLog.debug("MONCajasBean.cerrarCaja(DTOImportesFisicos dto):Entrada");
        DTOBoolean dtoB = new DTOBoolean();
        String usuario = ctx.getCallerPrincipal().getName();  
        Boolean cuadrada = new Boolean(false);
        
       try {//-> Tomar dto.oidCaja y hacer findByPrimaryKey sobre la entidad Caja 
          CajaLocalHome cajaLH = this.getCajaLocalHome();
          CajaLocal     cajaL  = cajaLH.findByPrimaryKey(dto.getOidCaja());
          //-> Crear variable llamada "subacceso" de tipo DTOOID, donde dto.oid = Caja.oidSubacceso 
          DTOOID subacceso = new DTOOID();
          subacceso.setOid(cajaL.getSubAcceso());
          subacceso.setOidPais(dto.getOidPais());
          subacceso.setOidIdioma(dto.getOidIdioma());
          //-> Tomar "subacceso" para la siguiente llamada 
          //-> Llamar al método "DAOServicioBEL.obtenerMediosPagoBelcenter(dto : DTOOID) : DTOSalida" 
          DAOServicioBel dao = new DAOServicioBel(usuario);
          DTOSalida dtoS = dao.obtenerMediosPagoBelcenter(subacceso);
          //-> Recorrer RecordSet obtenido en la llamada anterior
          RecordSet resultado = dtoS.getResultado();
          //-> Crear variable "salir" de tipo boolean inicializada a "false" 
          Boolean salir = new Boolean(false);
          //-> Crear variable "cuadrada" de tipo boolean inicializada a "true" 
          
          //-> Crear variable "cuadradaLocal" de tipo boolean inicializada a "true"
          Boolean cuadradaLocal = new Boolean(false);
          //-> Crear variable "cuadradaDivisa" de tipo boolean inicializada a "true"
          Boolean cuadradaDivisa = new Boolean(false);
          //-> Crear variable "medioPagoBelcenter" de tipo Long inicializada a 0 */
          Long medioPagoBelcenter = new Long(0);

          /*Incidencia 12458 */
          ArrayList arrLst = dto.getDetalle();
          DTOImporte dtimp = (DTOImporte)arrLst.get(0);
          Long oidMonedaAlter = dtimp.getOidMonedaAlternativa(); 
          /*fin Incidencia 12458, solo para obtener el oidMonedaAlternativa 
           * la moneda alternativa es siempre la misma para un pais*/
          
          for (int i = 0; i < resultado.getRowCount() && !salir.booleanValue(); i++){
             
             medioPagoBelcenter = new Long(((BigDecimal)resultado.getValueAt(i,"OID_MEDI_PAGO_BELC")).longValue());
             
             UtilidadesLog.debug("medioPagoBelcenter: "+ medioPagoBelcenter);
            
             cuadradaLocal   = this.cuadrarImportesMedioPago(medioPagoBelcenter, dto, new Boolean(false));
            
             /*Incidencia 12458 moneda divisa local */
             if(!cuadradaLocal.booleanValue()){
                generaLog(dto.getOidCaja(), medioPagoBelcenter, oidMonedaAlter, dto.getOidIdioma());
             }
             /*Fin Incidencia 12458 moneda divisa local */
             
             cuadradaDivisa  = this.cuadrarImportesMedioPago(medioPagoBelcenter, dto, new Boolean(true));
             /*Incidencia 12458 moneda divisa mcuadrarImportesMedioPagoundial */
             if(!cuadradaDivisa.booleanValue()){
                generaLog(dto.getOidCaja(), medioPagoBelcenter, oidMonedaAlter, dto.getOidIdioma());
             }
             /* Fin Incidencia 12458 moneda divisa mundial */
            
             cuadrada = new Boolean(cuadradaLocal.booleanValue() && cuadradaDivisa.booleanValue());

             if(!cuadrada.booleanValue()){            
                salir = new Boolean(true);  
             }
          }
          
          UtilidadesLog.debug( " cuadradaLocal.booleanValue() " + cuadradaLocal.booleanValue()  );
          UtilidadesLog.debug( " cuadradaDivisa.booleanValue() " + cuadradaDivisa.booleanValue() );
          
           //******  Incidencia 12456  *******
          int a = 1;
          if(!cuadrada.booleanValue() && (dto.getNroOportunidad().intValue()== a) ){
              cuadrada = cuadrada.FALSE;
              UtilidadesLog.debug("Caja descuadrada oportunidad 1");
          //******  Fin Incidencia 12456  *******
          }else{           
              this.actualizarDatos(cuadrada, dto);              
              UtilidadesLog.debug("************seguna oportunidad*************");
          } 
          
       }catch(NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }catch(PersistenceException ne) {
            UtilidadesLog.debug(ne);
            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
       }
       UtilidadesLog.debug("estado cuadrada " + cuadrada);
       dtoB.setValor(cuadrada.booleanValue());
       
       UtilidadesLog.debug("MONCajasBean.cerrarCaja(DTOImportesFisicos dto):Salida");
       return dtoB;
    }


    /**
     * Comentario
     * @param DTOCaja
     * @return DTOSalida
     * @exception MareException 
     * @author Cristian Valenzuela
     */
    public DTOSalida cerrarCajasBELC(DTOCaja dto) throws MareException {
      /*-> Hacer findByUK sobre la entidad ParametrosBelcenter tomando dto.pais y dto.oidSubacceso 
        -> Crear variable "subacceso" de tipo DTOOID, tal que subacceso.oid = dto.oidSubacceso 
        -> Tomar "subacceso" para la siguiente llamada 
        -> Llamar al método "DAOCajas.obtenerCajasCerradas(dto : DTOOID) : DTOSalida" 

        (1) Si la longitud del RecordSet es igual a ParametrosBelcenter.numeroDeCajas entonces 
              -> Tomar "subacceso" para la siguiente llamada 
              -> Llamar al método "DAOCajas.obtenerCierresDeCaja(dto : DTOOID) : DTOSalida" 
              (2) Si la longitud del RecordSet es mayor que 0 entonces 
                    -> Tomar "subacceso" para la siguiente llamada 
                    -> DAOCajas.obtenerCierresDeCajaDetalleDescuadrados(dto : DTOOID) : DTOSalida" 
                    -> Devolver respuesta a la llamada anterior 
              (2) Si no entonces 
                  -> Lanzar MareException con el código de error "BEL-0006" 
              (2) Fin Si 
        (1) Si no entonces 
          -> Lanzar MareException con el código de error "BEL-0005" 
        (1) Fin Si */
        
        UtilidadesLog.debug("MONCajasBean.cerrarCaja(DTOImportesFisicos dto):Entrada");
        try {
          UtilidadesLog.debug("********* Entre a cerrarCajasBELC - MONCajas");

          DTOSalida dtoSal = new DTOSalida();                  
          ParametrosBelcenterLocal pbl = this.getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(),dto.getOidSubacceso());          
          UtilidadesLog.debug("********* this.getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(),dto.getOidSubacceso() - MONCajas");
          
          DTOOID subacceso = new DTOOID();
          subacceso.setOid(dto.getOidSubacceso());
          subacceso.setOidPais(dto.getOidPais());
          subacceso.setOidIdioma(dto.getOidIdioma());
          
          
          //PZERBINO Incidencia 22034 
          UtilidadesLog.debug("********* MONRegistroAbastacemiento - MONCajas");
          

          MONRegistroAbastecimientoHome monRegistroAbastecimientoLH = this.getMONRegistroAbastecimientoHome();        
          UtilidadesLog.debug("********* Asignacion de monRegistroAbastecimientoLH - MONCajas");
          MONRegistroAbastecimiento     monRegistroAbastecimientoH =  monRegistroAbastecimientoLH.create();    
          UtilidadesLog.debug("********* Creacion monRegistroAbastecimientoH - MONCajas");
          monRegistroAbastecimientoH.alertaCalculoSalidaSuperiorAlPrevisto(dto.getOidPais(),dto.getOidSubacceso());
          
          UtilidadesLog.debug("*********SAlir  MONRegistroAbastacemiento - MONCajas");
          
          UtilidadesLog.debug("*********Antes DTOCambiosVentas dtoCv = new DTOCambiosVentas();  - MONCajas");
          DTOCambiosVentas dtoCv = new DTOCambiosVentas();
          
          UtilidadesLog.debug("*********Antes dto.getOidPais()  - MONCajas" + dto.getOidPais());
          dtoCv.setOidPais(dto.getOidPais());
          
          UtilidadesLog.debug("*********Antes dto.getOidSubacceso()  - MONCajas" + dto.getOidSubacceso());
          dtoCv.setOidSubacceso(dto.getOidSubacceso());          
          
       
          dtoCv.setOidSolicitud(null);
          
          dtoCv.setNumeroSolicitud(null);       
          
          dtoCv.setSimulacion(new Boolean(false));

          
          //MONCambiosVentas monCambiosVentas = null;
          MONCambiosVentasHome monCambiosVentasLH = this.getMONCambiosVentasHome();
          UtilidadesLog.debug("*********Antes monCambiosVentas.cambiosVentas(dtoCv)  - MONCajas" );          
          MONCambiosVentas monCambiosVentasH = monCambiosVentasLH.create();
          monCambiosVentasH.cambiosVentas(dtoCv);
          
          //Fin de agregado de Incidencia 22034
          UtilidadesLog.debug("********* Llamando a 55555555 - DAOCajas");          
          DAOCajas dao = new DAOCajas();
          
          UtilidadesLog.debug("********* Llamando a obtenerCajasCerradas - DAOCajas");
          dtoSal = dao.obtenerCajasCerradas(subacceso);
          UtilidadesLog.debug("********* Despues de llamar a obtenerCajasCerradas - DAOCajas");
          RecordSet rs = dtoSal.getResultado();
          UtilidadesLog.debug("********* rs " + rs);

          if(rs.getRowCount() == pbl.getNumeroDeCajas().intValue()) {
            UtilidadesLog.debug("********* Llamando a obtenerCierresDeCaja - DAOCajas");
            dtoSal = dao.obtenerCierresDeCaja(subacceso);
            rs = dtoSal.getResultado();
            if(!rs.esVacio()){
                if(rs.getRowCount()>0) {
                  UtilidadesLog.debug("********* Llamando a obtenerCierresDeCajaDetalleDescuadrados - DAOCajas");
                  dtoSal = dao.obtenerCierresDeCajaDetalleDescuadrados(subacceso);
                  UtilidadesLog.debug("********* dtoSal " + dtoSal);
                 
                }
                
            }else{
              throw new MareException(null, null,
              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.TODAS_CAJAS_CUADRADAS));
            }
             UtilidadesLog.debug("MONCajasBean.cargaPaginaMCD(DTOOID dto):Salida");
             return dtoSal;              
          }
          else {
            throw new MareException(null, null,
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.NUMERO_CAJAS_MENOR_CAJAS_BELCENTER));
          }    
        } catch(NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.debug(ne);
            throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
          throw me;
        } catch (Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }


    /**
     * Comentario
     * @param DTOCaja
     * @return DTOSalida
     * @exception MareException 
     * @author Cristian Valenzuela
     */
    public DTOSalida cerrarCajasBELCResumen(DTOCaja dto) throws MareException {
      /*-> Hacer findByUK sobre la entidad ParametrosBelcenter tomando dto.pais y dto.oidSubacceso 
        -> Crear variable "subacceso" de tipo DTOOID, tal que subacceso.oid = dto.oidSubacceso 
        -> Tomar "subacceso" para la siguiente llamada 
        -> Llamar al método "DAOCajas.obtenerCierresDeCaja(dto : DTOOID) : DTOSalida" 

        (1) Si la longitud del RecordSet es mayor que 0 entonces 
            -> Tomar "subacceso" para la siguiente llamada 
            -> DAOCajas.obtenerCierresDeCajaDetalleDescuadradosResumen(dto : DTOOID) : DTOSalida" 
            -> Devolver respuesta a la llamada anterior 
        (1) Si no entonces 
            -> Lanzar MareException con el código de error "BEL-0006" 
        (1) Fin Si  */

        UtilidadesLog.debug("MONCajasBean.cerrarCajasBELCResumen(DTOCaja dto):Entrada");
        try {
          UtilidadesLog.debug("********* Entre a cerrarCajasBELCResumen - MONCajas");

          DTOSalida dtoSal = new DTOSalida();                 
          ParametrosBelcenterLocal pbl = this.getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(),dto.getOidSubacceso());

          DTOOID subacceso = new DTOOID();
          subacceso.setOid(dto.getOidSubacceso());
          subacceso.setOidPais(dto.getOidPais());
          subacceso.setOidIdioma(dto.getOidIdioma());
          
          DAOCajas dao = new DAOCajas();

          UtilidadesLog.debug("********* Llamando a obtenerCierresDeCaja - DAOCajas");
          dtoSal = dao.obtenerCierresDeCaja(subacceso);
          RecordSet rs = dtoSal.getResultado();
          UtilidadesLog.debug("********* rs " + rs);

          if(rs.getRowCount()>0) {
            UtilidadesLog.debug("********* Llamando a obtenerCierresDeCajaDetalleDescuadradosResumen - DAOCajas");
            dtoSal = dao.obtenerCierresDeCajaDetalleDescuadradosResumen(subacceso);
            UtilidadesLog.debug("********* dtoSal " + dtoSal);
            UtilidadesLog.debug("MONCajasBean.cargaPaginaMCD(DTOOID dto):Salida");
            return dtoSal;            
          }
          else {
            throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.TODAS_CAJAS_CUADRADAS));
          }
        } catch(NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
          throw me;
        } catch (Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

    }

    public Boolean cuadrarImportesMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa) throws MareException {
     UtilidadesLog.debug("MONCajasBean.cuadrarImportesMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa):Entrada");
     BigDecimal importeFisico = new BigDecimal(0);
     BigDecimal importeLogico = new BigDecimal(0);

     try{

        importeFisico = this.obtenerImporteFisicoMedioPago(medioPagoBelcenter, dto, divisa);
        DAOCajas dao = new DAOCajas();
        UtilidadesLog.debug("antes de llamar al dao importeFisico " + importeFisico);
        
        if(dao.obtenerImporteLogicoMedioPago(medioPagoBelcenter, dto.getOidCaja(), divisa) != null){
           UtilidadesLog.debug("es diferente de null");
           importeLogico = importeLogico.add(dao.obtenerImporteLogicoMedioPago(medioPagoBelcenter, dto.getOidCaja(), divisa));
           UtilidadesLog.debug("despues del dao importeLogico " +importeLogico);
        }
        
     } catch(Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }
     
     UtilidadesLog.debug("antes de igualar");
     
     if(importeFisico.intValue() == importeLogico.intValue()){
        UtilidadesLog.debug("Iguales");
        UtilidadesLog.debug("MONCajasBean.cuadrarImportesMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa):Salida");
        return Boolean.TRUE;
     }else{
        UtilidadesLog.debug("Desiguales");
        UtilidadesLog.debug("MONCajasBean.cuadrarImportesMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa):Salida");
        return Boolean.FALSE;
     }

     
  }

  public BigDecimal obtenerImporteFisicoMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa) throws MareException {
     UtilidadesLog.debug("MONCajasBean.obtenerImporteFisicoMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa):Entrada");

     BigDecimal importeFisico = new BigDecimal(0);
     ArrayList arr = new ArrayList();
    
     try{
        arr = dto.getDetalle();

        for (int i = 0; i < arr.size(); i++) {
           DTOImporte dtoI = (DTOImporte)arr.get(i);
           if(dtoI.getOidMedioPagoBelcenter().equals(medioPagoBelcenter)){
              if(divisa.booleanValue()){ 
                
                 importeFisico = importeFisico.add( dtoI.getImporteDivisa()==null?new BigDecimal(0):dtoI.getImporteDivisa());   
              }else{
                 importeFisico = importeFisico.add( dtoI.getImporte()==null?new BigDecimal(0):dtoI.getImporte() );
              }
           }
        }
      } catch(Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.debug("antes de setear el importeFisico en obtenerImporteFisicoMedioPago " + importeFisico);
      UtilidadesLog.debug("MONCajasBean.obtenerImporteFisicoMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa):Salida");
      return importeFisico;
  }


  // Método actualizaDatos
  // ---------------------------------------------------------------------
  // Autor: Sebastián Santana
  // Params. Entrada: Boolean cuadrado  
  //                  DTOImportesFisicos dto
  // Returns: void
  // Fecha: 23/11/2004
  public void actualizarDatos(Boolean cuadrada, DTOImportesFisicos dto) throws MareException  {
      UtilidadesLog.debug("MONCajasBean.actualizarDatos(Boolean cuadrada, DTOImportesFisicos dto):Entrada");
      DAOCajas daoCajas = new DAOCajas();
      ParametrosBelcenterLocalHome pBelcenterHome = null;
      ParametrosBelcenterLocal pBelcenter = null;
      MovimientosDeCajaCabeceraLocalHome movCajaCabecLocalHome = null;
      MovimientosDeCajaCabeceraLocal movCajaCabecLocal = null;
      MovimientosDeCajaDetalleLocalHome movCajaDetalleLocalHome = null;
      MovimientosDeCajaDetalleLocal movCajaDetalleLocal = null;      
      MovimientosDeCajaDetalleLocal movCajaDetalleLocalNuevo = null;            
      CajaLocalHome cajaLocalHome = null;      
      CajaLocal cajaLocal = null;
      CierreDeCajaCabeceraLocal cierreCajaCabecLocal= null;
      CierreDeCajaCabeceraLocalHome cierreCajaCabecLocalHome = null;
      CierreDeCajaDetalleLocal cierreCajaDetalLocal =  null;
      CierreDeCajaDetalleLocalHome cierreCajaDetalLocalHome = null;     
      PaisLocal paisLocal = null;
      PaisLocalHome paisLocalHome = null;
      SubaccesoLocalHome sbacLocalHome = null;
      SubaccesoLocal     sbacLocal   = null;
      AccesoLocalHome accLocalHome = null;
      AccesoLocal         accLocal = null;
      
      MONProcesosPEDHome monProcesoPEDHome= null;
      MONProcesosPED monProcesoPED = null;      
      DAOServicioBel daoServicioBel = new DAOServicioBel(dto.getUsuario());      


      // ****************************
      // Se obtiene la caja principal
      // ****************************
      UtilidadesLog.debug("********+++++++el dto es " + dto);
      Long subacceso = dto.getOidSubacceso();
      Long cajaPrincipal = daoCajas.obtenerCajaPrincipal(subacceso);
      

      // Si la caja Principal es null, tira Exception.
      if ( cajaPrincipal == null){
        UtilidadesLog.debug("Caja principal es null");
        throw new MareException("Caja principal null", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.CAJA_PRINCIPAL_INEXISTENTE));
      }

      UtilidadesLog.debug("Caja principal es: " + cajaPrincipal.toString());
      Long pais = dto.getOidPais();

      try {
        pBelcenterHome = this.getParametrosBelcenterLocalHome();
        pBelcenter = pBelcenterHome.findByUK(pais, subacceso);        
      } catch (NoResultException fEx){
        UtilidadesLog.debug("1- Finder Exception");      
        throw new MareException(fEx,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      // ***********************************************
      // Creamos un registro de MovimientoDeCajaCabecera
      // ***********************************************
      Long tipoMovimientosCajaCierre = pBelcenter.getTipoMovimientoCierre();

      BigDecimal diferenciaVuelto = daoCajas.obtenerSumaDevueltosMCC(dto.getOidCaja());
      UtilidadesLog.debug("Diferencia de Vuelto: " + diferenciaVuelto);

      try{
        cajaLocalHome = this.getCajaLocalHome();       
        cajaLocal = cajaLocalHome.findByPrimaryKey(dto.getOidCaja());
      } catch (NoResultException fEx){
        UtilidadesLog.debug("1- NoResultException");      
        throw new MareException(fEx,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (PersistenceException nEx){
        UtilidadesLog.debug("2- PersistenceException");
        throw new MareException (nEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

     
      Long oidCaja = dto.getOidCaja();

      DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
      dtoNumeroSolicitud.setOidPais( dto.getOidPais() );
      dtoNumeroSolicitud.setOidIdioma( dto.getOidIdioma() );      
      dtoNumeroSolicitud.setOperacion(ConstantesBEL.BEL005.toString());//"BEL005"

       try{
        sbacLocalHome = this.getSubaccesoLocalHome();       
        sbacLocal = sbacLocalHome.findByPrimaryKey(cajaLocal.getSubAcceso());
      } catch (NoResultException fEx){
        UtilidadesLog.debug("2- Finder Exception");      
        throw new MareException(fEx,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

       try{
        accLocalHome = this.getAccesoLocalHome();       
        accLocal = accLocalHome.findByPrimaryKey(sbacLocal.getOidAcceso());
      } catch (NoResultException fEx){
        UtilidadesLog.debug("2- NoResultException");      
        throw new MareException(fEx,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      
      // Inc. 10758:
      // -----------
      dtoNumeroSolicitud.setOidCanal( accLocal.getOidCanal());
      dtoNumeroSolicitud.setOidAcceso(sbacLocal.getOidAcceso()); 
      dtoNumeroSolicitud.setOidSubacceso(cajaLocal.getSubAcceso());

      // Llama a MONProcesosPED.generaNumeroDocumento para obtener
      // el nro de Movimiento (el nombre "generaNumeroDocumento" estaría mal en el DMCO).
      UtilidadesLog.debug("-- Llama a MONProcesosPED.generaNumeroDocumento");
      String sNroMovimiento = null;
      try{
        monProcesoPEDHome = this.getMONProcesosPEDHome();
        monProcesoPED = monProcesoPEDHome.create();
        sNroMovimiento = monProcesoPED.generaNumeroDocumento(dtoNumeroSolicitud);              
      }catch (NamingException nEx){
        UtilidadesLog.debug("3- Naming Exception al obtener monProcesoPEDHome");
        throw new MareException (nEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException rEx){
        UtilidadesLog.debug("3- Remote Exception");
        throw new MareException (rEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
      } catch (CreateException cEx){
        UtilidadesLog.debug("3- Create Exception");
        UtilidadesLog.error(cEx);
        ctx.setRollbackOnly();
        throw new MareException (cEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      // *******************************************************
      // Realiza el Create sobre MovimientoCajaCabeceraLocalHome
      // *******************************************************      
      UtilidadesLog.debug("--- Realiza el Create sobre MovimientoCajaCabeceraLocalHome");
      UtilidadesLog.debug("    y setea los parametros correspondientes");
      try{
        movCajaCabecLocalHome = this.getMovimientosDeCajaCabeceraLocalHome();
        movCajaCabecLocal = movCajaCabecLocalHome.create(
                      cajaPrincipal,  // Caja principal
                      new Long(sNroMovimiento), // Nro Movimiento
                      new Timestamp( new java.util.Date().getTime() ),  // Fecha del Sistema
                      dto.getUsuario()  // Usuario
                   );
        movCajaCabecLocal.setObservaciones(null);
        movCajaCabecLocal.setDiferenciaVuelto(diferenciaVuelto);
        movCajaCabecLocalHome.merge(movCajaCabecLocal);
      } catch (PersistenceException cEx){
        UtilidadesLog.debug("4- PersistenceException");
        UtilidadesLog.error(cEx);
        ctx.setRollbackOnly();
        throw new MareException (cEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

      // ***************************************************************
      // Creamos un registro de MovimientoDeCajaDetalle para la cabecera
      // ***************************************************************
      UtilidadesLog.debug("--- Crea registros de Detalle en MovimientoDeCajaDetalle");
      RecordSet r = daoCajas.obtenerMovimientosDeCajaDetalle(oidCaja);
      
      int numeroLinea = 0;
      UtilidadesLog.debug("Recordset: " + r);
      movCajaDetalleLocalHome = this.getMovimientosDeCajaDetalleLocalHome();
      
      for (int i = 0; i < r.getRowCount(); i++){
          // Se obtiene OID_DETA
          UtilidadesLog.debug(" Registro " + i);
          BigDecimal bigOidBuffer = (BigDecimal) r.getValueAt(i,0);
          Long oidDeta = new Long( bigOidBuffer.longValue() );
          try {
            movCajaDetalleLocal = movCajaDetalleLocalHome.findByPrimaryKey(oidDeta);
            UtilidadesLog.debug("+++++el oid detalle es " + movCajaCabecLocal.getOid());
            numeroLinea = numeroLinea + 1;
            movCajaDetalleLocalNuevo =  movCajaDetalleLocalHome.create(
                 movCajaCabecLocal.getOid(),  // Movimiento de Caja Cabecera (se toma el creado acá)
                 movCajaDetalleLocal.getMedioPagoBelcenter(), // Medio Pago Belcenter
                 new Integer(numeroLinea), // Numero de Linea
                 tipoMovimientosCajaCierre  // tipoMovimientoCaja
                );

            movCajaDetalleLocalNuevo.setDiferenciaVuelto( movCajaDetalleLocal.getDiferenciaVuelto() );
            movCajaDetalleLocalNuevo.setFecha( movCajaDetalleLocal.getFecha() );
            movCajaDetalleLocalNuevo.setImporte( movCajaDetalleLocal.getImporte() );
            movCajaDetalleLocalNuevo.setImporteDivisa( movCajaDetalleLocal.getImporteDivisa() );
            //movCajaDetalleLocalNuevo.setMedioPagoBelcenter( movCajaDetalleLocal.getMedioPagoBelcenter() );
            movCajaDetalleLocalNuevo.setMonedaAlternativa( movCajaDetalleLocal.getMonedaAlternativa() );
            movCajaDetalleLocalNuevo.setNumeroCheque( movCajaDetalleLocal.getNumeroCheque() );
            movCajaDetalleLocalNuevo.setNumeroTarjeta( movCajaDetalleLocal.getNumeroTarjeta() );
            movCajaDetalleLocalNuevo.setNumeroValeCompra( movCajaDetalleLocal.getNumeroValeCompra());
            movCajaDetalleLocalNuevo.setOidBanco( movCajaDetalleLocal.getOidBanco() );            
            // setOidMovimientoDeCajaDetalleOrigen - Se pone el oid del Entity MovimientoDeCajaDetalle
            // encontrado:
            movCajaDetalleLocalNuevo.setOidMovimientoDeCajaDetalleOrigen(oidDeta); 
            movCajaDetalleLocalNuevo.setTipoTarjeta( movCajaDetalleLocal.getTipoTarjeta() );
            movCajaDetalleLocalHome.merge(movCajaDetalleLocalNuevo);

          } catch (NoResultException fEx){
            UtilidadesLog.debug("5- NoResultException");      
            throw new MareException(fEx,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch (PersistenceException cEx){
            UtilidadesLog.debug("5- PersistenceException");  
            UtilidadesLog.error(cEx);
            ctx.setRollbackOnly();
            throw new MareException(cEx,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
          
      }

      UtilidadesLog.debug("--- Fin Bucle");

      // ******************************************************
      // Se genera el Cierre de Caja empezando por la cabecera
      // ******************************************************
      UtilidadesLog.debug("--- Generando Cierre de Caja (Cabecera)");
      try {
        sNroMovimiento = monProcesoPED.generaNumeroDocumento(dtoNumeroSolicitud);                    
      }catch (RemoteException rEx){
        UtilidadesLog.debug("6- Remote Exception");
        throw new MareException (rEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 

      try {

        Character c = null;
        if ( cuadrada.booleanValue() )
          c = ConstantesBEL.CAJA_CUADRADA;
        else
          c = ConstantesBEL.CAJA_DESCUADRADA;
        
        cierreCajaCabecLocalHome = this.getCierreDeCajaCabeceraLocalHome();
        cierreCajaCabecLocal = cierreCajaCabecLocalHome.create(
                            movCajaCabecLocal.getOid(),  // Oid de Mov. de Caja Cabecera
                            new Long(sNroMovimiento),  // Nro de Movimiento
                            c,  // Estado Cierre Caja
                            new Timestamp(new java.util.Date().getTime()), // Fecha actual
                            dto.getUsuario()
        );
      } catch (PersistenceException cEx){
        UtilidadesLog.debug("7- PersistenceException");
        UtilidadesLog.error(cEx);
        ctx.setRollbackOnly();
        throw new MareException (cEx, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

      // *************************************************
      //  Se generan los registros del detalle del cierre
      // *************************************************

      UtilidadesLog.debug("--- Genera Registros de Detalle de Cierre");

      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(dto.getOidSubacceso());
      dtoOid.setOidIdioma(dto.getOidIdioma());
      dtoOid.setOidPais(dto.getOidPais());

      DTOSalida dtoSalida = daoServicioBel.obtenerMediosPagoBelcenter(dtoOid);
      r = dtoSalida.getResultado();

      Long medioPagoBelcenter = new Long(0); // No importa el valor, abajo se cambia.
      Boolean divisa = null;

      cierreCajaDetalLocalHome = this.getCierreDeCajaDetalleLocalHome();

      numeroLinea = 0; 
      for  ( int i = 0; i < r.getRowCount(); i ++){
           BigDecimal bigBuffer = (BigDecimal) r.getValueAt(i,0);
           medioPagoBelcenter = new Long(bigBuffer.longValue());
           try {
           
               UtilidadesLog.debug("esto es lo que va a insertar: la cabecera oid" + cierreCajaCabecLocal.getOid());

               numeroLinea++;
               //Aca hay que buscar en el recordset el oid de medio de pago                                                                         
               

               cierreCajaDetalLocal = cierreCajaDetalLocalHome.create(
                          cierreCajaCabecLocal.getOid(), // cierreCajaCabecera
                          new Integer(numeroLinea)         // numeroLinea  Inc. 10760
                      );
               
               cierreCajaDetalLocal.setMedioDePago(medioPagoBelcenter);
               cierreCajaDetalLocalHome.merge(cierreCajaDetalLocal);
               
               UtilidadesLog.debug("oid de medio de pago del recordset   ***  " + medioPagoBelcenter);
                         
       
           } catch (PersistenceException cEx){ 
                UtilidadesLog.debug("9- PersistenceException");
                UtilidadesLog.error(cEx);
                ctx.setRollbackOnly();
                throw new MareException (cEx, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
           
            // Inc. 10760 sobre parametros 2do del DAO:
           divisa = new Boolean(false);
           
           cierreCajaDetalLocal.setImporteLogico(
                daoCajas.obtenerImporteLogicoMedioPago(medioPagoBelcenter, dto.getOidCaja(), divisa)
           );

           divisa = new Boolean(true);
           cierreCajaDetalLocal.setImporteLogicoDivisa(
                daoCajas.obtenerImporteLogicoMedioPago(medioPagoBelcenter, dto.getOidCaja(), divisa)
           );

           divisa = new Boolean(false);
           cierreCajaDetalLocal.setImporte(
                  this.obtenerImporteFisicoMedioPago(medioPagoBelcenter, dto, divisa)
           );

           divisa = new Boolean(true);           
           cierreCajaDetalLocal.setImporteDivisa(
                  this.obtenerImporteFisicoMedioPago(medioPagoBelcenter, dto, divisa)
           );

           if ( cierreCajaDetalLocal.getImporteDivisa().longValue() > 0){

                try {
                  paisLocalHome = this.getPaisLocalHome();                
                  paisLocal = paisLocalHome.findByPrimaryKey(dto.getOidPais());
                } catch (NoResultException fEx){
                  UtilidadesLog.debug("10- Finder Exception");   
                  throw new MareException(fEx,
                      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                cierreCajaDetalLocal.setMonedaAlternativa( paisLocal.getMone_oid_mone_alt() );
                
           }else{
             cierreCajaDetalLocal.setMonedaAlternativa( null );
           }
      }

      cajaLocal.setEstadoCaja(ConstantesBEL.CAJA_CERRADA);
      cajaLocal.setFechaCierre(new Timestamp(new java.util.Date().getTime() ));
      UtilidadesLog.debug("MONCajasBean.actualizarDatos(Boolean cuadrada, DTOImportesFisicos dto):Salida");

  }


    public void generaLog(Long oidCaja, Long medioPago, Long oidMoneda, Long idioma) throws MareException
  {
     UtilidadesLog.debug("MONCajasBean.generaLog(Long oidCaja, Long medioPago, Long oidMoneda, Long idioma):Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     UtilidadesLog.debug("*********** entre en generaLog() ******** ");
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();
    
     /*12458
               * "El Sistema muestra un mensaje del tipo “La caja está descuadrada”,
               * y genera un log de error con el detalle del
                 descuadre: “Caja descuadrada: <Fecha> <Código caja> <Medio pago> <Moneda>”. 
                 Los valores entre corchetes se sustituirá por sus valores correspondientes 
                 (puede haber varias diferencias).               
                 BEL_MOVIM_CAJA_CABEC                 
               * */              
     try {
          bs = BelcorpService.getInstance();

          query.append(" select distinct to_char(a.FEC_MOVI, 'dd/mm/yyyy'), caja_oid_caja, gen2.VAL_I18N, gen.VAL_I18N ");
          query.append(" from BEL_MOVIM_CAJA_CABEC a, BEL_MOVIM_CAJA_DETAL b , V_GEN_I18N_SICC gen, V_GEN_I18N_SICC gen2  ");
          query.append(" where caja_oid_caja = " + oidCaja );          
          query.append(" AND gen.VAL_OID = b.MONE_OID_MONE ");
          query.append(" AND gen.ATTR_ENTI = 'SEG_MONED' and  gen.ATTR_NUM_ATRI = 1 ");
          query.append(" AND gen2.VAL_OID = b.MPBC_OID_MEDI_PAGO_BELC ");
          query.append(" AND gen2.ATTR_ENTI = 'BEL_MEDIO_PAGO' and  gen2.ATTR_NUM_ATRI = 1 ");
          query.append(" and gen.IDIO_OID_IDIO = " + idioma );
          query.append(" and b.MPBC_OID_MEDI_PAGO_BELC = " + medioPago );
          if(oidMoneda != null){
            query.append(" and b.MONE_OID_MONE = " + oidMoneda );
          }
          query.append(" and to_char(a.fec_movi, 'dd/mm/yyyy') = to_char(sysdate, 'dd/mm/yyyy') "  );
          
          UtilidadesLog.debug("la query de genera lo es" + query.toString());
          
          resultado = bs.dbService.executeStaticQuery(query.toString());   
          int cantReg = resultado.getRowCount();
          BigDecimal caja = null;
          String fechaStr = "";
          String medioPagoStr ="";
          String monedaStr  = "";
          if(cantReg >0){
          UtilidadesLog.debug("el resultado es mayo a cero del resultado de genera log");
            for( int i=0; i<cantReg; i++ ){
                fechaStr = (String )resultado.getValueAt(i, 0);
                caja = (BigDecimal) resultado.getValueAt(i, 1);                
                medioPagoStr = (String)resultado.getValueAt(i, 2);
                monedaStr  = (String)resultado.getValueAt(i, 3);
                //String cadena = new String( fechaStr + " " + medioPagoStr + " " + monedaStr + " " +(caja!=null?caja.toString():"") ) ;
                String cadena = new String("Caja descuadrada " +  fechaStr + " " + medioPagoStr + " " + monedaStr + " " +(caja!=null?caja.toString():"") ) ;
                UtilidadesLog.debug("cadena    " +  cadena );
                UtilidadesLog.debug("antes de setear en UtilidadesLog.debug ");
                UtilidadesLog.debug(cadena);
            }
          
          }
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }
     
     UtilidadesLog.debug("MONCajasBean.generaLog(Long oidCaja, Long medioPago, Long oidMoneda, Long idioma):Salida");
  }    

  public DTOSalida obtenerCajas(DTOCaja dtoin) throws MareException{
    DAOCajas dao= new DAOCajas();
    
    return dao.obtenerCajas(dtoin);
  }
  
  public Long objectToLong(Object number){
      Long salida;
      if (number == null) {
          salida = null;
      } else {
          BigDecimal biDecimal =  (BigDecimal) number;
          salida = new Long(biDecimal.longValue());
      }
      return salida;
  }


  /**
   * Llama al método encargado de buscar las cajas
   * @author gPineda
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida con todas las cajas encontradas
   * @param dtoEntrada con los parametros a buscar
   */
  public DTOSalida buscarCajas(DTOMantenimientoCaja dtoEntrada) throws MareException
  {
    UtilidadesLog.info("MONCajasBean.buscarCajas(DTOOID dtoEntrada):Entrada");
    UtilidadesLog.debug( dtoEntrada );
    DAOCajas dao = new DAOCajas();
    DTOSalida resultado = dao.buscarCajas( dtoEntrada );
    UtilidadesLog.info("MONCajasBean.buscarCajas(DTOOID dtoEntrada):Salida");
    return resultado;
  }

  /**
   * Se eliminan las entidades caja cuyos oids se reciben como parametros de entrada 
   * @author gPineda
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoEntrada
   */
  public void eliminarCajas(DTOOIDs dtoEntrada) throws MareException {
    UtilidadesLog.info("MONCajasBean.eliminarCajas(DTOOIDs dtoEntrada):Entrada");
    UtilidadesLog.debug( dtoEntrada );
    try{
      CajaLocalHome cajaLocalHome = getCajaLocalHome();
      Long[] oids = dtoEntrada.getOids();
      int tamanio = oids.length;
      for( int i = 0; i < tamanio; i++){
        CajaLocal cajaLocal = cajaLocalHome.findByPrimaryKey( oids[i] );  
        cajaLocalHome.remove(cajaLocal);
      }
    } catch(NoResultException e){
      UtilidadesLog.debug(e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException e){
      UtilidadesLog.debug(e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("MONCajasBean.eliminarCajas(DTOOIDs dtoEntrada):Salida");
  }

  /**
   * Hace el create o update en la entidad caja 
   * @author gPineda
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoEntrada
   */
  public void actualizarCaja(DTOMantenimientoCaja dtoEntrada) throws MareException
  {
    UtilidadesLog.info("actualizarCaja(DTOMantenimientoCaja dtoEntrada):Entreada");
    UtilidadesLog.debug( dtoEntrada );
    try {
    CajaLocalHome cajaLocalHome = getCajaLocalHome();
    
    if( dtoEntrada.getOidCaja() == null ){ //insertar
      cajaLocalHome.create(dtoEntrada.getOidPais(), dtoEntrada.getOidSubacceso(),
                    dtoEntrada.getCodigoCaja(), ConstantesBEL.CAJA_CERRADA, null, dtoEntrada.getOidTipoCaja(), dtoEntrada.getOidRespCierreCaja() );
    }else{ //modificar
      CajaLocal cajaLocal = cajaLocalHome.findByPrimaryKey( dtoEntrada.getOidCaja() );  
      
      cajaLocal.setCodigoCaja( dtoEntrada.getCodigoCaja() );
      cajaLocal.setOidTipoCaja( dtoEntrada.getOidTipoCaja() );
      cajaLocal.setUsuario( dtoEntrada.getOidRespCierreCaja() );
      cajaLocalHome.merge(cajaLocal);
    }
    
    } catch(NoResultException e){
      UtilidadesLog.debug(e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException e){
      UtilidadesLog.debug(e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("actualizarCaja(DTOMantenimientoCaja dtoEntrada):Salida");
  }

  /**
   * Recibe un DTOOID con el oid del subacceso, con ese oid busca si existe la caja principal. 
   * Dependiendo del resultado arma el DTOSalida que devolverá 
   * @author gPineda
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoEntrada
   */
  public DTOSalida obtenerTiposCaja(DTOOID dtoEntrada) throws MareException
  {
    UtilidadesLog.info("MONCajasBean.obtenerTiposCaja(DTOOID dtoEntrada):Entrada");
    UtilidadesLog.debug( dtoEntrada );
    DAOCajas dao = new DAOCajas();
    DTOSalida resultado = dao.obtenerTiposCajas();
    UtilidadesLog.info("MONCajasBean.obtenerTiposCaja(DTOOID dtoEntrada):Salida");
    return resultado;
  }
  
    private AccesoLocalHome getAccesoLocalHome() {
        return new AccesoLocalHome();
    }
    
    private AsociacionMaquinaCajaLocalHome getAsociacionMaquinaCajaLocalHome() {
      return new AsociacionMaquinaCajaLocalHome();
    }

    private CajaLocalHome getCajaLocalHome() {
        return new CajaLocalHome();
    }
    
    private CanalLocalHome getCanalLocalHome() {
        return new CanalLocalHome();
    }
    
    private CierreDeCajaCabeceraLocalHome getCierreDeCajaCabeceraLocalHome() {
      return new CierreDeCajaCabeceraLocalHome();
    }
    
    private CierreDeCajaDetalleLocalHome getCierreDeCajaDetalleLocalHome() {
      return new CierreDeCajaDetalleLocalHome();
    }
    
    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
      return new Entidadi18nLocalHome();
    }   
    
    private MediosDePagoBelcenterLocalHome getMediosDePagoBelcenterLocalHome() {
      return new MediosDePagoBelcenterLocalHome();
    }
    
    private MediosDePagoLocalHome getMediosDePagoLocalHome() {
      return new MediosDePagoLocalHome();
    } 
    
    private MONCambiosVentasHome getMONCambiosVentasHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONCambiosVentasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCambiosVentas"), MONCambiosVentasHome.class);
    }
    
    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONMantenimientoSEGHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
    }
    
    private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
    }
    
    private MONRegistroAbastecimientoHome getMONRegistroAbastecimientoHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONRegistroAbastecimientoHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRegistroAbastecimiento"), MONRegistroAbastecimientoHome.class);    
    }
    
    private MONServicioBELHome getMONServicioBELHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONServicioBELHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONServicioBEL"), MONServicioBELHome.class);
    }
    
    private MovimientosDeCajaCabeceraLocalHome getMovimientosDeCajaCabeceraLocalHome() {
      return new MovimientosDeCajaCabeceraLocalHome();
    }
    
    private MovimientosDeCajaDetalleLocalHome getMovimientosDeCajaDetalleLocalHome() {
      return new MovimientosDeCajaDetalleLocalHome();
    }
    
    private PaisLocalHome getPaisLocalHome() {
      return new PaisLocalHome();
    }
    
    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
      return new ParametrosBelcenterLocalHome();
    }
    
    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }  

  
}