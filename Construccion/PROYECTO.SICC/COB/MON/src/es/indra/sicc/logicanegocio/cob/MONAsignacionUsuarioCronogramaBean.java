package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOUsuarEtapaCobraDetal;
import es.indra.sicc.entidades.cob.EtapasDeudaLocal;
import es.indra.sicc.entidades.cob.EtapasDeudaLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaCabeceraLocal;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaCabeceraLocalHome;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaDetalleLocal;
import es.indra.sicc.entidades.cob.UsuariosEtapaCobranzaDetalleLocalHome;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAsignacionUsuarioCronogramaBean implements SessionBean  {
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
      ctx = ctx;
  }
  
  
/** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */
  public DTOSalida recuperarUsuariosCabecera(DTOBelcorp dto) throws MareException {
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recuperarUsuariosCabecera(dto);
  }
  
/** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */
  public DTOSalida recuperarTiposCargo(DTOBelcorp dto) throws MareException {
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recuperarTiposCargo(dto);
  }

/** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */
  public DTOSalida recargaEtapaDeuda(DTOOID dtoOid) throws MareException {
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recargaEtapaDeuda(dtoOid);
  }
  
/** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */
  public DTOSalida recuperarLiquidacion(DTOBelcorp dto) throws MareException {
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recuperarLiquidacion(dto);
  }

/** 
  * Metodo intermediario para poder llamar al DAO remotamente
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */
  
  public DTOSalida recuperarGuiaArgumental(DTOBelcorp dto) throws MareException{
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recuperarGuiaArgumental(dto);
  }
  
/** 
  * Metodo para guardar un usuario de cobranza
  * @param DTOUsuarEtapaCobraDetal dto
  * @return void
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */

  public void guardarAsigUsuConograma(DTOUsuarEtapaCobraDetal dto) throws MareException{
  
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.guardarAsigUsuConograma(DTOUsuarEtapaCobraDetal dto): Entrada");
  
     boolean permiteGuardar; 
     EtapasDeudaLocalHome edLH = null;
     EtapasDeudaLocal edL = null;
     try{    
         try{
           edLH = this.getEtapasDeudaLocalHome();          
           edL = edLH.findByPrimaryKey(dto.getOidEtapaDeudaTCarg());
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

         if(edL.getTipoBalanceo() == null){
            DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
            if(dao.buscarUsuariosMismaZona(dto).booleanValue()){
               permiteGuardar = false;
            }else{
               permiteGuardar = true;
            }
         }else{
            permiteGuardar = true;    
         }
         UtilidadesLog.debug("permite guardar " + permiteGuardar);
         if(permiteGuardar){
               UsuariosEtapaCobranzaDetalleLocalHome uetdLH = null;
               UsuariosEtapaCobranzaDetalleLocal uecdL = null;
                         
               
               Long usuarCobra = dto.getOidUsuarioEtapCobra();
               Long etapaDeuda = dto.getOidEtapaDeudaTCarg();
               DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
               
               Long cabecera = dao.recuperaOidCabecera(usuarCobra, etapaDeuda);
               
               UtilidadesLog.debug("la cebecera es " + cabecera);
               
            try{
               uetdLH = this.getUsuariosEtapaCobranzaDetalleLocalHome();
               uecdL = uetdLH.create(dto.getOidSubgeVentas(),
                                     dto.getOidTipoCargo(),
                                     cabecera,
                                     dto.getOidRegion(),
                                     dto.getOidZona(),
                                     dto.getOidSeccion(),
                                     dto.getOidTerritorio(),
                                     dto.getOidGuionArgCabec(),
                                     dto.getOidMetodoLiqui());
              /* System.out.println("paso 3");
               uecdL.setZorgOidRegi(dto.getOidRegion());
               System.out.println("paso 4");
               uecdL.setZzonOidZona(dto.getOidZona());
               System.out.println("paso 5");
               uecdL.setZsccOidSecc(dto.getOidSeccion());
               System.out.println("paso 6");
               uecdL.setTerrOidTerr(dto.getOidTerritorio());
               System.out.println("paso 7");
               uecdL.setGacaOidGuioArguCabe(dto.getOidGuionArgCabec());
               System.out.println("paso 8");
               uecdL.setMelcOidMetoLiquCobr(dto.getOidMetodoLiqui());
               System.out.println("paso 9");*/
               uecdL.setVal_obse(dto.getObservaciones());
               
               uetdLH.merge(uecdL);
               
               
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 e.printStackTrace();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }     
            
         }else{
            UtilidadesLog.debug("paso por el else");
            throw new MareException(null, null, 
                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_011));
         }
         
     }catch (MareException mm){
             throw new MareException(null, null, 
                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_011));
     }catch (Exception mEx){
            UtilidadesLog.debug("salimos por excepcion");
            ctx.setRollbackOnly();
            UtilidadesLog.error(mEx);
            throw new MareException(mEx);
     }
      
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.guardarAsigUsuConograma(DTOUsuarEtapaCobraDetal dto): Salida");
      
  }
 

  
/** 
  * Metodo para buscar un usuario de cobranza
  * @param DTOOID dto
  * @return DTOUsuarEtapaCobraDetal
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */

  public DTOUsuarEtapaCobraDetal detalleUsuarioCabacera(DTOOID dtoOid) throws MareException {
  
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.detalleUsuarioCabacera(DTOOID dtoOid): Entrada");
  
    DTOUsuarEtapaCobraDetal dtoUsu = new DTOUsuarEtapaCobraDetal();
    
    try{
       UsuariosEtapaCobranzaDetalleLocalHome uecdLH = this.getUsuariosEtapaCobranzaDetalleLocalHome();
       UsuariosEtapaCobranzaDetalleLocal uecdL = uecdLH.findByPrimaryKey(dtoOid.getOid());
       UtilidadesLog.debug("paso el primer finder");
       
       SubGerenciaVentaLocalHome sgvLH = new SubGerenciaVentaLocalHome();
       SubGerenciaVentaLocal sgvL = sgvLH.findByPrimaryKey(uecdL.getZsgvOidSubgVent());
       UtilidadesLog.debug("paso el segundo finder");
       
       UsuariosEtapaCobranzaCabeceraLocalHome ueccLH = this.getUsuariosEtapaCobranzaCabeceraLocalHome();
       UsuariosEtapaCobranzaCabeceraLocal ueccL = ueccLH.findByPrimaryKey(uecdL.getUeccOidUsuaEtapCobr());
       UtilidadesLog.debug("paso el tercer finder");
          
       dtoUsu.setObservaciones(uecdL.getVal_obse());        
       dtoUsu.setOidCanal(sgvL.getOidCanal());
       dtoUsu.setOidEtapaDeudaTCarg(ueccL.getEtdeOidEtapDeud());
       dtoUsu.setOidGuionArgCabec(uecdL.getGacaOidGuioArguCabe());
       dtoUsu.setOidMarca(sgvL.getOidMarca());
       dtoUsu.setOidZona(uecdL.getZzonOidZona());
       dtoUsu.setOidMetodoLiqui(uecdL.getMelcOidMetoLiquCobr());
       dtoUsu.setOidRegion(uecdL.getZorgOidRegi());
       dtoUsu.setOidSeccion(uecdL.getZsccOidSecc());
       dtoUsu.setOidSubgeVentas(uecdL.getZsgvOidSubgVent());
       dtoUsu.setOidTerritorio(uecdL.getTerrOidTerr());
       dtoUsu.setOidTipoCargo(uecdL.getEdtcOidEtapDeudTipoCarg());
       dtoUsu.setOidUsuarioEtapCobra(ueccL.getUscoOidUsuaCobr());
    
    } catch (NoResultException e){
        ctx.setRollbackOnly();
        UtilidadesLog.debug(e);
        String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (PersistenceException e){
        ctx.setRollbackOnly();
        UtilidadesLog.debug(e);
        String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.detalleUsuarioCabacera(DTOOID dtoOid): Salida");
    
    return dtoUsu;
  }
  
/** 
  * Metodo para traer el detalle del usuario
  * @param DTOUsuarEtapaCobraDetal dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */  

  public DTOSalida consultarUsuariosCronogramaCobranzaDetalle(DTOUsuarEtapaCobraDetal dto) throws MareException{
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.consultarUsuariosCronogramaCobranzaDetalle(dto);
  }
  
 
 /** 
  * Metodo para eliminar un detalle de usuario
  * @param DTOOID dto
  * @return void
  * @exception MareException 
  * @author mdolce
  * @referencia SICC-DMCO-COM-N015-UnOficial-p2
  */ 
  
  public void eliminarAsignacionUsuarios(DTOOIDs dtoOid) throws MareException{
  
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.eliminarAsignacionUsuarios(DTOOIDs dtoOid): Entrada");  
    
    Long[] oids = dtoOid.getOids();   
    UsuariosEtapaCobranzaDetalleLocalHome uecdLH  = this.getUsuariosEtapaCobranzaDetalleLocalHome();
    UsuariosEtapaCobranzaDetalleLocal uecdL = null;
    
    for(int i = 0; i < oids.length; i++){
       try{
          uecdL = uecdLH.findByPrimaryKey(oids[i]);
          UtilidadesLog.debug("paso el finder");     
          try{
               uecdLH.remove(uecdL); 
          } catch (PersistenceException pe) {
               ctx.setRollbackOnly();
               pe.printStackTrace();
               throw new MareException(pe, 
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }         
          
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
    }    
    
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.eliminarAsignacionUsuarios(DTOOIDs dtoOid): Salida");
 
  }


    public void guardarModificacionAsigUsuConograma(DTOUsuarEtapaCobraDetal dto) throws MareException{
  
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.guardarModificacionAsigUsuConograma(DTOUsuarEtapaCobraDetal dto): Entrada");
  
     boolean permiteGuardar; 
     EtapasDeudaLocalHome edLH = null;
     EtapasDeudaLocal edL = null;
     try{     
         try{
           edLH = this.getEtapasDeudaLocalHome();          
           edL = edLH.findByPrimaryKey(dto.getOidEtapaDeudaTCarg());
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
             
         if(edL.getTipoBalanceo() == null){
            DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
            if(dao.buscarUsuariosMismaZona(dto).booleanValue()){
               permiteGuardar = false;
            }else{
               permiteGuardar = true;
            }
         }else{
            permiteGuardar = true;    
         }
         UtilidadesLog.debug("permite guardar " + permiteGuardar);
         
         if(permiteGuardar){
               UsuariosEtapaCobranzaDetalleLocalHome uetdLH = null;
               UsuariosEtapaCobranzaDetalleLocal uecdL = null;
               
               Long usuarCobra = dto.getOidUsuarioEtapCobra();
               Long etapaDeuda = dto.getOidEtapaDeudaTCarg();
               DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
               
               Long cabecera = dao.recuperaOidCabecera(usuarCobra, etapaDeuda);
               
               UtilidadesLog.debug("la cebecera es " + cabecera);
                 
               
            try{
               UtilidadesLog.debug("*********el oid del registro es " + dto.getOidUsuarioCobDeta());
               uetdLH = this.getUsuariosEtapaCobranzaDetalleLocalHome();
               uecdL = uetdLH.findByPrimaryKey(dto.getOidUsuarioCobDeta());
               
               
               //obligatorios por eso no los valido
               uecdL.setUeccOidUsuaEtapCobr(cabecera);           
               uecdL.setZsgvOidSubgVent(dto.getOidSubgeVentas());
               
               /* BELC300023364 - DBLG500000835
                * cdos gPineda 20/06/2006 */
               //uecdL.setEdtcOidEtapDeudTipoCarg(dto.getOidEtapaDeudaTCarg());
               uecdL.setEdtcOidEtapDeudTipoCarg( dto.getOidTipoCargo() );
               
               // gPineda - se debe guardar los null
               //if(dto.getOidRegion() != null){
                  uecdL.setZorgOidRegi(dto.getOidRegion());
               //}
               
               //if(dto.getOidZona() != null){
                  uecdL.setZzonOidZona(dto.getOidZona());
               //}
               
               //if(dto.getOidSeccion() != null){
                  uecdL.setZsccOidSecc(dto.getOidSeccion());
               //}
               
               //if(dto.getOidTerritorio() != null){
                  uecdL.setTerrOidTerr(dto.getOidTerritorio());
               //}
               
               if(dto.getOidGuionArgCabec() !=  null){
                  uecdL.setGacaOidGuioArguCabe(dto.getOidGuionArgCabec());
               }
               
               if(dto.getOidMetodoLiqui() != null){
                  uecdL.setMelcOidMetoLiquCobr(dto.getOidMetodoLiqui());
               }
               
               if(dto.getObservaciones() != null){
                  uecdL.setVal_obse(dto.getObservaciones());
               }
               
               uetdLH.merge(uecdL);
               
               
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
            
         }else{
            UtilidadesLog.debug("es false");
            throw new MareException(null, null, 
                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_001));
         }
     }catch (Exception mEx){
            ctx.setRollbackOnly();
            UtilidadesLog.error(mEx);
            throw new MareException(mEx);
     }
     
    UtilidadesLog.info("MONAsignacionUsuarioCronogramaBean.guardarModificacionAsigUsuConograma(DTOUsuarEtapaCobraDetal dto): Salida");
  }

/** 
  * Metodo para recuperar los tipos de cargo por etapa deuda, recibiendo como parametro el oidEtapaDeuda
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia incidencia Peru
  */  
  public DTOSalida recuperarTiposCargoPorEtapa(DTOOID dto) throws MareException
  {
  
    DAOAsignacionUsuarioCronograma dao = new DAOAsignacionUsuarioCronograma();
    return dao.recuperarTiposCargoPorEtapa(dto);    
  }
  
  
    private UsuariosEtapaCobranzaCabeceraLocalHome getUsuariosEtapaCobranzaCabeceraLocalHome()
    {
    return new UsuariosEtapaCobranzaCabeceraLocalHome();
    }
    
    
    private EtapasDeudaLocalHome getEtapasDeudaLocalHome()
    {
    return new EtapasDeudaLocalHome();
    }
    
    private UsuariosEtapaCobranzaDetalleLocalHome getUsuariosEtapaCobranzaDetalleLocalHome()
    {
    return new UsuariosEtapaCobranzaDetalleLocalHome();
    }
 
  
}