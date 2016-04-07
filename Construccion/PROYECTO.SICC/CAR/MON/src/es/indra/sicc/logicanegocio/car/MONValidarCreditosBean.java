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

package es.indra.sicc.logicanegocio.car;

import es.indra.sicc.logicanegocio.ped.MONPEDValidacionHome;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOSolicitudLimiteCredito;
import es.indra.sicc.dtos.car.DTODatosCliente;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOJerarquia;
import es.indra.sicc.dtos.car.DTOSolicitudBloqueada;
import es.indra.sicc.dtos.car.DTOTipoOfertaPrioridad;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTODias;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.CAREjbLocators;
import es.indra.sicc.util.CCCEjbLocators;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;

import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;

import es.indra.sicc.entidades.car.ParametrosGeneralesdeCarteraLocalHome;
import es.indra.sicc.entidades.car.ParametrosGeneralesdeCarteraLocal;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocalHome;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocal;

import es.indra.sicc.logicanegocio.car.MONSolicitudesBloqueadasHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;

import es.indra.sicc.logicanegocio.ped.MONPEDValidacion;
import es.indra.sicc.logicanegocio.ped.MONPEDValidacionLocal;

import javax.ejb.RemoveException;
import java.rmi.RemoteException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import java.sql.Date;
import java.math.BigDecimal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONValidarCreditosBean implements SessionBean  {

    private SessionContext ctx = null;

    private DTODatosCliente datosCliente;
    private DTOCodigoConfiguracion datosCodConfiguracion; 
    private Boolean[] resValidacion = new Boolean[4]; 
    private DTOSolicitudValidacion datosSolicitud; 
    private DTOJerarquia[] datosJerarquia; 
    private BigDecimal varMontoSolicitud; 
    private Date varFechaSolicitud;
    private ValidacionDeudaVencida valDeudaVen;
    private ValidacionCredito valCredito;    
    private ValidacionMontoMaximo valMontoMaximo; 
    private ValidacionPorcentajeMaximo valPorMaximo;
    private final static Long JERARQUIA_ACTIVA = new Long(1); 
    private static UtilidadesLog logAux = new UtilidadesLog();

    MONInterfaceModulos monInterfaceModulos; 


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
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public Long validarLineaCredito(DTOSolicitudValidacion dtoin) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.validarLineaCredito(DTOSolicitudValidacion):Entrada");
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("dtoin: " + dtoin);
        
        // Datos de la solicitud
        datosSolicitud = dtoin;
        
        // Obtiene los parametros de cliente
        this.obtenerParametrosCliente(datosSolicitud.getOidCliente());
        // Obtiene la configuración
        this.calcularCodigoConfiguracion();

        // Verifica la configuracón
        if(datosCodConfiguracion == null){
            UtilidadesLog.info("MONValidarCreditos.validarLineaCredito(DTOSolicitudValidacion):Salida");  
            return ConstantesCAR.ESTATUS_APROBADO;
        }

        // Obtiene el monto y la fecha de la solicitud  
        DAOSolicitud daoSolicitud = new DAOSolicitud();

        DTOSolicitudLimiteCredito dtoSolLimCred= daoSolicitud.obtenerFechaMontoTotalSolicitud(datosSolicitud.getOidSolicitud());

        varMontoSolicitud = dtoSolLimCred.getMontoSolicitud();
        varFechaSolicitud = dtoSolLimCred.getFechaSolicitud();

        // Se cargan los datos de las jerarquias
        this.cargarDatosJerarquia();

        // Primera jerarquia
        DTOJerarquia datosJer = (DTOJerarquia)datosJerarquia[0];

        // Valida Deuda Vencida
        if(datosCodConfiguracion.getValDiasDeuda().booleanValue()) {

            this.obtenerParametrosDeudaVencida(datosSolicitud.getOidCliente());
            
            valDeudaVen = new ValidacionDeudaVencida(datosCliente.getNumDiasAtraso(), 
                                                     new Long(datosCodConfiguracion.getDiasDeudaVenPerm().intValue()),
                                                     datosJer.getNumDias());
            resValidacion[0] = valDeudaVen.validar();
        } else {
            resValidacion[0] = Boolean.TRUE;
        }
        
        // Valida Linea de Credito
        if(datosCodConfiguracion.getValLineaCredito().booleanValue()) {
            this.obtenerParametrosLineaCredito(varMontoSolicitud, datosCliente.getLineaCredito(), datosSolicitud.getOidCliente());
            
            //por incidencia bloqueante, previo analisis de DT, se verifica que el PorcentajeValidacion puede ser nuelo
            Double porcentajeValidacion = null;
            if (datosCodConfiguracion.getPorcentajeValidacion() != null) {
                porcentajeValidacion = new Double(datosCodConfiguracion.getPorcentajeValidacion().toString());
            }
            
            valCredito = new ValidacionCredito(datosCliente.getLineaCreditoDisponible(), datosCliente.getLineaCredito(), 
                    datosJer.getExcesoLineaCredito(), porcentajeValidacion ,
                    new Integer(datosCodConfiguracion.getIndicadorValidacion().toString()), datosCodConfiguracion.getFechaVigenciaHasta(), 
                    datosCodConfiguracion.getFechaVigenciaDesde() , varFechaSolicitud);
            
            resValidacion[1] = valCredito.validar();
        } else {
            resValidacion[1] = Boolean.TRUE;
        }
        
        // Valida Monto Maximo
        if(datosCodConfiguracion.getValMontoMaximo().booleanValue()) {
            valMontoMaximo = new ValidacionMontoMaximo(
                                         datosCodConfiguracion.getMontoMaximoPermitido(), varMontoSolicitud, datosJer.getExcesoMontoMaximo());

            resValidacion[2] = valMontoMaximo.validar();

        } else {
            resValidacion[2] = Boolean.TRUE;
        }
        
        // Valida Porcentaje Max
        if(datosCodConfiguracion.getValporcentajeMaximo().booleanValue()) {
            this.obtenerParametrosPorcentajeMax(datosSolicitud.getOidCliente(), new Long(datosCodConfiguracion.getNumDiasAdicionales().intValue()));

            valPorMaximo = new ValidacionPorcentajeMaximo(datosCliente.getMontoDeudaVencida(), 
                                                          datosCliente.getDeudaTotalCliente(), 
                                                          new BigDecimal(datosCodConfiguracion.getPorcentajeMaximoPermitido().toString()));
            resValidacion[3] = valPorMaximo.validar();
        } else {
            resValidacion[3] = Boolean.TRUE;
            // borrar  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //this.datosCliente.setMontoDeudaVencida(new BigDecimal(0));
        }
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled()){
            UtilidadesLog.debug("resValidacion[0]: " + resValidacion[0]);
            UtilidadesLog.debug("resValidacion[1]: " + resValidacion[1]);
            UtilidadesLog.debug("resValidacion[2]: " + resValidacion[2]);
            UtilidadesLog.debug("resValidacion[3]: " + resValidacion[3]);
        }
        
        // Verifica el resultado obtenido
        if(!resValidacion[0].booleanValue() || !resValidacion[1].booleanValue() || !resValidacion[2].booleanValue() || !resValidacion[3].booleanValue()) {
            
            if ((resValidacion[0].booleanValue() && resValidacion[1].booleanValue() && 
                !resValidacion[2].booleanValue() && resValidacion[3].booleanValue())&&
                (this.obtenerIndicadorGestionMonto(datosSolicitud.getOidSolicitud()))&&
                (!this.esSolicitudReclamo(datosSolicitud.getOidSolicitud()))) {//Valido que sea SOLO por monto maximo y validar que el indicador este habilitado.
                    //17.3 Corroborar que la solicitud no sea un reclamos (se agrega en la validacion inicial V. Favale)
                    
                    //Procesar para hacer que valide monto maximo.
                    //17.2 Obtener el Valor Monto Maximo
                    UtilidadesLog.debug("Entro a gestionar monto maximo");
                    BigDecimal limiteMontoMaximo = datosCodConfiguracion.getMontoMaximoPermitido();

                    //17.3 Corroborar que la solicitud no sea un reclamos                    
                    //SELECT PSC.MODU_OID_MODU FROM PED_SOLIC_CABEC PSC WHERE PSC.OID_SOLI_CABE = 19626361
                    //REclamos es el modulo 15 o sea debe ser != de 15 (se agrega en la validacion inicial V. Favale)
                        
                    //17.4 y 17.5 Recuperar y sumar las posiciones (precioCatalogoExcluyente) Excluyendo Anuladas y las que no estan en PED_ESTRA_EXCLU
                    /*SELECT SUM(PSP.VAL_PREC_CATA_UNIT_LOCA * PSP.NUM_UNID_DEMA_REAL)
                    FROM PED_SOLIC_POSIC PSP, PRE_OFERT_DETAL POD, PRE_OFERT PO
                    WHERE PSP.SOCA_OID_SOLI_CABE = 19626361
                    AND PSP.ESPO_OID_ESTA_POSI <> 2
                    AND PSP.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER
                    AND POD.OFER_OID_OFER = PO.OID_OFER
                    AND PO.COES_OID_ESTR IN (SELECT PEE.COES_OID_ESTR FROM PED_ESTRA_EXCLU PEE)
                    */
                    
                    BigDecimal precioCatalogoExcluyente = this.calcularPrecioCatalogoExcluyente(datosSolicitud.getOidSolicitud());
                    //Modificacion punto 17.7 del DECU "Establecer una variable TOTAL = PRECIO CATALOGO EXCLUYENTE, la cual será utilizada en los puntos siguientes"
                    
                    //17.6 En un array cargar las posiciones excluyendo las cuyas estrategias esten en pre_estra_exclu y las anuladas
                    UtilidadesLog.debug("Obtengo la solicitud y las posiciones.");                    
                    DAOSolicitud dao = new DAOSolicitud();
                    DTOCabeceraSolicitud dtoC = dao.obtenerCabeceraSolicitud(datosSolicitud.getOidSolicitud());
                    dtoC.setPosiciones(dao.obtenerPosicionesSolicitud(datosSolicitud.getOidSolicitud()));                     
                    DTOOIDs estrategiasExcluidas = this.obtenerEstrategiasExcluidas();
                    
                    ArrayList posicionesNoExcluidas = new ArrayList();
                    
                    //Obtengo los datos de estrategia y tipo de oferta.
                     UtilidadesLog.debug("Obtengo los datos de estrategia y tipo de oferta.");
                    ArrayList posiciones = dtoC.getPosiciones();
                    StringBuffer detallesOferta = new StringBuffer();
                    
                    for (int i=0; i<posiciones.size(); i++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud) posiciones.get(i);
                        detallesOferta.append(pos.getOidDetalleOferta());                         
                        if (i<posiciones.size()-1) {
                            detallesOferta.append(",");
                        }
                    }
                     
                    RecordSet estraTipoOfert = this.obtenerEstraTipoOfertPosic(detallesOferta.toString()).getResultado();
                     
                    try {
                        for (int i=0; i<posiciones.size(); i++) {
                           DTOPosicionSolicitud pos = (DTOPosicionSolicitud) posiciones.get(i);
                           for (int j=0; j<estraTipoOfert.getRowCount(); j++){
                               Long oidDetaTmp = bigDecimalToLong((BigDecimal)estraTipoOfert.getValueAt(j,"OID_DETA_OFER"));
                               if (pos.getOidDetalleOferta().equals(oidDetaTmp)){
                                   pos.setOidEstrategia(bigDecimalToLong((BigDecimal)estraTipoOfert.getValueAt(j,"COES_OID_ESTR")));
                                   pos.setOidTipoOferta(bigDecimalToLong((BigDecimal)estraTipoOfert.getValueAt(j,"TOFE_OID_TIPO_OFER")));
                                   break;
                               }
                           }
                        }
                    } catch (Exception e) {
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
                    
                    //Quito las anuladas y exluidas.
                     UtilidadesLog.debug("Quito las anuladas y exluidas.");
                    Long[] estraExcl = estrategiasExcluidas.getOids();
                                        
                    for(int i=0; i<posiciones.size(); i++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud) posiciones.get(i);
                        //if (pos.getEstadoPosicion().longValue()!=2) { La validacion de anuladas ya se hace en el FUNCTION llamado por obtenerPosicionesSolicitud
                            boolean excluida = false;
                            if (estraExcl!=null){
                                for (int j=0; j<estraExcl.length; j++){//Chequeo si la estrategia esta en la tabla de excluidas.
                                    if (estraExcl[j].equals(pos.getOidEstrategia())){//Estrategia Excluida
                                        excluida=true;
                                        break;
                                    }
                                }
                            }
                            if (!excluida){//Agrego posicion no anulada y que no figura en excluidas.
                                posicionesNoExcluidas.add(pos);
                            }
                        //}                        
                    }
                                        
                    //Ordeno por precio catalogo de menor a mayor.
                     UtilidadesLog.debug("Ordeno por precio catalogo de menor a mayor.");
                    
                     for (int i=posicionesNoExcluidas.size()-1; i>0; i--) {
                         for(int j=0; j<i; j++) {
                             DTOPosicionSolicitud dtoJ = (DTOPosicionSolicitud)posicionesNoExcluidas.get(j);
                             DTOPosicionSolicitud dtoJ1 = (DTOPosicionSolicitud)posicionesNoExcluidas.get(j+1);                             
                             BigDecimal prCatUnLoJ = dtoJ.getPrecioCatalogoUnitarioLocal();
                             BigDecimal prCatUnLoJ1 = dtoJ1.getPrecioCatalogoUnitarioLocal();
                             Long lunDemReJ = dtoJ.getUnidadesDemandaReal();
                             Long lunDemReJ1 = dtoJ1.getUnidadesDemandaReal();
                             
                             BigDecimal unDemReJ = new BigDecimal(lunDemReJ);
                             BigDecimal unDemReJ1 = new BigDecimal(lunDemReJ1);
                             
                             BigDecimal resJ =  prCatUnLoJ.multiply(unDemReJ);
                             BigDecimal resJ1 =  prCatUnLoJ1.multiply(unDemReJ1);
                             
                             if (resJ.compareTo(resJ1)>0) {
                                 posicionesNoExcluidas.set(j,dtoJ1);
                                 posicionesNoExcluidas.set(j+1,dtoJ);                                 
                             }
                         }
                     }                                        
                                         
                    //17.7 En un array colocar los tipos de oferta de PED_TIPO_OFERT_PRIO ordenados de mayor a menor prioridad.
                     UtilidadesLog.debug("17.7 Proceso las posiciones de tipos de oferta CON prioridad.");
                     
                    ArrayList tiposOfertaPrio = this.obtenerTipoOfertaPrioridad();
                    
                    BigDecimal total;//new BigDecimal(0);Mod. pto. 17.7 DECU "Establecer una variable TOTAL = PRECIO CATALOGO EXCLUYENTE, la cual será utilizada en los puntos siguientes"
                    
                    if (precioCatalogoExcluyente==null){
                        total = new BigDecimal(0);
                    } else {
                        total = precioCatalogoExcluyente;
                    }
                    
                    // Recorro los tipos de oferta priorizados
                    ArrayList posOrdPorTiposOfertaPrio = new ArrayList();
                    ArrayList posPriorizadas = new ArrayList();
                    for (int i=0; i<tiposOfertaPrio.size(); i++) {
                        DTOTipoOfertaPrioridad dtoTiOfPri = (DTOTipoOfertaPrioridad)tiposOfertaPrio.get(i);
                        for (int j=0; j<posicionesNoExcluidas.size(); j++) {
                            DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posicionesNoExcluidas.get(j);
                            if (dtoTiOfPri.getOidTipoOferta().equals(pos.getOidTipoOferta())){
                                posOrdPorTiposOfertaPrio.add(pos);
                                posPriorizadas.add(new Long(j));
                            }
                        }                        
                    }
                    
                    BigDecimal totalTmp;
                    boolean excedio = false;
                    
                    //doliva -- cambio Optimizacion Logs -- 09/04/2010
                    if(logAux.isDebugEnabled())
                        UtilidadesLog.debug("limiteMontoMaximo:"+limiteMontoMaximo);
                        
                    for (int k=0; k<posOrdPorTiposOfertaPrio.size(); k++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posOrdPorTiposOfertaPrio.get(k);
                        
                        if  (excedio) {
                            //Anulo posiciones sin calcular nada porque ya se excedio con una entonces como esta
                            //ordenado de menor a mayor se deduce que se va a exceder con las siguientes.                            
                             pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                             pos.setSubtipoPosicion(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO);
                        } else {
                            BigDecimal prCatUnLo = pos.getPrecioCatalogoUnitarioLocal();
                            Long lunDemRe = pos.getUnidadesDemandaReal();                        
                            BigDecimal unDemRe = new BigDecimal(lunDemRe);
                            BigDecimal res =  prCatUnLo.multiply(unDemRe);
                            
                            totalTmp = total.add(res);  
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
                            if(logAux.isDebugEnabled())
                                UtilidadesLog.debug("totalTmp:"+totalTmp);
                            if (totalTmp.compareTo(limiteMontoMaximo)>0) {
                                //Se excedio del monto maximo. Anulo Esta posicion y levanto la bandera de excedio para anular las siguientes.
                                pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                                pos.setSubtipoPosicion(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO);
                                excedio = true;                                
                            } else {
                                //Sigo sumando.
                                total = totalTmp;
                            }
                        }
                    }
                    
                    //Recorro las posiciones que no pertenecen a ningun tipo de oferta priorizada
                     UtilidadesLog.debug("17.7 Proceso las posiciones de tipos de oferta SIN prioridad.");
                    ArrayList posSinPrioridad = new ArrayList();
                    for (int l=0; l<posicionesNoExcluidas.size(); l++) {
                        if (!posPriorizadas.contains(new Long(l)))  {
                            DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posicionesNoExcluidas.get(l);
                            posSinPrioridad.add(pos);
                        }
                    }
                    
                    excedio = false;
                    for (int k=0; k<posSinPrioridad.size(); k++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posSinPrioridad.get(k);
                        
                        if  (excedio) {
                            //Anulo posiciones sin calcular nada porque ya se excedio con una entonces como esta
                            //ordenado de menor a mayor se deduce que se va a exceder con las siguientes.                            
                             pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                             pos.setSubtipoPosicion(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO);
                        } else {
                            BigDecimal prCatUnLo = pos.getPrecioCatalogoUnitarioLocal();
                            Long lunDemRe = pos.getUnidadesDemandaReal();                        
                            BigDecimal unDemRe = new BigDecimal(lunDemRe);
                            BigDecimal res =  prCatUnLo.multiply(unDemRe);
                            
                            totalTmp = total.add(res);
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
                            if(logAux.isDebugEnabled())
                                UtilidadesLog.debug("totalTmp:"+totalTmp);
                            if (totalTmp.compareTo(limiteMontoMaximo)>0) {
                                //Se excedio del monto maximo. Anulo Esta posicion y levanto la bandera de excedio para anular las siguientes.
                                pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                                pos.setSubtipoPosicion(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO);
                                excedio = true;                                
                            } else {
                                //Sigo sumando.
                                total = totalTmp;
                            }
                        }
                    }
                    
                    //17.8 y 17.9 Ahora procedo a actualizar las posiciones Anuladas en la BBDD ped_solic_posic (estado_posicion y subtipo_posicion).
                     UtilidadesLog.debug("17.8 y 9 Procedo a actualizar las posiciones Anuladas en la BBDD.");
                    StringBuffer posicionesAct = new StringBuffer();
                    boolean almenosuno = false;
                    for (int k=0; k<posOrdPorTiposOfertaPrio.size(); k++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posOrdPorTiposOfertaPrio.get(k);
                        if (pos.getEstadoPosicion()!=null&&pos.getEstadoPosicion().equals(ConstantesPED.ESTADO_POSICION_ANULADO)&&
                            pos.getSubtipoPosicion()!=null&&pos.getSubtipoPosicion().equals(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO)) {
                                posicionesAct.append(pos.getOidPosicionSolicitud());
                                posicionesAct.append(",");
                                almenosuno = true;
                            }
                    }
                    /*if (almenosuno) posicionesAct.deleteCharAt(posicionesAct.length()-1);
                    
                    almenosuno = false;*/
                    for (int k=0; k<posSinPrioridad.size(); k++) {
                        DTOPosicionSolicitud pos = (DTOPosicionSolicitud)posSinPrioridad.get(k);
                        if (pos.getEstadoPosicion()!=null&&pos.getEstadoPosicion().equals(ConstantesPED.ESTADO_POSICION_ANULADO)&&
                            pos.getSubtipoPosicion()!=null&&pos.getSubtipoPosicion().equals(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO)) {
                                posicionesAct.append(pos.getOidPosicionSolicitud());
                                posicionesAct.append(",");
                                almenosuno = true;
                            }                    
                    }
                    if (almenosuno) posicionesAct.deleteCharAt(posicionesAct.length()-1);
                    
                    if (posicionesAct.length()>0) {
                        this.actualizarPosicionesAnuladasMontoMaximo(posicionesAct.toString());                        
                        
                        //Ahora se llama al CU PED Calcular Totales para que actualice los totales.
                        UtilidadesLog.debug("Llamo a calcular totales.");
                        
                        try{                       
    
                            MONPEDValidacion monPedValidacion = this.getMONPEDValidacionHome().create();
                            DTOEstatusSolicitud dtoES = monPedValidacion.calcularTotales(dtoin);
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
                            if(logAux.isDebugEnabled())
                                UtilidadesLog.debug("Resultado del Calculo de Totales:"+dtoES);
                         
                        } catch (RemoteException re) {
                             throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                                
                        }catch (NamingException e){
                            UtilidadesLog.error("ERROR",e);
                            ctx.setRollbackOnly();
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }catch(CreateException e){
                            UtilidadesLog.error("ERROR",e);
                            ctx.setRollbackOnly();
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
    
                        //17.10 Volver a hacer las validaciones por si algo cambio menos la de monto maximo.
                        UtilidadesLog.debug("Revalido la solicitud.--->");
                        return this.validarLineaCredito(dtoin);
                    } else {
                        //doliva -- cambio Optimizacion Logs -- 09/04/2010
                        if(logAux.isDebugEnabled())
                            UtilidadesLog.debug("Simulacion:"+datosSolicitud.getIndSimulacion());
                            
                        if(!datosSolicitud.getIndSimulacion().booleanValue()) {
                            // Obtiene el nivel de autorizacion 
                            Long varNivel;
                            
                            if(this.validarIndicadorJerarquia().booleanValue()) {
                                varNivel = this.calcularJerarquia();
                            } else {
                                varNivel = ConstantesCAR.JERARQUIA_J1;
                            }
                        
                        
                            // Obtiene el ejecutivo que debe autorizar la solicitud 
                            Long oidEjecutivo = this.calcularEjecutivoCuenta();
                            //Se guarda los datos de la solicitud bloqueada a espera de aprobacion
                            DTOSolicitudBloqueada dtoSolBloqueada = new DTOSolicitudBloqueada();
                        
                            dtoSolBloqueada.setOidPais(datosSolicitud.getOidPais());
                            dtoSolBloqueada.setOidTipoSolPED(datosCodConfiguracion.getOidTipoSolPED());
                            dtoSolBloqueada.setOidSubAcceso(datosSolicitud.getOidSubAcceso());
                            dtoSolBloqueada.setOidNivelRiesgo(datosCliente.getNivelRiesgo());
                            dtoSolBloqueada.setFechaSolicitud(varFechaSolicitud);
                            dtoSolBloqueada.setOidSolicitud(datosSolicitud.getOidSolicitud());
                            dtoSolBloqueada.setMontoSolicitud(varMontoSolicitud);
                            dtoSolBloqueada.setMontoDeudaVencida(datosCliente.getMontoDeudaVencida());
                            
                            // Se solicito validar Deuda Vencida
                            if(datosCodConfiguracion.getValDiasDeuda().booleanValue()){
                                dtoSolBloqueada.setIndDeudaVencida(resValidacion[0]);
                            }
                            
                            // Se solicito validar Linea Credito
                            if(datosCodConfiguracion.getValLineaCredito().booleanValue()) {
                                dtoSolBloqueada.setIndLineaCredito(resValidacion[1]);
                            }
                            
                            // Se solicito validar Monto Maximo
                            if(datosCodConfiguracion.getValMontoMaximo().booleanValue()) {
                                dtoSolBloqueada.setIndMontoMaximo(resValidacion[2]);
                            }
                            
                            // Se solicito validar Porcentaje Maximo
                            if(datosCodConfiguracion.getValporcentajeMaximo().booleanValue()) {
                                dtoSolBloqueada.setIndPorcentajeMaximo(resValidacion[3]);
                            }
                            
                            dtoSolBloqueada.setOidJerarquia(varNivel);
                            dtoSolBloqueada.setOidEjecutivo(oidEjecutivo);
                            dtoSolBloqueada.setOidPeriodo(datosSolicitud.getOidPeriodo());
                            dtoSolBloqueada.setOidCliente(datosSolicitud.getOidCliente());
                            dtoSolBloqueada.setNotificado(Boolean.FALSE);
                            dtoSolBloqueada.setOidGrupoSolicitud(datosCodConfiguracion.getGrupoSolicitud());
                            dtoSolBloqueada.setEstatus(ConstantesCAR.ESTATUS_BLOQUEADO);
                            dtoSolBloqueada.setOidZona(datosSolicitud.getZona());
                            
                            try {
                                this.getMONSolicitudesBloqueadasHome().actualizarSolicitudesEntregaBloqueadas(dtoSolBloqueada);
                            } catch(RemoteException re) {
                                throw new MareException(re,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                            }
                        }
                        //doliva -- cambio Optimizacion Logs -- 09/04/2010
                        if(logAux.isDebugEnabled())
                            UtilidadesLog.debug("POSICIONES SOLICITUD:"+posiciones);
                            
                        return ConstantesCAR.ESTATUS_BLOQUEADO;
                        
                    }
            } else {
                    // Verifica el indicador de simulación(pedido de prueba)             
                    if(!datosSolicitud.getIndSimulacion().booleanValue()) {
                        // Obtiene el nivel de autorizacion 
                        Long varNivel;
                        
                        if(this.validarIndicadorJerarquia().booleanValue()) {
                            varNivel = this.calcularJerarquia();
                        } else {
                            varNivel = ConstantesCAR.JERARQUIA_J1;
                        }
        
        
                        // Obtiene el ejecutivo que debe autorizar la solicitud 
                        Long oidEjecutivo = this.calcularEjecutivoCuenta();
                        //Se guarda los datos de la solicitud bloqueada a espera de aprobacion
                        DTOSolicitudBloqueada dtoSolBloqueada = new DTOSolicitudBloqueada();
        
                        dtoSolBloqueada.setOidPais(datosSolicitud.getOidPais());
                        dtoSolBloqueada.setOidTipoSolPED(datosCodConfiguracion.getOidTipoSolPED());
                        dtoSolBloqueada.setOidSubAcceso(datosSolicitud.getOidSubAcceso());
                        dtoSolBloqueada.setOidNivelRiesgo(datosCliente.getNivelRiesgo());
                        dtoSolBloqueada.setFechaSolicitud(varFechaSolicitud);
                        dtoSolBloqueada.setOidSolicitud(datosSolicitud.getOidSolicitud());
                        dtoSolBloqueada.setMontoSolicitud(varMontoSolicitud);
                        dtoSolBloqueada.setMontoDeudaVencida(datosCliente.getMontoDeudaVencida());
                        
                        // Se solicito validar Deuda Vencida
                        if(datosCodConfiguracion.getValDiasDeuda().booleanValue()){
                            dtoSolBloqueada.setIndDeudaVencida(resValidacion[0]);
                        }
                        
                        // Se solicito validar Linea Credito
                        if(datosCodConfiguracion.getValLineaCredito().booleanValue()) {
                            dtoSolBloqueada.setIndLineaCredito(resValidacion[1]);
                        }
                        
                        // Se solicito validar Monto Maximo
                        if(datosCodConfiguracion.getValMontoMaximo().booleanValue()) {
                            dtoSolBloqueada.setIndMontoMaximo(resValidacion[2]);
                        }
                        
                        // Se solicito validar Porcentaje Maximo
                        if(datosCodConfiguracion.getValporcentajeMaximo().booleanValue()) {
                            dtoSolBloqueada.setIndPorcentajeMaximo(resValidacion[3]);
                        }
                        
                        dtoSolBloqueada.setOidJerarquia(varNivel);
                        dtoSolBloqueada.setOidEjecutivo(oidEjecutivo);
                        dtoSolBloqueada.setOidPeriodo(datosSolicitud.getOidPeriodo());
                        dtoSolBloqueada.setOidCliente(datosSolicitud.getOidCliente());
                        dtoSolBloqueada.setNotificado(Boolean.FALSE);
                        dtoSolBloqueada.setOidGrupoSolicitud(datosCodConfiguracion.getGrupoSolicitud());
                        dtoSolBloqueada.setEstatus(ConstantesCAR.ESTATUS_BLOQUEADO);
                        dtoSolBloqueada.setOidZona(datosSolicitud.getZona());
                        
                        try {
                            this.getMONSolicitudesBloqueadasHome().actualizarSolicitudesEntregaBloqueadas(dtoSolBloqueada);
                        } catch(RemoteException re) {
                            throw new MareException(re,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        UtilidadesLog.info("MONValidarCreditos.validarLineaCredito(DTOSolicitudValidacion):Salida");
                        UtilidadesLog.debug("Bloqueado");
                        return ConstantesCAR.ESTATUS_BLOQUEADO;
                       
                    } else {
                        // Simulación
                        UtilidadesLog.info("MONValidarCreditos.validarLineaCredito(DTOSolicitudValidacion):Salida"); 
                        UtilidadesLog.debug("Bloqueado Simulacion");                        
                        return ConstantesCAR.ESTATUS_BLOQUEADO;                        
                    }
            }
        } else {
            // Validaciones correctas
            UtilidadesLog.info("MONValidarCreditos.validarLineaCredito(DTOSolicitudValidacion):Salida");  
            UtilidadesLog.debug("Aprobado");            
            return ConstantesCAR.ESTATUS_APROBADO;
        }        
    }

    private Long bigDecimalToLong(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        return new Long(number.longValue());
    }  
    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    public Long reversionLineaCredito(DTOSolicitudValidacion dtoin) throws MareException {
        try {
            UtilidadesLog.info("MONValidarCreditos.reversionLineaCredito(DTOSolicitudValidacion):Entrada"); 
            SolicitudesEntregaBloqueadasLocalHome solEntregasBloqH = this.getSolicitudesEntregaBloqueadasLocalHome();


            UtilidadesLog.debug("busco en solicitudes bloqueadas, la: " + dtoin.getOidSolicitud());
            SolicitudesEntregaBloqueadasLocal solEntregasBloq = solEntregasBloqH.findBySolicitud(dtoin.getOidSolicitud());
            
            try{
                solEntregasBloqH.remove(solEntregasBloq);
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                throw new MareException(pe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
            
            // El credito esta validado
            UtilidadesLog.info("MONValidarCreditos.reversionLineaCredito(DTOSolicitudValidacion):Salida"); 
            return ConstantesCAR.ESTATUS_APROBADO;
            
        } catch(NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException pex) {
            ctx.setRollbackOnly();
            throw new MareException(pex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void obtenerParametrosCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosCliente(Long):Entrada"); 
        try{
            ClienteDatosAdicionalesLocalHome cliDatosAdH = this.getClienteDatosAdicionalesLocalHome();

            ClienteDatosAdicionalesLocal cliDatosAd = cliDatosAdH.findByCliente(oidCliente);

            // Setea la Linea de Credito y el Nivel de Riesgo
            double valorCero = 0;  
            datosCliente = new DTODatosCliente();
            datosCliente.setLineaCredito(new BigDecimal((cliDatosAd.getImp_mont_line_cred()==null)?valorCero:cliDatosAd.getImp_mont_line_cred().doubleValue()));            
            DAOCAR  daoCar = new DAOCAR(ctx.getCallerPrincipal().getName());
            Long nivRiesgo = daoCar.obtenerNivelRiesgo(oidCliente);
            //datosCliente.setNivelRiesgo(cliDatosAd.getNiri_oid_nive_ries());            
            datosCliente.setNivelRiesgo(nivRiesgo);            
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled())
                UtilidadesLog.debug("MONValidarCreditos.obtenerParametrosCliente(Long):Nivel de riesgo query:"+nivRiesgo);   
            
            UtilidadesLog.info("MONValidarCreditos.obtenerParametrosCliente(Long):Salida"); 
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    /**
	 * Sistema:     BelcorpobtenerParametrosPorcentajeMax 
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void calcularCodigoConfiguracion() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.calcularCodigoConfiguracion():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        
        // Obtiene los datos de jerarquia
        datosCodConfiguracion = daoCAR.obtenerCodigoConfiguracionAsociado(
                                    datosCliente.getNivelRiesgo(), datosSolicitud.getOidTipoSolPais(), datosSolicitud.getZona());   
        UtilidadesLog.info("MONValidarCreditos.calcularCodigoConfiguracion():Salida");
    }

    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected Boolean obtenerIndicadorGestionMonto(Long oidSoliCabe) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerIndicadorGestionMonto():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
         UtilidadesLog.info("MONValidarCreditos.obtenerIndicadorGestionMonto():Salida");
        return daoCAR.obtenerIndicadorGestionMonto(oidSoliCabe);                                    
        
    }
    
    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected Boolean esSolicitudReclamo(Long oidSoliCabe) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.esSolicitudReclamo():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
         UtilidadesLog.info("MONValidarCreditos.esSolicitudReclamo():Salida");
        return daoCAR.esSolicitudReclamo(oidSoliCabe);                                    
        
    }   
    
    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected BigDecimal calcularPrecioCatalogoExcluyente(Long oidSoliCabe) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.calcularPrecioCatalogoExcluyente():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
         UtilidadesLog.info("MONValidarCreditos.calcularPrecioCatalogoExcluyente():Salida");
        return daoCAR.calcularPrecioCatalogoExcluyente(oidSoliCabe);                                    
        
    }       
    
    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected DTOSalida obtenerEstraTipoOfertPosic(String detallesOferta) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerEstraTipoOfertPosic():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
        UtilidadesLog.info("MONValidarCreditos.obtenerEstraTipoOfertPosic():Salida");
        return daoCAR.obtenerEstraTipoOfertPosic(detallesOferta);                                    
        
    }
    
    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected void actualizarPosicionesAnuladasMontoMaximo(String posiciones) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.actualizarPosicionesAnuladasMontoMaximo(String posiciones):Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        
        daoCAR.actualizarPosicionesAnuladasMontoMaximo(posiciones);
        UtilidadesLog.info("MONValidarCreditos.actualizarPosicionesAnuladasMontoMaximo(String posiciones):Salida");        
    }
    
    /**         
         * Modulo:      CAR
         * Fecha:       05/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected ArrayList obtenerTipoOfertaPrioridad() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerTipoOfertaPrioridad():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
        UtilidadesLog.info("MONValidarCreditos.obtenerTipoOfertaPrioridad():Salida");
        return daoCAR.obtenerTipoOfertaPrioridad();                                    
        
    }    
    
    /**         
         * Modulo:      CAR
         * Fecha:       02/06/2009
         * @version     1.0
         * @autor       Emilio Noziglia
         */
    protected DTOOIDs obtenerEstrategiasExcluidas() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerEstrategiasExcluidas():Entrada"); 
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                
         UtilidadesLog.info("MONValidarCreditos.obtenerEstrategiasExcluidas():Salida");
        return daoCAR.obtenerEstrategiasExcluidas();
        
    } 
    
    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void cargarDatosJerarquia() throws MareException {
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        
        // Obtiene los datos de la configuración
        datosJerarquia = daoCAR.obtenerDatosJerarquia();     
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void obtenerParametrosDeudaVencida(Long oidCliente) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosDeudaVencida(Long):Entrada");
        DTODias dtoDias;
        DTOSaldosPorFechasyVtos dtoSaldosPorFechasVtos = new DTOSaldosPorFechasyVtos();
        dtoSaldosPorFechasVtos.setOidCliente(oidCliente);
        dtoSaldosPorFechasVtos.setOidPais(datosSolicitud.getOidPais());

        if(monInterfaceModulos== null){
            monInterfaceModulos = this.getMONInterfaceModulosHome();
        }

        try{
            dtoDias = monInterfaceModulos.calcularDiasAtrasoCliente(dtoSaldosPorFechasVtos);
        } catch(Exception re) {
            UtilidadesLog.error("ERROR",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        datosCliente.setNumDiasAtraso(new Long(dtoDias.getNumeroDias().intValue()));
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosDeudaVencida(Long):Salida");
        
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void obtenerParametrosLineaCredito(BigDecimal montoSolicitud, BigDecimal lineaCredito, Long oidCliente) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosLineaCredito(BigDecimal , BigDecimal , Long):Salida");
        DTOTotal dtoTotal = new DTOTotal();

        // Si no esta, calcula la Deuda Total del Cliente
        if(datosCliente.getDeudaTotalCliente()==null){
            
            // Verifica si ya esta el objeto
            if(monInterfaceModulos== null){
                monInterfaceModulos = this.getMONInterfaceModulosHome();
            }
        
            DTOSaldosPorFechasyVtos dtoSaldosPorFechasVtos = new DTOSaldosPorFechasyVtos();
            dtoSaldosPorFechasVtos.setOidCliente(oidCliente);
            dtoSaldosPorFechasVtos.setOidPais(datosSolicitud.getOidPais());

            try {
                dtoTotal = monInterfaceModulos.calcularSaldoCCCliente(dtoSaldosPorFechasVtos);
            } catch(RemoteException re) {
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            datosCliente.setDeudaTotalCliente(dtoTotal.getTotal());
            
        } else {
            dtoTotal.setTotal(datosCliente.getDeudaTotalCliente());
        }

        // Calcula el cupon de tramite del cliente
        DTOTotal dtoTotalCupon;

        // Verifica si ya esta el objeto
        if(monInterfaceModulos== null){
            monInterfaceModulos = this.getMONInterfaceModulosHome();
        }
            
        // Calcula el cupon 
        DTOSaldosPorFechas dtoSaldosPorFechas  = new DTOSaldosPorFechas();
        dtoSaldosPorFechas.setOidCliente(oidCliente);
        dtoSaldosPorFechas.setOidPais(datosSolicitud.getOidPais());
        
        try {
            dtoTotalCupon = monInterfaceModulos.calcularCuponTramiteCliente(dtoSaldosPorFechas);
        } catch(RemoteException re) {
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        datosCliente.setCuponTramiteCliente(dtoTotalCupon.getTotal());        

        // Calcula el nomto de solicitudes nuevas
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        BigDecimal montoSolNuevas = daoSolicitud.calcularMontoSolicitudesNuevas(oidCliente);
        datosCliente.setMontoSolicitudesNuevas(montoSolNuevas);

        // Calcula linea Credito Disponible
        BigDecimal lineaCreditoDisp = lineaCredito.subtract(montoSolNuevas).subtract(dtoTotal.getTotal()).add(dtoTotalCupon.getTotal()).subtract(montoSolicitud);

        datosCliente.setLineaCreditoDisponible(lineaCreditoDisp);
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosLineaCredito(BigDecimal , BigDecimal , Long):Salida");
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected void obtenerParametrosPorcentajeMax(Long oidCliente, Long numDiasAdicionales) throws MareException {
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosPorcentajeMax(Long oidCliente, Long):Entrada");
        // Verifica si ya esta el objeto
        if(monInterfaceModulos== null){
            monInterfaceModulos = this.getMONInterfaceModulosHome();
        }

        // Busca el monto de deuda vencida
        DTOTotalyDias dtoTotalyDias;
        DTOSaldosPorDiasPeriodos dtoSaldosPorDiasPeriodos = new DTOSaldosPorDiasPeriodos();
        dtoSaldosPorDiasPeriodos.setOidCliente(oidCliente);
        dtoSaldosPorDiasPeriodos.setDiasDesde(new Integer(numDiasAdicionales.toString()));
        dtoSaldosPorDiasPeriodos.setOidPais(datosSolicitud.getOidPais()); 

        try {
            dtoTotalyDias = monInterfaceModulos.calcularDeudaVencidaCCCliente(dtoSaldosPorDiasPeriodos);
        } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        datosCliente.setMontoDeudaVencida(dtoTotalyDias.getTotal());
        
        // Si no esta, calcula la Deuda Total del Cliente
        if(datosCliente.getDeudaTotalCliente()==null){
            DTOTotal dtoTotal;
            DTOSaldosPorFechasyVtos dtoSaldosPorFechasVtos = new DTOSaldosPorFechasyVtos();
            dtoSaldosPorFechasVtos.setOidCliente(oidCliente);
            dtoSaldosPorFechasVtos.setOidPais(datosSolicitud.getOidPais());

            try {
                dtoTotal = monInterfaceModulos.calcularSaldoCCCliente(dtoSaldosPorFechasVtos);
            } catch(RemoteException re) {
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
        
            datosCliente.setDeudaTotalCliente(dtoTotal.getTotal());
        }
        UtilidadesLog.info("MONValidarCreditos.obtenerParametrosPorcentajeMax(Long oidCliente, Long):Salida");
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected Boolean validarIndicadorJerarquia() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.validarIndicadorJerarquia():Entrada");
        try{
            ParametrosGeneralesdeCarteraLocalHome paramGenCarH = this.getParametrosGeneralesdeCarteraLocalHome();;

            ParametrosGeneralesdeCarteraLocal paramGenCar = paramGenCarH.findByPais(datosSolicitud.getOidPais());

            //Verifica el nivel de jerarquia - JERARQUIA_ACTIVA /*Activo*/            
            if(paramGenCar.getOidIndicadorNivelJerarquia().equals(JERARQUIA_ACTIVA)) {
                UtilidadesLog.info("MONValidarCreditos.validarIndicadorJerarquia():Salida");
                return Boolean.FALSE; 
            } else {
                UtilidadesLog.info("MONValidarCreditos.validarIndicadorJerarquia():Salida");
                return Boolean.TRUE;
            }            
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected Long calcularJerarquia() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.calcularJerarquia():Entrada");
        Boolean[] miValidacion = resValidacion; 

        // Maximo nivel de Jerarquia
        DTOJerarquia dtoJerarquiaMax = (DTOJerarquia)datosJerarquia[datosJerarquia.length-1];

        if(!((Boolean)miValidacion[3]).booleanValue()){
            UtilidadesLog.info("MONValidarCreditos.calcularJerarquia():Salida");
            return dtoJerarquiaMax.getOidJerarquia();
        }

        // Cicla por las jerarquias
        DTOJerarquia dtoJerarquia;
        int cantJer= datosJerarquia.length;
        
        for(int i=1; i < cantJer; i++) {
            dtoJerarquia = (DTOJerarquia)datosJerarquia[i];

            // Valida la dias de deuda
            if(!((Boolean)miValidacion[0]).booleanValue()){
                valDeudaVen.setDiasAdicionalesDeudaVencida(dtoJerarquia.getNumDias());
                miValidacion[0] = valDeudaVen.validar();
            }

            // Valida linea de credito
            if(!((Boolean)miValidacion[1]).booleanValue()){
                valCredito.setExcesoLineaCredito(dtoJerarquia.getExcesoLineaCredito());
                miValidacion[1] = valCredito.validar();
            }

            // Valida Monto maximo
            if(!((Boolean)miValidacion[2]).booleanValue()){
                valMontoMaximo.setExcesoMontoMaximo(dtoJerarquia.getExcesoMontoMaximo());
                miValidacion[2] = valMontoMaximo.validar();
            }

            // Verifica las nuevas validaciones
            if(miValidacion[0].booleanValue() && miValidacion[1].booleanValue() && miValidacion[2].booleanValue()) {
                UtilidadesLog.info("MONValidarCreditos.calcularJerarquia():Salida");
                return dtoJerarquia.getOidJerarquia();
            }
        }
        UtilidadesLog.info("MONValidarCreditos.calcularJerarquia():Salida");
        return dtoJerarquiaMax.getOidJerarquia();
        
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    protected Long calcularEjecutivoCuenta() throws MareException {
        UtilidadesLog.info("MONValidarCreditos.calcularEjecutivoCuenta():Entrada");
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        
        // Obtiene los datos del ejecutivo de cuenta
        Long retorna = daoCAR.obtenerEjecutivoAsociado(datosCliente.getNivelRiesgo(), datosSolicitud.getZona());
        UtilidadesLog.info("MONValidarCreditos.calcularEjecutivoCuenta():Salida");
        return retorna;
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    private MONSolicitudesBloqueadas getMONSolicitudesBloqueadasHome() throws MareException {
        
        try{    
            MONSolicitudesBloqueadasHome carHome = CAREjbLocators.getMONSolicitudesBloqueadasHome();
        
            return carHome.create();
        
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }      
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
    private MONInterfaceModulos getMONInterfaceModulosHome() throws MareException {
   
        try{    
            MONInterfaceModulosHome cccHome = CCCEjbLocators.getMONInterfaceModulosHome();
        
            return cccHome.create();
        
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }      
    }

    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome() 
  {
      return new ClienteDatosAdicionalesLocalHome();
  }

    private SolicitudesEntregaBloqueadasLocalHome getSolicitudesEntregaBloqueadasLocalHome() 
    {
        return new SolicitudesEntregaBloqueadasLocalHome();
    }

    private ParametrosGeneralesdeCarteraLocalHome getParametrosGeneralesdeCarteraLocalHome() 
    {
        return new ParametrosGeneralesdeCarteraLocalHome();
    }


    private MONPEDValidacionHome getMONPEDValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPEDValidacionHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONPEDValidacion" ), MONPEDValidacionHome.class );
    }
}
