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
 
package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.mae.DTODataCodigoAnterior;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.CodigosClientesAnterioresLocal;
import es.indra.sicc.entidades.mae.CodigosClientesAnterioresLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.mae.ErroresDeNegocio;

import java.sql.Timestamp;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONCodigosAnterioresBean implements SessionBean {
  
  SessionContext sessionContext = null;

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
     sessionContext = ctx;
  }

  public void guardarCodigoAnterior(DTODataCodigoAnterior dto) throws MareException {
    try {
            UtilidadesLog.info("MONCodigosAnteriores.guardarCodigoAnterior(DTODataCodigoAnterior dto): Entrada"); 
            
            ClienteDatosBasicosLocal clienDatBasics;
            CodigosClientesAnterioresLocal codigClieAnt;            
            
            try{
                UtilidadesLog.info("Antes de if 1");
                if (dto.getOidCliente() == null) {
                  
                    UtilidadesLog.info("Entre al if 1");
        
                    ClienteDatosBasicosLocalHome clieBasicoHome =  getClienteDatosBasicosLocalHome();

                    UtilidadesLog.info("Voy a buscar el findbyUK" + dto.getOidPais() + " ####### " + dto.getCodigoClienteNuevo() );

                    clienDatBasics =  null;

                    clienDatBasics = clieBasicoHome.findByUK(dto.getOidPais(),dto.getCodigoClienteNuevo());

                    UtilidadesLog.info("Voy a asignar el OID encontrado" +  clienDatBasics.getOid());
                    
                    dto.setOidCliente(clienDatBasics.getOid());
                    
                }
            }catch(PersistenceException ex) {
                   UtilidadesLog.info("Exception traida-1-- " + ex);
                   throw new MareException(new Exception()  ,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE
                                         , ""
                                         , ErroresDeNegocio.MAE_0024));
            }
            if(dto.getOidCodigoAnterior() == null)  {
               try{ 
                 UtilidadesLog.info("Crea el CodigosClientesAnterioresLocalHome" ); 
                 
                 CodigosClientesAnterioresLocalHome codigClienAnterHome = getCodigosClientesAnterioresLocalHome();
                 UtilidadesLog.info("Voy a buscar por finByUk en  CodigosClientesAnteriores con +  dto.getOidCliente()  : " +  dto.getOidCliente() ); 
                 codigClieAnt = null;
                 codigClieAnt = codigClienAnterHome.findByUk(dto.getOidCliente());
                 UtilidadesLog.info("Ya fue a buscar el dato " +  codigClieAnt ); 

                 // Si no tiró excepcion, es porque encontró un registro con ese OID => tiro excepcion:
                 throw new MareException(new Exception(),UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE
                                 , ""
                                 , ErroresDeNegocio.MAE_0037));                 
                }catch (PersistenceException ex) {
                          UtilidadesLog.info("Exception traida-2-- " + ex);
                }
                
                 try{ 
                      UtilidadesLog.info("Creo una nueva entidad de CodigosClientesAnteriores para el Insertar " ); 
                      
                      CodigosClientesAnterioresLocalHome codigClienAnterNuevHome = getCodigosClientesAnterioresLocalHome();                          
                      UtilidadesLog.info("ya la obtuve " ); 
                      UtilidadesLog.info("Antes de hacer el create dto.getOidCliente()   " + dto.getOidCliente());
                      CodigosClientesAnterioresLocal codigClienAnterNuevLocal =                       
                          codigClienAnterNuevHome.create(dto.getOidCliente(),
                                                         dto.getCodigoClienteAntiguo(),                                                         
                                                         dto.getOidPaiscmb(),
                                                         new Timestamp(System.currentTimeMillis()));
                      
                      UtilidadesLog.info("Le seteo los datos a la nueva entidad CodigosClientesAnteriores :   " );
                      
                      codigClienAnterNuevLocal.setPaisOidPais(dto.getOidPaiscmb());
                      codigClienAnterNuevLocal.setValSistProc(dto.getSistemaProcedencia());
                      codigClienAnterNuevLocal.setCodClieAnti(dto.getCodigoClienteAntiguo());                                                 
                      codigClienAnterNuevLocal.setClieOidClieNuev(dto.getOidCliente());
                      
                      codigClienAnterNuevHome.merge(codigClienAnterNuevLocal);
                      
                 }catch (PersistenceException pe) {
                      sessionContext.setRollbackOnly();
                      throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                 }
                
            } else { 
                  
                      try{                  
                          UtilidadesLog.info("Busco en CodigosClientesAnteriores para poder realizar el update " );                     
                          
                          CodigosClientesAnterioresLocalHome codigClienAnterHome = getCodigosClientesAnterioresLocalHome();
                          codigClieAnt = codigClienAnterHome.findByPrimaryKey(dto.getOidCodigoAnterior());
      
                          codigClieAnt.setPaisOidPais(dto.getOidPaiscmb());  
                          codigClieAnt.setValSistProc(dto.getSistemaProcedencia());
                          codigClieAnt.setCodClieAnti(dto.getCodigoClienteAntiguo());
                          codigClieAnt.setClieOidClieNuev(dto.getOidCliente());
                          
                          codigClienAnterHome.merge(codigClieAnt);
                      } catch(PersistenceException pe) {
                         sessionContext.setRollbackOnly();
                         throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                     }
              
            }
            
        } catch (MareException me) {
            UtilidadesLog.info("MareException ------- " + me);
            throw me;
        } catch (Exception exception) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.info("exception ------- " + exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } 
        UtilidadesLog.info("MONCodigosAnteriores.guardarCodigoAnterior(DTODataCodigoAnterior dto): Salida"); 
  }

  public DTOSalida buscarCodigoAnterior(DTODataCodigoAnterior dto) throws MareException {
    UtilidadesLog.info("MONCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior dto): Entrada");   
          
      DTOSalida dtoSalida = new DTOSalida();
      DAOCodigosAnteriores daoCodigosAnteriores =  new DAOCodigosAnteriores();
      dtoSalida  = daoCodigosAnteriores.buscarCodigoAnterior(dto);
  
    UtilidadesLog.info("MONCodigosAnteriores.buscarCodigoAnterior(DTODataCodigoAnterior dto): Salida");           
      return dtoSalida;
  }

  
      /**
     * Por cada elemento del dto llamamos al metodo remove del home del  entitybean
     * CodigoClienteAnteriores
     *
     * @param dto - DTOOIDs
     *
     * @throws MareException
     */
   public void eliminarCodigosAnteriores(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONCodigosAnteriores.eliminarCodigosAnteriores(DTOOIDs): Entrada"); 
        try {
            
            //CodigosClientesAnterioresLocalHome codigClienAnterHome = MAEEjbLocators.getCodigosClientesAnterioresLocalHome();
            CodigosClientesAnterioresLocalHome codigClienAnterHome = getCodigosClientesAnterioresLocalHome();

            CodigosClientesAnterioresLocal codigClieAnt;  

            UtilidadesLog.info("Antes del bucle  dto.getOids().length----- " +  dto.getOids().length);
            for (int j = 0; j < dto.getOids().length; j++){
                UtilidadesLog.info("dto.getOids() +++++++  " + dto.getOids());
                UtilidadesLog.info("dto.getOids()[j]--------   " + "**** j ******" + j + "------" + dto.getOids()[j]);
                codigClieAnt = codigClienAnterHome.findByPrimaryKey(dto.getOids()[j]);
                UtilidadesLog.info("Ya busque  " );
                try {
                    codigClienAnterHome.remove(codigClieAnt);
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                UtilidadesLog.info("borre  " );
            }

            UtilidadesLog.info("MONCodigosAnteriores.eliminarCodigosAnteriores(DTOOIDs): Salida"); 
        } catch (NoResultException e) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", CodigosError.ERROR_DE_LECTURA_BLOB));
        }    
    }

  private CodigosClientesAnterioresLocalHome getCodigosClientesAnterioresLocalHome() throws NamingException
  {
      return new CodigosClientesAnterioresLocalHome();
  }
 

 
  private ClienteDatosBasicosLocalHome  getClienteDatosBasicosLocalHome() throws NamingException
  {
      return new ClienteDatosBasicosLocalHome();
  }
 
 
 
 }


