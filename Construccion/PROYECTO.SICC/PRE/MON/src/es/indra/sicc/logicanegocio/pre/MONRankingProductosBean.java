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
*/

package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.pre.DTORankingCuadre;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.mare.common.exception.MareException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class MONRankingProductosBean implements SessionBean 
{
    private SessionContext ctx;
    
    public void ejbCreate() { }
    public void ejbActivate() {  }
    public void ejbPassivate() {  }
    public void ejbRemove() {  }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }
    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param DTOE
     * modificaciones: 02/03/2006 - [1] pperanzola: se modifica para solucionar la incidencia DBLG200000583
     */
    public DTOCabeceraSolicitud agregarProductosGrupo(DTORankingCuadre DTOE) throws MareException {
        UtilidadesLog.info("MONRankingProductosBean.agregarProductosGrupo(DTORankingCuadre DTOE): Entrada");
        
        ArrayList posicionesOferta = null;
        int contPosOfer;
        int contProdGrupos;
        Long rankTmp = null;
        MONOferta monOferta = null;
        MONOfertaHome monOfertaH = null;
        RecordSet productosGrupo = null;
        String producto = null;

        // Recupera los productos del grupo ;
        
        try{
            monOfertaH = this.getMONOfertaHome();
            monOferta = monOfertaH.create();
            productosGrupo = monOferta.obtenerProductosGrupo(DTOE.getOidOferta(), DTOE.getNumeroGrupo()) ;
        }catch(NamingException nEx){
            
            UtilidadesLog.error(nEx); 
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException cEx){
            
            UtilidadesLog.error(cEx); 
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException rEx){
            
            UtilidadesLog.error(rEx); 
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        // Si DTOE.primerRanking != null 
        if (DTOE.getPrimerRanking()!= null){
            
            //Busca dentro de productosGrupo el producto con NUM_POSI_RANK == DTOE.primerRanking 
            contProdGrupos = productosGrupo.getRowCount();
            for (int i = 0; i < contProdGrupos; i++){
                //UtilidadesLog.debug(" entro al for con productos grupo =  " + productosGrupo.getRowCount() );
                rankTmp =  (productosGrupo.getValueAt(i,"NUM_POSI_RANK")== null
                                    ? new Long (0)
                                    : new Long(((BigDecimal)productosGrupo.getValueAt(i,"NUM_POSI_RANK")).longValue()));
                                    
                UtilidadesLog.debug(" prodGrupoRankTmp = " + rankTmp);
                
                if (DTOE.getPrimerRanking().longValue() == rankTmp.longValue()){
                   //UtilidadesLog.debug(" Entcontre el ranking ");
                   producto = (String) productosGrupo.getValueAt(i,"VAL_CODI_VENT");
                   //UtilidadesLog.debug("productoTmp =  " +producto);
                   break;
                }
            } 
        }
        
        if (producto == null && !productosGrupo.esVacio()){
            producto =  (String) productosGrupo.getValueAt(0,"VAL_CODI_VENT");
            //UtilidadesLog.debug("productoTmp v2 =  " +producto);
        }
        
        // Compruebo si el producto que tengo que agregar esta solicitado 
        posicionesOferta =  DTOE.getPosicionesOferta();
        DTOPosicionSolicitud dtoPosSol = null;
        DTOPosicionSolicitud posicion = null;
        Long numero = null;
        contPosOfer = posicionesOferta.size();
        //UtilidadesLog.debug("contPosOfer =" + contPosOfer);
        for (int i = 0; i < contPosOfer; i++){
            dtoPosSol =  (DTOPosicionSolicitud) posicionesOferta.get(i);
            if (dtoPosSol.getCodigoVenta().equals(producto)){
                if (!Boolean.TRUE.equals(dtoPosSol.getAAgregar())){//[1] 
                    posicion  = dtoPosSol;
                }
                numero = dtoPosSol.getNumeroPosicion();
                break;
            }
        }
        // Crea un DTOAgregarProductoSolicitud
        /*UtilidadesLog.debug("1.getTipoPosicion() =" + DTOE.getTipoPosicion());
        UtilidadesLog.debug("2.getSubtipoPosicion() =" + DTOE.getSubtipoPosicion());
        UtilidadesLog.debug("3.producto =" + producto);
        UtilidadesLog.debug("4.getNumeroUnidadesA =" + DTOE.getNumeroUnidadesA());
        UtilidadesLog.debug("5.getNumeroUnidadesA =" + numero);*/
        
        DTOAgregarProductoSolicitud dtoAgregarProdSol = new  DTOAgregarProductoSolicitud();
        dtoAgregarProdSol.setOidTipoPosicion(DTOE.getTipoPosicion());
        dtoAgregarProdSol.setOidSubtipoPosicion(DTOE.getSubtipoPosicion());
        dtoAgregarProdSol.setCodigoVenta(producto);
        dtoAgregarProdSol.setUnidadesPorAtender(DTOE.getNumeroUnidadesA());
        dtoAgregarProdSol.setNumeroPosicion(numero);
        
        try{
            MONCuadreProductosHome monCuadreProductosH = this.getMONCuadreProductosHome();
            MONCuadreProductos monCuadreProductos = monCuadreProductosH.create();
            DTOE.setDTOCabeceraSolicitud(
                        monCuadreProductos.agregarProductos(DTOE.getDTOCabeceraSolicitud(),dtoAgregarProdSol,posicion));
        }catch(NamingException nEx2){
            
            UtilidadesLog.error(nEx2); 
            throw new MareException(nEx2, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException cEx2){
            
            UtilidadesLog.error(cEx2); 
            throw new MareException(cEx2, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException rEx2){
            
            UtilidadesLog.error(rEx2); 
            throw new MareException(rEx2, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONRankingProductosBean.agregarProductosGrupo(DTORankingCuadre DTOE): Salida");
        return DTOE.getDTOCabeceraSolicitud();

    }

  /**
   * @date 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param DTOE
   */
    public DTOCabeceraSolicitud eliminarProductosGrupo(DTORankingCuadre DTOE) throws MareException {
        UtilidadesLog.info("MONRankingProductosBean.eliminarProductosGrupo(DTORankingCuadre DTOE): Entrada");
        
        // Eliminamos unidades al primer producto del grupo. Si se agotan, seleccionamos el siguiente 
        int cantPosicOfer;
        int contPosiciones;
        Long numeroUnidadesA = null;
        Long numeroGrupo = null;
        TreeMap treeMap = new TreeMap();
        ArrayList posicionesOfertaTmp = null;
        MONCuadreProductosHome monCuadreProductosH = null;  
        MONCuadreProductos monCuadre =null;
        
        numeroUnidadesA = new Long (- DTOE.getNumeroUnidadesA().longValue());
        //UtilidadesLog.debug(" numeroUnidadesA =" + numeroUnidadesA);
        posicionesOfertaTmp = DTOE.getPosicionesOferta();
        numeroGrupo = DTOE.getNumeroGrupo();
        //UtilidadesLog.debug(" numeroGrupo =" + numeroGrupo);
        DTOPosicionSolicitud dtoPosSolic = null;
        cantPosicOfer = posicionesOfertaTmp.size();
        //UtilidadesLog.debug(" cantPosicOfer =" + cantPosicOfer);
        // lleno un treemap para primero ordenarlo
        for (int i = 0; i < cantPosicOfer; i++ ){
            dtoPosSolic = (DTOPosicionSolicitud)posicionesOfertaTmp.get(i);
            //UtilidadesLog.debug(" dtoPosSolic.getGrupo().longValue() " + dtoPosSolic.getGrupo().longValue());
            if (dtoPosSolic.getGrupo().longValue() == DTOE.getNumeroGrupo().longValue()){
                //UtilidadesLog.debug(" entra a Ordenar " );
                treeMap = metodoOrdenaPorRanking (treeMap,dtoPosSolic);
            }
        }
        //Este ArrayList se debe rellenar con las posiciones encontradas dentro de DTOE.posicionesOferta que cumplan 
        //         DTOPosicionSolicitud.grupo == DTOE.numeroGrupo ordenadas 
        //         de mayor a menor por el campo DTOPosicionSolicitud.posicionRanking
        //Si DTOE.ultimoRanking != null 
        //UtilidadesLog.debug(" getUltimoRanking =" + DTOE.getUltimoRanking());
        if (DTOE.getUltimoRanking()!=null){
                //entro de posicionesGrupo la posicion con DTOPosicionSolicitud.posicionRanking == DTOE.ultimoRanking 
                //y la intercambia con la primera posicion
                treeMap = buscaDentroPosicionesGrupo (treeMap,DTOE.getUltimoRanking());
        }
        
        Collection colAux = treeMap.values();
        ArrayList posicionesGrupo = new ArrayList(colAux);
        DTOPosicionSolicitud dtoTmp = null;
        contPosiciones = 0;
        try{
            monCuadreProductosH = this.getMONCuadreProductosHome();  
            monCuadre = monCuadreProductosH.create();
        }catch(NamingException nEx3){
            
            UtilidadesLog.error("e",nEx3);
            throw new MareException(nEx3, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException cEx3){
            
            UtilidadesLog.error("e",cEx3);
            throw new MareException(cEx3, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(RemoteException rEx3){
            
            UtilidadesLog.error("e",rEx3);             
            throw new MareException(rEx3, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        while ( numeroUnidadesA.longValue() >0 && contPosiciones < posicionesGrupo.size()){
            dtoTmp = (DTOPosicionSolicitud) posicionesGrupo.get(contPosiciones);
            //UtilidadesLog.debug(" Comprobamos si se dispone de suficientes unidades de producto a eliminar  " );
            // Comprobamos si se dispone de suficientes unidades de producto a eliminar 
            if (dtoTmp.getUnidadesPorAtender().longValue() >=numeroUnidadesA.longValue()){ //DTOE.getNumeroUnidadesA().longValue()){
               
                try{
                    DTOE.setDTOCabeceraSolicitud(monCuadre.eliminarProductos(DTOE.getDTOCabeceraSolicitud()
                                            ,dtoTmp.getNumeroPosicion(),
                                            numeroUnidadesA));
                                            
                    
                }catch(Exception ex3){
                    
                    UtilidadesLog.error(ex3); 
                    throw new MareException(ex3, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                numeroUnidadesA = new Long(0);
            }else{
                // Eliminamos todas las unidades del producto 
                
                try{
                    DTOE.setDTOCabeceraSolicitud(monCuadre.eliminarProductos(DTOE.getDTOCabeceraSolicitud()
                                                                        ,dtoTmp.getNumeroPosicion()
                                                                        ,dtoTmp.getUnidadesPorAtender()));
                    
                }catch(Exception ex4){
                    throw new MareException(ex4, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                numeroUnidadesA = new Long(numeroUnidadesA.longValue() - dtoTmp.getUnidadesPorAtender().longValue());               
                
            }
            //UtilidadesLog.debug("numeroUnidadesA= " + numeroUnidadesA);
            contPosiciones = contPosiciones + 1;
            //ilidadesLog.debug("contPosiciones= " + contPosiciones);
            
        }
        
        UtilidadesLog.info("MONRankingProductosBean.eliminarProductosGrupo(DTORankingCuadre DTOE): Salida");
        return DTOE.getDTOCabeceraSolicitud();
    }

    private TreeMap metodoOrdenaPorRanking(TreeMap tEntrada, DTOPosicionSolicitud dtoPosicSolic){
        UtilidadesLog.info("MONRankingProductosBean.metodoOrdenaPorRanking(TreeMap tEntrada, DTOPosicionSolicitud dtoPosicSolic): Entrada");
        
        TreeMap tmARetornar = new TreeMap();
        int i = 0;
        DTOPosicionSolicitud dtoAux;
        Long rankAux = null;
        Long rankNuevo = dtoPosicSolic.getPosicionRanking();
        
        if (rankNuevo == null){
            rankNuevo = new Long (0);
        }
        
        for (i = 0; i <tEntrada.size(); i++){
            dtoAux = (DTOPosicionSolicitud) tEntrada.get(new Long (i));
            
            rankAux = dtoAux.getPosicionRanking();
            if (rankAux == null){
                rankAux = new Long (0);
            }
            
            if (rankAux.longValue()<= rankNuevo.longValue()){
                
                tmARetornar.put(new Long (i),dtoAux);
            }else {
                tmARetornar.put(new Long (i),dtoPosicSolic);
                break;
            }
       }
       //   Comentado por HRCS - Incidencia Sicc20080574
       /*if (i ==0){
            tmARetornar.put(new Long (0),dtoPosicSolic);
       }else*/
       if (i == tEntrada.size()){
            //Cleal - REC-01
            //tmARetornar.put(new Long (i+1),dtoPosicSolic);
            tmARetornar.put(new Long (i),dtoPosicSolic);
       }else{
           for (int j = i; j<tEntrada.size(); j++){
                tmARetornar.put(new Long (j+1),tEntrada.get(new Long (j)));
           }
       }
       
       UtilidadesLog.info("MONRankingProductosBean.metodoOrdenaPorRanking(TreeMap tEntrada, DTOPosicionSolicitud dtoPosicSolic): Salida");
       return tmARetornar;

    }
    
    private  TreeMap buscaDentroPosicionesGrupo(TreeMap tEntrada, Long ultimoRanking){
      UtilidadesLog.info("MONRankingProductosBean.buscaDentroPosicionesGrupo(TreeMap tEntrada, Long ultimoRanking): Entrada");
      
      int i;      
      TreeMap resultadoTreeMap = new TreeMap();
      DTOPosicionSolicitud dtoPosSolic = null;
      for (i = 0; i < tEntrada.size();i++){
         dtoPosSolic = (DTOPosicionSolicitud) tEntrada.get(new Long (i));
         if (dtoPosSolic.getPosicionRanking().longValue() == ultimoRanking.longValue()){
              resultadoTreeMap.put(new Long (0),dtoPosSolic);
              break;
         }else {
              resultadoTreeMap.put(new Long (i + 1),dtoPosSolic);
         }
      }
      UtilidadesLog.info("MONRankingProductosBean.buscaDentroPosicionesGrupo(TreeMap tEntrada, Long ultimoRanking): Salida");
      return resultadoTreeMap;
  }

  private MONCuadreProductosHome getMONCuadreProductosHome() throws NamingException
  {
      final InitialContext context = new InitialContext();
      return (MONCuadreProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreProductos"), MONCuadreProductosHome.class);
  }

  private MONOfertaHome getMONOfertaHome() throws NamingException
  {
      final InitialContext context = new InitialContext();
      return (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOferta"), MONOfertaHome.class);
  }
    
}