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
package es.indra.sicc.logicanegocio.com;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.com.DTOGerenteZona;
import es.indra.sicc.dtos.com.DTOClienteComision;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOTipificacionCliente;
import es.indra.sicc.entidades.com.TipoClienteComisionesDetalleLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.mae.DAOMAEMaestroClientes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.sql.Date;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.com.DAOCalcularComisiones;
import es.indra.sicc.dtos.com.DTOCalculoReporte;
import es.indra.sicc.dtos.com.DTOCuotaCalculoReporte;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.entidades.com.ComisionesLocalHome;
import es.indra.sicc.entidades.com.ComisionesLocal;
import es.indra.sicc.entidades.com.ComisionesVentasLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentasLocal;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocal;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocalHome;
import es.indra.sicc.entidades.com.ComisionesCalculadasLocal;
import es.indra.sicc.entidades.com.ComisionesClientesLocalHome;
import es.indra.sicc.entidades.com.ComisionesClientesLocal;
import es.indra.sicc.entidades.com.ComisionesMetasLocalHome;

import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.com.CuotasTramoComisionesCalculadasLocalHome;
import es.indra.sicc.entidades.com.CuotasTramoComisionesCalculadasLocal;
import es.indra.sicc.entidades.com.TipoClienteComisionesDetalleLocalHome;

import es.indra.sicc.util.COMEjbLocators;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONCalcularComisionesBean implements SessionBean 
{
  private SessionContext ctx = null;
   
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

  public void setSessionContext(SessionContext ctx){
    this.ctx = ctx;
  }

  
  /**    
   *@Author: pperez 
   *@Fecha: 07/04/2005
   *@paquete: N034
   *@return: 
   *@param: 
   *@Observaciones: calcularComisionesXVenta(DTODatosCalculosComision dto)
   * Diseñador tecnico: Hmansi
   * modificaciones  22/07/2005 - COM-06        - pperanzola
   *                 25/07/2005 - BELC300020172 - pperanzola
   * @performance se realiza el calculo del importe facturado de todas las consultoras para cada gerente mediante un query como dios manda.
   * @autor gdmarzi (in situ) 12/02/2007
  */ 
    public void calcularComisionesXVenta(DTODatosCalculosComision dto) throws MareException{
        UtilidadesLog.info("MONCalcularComisionesBean.calcularComisionesXVenta(DTODatosCalculosComision dto): Entrada");
        ComisionesVentasLocalHome comisionesVentaLHome = null;
        ComisionesVentasLocal comisionesVentaL = null;
        ComisionesLocalHome comisionesLHome = null;
        ComisionesLocal comisionesL = null;
        ComisionesMetasLocalHome comisionesMetasLHome = null;        
        ClienteDatosBasicosLocalHome clienteDatosBasicosLHome = null;
        ClienteDatosBasicosLocal clienteDB = null;
        ClienteTipoSubTipoLocalHome clienteTipoSubtipoLHome = null;
        ClienteTipoSubTipoLocal clienteTipoSubtipo = null;
        ComisionesVentaHistoricaLocalHome comisionesVentaHistoricaLHome = null;
        ComisionesVentaHistoricaLocal comisionesVentaHistorica = null;
        ComisionesCalculadasLocalHome comisionesCalculadasLHome = null;
        ComisionesCalculadasLocal comisionesCalculadas = null;
        ComisionesClientesLocal comisionesClientesLocal = null;
        Iterator it;
        DTOGerenteZona dtoGerenteZona;
        ArrayList tipificaciones;
        BigDecimal importeFacturado;
        Long oidCliente;
        BigDecimal topeMaximo;
        BigDecimal topeMinimo;
        Long oidComCabecera;
        TipoClienteComisionesDetalleLocalHome tccdLocalHome;        
        Collection tipoClienDetalles;
        
        UtilidadesLog.debug("DTODatosCalculosComision: " + dto);
        
        DAOCalcularComisiones daoCalcularComisiones = new DAOCalcularComisiones();
        
        try  {
            comisionesLHome = this.getComisionesLocalHome();
            comisionesL = comisionesLHome.findByPrimaryKey(dto.getOidComision());            
            
            comisionesVentaLHome = this.getComisionesVentasLocalHome();
            comisionesVentaL = comisionesVentaLHome.findByUK(comisionesL.getOid());
            
            Collection comisionesClientes = this.getComisionesClientesLocalHome().findByComision(dto.getOidComision());
            UtilidadesLog.debug("Se recuperaron " + comisionesClientes.size() +
                                " registros de ComisionesClientes (ambito de aplicacion)" + 
                                " para la comision " + dto.getOidComision());
            ArrayList gerentes = dto.getGerentes();
            DAOMAEMaestroClientes daoMae = new DAOMAEMaestroClientes(ctx.getCallerPrincipal().getName());
            
            for (int i=0; i < gerentes.size(); i++)  {
                dtoGerenteZona = null;
                importeFacturado = new BigDecimal(0);
                oidCliente = ((DTOClienteComision) gerentes.get(i)).getOid();
                topeMaximo = ((DTOClienteComision) gerentes.get(i)).getTopeMaximo();
                topeMinimo = ((DTOClienteComision) gerentes.get(i)).getTopeMinimo();
                UtilidadesLog.debug("DTOClienteComision: " + (DTOClienteComision)gerentes.get(i));
                
                tipificaciones = daoMae.obtenerTipificacionesCliente(oidCliente);

                it = comisionesClientes.iterator();                                             
                // DBLG700000215 Validamos el ambito geografico del cliente respecto al indicado en la comision
                while(it.hasNext()) {
                    comisionesClientesLocal = (ComisionesClientesLocal) it.next();
                    
                    oidComCabecera = comisionesClientesLocal.getTipoClienteComisionesCabecera();
                    
                    tccdLocalHome = this.getTipoClienteComisionesDetalleLocalHome();
                    tipoClienDetalles = tccdLocalHome.findByCabecera(oidComCabecera);
                    
                    if ( ! this.validarGerenteTipificacion(tipificaciones, tipoClienDetalles) ) {
                        UtilidadesLog.debug(" Tipificacion del cliente invalida para la especificada en ComisionCliente");
                        continue;
                    }
                    UtilidadesLog.debug(" Tipificacion del cliente valida para la especificada en ComisionCliente");
                    
                    dto.setOidSV(comisionesClientesLocal.getSubgerenciaVentas());
                    dto.setOidRegion(comisionesClientesLocal.getRegion());
                    dto.setOidZona(comisionesClientesLocal.getZonas());
                    dto.setOidSeccion(comisionesClientesLocal.getSeccion());
                    
                    UtilidadesLog.debug( "Validando ambito geografico:" +
                                         " Sgv_" + dto.getOidSV() + 
                                         " Reg_" + dto.getOidRegion() + 
                                         " Zon_" + dto.getOidZona() + 
                                         " Sec_" + dto.getOidSeccion() + " ..." );
                    
                    dtoGerenteZona = daoCalcularComisiones.validarGerenteAlcanceGeo(oidCliente, dto);
                    
                    if (dtoGerenteZona != null) {
                        // El gerente es valido para uno de los criterios de alcance 
                        // geografico de la comision (registros de Com_comis_clien)
                        UtilidadesLog.debug("... Gerente valido para el ambito geografico de la comision");
                        break; 
                    } else {
                        UtilidadesLog.debug("... Gerente fuera del ambito geografico");
                    }
                }

                UtilidadesLog.debug(" Este es el dtoGerenteZona: " + dtoGerenteZona);
                if (dtoGerenteZona != null)  {
                    UtilidadesLog.debug(" el dtoGerente es diferente de null .. ");

                    /**
                     * Calcula el importe facturado por el cual comisiona el gerente. 
                     */
                    importeFacturado = this.calcularImporteFacturado(dto, dtoGerenteZona, comisionesVentaL);

                    clienteDatosBasicosLHome = new ClienteDatosBasicosLocalHome();
                    clienteDB = clienteDatosBasicosLHome.findByPrimaryKey(oidCliente);
                    
                    BigDecimal porcentajePagar = null;
                    BigDecimal comisionPagar = null;
                    double importe = 0;
                    double importeOriginal = 0;
                    
                    UtilidadesLog.debug(" comisionesVentaL.getPorcentajeComision(): " + comisionesVentaL.getPorcentajeComision());
                    UtilidadesLog.debug(" comisionesVentaL.getImporteFijoComision(): " + comisionesVentaL.getImporteFijoComision());
                    
                    // 21229 - dmorello, 01/06/2005
                    if (comisionesVentaL.getPorcentajeComision() != null)  {
                        comisionPagar = new BigDecimal(comisionesVentaL.getPorcentajeComision().doubleValue() * importeFacturado.doubleValue()/100);
                    } else {
                        comisionPagar = comisionesVentaL.getImporteFijoComision();
                    }
                    porcentajePagar = comisionesVentaL.getPorcentajeComision();
                    
                    UtilidadesLog.debug(" comisionPagar: " + comisionPagar);
                    UtilidadesLog.debug(" topeMinimo(): " + topeMinimo);
                    UtilidadesLog.debug(" topeMaximo(): " + topeMaximo);
                    
                    // Control de tope Minino
                    if(topeMinimo!=null){
                        if (comisionPagar.compareTo(topeMinimo)==-1)  {
                            //comisionPagar = clienteComision.getTopeMinimo();
                              comisionPagar = topeMinimo;
                        }
                    }
                    
                    // Control de tope Maximo
                    if(topeMaximo!=null){
                        if (comisionPagar.compareTo(topeMaximo) == 1  &&
                            topeMaximo.compareTo(new BigDecimal(0))== 1)  {
                            //comisionPagar = clienteComision.getTopeMaximo();
                            comisionPagar = topeMaximo;
                        }
                    }
                    
                    UtilidadesLog.debug(" comisionesVentaL.getTipoComisionVta(): " + comisionesVentaL.getTipoComisionVta());
                    if (comisionesVentaL.getTipoComisionVta().longValue() == ConstantesCOM.COMISION_SOBRE_INCREMENTO.longValue())  {
                        UtilidadesLog.debug(" comisionesVentaL.getTipoComisionVtaIncremental(): " + comisionesVentaL.getTipoComisionVtaIncremental());
                        if (comisionesVentaL.getTipoComisionVtaIncremental().longValue() == ConstantesCOM.COMPARATIVO_HISTORICO.longValue())  {
                            
                            clienteTipoSubtipoLHome = new ClienteTipoSubTipoLocalHome();
                            clienteTipoSubtipo = clienteTipoSubtipoLHome.findByUK(oidCliente,ConstantesMAE.OID_TIPO_CLIENTE_GERENTE);

                            UtilidadesLog.debug("clienteTipoSubtipo: "+clienteTipoSubtipo);
                            comisionesMetasLHome = this.getComisionesMetasLocalHome();
                            
                            try  {
                                UtilidadesLog.debug(" dto.getOidComision():  " + dto.getOidComision());
                                UtilidadesLog.debug(" dto.getOidPeriodo(): " + dto.getOidPeriodo());
                                UtilidadesLog.debug(" clienteTipoSubtipo.getOid(): " + clienteTipoSubtipo.getOid());

                                /* Gacevedo - Segun modificacion al decu surgida de pruebas de aceptacion
                                 * el periodo a calcular es el mismo, pero del anio anterior.
                                 */
                                DAOCRA daoCra = new DAOCRA();
                                DTOPeriodo dtoPeriodoTemp = new DTOPeriodo();
                                dtoPeriodoTemp.setOid(dto.getOidPeriodo());
                                DTOSalida dtoSalida = daoCra.obtenerPeriodoAnioAnterior(dtoPeriodoTemp);
                                Long periodoComision = null;
                                if(!dtoSalida.getResultado().esVacio())
                                    periodoComision = new Long(dtoSalida.getResultado().getValueAt(0,"OID_PERI").toString());
                                else {
                                    throw new MareException(new Exception("No se encuentra el periodo historico relacionado a "+periodoComision.toString()),
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));    
                                }
                                //comisionesMetas = comisionesMetasLHome.findByUk(dto.getOidComision(), periodoComision, clienteTipoSubtipo.getSbti_oid_subt_clie());
                                
                                StringBuffer str = new StringBuffer();
                                str.append("SELECT * FROM COM_COMIS_METAS WHERE ");
                                str.append("COMI_OID_COMI = "+dto.getOidComision().toString()+" ");
                                str.append("aND CTSU_OID_CLIE_TIPO_SUBT = "+clienteTipoSubtipo.getOid()+" ");
                                str.append("aND PERD_OID_PERI = "+periodoComision.toString());
                                RecordSet rsMetas = null;
                                
                                try{
                                    rsMetas = BelcorpService.getInstance().dbService.executeStaticQuery(str.toString());
                                } catch(Exception e){
                                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                                }

                                /* mdolce 16/11/2006 DBLG700000227
                                 * Como estaba construido, si algun gerente no tiene meta no calcula nada,
                                 * y deberia calcular los que tiene metas, y los que no poner importe = 0
                                 */
                                if(!rsMetas.esVacio()){
                                    comisionesVentaHistoricaLHome = this.getComisionesVentaHistoricaLocalHome();
                                    comisionesVentaHistorica = comisionesVentaHistoricaLHome.findByUK(dto.getOidComision());
                                
                                    UtilidadesLog.debug(" comisionesVentaHistorica.getPorcentajeIncremento(): " + comisionesVentaHistorica.getPorcentajeIncremento());
                                    UtilidadesLog.debug(" comisionesVentaHistorica.getMontoIncremento(): "  + comisionesVentaHistorica.getMontoIncremento());
                                    UtilidadesLog.debug(" rsMetas.getValueAt(0,IMP_CALC).toString(): " + rsMetas.getValueAt(0,"IMP_CALC").toString());
    
                                    double importeCalculo = new BigDecimal(rsMetas.getValueAt(0,"IMP_CALC").toString()).doubleValue();
                                    importeOriginal = importeCalculo;
                                    UtilidadesLog.debug("*** importe META (Venta Historica): "  + importeOriginal);
                                    
                                    /* V-COM-01 eiraola 05/Ene/2007
                                     * Se realiza este ajuste porque el porcentaje y el monto
                                     * no son excluyentes. Ademas antes no estaba guardando
                                     * la meta objetivo en 'importe' cuando ambos incrementos eran null.
                                     */
                                    importe = importeOriginal; // La Meta Objetivo sera al menos la venta historica
                                    
                                    BigDecimal porcentajeIncremento = 
                                           (comisionesVentaHistorica.getPorcentajeIncremento() != null)
                                           ? comisionesVentaHistorica.getPorcentajeIncremento() 
                                           : new BigDecimal(0);
                                    BigDecimal montoIncremento = 
                                           (comisionesVentaHistorica.getMontoIncremento() != null)
                                           ? comisionesVentaHistorica.getMontoIncremento() 
                                           : new BigDecimal(0);
                                    
                                    if (porcentajeIncremento.compareTo(new BigDecimal(0)) != 0) {
                                        importe = importeCalculo + ((importeCalculo * 
                                                       porcentajeIncremento.doubleValue())/100);
                                    }
                                    
                                    if (montoIncremento.compareTo(new BigDecimal(0)) != 0) {
                                        importe = importe + montoIncremento.doubleValue();
                                    }
                                    // Fin    - Agrega  V-COM-01 eiraola 05/Ene/2007
                                }else{
                                   importe = 0;
                                }

                                UtilidadesLog.debug(" Importe resultante: " + importe);
                            } catch (FinderException fe)  {
                                UtilidadesLog.debug(fe);
                                importe = 0;
                            } 
                        } else if (comisionesVentaL.getTipoComisionVtaIncremental().longValue() == ConstantesCOM.COMPARATIVO_FILE.longValue())  {  
                            DTOSalida comisionesSAP = daoCalcularComisiones.recuperarComisionesMetasSAP(dto.getOidPeriodo(), dtoGerenteZona);
                            RecordSet rComisionesSAP = comisionesSAP.getResultado();
                            
                            UtilidadesLog.debug(" rComisionesSAP: " + rComisionesSAP);
                            importe = 0;
                            
                            // rgiorgi - 24-08-2005: inc. Perú JPB.
                            if ((!rComisionesSAP.esVacio()) && (rComisionesSAP.getValueAt(0,0)!=null)) {
                                UtilidadesLog.debug(" rComisionesSAP.getValueAt(0,VTANETAESTADISTICABLE)" + rComisionesSAP.getValueAt(0,"VTANETAESTADISTICABLE"));
                                UtilidadesLog.debug(" comisionPagar.doubleValue(): " + comisionPagar.doubleValue());
                                //Modificado por Hugo Mansi 21/01/006
                                if(rComisionesSAP.getValueAt(0,"VTANETAESTADISTICABLE")!=null && objectToDouble(rComisionesSAP.getValueAt(0,"VTANETAESTADISTICABLE")).doubleValue() <= importeFacturado.doubleValue()){
                                    //Modificado por Hugo Mansi 21/01/006    
                                    importe = comisionPagar.doubleValue();
                                } else {
                                    continue;
                                }
                            }else{
                               //Agrego Hugo Mansi 23/01/2006 por Incidencia Perú
                               //Si no hay estadisticas de venta se pasa al siguiente gerente
                               continue;
                            
                            }
                        }
                    }
                    
                    UtilidadesLog.debug(" comisionPagar.doubleValue(): " + comisionPagar.doubleValue());
                    UtilidadesLog.debug(" Importe Meta OBJETIVO: " + importe);
                    UtilidadesLog.debug(" importeFacturado: " + importeFacturado);

                    if (importeFacturado.doubleValue() >= importe)  {
                        comisionesCalculadasLHome = this.getComisionesCalculadasLocalHome();
                        Date fechaCalculo = new Date(System.currentTimeMillis());
                        Long periodo = dto.getOidPeriodo();
                        Long codigoCliente = clienteDB.getOid();
                        Long estado = ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE;
                        
                        DTOClienteComision dtoCliente = (DTOClienteComision) gerentes.get(i);
                        Long formaPago = null;
                        if (dtoCliente.getCodigoEmpleado() == null)  {
                            formaPago = ConstantesCOM.GERENTE_SIN_PLANILLA;
                        } else {
                            formaPago = ConstantesCOM.GERENTE_CON_PLANILLA;
                        }
                        
                        Long tipoPlantil = comisionesL.getTplaOidTipoPlan();
                        Long oidComi = comisionesL.getOid();
                        //mdolce 18/10/2006 Se cambia importe por importeOrigiinal INC DBLG700000166
                        BigDecimal cImporte = new BigDecimal(((importeFacturado.doubleValue() - importeOriginal) * porcentajePagar.doubleValue())/100);
                        
                        // DBLG700000215 y DBLG700000216 - Validacion del importe calculado respecto de los Topes (min y max).
                        if(topeMinimo != null) {
                            if (cImporte.compareTo(topeMinimo)==-1)  {
                              UtilidadesLog.debug(" Tomaremos el Tope minimo para la comision pues el Importe Calculado resulto menor a dicho tope");
                              cImporte = topeMinimo;
                            }
                        }
                        
                        if(topeMaximo != null) {
                            if (cImporte.compareTo(topeMaximo) == 1  &&
                                    topeMaximo.compareTo(new BigDecimal(0))== 1)  {
                                UtilidadesLog.debug(" Tomaremos el Tope Maximo para la comision pues el Importe Calculado resulto mayor a dicho tope");
                                cImporte = topeMaximo;
                            }
                        }
                        
                        Long tipoComision = ConstantesCOM.TIPO_COMISION_VENTAS;

                        UtilidadesLog.debug("ComisionesCalculadas create: ");
                        UtilidadesLog.debug("fechaCalculo: " + fechaCalculo);
                        UtilidadesLog.debug("periodo: " + periodo);
                        UtilidadesLog.debug("codigoCliente: " + codigoCliente);
                        UtilidadesLog.debug("estado: " + estado);
                        UtilidadesLog.debug("formaPago: " + formaPago);
                        UtilidadesLog.debug("tipoPlantil: " + tipoPlantil);
                        UtilidadesLog.debug("oidComi: " + oidComi);
                        UtilidadesLog.debug("cImporte: " + cImporte);
                        UtilidadesLog.debug("porcentaje: " + porcentajePagar);
                        UtilidadesLog.debug("tipoComision: " + tipoComision);
                        UtilidadesLog.debug("Fin create ");                        

                        comisionesCalculadas = comisionesCalculadasLHome.create(fechaCalculo, periodo, codigoCliente, estado, formaPago, tipoPlantil, oidComi);
                        comisionesCalculadas.setTipoComision(tipoComision);
                        comisionesCalculadas.setImporte(new Double(cImporte.doubleValue()));
                        comisionesCalculadas.setPorcentaje( new Double(porcentajePagar.doubleValue()));
                        comisionesCalculadas.setImporteVentaCalculada(new Double(importeFacturado.doubleValue()));
                        
                        comisionesCalculadasLHome.merge(comisionesCalculadas);
                    }
                }  //Fin Si dtoGerenteZona != null
            } // Fin for para cada gerente[]
        } catch (NoResultException fe)  {
            UtilidadesLog.debug(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
        } catch(PersistenceException e) {
             ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(MareException me) {
            me.printStackTrace();
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONCalcularComisionesBean.calcularComisionesXVenta(DTODatosCalculosComision dto): Salida");
    }


  /**
   * Calcula el importe facturado por las consultoras que dependen de un gerente determinado.
   * @autor gdmarzi
   */
  private BigDecimal calcularImporteFacturado(DTODatosCalculosComision dto, DTOGerenteZona dtoGerenteZona, ComisionesVentasLocal comisionesVentas) throws MareException{
      UtilidadesLog.info("MONCalcularComisiones.calcularImporteFacturado() Entrada");
      BelcorpService belcorpService;
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      BigDecimal importeFacturado;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      query.append(" SELECT ");
      query.append("   NVL( SUM(" + this.formulaImporteFacturado(comisionesVentas) + "), 0) AS importeFacturado ");
      query.append(" FROM " );
      query.append("   mae_clien_unida_admin cliadm, ");
      query.append("   zon_terri_admin terradm, ");
      query.append( this.tablasCondicionZonificacion(dtoGerenteZona) );
      query.append("   cra_perio cra, ");
      query.append("   cra_perio crai, ");
      query.append("   cra_perio craf, ");
      query.append("   ped_solic_cabec conso, ");
      query.append("   seg_acces ac, ");
      query.append("   seg_subac sub, ");
      query.append("   ped_tipo_solic pts, ");
      query.append("   ped_tipo_solic_pais ptsp, ");
      query.append("   ped_solic_posic sposi, ");
      query.append("   ped_solic_cabec cabec, ");
      query.append("   pre_ofert_detal oferDetal, ");
      query.append("   pre_tipo_ofert tipoOfer ");
      query.append(" WHERE ");
      query.append("   cliadm.ind_acti = 1 ");
      query.append("   AND cra.oid_peri = " + dto.getOidPeriodo() );
      query.append("   AND crai.oid_peri = perd_oid_peri_ini ");
      query.append("   AND craf.oid_peri(+) = perd_oid_peri_fin ");
      query.append("   AND crai.fec_inic <= cra.fec_inic ");
      query.append("   AND (perd_oid_peri_fin IS NULL OR cra.fec_fina <= craf.fec_fina) ");
      query.append("   AND cliadm.ztad_oid_terr_admi = terradm.oid_terr_admi ");
      query.append("   AND terradm.ind_borr = 0 ");
      // condicion de zonificacion del gerente para obtener las consultoras por las cual comisiona.
      query.append( this.condicionZonificacion(dtoGerenteZona) );
      query.append("   AND conso.clie_oid_clie = cliadm.clie_oid_clie ");
      query.append("   AND conso.perd_oid_peri = cra.oid_peri ");
      query.append("   AND conso.sbac_oid_sbac = sub.oid_sbac ");
      query.append("   AND sub.acce_oid_acce = ac.oid_acce ");
      query.append("   AND ac.oid_acce IN (" + arrayToString(dto.getOidAccesos()) + ") ");
      query.append("   AND conso.ind_ts_no_conso != 1 ");
      query.append("   AND pts.oid_tipo_soli = ptsp.tsol_oid_tipo_soli ");
      query.append("   AND cabec.tspa_oid_tipo_soli_pais = ptsp.oid_tipo_soli_pais ");
      query.append("   AND sposi.soca_oid_soli_cabe = cabec.oid_soli_cabe ");
      query.append("   AND cabec.soca_oid_soli_cabe = conso.oid_soli_cabe ");
      // se verfica que la solicitud sea comisionable
      query.append("   AND ptsp.ind_comi = 1 ");
      // si la comision NO tiene activo el flag de devoluciones, se verifica que no sean solicitues de devoluciones.
      if ( ! comisionesVentas.getDevoluciones().booleanValue() ) {
          query.append("   AND pts.ind_devo = 0 ");
      }
      // si la comision NO tiene activo el flag de anulaciones, se verifica que no sean solicitues de anulaciones.
      if ( ! comisionesVentas.getAnulaciones().booleanValue() ) {
          query.append("   AND pts.ind_anul = 0 ");
      }
      // se verfica que la posicion sea estadisticable
      query.append("   AND sposi.ofde_oid_deta_ofer = oferDetal.ofer_oid_ofer ");
      query.append("   AND oferDetal.tofe_oid_tipo_ofer = tipoOfer.oid_tipo_ofer ");
      query.append("   AND tipoOfer.ind_esta = 1 ");
      // se verifica condicion de calculo de incobrables para cada consolidado.
      query.append( this.condicionCalculoIncobrables(comisionesVentas) );
      // se verifica condicion de productos incluidos y excluidos
      query.append( this.condicionProductosIncluidosExcluidos(comisionesVentas, dto.getOidPeriodo()) );

      try {
          rs = belcorpService.dbService.executeStaticQuery(query.toString());
          importeFacturado = (BigDecimal)rs.getValueAt(0,0);
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONCalcularComisiones.calcularImporteFacturado() Salida");
      return importeFacturado;
  }


  /**
   * Retorna la condicion de Calculo de Incobrables segun la comision tratada.
   * Se verifica si se rechaza el consolidado por tener cuotas pendientes o
   * si se rechaza el consolidado por tener cuotas fuera del numero de dias para comisionar.
   * @autor gdmarzi
   */
  private String condicionCalculoIncobrables(ComisionesVentasLocal comisionesVentas) throws MareException {
      StringBuffer query = new StringBuffer();
      // Si el atributo calculo de incobrables de la comision esta seleccionado.
      if (comisionesVentas.getCalculoIncobrables().booleanValue())  {
          /* 
           * se verifica si se rechaza este consolidado por tener cuotas pendientes.
           */
          query.append("   AND (SELECT count (*) nroCuotasPendientes ");
          query.append("        FROM ccc_movim_cuent_corri cuota ");
          query.append("        WHERE cuota.imp_pend != 0 ");
          query.append("        AND LPAD(conso.val_nume_soli,10,'0') = LPAD(cuota.val_ejer_cuot,2,'0') || LPAD(cuota.num_iden_cuot,8,'0')");
          query.append("        AND cuota.clie_oid_clie = conso.clie_oid_clie ");
          query.append("        ) = 0 ");

          if (comisionesVentas.getCalculoIncobrablesFechaEmision().booleanValue() || 
              comisionesVentas.getCalculoIncobrablesFechaVencimiento().booleanValue() ) {
              /* 
               * se verifica si se rechaza el consolidado por tener cuotas fuera de dias.
               */
              query.append("   AND (SELECT count(*) nroCuotasFueraDias ");
              query.append("        FROM ccc_movim_cuent_corri cuota ");
              query.append("        WHERE cuota.imp_pend = 0 ");
              query.append("        AND LPAD(conso.val_nume_soli,10,'0') = LPAD(cuota.val_ejer_cuot,2,'0') || LPAD(cuota.num_iden_cuot,8,'0') ");
              query.append("        AND cuota.clie_oid_clie = conso.clie_oid_clie ");
              if (comisionesVentas.getCalculoIncobrablesFechaEmision().booleanValue() && 
                  comisionesVentas.getCalculoIncobrablesFechaVencimiento().booleanValue() ) {
                  query.append("        AND ( cuota.fec_ulti_movi - cuota.fec_docu > " + comisionesVentas.getDiasIncobrables() );
                  query.append("              OR cuota.fec_ulti_movi - cuota.fec_venc > " + comisionesVentas.getDiasIncobrables() + " ) " );
              } else if (comisionesVentas.getCalculoIncobrablesFechaEmision().booleanValue()) {
                  query.append("        AND cuota.fec_ulti_movi - cuota.fec_docu > " + comisionesVentas.getDiasIncobrables() );
              } else if (comisionesVentas.getCalculoIncobrablesFechaVencimiento().booleanValue()) {
                  query.append("        AND cuota.fec_ulti_movi - cuota.fec_venc > " + comisionesVentas.getDiasIncobrables() );
              }
              query.append("        ) = 0 ");
          }
      }
      return query.toString();
  }


  /**
   * Retorna la condicion de zonificacion segun el gerente que esta comisionando.
   */
  private String condicionZonificacion(DTOGerenteZona dtoGerenteZona) throws MareException {
      StringBuffer query = new StringBuffer();
      StringBuffer UA = new StringBuffer();
      // UA
      Long[] subg = dtoGerenteZona.getOidSubgerenciaVentas();
      Long[] region = dtoGerenteZona.getOidRegion();
      Long[] zona = dtoGerenteZona.getOidZona();
      Long[] seccion = dtoGerenteZona.getOidSeccion();
      if (subg != null) {
          // De las subgerencias
          query.append("   AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
          query.append("   AND s.IND_ACTI = 1 ");
          query.append("   AND s.IND_BORR = 0 ");
          query.append("   AND s.ZZON_OID_ZONA = z.OID_ZONA ");
          query.append("   AND z.IND_ACTI = 1 ");
          query.append("   AND z.IND_BORR = 0 ");
          query.append("   AND z.ZORG_OID_REGI = r.OID_REGI ");
          query.append("   AND r.IND_ACTI = 1 ");
          query.append("   AND r.IND_BORR = 0 ");
      
          for (int i = 0; i < subg.length; i++) {
              if (i != 0) {
                  UA.append(" ,");
              }
      
              UA.append(subg[i]);
          }
      
          query.append("   AND r.ZSGV_OID_SUBG_VENT IN (" + UA.toString() + ") ");
      } else if (region != null) {
          // De las regiones
          query.append("   AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
          query.append("   AND s.IND_ACTI = 1 ");
          query.append("   AND s.IND_BORR = 0 ");
          query.append("   AND s.ZZON_OID_ZONA = z.OID_ZONA ");
          query.append("   AND z.IND_ACTI = 1 ");
          query.append("   AND z.IND_BORR = 0 ");
      
          for (int i = 0; i < region.length; i++) {
              if (i != 0) {
                  UA.append(" ,");
              }
      
              UA.append(region[i]);
          }
      
          query.append("   AND z.ZORG_OID_REGI IN (" + UA.toString() + ") ");
      } else if (zona != null) {
          // De las zonas
          query.append("   AND terrAdm.ZSCC_OID_SECC = s.OID_SECC ");
          query.append("   AND s.IND_ACTI = 1 ");
          query.append("   AND s.IND_BORR = 0 ");
      
          for (int i = 0; i < zona.length; i++) {
              if (i != 0) {
                  UA.append(" ,");
              }
      
              UA.append(zona[i]);
          }
      
          query.append("   AND s.ZZON_OID_ZONA IN (" + UA.toString() + ") ");
      } else if (seccion != null) {
          // De las secciones                                  
          for (int i = 0; i < seccion.length; i++) {
              if (i != 0) {
                  UA.append(" ,");
              }
      
              UA.append(seccion[i]);
          }
      
          query.append("   AND terrAdm.ZSCC_OID_SECC IN (" + UA.toString() + ") ");
      }
      return query.toString();    
  }


  /**
   * Retorna las tabla segun la zonificacion del gerente.
   */
  private String tablasCondicionZonificacion(DTOGerenteZona dtoGerenteZona) throws MareException {
      StringBuffer query = new StringBuffer();
      // zonificacion el gerente por las que comisiona.
      if (dtoGerenteZona.getOidSubgerenciaVentas() != null) {
          query.append("   zon_secci s, zon_zona z, zon_regio r, ");
      } else if (dtoGerenteZona.getOidRegion() != null) {
          query.append("   zon_secci s, zon_zona z, ");
      } else if (dtoGerenteZona.getOidZona() != null) {
          query.append("   zon_secci s, ");
      }
      return query.toString();
  }


  /**
   * Retorna la formula adecuada para calcular el importe facturado para cada posicion.
   * @autor gdmarzi
   */
  private String formulaImporteFacturado(ComisionesVentasLocal comisionesVentas) throws MareException{
      StringBuffer query = new StringBuffer();
      if ( ! comisionesVentas.getFaltantesNoAnunciados().booleanValue() ) {
          if (comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_CATALOGO)) {
              // si Faltantes No Anunciados es false y formula es Venta Catalogo 
              query.append(" (sposi.num_unid_aten * sposi.val_prec_cata_unit_loca) ");
          } else if (comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_FACTURA)) {
              // si Faltantes No Anunciados es false y formula es Venta Facturada
              query.append(" (sposi.num_unid_aten * sposi.val_prec_fact_unit_loca) ");
          } else if(comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_NETA)) {
              // si Faltantes No Anunciados es false y formula es Venta Neta
              query.append(" (sposi.num_unid_aten * sposi.val_prec_neto_unit_loca) ");
          }
      } else {
          if (comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_CATALOGO)) {
              // si Faltantes No Anunciados es true y formula es Venta Catalogo
              query.append("   CASE WHEN (sposi.ind_ctrl_stoc = 1) ");	   				
              query.append("   THEN (sposi.num_unid_dema * sposi.val_prec_cata_unit_loca) ");
              query.append("   ELSE (sposi.num_unid_aten * sposi.val_prec_cata_unit_loca) ");
              query.append("   END ");
          } else if (comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_FACTURA)) {
              // si Faltantes No Anunciados es true y formula es Venta Facturada
              query.append("   CASE WHEN (sposi.ind_ctrl_stoc = 1) ");	   				
              query.append("   THEN (sposi.num_unid_dema * sposi.val_prec_fact_unit_loca) ");
              query.append("   ELSE (sposi.num_unid_aten * sposi.val_prec_fact_unit_loca) ");
              query.append("   END ");
          } else if(comisionesVentas.getFormula().equals(ConstantesCOM.VENTA_NETA)) {
              // si Faltantes No Anunciados es true y formula es Venta Neta
              query.append("   CASE WHEN (sposi.ind_ctrl_stoc = 1) ");	   				
              query.append("   THEN (sposi.num_unid_dema * sposi.val_prec_neto_unit_loca) ");
              query.append("   ELSE (sposi.num_unid_aten * sposi.val_prec_neto_unit_loca) ");
              query.append("   END ");
          }
      }
			return query.toString();
  }


  /**
   * Retorna la condicion de productos incluidos y excluidos para la comision.
   * @autor gdmarzi
   */
  private String condicionProductosIncluidosExcluidos(ComisionesVentasLocal comisionesVentas, Long oidPeriodo) throws MareException{
      UtilidadesLog.info("MONCalcularComisiones.condicionProductosIncluidosExcluidos() Entrada");
      StringBuffer query = new StringBuffer();
      if ( this.verificarProductosIncluidosExcluidos(comisionesVentas) ) {
          /*
           * inclusion de productos
           */
          query.append("   AND (SELECT COUNT (*) gdm ");
          query.append("        FROM mae_produ pr, ");
          query.append("             pre_ofert_detal deta, ");
          query.append("             pre_ofert ofer, ");
          query.append("             pre_matri_factu_cabec matri, ");
          query.append("             cra_perio peri, ");
          query.append("             ( SELECT mapr_oid_marc_prod marca, ");
          query.append("                  uneg_oid_unid_nego unidadnegocio, ");
          query.append("                  nego_oid_nego negocio, ");
          query.append("                  sgen_oid_supe_gene supergenerico, ");
          query.append("                  gene_oid_gene generico, ");
          query.append("                  prod_oid_prod producto, ");
          query.append("                  cra.cana_oid_cana canal, ");
          query.append("                  tofe_oid_tipo_ofer tipooferta, ");
          query.append("                  civi_oid_cicl_vida ciclovida ");
          query.append("               FROM com_comis_produ cprodu, ");
          query.append("                  com_tipo_produ tprodu, ");
          query.append("                  cra_perio cra, ");
          query.append("                  com_comis com ");
          query.append("               WHERE cprodu.comi_oid_comi = " + comisionesVentas.getComision());
          query.append("                  AND cprodu.comi_oid_comi = com.oid_comi ");
          query.append("                  AND tprodu.oid_tipo_prod = cprodu.tpro_oid_tipo_prod ");
          query.append("                  AND cra.oid_peri = com.perd_oid_peri ");
          query.append("                  AND tprodu.cod_tipo_prod like 'I') prodinclu ");
          query.append("        WHERE pr.oid_prod = sposi.prod_oid_prod ");
          query.append("          AND deta.ofer_oid_ofer = ofer.oid_ofer ");
          query.append("          AND ofer.mfca_oid_cabe = matri.oid_cabe ");
          query.append("          AND matri.perd_oid_peri = peri.oid_peri ");
          query.append("          AND deta.prod_oid_prod = pr.oid_prod ");
          query.append("          AND peri.oid_peri = " + oidPeriodo );
          query.append("          AND ( prodinclu.marca IS NULL OR prodinclu.marca = pr.mapr_oid_marc_prod ) ");
          query.append("          AND ( prodinclu.unidadnegocio IS NULL OR prodinclu.unidadnegocio = pr.uneg_oid_unid_nego ) ");
          query.append("          AND ( prodinclu.negocio IS NULL OR prodinclu.negocio = pr.nego_oid_nego ) ");
          query.append("          AND ( prodinclu.supergenerico IS NULL OR prodinclu.supergenerico = pr.sgen_oid_supe_gene ) ");
          query.append("          AND ( prodinclu.generico IS NULL OR prodinclu.generico = pr.gene_oid_gene ) ");
          query.append("          AND ( prodinclu.canal IS NULL OR prodinclu.canal = peri.cana_oid_cana) ");
          query.append("          AND ( prodinclu.tipooferta IS NULL OR prodinclu.tipooferta = deta.tofe_oid_tipo_ofer ) ");
          query.append("          AND ( prodinclu.ciclovida IS NULL OR prodinclu.ciclovida = deta.civi_oid_ciclo_vida ) ");
          query.append("        ) <> 0 ");
          /*
           * exclusion de productos
           */
          query.append("   AND (SELECT COUNT (*) khuss ");
          query.append("        FROM mae_produ pr, ");
          query.append("             pre_ofert_detal deta, ");
          query.append("             pre_ofert ofer, ");
          query.append("             pre_matri_factu_cabec matri, ");
          query.append("             cra_perio peri, ");
          query.append("             ( SELECT mapr_oid_marc_prod marca, ");
          query.append("                  uneg_oid_unid_nego unidadnegocio, ");
          query.append("                  nego_oid_nego negocio, ");
          query.append("                  sgen_oid_supe_gene supergenerico, ");
          query.append("                  gene_oid_gene generico, ");
          query.append("                  prod_oid_prod producto, ");
          query.append("                  cra.cana_oid_cana canal, ");
          query.append("                  tofe_oid_tipo_ofer tipooferta, ");
          query.append("                  civi_oid_cicl_vida ciclovida ");
          query.append("               FROM com_comis_produ cprodu, ");
          query.append("                  com_tipo_produ tprodu, ");
          query.append("                  cra_perio cra, ");
          query.append("                  com_comis com ");
          query.append("               WHERE cprodu.comi_oid_comi = " + comisionesVentas.getComision());
          query.append("                  AND cprodu.comi_oid_comi = com.oid_comi ");
          query.append("                  AND tprodu.oid_tipo_prod = cprodu.tpro_oid_tipo_prod ");
          query.append("                  AND cra.oid_peri = com.perd_oid_peri ");
          query.append("                  AND tprodu.cod_tipo_prod like 'E') prodexclu ");
          query.append("        WHERE pr.oid_prod = sposi.prod_oid_prod ");
          query.append("          AND deta.ofer_oid_ofer = ofer.oid_ofer ");
          query.append("          AND ofer.mfca_oid_cabe = matri.oid_cabe ");
          query.append("          AND matri.perd_oid_peri = peri.oid_peri ");
          query.append("          AND deta.prod_oid_prod = pr.oid_prod ");
          query.append("          AND peri.oid_peri = " + oidPeriodo );
          query.append("          AND ( prodexclu.marca IS NULL OR prodexclu.marca = pr.mapr_oid_marc_prod ) ");
          query.append("          AND ( prodexclu.unidadnegocio IS NULL OR prodexclu.unidadnegocio = pr.uneg_oid_unid_nego ) ");
          query.append("          AND ( prodexclu.negocio IS NULL OR prodexclu.negocio = pr.nego_oid_nego ) ");
          query.append("          AND ( prodexclu.supergenerico IS NULL OR prodexclu.supergenerico = pr.sgen_oid_supe_gene ) ");
          query.append("          AND ( prodexclu.generico IS NULL OR prodexclu.generico = pr.gene_oid_gene ) ");
          query.append("          AND ( prodexclu.canal IS NULL OR prodexclu.canal = peri.cana_oid_cana) ");
          query.append("          AND ( prodexclu.tipooferta IS NULL OR prodexclu.tipooferta = deta.tofe_oid_tipo_ofer ) ");
          query.append("          AND ( prodexclu.ciclovida IS NULL OR prodexclu.ciclovida = deta.civi_oid_ciclo_vida ) ");
          query.append("        ) = 0 ");
      }
      UtilidadesLog.info("MONCalcularComisiones.condicionProductosIncluidosExcluidos() Salida");
      return query.toString();
  }


  /**
   * Verifica si la comision posee productos incluidos o excluidos.
   */
  private boolean verificarProductosIncluidosExcluidos(ComisionesVentasLocal comisionesVentas) throws MareException {
      UtilidadesLog.info("MONCalcularComisiones.verificarProductosIncluidosExcluidos() Entrada");
      BelcorpService belcorpService;
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      boolean hayIncluidosExcluidos;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      query.append(" SELECT cprodu.oid_comi_prod ");
      query.append(" FROM com_comis_produ cprodu ");
      query.append(" WHERE cprodu.comi_oid_comi = " + comisionesVentas.getComision() ) ;
      try {
          rs = belcorpService.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      hayIncluidosExcluidos = ! rs.esVacio();
      UtilidadesLog.info("MONCalcularComisiones.verificarProductosIncluidosExcluidos() Salida");
      return hayIncluidosExcluidos;
  }


 /**
	 * Sistema:     Belcorp
	 * Modulo:      COM
	 * Fecha:       06/04/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public void calcularComisionesXCobranzas(DTODatosCalculosComision dto) 
    throws MareException {
    try {
      UtilidadesLog.info("MONCalcularComisionesBean.calcularComisionesXCobranzas(DTODatosCalculosComision dto): Entrada");
    
      UtilidadesLog.debug("dto: " + dto);
      UtilidadesLog.debug("gerentes: " + dto.getGerentes());
      
      // Definición de variables
      Long oidGerente= null;
      Long oidGerenteAnt=null;      
      DTOGerenteZona gerenteZona=null;
      Boolean consultoras = Boolean.FALSE;
      Long oidPeriodo;
      BigDecimal cantidadFacturada= null;
      BigDecimal totalTramo = new BigDecimal(0);      
      Integer diasTramoAnterior = new Integer(0);
      Integer diasTramoActual;
      ArrayList cobros = new ArrayList();
      Vector cobroTramo = new Vector();
      BigDecimal porcentajeRecuperado;
      int contTramos = 0;
      BigDecimal montoAPagar = new BigDecimal(0);;
      BigDecimal montoAPagarTramo;
      BigDecimal montoPagar;
      BigDecimal totalTramoT;
      BigDecimal montoRecuperado = new BigDecimal(0);
      ComisionesCobranzasAcumuladasClienteLocalHome comiAcuCliHome = this.getComisionesCobranzasAcumuladasClienteLocalHome();
      ComisionesCobranzasAcumuladasClienteLocal comiAcuCli;
      ComisionesCalculadasLocalHome comCalHome = this.getComisionesCalculadasLocalHome();
      ComisionesCalculadasLocal comCal;
      CuotasTramoComisionesCalculadasLocalHome comCuotaTCalHome = this.getCuotasTramoComisionesCalculadasLocalHome();
      CuotasTramoComisionesCalculadasLocal comCuotaTCal;
      String codEmpleado;
      Long formaPago;      
      DTOCalculoReporte dtoCalculoReporte = null;
      DTOCuotaCalculoReporte dtoCuotaCalculoReporte = null;
      ArrayList cuotas = null;
      
      // Calcula el volumen de facturas
      MONCalcularVolumenFacturasHome volFacHome = COMEjbLocators.getMONCalcularVolumenFacturasHome();
      volFacHome.create().calcularVolumenFacturas(dto);
      
      // Recupera los gerentes de cobranza      
      DAOCalcularComisiones daoCalcularComisiones= new DAOCalcularComisiones();
      DTOSalida gerente = daoCalcularComisiones.recuperarGerentesCobranza(dto);
      
      RecordSet rsGerentes = gerente.getResultado();
      UtilidadesLog.debug("gerentesCobranzas: " + rsGerentes);
      //todos los calculos se realizan en base a el agrupado de los gerentes de zona
      //asi que los agrupo y los proceso.
      
    for(int i=0;i<rsGerentes.getRowCount();i++) {        
          if(i==0){
              oidGerente= new Long(((BigDecimal)rsGerentes.getValueAt(i,"CLIE_OID_CLIE")).toString());
          }
          
          UtilidadesLog.debug("oidGerente: " + oidGerente);
          
          if(!oidGerente.equals(oidGerenteAnt)){        
            gerenteZona= daoCalcularComisiones.validarGerente(oidGerente,dto);
          }
          
          if(gerenteZona== null) {
              UtilidadesLog.debug("Gerente no valido, gerenteZona==null");
              oidGerenteAnt = oidGerente;
              if(((i+1) < rsGerentes.getRowCount())){
                  // Hay un proximo registro
                  oidGerente= new Long(((BigDecimal)rsGerentes.getValueAt(i+1,"CLIE_OID_CLIE")).toString());
              }
              continue;
          }else {
              // Obtiene las consultaras del gerente
              if(!oidGerente.equals(oidGerenteAnt)){
                  // Consultoras pertenecientes al gerente
                  oidPeriodo= new Long(((BigDecimal)rsGerentes.getValueAt(i,"PERD_OID_PERI")).toString());
                  
                  // vbongiov -- 27/10/2006
                  consultoras = daoCalcularComisiones.hayConsultoras(oidPeriodo, gerenteZona); 
                  
                  UtilidadesLog.debug("hay Consultoras: " + consultoras);
                  
                  // Cantidad facturada
                  cantidadFacturada = (BigDecimal)rsGerentes.getValueAt(i,"VAL_CANT_FACT");
                  
                  // Tramo anterior
                  diasTramoAnterior = new Integer(0);
              }
              
              diasTramoActual= new Integer(((BigDecimal)rsGerentes.getValueAt(i,"NUM_DIAS")).toString());
              totalTramo = new BigDecimal(0);              
              cobroTramo = new Vector();
              
              if (consultoras.booleanValue()){
                  // vbongiov -- 27/10/2006
                  dtoCalculoReporte = daoCalcularComisiones.calcularImportePago(gerenteZona, diasTramoActual, diasTramoAnterior, dto);
                  
                  totalTramo = dtoCalculoReporte.getImportePagado();
                  
                  // Verifica si hay cuotas para el tramo
                  if(dtoCalculoReporte.getCuota()!= null) {
                      // Inserto las cuotas tramos
                      cuotas = dtoCalculoReporte.getCuota();
                      
                      int cant = cuotas.size();
                      
                      for(int a=0; a < cant; a++) {
                      
                          dtoCuotaCalculoReporte = (DTOCuotaCalculoReporte)cuotas.get(a);
                          
                          UtilidadesLog.debug("CuotasTramoComisionesCalculadas create: ");
                          UtilidadesLog.debug("OidComiCobrAcumClien: " + (BigDecimal)rsGerentes.getValueAt(i,"OID_COMI_COBR_ACUM"));
                          
                          UtilidadesLog.debug("oidCuota: " + dtoCuotaCalculoReporte.getOidCuota());
                          UtilidadesLog.debug("EjerCuota: " + dtoCuotaCalculoReporte.getEjerCuota());
                          UtilidadesLog.debug("codTerr: " + dtoCuotaCalculoReporte.getCodTerri());
                          UtilidadesLog.debug("oidCliente: " + dtoCuotaCalculoReporte.getOidCliente());
                          UtilidadesLog.debug("ImportePagado: " + dtoCuotaCalculoReporte.getImportePagado());
                          UtilidadesLog.debug("ImporteCuota: " + dtoCuotaCalculoReporte.getImporteCuota());
                          UtilidadesLog.debug("FechaDocu: " + dtoCuotaCalculoReporte.getFechaDocu());
                          UtilidadesLog.debug("FechaValor: " + dtoCuotaCalculoReporte.getFechaValor());
                          
                          comCuotaTCal = comCuotaTCalHome.create(dtoCuotaCalculoReporte.getOidCuota(), 
                                                                 dtoCuotaCalculoReporte.getCodTerri());

                          UtilidadesLog.debug(" despues create comCuota ");
                          comCuotaTCal.setOidComiCobrAcumClien(new Long(((BigDecimal)rsGerentes.getValueAt(i,"OID_COMI_COBR_ACUM")).toString()));                                                             
                                                                 
                          comCuotaTCal.setEjercicioCuota(dtoCuotaCalculoReporte.getEjerCuota());                                                                         
                          comCuotaTCal.setOidCliente(dtoCuotaCalculoReporte.getOidCliente());                                                             
                          comCuotaTCal.setImportePago(dtoCuotaCalculoReporte.getImportePagado());
                          comCuotaTCal.setImporte(dtoCuotaCalculoReporte.getImporteCuota());
                          comCuotaTCal.setFechaDocumento(dtoCuotaCalculoReporte.getFechaDocu());
                          comCuotaTCal.setFechaValor(dtoCuotaCalculoReporte.getFechaValor());
                          
                          comCuotaTCalHome.merge(comCuotaTCal);
                      }
                  }
                  
                  
              // Limpia los valores del gerente anterior
              if(!oidGerente.equals(oidGerenteAnt)){
                  // Limpia los array para un nuevo gerente
                  cobros = new ArrayList();  
                  contTramos = 0;
                  montoAPagar = new BigDecimal(0);
                  montoRecuperado = new BigDecimal(0);
              }
              
              UtilidadesLog.debug("VAL_PORC_COMI: " + (BigDecimal)rsGerentes.getValueAt(i,"VAL_PORC_COMI"));
              
              // Información del tramo
              cobroTramo.add(new Integer(((BigDecimal)rsGerentes.getValueAt(i,"VAL_NIVE_TRAM")).toString()));
              cobroTramo.add(totalTramo);
              cobroTramo.add((BigDecimal)rsGerentes.getValueAt(i,"VAL_PORC_COMI"));
              cobroTramo.add((BigDecimal)rsGerentes.getValueAt(i,"VAL_PORC_OBJE"));
              contTramos++;
              
              UtilidadesLog.debug("cobroTramo: " + cobroTramo);
              UtilidadesLog.debug("contTramos: " + contTramos);

              montoRecuperado = montoRecuperado.add(totalTramo);
                                     
              // Calcula la comision de ese tramo
              
              if(cantidadFacturada.compareTo(new BigDecimal(0))!=0){
                  porcentajeRecuperado = montoRecuperado.multiply(new BigDecimal(100)).divide(cantidadFacturada, 2, BigDecimal.ROUND_HALF_UP);
              } else{
                  porcentajeRecuperado = new BigDecimal(0);
              }
              UtilidadesLog.debug("Calculamos el monto acumulado");
              UtilidadesLog.debug("porcentajeRecuperado: " + porcentajeRecuperado);
              UtilidadesLog.debug("VAL_PORC_COMI: " + (BigDecimal)cobroTramo.get(3));
              // Compara porcentajeRecuperado con porcentaje objetivo
              int compare = porcentajeRecuperado.compareTo((BigDecimal)cobroTramo.get(3));
              UtilidadesLog.debug("compare: " + compare);
              
              if(compare==0 || compare==1){
                  // Supero el porcentaje objetivo
                  if(contTramos == 1 || !noPagoComisionTramosAnt(cobros)){
                     UtilidadesLog.debug("Es el primer tramo o no se se pago comision en tramos anteriores");
                     // Es el primer tramo o no se se pago comision en tramos anteriores
                     // Valor a pagar montoPagar = (totaltramo * cobroTramo.(porcComision)) / 100
                      montoPagar = totalTramo.multiply((BigDecimal)cobroTramo.get(2)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                      montoAPagarTramo = montoPagar;
                      UtilidadesLog.debug("montoAPagarTramo: " + montoAPagarTramo);
                  } else {
                      UtilidadesLog.debug("No se se pago comision en alguno de los tramos anteriores");  
                     // No se se pago comision en alguno de los tramos anteriores
                     // Valor a pagar montoPagar = (Sumatoria de totalTramo de los tramos que no pagaron comision + totalTramo actual)* cobro.(porcComision) / 100
                      totalTramoT = totalTramo.add(totalTramoNoPagaronCom(cobros));  
                      montoPagar = totalTramoT.multiply((BigDecimal)cobroTramo.get(2)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
                      montoAPagarTramo = montoPagar;
                      UtilidadesLog.debug("montoAPagarTramo: " + montoAPagarTramo);
                  }             
                
              } else {
                  // No supero el porcentaje objetivo
                  montoAPagarTramo = new BigDecimal(0);
              }
              cobroTramo.add(montoAPagarTramo);
              UtilidadesLog.debug("cobroTramo: " + cobroTramo);
              
              // Acumulados
              montoAPagar = montoAPagar.add(montoAPagarTramo);
              
              UtilidadesLog.debug("montoAPagar: " + montoAPagar);
              UtilidadesLog.debug("montoRecuperado: " + montoRecuperado);
              
              // Tramos del gerente
              cobros.add(cobroTramo);   
              UtilidadesLog.debug("cobros: " + cobros);
              
              // Se actualiza ComisionesCobranzasAcumuladasCliente con los valores calculados                      
              comiAcuCli = comiAcuCliHome.findByPrimaryKey(new Long(((BigDecimal)rsGerentes.getValueAt(i,"OID_COMI_COBR_ACUM")).toString()));
              comiAcuCli.setMontoPagar(montoAPagarTramo);
              //comiAcuCli.setMontoRecuperado(totalTramo);
              comiAcuCli.setMontoRecuperado(montoRecuperado);
              comiAcuCli.setFechaCalculo(new Date(System.currentTimeMillis()));
              comiAcuCli.setCalculado(Boolean.TRUE);
              // vbongiov - inc 22023
              comiAcuCli.setPorcentajeRecuperado(new Double(porcentajeRecuperado.toString()));
              
              comiAcuCliHome.merge(comiAcuCli);
              
              diasTramoAnterior = new Integer(diasTramoActual.intValue()+1);     
              
              }
              oidGerenteAnt = oidGerente;
              if(((i+1) < rsGerentes.getRowCount())){
                  // Hay un proximo registro
                  oidGerente= new Long(((BigDecimal)rsGerentes.getValueAt(i+1,"CLIE_OID_CLIE")).toString());
              } 
              
              // Se graba porque se cambia el cliente o es el ultimo registro
              
              /*UtilidadesLog.debug("GA - (rsGerentes.getRowCount()==(i+1)): "+(rsGerentes.getRowCount()==(i+1)));
              UtilidadesLog.debug("GA - !oidGerente.equals(oidGerenteAnt): "+!oidGerente.equals(oidGerenteAnt));
              UtilidadesLog.debug("GA - rsGerentes.getRowCount(): "+rsGerentes.getRowCount());
              UtilidadesLog.debug("GA - (i+1): "+(i+1));
              UtilidadesLog.debug("GA - oidGerente: "+oidGerente);
              UtilidadesLog.debug("GA - oidGerenteAnt: "+oidGerenteAnt);*/
              if((rsGerentes.getRowCount()==(i+1)) || !oidGerente.equals(oidGerenteAnt)){
                  //UtilidadesLog.debug("GA - Entro al if");
                  codEmpleado= (String)rsGerentes.getValueAt(i,"COD_EMPL");
                  UtilidadesLog.debug("codEmpleado: " + codEmpleado);
              
                  // Forma de pago
                  if(codEmpleado!=null){
                      formaPago = ConstantesCOM.FORMA_PAGO_CON_PLANILLA;
                  }else {
                      formaPago = ConstantesCOM.FORMA_PAGO_SIN_PLANILLA;
                  }                  
                  
                  UtilidadesLog.debug("ComisionesCalculadas create: ");
                  UtilidadesLog.debug("fecha actual");
                  UtilidadesLog.debug("OidPeriodo: " + dto.getOidPeriodo() );
                  UtilidadesLog.debug("oidGerente: " + oidGerenteAnt );
                  UtilidadesLog.debug("OidEstado: " + ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE);
                  UtilidadesLog.debug("formaPago: " + formaPago);
                  UtilidadesLog.debug("OidTipoPlantilla: " + dto.getOidTipoPlantilla());
                  UtilidadesLog.debug("OidComision: " + dto.getOidComision());
                  UtilidadesLog.debug("Importe: " + montoAPagar);
                  
                  // Inserta la Comision Calculada del gerente
                  comCal= comCalHome.create(new java.sql.Date(System.currentTimeMillis()), 
                                    dto.getOidPeriodo(),
                                    oidGerenteAnt,
                                    ConstantesCOM.ESTADO_COMISION_CALCULADA_Y_PENDIENTE,
                                    formaPago,
                                    dto.getOidTipoPlantilla(),
                                    dto.getOidComision());
                                    
                  comCal.setImporte(new Double(montoAPagar.toString()));
                  if((!montoRecuperado.equals(new BigDecimal(0))) && (!montoRecuperado.equals(new BigDecimal("0.0"))) && (!montoRecuperado.equals(new BigDecimal("0.00")))){
                      comCal.setPorcentaje(new Double(montoAPagar.multiply(new BigDecimal(100)).divide(montoRecuperado,2, BigDecimal.ROUND_HALF_UP).toString()));                                                                    
                      UtilidadesLog.debug("Porcentaje: " + montoAPagar.multiply(new BigDecimal(100)).divide(montoRecuperado,2, BigDecimal.ROUND_HALF_UP));
                  }else {
                      comCal.setPorcentaje(new Double(0));
                      UtilidadesLog.debug("Porcentaje: 0");
                  }
                  
                  comCalHome.merge(comCal);                  
                  
              }
          }
      }
      
      UtilidadesLog.info("MONCalcularComisionesBean.calcularComisionesXCobranzas(DTODatosCalculosComision dto): Salida");
        
    } catch(NoResultException nre) {
        ctx.setRollbackOnly();
        throw new MareException(nre, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch(PersistenceException pex) {
        ctx.setRollbackOnly();
        throw new MareException(pex, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } catch(Exception e) {
        ctx.setRollbackOnly();
        e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }


  }
  
  
  private boolean noPagoComisionTramosAnt(ArrayList cobros) {
      UtilidadesLog.info("MONCalcularComisionesBean.noPagoComisionTramosAnt(ArrayList cobros): Entrada");
      Vector cobroTramo;
      BigDecimal montoAPagarTramo;
      
      for(int i=0; i<cobros.size(); i++){
          cobroTramo = (Vector)cobros.get(i);
          montoAPagarTramo = (BigDecimal)cobroTramo.get(4);
          
          if(montoAPagarTramo.compareTo(new BigDecimal(0))==0) {
            UtilidadesLog.info("MONCalcularComisionesBean.noPagoComisionTramosAnt(ArrayList cobros): Salida");
            return true;
          }
      }
      
      UtilidadesLog.info("MONCalcularComisionesBean.noPagoComisionTramosAnt(ArrayList cobros): Salida");
      return false;
  }
  
  
  private BigDecimal totalTramoNoPagaronCom(ArrayList cobros) {  
      UtilidadesLog.info("MONCalcularComisionesBean.totalTramoNoPagaronCom(ArrayList cobros): Entrada");
      Vector cobroTramo;
      BigDecimal montoAPagarTramo;
      BigDecimal totalTramosNoCom= new BigDecimal(0);      
      
      for(int i=0; i<cobros.size(); i++){
          cobroTramo = (Vector)cobros.get(i);
          montoAPagarTramo = (BigDecimal)cobroTramo.get(4);
          
          if(montoAPagarTramo.compareTo(new BigDecimal(0))==0) {
              // Sumo los totalTramo que no pagaron comision
              totalTramosNoCom = totalTramosNoCom.add((BigDecimal)cobroTramo.get(1));            
          }
      }
      
      UtilidadesLog.debug("totalTramosNoCom: " + totalTramosNoCom);      
      UtilidadesLog.info("MONCalcularComisionesBean.totalTramoNoPagaronCom(ArrayList cobros): Salida");
      return totalTramosNoCom;
  }

     
    /**    
    *@Author: pperez 
    *@Fecha: 
    *@throws: 
    *@return: 
    *@param: 
    *@Observaciones:  
    */ 
 
    private Boolean objectToBoolean(Object rango) {
        UtilidadesLog.info("MONCalcularComisionesBean.objectToBoolean(Object rango): Entrada");
        if (rango != null)  {
            long valor = ((BigDecimal)rango).longValue();
            if (valor == 1){
                UtilidadesLog.info("MONCalcularComisionesBean.objectToBoolean(Object rango): Salida");
                return new Boolean(true);
            } else {
                UtilidadesLog.info("MONCalcularComisionesBean.objectToBoolean(Object rango): Salida");
                return new Boolean(false);        
            }
        }
        else {
            UtilidadesLog.info("MONCalcularComisionesBean.objectToBoolean(Object rango): Salida");
            return null;
        }       
    }

    private Long objectToLong(Object rango) {
        //UtilidadesLog.info("MONCalcularComisionesBean.objectToLong(Object rango): Entrada");
        if (rango != null)  {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToLong(Object rango): Salida");
            return new Long(((BigDecimal)rango).longValue());
        }
        else {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToLong(Object rango): Salida");
            return null;
        }            
    }


    private Integer objectToInteger(Object rango) {        
        //UtilidadesLog.info("MONCalcularComisionesBean.objectToInteger(Object rango): Entrada");
        if (rango != null)  {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToInteger(Object rango): Salida");
            return new Integer(((BigDecimal)rango).intValue());
        }else {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToInteger(Object rango): Salida");
            return null;
        }            
    }


    private Float objectToFloat(Object rango) {
        //UtilidadesLog.info("MONCalcularComisionesBean.objectToFloat(Object rango): Entrada");
        if (rango != null)  {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToFloat(Object rango): Salida");
            return new Float(((BigDecimal)rango).floatValue());
        }
        else {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToFloat(Object rango): Salida");
            return null;
        }            
    }

    private Double objectToDouble(Object rango) {
        //UtilidadesLog.info("MONCalcularComisionesBean.objectToDouble(Object rango): Entrada");
        if (rango != null)  {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToDouble(Object rango): Salida");
            return new Double(((BigDecimal)rango).doubleValue());
        }
        else {
            //UtilidadesLog.info("MONCalcularComisionesBean.objectToDouble(Object rango): Salida");
            return null;
        }            
    }


    private boolean validarGerenteTipificacion(Collection tipificaciones, Collection tipoClienDetalles)
          throws MareException {
      UtilidadesLog.info("MONCalcularComisionesBean.validarGerenteTipificacion(Collection tipificaciones, Collection tipoClienDetalles): Entrada");
      
      int cantDetalles = tipoClienDetalles.size();
      if (cantDetalles == 0) {
          throw new MareException("La CabeceraClienteComisiones no posee detalles");
      }
      
      Iterator itDet;
      Iterator itTip;
      itDet = tipoClienDetalles.iterator();   

      TipoClienteComisionesDetalleLocal detalle;
      DTOTipificacionCliente dtoTipClien;
      
      boolean valido = false;
      
      while(itDet.hasNext()) {
          detalle = (TipoClienteComisionesDetalleLocal)itDet.next();
          UtilidadesLog.debug("Tipificacion del detalle: entity_" + detalle);  
          itTip = tipificaciones.iterator();
            
          while(itTip.hasNext()) {
              dtoTipClien = (DTOTipificacionCliente)itTip.next();
              UtilidadesLog.debug("Tipificacion del cliente: dto_" + dtoTipClien);
                
              valido = false;
              
              if (detalle.getTiclOidTipoClie() != null) {
                  if (dtoTipClien.getOidTipoCliente() != null && 
                      dtoTipClien.getOidTipoCliente().equals(detalle.getTiclOidTipoClie())) {
                      UtilidadesLog.debug("Tipo del cliente valido");
                      valido = true;
                  }
              }
              
              if (detalle.getSbtiOidSubtClie() != null) {
                  if (dtoTipClien.getOidSubtipoCliente() != null && 
                      dtoTipClien.getOidSubtipoCliente().equals(detalle.getSbtiOidSubtClie())) {
                      UtilidadesLog.debug("Subtipo del cliente valido");
                      valido = true;
                  } else {
                      valido = false;
                  }
              }
              
              if (detalle.getTcclOidTipoClas() != null) {
                  if (dtoTipClien.getOidTipoClasificacionCliente() != null && 
                      dtoTipClien.getOidTipoClasificacionCliente().equals(detalle.getTcclOidTipoClas())) {
                      UtilidadesLog.debug("Tipo Clasificacion del cliente valido");
                      valido = true;
                  } else {
                      valido = false;
                  }
              }
              
              if (detalle.getClasOidClas() != null) {
                  if (dtoTipClien.getOidClasificacionCliente() != null && 
                      dtoTipClien.getOidClasificacionCliente().equals(detalle.getClasOidClas())) {
                      UtilidadesLog.debug("Clasificacion del cliente valida");
                      valido = true;
                  } else {
                      valido = false;
                  }
              }
              
              if (valido) {
                  return true;
              }
          }
      }
      UtilidadesLog.info("MONCalcularComisionesBean.validarGerenteTipificacion(Collection tipificaciones, Collection tipoClienDetalles): Salida");
      return false;
  }
 
    private String arrayToString(Long[] array) {
        UtilidadesLog.info("DAOCalcularComisiones.arrayToString(Long[] array): Entrada");

        StringBuffer strSalida = new StringBuffer();

        for (int i = 0; i < (array.length - 1); i++) {
            strSalida.append(array[i] + ",");
        }

        strSalida.append(array[array.length - 1]);
        UtilidadesLog.info("DAOCalcularComisiones.arrayToString(Long[] array): Salida");

        return strSalida.toString();
    }
    
    
    private ComisionesClientesLocalHome getComisionesClientesLocalHome() throws MareException {      
       return new ComisionesClientesLocalHome();
    }

    private TipoClienteComisionesDetalleLocalHome getTipoClienteComisionesDetalleLocalHome() throws MareException {      
       return new TipoClienteComisionesDetalleLocalHome();
    }
    private ComisionesVentasLocalHome getComisionesVentasLocalHome() throws MareException {      
       return new ComisionesVentasLocalHome();
    }
    private ComisionesLocalHome getComisionesLocalHome() throws MareException {      
       return new ComisionesLocalHome();
    }
    private ComisionesMetasLocalHome getComisionesMetasLocalHome() throws MareException {      
       return new ComisionesMetasLocalHome();
    }
    private ComisionesVentaHistoricaLocalHome getComisionesVentaHistoricaLocalHome() throws MareException {      
       return new ComisionesVentaHistoricaLocalHome();
    }
    private ComisionesCalculadasLocalHome getComisionesCalculadasLocalHome() throws MareException {      
       return new ComisionesCalculadasLocalHome();
    }
    private ComisionesCobranzasAcumuladasClienteLocalHome getComisionesCobranzasAcumuladasClienteLocalHome() throws MareException {      
       return new ComisionesCobranzasAcumuladasClienteLocalHome();
    }
    private CuotasTramoComisionesCalculadasLocalHome getCuotasTramoComisionesCalculadasLocalHome() throws MareException {      
       return new CuotasTramoComisionesCalculadasLocalHome();
    }

 
  
}