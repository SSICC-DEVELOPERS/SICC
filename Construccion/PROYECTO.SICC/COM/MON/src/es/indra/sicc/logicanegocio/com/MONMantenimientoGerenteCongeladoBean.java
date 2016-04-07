/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        MONMantenimientoGerenteCongelado
 * Fecha:             03-01-2006
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes DMCO-SICC-COM-H34
 * Descripcion:       MONMantenimientoGerenteCongeladoBean
 * @version           1.0
 * @autor             lcordoba
 */
package es.indra.sicc.logicanegocio.com;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.com.DTODatosGerenteCongelacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.entidades.com.CongeladosLocalHome;
import es.indra.sicc.entidades.com.CongeladosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Date;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoGerenteCongeladoBean implements SessionBean 
{
    private SessionContext ctx = null;
    
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
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    *@throws: es.indra.mare.common.exception.MareException
    *@return: Void
    *@param:  DTODatosGerenteCongelacion
    */
    public void insertarGerenteCongelado(DTODatosGerenteCongelacion dto) throws MareException
    {

            /***
             * Proceso: 
            -> Long oidCliente 
            -> (1) Si (dto.get(oidCliente) == null ){ 
            //el usuario seleccionó el código de cliente manualmente 
            Instanciar una entidad clienteDatosBasicos (MAE) "cliente" 
            Hacer cliente.findByCodigoYPais(dto.get(oidPais), dto.get(codigoCliente)) 
            (1.1) Si el finder retorna datos entonces 
            oidCliente = cliente.get(oidCliente) 
            dto.set(oidCliente) = oidCliente 
            (1.1) sino 
            Lanzar una mare exception COM-0016 ("El código de cliente que desea congelar no existe.") 
            (1.1) fin si 
            }(1) fin si 
    
            -> (2) (Si(DAOMantenimientoGerenteCongelado.verificarCongelacion (dto): Boolean){ 
            //el cliente ya esta congelado 
            Lanzar una mare exception COM-0017 ("El cliente ya se encuentra en estado de congelación") 
            }(2) sino{ 
            Grabar un registro en la entidad congelados (COM) 
            congelados.set(fechaDesde) = dto.get(fechaDesde) 
            congelados.set(fechaHasta) = dto.get(fechaDesde) 
            congelados.set(importe) = dto.get(importe) 
            congelados.set(oidCliente) = dto.get(oidCliente) 
            congelados.set(indDescongAutomatic) = dto.get(descongelacion) 
            congelado.set(idCongelado) = armar un numero secuencial unico 
            }(2) fin si
            * */

        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.insertarGerenteCongelado - Entrada");
        
               
        if (dto.getOidCliente() == null ){
            ClienteDatosBasicosLocal clienteLocal;
            ClienteDatosBasicosLocalHome clienteHome;
            try{
                clienteHome= new ClienteDatosBasicosLocalHome();
                clienteLocal=clienteHome.findByCodigoYPais(dto.getOidPais(),dto.getCodigoCliente());
                dto.setOidCliente(clienteLocal.getOid());
            }catch (NoResultException fex) {  
                    UtilidadesLog.error(fex);
                    throw new MareException ( null, null, UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COM, "", ErroresDeNegocio.COM_0016));          
            }
        }
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.insertarGerenteCongelado - antes del DAO");
        DAOMantenimientoGerenteCongelado daoMantenimientoGerenteCongelado=new DAOMantenimientoGerenteCongelado();
        
        if (daoMantenimientoGerenteCongelado.verificarCongelacion(dto).booleanValue()){
             throw new MareException ( null, null, UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COM
                                                                                            , "", ErroresDeNegocio.COM_0017));     
        }else{
                    CongeladosLocal congeladosLocal;
                    CongeladosLocalHome congeladosLocalHome;
            try{            
                congeladosLocalHome= this.getCongeladosLocalHome();
                
                Date fechaDesde=null;
                Date fechaHasta=null;
                
                if(dto.getFechaDesde()!= null){
                  long fechaD=dto.getFechaDesde().getTime();
                  fechaDesde= new Date(fechaD);
                }
                
                if(dto.getFechaHasta()!= null){       
                  long fechaH=dto.getFechaHasta().getTime();
                  fechaHasta= new Date(fechaH);
                }            
                
                UtilidadesLog.debug("***fecha desde despues: " + fechaDesde);
                UtilidadesLog.debug("***fecha hasta despues: " + fechaHasta);
                
                Long codConge= new Long((int)((System.currentTimeMillis()/1000)%1000000));                
                congeladosLocal=congeladosLocalHome.create(codConge, fechaDesde, fechaHasta, 
                                                            dto.getImporte(), dto.getDescongelacion(), dto.getOidCliente());
                
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }     
            
        }
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.insertarGerenteCongelado - Salida");
    }
    /**    
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    *@throws: es.indra.mare.common.exception.MareException
    *@return: DTOSalida
    *@param:  DTODatosGerenteCongelacion
    */
    public DTOSalida buscarGerentesCongelados(DTODatosGerenteCongelacion dto) throws MareException
    {

            /**
             * -> Long oidCliente          
            -> (1) Si (dto.get(oidCliente) == null ){ 
            //el usuario seleccionó el código de cliente manualmente 
            Instanciar una entidad clienteDatosBasicos (MAE) "cliente" 
            Hacer cliente.findByCodigoYPais(dto.get(oidPais), dto.get(codigoCliente)) 
            (1.1) Si el finder retorna datos entonces 
            oidCliente = cliente.get(oidCliente) 
            dto.set(oidCliente) = oidCliente 
            (1.1) sino 
            Lanzar una mare exception COM-0016 ("El código de cliente que desea congelar no existe.") 
            (1.1) fin si 
            }(1) fin si 
            -> Crear DTOSalida rta 
            
            -> rta = DAOMantenimientoGerenteCongelado.buscarGerentesCongelados(dto) 
            
            -> Retornar rta
            */
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.buscarGerentesCongelados - Entrada");
        
        if(dto.getCodigoCliente() != null && !dto.getCodigoCliente().equals("")){
          if(dto.getOidCliente() == null ){
              ClienteDatosBasicosLocal clienteLocal;
              ClienteDatosBasicosLocalHome clienteHome;
              try{
                  clienteHome= new ClienteDatosBasicosLocalHome();
                  clienteLocal=clienteHome.findByCodigoYPais(dto.getOidPais(),dto.getCodigoCliente());
                  dto.setOidCliente(clienteLocal.getOid());
              }catch (NoResultException fex) {  
                    UtilidadesLog.error(fex);
                      throw new MareException ( null, null, UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COM, "", ErroresDeNegocio.COM_0016));          
              }
          }
        }
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.buscarGerentesCongelados - antes del DAO");
                    
        DAOMantenimientoGerenteCongelado daoMantenimientoGerenteCongelado=new DAOMantenimientoGerenteCongelado();
        DTOSalida dtoSalida = null;
        dtoSalida = daoMantenimientoGerenteCongelado.buscarGerentesCongelados(dto);
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.buscarGerentesCongelados - Salida");
        return dtoSalida;
    }

    /**    
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    *@throws: es.indra.mare.common.exception.MareException
    *@return: Void
    *@param:  DTODatosGerenteCongelacion
    */
    public void guardarGerenteCongelado(DTODatosGerenteCongelacion dto) throws MareException {
            /**
            -> Instanciar una entidad congelado "cong" 
            -> Hacer un findByPK(dto.get(oidCongelado)) 
            -> Actualizar los datos del registro encontrado con los datos recibidos en el dto de entrada. 
            **/
        CongeladosLocal congeladosLocal;
        CongeladosLocalHome congeladosLocalHome;
        try{
            UtilidadesLog.info("***MONMantenimientoGerenteCongelado.guardarGerenteCongelado - Entrada");
            
            Date fechaDesde=null;
            Date fechaHasta=null;
            
            if(dto.getFechaDesde()!= null){       
              long fechaD=dto.getFechaDesde().getTime();            
              fechaDesde= new Date(fechaD);		                  
            }
            if(dto.getFechaHasta()!= null){       
              long fechaH=dto.getFechaHasta().getTime();            
              fechaHasta= new Date(fechaH);		                  
            }     
    
            congeladosLocalHome= this.getCongeladosLocalHome();
            congeladosLocal =congeladosLocalHome.findByPrimaryKey(dto.getOidCongelado());               
            congeladosLocal.setFechaDesde(fechaDesde);
            congeladosLocal.setFechaHasta(fechaHasta);
            congeladosLocal.setClienteDatosBasicos(dto.getOidCliente());
            congeladosLocal.setImporte(dto.getImporte());
            congeladosLocal.setIndDescongAutomatic(dto.getDescongelacion()); 
            
            congeladosLocalHome.merge(congeladosLocal);
            
            UtilidadesLog.info("***MONMantenimientoGerenteCongelado.guardarGerenteCongelado - Salida");
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

    }

    /**    
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    *@throws: es.indra.mare.common.exception.MareException
    *@return: Void
    *@param:  DTOOIDs
    */
    public void eliminarGerentesCongelados(DTOOIDs dto) throws MareException {

            /**Desc. Se eliminan todos los registros recibidos en el dto de entrada de la entidad congelados. 
            
            Implementacion: 
            
            Instanciar una entidad congelados. 
            Por cada oid recibido en dto hacer congelado.remove. 
            **/
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.eliminarGerentesCongelados - Entrada");
        CongeladosLocal congeladosLocal;
        CongeladosLocalHome congeladosLocalHome;
        try{
            congeladosLocalHome= this.getCongeladosLocalHome();
            Long[] vec=dto.getOids();
            for(int i=0; vec.length>i; i++) {
                    congeladosLocal =congeladosLocalHome.findByPrimaryKey(vec[i]); 
                    
                    try{
                        congeladosLocalHome.remove(congeladosLocal);
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        throw new MareException(pe, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
            }
        } catch(NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException pex) {
            ctx.setRollbackOnly();
            throw new MareException(pex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("***MONMantenimientoGerenteCongelado.eliminarGerentesCongelados - Salida");

    
    }
    
    private CongeladosLocalHome getCongeladosLocalHome() throws MareException {      
       return new CongeladosLocalHome();
    }


}
