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
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOPromocion;

import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class SeleccionSolicitudesPromocion  {
    private static UtilidadesLog logAux = new UtilidadesLog();
    public SeleccionSolicitudesPromocion() {
    }

    /**
      Recorremos las posiciones de la solicitud utilizando el contador numeroPosicion 
      { 
      DTOPosicionSolicitud = DTOCabeceraSolicitud.posiciones.get(numeroPosicion) 

      // Si la linea proviene de una promoción, no se evalua 
      Si DTOPosicionSolicitud.tipoEstrategia != (INDIVIDUAL_VS_GRUPO) AND DTOPosicionSolicitud.tipoEstrategia != (COMPUESTA_FIJA_VS_GRUPO) AND DTOPosicionSolicitud.tipoEstrategia != (COMPUESTA_VARIABLE_VS_GRUPO) 
      { 
      posicionValida = validarPromocion(DTOPromocion, DTOPosicionSolicitud) 

      // Si la posición es válida y además no pertenece a una promocion, se añade 
      Si posicionValida == True 
      { 
      listaPosiciones.add(DTOPosicionSolicitud) 
      } 
      } 
      }
      Devuelve listaPosiciones
    *
    *@autor jpbosnja
    * 
    * 31/03/06 - pperanzola - [2] mejoras de performance
    **/
    public ArrayList obtenerPosicionesCuadre(DTOPromocion dtoPromocion, DTOCabeceraSolicitud dtoCabeceraSolicitud, Long estrategia) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.obtenerPosicionesCuadre(DTOPromocion dtoPromocion, DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada");
        
        ArrayList listaPosiciones = new ArrayList();
        ///*[2]
        DTOPromocion dtoPromocionIncluidos = this.filtrarPromociones(dtoPromocion,false);
        DTOPromocion dtoPromocionExcluidos = this.filtrarPromociones(dtoPromocion,true);
        //*/[2]
        for ( int numeroPosicion = 0 ; dtoCabeceraSolicitud.getPosiciones().size()>numeroPosicion; numeroPosicion++){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud) dtoCabeceraSolicitud.getPosiciones().get(numeroPosicion);
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled())
                UtilidadesLog.debug("Codigo Venta:"+dtoP.getCodigoVenta()+" Tipo Estra:"+dtoP.getTipoEstrategia());
            
            // sapaza -- PER-SiCC-2011-0340 -- 16/05/2011
            if ((dtoP.getTipoEstrategia()!=null &&
                dtoP.getTipoEstrategia().intValue() != ConstantesPRE.INDIVIDUAL_VS_GRUPO &&
                dtoP.getTipoEstrategia().intValue() != ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO &&
                dtoP.getTipoEstrategia().intValue() != ConstantesPRE.COMPUESTA_VARIABLE_VS_GRUPO )
                || (estrategia != null && (estrategia.longValue()==2019 || estrategia.longValue()==2020)))
                {
                //Boolean posicionValida = validarPromocion(dtoPromocion, dtoP);                
                Boolean posicionValida = validarPromocion(dtoPromocionIncluidos, dtoP);
                if (posicionValida.booleanValue()){
                    if (this.validarPromocionExcluyente(dtoPromocionExcluidos,dtoP).equals(Boolean.TRUE)){
                        listaPosiciones.add(dtoP);
                    }
                }
            }
        }
        UtilidadesLog.info("SeleccionSolicitudesPromocion.obtenerPosicionesCuadre(DTOPromocion dtoPromocion, DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida");
        return listaPosiciones;
    }
    

   /**
    * @autor jpbosnja
    * @modificado pperanzola [1] se modifica para el caso en que solamente se define una promocion que no incluye nada
    **/
    private Boolean validarPromocion(DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPromocion(DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        if (dtoPromocion.getLineaPromocion().size()>0){ //[1]
            DTOLineaPromocion dtoLP = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().elementAt(0);
            Long catalogoActual = dtoLP.getOidCatalogo();
            Boolean posicionValida = validarLineasCatalogo(catalogoActual, dtoPromocion, dtoPosicionSolicitud, 0);
            if (posicionValida.booleanValue()==false){
                int numeroLinea = 1;
                for (;dtoPromocion.getLineaPromocion().size()>numeroLinea;numeroLinea++){
                    DTOLineaPromocion dtoLP2 = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().elementAt(numeroLinea);
                    if (catalogoActual != dtoLP2.getOidCatalogo()){
                        catalogoActual = dtoLP2.getOidCatalogo();
                        posicionValida = validarLineasCatalogo(catalogoActual, dtoPromocion, dtoPosicionSolicitud, numeroLinea);
                        if (posicionValida.booleanValue()){
                            UtilidadesLog.debug("Salida: SeleccionSolicitudesPromocion.validarPromocion");
                            return posicionValida;
                        }
                    } 
                }
            } 
            UtilidadesLog.info("Salida: SeleccionSolicitudesPromocion.validarPromocion");
            return posicionValida;
        }else {
            UtilidadesLog.info("Sale sin validar porque es una promocion que no incluye nada");
            return Boolean.FALSE;
        }
    }   

    /**
      Si DTOLineaPromocion.tipoRango == ConstantesPRE.LINEAS_NEGOCIO 
      posicionValida = validarLineaProductos(DTOLineaPromocion, DTOPosicionSolicitud) 

      sino 
      Si DTOLineaPromocion.tipoRango == ConstantesPRE.RANGO_PAGINAS 
      posicionValida = validarPaginas(DTOLineaPromocion, DTOPosicionSolicitud) 

      sino 
      Si DTOLineaPromocion.tipoRango == ConstantesPRE.PRODUCTOS 
      posicionValida = validarProductos(DTOLineaPromocion, DTOPosicionSolicitud) 

      Devuelve posicionValida 
    *
    *@autor jpbosnja
    **/
    private Boolean validarLineaPromocion(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaPromocion(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        Boolean posicionValida = null;
        if (dtoLineaPromocion.getTipoRango() == ConstantesPRE.LINEAS_NEGOCIO){
            posicionValida = validarLineaProductos(dtoLineaPromocion, dtoPosicionSolicitud);
        }else if (dtoLineaPromocion.getTipoRango() == ConstantesPRE.RANGO_PAGINAS){
            posicionValida = validarPaginas(dtoLineaPromocion, dtoPosicionSolicitud);
        }else if (dtoLineaPromocion.getTipoRango() == ConstantesPRE.PRODUCTOS){
            posicionValida = validarProducto(dtoLineaPromocion, dtoPosicionSolicitud);
        }
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaPromocion(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Salida");
        return posicionValida;
    }

    /**
      Si lineaPromocion.indicadorExclusion == False 
      { 
      Si posicionSolicitud.lineaProducto == lineaPromocion.valorDesde 
      Devuelve True 
      sino 
      Devuelve False 
      } 
      sino 
      { 
      Si posicionSolicitud.lineaProducto != lineaPromocion.valorDesde 
      Devuelve True 
      sino 
      Devuelve False 
      }
    *
    *@autor jpbosnja
    **/
    /*
     * Autor: Cortaberría
     * Fecha: 01/06/2005
     * Se agrega validación de que no sea null, debido a incidencia BELC300015597
     */
    private Boolean validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        /*UtilidadesLog.debug("       Producto = " + dtoPosicionSolicitud.getProducto());
        UtilidadesLog.debug("       ValorDesde = " + dtoLineaPromocion.getValorDesde());
        UtilidadesLog.debug("       IndicadorExclusion = " + dtoLineaPromocion.getIndicadorExclusion());*/

        if (dtoLineaPromocion.getIndicadorExclusion()!=null && Boolean.FALSE.equals(dtoLineaPromocion.getIndicadorExclusion())){
            //if (dtoPosicionSolicitud.getLineaProducto().longValue() == Long.valueOf(dtoLineaPromocion.getValorDesde()).longValue()){
            if ( dtoLineaPromocion.getValorDesde() != null && 
                  Long.valueOf(dtoLineaPromocion.getValorDesde()).equals(dtoPosicionSolicitud.getLineaProducto())){
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1F: Salida");
                return Boolean.FALSE;
            }
        }else{
            //if (dtoPosicionSolicitud.getLineaProducto().longValue() != Long.valueOf(dtoLineaPromocion.getValorDesde()).longValue()){
            if ( dtoLineaPromocion.getValorDesde() != null && 
                  !Long.valueOf(dtoLineaPromocion.getValorDesde()).equals(dtoPosicionSolicitud.getLineaProducto())){            
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineaProductos(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2F: Salida");
                return Boolean.FALSE;
            }
        }
    }

    /**
      Si lineaPromocion.indicadorExclusion == False 
      { 
      Si posicionSolicitud.producto == lineaPromocion.valorDesde 
      Devuelve True 
      sino 
      Devuelve False 
      } 
      sino 
      { 
      Si posicionSolicitud.producto != lineaPromocion.valorDesde 
      Devuelve True 
      sino 
      Devuelve False 
      }
    *
    *@autor jpbosnja
    **/
    private Boolean validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        /*UtilidadesLog.debug("       Producto = " + dtoPosicionSolicitud.getProducto());
        UtilidadesLog.debug("       ValorDesde = " + dtoLineaPromocion.getValorDesde());
        UtilidadesLog.debug("       IndicadorExclusion = " + dtoLineaPromocion.getIndicadorExclusion());*/
        
        if (dtoLineaPromocion.getIndicadorExclusion()!=null && dtoLineaPromocion.getIndicadorExclusion().booleanValue()==false){
            if (dtoPosicionSolicitud.getProducto()!=null &&
            (dtoPosicionSolicitud.getProducto().longValue() == Long.valueOf(dtoLineaPromocion.getValorDesde()).longValue())){
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1F: Salida");
                return Boolean.FALSE;
            }
        }else{
            if (dtoPosicionSolicitud.getProducto()!=null && (dtoPosicionSolicitud.getProducto().longValue() != Long.valueOf(dtoLineaPromocion.getValorDesde()).longValue())){                
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarProducto(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2F: Salida");
                return Boolean.FALSE;
            }
        }
    }

    /**
      Si lineaPromocion.indicadorExclusion == False 
      { 
      Si posicionSolicitud.pagina >= lineaPromocion.valorDesde AND posicionSolicitud.pagina <= lineaPromocion.valorHasta 
      Devuelve True 
      sino 
      Devuelve False 
      } 
      sino 
      { 
      Si posicionSolicitud.pagina < lineaPromocion.valorDesde OR posicionSolicitud.pagina > lineaPromocion.valorHasta 
      Devuelve True 
      sino 
      Devuelve False 
      } 
    *
    *@autor jpbosnja
    **/
    private Boolean validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        /*UtilidadesLog.debug("       Producto = " + dtoPosicionSolicitud.getProducto());
        UtilidadesLog.debug("       Pagina = " +dtoPosicionSolicitud.getPagina());
        UtilidadesLog.debug("       ValorHasta = " + dtoLineaPromocion.getValorHasta());
        UtilidadesLog.debug("       ValorDesde = " + dtoLineaPromocion.getValorDesde());*/

        long desde = Long.valueOf(dtoLineaPromocion.getValorDesde()).longValue();
        long hasta = 0;
        if (dtoLineaPromocion.getValorHasta()!=null)
            hasta = Long.valueOf(dtoLineaPromocion.getValorHasta()).longValue();
        else
            hasta = desde;
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("Desde:"+desde+" Hasta:"+hasta+" Valor:"+dtoPosicionSolicitud.getPagina());
            
        if (dtoLineaPromocion.getIndicadorExclusion()!=null && dtoLineaPromocion.getIndicadorExclusion().booleanValue()==false){
            if (dtoPosicionSolicitud.getPagina()!=null && 
                dtoPosicionSolicitud.getPagina().longValue() >= desde &&
                dtoPosicionSolicitud.getPagina().longValue() <= hasta){
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)1F: Salida");
                return Boolean.FALSE;
            }
        }else{
            if (dtoPosicionSolicitud.getPagina()!=null && 
                (dtoPosicionSolicitud.getPagina().longValue() < desde ||
                dtoPosicionSolicitud.getPagina().longValue() > hasta )){
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2T: Salida");
                return Boolean.TRUE;
            }else{
                UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPaginas(DTOLineaPromocion dtoLineaPromocion, DTOPosicionSolicitud dtoPosicionSolicitud)2F: Salida");
                return Boolean.FALSE;
            }
        }
    }

    /**
      // Si la posición de la solicitud es de otro catálogo, no se aplica la promoción 
      Si DTOPosicionSolicitud.catalogo != catalogoActual 
      Devuelve False 

      DTOLineaPromocion = DTOPromocion.elementAt(numeroLinea) 
      tipoRangoActual = DTOLineaPromocion.tipoRango 

      posicionValida = validarLineasTipoRango(catalogoActual, tipoRangoActual, DTOPromocion, DTOPosicionSolicitud, numeroLinea) 

      Si posicionValida == False 
      Devuelve False 

      numeroLinea = numeroLinea + 1 
      Recorremos las lineas de la promocion utilizando el contador numeroLinea (desde numeroLinea a DTOPromocion.lineaPromocion.size()) 
      { 
      DTOLineaPromocion = DTOPromocion.elementAt(numeroLinea) 

      Si (DTOLineaPromocion.oidCatalogo == catalogoActual) AND (DTOLineaPromocion.tipoRango != tipoRangoActual) 
      { 
      tipoRangoActual = DTOLineaPromocion.tipoRango 
      posicionValida = validarLineasTipoRango(catalogoActual, tipoRangoActual, DTOPromocion, DTOPosicionSolicitud, numeroLinea) 
      Si posicionValida == False 
      Devuelve False 
      } 
      } 

      Devuelve posicionValida
    *
    *@autor jpbosnja
    **/
    private Boolean validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea): Entrada");
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug(" Datos Entrada: catalogoActual: "+catalogoActual+" dtoPosicionSolicitud.getCatalogo():"+dtoPosicionSolicitud.getCatalogo());
        
        if (dtoPosicionSolicitud.getCatalogo()!=null && !dtoPosicionSolicitud.getCatalogo().equals(catalogoActual)){
            UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea)1T: Salida");
            return Boolean.FALSE;
        }
        DTOLineaPromocion dtoLP = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().elementAt(numeroLinea);
        char tipoRangoActual = dtoLP.getTipoRango();

        Boolean posicionValida = validarLineasTipoRango(catalogoActual, tipoRangoActual, dtoPromocion, dtoPosicionSolicitud, numeroLinea);

        if (posicionValida.booleanValue() == false){
            UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea)2F: Salida");
            return Boolean.FALSE;
        }
        UtilidadesLog.debug(" Incrementa numeroLinea++");
        numeroLinea++;
        for (;dtoPromocion.getLineaPromocion().size()>numeroLinea;numeroLinea++){
            dtoLP = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().elementAt(numeroLinea);
            if (dtoLP.getOidCatalogo().longValue()==catalogoActual.longValue() &&
                dtoLP.getTipoRango() != tipoRangoActual){
                tipoRangoActual = dtoLP.getTipoRango();
                posicionValida = validarLineasTipoRango(catalogoActual, tipoRangoActual, dtoPromocion, dtoPosicionSolicitud, numeroLinea);
                if (posicionValida.booleanValue()==false){
                    UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea)3F: Salida");
                    return Boolean.FALSE;
                }
            }
        }
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("Datos Salida: SeleccionSolicitudesPromocion.validarLineasCatalogo --> "+posicionValida);
        
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasCatalogo(Long catalogoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea): Salida");
        return posicionValida;
    }

    /**
      Recorremos las lineas de la promocion (desde numeroLinea a DTOPromocion.lineaPromocion.size()) 
      { 
      DTOLineaPromocion = DTOPromocion.elementAt(numeroLinea) 
      catalogo = DTOLineaPromocion.oidCatalogo 
      tipoRango = DTOLineaPromocion.tipoRango 

      Si (catalogo == catalogoActual) AND (tipoRango == tipoRangoActual) 
      { 
      posicionValida = validarLineaPromocion(DTOLineaPromocion, DTOPosicionSolicitud) 
      Si posicionValida == True 
      { 
      Devuelve True 
      } 
      } 
      } 

      Devuelve False
    *
    *@autor jpbosnja
    **/
    private Boolean validarLineasTipoRango(Long catalogoActual, char tipoRangoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasTipoRango(Long catalogoActual, char tipoRangoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea): Entrada");
        
        for (;dtoPromocion.getLineaPromocion().size()>numeroLinea;numeroLinea++){
            DTOLineaPromocion dtoLP = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().elementAt(numeroLinea);
            Long catalogo = dtoLP.getOidCatalogo();
            char tipoRango = dtoLP.getTipoRango();

            if(catalogo.longValue() == catalogoActual.longValue() && tipoRango == tipoRangoActual){ 
                Boolean posicionValida = validarLineaPromocion(dtoLP, dtoPosicionSolicitud);
                if (posicionValida.booleanValue()){
                    UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasTipoRango(Long catalogoActual, char tipoRangoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea)T: Salida");
                    return Boolean.TRUE;
                }
            }
        }
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarLineasTipoRango(Long catalogoActual, char tipoRangoActual, DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud, int numeroLinea)F: Salida");
        return Boolean.FALSE;
    }
    
    //##################### METODOS AGREGADOS POR PPERANZOLA ####################################
    /**
     * 
     * @date 22/08/2005
     * @throws java.lang.Exception
     * @return Boolean
     * @param dtoPosicionSolicitud
     * @param dtoPromocion
     * @author pperanzola 
     * El método se encarga de recorrer el dtoPromocion que recibe como parámetro
     * sólo que el dto sólo contiene promociones con el flag de exclusión en true
     */
    private Boolean validarPromocionExcluyente(DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud) throws Exception{
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPromocionExcluyente(DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Entrada");
        
        int i = 0;
        int cantLineaPromociones = dtoPromocion.getLineaPromocion().size();
        Boolean posicionValida = null;
        DTOLineaPromocion dtoLP = null;
        //UtilidadesLog.debug("cantLineaPromociones = " + cantLineaPromociones);
        for (i =0; i < cantLineaPromociones; i++){
            dtoLP = (DTOLineaPromocion) dtoPromocion.getLineaPromocion().get(i);
            //UtilidadesLog.debug("TipoRango = " + dtoLP.getTipoRango());
            if (dtoLP.getTipoRango() == ConstantesPRE.LINEAS_NEGOCIO){
                posicionValida = validarLineaProductos(dtoLP, dtoPosicionSolicitud);
            }else if (dtoLP.getTipoRango() == ConstantesPRE.RANGO_PAGINAS){
                posicionValida = validarPaginas(dtoLP, dtoPosicionSolicitud);
            }else if (dtoLP.getTipoRango() == ConstantesPRE.PRODUCTOS){
                posicionValida = validarProducto(dtoLP, dtoPosicionSolicitud);
            }
            if (posicionValida.equals(Boolean.FALSE)){
                // Encontro 1 linea de la promoción que la excluye
                //UtilidadesLog.debug("Sale false porque Encontro 1 linea de la promoción que la excluye");
                return Boolean.FALSE;
            }
        }
        // Ninguna linea excluye la posicion
        UtilidadesLog.info("SeleccionSolicitudesPromocion.validarPromocionExcluyente(DTOPromocion dtoPromocion, DTOPosicionSolicitud dtoPosicionSolicitud): Salida");        
        return Boolean.TRUE;
    }
    /**
   * @Autor: Emilio Noziglia
   * @Fecha : 22/08/2005
   * @Recibe: DTOPromocion dtoAFiltrar, boolean exclusion
   * @Retorna: DTOPromocion filtrado 
   * @Descripción: filtra las las lineas de promocion indicadas por parametro con indicador de
   *               exclusion en true o en false.
   */ 
    private DTOPromocion filtrarPromociones(DTOPromocion dtoAFiltrar, boolean exclusion){
      UtilidadesLog.info("SeleccionSolicitudesPromocion.filtrarPromociones(DTOPromocion dtoAFiltrar, boolean exclusion): Entrada");
    
      //UtilidadesLog.debug("Datos Entrada: exclusion en:"+exclusion);
      Vector lineasFiltradas = new Vector();
      DTOPromocion dtoRes = new DTOPromocion();
      dtoRes.setDescripcionIndicadorCuadre(dtoAFiltrar.getDescripcionIndicadorCuadre());
      dtoRes.setFactorCuadre(dtoAFiltrar.getFactorCuadre());
      dtoRes.setNumeroCondicion(dtoAFiltrar.getNumeroCondicion());
      dtoRes.setOidIndicadorCuadre(dtoAFiltrar.getOidIndicadorCuadre());
      dtoRes.setOidPromocion(dtoAFiltrar.getOidPromocion());
      dtoRes.setOidPais(dtoAFiltrar.getOidPais());
      dtoRes.setOidIdioma(dtoAFiltrar.getOidIdioma());      
      for (int i=0; i<dtoAFiltrar.getLineaPromocion().size();i++){
        DTOLineaPromocion dtoLP = (DTOLineaPromocion)dtoAFiltrar.getLineaPromocion().elementAt(i);
        if (((dtoLP.getIndicadorExclusion()!=null)&&(dtoLP.getIndicadorExclusion().booleanValue()==exclusion))||
            ((dtoLP.getIndicadorExclusion()==null)&&(exclusion==false))){
            lineasFiltradas.add(dtoLP);
        }
      }
      dtoRes.setLineaPromocion(lineasFiltradas);
      
      UtilidadesLog.info("SeleccionSolicitudesPromocion.filtrarPromociones(DTOPromocion dtoAFiltrar, boolean exclusion): Salida");
      return dtoRes;    
    }
    
    //##################### FIN METODOS AGREGADOS POR PPERANZOLA ####################################

}