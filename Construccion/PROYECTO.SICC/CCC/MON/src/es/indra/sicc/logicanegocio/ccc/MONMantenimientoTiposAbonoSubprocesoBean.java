package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarTiposAbonoSubproceso;
import es.indra.sicc.dtos.ccc.DTOMantenimientoTiposAbonoSubproceso;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoTiposAbonoSubprocesoBean implements SessionBean 
{

    private SessionContext ctx;
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
        this.ctx = ctx;
    }
    /**
      * @autor Noziglia C.
      * @throws MareException
      * @documentation 
      * Descripción: Crea un nuevo registro o actualiza uno existente. 
        Implementación: 
        
        Si (dto.oidTiposAbonoSubproceso != null) // sera modificacion 
        { 
        Para dto.oidTiposAbonoSubproceso 
        - Realizar un findByPrimaryKey sobre la Entidad TiposAbonoSubproceso. 
        - Actualizar los atributos de la Entidad con los valores contenidos en el DTO recibido como parametro. 
        } Sino // se trata de un registro nuevo { 
            Obtenemos la propiedad oidSubproceso de dto. 
            SELECT t.OID_TIPO_ABON_SUBP 
            FROM CCC_SUBPR s JOIN CCC_TIPO_ABONO_SUBPR t ON (s.OID_SUBP = t.SUBP_OID_SUBP) 
            WHERE s.OID_SUBP = el valor de la propiedad AND s.VAL_INDI_TIPO_ABON = 1 
            Si obtenemos algún registro{ 
                Lanzamos una MareException con el mensaje CCC-0041 "No puede introducirse más tipos de abono para el proceso/subproceso introducido" 
            } 
            Sino realizar un create sobre la Entidad TiposAbonoSubproceso con los valores contenidos en el DTO recibido como parametro. 
        }
      * @date 18/01/2006
      */
    public void insertarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.insertarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto): Entrada ");
        try{
            TiposAbonoSubprocesoLocalHome tiposAbonoSubprocesoHome = this.getTiposAbonoSubprocesoLocalHome();
            TiposAbonoSubprocesoLocal tiposAbonoSubprocesoLocal = null;
            
            if(dto.getOidTiposAbonoSubproceso() != null){
                 UtilidadesLog.debug("El oid de abono no es null");
                  tiposAbonoSubprocesoLocal = tiposAbonoSubprocesoHome.findByPrimaryKey(dto.getOidTiposAbonoSubproceso());
                  
                  tiposAbonoSubprocesoLocal.setCuenta(dto.getOidCuentaContable());
                  tiposAbonoSubprocesoLocal.setSubproceso(dto.getOidSubproceso());
                  tiposAbonoSubprocesoLocal.setTipoAbono(dto.getOidTipoAbono());
                  tiposAbonoSubprocesoHome.merge(tiposAbonoSubprocesoLocal);
                  UtilidadesLog.debug("Modifica el abono ");
            }else{
                StringBuffer query = new StringBuffer();
                RecordSet rs;
                query.append("        SELECT t.OID_TIPO_ABON_SUBP ");
                query.append("        FROM CCC_SUBPR s, ");
                query.append("		       CCC_TIPO_ABONO_SUBPR t  ");
                query.append("        WHERE s.OID_SUBP = t.SUBP_OID_SUBP ");
                query.append("		  AND s.OID_SUBP = "+dto.getOidSubproceso());
                query.append("		  AND s.VAL_INDI_TIPO_ABON = 1  ");
          
                UtilidadesLog.debug("entro en consulta de Tipo abonos  ");
                rs = getBelcorpService().dbService.executeStaticQuery(query.toString());   
                UtilidadesLog.debug("entro en consulta de Tipo abonos y armo recordset ");
                if (!rs.esVacio()) {
                   	UtilidadesLog.debug("El recordset no es vacio ");
                    throw new MareException(null,null,
						UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC , "", 
							ErroresDeNegocio.CCC_0041));
                }else{
                    //Long subproceso, Long cuenta, Long tipoAbono
                    tiposAbonoSubprocesoLocal = tiposAbonoSubprocesoHome.create(dto.getOidSubproceso(),
                                                                            dto.getOidCuentaContable(),
                                                                            dto.getOidTipoAbono());
                }            
            }

        } catch(NoResultException fe){
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Excepcion Finder - ");
            fe.printStackTrace();
            throw new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(PersistenceException fe){
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Excepcion Finder - ");
            fe.printStackTrace();
            throw new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }catch(MareException me) {
          UtilidadesLog.debug("Excepcion de Tipo Mare- ");
           me.printStackTrace();
            throw me;
        } catch (Exception ex){
           UtilidadesLog.debug("Excepcion desconocida - ");
            ex.printStackTrace();
            throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.insertarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto): Salida ");
    }
     /**
      * @autor Noziglia C.
      * @throws MareException
      * @documentation 
      * Descripción: Realiza la eliminacion de la entrada correspondiente al parametro recibido. 
            Implementación: 
                Para cada oid contenido en dto.oidRegistrosAEliminar 
                - registro = findByPrimaryKey sobre la Entidad TiposAbonoSubproceso. 
                - registro.remove
      * @date 18/01/2006
      * @modificacion: devuelve un DTOBoolean con true si la operacion fue realizada con exito
      */
    public DTOBoolean  eliminarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto) throws MareException
    {
       DTOBoolean dtoBool =new DTOBoolean();
       dtoBool.setValor(true);
       
        boolean error = false;
        //dto.setProperty("error",new Boolean (false));
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.eliminarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto): Entrada ");
        try{
            TiposAbonoSubprocesoLocalHome tiposAbonoSubprocesoHome = this.getTiposAbonoSubprocesoLocalHome();
            TiposAbonoSubprocesoLocal tiposAbonoSubprocesoLocal = null;
            
            UtilidadesLog.debug("Antes del for ");
            int cantidadIteraciones = dto.getOidsRegistrosAEliminar().length;
            UtilidadesLog.debug("Total de registros a eliminar :  " + cantidadIteraciones);
            DAOCCC dao = new DAOCCC();
            for( int i = 0 ;i<cantidadIteraciones; i++ ){
           
                 if(dto.getOidsRegistrosAEliminar()[i]!=null){
                  UtilidadesLog.debug("el oid del registro a eliminar es " + dto.getOidsRegistrosAEliminar()[i]);
                    /*  Buscamos si el oid de tipo abono suproceso esta siendo referenciado por alguna entidad externa
                     *  En tal caso no deberiamos hacer el remove() 
                     */
                   RecordSet rs = dao.ObtenerTipoAbonoSubprocesoRefereciados(dto.getOidsRegistrosAEliminar()[i]);
                   
                   if (rs != null && rs.esVacio()){
                        tiposAbonoSubprocesoLocal = tiposAbonoSubprocesoHome.findByPrimaryKey(dto.getOidsRegistrosAEliminar()[i]);
                       
                        UtilidadesLog.debug("antes del remove");
                        UtilidadesLog.debug("Eliminamos el registro nro : " + i);
                        tiposAbonoSubprocesoHome.remove(tiposAbonoSubprocesoLocal);   
                    } else{
                        UtilidadesLog.debug("seteamos error en true");
                        error=true;
                    }    
                } //fin for
            }
             UtilidadesLog.debug("Termna el for ");
        }catch(NoResultException fe){
              ctx.setRollbackOnly();  
              UtilidadesLog.debug("Entro en finder exception ");
              fe.printStackTrace();
              throw new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));  
         } catch(PersistenceException fe){
               // vconte incidencia BELC300022877 
               ctx.setRollbackOnly();
                UtilidadesLog.debug("Entro en Remove exception ");
                fe.printStackTrace();
                new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (error){
         /*UtilidadesLog.debug("Es error");
          throw new  MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.CCC_0060));
          */
          dtoBool.setValor(false);
        }
        UtilidadesLog.info(
                "MONMantenimientoTiposAbonoSubprocesoBean.eliminarTiposAbonoSubproceso(DTOMantenimientoTiposAbonoSubproceso dto): Salida ");  
       return dtoBool; 
    }
   /**
    * @autor Noziglia C.
    * @throws MareException
    * @documentation 
    * Descripción: Recupera los datos de TipoAbono con los que se completara el combo correspondiente. 
    * Implementacion: 
         Invocar al metodo DAOCCC.obtenerTiposAbono pasandole como parametro el dto de entrada. 
         Devolver el RecordSet obtenido en el metodo anterior.
    * 
    * @date 18/01/2006
    */
    public RecordSet obtenerTiposAbono(DTOBelcorp dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.obtenerTiposAbono(DTOBelcorp dto): Entrada ");
        DAOCCC dao = new DAOCCC();
        RecordSet resultado = null;
        try{
            resultado = dao.obtenerTiposAbono(dto);
        }catch(MareException e){
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.obtenerTiposAbono(DTOBelcorp dto): Salida ");
        return resultado;
    }
     /**
      * @autor Noziglia C.
      * @throws MareException 
      * @documentation 
      *  Descripción: Recupera los datos de CuentaContable con los que se completara el combo correspondiente. 
         Implementacion: 
                Invocar al metodo DAOCCC.obtenerCuentasContables pasandole como parametro el dto de entrada. 
                Devolver el RecordSet obtenido en el metodo anterior.
                Descripción: Recupera los datos con los que se cargara la pantalla de resultados de busqueda. 

      * @date 18/01/2006
      */
    public RecordSet obtenerCuentasContables(DTOBelcorp dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.obtenerCuentasContables(DTOBelcorp dto): Entrada ");
        DAOCCC dao = new DAOCCC();
        RecordSet resultado = null;
        try{
            resultado = dao.obtenerCuentasContables(dto);
        }catch(MareException e){
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.obtenerCuentasContables(DTOBelcorp dto): Salida ");
        return resultado;
    
    }
     /**
      * @autor Noziglia C.
      * @throws MareException
      * @documentation 
      *  Descripción: Recupera los datos con los que se cargara la pantalla de resultados de busqueda. 
      *  Implementacion: 
            Invocar el metodo DAOCCC.buscarTiposAbonoSubproceso pasandole como parametro el dto recibido. 
            Retornar el RecordSet devuelto por el metodo anterior. 
      * @date 18/01/2006
      */
    public DTOSalida buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto): Entrada ");
        DAOCCC dao = new DAOCCC();
        DTOSalida resultado = new DTOSalida();
        try{
            resultado = dao.buscarTiposAbonoSubproceso(dto);
        }catch(MareException e){
            throw e;
        }catch(Exception e){
             throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.buscarTiposAbonoSubproceso(DTOBuscarTiposAbonoSubproceso dto): Salida ");
        return resultado;
    }

    private TiposAbonoSubprocesoLocalHome getTiposAbonoSubprocesoLocalHome() {       
        return new TiposAbonoSubprocesoLocalHome();
    }
    
    private BelcorpService getBelcorpService() {
        
        UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.getBelcorpService(): Entrada ");
        try {
            UtilidadesLog.info("MONMantenimientoTiposAbonoSubprocesoBean.getBelcorpService(): Salida ");
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " +
                mmsnfe.getMessage(), mmsnfe);
        }
       
    }
}