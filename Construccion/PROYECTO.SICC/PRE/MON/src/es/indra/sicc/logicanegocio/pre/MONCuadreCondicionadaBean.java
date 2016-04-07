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
 
package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.dtos.pre.DTOCuadrarCondicion;
import es.indra.sicc.dtos.pre.DTORankingCuadre;
import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.sicc.entidades.pre.OfertaLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

/**
* MON encargado de cuadrar ofertas condicionadas.
*
* @version 3.6 - 12 Sep 2005
* @author Emilio Noziglia
*/
public class MONCuadreCondicionadaBean implements SessionBean  {

    SessionContext ctx;
    private Long tipoPosicion;
    private Long subtipoPosicion;
    private Long primerRanking;
    private Long ultimoRanking;
    private Long oidOferta;
    
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
    * @autor jpbosnja
    * @modificado pperanzola [1] 12/08/2005 Se actualiza para que pueda calcular el ranking
    **/
    public DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion) throws MareException {
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion): Entrada");
        try{
            /*UtilidadesLog.debug("----------------------------------------------------------------------");
            UtilidadesLog.debug("-------------------ENTRE DE CUADRE CONDICIONADA-----------------------");
            UtilidadesLog.debug("----------------------------------------------------------------------");*/
            OfertaLocalHome olh =  new OfertaLocalHome();
            
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesOferta.get(0);
            OfertaLocal oferta = olh.findByPrimaryKey(dtoP.getOidOferta());
            ArrayList factoresCuadre = obtenerFactorCuadreGrupos(oferta.getOid());
            ArrayList indicadoresCuadre = obtenerIndicadorCuadreGrupos(oferta.getOid());
            // pperanzola [1]
            this.setOidOferta(oferta.getOid());
            
            this.setPrimerRanking((oferta.getPrimeraPosicionRanking()!=null) 
                                   ? new Long(oferta.getPrimeraPosicionRanking().longValue())
                                   :null);
            this.setUltimoRanking((oferta.getUltimaPosicionRanking()!=null)
                                   ? new Long(oferta.getUltimaPosicionRanking().longValue())
                                   :null);                                   
            this.setSubtipoPosicion(subtipoPosicion);
            this.setTipoPosicion(tipoPosicion);
            // pperanzola [1]
          
            ArrayList unidadesOferta = calcularUnidadesOferta(posicionesOferta, oferta.getNumeroGrupos().intValue());

            DTOCuadrarCondicion dtoC = new DTOCuadrarCondicion();
            dtoC.setCabeceraSolicitud(dtoe);
            dtoC.setPosicionesOferta(posicionesOferta);
            dtoC.setUnidadesOferta(unidadesOferta);
            dtoC.setIndicadorCuadreGrupos(indicadoresCuadre);
            dtoC.setFactorCuadreGrupos(factoresCuadre);
            dtoC.setNumeroGrupos(oferta.getNumeroGrupos().intValue());
            if (oferta.getNumeroGruposCondicionados()!=null){
                UtilidadesLog.debug("Numero grupos Condicionados: "+oferta.getNumeroGruposCondicionados().intValue());
                dtoC.setNumeroGruposCondicionados(oferta.getNumeroGruposCondicionados().intValue());
            }
            if (oferta.getNumeroGruposCondicionantes()!=null){
                UtilidadesLog.debug("Numero grupos Condicionantes: "+oferta.getNumeroGruposCondicionantes().intValue());
                dtoC.setNumeroGruposCondicionantes(oferta.getNumeroGruposCondicionantes().intValue());
            }
            dtoC.setCondicionCondicionados(oferta.getCondicionCondicionados());
            UtilidadesLog.debug("CondicionCondicionados: "+oferta.getCondicionCondicionados());
            dtoC.setCondicionCondicionantes(oferta.getCondicionCondicionantes());
            UtilidadesLog.debug("CondicionCondicionantes: "+oferta.getCondicionCondicionantes());
            dtoC.setDespachoAutomatico(oferta.getDespachoAutomatico());
            //UtilidadesLog.debug("DespachoAutomatico: "+oferta.getDespachoAutomatico());
            dtoC.setCuadreFinalizado(Boolean.FALSE);
            //UtilidadesLog.debug("DTO ANTES cuadrarCondicionG1: "+dtoC);
            dtoC = cuadrarCondicionG1(dtoC);
            //UtilidadesLog.debug("DTO DESPUES cuadrarCondicionG1: "+dtoC);
            if (!dtoC.getCuadreFinalizado().booleanValue()){
                dtoC = cuadrarCondicionG2(dtoC);
                //UtilidadesLog.debug("DTO DESPUES cuadrarCondicionG2: "+dtoC);
            }           
            
            /*UtilidadesLog.debug("----------------------------------------------------------------------");
            UtilidadesLog.debug("--------------------SALI DE CUADRE CONDICIONADA-----------------------");
            UtilidadesLog.debug("----------------------------------------------------------------------");*/
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion): Salida");
            return dtoC.getCabeceraSolicitud();
        } catch (NoResultException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**
    *
    * @autor jpbosnja
    * @modificado: 10/08/2005 - pperanzola - se necesita que se inicialicen los 
    *              arraylist porque sino se retorna un arraylist incompleto
    **/
    private ArrayList calcularUnidadesOferta(ArrayList posicionesOferta, int numeroGrupos) throws Exception {              
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularUnidadesOferta(ArrayList posicionesOferta, int numeroGrupos): Entrada");
        
        ArrayList montoGrupos = new ArrayList();
        ArrayList unidadesOferta = new ArrayList();
        int i;
        double monto = 0.0;
        int numeroPosicion = 0;
        //inicializo los arraylist
        for (i = 0; i < numeroGrupos ; i++){
            montoGrupos.add(new Double(0));
            unidadesOferta.add(new Double(0));
        }
        
        for(;numeroPosicion<posicionesOferta.size();numeroPosicion++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
            //UtilidadesLog.debug("Numero Posicion: "+numeroPosicion);
            monto = 0.0;
            if (dtoP.getIndicadorCuadre().longValue() == ConstantesPRE.CUADRE_TOTAL_MONTOS){
                //UtilidadesLog.debug("Indicador de cuadre CUADRE_TOTAL_MONTOS");
                monto = ((Double)montoGrupos.get(dtoP.getGrupo().intValue() - 1)).doubleValue();

                /*UtilidadesLog.debug("MONTO: "+monto);
                UtilidadesLog.debug("OidPosicionSolicitud: "+dtoP.getOidPosicionSolicitud());
                UtilidadesLog.debug("PrecioCatalogoUnitarioLocal: "+dtoP.getPrecioCatalogoUnitarioLocal());
                UtilidadesLog.debug("UnidadesPorAtender: "+dtoP.getUnidadesPorAtender());
                UtilidadesLog.debug("FactorRepeticion: "+dtoP.getFactorRepeticion());*/

                monto = monto + (dtoP.getPrecioCatalogoUnitarioLocal().doubleValue() 
                                 * dtoP.getUnidadesPorAtender().longValue()
                                 * dtoP.getFactorRepeticion().intValue());
                
                UtilidadesLog.debug("MONTO+PRECIOCATALOGOUNITARIOLOCAL*FACTORREPETICIO*UNIDADESPORATENDER: "+monto);
               // UtilidadesLog.debug("MODIFICO MONTO PARA EL GRUPO "+(dtoP.getGrupo().intValue()-1)); 

                montoGrupos.set(dtoP.getGrupo().intValue() - 1, new Double(monto));

                double unidadOferta=0.0;

                unidadOferta = (monto / dtoP.getFactorCuadre().longValue());
                                    //+ ((Double)unidadesOferta.get(dtoP.getGrupo().intValue() - 1)).doubleValue();
                                    
                //UtilidadesLog.debug("UNIDADOFERTA: "+unidadOferta);
                
                unidadesOferta.set(dtoP.getGrupo().intValue() - 1, new Double(unidadOferta));

            }else if(dtoP.getIndicadorCuadre().longValue() == ConstantesPRE.CUADRE_TOTAL_UNIDADES ){
                //UtilidadesLog.debug("Indicador de cuadre CUADRE_TOTAL_UNIDADES");

                monto = ((Double)montoGrupos.get(dtoP.getGrupo().intValue() - 1)).doubleValue();
                //UtilidadesLog.debug("MONTO: "+monto);

                monto = monto + dtoP.getUnidadesPorAtender().longValue();
                UtilidadesLog.debug("MONTO+UNIDADESPORATENDER: "+monto);
                UtilidadesLog.debug("MODIFICO MONTO PARA EL GRUPO "+(dtoP.getGrupo().intValue()-1));

                montoGrupos.set(dtoP.getGrupo().intValue() - 1, new Double(monto));
                double unidadOferta=0.0;
                //unidadOferta = (monto / dtoP.getFactorCuadre().longValue()) + ((Double)unidadesOferta.get(dtoP.getGrupo().intValue() - 1)).doubleValue();
                unidadOferta = (monto / dtoP.getFactorCuadre().longValue());
                               // + ((Double)unidadesOferta.get(dtoP.getGrupo().intValue() - 1)).doubleValue();
                unidadesOferta.set(dtoP.getGrupo().intValue() - 1, new Double(unidadOferta));
                //UtilidadesLog.debug("UNIDADOFERTA: "+unidadOferta);
            }
        }
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularUnidadesOferta(ArrayList posicionesOferta, int numeroGrupos): Salida");
        return unidadesOferta;
    }

   /**    
    * @autor jpbosnja
    * @modificado  [1] - 18/08/2005 -pperanzola -  se modifica el diseño porque el cuadre debe ser de la parte entera
    **/
    private DTOCuadrarCondicion calcularCuadre(DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularCuadre(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        Double cuadre = null;
        if (dtoCuadrarCondicion.getCondicionCondicionantes().equalsIgnoreCase(ConstantesPRE.Y)){
            cuadre = (Double)dtoCuadrarCondicion.getUnidadesOferta().get(0);
        }else{
            cuadre = new Double(0.0);
        }
        int numeroPosicion = 0;
        for (;numeroPosicion <= dtoCuadrarCondicion.getNumeroGruposCondicionantes()-1;numeroPosicion++){
            if (dtoCuadrarCondicion.getCondicionCondicionantes().equalsIgnoreCase(ConstantesPRE.Y)){
                //UtilidadesLog.debug("Entra por ConstantesPRE.Y");
                Double unidadOferta = (Double)dtoCuadrarCondicion.getUnidadesOferta().get(numeroPosicion);
                cuadre = new Double(Math.min(cuadre.doubleValue(),unidadOferta.doubleValue()));
            }else{
                //UtilidadesLog.debug("ELSE");
                cuadre = new Double(cuadre.doubleValue()+Math.floor(((Double)dtoCuadrarCondicion.getUnidadesOferta().get(numeroPosicion)).doubleValue()));
            }
        }
        UtilidadesLog.debug("VALOR CUADRE: "+cuadre);
        // [1] dtoCuadrarCondicion.setCuadre(new Long(Math.round(cuadre.doubleValue())).intValue());
        dtoCuadrarCondicion.setCuadre(cuadre.intValue()); 
        //[1]
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularCuadre(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
        return dtoCuadrarCondicion;
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion cuadrarCondicionG1(DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG1(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        dtoCuadrarCondicion = calcularCuadre(dtoCuadrarCondicion);
        //UtilidadesLog.debug("DTOCuadrarCondicion despues de calcularCuadre: "+dtoCuadrarCondicion);
        if (dtoCuadrarCondicion.getCuadre()<1){
            //UtilidadesLog.debug("----Se procede a eliminar los productos condicionados de la solicitud-----");
            int numeroPosicion = 0;
            ArrayList posicionesOferta = dtoCuadrarCondicion.getPosicionesOferta();
            for (;numeroPosicion<posicionesOferta.size();numeroPosicion++){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                if (!dtoP.getIndCondicionante().booleanValue()){
                    UtilidadesLog.debug("Se procede a eliminar de la posicion "+dtoP.getNumeroPosicion()+" "+dtoP.getUnidadesPorAtender()+" unidades");
                    dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().eliminarProductos(dtoCuadrarCondicion.getCabeceraSolicitud(), dtoP.getNumeroPosicion(), dtoP.getUnidadesPorAtender()));
                    dtoCuadrarCondicion.setCuadreFinalizado(Boolean.TRUE);
                }
            }
        }
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG1(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
        return dtoCuadrarCondicion;
    }

   /**    
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion cuadrarCondicionG2(DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        if (dtoCuadrarCondicion.getCondicionCondicionados()!=null && dtoCuadrarCondicion.getCondicionCondicionados().equalsIgnoreCase(ConstantesPRE.Y)){
            if (dtoCuadrarCondicion.getDespachoAutomatico()!=null && !dtoCuadrarCondicion.getDespachoAutomatico().booleanValue()){
                UtilidadesLog.debug("-------HAY CONDICIONADOS 'Y' Y TIENE DESPACHO AUTOMATICO FALSE---------");
                dtoCuadrarCondicion = calcularCuadreSinDespachoAutomatico(dtoCuadrarCondicion);
            // Modificado por SICC20070369 - Rafael Romero - 01/08/2007
            }
            //} else {
            //  //enozigli 12/10/06 Cambio por incidencia V_PRE01
            //    dtoCuadrarCondicion = cuadrarCondicionG2Y(dtoCuadrarCondicion);    
            //}
            dtoCuadrarCondicion = cuadrarCondicionG2Y(dtoCuadrarCondicion);    
            // Fin Modificado SICC20070369
        }else if (dtoCuadrarCondicion.getCondicionCondicionados()!=null && dtoCuadrarCondicion.getCondicionCondicionados().equalsIgnoreCase(ConstantesPRE.O)){
            UtilidadesLog.debug("-------HAY CONDICIONADOS 'O'---------");
            dtoCuadrarCondicion = cuadrarCondicionG2O(dtoCuadrarCondicion);
        }else{
            UtilidadesLog.debug("------NO HAY CONDICIONADOS-------");
        }
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
        return dtoCuadrarCondicion;
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion cuadrarCondicionG2Y (DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2Y(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        try{
            ArrayList unidadesOferta = dtoCuadrarCondicion.getUnidadesOferta();
            ArrayList factorCuadreGrupos = dtoCuadrarCondicion.getFactorCuadreGrupos();
            int cuadre = dtoCuadrarCondicion.getCuadre();
            int numeroPosicion = dtoCuadrarCondicion.getNumeroGruposCondicionantes();
            UtilidadesLog.debug("Posicion Inicial: "+numeroPosicion);
            UtilidadesLog.debug("Posicion Final: "+dtoCuadrarCondicion.getUnidadesOferta().size());
            for (;numeroPosicion<dtoCuadrarCondicion.getUnidadesOferta().size();numeroPosicion++){
                Double unidadOferta = (Double)unidadesOferta.get(numeroPosicion);
                Long factorCuadre = (Long)factorCuadreGrupos.get(numeroPosicion);
                //UtilidadesLog.debug("unidadOferta: "+unidadOferta);
                //UtilidadesLog.debug("factorCuadre: "+factorCuadre);
                //UtilidadesLog.debug("cuadre: "+cuadre);

                // Modificado por SICC2007386 - Rafael Romero - 09/08/2007
                // Solo se agregan el producto condicionado, siempre que se haya solicitado
                boolean indAagregar = false;
                if(dtoCuadrarCondicion.getDespachoAutomatico().booleanValue()){
                    indAagregar = true;
                }else{
                    //Modificado por 20080757 - enoziglia -8/10/08
                     /* if(unidadOferta.floatValue() > 0){
                          indAagregar = true;
                      }else{
                          indAagregar = false;
                      }*/
                      indAagregar = false;
                }
                
                if ((indAagregar) && (cuadre - unidadOferta.floatValue()) >0){
                // Fin modificado SICC2007386
                    //UtilidadesLog.debug("AGREGO PRODUCTOS");
                    long unidadesSumar = Math.round((cuadre - unidadOferta.floatValue())*factorCuadre.longValue());
                    // pperanzola [1]
                    //dtoCuadrarCondicion = agregarProductosGrupoG2Y(dtoCuadrarCondicion, unidadesSumar, numeroPosicion+1);
                    dtoCuadrarCondicion = agregarProductosGrupo(dtoCuadrarCondicion
                                                                ,dtoCuadrarCondicion.getPosicionesOferta()
                                                                , new Long (unidadesSumar)
                                                                , new Integer(numeroPosicion+1));
                    // pperanzola [1]
                }else if ((cuadre - unidadOferta.floatValue()) <0){
                    //UtilidadesLog.debug("ELIMINO PRODUCTOS");
                    long unidadesRestar = Math.round((unidadOferta.floatValue()-cuadre)*factorCuadre.longValue());
                    // pperanzola [1]
                    //dtoCuadrarCondicion = eliminarProductosGrupoG2Y(dtoCuadrarCondicion, unidadesRestar, numeroPosicion+1);
                    dtoCuadrarCondicion = eliminarProductosGrupo(dtoCuadrarCondicion
                                                                , dtoCuadrarCondicion.getPosicionesOferta()
                                                                , new Long (-unidadesRestar)
                                                                , new Integer(numeroPosicion+1));
                    // pperanzola [1]
                }
            }
            UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2Y(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
            return dtoCuadrarCondicion;
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion agregarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Entrada");
        try{
            DTOCabeceraSolicitud dtoC = dtoCuadrarCondicion.getCabeceraSolicitud();
            ArrayList posicionesOferta = dtoCuadrarCondicion.getPosicionesOferta();            
            DTOPosicionSolicitud dtoP = null;
            int i = 0;
            int cantPos = posicionesOferta.size();
            for (; cantPos >i ; i++){
                dtoP = (DTOPosicionSolicitud)posicionesOferta.get(i);
                if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                    break;
                }
            }
            if (dtoP==null){
                //UtilidadesLog.debug("NO ENCONTRO Posiciones con grupo");
                return dtoCuadrarCondicion;
            }            
            while( numeroUnidadesA > 0 && dtoP.getGrupo().intValue() == numeroGrupo){ 
                long numeroUnidadesB=0;
                numeroUnidadesB = numeroUnidadesA;
                DTOAgregarProductoSolicitud dtoAPS = new DTOAgregarProductoSolicitud();
                dtoAPS.setUnidadesPorAtender(new Long(numeroUnidadesB));
                dtoAPS.setNumeroPosicion(dtoP.getNumeroPosicion());
                //UtilidadesLog.debug("VOY A AGREGAR "+numeroUnidadesB+" EN LA POSICION "+dtoP.getNumeroPosicion());
                //dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().agregarProductos(dtoC,dtoAPS,dtoP));
                dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosLocalHome().create().agregarProductos(dtoC,dtoAPS,dtoP));
                numeroUnidadesA = numeroUnidadesA - numeroUnidadesB;
            }
            UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Salida");
            return dtoCuadrarCondicion;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } 
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion eliminarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Entrada");
        try{
            DTOCabeceraSolicitud dtoC = dtoCuadrarCondicion.getCabeceraSolicitud();
            ArrayList posicionesOferta = dtoCuadrarCondicion.getPosicionesOferta();            
            DTOPosicionSolicitud dtoP = null;
            int i = 0;
            for (;  posicionesOferta.size()>i ; i++){
                dtoP = (DTOPosicionSolicitud)posicionesOferta.get(i);
                if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                    break;
                }
            }
            if (dtoP==null){
                UtilidadesLog.debug("NO ENCONTRO Posiciones con grupo");
                return dtoCuadrarCondicion;
            }
            BigDecimal precioCatalogo = dtoP.getPrecioCatalogoUnitarioLocal();
            Integer factorRepeticion = dtoP.getFactorRepeticion();
            while( numeroUnidadesA > 0 && dtoP.getGrupo().intValue() == numeroGrupo){ 
                long numeroUnidadesB=0;
                /*if (((Long)indicadoresCuadre.get(numeroGrupo-1)).longValue() == ConstantesPRE.CUADRE_TOTAL_MONTOS){
                    //numeroUnidadesB = Math.round(numeroUnidadesA / (precioCatalogo.floatValue() * factorRepeticion.intValue()));
                    numeroUnidadesB = new Double(Math.ceil(numeroUnidadesA / (precioCatalogo.floatValue() * factorRepeticion.intValue()))).longValue();
                }else if(((Long)indicadoresCuadre.get(numeroGrupo-1)).longValue() == ConstantesPRE.CUADRE_TOTAL_UNIDADES){
                    numeroUnidadesB = numeroUnidadesA;
                } */
                //inc 10247
                numeroUnidadesB = numeroUnidadesA;
                //inc 10247
                if (dtoP.getUnidadesPorAtender().longValue() >= numeroUnidadesB){ 
                    //UtilidadesLog.debug("VOY A AGREGAR "+numeroUnidadesB+" EN LA POSICION "+dtoP.getNumeroPosicion());
                    //dtoCuadrarCondicion.setCabeceraSolicitud(this.getMONCuadreProductosHome().create().eliminarProductos(dtoC, dtoP.getNumeroPosicion(), new Long(numeroUnidadesB))); 
                    dtoCuadrarCondicion.setCabeceraSolicitud(this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoC, dtoP.getNumeroPosicion(), new Long(numeroUnidadesB))); 
                    numeroUnidadesA = numeroUnidadesA - numeroUnidadesB;
                }else{ 
                    //UtilidadesLog.debug("VOY A AGREGAR "+dtoP.getUnidadesPorAtender()+" EN LA POSICION "+dtoP.getNumeroPosicion());
                    //dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().eliminarProductos(dtoC, dtoP.getNumeroPosicion(), dtoP.getUnidadesPorAtender())); 
                    dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosLocalHome().create().eliminarProductos(dtoC, dtoP.getNumeroPosicion(), dtoP.getUnidadesPorAtender())); 
                    numeroUnidadesA = numeroUnidadesA - dtoP.getUnidadesPorAtender().longValue(); 

                    for (; posicionesOferta.size()>i ; i++){
                        dtoP = (DTOPosicionSolicitud)posicionesOferta.get(i);
                        if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                            break;
                        }
                    }
                    precioCatalogo = dtoP.getPrecioCatalogoUnitarioLocal();
                    factorRepeticion = dtoP.getFactorRepeticion();
                }
            }
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupoG2Y(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Salida");
            return dtoCuadrarCondicion;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } 
    }

   /**
    * @autor jpbosnja
    * @modificado pperanzola [1] 12/08/2005 Se modifica para utilizar sólo 1 eliminar
    *             o agregar independientemente de que sea Y o O
    **/
    private DTOCuadrarCondicion cuadrarCondicionG2O(DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2O(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        ArrayList unidadesOferta = dtoCuadrarCondicion.getUnidadesOferta(); 
        ArrayList factorCuadreGrupos = dtoCuadrarCondicion.getFactorCuadreGrupos(); 
        int cuadre = dtoCuadrarCondicion.getCuadre(); 
        Boolean despachoAutomatico = dtoCuadrarCondicion.getDespachoAutomatico(); 
        //UtilidadesLog.debug("CUADRE: "+cuadre);
        UtilidadesLog.debug("despachoAutomatico: "+despachoAutomatico);
        double numeroUnidadesA = 0.0;
        int numeroPosicion = dtoCuadrarCondicion.getNumeroGruposCondicionantes();
        RecordSet rsGrupos=null;
        Long grupoA=null;
        int contadorRS;
        int cantUOf = unidadesOferta.size();
        for (;cantUOf > numeroPosicion; numeroPosicion++){
            Double unidadOferta = (Double)unidadesOferta.get(numeroPosicion);
            Long factorCuadre = (Long)factorCuadreGrupos.get(numeroPosicion); 
            if (unidadOferta.floatValue() != unidadOferta.intValue()) { 
                numeroUnidadesA = Math.ceil(unidadOferta.doubleValue()) - unidadOferta.floatValue(); 
                numeroUnidadesA = Math.round(numeroUnidadesA * factorCuadre.longValue());
                unidadesOferta.set(numeroPosicion, new Double(Math.ceil(unidadOferta.doubleValue())));
                //UtilidadesLog.debug("numeroUnidadesA: "+numeroUnidadesA);
                if (numeroUnidadesA > 0) { 
                    //UtilidadesLog.debug("VOY A AGREGAR PRODUCTOS");
                    //pperanzola [1]
                    //dtoCuadrarCondicion = agregarProductosGrupoG2O(dtoCuadrarCondicion, new Double(numeroUnidadesA).longValue(), numeroPosicion+1); 
                    dtoCuadrarCondicion = agregarProductosGrupo(dtoCuadrarCondicion
                                                                ,dtoCuadrarCondicion.getPosicionesOferta()
                                                                ,new Long (new Double( numeroUnidadesA).longValue()) 
                                                                ,new Integer(numeroPosicion+1));                    
                    //pperanzola [1]
                } 
            } 
        }
        numeroPosicion = dtoCuadrarCondicion.getNumeroGruposCondicionantes();
        float totalCondicionados=0;
        Long factorCuadreAux= null;        
        //UtilidadesLog.debug("numeroPosicion: "+numeroPosicion);
        numeroPosicion = dtoCuadrarCondicion.getNumeroGruposCondicionantes();
        // Recorremos los grupos condicionados 
        for (;unidadesOferta.size()> numeroPosicion; numeroPosicion++){
            totalCondicionados = totalCondicionados + ((Double)unidadesOferta.get(numeroPosicion)).floatValue();
        }
        //UtilidadesLog.debug("totalCondicionados: "+totalCondicionados);
               
        if (totalCondicionados < cuadre && despachoAutomatico.booleanValue()){ 
            numeroUnidadesA = cuadre - totalCondicionados;
            
            if (numeroUnidadesA > 0){ 
                //pperanzola [1]
                // Buscamos todos los productos pertenecientes a grupos condicionados y obtenemos el de menor ranking
                UtilidadesLog.debug("numeroUnidadesA > 0");
                //rsGrupos  = getMONOfertaHome().create().obtenerGrupoCondicionadoMenorRanking(this.getOidOferta());
                rsGrupos  = getMONOfertaLocalHome().create().obtenerGrupoCondicionadoMenorRanking(this.getOidOferta());
                //UtilidadesLog.debug("Obtuve el rsGrupos obtenerGrupoCondicionadoMenorRanking ");
                grupoA = new Long (((BigDecimal) rsGrupos.getValueAt(0,"NUM_GRUP")).longValue());
                factorCuadreAux = (Long)factorCuadreGrupos.get(dtoCuadrarCondicion.getNumeroGruposCondicionantes()); 
                //UtilidadesLog.debug("factorCuadreAux = " + factorCuadreAux);
                numeroUnidadesA = Math.round(numeroUnidadesA * factorCuadreAux.longValue());
                //dtoCuadrarCondicion = agregarProductosGrupoG2O(dtoCuadrarCondicion, new Double(numeroUnidadesA).longValue(), numeroPosicion+1); 
                dtoCuadrarCondicion = agregarProductosGrupo(dtoCuadrarCondicion
                                                            ,dtoCuadrarCondicion.getPosicionesOferta()
                                                            ,new Long (new Double( numeroUnidadesA).longValue())
                                                            ,new Integer(grupoA.intValue()));
                //pperanzola [1]    
            } 
        }else if (totalCondicionados > cuadre){ 
            //pperanzola [1]
            //UtilidadesLog.debug("totalCondicionados > cuadre ");
            // Buscamos todos los productos pertenecientes a grupos condicionados y obtenemos el de mayor 
            //rsGrupos = getMONOfertaHome().create().obtenerGrupoCondicionadoMayorRanking(this.getOidOferta());
            rsGrupos = getMONOfertaLocalHome().create().obtenerGrupoCondicionadoMayorRanking(this.getOidOferta());
            //UtilidadesLog.debug(" Obtubo rsGrupos ");
            contadorRS = 0;
            ArrayList listaAntes = null;
            DTOPosicionSolicitud dtoAntes = null;
            ArrayList listaDespues = null;
            DTOPosicionSolicitud dtoDespues = null;
            long diferenciaDeUnidades = 0;
            numeroUnidadesA = totalCondicionados - cuadre; 
            while (numeroUnidadesA > 0 && contadorRS < rsGrupos.getRowCount()){
                //UtilidadesLog.debug("contadorRS = "+contadorRS);
                grupoA = new Long (((BigDecimal) rsGrupos.getValueAt(contadorRS,"NUM_GRUP")).longValue());
                //UtilidadesLog.debug("grupoA = "+grupoA);
                factorCuadreAux = (Long)factorCuadreGrupos.get(dtoCuadrarCondicion.getNumeroGruposCondicionantes()); 
                //UtilidadesLog.debug("numeroUnidadesA antes = "+numeroUnidadesA);
                numeroUnidadesA = Math.round(numeroUnidadesA * factorCuadreAux.longValue());
                

                listaAntes = (ArrayList)dtoCuadrarCondicion.getCabeceraSolicitud().getPosiciones().clone();

                dtoCuadrarCondicion = eliminarProductosGrupo(dtoCuadrarCondicion
                                                        , dtoCuadrarCondicion.getPosicionesOferta()
                                                        , new Long(new Double( - numeroUnidadesA).longValue())
                                                        , new Integer (grupoA.intValue()));
                listaDespues = dtoCuadrarCondicion.getCabeceraSolicitud().getPosiciones();

                //UtilidadesLog.debug("numeroUnidadesA antes del for = "+numeroUnidadesA);
                for (int k =0; k <listaAntes.size(); k++){
                    dtoAntes = (DTOPosicionSolicitud)listaAntes.get(k);
                    dtoDespues = (DTOPosicionSolicitud)listaDespues.get(k);
                    UtilidadesLog.debug("dtoAntes.getOidOferta() gg " + dtoAntes.getOidOferta());
                    UtilidadesLog.debug("dtoAntes.getGrupo() gg " + dtoAntes.getGrupo());
                    if ((dtoAntes.getGrupo() != null) && (dtoAntes.getGrupo().intValue() == grupoA.intValue())) {
                        diferenciaDeUnidades = diferenciaDeUnidades + dtoAntes.getUnidadesPorAtender().longValue() - dtoDespues.getUnidadesPorAtender().longValue();
                        //UtilidadesLog.debug("diferenciaDeUnidades = "+diferenciaDeUnidades);
                    }
                }
                numeroUnidadesA = numeroUnidadesA - diferenciaDeUnidades;
                //UtilidadesLog.debug("numeroUnidadesA despues del for = "+numeroUnidadesA);
                diferenciaDeUnidades = 0;


                contadorRS = contadorRS  + 1;                                                        
            }           
            //pperanzola [1]
        }
        
        UtilidadesLog.info("MONCuadreCondicionadaBean.cuadrarCondicionG2O(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
        return dtoCuadrarCondicion;
    }

   /**    
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion agregarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Entrada");
        try{
            DTOCabeceraSolicitud dtoC = dtoCuadrarCondicion.getCabeceraSolicitud();
            ArrayList posicionesOferta = dtoCuadrarCondicion.getPosicionesOferta();            
            DTOPosicionSolicitud dtoP = null;
            int cantPos = posicionesOferta.size();
            
            for (int i = 0 ; cantPos >i ; i++){
                dtoP = (DTOPosicionSolicitud)posicionesOferta.get(i);
                if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                    break;
                }
            }
            if (dtoP==null){
                //UtilidadesLog.debug("NO ENCONTRO Posiciones con grupo");
                return dtoCuadrarCondicion;
            }            
            long numeroUnidadesB=0;
            
            numeroUnidadesB = numeroUnidadesA;
            
            DTOAgregarProductoSolicitud dtoAPS = new DTOAgregarProductoSolicitud();
            dtoAPS.setUnidadesPorAtender(new Long(numeroUnidadesB));
            dtoAPS.setNumeroPosicion(dtoP.getNumeroPosicion());
            //UtilidadesLog.debug("VOY A AGREGAR "+numeroUnidadesB+" UNIDADES A LA POSICION "+dtoP.getNumeroPosicion());
            //dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().agregarProductos(dtoC,dtoAPS,dtoP));
            dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosLocalHome().create().agregarProductos(dtoC,dtoAPS,dtoP));
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Salida");
            return dtoCuadrarCondicion;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**     
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion eliminarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Entrada");
        try{
            DTOCabeceraSolicitud dtoC = dtoCuadrarCondicion.getCabeceraSolicitud();
            ArrayList posicionesOfertas = dtoCuadrarCondicion.getPosicionesOferta();            
            ArrayList factoresCuadre = dtoCuadrarCondicion.getFactorCuadreGrupos();
            DTOPosicionSolicitud dtoP = null;
            int i = 0;
            int cantPos = posicionesOfertas.size();
            
            for (; cantPos>i ; i++){
                dtoP = (DTOPosicionSolicitud)posicionesOfertas.get(i);
                if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                    break;
                }
            }
            if (dtoP==null){
                //UtilidadesLog.debug("NO ENCONTRO Posiciones con grupo");
                return dtoCuadrarCondicion;
            }
            while(numeroUnidadesA > 0){
                long numeroUnidadesB = numeroUnidadesA * ((Long)factoresCuadre.get(numeroGrupo - 1)).longValue();
                if (dtoP.getUnidadesPorAtender().longValue() >= numeroUnidadesB ){
                    //UtilidadesLog.debug("VOY A ELIMINAR "+numeroUnidadesB+" UNIDADES A LA POSICION "+dtoP.getNumeroPosicion());
                    //dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().eliminarProductos(dtoC,dtoP.getNumeroPosicion(), new Long(numeroUnidadesB)));
                    dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosLocalHome().create().eliminarProductos(dtoC,dtoP.getNumeroPosicion(), new Long(numeroUnidadesB)));
                    numeroUnidadesA = 0;
                }else{
                    //UtilidadesLog.debug("VOY A ELIMINAR "+dtoP.getUnidadesPorAtender()+" UNIDADES A LA POSICION "+dtoP.getNumeroPosicion());
                    //dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosHome().create().eliminarProductos(dtoC,dtoP.getNumeroPosicion(), dtoP.getUnidadesPorAtender()));
                    dtoCuadrarCondicion.setCabeceraSolicitud(getMONCuadreProductosLocalHome().create().eliminarProductos(dtoC,dtoP.getNumeroPosicion(), dtoP.getUnidadesPorAtender()));
                    //numeroUnidadesA = (new Long(numeroUnidadesB).intValue() * ((Long)factoresCuadre.get(numeroGrupo - 1)).intValue()) - dtoP.getUnidadesPorAtender().intValue();
                    //10239
                    numeroUnidadesA = (new Long(numeroUnidadesB).intValue() - dtoP.getUnidadesPorAtender().intValue()/((Long)factoresCuadre.get(numeroGrupo - 1)).intValue());
                    //inc 8606
                    int cantPosi = posicionesOfertas.size();
                    
                    for (; cantPosi >i ; i++){
                        dtoP = (DTOPosicionSolicitud)posicionesOfertas.get(i);
                        if (dtoP.getGrupo()!=null && dtoP.getGrupo().intValue() == numeroGrupo){
                            break;
                        }
                    }
                    dtoC = dtoCuadrarCondicion.getCabeceraSolicitud();
                }
            }
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupoG2O(DTOCuadrarCondicion dtoCuadrarCondicion, long numeroUnidadesA, int numeroGrupo): Salida");
            return dtoCuadrarCondicion;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCuadrarCondicion calcularCuadreSinDespachoAutomatico(DTOCuadrarCondicion dtoCuadrarCondicion) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularCuadreSinDespachoAutomatico(DTOCuadrarCondicion dtoCuadrarCondicion): Entrada");
        ArrayList unidadesOferta = dtoCuadrarCondicion.getUnidadesOferta();
        Double maxUnidadOferta = new Double(0);
        if ((dtoCuadrarCondicion.getNumeroGruposCondicionantes()-1) < unidadesOferta.size()){
            maxUnidadOferta = (Double)unidadesOferta.get(dtoCuadrarCondicion.getNumeroGruposCondicionantes()-1);
        }        
        int numeroPosicion = dtoCuadrarCondicion.getNumeroGruposCondicionantes();
        for (;unidadesOferta.size()> numeroPosicion; numeroPosicion++){
            Double unidad = (Double)unidadesOferta.get(numeroPosicion);
            if (unidad.doubleValue() > maxUnidadOferta.doubleValue()){
                maxUnidadOferta = unidad;
            }
        }
        //UtilidadesLog.debug("CuadreOriginal: "+dtoCuadrarCondicion.getCuadre());
        //UtilidadesLog.debug("maxUnidadOferta: "+maxUnidadOferta);
        int cuadre = new Long(Math.min(dtoCuadrarCondicion.getCuadre(),Math.round(maxUnidadOferta.doubleValue()))).intValue();
        //UtilidadesLog.debug("VALOR CUADRE: "+cuadre);
        dtoCuadrarCondicion.setCuadre(cuadre);
        
        UtilidadesLog.info("MONCuadreCondicionadaBean.calcularCuadreSinDespachoAutomatico(DTOCuadrarCondicion dtoCuadrarCondicion): Salida");
        return dtoCuadrarCondicion;
    }

   /**
    *@autor jpbosnja
    **/
    private ArrayList obtenerIndicadorCuadreGrupos(Long oidOferta) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.obtenerIndicadorCuadreGrupos(Long oidOferta): Entrada");
        try{
            DTOOID dto = new DTOOID();
            dto.setOid(oidOferta);
            //DTOSalida dtoS = getMONOfertaHome().create().obtenerIndicadorCuadreGrupos(dto);
            DTOSalida dtoS = getMONOfertaLocalHome().create().obtenerIndicadorCuadreGrupos(dto);
            ArrayList indicadorCuadreGrupos = new ArrayList();
            RecordSet r = dtoS.getResultado();
            //UtilidadesLog.debug("-------INDICADORES DE CUADRE DE LOS GRUPOS------"); 
            int rows = r.getRowCount();
            
            for (int i = 0 ; i< rows;i++){
                //UtilidadesLog.debug("Grupo "+i+": "+r.getValueAt(i,0));
                indicadorCuadreGrupos.add(bigDecimalToLong((BigDecimal)r.getValueAt(i,0)));
            }
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.obtenerIndicadorCuadreGrupos(Long oidOferta): Salida");
            return indicadorCuadreGrupos;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

   /**
    *@autor jpbosnja
    **/
    private ArrayList obtenerFactorCuadreGrupos(Long oidOferta) throws Exception {
        UtilidadesLog.info("MONCuadreCondicionadaBean.obtenerFactorCuadreGrupos(Long oidOferta): Entrada");
        try{
            DTOOID dto = new DTOOID();
            dto.setOid(oidOferta);
            //DTOSalida dtoS = getMONOfertaHome().create().obtenerFactorCuadreGrupos(dto);
            DTOSalida dtoS = getMONOfertaLocalHome().create().obtenerFactorCuadreGrupos(dto);
            ArrayList factorCuadreGrupos = new ArrayList();
            RecordSet r = dtoS.getResultado();
            //UtilidadesLog.debug("-------FACTORES DE CUADRE DE LOS GRUPOS------");
            int rows = r.getRowCount();
            
            for (int i = 0 ; i< rows;i++){
                //UtilidadesLog.debug("Grupo "+i+": "+r.getValueAt(i,0));
                factorCuadreGrupos.add(bigDecimalToLong((BigDecimal)r.getValueAt(i,0)));
            }
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.obtenerFactorCuadreGrupos(Long oidOferta): Salida");
            return factorCuadreGrupos;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

    private Long bigDecimalToLong(BigDecimal number) throws Exception{
        UtilidadesLog.info("MONCuadreCondicionadaBean.bigDecimalToLong(BigDecimal number): Entrada");
        if (number==null){
            UtilidadesLog.info("MONCuadreCondicionadaBean.bigDecimalToLong(BigDecimal number): Salida");
            return null;
        }
        UtilidadesLog.info("MONCuadreCondicionadaBean.bigDecimalToLong(BigDecimal number): Salida");    
        return new Long(number.longValue());
    }
    
    public Long getTipoPosicion() {
        UtilidadesLog.info("MONCuadreCondicionadaBean.getTipoPosicion(): Entrada");
        UtilidadesLog.info("MONCuadreCondicionadaBean.getTipoPosicion(): Salida");    
        return tipoPosicion;
    }
    public void setTipoPosicion(Long tipoPosicion) {
        UtilidadesLog.info("MONCuadreCondicionadaBean.setTipoPosicion(Long tipoPosicion): Entrada");
        this.tipoPosicion = tipoPosicion;
        UtilidadesLog.info("MONCuadreCondicionadaBean.setTipoPosicion(Long tipoPosicion): Salida");  
    }
    public Long getSubtipoPosicion() {
        UtilidadesLog.info("MONCuadreCondicionadaBean.getSubtipoPosicion(): Entrada");
        UtilidadesLog.info("MONCuadreCondicionadaBean.getSubtipoPosicion(): Salida");        
        return subtipoPosicion;
    }

    public void setSubtipoPosicion(Long subtipoPosicion) {
        UtilidadesLog.info("MONCuadreCondicionadaBean.setSubtipoPosicion(Long subtipoPosicion): Entrada");
        this.subtipoPosicion = subtipoPosicion;
        UtilidadesLog.info("MONCuadreCondicionadaBean.setSubtipoPosicion(Long subtipoPosicion): Salida");  
    }

    public Long getPrimerRanking() {
        UtilidadesLog.info("MONCuadreCondicionadaBean.getPrimerRanking(): Entrada");
        UtilidadesLog.info("MONCuadreCondicionadaBean.getPrimerRanking(): Salida");        
        return primerRanking;
    }

    public void setPrimerRanking(Long primerRanking) {
        UtilidadesLog.info("MONCuadreCondicionadaBean.setPrimerRanking(Long primerRanking): Entrada");
        this.primerRanking = primerRanking;
        UtilidadesLog.info("MONCuadreCondicionadaBean.setPrimerRanking(Long primerRanking): Salida");  
    }

    public Long getUltimoRanking() {
        UtilidadesLog.info("MONCuadreCondicionadaBean.getUltimoRanking(): Entrada");
        UtilidadesLog.info("MONCuadreCondicionadaBean.getUltimoRanking(): Salida");        
        return ultimoRanking;
    }

    public void setUltimoRanking(Long ultimoRanking) {
        UtilidadesLog.info("MONCuadreCondicionadaBean.setUltimoRanking(Long ultimoRanking): Entrada");
        this.ultimoRanking = ultimoRanking;
        UtilidadesLog.info("MONCuadreCondicionadaBean.setUltimoRanking(Long ultimoRanking): Salida");  
    }

    public Long getOidOferta() {
        UtilidadesLog.info("MONCuadreCondicionadaBean.getTipoPosicion(): Entrada");
        UtilidadesLog.info("MONCuadreCondicionadaBean.getTipoPosicion(): Salida");    
        return oidOferta;
    }

    public void setOidOferta(Long oidOferta) {
        UtilidadesLog.info("MONCuadreCondicionadaBean.setOidOferta(Long oidOferta): Entrada");
        this.oidOferta = oidOferta;
        UtilidadesLog.info("MONCuadreCondicionadaBean.setOidOferta(Long oidOferta): Salida");
    }
    
  /**
   * @Autor: pperanzola
   * @Fecha : 11/08/2005
   * @Recibe: DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo
   * @Retorna: DTOCabeceraSolicitud 
   * @Referencia: cambios jespin
   * // Agregamos unidades al primer producto del grupo 
        Crea un DTORankingCuadre con: 
        - tipoPosicion 
        - subtipoPosicion 
        - oidOferta 
        - primerRanking 
        - ultimoRanking 
        - DTOCabeceraSolicitud = DTOCuadrarCondicion.DTOCabeceraSolicitud 
        - posicionesOferta = DTOCuadrarCondicion.posicionesOferta 
        - numeroUnidadesA 
        - numeroGrupo 
        
        DTOCuadrarCondicion.DTOCabeceraSolicitud = MONRankingProductos.agregarProductosGrupo(DTORankingCuadre) 
        
        Devuelve DTOCuadrarCondicion
   */  
    private DTOCuadrarCondicion agregarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo) throws Exception{
        UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Entrada");
        try{  
            //UtilidadesLog.debug("numeroUnidadesA= " + numeroUnidadesA);
            //UtilidadesLog.debug("numeroGrupo= " + numeroGrupo);
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(this.getOidOferta());
            dtoRank.setPrimerRanking(this.getPrimerRanking());
            dtoRank.setUltimoRanking(this.getUltimoRanking());
            dtoRank.setDTOCabeceraSolicitud(dtoe.getCabeceraSolicitud());
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
            
            //dtoe.setCabeceraSolicitud(this.getMONRankingProductosHome().create().agregarProductosGrupo(dtoRank));
            dtoe.setCabeceraSolicitud(this.getMONRankingProductosLocalHome().create().agregarProductosGrupo(dtoRank));
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.agregarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Salida");
            return dtoe;
        }catch (NamingException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

  /**
   * @Autor: pperanzola
   * @Fecha : 11/08/2005
   * @Recibe: DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo
   * @Retorna: DTOCabeceraSolicitud 
   * @Referencia: diseño jespin 11/08/2005
   * Crea un DTORankingCuadre con: 
        - tipoPosicion 
        - subtipoPosicion 
        - oidOferta 
        - primerRanking 
        - ultimoRanking 
        - DTOCabeceraSolicitud = DTOCuadrarCondicion.DTOCabeceraSolicitud 
        - posicionesOferta = DTOCuadrarCondicion.posicionesOferta 
        - numeroUnidadesA 
        - numeroGrupo 
        
        DTOCuadrarCondicion.DTOCabeceraSolicitud = MONRankingProductos.eliminarProductosGrupo(DTORankingCuadre) 
        
        Devuelve DTOCuadrarCondicion
   */ 
    private DTOCuadrarCondicion eliminarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo) throws Exception{
        UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Entrada");

        try{
            //UtilidadesLog.debug("numeroUnidadesA= " + numeroUnidadesA);
            //UtilidadesLog.debug("numeroGrupo= " + numeroGrupo);
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(this.getOidOferta());
            dtoRank.setPrimerRanking(this.getPrimerRanking());
            dtoRank.setUltimoRanking(this.getUltimoRanking());
            dtoRank.setDTOCabeceraSolicitud(dtoe.getCabeceraSolicitud());
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
            
            //dtoe.setCabeceraSolicitud(this.getMONRankingProductosHome().create().eliminarProductosGrupo(dtoRank));
            dtoe.setCabeceraSolicitud(this.getMONRankingProductosLocalHome().create().eliminarProductosGrupo(dtoRank));
            
            UtilidadesLog.info("MONCuadreCondicionadaBean.eliminarProductosGrupo(DTOCuadrarCondicion dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Salida");
            return dtoe;
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

    private MONOfertaHome getMONOfertaHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOferta"), MONOfertaHome.class);
    }

    private MONCuadreProductosHome getMONCuadreProductosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONCuadreProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreProductos"), MONCuadreProductosHome.class);
    }

    private MONRankingProductosHome getMONRankingProductosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONRankingProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRankingProductos"), MONRankingProductosHome.class);
    }

    private MONCuadreProductosLocalHome getMONCuadreProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreProductos");
    }

    private MONOfertaLocalHome getMONOfertaLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONOfertaLocalHome)context.lookup("java:comp/env/ejb/local/MONOferta");
    }

    private MONRankingProductosLocalHome getMONRankingProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONRankingProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONRankingProductos");
    }
}