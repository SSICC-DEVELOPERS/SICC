package es.indra.sicc.logicanegocio.inc;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado;
import es.indra.sicc.dtos.inc.DTOCalculoMeta;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta;
import es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOMetTipVtaPag;
import es.indra.sicc.dtos.inc.DTOMetasTipoVenta;
import es.indra.sicc.dtos.inc.DTOMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOPeriodoDesdeHasta;
import es.indra.sicc.dtos.inc.DTOProdu;
import es.indra.sicc.dtos.inc.DTOUACliente;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.MetasTipoVentaLocal;
import es.indra.sicc.entidades.inc.MetasTipoVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCalcularMetasBean
        implements SessionBean {
    private SessionContext ctx;

    //jrivas 05/01/2007 Cambio Calculo Metas Performance
    private Integer tamanioSegmento;  
    private Integer numeroMaximoSegmentos;      


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
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOOID
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 06/06/2005
     * Se ejecuta este proceso en background
     */
    public DTOOID calcularMetasTipoVentaBatch(DTOConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaBatch(DTOConcurso DTOE): Entrada");
        //Antes se comprueba si existe el oidConcurso, si no existe lo tenemos que crear para 
        //las inserciones de las metas 
        UtilidadesLog.debug("dentro de: calcularMetasTipoVentaBatch(....");

        DTOOID dtoOid = new DTOOID();

        ConcursoParametrosGeneralesLocalHome cpgLH = this.getConcursoParametrosGeneralesLocalHome();
        ConcursoParametrosGeneralesLocal cpgL = null;

        try {
            if(DTOE.getParamGenerales().getOid()!= null){
                cpgL = cpgLH.findByPrimaryKey(DTOE.getParamGenerales().getOid());
                dtoOid.setOid(cpgL.getOid());
            } else {
                dtoOid.setOid(this.obtengoOidSecuencia(new String("INC_COPA_SEQ")));
                DTOE.getParamGenerales().setOid(dtoOid.getOid());
            }
            
        } catch (NoResultException fe) {
            dtoOid.setOid(this.obtengoOidSecuencia(new String("INC_COPA_SEQ")));
            DTOE.getParamGenerales().setOid(dtoOid.getOid());
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        //Se crea un DTOBatch
        MareBusinessID id = new MareBusinessID(new String("INCCalcularMetasTipoVenta"));
        DTOBatch dtoB = new DTOBatch(new String("Calcular metas tipo venta"), id, DTOE, ctx.getCallerPrincipal().getName());
        UtilidadesLog.debug("(SCS)a punto de: batch.executeMLN(....con DTOBatch: " + dtoB);

        try {
            //Se llama al servicio INCPROCESOSBATCH del susbsistema Batch 
            BatchUtil batch = new BatchUtil();
            UtilidadesLog.debug("antes de batch.executeMLN(...");
            batch.executeMLN(dtoB, "INCPROCESOSBATCH");
            UtilidadesLog.debug("luego de batch.executeMLN(...");
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaBatch(DTOConcurso DTOE):Salida");
        return dtoOid;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOOID
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 06/06/2005
     * Se ejecuta este proceso en background
     */
    public DTOOID calcularMetasVentaProyectadaBatch(DTOConcurso dto)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasVentaProyectadaBatch(DTOConcurso dto):Salida");
        //Antes se comprueba si existe el oidConcurso, si no existe lo tenemos que crear para las 
        //inserciones de las metas 
        UtilidadesLog.debug("dentro de: calcularMetasVentaProyectadaBatch(....");

        DTOOID dtoOid = new DTOOID();

        ConcursoParametrosGeneralesLocalHome cpgLH = this.getConcursoParametrosGeneralesLocalHome();
        ConcursoParametrosGeneralesLocal cpgL = null;

        try {
            cpgL = cpgLH.findByPrimaryKey(dto.getParamGenerales().getOid());
            dtoOid.setOid(cpgL.getOid());
        } catch (NoResultException fe) {
            dtoOid.setOid(this.obtengoOidSecuencia(new String("INC_COPA_SEQ")));
            dto.getParamGenerales().setOid(dtoOid.getOid());
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        //Se crea un DTOBatch
        MareBusinessID id = new MareBusinessID(new String("INCCalcularMetasVentaProyectada"));
        DTOBatch dtoB = new DTOBatch(new String("Calcular metas venta proyectada"), id, dto, ctx.getCallerPrincipal().getName());
        UtilidadesLog.debug("(SCS)a punto de: batch.executeMLN(....con DTOBatch: " + dtoB);

        try {
            //Se llama al servicio INCPROCESOSBATCH del susbsistema Batch 
            BatchUtil batch = new BatchUtil();
            UtilidadesLog.debug("antes de batch.executeMLN(...");
            batch.executeMLN(dtoB, "INCPROCESOSBATCH");
            UtilidadesLog.debug("luego de batch.executeMLN(...");
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasVentaProyectadaBatch(DTOConcurso dto):Salida");
        return dtoOid;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalidaBatch
     * @param DTOBatch
     * @author Sergio C. Saavedra -- 17/05/2005
     * Se calculan las metas de venta proyectada, es decir las metas según los datos de la
     * tabla INT_FUENT_VENTA_PREVI_SAP
     * Se usará un fichero de log, para dejar constancia de aquellos registros que no
     * tienen gerente
     */
    public DTOSalidaBatch calcularMetasVentaProyectada(DTOBatch DTOE)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasVentaProyectada(DTOBatch DTOE):Entrada");
        UtilidadesLog.debug("dentro de calcularMetasVentaProyectada, recibo : " + DTOE);

        try {
            DTOConcurso dtoConcurso = (DTOConcurso) DTOE.getDTOOnline();
    
            //Se utiliza una variable para controlar si algún registro no tiene gerente asociado
            boolean ficheroLog = false;
            
            // vbongiov -- 28/08/2006 -- DBLG500000222
            DTOSalida rs = this.obtenerPrimerUltimoPeriodoAnio(dtoConcurso);
            
            Long oidPrimerPeriodoAnio = Long.valueOf(((BigDecimal)rs.getResultado().getValueAt(0,"OID_PERI")).toString());
            UtilidadesLog.debug("oidPrimerPeriodoAnio : " + oidPrimerPeriodoAnio);
            
            DTOListaMetasVentaProyectada listaMetas = new DTOListaMetasVentaProyectada();
    
            DTOListaMetasVentaProyectada dtoFinalListaMetas = new DTOListaMetasVentaProyectada();
            dtoFinalListaMetas.setListaMetas(new ArrayList());
    
            DAOCalcularMetas daoCM = new DAOCalcularMetas();
            // vbongiov -- 14/09/2006 -- DBLG500000222
            listaMetas = daoCM.obtenerMetasParaVentasProyectada(dtoConcurso, oidPrimerPeriodoAnio);
            DTOListaMetasVentaProyectada dtoListaActivasIni = new DTOListaMetasVentaProyectada();
            dtoListaActivasIni.setListaMetas(new ArrayList());

    
            BelcorpService bs = BelcorpService.getInstance();
    
            ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
            ClienteDatosBasicosLocal clienteDatosBasicosL = null;
    
            
            clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
           
    
            if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
                DTOMetasVentaProyectada elemVtaProy = new DTOMetasVentaProyectada();
                Long numActivasInicioAnyo;
                Long numActivasFinalAnyo;
                boolean estaTipi;
    
                for (int j = 0; j < listaMetas.getListaMetas().size(); j++) {
                    numActivasInicioAnyo = new Long(0);
                    numActivasFinalAnyo = new Long(0);
                    estaTipi = false;
                    elemVtaProy = (DTOMetasVentaProyectada) listaMetas.getListaMetas().get(j);
    
                    //Las metas son por gerente y periodo, luego si no existe el gerente se pasará al registro 
                    //siguiente y se dejará constancia en un fichero de log 
                    if (elemVtaProy.getOidCliente() == null) {
                        LogAPP.error("INC-0017 No existe gerente para la subgerencia/región/zona: " + elemVtaProy.getOid() + ", y para el período: " +
                                        elemVtaProy.getOidPeriodo());
                        ficheroLog = true;
                    } else {
                        LogAPP.info("existe gerente para la subgerencia/región/zona: " + elemVtaProy.getOid() + ", y para el período: " +
                                       elemVtaProy.getOidPeriodo() + " y el cliente :" + elemVtaProy.getOidCliente());
    
                        UtilidadesLog.debug("elemVtaProy.getOidPeriodo(): " + elemVtaProy.getOidPeriodo());
                        
                        if(elemVtaProy.getPrimerPeriodo().booleanValue()){
                            dtoListaActivasIni.agregarActivaInicial(elemVtaProy);
                        }
                        
                        if(!elemVtaProy.getDentroRangoEvaluacion().booleanValue()){
                            UtilidadesLog.debug("no esta dentro del rango");
                            continue;
                        }
                        
                        //hay gerente....
                      
                        //Se obtiene la tipificación del cliente: tipo-subtipo-tipo 
                        //clasificacion-clasificación, si el concurso no está basado en una plantilla 
                        //que incluya a todos los participantes
                        if (dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue() == false) {
                            // vbongiov -- 18/09/2006 -- inc DBLG500000304
                            estaTipi = this.estaTipificacionCliente(elemVtaProy.getOidCliente(),
                                                                    dtoConcurso.getCalificacionParticipantes().getLstCalificacionParticipantes())
                                           .booleanValue();
                        }
    
                        if ((dtoConcurso.getPlantilla().getIndPartParticipantesCompleto().booleanValue() == true) || (estaTipi)) {
                            //Si hay participantes completo o el participante está dentro de los 
                            //participantes del concurso, guardamos el registro con las metas, están a
                            //grupadas por oid (subgerencia, región o zona y período)
                            //Es decir, guardamos todo lo que se calculó en el método 
                            //obtenerMetasParaVentasProyectada(dtoConcurso) del DAOCalcularMetas, de 
                            //nuevo, y ahora hacemos el resto de cálculos, pero sólo para aquellos 
                            //registros que cumplan que la tipificación del cliente está en la lista de 
                            //participantes del concurso, ya que eso no se hizo en la select del método 
                            //obtenerMetasParaVentasProyectada(dtoConcurso)                
                            //asignamos todos los campos de una estructura a la otra, sólo aquellos que 
                            //se han rellenado en la estructura dtoListaMetas, los demás se calculan a 
                            //continuación
                            //calculamos campos extra, de la lista
                            try {
                                clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(elemVtaProy.getOidCliente());
                            } catch (NoResultException nre) {
                                ctx.setRollbackOnly();
                                 UtilidadesLog.error("ERROR ", nre);
                                throw new MareException(nre,        
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

                            }
    
                            elemVtaProy.setCodigoCliente(clienteDatosBasicosL.getCod_clie());
                            elemVtaProy.setOidPais(dtoConcurso.getOidPais());
                            //MODIFICADO POR CVALENZU - 24/05/2006 - DBLG500000717
                            /*elemVtaProy.setCapitalizacion(new Long((elemVtaProy.getNumActivasIniciales().longValue() -
                                                                   elemVtaProy.getNumActivasFinales().longValue())));*/
                            elemVtaProy.setCapitalizacion(new Long((elemVtaProy.getNumActivasFinales().longValue() -
                                                                   elemVtaProy.getNumActivasIniciales().longValue())));
                            //FIN - MODIFICADO POR CVALENZU - 24/05/2006 - DBLG500000717
    
                            UtilidadesLog.debug("Calculo metas proyectada: getOidCliente" + elemVtaProy.getOidCliente());
                            UtilidadesLog.debug("Calculo metas proyectada: getOidPeriodo" + elemVtaProy.getOidPeriodo());
                            UtilidadesLog.debug("Calculo metas proyectada: setCapitalizacion" + elemVtaProy.getCapitalizacion());
                            UtilidadesLog.debug("Calculo metas proyectada: getNumActivasIniciales" + elemVtaProy.getNumActivasIniciales());
                            UtilidadesLog.debug("Calculo metas proyectada: getNumActivasFinales" + elemVtaProy.getNumActivasFinales());
                            UtilidadesLog.debug("Calculo metas proyectada: getNumPedidos" + elemVtaProy.getNumPedidos());
    
                            if (elemVtaProy.getNumActivasFinales().longValue() != 0) {
                                UtilidadesLog.debug("numActivas finales != 0");
                                elemVtaProy.setActividad(new BigDecimal(((elemVtaProy.getNumPedidos().doubleValue() / elemVtaProy.getNumActivasFinales()
                                                                                                                                 .doubleValue()) * 100)));
                            } else {
                                UtilidadesLog.debug("numActivas finales == 0");
                                elemVtaProy.setActividad(new BigDecimal(0));
                            }
    
                            UtilidadesLog.debug("Calculo metas proyectada: setActividad" + elemVtaProy.getActividad());
                            UtilidadesLog.debug("Calculo metas proyectada: getNumUnidadesVendidas" + elemVtaProy.getNumUnidadesVendidas());
                            UtilidadesLog.debug("Calculo metas proyectada: getImpVentaEstadisticable" + elemVtaProy.getImpVentaEstadisticable());
    
                            if (elemVtaProy.getNumUnidadesVendidas().longValue() != 0) {
                                elemVtaProy.setPrecioPromedioUnitario(new BigDecimal(elemVtaProy.getImpVentaEstadisticable().doubleValue() / elemVtaProy.getNumUnidadesVendidas()
                                                                                                                                                        .doubleValue()));
                            } else {
                                elemVtaProy.setPrecioPromedioUnitario(new BigDecimal(0));
                            }
    
                            UtilidadesLog.debug("Calculo metas proyectada: setPrecioPromedioUnitario" + elemVtaProy.getPrecioPromedioUnitario());
    
                            UtilidadesLog.debug("Calculo metas proyectada: getNumPedidos" + elemVtaProy.getNumPedidos());
                            UtilidadesLog.debug("Calculo metas proyectada: getNumOrdenes" + elemVtaProy.getNumOrdenes());
    
                            if (elemVtaProy.getNumPedidos().longValue() != 0) {
                                elemVtaProy.setPromedioVentaPedido(new BigDecimal(elemVtaProy.getImpVentaEstadisticable().doubleValue() / elemVtaProy.getNumPedidos()
                                                                                                                                                     .doubleValue()));
                                elemVtaProy.setPromedioUnidadesPedido(new BigDecimal((elemVtaProy.getNumUnidadesVendidas().doubleValue() / elemVtaProy.getNumPedidos()
                                                                                                                                                      .doubleValue())));
                                elemVtaProy.setPromedioOrdenesPedido(new BigDecimal(elemVtaProy.getNumOrdenes().doubleValue() / elemVtaProy.getNumPedidos()
                                                                                                                                           .doubleValue()));
                            } else {
                                elemVtaProy.setPromedioVentaPedido(new BigDecimal(0));
                                elemVtaProy.setPromedioUnidadesPedido(new BigDecimal(0));
                                elemVtaProy.setPromedioOrdenesPedido(new BigDecimal(0));
                            }
    
                            UtilidadesLog.debug("Calculo metas proyectada: setPromedioVentaPedido" + elemVtaProy.getPromedioVentaPedido());
                            UtilidadesLog.debug("Calculo metas proyectada: setPromedioUnidadesPedido" + elemVtaProy.getPromedioUnidadesPedido());
                            UtilidadesLog.debug("Calculo metas proyectada: setPromedioOrdenesPedido" + elemVtaProy.getPromedioOrdenesPedido());
                            
                            numActivasFinalAnyo = dtoListaActivasIni.obtenerActivasIniciales(elemVtaProy);
    
                            UtilidadesLog.debug("Calculo metas proyectada: numActivasFinalAnyo" + numActivasFinalAnyo);
    
                            if (numActivasFinalAnyo.longValue() != 0) {
                                elemVtaProy.setRetencion(new Double(elemVtaProy.getNumActivasFinales().doubleValue() / numActivasFinalAnyo.doubleValue()));
                            } else {
                                elemVtaProy.setRetencion(new Double(0));
                            }
    
                            UtilidadesLog.debug("Calculo metas proyectada: setRetencion" + elemVtaProy.getRetencion());
    
                            //voy adicionando a la final, el objeto: elemVtaProy tiene ciertos campos 
                            //llenos, que son los que se rescatan, en: obtenerMetasParaVentasProyectada
                            //los demas se llenan arriba
                            dtoFinalListaMetas.getListaMetas().add((DTOMetasVentaProyectada) elemVtaProy);
                        }
                    } //hay gerente           
                } //for sobre lista   
            }
    
            if (dtoConcurso.getParamCalificacion().getOidAgrupacion().longValue() == ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA.longValue()) {
                this.guardarMetasVentaProyectadaSubgerencia(dtoConcurso.getParamGenerales().getOid(), dtoFinalListaMetas);
            }
    
            if (dtoConcurso.getParamCalificacion().getOidAgrupacion().longValue() == ConstantesINC.OID_AGRUPACION_REGION.longValue()) {
                this.guardarMetasVentaProyectadaRegion(dtoConcurso.getParamGenerales().getOid(), dtoFinalListaMetas);
            }
    
            if (dtoConcurso.getParamCalificacion().getOidAgrupacion().longValue() == ConstantesINC.OID_AGRUPACION_ZONA.longValue()) {
                this.guardarMetasVentaProyectadaZona(dtoConcurso.getParamGenerales().getOid(), dtoFinalListaMetas);
            }
        
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex);
        }
        
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasVentaProyectada(DTOBatch DTOE):Salida");
        return new DTOSalidaBatch(0, new String("- Calculadas metas venta proyectada - "));
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return Boolean
     * @author Sergio C. Saavedra -- 23/06/2005
     */
    public Boolean estaTipificacionCliente(Long oidCliente, ArrayList listaClasiParti)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.estaTipificacionCliente(Long oidCliente, ArrayList listaClasiParti):Entrada");
        //inc. 19000
        UtilidadesLog.debug("dentro de: estaTipificacionCliente(.... cliente / listaClasiParti: " + oidCliente + " / " + listaClasiParti);

        if (listaClasiParti == null || !(listaClasiParti.size() > 0)) {
            UtilidadesLog.info("MONCalcularMetasBean.estaTipificacionCliente(Long oidCliente, ArrayList listaClasiParti):SALIDA 0 FALSE");
            return Boolean.FALSE;
        }
        
        DAOCalcularMetas daoCM = new DAOCalcularMetas();
        RecordSet tipificaciones = daoCM.obtenerTipificacionCliente(oidCliente);
        boolean resu = false;
        TipificacionCliente tc = null;
        ArrayList listaTipificacionesCliente = new ArrayList();

        if ((tipificaciones != null) && (tipificaciones.getRowCount() > 0)) {
            Object o = null;

            //este recordset solo debe contener un registro, a lo sumo....
            for (int i = 0; i < tipificaciones.getRowCount(); i++) {
                tc = new TipificacionCliente();
                tc.setOidClasificacionCliente(((o = tipificaciones.getValueAt(i, "OID_CLASI")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                tc.setOidSubTipoCliente(((o = tipificaciones.getValueAt(i, "OID_SUBTIPO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                tc.setOidTipoClasificacionCliente(((o = tipificaciones.getValueAt(i, "OID_TIPO_CLASI")) != null)
                                                  ? new Long(((BigDecimal) o).toString()) : null);
                tc.setOidTipoCliente(((o = tipificaciones.getValueAt(i, "OID_TIPO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
                
                listaTipificacionesCliente.add(tc);
            }
        }
        
        RecordSet tipificacionesParticipantes = daoCM.obtenerTipificacionesParticipantes(listaClasiParti);

        if ((tipificacionesParticipantes != null) && (tipificacionesParticipantes.getRowCount() > 0)) {
            ArrayList listaTipificacionesParticipantes = new ArrayList();
            TipificacionCliente registro = null;
            Object o = null;

            for (int i = 0; i < tipificacionesParticipantes.getRowCount(); i++) {
                registro = new TipificacionCliente();
                registro.setOidClasificacionCliente(((o = tipificacionesParticipantes.getValueAt(i, "CLAS")) != null)
                                                    ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidSubTipoCliente(((o = tipificacionesParticipantes.getValueAt(i, "SUBTIPOCLI")) != null)
                                              ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidTipoClasificacionCliente(((o = tipificacionesParticipantes.getValueAt(i, "TIPOCLAS")) != null)
                                                        ? new Long(((BigDecimal) o).toString()) : null);
                registro.setOidTipoCliente(((o = tipificacionesParticipantes.getValueAt(i, "TIPOCLI")) != null)
                                           ? new Long(((BigDecimal) o).toString()) : null);
                                           
                listaTipificacionesParticipantes.add(registro);
            }

            //busco
            TipificacionCliente regPart = null;
            TipificacionCliente regCli = null;

            for (int j = 0; j < listaTipificacionesParticipantes.size(); j++) {
                regPart = new TipificacionCliente();
                regPart = (TipificacionCliente) listaTipificacionesParticipantes.get(j);
                
                for (int k = 0; k < listaTipificacionesCliente.size(); k++) {
                
                    regCli = new TipificacionCliente();
                    regCli = (TipificacionCliente) listaTipificacionesCliente.get(k);
    
                    if (regPart.equals(regCli)) {
                        resu = true;
    
                        break;
                    }
                }
                
                if(resu) break;
            }
        }
        UtilidadesLog.info("MONCalcularMetasBean.estaTipificacionCliente(Long oidCliente, ArrayList listaClasiParti):Salida " + resu);
        return new Boolean(resu);
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOOID
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 07/06/2005
     * Se ejecuta este proceso en background
     */
    public Boolean esPrimerPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.esPrimerPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Entrada");
        //se toma la fecha desde del periodo del parametro y se compara con las fechas desde 
        //de todos los periodos del DTOMetasVentaProyectada que hay dentro del array....
        //busco desde del oid, del parametro...
        try {
            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLDesde = null;
            PeriodoLocal periodo1LDesde = null;
            periodoLDesde = periodoLH.findByPrimaryKey(oidPeriodo);

            for (int j = 0; j < listaMetas.getListaMetas().size(); j++) {
                DTOMetasVentaProyectada registro = (DTOMetasVentaProyectada) listaMetas.getListaMetas().get(j);
                periodo1LDesde = periodoLH.findByPrimaryKey(registro.getOidPeriodo());

                if (periodoLDesde.getFechainicio().getTime() > periodo1LDesde.getFechainicio().getTime()) {
                    UtilidadesLog.info("MONCalcularMetasBean.esPrimerPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Salida");
                    return new Boolean(false);
                }
            }
            UtilidadesLog.info("MONCalcularMetasBean.esPrimerPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Salida");
            return new Boolean(true);
        } catch (NoResultException nre) {
             ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

        } 
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOOID
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 08/06/2005
     * Se ejecuta este proceso en background
     */
    public Boolean esUltimoPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.esUltimoPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Entrada");
        //se toma la fecha desde del periodo del parametro y se compara con las fechas hasta 
        //de todos los periodos del DTOMetasVentaProyectada que hay dentro del array....
        //busco hasta del oid, del parametro...
        try {
            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLHasta = null;
            PeriodoLocal periodo1LHasta = null;
            periodoLHasta = periodoLH.findByPrimaryKey(oidPeriodo);

            for (int j = 0; j < listaMetas.getListaMetas().size(); j++) {
                DTOMetasVentaProyectada registro = (DTOMetasVentaProyectada) listaMetas.getListaMetas().get(j);
                periodo1LHasta = periodoLH.findByPrimaryKey(registro.getOidPeriodo());

                if (periodoLHasta.getFechainicio().getTime() < periodo1LHasta.getFechainicio().getTime()) {
                    UtilidadesLog.info("MONCalcularMetasBean.esUltimoPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Salida");
                    return new Boolean(false);
                }
            }
            UtilidadesLog.info("MONCalcularMetasBean.esUltimoPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas):Salida");
            return new Boolean(true);
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalidaBatch
     * @param DTOBatch
     * @author Sergio C. Saavedra -- 19/05/2005
     * Se calculan las metas tipo venta, si el concurso es dirigido a Gerente o a consultora
     * se llamará al método correspondiente
     */
    public DTOSalidaBatch calcularMetasTipoVenta(DTOBatch DTOE)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVenta(DTOBatch DTOE):Entrada");
        UtilidadesLog.debug("dentro de MONCalcularMetas==>>calcularMetasTipoVenta, recibo : " + DTOE);

        DTOConcurso dtoConcurso = (DTOConcurso) DTOE.getDTOOnline();
        DTOListaMetasTipoVenta dtoListaMetasTipoVenta = new DTOListaMetasTipoVenta();

        if (dtoConcurso.getParamGenerales().getOidDirigidoA().longValue() == 
        ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
            dtoListaMetasTipoVenta = this.calcularMetasTipoVentaGerentes(dtoConcurso);

            this.guardarMetasTipoVenta(dtoConcurso.getParamGenerales().getOid(), dtoListaMetasTipoVenta);
            
            //Inicio - DBLG500000900        
            if(dtoConcurso.getParamGenerales().getIndActivo().booleanValue() &&
            dtoConcurso.getParamCalificacion()!= null &&
            dtoConcurso.getParamCalificacion().getIndComunicacion()!=null &&
            dtoConcurso.getParamCalificacion().getIndComunicacion().booleanValue()) {
                DTOOID dtoOid = new DTOOID();
                dtoOid.setOidPais(dtoConcurso.getOidPais());
                dtoOid.setOid(dtoConcurso.getParamGenerales().getOid());            
                GestorMensajesMetas gestor = new GestorMensajesMetas();
                UtilidadesLog.debug("*** Llamando a enviarMSGCalificacionMetasVenta con:");
                UtilidadesLog.debug("*** DTOOID: " + dtoOid);
                gestor.enviarMSGCalificacionMetasVenta(dtoOid);
            } 

        }
        else {
            //jrivas 05/01/2007 Cambio Calculo Metas Performance
            //dtoListaMetasTipoVenta = this.calcularMetasTipoVentaConsultoras(dtoConcurso, DTOE.getProcessID());
            this.calcularMetasTipoVentaConsultorasPerf(dtoConcurso, DTOE.getProcessID());
        }

        //Fin - DBLG500000900        
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVenta(DTOBatch DTOE):Salida");
        return new DTOSalidaBatch(0, new String("- Calculadas metas tipo venta  - "));
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasTipoVenta
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 10/06/2005
     */
    public DTOListaMetasTipoVenta calcularMetasTipoVentaGerentes(DTOConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaGerentes(DTOConcurso DTOE):Entrada");
        UtilidadesLog.debug("****Entro  MONPremiacion.calcularMetasTipoVentaGerentes****");

        DTOPeriodoDesdeHasta dtoDesdeHasta = new DTOPeriodoDesdeHasta();
        dtoDesdeHasta.setPeriodoDesde(DTOE.getParamCalificacion().getOidPeriodoDesde());
        dtoDesdeHasta.setPeriodoHasta(DTOE.getParamCalificacion().getOidPeriodoHasta());

        DAOCalcularMetas daoCM = new DAOCalcularMetas();
        DAOSolicitudes daoS = new DAOSolicitudes();
        ArrayList periodos = daoCM.obtenerPeriodosCalificacion(dtoDesdeHasta);

        DTOBusquedaClienteCalificado dtoBusqueda = new DTOBusquedaClienteCalificado();

        dtoBusqueda.setOidPais(DTOE.getOidPais());
        dtoBusqueda.setOidMarca(DTOE.getParamGenerales().getOidMarca());
        dtoBusqueda.setOidCanal(DTOE.getParamGenerales().getOidCanal());
        dtoBusqueda.setOidTipoCliente(ConstantesMAE.OID_TIPO_CLIENTE_GERENTE);
        dtoBusqueda.setIndParticipantesCompleto(DTOE.getPlantilla().getIndPartParticipantesCompleto());
        dtoBusqueda.setIndAmbitoGeograficoCompleto(DTOE.getPlantilla().getIndAmbitoGeografico());
        if (DTOE.getCalificacionParticipantes() != null) {        
            dtoBusqueda.setListaParticipantesCalificacion(DTOE.getCalificacionParticipantes().getLstCalificacionParticipantes());
        }
        if (DTOE.getListaAmbitosGeograficos() != null) {
            dtoBusqueda.setListaAmbitosGeograficos(DTOE.getListaAmbitosGeograficos().getAmbitoGeografico());
        }
        
        //Jrivas 21205 14/10/2005
        //dtoBusqueda.setOidAgrugacion(DTOE.getParamCalificacion().getOidAgrupacion());
        dtoBusqueda.setOidAgrugacion(null);

        DTOUACliente[] clientesCalificados = daoCM.obtenerGerentesCalificados(dtoBusqueda);
        ArrayList listaSolicitudes = new ArrayList();

        BigDecimal totalMonto = new BigDecimal(0);
        int totalUnidades = 0;

        //par de objetos para el retorno
        DTOListaMetasTipoVenta dtoLista = new DTOListaMetasTipoVenta();
        dtoLista.setListaMetas(new ArrayList());

        DTOMetasTipoVenta dto = new DTOMetasTipoVenta();

        ArrayList periodosConPedido = new ArrayList();

        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;

        if ((clientesCalificados != null) && (clientesCalificados.length > 0)) {
            int count = 0;

            while ((count < clientesCalificados.length)) {
                totalMonto = new BigDecimal(0);
                totalUnidades = 0;  
                periodosConPedido = new ArrayList();
                listaSolicitudes = new ArrayList();
                DTOUACliente regActual = clientesCalificados[count];
                DTOSolicitudValidacion[] dtoSolicitudes = daoCM.obtenerSolicitudes(regActual, dtoDesdeHasta.getOidPeriodoDesde(),
                                                                                   dtoDesdeHasta.getOidPeriodoHasta(),
                                                                                   DTOE.getParamCalificacion().getIndAnulaciones(),
                                                                                   DTOE.getParamCalificacion().getIndDevoluciones());
                int count1 = 0;
                UtilidadesLog.debug("dtoSolicitudes: " + dtoSolicitudes);
                if (dtoSolicitudes != null) {
                    for (int j = 0; j < dtoSolicitudes.length; j++) {
                        DTOSolicitudValidacion registro = dtoSolicitudes[j];
                        UtilidadesLog.debug("registro: " + registro);
                        Solicitud solicitud = daoS.obtenerSolicitud(registro);

                        listaSolicitudes.add(solicitud);
                    }
                }

                if (listaSolicitudes != null && listaSolicitudes.size() > 0) {
                    //Llamar al método que pasa las posiciones de las solicitudes y todos los 
                    //objetos del motor de reglas y actualiza un indicador para posteriormente 
                    //calcular las metas 
                    Concurso concurso = new Concurso();
    
                    if (DTOE.getParamGenerales().getOid() != null) {
                        concurso.setOidConcurso(DTOE.getParamGenerales().getOid());
                    } else {
                        //siempre existiria....
                        concurso.setOidConcurso(new Long(9999999999L));
                    }
    
                    if (ConstantesINC.OID_DIRIGIDO_A_GERENTE.equals(DTOE.getParamGenerales().getOidDirigidoA())) {
                        concurso.setBaseCalculo(DTOE.getParamGerentes().getOidBaseCalculo());
                    } else {
                        concurso.setBaseCalculo(DTOE.getParamConsultoras().getOidBaseCalculo());
                    }
    
                    if(concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_UNIDADES)){
                        concurso.setTipoVenta(ConstantesINC.TIPO_VENTA_CATALOGO);
                    } else {
                        concurso.setTipoVenta(DTOE.getParamCalificacion().getOidTipoVentaHistorica());
                    }
    
                    if (DTOE.getParamCalificacion().getIndFaltantesNoAnunciados() != null) {
                        concurso.setIndFaltantesAnunciados(DTOE.getParamCalificacion().getIndFaltantesNoAnunciados().booleanValue());
                    } else {
                        concurso.setIndFaltantesAnunciados(false);
                    }
    
                    concurso.setProductosCalificar(new ListaProductos());
                    concurso.getProductosCalificar().setProductos(new ArrayList());
    
                    concurso.setProductosExcluirCalificar(new ListaProductos());
                    concurso.getProductosExcluirCalificar().setProductos(new ArrayList());
    
                    UtilidadesLog.debug("ANTES de getProductosACalificar ....." + DTOE.getProductosACalificar().getLstProductos().size());
    
                    for (int k = 0; k < DTOE.getProductosACalificar().getLstProductos().size(); k++) {
                        DTOProdu registro = (DTOProdu) DTOE.getProductosACalificar().getLstProductos().get(k);
    
                        if (registro.getOidMarcaProducto() != null) {
                            PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
    
                            prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                            prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                            prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                            prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                            prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
    
                            concurso.getProductosCalificar().getProductos().add(prdBloqueNegocio);
                        } else {
                            if (registro.getOidProducto() != null) {
                                PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
        
                                prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
        
                                concurso.getProductosCalificar().getProductos().add(prdBloqueProducto);
                            } else {
                                PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
        
                                prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
        
                                concurso.getProductosCalificar().getProductos().add(prdBloqueOferta);
                            }
                        }
                    } //fin ciclo sobre: DTOE.getProductosACalificar().getLstProductos()
    
                    UtilidadesLog.debug("despues de getProductosACalificar ....."  + concurso.getProductosCalificar().getProductos().size());
    
                    if ((DTOE.getProductosExcluidosCalificacion() != null) && (DTOE.getProductosExcluidosCalificacion().getLstProductos() != null)) {
                    
                        UtilidadesLog.debug("Antes de getProductosExcluidosCalificacion ....." + DTOE.getProductosExcluidosCalificacion().getLstProductos().size());
                        
                        for (int l = 0; l < DTOE.getProductosExcluidosCalificacion().getLstProductos().size(); l++) {
                            DTOProdu registro = (DTOProdu) DTOE.getProductosExcluidosCalificacion().getLstProductos().get(l);
    
                            if (registro.getOidMarcaProducto() != null) {
                                PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
    
                                prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                                prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                                prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                                prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                                prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
    
                                concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueNegocio);
                            } else {
                                if (registro.getOidProducto() != null) {
                                    PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
        
                                    prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                    prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
        
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueProducto);
                                } else {
                                    PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
        
                                    prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
        
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueOferta);
                                }
                            }
                        } //fin ciclo sobre: DTOE.getProductosExcluidosCalificacion().getLstProductos()
                    }
    
                    UtilidadesLog.debug("despues de getProductosExcluidosCalificacion ....." + concurso.getProductosExcluirCalificar().getProductos().size());
    
                    //se llama al método 
                    //MotorCalcularMetas.evaluarSolicitudesParaMetas(listaSolicitudes....
                    MotorCalcularMetas motor = new MotorCalcularMetas();
                    UtilidadesLog.debug("Antes de evaluarSolicitudesParaMetas .....");
                    motor.evaluarSolicitudesParaMetas(listaSolicitudes, concurso);
                    UtilidadesLog.debug("despues de evaluarSolicitudesParaMetas .....");
    
                    if (listaSolicitudes != null) {
                        for (int w = 0; w < listaSolicitudes.size(); w++) {
                            Solicitud solicitud = (Solicitud) listaSolicitudes.get(w);
                            UtilidadesLog.debug("****solicitud**** " + solicitud);
                            UtilidadesLog.debug("Monto: " + solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                            totalMonto = totalMonto.add(solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                            totalUnidades = (totalUnidades +
                                            solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getUnidadesCalificacion().intValue());
    
                            if (!contenidoEnPeriodosConPedido(periodosConPedido, solicitud.getPeriodo().getOidPeriodo())) {
                                periodosConPedido.add(solicitud.getPeriodo().getOidPeriodo());
                            }
                        }
                    }
    
                    UtilidadesLog.debug("totalMonto ..... " + totalMonto);
                    UtilidadesLog.debug("totalUnidades ..... " + totalUnidades);                
    
                    //Crear un objeto Meta....
                    Meta meta = new Meta();
                    meta.setMonto(totalMonto);
                    meta.setUnidades(new Integer(totalUnidades));
    
                    //meta.setUnidades(new Long(totalUnidades));
                    meta.setBaseCalculo(concurso.getBaseCalculo());
                    meta.setTipoIncremento(DTOE.getParamCalificacion().getOidTipoIncremento());
                    meta.setTablaIncremento(DTOE.getParamCalificacion().getLstIncrementosPorRango());
                    meta.setFormaCalculo(DTOE.getParamCalificacion().getOidFormaCalculo());
                    meta.setNumPeriodoCalificacion(new Integer(periodos.size()));
                    meta.setNumPeriodoPedido(new Integer(periodosConPedido.size()));
    
                    //jrivas 20/7/2005
                    //Inc 19992
                    //meta.setIncremento(DTOE.getParamCalificacion().getValorIncremento());
                    // o incrementoPorNiveles por tablaIncremento...        
                    //if ((meta.getTablaIncremento() != null) && (meta.getTablaIncremento().size() > 0)) {
                    //    meta.setIncrementoPorNiveles(Boolean.TRUE);
                    //}
                    
                    //COMENTADO POR INCIDENCIA 21054 - Cristian Valenzuela - 4/10/05
                    /*if (ConstantesINC.OID_TIPO_VTA_INC_INCREMENTAL.equals(DTOE.getParamCalificacion().getOidTipoVentaIncremental())) {
                        ArrayList incPorRango = DTOE.getParamCalificacion().getLstIncrementosPorRango();
                        DTOIncrementoPorRango dtoTemp = (DTOIncrementoPorRango) incPorRango.get(0);
                        meta.setIncremento(dtoTemp.getIncremento());
                        meta.setIncrementoPorNiveles(new Boolean(false));
                    } else if (ConstantesINC.OID_TIPO_VTA_INC_INCREMENTAL_NIVELES.equals(DTOE.getParamCalificacion().getOidTipoVentaIncremental())) {
                        meta.setIncremento(null);
                        meta.setIncrementoPorNiveles(new Boolean(true));
                    }*/
                    //FIN - COMENTADO POR INCIDENCIA 21054
    
                    //jrivas 26-5-2006 DBLG500000255
                    meta.setLstCalificacionParticipantesConc(DTOE.getCalificacionParticipantes().getLstCalificacionParticipantes());;
                    meta.asignarTipificacionGerente(((Solicitud)listaSolicitudes.get(0)), clientesCalificados[count].getOidCliente()); 
                    meta.setDirigidoA(ConstantesINC.OID_DIRIGIDO_A_GERENTE);
                    
                    UtilidadesLog.debug("META ...antes de calcular Meta.");
    
                    BigDecimal metaTotal = meta.calcularMeta();
                    UtilidadesLog.debug("META ...despues de calcular Meta." + metaTotal);
    
                    //busco sobre ClientesDatosBasicos para recuperar el codigo del cliente
                    try {
                        clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
                        UtilidadesLog.debug("clientesCalificados[count].getOidCliente() " + clientesCalificados[count].getOidCliente());
                        clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(clientesCalificados[count].getOidCliente());
                    } catch (NoResultException nre) {
                        ctx.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
    
                    dto = new DTOMetasTipoVenta();
                    dto.setOidCliente(clientesCalificados[count].getOidCliente());
                    dto.setCodigoCliente(clienteDatosBasicosL.getCod_clie());
                    dto.setValorMetas(metaTotal);
                    dto.setImpMontoVenta(totalMonto);
                    dto.setNumUnidadesVendidas(new Integer(totalUnidades));
                    //Agregado por incidencia 21054
                    dto.setValorIncremento(meta.getIncremento());
                    //FIN - Agregado por incidencia 21054
                    dtoLista.getListaMetas().add(dto);
                    
                    UtilidadesLog.debug("DTOMetasTipoVenta: " + dto);
    
                }//if listaSolicitudes
                count++;                
            }
        }

        UtilidadesLog.debug("****Salgo  MONPremiacion.calcularMetasTipoVentaGerentes****");
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaGerentes(DTOConcurso DTOE):Salida");
        return dtoLista;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasTipoVenta
     * @param DTOConcurso
     * @author Sergio C. Saavedra -- 08/06/2005
     */
    public DTOListaMetasTipoVenta calcularMetasTipoVentaConsultoras(DTOConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaConsultoras(DTOConcurso DTOE):Entrada");
        //Se calculan las metas tipo venta para consultoras 
        DTOPeriodoDesdeHasta dtoDesdeHasta = new DTOPeriodoDesdeHasta();
        DAOCalcularMetas daoCM = new DAOCalcularMetas();
        DAOSolicitudes daoS = new DAOSolicitudes();
        dtoDesdeHasta.setPeriodoDesde(DTOE.getParamCalificacion().getOidPeriodoDesde());
        dtoDesdeHasta.setPeriodoHasta(DTOE.getParamCalificacion().getOidPeriodoHasta());

        ArrayList periodos = daoCM.obtenerPeriodosCalificacion(dtoDesdeHasta);
        
        //vbongiov -- 18/07/2006 -- inc DBLG500000977
        Concurso concursoValidadorEstatus = 
                this.obtenerConcursoValidadorEstatus(DTOE.getEstatusVenta().getEstatusVenta());        
        
        DTOBusquedaClienteCalificado dtoBusqueda = new DTOBusquedaClienteCalificado();

        dtoBusqueda.setOidPais(DTOE.getOidPais());
        dtoBusqueda.setOidMarca(DTOE.getParamGenerales().getOidMarca());
        dtoBusqueda.setOidCanal(DTOE.getParamGenerales().getOidCanal());
        dtoBusqueda.setIndAmbitoGeograficoCompleto(DTOE.getPlantilla().getIndAmbitoGeografico());
        if (DTOE.getCalificacionParticipantes() != null) {        
            dtoBusqueda.setListaParticipantesCalificacion(DTOE.getCalificacionParticipantes().getLstCalificacionParticipantes());
        }
        if (DTOE.getListaAmbitosGeograficos() != null) {
            dtoBusqueda.setListaAmbitosGeograficos(DTOE.getListaAmbitosGeograficos().getAmbitoGeografico());
        }
        
        Long[] clientesCalificados = daoCM.obtenerClientesCalificados(dtoBusqueda).getOids();
        ArrayList listaSolicitudes = new ArrayList();

        //par de objetos para el retorno
        DTOListaMetasTipoVenta dtoLista = new DTOListaMetasTipoVenta();
        dtoLista.setListaMetas(new ArrayList());

        DTOMetasTipoVenta dto = new DTOMetasTipoVenta();
        ArrayList periodosConPedido = new ArrayList();

        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;

        BigDecimal totalMonto = new BigDecimal(0);
        int totalUnidades = 0;
        Solicitud sol= null;
        Periodo periodoCalculoAux = null;
        boolean estatusClienteValido = false;

        if (clientesCalificados != null) {
            for (int i = 0; i < clientesCalificados.length; i++) {
                totalMonto = new BigDecimal(0);
                totalUnidades = 0;  
                periodosConPedido = new ArrayList();
                listaSolicitudes = new ArrayList();
                DTOSolicitudValidacion[] solicitudes = null;
                UtilidadesLog.debug("clientesCalificados[i]: " + clientesCalificados[i]);
            
                solicitudes = daoCM.obtenerSolicitudes(clientesCalificados[i], dtoDesdeHasta.getOidPeriodoDesde(),
                                                       dtoDesdeHasta.getOidPeriodoHasta(), DTOE.getParamCalificacion().getIndAnulaciones(),
                                                       DTOE.getParamCalificacion().getIndDevoluciones());

                UtilidadesLog.debug("solicitudes: " + solicitudes);
                Solicitud solicitud = null;
                DTOSolicitudValidacion registroSV = null;
                if (solicitudes != null) {
                    for (int j = 0; j < solicitudes.length; j++) {
                        registroSV = solicitudes[j];
                        solicitud = daoS.obtenerSolicitud(registroSV);
                        listaSolicitudes.add(solicitud);
                    }
                }
                
                //Este es el inicio del cambio de la incidencia tecnica V-INC-17
                //Se comenta a fin de no afectar el funcionamiento actual del proceso.
                //Gacevedo
                //listaSolicitudes = daoCM.obtenerSolicitudesCompleto(clientesCalificados[i], dtoDesdeHasta.getOidPeriodoDesde(),
                //                                       dtoDesdeHasta.getOidPeriodoHasta(), DTOE.getParamCalificacion().getIndAnulaciones(),
                //                                       DTOE.getParamCalificacion().getIndDevoluciones());
                UtilidadesLog.debug("listaSolicitudes: " + listaSolicitudes);
                
                if (listaSolicitudes != null && listaSolicitudes.size() > 0) {
                    // vbongiov -- 18/07/2006 -- inc DBLG500000977
                    // Valida estatus del cliente
                    sol= (Solicitud)listaSolicitudes.get(0);
                    periodoCalculoAux = sol.getPeriodoCalculo();
                    sol.setPeriodoCalculo(null);
                    
                    estatusClienteValido = concursoValidadorEstatus.validarEstatusCliente(sol);
    
                    sol.setPeriodoCalculo(periodoCalculoAux);                   

                    if (estatusClienteValido) {
                        //Llamar al método que pasa las posiciones de las solicitudes y todos los 
                        //objetos del motor de reglas y actualiza un indicador para posteriormente 
                        //calcular las metas 
                        Concurso concurso = new Concurso();
        
                        if (DTOE.getParamGenerales().getOid() != null) {
                            concurso.setOidConcurso(DTOE.getParamGenerales().getOid());
                        } else {
                            //siempre existiria....
                            concurso.setOidConcurso(new Long(9999999999L));
                        }
        
                        if (DTOE.getParamGenerales().getOidDirigidoA() == ConstantesINC.OID_DIRIGIDO_A_GERENTE) {
                            concurso.setBaseCalculo(DTOE.getParamGerentes().getOidBaseCalculo());
                        } else {
                            concurso.setBaseCalculo(DTOE.getParamConsultoras().getOidBaseCalculo());
                        }
        
                        if(concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_UNIDADES)){
                            concurso.setTipoVenta(ConstantesINC.TIPO_VENTA_CATALOGO);
                        } else {
                            concurso.setTipoVenta(DTOE.getParamCalificacion().getOidTipoVentaHistorica());
                        }
        
                        if (DTOE.getParamCalificacion().getIndFaltantesNoAnunciados() != null) {
                            concurso.setIndFaltantesAnunciados(DTOE.getParamCalificacion().getIndFaltantesNoAnunciados().booleanValue());
                        } else {
                            concurso.setIndFaltantesAnunciados(false);
                        }
        
                        concurso.setProductosCalificar(new ListaProductos());
                        concurso.getProductosCalificar().setProductos(new ArrayList());
        
                        concurso.setProductosExcluirCalificar(new ListaProductos());
                        concurso.getProductosExcluirCalificar().setProductos(new ArrayList());
        
                        if (DTOE.getProductosACalificar() != null && DTOE.getProductosACalificar().getLstProductos() != null) {
                            for (int k = 0; k < DTOE.getProductosACalificar().getLstProductos().size(); k++) {
                                DTOProdu registro = (DTOProdu) DTOE.getProductosACalificar().getLstProductos().get(k);
            
                                /*
                                 * INC 22402 - dmorello, 16/01/2006
                                 * El bloque if (registro.getOidProducto != null) { ... } else { ... },
                                 * que originalmente estaba "suelto" dentro de este FOR, pasa a ubicarse
                                 * en el ELSE del siguiente bloque IF, que pregunta
                                 * if (registro.getOidMarcaProducto() != null)
                                 * a fin de adecuarse al diseño.
                                 */
                                if (registro.getOidMarcaProducto() != null) {
                                    PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
            
                                    prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                                    prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                                    prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueNegocio);
                                } else if (registro.getOidProducto() != null) {
                                    PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
            
                                    prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                    prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueProducto);
                                } else {
                                    PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
            
                                    prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueOferta);
                                }
                            } //fin ciclo sobre: DTOE.getProductosACalificar().getLstProductos()
                        }
        
                        if (DTOE.getProductosExcluidosCalificacion() != null && DTOE.getProductosExcluidosCalificacion().getLstProductos() != null) {
                            for (int l = 0; l < DTOE.getProductosExcluidosCalificacion().getLstProductos().size(); l++) {
                                DTOProdu registro = (DTOProdu) DTOE.getProductosExcluidosCalificacion().getLstProductos().get(l);
            
                                /*
                                 * dmorello, 16/01/2006
                                 * El bloque if (registro.getOidProducto() != null) {...} else {...}
                                 * deja de estar suelto, y pasa al ELSE del siguiente if...
                                 */
                                if (registro.getOidMarcaProducto() != null) {
                                    PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
            
                                    prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                                    prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                                    prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueNegocio);
                                } else if (registro.getOidProducto() != null) {
                                    PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
            
                                    prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                    prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueProducto);
                                } else {
                                    PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
            
                                    prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueOferta);
                                }
                            } //fin ciclo sobre: DTOE.getProductosExcluidosCalificacion().getLstProductos()
                        }
        
                        //se llama al método 
                        //MotorCalcularMetas.evaluarSolicitudesParaMetas(listaSolicitudes....
                        MotorCalcularMetas motor = new MotorCalcularMetas();
                        motor.evaluarSolicitudesParaMetas(listaSolicitudes, concurso);
                        
                        UtilidadesLog.debug("listaSolicitudes luego de " 
                            + "evaluarSolicitudesParaMetas():" + listaSolicitudes);
                        UtilidadesLog.debug("listaSolicitudes " + listaSolicitudes);
                        if (listaSolicitudes != null) {
                            for (int w = 0; w < listaSolicitudes.size(); w++) {
                                solicitud = (Solicitud) listaSolicitudes.get(w);
                                UtilidadesLog.debug("solicitud " + solicitud + " - " + solicitud.getSolicitudConcurso(concurso.getOidConcurso()));
                                UtilidadesLog.debug("Monto: " + solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                                totalMonto = totalMonto.add(solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                                totalUnidades = (totalUnidades +
                                                solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getUnidadesCalificacion().intValue());
        
                                if (!contenidoEnPeriodosConPedido(periodosConPedido, solicitud.getPeriodo().getOidPeriodo())) {
                                    periodosConPedido.add(solicitud.getPeriodo().getOidPeriodo());
                                }
                            }
                        }
                        
                        UtilidadesLog.debug("totalMonto ..... " + totalMonto);
                        UtilidadesLog.debug("totalUnidades ..... " + totalUnidades);              
        
                        //Crear un objeto Meta....
                        Meta meta = new Meta();
                        meta.setMonto(totalMonto);
                        meta.setUnidades(new Integer(totalUnidades));
                        meta.setBaseCalculo(concurso.getBaseCalculo());
                        meta.setTipoIncremento(DTOE.getParamCalificacion().getOidTipoIncremento());
                        meta.setTablaIncremento(DTOE.getParamCalificacion().getLstIncrementosPorRango());
                        meta.setFormaCalculo(DTOE.getParamCalificacion().getOidFormaCalculo());
                        meta.setNumPeriodoPedido(new Integer(periodosConPedido.size()));
                        meta.setNumPeriodoCalificacion(new Integer(periodos.size()));
        
                        //jrivas 20/7/2005
                        //Inc 19992
                        meta.setIncremento(DTOE.getParamCalificacion().getValorIncremento());
        
                        // o incrementoPorNiveles por tablaIncremento...        
                        if ((meta.getTablaIncremento() != null) && (meta.getTablaIncremento().size() > 0)) {
                            meta.setIncrementoPorNiveles(Boolean.TRUE);
                        }
        
                        //jrivas 26-5-2006 DBLG500000255
                        meta.setLstEstatusVentaConc(DTOE.getEstatusVenta().getEstatusVenta());
                        meta.setLstCalificacionParticipantesConc(DTOE.getCalificacionParticipantes().getLstCalificacionParticipantes());;
                        meta.setArrEstatusCliente(((Solicitud)listaSolicitudes.get(0)).getCliente().getHistoricoEstatusCliente()); 
                        meta.setArrTipificacionesCliente(((Solicitud) listaSolicitudes.get(0)).getCliente().getTipificacionCliente());
                        meta.setDirigidoA(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
                        
                        BigDecimal metaTotal = meta.calcularMeta();
                        //busco sobre ClientesDatosBasicos para recuperar el codigo del cliente
                        try {
                            clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
                            clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(clientesCalificados[i]);
                            
                        } catch (NoResultException nre) {
                            ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", nre);
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        } 
                                    
                        dto = new DTOMetasTipoVenta();
                        dto.setOidCliente(clientesCalificados[i]);
                        dto.setCodigoCliente(clienteDatosBasicosL.getCod_clie());
                        dto.setValorMetas(metaTotal);
                        dto.setImpMontoVenta(totalMonto);
                        dto.setNumUnidadesVendidas(new Integer(totalUnidades));
                        //AGREGADO POR INCIDENCIA 21054 - Cristian Valenzuela - 4/10/2005
                        dto.setValorIncremento(meta.getIncremento());
                        //FIN AGREGADO POR INCIDENCIA 21054
                        
                        UtilidadesLog.debug("DTOMetasTipoVenta: " + dto);
                        
                        dtoLista.getListaMetas().add(dto);
                    }//if estatusClienteValido
                }//if listaSolicitudes                
            } //for sobre: clientesCalificados...
        } //clientesCalificados no nulo....
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaConsultoras(DTOConcurso DTOE):Salida");
        return dtoLista;
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 02/05/2005
     */
     /*
      * Modificado en 2007-01-11 por Rafael Romero
      */
    public DTOListaMetasTipoVenta obtenerMetasTipoVenta(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasTipoVenta(Long oidConcurso):Entrada");
        RecordSet rsMetas = null;
        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;

        DAOMetas daoMetas = new DAOMetas();
        rsMetas = daoMetas.obtenerMetasTipoVentaPorConcurso(oidConcurso);
        
        clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();

        //periodoLH = this.getPeriodoLocalHome();
        

        DTOListaMetasTipoVenta dtoListaMetasTipoVenta = new DTOListaMetasTipoVenta();
        DTOMetasTipoVenta dto = null;
        ArrayList al = new ArrayList();
        
        int totalMetas = rsMetas.getRowCount();
        
        if(rsMetas != null && (totalMetas>0)){
          for(int i = 0; i<totalMetas; i++){
            
            dto = new DTOMetasTipoVenta();
            dto.setOid(new Long(((BigDecimal)rsMetas.getValueAt(i, "OID_META_TIPO_VENTA")).longValue()));
            Object v_impMontoVenta = rsMetas.getValueAt(i, "IMP_MONTO_VENTA");
            if (v_impMontoVenta!=null){
              dto.setImpMontoVenta((BigDecimal)v_impMontoVenta);
            }
            Object v_numUnidVend = rsMetas.getValueAt(i, "NUM_UNID_VEND");
            if (v_numUnidVend!=null){
              dto.setNumUnidadesVendidas(new Integer(((BigDecimal)v_numUnidVend).intValue()));
            }
            
            Object v_valInc = rsMetas.getValueAt(i, "VAL_INCR");
            if (v_valInc!=null){
              dto.setValorIncremento((BigDecimal)v_valInc);
            }
            
            dto.setValorMetas((BigDecimal)rsMetas.getValueAt(i, "VAL_META"));
            dto.setOidCliente(new Long(((BigDecimal)rsMetas.getValueAt(i, "CLIE_OID_CLIE")).longValue()));

            dto.setCodigoCliente((String)rsMetas.getValueAt(i, "COD_CLIE"));
            al.add(dto);

          }
          dtoListaMetasTipoVenta.setListaMetas(al);
          
        }
        
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasTipoVenta(Long oidConcurso):Salida");
        return dtoListaMetasTipoVenta;
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasVentaProyectada
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 31/05/2005 -- Se sobrecarga el metodo con DTOOID
     *                                              para ser invocado desde el cliente
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaSubgerencia(DTOOID oidConcurso)
            throws MareException {
        
        return this.obtenerMetasVentaProyectadaSubgerencia(oidConcurso.getOid());
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasVentaProyectada
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 29/04/2005
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaSubgerencia(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaSubgerencia(Long oidConcurso):Entrada");
        MetasVentaProyectadaSubgerenciaVentaLocal meta = null;
        MetasVentaProyectadaSubgerenciaVentaLocalHome metasVentaProyectadaSubgerenciaVentaLH = null;
        Collection metas = null;
        Iterator i = null;
        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;
        PeriodoLocalHome periodoLH = null;
        PeriodoLocal periodoL = null;

        try {
            UtilidadesLog.debug("antes de obtener home..");
            metasVentaProyectadaSubgerenciaVentaLH = this.getMetasVentaProyectadaSubgerenciaVentaLocalHome();
            metas = metasVentaProyectadaSubgerenciaVentaLH.findByConcurso(oidConcurso);
            clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
            periodoLH = this.getPeriodoLocalHome();
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOListaMetasVentaProyectada dtoListaMetas = new DTOListaMetasVentaProyectada();
        DTOMetasVentaProyectada dtoMetasVentaProy = null;
        ArrayList al = new ArrayList();

        if ((metas != null) && !metas.isEmpty()) {
            i = metas.iterator();

            while (i.hasNext()) {
                meta = (MetasVentaProyectadaSubgerenciaVentaLocal) i.next();
                dtoMetasVentaProy = new DTOMetasVentaProyectada();
                dtoMetasVentaProy.setOid(meta.getOid());
                dtoMetasVentaProy.setOidUA(meta.getSubgerencia());
                dtoMetasVentaProy.setOidPeriodo(meta.getPeriodoCalculado());
                dtoMetasVentaProy.setOidCliente(meta.getCliente());
                dtoMetasVentaProy.setNumActivasIniciales((meta.getActivasIniciales() != null) ? new Long(meta.getActivasIniciales().toString()) : null);
                dtoMetasVentaProy.setNumActivasFinales((meta.getActivasFinales() != null) ? new Long(meta.getActivasFinales().toString()) : null);
                dtoMetasVentaProy.setImpIngreso((meta.getIngresos() != null) ? new BigDecimal(meta.getIngresos().toString()) : null);
                dtoMetasVentaProy.setImpReingreso((meta.getReingresos() != null) ? new BigDecimal(meta.getReingresos().toString()) : null);
                dtoMetasVentaProy.setImpEgresos((meta.getEgresos() != null) ? new BigDecimal(meta.getEgresos().toString()) : null);
                dtoMetasVentaProy.setNumOrdenes((meta.getNumeroOrdenes() != null) ? new Long(meta.getNumeroOrdenes().toString()) : null);
                dtoMetasVentaProy.setNumPedidos((meta.getNumeroPedidos() != null) ? new Long(meta.getNumeroPedidos().toString()) : null);
                dtoMetasVentaProy.setNumUnidadesVendidas((meta.getUnidadesVendidas() != null) ? new Long(meta.getUnidadesVendidas().toString()) : null);
                dtoMetasVentaProy.setNumClientes((meta.getNumeroClientes() != null) ? new Long(meta.getNumeroClientes().toString()) : null);
                dtoMetasVentaProy.setImpVentaEstadisticable(meta.getVentaNetaEstadisticable());
                dtoMetasVentaProy.setImpCapitalizacion(meta.getCapitalizacion());
                dtoMetasVentaProy.setPrecioPromedioUnitario(meta.getPrecioPromedioUnitario());
                dtoMetasVentaProy.setPromedioVentaPedido(meta.getPromedioVentaPedido());
                dtoMetasVentaProy.setPromedioUnidadesPedido(meta.getPromedioUnidadesPedido());
                dtoMetasVentaProy.setPromedioOrdenesPedido(meta.getPromedioOrdenesPedido());
                dtoMetasVentaProy.setImpRetencion(meta.getRetencion());
                dtoMetasVentaProy.setCapitalizacion((meta.getCapitalizacion() != null) ? new Long(meta.getCapitalizacion().toString()) : null);
                dtoMetasVentaProy.setActividad((meta.getActividad() != null) ? new BigDecimal(meta.getActividad().toString()) : null);
                dtoMetasVentaProy.setRetencion((meta.getRetencion() != null) ? new Double(meta.getRetencion().toString()) : null);
                dtoMetasVentaProy.setNumEntregadas(meta.getNumeroEntregadas());
                dtoMetasVentaProy.setNumRecibidas(meta.getNumeroRecibidas());

                try {
                    clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(meta.getCliente());
                    periodoL = periodoLH.findByPrimaryKey(meta.getPeriodoCalculado());
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                //Se hace datosCliente = findByPK (meta.cliente) en la entidad MAE: ClienteDatosBasicos 
                //DTOListaMetasVentaProyectada.listaMetas[i]..codigoCliente = datosCliente.codigoCliente 
                dtoMetasVentaProy.setCodigoCliente(clienteDatosBasicosL.getCod_clie());

                //DTOListaMetasVentaProyectada.listaMetas[i].nombrePeriodo = se obtiene "periodo" 
                //haciendo un findByPK(meta.oidPeriodo) en la entidad Periodo y se obtiene periodo.nombrePeriodo.
                dtoMetasVentaProy.setNombrePeriodo(periodoL.getNombrePeriodo());
                al.add(dtoMetasVentaProy);
            }

            dtoListaMetas.setListaMetas(al);
        }
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaSubgerencia(Long oidConcurso):Salida");
        return dtoListaMetas;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasVentaProyectada
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 31/05/2005 -- Se sobrecarga el metodo con DTOOID
     *                                             para invocarlo desde la capa clente.
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaRegion(DTOOID oidConcurso)
            throws MareException {
        return this.obtenerMetasVentaProyectadaRegion(oidConcurso.getOid());
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaRegion(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaRegion(Long oidConcurso):Entrada");
        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;
        PeriodoLocalHome periodoLH = null;
        PeriodoLocal periodoL = null;
        MetasVentaProyectadaRegionLocalHome metasVentaProyectadaRegionLH = null;
        MetasVentaProyectadaRegionLocal meta = null;
        Collection metas = null;

        try {
            metasVentaProyectadaRegionLH = this.getMetasVentaProyectadaRegionLocalHome();
            metas = metasVentaProyectadaRegionLH.findByConcurso(oidConcurso);
            clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
            periodoLH = this.getPeriodoLocalHome();
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOListaMetasVentaProyectada dtoListaMetas = new DTOListaMetasVentaProyectada();
        DTOMetasVentaProyectada dtoMetasVentaProy = null;
        ArrayList al = new ArrayList();
        Iterator i = null;

        if ((metas != null) && !metas.isEmpty()) {
            i = metas.iterator();

            while (i.hasNext()) {
                meta = (MetasVentaProyectadaRegionLocal) i.next();
                dtoMetasVentaProy = new DTOMetasVentaProyectada();
                dtoMetasVentaProy.setOid(meta.getOid());
                dtoMetasVentaProy.setOidUA(meta.getRegion());
                dtoMetasVentaProy.setOidPeriodo(meta.getPeriodoCalculado());
                dtoMetasVentaProy.setOidCliente(meta.getCliente());
                dtoMetasVentaProy.setNumActivasIniciales((meta.getActivasIniciales() != null) ? new Long(meta.getActivasIniciales().toString()) : null);
                dtoMetasVentaProy.setNumActivasFinales((meta.getActivasFinales() != null) ? new Long(meta.getActivasFinales().toString()) : null);
                dtoMetasVentaProy.setImpIngreso((meta.getIngresos() != null) ? new BigDecimal(meta.getIngresos().toString()) : null);
                dtoMetasVentaProy.setImpReingreso((meta.getReingresos() != null) ? new BigDecimal(meta.getReingresos().toString()) : null);
                dtoMetasVentaProy.setImpEgresos((meta.getEgresos() != null) ? new BigDecimal(meta.getEgresos().toString()) : null);
                dtoMetasVentaProy.setNumOrdenes((meta.getNumeroOrdenes() != null) ? new Long(meta.getNumeroOrdenes().toString()) : null);
                dtoMetasVentaProy.setNumPedidos((meta.getNumeroPedidos() != null) ? new Long(meta.getNumeroPedidos().toString()) : null);
                dtoMetasVentaProy.setNumUnidadesVendidas((meta.getUnidadesVendidas() != null) ? new Long(meta.getUnidadesVendidas().toString()) : null);
                dtoMetasVentaProy.setNumClientes((meta.getNumeroClientes() != null) ? new Long(meta.getNumeroClientes().toString()) : null);
                dtoMetasVentaProy.setImpVentaEstadisticable(meta.getVentaNetaEstadisticable());
                dtoMetasVentaProy.setImpCapitalizacion(meta.getCapitalizacion());
                dtoMetasVentaProy.setPrecioPromedioUnitario(meta.getPrecioPromedioUnitario());
                dtoMetasVentaProy.setPromedioVentaPedido(meta.getPromedioVentaPedido());
                dtoMetasVentaProy.setPromedioUnidadesPedido(meta.getPromedioUnidadesPedido());
                dtoMetasVentaProy.setPromedioOrdenesPedido(meta.getPromedioOrdenesPedido());
                dtoMetasVentaProy.setImpRetencion(meta.getRetencion());
                dtoMetasVentaProy.setCapitalizacion((meta.getCapitalizacion() != null) ? new Long(meta.getCapitalizacion().toString()) : null);
                dtoMetasVentaProy.setActividad((meta.getActividad() != null) ? new BigDecimal(meta.getActividad().toString()) : null);
                dtoMetasVentaProy.setRetencion((meta.getRetencion() != null) ? new Double(meta.getRetencion().toString()) : null);
                dtoMetasVentaProy.setNumEntregadas(meta.getNumeroEntregadas());
                dtoMetasVentaProy.setNumRecibidas(meta.getNumeroRecibidas());

                try {
                    clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(meta.getCliente());
                    periodoL = periodoLH.findByPrimaryKey(meta.getPeriodoCalculado());
                    
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                //Se hace datosCliente = findByPK (meta.cliente) en la entidad MAE: ClienteDatosBasicos 
                //DTOListaMetasVentaProyectada.listaMetas[i]..codigoCliente = datosCliente.codigoCliente 
                dtoMetasVentaProy.setCodigoCliente(clienteDatosBasicosL.getCod_clie());

                //DTOListaMetasVentaProyectada.listaMetas[i].nombrePeriodo = se obtiene "periodo" 
                //haciendo un findByPK(meta.oidPeriodo) en la entidad Periodo y se obtiene periodo.nombrePeriodo.
                dtoMetasVentaProy.setNombrePeriodo(periodoL.getNombrePeriodo());
                al.add(dtoMetasVentaProy);
            }

            dtoListaMetas.setListaMetas(al);
        }
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaRegion(Long oidConcurso):Salida");
        return dtoListaMetas;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 31/05/2005 -- Se sobrecarga el metodo con DTOOID
     *                                             para invocarlo desde la capa cliente.
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaZona(DTOOID oidConcurso)
            throws MareException {
        return this.obtenerMetasVentaProyectadaZona(oidConcurso.getOid());
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaZona(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaZona(Long oidConcurso):Entrada");
        UtilidadesLog.debug("********** obtenerMetasVentaProyectadaZona");

        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;
        PeriodoLocalHome periodoLH = null;
        PeriodoLocal periodoL = null;

        MetasVentaProyectadaZonaLocal meta = null;
        MetasVentaProyectadaZonaLocalHome metasVentaProyectadaZonaLH = null;
        Collection metas = null;

        try {
            UtilidadesLog.debug("********** 1");
            metasVentaProyectadaZonaLH = this.getMetasVentaProyectadaZonaLocalHome();
            UtilidadesLog.debug("********** 2");
            metas = metasVentaProyectadaZonaLH.findByConcurso(oidConcurso);
            UtilidadesLog.debug("********** 3");
            clienteDatosBasicosLH = this.getClienteDatosBasicosLocalHome();
            UtilidadesLog.debug("********** 4");
            periodoLH = this.getPeriodoLocalHome();
            UtilidadesLog.debug("********** 5");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOListaMetasVentaProyectada dtoListaMetas = new DTOListaMetasVentaProyectada();
        DTOMetasVentaProyectada dtoMetasVentaProy = null;
        ArrayList al = new ArrayList();
        Iterator i = null;

        if ((metas != null) && !metas.isEmpty()) {
            i = metas.iterator();

            while (i.hasNext()) {
                meta = (MetasVentaProyectadaZonaLocal) i.next();
                dtoMetasVentaProy = new DTOMetasVentaProyectada();
                dtoMetasVentaProy.setOid(meta.getOid());
                dtoMetasVentaProy.setOidUA(meta.getZona());
                dtoMetasVentaProy.setOidPeriodo(meta.getPeriodoCalculado());
                dtoMetasVentaProy.setOidCliente(meta.getCliente());
                dtoMetasVentaProy.setNumActivasIniciales((meta.getActivasIniciales() != null) ? new Long(meta.getActivasIniciales().toString()) : null);
                dtoMetasVentaProy.setNumActivasFinales((meta.getActivasFinales() != null) ? new Long(meta.getActivasFinales().toString()) : null);
                dtoMetasVentaProy.setImpIngreso((meta.getIngresos() != null) ? new BigDecimal(meta.getIngresos().toString()) : null);
                dtoMetasVentaProy.setImpReingreso((meta.getReingresos() != null) ? new BigDecimal(meta.getReingresos().toString()) : null);
                dtoMetasVentaProy.setImpEgresos((meta.getEgresos() != null) ? new BigDecimal(meta.getEgresos().toString()) : null);
                dtoMetasVentaProy.setNumOrdenes((meta.getNumeroOrdenes() != null) ? new Long(meta.getNumeroOrdenes().toString()) : null);
                dtoMetasVentaProy.setNumPedidos((meta.getNumeroPedidos() != null) ? new Long(meta.getNumeroPedidos().toString()) : null);
                dtoMetasVentaProy.setNumUnidadesVendidas((meta.getUnidadesVendidas() != null) ? new Long(meta.getUnidadesVendidas().toString()) : null);
                dtoMetasVentaProy.setNumClientes((meta.getNumeroClientes() != null) ? new Long(meta.getNumeroClientes().toString()) : null);
                dtoMetasVentaProy.setImpVentaEstadisticable(meta.getVentaNetaEstadisticable());
                dtoMetasVentaProy.setImpCapitalizacion(meta.getCapitalizacion());
                dtoMetasVentaProy.setPrecioPromedioUnitario(meta.getPrecioPromedioUnitario());
                dtoMetasVentaProy.setPromedioVentaPedido(meta.getPromedioVentaPedido());
                dtoMetasVentaProy.setPromedioUnidadesPedido(meta.getPromedioUnidadesPedido());
                dtoMetasVentaProy.setPromedioOrdenesPedido(meta.getPromedioOrdenesPedido());
                dtoMetasVentaProy.setImpRetencion(meta.getRetencion());
                dtoMetasVentaProy.setCapitalizacion((meta.getCapitalizacion() != null) ? new Long(meta.getCapitalizacion().toString()) : null);
                dtoMetasVentaProy.setActividad((meta.getActividad() != null) ? new BigDecimal(meta.getActividad().toString()) : null);
                dtoMetasVentaProy.setRetencion((meta.getRetencion() != null) ? new Double(meta.getRetencion().toString()) : null);
                dtoMetasVentaProy.setNumEntregadas(meta.getNumeroEntregadas());
                dtoMetasVentaProy.setNumRecibidas(meta.getNumeroRecibidas());

                try {
                    clienteDatosBasicosL = clienteDatosBasicosLH.findByPrimaryKey(meta.getCliente());
                    periodoL = periodoLH.findByPrimaryKey(meta.getPeriodoCalculado());
                    
                    
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                //Se hace datosCliente = findByPK (meta.cliente) en la entidad MAE: ClienteDatosBasicos 
                //DTOListaMetasVentaProyectada.listaMetas[i]..codigoCliente = datosCliente.codigoCliente 
                dtoMetasVentaProy.setCodigoCliente(clienteDatosBasicosL.getCod_clie());

                //DTOListaMetasVentaProyectada.listaMetas[i].nombrePeriodo = se obtiene "periodo" 
                //haciendo un findByPK(meta.oidPeriodo) en la entidad Periodo y se obtiene periodo.nombrePeriodo.
                dtoMetasVentaProy.setNombrePeriodo(periodoL.getNombrePeriodo());
                al.add(dtoMetasVentaProy);
            }

            dtoListaMetas.setListaMetas(al);
        }
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasVentaProyectadaZona(Long oidConcurso):Salida");
        return dtoListaMetas;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @param valorIncremento
     * @param listaMetas
     * @param oidConcurso
     * Autor: Julian Rivas
     * 4/6/2005
     */
    public void guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas)
        throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas) - Entrada");

        MetasTipoVentaLocal metasTipoVentaL = null;
        MetasTipoVentaLocalHome metasTipoVentaLH = null;
        BigDecimal valorMetas = null;
        BigDecimal incremento = null;
        BigDecimal importeMontoVenta = null;
        Integer numUnidadesVendidas = null;

        metasTipoVentaLH = this.getMetasTipoVentaLocalHome();
        
        if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
            Iterator listaDTOMetas = listaMetas.getListaMetas().iterator();

            while (listaDTOMetas.hasNext()) {
                DTOMetasTipoVenta dtoMTV = (DTOMetasTipoVenta) listaDTOMetas.next();
                StringBuffer query = new StringBuffer();
                try {
                  query.append(" DELETE INC_METAS_TIPO_VENTA MTV  ");
                  query.append("  WHERE MTV.COPA_OID_PARA_GRAL = " + oidConcurso);
                  query.append("  AND CLIE_OID_CLIE = " + dtoMTV.getOidCliente());
        
                  BelcorpService.getInstance().dbService.executeUpdate( query.toString() );

                }catch (Exception e) {
                    throw new MareException("INSERTAR METAS TIPO VENTA", e );
                }
                
                valorMetas = dtoMTV.getValorMetas() != null?dtoMTV.getValorMetas():new BigDecimal(0);
                importeMontoVenta = dtoMTV.getImpMontoVenta() != null?dtoMTV.getImpMontoVenta():new BigDecimal(0);
                numUnidadesVendidas = dtoMTV.getNumUnidadesVendidas() != null?dtoMTV.getNumUnidadesVendidas():new Integer(0);        
                incremento = dtoMTV.getValorIncremento() != null?dtoMTV.getValorIncremento():new BigDecimal(0);                                   
                
                UtilidadesLog.debug("**** valorMetas " + valorMetas);
                UtilidadesLog.debug("**** importeMontoVenta " + importeMontoVenta);
                UtilidadesLog.debug("**** numUnidadesVendidas " + numUnidadesVendidas);
                UtilidadesLog.debug("**** incremento " + incremento);

                try {
                  metasTipoVentaL = metasTipoVentaLH.create(importeMontoVenta,
                                                          numUnidadesVendidas, incremento, valorMetas, dtoMTV.getOidCliente(),
                                                          oidConcurso);  
                  
             
                } catch (PersistenceException ne) {
                    UtilidadesLog.error("ERROR ", ne);
                    throw new MareException(ne, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }      

            }
        }

        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas) - Salida");
    }


    public void guardarMetasVentaProyectadaSubgerencia(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas, BigDecimal valorIncremento):Salida");
        UtilidadesLog.debug("Entro a MONCalcularMetas --->>> guardarMetasVentaProyectadaSubgerencia");

        MetasVentaProyectadaSubgerenciaVentaLocal metasVentaPL = null;
        MetasVentaProyectadaSubgerenciaVentaLocalHome metasVentaPLH = null;

        PeriodoLocal periodoL = null;
        PeriodoLocalHome periodoLH = null;

        PeriodoCorporativoLocal periodoCorpL = null;
        PeriodoCorporativoLocalHome periodoCorpLH = null;

        try {
            metasVentaPLH = this.getMetasVentaProyectadaSubgerenciaVentaLocalHome();

            Iterator metas = metasVentaPLH.findByConcurso(oidConcurso).iterator();

            //En principio habría que borrar antes en la entidad ResultadosVentaProyectadaSubge, 
            //pero en el paquete INC9 se revisará si debe existir dicha entidad o no (es posible que
            //desaparezca) 
            while (metas.hasNext()) {
                metasVentaPLH.remove((MetasVentaProyectadaSubgerenciaVentaLocal) metas.next());
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
            Iterator listaDTOMetas = listaMetas.getListaMetas().iterator();

            while (listaDTOMetas.hasNext()) {
                DTOMetasVentaProyectada dtoMTV = (DTOMetasVentaProyectada) listaDTOMetas.next();
                UtilidadesLog.debug("dtoMTV :" + dtoMTV);

                try {
                    //Calculamos el año comercial 
                    periodoLH = this.getPeriodoLocalHome();
                    periodoL = periodoLH.findByPrimaryKey(dtoMTV.getOidPeriodo());

                    periodoCorpLH = this.getPeriodoCorporativoLocalHome();
                    periodoCorpL = periodoCorpLH.findByPrimaryKey(periodoL.getOidPeriodoCorporativo());

                    metasVentaPL = metasVentaPLH.create(new Integer(periodoCorpL.getAnio().intValue()),
                                                        new Integer(dtoMTV.getNumActivasIniciales().intValue()),
                                                        new Integer(dtoMTV.getNumActivasFinales().intValue()),
                                                        new Integer(dtoMTV.getImpIngreso().intValue()),
                                                        new Integer(dtoMTV.getImpReingreso().intValue()),
                                                        new Integer(dtoMTV.getImpEgresos().intValue()),
                                                        new Integer(dtoMTV.getNumOrdenes().intValue()),
                                                        new Integer(dtoMTV.getNumPedidos().intValue()),
                                                        new Integer(dtoMTV.getNumUnidadesVendidas().intValue()),
                                                        new Integer(dtoMTV.getNumClientes().intValue()), dtoMTV.getImpVentaEstadisticable(),
                                                        dtoMTV.getOidCliente(), dtoMTV.getOidUA(), oidConcurso, dtoMTV.getOidPeriodo());
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", pe);
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }

                metasVentaPL.setCapitalizacion(new BigDecimal(dtoMTV.getCapitalizacion().longValue()));
                metasVentaPL.setActividad(new BigDecimal(dtoMTV.getActividad().longValue()));
                metasVentaPL.setPrecioPromedioUnitario(dtoMTV.getPrecioPromedioUnitario());
                metasVentaPL.setPromedioVentaPedido(dtoMTV.getPromedioVentaPedido());
                metasVentaPL.setPromedioUnidadesPedido(dtoMTV.getPromedioUnidadesPedido());
                metasVentaPL.setPromedioOrdenesPedido(dtoMTV.getPromedioOrdenesPedido());
                metasVentaPL.setRetencion(new BigDecimal(dtoMTV.getRetencion().doubleValue()));
                metasVentaPL.setNumeroRecibidas(dtoMTV.getNumRecibidas());
                metasVentaPL.setNumeroEntregadas(dtoMTV.getNumEntregadas());
                metasVentaPLH.merge(metasVentaPL);
            }
        }

        UtilidadesLog.debug("Salgo a MONCalcularMetas --->>> guardarMetasVentaProyectadaSubgerencia");
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas, BigDecimal valorIncremento):Salida");
    }

    public void guardarMetasVentaProyectadaRegion(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws MareException {
    
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasVentaProyectadaRegion(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas):Entrada");
        MetasVentaProyectadaRegionLocal metasVentaPL = null;
        MetasVentaProyectadaRegionLocalHome metasVentaPLH = null;

        PeriodoLocal periodoL = null;
        PeriodoLocalHome periodoLH = null;

        PeriodoCorporativoLocal periodoCorpL = null;
        PeriodoCorporativoLocalHome periodoCorpLH = null;

        try {
            metasVentaPLH = this.getMetasVentaProyectadaRegionLocalHome();

            Iterator metas = metasVentaPLH.findByConcurso(oidConcurso).iterator();

            //En principio habría que borrar antes en la entidad ResultadosVentaProyectadaSubge, 
            //pero en el paquete INC9 se revisará si debe existir dicha entidad o no (es posible que
            //desaparezca) 
            while (metas.hasNext()) {
                metasVentaPLH.remove((MetasVentaProyectadaRegionLocal) metas.next());
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
            Iterator listaDTOMetas = listaMetas.getListaMetas().iterator();

            while (listaDTOMetas.hasNext()) {
                DTOMetasVentaProyectada dtoMTV = (DTOMetasVentaProyectada) listaDTOMetas.next();

                try {
                    //Calculamos el año comercial 
                    periodoLH = this.getPeriodoLocalHome();
                    periodoL = periodoLH.findByPrimaryKey(dtoMTV.getOidPeriodo());

                    periodoCorpLH = this.getPeriodoCorporativoLocalHome();
                    periodoCorpL = periodoCorpLH.findByPrimaryKey(periodoL.getOidPeriodoCorporativo());

                    metasVentaPL = metasVentaPLH.create(new Integer(periodoCorpL.getAnio().intValue()),
                                                        new Integer(dtoMTV.getNumActivasIniciales().intValue()),
                                                        new Integer(dtoMTV.getNumActivasFinales().intValue()),
                                                        new Integer(dtoMTV.getImpIngreso().intValue()),
                                                        new Integer(dtoMTV.getImpReingreso().intValue()),
                                                        new Integer(dtoMTV.getImpEgresos().intValue()),
                                                        new Integer(dtoMTV.getNumOrdenes().intValue()),
                                                        new Integer(dtoMTV.getNumPedidos().intValue()),
                                                        new Integer(dtoMTV.getNumUnidadesVendidas().intValue()),
                                                        new Integer(dtoMTV.getNumClientes().intValue()), dtoMTV.getImpVentaEstadisticable(),
                                                        dtoMTV.getOidUA(), dtoMTV.getOidCliente(), oidConcurso, dtoMTV.getOidPeriodo());
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", pe);
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }

                metasVentaPL.setCapitalizacion(new BigDecimal(dtoMTV.getCapitalizacion().longValue()));
                metasVentaPL.setActividad(new BigDecimal(dtoMTV.getActividad().longValue()));
                metasVentaPL.setPrecioPromedioUnitario(dtoMTV.getPrecioPromedioUnitario());
                metasVentaPL.setPromedioVentaPedido(dtoMTV.getPromedioVentaPedido());
                metasVentaPL.setPromedioUnidadesPedido(dtoMTV.getPromedioUnidadesPedido());
                metasVentaPL.setPromedioOrdenesPedido(dtoMTV.getPromedioOrdenesPedido());
                metasVentaPL.setRetencion(new BigDecimal(dtoMTV.getRetencion().doubleValue()));
                metasVentaPL.setNumeroRecibidas(dtoMTV.getNumRecibidas());
                metasVentaPL.setNumeroEntregadas(dtoMTV.getNumEntregadas());
                metasVentaPLH.merge(metasVentaPL);
   
            }
        }
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasVentaProyectadaRegion(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas):Salida");
    }

    public void guardarMetasVentaProyectadaZona(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasVentaProyectadaZona(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas):Entrada");
        MetasVentaProyectadaZonaLocal metasVentaPL = null;
        MetasVentaProyectadaZonaLocalHome metasVentaPLH = null;

        //jrivas 17/6/2005
        //Quitado por INC 18919
        //Calculamos el año comercial     

        /*PeriodoLocal periodoL = null;
        PeriodoLocalHome periodoLH = null;
        PeriodoCorporativoLocal periodoCorpL = null;
        PeriodoCorporativoLocalHome periodoCorpLH = null;*/
        try {
            metasVentaPLH = this.getMetasVentaProyectadaZonaLocalHome();

            Iterator metas = metasVentaPLH.findByConcurso(oidConcurso).iterator();

            //En principio habría que borrar antes en la entidad ResultadosVentaProyectadaSubge, 
            //pero en el paquete INC9 se revisará si debe existir dicha entidad o no (es posible que
            //desaparezca) 
            while (metas.hasNext()) {
                metasVentaPLH.remove((MetasVentaProyectadaZonaLocal) metas.next());
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
            Iterator listaDTOMetas = listaMetas.getListaMetas().iterator();

            while (listaDTOMetas.hasNext()) {
                DTOMetasVentaProyectada dtoMTV = (DTOMetasVentaProyectada) listaDTOMetas.next();

                try {                    
                    metasVentaPL = metasVentaPLH.create(new Integer(dtoMTV.getNumActivasIniciales().intValue()),
                                                        new Integer(dtoMTV.getNumActivasFinales().intValue()),
                                                        new Integer(dtoMTV.getImpIngreso().intValue()),
                                                        new Integer(dtoMTV.getImpReingreso().intValue()),
                                                        new Integer(dtoMTV.getImpEgresos().intValue()),
                                                        new Integer(dtoMTV.getNumOrdenes().intValue()),
                                                        new Integer(dtoMTV.getNumPedidos().intValue()),
                                                        new Integer(dtoMTV.getNumUnidadesVendidas().intValue()),
                                                        new Integer(dtoMTV.getNumClientes().intValue()), dtoMTV.getImpVentaEstadisticable(),
                                                        dtoMTV.getOidUA(), dtoMTV.getOidCliente(), oidConcurso, dtoMTV.getOidPeriodo());
                }
                catch (PersistenceException ne) {
                    UtilidadesLog.error("ERROR ", ne);
                    throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                metasVentaPL.setCapitalizacion(new BigDecimal(dtoMTV.getCapitalizacion().doubleValue()));
                metasVentaPL.setActividad(dtoMTV.getActividad());
                metasVentaPL.setPrecioPromedioUnitario(dtoMTV.getPrecioPromedioUnitario());
                metasVentaPL.setPromedioVentaPedido(dtoMTV.getPromedioVentaPedido());
                metasVentaPL.setPromedioUnidadesPedido(dtoMTV.getPromedioUnidadesPedido());
                metasVentaPL.setPromedioOrdenesPedido(dtoMTV.getPromedioOrdenesPedido());
                metasVentaPL.setRetencion(new BigDecimal(dtoMTV.getRetencion().doubleValue()));
                metasVentaPL.setNumeroRecibidas(dtoMTV.getNumRecibidas());
                metasVentaPL.setNumeroEntregadas(dtoMTV.getNumEntregadas());
                metasVentaPLH.merge(metasVentaPL);
            }
        }
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasVentaProyectadaZona(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas):Salida");
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return DTOListaMetasTipoVenta
       * @param oid (DTOOID)
       * @author Paola Cabrera-- 01/06/2005
       */
    public DTOListaMetasTipoVenta obtenerMetasTipoVenta(DTOOID oid)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasTipoVenta(DTOOID oid):Entrada");
        DTOListaMetasTipoVenta dtoMetasTV = new DTOListaMetasTipoVenta();

        dtoMetasTV = this.obtenerMetasTipoVenta(oid.getOid());
        UtilidadesLog.info("MONCalcularMetasBean.obtenerMetasTipoVenta(DTOOID oid):Salida");
        return dtoMetasTV;
    }

    private Long obtengoOidSecuencia(String nameSec) throws MareException {
        
        SecuenciadorOID secuencer = null;

        return secuencer.obtenerSiguienteValor(nameSec);
    }

    private boolean contenidoEnPeriodosConPedido(ArrayList lista, Long oidPeri)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.contenidoEnPeriodosConPedido(ArrayList lista, Long oidPeri):Entrada");
        boolean resu = false;

        for (int x = 0; x < lista.size(); x++) {
            Long rec = (Long) lista.get(x);

            if (rec.equals(oidPeri)) {
                resu = true;

                break;
            }
        }
        UtilidadesLog.info("MONCalcularMetasBean.contenidoEnPeriodosConPedido(ArrayList lista, Long oidPeri):Salida");
        return resu;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       18/07/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc DBLG500000977
    */
    public Concurso obtenerConcursoValidadorEstatus(ArrayList estatusVentas) throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.obtenerConcursoValidadorEstatus(ArrayList estatusVentas):Entrada");
        
        EstatusVentaConsultoras[] lstEstatusVentasConsultoras = new EstatusVentaConsultoras[estatusVentas.size()];
        Periodo menorPeriodoDesde = null;
        Periodo mayorPeriodoHasta = null;
        DTOPeriodoDesdeHasta dtoDesdeHasta = null;
        DTOEstatusVenta dtoEstatu = null;
        Periodo periodoDesde =  null;
        Periodo periodoHasta = null;
        
        try{          
        
            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoL = null;
            EstatusVentaConsultoras estatusVentaConsultora = null;
            
            int cant = estatusVentas.size();
            
            for(int i=0; i < cant; i++){
                dtoEstatu = (DTOEstatusVenta)estatusVentas.get(i);
                
                // Busca periodo desde
                periodoL = periodoLH.findByPrimaryKey(dtoEstatu.getOidPeriodoDesde());
                
                periodoDesde =  new Periodo();                
                periodoDesde.setOidPeriodo(periodoL.getOid());
                periodoDesde.setFechaDesde(periodoL.getFechainicio());
                periodoDesde.setFechaHasta(periodoL.getFechaFin());
                
                // Busca periodo hasta
                periodoL = periodoLH.findByPrimaryKey(dtoEstatu.getOidPeriodoHasta());
                
                periodoHasta =  new Periodo();                
                periodoHasta.setOidPeriodo(periodoL.getOid());
                periodoHasta.setFechaDesde(periodoL.getFechainicio());
                periodoHasta.setFechaHasta(periodoL.getFechaFin());
                
                estatusVentaConsultora = new EstatusVentaConsultoras();
                estatusVentaConsultora.setOidEstatusCliente(dtoEstatu.getOidEstatusVentaMae());
                estatusVentaConsultora.setPeriodoDesde(periodoDesde);
                estatusVentaConsultora.setPeriodoHasta(periodoHasta);
                
                if(menorPeriodoDesde == null || 
                  (periodoDesde.getFechaDesde().getTime() < menorPeriodoDesde.getFechaDesde().getTime())){
                  
                      menorPeriodoDesde = periodoDesde;
                }
                
                if(mayorPeriodoHasta == null || 
                  (periodoHasta.getFechaHasta().getTime() > mayorPeriodoHasta.getFechaHasta().getTime())){
                  
                      mayorPeriodoHasta = periodoHasta;
                }
                
                UtilidadesLog.debug("estatusVentaConsultora.getOidEstatusCliente(): " + estatusVentaConsultora.getOidEstatusCliente());
                UtilidadesLog.debug("estatusVentaConsultora.getPeriodoDesde(): " + estatusVentaConsultora.getPeriodoDesde());
                UtilidadesLog.debug("estatusVentaConsultora.getPeriodoHasta(): " + estatusVentaConsultora.getPeriodoHasta());

                lstEstatusVentasConsultoras[i] = estatusVentaConsultora;
            }
            
            dtoDesdeHasta = new DTOPeriodoDesdeHasta();
            
            UtilidadesLog.debug("menorPeriodoDesde.getOidPeriodo(): " + menorPeriodoDesde.getOidPeriodo());
            UtilidadesLog.debug("mayorPeriodoHasta.getOidPeriodo(): " + mayorPeriodoHasta.getOidPeriodo());
            
            dtoDesdeHasta.setPeriodoDesde(menorPeriodoDesde.getOidPeriodo());
            dtoDesdeHasta.setPeriodoHasta(mayorPeriodoHasta.getOidPeriodo());
            
            Concurso concurso = new Concurso();
            DAOCalcularMetas daoCalcularMetas = new DAOCalcularMetas();
            
            concurso.setEstatusVentaConsultoras(lstEstatusVentasConsultoras);
            
            ArrayList periodosCalificacion = daoCalcularMetas.obtenerPeriodosCalificacion(dtoDesdeHasta);
            
            concurso.setCronograma(periodosCalificacion); 
            
            UtilidadesLog.debug("concurso: " + concurso);
            
            UtilidadesLog.info("MONCalcularMetasBean.obtenerConcursoValidadorEstatus(ArrayList estatusVentas):Salida");
            return concurso;
            
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        }
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/08/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc DBLG500000222
    */
  public DTOSalida obtenerPrimerUltimoPeriodoAnio(DTOConcurso dtoe) throws MareException {
      UtilidadesLog.info("MONCalcularMetasBean.obtenerPrimerUltimoPeriodoAnio(DTOConcurso dtoe:Entrada");
      
      try {
          PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
          PeriodoLocal periodoL = periodoLH.findByPrimaryKey(dtoe.getParamCalificacion().getOidPeriodoDesde());
        
          PeriodoCorporativoLocalHome periodoCorpLH = this.getPeriodoCorporativoLocalHome();
          PeriodoCorporativoLocal periodoCorpL = periodoCorpLH.findByPrimaryKey(periodoL.getOidPeriodoCorporativo());
          
          DTOCriteriosPeriodo dtoCPeriodo = new DTOCriteriosPeriodo();          
          dtoCPeriodo.setOidPais(periodoL.getOidPais());
          dtoCPeriodo.setMarca(periodoL.getOidMarca());
          dtoCPeriodo.setCanal(periodoL.getOidCanal());
          dtoCPeriodo.setAnio(Integer.valueOf(periodoCorpL.getAnio().toString()));
          
          DAOCRA daoCRA= new DAOCRA();          
          RecordSet rs = daoCRA.obtenerPrimerUltimoPeriodoAnio(dtoCPeriodo);
          
          DTOSalida dtoSalida = new DTOSalida();          
          dtoSalida.setResultado(rs);
          
          UtilidadesLog.info("MONCalcularMetasBean.obtenerPrimerUltimoPeriodoAnio(DTOConcurso dtoe:Salida");
          return dtoSalida;
      
      } catch (NoResultException nre) {
          ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", nre);
          throw new MareException(nre,        
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
      } 
  }


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (BusinessFacadeLocalHome) context.lookup("java:comp/env/BusinessFacadeBATCH");
    }


    private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
    }


    //jrivas 05/01/2007 V-INC-17 Cambio Calculo Metas Performance
    public void calcularMetasTipoVentaConsultorasPerf(DTOConcurso DTOE, String idProc)
            throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaConsultorasPerf(DTOConcurso DTOE, String idProc):Entrada");
        //Se calculan las metas tipo venta para consultoras 
        long comienzo = System.currentTimeMillis();
        DTOPeriodoDesdeHasta dtoDesdeHasta = new DTOPeriodoDesdeHasta();
        DAOCalcularMetas daoCM = new DAOCalcularMetas();
        dtoDesdeHasta.setPeriodoDesde(DTOE.getParamCalificacion().getOidPeriodoDesde());
        dtoDesdeHasta.setPeriodoHasta(DTOE.getParamCalificacion().getOidPeriodoHasta());

        ArrayList periodos = daoCM.obtenerPeriodosCalificacion(dtoDesdeHasta);
        
        //vbongiov -- 18/07/2006 -- inc DBLG500000977
        Concurso concursoValidadorEstatus = 
                this.obtenerConcursoValidadorEstatus(DTOE.getEstatusVenta().getEstatusVenta());        
        
        DTOBusquedaClienteCalificado dtoBusqueda = new DTOBusquedaClienteCalificado();

        dtoBusqueda.setOidPais(DTOE.getOidPais());
        dtoBusqueda.setOidMarca(DTOE.getParamGenerales().getOidMarca());
        dtoBusqueda.setOidCanal(DTOE.getParamGenerales().getOidCanal());
        dtoBusqueda.setIndAmbitoGeograficoCompleto(DTOE.getPlantilla().getIndAmbitoGeografico());
        if (DTOE.getCalificacionParticipantes() != null) {        
            dtoBusqueda.setListaParticipantesCalificacion(DTOE.getCalificacionParticipantes().getLstCalificacionParticipantes());
        }
        if (DTOE.getListaAmbitosGeograficos() != null) {
            dtoBusqueda.setListaAmbitosGeograficos(DTOE.getListaAmbitosGeograficos().getAmbitoGeografico());
        }
        
        Long[] clientesCalificados = daoCM.obtenerClientesCalificados(dtoBusqueda).getOids();
        UtilidadesLog.warn("Clientes Calificados = "+clientesCalificados.length);

        MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String tamanio= (String) mgc.getProperty("application.TamanioSegmentoMETAS");
        String numero = (String) mgc.getProperty("application.NumeroMaximoSegmentosMETAS");
        if ((tamanio == null) || (tamanio.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 500
            this.tamanioSegmento = new Integer(1500);
        } else {
            this.tamanioSegmento = new Integer(tamanio);
        }
        if ((numero == null) || (numero.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 12 (numero de procesadores de ejecucion)
            this.numeroMaximoSegmentos = new Integer(12);
        } else {
            this.numeroMaximoSegmentos = new Integer(numero);
        }    

        int count = 0;
        ArrayList segmento= new ArrayList();
        boolean ejecuta = false;
        int segmentosEjecutandoSimultaneamente = 0;
        
        if (clientesCalificados != null) {
            Long oid;
            int cant = clientesCalificados.length;
            
            for (int i = 0; i < cant;  ) {
                oid = clientesCalificados[i];
                if (count == this.tamanioSegmento.intValue()){
                    count = 0;
                    ejecuta = true;
                }else{
                    segmento.add(oid);
                    count++;
                    i++;
                }
    
                if (ejecuta){
                    ejecucionBatch(segmento, idProc, DTOE, concursoValidadorEstatus, periodos.size());
                    ejecuta = false;
                    segmento= new ArrayList();
                    segmentosEjecutandoSimultaneamente++;
                }
                
                if (segmentosEjecutandoSimultaneamente == numeroMaximoSegmentos.intValue()){
                    try{
                        UtilidadesLog.debug("*** El IDProceso es = "+idProc);
                        this.esperarProcesamiento(idProc);
                    }catch(InterruptedException ie){
                        UtilidadesLog.error("ERROR" , ie);
                        String codigoError = ie.getMessage();
                        throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
                    }    
                    segmentosEjecutandoSimultaneamente= 0;
                    count = 0;
                }
            }
            
            if (segmento.size()>0){
                ejecucionBatch(segmento, idProc, DTOE, concursoValidadorEstatus, periodos.size());
                segmento= new ArrayList();
            } 
            
            try{
                this.esperarProcesamiento(idProc);
            }catch(InterruptedException ie){
                UtilidadesLog.error("ERROR ", ie);
                String codigoError = ie.getMessage();
                throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
            }

        }

        UtilidadesLog.warn("calcularMetasTipoVentaConsultoras TOTAL -->> " + (System.currentTimeMillis() - comienzo));
        UtilidadesLog.info("MONCalcularMetasBean.calcularMetasTipoVentaConsultorasPerf(DTOConcurso DTOE, String idProc):Salida");
    }
    
    //jrivas 05/01/2007 V-INC-17 Cambio Calculo Metas Performance
    private void ejecucionBatch(ArrayList listaSegmentos, String IDProceso, DTOConcurso dto, Concurso concurso, int cantPeri) throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Entrada");
    
        UtilidadesLog.warn(" tamanio de segmento = "+listaSegmentos.size());
        DTOCalculoMeta dtoSegmento = new DTOCalculoMeta();
        dtoSegmento.setCliente(listaSegmentos);
        dtoSegmento.setDTOConcurso(dto);
        dtoSegmento.setCantPeriodo(cantPeri);
        dtoSegmento.setConcurso(concurso);
        IMareDTO DTOSegmento = dtoSegmento;
        DTOSubBatch dtoSubBatch = new DTOSubBatch("INC_CALC_METAS_",IDProceso,ctx.getCallerPrincipal().getName() ,new MareBusinessID("INCProcesarSegmentoCalcularMetas"),DTOSegmento);
        try{
            BatchUtil.executeMLN( dtoSubBatch, new MareBusinessID( "INCPROCESOSBATCH" ));
        }catch(RemoteException re){
            UtilidadesLog.error("ERROR ", re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
        }
        UtilidadesLog.info("MONCalcularMetasBean.ejecucionBatch(ArrayList listaSegmentos, String IDProceso): Salida");
    }

    //jrivas 05/01/2007 V-INC-17 Cambio Calculo Metas Performance
    private void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException {
        UtilidadesLog.info("MONCalcularMetasBean.esperarProcesamiento(String codigoProceso): Entrada");
        BatchUtil.esperarHijos(codigoProceso);	
        UtilidadesLog.info("MONCalcularMetasBean.esperarProcesamiento(String codigoProceso): Salida");
    }    

   
    //jrivas 05/01/2007 V-INC-17 Cambio Calculo Metas Performance
    public DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException{
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        ArrayList arrConcCierre;
        DAOConcursos daoConcursos = new DAOConcursos();
        BigDecimal totalMonto = new BigDecimal(0);
        int totalUnidades = 0;
        Solicitud sol= null;
        Periodo periodoCalculoAux = null;
        boolean estatusClienteValido = false;
        ArrayList periodosConPedido = new ArrayList();
        ArrayList listaSolicitudes = new ArrayList();
        DAOCalcularMetas daoCM = new DAOCalcularMetas();        
        DAOSolicitudes daoS = new DAOSolicitudes();
        DTOMetasTipoVenta dto = new DTOMetasTipoVenta();
        Cliente cliente = null;
        Long oidCliente = null;
        Solicitud solicitud = null;

        if (dtoonline instanceof DTOCalculoMeta) {
            DTOCalculoMeta segmento = (DTOCalculoMeta)dtoonline;
            ArrayList clientes = segmento.getCliente();
            DTOConcurso conc = segmento.getDTOConcurso();
            Concurso concursoValidadorEstatus = segmento.getConcurso();
            int cantPeri = segmento.getCantPeriodo();
            DTOListaMetasTipoVenta dtoListaMetasTipoVenta = new DTOListaMetasTipoVenta();
            dtoListaMetasTipoVenta.setListaMetas(new ArrayList());
            GestorMensajesMetas gestor = new GestorMensajesMetas();
            DTOBuzonMensajes buzonAux = new DTOBuzonMensajes();
            gestor.obtenerDatosMSG(conc.getParamCalificacion().getOidPeriodoDesde(),
                                   conc.getParamCalificacion().getOidPeriodoHasta(), 
                                   conc.getParamGenerales().getOid(), buzonAux);

            for (int i = 0; (i < clientes.size()); i++) {
                long aa = System.currentTimeMillis();
                totalMonto = new BigDecimal(0);
                totalUnidades = 0;  
                periodosConPedido = new ArrayList();
                listaSolicitudes = new ArrayList();
           
                long b = System.currentTimeMillis();                
                oidCliente = (Long)clientes.get(i);
                cliente = new Cliente();
                
                cliente.setOidCliente(oidCliente);
                daoS.obtenerTipificacionesCliente(cliente);
                daoS.obtenerHistoricoEstatusCliente(cliente);

                
                listaSolicitudes = daoCM.obtenerSolicitudesMetas(oidCliente, conc.getParamCalificacion().getOidPeriodoDesde(),
                                                       conc.getParamCalificacion().getOidPeriodoHasta(), conc.getParamCalificacion().getIndAnulaciones(),
                                                       conc.getParamCalificacion().getIndDevoluciones(), cliente);
                                                       
                UtilidadesLog.debug("listaSolicitudes: " + listaSolicitudes);
                UtilidadesLog.warn("Buscar Soli BB -->> " + (System.currentTimeMillis() - b) + " Solicitudes = " + listaSolicitudes.size());


                if (listaSolicitudes != null && listaSolicitudes.size() > 0) {
                    // vbongiov -- 18/07/2006 -- inc DBLG500000977
                    // Valida estatus del cliente
                    sol= (Solicitud)listaSolicitudes.get(0);
                    /*periodoCalculoAux = sol.getPeriodoCalculo();
                    sol.setPeriodoCalculo(null);*/
                    estatusClienteValido = concursoValidadorEstatus.validarEstatusCliente(sol);
                    //sol.setPeriodoCalculo(periodoCalculoAux);                   

                    if (estatusClienteValido) {
                        //Llamar al método que pasa las posiciones de las solicitudes y todos los 
                        //objetos del motor de reglas y actualiza un indicador para posteriormente 
                        //calcular las metas 
                        Concurso concurso = new Concurso();
        
                        if (conc.getParamGenerales().getOid() != null) {
                            concurso.setOidConcurso(conc.getParamGenerales().getOid());
                        } else {
                            //siempre existiria....
                            concurso.setOidConcurso(new Long(9999999999L));
                        }
        
                        if (conc.getParamGenerales().getOidDirigidoA() == ConstantesINC.OID_DIRIGIDO_A_GERENTE) {
                            concurso.setBaseCalculo(conc.getParamGerentes().getOidBaseCalculo());
                        } else {
                            concurso.setBaseCalculo(conc.getParamConsultoras().getOidBaseCalculo());
                        }
        
                        if(concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_UNIDADES)){
                            concurso.setTipoVenta(ConstantesINC.TIPO_VENTA_CATALOGO);
                        } else {
                            concurso.setTipoVenta(conc.getParamCalificacion().getOidTipoVentaHistorica());
                        }
        
                        if (conc.getParamCalificacion().getIndFaltantesNoAnunciados() != null) {
                            concurso.setIndFaltantesAnunciados(conc.getParamCalificacion().getIndFaltantesNoAnunciados().booleanValue());
                        } else {
                            concurso.setIndFaltantesAnunciados(false);
                        }
        
                        concurso.setProductosCalificar(new ListaProductos());
                        concurso.getProductosCalificar().setProductos(new ArrayList());
        
                        concurso.setProductosExcluirCalificar(new ListaProductos());
                        concurso.getProductosExcluirCalificar().setProductos(new ArrayList());
        
                        if (conc.getProductosACalificar() != null && conc.getProductosACalificar().getLstProductos() != null) {
                            for (int k = 0; k < conc.getProductosACalificar().getLstProductos().size(); k++) {
                                DTOProdu registro = (DTOProdu) conc.getProductosACalificar().getLstProductos().get(k);
            
                                /*
                                 * INC 22402 - dmorello, 16/01/2006
                                 * El bloque if (registro.getOidProducto != null) { ... } else { ... },
                                 * que originalmente estaba "suelto" dentro de este FOR, pasa a ubicarse
                                 * en el ELSE del siguiente bloque IF, que pregunta
                                 * if (registro.getOidMarcaProducto() != null)
                                 * a fin de adecuarse al diseño.
                                 */
                                if (registro.getOidMarcaProducto() != null) {
                                    PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
            
                                    prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                                    prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                                    prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueNegocio);
                                } else if (registro.getOidProducto() != null) {
                                    PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
            
                                    prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                    prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueProducto);
                                } else {
                                    PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
            
                                    prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosCalificar().getProductos().add(prdBloqueOferta);
                                }
                            } //fin ciclo sobre: DTOE.getProductosACalificar().getLstProductos()
                        }
        
                        if (conc.getProductosExcluidosCalificacion() != null && conc.getProductosExcluidosCalificacion().getLstProductos() != null) {
                            for (int l = 0; l < conc.getProductosExcluidosCalificacion().getLstProductos().size(); l++) {
                                DTOProdu registro = (DTOProdu) conc.getProductosExcluidosCalificacion().getLstProductos().get(l);
            
                                /*
                                 * dmorello, 16/01/2006
                                 * El bloque if (registro.getOidProducto() != null) {...} else {...}
                                 * deja de estar suelto, y pasa al ELSE del siguiente if...
                                 */
                                if (registro.getOidMarcaProducto() != null) {
                                    PrdBloqueNegocio prdBloqueNegocio = new PrdBloqueNegocio();
            
                                    prdBloqueNegocio.setOidMarcaProducto(registro.getOidMarcaProducto());
                                    prdBloqueNegocio.setOidUnidadNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidNegocio(registro.getOidUnidadNegocio());
                                    prdBloqueNegocio.setOidGenerico(registro.getOidGenerico());
                                    prdBloqueNegocio.setOidSuperGenerico(registro.getOidSupergenerico());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueNegocio);
                                } else if (registro.getOidProducto() != null) {
                                    PrdBloqueProducto prdBloqueProducto = new PrdBloqueProducto();
            
                                    prdBloqueProducto.setOidProducto(registro.getOidProducto());
                                    prdBloqueProducto.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueProducto.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueProducto);
                                } else {
                                    PrdBloqueOferta prdBloqueOferta = new PrdBloqueOferta();
            
                                    prdBloqueOferta.setOidTipoOferta(registro.getOidTipoOferta());
                                    prdBloqueOferta.setOidCicloVida(registro.getOidCicloVida());
            
                                    concurso.getProductosExcluirCalificar().getProductos().add(prdBloqueOferta);
                                }
                            } //fin ciclo sobre: DTOE.getProductosExcluidosCalificacion().getLstProductos()
                        }
        
                        //se llama al método 
                        //MotorCalcularMetas.evaluarSolicitudesParaMetas(listaSolicitudes....
                        MotorCalcularMetas motor = new MotorCalcularMetas();
                        long d = System.currentTimeMillis();
                        motor.evaluarSolicitudesParaMetas(listaSolicitudes, concurso);
                        
                        UtilidadesLog.debug("listaSolicitudes luego de " 
                            + "evaluarSolicitudesParaMetas():" + listaSolicitudes);
                        UtilidadesLog.warn("Motor -->> " + (System.currentTimeMillis() - d));
                        UtilidadesLog.debug("listaSolicitudes " + listaSolicitudes);
                        if (listaSolicitudes != null) {
                            for (int w = 0; w < listaSolicitudes.size(); w++) {
                                solicitud = (Solicitud) listaSolicitudes.get(w);
                                UtilidadesLog.debug("solicitud " + solicitud + " - " + solicitud.getSolicitudConcurso(concurso.getOidConcurso()));
                                UtilidadesLog.debug("Monto: " + solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                                totalMonto = totalMonto.add(solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoCalificacion());
                                totalUnidades = (totalUnidades +
                                                solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getUnidadesCalificacion().intValue());
                                if (!contenidoEnPeriodosConPedido(periodosConPedido, solicitud.getPeriodo().getOidPeriodo())) {
                                    periodosConPedido.add(solicitud.getPeriodo().getOidPeriodo());
                                }
                            }
                        }
                        
                        UtilidadesLog.debug("totalMonto ..... " + totalMonto);
                        UtilidadesLog.debug("totalUnidades ..... " + totalUnidades);              
        
                        long f = System.currentTimeMillis();
                        //Crear un objeto Meta....
                        Meta meta = new Meta();
                        meta.setMonto(totalMonto);
                        meta.setUnidades(new Integer(totalUnidades));
                        meta.setBaseCalculo(concurso.getBaseCalculo());
                        meta.setTipoIncremento(conc.getParamCalificacion().getOidTipoIncremento());
                        meta.setTablaIncremento(conc.getParamCalificacion().getLstIncrementosPorRango());
                        meta.setFormaCalculo(conc.getParamCalificacion().getOidFormaCalculo());
                        meta.setNumPeriodoPedido(new Integer(periodosConPedido.size()));
                        meta.setNumPeriodoCalificacion(new Integer(cantPeri));
        
                        //jrivas 20/7/2005
                        //Inc 19992
                        meta.setIncremento(conc.getParamCalificacion().getValorIncremento());
        
                        // o incrementoPorNiveles por tablaIncremento...        
                        if ((meta.getTablaIncremento() != null) && (meta.getTablaIncremento().size() > 0)) {
                            meta.setIncrementoPorNiveles(Boolean.TRUE);
                        }
        
                        //jrivas 26-5-2006 DBLG500000255
                        meta.setLstEstatusVentaConc(conc.getEstatusVenta().getEstatusVenta());
                        meta.setLstCalificacionParticipantesConc(conc.getCalificacionParticipantes().getLstCalificacionParticipantes());;
                        meta.setArrEstatusCliente(((Solicitud)listaSolicitudes.get(0)).getCliente().getHistoricoEstatusCliente()); 
                        meta.setArrTipificacionesCliente(((Solicitud) listaSolicitudes.get(0)).getCliente().getTipificacionCliente());
                        meta.setDirigidoA(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
                        
                        BigDecimal metaTotal = meta.calcularMeta();
                        UtilidadesLog.warn("Calcular Meta -->> " + (System.currentTimeMillis() - f));
                        
                        dto = new DTOMetasTipoVenta();
                        dto.setOidCliente(oidCliente);
                        //dto.setCodigoCliente(clienteDatosBasicosL.getCod_clie());
                        dto.setValorMetas(metaTotal);
                        dto.setImpMontoVenta(totalMonto);
                        dto.setNumUnidadesVendidas(new Integer(totalUnidades));
                        //AGREGADO POR INCIDENCIA 21054 - Cristian Valenzuela - 4/10/2005
                        dto.setValorIncremento(meta.getIncremento());
                        //FIN AGREGADO POR INCIDENCIA 21054
                        
                        dto.setOidConcurso(conc.getParamGenerales().getOid());
                        
                        //  Agregado por HRCS - Fecha 06/07/2007 - Incidencia Sicc20070287
                        dto.setDpNombre1( sol.getCliente().getDatosPersonales().getNombre1() );
                        dto.setDpApellido1( sol.getCliente().getDatosPersonales().getApellido1() );
                        dto.setDpCodCliente( sol.getCliente().getDatosPersonales().getCodCliente() );
                        dto.setDpCodZona( sol.getCliente().getDatosPersonales().getCodZona() );
                        dto.setDpCodTerritorio( sol.getCliente().getDatosPersonales().getCodTerritorio() );
                        
                        UtilidadesLog.debug("DTOMetasTipoVenta: " + dto);
                        
                        dtoListaMetasTipoVenta.getListaMetas().add(dto);
                    } else {
                        UtilidadesLog.warn("NO VALIDO POR ESTATUS " + clientes.get(i));    
                    }
                }
                UtilidadesLog.warn("X CLIENTE -->> " + (System.currentTimeMillis() - aa));
            }
            
            UtilidadesLog.warn("A guardar : " + dtoListaMetasTipoVenta.getListaMetas().size());
            
            //this.guardarMetasTipoVenta(conc.getParamGenerales().getOid(), dtoListaMetasTipoVenta);
            this.guardarMetasTipoVentaMasivo(dtoListaMetasTipoVenta);
            
            //jrivas SICC20070287 06/06/2007
            if(conc.getParamGenerales().getIndActivo().booleanValue() &&
            conc.getParamCalificacion()!= null &&
            conc.getParamCalificacion().getIndComunicacion()!=null &&
            conc.getParamCalificacion().getIndComunicacion().booleanValue()) {
                solicitud.getIncremento();
                gestor.enviarMSGCalificacionMetasVentaPerf(dtoListaMetasTipoVenta, conc, buzonAux);                
            }           
            return new DTOSalidaBatch(0,"Ejecucion MONCalcularMetas:procesarSegmento completada");  
        } else {
            throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ""));
        }
    }

    private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");
    }

    private MONCalcularMetasLocalHome getMONCalcularMetasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCalcularMetasLocalHome)context.lookup("java:comp/env/ejb/local/MONCalcularMetas");
    }
    
    //jrivas 19/01/2007 V-INC-17 Cambio Calculo Metas Performance
    private void guardarMetasTipoVentaMasivo(DTOListaMetasTipoVenta listaMetas) throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVentaMasivo(DTOListaMetasTipoVenta listaMetas) - Entrada");

        BigDecimal valorMetas = null;
        BigDecimal incremento = null;
        BigDecimal importeMontoVenta = null;
        Integer numUnidadesVendidas = null;
        StringBuffer insertMasivo = new StringBuffer();

        if ((listaMetas != null) && (listaMetas.getListaMetas() != null)) {
            Iterator listaDTOMetas = listaMetas.getListaMetas().iterator();

            while (listaDTOMetas.hasNext()) {
                DTOMetasTipoVenta dtoMTV = (DTOMetasTipoVenta) listaDTOMetas.next();
                StringBuffer query = new StringBuffer();
                
                valorMetas = dtoMTV.getValorMetas() != null?dtoMTV.getValorMetas():new BigDecimal(0);
                importeMontoVenta = dtoMTV.getImpMontoVenta() != null?dtoMTV.getImpMontoVenta():new BigDecimal(0);
                numUnidadesVendidas = dtoMTV.getNumUnidadesVendidas() != null?dtoMTV.getNumUnidadesVendidas():new Integer(0);        
                incremento = dtoMTV.getValorIncremento() != null?dtoMTV.getValorIncremento():new BigDecimal(0);                                   
                
                UtilidadesLog.debug("**** valorMetas " + valorMetas);
                UtilidadesLog.debug("**** importeMontoVenta " + importeMontoVenta);
                UtilidadesLog.debug("**** numUnidadesVendidas " + numUnidadesVendidas);
                UtilidadesLog.debug("**** incremento " + incremento);

                //Borro el registro, por si existe.
                query.append("DELETE INC_METAS_TIPO_VENTA ");
                query.append("WHERE COPA_OID_PARA_GRAL = " + dtoMTV.getOidConcurso());
                query.append(" AND CLIE_OID_CLIE = " + dtoMTV.getOidCliente());
                query.append(";");
                
                //Lo inserto.
                query.append("INSERT INTO INC_METAS_TIPO_VENTA ( OID_META_TIPO_VENTA, IMP_MONTO_VENTA, ");
                query.append("NUM_UNID_VEND, VAL_INCR, VAL_META, CLIE_OID_CLIE, COPA_OID_PARA_GRAL ");
                query.append(") VALUES (");
                query.append(" INC_METV_SEQ.nextval, " + importeMontoVenta);
                query.append(", " + numUnidadesVendidas);
                query.append(", " + incremento);
                query.append(", " + valorMetas);
                query.append(", " + dtoMTV.getOidCliente());
                query.append(", " + dtoMTV.getOidConcurso() + " )");
                query.append(";");

                insertMasivo.append(query);
            }
            
            BelcorpService bs;
            try {
                bs = BelcorpService.getInstance();
            } catch (MareException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            try {
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insertMasivo.toString());
            } catch (Exception e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Error en guardarMetasTipoVentaMasivo ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }            
        }
        UtilidadesLog.info("MONCalcularMetasBean.guardarMetasTipoVentaMasivo(DTOListaMetasTipoVenta listaMetas) - Salida");
    }    
    
    /**
     * Metodo para obtener los registros para el paginado de la consulta de metas tipo venta
     * @throws es.indra.mare.common.exception.MareException
     * @return DTO con la informacion de registros para el paginado
     * @param dtoe con informacion para obtener los registros para el paginado
     */
    public DTOSalida consultarMetasTipoVenta(DTOMetTipVtaPag dtoe) throws MareException {
		UtilidadesLog.info("MONCalcularMetas.consultarMetasTipoVenta(DTOMetTipVtaPag dtoe): Entrada");
		DTOSalida dtoSalida=new DTOSalida();
		DAOMetas daoMetas= new DAOMetas();
		dtoSalida=daoMetas.consultaMetasTipoVenta(dtoe);
		RecordSet rs=new RecordSet();
		rs=dtoSalida.getResultado();
		 if (rs.esVacio()) {
			UtilidadesLog.debug("****obtenerMetasTipoVenta: no hay datos ");				
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONCalcularMetas.consultarMetasTipoVenta(DTOMetTipVtaPag dtoe): Salida");
		return dtoSalida;
    }

    /**
     * Metodo para verificar que existen regstros de metas tipo venta
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOListaMetasTipoVenta con indicador de si hay metas tipo venta
     * @param oidConcurso OID del concurso
     */
    public DTOListaMetasTipoVenta existenMetasTipoVenta(Long oidConcurso) throws MareException {
		UtilidadesLog.info("MONCalcularMetas.existenMetasTipoVenta(Long oidConcurso): Entrada --- oidConcurso["+oidConcurso+"]");
        DTOListaMetasTipoVenta retorno = new DTOListaMetasTipoVenta();
        ArrayList arr = new ArrayList();
        
        DAOMetas daoMetas= new DAOMetas();
        Boolean existen = daoMetas.existenMetasTipoVenta(oidConcurso);
        if(existen.booleanValue()){
            // Se agrega un objeto a la lisata como indicador de que hay Metas Tipo Venta
            arr.add(Boolean.TRUE);
        }
        
        retorno.setListaMetas(arr);
        UtilidadesLog.info("MONCalcularMetas.existenMetasTipoVenta(Long oidConcurso): Salida --- existen["+existen+"]");
        return retorno;
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
      }

    private PeriodoLocalHome getPeriodoLocalHome(){
        return new PeriodoLocalHome();
    }
    
    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
           return new PeriodoCorporativoLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private MetasVentaProyectadaSubgerenciaVentaLocalHome getMetasVentaProyectadaSubgerenciaVentaLocalHome() {
            return new MetasVentaProyectadaSubgerenciaVentaLocalHome();
    }

    private MetasVentaProyectadaRegionLocalHome getMetasVentaProyectadaRegionLocalHome() {
            return new MetasVentaProyectadaRegionLocalHome();
    }

    private MetasVentaProyectadaZonaLocalHome getMetasVentaProyectadaZonaLocalHome() {
            return new MetasVentaProyectadaZonaLocalHome();
    }

    private MetasTipoVentaLocalHome getMetasTipoVentaLocalHome() {
            return new MetasTipoVentaLocalHome();
    }



}
    
        
        
        


