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

/**
 * Sistema:		Belcorp
 * Modulo:	   	INT 
 * Fecha:		19/01/2007
 * @version		1.0
 * @autor		SPLATAS
 */
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTODetalleCaja;
import es.indra.sicc.dtos.intsys.DTODetalleCajaProducto;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import es.indra.sicc.dtos.intsys.DTOPedidoFacturadoAPicar;
import es.indra.sicc.dtos.intsys.DTOEtiquetaInduccionPTL;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.logicanegocio.ape.IAPE;
import es.indra.sicc.logicanegocio.ape.MONCrearListasInduccionPTL;
import es.indra.sicc.logicanegocio.ape.MONImpresionPTLLocal;
import es.indra.sicc.logicanegocio.ape.TaponAPE;
import es.indra.sicc.logicanegocio.intsys.ErroresDeNegocio;
import es.indra.sicc.dtos.ape.DTOAnaquelProductoAEnviar;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelCabecera;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.logicanegocio.ape.MONCrearListasInduccionPTLHome;
import javax.rmi.PortableRemoteObject;
import java.util.HashMap;
import es.indra.sicc.dtos.intsys.DTOCompararAsignacionAnaqueles;
import es.indra.sicc.dtos.intsys.DTODiferenciaAsignacion;

import es.indra.sicc.cmn.negocio.interfaces.HistoricoLotesLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.HistoricoLotesLocal;

import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.logicanegocio.MONReportesHome;
import es.indra.sicc.rep.logicanegocio.MONReportes;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.logicanegocio.ape.MONImpresionPTLLocalHome;

import es.indra.sicc.util.UtilidadesSession;

public class MONINTPTLBean implements SessionBean 
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
    }

    /**
     * Descripcion: PTL-1
     * @author SPLATAS - 20/01/2007
     * @observaciones
     *     BELC400000643 eiraola 23/Ago/2007 - No debe quedar en /temp cuando no hay datos.
     */
    public void enviarPedidosFacturadosAPicar(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONINTPTLBean.enviarPedidosFacturadosAPicar(DTOOID dtoE): Entrada");
        UtilidadesLog.debug("   - SAP601: DTOOID = " + dtoE);
        
        MONGestorInterfaces gestor = this.getMONGestorInterfaces();
        
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        RegistroSicc registro = null;
                        
        try {
            UtilidadesLog.debug("   - SAP601: 2 " + gestor);
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL1, dtoE.getOid());
            UtilidadesLog.debug("     Lote (numero/desc): " + info.getNumeroLote() + "/" + info.getDescripcionLote());       
            UtilidadesLog.debug("   - SAP601: 3 ");
            interfaz = gestor.crearInterfaz(info); 
            
            UtilidadesLog.debug("   - SAP601: 4 ");
            interfaz.setDescripcionLote(info.getDescripcionLote()); 
            UtilidadesLog.debug(" --- Archivo de interfaz PTL-1 inicializado");
        } catch (Exception e) {
            UtilidadesLog.error("MONINTPTL.enviarPedidosFacturadosAPicar: Exception (inicializacion) ");
            String codigoError = CodigosError.ERROR_DE_ARCHIVO;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        try {
            UtilidadesLog.debug("   - SAP601: 5 ");
            registro = new RegistroSicc(); 
            DAOPTL daoPtl = new DAOPTL();
            
            UtilidadesLog.debug("   - SAP601: 6 ");
            ArrayList listaPicados = daoPtl.obtenerListasPicadoPTLNoEnviadas();
            int tam = listaPicados.size();
            DTOOIDs oidsCabecerasEnviadas = new DTOOIDs();
                
            if( tam >= 1 ){   // Se obtuvo algún registro 
                Long oidCabeceraAnterior = null;
                String sVacio = new String();
                DTOPedidoFacturadoAPicar dtoPedFact = null;
                Long[] aOidsCabecEnv = new Long[tam];
                
                for(int i=0; i<tam; i++) { 
                    dtoPedFact = (DTOPedidoFacturadoAPicar) listaPicados.get(i);
                    Long oidLPCabec = dtoPedFact.getOidListaPicadoCabecera();                    
                    Long oidLPD = dtoPedFact.getOidListaPicadoDetalle();
                        
                    
                    if( oidLPCabec != null  &&  oidLPCabec != oidCabeceraAnterior){
                        
                        UtilidadesLog.debug("   - SAP601: 1er. IF = " + oidLPCabec);
                        oidCabeceraAnterior = oidLPCabec;                                                
                    
                        //Agregar dtoPedFact.oidListaPicadoCabecera a oidsCabecerasEnviadas
                        aOidsCabecEnv[i] = oidLPCabec; 
                        
                        //Cargamos los valores de la cabecera 
                        //Cargamos los valores del indicador de la cabecera 
                        UtilidadesLog.debug("   - SAP601: a ");                        
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_IND_CAB);
                        UtilidadesLog.debug("   - SAP601: b ");                        
                        registro.anyadirCampo( IRegistroSicc.PTL1_VALOR , sVacio);
                        UtilidadesLog.debug("   - SAP601: c ");                        
                        gestor.anyadirRegistro(interfaz, registro);
                        UtilidadesLog.debug("   - SAP601: d ");                        
                        registro.vaciar();
                        UtilidadesLog.debug("   - SAP601: 1 ");
                        
                        //Cargamos los valores del primer dato de la cabecera 
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_NRO_FACT); 
                        
                        String nroSol = dtoPedFact.getNumSolicitud();
                        if( nroSol.length() > 8 ){     
                        
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, 
                                nroSol.substring((nroSol.length()-8), nroSol.length())); // Pasar sólo los últimos 8 caracteres 
                        
                        } else {
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, nroSol); 
                        }
                        
                        gestor.anyadirRegistro(interfaz, registro); 
                        registro.vaciar();
                        UtilidadesLog.debug("   - SAP601: 2 ");
                        
                        //Cargamos los valores del segundo dato de la cabecera 
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_IND_CHEQUEO); 
                        
                        //Si dtoPedFact.indicadorChequeo == NULL | | dtoPedFact.indicadorChequeo == FALSE 
                        Boolean indCheq = null;
                        indCheq = dtoPedFact.getIndicadorChequeo();
                        
                        if( indCheq == null || !indCheq.booleanValue() ){     
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, new String("0"));     
                        
                        } else {
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, new String("1"));     
                        }
                        
                        gestor.anyadirRegistro(interfaz, registro);               
                        registro.vaciar();
                        UtilidadesLog.debug("   - SAP601: 3 ");
                        
                        if( oidLPD != null ){     
                            //Cargamos los valores del indicador del detalle 
                            registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_IND_DET); 
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, sVacio); // Solo se envía el prefijo 
                            gestor.anyadirRegistro(interfaz, registro); 

                            UtilidadesLog.debug("   - SAP601: VACIAR... ");                            
                            registro.vaciar(); 
                        }
                    
                    }
                    
                    if( oidLPD != null ){     
                        //Cargamos los valores del primer dato del detalle 
                        
                        UtilidadesLog.debug("   - SAP601: 4 ");                        
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_UNID_ATEN); 
                        UtilidadesLog.debug("   - SAP601: hago el dtoPedFact.getUnidadesAtendidas().toString()....    ");
                        
                        registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, dtoPedFact.getUnidadesAtendidas().toString()); 
                        gestor.anyadirRegistro(interfaz, registro); 
                        registro.vaciar();
                        UtilidadesLog.debug("   - SAP601: 6 ");
                    
                        //Cargamos los valores del segundo dato del detalle 
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_DESC_PROD); 
                        
                        String descProd = dtoPedFact.getDescProd();
                        if( descProd.length() > 30 ){     
                        
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, 
                                descProd.substring((descProd.length()-30), descProd.length())); // Pasar sólo los primeros 30 caracteres 
                        
                        } else {
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, descProd); 
                        }
                        gestor.anyadirRegistro(interfaz, registro ); 
                        registro.vaciar(); 
                        UtilidadesLog.debug("   - SAP601: 7 ");
                        
                        //Cargamos los valores del tercer dato del detalle 
                        registro.anyadirCampo(IRegistroSicc.PTL1_PREFIJO, ConstantesPTL.PTL1_COD_PROD); 
                        
                        String pedFact = dtoPedFact.getCodProd();
                        if( pedFact.length() > 15 ){     
                            
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, 
                                pedFact.substring((pedFact.length()-15), pedFact.length())); // Pasar sólo los primeros 15 caracteres     
                        
                        } else {
                            registro.anyadirCampo(IRegistroSicc.PTL1_VALOR, pedFact);
                        }
                                               
                        gestor.anyadirRegistro(interfaz, registro ); 
                        registro.vaciar(); 
                        UtilidadesLog.debug("   - SAP601: 8 ");
                        
                    }// Fin Si dtoPedFact.oidListaPicadoDetalle != NULL 

                }// Fin mientras(listaPicados.tieneElementos ) 
                
                oidsCabecerasEnviadas.setOids(aOidsCabecEnv); 
                
                
                //Si el DTOOIDs oidsCabecerasEnviadas posee elementos 
                //Invocar al método DAOPTL.actualizarListasPicadoEnviadas enviándole oidsCabecerasEnviadas 
                if( oidsCabecerasEnviadas.getOids().length > 0 ){     
                    
                    UtilidadesLog.debug("   - SAP601: antes de actualizarListasPicadoEnviadas........  ");
                    daoPtl.actualizarListasPicadoEnviadas(oidsCabecerasEnviadas);
                    UtilidadesLog.debug("   - SAP601: retornó ! ");
                }
                
                
            } else { // No se obtuvo ningún registro 
                UtilidadesLog.debug(" *** No se obtuvieron datos para enviar a la interfaz PTL-1");
                // Loguear: "No existen listas de picado PTL sin enviar"
                LogAPP.error("[INT][PTL-1 Enviar pedidos facturados a picar] " + ErroresDeNegocio.INT_0121);
            }
            
        
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONINTPTLBean.enviarPedidosFacturadosAPicar: Exception");
            // En caso de error al procesar quitamos el archivo del directorio temporal
            this.enviarInterfazSalida(interfaz, gestor);
            
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Enviamos la interfaz
        this.enviarInterfazSalida(interfaz, gestor);
        
        UtilidadesLog.info("MONINTPTLBean.enviarPedidosFacturadosAPicar(DTOOID dtoE): Salida");
    }

    /**
     * @author SPLATAS - 22/01/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * 
     * Descripción: (PTL-2) Este método pertenece al Caso de Uso 'Recepcionar Información para Etiquetas' 
     * @observaciones
     *     splatas - BELC400000365
     *     eiraola - BELC400000690
     */
    public void recepcionarInformacionEtiquetas(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONINTPTLBean.recepcionarInformacionEtiquetas(DTOOID dtoE): Entrada");
        
        UtilidadesLog.debug(" --- (ENTRADA PTL-2): dtoe = " + dtoE);
        MONGestorInterfaces gestor = this.getMONGestorInterfaces();
        
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;
        
        ArrayList lstEtiquetasAImprimir = new ArrayList();
        
        try {
            UtilidadesLog.debug(" --- Obteniendo configuracion de la interfaz (Cod/pais): " + 
                  IGestorInterfaces.COD_INTERFAZ_PTL2 + "/" + dtoE.getOidPais() + "...");
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL2, dtoE.getOidPais());
            
            UtilidadesLog.debug(" --- Buscando el archivo de Entrada para abrirlo...");
            interfaz = gestor.importarInterfaz(info);
            interfaz.setDescripcionLote(info.getDescripcionLote()); 
            UtilidadesLog.debug("    -> fichero del sistema PTL: recibido.");
            
        } catch (InterfacesException ie) {
            UtilidadesLog.error(" --- [ERROR en PTL-2]: InterfacesException: " + ie.getMotivo());
            // Si se recibe una InterfacesException, se loguea el mensaje de error 
            // INT-0099 (El fichero no existe en el path indicado.)
            throw new MareException(ie, UtilidadesError.armarCodigoError( 
                    ConstantesSEG.MODULO_INT, "", ErroresDeNegocio.INT_0099));
        } catch (Exception e) {
            UtilidadesLog.error(" --- [ERROR en PTL-2]: Exception: " + e.getCause());
            throw new MareException(e);
        }
        
        Long nroSolicitud = null;
        Long nroCaja = null;
        Long nroTotalCajas = null;
        Long tipoCajaAux = null;
        String tipoCaja = null;
        Long codImpresora = null;
        String codImpresoraAux = null;
        
        // Cambio APE-04 - dmorello, 10/01/2008
        Long numeroCajaPTLActual = null;
        
        
        try {
            Date fecha =  new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yy");
            String anio = sdf.format(fecha);
            UtilidadesLog.debug(" --- Anio(YY): " + anio);
            
            DAOPTL daoPtl = new DAOPTL();
            
            UtilidadesLog.debug(" --- Iniciando la lectura de los registros de PTL-2...");
            while ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
                try {
                    UtilidadesLog.debug("    - Registro cargado...\n" + registro);
                    
                    nroSolicitud = (Long) registro.obtenerCampo(IRegistroSicc.PTL2_FACTURA);
                    nroSolicitud = this.completarNumeroConsolidado(nroSolicitud.toString(), anio);
                    UtilidadesLog.debug("       factura (con prefijo anio): " + nroSolicitud);
                    
                    nroCaja = (Long) registro.obtenerCampo(IRegistroSicc.PTL2_NUMERO_CAJA);
                    UtilidadesLog.debug("       numeroCaja: " + nroCaja);
                    
                    nroTotalCajas = (Long) registro.obtenerCampo(IRegistroSicc.PTL2_NUMERO_TOTAL_CAJAS);
                    UtilidadesLog.debug("       numeroTotalCajas: " + nroTotalCajas);
                    
                    tipoCajaAux = (Long) registro.obtenerCampo(IRegistroSicc.PTL2_TAMANIO_CAJA);
                    UtilidadesLog.debug("       tamanioCaja: " + tipoCajaAux);
                    
                    if ( tipoCajaAux.longValue() == (ConstantesAPE.TIPO_CAJA_GRANDE.longValue())  ) {
                        UtilidadesLog.debug("        => Caja grande (cod): "+ConstantesAPE.COD_TIPO_CAJA_GRANDE);
                        tipoCaja = ConstantesAPE.COD_TIPO_CAJA_GRANDE; 
                    } else {
                        UtilidadesLog.debug("        => Caja pequenia (cod): "+ConstantesAPE.COD_TIPO_CAJA_PEQUENIA);
                        tipoCaja = ConstantesAPE.COD_TIPO_CAJA_PEQUENIA;
                    }
                    
                    codImpresora = (Long) registro.obtenerCampo(IRegistroSicc.PTL2_CODIGO_IMPRESORA);
                    codImpresoraAux = codImpresora.toString();
                    UtilidadesLog.debug("       codigoImpresora: " + codImpresora);
                    
                    // Cambio APE-04 - dmorello, 10/01/2008
                    numeroCajaPTLActual = (Long)registro.obtenerCampo(IRegistroSicc.PTL2_NUMERO_CAJA_PTL_ACTUAL);
                    UtilidadesLog.debug("numeroCajaPTLActual: " + numeroCajaPTLActual);
                    
                    DTOEtiquetaInduccionPTL dtoEtIndPTL = new DTOEtiquetaInduccionPTL();
                    dtoEtIndPTL.setNroSolicitud(nroSolicitud);
                    dtoEtIndPTL.setNroCaja(nroCaja);
                    dtoEtIndPTL.setNroTotalCajas(nroTotalCajas);
                    dtoEtIndPTL.setTipoCaja(tipoCaja);
                    dtoEtIndPTL.setCodImpresora(codImpresoraAux);
                    dtoEtIndPTL.setOidPais(dtoE.getOidPais()); // Agregado - eiraola 30/08/2007 - BELC400000690
                    dtoEtIndPTL.setNumeroCajaPTLActual(numeroCajaPTLActual);  // Cambio APE-04 - dmorello, 10/01/2008
                    
                    UtilidadesLog.debug("    - Validando numero de consolidado...");
                    
                    if (daoPtl.validarExistenciaNumeroSolicitud(dtoE.getOidPais(), nroSolicitud) != null) {
                        UtilidadesLog.debug("    - Ok. Agregando DTOEtiquetaInduccionPTL: "+dtoEtIndPTL);
                        lstEtiquetasAImprimir.add(dtoEtIndPTL);
                    } else {
                        UtilidadesLog.debug("    - No se ha podido identificar el consolidado: "+nroSolicitud);
                        DTOINTError dtoError = new DTOINTError(interfaz, 
                                                               registro, 
                                                               "No se ha podido identificar consolidado: " 
                                                               + nroSolicitud);
                        this.registrarErrorInterfaz(gestor, dtoError);
                    }
                    
                } catch (ClassCastException cce) {
                    UtilidadesLog.error("   - PTL-2: ERROR al procesar Registro... ClassCastException: " 
                            + cce.getCause());
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, cce.getCause().toString());
                    this.registrarErrorInterfaz(gestor, dtoError);
                } catch (Exception e) {
                    UtilidadesLog.error("   - PTL-2: ERROR al procesar Registro... Exception: " + e.getCause());
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, e.getCause().toString());
                    this.registrarErrorInterfaz(gestor, dtoError);
                }
                UtilidadesLog.debug("    - proximo...");
            }
            UtilidadesLog.debug(" --- Fin de la lectura y carga de los registros de PTL-2...");

        } catch (Exception e) {
            UtilidadesLog.error("   - PTL-2: Exception... " + e.getCause());
            DTOINTError dtoError = new DTOINTError(interfaz, null, 
                                                   e.getCause() + 
                                                   interfaz.getCodigoInterfaz() + 
                                                   " (Lote: " + interfaz.getNumeroLote() + ")");
            this.registrarErrorInterfaz(gestor, dtoError);
            this.cerrarInterfazEntrada(interfaz, gestor);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        this.cerrarInterfazEntrada(interfaz, gestor);
        
        int tam = lstEtiquetasAImprimir.size();
        UtilidadesLog.debug(" --- Hay " + tam + " etiquetas para Imprimir");
        
        if (tam > 0) {
            UtilidadesLog.debug(" --- Antes de llamar al CU Imprimir etiquetas por induccion de PTL");
            
            try {
                MONImpresionPTLLocal monImpresion = this.getMONImpresionPTLLocalHome().create();
                monImpresion.imprimirEtiquetasPTL(lstEtiquetasAImprimir);
            } catch (CreateException e) {
                UtilidadesLog.debug("Error al crear un MONImpresionPTL: ", e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch (Exception e) {
                UtilidadesLog.debug("Error al imprimirEtiquetasPTL: ", e.getCause());
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
            UtilidadesLog.debug(" --- Despues de llamar al CU Imprimir etiquetas por induccion de PTL");
        }
        UtilidadesLog.info("MONINTPTLBean.recepcionarInformacionEtiquetas(DTOOID dtoE): Salida");
    }

    /**
     * Descripción: (PTL-3) Metodo principal correspondiente a la implementacion del 
     * Caso de Uso 'Recepcionar Pedidos procesados en PTL'
     * @author eiraola
     * @since 10/Sep/2007
     * @observaciones (incluye del metodo original)
     *     BELC400000633 - dmorello - 23/08/2007 Se pasa false para que se pueda cerrar 
     *                     luego la interfaz si hay errores.
     *     BELC400000719 - eiraola  - 07/09/2007 Se valida la existencia del consolidado.
     *     BELC400000714 - eiraola  - 14/09/2007 Se valida tipo de dato y longitud de cada dato por prefijo.
     *     BELC400000715 - eiraola  - 14/09/2007 Se contempla que el archivo contenga multiples
     *                     Detalles de Caja (SO:)
     */
    public void recepcionarPedidosProcesadosPTL(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Entrada");
        
        UtilidadesLog.debug(" --- (ENTRADA PTL-3): dtoe = " + dtoE);
        MONGestorInterfaces gestor = this.getMONGestorInterfaces();
        
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;
        String prefijo = null; 
        String valor = null;
        DTOListaPicadoInduccionPTL dtoLstPTL = new DTOListaPicadoInduccionPTL();
        dtoLstPTL.setOidPais(dtoE.getOidPais());
        
        try {
            UtilidadesLog.debug(" --- Obteniendo configuracion de la interfaz (Cod/pais): " + 
                  IGestorInterfaces.COD_INTERFAZ_PTL3 + "/" + dtoE.getOidPais() + "...");
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL3, dtoE.getOidPais());
            
            UtilidadesLog.debug(" --- Buscando el archivo de Entrada para abrirlo...");
            interfaz = gestor.importarInterfaz(info);
            interfaz.setDescripcionLote(info.getDescripcionLote()); 
            UtilidadesLog.debug("    -> fichero del sistema PTL: recibido.");
            
        } catch (InterfacesException ie) {
            UtilidadesLog.error(" --- [ERROR en PTL-3]: InterfacesException: " + ie.getMotivo());
            // Si se recibe una InterfacesException, se loguea el mensaje de error 
            // INT-0099 (El fichero no existe en el path indicado.)
            throw new MareException(ie, UtilidadesError.armarCodigoError( 
                    ConstantesSEG.MODULO_INT, "", ErroresDeNegocio.INT_0099));
        } catch (Exception e) {
            UtilidadesLog.error(" --- [ERROR en PTL-3]: Exception: " + e.getCause());
            throw new MareException(e);
        }
        
        UtilidadesLog.debug(" **** Inicio de Lectura de Registros del archivo....");
        try {
            // CABECERA DE FACTURA (SB)
            if ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
                UtilidadesLog.debug(" --- (1) Procesando: Cabecera de Factura... Inicio");
                prefijo = (String)registro.obtenerCampo(IRegistroSicc.PTL3_PREFIJO);
                UtilidadesLog.debug("     --> Prefijo: " + prefijo);
                
                if (prefijo.equals(ConstantesPTL.PTL3_CAB_FAC)) {
                    UtilidadesLog.debug("     --  Se obtiene el campo de la Cabecera de Factura...");
                    if ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
                        dtoLstPTL = cargarCampoCabeceraFactura(dtoLstPTL, registro, ConstantesPTL.PTL3_NRO_FAC);
                        
                        // Validacion de existencia de Consolidado en Sicc
                        SimpleDateFormat sdf = new SimpleDateFormat("yy");
                        String anio = sdf.format(new Date(System.currentTimeMillis()));
                        Long numeroConsolidado = completarNumeroConsolidado(dtoLstPTL.getNroFactura().toString(), anio);
                        dtoLstPTL.setNumeroConsolidado(numeroConsolidado);
                        
                        UtilidadesLog.debug("    - Validando que el consolidado indicado por PTL-3 tenga "
                                           +"Lista Picado...");
                        DAOPTL daoPtl = new DAOPTL();
                        
                        if (daoPtl.validarExistenciaListaPicado(dtoE.getOidPais(), numeroConsolidado) != null) {
                            UtilidadesLog.debug("    - Ok. Se encontro al menos una Lista "
                                               +"de Picado para el Numero de Consolidado");
                        } else {
                            UtilidadesLog.debug("    - No se ha podido encontrar una Lista de Picado"
                                               +"para el consolidado: " + valor);
                            DTOINTError dtoError = new DTOINTError(interfaz, 
                                                                   registro, 
                                                                   "No existen datos en Lista de picado cabecera "
                                                                    + "para el Numero de Consolidado: " 
                                                                    + numeroConsolidado);
                            this.registrarErrorInterfaz(gestor, dtoError);
                            UtilidadesLog.debug(".... finalizando el Caso de Uso");
                            this.cerrarInterfazEntrada(interfaz, gestor);
                            UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida D");
                            return;
                        }
                        
                    } else {
                        String mensaje = "No se encontro prefijo de Cabecera de Factura (1:).";
                        UtilidadesLog.debug(" --- (1) "+mensaje);
                        throw new InterfacesException(mensaje);
                    }
                    
                } else {
                    String mensaje = "Se esperaba prefijo de Cabecera de Factura (SB:) y se encontro: "+ prefijo;
                    UtilidadesLog.debug(" --- (1) "+mensaje);
                    throw new InterfacesException(mensaje);
                }
                
                UtilidadesLog.debug(" --- (1) Procesando: Cabecera de Factura... Fin");
            } else { // No se encontro un registro valido (archivo vacio o con errores graves)
                this.cerrarInterfazEntrada(interfaz, gestor);
                UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida A");
                return;
            }
            
            DTODetalleCaja dtoDetalleCaja = null;
            DTODetalleCajaProducto dtoDetalleCajaProducto = null;
            
            ArrayList detallesCajaProducto = null;
            ArrayList detallesCaja = new ArrayList();
            
            dtoLstPTL.setDetallesCaja(new ArrayList());
            int cantidadCajasLeidas = 0;
            String ultimoPrefijo = null;
            
            while ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
                prefijo = (String)registro.obtenerCampo(IRegistroSicc.PTL3_PREFIJO);
                UtilidadesLog.debug("     --> Prefijo: " + prefijo);
                
                if (ultimoPrefijo == null && !prefijo.equals(ConstantesPTL.PTL3_CAB_CAJA)) {
                    String mensaje = "Se esperaba recibir Detalle de Caja (SO:).";
                    UtilidadesLog.debug(mensaje);
                    throw new InterfacesException(mensaje);
                }
                if (ultimoPrefijo != null && ultimoPrefijo.equals(ConstantesPTL.PTL3_CAB_CAJA) 
                        && !prefijo.equals(ConstantesPTL.PTL3_DET_CAJA)) {
                    String mensaje = "Se esperaba recibir Detalle de Caja-Producto (SS:).";
                    UtilidadesLog.debug(mensaje);
                    throw new InterfacesException(mensaje);
                }
                ultimoPrefijo = prefijo;
                
                // DETALLE DE CAJA (SO)
                if ( prefijo.equals(ConstantesPTL.PTL3_CAB_CAJA) ) {
                    dtoDetalleCaja = new DTODetalleCaja();
                    UtilidadesLog.debug("     -- (2)  Lectura de campos de un Detalle de Caja... Inicio");
                    
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_NRO_CAJA_PTL); // 1:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_IND_CHEQUEO); // 31:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_OPER_INT_FAC); // 32:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_OPER_CHEQ_FAC); // 33:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_IND_CAJAS_ACEP); // 34:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_NRO_ORIG_CAJA_FACTURA); // 35:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_NRO_ACTUA_CAJA_FACTURA); // 36:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_NRO_CAJA); // 37:
                    dtoDetalleCaja = this.leerCampoDetalleCaja(gestor, interfaz, dtoDetalleCaja, 
                                                               ConstantesPTL.PTL3_TIPO_CAJA); // 38:
                    
                    dtoDetalleCaja.setDetallesCajaProducto(new ArrayList());
                    dtoLstPTL.getDetallesCaja().add(dtoDetalleCaja);
                    UtilidadesLog.debug("        - el Detalle de Caja fue agregado al DTOListaPicadoInduccionPTL.");
                    UtilidadesLog.debug("     -- (2)  Lectura de campos de un Detalle de Caja... Fin");
                    
                } // fin if PTL3_CAB_CAJA (SO)
                
                // DETALLE DE CAJA-PRODUCTO (SS)
                else if ( prefijo.equals(ConstantesPTL.PTL3_DET_CAJA) ) {
                    dtoDetalleCajaProducto = new DTODetalleCajaProducto();
                    UtilidadesLog.debug("     -- (3)  Lectura de campos de un Detalle de Caja-Producto... Inicio");
                    
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_ANAQUEL); // 7:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_CANT_REQ_PICAR); // 8:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_CANT_ACTUAL_PICADA); // 9:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_NOM_PICADOR); // 16:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_DESC_PROD); // 21:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_IND_CAMBIO); // 29:
                    dtoDetalleCajaProducto = this.leerCampoDetalleCajaProducto(gestor, interfaz, dtoDetalleCajaProducto, 
                                                                               ConstantesPTL.PTL3_COD_PROD); // 30:
                    
                    // Agregamos el Detalle de Caja-Producto a la ultima Caja
                    cantidadCajasLeidas = dtoLstPTL.getDetallesCaja().size();
                    dtoDetalleCaja = (DTODetalleCaja)dtoLstPTL.getDetallesCaja().get(cantidadCajasLeidas-1);
                    dtoDetalleCaja.getDetallesCajaProducto().add(dtoDetalleCajaProducto);
                    UtilidadesLog.debug("        - el Detalle de Caja-Producto fue agregado al ultimo Detalle de Caja.");
                    
                    UtilidadesLog.debug("     -- (3)  Lectura de campos de un Detalle de Caja-Producto... Fin");
                } // fin if PTL3_DET_CAJA (SS)
                
                else {
                    String mensaje = "Tipo de fichero no valido.";
                    UtilidadesLog.debug(mensaje);
                    throw new InterfacesException(mensaje);
                }
                
            } // fin while
            
            // Validacion
            cantidadCajasLeidas = dtoLstPTL.getDetallesCaja().size();
            
            if (cantidadCajasLeidas == 0) {
                String mensaje = "Tipo de fichero no valido: No se recibieron Detalles de Caja (SO:).";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            } else {
                dtoDetalleCaja = (DTODetalleCaja)dtoLstPTL.getDetallesCaja().get(cantidadCajasLeidas-1);
                int cantidadProductosUltimaCaja = dtoDetalleCaja.getDetallesCajaProducto().size();
                
                if (cantidadProductosUltimaCaja == 0) {
                    String mensaje = "Tipo de fichero no valido: No se recibieron Detalles de Caja-Producto "
                                     +"(SS:) para el ultimo Detalle de Caja (SO:).";
                    UtilidadesLog.debug(mensaje);
                    throw new InterfacesException(mensaje);
                }
            }
            
        } catch (InterfacesException ie) {
            DTOINTError dtoError = new DTOINTError(interfaz, registro, ie.getMotivo());
            this.registrarErrorInterfaz(gestor, dtoError);
            this.cerrarInterfazEntrada(interfaz, gestor);
            UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida B");
            return;
        } catch (Exception e) {
            DTOINTError dtoError = new DTOINTError(interfaz, registro, e.getCause().toString());
            this.registrarErrorInterfaz(gestor, dtoError);
            this.cerrarInterfazEntrada(interfaz, gestor);
            UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida C");
            return;
        }
        UtilidadesLog.debug(" **** Fin de Lectura de Registros del archivo.");
        
        this.cerrarInterfazEntrada(interfaz, gestor);
        
        
        
        try {
            UtilidadesLog.debug(" **** Ahora llamamos al CU APE Crear listas de picado por induccion PTL...");
            MONCrearListasInduccionPTLHome monHome = this.getMONCrearListasInduccionPTLHome();
            MONCrearListasInduccionPTL mon = monHome.create();
            UtilidadesLog.debug("Parametro para crear ListasPicadoInduccionPTL: " + dtoLstPTL);
            mon.crearListasPicadoInduccionPTL(dtoLstPTL);
            UtilidadesLog.debug(" **** Despues de llamar al CU APE Crear listas de picado por induccion PTL.");
        } catch (NamingException ne) {
            UtilidadesLog.error("NamingException (al buscar MONCrearListasInduccionPTLHome)");
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.error("CreateException (al crear MONCrearListasInduccionPTL)");
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("RemoteException (error al crearListasPicadoInduccionPTL)");
            throw new MareException(re);
        }
                
        UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida E");
    }

    /**
     * @author SPLATAS - 22/01/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * 
     * Descripción: (PTL-3) Este método pertenece al Caso de Uso 'Recepcionar Pedidos procesados en PTL' 
     * @deprecated 13/Sep/2007
     */
    public void recepcionarPedidosProcesadosPTL_DISABLED(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Entrada");
        
        UtilidadesLog.debug(" --- (ENTRADA PTL-3): dtoe = " + dtoE);
        MONGestorInterfaces gestor = this.getMONGestorInterfaces();
        
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;
        String prefijo = null; 
        String valor = null;
        String valorAux = null;
        Boolean error = Boolean.TRUE; 
        DTOListaPicadoInduccionPTL dtoLstPTL = new DTOListaPicadoInduccionPTL();
        int i = 0;
        
        try {
            UtilidadesLog.debug(" --- Obteniendo configuracion de la interfaz (Cod/pais): " + 
                  IGestorInterfaces.COD_INTERFAZ_PTL3 + "/" + dtoE.getOidPais() + "...");
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL3, dtoE.getOidPais());
            
            UtilidadesLog.debug(" --- Buscando el archivo de Entrada para abrirlo...");
            interfaz = gestor.importarInterfaz(info);
            interfaz.setDescripcionLote(info.getDescripcionLote()); 
            UtilidadesLog.debug("    -> fichero del sistema PTL: recibido.");
            
        } catch (InterfacesException ie) {
            UtilidadesLog.error(" --- [ERROR en PTL-3]: InterfacesException: " + ie.getMotivo());
            // Si se recibe una InterfacesException, se loguea el mensaje de error 
            // INT-0099 (El fichero no existe en el path indicado.)
            throw new MareException(ie, UtilidadesError.armarCodigoError( 
                    ConstantesSEG.MODULO_INT, "", ErroresDeNegocio.INT_0099));
        } catch (Exception e) {
            UtilidadesLog.error(" --- [ERROR en PTL-3]: Exception: " + e.getCause());
            throw new MareException(e);
        }
        
        UtilidadesLog.debug("   - SAP601: Se obtienen los datos de la Cabecera de Factura.... ");
        try {
            /* BELC40000633 - dmorello, 23/08/2007 
             * Se pasa false para que se pueda cerrar luego la interfaz si hay errores*/
            //if( ( registro = ejbGestor.cargarRegistro( interfaz ) ) != null ) { 
            if( ( registro = gestor.cargarRegistro( interfaz , false) ) != null ) { 
            /* Fin BELC40000633 - dmorello, 23/08/2007 */
                
                UtilidadesLog.debug("   - SAP601: entró IF 1 !! ");
                prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO ); 
                UtilidadesLog.debug("   - SAP601: prefijo = " + prefijo);
                
                if( prefijo.equals(ConstantesPTL.PTL3_CAB_FAC) ){ 
                     
                    UtilidadesLog.debug("   - SAP601: ... carga el próximo registro ...");
                    /* BELC40000633 - dmorello, 23/08/2007 
                     * Se pasa false para que se pueda cerrar luego la interfaz si hay errores*/
                    //if( ( registro = ejbGestor.cargarRegistro( interfaz ) ) != null ){ 
                    if( ( registro = gestor.cargarRegistro( interfaz , false ) ) != null ){ 
                    /* Fin BELC40000633 - dmorello, 23/08/2007 */
                        UtilidadesLog.debug(" - dsm: Entro IF 2 !!!");
                        
                        prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO ); 
                        UtilidadesLog.debug("   - SAP601: prefijo = " + prefijo);
                        
                        if( prefijo.equals(ConstantesPTL.PTL3_NRO_FAC) ){
                            
                            UtilidadesLog.debug("   - SAP601: ... obtieneCampo ... ");
                            valorAux = (String)registro.obtenerCampo( IRegistroSicc.PTL3_VALOR ); 
                            UtilidadesLog.debug("   - SAP601: valorAux = " + valorAux);

                            /* BELC400000633 - dmorello, 22/08/2007
                             * Verifico que el valor leído es un número */
                            try {
                                Long.parseLong(valorAux);
                            } catch (NumberFormatException nex) {
                                // Registro error, cierro la interfaz y salgo del metodo
                                UtilidadesLog.debug("Error: se esperaba un registro con valor numérico. Registro: " + registro);    
                                DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                                    ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                                    "Lote: " + interfaz.getNumeroLote() ); 
                                try{
                                    gestor.registrarError(dtoError);
                                    gestor.cerrarInterfaz(interfaz);
                                } catch(InterfacesException e) {
                                    UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                                    DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                                        ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                                        "Lote: " + interfaz.getNumeroLote() ); 
                                    try {
                                        gestor.registrarError(dtoError2);
                                    } catch (Exception except) { 
                                        UtilidadesLog.debug("registrarError KO");
                                    }
                                } catch (RemoteException re) {
                                    UtilidadesLog.debug("error RemoteException");
                                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                }
                                
                                // Salgo!
                                UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
                                return;   
                            }
                            
                            /* Fin BELC400000633 - dmorello, 22/08/2007 */
                            
                            Date fecha =  new Date(System.currentTimeMillis());
                            SimpleDateFormat sdf = new SimpleDateFormat("yy");
                            String anio = sdf.format(fecha);
                           
                            valor = anio + valorAux;  // concatenar los 2 últimos números del anio actual con formato "AA" con valorAux 
                            UtilidadesLog.debug("   - SAP601:  anio + valorAux = " + valor);
                            
                            // Agregado 07/09/2007 - eiraola - BELC400000719 [inicio]
                            UtilidadesLog.debug("    - Validando que el consolidado indicado por PTL-3 tenga "
                                    + "Lista Picado...");
                            DAOPTL daoPtl = new DAOPTL();
                            if (daoPtl.validarExistenciaNumeroSolicitud(dtoE.getOidPais(), new Long(valor)) != null) {
                                UtilidadesLog.debug("      - Ok. Se encontro al menos una Lista "
                                        +"de Picado para el Numero de Consolidado");
                            } else {
                                UtilidadesLog.debug("      - No se ha podido encontrar una Lista de Picado"
                                        +"para el consolidado: " + valor);
                                DTOINTError dtoError = new DTOINTError(interfaz, 
                                                                       registro, 
                                                                       "No existen datos en Lista de picado cabecera "
                                                                       + "para el Numero de Consolidado: " 
                                                                       + valor);
                                this.registrarErrorInterfaz(gestor, dtoError);
                                UtilidadesLog.debug(".... finalizando el Caso de Uso");
                                this.cerrarInterfazEntrada(interfaz, gestor);
                                UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
                                return;
                            }
                            // Agregado 07/09/2007 - eiraola - BELC400000719 [fin]

                            dtoLstPTL.setNroFactura(new Long(valor));
                            error = Boolean.FALSE; 
                        }    
                    } 
                } 
            } else { // No se encontro un registro valido (archivo vacio o con errores)
                this.cerrarInterfazEntrada(interfaz, gestor);
                UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
                return;
            }
        } catch (Exception e) {
            UtilidadesLog.debug("   - SAP601:  pinchó 'cargarRegistro'... " + e);
            
        }
        
        if( error.booleanValue() ) {       // No es un fichero válido 
                
            UtilidadesLog.debug("   - SAP601: No es un fichero válido ... ");
            UtilidadesLog.debug(" Error en alguno de los dos primeros registros ");
            DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                "Lote: " + interfaz.getNumeroLote() ); 
            
            try {
                UtilidadesLog.debug("   - SAP601: registraError... ");
                gestor.registrarError( dtoError );     
            } catch (Exception except) {
                UtilidadesLog.debug("   - SAP601: reventó registrarError().... " + except.getCause());
            }
            
            /* BELC400000633 - dmorello, 22/08/2007 */
            try{
                UtilidadesLog.debug("voy a cerrar interfaz");    
                gestor.cerrarInterfaz(interfaz);
            } catch(InterfacesException e) {
                UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                    ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                    "Lote: " + interfaz.getNumeroLote() ); 
                try {
                    gestor.registrarError(dtoError2);
                } catch (Exception except) { 
                    UtilidadesLog.debug("registrarError KO");
                }
            } catch (RemoteException re) {
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            return;

            /* Fin BELC400000633 dmorello 22/08/2007 */

            
        } else {
            UtilidadesLog.debug("   - SAP601: seteo 'error' TRUE !");
            error = Boolean.TRUE;
        }
        
        try {
            UtilidadesLog.debug("   - SAP601: Se obtienen los datos de la Cabecera de Caja  ");
            if( (registro = gestor.cargarRegistro( interfaz )) != null ) { 
                
                UtilidadesLog.debug("   - SAP601: entró IF 2 !! ");
                prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO ); 
                UtilidadesLog.debug("   - SAP601: prefijo = " + prefijo);
                
                if( prefijo.equals(ConstantesPTL.PTL3_CAB_CAJA) ){ 
                    
                    UtilidadesLog.debug("   - SAP601: antes del FOR... ");

                    int cantReg = ConstantesPTL.PTL3_CANT_REG_CAB_CAJA.intValue();
                    UtilidadesLog.debug("   - SAP601:  CANT_REG = " + cantReg);
                    
                    for( i = 1; i <= cantReg; i++ ){ 
                        
                        UtilidadesLog.debug("######## i = " + i + " ########");
                        
                        if(( registro = gestor.cargarRegistro( interfaz ) ) != null ){
        
                            prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO ); 
                            UtilidadesLog.debug("   - SAP601: prefijo = " + prefijo);
                            
                            valor = (String)registro.obtenerCampo( IRegistroSicc.PTL3_VALOR ); 
                            UtilidadesLog.debug("   - SAP601: valor = " + valor);
                            
                            //Agregado por cvalenzu - 21/05/2007
                            //Incidencia: BELC400000438
                            if(prefijo.equals(ConstantesPTL.PTL3_NRO_ORIG_CAJA_FACTURA) ) {
                                UtilidadesLog.debug("   - SAP601: nro_orig_caja_factura... ");
                                dtoLstPTL.setNroOriginalCajasFactura(new Long(valor));  
                                //FIN - Agregado por cvalenzu - 21/05/2007
                            } else if( prefijo.equals(ConstantesPTL.PTL3_NRO_CAJA) ) {
                                UtilidadesLog.debug("   - SAP601: nro_caja... ");
                                dtoLstPTL.setNroCaja(Long.valueOf(valor)); 
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_NRO_CAJA_PTL)) { 
                                UtilidadesLog.debug("   - SAP601: nro_caja_ptl... ");
                                dtoLstPTL.setNroCajaPTL(valor); 
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_IND_CHEQUEO)) { 
                                UtilidadesLog.debug("   - SAP601: ind_chequeo.... ");
                                dtoLstPTL.setIndChequeo(new Boolean(valor));  // el valor Booleano del atributo valor 
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_OPER_INT_FAC)) { 
                                UtilidadesLog.debug("   - SAP601: oper_int_fac.... ");
                                dtoLstPTL.setOperadorIntroduccionFactura(valor); 
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_OPER_CHEQ_FAC)){ 
                                UtilidadesLog.debug("   - SAP601: oper_cheq_fac.... ");
                                dtoLstPTL.setOperadorChequeoCajaFactura(valor); 
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_TIPO_CAJA)){ 
                                UtilidadesLog.debug("   - SAP601: tipo_caja... ");
                                dtoLstPTL.setTipoCaja(valor); 
                                error = Boolean.FALSE; 
                                UtilidadesLog.debug("   - SAP601: Leyó el último registro de la cabecera !! ");
                    
                            } else if( prefijo.equals(ConstantesPTL.PTL3_IND_CAJAS_ACEP)){ 
                                
                                UtilidadesLog.debug("   - SAP601: ind_cajas_acep... ");
                                if( !valor.equals("1") ) { 
                                    UtilidadesLog.debug("   - SAP601:  No fueron aceptadas todas las cajas de la factura ");
                                    
                                    DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                                        ErroresDeNegocio.INT_0120 + interfaz.getCodigoInterfaz() + 
                                        "Lote: " + interfaz.getNumeroLote() ); 
                                        
                                    try {
                                        UtilidadesLog.debug("   - SAP601: registraError... ");
                                        gestor.registrarError( dtoError );     
                                    
                                    } catch (Exception except) {
                                        
                                        UtilidadesLog.debug("   - SAP601: reventó registrarError().... " + except.getCause());
                                    }
                                    
                                    
                                    /* BELC400000633 - dmorello, 22/08/2007 */
                                    try{
                                        UtilidadesLog.debug("voy a cerrar interfaz");    
                                        gestor.cerrarInterfaz(interfaz);
                                    } catch(InterfacesException e) {
                                        UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                                        DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                                            ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                                            "Lote: " + interfaz.getNumeroLote() ); 
                                        try {
                                            gestor.registrarError(dtoError2);
                                        } catch (Exception except) { 
                                            UtilidadesLog.debug("registrarError KO");
                                        }

                                    } catch (RemoteException re) {
                                        UtilidadesLog.debug("error RemoteException");
                                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                    }

                                    return;
                                    
                                    /* Fin BELC400000633 dmorello 22/08/2007 */
                                    
                                } 
                    
                            }
                        
                        }
                
                    } UtilidadesLog.debug("   - SAP601: Fin FOR!  ");
                
                } UtilidadesLog.debug("   - SAP601: Fin IF 'PTL3_CAB_CAJA'!  ");
            
            } UtilidadesLog.debug("   - SAP601: Fin IF 'cargarRegistro'!  ");
            
        /* BELC400000633 - dmorello, 22/08/2007 */
        } catch (NumberFormatException nex) {
            // Registro error, cierro la interfaz y salgo del metodo
            UtilidadesLog.debug("Error: se esperaba un registro con valor numérico. Registro: " + registro);    
            DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                "Lote: " + interfaz.getNumeroLote() ); 
            try{
                gestor.registrarError(dtoError);
                gestor.cerrarInterfaz(interfaz);
            } catch(InterfacesException e) {
                UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                    ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                    "Lote: " + interfaz.getNumeroLote() ); 
                try {
                    gestor.registrarError(dtoError2);
                } catch (Exception except) { 
                    UtilidadesLog.debug("registrarError KO");
                }
            } catch (RemoteException re) {
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
            return;        
        
        /* Fin BELC400000633 - dmorello, 22/08/2007 */

        } catch (Exception e) {
            
            UtilidadesLog.debug("   - SAP601: Exception e = " + e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
        
        }
        
        UtilidadesLog.debug("   - SAP601: antes del IF 'PTL3_CANT_REG_CAB_CAJA'... ");
        UtilidadesLog.debug("   - SAP601: i-1 = " + (i-1) 
                                + ", CANT_REG_CAB_CAJA = " + ConstantesPTL.PTL3_CANT_REG_CAB_CAJA.longValue() 
                                + ", error = " + error.toString());
        if( ((i-1) != ConstantesPTL.PTL3_CANT_REG_CAB_CAJA.longValue()) || error.booleanValue() ) {
            
            UtilidadesLog.debug("   - SAP601: No es un fichero válido...  "); 
            DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                                    ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                                    "Lote: " + interfaz.getNumeroLote() ); 
                                
            try {
                UtilidadesLog.debug("   - SAP601: registraError... ");
                gestor.registrarError( dtoError );     
            
            } catch (Exception except) {
                
                UtilidadesLog.debug("   - SAP601: reventó registrarError().... " + except.getCause());
            }
            
            
            /* BELC400000633 - dmorello, 22/08/2007 */
            try{
                UtilidadesLog.debug("voy a cerrar interfaz");    
                gestor.cerrarInterfaz(interfaz);
            } catch(InterfacesException e) {
                UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                    ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                    "Lote: " + interfaz.getNumeroLote() ); 
                try {
                    gestor.registrarError( dtoError2 );     
                } catch (Exception except) { 
                    UtilidadesLog.debug("registrarError KO");
                }
            } catch (RemoteException re) {
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            return;
            
            /* Fin BELC400000633 dmorello 22/08/2007 */
        
        } else {
            error = Boolean.TRUE; 
        }        
        

        try {
            UtilidadesLog.debug("   - SAP601: Se cargan los datos de los detalles de Caja... "); 
             
            /* BELC400000662 - dmorello, 27/08/2007 */
            //while ( (registro = ejbGestor.cargarRegistro( interfaz )) != null ) { 
            while ( (registro = gestor.cargarRegistro( interfaz , false)) != null ) { 
                prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO ); 
            
                if( prefijo.equals(ConstantesPTL.PTL3_DET_CAJA)){ 
                    dtoLstPTL.limpiarDatosDetalle(); 
                    
                    int cantRegDet = ConstantesPTL.PTL3_CANT_REG_DET_CAJA.intValue();
                    UtilidadesLog.debug("   - SAP601:  cantRegDet = " + cantRegDet);
                    
                    /* dmorello, 22/08/2007 */
                    //for( i = 0; i <= cantRegDet; i++ ){ 
                    for( i = 1; i <= cantRegDet; i++ ){ 
                        
                        UtilidadesLog.debug(" $$$$$$$$$$$$  i = " + i + " $$$$$$$$$$$$ ");
                        /* BELC400000662 - dmorello, 27/08/2007 */
                        //if( ( registro = ejbGestor.cargarRegistro( interfaz ) ) != null ){
                        if( ( registro = gestor.cargarRegistro( interfaz , false ) ) != null ){
            
                            prefijo = (String)registro.obtenerCampo( IRegistroSicc.PTL3_PREFIJO );
                            UtilidadesLog.debug("   - SAP601: prefijo = " + prefijo);
                            
                            valor = (String)registro.obtenerCampo( IRegistroSicc.PTL3_VALOR );
                            UtilidadesLog.debug("   - SAP601: valor = " + valor);
                            
                            //Agregado por cvalenzu - 21/05/2007
                            //Incidencia: BELC400000438
                            if( prefijo.equals(ConstantesPTL.PTL3_CANT_ACTUAL_PICADA)) {
                                UtilidadesLog.debug("   - SAP601: cant_act_picada... ");
                                dtoLstPTL.setCantidadActualPicada(new Long(valor));
                                //FIN - Agregado por cvalenzu - 21/05/2007
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_ANAQUEL)) {
                                UtilidadesLog.debug("   - SAP601: anaquel... ");
                                dtoLstPTL.setAnaquel(valor); 
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_CANT_REQ_PICAR)) { 
                                UtilidadesLog.debug("   - SAP601: cant_req_picar... ");
                                dtoLstPTL.setCantidadRequeridaPicar(new Long(valor)); 
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_NOM_PICADOR)) { 
                                UtilidadesLog.debug("   - SAP601: nom_picador... ");
                                dtoLstPTL.setNombrePicadorProducto(valor);
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_DESC_PROD)) { 
                                UtilidadesLog.debug("   - SAP601: desc_prod... ");
                                dtoLstPTL.setDescripcionProducto(valor); 
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_IND_CAMBIO)) { 
                                UtilidadesLog.debug("   - SAP601: ind_cambio... ");
                                // El campo Indicador de cambio (prefijo 29) no se utiliza en Sicc
                            
                            } else if( prefijo.equals(ConstantesPTL.PTL3_COD_PROD)) { 
                                UtilidadesLog.debug("   - SAP601: cod_prod... ");
                                dtoLstPTL.setCodigoProducto(valor);
                                
                                UtilidadesLog.debug("   - SAP601: seteo ERROR=FALSE! ");
                                error = Boolean.FALSE; 
                                UtilidadesLog.debug("   - SAP601: Leyó el último registro del detalle !! ");
                
                                // Se invoca al caso de uso "Crear listas de picado por inducción de PTL", del módulo APE                         
                
                                /*TaponAPE tapon = new TaponAPE();
                                UtilidadesLog.debug("   - SAP601: Invocar a TaponAPE.crearListasPicadoInduccionPTL con dtoLstPTL = " + dtoLstPTL);
                                tapon.crearListasPicadoInduccionPTL(dtoLstPTL);
                                UtilidadesLog.debug("   - SAP601: despues de 'crearListasPicadoInduccionPTL'.... ");
                                */
                                
                                MONCrearListasInduccionPTLHome monHome = this.getMONCrearListasInduccionPTLHome();
                                MONCrearListasInduccionPTL mon = monHome.create();
                                UtilidadesLog.debug("   - SAP601: Invocar a MONCrearListasInduccionPTL.crearListasPicadoInduccionPTL con dtoLstPTL = " + dtoLstPTL);
                                mon.crearListasPicadoInduccionPTL(dtoLstPTL);
                                UtilidadesLog.debug("   - SAP601: despues de 'crearListasPicadoInduccionPTL'.... ");                                
                            } 
                            
                        } // Fin if registro!= null 
                        /* dmorello, 22/08/2007: Agrego ELSE */
                        else {
                            break;
                        }
            
                    } // Fin for 
            
                    UtilidadesLog.debug("   - SAP601: i-1 = " + (i-1) 
                                + ", PTL3_CANT_REG_DET_CAJA = " + ConstantesPTL.PTL3_CANT_REG_DET_CAJA.toString()
                                + ", error = " + error.toString());
                    if( ((i-1) != ConstantesPTL.PTL3_CANT_REG_DET_CAJA.longValue()) || error.booleanValue() ) { 
    
                        UtilidadesLog.debug("   - SAP601: No es un fichero válido !! ");
                        DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                            ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                            "Lote: " + interfaz.getNumeroLote() ); 

                        /* dmorello, 22/08/2007: Agrego registrarError  */
                        try {
                            UtilidadesLog.debug("   - SAP601: registraError... ");
                            gestor.registrarError( dtoError );     
                        } catch (Exception except) {
                            UtilidadesLog.debug("   - SAP601: reventó registrarError().... " + except.getCause());
                        }
                            
                        /* BELC400000633 - dmorello, 22/08/2007 */
                        try{
                            UtilidadesLog.debug("voy a cerrar interfaz");    
                            gestor.cerrarInterfaz(interfaz);
                        } catch(InterfacesException e) {
                            UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                            DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                                ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                                "Lote: " + interfaz.getNumeroLote() ); 
                            try {
                                gestor.registrarError( dtoError2 );     
                            } catch (Exception except) { 
                                UtilidadesLog.debug("registrarError KO"); 
                            }
                        }

                        return;
                        
                        /* Fin BELC400000633 dmorello 22/08/2007 */
            
                    } else {
                        //UtilidadesLog.debug("   - SAP601: seteo error=TRUE !!!!!!! ");
                        error = Boolean.TRUE; 
                    } 
                    
                    //UtilidadesLog.debug("   - SAP601: mando un break bien cabeza y a comerla... ");
                    
                    /* BELC400000662 - dmorello, 27/08/207 */
                    //break;
                    
                } 
            
            } // Fin Mientras 
            
            /* BELC400000662 - dmorello, 27/08/2007 */
            try{
                UtilidadesLog.debug("voy a cerrar interfaz");    
                gestor.cerrarInterfaz(interfaz);
            } catch(InterfacesException e) {
                UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                    ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                    "Lote: " + interfaz.getNumeroLote() ); 
                try {
                    gestor.registrarError( dtoError2 );     
                } catch (Exception except) { 
                    UtilidadesLog.debug("registrarError KO"); 
                }
            }
  
            /* Fin BELC400000662 dmorello 27/08/2007 */
        
        /* BELC400000633 - dmorello, 22/08/2007 */
        } catch (NumberFormatException nex) {
            // Registro error, cierro la interfaz y salgo del metodo
            UtilidadesLog.debug("Error: se esperaba un registro con valor numérico. Registro: " + registro);    
            DTOINTError dtoError = new DTOINTError( interfaz, registro, 
                ErroresDeNegocio.INT_0119 + interfaz.getCodigoInterfaz() + 
                "Lote: " + interfaz.getNumeroLote() ); 
            try{
                gestor.registrarError(dtoError);
                gestor.cerrarInterfaz(interfaz);
            } catch(InterfacesException e) {
                UtilidadesLog.debug("   - PTL-3: InterfacesException... " + e.getMotivo());
                DTOINTError dtoError2 = new DTOINTError( interfaz, registro, 
                    ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + 
                    "Lote: " + interfaz.getNumeroLote() ); 
                try {
                    gestor.registrarError(dtoError2);
                } catch (Exception except) { 
                    UtilidadesLog.debug("registrarError KO");
                }
            } catch (RemoteException re) {
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
            return;
        
        /* Fin BELC400000633 - dmorello, 22/08/2007 */
        
        } catch (Exception e) {
            
            UtilidadesLog.debug("   - SAP601: Exception " + e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
            
        }
    
        UtilidadesLog.info("MONINTPTLBean.recepcionarPedidosProcesadosPTL(DTOOID dtoE): Salida");
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
    /**
     * @author scsaavedra - 27/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE (DTOOID)
     * 
     * Descripción: (PTL-4) Este método pertenece al Caso de Uso 'Enviar mapa de anaqueles producto en PTL' 
     */
  public void enviarMapaAnaquelesProductoBatch(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONINTPTLBean.enviarMapaAnaquelesProductoBatch(DTOOID dtoE): Entrada");

        DTOBatch dtoBatch = new DTOBatch("Enviar Mapa de Anaqueles Producto", new MareBusinessID("INTEnviarMapaAnaquelesProducto"), dtoE);

        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        } catch (RemoteException re) {
            UtilidadesLog.error("#*ERROR*# MONINTPTL:enviarMapaAnaquelesProductoBatch", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONINTPTLBean.enviarMapaAnaquelesProductoBatch(DTOOID dtoE): Salida");  
  }

    /**
     * @author scsaavedra - 27/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE (dtoE)
     * 
     * Descripción: (PTL-4) Este método pertenece al Caso de Uso 'Enviar mapa de anaqueles producto en PTL' (es llamadao atraves del sub-sistema) 
     * @observaciones
     *     BELC400000643 eiraola 23/Ago/2007 - No debe quedar en /temp cuando no hay datos.
     */
  public DTOSalidaBatch enviarMapaAnaquelesProducto(DTOBatch dtoE) throws MareException {
      UtilidadesLog.info("MONINTPTLBean.enviarMapaAnaquelesProducto(DTOBatch dtoE): Entrada");
      DTOOID dto = (DTOOID)dtoE.getDTOOnline();
      UtilidadesLog.debug(" --- dto entrada (DTOOID): " + dto);
      
      MONGestorInterfaces gestor = this.getMONGestorInterfaces();
      
      InterfazInfo info = null;
      InterfazInfo interfaz = null;
      RegistroSicc registro = null;
      
      // Se inicializa el archivo de salida
      try {
          UtilidadesLog.debug(" --- Obteniendo configuracion de la interfaz (Cod/pais): " + 
                  IGestorInterfaces.COD_INTERFAZ_PTL4 + "/" + dto.getOidPais() + "...");
          info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL4, dto.getOidPais());
          info.setPais(dto.getOidPais());
          
          UtilidadesLog.debug(" --- Inicializando archivo de interfaz...");
          interfaz = gestor.crearInterfaz(info);
          interfaz.setDescripcionLote(info.getDescripcionLote());
          UtilidadesLog.debug(" --- Archivo de interfaz PTL-4 inicializado");
      } catch (Exception e) {
          UtilidadesLog.error("MONINTPTL.enviarMapaAnaquelesProducto: Exception (inicializacion) ");
          String codigoError = CodigosError.ERROR_DE_ARCHIVO;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      // Se procesan los datos y se envian al archivo de interfaz
      try {
          registro = new RegistroSicc();   
          DAOPTL daoPtl = new DAOPTL();
          
          ArrayList lstAsigProdAnaqDet = daoPtl.obtenerDatosEnviarProductosAnaqueles(dto.getOid(), dto.getOidPais());
          
          if (lstAsigProdAnaqDet == null || lstAsigProdAnaqDet.size() == 0) {
              UtilidadesLog.debug(" *** No se obtuvieron datos para enviar a la interfaz PTL-4");
              this.enviarInterfazSalida(interfaz, gestor);
              
              UtilidadesLog.info("MONINTPTLBean.enviarMapaAnaquelesProducto(DTOBatch dtoE): Salida (lista vacia!)");
              return new DTOSalidaBatch(0, "enviarMapaAnaquelesProducto sin productos");  
          } else {
              int cant = lstAsigProdAnaqDet.size();  
              DTOAnaquelProductoAEnviar dtoAEnviar = null; 
              UtilidadesLog.info(" *** Registros a enviar (cant): " + cant); 
              for (int i=0; i<cant; i++) { 
                  dtoAEnviar = (DTOAnaquelProductoAEnviar)lstAsigProdAnaqDet.get(i);
                  registro = new RegistroSicc();
                                    
                  try {
                      UtilidadesLog.debug("     ["+i+"] DTOAnaquelProductoAEnviar: " + dtoAEnviar);
                      
                      // Se prepara el registro
                      registro.anyadirCampo(IRegistroSicc.PTL4_NUMERO_ANAQUEL,  dtoAEnviar.getNumeroAnaquel());
                      registro.anyadirCampo(IRegistroSicc.PTL4_CODIGO_PRODUCTO, dtoAEnviar.getCodProdu());
                      registro.anyadirCampo(IRegistroSicc.PTL4_UNIDADES_CAJA1,  dtoAEnviar.getUnidadesProducto1());
                      registro.anyadirCampo(IRegistroSicc.PTL4_UNIDADES_CAJA2,  dtoAEnviar.getUnidadesProducto2());
                      
                      // Se añade el registro al fichero de interfaz 
                      gestor.anyadirRegistro(interfaz, registro);
                      
                  } catch (InterfacesException ie) {
                      UtilidadesLog.error("     ERROR InterfacesException al procesar registro ["+i+"]");
                      DTOINTError dtoError = new DTOINTError(interfaz, registro, "Error al procesar registro");
                      this.registrarErrorInterfaz(gestor, dtoError);
                  }
                  
                  registro.vaciar();
              
              } // fin for
              
          } // fin else
      } catch (Exception e) {
          UtilidadesLog.error("MONINTPTLBean.enviarMapaAnaquelesProducto: Exception");
          // En caso de error al procesar quitamos el archivo del directorio temporal
          this.enviarInterfazSalida(interfaz, gestor);
          
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      // Enviamos la interfaz
      this.enviarInterfazSalida(interfaz, gestor);
      
      UtilidadesLog.info("MONINTPTLBean.enviarMapaAnaquelesProducto(DTOBatch dtoE): Salida");  
      return new DTOSalidaBatch(0, "enviarMapaAnaquelesProducto procesada");  
  }
 
  private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
      // Se obtiene el interfaz home
      UtilidadesLog.info("MONINTPTLBean.getMONGestorInterfaces(): Entrada");
      MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
      // Se obtiene el interfaz remoto
      MONGestorInterfaces ejb = null;
      try {
          ejb = home.create();
      } catch (Exception e) {
			    UtilidadesLog.error("*** Error en getMONGestroInterfaces",e);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.info("MONINTPTLBean.getMONGestorInterfaces(): Salida");
      return ejb;
	} 

  private MONCrearListasInduccionPTLHome getMONCrearListasInduccionPTLHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCrearListasInduccionPTLHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCrearListasInduccionPTL"), MONCrearListasInduccionPTLHome.class);
    }
    
    /**
     * @author scsaavedra - 13/06/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE (dtoE)
     * 
     * Descripción: (PTL-5) Este método pertenece al Caso de Uso 'Recepcionar mapa de anaqueles producto'
     */
    public void recepcionarMapaAnaquelesProducto(DTOAsignacionProductoAnaquelCabecera dtoe) 
            throws MareException {
        UtilidadesLog.info("MONINTPTLBean.recepcionarMapaAnaquelesProducto(DTOAsignacionProductoAnaquelCabecera dtoe): Entrada");
        
        UtilidadesLog.debug(" --- (ENTRADA PTL-5): dtoe = " + dtoe);
        MONGestorInterfaces gestor = this.getMONGestorInterfaces();
        
        InterfazInfo info = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;
        
        // Se comprueba que se haya recibido el fichero del sistema PTL
        try {
            UtilidadesLog.debug(" --- Obteniendo configuracion de la interfaz (Cod/pais): " + 
                  IGestorInterfaces.COD_INTERFAZ_PTL5 + "/" + dtoe.getOidPais() + "...");
            info = gestor.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_PTL5, dtoe.getOidPais());
            
            UtilidadesLog.debug(" --- Buscando el archivo de Entrada para abrirlo...");
            interfaz = gestor.importarInterfaz(info);
            interfaz.setDescripcionLote(info.getDescripcionLote()); 
            UtilidadesLog.debug("    -> fichero del sistema PTL: recibido.");
            
        } catch (InterfacesException ie) {
            UtilidadesLog.error(" --- [ERROR en PTL-5]: InterfacesException: " + ie.getMotivo());
            // Si se recibe una InterfacesException, se loguea el mensaje de error 
            // INT-0099 (El fichero no existe en el path indicado.)
            throw new MareException(ie, UtilidadesError.armarCodigoError( 
                    ConstantesSEG.MODULO_INT, "", ErroresDeNegocio.INT_0099));
        } catch (Exception e) {
            UtilidadesLog.error(" --- [ERROR en PTL-5]: Exception: " + e.getCause());
            throw new MareException();
        }
        
        DTOOIDs asignacionesPTL = null;
        DAOPTL daoPtl = null;
        ArrayList diferenciasAsignacion = new ArrayList();
        
        try {
            //borro todo lo q' cont. la tabla!!
            UtilidadesLog.debug(" --- voy a eliminarDiferenciasAsignacion...");
            daoPtl = new DAOPTL();
            daoPtl.eliminarDiferenciasAsignacion();
            
            //Borramos el flag de asignación PTL de todos los detalles de asignación para los datos ingresados 
            UtilidadesLog.debug(" --- voy a borrarIndAsignacionPTL...");
            daoPtl.borrarIndAsignacionPTL(dtoe);
            
            // Se recuperan los Números de Anaquel y Códigos de producto de los detalles de la cabecera activa para facturación 
            HashMap hashAnaqProd = daoPtl.obtenerNroAnaqCodProdActivosFact(dtoe);
            // Se procesan los datos del fichero 
            
            String nroAnaquel = null;
            String codProductoPTL = null;
            String codProductoSiCC = null;
            Long   oidProductoSiCC = null;
            Long   oidAsignacionAnaquel = null;
            
            ArrayList oidAsignacionAnaquelDinamico = new ArrayList();
            
            UtilidadesLog.debug("   - PTL-5: antes de while() ");
            boolean lEntro = false;
            while((registro = gestor.cargarRegistro(interfaz, false)) != null) {
                
                // Recuperamos los datos que nos interesan, las unidades en caja 1 y 2 no son utilizadas por este CU 
                nroAnaquel = (String)registro.obtenerCampo(IRegistroSicc.PTL5_ANAQUEL);
                UtilidadesLog.debug("anaquel: " + nroAnaquel);    
                codProductoPTL = (String)registro.obtenerCampo(IRegistroSicc.PTL5_CODIGO_PRODUCTO);
                UtilidadesLog.debug("codProductoPTL: " + codProductoPTL);    
                lEntro = true;
                codProductoSiCC = null; 
                oidAsignacionAnaquel = null;
                oidProductoSiCC = null;
                
                //codProductoSiCC le asignamos el código de producto del hashAnaqProd para el nroAnaquel 
                if (hashAnaqProd.get(nroAnaquel)!=null){
                    codProductoSiCC = ((DTOCompararAsignacionAnaqueles)hashAnaqProd.get(nroAnaquel)).getCodigoProducto();
                    UtilidadesLog.debug("codProductoSiCC: " + codProductoSiCC);    
                
                    //oidAsignacionAnaquel le asignamos el oidAsignacionAnaquel del hashAnaqProd para el nroAnaquel 
                    oidAsignacionAnaquel = ((DTOCompararAsignacionAnaqueles)hashAnaqProd.get(nroAnaquel)).getOidAsignacionAnaquel();
                    UtilidadesLog.debug("oidAsignacionAnaquel: " + oidAsignacionAnaquel);    

                    //SCS, oid de producto
                    oidProductoSiCC = ((DTOCompararAsignacionAnaqueles)hashAnaqProd.get(nroAnaquel)).getOidProducto();
                    UtilidadesLog.debug("oidProductoSiCC: " + oidAsignacionAnaquel);    
                }
                
                if ( (codProductoSiCC==null) || !(codProductoSiCC.equals(codProductoPTL)) ){
                    DTODiferenciaAsignacion dtoDA = new DTODiferenciaAsignacion();
                    
                    dtoDA.setCodProductoPTL(codProductoPTL);
                    dtoDA.setCodProductoSiCC(codProductoSiCC);
                    dtoDA.setOidProductoSiCC(oidProductoSiCC);
                    dtoDA.setNumeroAnaquel(nroAnaquel);
                        
                    diferenciasAsignacion.add(dtoDA);
                    UtilidadesLog.debug("adhiero a diferenciasAsignacion");    
                }else{
                    if (oidAsignacionAnaquel!=null){
                        oidAsignacionAnaquelDinamico.add(oidAsignacionAnaquel);
                        UtilidadesLog.debug("adhiero a oidAsignacionAnaquelDinamico");    
                    }    
                }    
            }
            
            UtilidadesLog.debug("lEntro: " + lEntro);
            if ((registro==null) && (!lEntro)){ //no pudo levantar ninguno, todos estan mal; no sigo!
               UtilidadesLog.debug("todos los reg. maaaal!!");
               this.cerrarInterfazEntrada(interfaz, gestor);
               return;
            }
               
            //si el array oidAsignacionAnaquelDinamico, tiene posiciones cargo el: asignacionesPTL
            int size = oidAsignacionAnaquelDinamico.size();
            UtilidadesLog.debug("size " + size);    
            if (size>0){
                Long[] aOidsAsignacionAnaquel = new Long[size];
                for(int i=0; i<size; i++) {
                    aOidsAsignacionAnaquel[i]=(Long)oidAsignacionAnaquelDinamico.get(i);
                }
                asignacionesPTL = new DTOOIDs();
                asignacionesPTL.setOids(aOidsAsignacionAnaquel);
            }

        } catch (Exception e) {
            UtilidadesLog.error("   - PTL-5: Exception... " + e.getCause());
            // eiraola - 29/08/2007 - Inc. BELC400000669 Si hubo un error cerramos para 
            // que no quede en /temporal
            DTOINTError dtoError = new DTOINTError(interfaz, null, 
                                                   e.getCause() + 
                                                   interfaz.getCodigoInterfaz() + 
                                                   " (Lote: " + interfaz.getNumeroLote() + ")");
            this.registrarErrorInterfaz(gestor, dtoError);
            this.cerrarInterfazEntrada(interfaz, gestor);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        this.cerrarInterfazEntrada(interfaz, gestor);
        
        //Marcamos como asignadas a PTL todas las asignaciones de anaquel que tienen el mismo producto en los dos sistemas 
        if (asignacionesPTL!=null){
            UtilidadesLog.debug("voy a marcarAsignacionesPTL(....");    
            daoPtl.marcarAsignacionesPTL(asignacionesPTL);
        }
            
        //Obtenemos los anaqueles que quedaron sin asignar luego de procesar el archivo            
        UtilidadesLog.debug("addAll en: diferenciasAsignacion");    
        diferenciasAsignacion.addAll(daoPtl.obtenerAnaquelesNoAsignados(dtoe));
        
        //(SCS)ok, la consulta anterior me puede devolver anaqueles repetidos, los meto en una hash con clave el anaquel y ya
        //no me cierra del todo, pero bue....
        int mide = 0;
        
        if (diferenciasAsignacion!=null)
            mide = diferenciasAsignacion.size();
            
        HashMap hashAnaqNoRep = null;
        if (mide>0){
            hashAnaqNoRep = new HashMap();
            DTODiferenciaAsignacion dtoLinea;
            for(int i=0; i<mide; i++) {
                String keyHash;
                dtoLinea = (DTODiferenciaAsignacion)diferenciasAsignacion.get(i);
                keyHash = dtoLinea.getNumeroAnaquel().trim();
                
                if (hashAnaqNoRep.get(keyHash) == null){
                    hashAnaqNoRep.put(keyHash, dtoLinea);
                }    
            }
        }
        
        //Almacenamos las diferencias de asignación en la tabla correspondiente para que las use el CU de REP
        UtilidadesLog.debug("voy a insertarDiferenciasAsignacion,,,,");    
        mide=0;
        if (hashAnaqNoRep!=null) {
            mide = hashAnaqNoRep.size();
            if (mide>0) {
                //daoPtl.insertarDiferenciasAsignacion(diferenciasAsignacion);
                daoPtl.insertarDiferenciasAsignacion(hashAnaqNoRep);
            }else{
                UtilidadesLog.debug("nada, para insertar..........");        
            }
        }else{
            UtilidadesLog.debug("nada, para insertar..........");            
        }
        ////Invocar al CU REP-APE Verificación de mapas de pick to light vs balanceo 
        //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        if (mide>0) {
            DTOReporte dtoRep = new DTOReporte();
            try {
                MONReportesHome monHome = this.getMONReportesHome();
                MONReportes mon = monHome.create();
                
                //seteos
                dtoRep.setIdReporte(new String("RD_APE-064"));
                HashMap parametros = new HashMap();
                parametros.put(ConstantesREP.TITULO, "Verificación de Mapas de Pick to Light vs Balanceo");
                parametros.put(ConstantesREP.EXTENSION, "pdf");
                parametros.put(ConstantesREP.MODULO, "INT");
                
                //hago llegar en este atributo la descr. del pais de sesion, no tengo ganas de modificar el dto!!
                parametros.put(ConstantesREP.DESCPAIS, dtoe.getActivoFacturacion().trim());
                
                parametros.put(ConstantesREP.FORMATOFECHA, "dd/MM/yyyy");
                parametros.put(ConstantesREP.IDIOMA, new String(dtoe.getOidIdioma().toString()));
                parametros.put(ConstantesREP.PAIS, new String(dtoe.getOidPais().toString()));
                dtoRep.setParametros(parametros);
                
                mon.lanzarBatch(dtoRep);
            } catch (Exception e) {
                
                UtilidadesLog.debug("   - SAP601: Exception " + e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException("", UtilidadesError.armarCodigoError(codigoError));
                
            }        
        }
    }

    private MONReportesHome getMONReportesHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONReportesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONReportes"), MONReportesHome.class);
    }

  private MONImpresionPTLLocalHome getMONImpresionPTLLocalHome() throws MareException  {
      Object objHome = UtilidadesEJB.getLocalHome("java:comp/env/MONImpresionPTL");
      return (MONImpresionPTLLocalHome)objHome;
  }
  
    private void enviarInterfazSalida(InterfazInfo interfaz, MONGestorInterfaces gestor) 
            throws MareException {
        UtilidadesLog.info(" --- Enviando interfaz al buzon de Salida...");
        UtilidadesLog.info("    -> InterfazInfo: " + interfaz);
        try {
            gestor.enviarInterfaz(interfaz);
            UtilidadesLog.info(" --- Interfaz enviada.");
        } catch (InterfacesException ie) {
            UtilidadesLog.error("     MONINTPTL.enviarInterfazSalida: Exception " + ie.getMotivo());
            DTOINTError dtoError = new DTOINTError(interfaz, null, 
                                                   ErroresDeNegocio.INT_0009 + 
                                                   interfaz.getCodigoInterfaz() + 
                                                   " (Lote: " + interfaz.getNumeroLote() + ")");
            this.registrarErrorInterfaz(gestor, dtoError);
        } catch (Exception e) {
            UtilidadesLog.error("     MONINTPTL.enviarInterfazSalida: Exception " + e.getCause());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
        }
    }
  
    private void cerrarInterfazEntrada(InterfazInfo interfaz, MONGestorInterfaces gestor) 
            throws MareException {
        UtilidadesLog.info(" --- Cerrando la interfaz de Entrada...");
        UtilidadesLog.info("    -> InterfazInfo: " + interfaz);
        try {
            gestor.cerrarInterfaz(interfaz);
            UtilidadesLog.debug(" --- Interfaz cerrada.");
        } catch (InterfacesException ie) {
            UtilidadesLog.error("     MONINTPTL.cerrarInterfazEntrada: InterfacesException " + ie.getMotivo());
            DTOINTError dtoError = new DTOINTError(interfaz, null, 
                                                   ErroresDeNegocio.INT_0009 + 
                                                   interfaz.getCodigoInterfaz() + 
                                                   " (Lote: " + interfaz.getNumeroLote() + ")");
            this.registrarErrorInterfaz(gestor, dtoError);
        } catch (Exception e) {
            UtilidadesLog.error("     MONINTPTL.cerrarInterfazEntrada: Exception " + e.getCause());
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ENVIO_DE_INTERFAZ));
        }
    }

    private void registrarErrorInterfaz(MONGestorInterfaces gestor, DTOINTError dtoError) 
            throws MareException {
        UtilidadesLog.info(" --- Registrando error al procesar interfaz...");
        UtilidadesLog.debug("    -> DTOINTError: " + dtoError);
        try {
            gestor.registrarError(dtoError);
            UtilidadesLog.info(" --- El error fue registrado en el archivo .err");
        } catch (Exception e) {
            UtilidadesLog.error("     MONINTPTL.registrarErrorInterfaz: Exception ");
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_DE_INTERFAZ));
        }
    }
    
   /**
    * Metodo utilizado para completar el Numero de solicitud recibido por PTL-2
    * y tambien en PTL-3:
    * Se reciben 8 digitos desde la interfaz y se agregan los 2 ultimos digitos
    * del anio actual.
    * Como el campo esta definido Long, en Interfaces.xml, en realidad se estan
    * perdiendo los ceros a izquierda por eso aqui los rellenamos antes de
    * concatenar el anio.
    */
    private Long completarNumeroConsolidado(String numeSoliInte, String anio) 
            throws MareException {
        StringBuffer numeSoli = new StringBuffer();
        int longitudRecibida = numeSoliInte.length();
        int longitudRelleno = 8 - longitudRecibida;
        
        if (longitudRecibida >= 8) {
            numeSoli.append(anio + numeSoliInte);
        } else {
            numeSoli.append(anio);
            
            for (int i = 0; i < longitudRelleno; i++) {
                numeSoli.append("0");
            }
            numeSoli.append(numeSoliInte);
        }
        UtilidadesLog.debug(" Agregando prefijo YY a Consolidado: "+numeSoliInte+" => "
                            +numeSoli.toString());
        return new Long(numeSoli.toString());
    }

    /**
     * Metodo para PTL-3
     * @author eiraola
     * @since 12/Sep/2007
     */
    private DTOListaPicadoInduccionPTL cargarCampoCabeceraFactura(DTOListaPicadoInduccionPTL dtoListaPicado, 
            IRegistroSicc registro, String prefijoEsperado) throws InterfacesException {
        UtilidadesLog.debug(" - Cargar campo: de Cabecera de Factura... Entrada");
        
        String prefijo = (String)registro.obtenerCampo(IRegistroSicc.PTL3_PREFIJO);
        String valor = (String)registro.obtenerCampo(IRegistroSicc.PTL3_VALOR);
        UtilidadesLog.debug("   Prefijo: " + prefijo + " Valor: " + valor);
        
        if (!prefijoEsperado.equals(prefijo)) {
            String mensaje = "Se esperaba prefijo de campo Factura: "+prefijoEsperado+" pero se encontro: "+prefijo;
            UtilidadesLog.debug(mensaje);
            throw new InterfacesException(mensaje);
        }
        
        // Validaciones
        if (prefijo.equals(ConstantesPTL.PTL3_NRO_FAC)) { // 1:
            validarFormatoCampo(valor, "numerico", 8);
            dtoListaPicado.setNroFactura(new Long(valor));
        }
        
        UtilidadesLog.debug(" - Cargar campo: de Cabecera de Factura... Salida");
        return dtoListaPicado;
    }

    /**
     * Metodo para PTL-3
     * @author eiraola
     * @since 12/Sep/2007
     */
    private DTODetalleCaja cargarCampoDetalleCaja(DTODetalleCaja dtoDetalleCaja, IRegistroSicc registro, 
            String prefijoEsperado) throws InterfacesException {
        UtilidadesLog.debug(" - Cargar campo: de Detalle de caja... Entrada");
        
        String prefijo = (String)registro.obtenerCampo(IRegistroSicc.PTL3_PREFIJO);
        String valor = (String)registro.obtenerCampo(IRegistroSicc.PTL3_VALOR);
        UtilidadesLog.debug("   - Prefijo: " + prefijo + " Valor: " + valor);
        
        if (!prefijoEsperado.equals(prefijo)) {
            String mensaje = "Se esperaba prefijo de campo: "+prefijoEsperado+" pero se encontro: "+prefijo;
            UtilidadesLog.debug(mensaje);
            throw new InterfacesException(mensaje);
        }
        
        // Validaciones
        if (prefijo.equals(ConstantesPTL.PTL3_NRO_CAJA_PTL)) { // 1:
            validarFormatoCampo(valor, "alfanumerico", 11);
            dtoDetalleCaja.setNroCajaPTL(valor);
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_IND_CHEQUEO)) { // 31:
            validarFormatoCampo(valor, "alfanumerico", 1);
            
            if (valor.equals("1")) { // Chequeada
                dtoDetalleCaja.setIndChequeo(new Boolean(true));
            } else if (valor.equals("0")) { // No chequeada
                dtoDetalleCaja.setIndChequeo(new Boolean(false));
            } else {
                String mensaje = "Prefijo " + ConstantesPTL.PTL3_IND_CHEQUEO + 
                                 ": se esperaba valores 0 (No Chequeada) o 1 (Chequeada)";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            }
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_OPER_INT_FAC)) { // 32:
            validarFormatoCampo(valor, "alfanumerico", 20);
            dtoDetalleCaja.setOperadorIntroduccionFactura(valor);
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_OPER_CHEQ_FAC)) { // 33:
            validarFormatoCampo(valor, "alfanumerico", 20);
            dtoDetalleCaja.setOperadorChequeoCajaFactura(valor);
         
        } else if (prefijo.equals(ConstantesPTL.PTL3_IND_CAJAS_ACEP)) { // 34:
            validarFormatoCampo(valor, "alfanumerico", 1);
            
            if (valor.equals("1")) { // Si (Todas las cajas fueron aceptadas)
                // Correcto, igualmente se verificara a '1' para todas las Cajas del archivo
                dtoDetalleCaja.setIndicadorCajasAceptadas(valor);
            } else if (valor.equals("0")) { // No (No todas las cajas fueron aceptadas)
                String mensaje = "No fueron aceptadas todas las cajas de la factura";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(ErroresDeNegocio.INT_0120);
            } else {
                String mensaje = "Prefijo " + ConstantesPTL.PTL3_IND_CAJAS_ACEP + 
                                 ": se esperaba valores 0 (No) o 1 (Si)";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            }
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_NRO_ORIG_CAJA_FACTURA)) { // 35:
            validarFormatoCampo(valor, "numerico", 12);
            dtoDetalleCaja.setNumeroTotalCajas(new Long(valor));
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_NRO_ACTUA_CAJA_FACTURA)) { // 36:
            validarFormatoCampo(valor, "numerico", 12);
            dtoDetalleCaja.setNroActualCajasUsadas(new Long(valor));
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_NRO_CAJA)) { // 37:
            validarFormatoCampo(valor, "numerico", 12);
            dtoDetalleCaja.setNroCaja(new Long(valor));
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_TIPO_CAJA)) { // 38:
            validarFormatoCampo(valor, "alfanumerico", 1);
            
            if (valor.equals("1") || valor.equals("2")) { // Grande o Pequenia
                dtoDetalleCaja.setTipoCaja(valor);
            } else {
                String mensaje = "Prefijo " + ConstantesPTL.PTL3_TIPO_CAJA + 
                                 ": se esperaba valores 1 (Grande) o 2 (Pequenia)";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            }
            
        }
        
        UtilidadesLog.debug(" - Cargar campo: de Detalle de caja... Salida");
        return dtoDetalleCaja;
    }

    /**
     * Metodo para PTL-3
     * @author eiraola
     * @since 12/Sep/2007
     */
    private DTODetalleCajaProducto cargarCampoDetalleCajaProducto(DTODetalleCajaProducto dtoDetalleCajaProducto, 
            IRegistroSicc registro, String prefijoEsperado) throws InterfacesException {
        UtilidadesLog.debug(" - Cargar campo: de Detalle de Caja-producto... Entrada");
        
        String prefijo = (String)registro.obtenerCampo(IRegistroSicc.PTL3_PREFIJO);
        String valor = (String)registro.obtenerCampo(IRegistroSicc.PTL3_VALOR);
        UtilidadesLog.debug("   - Prefijo: " + prefijo + " Valor: " + valor);
        
        if (!prefijoEsperado.equals(prefijo)) {
            String mensaje = "Se esperaba prefijo de campo: "+prefijoEsperado+" pero se encontro: "+prefijo;
            UtilidadesLog.debug(mensaje);
            throw new InterfacesException(mensaje);
        }
        
        // Validaciones
        if (prefijo.equals(ConstantesPTL.PTL3_ANAQUEL)) { // 7:
            validarFormatoCampo(valor, "alfanumerico", 5);
            dtoDetalleCajaProducto.setAnaquel(valor);
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_CANT_REQ_PICAR)) { // 8:
            validarFormatoCampo(valor, "numerico", 10);
            dtoDetalleCajaProducto.setCantidadRequeridaPicar(new Long(valor));
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_CANT_ACTUAL_PICADA)) { // 9:
            validarFormatoCampo(valor, "numerico", 10);
            dtoDetalleCajaProducto.setCantidadActualPicada(new Long(valor));
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_NOM_PICADOR)) { // 16:
            validarFormatoCampo(valor, "alfanumerico", 20);
            dtoDetalleCajaProducto.setNombrePicadorProducto(valor);
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_DESC_PROD)) { // 21:
            validarFormatoCampo(valor, "alfanumerico", 30);
            dtoDetalleCajaProducto.setDescripcionProducto(valor);
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_IND_CAMBIO)) { // 29:
            validarFormatoCampo(valor, "alfanumerico", 1);
            
            if (valor.equals("0") || valor.equals("1")) { // 0 No hubo cambios, 1 Cambios
                dtoDetalleCajaProducto.setIndicadorCambios(valor);
            } else {
                String mensaje = "Prefijo " + ConstantesPTL.PTL3_IND_CAMBIO + 
                                 ": se esperaba valores 0 (No hubo cambios) o 1 (Cambios)";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            }
            
        } else if (prefijo.equals(ConstantesPTL.PTL3_COD_PROD)) { // 30:
            validarFormatoCampo(valor, "alfanumerico", 15);
            dtoDetalleCajaProducto.setCodigoProducto(valor);
            
        }
        
        UtilidadesLog.debug(" - Cargar campo: de Detalle de Caja-producto... Salida");
        return dtoDetalleCajaProducto;
    }

    /**
     * Metodo para PTL-3
     * @author eiraola
     * @since 12/Sep/2007
     */
    private DTODetalleCaja leerCampoDetalleCaja(MONGestorInterfaces gestor, InterfazInfo interfaz,
            DTODetalleCaja dtoDetalleCaja, String prefijoCampo) throws MareException, InterfacesException, RemoteException {
        IRegistroSicc registro = null;
        
        if ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
            dtoDetalleCaja = cargarCampoDetalleCaja(dtoDetalleCaja, registro, prefijoCampo);
        } else {
            String mensaje = "Tipo fichero no valido: (SO) Falta el campo de prefijo: " + prefijoCampo;
            UtilidadesLog.debug(" --- (2) "+mensaje);
            throw new InterfacesException(mensaje);
        }
        return dtoDetalleCaja;
    }

    /**
     * Metodo para PTL-3
     * @author eiraola
     * @since 12/Sep/2007
     */
    private DTODetalleCajaProducto leerCampoDetalleCajaProducto(MONGestorInterfaces gestor, InterfazInfo interfaz,
            DTODetalleCajaProducto dtoDetalleCajaProducto, String prefijoCampo) throws MareException, InterfacesException, 
            RemoteException {
        IRegistroSicc registro = null;
        
        if ((registro = gestor.cargarRegistro(interfaz, false)) != null) {
            dtoDetalleCajaProducto = cargarCampoDetalleCajaProducto(dtoDetalleCajaProducto, registro, prefijoCampo);
        } else {
            String mensaje = "Tipo fichero no valido: (SS) Falta el campo de prefijo: " + prefijoCampo;
            UtilidadesLog.debug(" --- (3) "+mensaje);
            throw new InterfacesException(mensaje);
        }
        return dtoDetalleCajaProducto;
    }

    /**
     * Metodo utilizado en PTL-3 para validar: tipo de dato numerico y longitud ya que
     * no se puede realizar con la definicion de campos del Interfaces.xml por la estructura 
     * que tiene el archivo.
     * @author eiraola
     * @since 11/Sep/2007
     */
    private void validarFormatoCampo(String valorCampo, String tipoDato, int longitud) throws InterfacesException {
        // Longitud
        if (valorCampo.length() > longitud) {
            String mensaje = "Formato no valido: "+valorCampo+ " (longitud de campo superior a " + longitud +").";
            UtilidadesLog.debug(mensaje);
            throw new InterfacesException(mensaje);
        }
        
        // Tipo de dato:
        if (tipoDato.equals("numerico")) {
            try {
                Long.parseLong(valorCampo);
            } catch (NumberFormatException nex) {
                String mensaje = "Formato no valido: "+valorCampo+ " (tipo de dato, se esperaba un registro con valor numerico).";
                UtilidadesLog.debug(mensaje);
                throw new InterfacesException(mensaje);
            }
        }
    }

}