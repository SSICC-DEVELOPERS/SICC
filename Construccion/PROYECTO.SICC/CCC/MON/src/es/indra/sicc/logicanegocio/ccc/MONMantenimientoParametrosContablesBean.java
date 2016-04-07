package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.ccc.ParametrosContablesLocal;
import es.indra.sicc.entidades.ccc.ParametrosContablesLocalHome;
import es.indra.sicc.entidades.ccc.SubprocesosLocal;
import es.indra.sicc.entidades.ccc.SubprocesosLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ccc.DTOParametrosContables;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoParametrosContablesBean implements SessionBean  {
  
  private SessionContext ctx;
  
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }
  
  
  /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dto
   */
  public DTOSalida obtenerProcesosPais(DTOBelcorp dto) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerProcesosPais: Entrada");
    
    DAOParametrosContables daoPC = new DAOParametrosContables();
    
    DTOSalida dtoSalida = daoPC.obtenerProcesosPais(dto);
    /* NO IRIA ES PARA CARGAR COMBOS
    if (dtoSalida.getResultado().esVacio()) {                                               
    
        UtilidadesLog.debug("**** DAOParametrosContables.obtenerProcesosPais: No hay datos "); 
				throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       				
		 }                                                                                                       
    */
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerProcesosPais: Salida");
		return dtoSalida;
  }


  /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dto
   */
  public DTOSalida obtenerCuentasContablesPais(DTOBelcorp dto) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerCuentasContablesPais: Entrada");
  
  	DAOParametrosContables daoPC = new DAOParametrosContables();

    DTOSalida dtoSalida = daoPC.obtenerCuentasContablesPais(dto);
    
    /* NO IRIA ES PARA CARGAR COMBOS 
    if (dtoSalida.getResultado().esVacio()) {                                               
    
        UtilidadesLog.debug("**** DAOParametrosContables.obtenerCuentasContablesPais: No hay datos "); 
				throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       				
		 }                                                                                                       
    */ 
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerCuentasContablesPais: Salida");
		return dtoSalida;
   }
   
  /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dto
   */
  public DTOSalida obtenerSubProcesosPorProceso(DTOOID dto) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerSubProcesosPorProceso: Entrada");
  
  	DAOParametrosContables daoPC = new DAOParametrosContables();

    DTOSalida dtoSalida = daoPC.obtenerSubProcesosPorProceso(dto);
    
     /* NO IRIA ES PARA CARGAR COMBOS 
    if (dtoSalida.getResultado().esVacio()) {                                               
    
        UtilidadesLog.debug("**** DAOParametrosContables.obtenerSubProcesosPorProceso: No hay datos "); 
				throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       				
		 }                                                                                                       
    */
    
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerSubProcesosPorProceso: Salida");
		return dtoSalida;
  }
  
  /**
   * 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dto
   */
  public DTOSalida obtenerObtencionCuenta(DTOBelcorp dto) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerObtencionCuenta: Entrada");
  
  	DAOParametrosContables daoPC = new DAOParametrosContables();

    DTOSalida dtoSalida = daoPC.obtenerObtencionCuenta(dto);
    
    /* NO IRIA ES PARA CARGAR COMBOS 
    if (dtoSalida.getResultado().esVacio()) {                                               
    
        UtilidadesLog.debug("**** DAOParametrosContables.obtenerObtencionCuenta: No hay datos "); 
				throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       				
		 }                                                                                                       
    */
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerObtencionCuenta: Salida");
		return dtoSalida;
  }

  
  /**
   * Si se ha seleccionado previamente una entidad ParametrosContables, 
   * la actualiza, sino crea una nueva entidad ParametrosContables. 
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoPC
   */
  public void actualizarParametrosContables(DTOParametrosContables dtoPC) throws MareException {
  /*
    Si DTOE.oid == null //es una entidad ParametrosContables nueva 
    { 
    Crear un registro nuevo en la entidad ParametrosContables : parametrosContables 
    
    parametrosContables.oid = secuencial 
    parametrosContables.subproceso = DTOE.subproceso 
    parametrosContables.indicativoDebeHaber = DTOE.indicativoDebeHaber 
    } 
    en otro caso //es una modificacion 
    { 
    parametrosContables = llamar al método findByPrimaryKey(DTOE.oid) de la entidad ParametrosContables 
    } 
    
    parametrosContables.obtencionCuenta = DTOE.obtencionCuenta 
    parametrosContables.cuenta = DTOE.cuenta 
    parametrosContables.textoApunte = DTOE.textoApunte 
    parametrosContables.concatenarFechaSN = DTOE.concatenarFechaSN 
  */
  //  DTOParametrosContables dtoParametrosContables = new DTOParametrosContables();     

    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.actualizarParametrosContables: Entrada");
//    UtilidadesLog.info("**** Entramos con dtoPC: " + dtoPC.toString());

    ParametrosContablesLocalHome  homePC = null;
    ParametrosContablesLocal     localPC = null;

    homePC = this.getParametrosContablesLocalHome();         
    Long oid  = dtoPC.getOid();  
//    UtilidadesLog.info("**** dtoPC.getOid()-- " + oid);
    Character concatenaSN;
//    UtilidadesLog.info("**** 1 -- ");     
    if(oid == null){
    // crear nueva entidad
      try {
/**
* Método ejbCreate al que se le pasan solo los parámetros obligatorios
public Long ejbCreate(Long subproceso, Character indicativoDeberHaber, String textoApunte, Character concatenarFechaSN)
*/      
//        UtilidadesLog.info("**** dtoPC.getConcatenarFechaSN()-- " + dtoPC.getConcatenarFechaSN());
        
        if (dtoPC.getConcatenarFechaSN()) {
            concatenaSN = new Character('1');
        } else {
        
            concatenaSN = new Character('0');
        }
//        UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.actualizarParametrosContables...........Antes del create.");
//        UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.actualizarParametrosContables...........El dtoPC es : " + dtoPC.toString());

        localPC = homePC.create(dtoPC.getSubProceso(), new Character(dtoPC.getIndicativoDebeHaber().charAt(0)), dtoPC.getTextoApunte(), concatenaSN);
//        UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.actualizarParametrosContables...........Despues del create");
        if (dtoPC.getCuenta()!=null) {
            localPC.setCuenta(dtoPC.getCuenta());
        }
        if (dtoPC.getObtencionCuenta()!=null) {
            localPC.setObtencionCuenta(new Character(dtoPC.getObtencionCuenta().toString().charAt(0)));
        }
        homePC.merge(localPC);
      }catch (PersistenceException ce) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(ce);
                throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
   
    }else{
 
         try {
                localPC = homePC.findByPrimaryKey(dtoPC.getOid());         
         } catch (NoResultException fe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }
        //Actualizamos 

        if (dtoPC.getConcatenarFechaSN()) {
            concatenaSN = new Character('1');
        } else {
        
            concatenaSN = new Character('0');
        }
        localPC.setConcatenarFechaSN(concatenaSN);
        if (dtoPC.getObtencionCuenta()!=null) {
            localPC.setObtencionCuenta(new Character (dtoPC.getObtencionCuenta().toString().charAt(0)));
        }
        if (dtoPC.getCuenta()!=null) {
            localPC.setCuenta(dtoPC.getCuenta());
        }
        localPC.setTextoApunte(dtoPC.getTextoApunte());
        homePC.merge(localPC);       
    }
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.actualizarParametrosContables: Salida");
  }

  /**
   * Obtiene las entidades ParametrosContables que coincidan con los parámetros de la búsqueda 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dtoPC
   */
  public DTOSalida buscarParametrosContables(DTOParametrosContables dtoPC) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.buscarParametrosContables: Entrada");
   
  	DAOParametrosContables daoPC = new DAOParametrosContables();

    DTOSalida dtoSalida = daoPC.buscarParametrosContables(dtoPC);
    
    //ES PARA LISTA EDITABLE, SINO TENGO FILAS RESULTADOS LANSO EXCEPTION
    if (dtoSalida.getResultado().esVacio()) {                                               
    
        UtilidadesLog.debug("**** DAOParametrosContables.buscarParametrosContables: No hay datos "); 
				throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       				
		 }                                                                                                       
    
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.buscarParametrosContables: Salida"); 
  return dtoSalida;
  }

  /**
   * Obtiene los datos de la entidad ParametrosContables cuyo oid se recibe como parametro de entrada 
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOParametrosContables
   * @param dto
   */
  public DTOParametrosContables obtenerParametroContable(DTOOID dto) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerParametroContable: Entrada");
  /*
      parametrosContables = Llama al método findByPrimaryKey(DTOE.oid) de la entidad ParametrosContables 
      Crea un dto del tipo DTOParametrosContables y rellena sus atributos con la información del entity: 
      
      - dto.oid = parametrosContables.oid 
      - dto.indicativoDebeHaber = parametrosContables.indicativoDebeHaber 
      - dto.obtencionCuenta = parametrosContables.obtencionCuenta 
      - dto.textoApunte = parametrosContables.textoApunte 
      - dto.concatenarFechaSN = parametrosContables.concatenarFechaSN 
      - dto.cuenta = parametrosContables.cuenta 
      - dto.subproceso = parametrosContables.subproceso 
      
      subproceso = Llama al método findByPrimaryKey( parametrosContables.subproceso ) de la entidad Subproceso 
      
      - dto.proceso = subproceso.proceso 
      
      Devuelve dto
   */
     DTOParametrosContables dtoParametrosContables = new DTOParametrosContables();     
     ParametrosContablesLocalHome  homePC = null;
     ParametrosContablesLocal     localPC = null;

     homePC = this.getParametrosContablesLocalHome();
     
     Long oid  = dto.getOid();     
     try {
            localPC = homePC.findByPrimaryKey(oid);
            
     }catch (NoResultException fe) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(fe);
             throw new MareException(fe,
                 UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }
     
     dtoParametrosContables.setOid(localPC.getOid());
     dtoParametrosContables.setIndicativoDebeHaber(localPC.getIndicativoDeberHaber().toString());
     dtoParametrosContables.setTextoApunte(localPC.getTextoApunte());
     dtoParametrosContables.setCuenta(localPC.getCuenta());
     dtoParametrosContables.setSubProceso(localPC.getSubproceso());  
                   
     String concatenaFechaSN = localPC.getConcatenarFechaSN().toString();
     UtilidadesLog.debug("**** valor concatenarFechaSN: " + concatenaFechaSN);  
              
     if(concatenaFechaSN.equalsIgnoreCase("1")){
		 				dtoParametrosContables.setConcatenarFechaSN(Boolean.TRUE.booleanValue());
		 }else{
		 				dtoParametrosContables.setConcatenarFechaSN(Boolean.FALSE.booleanValue());
		 }
     
     if(localPC.getObtencionCuenta()!= null){
        dtoParametrosContables.setObtencionCuenta(localPC.getObtencionCuenta().toString());
     }
        
    SubprocesosLocalHome  homeSP = null;
    SubprocesosLocal     localSP = null;
     
     homeSP = this.getSubprocesosLocalHome();
     
     Long oidSubp  = dtoParametrosContables.getSubProceso();     
     try {
            localSP = homeSP.findByPrimaryKey(oidSubp);
            
     }catch (NoResultException fe) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(fe);
             throw new MareException(fe,
                 UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }
    
    dtoParametrosContables.setProceso(localSP.getProceso());
  
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.obtenerParametroContable: Salida"); 
  return dtoParametrosContables;  
  }


  /**
   * Se eliminan las entidades ParametrosContables cuyos oids se reciben como parametros de entrada 
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoOIDs
   */
  public void eliminarParametrosContables(DTOOIDs dtoOIDs) throws MareException {
  UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.eliminarParametrosContables: Entrada"); 
  /* // Elimina los parametros contables especificados en el DTOOIDs de entrada 
    
    Para cada "oid" encontrado en DTOE hacer: 
    { 
    parametrosContable = Llamar al método findByPrimaryKey(oid) de la entidad ParametrosContables 
    parametrosContable.remove() 
    } 

  */
     ParametrosContablesLocalHome  homePC = null;
     ParametrosContablesLocal     localPC = null;
     
     homePC = this.getParametrosContablesLocalHome();    
     
     Long oids[]  = dtoOIDs.getOids();
     int cantOids = oids.length;

     for (int i = 0; i < cantOids ; i++) {
         try {
            localPC = homePC.findByPrimaryKey(oids[i]);
            homePC.remove(localPC);
         }catch (NoResultException fe) {
             ctx.setRollbackOnly();
             UtilidadesLog.error(fe);
             throw new MareException(fe,
                 UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }catch (PersistenceException re) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
     }
  
   UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.eliminarParametrosContables: Salida"); 
  }

  private ParametrosContablesLocalHome getParametrosContablesLocalHome() {
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.getParametrosContablesLocalHome: Entrada"); 
    UtilidadesLog.info("****Metodo MONMantenimientoParametrosContables.getParametrosContablesLocalHome: Salida"); 
    return new ParametrosContablesLocalHome();
  }

  private SubprocesosLocalHome getSubprocesosLocalHome() {
        return new SubprocesosLocalHome();
  }
}