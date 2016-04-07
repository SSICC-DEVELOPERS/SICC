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
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.dtos.cob.DTOCompromisoDePago;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;
import es.indra.sicc.util.COBEjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.entidades.cob.CompromisoPagoLocalHome;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.cob.ErroresDeNegocio;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import java.util.ArrayList;

import es.indra.sicc.entidades.cob.GestionesCobranzaLocal;
import es.indra.sicc.entidades.cob.GestionesCobranzaLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import es.indra.sicc.entidades.cob.CompromisoPagoLocal;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.dtos.cob.DTOUsuariosCobComboPerfil;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocal;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONGestionesDeCobranzaBean implements SessionBean 
{

  SessionContext ctx= null;
  
  
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
   this.ctx =  ctx;
  }
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida obtenerUsuariosCobCombo(DTOBelcorp dto) throws MareException
  {
    DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
    return daoGestCob.obtenerUsuariosCobCombo(dto);
  }
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBuscarGestionesDeCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto) throws MareException{
    UtilidadesLog.info("MONGestionesDeCobranzaBean.buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto): Entrada");
  
    DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
    
    UtilidadesLog.info("MONGestionesDeCobranzaBean.buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto): Salida");
    
    return daoGestCob.buscarGestionesDeCobranzaSB(dto);
  }
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBuscarGestionesDeCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarGestionesDeCobranzaPG(DTOBuscarGestionesDeCobranza dto) throws MareException
  {
   
    DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
    return daoGestCob.buscarGestionesDeCobranzaPG(dto);
  }
  /** 
  * Descripcion aqui
  * @Author: sssantana, 18/2/2005
  * @param DTOGestionDeCobranza dto
  * @return void
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public void guardarGestion(DTOGestionDeCobranza dto) throws MareException{
    UtilidadesLog.info("MONGestionesDeCobranzaBean.guardarGestion(DTOGestionDeCobranza dto): Entrada");
  
    Long oidCliente = null;
    if(dto.getUsuarioCobranza()!=null){
      oidCliente = this.obtenerUsuarioCobranza(dto.getUsuarioCobranza());
    }
    Long oid = dto.getOid();
    UtilidadesLog.debug("Oid a buscar: " + oid);
    try { 
    
      GestionesCobranzaLocalHome gCobranzaLocalHome = 
                                            this.getGestionesCobranzaLocalHome();
      GestionesCobranzaLocal gCobranzaLocal =
                                            gCobranzaLocalHome.findByPrimaryKey(oid);
                                              
      gCobranzaLocal.setVisadoAdministrador(new Boolean(true));
      gCobranzaLocal.setObservaciones(dto.getObservaciones());
      gCobranzaLocal.setUsuarioCobranzas(oidCliente);
      gCobranzaLocal.setFechaSeguimiento(dto.getFechaSeguimiento());
      gCobranzaLocal.setHoraSeguimiento(dto.getHoraSeguimiento());
      
      gCobranzaLocalHome.merge(gCobranzaLocal);      
      
  } catch(NoResultException nre) {
      ctx.setRollbackOnly();
      nre.printStackTrace();
      throw new MareException(nre, 
      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
  } catch(PersistenceException pex) {
      ctx.setRollbackOnly();
      pex.printStackTrace();
      throw new MareException(pex, 
      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
  }
    
    UtilidadesLog.info("MONGestionesDeCobranzaBean.guardarGestion(DTOGestionDeCobranza dto): Salida");
  } 
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOOID dto
  * @return DTOGestionDeCobranza
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  * Modificado: Cristian Valenzuela - 19/10/2005
  * Incidencia BELC300021226 - Se modifico un casteo, debido a
  * un cambio en la tabla ZON_TERRI,
  */
  public DTOGestionDeCobranza detalleGestion(DTOOID dto) throws MareException{
    UtilidadesLog.info("MONGestionesDeCobranzaBean.detalleGestion(DTOOID dto): Entrada");
  
    DTOGestionDeCobranza dtoRes = new DTOGestionDeCobranza();
    DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
    
    DTOSalida resQuery = daoGestCob.detalleGestion(dto);
    
    if ((resQuery.getResultado()!=null)&&
        (!resQuery.getResultado().esVacio())) {
        
        RecordSet rs = resQuery.getResultado();
   

        dtoRes.setApellidos((String)rs.getValueAt(0,"APELLIDOS"));
        dtoRes.setAportaPrueba(BigToBoolean(rs.getValueAt(0,"APORTAPRUEBA")));
        dtoRes.setCodCompromisoPago(BigToInteger(rs.getValueAt(0,"COMPROMISOPAGO")));
        dtoRes.setCodigoBanco((String)rs.getValueAt(0,"BANCO"));
        dtoRes.setCodigoCliente((String)rs.getValueAt(0,"CODIGOCLIENTE"));
        dtoRes.setCodigoSucursal((String)rs.getValueAt(0,"SUCURSAL"));
        dtoRes.setDescripcionPrueba((String)rs.getValueAt(0,"DESCRIPCIONPRUEBA"));
        dtoRes.setFechaReprogramacion((Date)rs.getValueAt(0,"FECHAREPROGRAMACION"));
        dtoRes.setFechaSeguimiento((Date)rs.getValueAt(0,"FECHASEGUIMIENTO"));
        dtoRes.setHoraReprogramacion((String)rs.getValueAt(0,"HORAREPROGRAMACION"));
        dtoRes.setHoraSeguimiento((String)rs.getValueAt(0,"HORASEGUIMIENTO"));
        dtoRes.setMarcaComisionCalculada(BigToBoolean(rs.getValueAt(0,"MARCACOMISIONCALC")));
        dtoRes.setOidMotivoNoCobro(BigToLong(rs.getValueAt(0,"OIDMOTIVONOCOBRO")));
        dtoRes.setNombre((String)rs.getValueAt(0,"NOMBRE"));
        dtoRes.setNuevaDireccion((String)rs.getValueAt(0,"NUEVADIRECCION"));
        dtoRes.setNuevoTelefono((String)rs.getValueAt(0,"NUEVOTELEFONO"));
        dtoRes.setNumeroDocSoporte(BigToLong(rs.getValueAt(0,"NUMERODOCSOPORTE")));
        dtoRes.setObservaciones((String)rs.getValueAt(0,"OBSERVACIONES"));
        dtoRes.setOid(dto.getOid());
        dtoRes.setOidAccion(BigToLong(rs.getValueAt(0,"OIDACCION")));
        dtoRes.setOidCanal(BigToLong(rs.getValueAt(0,"OIDCANAL")));
        dtoRes.setOidCliente(BigToLong(rs.getValueAt(0,"OIDCLIENTE")));
        dtoRes.setOidCompromisoPago(BigToLong(rs.getValueAt(0,"OIDCOMPROMISOPAGO")));
        dtoRes.setOidEtapaDeuda(BigToLong(rs.getValueAt(0,"OIDETAPA")));
        dtoRes.setOidMarca(BigToLong(rs.getValueAt(0,"OIDMARCA")));
        dtoRes.setOidPeriodo(BigToLong(rs.getValueAt(0,"OIDPERIODO")));
        dtoRes.setOidRegion(BigToLong(rs.getValueAt(0,"OIDREGION")));
        dtoRes.setOidSeccion(BigToLong(rs.getValueAt(0,"OIDSECCION")));
        dtoRes.setOidSubgerenciaVentas(BigToLong(rs.getValueAt(0,"OIDSUBGERENCIAVENTAS")));
        dtoRes.setOidSucursal(BigToLong(rs.getValueAt(0,"OIDSUCURSAL")));
        dtoRes.setOidTerritorio(BigToLong(rs.getValueAt(0,"OIDTERRITORIO")));
        dtoRes.setOidUsuarioCobranza(BigToLong(rs.getValueAt(0,"OIDUSUARIOCOBRANZA")));
        dtoRes.setOidZona(BigToLong(rs.getValueAt(0,"OIDZONA")));
        dtoRes.setPasaAdministrador(BigToBoolean(rs.getValueAt(0,"PASAADMINISTRADOR")));
        dtoRes.setPeticionBloqueoAdmin(BigToBoolean(rs.getValueAt(0,"PETICIONBLOQUEO")));
        dtoRes.setPeticionDesbloqueoAdmin(BigToBoolean(rs.getValueAt(0,"PETICIONDESBLOQUEO")));
        dtoRes.setOidTipoDocPago(BigToLong(rs.getValueAt(0,"OIDTIPODOCUMENTOPAGO")));
        dtoRes.setVisadoAdministrador(BigToBoolean(rs.getValueAt(0,"VISADOADMINISTRADOR"))); 
        //tipocargo sobra y todas los codigos marca, canal, periodo, region ...        
        //El metodo del dao esta obteniendo descripciones en lugar de oids segun inc. 13249
        //Este metodo no es llamado de ningun CU de parte cliente de N037      
        
        //Se agregan asignaciones que no constan en el modelo, pero que son requeridas por
        // el paq N036
        dtoRes.setUsuarioCobranza((String)rs.getValueAt(0,"USUARIOCOBRANZA"));
        dtoRes.setEtapaDeuda((String)rs.getValueAt(0,"ETAPA"));
        dtoRes.setMarca((String)rs.getValueAt(0,"MARCA"));
        dtoRes.setCanal((String)rs.getValueAt(0,"CANAL"));
        dtoRes.setPeriodo((String)rs.getValueAt(0,"PERIODO"));
        dtoRes.setSubgerenciaVentas((String)rs.getValueAt(0,"SUBGERENCIAVENTAS"));
        dtoRes.setRegion((String)rs.getValueAt(0,"REGION"));
        dtoRes.setZona((String)rs.getValueAt(0,"ZONA"));
        dtoRes.setSeccion((String)rs.getValueAt(0,"SECCION"));
        //MODIFICADO POR CRISTIAN VALENZUELA - 19/10/2005
        //EN LA TABLA ZON_TERRI, EL CAMPO COD_TERR PASO DE VARCHAR A NUMBER 
        //dtoRes.setTerritorio((String)rs.getValueAt(0,"TERRITORIO"));
        dtoRes.setTerritorio(((BigDecimal)rs.getValueAt(0, "TERRITORIO")).toString());
        //FIN - MODIFICADO POR CRISTIAN VALENZUELA - 19/10/2005
        dtoRes.setTipoCargo((String)rs.getValueAt(0,"TIPOCARGO"));
        dtoRes.setAccion((String)rs.getValueAt(0,"ACCION"));
        dtoRes.setMotivoNoCobro((String)rs.getValueAt(0,"MOTIVONOCOBRO"));
        dtoRes.setTipoDocPago((String)(rs.getValueAt(0,"TIPODOCUMENTOPAGO")));
    }
     
    UtilidadesLog.info("MONGestionesDeCobranzaBean.detalleGestion(DTOOID dto): Salida");
     
    return dtoRes;
  }
  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida obtenerUsuariosCobComboMenos1(DTOOID dto) throws MareException
  {
    DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
    return daoGestCob.obtenerUsuariosCobComboMenos1(dto);
  }
  /** 
  * Metodo de apoyo que transforma un BigDecimal a Boolean
  * @param Object num
  * @return Boolean
  * @exception 
  * @author enozigli
  * @referencia 
  */  
  private Boolean BigToBoolean(Object num) {
    if (num != null) {
        BigDecimal n = (BigDecimal) num;
        if (n.equals(new BigDecimal(0))){
          return new Boolean(false);
        } else {
          return new Boolean(true);
        }
    } else {
        return null;
    }
  }
  /** 
  * Metodo de apoyo que transforma un BigDecimal a Integer
  * @param Object num
  * @return Integer
  * @exception 
  * @author enozigli
  * @referencia 
  */  
  private Integer BigToInteger(Object num) {
        if (num != null) {
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            return null;
        }
  }
  /** 
  * Metodo de apoyo que transforma un BigDecimal a Long
  * @param Object num
  * @return Long
  * @exception 
  * @author enozigli
  * @referencia 
  */  
  private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
  }


    /** 
     * Metodo intermediario para poder llamar al DAO remotamente
     * @param DTOOID dto
     * @return DTOSalida
     * @exception MareException 
     * @author cargain
     * @referencia SICC-DMCO-COB-201-324-N036
     */
    public DTOSalida compromisoPago(DTOEBuscarCompromisosPago dto) throws MareException{
        UtilidadesLog.info("MONGestionesDeCobranzaBean.compromisoPago(DTOEBuscarCompromisosPago dto): Entrada");
    
        /*-> Llamar al método 
        *  "DAOGestionesDeCobranza.compromisoPago(dto : DTOOID) : DTOSalida" 
        *  pasando "dto" como parámetro de entrada 
        -> Retornar el DTOSal   
        * */
        DAOGestionesDeCobranza daoGestCob = new DAOGestionesDeCobranza();
        DTOSalida dtoS = daoGestCob.compromisoPago(dto);
        
        UtilidadesLog.info("MONGestionesDeCobranzaBean.compromisoPago(DTOEBuscarCompromisosPago dto): Salida");
        
        return dtoS;
    }

  /** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOGestionDeCobranza dto
  * @return void
  * @exception MareException 
  * @author Viviana Bongiovanni
  * @referencia SICC-DMCO-COB-201-324-N038
  */
    public void crearGestion(DTOGestionDeCobranza dto) throws MareException {
    
        UtilidadesLog.info("MONGestionesDeCobranzaBean.crearGestion(DTOGestionDeCobranza dto): Entrada");
    
       // Inserta la accion de cobranza
      try{
           UtilidadesLog.debug("DTOGestionDeCobranza: " + dto);
           
           DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
           dtoNumeroSolicitud.setOperacion("COB072");
           dtoNumeroSolicitud.setOidPais(dto.getOidPais());
           
           MONProcesosPEDHome monProcesosPEDHome = PEDEjbLocators.getMONProcesosPEDHome();
           MONProcesosPED monProcesos = monProcesosPEDHome.create();
           
           String orden = monProcesos.generaNumeroDocumento(dtoNumeroSolicitud);
           UtilidadesLog.debug("generaNumeroDocumento: " + orden);
           
           DTOUsuariosPerfil dtoUsuPerf = new DTOUsuariosPerfil();
           
           dtoUsuPerf.setOidPais(dto.getOidPais());
           dtoUsuPerf.setLoginUsuario(ctx.getCallerPrincipal().getName());
           
           DAOGestionesDeCobranza daoGestCob=  new DAOGestionesDeCobranza();
           Long usuCob= daoGestCob.recuperarUsuario (dtoUsuPerf);
           
           GestionesCobranzaLocalHome  gestionCobeHome = this.getGestionesCobranzaLocalHome();    
           
           // Falta orden y usuario de cobranza
           //Integer orden, Long cliente, Long periodo, Long etapaDeuda, Long usuarioCobranzas, Long codigoAccion
           GestionesCobranzaLocal gestionesCobranzaLocal = gestionCobeHome.create(orden, dto.getOidCliente(), dto.getOidPeriodo(), dto.getOidEtapaDeuda(), usuCob, dto.getOidAccion());
           
           gestionesCobranzaLocal.setOidSociedad(dto.getOidEmpresa());
           gestionesCobranzaLocal.setOidEtapaDTipoCargo(dto.getOidTipoCargoAbono());
           gestionesCobranzaLocal.setFechaSeguimiento(dto.getFechaSeguimiento());
           gestionesCobranzaLocal.setHoraSeguimiento(dto.getHoraSeguimiento());
           gestionesCobranzaLocal.setFechaReprogramacion(dto.getFechaReprogramacion());
           gestionesCobranzaLocal.setHoraReprogramacion(dto.getHoraReprogramacion());
           gestionesCobranzaLocal.setAportaPrueba(dto.getAportaPrueba());
           gestionesCobranzaLocal.setDescripcionPrueba(dto.getDescripcionPrueba());
           
           if(dto.getNumeroDocSoporte()!=null)
              gestionesCobranzaLocal.setNumeroDocumentoSoporte(new BigDecimal(dto.getNumeroDocSoporte().toString()));
                
           gestionesCobranzaLocal.setTipoDocumentoPago(dto.getOidMedioPago());
           gestionesCobranzaLocal.setSucursal(dto.getOidSucursal());
           gestionesCobranzaLocal.setNuevaDireccion(dto.getNuevaDireccion());
           gestionesCobranzaLocal.setNuevoTelefono(dto.getNuevoTelefono());
           gestionesCobranzaLocal.setPasaAdministrador(dto.getPasaAdministrador());
           gestionesCobranzaLocal.setPeticionBloqueo(dto.getPeticionBloqueoAdmin());
           gestionesCobranzaLocal.setPeticionDesbloqueo(dto.getPeticionDesbloqueoAdmin());
           gestionesCobranzaLocal.setMotivoNoCobro(dto.getOidMotivoNoCobro());
           gestionesCobranzaLocal.setObservaciones(dto.getObservaciones());
           gestionesCobranzaLocal.setFechaGestion(new Date(System.currentTimeMillis()));    
           gestionesCobranzaLocal.setOidTipoBloqueo(dto.getOidTipoBloqueo());
           
           gestionCobeHome.merge(gestionesCobranzaLocal);
                      
           // Inserta los compromisos de pago
           CompromisoPagoLocalHome  compPagoHome = this.getCompromisoPagoLocalHome();   
           
           ArrayList arrLstCompromisosDePago = dto.getCompromisosDePago();
           DTOCompromisoDePago dtoCompromisoPago = null;
           int cont = 1;
           
           UtilidadesLog.debug("Tamano:" + arrLstCompromisosDePago.size());
                  
           for(int i=0;i< arrLstCompromisosDePago.size();i++){
              dtoCompromisoPago = (DTOCompromisoDePago)arrLstCompromisosDePago.get(i);
              //Long codigoCompromisoPago, Date fechaPago, BigDecimal importePago, Date fechaSeguimientoPrevisto, Long sucursal, Long orden
              CompromisoPagoLocal  compromisoPagoLocal = compPagoHome.create(new Long(cont), dtoCompromisoPago.getFechaPago(), dtoCompromisoPago.getImportePago(), dtoCompromisoPago.getFechaSeguimientoPrevisto(), dtoCompromisoPago.getSucursal(), gestionesCobranzaLocal.getOid());              
              compromisoPagoLocal.setObservaciones(dtoCompromisoPago.getObservaciones());
              compromisoPagoLocal.setFechaCompromiso(dtoCompromisoPago.getFechaCompromisoPago());
              
               compPagoHome.merge(compromisoPagoLocal);
              
              cont++;
           }              
       
       } catch(PersistenceException pex) {
           ctx.setRollbackOnly();
           pex.printStackTrace();
           throw new MareException(pex, 
           UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       } catch (CreateException ce) {
          UtilidadesLog.error(ce);
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
       } catch (RemoteException re) {
          UtilidadesLog.error(re);
          throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
       } 
       
        UtilidadesLog.info("MONGestionesDeCobranzaBean.crearGestion(DTOGestionDeCobranza dto): Salida");
       
    }

 /** 
  * Descripción 
  * @param DTOGestionDeCobranza dto
  * @return void
  * @exception MareException 
  * @author pcabrera
  * @referencia SICC-DMCO-COB-201-324-N036
  */ 
   public void guardarBloqueoDesbloqueo(DTOGestionDeCobranza dto) throws MareException{
   
    UtilidadesLog.info("MONGestionesDeCobranzaBean.guardarBloqueoDesbloqueo(DTOGestionDeCobranza dto): Entrada");
    
        /** Documentation
          -> con el oid recibido en el DTO hacer una modificación en la entidad 
          GestionesCobranza, actualizando el campo Observaciones con el Motivo 
          introducido y el campo Visado administrador = "S", con el código de 
          usuario y la fecha/hora de autorización (=fecha sistema). 
          
          -> Hacer una busqueda en la entidad MAE_CLIEN por el codigoCliente y 
          pais activo, recuperarando el oidCliente 
          
          ->En la entidad ClienteBloqueo hacer un findByClienteTipoBloqueo
          (oidCliente, ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO) 
          si retorna valores 
          entonces remove. 
          sino 
          se crea una entrada en la entidad con: 
          motivoBloqueo = observaciones 
          observacionesBloqueo = observaciones 
          fechaBloqueo = fecha del sistema 
          usuarioBloqueo = usuario activo 
          
          -> En la entidad ClienteBloqueo hacer un findByClienteTipoBloqueo
          (oidCliente, ConstantesMAE.OID_BLOQUEO_FINANCIERO) 
          si retorna valores 
          entonces remove. 
          sino 
          se crea una entrada en la entidad con: 
          motivoBloqueo = observaciones 
          observacionesBloqueo = observaciones 
          fechaBloqueo = fecha del sistema 
          usuarioBloqueo = usuario activo 

    */
    
    Date fechaProceso = new Date(System.currentTimeMillis());   
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Long oid = dto.getOid();
    UtilidadesLog.debug("Oid a buscar: " + oid);
    
    Long user = this.obtenerIdCliente(ctx.getCallerPrincipal().getName());   
    UtilidadesLog.debug("user-- " + user.toString());
     //Modificado por Hugo Mansi
    //23/11/2005 Incidencia de Perú de COB
    //Se agrego findByUK en entidades Cob porque es necesario recuperar el oid del usuario de cobranzas
    //para setearlo luego a la gestion de cobranzas
    Long usuCobr;   
    
    try {
      UsuariosCobranzasLocalHome usuaCobLH = this.getUsuariosCobranzasLocalHome();
      UsuariosCobranzasLocal usuLocal = usuaCobLH.findByUK(dto.getOidPais(),user);
      usuCobr = usuLocal.getOid();
    } catch(NoResultException nre) {
        ctx.setRollbackOnly();
        nre.printStackTrace();
        throw new MareException(nre, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException pex) {
        ctx.setRollbackOnly();
        pex.printStackTrace();
        throw new MareException(pex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    try{ 
    
    
        ///Falta ... se levanta una incidencia
        GestionesCobranzaLocalHome gCobranzaLocalHome = this.getGestionesCobranzaLocalHome();
        GestionesCobranzaLocal gCobranzaLocal =  gCobranzaLocalHome.findByPrimaryKey(oid);
                                              
        gCobranzaLocal.setVisadoAdministrador(new Boolean(true));     
        gCobranzaLocal.setUsuarioCobranzas(usuCobr);
        gCobranzaLocal.setFechaSeguimiento(fechaProceso);
        gCobranzaLocal.setHoraSeguimiento(sdf.format(fechaProceso));
        if(dto.getIndAnular()!=null && dto.getIndAnular().booleanValue()){
           gCobranzaLocal.setObservaciones("Gestion Anulada");
        }else{
           gCobranzaLocal.setObservaciones(dto.getObservaciones());
        }
        
        gCobranzaLocalHome.merge(gCobranzaLocal);
      
    } catch(NoResultException nre) {
        ctx.setRollbackOnly();
        nre.printStackTrace();
        throw new MareException(nre, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException pex) {
        ctx.setRollbackOnly();
        pex.printStackTrace();
        throw new MareException(pex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
           
    if(dto.getIndAnular()==null || !dto.getIndAnular().booleanValue()){
      ClienteDatosBasicosLocal localClientes = null;
       ClienteDatosBasicosLocalHome clientesHome = null;
      try {
            clientesHome = new ClienteDatosBasicosLocalHome();
            localClientes = clientesHome.findByCodigoYPais(dto.getOidPais(),dto.getCodigoCliente());
            dto.setOidCliente(localClientes.getOid());
      } catch (NoResultException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.debug("Error en ClienteDatosBasicosLocal 1");
          UtilidadesLog.debug(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (PersistenceException e) {  
     ctx.setRollbackOnly();
     UtilidadesLog.debug("Error en ClienteDatosBasicosLocal 2");
           UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } 
    
   Long oidCliente = null;
   oidCliente = localClientes.getOid(); 
          
          
          
          
           ClienteBloqueoLocal clienteBloqueoLocal = null;
           ClienteBloqueoLocalHome clienteBloqueoLocalHome = null; 
          UtilidadesLog.debug("fechaProceso>>>>> " + fechaProceso.toString());     
  
               StringBuffer consulta = new StringBuffer();
              
              consulta.append(" SELECT V.OID_VALO_ACCI_BLOQ ");
              consulta.append(" FROM MAE_VALOR_ACCIO_BLOQU V ");
              consulta.append(" WHERE V.COD_VALO_BLOQ = 'M'");
              
              BelcorpService bs = UtilidadesEJB.getBelcorpService();
              RecordSet rs = null;
              String codigoError = null;
              try {
                rs = bs.dbService.executeStaticQuery(consulta.toString());
              } catch (Exception e) {
                      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
              }
             UtilidadesLog.debug("Pais** " + dto.getOidPais());
             UtilidadesLog.debug("Codigo Cliente ** " + dto.getCodigoCliente());
             Long oidAccionManual = new Long(rs.getValueAt(0,0).toString());
             UtilidadesLog.debug("oidAccionManual ** " + oidAccionManual);
   //COL
   if(dto.getPeticionBloqueoAdmin()!= null && dto.getPeticionBloqueoAdmin().booleanValue()){
           
           
           try{
          /*  Long clie_oid_clie, Long tibq_oid_tipo_bloq, Timestamp fec_bloq,
            String val_moti_bloq, String val_usua_bloq, String obs_bloq*/
           clienteBloqueoLocalHome = new ClienteBloqueoLocalHome();
           clienteBloqueoLocal = clienteBloqueoLocalHome.create(dto.getOidCliente(),
                  dto.getOidTipoBloqueo(),new Timestamp(fechaProceso.getTime()),
                  dto.getObservaciones(), ctx.getCallerPrincipal().getName(),
                  dto.getObservacionesBloqueo());
           clienteBloqueoLocal.setMaab_oid_valo_acci_bloq(oidAccionManual);
        
            clienteBloqueoLocalHome.merge(clienteBloqueoLocal);
        
        }catch(PersistenceException  ex){
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));   
        } 
   }
   if(dto.getPeticionDesbloqueoAdmin() !=null &&dto.getPeticionDesbloqueoAdmin().booleanValue()){
     
     
      try {
            if (clienteBloqueoLocalHome == null)
                clienteBloqueoLocalHome = new ClienteBloqueoLocalHome();
            
            clienteBloqueoLocal = clienteBloqueoLocalHome.findByClienteTipoBloqueo(dto.getOidCliente(), dto.getOidTipoBloqueo() );
            clienteBloqueoLocal.setFec_desb(new Timestamp(fechaProceso.getTime()));
            clienteBloqueoLocal.setObs_desb(dto.getObservacionesDesbloqueo());
            clienteBloqueoLocal.setVal_usua_desb(ctx.getCallerPrincipal().getName());
            clienteBloqueoLocal.setMaab_oid_valo_acci_desb(oidAccionManual);
            
            try {
                clienteBloqueoLocalHome.merge(clienteBloqueoLocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }

      } catch (NoResultException e) {     
          UtilidadesLog.debug("Error en clienteBloqueoLocalHome 1", e);
          ctx.setRollbackOnly();
          throw new MareException(e,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));   
      
      }catch (PersistenceException e) {   
          UtilidadesLog.debug("Error en clienteBloqueoLocalHome 2", e);
          ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } 
   }
   
   //COL
   /* try {
            clientesHome = this.getClienteDatosBasicosLocalHome();
            localClientes = clientesHome.findByCodigoYPais(dto.getOidPais(),dto.getCodigoCliente());

      } catch (FinderException fe) {
        UtilidadesLog.debug("Error en ClienteDatosBasicosLocal 1");
          UtilidadesLog.debug(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (NamingException e) {  
     UtilidadesLog.debug("Error en ClienteDatosBasicosLocal 2");
           UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    
   Long oidCliente = null;
   oidCliente = localClientes.getOid(); 
   UtilidadesLog.debug("oidCliente>>> " + oidCliente);   
  
        
   ClienteBloqueoLocal clienteBloqueoLocal = null;
   ClienteBloqueoLocalHome clienteBloqueoLocalHome = null; 
   
   Long tipoBloqueo = dto.getOidTipoBloqueo();
   
   UtilidadesLog.debug("OID tipoBloqueo *** " + dto.getOidTipoBloqueo());
     
    try {
            clienteBloqueoLocalHome = this.getClienteBloqueoLocalHome();
            clienteBloqueoLocal = clienteBloqueoLocalHome.findByClienteTipoBloqueo(oidCliente, ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO);

      } catch (FinderException fe) {      
        UtilidadesLog.debug("Error en clienteBloqueoLocalHome 1");
                            
        try{
            
           clienteBloqueoLocalHome.create(oidCliente, tipoBloqueo,new Timestamp(fechaProceso.getTime()),dto.getObservaciones(), ctx.getCallerPrincipal().getName(), null);
        }catch(CreateException  ex){
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));   
                    
        }          
     }
    catch (NamingException e) {   
          UtilidadesLog.debug("Error en clienteBloqueoLocalHome 2");
           UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    
  try{  
         if (clienteBloqueoLocal!=null){  
              clienteBloqueoLocal.remove();
         
         }
         
  }catch (RemoveException e){
      UtilidadesLog.debug("Error en clienteBloqueoLocalHome 1 .... en el remove");
          UtilidadesLog.error(e);
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB)); 
  }*/
     /*
  ClienteBloqueoLocal clienteBloqueoLocalFinanciero = null;
  ClienteBloqueoLocalHome clienteBloqueoLocalHomeFinanciero = null; 
  
  Long tipoBloqueos = ConstantesMAE.OID_BLOQUEO_FINANCIERO;
     
  UtilidadesLog.debug("ConstantesMAE.OID_BLOQUEO_FINANCIERO ** " + ConstantesMAE.OID_BLOQUEO_FINANCIERO);   
    try {
            clienteBloqueoLocalHomeFinanciero = this.getClienteBloqueoLocalHome();
            clienteBloqueoLocalFinanciero = clienteBloqueoLocalHomeFinanciero.findByClienteTipoBloqueo(oidCliente, ConstantesMAE.OID_BLOQUEO_FINANCIERO);

      } catch (FinderException fe) {
        UtilidadesLog.debug("Error en clienteBloqueoLocalHomeFinanciero 1");
       
       try{
            
           clienteBloqueoLocalHomeFinanciero.create(oidCliente, tipoBloqueos,new Timestamp(fechaProceso.getTime()),dto.getObservaciones(), ctx.getCallerPrincipal().getName(), null);
        }catch(CreateException  ex){
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw new MareException(ex,UtilidadesError.armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));   
                    
        }       
          
      } catch (NamingException e) {   
        UtilidadesLog.debug("Error en clienteBloqueoLocalHomeFinanciero 2");
           UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    
  try{  
         if (clienteBloqueoLocalFinanciero!=null){   
               clienteBloqueoLocalFinanciero.remove();
         
         }
         
  }catch (RemoveException e){
    UtilidadesLog.debug("Error en clienteBloqueoLocalHomeFinanciero 3");
            UtilidadesLog.error(e);
                  throw new MareException(e,
                      UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB)); 
  
  }      */
   
    }
    UtilidadesLog.info("MONGestionesDeCobranzaBean.guardarBloqueoDesbloqueo(DTOGestionDeCobranza dto): Salida");
 }


    private Long obtenerIdCliente(String name) throws MareException{
    
        UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerIdCliente(String name): Entrada");
    
      Long oidCliente = null;
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      

      query.append(" SELECT p.IDPRINCIPAL ");
      query.append(" FROM PRINCIPALS p  ");
      query.append(" where p.NAME  = '"+ name + "'");
      
      
      try 
        {   
            rs = bs.dbService.executeStaticQuery(query.toString());
            if (rs.esVacio()) {             
                  return null; 
            }
           else {
              oidCliente = BigToLong(rs.getValueAt(0,"IDPRINCIPAL"));
            }
        }
       catch (Exception ex) 
       {   
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       
        UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerIdCliente(String name): Salida");
       
       return oidCliente;   
  }
  
  //vbongiov -- 28/05/2008
  private Long obtenerUsuarioCobranza(String name) throws MareException{
    
      UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerUsuarioCobranza(String name): Entrada");
    
      Long oidCliente = null;
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      

      query.append(" SELECT usuC.OID_USUA_COBR ");
      query.append(" FROM PRINCIPALS p, COB_USUAR_COBRA usuC  ");
      query.append(" where usuC.USER_OID_USUA_COBR = p.IDPRINCIPAL  ");
      query.append(" and p.NAME  = '"+ name + "'");
      
      
      try 
        {   
            rs = bs.dbService.executeStaticQuery(query.toString());
            if (rs.esVacio()) {             
                  return null; 
            }
           else {
              oidCliente = BigToLong(rs.getValueAt(0,"OID_USUA_COBR"));
            }
        }
       catch (Exception ex) 
       {   
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       
        UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerUsuarioCobranza(String name): Salida");
       
       return oidCliente;   
  }


  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       08/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida obtenerMotivosNoCobro(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerMotivosNoCobro(DTOBelcorp dto): Entrada");
  
    DAOGestionesDeCobranza dao = new DAOGestionesDeCobranza();
	DTOSalida dtoSalida = dao.obtenerMotivosNoCobro(dto);
    
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerMotivosNoCobro(DTOBelcorp dto): Salida");
    
	return dtoSalida;     
  }

  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       11/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto) throws MareException {
        UtilidadesLog.info("MONGestionesDeCobranzaBean.buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto): Entrada");
  
        DAOGestionesDeCobranza dao = new DAOGestionesDeCobranza();
		DTOSalida dtoSalida = dao.buscarGestionesDeCobranzaTC(dto);
        
        UtilidadesLog.info("MONGestionesDeCobranzaBean.buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto): Salida");
        
		return dtoSalida;     
  }

  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       17/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOUsuariosCobComboPerfil obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada) throws MareException {
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada): Entrada");
  
    DAOGestionesDeCobranza dao = new DAOGestionesDeCobranza(ctx);
	DTOUsuariosCobComboPerfil dtoUsuariosCobComboPerfil = new DTOUsuariosCobComboPerfil();
    
    dtoUsuariosCobComboPerfil = dao.obtenerUsuariosCobComboPerfil(dtoEntrada);
        
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada): Salida");
        
	return dtoUsuariosCobComboPerfil; 
  }


    public DTOSalida obtenerTiposBloqueo(DTOOID dto) throws MareException
  {
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerTiposBloqueo( ): Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        
        DAOGestionesDeCobranza dao = new DAOGestionesDeCobranza();
        
        RecordSet resultado = null;
        if(dto.getOid()==null){
            resultado = dao.obtenerTiposBloqueo(dto.getOidIdioma(),usuario);  
        }else{
            resultado = dao.obtenerTiposBloqueoCliente(dto,usuario);  
            if(resultado.esVacio()){
               throw new MareException(null, null, 
                                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_018));      
            }
            if(resultado.getValueAt(0,"IND_BLOQ_FINA").toString().equals("1")){
               throw new MareException(null, null, 
                                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_019));      
            }
        }
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(resultado);
        
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerTiposBloqueo( ): Salida");
    return dtoS;
  }
  
  public DTOSalida obtenerBloqueoCliente(DTOGestionDeCobranza dto) throws MareException
  {
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerBloqueoCliente( ): Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        
        Date fechaActual = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        
        dto.setUsuarioCobranza(usuario);
        dto.setFechaSeguimiento(fechaActual);
        dto.setHoraSeguimiento(sdf.format(fechaActual));
        
        UtilidadesLog.info("DTO "+ dto );
        
        DAOGestionesDeCobranza dao = new DAOGestionesDeCobranza();
        RecordSet resultado = null;
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(dto.getOidCliente());
        dtoOID.setOidIdioma(dto.getOidIdioma());
        dtoOID.setOidPais(dto.getOidPais());
        
        resultado = dao.obtenerTiposBloqueoCliente(dtoOID,usuario);  
        UtilidadesLog.info("Resultado "+ resultado );
        
        // vbongiov --27/05/2008
        if(dto.getPeticionBloqueoAdmin().booleanValue() && !resultado.esVacio()){
            this.guardarGestion(dto);
        }
        
        if(dto.getPeticionDesbloqueoAdmin().booleanValue()&&resultado.esVacio()){
             this.guardarGestion(dto);
        }
        
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(resultado);
        
    UtilidadesLog.info("MONGestionesDeCobranzaBean.obtenerBloqueoCliente( ): Salida");
    return dtoS;
  }
  
  
    private GestionesCobranzaLocalHome getGestionesCobranzaLocalHome() 
    {
    return new GestionesCobranzaLocalHome();
    }

    private UsuariosCobranzasLocalHome getUsuariosCobranzasLocalHome()
    {
    return new UsuariosCobranzasLocalHome();
    }

    private CompromisoPagoLocalHome getCompromisoPagoLocalHome() 
    {
    return new CompromisoPagoLocalHome();
    }

}
