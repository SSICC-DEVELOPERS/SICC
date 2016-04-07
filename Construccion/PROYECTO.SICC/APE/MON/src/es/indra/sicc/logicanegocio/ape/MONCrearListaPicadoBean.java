/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelBusqueda;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOGenerarSecuencia;

import es.indra.sicc.dtos.ape.DTOSublineaZonas;

import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOProcesoFueraPedido;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.ape.DTODatosLinea;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.logicanegocio.intsys.MONINTPTL;
import es.indra.sicc.logicanegocio.intsys.MONINTPTLHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.sql.Date;

import es.indra.sicc.dtos.ape.DTOListaPicadoCabeceraFacturacion;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalleFacturacion;
import java.util.HashMap;
import es.indra.sicc.dtos.ape.DTOCajaListaPicado;
import es.indra.sicc.dtos.ape.DTOEtiqueta;

import java.util.Arrays;
import java.util.TreeSet;

public class MONCrearListaPicadoBean implements SessionBean 
{
    private DTOListaPicadoCabecera listaPicadoCabecera;
    private ArrayList lstProcesoFueraPedido;
    private DTODatosLinea datosLinea;
    private DTOConfiguracionCentroDistribucion configuracionCD;
    private DTOFACConsolidado consolidado;
    private String secuencia;
    private SessionContext ctx;
    private UtilidadesLog log = new UtilidadesLog();
    
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
     * Descripción: Para el consolidado recibido crea la 
     * lista de picado correspondiente. 
     * Activación: Desde el caso de uso Arrancar Facturación (FAC)
     * @author gpons
     * @since 03-07-2007
     * 
     * CHANGELOG
     * ---------
     * dmorello, 15/10/2008
     *   - Se elimina la recuperacion de datos de Mapa CD ya que no es necesaria
     *   - Se modifica el manejo de la variable datosLinea
     */
    public void crearListaPicado(DTOFACConsolidado consolidado) throws MareException {
           UtilidadesLog.info("MONCrearListaPicadoBean.crearListaPicado(DTOFACConsolidado consolidado): Entrada");
           
           this.lstProcesoFueraPedido = new ArrayList();
           
             this.consolidado = consolidado;
             
             if(log.isInfoEnabled())
               UtilidadesLog.info("DTOFACConsolidado: " +  this.consolidado);
    
             //Obtenemos datos relativos al Centro de Ditribución 
             DAOCrearListaPicado daoCrearListaPicado = new DAOCrearListaPicado();
             this.configuracionCD = daoCrearListaPicado.obtenerConfiguracionCD(consolidado.getDtoCabecera().getAlmacen());

             //Si no se recuperan datos del CD finaliza el tratamiento del consolidado 
             if (this.configuracionCD == null) { 
                 UtilidadesLog.info("No se recuperan datos del CD: finaliza el tratamiento del consolidado"); 
                 return;
             } 

             if(log.isInfoEnabled())
               UtilidadesLog.info("this.configuracionCD: " +  this.configuracionCD);        
             
             //Obtenemos los datos del mapa de zonas y del de CD 
             Long oidIdioma =  RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
            
            //Obtenemos datos de la línea 
            this.datosLinea = daoCrearListaPicado.obtenerDatosLinea(this.configuracionCD.getOidCentroDistribucion(), 
                                    consolidado.getDtoCabecera().getTipoSolicitud(), this.consolidado.getDtoCabecera().getPeriodo(),
                                    oidIdioma, consolidado.getDtoCabecera().getOidCabeceraSolicitud(), this.configuracionCD.getAgrupacionOlas()); 

            if(log.isInfoEnabled())
              UtilidadesLog.info("this.datosLinea: " +  this.datosLinea);                 
            //Si la línea no pertenece al mapa obtenido anteriormente se registra el error 
            
            if(this.datosLinea != null && this.datosLinea.getOidLinea() == null){ 
                LogAPP.error("No existe mapa activo para facturación");
                return;
            } else if (this.datosLinea == null) {
                LogAPP.error("*** ERROR - No existe linea no AFP para el CD " + this.configuracionCD.getDescripcion());
                UtilidadesLog.info("MONCrearListaPicadoBean.crearListaPicado(DTOFACConsolidado consolidado): Salida");           
                return;
            }
            
             //Preparamos los productos para pasarselos al CU seleccionar anaquel 
             ArrayList listaProductos = obtenerListaProductos(); 
             
             if(listaProductos.size()==0) {
                UtilidadesLog.info("No hay productos con Indicador Producto Servicio <> S (servicio)");          
                return;  
             }

             /* dmorello, 17/07/2007: Se usa la interfaz local del MONSeleccionarAnaquel */
             MONSeleccionarAnaquelLocal monSeleccionarAnaquel = null;
             
             //Por cada DTOAsignacionProductoAnaquelBusqueda en listaProductos
             Iterator it1 = listaProductos.iterator();
             while (it1.hasNext()) {
               
               DTOAsignacionProductoAnaquelBusqueda dtoAsignacionProductoAnaquelBusqueda = (DTOAsignacionProductoAnaquelBusqueda)it1.next();
               
               if(log.isInfoEnabled())
                 UtilidadesLog.info("dtoAsignacionProductoAnaquelBusqueda: " +  dtoAsignacionProductoAnaquelBusqueda);                 

               //Llamar a MONSeleccionarAnaquel.seleccionarAnaquel pasandole el DTO. 
               if (monSeleccionarAnaquel == null) {
                  monSeleccionarAnaquel = this.getMONSeleccionarAnaquelLocal();
               }
               
               DTOProcesoFueraPedido dtoProcesoFueraPedido = null;
               dtoProcesoFueraPedido = monSeleccionarAnaquel.seleccionarAnaquel(dtoAsignacionProductoAnaquelBusqueda);

               if(log.isInfoEnabled())
                 UtilidadesLog.info("dtoProcesoFueraPedido: " +  dtoProcesoFueraPedido);                 
               
                 if (dtoProcesoFueraPedido == null){
                    /* BELC400000538 - dmorello, 03/07/2007
                     * Si el DTO es nulo, se pasa al siguiente producto */
                    continue;
                    //continue cicloConsolidados;
                 }
                 // Agregar el DTO recibido a lstProcesoFueraPedido  
                 this.lstProcesoFueraPedido.add(dtoProcesoFueraPedido);
                 
             }
             
             /* BELC400000538 - dmorello, 03/07/2007
              * Si no hay productos para procesar, se pasa al sig. consolidado */
             if (this.lstProcesoFueraPedido.isEmpty()) {
                Long numCons = this.consolidado.getDtoCabecera().getNumeroSolicitud();
                LogAPP.error("El consolidado " + numCons + " fallo en la asignación de anaqueles y no se ha podido procesar");
                return;
             }
             
             /* dmorello, 17/07/2007: Se utiliza la interfaz local del MONProcesoFueraPedido */
             MONProcesoFueraPedidoLocal monProcesoFueraPedido = getMONProcesoFueraPedidoLocal();
             
             this.lstProcesoFueraPedido = monProcesoFueraPedido.procesarFueraPedido (this.lstProcesoFueraPedido );

            //Calculamos la secuencia de la lista de picado 
             crearSecuencia();
             
            //Armamos el DTOListaPicadoCabecera con sus detalles para pasarlo a los siguientes métodos. 
            armarListaPicado();
            
            /* dmorello, 28/06/2007: Se llama al CU solo si hay productos "no fuera de pedido"
             * Idem para el ordenamiento (si no hay productos no hay detalles que ordenar) */
            if (this.lstProcesoFueraPedido.size() > 0) {
                //Llamar al CU Calcular Cubicaje
                calcularCubicaje();

                //Ordenamos la lista de Picado
                ordenarListaPicadoDetalle();

                //SCS -07-08-07 
                //Grabamos la lista de Picado
                grabarListaPicado(consolidado);
            }
            
            /* dmorello, 28/06/2007: Se llama al CU solo si hay productos "no fuera de pedido" */
            if (this.lstProcesoFueraPedido.size() > 0) {
                //Llamamos al CU Generar Etiquetas
                generarEtiquetas(); 
            }

           UtilidadesLog.info("MONCrearListaPicadoBean.crearListaPicado(DTOFACConsolidado consolidado): Salida");           
    }


    /**
     * Descripción: 
     * Crea la secuencia como la concatenación del código de sublínea y el id de zona, 
     * sin repetir el par código ID y ordenado por estos dos campos. 
     * 
     * @author gpons
     * @since 14-05-2007
     * 
     * CHANGELOG
     * ---------
     * 03/09/2009 - dmorello, Cambio 20090839
     *     Se reemplaza en la secuencia el codigo de la sublinea por su letra para anaquel
     * 18/11/2009 - dmorello, Incidente RI 20091777
     *     Se ordena la secuencia por letra para anaquel de la sublinea
     */
    public void crearSecuencia() throws MareException {
         UtilidadesLog.info("MONCrearListaPicadoBean.crearSecuencia(): Entrada");
         
         /* dmorello, 11/07/2007 */
         this.setSecuencia("");         
         //Crear una lista listaSecuencia 
         Hashtable listaSecuencia = new Hashtable();
         String keyHash;
    
         //Por cada dto en lstProcesoFueraPedido{ 
         Iterator it = this.lstProcesoFueraPedido.iterator();
         while (it.hasNext()){
               //Crear un DTOGenerarSecuencia con dto.codigoSublinea y dto.idZona y 
               //agregarlo manera tal que la lista quede ordenada por código de sublínea e idZona,
               //sin duplicados. 
               DTOProcesoFueraPedido dtoProcesoFueraPedido = (DTOProcesoFueraPedido)it.next();
             
               DTOGenerarSecuencia dtoGenerarSecuencia = new DTOGenerarSecuencia();

               dtoGenerarSecuencia.setCodigoSublinea(dtoProcesoFueraPedido.getCodigoSublinea());                
               dtoGenerarSecuencia.setOidZona(dtoProcesoFueraPedido.getIdZona());           

               // La clave pasa a ser la letra para anaquel, que es unica por CD                        
               keyHash = dtoProcesoFueraPedido.getLetraParaAnaquel().trim();                          
                          
               UtilidadesLog.info("keyHash: " + keyHash + ", con Zona: " + dtoProcesoFueraPedido.getIdZona());
               
               if (listaSecuencia.get(keyHash) == null){
                   ArrayList listaSublineaZona = new ArrayList();
                   
                   DTOSublineaZonas dtoSublineaYZonas = new DTOSublineaZonas();
                   dtoSublineaYZonas.setOidSublinea(dtoProcesoFueraPedido.getCodigoSublinea());
                   dtoSublineaYZonas.setLetraParaAnaquel(dtoProcesoFueraPedido.getLetraParaAnaquel()); // Cambio 20090839
                   
                   UtilidadesLog.info("no esta la key, adhiero: " + dtoGenerarSecuencia);
                   
                   listaSublineaZona.add(dtoGenerarSecuencia);
                   dtoSublineaYZonas.setZonas(listaSublineaZona);
                   
                   listaSecuencia.put(keyHash, dtoSublineaYZonas);
               } else {
                   //esta, pero para esa sublinea, la zona esta?
                   UtilidadesLog.info("esta la key, veo si esta en zonas, la zona: " + dtoGenerarSecuencia.getOidZona());
                   DTOSublineaZonas dtoSZ = (DTOSublineaZonas)listaSecuencia.get(keyHash);
                   ArrayList arrayZonasParaSublinea = dtoSZ.getZonas();
                   
                   //si la zona que leo no esta en el array para la key, metola
                   if (!noEstaEnArray(arrayZonasParaSublinea, dtoGenerarSecuencia.getOidZona())) {
                       UtilidadesLog.info("adhiero!!");
                       arrayZonasParaSublinea.add(dtoGenerarSecuencia);
                   }
                   dtoSZ.setZonas(arrayZonasParaSublinea);
                   listaSecuencia.put(keyHash, dtoSZ);
                   
               }
               //listaSecuencia.add(dtoGenerarSecuencia);
         }
         //Recorrer listaSecuencia
         UtilidadesLog.debug("Recorrer listaSecuencia");
         UtilidadesLog.debug("----------------------------------------------");
         
         // Para que las claves se obtengan en orden con el iterador
         TreeSet keys = new TreeSet();
         keys.addAll(listaSecuencia.keySet());
         
         Iterator it1 = keys.iterator();
         int zonasParaSubLineaSize = 0;
         
         int iteraccionesSublinea=0;
         int iteraccionesZonas=0;
         int cantSublineasDiff = listaSecuencia.size();
         UtilidadesLog.debug("la hash, mide: " + cantSublineasDiff);
         String barra = "/";
         String guion = "-";
         String dosPuntos = ":";
         while (it1.hasNext()){
            DTOSublineaZonas dtoSZ = (DTOSublineaZonas)listaSecuencia.get(it1.next());
            this.setSecuencia(this.getSecuencia() + dtoSZ.getLetraParaAnaquel() + dosPuntos); // Cambio 20090839
            ArrayList zonasParaSubLinea = dtoSZ.getZonas();
            zonasParaSubLineaSize = zonasParaSubLinea.size();
            
            Collections.sort(zonasParaSubLinea, new ZonasComparator());
            
            DTOGenerarSecuencia linea = null;
            UtilidadesLog.debug("zonas por sub-linea mide: " + zonasParaSubLineaSize);
            iteraccionesZonas=0;
            for (int i = 0; i < zonasParaSubLineaSize; i++) {
                linea=(DTOGenerarSecuencia)zonasParaSubLinea.get(i);
                UtilidadesLog.debug("dtoGenerarSecuencia: " + linea);
                this.setSecuencia(this.getSecuencia() + normalizoDosDigitos(linea.getOidZona().toString().trim()));
                iteraccionesZonas++;
                if (iteraccionesZonas<zonasParaSubLineaSize)
                    this.setSecuencia(this.getSecuencia() + guion);
            }
            iteraccionesSublinea++;
            if (iteraccionesSublinea<cantSublineasDiff)
                this.setSecuencia(this.getSecuencia() + barra);
         }
         UtilidadesLog.debug("secuencia a retornar antes de ordenamiento producto : " + this.getSecuencia());
          //SB RI SICC 20091777 ORDEN POR producto              
            Long ordenAscDesc =this.configuracionCD.getOrdenAscDesc();
            String cadena="";
            if(ordenAscDesc!=null){
             String codigoOrdenAscDesc = new DAOCrearListaPicado().obtenerCodigoOrdenAscDescProd(ordenAscDesc.longValue());
             String [] arrSec = this.getSecuencia().split("/");
             if(arrSec!=null && arrSec.length>0){
               List listSecuencia = Arrays.asList(arrSec);
               Collections.sort(listSecuencia);//orden natural
                 if("A".equals(codigoOrdenAscDesc)){
                    Iterator ite = listSecuencia.iterator();
                    int k=0;
                     while(ite.hasNext()){
                             if(k==listSecuencia.size()-1)
                                     cadena+=(String)ite.next();
                             else
                                     cadena+=(String)ite.next()+"/";
                             k++;
                     }                                                  
                 
                 }else{//ordenmaiento descendente
                     for(int j= listSecuencia.size()-1;j>=0;j--){
                        if(j==0)
                            cadena+=(String)listSecuencia.get(j);
                        else
                            cadena+=(String)listSecuencia.get(j)+"/";       
                     }  
                 }//end ordenamiento 
               }//end arr sec  
               if(cadena!=null && !cadena.equals(""))  this.setSecuencia(cadena);
             }//end orden asc desc       
         //
         UtilidadesLog.debug("secuencia a retornar despues de ordenamiento producto : " + this.getSecuencia());
         UtilidadesLog.info("MONCrearListaPicadoBean.crearSecuencia(): Salida");
    }
    
    private boolean noEstaEnArray(ArrayList arrayZonasParaSublinea, Long oidZona) throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.noEstaEnArray(ArrayList arrayZonasParaSublinea, Long oidZona): Entrada");
        int mide = arrayZonasParaSublinea.size();
        DTOGenerarSecuencia linea = null;
        boolean retu = false;
        for (int i = 0; i < mide; i++) {
            linea=(DTOGenerarSecuencia)arrayZonasParaSublinea.get(i);
            if (linea.getOidZona().longValue()==oidZona.longValue()){
                UtilidadesLog.debug(oidZona + " esta en el array");
                return true;
            }    
        }
        UtilidadesLog.debug(oidZona + " no esta en el array");
        UtilidadesLog.info("MONCrearListaPicadoBean.noEstaEnArray(ArrayList arrayZonasParaSublinea, Long oidZona): Salida");
        return retu;
    }
    
    private String normalizoDosDigitos(String unaPos) {
        if (unaPos.length()==1){
            String cero = new String("0");
            return cero.concat(unaPos);
        }
        return unaPos;
    }
    
    /**
     * CHANGELOG
     * ---------
     * 13/10/2009 - dmorello, Cambio 20090839
     *    - Se agrega seteo de nuevo campo idZona en DTOListaPicadoDetalle
     */
    public void armarListaPicado() throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.armarListaPicado(): Entrada");
        ArrayList detalles = new ArrayList();
        
        // dmorello, 29/02/2008
        long unidadesTotalesLista = 0;  
        
        DTOListaPicadoDetalle dtoDetalle = null;
        int size = this.lstProcesoFueraPedido.size();
        for (int i = 0; i < size; i++) {
            DTOProcesoFueraPedido dto = (DTOProcesoFueraPedido)this.lstProcesoFueraPedido.get(i);
           
            UtilidadesLog.info("DTOProcesoFueraPedido: " + dto);
            
            dtoDetalle = new DTOListaPicadoDetalle();

            /*
             * valorLinea = posicion.precioTotalTL
             * (Buscar la posición para el oidProducto que estamos procesando)
             */
            ArrayList listaPos = this.consolidado.getListaPosiciones();
            DTOFACPosicionSolicitud dtoPos = this.buscarPosicionProducto(listaPos, dto.getOidProducto());            
            UtilidadesLog.info("dtoPos: " + dtoPos);
            
            dtoDetalle.setValorLinea(new BigDecimal(dtoPos.getPrecioTotalTL().toString()));
            
            dtoDetalle.setUnidadesProducto(dto.getNumeroUnidades());
            dtoDetalle.setOidMapaCDDetalle(dto.getOidMapaCDDetalle());
            dtoDetalle.setNumeroAnaquel(dto.getNumeroAnaquel());
            dtoDetalle.setOidProducto(dto.getOidProducto());
            dtoDetalle.setCodigoSAP(dto.getCodProducto());
            dtoDetalle.setOidSistemaPicado(dto.getOidSistemaPicado());
            dtoDetalle.setIndicadorImpresion(dto.getImpresion());
            dtoDetalle.setOidSentidoOrden(this.configuracionCD.getOrdenAscDesc());
            dtoDetalle.setOidOrdenLista(this.configuracionCD.getOrdenPedidoPicado());
            
            // sapaza -- Cambios para WCS y MUO -- 22/09/2010
            dtoDetalle.setCodigoSentidoOrden(this.configuracionCD.getCodigoOrdenAsDesc());
            dtoDetalle.setCodigoOrdenLista(this.configuracionCD.getCodigoOrdenPedidoPicado());
            dtoDetalle.setNumeroOrdenSubLinea(dto.getNumeroOrdenSubLinea());
            
            dtoDetalle.setIdZona(Integer.valueOf(dto.getIdZona().intValue())); // Cambio 20090839
            
            UtilidadesLog.info("dtoDetalle: " + dtoDetalle);
            
            detalles.add(dtoDetalle);
            
            // dmorello, 29/02/2008
            unidadesTotalesLista += dto.getNumeroUnidades().longValue();
        }
        
        
        DTOListaPicadoCabecera dtoCabecera = new DTOListaPicadoCabecera();
        DTOFACCabeceraSolicitud dtoCabeceraSolicitud = this.consolidado.getDtoCabecera();
        
        Long indRevision = dtoCabeceraSolicitud.getIndicadorRevision();
        dtoCabecera.setIndicadorChequeo(indRevision);
        
        if (indRevision != null) { // El indicadorRevision esta activo (debe ser 'L', 'C' o 'A')
            //Gpons - Inc. BELC400000464 
            //dtoCabecera.setIndicadorChequeo(new Boolean(indRevision != null));
            
            //if (dtoCabecera.getIndicadorChequeo()!= null ) {
            //    dtoCabecera.setTextoChequeo(this.configuracionCD.getTextoChequeos());
            //}
            dtoCabecera.setTextoChequeo(this.configuracionCD.getTextoChequeos());
            
            //Gpons - Inc. BELC400000459
            if (consolidado.getDtoCabecera().getOrigenChequeo() != null) { 
               dtoCabecera.setOrigenChequeo(consolidado.getDtoCabecera().getOrigenChequeo());
            } else {
               dtoCabecera.setOrigenChequeo(ConstantesAPE.CHEQUEO_EVALUACION_RECLAMOS);
            }
            //Fin Inc. BELC400000459
        } // fin if (indRevision != null)
        
        /* BELC400000547 - dmorello, 17/07/2007 */
        //dtoCabecera.setIndicadorImpresion(this.datosLinea.getImprimirListaPicado());
        /* Fin BELC400000547 dmorello 17/07/2007 */
        // dmorello, 29/02/2008
        //dtoCabecera.setNumeroUnidadesTotales(new Long(dtoCabeceraSolicitud.getUnidadesAtendidasTotal().intValue()));
        dtoCabecera.setNumeroUnidadesTotales(new Long(unidadesTotalesLista));
        // Fin dmorello 29/02/2008
        dtoCabecera.setImpreso(Boolean.FALSE);
        dtoCabecera.setOidConfiguracionCD(this.configuracionCD.getOidCentroDistribucion());
        dtoCabecera.setOidPeriodo(dtoCabeceraSolicitud.getPeriodo());
        dtoCabecera.setOidSolicitudCAbecera(dtoCabeceraSolicitud.getOidCabeceraSolicitud());
        dtoCabecera.setOidRegion(dtoCabeceraSolicitud.getRegion());
        dtoCabecera.setOidCliente(dtoCabeceraSolicitud.getOidCliente());
        dtoCabecera.setFechaFacturacion(new Timestamp(dtoCabeceraSolicitud.getFechaFacturacion().getTime()));
        // dmorello, 27/02/2008
        dtoCabecera.setFechaCreacion(new Date(System.currentTimeMillis()));
        // Fin dmorello, 27/02/2008
        dtoCabecera.setSecuencia(this.getSecuencia()); 
        dtoCabecera.setDetalles(detalles);
        dtoCabecera.setOidPais(dtoCabeceraSolicitud.getOidPais());
        dtoCabecera.setOidIdioma(dtoCabeceraSolicitud.getOidIdioma());
        
        DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
        dtoLineaArmado.setOid(this.datosLinea.getOidLinea());
        dtoCabecera.setLineaArmado(dtoLineaArmado);
        
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        Long oidCliente = dtoCabeceraSolicitud.getOidCliente();
        Boolean primerPedido = daoCL.verificarPrimerPedidoCliente(oidCliente);
        if (primerPedido.booleanValue()) {
            dtoCabecera.setTextoPrimerPedido(this.configuracionCD.getTextoPrimerPedido());
        }
         
        //Cambio APE-05
        dtoCabecera.setOidZona(dtoCabeceraSolicitud.getZona());
        dtoCabecera.setOidSeccion(dtoCabeceraSolicitud.getSeccion());
        //
         
        this.listaPicadoCabecera = dtoCabecera;

        UtilidadesLog.info("dtoCabecera: " + dtoCabecera);        
        UtilidadesLog.info("this.listaPicadoCabecera: " + this.listaPicadoCabecera);        
        UtilidadesLog.info("MONCrearListaPicadoBean.armarListaPicado(): Salida");
    }

    /**
     *   Descripción: 
     *   Calcula las unidades de cada producto y 
     *   recupera los campos necesarios para la invocación al CU seleccionar anaquel 
     * 
     * @author gpons
     * @since 14-05-2007
     * 
     * CHANGELOG
     * ---------
     * dmorello, 27/05/2008 - Incidencia 20080502 - Se considera producto fuera
     *                        de pedido el que tenga ind.dentro caja/bolsa = "F"
     *                        o "B"; dentro de pedido solo el que tenga "C".
     * dmorello, 15/10/2008 - Se toma el oidMapaCD de this.datosLinea al armar
     *                        el DTOAsignacionProductoAnaquelBusqueda
     */         
    public ArrayList obtenerListaProductos() throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.obtenerListaProductos(): Entrada");
        
        //Crear un HashTable listaProductos con oid de producto como clave y 
        //DTOAsignacionProductoAnaquelBusqueda como valor. 
        Hashtable listaProductos = new Hashtable();
     
        //Por cada posicion en consolidado.listaPosiciones
        Iterator it1 =  this.consolidado.getListaPosiciones().iterator();
        while(it1.hasNext()){
            DTOFACPosicionSolicitud dtoFACPosicionSolicitud = (DTOFACPosicionSolicitud) it1.next();
            
            UtilidadesLog.info("dtoFACPosicionSolicitud: " + dtoFACPosicionSolicitud);    

            DTOAsignacionProductoAnaquelBusqueda productoActualizar = (DTOAsignacionProductoAnaquelBusqueda)listaProductos.get(dtoFACPosicionSolicitud.getProducto());
            
            UtilidadesLog.info("productoActualizar: " + productoActualizar);    
            
            if (productoActualizar == null) {
                    // vbongiov -- RI 20080679 --3/09/2008
                    if(!dtoFACPosicionSolicitud.getIndicadorProductoServicio().equals(new Long("1"))){
                    
                        DTOAsignacionProductoAnaquelBusqueda dtoAsignacionProductoAnaquelBusqueda = 
                                             new DTOAsignacionProductoAnaquelBusqueda();
                        dtoAsignacionProductoAnaquelBusqueda.setOidLinea(this.datosLinea.getOidLinea());            
                        dtoAsignacionProductoAnaquelBusqueda.setOidMapaCDCabecera(this.datosLinea.getOidMapaCD());
                        dtoAsignacionProductoAnaquelBusqueda.setOidPeriodo(this.consolidado.getDtoCabecera().getPeriodo());
                        dtoAsignacionProductoAnaquelBusqueda.setOidProducto(dtoFACPosicionSolicitud.getProducto());
                        dtoAsignacionProductoAnaquelBusqueda.setOidCD(this.configuracionCD.getOidCentroDistribucion());
                        dtoAsignacionProductoAnaquelBusqueda.setOidTipoSolicitudPais(this.consolidado.getDtoCabecera().getTipoSolicitud());
                        dtoAsignacionProductoAnaquelBusqueda.setUnidades(dtoFACPosicionSolicitud.getUnidadesAtendidas());
                        
                        UtilidadesLog.debug("dtoFACPosicionSolicitud.getIndicadorProductoServicio: " + dtoFACPosicionSolicitud.getIndicadorProductoServicio());
                        
                        String indFueraCajaBolsa = dtoFACPosicionSolicitud.getIndicadorDentroFueraCajaBolsa();
                        // dmorello, 28/02/2008 - Se deben aceptar productos con indFueraCajaBolsa==null
                        //if (indFueraCajaBolsa != null && indFueraCajaBolsa.equals("F")) {
                        if ((indFueraCajaBolsa != null) && (indFueraCajaBolsa.equals("F") || indFueraCajaBolsa.equals(ConstantesMAE.BOLSA))) {
                            dtoAsignacionProductoAnaquelBusqueda.setIndFueraCajaBolsa(Boolean.TRUE);
                        } else {
                            dtoAsignacionProductoAnaquelBusqueda.setIndFueraCajaBolsa(Boolean.FALSE);
                        }
                        
                        //dtoAsignacionProductoAnaquelBusqueda.setIndFueraCajaBolsa(new Boolean(dtoFACPosicionSolicitud.getIndicadorDentroFueraCajaBolsa()));
                        dtoAsignacionProductoAnaquelBusqueda.setOidConsolidado(this.consolidado.getDtoCabecera().getOidCabeceraSolicitud());                
                        //dtoAsignacionProductoAnaquelBusqueda.setCodProducto(null); //Se rellena más adelante               
    
                        UtilidadesLog.info("dtoAsignacionProductoAnaquelBusqueda: " + dtoAsignacionProductoAnaquelBusqueda );                    
                        listaProductos.put(dtoAsignacionProductoAnaquelBusqueda.getOidProducto(),dtoAsignacionProductoAnaquelBusqueda);
                        UtilidadesLog.info("listaProductos.put: OK ");      
                    }
            }
            else {
                     Integer suma = new Integer(productoActualizar.getUnidades().intValue() + 
                                    dtoFACPosicionSolicitud.getUnidadesAtendidas().intValue());
                     productoActualizar.setUnidades(suma);
            }
        }

        //Completamos los códigos de producto de la lista 
        // vbongiov -- RI 20080679 --3/09/2008
        if(listaProductos.size()!=0) {
            //Armar una lista con todos los oids de la hash 
            //y con ella llamar al método DAOCrearListaPicado.obtenerCodigosProductos. 
            Enumeration oids = listaProductos.keys();
            DAOCrearListaPicado daoCrearListaPicado = new DAOCrearListaPicado();
            DTOSalida dtoSalida = daoCrearListaPicado.obtenerCodigosProductos(oids);
                
            Long oidProdu;
            String codSap;
            
            RecordSet rs = dtoSalida.getResultado();
            //Recorrer el RecordSet 
            for(int i=0;  i < rs.getRowCount(); i++){
                //Por cada elemento buscar en la hash el que se corresponda 
                //con el oid de producto y setearle al DTO asociado el código de producto. 
                oidProdu = new Long(((BigDecimal) rs.getValueAt(i, "OID_PROD")).longValue());
                codSap = (String) rs.getValueAt(i, "COD_SAP");
    
                UtilidadesLog.info("oidProdu: " + oidProdu );    
                UtilidadesLog.info("codSap: " + codSap);
                
                DTOAsignacionProductoAnaquelBusqueda dtoAsignacionProductoAnaquelBusqueda = (DTOAsignacionProductoAnaquelBusqueda) listaProductos.get(oidProdu);
                dtoAsignacionProductoAnaquelBusqueda.setCodProducto(codSap);
            }
        }

        UtilidadesLog.info("MONCrearListaPicadoBean.obtenerListaProductos(): Salida");
        //Devolver la lista de DTOs de la hash.
        return new ArrayList(listaProductos.values());
    }

    /**
     * CHANGELOG
     * ---------
     * 02/10/2009 - dmorello, Cambio 20090839
     *    - Se setean idZona y descripcionTipoCajaEmbalaje en los DTOListaPicadoDetalleFacturacion
     *    - Se setea longitudNumeroEtiqueta en el DTOListaPicadoCabeceraFacturacion
     *    - Se setea el nombre de la consultora en el DTOListaPicadoCabeceraFacturacion segun el valor
     *      del flag impresionDatosBasicos de la configuracion del CD
     * 18/11/2009 - dmorello, Incidente RI 20091777
     *    - Se setea tambien el codigo de la consultora en el DTOListaPicadoCabeceraFacturacion
     *      segun el valor del flag impresionDatosBasicos
     */
    public void grabarListaPicado(DTOFACConsolidado consolidado) throws MareException {

        UtilidadesLog.info("MONCrearListaPicadoBean.grabarListaPicado(): Entrada");
        
        Long oidCabecera = new Long(SecuenciadorOID.obtenerSiguienteValor("APE_LPCA_SEQ").longValue());
        StringBuffer queryCabecera = new StringBuffer();
        
            DTOListaPicadoCabecera dtoLista = this.listaPicadoCabecera;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            UtilidadesLog.debug("dtoLista cuando estoy por grabar: " + dtoLista);
        
            //scs, cargo dto, que es parte del dto fac consolidado, con todo lo que se persiste en
            // cabecera y detalle de lista picado, para luego imprimir la lista en el paq. docum.
            // dtoCabeceraListaPicado            
            // trapizonda esta, para llevar estos datos a la impresion del paq. doc. y puntualmente para laimpr de la L de P                           
            DTOListaPicadoCabeceraFacturacion dtoLPCF = new DTOListaPicadoCabeceraFacturacion();                                       
            dtoLPCF.setFechaCreacion(dtoLista.getFechaCreacion());
            dtoLPCF.setFechaFacturacion(new Date(dtoLista.getFechaFacturacion().getTime()));
            dtoLPCF.setNumeroUnidadesTotales(dtoLista.getNumeroUnidadesTotales());
            dtoLPCF.setOidConfiguracionCD(dtoLista.getOidConfiguracionCD());
            dtoLPCF.setOidLinea(this.datosLinea.getOidLinea());
            dtoLPCF.setOidPeriodo(dtoLista.getOidPeriodo());
            dtoLPCF.setOidRegion(dtoLista.getOidRegion());
            dtoLPCF.setOrigenChequeo(dtoLista.getOrigenChequeo());
            dtoLPCF.setSecuencia(dtoLista.getSecuencia());
            dtoLPCF.setTextoChequeo(dtoLista.getTextoChequeo());
            dtoLPCF.setTextoPrimerPedido(dtoLista.getTextoPrimerPedido());
            dtoLPCF.setVolumen(dtoLista.getVolumen()!=null?new Double(dtoLista.getVolumen().doubleValue()):null);
            dtoLPCF.setDescrLineaArmado(this.obtenerDescrLiArm(this.datosLinea.getOidLinea().longValue(),
                                                               consolidado.getOidIdioma().longValue()));
            dtoLPCF.setLongitudNumeroEtiqueta(this.obtenerLongitudNumeroEtiqueta(this.datosLinea.getOidLinea()));
            // Cambio 20090839
            UtilidadesLog.debug("*** flag impresion datos basicos: " + this.configuracionCD.getImpresionDatosbasicos());
            if (this.configuracionCD.getImpresionDatosbasicos() != null
                    && this.configuracionCD.getImpresionDatosbasicos().intValue() == 1) {
                dtoLPCF.setCodConsult(this.obtenerCogConsult(dtoLista.getOidCliente().longValue())); // RI 20091777
                dtoLPCF.setNomComplConsult(this.obtenerNombrComplConsult(dtoLista.getOidCliente().longValue()));    
            }
            // Fin cambio 20090839
            dtoLPCF.setDescrPeriodo(this.obtenerCodPeri(dtoLista.getOidPeriodo().longValue()));
            
            dtoLPCF.setCodBarr(obtenerCodBar(dtoLista.getOidSolicitudCAbecera().longValue()));
            dtoLPCF.setCodTerritorial(obtenerCodigoTerritorial(dtoLista.getOidSolicitudCAbecera().longValue()));
            
            dtoLPCF.setNumeroTotCaj(dtoLista.getNumeroTotalCajas());
                                                               
           
            queryCabecera.append("INSERT INTO APE_LISTA_PICAD_CABEC (OID_LIST_PICA_CABE ");
            if (dtoLista.getNumeroTotalCajas()!=null)
                queryCabecera.append(", NUM_TOTA_CAJA ");
            if (dtoLista.getSecuencia()!=null)
                queryCabecera.append(", VAL_SECU ");

            queryCabecera.append(", FEC_CREA ");
            queryCabecera.append(", FEC_FACTU ");

            if (dtoLista.getVolumen()!=null)
                queryCabecera.append(", NUM_VOLU ");
            if (dtoLista.getNumeroUnidadesTotales()!=null)
                queryCabecera.append(", NUM_UNID_TOTA ");
             
            queryCabecera.append(", IND_IMP1 ");

            if (dtoLista.getTextoChequeo()!=null)
                queryCabecera.append(", VAL_TEXT_CHEQ ");

            if (dtoLista.getTextoPrimerPedido()!=null)    
                queryCabecera.append(", VAL_TEXT_PRIM_PEDI ");

            queryCabecera.append(", PERD_OID_PERI ");

            if (dtoLista.getOidCliente()!=null)
                queryCabecera.append(", CLIE_OID_CLIE "); 

            queryCabecera.append(", CCDI_OID_CONF_CENT_DIST, LIAR_OID_LINE_ARMA ");

            if (dtoLista.getOidSolicitudCAbecera()!=null)
                queryCabecera.append(", SOCA_OID_SOLI_CABE ");

            if (dtoLista.getOidZona()!=null)
                queryCabecera.append(", ZZON_OID_ZONA ");
                
            if (dtoLista.getOidSeccion()!=null)
                queryCabecera.append(", ZSCC_OID_SECC ");


            queryCabecera.append(", ZORG_OID_REGI ");

            // Agregado - eiraola - 13/08/2007 [inicio]
            if (dtoLista.getIndicadorChequeo() != null) {
                queryCabecera.append(", INRE_OID_INDI_REVI ");
            }
            // Agregado - eiraola - 13/08/2007 [fin]

            if (dtoLista.getOrigenChequeo()!=null)
                queryCabecera.append(", IND_ORIG_CHEQ ");

            // sapaza -- Cambios para WCS y MUO -- 22/09/2010
            queryCabecera.append(", NUM_OLA ");

            queryCabecera.append(" ) VALUES (" + oidCabecera);

            if (dtoLista.getNumeroTotalCajas()!=null)
                queryCabecera.append(", " + dtoLista.getNumeroTotalCajas());    
            if (dtoLista.getSecuencia()!=null)
                queryCabecera.append(", '" + dtoLista.getSecuencia() + "' ");
            queryCabecera.append(", TO_DATE('" + df.format(dtoLista.getFechaCreacion()) + "','DD/MM/yyyy') ");
            queryCabecera.append(", TO_DATE('" + df.format(dtoLista.getFechaFacturacion()) + "','DD/MM/yyyy') ");

            if (dtoLista.getVolumen()!=null)
                queryCabecera.append(", " + dtoLista.getVolumen().doubleValue());
            if (dtoLista.getNumeroUnidadesTotales()!=null)
                queryCabecera.append(", " + dtoLista.getNumeroUnidadesTotales());

            queryCabecera.append(", 'N'");

            if (dtoLista.getTextoChequeo()!=null)
                queryCabecera.append(", '" + dtoLista.getTextoChequeo().toString() + "' " );
             
            if (dtoLista.getTextoPrimerPedido()!=null)    
                queryCabecera.append(", '" + dtoLista.getTextoPrimerPedido() + "' " );

            queryCabecera.append(", " + dtoLista.getOidPeriodo().longValue());

            if (dtoLista.getOidCliente()!=null)
                queryCabecera.append(", " + dtoLista.getOidCliente().longValue());
             
             
            queryCabecera.append(", " + dtoLista.getOidConfiguracionCD().longValue() + ", " + this.datosLinea.getOidLinea().longValue());

            if (dtoLista.getOidSolicitudCAbecera()!=null)
                queryCabecera.append(", " + dtoLista.getOidSolicitudCAbecera().longValue()); 

            if (dtoLista.getOidZona()!=null)
                queryCabecera.append(", " + dtoLista.getOidZona().longValue());
                
            if (dtoLista.getOidSeccion()!=null)
                queryCabecera.append(", " + dtoLista.getOidSeccion().longValue());
                
                
            queryCabecera.append(", " + dtoLista.getOidRegion());

            // Agregado - eiraola - 13/08/2007 [inicio]
            if (dtoLista.getIndicadorChequeo() != null) {
                queryCabecera.append(", " + dtoLista.getIndicadorChequeo());
            }
            // Agregado - eiraola - 13/08/2007 [fin]

            if (dtoLista.getOrigenChequeo()!=null)
                queryCabecera.append(", '" + dtoLista.getOrigenChequeo() + "'");
            
            // sapaza -- Cambios para WCS y MUO -- 22/09/2010 
            queryCabecera.append(", 0");
        
            queryCabecera.append(");");
            UtilidadesLog.debug("queryCabecera: " + queryCabecera);
            
            
            ArrayList detalles = dtoLista.getDetalles();
            DTOListaPicadoDetalle dto = null;
            String bool1 = null;
            
            int cantDetalles = detalles.size();
            StringBuffer listaPicadoDetalle = new StringBuffer();
            
            HashMap detallesHash = new HashMap();
           
            for (int i = 0; i < cantDetalles; i++) {
                StringBuffer queryDetalle  = new StringBuffer();
                StringBuffer values = new StringBuffer();
         
                dto = (DTOListaPicadoDetalle)detalles.get(i);
                
                //Cambio APE-05
                if ((dto.getUnidadesProducto()!=null)&&(dto.getUnidadesProducto().longValue()>0)){
                
                    String keyHash;
                    keyHash = dto.getNumeroCaja().toString().trim();
                    
                    if (dto.getIndicadorImpresion().booleanValue()){
                        if (detallesHash.get(keyHash) == null){
                            ArrayList listaPicadoDetalleFacturacion = new ArrayList();
                            DTOListaPicadoDetalleFacturacion dtoLPDF = new DTOListaPicadoDetalleFacturacion();      
                            DTOCajaListaPicado dtoCLP = new DTOCajaListaPicado();
                            
                            dtoLPDF.setDescrProd(this.obtenerDescProd(dto.getOidProducto(), consolidado.getOidIdioma()));
                            dtoLPDF.setNumeroAnaquel(this.obtenerAnaq(dto.getOidMapaCDDetalle()));
                            dtoLPDF.setNumeroCaja(dto.getNumeroCaja());
                            dtoLPDF.setOidMapaCDDetalle(dto.getOidMapaCDDetalle());
                            dtoLPDF.setOidProducto(dto.getOidProducto());
                            dtoLPDF.setUnidadesProducto(dto.getUnidadesProducto());
                            dtoLPDF.setIdZona(dto.getIdZona());    // Cambio 20090839
                            dtoLPDF.setDescripcionTipoCajaEmbalaje(dto.getDescripcionTipoCajaEmbalaje());   // Cambio 20090839
                            
                            listaPicadoDetalleFacturacion.add(dtoLPDF);
                            
                            if (dto.getUnidadesProducto().longValue()>0)
                                dtoCLP.setCantProdDifParaEstaCaja(1);
                            
                            dtoCLP.setNumeroCaja(dto.getNumeroCaja());
                            dtoCLP.setListaPicadoDetalleFacturacion(listaPicadoDetalleFacturacion);
                            
                            detallesHash.put(keyHash, dtoCLP);
                        }else{
                            DTOCajaListaPicado dtoCLP = (DTOCajaListaPicado)detallesHash.get(keyHash);    
                            ArrayList arrayDetallePos = dtoCLP.getListaPicadoDetalleFacturacion();    
                            DTOListaPicadoDetalleFacturacion dtoLPDF = new DTOListaPicadoDetalleFacturacion();      
                            
                            dtoCLP.setCantProdDifParaEstaCaja(dtoCLP.getCantProdDifParaEstaCaja() +
                                                              this.sumoSiNoEsta(arrayDetallePos, dto.getOidProducto(), 
                                                                                dto.getUnidadesProducto().longValue()));
                            
                            dtoLPDF.setDescrProd(this.obtenerDescProd(dto.getOidProducto(), consolidado.getOidIdioma()));
                            dtoLPDF.setNumeroAnaquel(this.obtenerAnaq(dto.getOidMapaCDDetalle()));
                            dtoLPDF.setNumeroCaja(dto.getNumeroCaja());
                            dtoLPDF.setOidMapaCDDetalle(dto.getOidMapaCDDetalle());
                            dtoLPDF.setOidProducto(dto.getOidProducto());
                            dtoLPDF.setUnidadesProducto(dto.getUnidadesProducto());
                            dtoLPDF.setIdZona(dto.getIdZona());    // Cambio 20090839
                            dtoLPDF.setDescripcionTipoCajaEmbalaje(dto.getDescripcionTipoCajaEmbalaje());   // Cambio 20090839
                            
                            arrayDetallePos.add(dtoLPDF);
                            
                            dtoCLP.setListaPicadoDetalleFacturacion(arrayDetallePos);
                            detallesHash.put(keyHash, dtoCLP); 
                            
                        }
                    }
                    
                    if (dto.getIndicadorImpresion()!=null) {
                        if (dto.getIndicadorImpresion().booleanValue())
                            bool1=ConstantesAPE.TRUE.toString();
                        else    
                            bool1=ConstantesAPE.FALSE.toString();                          
                    }     
                    queryDetalle.append(" INSERT INTO APE_LISTA_PICAD_DETAL (");
                    queryDetalle.append(" OID_LIST_PICA_DETA, ");
                    values.append("APE_LPDE_SEQ.NEXTVAL, ");
                    queryDetalle.append(" LPCA_OID_LIST_PICA_CABE, ");
                    values.append(oidCabecera).append(",");
                    
                    queryDetalle.append(" NUM_UNID_PROD, ");
                    values.append(dto.getUnidadesProducto()).append(",");
                    
                    if (dto.getValorLinea()!=null){
                        queryDetalle.append(" VAL_LINE, ");
                        values.append(dto.getValorLinea()).append(",");
                    }    
                    if (dto.getNumeroCaja()!=null){
                        queryDetalle.append(" NUM_CAJA, ");
                        values.append(dto.getNumeroCaja()).append(",");
                    }
                    if (bool1!=null){
                        queryDetalle.append(" IND_IMPR, ");
                        values.append(bool1).append(",");
                    }
                    if (dto.getNombrePicador()!=null) {
                        queryDetalle.append(" VAL_NOMB_PICA, ");
                        values.append(dto.getNombrePicador()).append(",");
                    }
                    if (dto.getUnidadesPicadas()!=null) {
                        queryDetalle.append(" NUM_UNID_PICA, ");
                        values.append(dto.getUnidadesPicadas()).append(",");
                    }
                    if (dto.getUnidadesChequeadas()!=null) {
                        queryDetalle.append(" NUM_UNID_CHEQ, ");
                        values.append(dto.getUnidadesChequeadas()).append(",");
                    }
                    if (dto.getOidTipoCajaEmbalaje()!=null) {
                        queryDetalle.append(" TCEM_OID_TIPO_CAJA_EMBA, ");
                        values.append(dto.getOidTipoCajaEmbalaje()).append(",");
                    }
                    queryDetalle.append(" MCDD_OID_MAPA_CENT_DIST_DETA, ");
                    values.append(dto.getOidMapaCDDetalle()).append(",");
                    queryDetalle.append(" SIPI_OID_SIST_PICA, ");
                    values.append(dto.getOidSistemaPicado()).append(",");
                    queryDetalle.append(" PROD_OID_PROD ");
                    values.append(dto.getOidProducto());
                    
                    if (dto.getNombreChequeador()!=null) {
                        queryDetalle.append(" ,VAL_NOMB_CHEQ ");
                        values.append(", '").append(dto.getNombreChequeador()).append("' ");
                    }
                    
                    // Cambio 20090839
                    queryDetalle.append(" , NUM_IDZO");
                    values.append(',').append(dto.getIdZona());
                    
                    queryDetalle.append(") VALUES (");
                    queryDetalle.append(values);
                    queryDetalle.append(");");
                    listaPicadoDetalle.append(queryDetalle.toString());
                    UtilidadesLog.debug("queryDetalle: " + queryDetalle);
                }else{
                    UtilidadesLog.debug("unidades pro.: " + dto.getUnidadesProducto() + ", no se inserta en detalle!");
                }

            }
            dtoLPCF.setDetalles(detallesHash);
            UtilidadesLog.debug("el dto de lista de picado que pongo en el dto consolidado, es: " + dtoLPCF);
            consolidado.setDtoCabeceraListaPicado(dtoLPCF);
            
            StringBuffer cabYdeta = new StringBuffer();
            cabYdeta.append(queryCabecera).append(listaPicadoDetalle);
            UtilidadesLog.debug("cabYdeta: " + cabYdeta);
            this.grabarDetListaPicado(cabYdeta);
             
            dtoLista.setOid(oidCabecera);

        UtilidadesLog.info("MONCrearListaPicadoBean.grabarListaPicado(): Salida");
    }
    
    
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
    private void grabarDetListaPicado(StringBuffer query) throws MareException {
      BelcorpService bs = BelcorpService.getInstance();   
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error en grabarDetListaPicado ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }    

    public void calcularCubicaje() throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.calcularCubicaje(): Entrada");
        if (this.datosLinea.getOidProgramaCubicaje().equals(ConstantesAPE.OID_CUBICAJE_VOLUMEN)) {
            try {
                MONCalculoCubicajeLocal mon = this.getMONCalculoCubicajeLocalHome().create();
                mon.calcularCubicajePorVolumen(this.listaPicadoCabecera);
            } catch (CreateException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        UtilidadesLog.info("MONCrearListaPicadoBean.calcularCubicaje(): Salida");
    }

    public void generarEtiquetas() throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.generarEtiquetas(): Entrada");
        boolean generarEtiquetas = true;
        
        // sapaza -- Cambios para WCS y MUO -- 22/09/2010
        /*ArrayList detalles = this.listaPicadoCabecera.getDetalles();
        for (int i = 0; (i < detalles.size()) && generarEtiquetas; i++) {
            DTOListaPicadoDetalle dto = (DTOListaPicadoDetalle)detalles.get(i);
            if (! dto.getOidSistemaPicado().equals(ConstantesAPE.OID_SISTEMA_PICADO_MANUAL)) {
                generarEtiquetas = false;
            }
        }*/
        
        if (generarEtiquetas) {
            DTOListaPicado dtoLista = new DTOListaPicado();
            dtoLista.setOidListaPicado(this.listaPicadoCabecera.getOid());
            dtoLista.setOidCentroDistribucion(this.listaPicadoCabecera.getOidConfiguracionCD());
            dtoLista.setOidLineaArmado(this.listaPicadoCabecera.getLineaArmado().getOid()); /* TODO: Ver */
            dtoLista.setOidPeriodo(this.listaPicadoCabecera.getOidPeriodo());
            dtoLista.setOidPais(this.listaPicadoCabecera.getOidPais());
            dtoLista.setOidIdioma(this.listaPicadoCabecera.getOidIdioma());
            
            try {
                MONGenerarEtiquetasLocal mon = this.getMONGenerarEtiquetasLocalHome().create();
                mon.generarEtiquetas(dtoLista);
            } catch (CreateException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        
        UtilidadesLog.info("MONCrearListaPicadoBean.generarEtiquetas(): Salida");
    }

    public void ordenarListaPicadoDetalle() throws MareException {
        UtilidadesLog.info("MONCrearListaPicadoBean.ordenarListaPicadoDetalle(): Entrada");
        Collections.sort(this.listaPicadoCabecera.getDetalles());
        UtilidadesLog.info("MONCrearListaPicadoBean.ordenarListaPicadoDetalle(): Salida");
    }

   public String getSecuencia(){
        return secuencia;
    }

    public void setSecuencia(String secuencia){
        this.secuencia = secuencia;
    }    
    
    
    public DTOFACConsolidado getConsolidado(){
        return consolidado;
    }

    public void setConsolidado(DTOFACConsolidado consolidado){
        this.consolidado = consolidado;
    }

    public DTOConfiguracionCentroDistribucion getConfiguracionCD(){
        return configuracionCD;
    }

    public void setConfiguracionCD(DTOConfiguracionCentroDistribucion configuracionCD){
        this.configuracionCD = configuracionCD;
    }

    public ArrayList getLstProcesoFueraPedido(){
        return lstProcesoFueraPedido;
    }

    public void setLstProcesoFueraPedido(ArrayList lstProcesoFueraPedido){
        this.lstProcesoFueraPedido = lstProcesoFueraPedido;
    }

    public DTOListaPicadoCabecera getListaPicadoCabecera(){
        return listaPicadoCabecera;
    }

    public void setListaPicadoCabecera(DTOListaPicadoCabecera listaPicadoCabecera){
        this.listaPicadoCabecera = listaPicadoCabecera;
    }
    
    /**
     * Busca en una lista de DTOFACPosicionSolicitud el primero cuyo OID de
     * producto coincida con el pasado por parámetro y lo devuelve.
     * Si no encuentra ninguno, devuelve null.
     * 
     * @author dmorello
     * @since 11-05-2007
     */
    private DTOFACPosicionSolicitud buscarPosicionProducto(ArrayList listaPosiciones, Long oidProducto) {
        
        int size = listaPosiciones.size();
        for (int i = 0; i < size; i++) {
            DTOFACPosicionSolicitud dtoPosicion;
            dtoPosicion = (DTOFACPosicionSolicitud)listaPosiciones.get(i);
            if (dtoPosicion.getProducto().equals(oidProducto)) {
                return dtoPosicion;
            }
        }
        return null;
    }

    private MONGenerarEtiquetasLocalHome getMONGenerarEtiquetasLocalHome() throws MareException {
        Object objHome = UtilidadesEJB.getLocalHome("java:comp/env/MONGenerarEtiquetas");
        return (MONGenerarEtiquetasLocalHome)objHome;
    }

  private MONCalculoCubicajeLocalHome getMONCalculoCubicajeLocalHome() throws MareException {
        Object objHome = UtilidadesEJB.getLocalHome("java:comp/env/MONCalculoCubicaje");
        return (MONCalculoCubicajeLocalHome)objHome;
  }
  
  

    private MONSeleccionarAnaquelLocal getMONSeleccionarAnaquelLocal() throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.getMONSeleccionarAnaquel: Entrada");
    
        // Se obtiene el interfaz home
        MONSeleccionarAnaquelLocalHome home = this.getMONSeleccionarAnaquelLocalHome();
        // Se obtiene el interfaz remoto
        MONSeleccionarAnaquelLocal ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            //this.logearError("*** Error en MONCrearListaPicado.getMONSeleccionarAnaquel", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("MONCrearListaPicado.getMONSeleccionarAnaquel: Salida");
        return ejb;
    }

  
    private MONProcesoFueraPedidoLocal getMONProcesoFueraPedidoLocal() throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.getMONProcesoFueraPedidoLocal: Entrada");
    
        // Se obtiene el interfaz home
        MONProcesoFueraPedidoLocalHome home = this.getMONProcesoFueraPedidoLocalHome();
        // Se obtiene el interfaz remoto
        MONProcesoFueraPedidoLocal ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            //this.logearError("*** Error en MONCrearListaPicado.getMONProcesoFueraPedido", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("MONCrearListaPicado.getMONProcesoFueraPedido: Salida");
        return ejb;
    }

    private MONINTPTL getMONINTPTL() throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.getMONINTPTL: Entrada");
    
        // Se obtiene el interfaz home
        MONINTPTLHome home = (MONINTPTLHome) UtilidadesEJB.getHome("MONINTPTL", MONINTPTLHome.class);
        // Se obtiene el interfaz remoto
        MONINTPTL ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            //this.logearError("*** Error en MONCrearListaPicado.getMONINTPTL", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("MONCrearListaPicado.getMONINTPTL: Salida");
        return ejb;
    }    

  private MONSeleccionarAnaquelLocalHome getMONSeleccionarAnaquelLocalHome() throws MareException {
    Object objHome = UtilidadesEJB.getLocalHome("java:comp/env/MONSeleccionarAnaquel");
    return (MONSeleccionarAnaquelLocalHome)objHome;
  }

  private MONProcesoFueraPedidoLocalHome getMONProcesoFueraPedidoLocalHome() throws MareException {
    Object objHome = UtilidadesEJB.getLocalHome("java:comp/env/MONProcesoFueraPedido");
    return (MONProcesoFueraPedidoLocalHome)objHome;
  }

  private MONINTPTLHome getMONINTPTLHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONINTPTLHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONINTPTL"), MONINTPTLHome.class);
  }
  
  private String obtenerAnaq(Long oidMapaCDDetalle) throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.obtenerAnaq: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String anaq = daoCL.obtenerAnaq(oidMapaCDDetalle);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerAnaq: Salida");
        return anaq;
  }
  
  private String obtenerDescProd(Long oidProd, Long oidIdioma) throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.obtenerProd: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String desc = daoCL.obtenerDescProd(oidProd, oidIdioma);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerProd: Salida");
        return desc;
  }
  
  private String obtenerDescrLiArm(long oidLinea, long oidIdioma) throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.obtenerDescrLiArm: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String desc = daoCL.obtenerDescrLiArm(oidLinea, oidIdioma);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerDescrLiArm: Salida");
        return desc;
  }
  
  /**
   * Cambio 20090839
   * Obtiene el valor del campo "longitud numero etiqueta" de la linea de armado
   * cuyo OID recibe por parametro.
   * @author dmorello
   * @since 06-10-2009
   */
  private Integer obtenerLongitudNumeroEtiqueta(Long oidLineaArmado) throws MareException {
      UtilidadesLog.debug("MONCrearListaPicado.obtenerLongitudNumeroEtiqueta(Long oidLineaArmado): Entrada");
      Integer longitud = new DAOCrearListaPicado().obtenerLongitudNumeroEtiqueta(oidLineaArmado);
      UtilidadesLog.debug("MONCrearListaPicado.obtenerLongitudNumeroEtiqueta(Long oidLineaArmado): Salida");
      return longitud;
  }
  
  private String obtenerNombrComplConsult(long oidClie) throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.obtenerNombrComplConsult: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String nombre = daoCL.obtenerNombrComplConsult(oidClie);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerNombrComplConsult: Salida");
        return nombre;
  }

  private String obtenerCogConsult(long oidClie) throws MareException {
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCogConsult: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String cod = daoCL.obtenerCogConsult(oidClie);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCogConsult: Salida");
        return cod;
  }
  
  private String obtenerCodPeri(long oidPeri) throws MareException {  //campaña
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodPeri: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String cod = daoCL.obtenerCodPeri(oidPeri);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodPeri: Salida");
        return cod;
  }

  private String obtenerCodBar(long oidSoliCabe) throws MareException {  
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodBar: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String codBar = daoCL.obtenerCodBar(oidSoliCabe);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodBar: Salida");
        return codBar;
  }
  
  private String obtenerCodigoTerritorial(long oidSoliCabe) throws MareException {  
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodigoTerritorial: Entrada");
        DAOCrearListaPicado daoCL = new DAOCrearListaPicado();
        String codTerr = daoCL.obtenerCodigoTerritorial(oidSoliCabe);
        UtilidadesLog.debug("MONCrearListaPicado.obtenerCodigoTerritorial: Salida");
        return codTerr;
  }
  
  private long sumoSiNoEsta(ArrayList arrayDetallePos, Long oidProducto, long cantidadParaEsteProd) throws MareException {  
        UtilidadesLog.debug("MONCrearListaPicado.sumoSiNoEsta: Entrada");
        //sumo si no esta o si su cantidad es distinta de cero
        int size = arrayDetallePos.size();
        DTOListaPicadoDetalleFacturacion dtoLPDF = null;
        for (int i = 0; i < size; i++) {
            dtoLPDF = (DTOListaPicadoDetalleFacturacion)arrayDetallePos.get(i);
            if (dtoLPDF.getOidProducto().longValue() == oidProducto.longValue()){
                UtilidadesLog.debug("MONCrearListaPicado.sumoSiNoEsta: Salida (esta!)");
                return 0;
            }
        }
        UtilidadesLog.debug("MONCrearListaPicado.sumoSiNoEsta: Salida (no esta!)");
        
        if (cantidadParaEsteProd>0)
            return 1;
        else
            return 0;
  }         

  public void procesoEmbalajeTermindo(DTOEtiqueta dtoe) throws MareException
  {
        UtilidadesLog.debug("MONCrearListaPicado.procesoEmbalajeTerminado: Entrada");
        DAOCrearListaPicado dao = new DAOCrearListaPicado();
        String usuario = ctx.getCallerPrincipal().getName();
        UtilidadesLog.debug("Usuario:" + usuario);
        dao.procesoEmbalajeTerminado(dtoe, usuario);
        UtilidadesLog.debug("MONCrearListaPicado.procesoEmbalajeTerminado: Salida");
  }
  
  public void eliminarAnaquelesPostVenta(DTOBelcorp dtoe) throws MareException {
      UtilidadesLog.debug("MONCrearListaPicado.eliminarAnaquelesPostVenta(DTOBelcorp dtoe): Entrada");
      new DAOCrearListaPicado().eliminarAnaquelesPostVenta(dtoe);
      UtilidadesLog.debug("MONCrearListaPicado.eliminarAnaquelesPostVenta(DTOBelcorp dtoe): Salida");
  }
  
  
}
