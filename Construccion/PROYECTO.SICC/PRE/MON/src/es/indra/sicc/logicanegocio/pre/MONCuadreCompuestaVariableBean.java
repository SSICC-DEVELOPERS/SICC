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
 *
 */
package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTORankingCuadre;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.GrupoLocal;
import es.indra.sicc.entidades.pre.GrupoLocalHome;
import es.indra.sicc.entidades.pre.IndicadorCuadrePorTipoEstrategiaLocalHome;
import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.sicc.entidades.pre.OfertaLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * MON encargado de cuadrar ofertas compuestas variables.
 *
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia
 */
public class MONCuadreCompuestaVariableBean implements SessionBean  {

    SessionContext ctx;  
    private Long tipoPosicion;
    private Long subtipoPosicion;
    private Long primerRanking;
    private Long ultimoRanking;
    private Long oidOferta;
    
    private static UtilidadesLog logAux = new UtilidadesLog();
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx=ctx;
    }

   /**
    *@autor jpbosnja
    *@modificado enozigli 11/08/05 cambio DMCO jespin
    **/
    public DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion) throws MareException {
       UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion): Entrada");
       UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion): Salida");
       return this.cuadrarOferta( dtoe,  posicionesOferta,  cuadre,  despachoAutomatico,  tipoPosicion,  subtipoPosicion, null);
    }

  /**
   * @Autor: Cortaberria
   * @throws java.lang.Exception
   * @return 
   * @param numeroGrupos
   * @param posicionesOferta
   * Se modifica el ArrayList por un TreeMap, debido a que en el arrayList no se puede
   * agregar objetos en forma desordenada, es decir agregar algo en la posicion
   * 3 sin haber agregado en la 0, 1 y 2.
   * Esto se hace para arreglar la incidencia reportada por el cliente PED-12.
   * @modificado: jpbosnja (previo a enozigli)
   * @modificado: enozigli 09/08/2005 por indicacion de DT jespin (se quita el 
   * treemap y se pone arraylist inicializado, eliminandose el problema de modificar
   * una posicion que no exista aun)
   */
    private ArrayList obtenerNumeroUnidadesGrupo (ArrayList posicionesOferta, int numeroGrupos) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerNumeroUnidadesGrupo(ArrayList posicionesOferta, int numeroGrupos): Entrada");
        
        //UtilidadesLog.debug("Datos Entrada: numeroGrupos:"+numeroGrupos);
        ArrayList numeroUnidadesGrupo = new ArrayList();
        //Inicializacion del arraylist de unidades de grupo
        for (int i=0;i<numeroGrupos;i++){
          BigDecimal unidades = new BigDecimal(0);
          numeroUnidadesGrupo.add(unidades);
        }
        int numeroPosicion = 0;
        BigDecimal unidadesGrupo = null;
        int cantPos = posicionesOferta.size();
        for (;numeroPosicion<cantPos;numeroPosicion++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
            Integer grupoActual = dtoP.getGrupo();
            //UtilidadesLog.debug("grupoActual:"+grupoActual);
            unidadesGrupo = (BigDecimal)numeroUnidadesGrupo.get((grupoActual.intValue()-1));

            if (dtoP.getUnidadesPorAtender() != null) {
              unidadesGrupo = new BigDecimal(unidadesGrupo.longValue() + dtoP.getUnidadesPorAtender().longValue());
              numeroUnidadesGrupo.set((grupoActual.intValue()-1), unidadesGrupo);
            }
        }
        //UtilidadesLog.debug("Datos Salida: numeroUnidadesGrupo:"+numeroUnidadesGrupo);
        
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerNumeroUnidadesGrupo(ArrayList posicionesOferta, int numeroGrupos): Salida");
        return numeroUnidadesGrupo;
    }

   /**
    *
    *@autor jpbosnja
    **/
    private ArrayList obtenerUnidadesOferta(ArrayList posicionesOferta, ArrayList numeroUnidadesGrupo) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerUnidadesOferta(ArrayList posicionesOferta, ArrayList numeroUnidadesGrupo): Entrada");

        ArrayList numeroUnidadesOferta = numeroUnidadesGrupo;
        ArrayList factorCuadreGrupos = obtenerFactorCuadreGrupos(posicionesOferta);
        int numeroGrupo = 0;
        int cantUnOf = numeroUnidadesOferta.size();
        for (;numeroGrupo<cantUnOf;numeroGrupo++){
            BigDecimal unidadesGrupo = (BigDecimal)numeroUnidadesOferta.get(numeroGrupo);
            //UtilidadesLog.debug("Unidades Grupo: "+unidadesGrupo);
            BigDecimal factorCuadre = (BigDecimal)factorCuadreGrupos.get(numeroGrupo);
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled())
                UtilidadesLog.debug("Factor Cuadre: "+factorCuadre);
            
            BigDecimal unidadesOferta = unidadesGrupo.divide(factorCuadre,2, BigDecimal.ROUND_HALF_UP); 
            //UtilidadesLog.debug("Unidades Oferta: "+unidadesOferta);
            numeroUnidadesOferta.set(numeroGrupo, unidadesOferta);
        }

        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerUnidadesOferta(ArrayList posicionesOferta, ArrayList numeroUnidadesGrupo): Salida");
        return numeroUnidadesOferta;
    }

    /**
   * @Autor: enozigli
   * @throws java.lang.Exception
   * @return arrayList
   * @param posicionesOferta
   * @Fecha: 09/08/2005
   * @referencia incidencia 20489
   */
    private ArrayList obtenerFactorCuadreGrupos(ArrayList posicionesOferta) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerFactorCuadreGrupos(ArrayList posicionesOferta): Entrada");
        ArrayList factorCuadreGrupos = new ArrayList();
        GrupoLocalHome glh = new GrupoLocalHome();
        
        DTOPosicionSolicitud dtoPrimero = (DTOPosicionSolicitud) posicionesOferta.get(0);
        Collection gruposOferta = glh.findByOidOferta(dtoPrimero.getOidOferta());
        
        Iterator itGruposOfert = gruposOferta.iterator();
        int cantGrupos = gruposOferta.size();
        for (int i=0;i<cantGrupos;i++) {
          factorCuadreGrupos.add(new BigDecimal(0));
        }
        while (itGruposOfert.hasNext()){
            GrupoLocal grupo = (GrupoLocal)itGruposOfert.next();
            BigDecimal factorCuadre = new BigDecimal(grupo.getFactorCuadre()!=null?grupo.getFactorCuadre().longValue():0);
            factorCuadreGrupos.set((grupo.getNumeroGrupo().intValue()-1),factorCuadre);
        }
        
        //UtilidadesLog.debug("Datos Salida: factorCuadreGrupos:"+factorCuadreGrupos);
        
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerFactorCuadreGrupos(ArrayList posicionesOferta): Salida");
        return factorCuadreGrupos;
    }

    /**
      Si cuadre != null 
      { 
      Si despachoAutomatico == True 
      { 
      valorCuadre = cuadre 
      } 
      sino 
      Si indicadorCuadre == ConstantesPRE.CUADRE_MENOR_POR_UNIDADES 
      { 
      // Obtiene el menor valor contenido en el ArrayList numeroUnidadesOferta y lo redondea 
      unidadOfertaMayor = Mayor valor contenido en el ArrayList numeroUnidadesOferta 

      // El valor de cuadre será el minimo entre el cuadre recibido y el redondeo superior de unidadOfertaMayor 
      valorCuadre = Math.min(cuadre, Math.ceil(unidadOfertaMenor)) 
      } 
      sino 
      Si indicadorCuadre == ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES OR ConstantesPRE.CUADRE_FACTOR_MULTIPLO 
      { 
      // Obtiene el mayor valor contenido en el ArrayList numeroUnidadesOferta y lo redondea 
      unidadOfertaMayor = Mayor valor contenido en el ArrayList numeroUnidadesOferta 

      // El valor de cuadre será el minimo entre el cuadre recibido y el redondeo superior de unidadOfertaMayor 
      valorCuadre = Math.min(cuadre, Math.ceil(unidadOfertaMayor)) 
      } 
      } 
      } 
      sino // cuadre == null 
      { 
      Si indicadorCuadre == ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES 
      { 
      // Se obtiene el mayor valor de unidades de oferta y se redondea al entero superior 
      unidadOfertaMayor = Mayor valor contenido en el ArrayList numeroUnidadesOferta 
      valorCuadre = Math.ceil(unidadOfertaMayor) 
      } 
      sino 
      Si indicadorCuadre == ConstantesPRE.CUADRE_MENOR_POR_UNIDADES 
      { 
      // Se obtiene el menor valor de unidades de oferta y se redondea al antero superior 
      unidadOfertaMenor = Menor valor contenido en el ArrayList numeroUnidadesOferta 
      valorCuadre = Math.ceil(unidadOfertaMenor) 
      } 
      sino 
      Si indicadorCuadre == ConstantesPRE.CUADRE_FACTOR_MULTIPLO 
      { 
      // En este caso, por definición, solo habrá un grupo y por tanto, un único elemento en numeroUnidadesOferta 
      unidadOferta = numeroUnidadesOferta.get(0) 
      valorCuadre = Math.ceil(unidadOferta) 
      } 
      } 

      // Devuelve un valor long 
      Devuelve Math.round(valorCuadre)
    *
    *@autor jpbosnja
    **/
    private BigDecimal calcularValorCuadre(Integer cuadre, Boolean despachoAutomatico, ArrayList numeroUnidadesOferta, Long indicadorCuadre) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularValorCuadre(Integer cuadre, Boolean despachoAutomatico, ArrayList numeroUnidadesOferta, Long indicadorCuadre): Entrada");

        BigDecimal valorCuadre = null;
        BigDecimal unidadOfertaMenor = null;
        BigDecimal unidadOfertaMayor = null;
        if (cuadre!=null){
            //UtilidadesLog.debug("Entre con cuadre != null, lo que indica que vengo de cuadrar promocion");
            if (despachoAutomatico.booleanValue()){
                UtilidadesLog.debug("Entro por Despacho automatico!!!");
                valorCuadre = new BigDecimal(cuadre.intValue());
            }else{
            //Inc 10368
                if (indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MENOR_POR_UNIDADES){
                    //UtilidadesLog.debug("indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MENOR_POR_UNIDADES");
                    unidadOfertaMayor = calcularMenorValor(numeroUnidadesOferta);
                    valorCuadre = new BigDecimal(Math.min(cuadre.doubleValue(), Math.ceil(unidadOfertaMayor.doubleValue())));
                }else if ((indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES) ||
                          (indicadorCuadre.longValue() == ConstantesPRE.CUADRE_FACTOR_MULTIPLO)){
                    //UtilidadesLog.debug("indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES || indicadorCuadre.longValue() == ConstantesPRE.CUADRE_FACTOR_MULTIPLO");
                    unidadOfertaMayor = calcularMayorValor(numeroUnidadesOferta);
                    valorCuadre = new BigDecimal(Math.min(cuadre.doubleValue(), Math.ceil(unidadOfertaMayor.doubleValue())));    
                }
            //Inc 10368
            }
        }else{
            //UtilidadesLog.debug("Entre con cuadre == null, osea que tengo que calcularlo de 0");
            if (indicadorCuadre.longValue()== ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES){
                //UtilidadesLog.debug("indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MAYOR_POR_UNIDADES");
                unidadOfertaMayor = calcularMayorValor(numeroUnidadesOferta);
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(logAux.isDebugEnabled())
                    UtilidadesLog.debug("UnidadesOferta: "+unidadOfertaMayor);
                    
                if (unidadOfertaMayor!=null){
                    valorCuadre = new BigDecimal(Math.ceil(unidadOfertaMayor.doubleValue()));
                }
            }else if (indicadorCuadre.longValue()== ConstantesPRE.CUADRE_MENOR_POR_UNIDADES){ 
                //UtilidadesLog.debug("indicadorCuadre.longValue() == ConstantesPRE.CUADRE_MENOR_POR_UNIDADES");
                unidadOfertaMenor = calcularMenorValor(numeroUnidadesOferta);
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(logAux.isDebugEnabled())
                    UtilidadesLog.debug("UnidadesOferta: "+unidadOfertaMenor);
                    
                if (unidadOfertaMenor!=null){
                    valorCuadre = new BigDecimal(Math.ceil(unidadOfertaMenor.doubleValue()));
                }
            }else if (indicadorCuadre.longValue()== ConstantesPRE.CUADRE_FACTOR_MULTIPLO){ 
                //UtilidadesLog.debug("indicadorCuadre.longValue() == ConstantesPRE.CUADRE_FACTOR_MULTIPLO");
                BigDecimal unidadOferta = (BigDecimal)numeroUnidadesOferta.get(0);
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(logAux.isDebugEnabled())
                    UtilidadesLog.debug("UnidadesOferta: "+unidadOferta);
                    
                if (unidadOferta!=null){
                    valorCuadre = new BigDecimal(Math.ceil(unidadOferta.doubleValue()));
                }
            }
        }
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isInfoEnabled())
            UtilidadesLog.info("Datos Salida: Valor Cuadre= "+valorCuadre);
        
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularValorCuadre(Integer cuadre, Boolean despachoAutomatico, ArrayList numeroUnidadesOferta, Long indicadorCuadre): Salida");
        if (valorCuadre!=null){
            //return new Long(Math.round(valorCuadre.doubleValue()));
            return new BigDecimal(Math.round(valorCuadre.doubleValue()));
        }
        return null;      
    }

    private BigDecimal calcularMayorValor(ArrayList list) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularMayorValor(ArrayList list): Entrada");
        BigDecimal mayor = null;
        for(int i=0;i<list.size();i++){
            BigDecimal valor = (BigDecimal)list.get(i);
            if (mayor == null || valor.doubleValue() > mayor.doubleValue()){
                mayor = valor;
            }
        }
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularMayorValor(ArrayList list): Salida");
        return mayor;
    }

    private BigDecimal calcularMenorValor(ArrayList list) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularMenorValor(ArrayList list): Entrada");
        BigDecimal menor = null;
        for(int i=0;i<list.size();i++){
            BigDecimal valor = (BigDecimal)list.get(i);
            if (menor == null || valor.doubleValue() < menor.doubleValue()){
                menor = valor;
            }
        }
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.calcularMenorValor(ArrayList list): Salida");
        return menor;
    }

   /**
    *
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud cuadrarGrupos(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, ArrayList numeroUnidadesOferta, BigDecimal valorCuadre) throws Exception {
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarGrupos(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, ArrayList numeroUnidadesOferta, BigDecimal valorCuadre): Entrada");
        try{
            ArrayList factorCuadreGrupos = obtenerFactorCuadreGrupos(posicionesOferta);
            int numeroGrupo=0;
            for (;numeroGrupo<numeroUnidadesOferta.size();numeroGrupo++){
                BigDecimal unidadOfertaGrupo = (BigDecimal)numeroUnidadesOferta.get(numeroGrupo);
                //UtilidadesLog.debug("unidadOfertaGrupo: "+unidadOfertaGrupo);
                BigDecimal cuadreGrupo = (BigDecimal)factorCuadreGrupos.get(numeroGrupo);
                
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(logAux.isDebugEnabled())
                    UtilidadesLog.debug("cuadreGrupo: "+cuadreGrupo);
                    
                Long numeroUnidadesA = new Long(Math.round(valorCuadre.subtract(unidadOfertaGrupo).multiply(cuadreGrupo).doubleValue()));
                //UtilidadesLog.debug("numeroUnidadesA: "+numeroUnidadesA);
                if (numeroUnidadesA.longValue() > 0){
                    //UtilidadesLog.debug("agregarProductosGrupo");  
                    dtoe = agregarProductosGrupo(dtoe, posicionesOferta, numeroUnidadesA, new Integer(numeroGrupo+1));
                }else if (numeroUnidadesA.longValue() < 0){
                    //UtilidadesLog.debug("eliminarProductosGrupo");  
                    dtoe = eliminarProductosGrupo(dtoe, posicionesOferta, numeroUnidadesA, new Integer(numeroGrupo+1));
                }
            }
            UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarGrupos(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, ArrayList numeroUnidadesOferta, BigDecimal valorCuadre): Salida");
            return dtoe;
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

/*
Crea un DTORankingCuadre con: 
- tipoPosicion 
- subtipoPosicion 
- oidOferta 
- primerRanking 
- ultimoRanking 
- DTOCabeceraSolicitud 
- posicionesOferta 
- numeroUnidadesA 
- numeroGrupo 

DTOCabeceraSolicitud = MONRankingProductos.agregarProductosGrupo(DTORankingCuadre) 

Devuelve DTOCabeceraSolicitud
 */
  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 11/08/2005
   * @Recibe: DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo
   * @Retorna: DTOCabeceraSolicitud 
   * @Descripción: 
   * @Referencia: cambios jespin
   */  
    private DTOCabeceraSolicitud agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Entrada");
        try{            
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(this.getOidOferta());
            dtoRank.setPrimerRanking(this.getPrimerRanking());
            dtoRank.setUltimoRanking(this.getUltimoRanking());
            dtoRank.setDTOCabeceraSolicitud(dtoe);
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
                        
            dtoe = this.getMONRankingProductosLocalHome().create().agregarProductosGrupo(dtoRank);
            
            UtilidadesLog.info("MONCuadreCompuestaVariableBean.agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Salida");
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

  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 11/08/2005
   * @Recibe: DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo
   * @Retorna: DTOCabeceraSolicitud 
   * @Descripción: descripcion
   * @Referencia: diseño jespin 11/08/2005
   */ 
    private DTOCabeceraSolicitud eliminarProductosGrupo (DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo) throws Exception{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.eliminarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Entrada");
        try{
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(this.getOidOferta());
            dtoRank.setPrimerRanking(this.getPrimerRanking());
            dtoRank.setUltimoRanking(this.getUltimoRanking());
            dtoRank.setDTOCabeceraSolicitud(dtoe);
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
                        
            dtoe = this.getMONRankingProductosLocalHome().create().eliminarProductosGrupo(dtoRank);

            UtilidadesLog.info("MONCuadreCompuestaVariableBean.eliminarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo): Salida");
            return dtoe;
        } catch (NamingException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

  public Long getTipoPosicion() {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getTipoPosicion(): Entrada");
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getTipoPosicion(): Salida");
    return tipoPosicion;
  }

  public void setTipoPosicion(Long tipoPosicion) {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setTipoPosicion(Long tipoPosicion): Entrada");    
    this.tipoPosicion = tipoPosicion;
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setTipoPosicion(Long tipoPosicion): Salida");  
  }

  public Long getSubtipoPosicion() {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getSubtipoPosicion(): Entrada");
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getSubtipoPosicion(): Salida");  
    return subtipoPosicion;
  }

  public void setSubtipoPosicion(Long subtipoPosicion) {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setSubtipoPosicion(Long subtipoPosicion): Entrada");    
    this.subtipoPosicion = subtipoPosicion;
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setSubtipoPosicion(Long subtipoPosicion): Salida");  
  }

  public Long getPrimerRanking() {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getPrimerRanking(): Entrada");    
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getPrimerRanking(): Salida");      
    return primerRanking;
  }

  public void setPrimerRanking(Long primerRanking) {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setPrimerRanking(Long primerRanking): Entrada");
    this.primerRanking = primerRanking;
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setPrimerRanking(Long primerRanking): Salida");
  }

  public Long getUltimoRanking() {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getUltimoRanking(): Entrada");    
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getUltimoRanking(): Salida");     
    return ultimoRanking;
  }

  public void setUltimoRanking(Long ultimoRanking) {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setUltimoRanking(Long ultimoRanking): Entrada");    
    this.ultimoRanking = ultimoRanking;
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setUltimoRanking(Long ultimoRanking): Salida");    
  }

  public Long getOidOferta() {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getOidOferta(): Entrada");    
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.getOidOferta(): Salida");    
    return oidOferta;
  }

  public void setOidOferta(Long oidOferta) {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setOidOferta(Long oidOferta): Entrada");    
    this.oidOferta = oidOferta;
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.setOidOferta(Long oidOferta): Salida");    
  }

  public DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion, DTOOferta dtoOferta) throws MareException {
    UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion, DTOOferta dtoOferta): Entrada"); 
    try{
            /*UtilidadesLog.debug("----------------------------------------------------------------------");
            UtilidadesLog.debug("-------------------ENTRE DE CUADRE COMPUESTA VARIABLE-----------------");
            UtilidadesLog.debug("----------------------------------------------------------------------"); */    
            GrupoLocalHome glh = new GrupoLocalHome();
            IndicadorCuadrePorTipoEstrategiaLocalHome ictelh = new IndicadorCuadrePorTipoEstrategiaLocalHome();
            
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicionesOferta.get(0);
            Long oidOferta = null;
            Long indCuadre = null;
            if (dtoOferta!= null){
                oidOferta = dtoOferta.getOidOferta();
                Collection colGrupo = glh.findByOidOferta(oidOferta);
                Iterator it = colGrupo.iterator();
                GrupoLocal gl = (GrupoLocal)it.next();
                indCuadre = gl.getOidIndCuadTipoEstr();
                indCuadre = ictelh.findByPrimaryKey(indCuadre).getOidIndiCuad();
                // Se filtra las posiciones de la lista para trabajar solamente con las del cuadre compuesta variable
                //UtilidadesLog.debug("posicionesOferta ANTES DEL FILTRADO:" + posicionesOferta);
                posicionesOferta = this.obtenerPosicionesOferta(posicionesOferta,oidOferta);
                //UtilidadesLog.debug("posicionesOferta DESPUES DEL FILTRADO :" + posicionesOferta);
                
            }else{
                oidOferta =  dtoP.getOidOferta();
                indCuadre = dtoP.getIndicadorCuadre();
            }
            OfertaLocalHome olh = new OfertaLocalHome();
            OfertaLocal ofertaLocal = olh.findByPrimaryKey(oidOferta);
            //Long indCuadre = dtoP.getIndicadorCuadre();
            Integer numeroGrupos = ofertaLocal.getNumeroGrupos();
            //enozigli 11/08/05
            this.setTipoPosicion(tipoPosicion);
            this.setSubtipoPosicion(subtipoPosicion);            
            this.setPrimerRanking((ofertaLocal.getPrimeraPosicionRanking()!=null)?new Long(ofertaLocal.getPrimeraPosicionRanking().intValue()):null);
            this.setUltimoRanking((ofertaLocal.getUltimaPosicionRanking()!=null)?new Long(ofertaLocal.getUltimaPosicionRanking().intValue()):null);
            this.setOidOferta(ofertaLocal.getOid());
            //fin cambio enozigli 11/08/05
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled()){
                UtilidadesLog.debug("Indicador de cuadre de la oferta: "+indCuadre);
                UtilidadesLog.debug("Numero de Grupos de la oferta: "+numeroGrupos);
            }

            if (numeroGrupos !=null && numeroGrupos.longValue() > 0){
                ArrayList numeroUnidadesGrupo = obtenerNumeroUnidadesGrupo(posicionesOferta, numeroGrupos.intValue());
                ArrayList numeroUnidadesOferta = obtenerUnidadesOferta(posicionesOferta, numeroUnidadesGrupo);
                BigDecimal valorCuadre = calcularValorCuadre(cuadre, despachoAutomatico, numeroUnidadesOferta, indCuadre);
                dtoe = cuadrarGrupos(dtoe, posicionesOferta, numeroUnidadesOferta, valorCuadre);
            }else{
                //UtilidadesLog.debug("Oferta: "+ofertaLocal.getOid()+" Sin grupos!!!, muy raro");
            }
            
            /*UtilidadesLog.debug("----------------------------------------------------------------------");
            UtilidadesLog.debug("-------------------SALI DE CUADRE COMPUESTA VARIABLE------------------");
            UtilidadesLog.debug("----------------------------------------------------------------------");*/

            UtilidadesLog.info("MONCuadreCompuestaVariableBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion, DTOOferta dtoOferta): Salida");
            return dtoe;
        } catch(NoResultException e) {
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
    
    // METODOS AGREGADOS 
    /**
     * @author pperanzola
     * @date 20/08/2005
     * filtra el listado de posiciones según la oferta que se esté buscando
     * 
     */
    private ArrayList obtenerPosicionesOferta (ArrayList posiciones, Long oidOferta) throws Exception {
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerPosicionesOferta(ArrayList posiciones, Long oidOferta): Entrada");
        
        DTOPosicionSolicitud dtoP =null;
        //Long numeroOferta = dtoP.getOidOferta();
        ArrayList posicionesOferta = new ArrayList();
        int cantPosiciones =posiciones.size();
        for (int i = 0; i< cantPosiciones; i++){
            dtoP = (DTOPosicionSolicitud)posiciones.get(i);
            if (dtoP.getOidOferta().longValue() == oidOferta.longValue()){
                if(!ConstantesPED.ESTADO_POSICION_ANULADO.equals(dtoP.getTipoPosicion())){
                    posicionesOferta.add(dtoP); 
                }
            }
        }
        //UtilidadesLog.debug("Salida: MONCuadreCompuestaVariable.obtenerPosicionesOferta");
        if (posicionesOferta.size()==0){
            UtilidadesLog.debug("posicionesOferta.size()==0");
            OfertaLocalHome olh = new OfertaLocalHome();
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            OfertaLocal ofertaLocal = olh.findByPrimaryKey(oidOferta);
            Collection colAuxDetal = dolh.findByOidOfer(oidOferta);            
            UtilidadesLog.debug("OIDOFERTA--->"+oidOferta);
            UtilidadesLog.debug("Detalles:");
            Iterator it = colAuxDetal.iterator();
            DTOPosicionSolicitud dtoAagregar;
            while (it.hasNext()){
                DetalleOfertaLocal ofertaDetalLocal = (DetalleOfertaLocal) it.next();
                UtilidadesLog.debug("OIDDETALLE------->"+ofertaDetalLocal.getOid());
                UtilidadesLog.debug("OIDGRUPO------->"+ofertaDetalLocal.getOidGrupOfer());
                dtoAagregar = new DTOPosicionSolicitud();
                GrupoLocalHome glh = new GrupoLocalHome();
                
                GrupoLocal grupOfertaLocal = glh.findByPrimaryKey(ofertaDetalLocal.getOidGrupOfer());
                //UtilidadesLog.debug("dtoAagregar");
                dtoAagregar.setAAgregar(Boolean.TRUE);
                dtoAagregar.setNumeroPosicion(new Long (this.obtenerUltimaPosicion(posiciones)+1));
                dtoAagregar.setGrupo(grupOfertaLocal.getNumeroGrupo());
                dtoAagregar.setUnidadesPorAtender(new Long (0));
                dtoAagregar.setUnidadesDemandadas(new Long (0));
                dtoAagregar.setUnidadesComprometidas(new Long (0));
                dtoAagregar.setProducto(ofertaDetalLocal.getOidProd());
                dtoAagregar.setFormaPago(ofertaDetalLocal.getOidFormPago());
                dtoAagregar.setCodigoVenta(ofertaDetalLocal.getCodigoVenta());
                dtoAagregar.setOidProducto(ofertaDetalLocal.getOidProd());
                dtoAagregar.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
                dtoAagregar.setUnidadesDemandaReal(new Long (0));
                dtoAagregar.setOK(Boolean.TRUE);
                dtoAagregar.setOidDetalleOferta(ofertaDetalLocal.getOid());
                dtoAagregar.setOidOferta(ofertaDetalLocal.getOidOfer());
                dtoAagregar.setTipoEstrategia(new Long (7));
                dtoAagregar.setNumeroOferta(ofertaLocal.getNumeroOferta());
                dtoAagregar.setCatalogo(ofertaDetalLocal.getOidCatal());
                dtoAagregar.setFactorRepeticion(ofertaDetalLocal.getFactorRepeticion());
                dtoAagregar.setPagina(ofertaDetalLocal.getNumeroPaginaCatalogo());
                //UtilidadesLog.debug("dtoAagregar:" + dtoAagregar);
                posicionesOferta.add(dtoAagregar);            
            }
        }
        

        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerPosicionesOferta(ArrayList posiciones, Long oidOferta): Salida");
        return posicionesOferta;
    }
    private long obtenerUltimaPosicion (ArrayList posiciones) throws MareException{
        UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerUltimaPosicion(ArrayList posiciones): Entrada");
        try{ 
            long maximo = 0;
            int posicion = 0;
            int cantPos = posiciones.size();
            
            while (posicion < cantPos){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posiciones.get(posicion);
                if (dtoP.getNumeroPosicion().longValue() > maximo){
                    maximo = dtoP.getNumeroPosicion().longValue();
                }
                posicion++;
            }
            
            UtilidadesLog.info("MONCuadreCompuestaVariableBean.obtenerUltimaPosicion(ArrayList posiciones): Salida");
            return maximo;
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
    
  
    private MONCuadreProductosHome getMONCuadreProductosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONCuadreProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreProductos"), MONCuadreProductosHome.class);
    }
  
    private MONRankingProductosHome getMONRankingProductosHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONRankingProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRankingProductos"), MONRankingProductosHome.class);
    }

    private MONRankingProductosLocalHome getMONRankingProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONRankingProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONRankingProductos");
    }
    // FIN METODOS AGREGADOS 
}
