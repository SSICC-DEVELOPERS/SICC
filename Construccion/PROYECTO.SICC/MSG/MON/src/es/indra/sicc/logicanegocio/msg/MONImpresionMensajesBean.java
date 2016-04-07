package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonImpresion;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.DTODestinatarioMensaje;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.dtos.msg.DTOMensajeImpresion;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.dtos.msg.DTOSeleccionMensajes;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.fac.AsignacionImpresoraLocal;
import es.indra.sicc.entidades.fac.AsignacionImpresoraLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.msg.BuzonMensajesLocalHome;
import es.indra.sicc.entidades.msg.PatronCabeceraLocal;
import es.indra.sicc.entidades.msg.PatronCabeceraLocalHome;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICC;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICCHome;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.Parseador;
import es.indra.sicc.logicanegocio.msg.DAOImpresion;
import es.indra.sicc.logicanegocio.ped.IGenerarNumeroDocumento;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;



public class MONImpresionMensajesBean
        implements SessionBean {
    public static IGenerarNumeroDocumento iGenerarNumeroDocumento;
    private UtilidadesLog log = new UtilidadesLog();

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /**
      * autor@ Paola Cabrera
      * Descripcion::: Se llama desde el caso de Facturacion, se obtienen los mensajes
      *                que deben imprimirse para un determinado cliente.
      *                Los argumentos de entrada son los datos del consolidado del
      *                cliente y el numero de lote de impresion
      * Fecha :::::::: 22/12/2004
      * 16-06-2005 - rgiorgi: inc. 19162
      */
    public DTOImpresion[] imprimirMensajesFacturacion(DTOFACConsolidado DTOConsolidado)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.imprimirMensajesFacturacion(DTOFACConsolidado DTOConsolidado): Entrada");
            
        int nMensaje = 0;
        boolean imprimirMensaje = true;

        ArrayList nMensajes = new ArrayList();

        try {
            DTOMensajeImpresion[] dtoMensajesFinal = new DTOMensajeImpresion[nMensaje];
            int finalBuzon;

            DAOImpresion daoImpresion = new DAOImpresion();
            //  Agregado por HRCS - Fecha 24/05/2007 - Incidencia Sicc20070203
            ArrayList codigos = daoImpresion.obtenerClasificacionTipoCliente( DTOConsolidado.getDtoCabecera().getOidCliente(),
                                                                              DTOConsolidado.getDtoCabecera().getTipoCliente(),
                                                                              DTOConsolidado.getDtoCabecera().getSubtipoCliente() );
            
            DTOMensajeImpresion[] DTOMensa = daoImpresion.obtenerMensajesImpresion(DTOConsolidado.getDtoCabecera());
            /*DTOMensajeImpresion[] DTOMensa = daoImpresion.obtenerMensajesImpresion(DTOConsolidado.getDtoCabecera().getPeriodo(),
                                                                                   DTOConsolidado.getDtoCabecera().getOidCliente(),
                                                                                   DTOConsolidado.getDtoCabecera().getOidPais());*/
            int vFinal = DTOMensa.length;
            UtilidadesLog.debug("[MSG][imprimirMensajesFacturacion] - se obtuvieron: " + vFinal + " mensajes.");

            for (int i = 0; i < vFinal; i++) {
                imprimirMensaje = true;

                //UtilidadesLog.info("[MSG][imprimirMensajesFacturacion] - mensaje: " + DTOMensa[i].getOidMensaje()
                //                                              + " permanencia: " + DTOMensa[i].getOidTipoPermanencia());
                if (DTOMensa[i].getOidTipoPermanencia() != null) {
                    if (new Long(DTOMensa[i].getOidTipoPermanencia().longValue()) == ConstantesMSG.OID_PERMANENCIA_H) {
                        if (((new Long(DTOMensa[i].getCodigoPeriodoInicial()).longValue()) >= (new Long(DTOMensa[i].getCodigoPeriodoDesde()).longValue())) &&
                                ((new Long(DTOMensa[i].getCodigoPeriodoInicial()).longValue()) <= (new Long(DTOMensa[i].getCodigoPeriodoHasta()).longValue()))) {
                            imprimirMensaje = true;
                        } else {
                            imprimirMensaje = false;
                        }
                    }

                    if (DTOMensa[i].getOidTipoPermanencia() == ConstantesMSG.OID_PERMANENCIA_R) {
                        if ((DTOMensa[i].getFechaPermanenciaDesde() != null) && (DTOMensa[i].getFechaPermanenciaHasta() != null) &&
                                (DTOConsolidado.getDtoCabecera().getFechaFacturacion() != null)) {
                            long desde = DTOMensa[i].getFechaPermanenciaDesde().getTime();
                            long hasta = DTOMensa[i].getFechaPermanenciaHasta().getTime();
                            long factura = DTOConsolidado.getDtoCabecera().getFechaFacturacion().getTime();

                            if ((factura >= desde) && (factura <= hasta)) {
                                imprimirMensaje = true;
                            }
                        } else {
                            imprimirMensaje = false;
                        }
                    }
                }

                //Se puede imprimir
                //Se comprueba tipos de mensajes y destinatarios
                if (imprimirMensaje) {
                    if (DTOMensa[i].getOidMensaje() != null) {
                        if (DTOMensa[i].getOidTipoMensaje().equals(ConstantesMSG.OID_TIPO_G2)) {
                            int j = 0;

                            // Num de destinatarios distintos del mensaje 
                            int finalDesti = DTOMensa[i].getDestinatario().size();
                            DTODestinatarioMensaje dTODestinatorioMensaje = new DTODestinatarioMensaje();

                            while ((j < finalDesti) && imprimirMensaje) {
                                dTODestinatorioMensaje = (DTODestinatarioMensaje) DTOMensa[i].getDestinatario().get(j);

                                if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA)) {
                                    if (DTOMensa[i].getContadorUnidadAdministrativa().longValue()>0){
                                        imprimirMensaje = true;
                                    }else{
                                        imprimirMensaje = false;
                                    }
                                    /*DTOMensajeUnidadAdministrativa dtoUA = new DTOMensajeUnidadAdministrativa();

                                    dtoUA.setOid(DTOMensa[i].getOidMensaje());
                                    dtoUA.setOidRegion(DTOConsolidado.getDtoCabecera().getRegion());
                                    dtoUA.setOidZona(DTOConsolidado.getDtoCabecera().getZona());
                                    dtoUA.setOidSeccion(DTOConsolidado.getDtoCabecera().getSeccion());
                                    dtoUA.setOidTerritorio(DTOConsolidado.getDtoCabecera().getTerritorio());

                                    // Se llama al metodo del daoImpresion
                                    imprimirMensaje = daoImpresion.existeUnidadAdministrativa(dtoUA).booleanValue();*/
                                }

                                if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_CLASIFICACION_CLIENTE)) {
                                    DTOMensajeTipoCliente dtoTipifi = new DTOMensajeTipoCliente();

                                    dtoTipifi.setOid(DTOMensa[i].getOidMensaje());
                                    dtoTipifi.setOidTipoCliente(DTOConsolidado.getDtoCabecera().getTipoCliente());
                                    dtoTipifi.setOidSubtipoCliente(DTOConsolidado.getDtoCabecera().getSubtipoCliente());
                                    //  Modificado por HRCS - Fecha 24/05/2007 - Incidencia Sicc20070203
                                    if (codigos.size()==2 && codigos.get(0)!=null && codigos.get(1)!=null)  {
                                        dtoTipifi.setOidsClasificaciones( (String)codigos.get(0) );
                                        dtoTipifi.setOidsTipoClasificaciones( (String)codigos.get(1) );
                                    } else {
                                        //sapaza -- cambio Optimizacion Logs -- 05/03/2010, Recategorizacion de nivel ERROR a INFO
                                        UtilidadesLog.info("Las clasificaciones y tipos de clasificacion tienen datos nulos."); 
                                    }
                                    //verifico exclusion de tipologia de cliente. incidencia 20070203.
                                    if (DTOMensa[i].getExclusionTipologia().booleanValue()  ) {
                                        // si alguna tipificacion del cliente esta definida en el mesanje, entonces NO imprime.
                                        imprimirMensaje = ! daoImpresion.existeTipificacionCliente(dtoTipifi).booleanValue();
                                    } else {
                                        // si alguna tipificacion del cliente esta definida en el mesanje, entonces imprime.
                                        imprimirMensaje = daoImpresion.existeTipificacionCliente(dtoTipifi).booleanValue();
                                    }
                                }

                                if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_MARCA)) {
                                    DTOMensajeMarca dtoMarca = new DTOMensajeMarca();
                                    dtoMarca.setOid(DTOMensa[i].getOidMensaje());
                                    dtoMarca.setOidMarca(DTOConsolidado.getDtoCabecera().getMarca());

                                    //Se llama al daoImpresion
                                    imprimirMensaje = daoImpresion.existeMarca(dtoMarca).booleanValue();
                                }

                                if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_CODIGO_VENTA)) {
                                    /* Incidencia 10973
                                     * la llamada al método existeCodigoVenta:
                                     *  imprimirMensaje = existeCodigoVenta(DTOConsolidado, DTOMensa[i].oidMensaje)
                                     */
                                    imprimirMensaje = this.existeCodigoVenta(DTOConsolidado, DTOMensa[i].getOidMensaje()).booleanValue();
                                }

                                j++;
                            } // Fin del while ==> j<finalDesti y imprimirMensaje

                            /* Despues de procesar todos los destinos del mensaje se comprueba si
                               se puede imprimir */
                            if (imprimirMensaje) {
                                DTOImpresion DtoMensajesFinales = new DTOImpresion();
                                DtoMensajesFinales.setOidMensaje(DTOMensa[i].getOidMensaje());
                                DtoMensajesFinales.setOidTipoMensaje(DTOMensa[i].getOidTipoMensaje());
                                DtoMensajesFinales.setTexto(DTOMensa[i].getTexto());
                                DtoMensajesFinales.setOidTipoPermanencia(DTOMensa[i].getOidTipoPermanencia());
                                DtoMensajesFinales.setOidBuzon(null);
                                DtoMensajesFinales.setOidCliente(DTOConsolidado.getDtoCabecera().getOidCliente());
                                DtoMensajesFinales.setNumeroSecuencia(new Long(0));
                                //DtoMensajesFinales.setOidPeriodo(DTOConsolidado.getDtoCabecera().getPeriodo());
                                DtoMensajesFinales.setOidPeriodo(DTOMensa[i].getOidPeriodo());
                                DtoMensajesFinales.setOidIdioma(DTOConsolidado.getOidIdioma());
                                DtoMensajesFinales.setOidPais(DTOConsolidado.getOidPais());
                                nMensajes.add((DTOImpresion) DtoMensajesFinales);
                                UtilidadesLog.debug("[MSG][imprimirMensajesFacturacion] - se agregó el mensaje: " +
                                                   DtoMensajesFinales.getOidMensaje() + " de tipo G2.");
                            }
                        } // fin TipoMensaje() = ConstantesMSG.OID_TIPO_G2)

                        //solo puede existir un destinatario
                        if (DTOMensa[i].getOidTipoMensaje().equals(ConstantesMSG.OID_TIPO_G1)) {
                            DTODestinatarioMensaje dTODestinatorioMensaje = new DTODestinatarioMensaje();
                            dTODestinatorioMensaje = (DTODestinatarioMensaje) DTOMensa[i].getDestinatario().get(0);

                            if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_PEDIDO)) {
                                imprimirMensaje = existeOrdenCompra(DTOConsolidado).booleanValue();
                            }

                            if (dTODestinatorioMensaje.getOidTipoDestinatario().equals(ConstantesMSG.OID_CONSULTORAS)) {
                                if (DTOMensa[i].getBuzon() != null) {
                                    imprimirMensaje = true;
                                } else {
                                    imprimirMensaje = false;
                                }
                            }

                            if (imprimirMensaje && (DTOMensa[i].getBuzon() != null)) {
                                int n = 0;

                                /* se comprueba si se debe imprimir el mensaje, en caso de que si se
                                imprimira el mensaje tantas veces como registros activos haya en
                                DTOMensa[i].buzon() */
                                finalBuzon = DTOMensa[i].getBuzon().size();
                                
                                int cantCabec = this.contarCabeceras(DTOMensa[i].getTexto());
                                UtilidadesLog.debug("cantCabec: " + cantCabec);
                                String[] strMensaje = this.configurarMensaje(DTOMensa[i].getTexto());

                                DTOBuzonImpresion dtoBuzon = null;
                                
                                for (int z = 0; z < strMensaje.length; z++) {
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                                      UtilidadesLog.debug("Posicion a procesar: " + strMensaje[z]);
                                      
                                    String strParteVar = null;
                                    if (cantCabec != 0) {
                                        strParteVar = this.quitarParteFija(strMensaje[z]);
                                    }
    
                                    while (n < finalBuzon) {
                                        DTOImpresion DtoMensajesFinaly = new DTOImpresion();
    
                                        dtoBuzon = (DTOBuzonImpresion) DTOMensa[i].getBuzon().get(n);
                                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                                          UtilidadesLog.debug("dtoBuzon " + n + ": " + dtoBuzon);
    
                                        if (dtoBuzon.getIndActivo() != null && dtoBuzon.getIndActivo().intValue() == 1) {
                                            // Se asignan los datos correspondiente del buzon de mensajes
                                            DtoMensajesFinaly.setOidMensaje(DTOMensa[i].getOidMensaje());
                                            DtoMensajesFinaly.setOidTipoMensaje(DTOMensa[i].getOidTipoMensaje());
                                            //DtoMensajesFinaly.setTexto(DTOMensa[i].getTexto());
                                            if (cantCabec == 0) {
                                                // No hay partes marcadas como fijas, se asigna directamente el texto
                                                DtoMensajesFinaly.setTexto(strMensaje[z]);
                                            } else {
                                                // Hay partes marcadas como fijas
                                                String textoAux;
                                                if (n == 0) {
                                                    // Es la 1ra linea que contiene la parte fija, la imprimo sin los tags
                                                    textoAux = this.quitarTags(strMensaje[z]);
                                                } else  {
                                                    // Si no es la 1ra linea, quito la parte fija
                                                    textoAux = strParteVar;
                                                }
                                                DtoMensajesFinaly.setTexto(textoAux);
                                            }
                                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                                              UtilidadesLog.debug("Texto asignado: " + DtoMensajesFinaly.getTexto());
                                              
                                            DtoMensajesFinaly.setOidTipoPermanencia(DTOMensa[i].getOidTipoPermanencia());
                                            DtoMensajesFinaly.setOidBuzon(dtoBuzon.getOidBuzon());
                                            DtoMensajesFinaly.setOidPeriodo(DTOMensa[i].getOidPeriodo());
                                            DtoMensajesFinaly.setOidCliente(DTOConsolidado.getDtoCabecera().getOidCliente());
                                            DtoMensajesFinaly.setNumeroSecuencia(dtoBuzon.getNumeroSecuencia());
                                            DtoMensajesFinaly.setDatoVariable1(dtoBuzon.getDatoVariable1());
                                            DtoMensajesFinaly.setDatoVariable2(dtoBuzon.getDatoVariable2());
                                            DtoMensajesFinaly.setDatoVariable3(dtoBuzon.getDatoVariable3());
                                            DtoMensajesFinaly.setDatoVariable4(dtoBuzon.getDatoVariable4());
                                            DtoMensajesFinaly.setDatoVariable5(dtoBuzon.getDatoVariable5());
                                            DtoMensajesFinaly.setDatoVariable6(dtoBuzon.getDatoVariable6());
                                            DtoMensajesFinaly.setDatoVariable7(dtoBuzon.getDatoVariable7());
                                            DtoMensajesFinaly.setDatoVariable8(dtoBuzon.getDatoVariable8());
                                            DtoMensajesFinaly.setDatoVariable9(dtoBuzon.getDatoVariable9());
                                            DtoMensajesFinaly.setDatoVariable10(dtoBuzon.getDatoVariable10());
                                            DtoMensajesFinaly.setDatoVariable11(dtoBuzon.getDatoVariable11());
                                            DtoMensajesFinaly.setDatoVariable12(dtoBuzon.getDatoVariable12());
                                            DtoMensajesFinaly.setDatoVariable13(dtoBuzon.getDatoVariable13());
                                            DtoMensajesFinaly.setDatoVariable14(dtoBuzon.getDatoVariable14());
                                            DtoMensajesFinaly.setDatoVariable15(dtoBuzon.getDatoVariable15());
                                            DtoMensajesFinaly.setDatoVariable16(dtoBuzon.getDatoVariable16());
                                            DtoMensajesFinaly.setDatoVariable17(dtoBuzon.getDatoVariable17());
                                            DtoMensajesFinaly.setDatoVariable18(dtoBuzon.getDatoVariable18());
                                            DtoMensajesFinaly.setDatoVariable19(dtoBuzon.getDatoVariable19());
                                            DtoMensajesFinaly.setDatoVariable20(dtoBuzon.getDatoVariable20());
                                            DtoMensajesFinaly.setOidIdioma(DTOConsolidado.getOidIdioma());
                                            DtoMensajesFinaly.setOidPais(DTOConsolidado.getOidPais());
    
                                            nMensajes.add((DTOImpresion) DtoMensajesFinaly);
                                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                                              UtilidadesLog.debug("[MSG][imprimirMensajesFacturacion] - se agregó el mensaje: " +
                                                               DtoMensajesFinaly.getOidMensaje() + " de tipo G1" + " para el buzón: " +
                                                               DtoMensajesFinaly.getOidBuzon());
                                        }
                                        if (strParteVar != null && strParteVar.length() == 0) {
                                          // Si la parte actual del texto es una parte fija sin detalle,
                                          // se fuerza la salida del ciclo para no repetir lineas de detalle vacias
                                          n = finalBuzon;
                                        } else {
                                          // Si hay parte repetible, se continua imprimiendo
                                          n++;
                                        }
                                    }
                                    n = 0;
                                } //Pasamos a tratar el otro buzon
                            } //si imprimir mensaje G1 = true
                        } //fin mensaje G1
                    } //mensaje != null
                } //imprimir mensaje cabecera
            } //for mensajes del DAO

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("nMensajes: " + nMensajes);
            
            DTOImpresion[] dtoMensajesFinaly = null;

            if ((nMensajes != null) && (nMensajes.size() > 0)) {
                
                dtoMensajesFinaly = (DTOImpresion[]) nMensajes.toArray(new DTOImpresion[nMensajes.size()]);
                
//                if (dtoMensajesFinaly != null) {
                    this.actualizarMensajesFacturacion(nMensajes, DTOConsolidado.getDtoCabecera().getNumeroLoteFacturacion());
//                }
            }

            UtilidadesLog.info("MONImpresionMensajesBean.imprimirMensajesFacturacion(DTOFACConsolidado DTOConsolidado): Salida");

            return dtoMensajesFinaly;
        } catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            
            UtilidadesLog.error("ERROR: ",e);
            
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     *
     * @throws java.rmi.RemoteException
     * @throws es.indra.mare.common.exception.MareException
     * @author mbobadill
     * @date 21/12/04
     * /Se imprimen los mensajes del patrón seleccionado, si se ha seleccionado
                  un cliente, entonces se imprimirán los mensajes que existan para ese cliente
                  y en caso contrario para todos los clientes que tengan los mensajes del
                  patrón (que estén en el buzón de mensajes)
     */
    public void imprimirMensajesDesdeEditor(DTOSeleccionMensajes DTOE)
            throws RemoteException, MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.imprimirMensajesDesdeEditor(DTOSeleccionMensajes DTOE): Entrada");
            
        //NUEVO
        //Se comprueba si se ha seleccionado un cliente, si el código del mismo existe
        try {
            ClienteDatosBasicosLocal cliente = null;

            if ((DTOE.getCodigoCliente() != null) && !DTOE.getCodigoCliente().equals("")) {
                try {
                    cliente = new ClienteDatosBasicosLocalHome().findByUK(DTOE.getOidPais(), DTOE.getCodigoCliente());
                    DTOE.setOidCliente(cliente.getOid());
                }
                catch (NoResultException e) {
                    UtilidadesLog.debug(e);
                    UtilidadesLog.debug("No Existen Clientes, Abortamos");
                    throw new MareException(" ", 
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0014));
                }catch (PersistenceException e) {
                UtilidadesLog.error(e);
                
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
            }

            //FIN NUEVO
            DAOImpresion dao = new DAOImpresion();
            DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
            dtoNumeroSolicitud.setOidPais(DTOE.getOidPais());
            dtoNumeroSolicitud.setOidIdioma(DTOE.getOidIdioma());

            dtoNumeroSolicitud.setOperacion("FAC001");

            String numeroLote = getMONProcesosPEDHome().create().generaNumeroDocumento(dtoNumeroSolicitud);

            UtilidadesLog.info("Llama a DAOImpresion.obtenerMensajesImpresionPorPatron()");
            DTOMensajeImpresion[] dTOMensaInicial = dao.obtenerMensajesImpresionPorPatron(DTOE);
            //this.imprimeDTOMensajeInicial(dTOMensaInicial); 
            //UtilidadesLog.info("dTOMensaInicial: " + dTOMensaInicial);

            DTOOIDs dtoClientes = this.obtenerClientes(dTOMensaInicial);
            dtoClientes.setOidIdioma(DTOE.getOidIdioma());
            dtoClientes.setOidPais(DTOE.getOidPais());

            DTOMensajeImpresion[] dtoMensaG2 = this.obtenerMensajesG2(dTOMensaInicial);
            DTOMensajeImpresion[] dtoMensa = this.obtenerRestoMensajes(dTOMensaInicial);
            
            UtilidadesLog.debug("dtoMensaG2: " + this.arrayToString(dtoMensaG2));
            UtilidadesLog.debug("dtoMensa: " + this.arrayToString(dtoMensa));
            
            if ((dtoMensaG2.length == 0) && (dtoMensa.length == 0)) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", 
                ErroresDeNegocio.MSG_0021));
            }

            int i = 0;
            int finalCli = dtoClientes.getOids().length;
            ArrayList listadtoMensajesFinal = new ArrayList();
            UtilidadesLog.debug("Clientes a procesar: "+finalCli);
            while (i < finalCli) {
                Long[] dtoClientesOid = dtoClientes.getOids();
                
                //Modificado por incidencia 11639
                DTOImpresion[] dtoMensajesFinal = this.crearDTOMensajesFinal(new Integer(i), DTOE.getOidPeriodo(), dtoClientes, dtoMensa, dtoMensaG2);
                //Modificado por incidencia 11639
                
                //ArrayList listadtoMensajesFinal = new ArrayList();

                //transformamos el Array a Array List             
                for (int z = 0; z < dtoMensajesFinal.length; z++) {
                    listadtoMensajesFinal.add((DTOImpresion) dtoMensajesFinal[z]);
                }
                i++;
            }

            /**MODIFICACION SEGUN INCIDENCIA 12079*/

            //Se llama a un proceso de facturación, y se le pasa el patrón y 
            //la estructura con los mensajes del cliente que deben imprimirse
            PatronCabeceraLocalHome localHome = null;
            PatronCabeceraLocal local = null;
            Long patron = null;
            Long formulario = null;

            try {
                localHome = new PatronCabeceraLocalHome();
                
                UtilidadesLog.debug("OID PATRON: " + DTOE.getOidPatron());
                
                local = localHome.findByPrimaryKey(DTOE.getOidPatron());
            } catch (NoResultException fe) {
                UtilidadesLog.debug(fe);
                
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            patron = local.getOidFormulario();
            
            UtilidadesLog.debug("Subacceso: " + DTOE.getOidSubacceso());
            UtilidadesLog.debug("Formulario: " + patron);

            AsignacionImpresoraLocal impresora = new AsignacionImpresoraLocalHome().findByUK(DTOE.getOidSubacceso(), patron);

            if (listadtoMensajesFinal != null && listadtoMensajesFinal.size() > 0) { // inc.20235  22/08/05   idedough
                MONImpresionSICCHome mONImpresionSICCHome = 
                (MONImpresionSICCHome) UtilidadesEJB.getHome("MONImpresionSICC", MONImpresionSICCHome.class);
                
                MONImpresionSICC mONImpresionSICC = mONImpresionSICCHome.create();
                mONImpresionSICC.imprimirDocumentoMensajes(DTOE.getOidPatron(), listadtoMensajesFinal, impresora.getImpresoraVirtual(), new Integer(0), DTOE.getOidSubacceso());
                actualizarMensajesFacturacion(listadtoMensajesFinal, new Long(0));
                // i++; - (removed) inc.20235 22/08/05   idedough
            }
            else {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", 
                ErroresDeNegocio.MSG_0021));
            }
        }
        catch (CreateException ce) {
            UtilidadesLog.error(ce);
            
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (RemoteException re) {
            UtilidadesLog.error(re);
            
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (NoResultException re) {
            UtilidadesLog.debug(re);
            
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException e) {
            UtilidadesLog.error(e);
           
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            
            UtilidadesLog.error(e);
            
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONImpresionMensajesBean.imprimirMensajesDesdeEditor(DTOSeleccionMensajes DTOE): Salida");
        
    }

    /**
       *
       * @autor Paola Cabrera
       * Descripcion: Se imprimen los mensajes del patron seleccionado, se se selecciona
       * un cliente, se imprimen los mensajes que existan para ese cliente, sino
       * para todos los clientes que tengan los mensajes del patron que esten en el buzon
       * de mensajes
       *
       */
    public DTOSalida consultarMensajesPorConsultora(DTOSeleccionMensajes DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.consultarMensajesPorConsultora(DTOSeleccionMensajes DTOE): Entrada");
        
        UtilidadesLog.debug("DTOSeleccionMensajes recibido: " + DTOE);
        UtilidadesLog.debug("DTOE.oidPais = " + DTOE.getOidPais());
            
        try {
            /*
             * INC 22029 - dmorello, 26/01/2006
             * Con la info del DTOE se buscará el OID de cliente y se asignará
             * al mismo, a fin de filtrar adecuadamente por cliente en la query
             * de DAOImpresion.obtenerMensajesPorConsultora(DTOE)
             */
            try {
                Long oidCliente = null;
                ClienteDatosBasicosLocalHome clienteHome;
                ClienteDatosBasicosLocal cliente;
                
                clienteHome = new ClienteDatosBasicosLocalHome();
                cliente = clienteHome.findByCodigoYPais(DTOE.getOidPais(),
                                                        DTOE.getCodigoCliente());
                oidCliente = cliente.getOid();
                DTOE.setOidCliente(oidCliente);
            } catch (NoResultException e) {
                UtilidadesLog.debug("EXCEPCION: El cliente no existe: " + e);
                throw new MareException(" ",
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG,
                        "",ErroresDeNegocio.MSG_0014));
            }
            
            DAOImpresion daoImp = new DAOImpresion();

            DTOMensajeImpresion[] dtoMensajeInicial = 
            daoImp.obtenerMensajesPorConsultora(DTOE);

            if (dtoMensajeInicial.length == 0) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0022));
            }

            ClienteDatosBasicosLocal localClientes = null;
            ClienteDatosBasicosLocalHome clientesHome = null;

            try {
                clientesHome = new ClienteDatosBasicosLocalHome();
                localClientes = clientesHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCodigoCliente());
            }
            catch (NoResultException fe) {
                UtilidadesLog.debug(fe);
                
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }catch (PersistenceException e) {
               UtilidadesLog.error(e);
         
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            Long oidCliente = null;
            oidCliente = localClientes.getOid();

            int i = 1;
            Long[] oids = new Long[i];
            oids[0] = oidCliente;

            DTOOIDs dtoClientes = new DTOOIDs();
            dtoClientes.setOids(oids);
            // 22029 - dmorello, 02/05/2006: Se setea país en el DTO
            dtoClientes.setOidPais(DTOE.getOidPais());

            Vector valores = null;

            DTOMensajeImpresion[] dtoMensaG2 = this.obtenerMensajesG2(dtoMensajeInicial);

            DTOMensajeImpresion[] dtoMensa = this.obtenerRestoMensajes(dtoMensajeInicial);

            if ((dtoMensaG2.length == 0) && (dtoMensa.length == 0)) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0022));
            }

            DTOImpresion[] dtoMensajesFinal = 
            this.crearDTOMensajesFinal(new Integer(0),DTOE.getOidPeriodo(), 
            dtoClientes, dtoMensa, dtoMensaG2);

            int finalMen = dtoMensajesFinal.length;
            /*
             * dmorello, 07/02/2006
             * Si se da el caso de que finalMen == 0, debe lanzarse una excepción
             * para que aparezca en pantalla el cartel de que no se recuperaron
             * registros, en lugar de la lista de resultados vacía.
             */
            if (finalMen == 0) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0022));
            }
            
            String texto = null;
            Long auxMensajeAnterior = null;

            RecordSet listaTextos = new RecordSet();
            listaTextos.addColumn("CODIGO");
            listaTextos.addColumn("TEXTO");

            /*
             * BELC300024066 - dmorello, 04/09/2006
             * Se modifica el siguiente ciclo para que las líneas de un mensaje
             * con parte repetible queden concatenadas en un solo elemento
             * del RecordSet
             */
            for (int t = 0; t < finalMen; t++) {
            
                UtilidadesLog.debug("Texto de la posicion a procesar: " + dtoMensajesFinal[t].getTexto());
                UtilidadesLog.debug("auxMensajeAnterior: " + auxMensajeAnterior);
                
                if (dtoMensajesFinal[t].getOidTipoMensaje().longValue() == 
                        ConstantesMSG.OID_TIPO_G1.longValue() ) {
                        
                    UtilidadesLog.debug("El mensaje es de tipo G1");
                        
                    Parseador parse = Parseador.getInstance();
                    String auxTexto = parse.sustituirEtiquetasVariables(dtoMensajesFinal[t].getTexto(), dtoMensajesFinal[t]);
                    if (dtoMensajesFinal[t].getOidMensaje().equals(auxMensajeAnterior)) {
                        // Si se trata de otra línea del mismo mensaje, concateno el texto
                        texto += auxTexto;
                    } else {
                        // Si es la primera línea del mensaje, tomo todo el texto
                        texto = auxTexto;
                    }
                }
                else {
                    UtilidadesLog.debug("El mensaje es de tipo G2");
                    texto = dtoMensajesFinal[t].getTexto();
                }
                
                // Agrego al RecordSet solo cuando el siguiente OID de mensaje
                // es diferente al actual, o si estoy en el último elemento
                if ( (t + 1 < finalMen && ! (dtoMensajesFinal[t+1].getOidMensaje().equals(dtoMensajesFinal[t].getOidMensaje())) )
                        || t + 1 == finalMen) {
                        
                  UtilidadesLog.debug("Agrego al recordset: " + texto);
                
                  valores = new Vector();
                  valores.add(texto);
                  listaTextos.addRow(valores);
                }
                auxMensajeAnterior = dtoMensajesFinal[t].getOidMensaje();
            }

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(listaTextos);

            UtilidadesLog.debug("dtoSalida: " + dtoSalida.toString());

            UtilidadesLog.info("MONImpresionMensajesBean.consultarMensajesPorConsultora(DTOSeleccionMensajes DTOE): Salida");

            return dtoSalida;
        }
        catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            
            UtilidadesLog.error(e);
            
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void actualizarMensajesFacturacion(ArrayList DTOE, Long numeroLote) throws MareException {
        UtilidadesLog.info("MONImpresionMensajesBean.actualizarMensajesFacturacion(DTOImpresion[] DTOE, Long numeroLote): Entrada");
            
        try {   
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < DTOE.size(); i++) {
                DTOImpresion dtoe = (DTOImpresion) DTOE.get(i);
                if (dtoe.getOidBuzon() != null) {
                    Long activo = null;
                    if (dtoe.getOidTipoPermanencia().longValue() == 
                        ConstantesMSG.OID_PERMANENCIA_U.longValue()) {
                        activo = new Long(ConstantesMSG.IND_INACTIVO.longValue());
                    }
                    else {
                        activo = new Long(ConstantesMSG.IND_ACTIVO.longValue());
                    }
                    sb.append(generaUpdateBuzonMensaje(dtoe.getOidPeriodo(), numeroLote, new Long(ConstantesMSG.IND_ACTIVO.longValue()), activo, dtoe.getOidBuzon()));
                }
            }
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
        }catch (Exception ex) {
            UtilidadesLog.error("ERROR",ex);
            throw new MareException(ex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONImpresionMensajesBean.actualizarMensajesFacturacion(DTOImpresion[] DTOE, Long numeroLote): Salida");
    }
    
    private StringBuffer generaUpdateBuzonMensaje (Long periodo, Long numeroLote, Long estadoMensaje, Long activo, Long oid){
        StringBuffer sb = new StringBuffer();
        sb.append("update msg_buzon_mensa f  set ");
        sb.append(" f.IND_ACTI = "+activo);
        sb.append(" , f.FEC_IMPR = sysdate ");
        sb.append(" , f.IND_ESTA_MENS = "+estadoMensaje);
        sb.append(" , f.PERI_OID_PERI = "+periodo); 
        sb.append(" , f.NUM_LOTE_IMPR =  "+numeroLote);
        sb.append(" where f.OID_BUZO_MENS = "+oid);
        sb.append(";");
        return sb;
    }

    public Boolean existeOrdenCompra(DTOFACConsolidado DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.existeOrdenCompra(DTOFACConsolidado DTOE): Entrada");
            
        //Se comprueba si alguna de las solicitudes del consolidado es del tipo orden de compra 
        //finalSoli = tamaño del DTOConsolidado.listaSolicitudes 
        //encontrado = false 
        int finalSoli = DTOE.getListaSolicitudes().size();
        boolean encontrado = false;
        int k = 0;

        while ((k < finalSoli) && !encontrado) {
            encontrado = ((DTOFACCabeceraSolicitud) DTOE.getListaSolicitudes().get(k)).getIndicadorOrdenCompra().booleanValue();
            k++;
        }

        UtilidadesLog.info("MONImpresionMensajesBean.existeOrdenCompra(DTOFACConsolidado DTOE): Salida");

        return new Boolean(encontrado);
    }

    /**
       * Modificado por dmorello, 24/08/2006
       * con motivo de incidencia BELC300024066
       * @author mbobadilla
       * @param i
       * @param dtoClientes
       * @param DTOMensa
       * @param dtoMensaG2
       * @return
       * @throws es.indra.mare.common.exception.MareException
       * Crea un dtoMensajesFinal del tipo DTOImpresion con los mensajes 
       * del cliente que deben imprimirse
       */
    public DTOImpresion[] crearDTOMensajesFinal(Integer i, Long oidPeriodo, DTOOIDs dtoClientes, DTOMensajeImpresion[] DTOMensa, DTOMensajeImpresion[] dtoMensaG2) throws MareException {

        UtilidadesLog.info("MONImpresionMensajesBean.crearDTOMensajesFinal(Integer i, Long oidPeriodo, DTOOIDs dtoClientes, DTOMensajeImpresion[] DTOMensa, DTOMensajeImpresion[] dtoMensaG2): Entrada");
        
        // Genero trazas de los arrays de DTOMensajeImpresion que recibo
        UtilidadesLog.debug("DTOMensa: " + this.arrayToString(DTOMensa));
        UtilidadesLog.debug("dtoMensaG2: " + this.arrayToString(dtoMensaG2));

        try {
            Vector buzon = new Vector();
            Long[] dtoClientesOid = dtoClientes.getOids();
            //DTOBuzonImpresion buzonImpresion = new DTOBuzonImpresion();
            int j = 0;
            int k = 0;
            Vector nMensaje = new Vector();
            boolean imprimirMensaje = false;
            
            if (DTOMensa != null && DTOMensa.length > 0) {
                //UtilidadesLog.debug("DTOMensa es diferente de null " + DTOMensa.length);
                
                if (DTOMensa[j] != null) {
                    //buzon.add(DTOMensa[j].getBuzon());
                    //UtilidadesLog.debug(" DTOMensa["+j+"] es diferente de null....");
                    
                    if (DTOMensa[j].getBuzon() != null) {                       
                        // Modificado por ssantana, 7/9/2005, inc. 20617
                        DTOBuzonImpresion buzonImpresion = (DTOBuzonImpresion) DTOMensa[j].getBuzon().get(k);
                        Long oidClienteBuzon = buzonImpresion.getOidCliente();
                        Long oidClienteDTO =  dtoClientesOid[i.intValue()];
                        int tamanyoDTOMensa = DTOMensa.length;
                        while ( (oidClienteDTO.equals(oidClienteBuzon)) && 
                                (j < tamanyoDTOMensa) &&
                                (DTOMensa[j] != null) ) {

                            //UtilidadesLog.debug(" Al while con j= " + j + " y k = " + k);                                   
                            //UtilidadesLog.debug("DTOMensa[" + j+ "]: " + DTOMensa[j]);    
                            
                            imprimirMensaje = true;
                            
                            if (DTOMensa[j].getOidTipoPermanencia().longValue() == ConstantesMSG.OID_PERMANENCIA_H.longValue()) {
                                if ((new Long(DTOMensa[j].getCodigoPeriodoInicial()).longValue() >= new Long(DTOMensa[j].getCodigoPeriodoDesde()).longValue()) &&
                                        (new Long(DTOMensa[j].getCodigoPeriodoInicial()).longValue() <= new Long(DTOMensa[j].getCodigoPeriodoHasta()).longValue())) {
                                    imprimirMensaje = true;
                                } else {
                                    imprimirMensaje = false;
                                }
                            }
                            
                            if (DTOMensa[j].getOidTipoPermanencia().longValue() == ConstantesMSG.OID_PERMANENCIA_R.longValue()) {
                                if (this.compararFecha(DTOMensa[j].getFechaPermanenciaDesde(), DTOMensa[j].getFechaPermanenciaHasta())) {
                                    imprimirMensaje = true;
                                } else {
                                    imprimirMensaje = false;
                                }
                            }

                            //----------------------------7
                            if (imprimirMensaje) {
                                //int finalBuzon = buzon.size();
                                
                                /*
                                 * DBLG400000397 - dmorello, 13/03/2006
                                 * Se considerará la posibilidad de buzon nulo
                                 */
                                if (DTOMensa[j].getBuzon() != null) {
                                
                                  /*
                                   * dmorello, 23/08/2006 - BELC300024066
                                   * Con motivo de este cambio, se modifica el siguiente ciclo
                                   * a fin de imprimir correctamente las partes fijas y repetibles
                                   * (sin repetir tambien las partes fijas del mensaje).
                                   */
                                  
                                  int cantCabec = this.contarCabeceras(DTOMensa[j].getTexto());
                                  UtilidadesLog.debug("cantCabec: " + cantCabec);
                                  String[] strMensaje = this.configurarMensaje(DTOMensa[j].getTexto());
                                    
                                  for (int z = 0; z < strMensaje.length; z++) { 
                                  
                                    UtilidadesLog.debug("Posicion a procesar: " + strMensaje[z]);
                                    String strParteVar = null;
                                    if (cantCabec != 0) {
                                        strParteVar = this.quitarParteFija(strMensaje[z]);
                                    }
                                    
                                    int finalBuzon = DTOMensa[j].getBuzon().size();
                                    
                                    //--------------6------------------
                                    while (k < finalBuzon) {
                                        //-----------5------------------
                                        buzonImpresion = (DTOBuzonImpresion) DTOMensa[j].getBuzon().get(k);                                    
                                        if ( (buzonImpresion.getIndActivo() != null) && buzonImpresion.getIndActivo().intValue() == 1) {
                                            DTOImpresion DtoMensajesFinal = new DTOImpresion();
    
                                            /** PARA SETEARLE EL VALOR ******   VER EN EL MODELO*/
                                            DtoMensajesFinal.setOidIdioma(dtoClientes.getOidIdioma());
                                            DtoMensajesFinal.setOidPais(dtoClientes.getOidPais());
                                            DtoMensajesFinal.setOidMensaje(DTOMensa[j].getOidMensaje());
                                            DtoMensajesFinal.setOidTipoMensaje(DTOMensa[j].getOidTipoMensaje());
                                            //DtoMensajesFinal.setTexto(DTOMensa[j].getTexto());
                                            
                                            if (cantCabec == 0) {
                                                // No hay partes marcadas como fijas, se asigna directamente el texto
                                                DtoMensajesFinal.setTexto(strMensaje[z]);
                                            } else {
                                                // Hay partes marcadas como fijas
                                                String textoAux;
                                                if (k == 0) {
                                                    // Es la 1ra linea que contiene la parte fija, la imprimo sin los tags
                                                    textoAux = this.quitarTags(strMensaje[z]);
                                                } else  {
                                                    // Si no es la 1ra linea, quito la parte fija
                                                    textoAux = strParteVar;
                                                }
                                                DtoMensajesFinal.setTexto(textoAux);
                                            }
                                            UtilidadesLog.debug("Texto asignado: " + DtoMensajesFinal.getTexto());
                                            
                                            DtoMensajesFinal.setOidTipoPermanencia(DTOMensa[j].getOidTipoPermanencia());
                                            DtoMensajesFinal.setOidBuzon(buzonImpresion.getOidBuzon());
                                            DtoMensajesFinal.setOidCliente(dtoClientesOid[i.intValue()]);
                                            DtoMensajesFinal.setNumeroSecuencia(buzonImpresion.getNumeroSecuencia());
                                            DtoMensajesFinal.setOidPeriodo(oidPeriodo);
                                            DtoMensajesFinal.setDatoVariable1(buzonImpresion.getDatoVariable1());
                                            DtoMensajesFinal.setDatoVariable2(buzonImpresion.getDatoVariable2());
                                            DtoMensajesFinal.setDatoVariable3(buzonImpresion.getDatoVariable3());
                                            DtoMensajesFinal.setDatoVariable4(buzonImpresion.getDatoVariable4());
                                            DtoMensajesFinal.setDatoVariable5(buzonImpresion.getDatoVariable5());
                                            DtoMensajesFinal.setDatoVariable6(buzonImpresion.getDatoVariable6());
                                            DtoMensajesFinal.setDatoVariable7(buzonImpresion.getDatoVariable7());
                                            DtoMensajesFinal.setDatoVariable8(buzonImpresion.getDatoVariable8());
                                            DtoMensajesFinal.setDatoVariable9(buzonImpresion.getDatoVariable9());
                                            DtoMensajesFinal.setDatoVariable10(buzonImpresion.getDatoVariable10());
                                            DtoMensajesFinal.setDatoVariable11(buzonImpresion.getDatoVariable11());
                                            DtoMensajesFinal.setDatoVariable12(buzonImpresion.getDatoVariable12());
                                            DtoMensajesFinal.setDatoVariable13(buzonImpresion.getDatoVariable13());
                                            DtoMensajesFinal.setDatoVariable14(buzonImpresion.getDatoVariable14());
                                            DtoMensajesFinal.setDatoVariable15(buzonImpresion.getDatoVariable15());
                                            DtoMensajesFinal.setDatoVariable16(buzonImpresion.getDatoVariable16());
                                            DtoMensajesFinal.setDatoVariable17(buzonImpresion.getDatoVariable17());
                                            DtoMensajesFinal.setDatoVariable18(buzonImpresion.getDatoVariable18());
                                            DtoMensajesFinal.setDatoVariable19(buzonImpresion.getDatoVariable19());
                                            DtoMensajesFinal.setDatoVariable20(buzonImpresion.getDatoVariable20());
                                            //UtilidadesLog.info("dtoMensaFinal 1: " + DtoMensajesFinal);
                                            nMensaje.add(DtoMensajesFinal);
                                        } //--------------fin 5-------
                                        if (strParteVar != null && strParteVar.length() == 0) {
                                          // Si la parte actual del texto es una parte fija sin detalle,
                                          // se fuerza la salida del ciclo para no repetir lineas de detalle vacias
                                          k = finalBuzon;
                                        } else {
                                          // Si hay parte repetible, se continua imprimiendo
                                          k++;
                                        }
                                    } //------fin 6---------
                                    k = 0;
                                  }
                                }
                            } //-----Fin 7

                            j++;
                            k = 0;
                        }
                    }

                } //Fin de si hay datos de G1
            }
            
            UtilidadesLog.debug("--- Fin Proceso Primer Parte de Mensajes");
            UtilidadesLog.debug("--- Cantidad de mensajes: " + nMensaje.size());
            //--------------fin 8------------------------
            int finalG2 = dtoMensaG2.length;

            //------------------------1-----------------------
            Vector destinatarios = new Vector();
            
            UtilidadesLog.debug("dtoMensaG2.length: " + dtoMensaG2.length);
            DTOMensajeUnidadAdministrativa dtoUA = this.obtenerUACliente(dtoClientesOid[i.intValue()]);
            DTOOID dtoCliente = new DTOOID();
            dtoCliente.setOid(dtoClientesOid[i.intValue()]);
            dtoCliente.setOidPais(dtoClientes.getOidPais());
            DTOMensajeTipoCliente[] dtoTipifi = this.obtenerTipificacionCliente(dtoCliente);
            DTOMensajeMarca[] dtoMarca = obtenerMarcasCliente(dtoClientesOid[i.intValue()]);
            
            for (int m = 0; m < finalG2; m++) {
                if (dtoMensaG2[m].getDestinatario() != null) {
                    destinatarios = dtoMensaG2[m].getDestinatario();

                    //UtilidadesLog.debug("dtoMensaG2[" + m + "]: " + dtoMensaG2[m]);

                    int finalDesti = destinatarios.size();

                    //-----------------------2-----------------
                    //UtilidadesLog.debug("destinatarios.size(): " + destinatarios.size());

                    for (int n = 0; n < finalDesti; n++) {
                        if (destinatarios.get(n) != null) {
                            DTODestinatarioMensaje dest = (DTODestinatarioMensaje) destinatarios.get(n);
                            //UtilidadesLog.info("antes de preguntar si el destinatario es unidad administrativa");
                            if (dest.getOidTipoDestinatario().longValue() == ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA.longValue()) {
                                //DTOMensajeUnidadAdministrativa dtoUA = this.obtenerUACliente(dtoClientesOid[i.intValue()]);
                                /*
                                 * INC 22026 - dmorello, 26/01/2006
                                 * Si dtoUA es null, imprimirMensaje será false
                                 */
                                if (dtoUA != null) {
                                    dtoUA.setOid(dtoMensaG2[m].getOidMensaje());
                                    DAOImpresion dao = new DAOImpresion();
                                    imprimirMensaje = dao.existeUnidadAdministrativa(dtoUA).booleanValue();
                                } else {
                                    imprimirMensaje = false;
                                }
                            }

                            //-----------------3---------------
                            if (dest.getOidTipoDestinatario().longValue() == ConstantesMSG.OID_CLASIFICACION_CLIENTE.longValue()) {
                                UtilidadesLog.debug("cliente");
                                int finalTipifi = dtoTipifi.length;
                                DAOImpresion dao = new DAOImpresion();

                                // verifico exclusion de tipologia de cliente. incidencia 20070203.
                                if (dtoMensaG2[m].getExclusionTipologia().booleanValue()) {
                                    // si alguna tipificacion del cliente esta definida en el mesanje, entonces NO imprime.
                                    imprimirMensaje = true;
                                    for (int t = 0; t < finalTipifi; t++) {
                                        if ( ! imprimirMensaje) {
                                            break;
                                        }
                                        dtoTipifi[t].setOid(dtoMensaG2[m].getOidMensaje());
                                        imprimirMensaje = ! dao.existeTipificacionCliente(dtoTipifi[t]).booleanValue();
                                    }
                                } else {
                                    // si alguna tipificacion del cliente esta definida en el mesanje, entonces imprime.
                                    imprimirMensaje = false;
                                    for (int t = 0; t < finalTipifi; t++) {
                                        if (imprimirMensaje) {
                                            break;
                                        }
                                        dtoTipifi[t].setOid(dtoMensaG2[m].getOidMensaje());
                                        imprimirMensaje = dao.existeTipificacionCliente(dtoTipifi[t]).booleanValue();
                                    }
                                }

                            }

                            //-----------fin3---------------
                            //-------------4------------------
                            if (dest.getOidTipoDestinatario().longValue() == ConstantesMSG.OID_MARCA.longValue()) {
                                UtilidadesLog.debug("marca");

                                //DTOMensajeMarca[] dtoMarca = obtenerMarcasCliente(dtoClientesOid[i.intValue()]);

                                int finalMarcas = dtoMarca.length;
                                imprimirMensaje = false;

                                DAOImpresion dao = new DAOImpresion();

                                for (int t = 0; t < finalMarcas; t++) {
                                    if (imprimirMensaje) {
                                        break;
                                    }

                                    //if(!imprimirMensaje){
                                    dtoMarca[t].setOid(dtoMensaG2[m].getOidMensaje());

                                    //}
                                    imprimirMensaje = dao.existeMarca(dtoMarca[t]).booleanValue();
                                }
                            }

                            //-------------fin 4----------------
                        }
                    }
                    
                    if (imprimirMensaje)  {
                        UtilidadesLog.debug(" Antes de permanencia H en G2 ");
                        
                        if (dtoMensaG2[m].getOidTipoPermanencia().longValue() == ConstantesMSG.OID_PERMANENCIA_H.longValue())  {
                            if ((Long.valueOf(dtoMensaG2[m].getCodigoPeriodoInicial()).longValue()  >=  Long.valueOf(dtoMensaG2[m].getCodigoPeriodoDesde()).longValue())  &&
                                (Long.valueOf(dtoMensaG2[m].getCodigoPeriodoInicial()).longValue() <=  Long.valueOf(dtoMensaG2[m].getCodigoPeriodoHasta()).longValue()))  {
                                imprimirMensaje = true;
                            } else {
                                imprimirMensaje = false;
                            }
                            
                        }
                        
                        if (dtoMensaG2[m].getOidTipoPermanencia().longValue() == ConstantesMSG.OID_PERMANENCIA_R.longValue()) {
                            if (this.compararFecha(dtoMensaG2[m].getFechaPermanenciaDesde(), dtoMensaG2[m].getFechaPermanenciaHasta())) {
                                imprimirMensaje = true;
                            } else {
                                imprimirMensaje = false;
                            }
                        }
                    }
                    
                    //UtilidadesLog.debug("Resulto imprimirMensaje:  " + imprimirMensaje);

                    //-----fin 2--------------
                    if (imprimirMensaje) {
                        UtilidadesLog.debug("imprimirMensaje true");

                        DTOImpresion DtoMensajesFinal = new DTOImpresion();
                        
                        //UtilidadesLog.debug("DTOMensa[j]>>> " + dtoMensaG2[m]);

                        if (dtoMensaG2[m].getOidMensaje() != null) {
                            DtoMensajesFinal.setOidMensaje(dtoMensaG2[m].getOidMensaje());
                        }

                        if (dtoMensaG2[m].getOidTipoMensaje() != null) {
                            DtoMensajesFinal.setOidTipoMensaje(dtoMensaG2[m].getOidTipoMensaje());
                        }

                        if (dtoMensaG2[m].getTexto() != null) {
                            DtoMensajesFinal.setTexto(dtoMensaG2[m].getTexto());
                        }

                        if (dtoMensaG2[m].getOidTipoPermanencia() != null) {
                            DtoMensajesFinal.setOidTipoPermanencia(dtoMensaG2[m].getOidTipoPermanencia());
                        }

                        //EL MODELO DICE QUE SE PASA NULL
                        /*if (buzonImpresion.getOidBuzon() != null) {
                            DtoMensajesFinal.setOidBuzon(buzonImpresion.getOidBuzon());
                        }*/

                        if (dtoClientesOid[i.intValue()] != null) {
                            DtoMensajesFinal.setOidCliente(dtoClientesOid[i.intValue()]);
                        }
                        
                        if(oidPeriodo!=null) {
                            DtoMensajesFinal.setOidPeriodo(oidPeriodo);
                        }

                        //EL MODELO DICE QUE SE PASA CERO
                        /*if (buzonImpresion.getNumeroSecuencia() != null) {
                            DtoMensajesFinal.setNumeroSecuencia(buzonImpresion.getNumeroSecuencia());
                        }*/                       

                        DtoMensajesFinal.setOidIdioma(dtoClientes.getOidIdioma());
                        
                        //UtilidadesLog.debug("dtoMensaFinal 2: " + DtoMensajesFinal);
                        
                        nMensaje.add(DtoMensajesFinal);
                    }
                }
            }

            //-------------fin 1--------------------------
            DTOImpresion[] dtoMensajesFinal = new DTOImpresion[nMensaje.size()];
            
            //UtilidadesLog.debug("nMensaje.size(): " + nMensaje.size());

            for (int x = 0; x < nMensaje.size(); x++) {
                dtoMensajesFinal[x] = (DTOImpresion) nMensaje.get(x);
            }

            UtilidadesLog.debug("este es el dto final: " + this.arrayToString(dtoMensajesFinal));
            UtilidadesLog.info("MONImpresionMensajesBean.crearDTOMensajesFinal(Integer i, Long oidPeriodo, DTOOIDs dtoClientes, DTOMensajeImpresion[] DTOMensa, DTOMensajeImpresion[] dtoMensaG2): Salida");

            return dtoMensajesFinal;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            
            throw new MareException(e);
        }
    }

    boolean compararFecha(java.util.Date fecha1, java.util.Date fecha2) {
    
        UtilidadesLog.info("MONImpresionMensajesBean.compararFecha(java.util.Date fecha1, java.util.Date fecha2): Entrada");
    
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //int[] ArrayFechaSistema = new int[3];
        //int[] ArrayFechaPermanenciaDesde = new int[3];
        //int[] ArrayFechaPermanenciaHasta = new int[3];

        //ArrayFechaSistema = splitFecha(formato.format(new java.util.Date()));
        //ArrayFechaPermanenciaDesde = splitFecha(formato.format(fecha1));
        //ArrayFechaPermanenciaHasta = splitFecha(formato.format(fecha2));       

        //Integer exp1 = new Integer(ArrayFechaSistema[2] + ArrayFechaSistema[1] + ArrayFechaSistema[0]);
        //Integer exp2 = new Integer(ArrayFechaPermanenciaDesde[2] + ArrayFechaPermanenciaDesde[1] + ArrayFechaPermanenciaDesde[0]);
        //Integer exp3 = new Integer(ArrayFechaPermanenciaHasta[2] + ArrayFechaPermanenciaHasta[1] + ArrayFechaPermanenciaHasta[0]);

        boolean valor = false;
        java.util.Date fechaSistema = new java.util.Date();
        
        if(fechaSistema.equals(fecha1) || fechaSistema.equals(fecha2)) {
            valor = true;
        }
        else if(fechaSistema.after(fecha1) && fechaSistema.before(fecha2)) {
            valor = true;
        }

        //if ((exp1.intValue() >= exp2.intValue()) && (exp1.intValue() <= exp3.intValue())) {
        //    valor = true;
        //} else {
        //    valor = false;
        //}

        UtilidadesLog.info("MONImpresionMensajesBean.compararFecha(java.util.Date fecha1, java.util.Date fecha2): Salida");

        return valor;
    }

    /**
      *metodo de apoyo ,a crear DTOMensajeFinal que descompone la fecha
      * dentro de una hashtable
      * @return Hashtable
      */
    /*private int[] splitFecha(String str) {
        String[] tok = str.split("/");
        int[] Array = new int[3];

        int i = 1;
        Integer mes = new Integer(0);
        Integer ano = new Integer(0);
        Integer dia = new Integer(0);

        // while(tok.hasMoreElements())
        for (int k = 0; k < tok.length; k++) {
            switch (i) {
                case 1:
                    dia = new Integer(tok[k]);
                    i++;

                    break;

                case 2:
                    mes = new Integer(tok[k]);
                    i++;

                    break;

                case 3:
                    ano = new Integer(str.substring(str.length() - 4, str.length()));
                    i++;

                    break;
            }
        }

        Array[0] = dia.intValue();
        Array[1] = mes.intValue();
        Array[2] = ano.intValue();

        return Array;
    }*/

    public DTOMensajeImpresion[] obtenerMensajesG2(DTOMensajeImpresion[] DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerMensajesG2(DTOMensajeImpresion[] DTOE): Entrada");
        UtilidadesLog.debug("DTOMensajeImpresion[] recibido: " + this.arrayToString(DTOE));

        Vector v = new Vector();
        int finalMen = DTOE.length;
        
        UtilidadesLog.debug("DTOE.length: " + DTOE.length);
        UtilidadesLog.debug("FINALMEN: " + finalMen);

        for (int i = 0; i < finalMen; i++) {
            if (DTOE[i].getOidTipoMensaje() != null) {
                if (DTOE[i].getOidTipoMensaje().intValue() == ConstantesMSG.OID_TIPO_G2.intValue()) {
                    v.add(DTOE[i]);
                }
            }
        }

        UtilidadesLog.debug("este es el size del vector: " + v.size());

        DTOMensajeImpresion[] dtoMensaG2 = new DTOMensajeImpresion[v.size()];

        // UtilidadesLog.info("DTOE>>>> " +dtoMensaG2);
        for (int i = 0; i < v.size(); i++) {
            DTOMensajeImpresion msj = (DTOMensajeImpresion) v.get(i);
            dtoMensaG2[i] = msj;
        }

        UtilidadesLog.info("MONImpresionMensajesBean.obtenerMensajesG2(DTOMensajeImpresion[] DTOE): Salida");

        return dtoMensaG2;
    }

    public DTOMensajeImpresion[] obtenerRestoMensajes(DTOMensajeImpresion[] DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerRestoMensajes(DTOMensajeImpresion[] DTOE): Entrada");
        UtilidadesLog.debug("DTOMensajeImpresion[] recibido: " + this.arrayToString(DTOE));
        
        //UtilidadesLog.debug("DTOE.length: " + DTOE.length);

        //DTOMensajeImpresion[] dtoMensa = new DTOMensajeImpresion[DTOE.length];
        int c = 0;

        for (int x = 0; x < DTOE.length; x++) {
            //UtilidadesLog.debug("DTOE[" + x + "]: " + DTOE[x]);
            if (DTOE[x].getOidTipoMensaje() != null) {
                if (DTOE[x].getOidTipoMensaje().intValue() != ConstantesMSG.OID_TIPO_G2.intValue()) {
                    c++;
                }
            }
        }
        
        //UtilidadesLog.debug("c == " + c);

        DTOMensajeImpresion[] dtoMensa = new DTOMensajeImpresion[c];

        if (c > 0) {
            int j = 0;

            for (int i = 0; i < DTOE.length; i++) {
                if (DTOE[i].getOidTipoMensaje() != null) {
                    //UtilidadesLog.debug("DTOE[i].getOidTipoMensaje(): " + DTOE[i].getOidTipoMensaje());
                    if (DTOE[i].getOidTipoMensaje().intValue() != ConstantesMSG.OID_TIPO_G2.intValue()) {
                       // UtilidadesLog.debug("asigno en dtoMensa: " + DTOE[i]);
                        dtoMensa[j] = DTOE[i];
                        j++;
                    }
                }
            }
            //UtilidadesLog.debug("Valor final de j == " + j);
        }

        UtilidadesLog.info("MONImpresionMensajesBean.obtenerRestoMensajes(DTOMensajeImpresion[] DTOE): Salida");

        return dtoMensa;
    }

    /**
     * @author mbobadill
     * @date 14/12/04
     * Recorre toda la estructura y obtiene un DTOOIDs con todos los clientes diferentes
     */
    public DTOOIDs obtenerClientes(DTOMensajeImpresion[] DTOE)
            throws RemoteException, MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerClientes(DTOMensajeImpresion[] DTOE): Entrada");
            
        /*
         * Documentation
                //Recorre toda la estructura y obtiene un DTOOIDs con todos los clientes diferentes

                Crear un dtoClientes del tipo DTOOIDs //para guardar la lista de clientes diferentes
                k=0
                clienteAnterior = -1
        */
        DTOOIDs dtoClientes = new DTOOIDs();

        Vector v = new Vector();

        // int k=0;
        int clienteAnterior = -1;

        //UtilidadesLog.info("La cantidad de elementos del DTO es" +  DTOE.length );
        for (int i = 0; i < DTOE.length; i++) {
            if (DTOE[i].getBuzon() != null) {
                int finalBuz = DTOE[i].getBuzon().size();

                //UtilidadesLog.info("La cantidad de buzones es " + DTOE[i].getBuzon().size());
                for (int j = 0; j < finalBuz; j++) {
                    if (DTOE[i].getBuzon() != null) {
                        DTOBuzonImpresion buzon = (DTOBuzonImpresion) DTOE[i].getBuzon().get(j);
                        Long bzoid = buzon.getOidCliente();

                        if (bzoid.intValue() != clienteAnterior) {
                            clienteAnterior = bzoid.intValue();

                            //UtilidadesLog.info("Agrego a vector");
                            v.add((Long) bzoid);

                            //oids[k]=new Long(bzoid.intValue());
                            //k++;
                        }
                    }
                }
            }
        }

        Long[] oids = new Long[v.size()];

        for (int i = 0; i < v.size(); i++) {
            //UtilidadesLog.info("Agrego a Array" + i);
            oids[i] = (Long) v.get(0);
        }

        dtoClientes.setOids(oids);

        UtilidadesLog.info("MONImpresionMensajesBean.obtenerClientes(DTOMensajeImpresion[] DTOE): Salida");

        // //UtilidadesLog.info("Obtengo Clientes normalmante");
        return dtoClientes;
    }

    /*
     * Pablo Perez
     * 15/12/2004
     * */
    public DTOMensajeUnidadAdministrativa obtenerUACliente(Long oidCliente)
            throws MareException {
        /*Documentation
          dtoUA = Llamar al método obtenerUACliente (oidCliente)
          Devuelve el dtoUA
         */
        DAOImpresion daoImpresion = new DAOImpresion();

        return daoImpresion.obtenerUACliente(oidCliente);
    }

    public DTOMensajeTipoCliente[] obtenerTipificacionCliente(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerTipificacionCliente(DTOOID DTOE): Entrada");
            
        ////Obtiene las tipificaciones del cliente
        DAOImpresion daoImpresion = new DAOImpresion();
        RecordSet tipificacion = daoImpresion.obtenerTipificacionCliente(DTOE);

        //Crear un dtoTipificacion del tipo DTOMensajeTipoCliente[] y rellenar con cada uno de los registros
        //del recordset:
        DTOMensajeTipoCliente[] dtoMensajeTipoCliente = new DTOMensajeTipoCliente[tipificacion.getRowCount()];

        for (int i = 0; i < tipificacion.getRowCount(); i++) {
            dtoMensajeTipoCliente[i] = new DTOMensajeTipoCliente();

            if (tipificacion.getValueAt(i, "TICL_OID_TIPO_CLIE") != null) {
                dtoMensajeTipoCliente[i].setOidTipoCliente(bigDecimalToLong(tipificacion.getValueAt(i, "TICL_OID_TIPO_CLIE")));
            }

            if (tipificacion.getValueAt(i, "SBTI_OID_SUBT_CLIE") != null) {
                dtoMensajeTipoCliente[i].setOidSubtipoCliente(bigDecimalToLong(tipificacion.getValueAt(i, "SBTI_OID_SUBT_CLIE")));
            }

            if (tipificacion.getValueAt(i, "TCCL_OID_TIPO_CLASI") != null) {
                dtoMensajeTipoCliente[i].setOidTipoClasificacion(bigDecimalToLong(tipificacion.getValueAt(i, "TCCL_OID_TIPO_CLASI")));
            }

            if (tipificacion.getValueAt(i, "CLAS_OID_CLAS") != null) {
                dtoMensajeTipoCliente[i].setOidClasificacion(bigDecimalToLong(tipificacion.getValueAt(i, "CLAS_OID_CLAS")));
            }
        }

        UtilidadesLog.info("MONImpresionMensajesBean.obtenerTipificacionCliente(DTOOID DTOE): Salida");

        return dtoMensajeTipoCliente;
    }

    public DTOMensajeMarca[] obtenerMarcasCliente(Long oidCliente)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerMarcasCliente(Long oidCliente): Entrada");
            
        //Obtiene las marcas del cliente 
        DAOImpresion daoImpresion = new DAOImpresion();

        //marcas = llamar al método obtenerMarcasCliente(oidCliente) del DAOImpresion 
        RecordSet marcas = daoImpresion.obtenerMarcasCliente(oidCliente);
        DTOMensajeMarca[] dtoMensajeMarca = new DTOMensajeMarca[marcas.getRowCount()];

        //Crear un dtoMarcas del tipo DTOMarcaMensaje[] y añadir cada marca del recordset "marcas": 
        for (int i = 0; i < marcas.getRowCount(); i++) {
            dtoMensajeMarca[i] = new DTOMensajeMarca();
            dtoMensajeMarca[i].setOidMarca(bigDecimalToLong(marcas.getValueAt(i, 0)));
        }

        //dtoMarcas[i].oidMarca = marcas.oidMarca 
        
        UtilidadesLog.info("MONImpresionMensajesBean.obtenerMarcasCliente(Long oidCliente): Salida");
        
        return dtoMensajeMarca;
    }

    public DTODocumento simularMensajes(DTOSeleccionMensajes DTOE)
            throws RemoteException, MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.simularMensajes(DTOSeleccionMensajes DTOE): Entrada");

        /*Documentation
        //Se imprimen los mensajes del patrón seleccionado, si se ha seleccionado
        un cliente, entonces se imprimirán los mensajes que existan para ese
        cliente y en caso contrario para todos los clientes que tengan los
        mensajes del patrón (que estén en el buzón de mensajes)
        */

        //ClienteDatosBasicosLocalHome clienteDBHome = null;
        //ClienteDatosBasicosLocal clienteDBLocal = null;
        ClienteDatosBasicosLocalHome clientesHome = null;
        ClienteDatosBasicosLocal localClientes = null;
        DTODocumento dtoDocumento = new DTODocumento();

        try {
            clientesHome = new ClienteDatosBasicosLocalHome();
            localClientes = clientesHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCodigoCliente());
            DTOE.setOidCliente(localClientes.getOid());
            
            UtilidadesLog.debug("este es el cliente: " + localClientes.getOid());

            Date fechaProceso = new Date(System.currentTimeMillis());
            DAOImpresion daoImpresion = new DAOImpresion();
            DTOMensajeImpresion[] dtoMensajeInicial = daoImpresion.obtenerMensajesImpresionPorPatron(DTOE);
            
            UtilidadesLog.debug("contenido >>>> " + dtoMensajeInicial.length);

            if (dtoMensajeInicial.length == 0) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0019));
            }

            Long oidCliente = localClientes.getOid();

            //Long oidCliente = new Long(1);   
            Long[] vClientes = new Long[1];
            vClientes[0] = oidCliente;

            DTOOIDs dtoClientes = new DTOOIDs();
            dtoClientes.setOids(vClientes);
            dtoClientes.setOidIdioma(DTOE.getOidIdioma());
            dtoClientes.setOidPais(DTOE.getOidPais());

            DTOMensajeImpresion[] dtoMensaG2 = obtenerMensajesG2(dtoMensajeInicial);
            DTOMensajeImpresion[] dtoMensa = obtenerRestoMensajes(dtoMensajeInicial);

            /*Modificacion  -------------------------------------------------*/
            if ((dtoMensaG2.length == 0) && (dtoMensa.length == 0)) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0019));
            }

            /*Modificacion  -------------------------------------------------*/
            
            //Modificado por incidencia 11639
            DTOImpresion[] dtoMensajeFinal = 
            crearDTOMensajesFinal(new Integer(0), DTOE.getOidPeriodo(), 
            dtoClientes, dtoMensa, dtoMensaG2);
            //Modificado por incidencia 11639
            
            UtilidadesLog.debug("dtoMensajeFinal.length: " + dtoMensajeFinal.length);

            ArrayList aDtoMensajeFinal = new ArrayList();

            for (int i = 0; i < dtoMensajeFinal.length; i++) {
                aDtoMensajeFinal.add(dtoMensajeFinal[i]);
            }

            /*Se modifica Segun DT*/
            if (aDtoMensajeFinal.size() == 0) {
                throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0019));
            }

            /*Se modifica Segun DT*/
            MONImpresionSICCHome misHome = (MONImpresionSICCHome) 
            UtilidadesEJB.getHome("MONImpresionSICC", MONImpresionSICCHome.class);
            MONImpresionSICC mis = misHome.create();
            dtoDocumento = mis.getDocumentoMensajes(DTOE.getOidPatron(), aDtoMensajeFinal);
        }
        catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            
            /*
             * 22025 - dmorello, 10/05/2006: Dado que la FinderException puede lanzarse
             * sólo desde el find de ClienteDatosBasicos, se lanza acá la MareException
             * con el código correspondiente al mensaje de que no se halla el cliente.
             */
            throw new MareException(fe, 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0014));
        }
        catch (CreateException ce) {
            UtilidadesLog.error(ce);
            
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));            
        }
        catch (RemoteException re) {
            UtilidadesLog.error(re);
            
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            
            UtilidadesLog.error(e);
            
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONImpresionMensajesBean.simularMensajes(DTOSeleccionMensajes DTOE): Salida");

        return dtoDocumento;
    }

    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    private BuzonMensajesLocalHome getBuzonMensajesLocalHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (BuzonMensajesLocalHome) context.lookup("java:comp/env/BuzonMensajes");
    }

    /**
       *
       * @param DTOE
       * @return Boolean
       * @throws es.indra.mare.common.exception.MareException
       * @author mbobadill
       * @date 21/12/04
       * Se comprueba si existe alguno de los códigos de venta del consolidado del cliente en la
       * entidad MensajeCodigoVenta, ese código de venta se busca para cada solicitud del consolidado
       * que tenga tipo orden de compra
       *
       * 21/06/2005 - rgiorgi: inc. 19308
       */
    public Boolean existeCodigoVenta(DTOFACConsolidado DTOE, Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("MONImpresionMensajesBean.existeCodigoVenta(DTOFACConsolidado DTOE, Long oidMensaje): Entrada");
            
        boolean encontrado = false;

        //Se obtienen todos los códigos de venta asociados al mensaje que se está tratando 
        DAOImpresion dao = new DAOImpresion();
        RecordSet rs = dao.obtenerCodigosVenta(oidMensaje);

        int finalSoli = DTOE.getListaSolicitudes().size();
        int finalPosi = DTOE.getListaPosiciones().size();
        int finalVenta = rs.getRowCount();
        ArrayList solicitudes = DTOE.getListaSolicitudes();
        ArrayList posiciones = DTOE.getListaPosiciones();

        //Recorremos todas las solicitudes para ver las que son del tipo orden de compra 
        int k = 0;

        while ((k < finalSoli) && !encontrado) {
            DTOFACCabeceraSolicitud cSolic = (DTOFACCabeceraSolicitud) solicitudes.get(k);

            if (cSolic.getIndicadorOrdenCompra().booleanValue() == true) {
                //recorrer las posiciones de esa solicitud para ver si el código de venta que tiene asociado 
                //está en el recorset "codigosVenta" 
                int oidCabeceraSolicitud = cSolic.getOidCabeceraSolicitud().intValue();
                int I = 0;

                while ((I < finalPosi) && !encontrado) {
                    DTOFACPosicionSolicitud cPosic = (DTOFACPosicionSolicitud) posiciones.get(I);

                    if (cPosic.getOidCabecera().intValue() == oidCabeceraSolicitud) {
                        int m = 0;

                        while ((m < finalVenta) && !encontrado) {
                            //Para cada solicitud del cliente del tipo orden de compra, 
                            //se comprueba si el codigo de venta asociado está en el recordset "codigosVenta" 
                            if ((rs.getValueAt(m, "VAL_CODI_VENT") != null) &&
                                    (rs.getValueAt(m, "VAL_CODI_VENT").toString().equals(cPosic.getCodigoVenta()))) {
                                //cPosic.setCodigoVenta(rs.getValueAt(m,"VAL_CODI_VENT").toString());
                                encontrado = true;
                            }

                            m++;
                        }
                    } //if posiciones de cabecera

                    I++;
                } //bucle posiciones
            } //indicador orden de compra      

            k++;
        } //bucle solicitudes

        UtilidadesLog.info("MONImpresionMensajesBean.existeCodigoVenta(DTOFACConsolidado DTOE, Long oidMensaje): Salida");

        return (new Boolean(encontrado));
    }


    private MONProcesosPEDHome getMONProcesosPEDHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONProcesosPEDHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
    }
    
    /*private void imprimeDTOMensajeInicial(DTOMensajeImpresion[] dTOMensaInicial) throws MareException {
        UtilidadesLog.info("MONImpresionMensajesBean.imprimeDTOMensajeInicial(DTOMensajeImpresion[] dTOMensaInicial): Entrada");
    
        DTOMensajeImpresion dto = null;
      
        for (int i = 0; i < dTOMensaInicial.length; i++) {
            dto = dTOMensaInicial[i];
            
            UtilidadesLog.debug("DTOMensajeImpresion " + i + ": " + dto);
        }
        
        UtilidadesLog.info("MONImpresionMensajesBean.imprimeDTOMensajeInicial(DTOMensajeImpresion[] dTOMensaInicial): Salida");
    }*/
    
    
    private String arrayToString(Object[] array) {
        StringBuffer sb = new StringBuffer('{');
        for (int i = 0; i < array.length; i++) {
            sb.append(i).append('=').append(array[i]);
            if (i < array.length - 1)
                sb.append(',');
        }
        sb.append('}');
        return sb.toString();
    }
    

    /**
     * Cuenta las veces que aparece un String en otro.
     * @return cantidad de ocurrencias de queBuscar en dondeBuscar
     * @param queBuscar String cuyas ocurrencias se quiere contar
     * @param dondeBuscar String donde contar las ocurrencias
     */
    private int contarOcurrencias(String dondeBuscar, String queBuscar) {
        int count = 0;
        int desde = 0;
        int pos = -1;
        while (desde < dondeBuscar.length()) {
            if ((pos = dondeBuscar.indexOf(queBuscar, desde)) != -1) {
                count++;
                desde = pos + queBuscar.length();
            } else {
                break;
            }
        }
        return count;		
    }
    
	  /**
     * Devuelve el número de partes fijas (cabeceras) que tienen asociada una parte
     * repetible (detalle). Se toma como detalle todo el texto no delimitado por
     * los metacaracteres <fijo> </fijo>. Si el mensaje esta mal formado (no coinciden
     * la cantidad de <fijo> con la de </fijo>, o no se hallan alternados a lo largo
     * del texto), lanza una MareException
     * @return cantidad de partes fijas con parte repetible asociada
     * @param texto Texto del mensaje
     */
    private synchronized int contarCabeceras(String texto) throws MareException {
        UtilidadesLog.info("MONImpresionMensajesBean.contarCabeceras(String texto): Entrada");
		
	  		// 1. Verifico que el numero de tags de apertura
	  		//    coincida con el numero de tags de cierre
	  		int numTagsApertura = contarOcurrencias(texto,ConstantesMSG.TAG_FIJO_APERTURA);
	  		int numTagsCierre = contarOcurrencias(texto,ConstantesMSG.TAG_FIJO_CIERRE);
	  		if (numTagsApertura != numTagsCierre) {
            UtilidadesLog.error("Error de mensaje mal formado: "
                  + "#tags apertura <> #tags cierre");
            throw new MareException((Throwable)null, 
              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0025));
	  		}
		
			  // 2. Verifico que el orden de los tags sea el correcto
			  if (numTagsApertura > 0) {
				    int desdeAper = 0;
				    int desdeCierre = 0;
				    int[] todasPosAper = new int[numTagsApertura];
				    int[] todasPosCierre = new int[numTagsCierre];
			
				    // Verifico que todo tag de cierre este despues de uno de apertura
						// Si no se cumple, arrojo una excepcion
						for (int i = 0; i < numTagsApertura; i++) {
								todasPosAper[i] = texto.indexOf(ConstantesMSG.TAG_FIJO_APERTURA,desdeAper);
								todasPosCierre[i] = texto.indexOf(ConstantesMSG.TAG_FIJO_CIERRE,desdeCierre);
				
								if (todasPosAper[i] > todasPosCierre[i]) {
                    UtilidadesLog.error("Error de mensaje mal formado: "
                                + "orden incorrecto de tags 1");
                    throw new MareException((Throwable)null, 
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0025));
								}
				
								desdeAper = todasPosAper[i] + ConstantesMSG.TAG_FIJO_APERTURA.length();
								desdeCierre = todasPosCierre[i] + ConstantesMSG.TAG_FIJO_CIERRE.length();
						}
			
						// Verifico que el i-esimo tag de cierre este antes del
						// (i+1)-esimo tag de apertura. Si no se cumple, arrojo excepcion
						for (int i = 0; i < numTagsApertura - 1; ) {
								if (todasPosCierre[i] > todasPosAper[++i]) {
                    UtilidadesLog.error("Error de mensaje mal formado: "
                                + "orden incorrecto de tags 1");
                    throw new MareException((Throwable)null, 
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0025));
								}
						}
				}
		
				// El mensaje esta bien formado, devuelvo el numero de cabeceras
        UtilidadesLog.info("MONImpresionMensajesBean.contarCabeceras(String texto): Salida");
				return numTagsApertura;
		}
    
		/**
     * Devuelve un array de strings que contiene el texto del mensaje dividido
     * en partes, cada una conteniendo una parte fija (encabezado) y la parte
     * repetible (detalle) que tiene a continuación. Cada parte fija esta
     * delimitada por los metacaracteres <fijo> y </fijo>, representados por
     * constantes. Si el mensaje no tuviera estos metacaracteres, el array
     * contendra solo una posicion, con el texto sin modificar.
     * @return array de Strings con las partes del mensaje
     * @param texto Texto del mensaje a procesar
     */
    private synchronized String[] configurarMensaje(String texto) {
        UtilidadesLog.info("MONImpresionMensajesBean.configurarMensaje(String texto): Entrada");
		
        texto = texto.trim();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("Texto del mensaje: " + texto);
		
        // El siguiente split tendra tamaño 1 si no hay cabeceras
        // o sera de 2 o mas si hay alguna cabecera
        String[] array = texto.split(ConstantesMSG.TAG_FIJO_APERTURA);

        if (array.length > 1) {
          // Si tiene cabeceras, chequeo si hay texto antes del primer tag
          if (array[0].length() == 0) {
            // Creo un nuevo array sin la primera posicion
            String[] aux = new String[array.length - 1];
            for (int i = 1; i < array.length; i++) {
                      aux[i-1] = array[i];
            }
            array = aux;
          }
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010        
          UtilidadesLog.debug("Array a procesar: " + this.arrayToString(array));
		
        // Si corresponde, agrego el texto del tag de apertura que se perdio con el split
        StringBuffer sb = (array.length > 0)? new StringBuffer() : null;
        
        for (int i = 0; i < array.length; i++) {
            sb.delete(0,sb.length());
            sb.append(array[i]);
	    if ((i == 0 && texto.startsWith(ConstantesMSG.TAG_FIJO_APERTURA)) || (i != 0)) {
   	        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("Agrego el tag de apertura al inicio");
                  
                sb.insert(0,ConstantesMSG.TAG_FIJO_APERTURA);
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("sb antes de quitar retornos de linea del inicio" + sb);            
              
            while (sb.charAt(0) == '\n' || sb.charAt(0) == '\r') {
                sb.deleteCharAt(0);
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("sb antes de quitar retornos de linea del final" + sb);                        
              
            while (sb.charAt(sb.length() - 1) == '\n' || sb.charAt(sb.length() - 1) == '\r')  {
                sb.deleteCharAt(sb.length() - 1);
            }
            array[i] = sb.toString();
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("Array de strings final: " + this.arrayToString(array));

        UtilidadesLog.info("MONImpresionMensajesBean.configurarMensaje(String texto): Entrada");
	return array;
    }
    
	  /**
     * Quita los tags de inicio y final de parte fija del texto del mensaje.
     * Estos metacaracteres son <fijo> y </fijo>, representados por constantes.
     * De este modo, el texto del mensaje queda listo para enviar a FAC.
     * Requiere que previamente se haya invocado exitosamente contarCabeceras(texto)
     * @return texto del mensaje sin los tags de apertura y cierre
     * @param texto Texto del mensaje
     * @author dmorello
     */
    private synchronized String quitarTags(String texto)	 {
        UtilidadesLog.info("MONImpresionMensajesBean.quitarTags(String texto): Entrada");
        StringBuffer sb = new StringBuffer().append(texto);
        int index;
        while ((index = sb.indexOf(ConstantesMSG.TAG_FIJO_APERTURA)) != -1) {
          sb.delete(index, index + ConstantesMSG.TAG_FIJO_APERTURA.length());
        }
        while ((index = sb.indexOf(ConstantesMSG.TAG_FIJO_CIERRE)) != -1) {
          sb.delete(index, index + ConstantesMSG.TAG_FIJO_CIERRE.length());
        }
        
        if (sb.length() > 0) {
            char c;
            while ((c = sb.charAt(0)) == '\n' || c == '\r') {
              sb.deleteCharAt(0);
            }
            // while ((c = sb.charAt((index = sb.length() - 1))) == '\n' || c == '\r') {
            //  sb.deleteCharAt(index);
            //}
        }
        
        String strFinal = sb.toString();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("String sin los tags: " + strFinal);
          
        UtilidadesLog.info("MONImpresionMensajesBean.quitarTags(String texto): Salida");
		    return strFinal;
	  }
    
    /**
     * Quita la parte fija del texto de un mensaje. Esta parte fija esta
     * delimitada por los metacaracteres <fijo> y </fijo>, representados por
     * constantes. Se quita del texto del mensaje todo el texto comprendido
     * entre ambos metacaracteres, asi como los metacaracteres mismos.
     * @return texto del mensaje sin la parte fija
     * @param texto Texto del mensaje
     * @author dmorello
     */
    private synchronized String quitarParteFija(String texto) {
        UtilidadesLog.info("MONImpresionMensajesBean.quitarParteFija(String texto): Entrada");
        int start = texto.indexOf(ConstantesMSG.TAG_FIJO_APERTURA);
        int end = texto.indexOf(ConstantesMSG.TAG_FIJO_CIERRE) + ConstantesMSG.TAG_FIJO_CIERRE.length();
        StringBuffer sb = new StringBuffer().append(texto).delete(start,end);
        if (sb.length() > 0) {
            char c;
            while ((c = sb.charAt(0)) == '\n' || c == '\r') {
              sb.deleteCharAt(0);
            }
            //int index;
            //while ((c = sb.charAt((index = sb.length() - 1))) == '\n' || c == '\r') {
            //  sb.deleteCharAt(index);
            //}
        }
        String strFinal = sb.toString();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("String sin la parte fija: " + strFinal);
          
        UtilidadesLog.info("MONImpresionMensajesBean.quitarParteFija(String texto): Salida");
        return strFinal;
    }

    /**    
     *@Author: pperez 
     *@Fecha: 19/10/2006
     *@throws: MareException
     *@return: boolean
     *@param: DTOBuzonMensajes dto
     *@Observaciones: CAMBIO MSG-002
    */ 
    public boolean validarDestinatarioUA(DTOBuzonMensajes dto) throws MareException {
        UtilidadesLog.info("MONImpresionMensajesBean.validarDestinatarioUA(DTOBuzonMensajes dto): Entrada");
        boolean destinatarioValido = false;
        DTOMensajeUnidadAdministrativa dtoUA = this.obtenerUACliente(dto.getOidCliente());
        if (dtoUA != null)  {
            dtoUA.setOid(dto.getOidMensaje());
            destinatarioValido = new DAOImpresion().existeUnidadAdministrativa(dtoUA).booleanValue();
        }
        UtilidadesLog.info("MONImpresionMensajesBean.validarDestinatarioUA(DTOBuzonMensajes dto): Salida");
        return destinatarioValido;
    }

    /**    
     *@Author: pperez 
     *@Fecha: 19/10/2006
     *@throws: MareException
     *@return: boolean
     *@param: DTOBuzonMensajes dto
     *@Observaciones: CAMBIO MSG-002
    */ 
    public boolean validarDestinatarioTipoCliente(DTOBuzonMensajes dto) throws MareException {
        UtilidadesLog.info("MONImpresionMensajesBean.validarDestinatarioTipoCliente(DTOBuzonMensajes dto): Entrada");
        
        boolean destinatarioValido = false;        
        DTOOID dtoCliente = new DTOOID();
        
        dtoCliente.setOid(dto.getOidCliente());
        
        DTOMensajeTipoCliente[] dtoTipoClien = this.obtenerTipificacionCliente(dtoCliente);
        
        int cant = dtoTipoClien.length;
        
        for (int i=0; i<cant && !destinatarioValido; i++)  {
            dtoTipoClien[i].setOid(dto.getOidMensaje());
            destinatarioValido = new DAOImpresion().existeTipificacionCliente(dtoTipoClien[i]).booleanValue();
        }
        UtilidadesLog.info("MONImpresionMensajesBean.validarDestinatarioTipoCliente(DTOBuzonMensajes dto): Salida");
        return destinatarioValido;
    }
}

