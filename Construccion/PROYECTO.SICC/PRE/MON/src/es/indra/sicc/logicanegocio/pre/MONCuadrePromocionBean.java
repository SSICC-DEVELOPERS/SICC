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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTORankingCuadre;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.EstrategiaLocal;
import es.indra.sicc.entidades.pre.EstrategiaLocalHome;
import es.indra.sicc.logicanegocio.pre.SeleccionSolicitudesPromocion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.PREEjbLocators;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.lang.Integer;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

/**
 * MON general del cuadre de ofertas con promociones.
 *
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia
 */
public class MONCuadrePromocionBean implements SessionBean  {

    SessionContext ctx;
    private Long tipoPosicion;
    private Long subtipoPosicion;
    private Hashtable filtros;
    //private ArrayList ofertasIndividuales = new ArrayList();
    
    public void ejbCreate() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }
    public void setSessionContext(SessionContext ctx) { this.ctx=ctx; }

   /**    
    * @autor jpbosnja
    * @modificado [1] 18/08/2005 pperanzola - reconstruccion - se modifica para 
    *             tener en la clase el tipo posicion y el subtipo
    
    *         
    **/
    public DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion) throws MareException {
        UtilidadesLog.info("MONCuadrePromocionBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Entrada");
        Cronometrador.startTransaction("MONCuadrePromocionBean.cuadrarOferta");
        /*UtilidadesLog.debug("----------------------------------------------------------------------");
        UtilidadesLog.debug("-------------------ENTRE DE CUADRE PROMOCION--------------------------");
        UtilidadesLog.debug("----------------------------------------------------------------------");*/
        
        try{
            this.setSubtipoPosicion(subtipoPosicion);  //[1]
            this.setTipoPosicion(tipoPosicion);        //[1]
            this.filtros = this.obtenerFiltros(dtoe); //[2]
            ArrayList listaOfertas = obtenerOfertasPromocion(dtoe.getPeriodo());
            ArrayList ofertasIndividuales = new ArrayList();
            for (int numeroOferta = 0; listaOfertas.size()>numeroOferta;numeroOferta++){
                DTOOferta oferta = (DTOOferta)listaOfertas.get(numeroOferta);
                dtoe = realizarCuadre(oferta, dtoe, tipoPosicion, subtipoPosicion, ofertasIndividuales);
            }
            if (ofertasIndividuales.size()>0){
                this.cuadrarIndividual(dtoe, dtoe.getPosiciones(), ofertasIndividuales);
            }
            ofertasIndividuales = null;

            /*UtilidadesLog.info("----------------------------------------------------------------------");
            UtilidadesLog.info("-------------------SALI DE CUADRE PROMOCION---------------------------");
            UtilidadesLog.info("----------------------------------------------------------------------");*/
            
            UtilidadesLog.info("MONCuadrePromocionBean.cuadrarOferta(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion): Salida");
            Cronometrador.endTransaction("MONCuadrePromocionBean.cuadrarOferta");
            return dtoe;
        }catch (Exception e){
            if (e instanceof MareException)
                throw (MareException)e;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    /**
     * 
     * @date 03/04/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * [2] se confecciona para mejorar la performance
     */
    private Hashtable obtenerFiltros (DTOCabeceraSolicitud dtoe) throws MareException {
        ArrayList posiciones = dtoe.getPosiciones();
        int cantPosic = dtoe.getPosiciones().size();
        Hashtable catalogos = new Hashtable();
        CatalogoPromociones catalogo = new CatalogoPromociones();
        String idSinCatalogo = "SINCATALOGO";
        
        for (int i = 0; i<cantPosic ; i++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud) posiciones.get(i);
            /* Se quita porque sino surge el problema de las incidencias V_PRE3 y 4 bloqueantes en Perú.
             * if (dtoP.getTipoEstrategia()!=null && (
                dtoP.getTipoEstrategia().intValue() == ConstantesPRE.INDIVIDUAL_VS_GRUPO ||
                dtoP.getTipoEstrategia().intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO ||
                dtoP.getTipoEstrategia().intValue() == ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO )){
                */
                if (dtoP.getCatalogo()== null){
                    if (catalogos.get(idSinCatalogo)== null){
                        catalogo = new CatalogoPromociones();
                    }else{
                        catalogo = (CatalogoPromociones)catalogos.get(idSinCatalogo);
                    }
                    //catalogo = new CatalogoPromociones();
                    catalogo.agregarLineasProductos(dtoP.getLineaProducto());
                    catalogo.agregarPagina(dtoP.getPagina());
                    catalogo.agregarProducto(dtoP.getProducto());
                    catalogo.agregarOfertas(dtoP.getOidOferta());
                    catalogos.put(idSinCatalogo,catalogo);
                }else if (catalogos.get(dtoP.getCatalogo())== null){
                    catalogo = new CatalogoPromociones();
                    catalogo.setOidCatalogo(dtoP.getCatalogo());
                    catalogo.agregarLineasProductos(dtoP.getLineaProducto());
                    catalogo.agregarPagina(dtoP.getPagina());
                    catalogo.agregarProducto(dtoP.getProducto());
                    catalogo.agregarOfertas(dtoP.getOidOferta());
                    catalogos.put(dtoP.getCatalogo(),catalogo);
                }else{
                    catalogo = (CatalogoPromociones)catalogos.get(dtoP.getCatalogo());
                    catalogo.agregarLineasProductos(dtoP.getLineaProducto());
                    catalogo.agregarPagina(dtoP.getPagina());
                    catalogo.agregarProducto(dtoP.getProducto());
                    catalogo.agregarOfertas(dtoP.getOidOferta());
                }
           //}
        }
       
        return catalogos;
    
    }
    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * [2] se confecciona para mejorar la performance
     */
    public DTOSalida consultarOfertasPromocion(DTOOID dtoe, Hashtable tablaFiltros) throws MareException {
        UtilidadesLog.info("MONCuadrePromocion.obtenerOfertasPromocion(DTOOID dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
        
            StringBuffer query = new StringBuffer("SELECT promo.* FROM (");
            query.append(" SELECT OID_OFER OFERTA, VAL_COND_G1_CNDT G1, COES_OID_ESTR ESTRATEGIA, IND_DESP_AUTO DESPACHO_AUTOMATICO, NUM_PAQU NUMERO_PAQUETES, ");
            query.append(" OID_PROM PROMOCION, NUM_COND NUMERO_CONDICION, ICPR_OID_INDI_CUAD_PROM IND_CUADRE, VAL_FACT_CUAD FACTOR_CUADRE, ");
            query.append(" OID_RANG_PROM RANGO_PROMOCION, RP.OCAT_OID_CATA CATALOGO, COD_TIPO_RANG TIPO_RANGO, NUM_RANG_INTE NUMERO_RANGO, IND_EXCL EXCLUIR, to_number(VAL_DESD) DESDE, to_number(VAL_HAST) HASTA  "); //[1]
            query.append(" FROM PRE_MATRI_FACTU_CABEC CM, PRE_OFERT O, PRE_PROMO P, PRE_RANGO_PROMO RP, PRE_ESTRA E, PRE_TIPO_ESTRA TE ");

            query.append("where CM.PERD_OID_PERI = " + dtoe.getOid());
            query.append(" AND O.MFCA_OID_CABE = CM.OID_CABE AND TE.IND_ESTR_VS = 1 AND ");
            query.append(" TE.OID_TIPO_ESTR = E.TIES_OID_TIPO_ESTR AND  O.COES_OID_ESTR = E.OID_ESTR AND ");
            query.append(" P.OFER_OID_OFER = O.OID_OFER AND RP.POMO_OID_PROM = P.OID_PROM ");

            query.append(" ) promo ");
            query.append(" WHERE( 1=2 ");
            if (tablaFiltros.size()>0){
                Iterator it = (Iterator)tablaFiltros.elements();
            
                while (it.hasNext()){
                    CatalogoPromociones catalogo = (CatalogoPromociones)it.next();
                    query.append(" OR ");
                    if (catalogo.getOidCatalogo() !=null){
                        query.append(" (promo.catalogo = " + catalogo.getOidCatalogo());
                    } else {
                        query.append(" (1=1 ");
                    }
                    query.append(" AND (excluir = 0 ");
                         query.append(" AND ( 1=2 ");
                                if (!catalogo.obtenerProductosString().trim().equalsIgnoreCase("")){
                                    query.append(" OR    (tipo_rango = 'P' AND desde IN( " + catalogo.obtenerProductosString() +")  ) ");
                                }
                                if (!catalogo.obtenerPaginasStringDesdeHasta().trim().equalsIgnoreCase("")){
                                    query.append(" OR (tipo_rango= 'R' AND ( "+ catalogo.obtenerPaginasStringDesdeHasta() + " ) )");
                                }
                                if (!catalogo.obtenerLineaProductosString().trim().equalsIgnoreCase("")){
                                    query.append(" OR (tipo_rango = 'L' AND desde IN ("+ catalogo.obtenerLineaProductosString() +")  ) ");
                                }
                                UtilidadesLog.debug(catalogo.obtenerOfertasString());
                                if (!catalogo.obtenerOfertasString().trim().equalsIgnoreCase("")){
                                    query.append(" OR (oferta IN ("+ catalogo.obtenerOfertasString() +")  ) ");
                                }
                         query.append("     ) "); // cierra "( 1=2 "
                         query.append(" OR ( excluir = 1  ");
                            query.append(" AND ( 1=2 ");
                                if (!catalogo.obtenerProductosString().trim().equalsIgnoreCase("")){
                                    query.append(" OR    (tipo_rango = 'P' AND desde IN( " + catalogo.obtenerProductosString() +")  ) ");
                                }
                                 if (!catalogo.obtenerPaginasStringDesdeHasta().trim().equalsIgnoreCase("")){
                                    query.append(" OR (tipo_rango= 'R' AND ( "+ catalogo.obtenerPaginasStringDesdeHasta() + " ) )");
                                }
                                 if (!catalogo.obtenerLineaProductosString().trim().equalsIgnoreCase("")){
                                    query.append(" OR (tipo_rango = 'L' AND desde IN ("+ catalogo.obtenerLineaProductosString() +")  ) ");
                                }
                                UtilidadesLog.debug(catalogo.obtenerOfertasString());
                                //V_PRE03 y4 se vuelve al estado original este metodo ya que en obtenerOfertasString vienen 
                                //efectivamente las ofertas, supongo que fallo por un problema con el periodo la primera vez
                                if (!catalogo.obtenerOfertasString().trim().equalsIgnoreCase("")){
                                    query.append(" OR (oferta IN ("+ catalogo.obtenerOfertasString() +")  ) ");
                                }
                            query.append("  ) "); // cierra "( 1=2 "
                         query.append("  ) "); //cierra "excluir = 1"
                         query.append("  ) "); //cierra "AND (excluir = 0"
                    query.append(" )"); // finaliza "(1=1"
                    
                }
            }
            query.append(" ) ");
            query.append(" ORDER BY oferta, promocion, catalogo, tipo_rango ");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONCuadrePromocion.obtenerOfertasPromocion(DTOOID dtoe): Salida");
            
            return dto;
            
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

   /**     
    * @autor: Cortaberria
    * @fecha: 24/05/2005
    * @modificado jpbosnja - Correción de la forma de completar las ofertas
    *             30/03/2006 - pperanzola - [2] se modifica para mejorar la performance
    */
    private ArrayList obtenerOfertasPromocion(Long periodo) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.obtenerOfertasPromocion(Long periodo): Salida");
        
        try {
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(periodo);
    
            //DTOSalida dtoSalida = this.getMONOfertaHome().create().obtenerOfertasPromocion(dtoOid); [2]
            DTOSalida dtoSalida = this.consultarOfertasPromocion(dtoOid,filtros ); //[2]
            ArrayList listaOfertas = new ArrayList();
            RecordSet resultado = dtoSalida.getResultado();
            int contadorIn = 0;//[2]
            String concatOfer = new String();//[2]
            if (resultado==null || resultado.getRowCount()<1){
                return new ArrayList();
            }
            BigDecimal ofertaActual = (BigDecimal)resultado.getValueAt(0,"OFERTA");
            Integer promocionActual = bigDecimalToInteger((BigDecimal)resultado.getValueAt(0,"NUMERO_CONDICION"));
            
            DTOOferta dtoOferta = this.crearDTOOferta(resultado, 0);
            DTOPromocion dtoPromocion = this.crearDTOPromocion(resultado, 0);
            DTOLineaPromocion dtoLineaPromocion = this.crearDTOLineaPromocion(resultado, 0);
    
            Vector lineaPromo = new Vector();
            lineaPromo.add(dtoLineaPromocion);
            dtoPromocion.setLineaPromocion(lineaPromo);
            
            Vector promociones = new Vector();
            promociones.add(dtoPromocion);
            dtoOferta.setPromocion(promociones);
            //listaOfertas.add(dtoOferta);
            int cantResultado = resultado.getRowCount();
            //UtilidadesLog.debug("resultado.getRowCount() = " +cantResultado);
            for(int fila=1; cantResultado > fila; fila++) {
                BigDecimal numeroOferta = (BigDecimal)resultado.getValueAt(fila, "OFERTA");
                if(numeroOferta.equals(ofertaActual)) {
                    Integer numeroPromocion = bigDecimalToInteger((BigDecimal)resultado.getValueAt(fila, "NUMERO_CONDICION"));
                    if(numeroPromocion.equals(promocionActual)) {
                        dtoLineaPromocion = this.crearDTOLineaPromocion(resultado, fila);
                  
                        Vector lineaPro = dtoPromocion.getLineaPromocion();
                        if (lineaPro==null){
                            lineaPro = new Vector();
                        }
                        lineaPro.add(dtoLineaPromocion);
                        dtoPromocion.setLineaPromocion(lineaPro);         
                    } else {
                        Vector promocion =dtoOferta.getPromocion();
                        if (promocion == null){
                            promocion = new Vector();
                        }
                        
                        dtoPromocion = this.crearDTOPromocion(resultado, fila);
                        
                        promocion.add(dtoPromocion);
                        dtoOferta.setPromocion(promocion);          
                        
                        promocionActual = numeroPromocion;
                        fila = fila - 1;
                    }           
                } else {
                    ///*[2]
                    if (contadorIn >= 999){
                        concatOfer = concatOfer.substring(0,concatOfer.length()-1);
                        concatOfer = concatOfer.concat("#/#"); 
                        contadorIn = 0; 
                    }else{
                        concatOfer = concatOfer.concat(dtoOferta.getOidOferta().toString() + ",");
                        contadorIn = contadorIn + 1;
                    } 
                    //*/[2]
                    listaOfertas.add(dtoOferta);
                    
                    dtoOferta = this.crearDTOOferta(resultado, fila);
                    dtoPromocion = this.crearDTOPromocion(resultado, fila);
                    
                    promociones = new Vector();
                    promociones.add(dtoPromocion);
                    dtoOferta.setPromocion(promociones);
                    
                    ofertaActual = numeroOferta;
                    promocionActual = dtoPromocion.getNumeroCondicion();
        
                    fila = fila - 1;           
                }          
            }
            ///*[2]
            if (contadorIn >= 999){
                concatOfer = concatOfer.substring(0,concatOfer.length()-1);
                concatOfer = concatOfer.concat("#/#"); 
                contadorIn = 0; 
            }else{
                concatOfer = concatOfer.concat(dtoOferta.getOidOferta().toString() + ",");
                contadorIn = contadorIn + 1;
            } 
            //*/[2]
            listaOfertas.add(dtoOferta);
               
            ///*[2]
            concatOfer = concatOfer.substring(0,concatOfer.length()-1);
            RecordSet rs = this.obtieneProductosOfertas(concatOfer);
            listaOfertas = this.asignaCodigosVentaAOfertas(listaOfertas,rs);
            //*/[2]
           
            
            UtilidadesLog.info("MONCuadrePromocionBean.obtenerOfertasPromocion(Long periodo): Salida");
            
            return listaOfertas;        
        }
        catch (Exception e){
            if (e instanceof MareException)
                throw (MareException)e;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }       
    }
    
   /**
    * @autor jpbosnja
    * @modificado 22/08/2005 - [1] pperanzola se modifica porque se estaba saliendo 
    *             del for antes de tiempo. El recorrer las promociones solo se usa
    *             para calcular el cuadre
    **/
    private DTOCabeceraSolicitud realizarCuadre(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud, Long tipoPosicion, Long subtipoPosicion, ArrayList ofertasIndividuales) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.realizarCuadre(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud, Long tipoPosicion, Long subtipoPosicion): Entrada");
      Cronometrador.startTransaction("MONCuadrePromocionBean.realizarCuadre"+dtoOferta.getOidOferta());
      try {
        UtilidadesLog.debug("OidOferta:"+dtoOferta.getOidOferta());
        Integer cuadre = null;
        Vector promociones = dtoOferta.getPromocion();
        Hashtable estrategias = new Hashtable();
        EstrategiaLocal el = null;
        if (estrategias.containsKey(dtoOferta.getOidEstrategia())){
            el = (EstrategiaLocal)estrategias.get(dtoOferta.getOidEstrategia());
        }else{
            EstrategiaLocalHome elh = new EstrategiaLocalHome();
            el = elh.findByPrimaryKey(dtoOferta.getOidEstrategia());
            estrategias.put(dtoOferta.getOidEstrategia(),el);
        }
        int tamanoPromo = promociones.size();
        //UtilidadesLog.debug("promociones.size() = " +tamanoPromo);
        SeleccionSolicitudesPromocion sel = new SeleccionSolicitudesPromocion();
        for(int numeroPromocion=0; tamanoPromo > numeroPromocion; numeroPromocion++) {
          DTOPromocion dtoPromocion = (DTOPromocion)promociones.get(numeroPromocion);
          
          // sapaza -- PER-SiCC-2011-0340 -- 16/05/2011
          ArrayList posicionesCuadre = sel.obtenerPosicionesCuadre(dtoPromocion, dtoCabeceraSolicitud, dtoOferta.getOidEstrategia());
          
          if (posicionesCuadre.size()>0){
            cuadre = this.calcularCuadre(posicionesCuadre, dtoPromocion, dtoOferta, cuadre);
          }
          //UtilidadesLog.debug("Cuadre de la promocion: "+cuadre);
        } // [1]
        if (cuadre == null){
            cuadre = new Integer(0);
        }
          if(cuadre.intValue()==0) {          
            dtoCabeceraSolicitud = this.eliminarProductosPromocion(dtoOferta, dtoCabeceraSolicitud);
            Cronometrador.endTransaction("MONCuadrePromocionBean.realizarCuadre"+dtoOferta.getOidOferta());
            return dtoCabeceraSolicitud;
          }

          
          //UtilidadesLog.debug("########## tipo de estrategia: " + el.getOidTipoEstr());
          //UtilidadesLog.debug("########## oid oferta: " + dtoOferta.getOidOferta());

          if(el.getOidTipoEstr().intValue() == ConstantesPRE.INDIVIDUAL_VS_GRUPO) {
              UtilidadesLog.debug("-----LA PROMOCION A CUADRAR ES DE TIPO INDIVIDUAL_VS_GRUPO-----");
              dtoOferta.setCuadre(cuadre);
              ofertasIndividuales.add(dtoOferta);
              //dtoCabeceraSolicitud = this.cuadrarIndividual(dtoCabeceraSolicitud, dtoCabeceraSolicitud.getPosiciones(), cuadre, dtoOferta);            
          }
          else {
            if(el.getOidTipoEstr().intValue() == ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO) {
                UtilidadesLog.debug("-LA PROMOCION A CUADRAR ES DE TIPO COMPUESTA_VARIABLE_VS_GRUPO-");
                dtoCabeceraSolicitud = this.cuadrarGrupos(dtoCabeceraSolicitud, dtoCabeceraSolicitud.getPosiciones(), cuadre, dtoOferta);   
            }
            else {
              if(el.getOidTipoEstr().intValue() == ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO) {
                  UtilidadesLog.debug("---LA PROMOCION A CUADRAR ES DE TIPO COMPUESTA_FIJA_VS_GRUPO---");
                  dtoCabeceraSolicitud = this.cuadrarPaquetes(dtoCabeceraSolicitud, (ArrayList)dtoCabeceraSolicitud.getPosiciones().clone(), cuadre, dtoOferta, tipoPosicion, subtipoPosicion);                
              }
            }
          }         
        
        UtilidadesLog.info("MONCuadrePromocionBean.realizarCuadre(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud, Long tipoPosicion, Long subtipoPosicion): Salida");
        Cronometrador.endTransaction("MONCuadrePromocionBean.realizarCuadre"+dtoOferta.getOidOferta());
        return dtoCabeceraSolicitud;        
      }
      catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      
    }

   /**
      Crea un DTOLineaPromocion con: 
      - oidLineaPromocion = resultado.getValueAt(fila, "RANGO_PROMOCION") 
      - numeroRangoInterno = resultado.getValueAt(fila, "NUMERO_RANGO") 
      - tipoRango = resultado.getValueAt(fila, "TIPO_RANGO") 
      - oidCatalogo = resultado.getValueAt(fila, "CATALOGO") 
      - indicadorExclusion = resultado.getValueAt(fila, "EXCLUIR") 
      - valorDesde = resultado.getValueAt(fila, "DESDE") 
      - valorHasta = resultado.getValueAt(fila, "HASTA") 

      Devuelve DTOLineaPromocion
    *
    * @autor jpbosnja
    **/
    private DTOLineaPromocion crearDTOLineaPromocion(RecordSet resultado, int fila) throws Exception{
        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOLineaPromocion(RecordSet resultado, int fila): Entrada");
        
        DTOLineaPromocion dtoLP = new DTOLineaPromocion();
        dtoLP.setOidLineaPromocion(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila,"RANGO_PROMOCION")));
        dtoLP.setNumeroRangoInterno(bigDecimalToInteger((BigDecimal)resultado.getValueAt(fila,"NUMERO_RANGO")));
        if (resultado.getValueAt(fila,"TIPO_RANGO")!=null){
            dtoLP.setTipoRango(resultado.getValueAt(fila,"TIPO_RANGO").toString().charAt(0));
        }
        dtoLP.setOidCatalogo(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila,"CATALOGO")));
        dtoLP.setIndicadorExclusion(bigDecimalToBoolean((BigDecimal)resultado.getValueAt(fila,"EXCLUIR")));
        dtoLP.setValorDesde(resultado.getValueAt(fila,"DESDE").toString());
        if (resultado.getValueAt(fila,"HASTA")!=null)
            dtoLP.setValorHasta(resultado.getValueAt(fila,"HASTA").toString());

        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOLineaPromocion(RecordSet resultado, int fila): Salida");
        return dtoLP;
    }

    private Float bigDecimalToFloat(BigDecimal number) throws Exception{
        if (number==null){
            return null;
        }
        return new Float(number.floatValue());
    }
    
    private Long bigDecimalToLong(BigDecimal number) throws Exception{
        if (number==null){
            return null;
        }
        return new Long(number.longValue());
    }

    private Integer bigDecimalToInteger(BigDecimal number) throws Exception{
        if (number==null){
            return null;
        }
        return new Integer(number.intValue());
    }

    private Boolean bigDecimalToBoolean(BigDecimal number) throws Exception{
        if (number==null){
            return null;
        }
        if (number.longValue()==0){
            return Boolean.FALSE;
        } else if (number.longValue()==1){
            return Boolean.TRUE;
        } else {
            return null;
        }
    }

   /**
      Crea un DTOPromocion con: 
      - oidPromocion = resultado.getValueAt(fila, "PROMOCION") 
      - numeroCondicion = resultado.getValueAt(fila, "NUMERO_CONDICION") 
      - oidIndicadorCuadre = resultado.getValueAt(fila, "IND_CUADRE") 
      - factorCuadre = resultado.getValueAt(fila, "FACTOR_CUADRE") 


      Devuelve DTOPromocion
    *
    *@autor jpbosnja
    **/
    private DTOPromocion crearDTOPromocion(RecordSet resultado, int fila) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOPromocion(RecordSet resultado, int fila): Entrada");
        
        DTOPromocion dto = new DTOPromocion();
        dto.setOidPromocion(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila, "PROMOCION")));
        dto.setNumeroCondicion(bigDecimalToInteger((BigDecimal)resultado.getValueAt(fila, "NUMERO_CONDICION")));
        dto.setOidIndicadorCuadre(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila, "IND_CUADRE")));
        dto.setFactorCuadre(bigDecimalToFloat((BigDecimal)resultado.getValueAt(fila, "FACTOR_CUADRE")));
        
        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOPromocion(RecordSet resultado, int fila): Salida");
        return dto;
    }

   /**
      Crea un DTOOferta con: 
      - oidOferta = resultado.getValueAt(fila, "OFERTA") 
      - condicionCondicionantes = resultado.getValueAt(fila, "G1") 
      - oidEstrategia = resultado.getValueAt(fila, "ESTRATEGIA") 
      - despachoAutomatico = resultado.getValueAt(fila, "DESPACHO_AUTOMATICO") 
      - numeroPaquetes = resultado.getValueAt(fila, "NUMERO_PAQUETES") 

      Devuelve DTOOferta
    *
    *@autor jpbosnja
    **/
    private DTOOferta crearDTOOferta(RecordSet resultado, int fila) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOOferta(RecordSet resultado, int fila): Entrada");
        
        DTOOferta dto = new DTOOferta();
        dto.setOidOferta(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila, "OFERTA")));
        if (resultado.getValueAt(fila, "G1")!=null){
            dto.setCondicionCondicionantes(resultado.getValueAt(fila, "G1").toString());
        }
        dto.setOidEstrategia(bigDecimalToLong((BigDecimal)resultado.getValueAt(fila, "ESTRATEGIA")));
        dto.setDespachoAutomatico(bigDecimalToBoolean((BigDecimal)resultado.getValueAt(fila, "DESPACHO_AUTOMATICO")));
        dto.setNumeroPaquetes(bigDecimalToInteger((BigDecimal)resultado.getValueAt(fila, "NUMERO_PAQUETES")));
        
        UtilidadesLog.info("MONCuadrePromocionBean.crearDTOOferta(RecordSet resultado, int fila): Salida");
        return dto;
    }

   /**
    * @autor jpbosnja
    * @modificado pperanzola [1] Se han agregado constantesPRE para promociones
    **/
    private Integer calcularCuadrePromocion(ArrayList listaPosiciones, DTOPromocion dtoPromocion) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.calcularCuadrePromocion(ArrayList listaPosiciones, DTOPromocion dtoPromocion): Entrada");
      try {
      
        BigDecimal totalCondicion = new BigDecimal(0.0);
        int cantPos = listaPosiciones.size();

        for (int numeroPosicion = 0;cantPos >numeroPosicion; numeroPosicion++){
          DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)listaPosiciones.get(numeroPosicion);
          //UtilidadesLog.debug("el dtoPosicion, para nº de pos: " + numeroPosicion + " es: " + dtoPosicion);
          BigDecimal precioCatalogo = dtoPosicion.getPrecioCatalogoUnitarioLocal();
          Long unidadesAtender = dtoPosicion.getUnidadesPorAtender();
          Integer factorRepeticion = dtoPosicion.getFactorRepeticion();

          if (dtoPromocion.getOidIndicadorCuadre().longValue()==ConstantesPRE.CUADRE_POR_MONTOS) {  // [1] CUADRE_TOTAL_MONTOS) {
            //UtilidadesLog.debug("Entro por dtoPromocion.getOidIndicadorCuadre().longValue()==ConstantesPRE.CUADRE_POR_MONTOS");
            BigDecimal bUnidades = new BigDecimal(unidadesAtender.longValue());
            BigDecimal bFactor = new BigDecimal(factorRepeticion.intValue());       
          
            totalCondicion = totalCondicion.add(precioCatalogo.multiply(bUnidades).multiply(bFactor));
          } else {
            //UtilidadesLog.debug("Entro por dtoPromocion.getOidIndicadorCuadre().longValue()!=ConstantesPRE.CUADRE_POR_MONTOS");
            BigDecimal bUnidades = new BigDecimal(unidadesAtender.longValue());
            BigDecimal bFactor = new BigDecimal(factorRepeticion.intValue());

            totalCondicion = totalCondicion.add(bUnidades.multiply(bFactor));
          }        
        }
        //UtilidadesLog.debug("TotalCondicion: "+totalCondicion);
        Integer cuadre = null;
        if (dtoPromocion.getFactorCuadre()!=null){
            cuadre = new Integer((int)(totalCondicion.floatValue() / dtoPromocion.getFactorCuadre().floatValue()));//V_PRE20 enozigli 29/11/2006 
        }else{
            cuadre = new Integer((int)(totalCondicion.floatValue()));//V_PRE20 enozigli 29/11/2006 
        }
        UtilidadesLog.info("Datos Salida: cuadre:"+cuadre);
        
        UtilidadesLog.info("MONCuadrePromocionBean.calcularCuadrePromocion(ArrayList listaPosiciones, DTOPromocion dtoPromocion): Salida");
        return cuadre;      
      } catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }     
    }

   /**
      // Calculamos el cuadre de la promocion 
      cuadrePromocion = calcularCuadrePromocion(listaPosiciones, DTOPromocion) 

      Si cuadre = 0 
      cuadre = cuadrePromocion 
      sino 
      { 
      Si DTOOferta.condicionCondicionantes == ConstantesPRE.Y 
      cuadre = Math.min(cuadre, cuadrePromocion) 
      sino 
      cuadre = cuadre + cuadrePromocion 
      } 

      Devuelve cuadre 
    *
    *@autor jpbosnja
    **/
    private Integer calcularCuadre(ArrayList listaPosiciones, DTOPromocion dtoPromocion, DTOOferta dtoOferta, Integer cuadre) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.calcularCuadre(ArrayList listaPosiciones, DTOPromocion dtoPromocion, DTOOferta dtoOferta, Integer cuadre): Entrada");
      try {      
        Integer cuadrePromocion = this.calcularCuadrePromocion(listaPosiciones, dtoPromocion);
        
        if(cuadre == null) {
          //UtilidadesLog.debug("Cuadre: "+cuadre);
          cuadre = cuadrePromocion;          
        } else {
          //UtilidadesLog.debug("dtoOferta.CondicionCondicionantes: "+dtoOferta.getCondicionCondicionantes());
          if(dtoOferta.getCondicionCondicionantes().equals(ConstantesPRE.Y)) {
            cuadre = new Integer(Math.min(cuadre.intValue(), cuadrePromocion.intValue()));
          }
          else {
            cuadre = new Integer(cuadre.intValue() + cuadrePromocion.intValue());
          }          
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.calcularCuadre(ArrayList listaPosiciones, DTOPromocion dtoPromocion, DTOOferta dtoOferta, Integer cuadre): Salida");
        return cuadre;        
      }catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }     
    }

   /**
    *@autor jpbosnja
    * 30/03/2006 - pperanzola - [2] se modifica para mejoras de performance
    **/
    private DTOCabeceraSolicitud eliminarProductosPromocion(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.eliminarProductosPromocion(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada");
      try {
        // /* [2]
        /*DTOSalida dtoSalida = this.getMONOfertaHome().create().obtenerProductosOferta(dtoOferta.getOidOferta());
        //DTOSalida dtoSalida = this.obtenerProductosOferta(dtoOferta.getOidOferta());
        RecordSet resultado = dtoSalida.getResultado();
        ArrayList productosSolicitud = dtoCabeceraSolicitud.getPosiciones();
        MONCuadreProductos mcph =  this.getMONCuadreProductosHome().create();
        int cantRegistros = resultado.getRowCount();
        for(int numeroDetalle=0; cantRegistros > numeroDetalle; numeroDetalle++) {
          String codigoVentaOferta = (String)resultado.getValueAt(numeroDetalle,0);
          for(int numeroPosicion=0; productosSolicitud.size()>numeroPosicion; numeroPosicion++) {
            DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)productosSolicitud.get(numeroPosicion);

            if(codigoVentaOferta!=null && dtoPosicion.getCodigoVenta()!=null && dtoPosicion.getCodigoVenta().equals(codigoVentaOferta)) {
              dtoCabeceraSolicitud = mcph.eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());              
              //dtoCabeceraSolicitud = this.eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());              
            }
          }
        }*/
        
        ArrayList listaCodigosVenta = dtoOferta.getListaCodVenta();
        if (listaCodigosVenta!=null){
            int cantRegistros = listaCodigosVenta.size();
            ArrayList productosSolicitud = dtoCabeceraSolicitud.getPosiciones();
            //MONCuadreProductos mcph =  this.getMONCuadreProductosHome().create();
            MONCuadreProductosLocal mcphl =  this.getMONCuadreProductosLocalHome().create();
            int tProdSolic;
            for(int numeroDetalle=0; cantRegistros > numeroDetalle; numeroDetalle++) {
                String codigoVentaOferta = (String)listaCodigosVenta.get(numeroDetalle);
                tProdSolic = productosSolicitud.size();
                for(int numeroPosicion=0; tProdSolic > numeroPosicion; numeroPosicion++) {
                    DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)productosSolicitud.get(numeroPosicion);
                    if(codigoVentaOferta!=null && dtoPosicion.getCodigoVenta()!=null && dtoPosicion.getCodigoVenta().equals(codigoVentaOferta)) {
                        dtoCabeceraSolicitud = mcphl.eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());              
                    }
                }
            }
        }
        // */ [2]
        UtilidadesLog.info("MONCuadrePromocionBean.eliminarProductosPromocion(DTOOferta dtoOferta, DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida");
        return dtoCabeceraSolicitud;        
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }   
    }

   /**
    * @author jpbosnja
    * @modificadopor 18/08/2005 - enoziglia - se crea un flag para no ordenar varias veces la promocion
    * @nota se a notificado de los cambios a DT GMIOTTI ARG
    **/
    private DTOCabeceraSolicitud cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta): Entrada");
      Cronometrador.startTransaction("MONCuadrePromocionBean.cuadrarIndividual");
      try {
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(dtoOferta.getOidOferta());
        //DTOSalida dtoSalida = this.getMONOfertaHome().create().obtenerProductosAsociados(dtoOid);
        DTOSalida dtoSalida = this.getMONOfertaLocalHome().create().obtenerProductosAsociados(dtoOid);
        String cvAsociado = (String)dtoSalida.getResultado().getValueAt(0,"CODIGO_VENTA");
        boolean cuadro = false;
        
        if(dtoSalida.getResultado().esVacio()==false) {
            for(int numeroPosicion=0; posicionesOferta.size()>numeroPosicion; numeroPosicion++) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                
                if(cvAsociado!=null && cvAsociado.equals(dtoPosicion.getCodigoVenta())) {
                    if(cuadro==false){
                        if((dtoPosicion.getUnidadesPorAtender().intValue()<cuadre.intValue()) && (dtoOferta.getDespachoAutomatico().booleanValue()==true)) {
                            DTOAgregarProductoSolicitud dtoAgregar = new DTOAgregarProductoSolicitud();
                            long res = cuadre.longValue() - dtoPosicion.getUnidadesPorAtender().longValue();
                            Long unidades = new Long(res);
                            dtoAgregar.setUnidadesPorAtender(unidades);
                            dtoAgregar.setNumeroPosicion(dtoPosicion.getNumeroPosicion());
            
                            //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, dtoPosicion);
                            dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, dtoPosicion);
                        } else {
                            if(dtoPosicion.getUnidadesPorAtender().intValue()>cuadre.intValue()) {
                                long unidadesCuadre = dtoPosicion.getUnidadesPorAtender().longValue() - cuadre.longValue(); 
                                Long lUniCuadre = new Long(unidadesCuadre);
                                //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), lUniCuadre);
                                dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), lUniCuadre);
                            }
                        }                    
                        cuadro = true; 
                    } else {
                        //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());
                        dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());
                    }
                }
            }
            if ((cuadro==false)&&(dtoOferta.getDespachoAutomatico().booleanValue()==true)){
                //UtilidadesLog.debug("No encontro la posicion, entonces la agrego si es despacho automatico.");
                DTOAgregarProductoSolicitud dtoAgregarNuevo = new DTOAgregarProductoSolicitud();
                dtoAgregarNuevo.setUnidadesPorAtender(new Long(cuadre.longValue()));
                dtoAgregarNuevo.setCodigoVenta(cvAsociado);
                dtoAgregarNuevo.setOidSubtipoPosicion(this.subtipoPosicion);
                dtoAgregarNuevo.setOidTipoPosicion(this.tipoPosicion);                
                dtoAgregarNuevo.setCodigoVenta(cvAsociado);
                dtoAgregarNuevo.setNumeroPosicion(null);                
                //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregarNuevo, null);
                dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregarNuevo, null);
            }
        }        
        UtilidadesLog.info("MONCuadrePromocionBean.cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta): Salida");
        Cronometrador.endTransaction("MONCuadrePromocionBean.cuadrarIndividual");
        return dtoCabeceraSolicitud;        
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }  
    }
    
    private DTOCabeceraSolicitud cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, ArrayList ofertas) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, ArrayList dtoOferta): Entrada");
      Cronometrador.startTransaction("MONCuadrePromocionBean.cuadrarIndividual");
      try {
        ArrayList oidsOfertas = new ArrayList();
        for (int i = 0 ; i < ofertas.size() ; i++ ){
            oidsOfertas.add(((DTOOferta)ofertas.get(i)).getOidOferta());
        }
        DTOSalida dtoSalida = this.getMONOfertaLocalHome().create().obtenerProductosAsociados(oidsOfertas);
        RecordSet r = dtoSalida.getResultado();
        //String cvAsociado = (String)dtoSalida.getResultado().getValueAt(0,"CODIGO_VENTA");
        
        Integer cuadre = null;
        for (int i = 0 ; i < r.getRowCount() ; i++ ){
            boolean cuadro = false;
            //V_PRE_37 al cambiarse por performance ahora hay que inicializar la bandera cada vuelta por ser ciclico y 
            //todo junto.
                    
            String cvAsociado = (String)r.getValueAt(i,"CODIGO_VENTA");
            DTOOferta dtoOferta = null;
            for (int z = 0 ; z < ofertas.size() ; z++ ){
                dtoOferta = (DTOOferta)ofertas.get(z);
                if (dtoOferta.getOidOferta().longValue() == Long.valueOf((r.getValueAt(i,"OFERTA").toString())).longValue()){
                    break;
                }
            }
            cuadre = dtoOferta.getCuadre();
            for(int numeroPosicion=0; posicionesOferta.size()>numeroPosicion; numeroPosicion++) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                
                if(cvAsociado!=null && cvAsociado.equals(dtoPosicion.getCodigoVenta())) {
                    if(cuadro==false){
                        if((dtoPosicion.getUnidadesPorAtender().intValue()<cuadre.intValue()) && (dtoOferta.getDespachoAutomatico().booleanValue()==true)) {
                            DTOAgregarProductoSolicitud dtoAgregar = new DTOAgregarProductoSolicitud();
                            long res = cuadre.longValue() - dtoPosicion.getUnidadesPorAtender().longValue();
                            Long unidades = new Long(res);
                            dtoAgregar.setUnidadesPorAtender(unidades);
                            dtoAgregar.setNumeroPosicion(dtoPosicion.getNumeroPosicion());
            
                            //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, dtoPosicion);
                            dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, dtoPosicion);
                        } else {
                            if(dtoPosicion.getUnidadesPorAtender().intValue()>cuadre.intValue()) {
                                long unidadesCuadre = dtoPosicion.getUnidadesPorAtender().longValue() - cuadre.longValue(); 
                                Long lUniCuadre = new Long(unidadesCuadre);
                                //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), lUniCuadre);
                                dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), lUniCuadre);
                            }
                        }                    
                        cuadro = true; 
                    } else {
                        //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());
                        dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoCabeceraSolicitud, dtoPosicion.getNumeroPosicion(), dtoPosicion.getUnidadesPorAtender());
                    }
                }
            }
            if ((cuadro==false)&&(dtoOferta.getDespachoAutomatico().booleanValue()==true)){
                //UtilidadesLog.debug("No encontro la posicion, entonces la agrego si es despacho automatico.");
                DTOAgregarProductoSolicitud dtoAgregarNuevo = new DTOAgregarProductoSolicitud();
                dtoAgregarNuevo.setUnidadesPorAtender(new Long(cuadre.longValue()));
                dtoAgregarNuevo.setCodigoVenta(cvAsociado);
                dtoAgregarNuevo.setOidSubtipoPosicion(this.subtipoPosicion);
                dtoAgregarNuevo.setOidTipoPosicion(this.tipoPosicion);                
                dtoAgregarNuevo.setCodigoVenta(cvAsociado);
                dtoAgregarNuevo.setNumeroPosicion(null);                
                //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregarNuevo, null);
                dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregarNuevo, null);
            }
        }        
        UtilidadesLog.info("MONCuadrePromocionBean.cuadrarIndividual(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, ArrayList dtoOferta): Salida");
        Cronometrador.endTransaction("MONCuadrePromocionBean.cuadrarIndividual");
        return dtoCabeceraSolicitud;        
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }  
    }

   /**
      // Llamamaos al cuadre de compuesta variable 
      DTOCabeceraSolicitud = Llamar al método MONCuadreCompuestaVariable.cuadrarOferta(DTOCabeceraSolicitud, posicionesOferta, cuadre, DTOOferta.despachoAutomatico) 

      Devuelve DTOCabeceraSolicitud
    *
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud cuadrarGrupos(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.cuadrarGrupos(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta): Entrada");
      Cronometrador.startTransaction("MONCuadrePromocionBean.cuadrarGrupos");
      try {        
        //dtoCabeceraSolicitud = this.getMONCuadreCompuestaVariableHome().create().cuadrarOferta(dtoCabeceraSolicitud, posicionesOferta, cuadre, dtoOferta.getDespachoAutomatico(), this.tipoPosicion, this.subtipoPosicion, dtoOferta);
        dtoCabeceraSolicitud = this.getMONCuadreCompuestaVariableLocalHome().create().cuadrarOferta(dtoCabeceraSolicitud, posicionesOferta, cuadre, dtoOferta.getDespachoAutomatico(), this.tipoPosicion, this.subtipoPosicion, dtoOferta);
        
        UtilidadesLog.info("MONCuadrePromocionBean.cuadrarGrupos(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta): Salida");
        Cronometrador.endTransaction("MONCuadrePromocionBean.cuadrarGrupos");
        return dtoCabeceraSolicitud;      
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }          
    }

   /**
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud cuadrarPaquetes(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta, Long tipoPosicion, Long subtipoPosicion) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.cuadrarPaquetes(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta, Long tipoPosicion, Long subtipoPosicion): Entrada");
      try {
        dtoCabeceraSolicitud = this.igualarPosiciones(dtoCabeceraSolicitud, dtoOferta, posicionesOferta, tipoPosicion, subtipoPosicion);
        dtoCabeceraSolicitud = this.cuadreMultipaquete(dtoCabeceraSolicitud, dtoOferta, posicionesOferta, cuadre, tipoPosicion, subtipoPosicion);
        UtilidadesLog.info("MONCuadrePromocionBean.cuadrarPaquetes(DTOCabeceraSolicitud dtoCabeceraSolicitud, ArrayList posicionesOferta, Integer cuadre, DTOOferta dtoOferta, Long tipoPosicion, Long subtipoPosicion): Salida");
        return dtoCabeceraSolicitud;         
      }catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }    
    }

   /**
    *@autor jpbosnja
    **/
    private DTOPosicionSolicitud buscarProductoSolicitud(String codigoVenta, ArrayList posicionesSolicitud) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.buscarProductoSolicitud(String codigoVenta, ArrayList posicionesSolicitud): Entrada");
      try {
        DTOPosicionSolicitud productoSolicitado = null;
        boolean encontrado = false;
        //UtilidadesLog.debug("CodigoVenta buscado = " + codigoVenta);
        
        for (int numeroProducto = 0; (posicionesSolicitud.size()>numeroProducto) && (encontrado==false); numeroProducto++){
          DTOPosicionSolicitud prodSolicitado = (DTOPosicionSolicitud)posicionesSolicitud.get(numeroProducto);
          //UtilidadesLog.debug("CodigoVenta actual = " + prodSolicitado.getCodigoVenta());
          if(codigoVenta!=null && codigoVenta.equals(prodSolicitado.getCodigoVenta())) {
            encontrado = true;
            productoSolicitado = prodSolicitado;
          }         
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.buscarProductoSolicitud(String codigoVenta, ArrayList posicionesSolicitud): Salida");
        return productoSolicitado;
        
      }catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }         
    }

   /**
    *@autor jpbosnja
    **/
    private int calcularUnidadesTotales(ArrayList posicionesOferta, DTOOferta dtoOferta) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.calcularUnidadesTotales(ArrayList posicionesOferta, DTOOferta dtoOferta): Entrada");
        try {
            ArrayList unidadesPaquete = new ArrayList(); 
            int i=0;
            //UtilidadesLog.debug("posicionesOferta = " + posicionesOferta.size());
            for (int numeroPosicion = 0; posicionesOferta.size()>numeroPosicion; numeroPosicion++) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
                
                Collection col = dolh.findByOfertaCV(dtoOferta.getOidOferta(), dtoPosicion.getCodigoVenta());
                Iterator it = col.iterator();              
                if (it.hasNext()){
                    DetalleOfertaLocal dol = (DetalleOfertaLocal)it.next();                    
                    UtilidadesLog.debug("CV"+dol.getCodigoVenta());                    
                    unidadesPaquete.add(i, dtoPosicion.getUnidadesPorAtender());
                    i++;
                }
            }

            int suma = 0;

            for (int numeroPaquete = 0; unidadesPaquete.size()>numeroPaquete; numeroPaquete++) {
                Long uni = (Long)unidadesPaquete.get(numeroPaquete);
                suma = suma + uni.intValue();
            }
            
            UtilidadesLog.info("MONCuadrePromocionBean.calcularUnidadesTotales(ArrayList posicionesOferta, DTOOferta dtoOferta): Salida");
            return suma;
            
        }catch (Exception e){
            if (e instanceof MareException)
                throw (MareException)e;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }   
    }

    /**
      Crea un DTOAgregarProductoSolicitud con: 
      - tipoPosicion = tipoPosicion (Parámetro de entrada) 
      - subtipoPosicion = subtipoPosicion (Parámetro de entrada) 
      - codigoVenta = detalleOferta.codigoVenta 
      - unidadesPorAtender = productoSolicitud.unidadesPorAtender 

      DTOCabeceraSolicitud = Llamar al método MONCuadreProductos.agregarProductos(DTOCabeceraSolicitud, DTOAgregarProductoSolicitud, null) 

      Devuelve DTOCabeceraSolicitud
    *
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud agregarPosicion(Long tipoPosicion, Long subtipoPosicion, String codigoVenta, Long unidades, DTOCabeceraSolicitud dtoCabeceraSolicitud) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.agregarPosicion(Long tipoPosicion, Long subtipoPosicion, String codigoVenta, Long unidades, DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada");
      try {
        DTOAgregarProductoSolicitud dtoAgregar = new DTOAgregarProductoSolicitud();
        dtoAgregar.setOidTipoPosicion(tipoPosicion);
        dtoAgregar.setOidSubtipoPosicion(subtipoPosicion);
        dtoAgregar.setCodigoVenta(codigoVenta);
        dtoAgregar.setUnidadesPorAtender(unidades);
        
        //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, null);    
        dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, null);    
        
        UtilidadesLog.info("MONCuadrePromocionBean.agregarPosicion(Long tipoPosicion, Long subtipoPosicion, String codigoVenta, Long unidades, DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida");
        return dtoCabeceraSolicitud;
        
      }catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      
    }

   /**
      Crea un DTOAgregarProductoSolicitud con: 
      - unidadesPorAtender = unidades 
      - numeroPosicion = productoSolicitado.numeroPosicion 

      DTOCabeceraSolicitud = Llamar al método MONCuadreProductos.agregarProductos(DTOCabeceraSolicitud, DTOAgregarProductoSolicitud, productoSolicitado) 

      Devuelve DTOCabeceraSolicitud
    *
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud agregarUnidades(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud productoSolicitado, Long unidades) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.agregarUnidades(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud productoSolicitado, Long unidades): Entrada");
      try {
        DTOAgregarProductoSolicitud dtoAgregar = new DTOAgregarProductoSolicitud();
        dtoAgregar.setUnidadesPorAtender(unidades);
        dtoAgregar.setNumeroPosicion(productoSolicitado.getNumeroPosicion());

        //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, productoSolicitado);
        dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().agregarProductos(dtoCabeceraSolicitud, dtoAgregar, productoSolicitado);
        
        UtilidadesLog.info("MONCuadrePromocionBean.agregarUnidades(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOPosicionSolicitud productoSolicitado, Long unidades): Salida");
        return dtoCabeceraSolicitud;
        
      }catch (Exception e){
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
    }

   /**
    *@autor jpbosnja
    **/
    /*private Boolean comprobarProductosEnOferta(DTOOferta dtoOferta, ArrayList posicionesSolicitud) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.comprobarProductosEnOferta(DTOOferta dtoOferta, ArrayList posicionesSolicitud): Entrada");
      try {
        int cantPos = posicionesSolicitud.size();
      
        for (int numeroPosicion = 0;cantPos >numeroPosicion; numeroPosicion++) {
          DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesSolicitud.get(numeroPosicion);
          Collection col = this.getDetalleOfertaLocalHome().findByOfertaCV(dtoOferta.getOidOferta(), dtoPosicion.getCodigoVenta());
        }
      
        UtilidadesLog.info("MONCuadrePromocionBean.comprobarProductosEnOferta(DTOOferta dtoOferta, ArrayList posicionesSolicitud): Salida");
        return new Boolean(true);
        
      }catch (NoResultException fe){
        UtilidadesLog.info("MONCuadrePromocionBean.comprobarProductosEnOferta(DTOOferta dtoOferta, ArrayList posicionesSolicitud): Salida");
        return new Boolean(false);
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      
    }*/

   /**
    *@autor jpbosnja
    **/
    private DTOCabeceraSolicitud igualarPosiciones(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.igualarPosiciones(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion): Entrada");
        try {             
            
            /*for(int numeroPosicion=0;posicionesOferta.size()>numeroPosicion;numeroPosicion++) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                Collection listaDetalles = this.getDetalleOfertaLocalHome().findByOfertaCV(dtoOferta.getOidOferta(), dtoPosicion.getCodigoVenta());
                Iterator it1 = listaDetalles.iterator();
                if (it1.hasNext()){
                    //UtilidadesLog.debug("entra a iterar");
                    DetalleOfertaLocal dol = (DetalleOfertaLocal)it1.next();

                    Collection productosMismoPaquete = this.getDetalleOfertaLocalHome().findByGrupo(dol.getOidGrupOfer());
                    Iterator it2 = productosMismoPaquete.iterator();

                    while(it2.hasNext()) {
                        DetalleOfertaLocal dol2 = (DetalleOfertaLocal)it2.next();
                        //DTOPosicionSolicitud dtoPosicionSolicitud = this.buscarProductoSolicitud(dol2.getCodigoVenta(), posicionesOferta);
                        DTOPosicionSolicitud dtoPosicionSolicitud = this.buscarProductoSolicitud(dol2.getCodigoVenta(), dtoCabeceraSolicitud.getPosiciones());
                        if(dtoPosicionSolicitud==null) {
                            dtoCabeceraSolicitud = this.agregarPosicion(tipoPosicion, subtipoPosicion, dol2.getCodigoVenta(), dtoPosicion.getUnidadesPorAtender(), dtoCabeceraSolicitud);
                        }else {
                            if(dtoPosicionSolicitud.getUnidadesPorAtender().longValue()!=dtoPosicion.getUnidadesPorAtender().longValue()) {
                                long unidadesSumar = Math.max(dtoPosicionSolicitud.getUnidadesPorAtender().longValue(), dtoPosicion.getUnidadesPorAtender().longValue());
                                Long uni = new Long(unidadesSumar);
                                dtoCabeceraSolicitud = this.agregarUnidades(dtoCabeceraSolicitud, dtoPosicionSolicitud, uni);                
                            }
                        }            
                    }
                }
            }*/
            RecordSet r = buscarProductosMismoPaquete (dtoOferta);
            UtilidadesLog.debug("buscarProductosMismoPaquete: "+r);
            Long unidadesPorAtenderDetaOferDigi = null;
            for(int numeroPosicion=0;posicionesOferta.size()>numeroPosicion;numeroPosicion++) {
                DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(numeroPosicion);
                ArrayList l = filtrarProductosRecordSet (r, dtoPosicion.getCodigoVenta());
                UtilidadesLog.debug("filtrarProductosRecordSet para Codigo Venta "+dtoPosicion.getCodigoVenta()+": "+r);
                
                if (dtoPosicion.getOidOferta().equals(dtoOferta.getOidOferta())) {
                    unidadesPorAtenderDetaOferDigi = dtoPosicion.getUnidadesPorAtender();
                } else {
                    unidadesPorAtenderDetaOferDigi = new Long(0);
                }
                
                for (int i = 0 ; i < l.size() ; i++ ){
                    DTOPosicionSolicitud dtoPosicionSolicitud = this.buscarProductoSolicitud(l.get(i).toString(), dtoCabeceraSolicitud.getPosiciones());
                    if(dtoPosicionSolicitud==null) {
                        dtoCabeceraSolicitud = this.agregarPosicion(tipoPosicion, subtipoPosicion, l.get(i).toString(), unidadesPorAtenderDetaOferDigi, dtoCabeceraSolicitud);
                    }else {
                        if(dtoPosicionSolicitud.getUnidadesPorAtender().longValue()<unidadesPorAtenderDetaOferDigi.longValue()) {
                            Long uni = new Long(unidadesPorAtenderDetaOferDigi.longValue()-dtoPosicionSolicitud.getUnidadesPorAtender().longValue());
                            UtilidadesLog.debug("Unidades A ajustara al numero posicion "+numeroPosicion+" : "+uni);
                            dtoCabeceraSolicitud = this.agregarUnidades(dtoCabeceraSolicitud, dtoPosicionSolicitud, uni);
                        }
                    }
                }
            }
            
            
            UtilidadesLog.info("MONCuadrePromocionBean.igualarPosiciones(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion): Salida");
            return dtoCabeceraSolicitud;
            
        }catch (Exception e){        
          if (e instanceof MareException)
            throw (MareException)e;
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }       
    }
    
    private ArrayList filtrarProductosRecordSet (RecordSet r, String cv) {
        ArrayList array = new ArrayList();
        BigDecimal old_grupo = null;
        boolean encontro = false;
        for (int i = 0 ; i < r.getRowCount() ; i++){
            if (old_grupo == null || !old_grupo.equals(r.getValueAt(i,"GRUPO"))){
                old_grupo = (BigDecimal)r.getValueAt(i,"GRUPO");
                if (!encontro){
                    array = new ArrayList();               
                }else{
                    break;
                }
            }
            array.add(r.getValueAt(i,"CODVENTA").toString());
            if (cv.equals(r.getValueAt(i,"CODVENTA").toString())){
                encontro = true;
            }            
        }
        return array;
    }
    
    private RecordSet buscarProductosMismoPaquete (DTOOferta dtoOferta) throws MareException{
        StringBuffer sb = new StringBuffer();
        RecordSet r = null;
        BelcorpService bs = null;
        sb.append(" select d.VAL_CODI_VENT CODVENTA, g.OID_GRUP_OFER GRUPO, g.NUM_GRUP NUMEROGRUPO from pre_ofert_detal d, pre_grupo_ofert g ");
        sb.append(" where d.GOFE_OID_GRUP_OFER = g.OID_GRUP_OFER ");
        sb.append(" and d.OFER_OID_OFER = "+dtoOferta.getOidOferta());
        sb.append(" and g.OFER_OID_OFER = d.OFER_OID_OFER ");
        sb.append(" order by GRUPO ");
        try {
            bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sb.toString());
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        return r;        
    }

   /**
    *@autor jpbosnja
    **/
    /*private DTOCabeceraSolicitud cuadreMonopaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion) throws Exception {
      UtilidadesLog.info("MONCuadrePromocionBean.cuadreMonopaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion): Entrada");
      try {
        if(dtoOferta.getNumeroPaquetes().intValue() == 1) {
          Collection grupos = this.getGrupoLocalHome().findByOidOferta(dtoOferta.getOidOferta());          
          Iterator it = grupos.iterator();        
          GrupoLocal gl = (GrupoLocal)it.next();          

          Collection productosMismoPaquete = this.getDetalleOfertaLocalHome().findByGrupo(gl.getOid());
          Iterator it2 = productosMismoPaquete.iterator();   
          
          Boolean productosEnOferta = this.comprobarProductosEnOferta(dtoOferta, dtoCabeceraSolicitud.getPosiciones());

          if(productosEnOferta.booleanValue()==true) {
            while(it2.hasNext()) {
              DetalleOfertaLocal dol = (DetalleOfertaLocal)it2.next();
              DTOPosicionSolicitud productoSolicitado = this.buscarProductoSolicitud(dol.getCodigoVenta(), dtoCabeceraSolicitud.getPosiciones());
              
              Long unidades;
              if (productoSolicitado!=null){
                  unidades = new Long(productoSolicitado.getUnidadesPorAtender().longValue() - cuadre.longValue());
              }else{
                  unidades = new Long(0);
              }
              
              if(unidades.longValue()>0) {
                //dtoCabeceraSolicitud = this.getMONCuadreProductosHome().create().eliminarProductos(dtoCabeceraSolicitud, productoSolicitado.getNumeroPosicion(), unidades);                
                dtoCabeceraSolicitud = this.getMONCuadreProductosLocalHome().create().eliminarProductos(dtoCabeceraSolicitud, productoSolicitado.getNumeroPosicion(), unidades);                                
              }
              else {
                if((unidades.longValue()<0) && (dtoOferta.getDespachoAutomatico().booleanValue()==true)) {
                  long unidadesSumar = Math.abs(unidades.longValue());
                  Long uniSum = new Long(unidadesSumar);
                  dtoCabeceraSolicitud = this.agregarUnidades(dtoCabeceraSolicitud, productoSolicitado, uniSum);                  
                }                
              }      
            }            
          }

          if((productosEnOferta.booleanValue()==false) && (dtoOferta.getDespachoAutomatico().booleanValue()==true)) {
            while(it2.hasNext()) {
              DetalleOfertaLocal dol = (DetalleOfertaLocal)it2.next();
              dtoCabeceraSolicitud = this.agregarPosicion(tipoPosicion, subtipoPosicion, dol.getCodigoVenta(), new Long(cuadre.longValue()), dtoCabeceraSolicitud);
            }     
          }     
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.cuadreMonopaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion): Salida");
        return dtoCabeceraSolicitud;
        
      }catch (Exception e){        
        if (e instanceof MareException)
          throw (MareException)e;
        UtilidadesLog.error(e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }          
    }*/

   /**
    * @autor jpbosnja
    * @moficado 19/08/2005 pperanzola se reconstruye el método
    *           22/08/2005 pperanzola se considera dtoOferta.getCondicionCondicionantes()
    *           es sólo para las promociones y no para los paquetes de regalo. Por lo tanto 
    *           la condicion para los regalos siempre se tomará como ConstantesPRE.O
    **/
    private DTOCabeceraSolicitud cuadreMultipaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion) throws Exception {
        UtilidadesLog.info("MONCuadrePromocionBean.cuadreMultipaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion): Entrada");
        try {            
            //UtilidadesLog.debug("DTOCABECERA posicionesOferta : " + dtoCabeceraSolicitud.getPosiciones());
            //int suma;
            //String condCondte = dtoOferta.getCondicionCondicionantes();
            //RecordSet r = buscarProductosMismoPaquete(dtoOferta);
            //DetalleOfertaLocal dol = null;
            //Collection listaPaquetes = this.getGrupoLocalHome().findByOidOferta(dtoOferta.getOidOferta());
            //Iterator it = listaPaquetes.iterator();
            Long cuadreDisponible = new Long (cuadre.longValue());
            boolean tipoDespacho;
            //UtilidadesLog.debug("dtoOferta.getDespachoAutomatico() = " + dtoOferta.getDespachoAutomatico());
            if (dtoOferta.getDespachoAutomatico()!=null){
                tipoDespacho = dtoOferta.getDespachoAutomatico().booleanValue();
            }else {
                tipoDespacho = false;
            }
            /*BigDecimal old_grupo = null;
            for (int i = 0 ; i < r.getRowCount() ; i++ ){
                String cv = r.getValueAt(i,"CODVENTA").toString();
                DTOPosicionSolicitud dto = this.buscarProductoSolicitud(cv, dtoCabeceraSolicitud.getPosiciones());
                if(dto == null) {
                    Long lUnidades = new Long(0);
                    dtoCabeceraSolicitud = this.agregarPosicion(tipoPosicion
                                                                ,subtipoPosicion
                                                                ,cv
                                                                ,lUnidades
                                                                ,dtoCabeceraSolicitud);
                    dto = this.buscarProductoSolicitud(cv, dtoCabeceraSolicitud.getPosiciones());
                    dto.setGrupo(new Integer(r.getValueAt(i,"NUMEROGRUPO").toString()));
                }else {
                    //UtilidadesLog.debug("dto != null");
                    long unidadesSumar = dto.getUnidadesPorAtender().longValue();
                    Long lUnidades = new Long(0);
                   // UtilidadesLog.debug("lUnidades= " + lUnidades);
                   // UtilidadesLog.debug("Vamos hacia agregar unidades " + dto.getCodigoVenta());
                    if (dto.getGrupo()==null){
                        dto.setGrupo(new Integer(r.getValueAt(i,"NUMEROGRUPO").toString()));
                    }                                
                    dtoCabeceraSolicitud = this.agregarUnidades(dtoCabeceraSolicitud, dto, lUnidades);              
                } 
                
            }*/
            
            /*while (it.hasNext()){ 
                GrupoLocal gl = (GrupoLocal)it.next();
                //UtilidadesLog.debug("Entro al while it gl= " + gl.getOid()); 
                Collection productosMismoPaquete = this.getDetalleOfertaLocalHome().findByGrupo(gl.getOid());
                //UtilidadesLog.debug("obtuve la coleccion de productosMismoPaquete "); 
                Iterator it2 = productosMismoPaquete.iterator();
                while(it2.hasNext()) {
                    //UtilidadesLog.debug("entro a Iterar"); 
                    dol = (DetalleOfertaLocal)it2.next();
                    DTOPosicionSolicitud dto = this.buscarProductoSolicitud(dol.getCodigoVenta(), dtoCabeceraSolicitud.getPosiciones());

                    if(dto == null) {
                        //UtilidadesLog.debug("dto == null");
                        //long unidades = cuadre.longValue();
                        Long lUnidades = new Long(0);
                        dtoCabeceraSolicitud = this.agregarPosicion(tipoPosicion
                                                                    ,subtipoPosicion
                                                                    ,dol.getCodigoVenta()
                                                                    ,lUnidades
                                                                    ,dtoCabeceraSolicitud);
                        dto = this.buscarProductoSolicitud(dol.getCodigoVenta(), dtoCabeceraSolicitud.getPosiciones());
                        dto.setGrupo(gl.getNumeroGrupo());
                    }else {
                        //UtilidadesLog.debug("dto != null");
                        long unidadesSumar = dto.getUnidadesPorAtender().longValue();
                        Long lUnidades = new Long(0);
                       // UtilidadesLog.debug("lUnidades= " + lUnidades);
                       // UtilidadesLog.debug("Vamos hacia agregar unidades " + dto.getCodigoVenta());
                        if (dto.getGrupo()==null){
                            dto.setGrupo(gl.getNumeroGrupo());
                        }                                
                        dtoCabeceraSolicitud = this.agregarUnidades(dtoCabeceraSolicitud, dto, lUnidades);              
                    }           
                }   
            }*/
            dtoCabeceraSolicitud.setPosiciones(this.completarPaquetesO(dtoCabeceraSolicitud.getPosiciones()
                                                                       ,dtoOferta.getOidOferta()
                                                                       ,cuadreDisponible
                                                                       ,posicionesOferta
                                                                       ,tipoDespacho));

            UtilidadesLog.info("MONCuadrePromocionBean.cuadreMultipaquete(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOOferta dtoOferta, ArrayList posicionesOferta, Integer cuadre, Long tipoPosicion, Long subtipoPosicion): Salida");
            return dtoCabeceraSolicitud;
            
        }catch (Exception e){        
          if (e instanceof MareException)
            throw (MareException)e;
          UtilidadesLog.error(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }   
    }

  // METODOS AGREGADOS POR PPERANZOLA
  /**
   * @author pperanzola
   * @date 18/08/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidOferta
   */
   private RecordSet obtenerGrupoMayorRanking(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONCuadrePromocionBean.obtenerGrupoMayorRanking(Long oidOferta): Entrada");
        BelcorpService belcorpService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        query.append(" SELECT DISTINCT * FROM ( ");
        query.append(" SELECT  ");
            query.append(" g.num_grup ");
        query.append(" FROM ");
            query.append(" pre_ofert_detal od, pre_grupo_ofert g ");
        query.append(" WHERE ");
            query.append(" od.ofer_oid_ofer = " + oidOferta);
            query.append(" AND od.gofe_oid_grup_ofer = g.oid_grup_ofer ");
        query.append(" ORDER BY od.num_posi_rank DESC  ");
        query.append(" ) ");
        
        try {
             rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
             throw me;
        } catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.obtenerGrupoMayorRanking(Long oidOferta): Salida");
        return rs; 
    }
    
  /**
   * @author pperanzola
   * @date 18/08/2005
   * @throws Exception
   * @return DTOCabeceraSolicitud
   * @param DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta
   */    
    private DTOCabeceraSolicitud eliminarProductosGrupo (DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta) throws Exception{
        UtilidadesLog.info("MONCuadrePromocionBean.eliminarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta): Entrada");

        try{
            /*UtilidadesLog.debug("numeroUnidadesA= " + numeroUnidadesA);
            UtilidadesLog.debug("numeroGrupo= " + numeroGrupo);
            UtilidadesLog.debug("posicionesOferta= " + posicionesOferta);*/
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(oidOferta);
            dtoRank.setPrimerRanking(null);
            dtoRank.setUltimoRanking(null);
            dtoRank.setDTOCabeceraSolicitud(dtoe);
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
            
            //dtoe = this.getMONRankingProductosHome().create().eliminarProductosGrupo(dtoRank);
            dtoe = this.getMONRankingProductosLocalHome().create().eliminarProductosGrupo(dtoRank);
            
            UtilidadesLog.info("MONCuadrePromocionBean.eliminarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta): Salida");
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
   * @author pperanzola
   * @date 18/08/2005
   * @throws Exception
   * @return DTOCabeceraSolicitud
   * @param DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta
   */    
    private DTOCabeceraSolicitud agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta) throws Exception{
        UtilidadesLog.info("MONCuadrePromocionBean.agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta): Salida");
        try{  
            /*UtilidadesLog.debug("numeroUnidadesA= " + numeroUnidadesA);
            UtilidadesLog.debug("numeroGrupo= " + numeroGrupo);*/
            DTORankingCuadre dtoRank = new DTORankingCuadre();
            dtoRank.setTipoPosicion(this.getTipoPosicion());
            dtoRank.setSubtipoPosicion(this.getSubtipoPosicion());
            dtoRank.setOidOferta(oidOferta);
            dtoRank.setPrimerRanking(null);
            dtoRank.setUltimoRanking(null);
            dtoRank.setDTOCabeceraSolicitud(dtoe);
            dtoRank.setPosicionesOferta(posicionesOferta);
            dtoRank.setNumeroUnidadesA(numeroUnidadesA);
            dtoRank.setNumeroGrupo((numeroGrupo!=null)?new Long(numeroGrupo.intValue()):null);
            
            //dtoe = this.getMONRankingProductosHome().create().agregarProductosGrupo(dtoRank);
            dtoe = this.getMONRankingProductosLocalHome().create().agregarProductosGrupo(dtoRank);
            
            UtilidadesLog.info("MONCuadrePromocionBean.agregarProductosGrupo(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long numeroUnidadesA, Integer numeroGrupo, Long oidOferta): Salida");
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
    
    public Long getTipoPosicion() {
        UtilidadesLog.info("MONCuadrePromocionBean.getTipoPosicion(): Entrada");
        UtilidadesLog.info("MONCuadrePromocionBean.getTipoPosicion(): Salida");
        return tipoPosicion;
    }
    
    public void setTipoPosicion(Long tipoPosicion) {
        UtilidadesLog.info("MONCuadrePromocionBean.setTipoPosicion(Long tipoPosicion): Entrada");
        this.tipoPosicion = tipoPosicion;
        UtilidadesLog.info("MONCuadrePromocionBean.setTipoPosicion(Long tipoPosicion): Salida");
    }
    
    public Long getSubtipoPosicion() {
        UtilidadesLog.info("MONCuadrePromocionBean.getSubtipoPosicion(): Entrada");
        UtilidadesLog.info("MONCuadrePromocionBean.getSubtipoPosicion(): Salida");
        return subtipoPosicion;
    }

    public void setSubtipoPosicion(Long subtipoPosicion) {
        UtilidadesLog.info("MONCuadrePromocionBean.setSubtipoPosicion(Long subtipoPosicion): Entrada");
        this.subtipoPosicion = subtipoPosicion;
        UtilidadesLog.info("MONCuadrePromocionBean.setSubtipoPosicion(Long subtipoPosicion): Salida");        
    }
    
    /**
     * @author pperanzola
     * @date 19/08/2005
     * @return ArrayList 
     * @param posicionesOferta
     * Completa las unidades a atender del listado de solicitudes segun el cuadre y el ranking
     */
    private ArrayList completarPaquetesO(ArrayList posicionesOferta, Long oidOferta, Long cuadre, ArrayList posicionesOfertaDigitada, boolean tipoDespacho) throws MareException{
        UtilidadesLog.info("MONCuadrePromocionBean.completarPaquetesO(ArrayList posicionesOferta, Long oidOferta, Long cuadre, ArrayList posicionesOfertaDigitada, boolean tipoDespacho): Entrada");
        
        int i;
        int posicOfertamano;
        int rsGrupTamano;
        Long cuadreDisponible = cuadre;
        Long maxCuadreSolicGrup = null;
        Long grupoActual = null;
        RecordSet rsGrupos =  this.obtenerGrupoMayorRanking(oidOferta);        
        rsGrupTamano = rsGrupos.getRowCount();
        
        // Busco las posiciones del grupo dentro de la lista de posicionesOferta
        posicOfertamano = posicionesOferta.size();
        /*UtilidadesLog.debug("posicOfertamano = " + posicOfertamano);
        UtilidadesLog.debug("rsGrupTamano = " + rsGrupTamano);
        UtilidadesLog.debug("cuadreDisponible = " + cuadreDisponible);*/
        if (tipoDespacho){
            //UtilidadesLog.debug("tipoDespacho = true");
            for (i = 0; i< rsGrupTamano; i++){
                    grupoActual = new Long(((BigDecimal) rsGrupos.getValueAt(i,"NUM_GRUP")).longValue());
                    
                    /*UtilidadesLog.debug(" - grupoActual = " + grupoActual);
                    UtilidadesLog.debug(" - oidOfertaActual = " + oidOferta);*/
                    //Obtengo la mayor cantidad de unidades solicitadas del grupo segun ranking
                    maxCuadreSolicGrup = this.obtenerMaxUnidadesAtenderGrupo (posicionesOferta, grupoActual, oidOferta);
                    // Si las unidades que se piden es es mayor que el cuadre obtenido se actualizan todas las unidades al cuadre sino
                    if (cuadreDisponible.longValue() > 0){
                        if (maxCuadreSolicGrup.longValue() >= cuadreDisponible.longValue() ){
                            
                            posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual, cuadreDisponible, oidOferta);
                            cuadreDisponible = new Long (0);
                            
                        } else if (maxCuadreSolicGrup.longValue()!=0 )  {
                            // Si el maxCuadreSolicGrup es cero es que no se digito ninguno de los codigos de venta
                            //UtilidadesLog.debug("maxCuadreSolicGrup.longValue()!=0 => qSol < qDisp ");
                            posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual,maxCuadreSolicGrup,oidOferta);
                            cuadreDisponible = new Long (cuadreDisponible.longValue() - maxCuadreSolicGrup.longValue());
                            //UtilidadesLog.debug("NUEVO cuadreDisponible = " + cuadreDisponible);
                        }
                    }else {
                        posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual, new Long (0), oidOferta);
                    } 
                }
                /*UtilidadesLog.debug(" Cuadre Sobrante = " + cuadreDisponible);
                UtilidadesLog.debug(" el Cuadre Sobrante se lo agrego al primero del ranking ");*/
                if (cuadreDisponible.longValue()> 0  && tipoDespacho){
                    grupoActual = new Long(((BigDecimal) rsGrupos.getValueAt(0,"NUM_GRUP")).longValue());
                    //UtilidadesLog.debug(" grupoActual = " + grupoActual);
                    posicionesOferta = completaUnidadesAtender (posicionesOferta, grupoActual, cuadreDisponible,oidOferta);
                }
            
            //UtilidadesLog.debug(" Voy Al Borrado ");
            posicionesOferta = this.borrarPosicionesSolicitudes(posicionesOferta, oidOferta ,rsGrupos, posicionesOfertaDigitada );
            
            UtilidadesLog.info("MONCuadrePromocionBean.completarPaquetesO(ArrayList posicionesOferta, Long oidOferta, Long cuadre, ArrayList posicionesOfertaDigitada, boolean tipoDespacho): Salida");
            return posicionesOferta;
            
        }else{
            //UtilidadesLog.debug("tipoDespacho = false");
            for (i = 0; i< rsGrupTamano; i++){
                    grupoActual = new Long(((BigDecimal) rsGrupos.getValueAt(i,"NUM_GRUP")).longValue());
                    
                    /*UtilidadesLog.debug(" - grupoActual = " + grupoActual);
                    UtilidadesLog.debug(" - oidOfertaActual = " + oidOferta);*/
                    //Obtengo la mayor cantidad de unidades solicitadas del grupo segun ranking
                    maxCuadreSolicGrup = this.obtenerMaxUnidadesAtenderGrupo (posicionesOferta, grupoActual, oidOferta);
                    // Si las unidades que se piden es es mayor que el cuadre obtenido se actualizan todas las unidades al cuadre sino
                    if (cuadreDisponible.longValue() > 0){
                        if (maxCuadreSolicGrup.longValue() >= cuadreDisponible.longValue() ){
                            
                            posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual, cuadreDisponible, oidOferta);
                            cuadreDisponible = new Long (0);
                            
                        } else if (maxCuadreSolicGrup.longValue()!=0 )  {
                            // Si el maxCuadreSolicGrup es cero es que no se digito ninguno de los codigos de venta
                            //UtilidadesLog.debug("maxCuadreSolicGrup.longValue()!=0 => qSol < qDisp ");
                            posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual,maxCuadreSolicGrup,oidOferta);
                            cuadreDisponible = new Long (cuadreDisponible.longValue() - maxCuadreSolicGrup.longValue());
                            //UtilidadesLog.debug("NUEVO cuadreDisponible = " + cuadreDisponible);
                        }
                    }else {
                        posicionesOferta = actualizaUnidadesAtender (posicionesOferta,grupoActual, new Long (0), oidOferta);
                    } 
                }
                /*UtilidadesLog.debug(" Cuadre Sobrante = " + cuadreDisponible);
                UtilidadesLog.debug(" el Cuadre Sobrante se lo agrego al primero del ranking ");
                UtilidadesLog.debug(" Voy Al Borrado ");*/
                posicionesOferta = this.borrarPosicionesSolicitudes(posicionesOferta, oidOferta ,rsGrupos, posicionesOfertaDigitada );
        
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.completarPaquetesO(ArrayList posicionesOferta, Long oidOferta, Long cuadre, ArrayList posicionesOfertaDigitada, boolean tipoDespacho): Salida");
        return posicionesOferta;          
    }
    
    /**
     * @author pperanzola
     * @date 19/08/2005
     * @return ArrayList
     * @param posicionesOfertaDigitada
     * @param rsGrupos
     * @param oidOferta
     * @param posicionesOferta
     */
    private ArrayList borrarPosicionesSolicitudes(ArrayList posicionesOferta, Long oidOferta , RecordSet rsGrupos, ArrayList posicionesOfertaDigitada) {
        UtilidadesLog.info("MONCuadrePromocionBean.borrarPosicionesSolicitudes(ArrayList posicionesOferta, Long oidOferta , RecordSet rsGrupos, ArrayList posicionesOfertaDigitada): Entrada");

        ArrayList posicionesOfertaRetorno = new ArrayList();
        //int rsGrupTamano =rsGrupos.getRowCount();
        int posicOfertamano = posicionesOferta.size();
        DTOPosicionSolicitud dtoTmp= null;
        DTOPosicionSolicitud dtoTmpDigit= null;
        
        int i;
        int j;
        int k;
        int posOferDigitTamano = posicionesOfertaDigitada.size();
        
        for (j = 0; j< posicOfertamano ; j++){
            dtoTmp = (DTOPosicionSolicitud) posicionesOferta.get(j);
            // Si el grupo es nulo se agrego en otro cuadre y no en promocion  por ende lo agrego directamente porque ya fue cuadrado
            // O si es de distinta oferta también pertenece a otro cuadre.
            if (dtoTmp.getOidOferta().longValue() == oidOferta.longValue()){
                 if (dtoTmp.getUnidadesPorAtender().longValue() == 0){
                        // Tengo que sacar todos los que tengan unidades por atender 0 y que fueron digitadas ... esas las dejo en 0
                        for (k =0; k< posOferDigitTamano; k++){
                            dtoTmpDigit = (DTOPosicionSolicitud) posicionesOfertaDigitada.get(k);
                            /*UtilidadesLog.debug(" dtoTmpDigit.getCodigoVenta()= " + dtoTmpDigit.getCodigoVenta() );
                            UtilidadesLog.debug(" dtoTmp.getCodigoVenta()= " + dtoTmp.getCodigoVenta() );*/
                            if(dtoTmpDigit.getCodigoVenta().equals(dtoTmp.getCodigoVenta())){
                                posicionesOfertaRetorno.add(dtoTmp); 
                            }
                        }
                 }else{
                    posicionesOfertaRetorno.add(dtoTmp);
                 }
            }else {
                posicionesOfertaRetorno.add(dtoTmp);
            }
        }

        UtilidadesLog.info("MONCuadrePromocionBean.borrarPosicionesSolicitudes(ArrayList posicionesOferta, Long oidOferta , RecordSet rsGrupos, ArrayList posicionesOfertaDigitada): Salida");
        return posicionesOfertaRetorno;
    }
    
  /**
   * @author pperanzola
   * @date 19/08/2005
   * @return ArrayList
   * @param grupoActual
   * @param posicionesOferta
   * @descripcion Actualiza las unidades a atender de un paquete (grupo)
   */    
    private ArrayList actualizaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta){
        UtilidadesLog.info("MONCuadrePromocionBean.actualizaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta): Entrada");
        int posicOfertamano = posicionesOferta.size();
        int j;
        DTOPosicionSolicitud dtoTmp = null;
        for (j=0; j < posicOfertamano; j++){
            dtoTmp = (DTOPosicionSolicitud) posicionesOferta.get(j);
            if (dtoTmp.getGrupo()!= null 
                && dtoTmp.getGrupo().longValue() == grupoActual.longValue()                
                && dtoTmp.getOidOferta().longValue() == oidOferta.longValue()){
                
                dtoTmp.setUnidadesPorAtender(numUnidadesA);
            }
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.actualizaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta): Salida");
        return posicionesOferta;
    }
    
    /**
     * @author pperanzola
     * @date 19/08/2005
     * @return ArrayList
     * @param grupoActual
     * @param posicionesOferta
     * Actualiza las unidades a atender de un paquete (grupo) con las unidadesPorAtender + numUnidadesA
     */
    private ArrayList completaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta){
        UtilidadesLog.info("MONCuadrePromocionBean.completaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta): Entrada");
        
        int posicOfertamano = posicionesOferta.size();
        int j;
        Long totalA;
        DTOPosicionSolicitud dtoTmp = null;
        for (j=0; j < posicOfertamano; j++){
            dtoTmp = (DTOPosicionSolicitud) posicionesOferta.get(j);
            if (dtoTmp.getGrupo()!= null 
                && dtoTmp.getGrupo().longValue() == grupoActual.longValue()
                && dtoTmp.getOidOferta().longValue() == oidOferta.longValue()){
                
                    totalA = new Long ( numUnidadesA.longValue() + dtoTmp.getUnidadesPorAtender().longValue());
                    dtoTmp.setUnidadesPorAtender(totalA);
            }
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.completaUnidadesAtender(ArrayList posicionesOferta, Long grupoActual, Long numUnidadesA, Long oidOferta): Salida");
        return posicionesOferta;
    }
    
  /**
   * @author pperanzola
   * @date 19/08/2005
   * @return Long
   * @param grupoActual
   * @param posicionesOferta
   * Busca la maxima unidad a atender
   */    
    private Long obtenerMaxUnidadesAtenderGrupo(ArrayList posicionesOferta, Long grupoActual, Long oidOferta){
        UtilidadesLog.info("MONCuadrePromocionBean.obtenerMaxUnidadesAtenderGrupo(ArrayList posicionesOferta, Long grupoActual, Long oidOferta): Entrada");
        
        DTOPosicionSolicitud dtoTmp = null;
        int posicOfertamano = posicionesOferta.size();;
        Long maxCuadreSolicGrup = new Long (0);
        int j;
        /*UtilidadesLog.debug(" grupoActual.longValue() =" + grupoActual.longValue());
        UtilidadesLog.debug(" oidOferta =" + oidOferta);*/
        for (j = 0; j < posicOfertamano; j++){
                dtoTmp = (DTOPosicionSolicitud) posicionesOferta.get(j);
                //UtilidadesLog.debug(" Grupo =" + dtoTmp.getGrupo());
                if (dtoTmp.getGrupo()!= null 
                    && dtoTmp.getGrupo().longValue() == grupoActual.longValue()
                    && dtoTmp.getOidOferta().longValue() == oidOferta.longValue()){
                    maxCuadreSolicGrup = new Long ( Math.max(dtoTmp.getUnidadesPorAtender().longValue()
                                                             ,maxCuadreSolicGrup.longValue()));
                }
        }
        //UtilidadesLog.debug(" maxCuadreSolicGrupFinal =" + maxCuadreSolicGrup);
        
        UtilidadesLog.info("MONCuadrePromocionBean.obtenerMaxUnidadesAtenderGrupo(ArrayList posicionesOferta, Long grupoActual, Long oidOferta): Salida");
        return maxCuadreSolicGrup;
    }
    
    /**
     * @author pperanzola 
     * @date 18/08/2005
     * @return 
     * @param posicionesOferta
     * @param tmGrupos
     */
    private ArrayList ordenaGruposSegunSolicitados(TreeMap tmGrupos, ArrayList posicionesOferta, Long oidOferta){
        UtilidadesLog.info("MONCuadrePromocionBean.ordenaGruposSegunSolicitados(TreeMap tmGrupos, ArrayList posicionesOferta, Long oidOferta): Entrada");
        
        int i;
        int j;
        int posicTamano = posicionesOferta.size();
        int grpTamano = tmGrupos.size();
        String codVta = null;
        Long numGrup = null;
        Long numGrupAConservar = null;
        ArrayList listadoGruposPosic= null;
        boolean blnEncontrado = false;
        DTOPosicionSolicitud dtoPosicion = null;
        for (j = grpTamano-1; j >= 0; j++){
            listadoGruposPosic = (ArrayList) tmGrupos.get(new Long(j));
            numGrup = (Long)listadoGruposPosic.get(0);
            codVta = (String) listadoGruposPosic.get(1);
            for (i = 0; i < posicTamano; i++){                
                dtoPosicion = (DTOPosicionSolicitud)posicionesOferta.get(i);
                if (dtoPosicion.getCodigoVenta().equals(codVta)){
                    blnEncontrado = true;
                    numGrupAConservar = numGrup;
                    break;
                }
            }
            if (blnEncontrado){
                break;
            }
        }
        for (j = 0; j < grpTamano; j++){
            listadoGruposPosic = (ArrayList) tmGrupos.get(new Long(j));
            numGrup = (Long)listadoGruposPosic.get(0);
            if (numGrup.equals(numGrupAConservar)){
                listadoGruposPosic.remove(j);
            }
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.ordenaGruposSegunSolicitados(TreeMap tmGrupos, ArrayList posicionesOferta, Long oidOferta): Salida");
        return listadoGruposPosic;        
    }    
    // FIN METODOS AGREGADOS POR PPERANZOLA
    /**
     * @author pperanzola 
     * @date 30/03/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param ofertas
     * obtiene todos los codigos de venta de un listado de ofertas 
     */
    private RecordSet obtieneProductosOfertas (String ofertas) throws MareException{ 
        UtilidadesLog.info("MONCuadrePromocionBean.obtieneProductosOfertas(String ofertas): Entrada");
        BelcorpService belcorpService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        String[] vOfertas = ofertas.split("#/#");
        int i;
        int canOfert = vOfertas.length;
        //UtilidadesLog.debug("cantOfertas = " + canOfert);
        
        query.append(" SELECT OFER_OID_OFER, VAL_CODI_VENT FROM PRE_OFERT_DETAL WHERE 1=1 ");
        query.append(" AND ( ");
        for (i = 0; i < canOfert ; i++ ){
            query.append(" OFER_OID_OFER IN ( " + vOfertas[i]  + " ) ");
            if (i+1 < canOfert){
                query.append(" OR ");
            }
        }
        query.append(" ) ");
        query.append(" ORDER BY OFER_OID_OFER ");
      
        try {
             rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
             throw me;
        } catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        UtilidadesLog.info("MONCuadrePromocionBean.obtieneProductosOfertas(String ofertas): Salida");
        return rs;
    }

     private ArrayList asignaCodigosVentaAOfertas(ArrayList listaOfertas, RecordSet rs) throws Exception {
        int cantReg = rs.getRowCount();
        Long ofertaActual;
        Long ofertaAnterior = new Long (0);
        ArrayList listaCodVentas = new ArrayList();
        Hashtable tablaOfertas = new Hashtable();
        int j;
        int i;
        for (i = 0 ; i <cantReg ; i++){
            ofertaActual = new Long(((BigDecimal) rs.getValueAt(i,"OFER_OID_OFER")).longValue());
            ofertaAnterior = ofertaActual;
            for (j = i; j < cantReg; j++){
                ofertaActual = new Long(((BigDecimal) rs.getValueAt(j,"OFER_OID_OFER")).longValue());              
                if (ofertaActual.equals(ofertaAnterior)){
                    listaCodVentas.add(listaCodVentas.size(),(String) rs.getValueAt(j,"VAL_CODI_VENT"));
                }else {
                    break;
                }
            }
            i = j-1;
            tablaOfertas.put(ofertaAnterior,listaCodVentas);
            listaCodVentas = new ArrayList();

        }
        
        int k;
        int cantOfer = listaOfertas.size();
        DTOOferta dtoTmpOfer;
        ArrayList listaTMP;
        for (i = 0; i < cantOfer; i++){
           dtoTmpOfer = (DTOOferta) listaOfertas.get(i);
           listaTMP = (ArrayList)tablaOfertas.get(dtoTmpOfer.getOidOferta());
           dtoTmpOfer.setListaCodVenta(listaTMP);
        }
        
        return listaOfertas;
     }

  private MONCuadreProductosHome getMONCuadreProductosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreProductos"), MONCuadreProductosHome.class);
  }

  private MONCuadreCompuestaVariableHome getMONCuadreCompuestaVariableHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONCuadreCompuestaVariableHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreCompuestaVariable"), MONCuadreCompuestaVariableHome.class);
  }

  private MONOfertaHome getMONOfertaHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONOfertaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOferta"), MONOfertaHome.class);
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

    private MONCuadreCompuestaVariableLocalHome getMONCuadreCompuestaVariableLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreCompuestaVariableLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreCompuestaVariable");
    }


    private MONRankingProductosLocalHome getMONRankingProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONRankingProductosLocalHome)context.lookup("java:comp/env/ejb/local/MONRankingProductos");
    }
}