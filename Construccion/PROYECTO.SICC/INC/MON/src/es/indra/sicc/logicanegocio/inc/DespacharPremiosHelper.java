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
 *
 *@author: Cortaberria
 *         Dante Castiglione
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.sicc.dtos.inc.DTOObtenerTipoSubtipoSolicitud;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;

import es.indra.sicc.dtos.inc.DTOActualizaIndicadorDespachado;
import es.indra.sicc.dtos.inc.DTODescuentosIncentivos;
import es.indra.sicc.dtos.inc.DTOProductoDescuento;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.logicanegocio.dto.MONMantenimientoDTO;
import es.indra.sicc.logicanegocio.dto.MONMantenimientoDTOHome;
import es.indra.sicc.logicanegocio.intsys.MONAdam;
import es.indra.sicc.logicanegocio.intsys.MONAdamHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocal;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DespacharPremiosHelper {
    private UtilidadesLog log = new UtilidadesLog();
    
    /**
     * Descripcion: este metodo debe despachar el premio monetario recibido por
     * parametro para el cliente y concurso tambien de los
     *  parametros.
     *
     * @author Dante Castiglione
     */
    public void despacharPremioTipoMonetario(ClientePremiacion 
        clientePremiacion, Premio premioGanado, ClientePremiacionConcurso 
        clienteConcurso) throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.despacharPremioTipoMone"
            +"tario(ClientePremiacion clientePremiacion, Premio premioGanado,"
            +"ClientePremiacionConcurso clienteConcurso):Entrada");
            
        //jrivas BLO-001 
        if (clientePremiacion.getClienteBloqueado()) {
            return;
        }            
            
        DAODespachoPremios dao = new DAODespachoPremios();

        PremioMonetario premioMonetario = (PremioMonetario) premioGanado;

        DTOCabeceraSolicitud dtoCabSol = new DTOCabeceraSolicitud();

        if (premioMonetario.getOidFormaPago().longValue() == ConstantesINC
            .FORMA_PAGO_ENTIDAD_BANCARIA.longValue()) {
        
                if(!premioMonetario.getPagoEnPartes()){
                    UtilidadesLog.debug("no pago en partes");
                    
                    if (clientePremiacion.getOidCodigoEmpleado() != null) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                    
                          UtilidadesLog.debug("Entidad Bancaria - clientePremiacion.getOid"
                            +"CodigoEmpleado " + clientePremiacion.getOidCodigoEmpleado().toString());
                            
                        try {
                            MONAdamHome home = (MONAdamHome) UtilidadesEJB.getHome(
                                "MONAdam", MONAdamHome.class);
                            MONAdam local = home.create();
                            local.ingresarComisionesEIncentivos(ConstantesCOM.MODULO_GENERADOR_INCENTIVO,
                                                                clientePremiacion.getOidCliente(), 
                                                                new BigDecimal(premioGanado.getUnidades().longValue()));
                        } catch (RemoteException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError
                                .ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        } catch (CreateException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError
                                .armarCodigoError(CodigosError
                                    .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                        
                        // vbongiov -- 21/06/06 -- DBLG500000775
                        dao.actualizarIndicadorListarGanador(clientePremiacion, 
                            premioMonetario.getNivel().getOidNivel(), clienteConcurso, null);
                    }
                         
                    // Actualizar el Flag Despachado de ganadoras
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                    
                      UtilidadesLog.debug("Actualizar flag despacho de ganadoras - " + 
                        "desde: despacharPremioTipoMonetario");
                    
                    //cvalenzu - BELC300023086
                    //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                    //    .getNivel().getOidNivel(), clienteConcurso, null);
                    
                    //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                    //    .getNivel().getOidNivel(), clienteConcurso, null, null);                    
                    
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("*** Antes de llamar a actualizarIndicadorDespachado"); 
                      UtilidadesLog.debug("*** premioMonetario.getOidGanadora(): " + premioMonetario.getOidGanadora());
                    }  
                    
                    DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
                    dtoActualiza.setClientePremiacion(clientePremiacion);
                    dtoActualiza.setClienteConcurso(clienteConcurso);
                    dtoActualiza.setOidNivelPremiacion(premioMonetario.getNivel().getOidNivel());
                    dtoActualiza.setOidPeriodoControl(null);
                    dtoActualiza.setOidCabSol(null);
                    dtoActualiza.setOidGanadora(premioMonetario.getOidGanadora());               
                    dao.actualizarIndicadorDespachado(dtoActualiza);        
                    //FIN - cvalenzu - BELC300023086
                        
                } else {
                    UtilidadesLog.debug("pago en partes");                    
                    try {
                        MONAdamHome home = (MONAdamHome) UtilidadesEJB.getHome(
                            "MONAdam", MONAdamHome.class);
                        MONAdam local = home.create();
                        
                        BigDecimal unidadesTotales = premioGanado.getUnidades();
                        ArrayList pagoPartes= premioMonetario.getPagosEnPartes();
                        PagoPartes pagoParte = null;
                        BigDecimal unidadesParte = null;
                        
                        int cant = pagoPartes!= null?pagoPartes.size():0;
                        
                        for (int i = 0; i < cant; i++) {
                            pagoParte = (PagoPartes) pagoPartes.get(i);
                            
                            if (clientePremiacion.getOidCodigoEmpleado() != null) {
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("Entidad Bancaria - clientePremiacion.getOid"
                                    +"CodigoEmpleado " + clientePremiacion.getOidCodigoEmpleado().toString());
                                
                                unidadesParte = unidadesTotales.multiply(pagoParte.getPorcentajePremio()).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP );
                                
                                local.ingresarComisionesEIncentivos(ConstantesCOM.MODULO_GENERADOR_INCENTIVO,
                                                                    clientePremiacion.getOidCliente(), 
                                                                    unidadesParte);  
                                                                    
                                // vbongiov -- 21/06/06 -- DBLG500000775
                                dao.actualizarIndicadorListarGanador(clientePremiacion, 
                                    premioMonetario.getNivel().getOidNivel(), clienteConcurso, pagoParte.getPeriodoControl().getOidPeriodo());                                                                    
                            }
                                 
                            // Actualizar el Flag Despachado de ganadoras
                            UtilidadesLog.debug("Actualizar flag despacho de ganadoras");
                            
                            //cvalenzu - BELC300023086
                            //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                            //    .getNivel().getOidNivel(), clienteConcurso, pagoParte.getPeriodoControl().getOidPeriodo());
                            
                            //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                            //    .getNivel().getOidNivel(), clienteConcurso, pagoParte.getPeriodoControl().getOidPeriodo(), null);                            
                            
                            DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
                            dtoActualiza.setClientePremiacion(clientePremiacion);
                            dtoActualiza.setClienteConcurso(clienteConcurso);
                            dtoActualiza.setOidNivelPremiacion(premioMonetario.getNivel().getOidNivel());
                            dtoActualiza.setOidPeriodoControl(pagoParte.getPeriodoControl().getOidPeriodo());
                            dtoActualiza.setOidCabSol(null);
                            dtoActualiza.setOidGanadora(pagoParte.getOidGanadora());               
                            dao.actualizarIndicadorDespachado(dtoActualiza);      
                            //FIN - cvalenzu - BELC300023086
                        }
                     
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (CreateException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
        }

        if (premioMonetario.getOidFormaPago().longValue() == ConstantesINC
            .FORMA_PAGO_ABONO_CC.longValue()) {
            // Generar solicitud 
            try {
                UtilidadesLog.debug("Forma Pago Abono - Obtenemos datos cabecera solicitud.");
                
                MONGenerarSolicitudModulosExternosLocal generarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternosLocalHome().create();
                
                /*MONGenerarSolicitudModulosExternosHome monGenerarSolicitudModulosExternos = PEDEjbLocators.getMONGenerarSolicitudModulosExternosHome();
                MONGenerarSolicitudModulosExternos generarSolicitudModulosExternos = monGenerarSolicitudModulosExternos.create();*/
                
                if(!premioMonetario.getPagoEnPartes()){
                    UtilidadesLog.debug("no pago en partes");
                    
                    dtoCabSol = obtenerDTOCabeceraSolicitud(ConstantesINC
                        .OPER_SOLIC_DESPACHO_PREMIO_MON, clientePremiacion, 
                            clienteConcurso,premioMonetario);
                       
                    DTOOID dtoOid = generarSolicitudModulosExternos.generaSolicitud(dtoCabSol);                    
            
                    UtilidadesLog.debug("oid solicitud generada: " +  dtoOid!=null?dtoOid.getOid():null);
                    
                     // Actualizar el Flag Despachado de ganadoras
                    UtilidadesLog.debug("Actualizar flag despacho de ganadoras");
                    
                    //cvalenzu - BELC300023086
                    //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                    //    .getNivel().getOidNivel(), clienteConcurso, null);
                    
                    //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                    //    .getNivel().getOidNivel(), clienteConcurso, null, dtoOid.getOid());                    
                    
                    DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
                    dtoActualiza.setClientePremiacion(clientePremiacion);
                    dtoActualiza.setClienteConcurso(clienteConcurso);
                    dtoActualiza.setOidNivelPremiacion(premioMonetario.getNivel().getOidNivel());
                    dtoActualiza.setOidPeriodoControl(null);
                    dtoActualiza.setOidCabSol(dtoOid.getOid());
                    dtoActualiza.setOidGanadora(premioMonetario.getOidGanadora());               
                    dao.actualizarIndicadorDespachado(dtoActualiza);      
                    //FIN - cvalenzu - BELC300023086
                
                } else {
                    UtilidadesLog.debug("pago en partes");
                    
                    BigDecimal unidadesTotales = new BigDecimal(premioGanado.getUnidades().toString());
                    ArrayList pagoPartes= premioMonetario.getPagosEnPartes();
                    PagoPartes pagoParte = null;
                    BigDecimal unidadesParte = null;
                    
                    int cant = pagoPartes!= null?pagoPartes.size():0;
                    
                    for (int i = 0; i < cant; i++) {
                       pagoParte = (PagoPartes) pagoPartes.get(i);
                        
                       unidadesParte = unidadesTotales.multiply(pagoParte.getPorcentajePremio()).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP );
                       
                       premioMonetario.setUnidades(unidadesParte);
                       
                       dtoCabSol = obtenerDTOCabeceraSolicitud(ConstantesINC.OPER_SOLIC_DESPACHO_PREMIO_MON, 
                                                               clientePremiacion, 
                                                               clienteConcurso,
                                                               premioMonetario);
                       
                       DTOOID dtoOid = generarSolicitudModulosExternos.generaSolicitud(dtoCabSol);                       
            
                       UtilidadesLog.debug("oid solicitud generada: " +  dtoOid!=null?dtoOid.getOid():null);
                      
                       // Actualizar el Flag Despachado de ganadoras
                       UtilidadesLog.debug("Actualizar flag despacho de ganadoras");
                       
                       //cvalenzu - BELC300023086
                       //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                       //   .getNivel().getOidNivel(), clienteConcurso, pagoParte.getPeriodoControl().getOidPeriodo());
                          
                       //dao.actualizarIndicadorDespachado(clientePremiacion, premioMonetario
                       //   .getNivel().getOidNivel(), clienteConcurso, pagoParte.getPeriodoControl().getOidPeriodo(), dtoOid.getOid());                          
                       
                       DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
                       dtoActualiza.setClientePremiacion(clientePremiacion);
                       dtoActualiza.setClienteConcurso(clienteConcurso);
                       dtoActualiza.setOidNivelPremiacion(premioMonetario.getNivel().getOidNivel());
                       dtoActualiza.setOidPeriodoControl(pagoParte.getPeriodoControl().getOidPeriodo());
                       dtoActualiza.setOidCabSol(dtoOid.getOid());
                       dtoActualiza.setOidGanadora(pagoParte.getOidGanadora());               
                       dao.actualizarIndicadorDespachado(dtoActualiza);      
                       //FIN - cvalenzu - BELC300023086                            
                    }
                    
                    premioMonetario.setUnidades(unidadesTotales);
                }
                
            } catch (CreateException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (MareException me) {
                UtilidadesLog.error("ERROR ", me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e);
            }
        }
    
        UtilidadesLog.info(" DespacharPremiosHelper.despacharPremioTipoMone"
            +"tario(ClientePremiacion clientePremiacion, Premio premioGanado,"
            +"ClientePremiacionConcurso clienteConcurso):Salida");
    }

    /**
     * Descripcion: este metodo debe despachar los premios de articulos
     * para el cliente y concurso pasados por parametro
     *
     * @author Dante Castiglione
     */
    public void despacharPremioTipoArticulo(ClientePremiacion 
        clientePremiacion, Premio premioGanado, ClientePremiacionConcurso 
        clienteConcurso) throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.despacharPremioTipoAr"
            +"ticulo(ClientePremiacion clientePremiacion, Premio premioGanado,"
            +"ClientePremiacionConcurso clienteConcurso):Entrada");
            
        //jrivas BLO-001 
        if (clientePremiacion.getClienteBloqueado()) {
            return;
        }            

        try {
            // Creacion DTO 
            DTOCabeceraSolicitud dtoCabSol = new DTOCabeceraSolicitud();

            // Generacion de Solicitud 
            dtoCabSol = obtenerDTOCabeceraSolicitud(ConstantesINC
                .OPER_SOLIC_DESPACHO_PREMIO_ART, clientePremiacion, 
                    clienteConcurso, premioGanado);

            //No hay posiciones, porque fueron bloqueados, no se realiza la generacion de la Solicitud de Premios
            if(dtoCabSol.getPosiciones().size()==0)
                return;
                
            MONGenerarSolicitudModulosExternosLocal generarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternosLocalHome().create();
            
            /*MONGenerarSolicitudModulosExternosHome 
                monGenerarSolicitudModulosExternos = PEDEjbLocators
                    .getMONGenerarSolicitudModulosExternosHome();
            MONGenerarSolicitudModulosExternos 
                generarSolicitudModulosExternos = 
                    monGenerarSolicitudModulosExternos.create();*/
            
            DTOOID dtoOid = generarSolicitudModulosExternos.generaSolicitud(dtoCabSol);            

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("oid solicitud generada: " +  dtoOid!=null?dtoOid.getOid():null);

            // Actualizar el Flag Despachado de ganadoras. 
            DAODespachoPremios dao = new DAODespachoPremios();
            UtilidadesLog.debug("Actualiza indicador despacho");
            
            //cvalenzu - BELC300023086
            //dao.actualizarIndicadorDespachado(clientePremiacion, 
            //    premioGanado.getNivel().getOidNivel(), clienteConcurso, null);
                
            //dao.actualizarIndicadorDespachado(clientePremiacion, 
            //    premioGanado.getNivel().getOidNivel(), clienteConcurso, null, dtoOid.getOid());    
            
            DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
            dtoActualiza.setClientePremiacion(clientePremiacion);
            dtoActualiza.setClienteConcurso(clienteConcurso);
            dtoActualiza.setOidNivelPremiacion(premioGanado.getNivel().getOidNivel());
            dtoActualiza.setOidPeriodoControl(null);
            dtoActualiza.setOidCabSol(dtoOid.getOid());
            dtoActualiza.setOidGanadora(premioGanado.getOidGanadora());   
            
            dao.actualizarIndicadorDespachado(dtoActualiza);      
            //FIN - cvalenzu - BELC300023086            
            
            UtilidadesLog.info(" DespacharPremiosHelper.despacharPremioTipoAr"
                +"ticulo(ClientePremiacion clientePremiacion, Premio" 
                +" premioGanado,ClientePremiacionConcurso clienteConcurso):"
                +"Salida");
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }

    /**
     * Descripcion: este metodo debe despachar los premios de puntuacion
     * para el cliente y concurso pasados por parametro
     *
     * @author Dante Castiglione
     */
    public void despacharPremioTipoPuntuacion(ClientePremiacion 
        clientePremiacion, Premio premioGanado, ClientePremiacionConcurso 
        clienteConcurso) throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.despacharPremioTipoPun"
            +"tuacion(ClientePremiacion clientePremiacion, Premio premioGanado"
            +",ClientePremiacionConcurso clienteConcurso):Entrada");
            
        //jrivas BLO-001 
        if (clientePremiacion.getClienteBloqueado()) {
            return;
        }            

        // Inicializacion
        PremioPuntos premioPuntos = (PremioPuntos) premioGanado;

        DAODespachoPremios dao = new DAODespachoPremios();
        
        dao.actualizarCuentaCorrientePuntos(clientePremiacion, clienteConcurso, 
            premioPuntos);       
        
        // Actualizar el Flag Despachado de ganadoras
        UtilidadesLog.debug("Actualizamos indicador despacho");
        
        //cvalenzu - BELC300023086
        //dao.actualizarIndicadorDespachado(clientePremiacion, premioGanado
        //    .getNivel().getOidNivel(), clienteConcurso, null);  
        
        //dao.actualizarIndicadorDespachado(clientePremiacion, premioGanado
        //    .getNivel().getOidNivel(), clienteConcurso, null, null);    
        
        DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
        dtoActualiza.setClientePremiacion(clientePremiacion);
        dtoActualiza.setClienteConcurso(clienteConcurso);
        dtoActualiza.setOidNivelPremiacion(premioGanado.getNivel().getOidNivel());
        dtoActualiza.setOidPeriodoControl(null);
        dtoActualiza.setOidCabSol(null);
        dtoActualiza.setOidGanadora(premioGanado.getOidGanadora());               
        dao.actualizarIndicadorDespachado(dtoActualiza);             
        //FIN - cvalenzu - BELC300023086
    }

    /**
     * Descripcion: despacha los premios del tipo descuento.
     * Autor: Dante Castiglione
     * Fecha de Creacion: 05/05/2005
     * Modificado: Carlos Leal 17/06/2005
     */
    public void despacharPremioTipoDescuentos(ClientePremiacion 
        clientePremiacion, Premio premioGanado, ClientePremiacionConcurso 
        clienteConcurso) throws MareException {
        UtilidadesLog.info("DespacharPremiosHelper.despacharPremioTipoDescuentos()- Entrada");
        
        //jrivas BLO-001 
        if (clientePremiacion.getClienteBloqueado()) {
            return;
        }            

        Concurso conc;

        PremioDescuento premioDescuento = (PremioDescuento) premioGanado;
        DTODescuentosIncentivos dtoDes = new DTODescuentosIncentivos();

        //ArrayList concursos = FactoriaConcurso.getFactoriaConcurso().
        //getConcursos(clientePremiacion.getOidPais());
        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
            .getConcursos(clientePremiacion.getOidPais());
        int cantConcursos = concursos.size();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Numero de concursos: " + cantConcursos);

        for (int i = 0; i < cantConcursos; i++) {
            conc = (Concurso) concursos.get(i);

            if (clienteConcurso.getOidConcurso().equals(conc
                .getOidConcurso())) {
                dtoDes.setIndComunicacionAutomatica(Boolean.valueOf(conc
                    .getComunicacionAutomatica()));
            }
        }

        dtoDes.setOidPais(clientePremiacion.getOidPais());
        dtoDes.setOidCliente(clientePremiacion.getOidCliente());
        dtoDes.setOidMarca(clientePremiacion.getOidMarca());
        dtoDes.setOidCanal(clientePremiacion.getOidCanal());
        dtoDes.setOidPeriodoInicial(premioDescuento.getOidPeriodoDesde());
        dtoDes.setOidPeriodoFinal(premioDescuento.getOidPeriodoHasta());
        dtoDes.setPorcentaje(premioDescuento.getPorcentaje());
        dtoDes.setImporte(new BigDecimal(premioDescuento.getCantidad()
            .longValue()));

        //harcodeo.....
        dtoDes.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("idioma desc: " + dtoDes.getOidIdioma());
        
        // Obtiene los accesos del concurso
        // vbongiov -31/03/2006 INC 80
        FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = { clienteConcurso.getOidConcurso() };
        dtoOids.setOids(oids);
  
        ArrayList concursos1 = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso1 = (Concurso) concursos1.get(0);
         
        dtoDes.setOidAcceso(concurso1.getOidAccesos());

        /*
         * Obtener un ArrayList llamado concursos = FactoriaConcursos.
         * getFactoriaConcurso().getConcursos(clientePremiacion.oidPais)
         *   b.- Buscar el concurso cuyo atributo oidConcurso es igual a 
         *   clienteConcurso.oidConcurso recibido
         *   por parametro.
         *   c.- Asignar el valor del atributo concurso.comunicacionAutomatica.
         */
        ArrayList dtos = new ArrayList();

        if (premioDescuento.getListaProductos() != null) {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("premioDescuento listaProductos cantidad: " +
                premioDescuento.getListaProductos().size());

            Iterator productos = premioDescuento.getListaProductos().iterator();

            while (productos.hasNext()) {
                ProductoDescuento prodDes = (ProductoDescuento) productos
                    .next();
                DTOProductoDescuento dtoProdDes = new DTOProductoDescuento();
                dtoProdDes.setOidMarcaProducto(prodDes.getOidMarcaProducto());
                dtoProdDes.setOidProducto(prodDes.getOidProducto());
                dtoProdDes.setOidUnidadNegocio(prodDes.getOidUnidadNegocio());
                dtoProdDes.setOidNegocio(prodDes.getOidNegocio());
                dtoProdDes.setOidSuperGenerico(prodDes.getOidSuperGenerico());
                dtoProdDes.setOidGenerico(prodDes.getOidGenerico());
                dtos.add(dtoProdDes);
            }
        }

        dtoDes.setProductos(dtos);
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("DTODescuentosIncentivos: " + dtoDes);

        //4.- Invocar a Interfaces:DTO:IMantenimientoDTO.ingresarDescuentosIn
        //centivos pasandole por parametro el dtoDes obtenido. 
        try {
            MONMantenimientoDTOHome monMantenimientoDTOHome = 
                getMONMantenimientoDTOHome();
            MONMantenimientoDTO monMantenimientoDTO = monMantenimientoDTOHome
                .create();
            monMantenimientoDTO.ingresarDescuentosIncentivos(dtoDes);
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        }

        UtilidadesLog.debug("Actuliza indy depacho.");

        DAODespachoPremios dao = new DAODespachoPremios();
        
        //cvalenzu - BELC300023086
        //dao.actualizarIndicadorDespachado(clientePremiacion, premioGanado
        //    .getNivel().getOidNivel(), clienteConcurso, null);
        
        //dao.actualizarIndicadorDespachado(clientePremiacion, premioGanado
        //    .getNivel().getOidNivel(), clienteConcurso, null, null);
        
        DTOActualizaIndicadorDespachado dtoActualiza = new DTOActualizaIndicadorDespachado();
        dtoActualiza.setClientePremiacion(clientePremiacion);
        dtoActualiza.setClienteConcurso(clienteConcurso);
        dtoActualiza.setOidNivelPremiacion(premioGanado.getNivel().getOidNivel());
        dtoActualiza.setOidPeriodoControl(null);
        dtoActualiza.setOidCabSol(null);
        dtoActualiza.setOidGanadora(premioGanado.getOidGanadora());               
        dao.actualizarIndicadorDespachado(dtoActualiza);              
        //FIN - cvalenzu - BELC300023086
        
        UtilidadesLog.info("DespacharPremiosHelper.despacharPremioTipoDescuentos() - Salida");
    }

    /**
    * Fecha de Creacion: 05/05/2005
    * Autor: Damasia Maneiro
    * Comentario: crea y retorna un objeto de la clase DTOCabeceraSolicitud con 
    * sus atributos completos desde los datos pasados por parametro.
    */
    private DTOCabeceraSolicitud obtenerDTOCabeceraSolicitud(Long 
        oidOperacion, ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clienteConcurso, Premio premioGanado)
        throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.obtenerDTOCabeceraSoli"
            +"citud(ong oidOperacion, ClientePremiacion clientePremiacion, "
            +"ClientePremiacionConcurso clienteConcurso, Premio premioGanado)"
            +":Entrada");

        //1.- Crear un objeto de la clase DTOCabeceraSolicitud y llamarlo 
        //dtoCabecera 
        DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();

        //2.- Obtener tipoSolicitudPosicion = DAODespachoPremios.obtenerTipoSub
        //tipoSolicitud pasandole por parametro clientePremiacion.oidPais, 
        //oidOperacion, clientePremiacion.oidAcceso, clientePremiacion
        //.oidMarca, clientePremiacion.oidCanal, clienteConcurso.dirigidoA 
        DAODespachoPremios daoDespachoPremios = new DAODespachoPremios();
        DAOClientePremiacion daoClientePremiacion = new DAOClientePremiacion();
        DTOPosicionSolicitud dtoPosicionSolicitud;
        ArrayList posiciones = new ArrayList();
        ArrayList articulos = null;
        TipoSolicitudPosicion tipoSolicitudPosicion = null;
        PremioArticuloLote premioArticuloLote = null;
        ArticuloLote articulo = null;

        try {
            Long tipoCliente = null;

            if (ConstantesINC.TIPO_CONSULTORA.equals(clienteConcurso
                .getDirigidoA())) {
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
            }

            if (ConstantesINC.TIPO_GERENTE.equals(clienteConcurso.getDirigidoA())) {
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
            }
            
            // Obtengo el tipo subtipo Solicitud
            // vbongiov -- 16/08/2006
            DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
            
            dtoObtenerTipoSubtipoSolicitud.setOidPais(clientePremiacion.getOidPais());
            dtoObtenerTipoSubtipoSolicitud.setOidOperacion(oidOperacion);
            dtoObtenerTipoSubtipoSolicitud.setOidCanal(clientePremiacion.getOidCanal());
            dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(clienteConcurso.getDirigidoA());
            dtoObtenerTipoSubtipoSolicitud.setOidMarca(clientePremiacion.getOidMarca());
            dtoObtenerTipoSubtipoSolicitud.setOidConcurso(clienteConcurso.getOidConcurso());
            dtoObtenerTipoSubtipoSolicitud.setOidCliente(clientePremiacion.getOidCliente());
            dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(clientePremiacion.getPeriodo().getOidPeriodo());

            tipoSolicitudPosicion = daoDespachoPremios.obtenerTipoSubtipoSolicitud(dtoObtenerTipoSubtipoSolicitud);
            
            // Obtengo el concurso
            Concurso concurso = obtenerConcurso(clienteConcurso.getOidConcurso());
            Periodo periodoFuturo = null;
            
            UtilidadesLog.debug("-GA- Buscando nulos.");
            UtilidadesLog.debug("-GA- Concurso: "+concurso);
            UtilidadesLog.debug("-GA- clientePremiacion: "+clientePremiacion);
            // vbongiov -- 14/11/2006 -- DBLG700000221
            if(ConstantesINC.OID_DIRIGIDO_A_GERENTE.equals(concurso.getDirigidoA()) 
               || (clientePremiacion.getIndCuponRecomendacion()!=null && clientePremiacion.getIndCuponRecomendacion().booleanValue())){
                  periodoFuturo =	daoClientePremiacion.obtenerPeriodo(clientePremiacion.getPeriodo().getOidPeriodo(), 1);
            }

            // Armo la cabecera
            dtoCabeceraSolicitud.setOperacion(oidOperacion);
            dtoCabeceraSolicitud.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
            dtoCabeceraSolicitud.setTipoSolicitud(tipoSolicitudPosicion
                .getTipoSolicitud());
            dtoCabeceraSolicitud.setTipoCliente(tipoCliente);
            dtoCabeceraSolicitud.setOidCliente(clientePremiacion.getOidCliente());
            dtoCabeceraSolicitud.setMarca(clientePremiacion.getOidMarca());
            dtoCabeceraSolicitud.setCanal(clientePremiacion.getOidCanal());
            dtoCabeceraSolicitud.setAcceso(tipoSolicitudPosicion.getAcceso());
            //modificado por Sapaza - fecha 11/09/2007 - incidencia Sicc20070412
            dtoCabeceraSolicitud.setObservaciones(null);
            //dtoCabeceraSolicitud.setObservaciones("");
            dtoCabeceraSolicitud.setOidConcursoParametros(clienteConcurso
                .getOidConcurso());
            dtoCabeceraSolicitud.setNumeroPremio(Integer.valueOf(premioGanado
                .getNumeroPremio().toString()));

            //Agregada
            dtoCabeceraSolicitud.setSubacceso(clientePremiacion.getSubacceso());
            dtoCabeceraSolicitud.setOidPais(clientePremiacion.getOidPais());
            
            /* vbongiov -- 17/11/2006 -- DBLG700000223
            //Jrivas 20/4/2006 Para Generar Solicitud LA fecha Dacturacion es igual a Fecha
            dtoCabeceraSolicitud.setFechaPrevistaFacturacion(new Timestamp(System.currentTimeMillis()));
            */
            
            //harcodeo
            dtoCabeceraSolicitud.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            
            // vbongiov -- 14/11/2006 -- DBLG700000221
            if(ConstantesINC.OID_DIRIGIDO_A_GERENTE.equals(concurso.getDirigidoA()) 
               || (clientePremiacion.getIndCuponRecomendacion()!=null && clientePremiacion.getIndCuponRecomendacion().booleanValue())){
               UtilidadesLog.debug("periodo futuro");
               dtoCabeceraSolicitud.setFecha(periodoFuturo.getFechaDesde());
               dtoCabeceraSolicitud.setPeriodo(periodoFuturo.getOidPeriodo());
               
            } else {
                UtilidadesLog.debug("periodo actual");
                dtoCabeceraSolicitud.setFecha(new Date(System.currentTimeMillis()));
                dtoCabeceraSolicitud.setPeriodo(clientePremiacion.getPeriodo().getOidPeriodo());
            }
            
            // vbongiov -- 14/11/2006 -- DBLG700000221
            clientePremiacion.setIndCuponRecomendacion(Boolean.FALSE);            

            if (!(premioGanado instanceof PremioArticuloLote)) {
                UtilidadesLog.debug("premioGanado NO es PremioArticuloLote");
                dtoPosicionSolicitud = new DTOPosicionSolicitud();
                dtoPosicionSolicitud.setTipoPosicion(tipoSolicitudPosicion
                    .getTipoPosicion());
                dtoPosicionSolicitud.setSubtipoPosicion(tipoSolicitudPosicion
                    .getSubtipoPosicion());

                if (premioGanado instanceof PremioMonetario) {
                    UtilidadesLog.debug("premioGanado ES PremioMonetario");

                    PremioMonetario premioMonetario = (PremioMonetario) premioGanado;

                    //jrivas DBLG500000735 20/6/2006
                    //DBLG500000945 - gPineda - 24/10/2006 - vuelve el seteo
                    dtoPosicionSolicitud.setPrecioContableUnitarioDocumento(
                        BigDecimal.valueOf(premioMonetario.getUnidades()
                            .longValue())); 
                    
                    //jrivas DBLG500000945 14/9/2006
                    dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(
                        BigDecimal.valueOf(premioMonetario.getUnidades()
                            .longValue()));   
                            
                    dtoPosicionSolicitud.setProducto(tipoSolicitudPosicion
                        .getProducto());

                    //mail a carlos
                    dtoPosicionSolicitud.setUnidadesDemandadas(new Long(-1));
                }

                posiciones.add(dtoPosicionSolicitud);
            } else {
                UtilidadesLog.debug("premioGanado ES PremioArticuloLote");
                premioArticuloLote = (PremioArticuloLote) premioGanado;
                articulos = premioArticuloLote.getArticulos();
                DTOReemplazoArticuloLote dtoReemplazoArticuloLote = null;
                DAOClientePremiacionConcurso daoClientePremiacionConcurso = new DAOClientePremiacionConcurso();

                UtilidadesLog.debug("premioArticuloLote articulos: " + 
                    articulos.size());

                for (int pos = 0; articulos.size() > pos; pos++) {
                    dtoPosicionSolicitud = new DTOPosicionSolicitud();
                    
                    //jrivas 24/11/2006 V-INC-09
                    dtoPosicionSolicitud.setTipoPosicion(tipoSolicitudPosicion
                        .getTipoPosicion());
                    dtoPosicionSolicitud.setSubtipoPosicion(tipoSolicitudPosicion
                        .getSubtipoPosicion());
                    
                    articulo = (ArticuloLote) articulos.get(pos);
                    dtoPosicionSolicitud.setProducto(articulo
                        .getOidCodigoProducto());
                    dtoPosicionSolicitud.setCodigoVentaFicticio(Long
                        .valueOf(articulo.getCodigoVentaFicticio()));

                    long unidadesDemandadas = premioArticuloLote.getPremio()    
                        .getNumeroUnidades().longValue() * articulo
                            .getNumeroUnidades().longValue();
                    dtoPosicionSolicitud.setUnidadesDemandadas(Long.valueOf(
                        String.valueOf(unidadesDemandadas)));
                    
                    //jrivas DBLG500000735 20/6/2006
                    /*dtoPosicionSolicitud.setPrecioContableUnitarioDocumento(
                        articulo.getPrecioPublico());*/
                    dtoPosicionSolicitud.setPrecioContableUnitarioLocal(
                        articulo.getPrecioPublico());     
                        
                    //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010                        
                    boolean esPremioPendiente = false;                                                                                        
                    String indicadorReemPremioBloqueado = daoDespachoPremios.validaPremioBloqueado(
                                                                clientePremiacion.getDatosPersonales().getCodRegion(),
                                                                concurso.getNumeroConcurso(),
                                                                clientePremiacion.getPeriodo().getCodperiodo(),
                                                                dtoPosicionSolicitud.getProducto(),
                                                                dtoPosicionSolicitud.getCodigoVentaFicticio());
                                                                
                    if(indicadorReemPremioBloqueado != null)
                        esPremioPendiente = true;                                                                
                                                
                    
                    // vbongiov -- Cambio 20090828 -- 8/06/2009
                    dtoReemplazoArticuloLote = daoClientePremiacionConcurso.verificarArticuloReemplazo(articulo,
                                                                                                       clientePremiacion,
                                                                                                       clienteConcurso);
                    
                    List posicionesCompuesta = null;
                    if(dtoReemplazoArticuloLote!= null){
                        dtoPosicionSolicitud.setProducto(dtoReemplazoArticuloLote.getProdOidProd());
                        dtoPosicionSolicitud.setCodigoVentaFicticio(Long.valueOf(dtoReemplazoArticuloLote.getCodVentFict()));
                        
                        // sapaza -- Cambio PER-SiCC-2010-0213 -- 16/04/2010 
                        dtoPosicionSolicitud.setUnidadesDemandadas(new Long(dtoReemplazoArticuloLote.getNumUnid().longValue()*unidadesDemandadas));
                        
                        dtoPosicionSolicitud.setPrecioContableUnitarioLocal(dtoReemplazoArticuloLote.getImpPrecPubi());
                        
                        //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010
                        if(indicadorReemPremioBloqueado != null)
                          if(indicadorReemPremioBloqueado.equals("1"))
                            esPremioPendiente = true;
                          else
                            esPremioPendiente = false;
                        
                        // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
                        String tipoAgrupacion = dtoReemplazoArticuloLote.getTipoAgrupacion();
                        if("C".equals(tipoAgrupacion)) {
                            List reemplazosCompuesta = daoClientePremiacionConcurso.obtenerPremiosReemplazoCompuesta(dtoReemplazoArticuloLote.getOidReemArtiLote());
                            
                            if(reemplazosCompuesta.size()>0) {
                                posicionesCompuesta = new ArrayList();
                            
                                for(int i=0; i<reemplazosCompuesta.size(); i++) {
                                    DTOReemplazoArticuloLote dtoReemplazoArticuloLoteAux = (DTOReemplazoArticuloLote)reemplazosCompuesta.get(i);
                                    DTOPosicionSolicitud dtoPosicionSolicitudAux = new DTOPosicionSolicitud();
                                    
                                    dtoPosicionSolicitudAux.setTipoPosicion(tipoSolicitudPosicion.getTipoPosicion());
                                    dtoPosicionSolicitudAux.setSubtipoPosicion(tipoSolicitudPosicion.getSubtipoPosicion());
                                    
                                    dtoPosicionSolicitudAux.setProducto(dtoReemplazoArticuloLoteAux.getProdOidProd());
                                    dtoPosicionSolicitudAux.setCodigoVentaFicticio(Long.valueOf(dtoReemplazoArticuloLoteAux.getCodVentFict()));
                                    dtoPosicionSolicitudAux.setUnidadesDemandadas(new Long(dtoReemplazoArticuloLoteAux.getNumUnid().longValue()*unidadesDemandadas));
                                    dtoPosicionSolicitudAux.setPrecioContableUnitarioLocal(dtoReemplazoArticuloLoteAux.getImpPrecPubi());
                                    
                                    posicionesCompuesta.add(dtoPosicionSolicitudAux);
                                }    
                            }
                        }
                        
                    }

                    //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010
                    if(esPremioPendiente) 
                        daoDespachoPremios.insertarPremioPendiente(premioGanado, clientePremiacion, concurso, dtoPosicionSolicitud);
                    else {
                        posiciones.add(dtoPosicionSolicitud);
                        
                        // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
                        if(posicionesCompuesta != null && posicionesCompuesta.size()>0)
                            posiciones.addAll(posicionesCompuesta);
                    }    
                }        
            }

            dtoCabeceraSolicitud.setPosiciones(posiciones);
            UtilidadesLog.info(" DespacharPremiosHelper.obtenerDTOCabeceraSoli"
                +"citud(ong oidOperacion, ClientePremiacion clientePremiacion,"
                +"ClientePremiacionConcurso clienteConcurso, Premio premioGa"
                +"nado):Salida");
            return dtoCabeceraSolicitud;
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }

    /**
    * Fecha de Creacion: 11/05/2005
    * Autor: Damasia Maneiro
    * Comentario: retorna un objeto concurso de acuerdo al oid recibido por
    * parametro.
    *
    */
    public Concurso obtenerConcurso(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.obtenerConcurso(Long oid"
            +"Concurso):Entrada");

        Long[] param = new Long[1];
        param[0] = oidConcurso;

        DTOOIDs dto = new DTOOIDs();
        dto.setOids(param);

        try {
            ArrayList concursos = FactoriaConcurso.getFactoriaConcurso()
                .getConcursosPorOID(dto);
            UtilidadesLog.info(" DespacharPremiosHelper.obtenerConcurso(Long "
                +"oidConcurso):Salida");
            return (Concurso) concursos.get(0);
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }

    private MONMantenimientoDTOHome getMONMantenimientoDTOHome()
            throws MareException {
        UtilidadesLog.info(" DespacharPremiosHelper.getMONMantenimientoDTOHome"
            +"():Entrada");
        MONMantenimientoDTOHome home = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }

        try {
            home = (MONMantenimientoDTOHome) bs.ejbLocator.getHome(
                "MONMantenimientoDTO", MONMantenimientoDTOHome.class);
        } catch (MareServiceException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info(" DespacharPremiosHelper.getMONMantenimientoDTOHome"
            +"():Salida");
        return home;
    }
    
    private MONGenerarSolicitudModulosExternosLocalHome getMONGenerarSolicitudModulosExternosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosLocalHome)context.lookup("java:comp/env/MONGenerarSolicitudModulosExternos");
    }    
    
}
