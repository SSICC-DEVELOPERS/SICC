package es.indra.sicc.logicanegocio.cal;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.cal.ConstantesCAL;
import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;
import es.indra.sicc.entidades.cal.CabeceraBuzonLocal;
import es.indra.sicc.entidades.cal.CabeceraBuzonLocalHome;
import es.indra.sicc.entidades.cal.DetalleBuzonLocal;
import es.indra.sicc.entidades.cal.DetalleBuzonLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.Date;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONBuzonBean implements SessionBean  {
  public void ejbCreate() {  }
  public void ejbActivate() {  }
  public void ejbPassivate() {  }
  public void ejbRemove() {  }

  SessionContext ctx = null;

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  /**
   * Metodo: obtenerCabeceraBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 16/12/2004
   * Descripcion: Este metodo llama al metodo del mismo nombre en la clase DAOBuzon
   */

  public DTOSalida obtenerCabeceraBuzon(DTOBusqueda dtoe) throws MareException {
    UtilidadesLog.info("MONBuzonBean.obtenerCabeceraBuzon(DTOBusqueda dtoe): Entrada");
  
    /*Se crea un DTOSalida 
      DTOSalida.resultado= llamar al método obtenerCabeceraBuzon(DTOE) del DAOBuzon */

    DTOSalida dtoSal = new DTOSalida();
    DAOBuzon dao = new DAOBuzon();
    RecordSet rs = dao.obtenerCabeceraBuzon(dtoe);
    dtoSal.setResultado(rs);    
  
    UtilidadesLog.info("MONBuzonBean.obtenerCabeceraBuzon(DTOBusqueda dtoe): Salida");
  
    return dtoSal;
  }

  /**
   * Metodo: insertarCabeceraBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo permite insertar un registro en la tabla CAL_CABEC_BUZON
   */

  public void insertarCabeceraBuzon(DTOCabecera dtoe) throws MareException {
    UtilidadesLog.info("MONBuzonBean.insertarCabeceraBuzon(DTOCabecera dtoe): Entrada");
  
    /*Crea una nueva cabeceraBuzon en la entidad CabeceraBuzon con la siguiente información: 

      - cabeceraBuzon.codBuzon = DTOE.codBuzon 
      - cabeceraBuzon.idUsuario = DTOE.idUsuario 
      - cabeceraBuzon.descripcion = DTOE.descripcion */       

    try {
      CabeceraBuzonLocalHome cblh = this.getCabeceraBuzonLocalHome();
      CabeceraBuzonLocal cbl = cblh.create(dtoe.getCodBuzon(), dtoe.getIdUsuario(), dtoe.getDescripcion(), dtoe.getOidPais());      
    }  
    
    catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        throw new MareException(pe,
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
    
    UtilidadesLog.info("MONBuzonBean.insertarCabeceraBuzon(DTOCabecera dtoe): Salida");
    
  }

  /**
   * Metodo: insertarDetalleBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo permite insertar o actualizar un registro en la tabla CAL_DETAL_BUZON
   */

  public void insertarDetalleBuzon(DTODetalle dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.insertarDetalleBuzon(DTODetalle dtoe): Entrada");
  
    /*Si DTOE.oidDetalle == null { 
      Crea un nuevo detalleBuzon en la entidad: DetalleBuzon con la siguiente información: 

      - detalleBuzon.oidCabecera = DTOE.oidCabecera 
      - detalleBuzon.codActividad = se le asignará el mismo valor que el oidDetalle del mismo registro. 
      - detalleBuzon.descripcionActividad = DTOE.descripcionActividad 
      - detalleBuzon.fechaHoraCreacion = fecha y hora del sistema 
      - detalleBuzon.codContacto = DTOE.oidContacto 
      - detalleBuzon.codGestion = DTOE.oidGestion 
      - detalleBuzon.observaciones = DTOE.observaciones 
      - detalleBuzon.idUsuario = Llama al método getCallerPrincipal()
      del contexto del EJB y obtiene el código del usuario 
      - detalleBuzon.estatusActividad = ConstantesCAL.ESTADO_NO_PROCESADO 
      } 

      En otro caso { 
      // Actualiza la información del detalle de un buzón 
      detalleBuzon = Llamar al método findByPrimaryKey(DTOE.oidDetalle) de la entidad CAL:DetalleBuzon 

      Actualiza la siguiente información del detalle del buzón: 

      - detalleBuzon.descripcionActividad = DTOE.descripcionActividad 
      - detalleBuzon.codContacto = DTOE.oidContacto 
      - detalleBuzon.codGestion = DTOE.oidGestion 
      - detalleBuzon.observaciones = DTOE.observaciones 

      }  */    

    try {
      UtilidadesLog.debug("******* oidDetalle " + dtoe.getOidDetalle());

      Date fechaSistema = new Date();
      Timestamp ts1 = new Timestamp(fechaSistema.getTime());      

      String usuario = ctx.getCallerPrincipal().getName();

      if(dtoe.getOidDetalle()==null) {
        DetalleBuzonLocalHome dblh = this.getDetalleBuzonLocalHome();
        //El codigo de actividad esta hardcodeado a 1 porque de todas maneras
        //este valor sera pisado por el oid que se obtiene del secuenciador. (Ver entidad)
        
        /* mamontie 30/09/05
         * Incidencia 17052
         * */
        Long cod_acti = obtenerNumeroSecuencialProximoDetalle(dtoe.getOidCabecera());
         
        DetalleBuzonLocal dbl = dblh.create(cod_acti, dtoe.getDescripcionActividad(), ts1, usuario, dtoe.getOidCabecera(), dtoe.getOidContacto(), ConstantesCAL.NO_PROCESADO);
        
        //Se setean los valores restantes si es que tienen valor
        if(dtoe.getOidGestion()!=null) {
          dbl.setOidTipoGestion(dtoe.getOidGestion());
          
        }

        if(dtoe.getObservaciones()!=null && dtoe.getObservaciones()!="") {
          dbl.setObservaciones(dtoe.getObservaciones());
          
        }
        dblh.merge(dbl);
      }
      else {
        DetalleBuzonLocalHome dblh = this.getDetalleBuzonLocalHome();
        DetalleBuzonLocal dbl = dblh.findByPrimaryKey(dtoe.getOidDetalle());

        dbl.setDescripcionActividad(dtoe.getDescripcionActividad());
        dbl.setOidContacto(dtoe.getOidContacto());
        dbl.setOidTipoGestion(dtoe.getOidGestion());
        dbl.setObservaciones(dtoe.getObservaciones()); 
        dblh.merge(dbl);
      }      
    }
    catch (NoResultException nre) {
      UtilidadesLog.error(nre);
      ctx.setRollbackOnly();
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (PersistenceException e) {
        ctx.setRollbackOnly();
        throw new MareException(e,
           UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }        
    
    UtilidadesLog.info("MONBuzonBean.insertarDetalleBuzon(DTODetalle dtoe): Salida");
  }

  /**
   * Metodo: obtenerDetalleBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 16/12/2004
   * Descripcion: Este metodo llama al metodo del mismo nombre en la clase DAOBuzon
   */

  public DTOSalida obtenerDetalleBuzon(DTOBusqueda dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.obtenerDetalleBuzon(DTOBusqueda dtoe): Entrada");
  
    /*Se crea un DTOSalida 
      DTOSalida.resultado= llamar al método obtenerDetalleBuzon(DTOE) del DAOBuzon */

    DTOSalida dtoSal = new DTOSalida();
    DAOBuzon dao = new DAOBuzon();
    RecordSet rs = dao.obtenerDetalleBuzon(dtoe);
    dtoSal.setResultado(rs);      
    
    UtilidadesLog.info("MONBuzonBean.obtenerDetalleBuzon(DTOBusqueda dtoe): Salida");
    
    return dtoSal;
  }

  /**
   * Metodo: procesarActividad
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo cambia el valor del campo OID_ESTATUS_ACTIVIDAD_CONTACTO en la tabla CAL_DETAL_BUZON
   */

  public void procesarActividad(DTODetalle dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.procesarActividad(DTODetalle dtoe): Entrada");
  
    /*//Cambia el estatus de actividad, de procesado a no procesado. 
        detalleBuzon = Llamar al método findByPrimaryKey(DTOE.oidDetalle) de la entidad CAL:DetalleBuzon 
        - detalleBuzon.estatusActividad = ConstantesCAL.ESTADO_PROCESADO */

    try {
      
      DetalleBuzonLocalHome dblh = this.getDetalleBuzonLocalHome();
      DetalleBuzonLocal dbl = dblh.findByPrimaryKey(dtoe.getOidDetalle());
      dbl.setEstatusActividad(ConstantesCAL.PROCESADO);    
      dblh.merge(dbl);
    }
    catch (NoResultException nre) {
      UtilidadesLog.error(nre);
      ctx.setRollbackOnly();
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (PersistenceException e) {
          ctx.setRollbackOnly();
          throw new MareException(e,
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }
    
        UtilidadesLog.info("MONBuzonBean.procesarActividad(DTODetalle dtoe): Salida");
    
  }

  /**
   * Metodo: redirigirActividad
   * Autor: Cristian Valenzuela
   * Fecha: 22/12/2004
   * Descripcion: 
   */

  public void redirigirActividad(DTORedirigirDetalle dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.redirigirActividad(DTORedirigirDetalle dtoe): Entrada");
  
    /* ACLARACION: Modelo parcial obtenido de la respuesta de la incidencia 11580
     
      redirigirActividad(DTOE : DTORedirigirDetalle){

      Para cada detalle recibido en  DTOE.ListaOidDetalle {
      detalleBuzon = Llamar al método findByPrimaryKey(DTOE.ListaOidDetalle[i]) de la entidad DetalleBuzon
      - detalleBuzon.estatusActividad = ConstantesCAL.ESTADO_PROCESADO

      Llamar al método Create de la entidad DetalleBuzon con los siguientes parámetros:
         - *Buzon(que es el oidCabeceraBuzon)=DTOE.oidCabeceraNuevo
         - *Contacto=detalleBuzon.codContacto
         - *estatusActividad = ConstantesCAL.ESTADO_NO_PROCESADO
         - +Gestion=detalleBuzon.codGestion
         - *codActividad=oidDetalleBuzon que se haya generado para el registro
         - *descripcionActividad=detalleBuzon.descripcionActividad 
         - *fechaHoraCreacion=detalleBuzon.fechaHoraCreacion
         - +observaciones=detalleBuzon.observaciones
         - *idUsuario=detalleBuzon=idUsuario
      }
    }*/

    try {
      Long[] listaOid = dtoe.getListaOidDetalle();

      for(int i=0; i<listaOid.length; i++) {
        DetalleBuzonLocalHome dblh = this.getDetalleBuzonLocalHome();
        DetalleBuzonLocal dbl = dblh.findByPrimaryKey(listaOid[i]);
        UtilidadesLog.debug(listaOid[i].toString());
        dbl.setEstatusActividad(ConstantesCAL.PROCESADO);
          dblh.merge(dbl);
        DetalleBuzonLocalHome dblh2 = this.getDetalleBuzonLocalHome();
        //El primer parametro esta hardcodeado a 1 porque
        //este valor se pisara en el create de la entidad. (Ver entidad DetalleBuzon)
        
         /* mamontie 30/09/05
         * Incidencia 17052
         * */
        
        /**
         * pperez - Incidencia DBLG300000074
         * 12/05/2005
         * */ 
        //Long cod_acti = obtenerNumeroSecuencialProximoDetalle(dtoe.getOidCabecera());
        Long cod_acti = obtenerNumeroSecuencialProximoDetalle(dtoe.getOidCabeceraNuevo());
         
        DetalleBuzonLocal dbl2 = dblh2.create(cod_acti, dbl.getDescripcionActividad(), dbl.getFechaHoraCreacion(), dbl.getCodUsuario(), dtoe.getOidCabeceraNuevo(), dbl.getOidContacto(), ConstantesCAL.NO_PROCESADO);

        //Se setean el resto de los campos no obligatorios, si es que hay algun
        //valor en la interfaz Local que se obtuvo en el metodo findByPrimaryKey de la
        //entidad DetalleBuzon
        if(dbl.getObservaciones()!=null) {
          dbl2.setObservaciones(dbl.getObservaciones());
            
        }

        if(dbl.getOidTipoGestion()!=null) {
          dbl2.setOidTipoGestion(dbl.getOidTipoGestion());          
        }
          dblh2.merge(dbl2);
      }           
    }    
    catch (NoResultException nre) {
      UtilidadesLog.error(nre);
      ctx.setRollbackOnly();
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
       }
      
     
        UtilidadesLog.info("MONBuzonBean.redirigirActividad(DTORedirigirDetalle dtoe): Salida");
    
  }

  /**
   * Metodo: obtenerContactosPorCliente
   * Autor: Cristian Valenzuela
   * Fecha: 16/12/2004
   * Descripcion: Este metodo llama al metodo del mismo nombre en la clase DAOBuzon
   */

  public DTOSalida obtenerContactosPorCliente(DTOCliente dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.obtenerContactosPorCliente(DTOCliente dtoe): Entrada");
  
    /*Se crea un DTOSalida 
      DTOSalida.resultado= llamar al método obtenerContactosPorCliente(DTOE) del DAOBuzon */

    DTOSalida dtoSal = new DTOSalida();
    DAOBuzon dao = new DAOBuzon();
    RecordSet rs = dao.obtenerContactosPorCliente(dtoe);
    dtoSal.setResultado(rs);
      
    UtilidadesLog.info("MONBuzonBean.obtenerContactosPorCliente(DTOCliente dtoe): Salida");
      
    return dtoSal;
  }

  /**
   * Metodo: obtenerCodBuzon
   * Autor: Cristian Valenzuela
   * Fecha: 16/12/2004
   * Descripcion: Este metodo llama al metodo del mismo nombre en la claes DAOBuzon
   */

  public DTOSalida obtenerCodBuzon(DTOBelcorp dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.obtenerCodBuzon(DTOBelcorp dtoe): Entrada");
  
    /*Se crea un DTOSalida 
      DTOSalida.resultado = Llamar al método obtenerCodBuzon(DTOE) del DAOBuzon  */

    DTOSalida dtoSal = new DTOSalida();
    DAOBuzon dao = new DAOBuzon();
    RecordSet rs = dao.obtenerCodBuzon(dtoe);
    dtoSal.setResultado(rs);     
    
    UtilidadesLog.info("MONBuzonBean.obtenerCodBuzon(DTOBelcorp dtoe): Salida");
    
    return dtoSal;
  }

  /**
   * Metodo: obtenerGestiones
   * Autor: Cristian Valenzuela
   * Fecha: 16/12/2004
   * Descripcion: Este metodo llama al metodo del mismo nombre en la clae DAOBuzon
   */

  public DTOSalida obtenerGestiones(DTOBelcorp dtoe) throws MareException {
  
    UtilidadesLog.info("MONBuzonBean.obtenerGestiones(DTOBelcorp dtoe): Entrada");
  
    /*Se crea un DTOSalida 
      DTOSalida.resultado = Llamar al método obtenerGestiones(DTOE) del DAOBuzon */

    DTOSalida dtoSal = new DTOSalida();
    DAOBuzon dao = new DAOBuzon();
    RecordSet rs = dao.obtenerGestiones(dtoe);
    dtoSal.setResultado(rs);
  
    UtilidadesLog.info("MONBuzonBean.obtenerGestiones(DTOBelcorp dtoe): Salida");
  
    return dtoSal;
  }


    public DTOSalida obtenerCabeceraBuzonCombo(DTOBelcorp dto) throws MareException{
    DAOBuzon dao = new DAOBuzon();
    return dao.obtenerCabeceraBuzonCombo(dto);
  }

  /* Metodo: obtenerNumeroSecuencialProximoDetalle
   * Autor: mamontie
   * Fecha: 29/09/2005
   * Descripcion: genera un numero secuencial con el que sera insertado un nuevo detalle a un buzon
   * recibe un Long con el oidBuzon
   * Incidencia 17052
   * */
  public Long obtenerNumeroSecuencialProximoDetalle(Long oidBuzon) throws MareException
  {
    UtilidadesLog.log(" Ingreso obtenerNumeroSecuencialProximoDetalle ");
    DAOBuzon dao = new DAOBuzon();
    Long numeroSecuencia = dao.obtenerNumeroSecuencialUltimoDetalle(oidBuzon);
    UtilidadesLog.log(" Sale obtenerNumeroSecuencialProximoDetalle " + numeroSecuencia);
    return numeroSecuencia;
  }
  private CabeceraBuzonLocalHome getCabeceraBuzonLocalHome(){
        return new CabeceraBuzonLocalHome();
  }

  private DetalleBuzonLocalHome getDetalleBuzonLocalHome(){      
      return  new DetalleBuzonLocalHome();
  }
}