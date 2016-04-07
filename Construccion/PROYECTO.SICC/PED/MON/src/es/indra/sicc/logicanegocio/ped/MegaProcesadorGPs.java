package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.fac.DAOSolicitudCabecera;
import es.indra.sicc.logicanegocio.fac.MONFacturacionLocal;
import es.indra.sicc.logicanegocio.fac.MONFacturacionLocalHome;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICC;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICCHome;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICCLocal;
import es.indra.sicc.logicanegocio.fac.MONImpresionSICCLocalHome;
import es.indra.sicc.logicanegocio.fac.MONTratamientosContables;
import es.indra.sicc.logicanegocio.fac.MONTratamientosContablesHome;
import es.indra.sicc.logicanegocio.fac.MONTratamientosContablesLocal;
import es.indra.sicc.logicanegocio.fac.MONTratamientosContablesLocalHome;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantes;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesHome;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesLocal;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesLocalHome;
import es.indra.sicc.logicanegocio.inc.MONIncentivos;
import es.indra.sicc.logicanegocio.inc.MONIncentivosHome;
import es.indra.sicc.logicanegocio.inc.MONIncentivosLocal;
import es.indra.sicc.logicanegocio.inc.MONIncentivosLocalHome;
import es.indra.sicc.logicanegocio.inc.MONPremiacion;
import es.indra.sicc.logicanegocio.inc.MONPremiacionHome;
import es.indra.sicc.logicanegocio.inc.MONPremiacionLocal;
import es.indra.sicc.logicanegocio.inc.MONPremiacionLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.mav.MONEnvioAgregadosBatchLocalHome;
import es.indra.sicc.logicanegocio.mav.MONEnvioAgregadosBatchLocal;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoLocal;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoLocalHome;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;

import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MegaProcesadorGPs {
    
    private static Character indicadorBalanceoAreaChequeo = null;
    public static Hashtable solicitudesConcursoEnEjecucion = null;
    private static Long numeroDecimales = null;
    private UtilidadesLog log = new UtilidadesLog();
    
    public MegaProcesadorGPs(){
        if (solicitudesConcursoEnEjecucion == null){
            solicitudesConcursoEnEjecucion = new Hashtable();
        }        
    }
    
    public MareDTO ejecutarGP2Y4(DTOSolicitudValidacion dtoin, ArrayList listaProc, Boolean online) throws MareException{
        MONPEDValidacionLocal monPedValidacion = null;
        MONIncentivosLocal monIncentivos = null;
        MONPremiacionLocal monPremiacion = null;
        MONBolsaFaltantesLocal monBolsaFaltantes = null;
        MONValidacionCuadreOfertasLocal monPedCuadre = null;
        MONReversionCuadreOfertasLocal monRevCuadre = null;
        MONEnvioAgregadosBatchLocal monEnvAgre = null;
        try{
            monPedValidacion = getMONPEDValidacionLocalHome().create();
            monIncentivos = getMONIncentivosLocalHome().create();
            monPremiacion = getMONPremiacionLocalHome().create();
            monBolsaFaltantes = getMONBolsaFaltantesLocalHome().create();
            monPedCuadre = getMONValidacionCuadreOfertasLocalHome().create();
            monRevCuadre = getMONReversionCuadreOfertasLocalHome().create();
            monEnvAgre = getMONEnvioAgregadosBatchLocalHome().create();
        }catch (NamingException e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (CreateException e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Long ultEstado = null;
        MareDTO ultResu   = new MareDTO();
        Long ultOidProceso = null;
        DTOEstatusSolicitud dtoESResu = new DTOEstatusSolicitud();
        try{
            if (dtoin.getNumDecimales() == null) {
                if (numeroDecimales == null){
                    MonedaLocalHome mlocalHome = new MonedaLocalHome();
                    PaisLocalHome plocalHome = new PaisLocalHome();
                    if (dtoin.getOidMoneda() != null) {
                        MonedaLocal mL = mlocalHome.findByPrimaryKey(dtoin.getOidMoneda());
                        dtoin.setNumDecimales( new Integer(mL.getNumDeci().intValue()) );
                        numeroDecimales = mL.getNumDeci();
                    } else {
                        PaisLocal pL = plocalHome.findByPrimaryKey(dtoin.getOidPais());
                        MonedaLocal mL = mlocalHome.findByPrimaryKey(pL.getMone_oid_mone());
                        numeroDecimales = mL.getNumDeci();
                        dtoin.setNumDecimales( new Integer(mL.getNumDeci().intValue()) );
                    }
                }else{
                    dtoin.setNumDecimales( new Integer(numeroDecimales.intValue()));
                }
            }      
            for(int i = 0; i < listaProc.size(); i++) {
                DTOProceso elemDTOProc = (DTOProceso) listaProc.get(i);
                String bId = elemDTOProc.getBusinessID();
                dtoin.setProceso(elemDTOProc);
                long comienzo = System.currentTimeMillis();
                if (elemDTOProc.getCodProceso().equals(ConstantesPED.COD_PROCESO_NULO)) {                        
                    ultEstado = ConstantesPED.ESTADO_SOLICITUD_VALIDADO;
                    ultOidProceso = elemDTOProc.getOidProceso();
                } else {
                    DTOEstatusSolicitud dtoES = null;
                    if ("PEDRecuperacionObligatoriaMismoPeriodo".equals(bId)){
                        dtoES = monPedValidacion.recuperacionObligatoriaMismoPeriodo(dtoin);
                    }else
                    if ("PEDRecuperacionVoluntaria".equals(bId)){
                        dtoES = monPedValidacion.recuperacionVoluntaria(dtoin);
                    }else
                    if ("PEDRecuperacionObligatoria".equals(bId)){
                        dtoES = monPedValidacion.recuperacionObligatoria(dtoin);
                    }else
                    if ("PEDValidarLimiteDeVenta".equals(bId)){
                        dtoES = monPedValidacion.validarLimiteVenta(dtoin);
                    }else
                    if ("PEDValidarPreciosEnMatriz".equals(bId)){
                        dtoES = monPedValidacion.validarPreciosMatriz(dtoin);
                    }else
                    if ("PEDValidarPreciosEnMaestroDeProductos".equals(bId)){
                        dtoES = monPedValidacion.validarPreciosMaestroProducto(dtoin);
                    }else
                    if ("PEDValidarAgregados".equals(bId)){
                        dtoES = monEnvAgre.validarAgregados(dtoin);//monPedValidacion.validarAgregados(dtoin);
                    }else
                    if ("PEDValidarCuadreOfertas".equals(bId)){
                        dtoES = monPedCuadre.validarCuadreOfertas(dtoin);
                    }else
                    if ("PEDValidarDescuentos".equals(bId)){
                        dtoES = monPedValidacion.validarDescuento(dtoin);
                    }else
                    if ("PEDValidarMontoMinimo".equals(bId)){
                        dtoES = monPedValidacion.validarMontoMinimo(dtoin);
                    }else
                    if ("PEDCalcularTotales".equals(bId)){
                        dtoES = monPedValidacion.calcularTotales(dtoin);
                    }else
                    if ("PEDRecuperarDatosAnulaciones".equals(bId)){
                        dtoES = monPedValidacion.recuperarDatosAnulaciones(dtoin);
                    }else
                    if ("PEDValidarFlete".equals(bId)){
                        dtoES = monPedValidacion.validarFlete(dtoin);
                    }else
                    if ("PEDValidarLineaCredito".equals(bId)){
                        dtoES = monPedValidacion.validarLineaCredito(dtoin);
                    }else                
                    if ("PEDValidarControlStock".equals(bId)){
                        dtoES = monPedValidacion.validarControlStock(dtoin);
                    }else
                    if ("PEDValidarControlLiquidacion".equals(bId)){
                        dtoES = monPedValidacion.validarControlLiquidacion(dtoin);
                    }else
                    if ("PEDValidarAsignacionStock".equals(bId)){
                        dtoES =  monPedValidacion.validarAsignacionStock(dtoin);
                    }else
                    if ("PEDGenerarMensajeDeFaltantesAnunciados".equals(bId)){
                        dtoES = monPedValidacion.generarMensajesFaltantesAnunciados(dtoin);
                    }else
                    if ("PEDCalcularPuntajesSolicitudes".equals(bId)){
                        dtoES = monIncentivos.calcularPuntajeMontoUnidades(dtoin);
                    }else
                    if ("PEDCalcularPuntajesProgramaNuevas".equals(bId)){
                        dtoES = monIncentivos.calcularPuntajeProgramaNuevas(dtoin);
                    }else
                    if ("PEDCalcularPuntajesNumeroPedidos".equals(bId)){
                        dtoES = monIncentivos.calcularPuntajeNumeroPedidos(dtoin);
                    }else
                    if ("PEDCalcularPuntajesRecomendadas".equals(bId)){
                        dtoES = monIncentivos.calcularPuntajeRecomendacion(dtoin);
                    }else
                    if ("PEDTratarAnulaciones".equals(bId)){
                        dtoES = monIncentivos.anularSolicitud(dtoin);
                    }else
                    if ("PEDAplicarRequisitosDePremiacionConsultoras".equals(bId)){
                        dtoES = monPremiacion.premiarPorSolicitud(dtoin);
                    }else
                    if ("PEDGenerarSolicitudBolsaFaltantesFacturacion".equals(bId)){
                        dtoES = monBolsaFaltantes.procesarBolsaFaltantes(dtoin);
                    }else
                    if ("PEDReversionLineaCredito".equals(bId)){
                        dtoES = monPedValidacion.reversionLineaCredito(dtoin);
                    }else
                    if ("PEDReversionFlete".equals(bId)){
                        dtoES = monPedValidacion.revertirFlete(dtoin);
                    }else
                    if ("PEDReversionMontoMinimo".equals(bId)){
                        dtoES = monPedValidacion.revertirMontoMinimo(dtoin);
                    }else
                    if ("PEDReversionDescuentos".equals(bId)){
                        dtoES = monPedValidacion.revertirDescuentos(dtoin);
                    }else
                    if ("PEDReversionCuadreOfertas".equals(bId)){
                        dtoES = monRevCuadre.revertirCuadreOfertas(dtoin);
                    }else
                    if ("PEDReversionAgregados".equals(bId)){
                        dtoES = monPedValidacion.revertirAgregados(dtoin);
                    }else
                    if ("PEDReversionPrecios".equals(bId)){
                        dtoES = monPedValidacion.revertirPrecios(dtoin);
                    }else
                    if ("PEDReversionLimiteVenta".equals(bId)){
                        dtoES = monPedValidacion.revertirLimiteVenta(dtoin);
                    }else
                    if ("PEDReversionObligatoriaEnElMismoPeriodo".equals(bId)){
                        dtoES = monPedValidacion.reversionRecuperacionObligatoriaMismoPeriodo(dtoin);
                    }else
                    if ("PEDReversionVoluntaria".equals(bId)){
                        dtoES = monPedValidacion.revertirRecuperacionVoluntaria(dtoin);
                    }else
                    if ("PEDReversionObligatoria".equals(bId)){
                        dtoES = monPedValidacion.revertirRecuperacionObligatoria(dtoin);
                    }else
                    if ("PEDReversionAsignacionDeStock".equals(bId)){
                        dtoES = monPedValidacion.revertirAsignacionStock(dtoin);
                    }else
                    if ("PEDReversionControlLiquidacion".equals(bId)){
                        dtoES = monPedValidacion.revertirControlLiquidacion(dtoin);
                    }else
                    if ("PEDReversionControlStock".equals(bId)){
                        dtoES = monPedValidacion.revertirControlStock(dtoin);
                    }else
                    if ("PEDReversionGenerarMensajesFaltantesAnunciados".equals(bId)){
                        dtoES = monPedValidacion.reversionMensajesFaltantesAnunciados(dtoin);
                    }else
                    if ("PEDRecuperacionObligatoriaEnElMismoPeriodo".equals(bId)){
                        dtoES = monPedValidacion.recuperacionObligatoriaMismoPeriodo(dtoin);
                    }else
                    if ("PEDRevertirCalculoTotales".equals(bId)){
                        dtoES = monPedValidacion.revertirCalcularTotales(dtoin);
                    }else  //jrivas 2007437  
                    if ("PEDActualizarPeriodoPrimerContacto".equals(bId)){
                        dtoES = monPedValidacion.actualizarPeriodoPrimerContacto(dtoin);
                    }else  //jrivas 20080535 
                    if ("PEDDeterminarGanadorasRecomCosultoraMonitor".equals(bId)){
                        dtoES = monPremiacion.determinarGanadorasRecomendacionConsultoraMonitor(dtoin);
                    }else  // sapaza -- PER-SiCC-2011-0214 -- 11/04/2011 
                    if ("PEDValidarDescuentos2".equals(bId)){
                        dtoES = monPedValidacion.validarDescuento2(dtoin);
                    }else  // sapaza -- PER-SiCC-2011-0214 -- 11/04/2011
                    if ("PEDValidarCuadreOfertas2".equals(bId)){
                        dtoES = monPedValidacion.validarCuadreOfertas2(dtoin);
                    }else  // sapaza -- PER-SiCC-2012-0130 -- 20/02/2011                        
                    if ("PEDRecuperacionObligatoria2".equals(bId)){
                        dtoES = monPedValidacion.recuperacionObligatoria2(dtoin);
                    }else  // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
                    if ("PEDCalcularMontoMaximo2".equals(bId)){
                        dtoES = monPedValidacion.calcularMontoMaximo2(dtoin);
                    }else  // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
                    if ("PEDCalcularMontoMinimo2".equals(bId)){
                        dtoES = monPedValidacion.calcularMontoMinimo2(dtoin);
                    }else  // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
                    if ("PEDInsertarOfertasEspeciales".equals(bId)){
                        dtoES = monPedValidacion.insertarOfertasEspeciales(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2013-0076 -- 06/02/2013
                    if ("PEDValidarAgregados2".equals(bId)){
                        dtoES = monPedValidacion.validarAgregados2(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2013-0123 -- 12/02/2013
                    if ("PEDCalcularMontoMinimoIncen".equals(bId)){
                        dtoES = monPedValidacion.calcularMontoMinimoIncentivos(dtoin);
                    }else  // sapaza -- PER-SiCC-2013-0123 -- 12/02/2013
                    if ("PEDInsertarOfertasEspeciales2".equals(bId)){
                        dtoES = monPedValidacion.insertarOfertasEspeciales2(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2014-0564 -- 15/09/2014
                    if ("PEDValidarCuadreOfertas3".equals(bId)){
                        dtoES = monPedValidacion.validarCuadreOfertas3(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2014-0750 -- 09/10/2014
                    if ("PEDValidarCuadreOfertas4".equals(bId)){
                        dtoES = monPedValidacion.validarCuadreOfertas4(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2015-0228 -- 05/05/2015
                    if ("PEDEliminarProductosFaltantesProlIndividual".equals(bId)){
                        dtoES = monPedValidacion.eliminarProductosFaltantesProlIndividual(dtoin);                                                
                    }else  // sapaza -- PER-SiCC-2015-0228 -- 05/05/2015
                    if ("PEDEliminarProductosFaltantesProlCompuesta".equals(bId)){
                        dtoES = monPedValidacion.eliminarProductosFaltantesProlCompuesta(dtoin);                                                
                    }else  // sapaza -- GR-851 -- 01/04/2016
                    if ("PEDEvluarExigenciasVentas".equals(bId)){
                        dtoES = monPedValidacion.evaluarExigenciasVentas(dtoin);                                                
                    }else{
                        UtilidadesLog.error("ERROR, BUSINESSID NO IDENTIFICADO");
                    }
                                
                    if ( (dtoES == null) ||
                    ((dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) &&
                    (dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_LIBERADO.longValue())) ) {
                        UtilidadesLog.debug("Se aborta transaccion, Oid Solicitud : " + 
                        dtoin.getOidSolicitud() + " Oid proceso: " + elemDTOProc.getOidProceso());
                        
                        LogAPP.error("Se aborta transaccion, Oid Solicitud : " + 
                        dtoin.getOidSolicitud() + " Oid proceso: " + elemDTOProc.getCodProceso());
                        return dtoES;
                    
                    } else {
                        ultOidProceso = elemDTOProc.getOidProceso();           
                        if (dtoES.getResultado() != null) {
                            ultResu   = dtoES.getResultado();
                            ultEstado = dtoES.getEstatus();
                        }                            
                    }                        
                }
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
                if(log.isWarnEnabled())
                    UtilidadesLog.warn("Proceso "+bId+" ---> "+(System.currentTimeMillis()-comienzo));
            }
            dtoESResu.setOidProceso(ultOidProceso);
            if (ultEstado == null) {
                dtoESResu.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            } else {
                dtoESResu.setEstatus(ultEstado);
                dtoESResu.setResultado(ultResu);
            }
            return dtoESResu;
        } catch(Throwable ex) {
            UtilidadesLog.error("Exception: ",ex);
            return null;
        }  
    }
    
    public void ejecutarGP5(DTOFACConsolidado consolidado, TreeMap listaProcesosOrdenados, Boolean online) throws Exception{
        MONTratamientosContablesLocal monTrata = getMONTratamientosContablesLocalHome().create();
        MONCrearListaPicadoLocal monCLP = getMONCrearListaPicadoLocalHome().create();
        MONImpresionSICCLocal monIMpre = getMONImpresionSICCLocalHome().create();
        MONFacturacionLocal monFact = getMONFacturacionLocalHome().create();
        Iterator itOrdenado = listaProcesosOrdenados.values().iterator();
        DTOProceso elemDTOProc = null;
        DTOProceso elemDTOProcAnt = null;
        while (itOrdenado.hasNext()){  
            elemDTOProc = (DTOProceso) itOrdenado.next();
            long comienzo = System.currentTimeMillis();
            String bId = elemDTOProc.getBusinessID();
            if ("PEDMarcaCheqPeru".equals(bId)){
                if (indicadorBalanceoAreaChequeo==null){
                    PaisLocalHome plocalHome = new PaisLocalHome();
                    PaisLocal pL = plocalHome.findByPrimaryKey(consolidado.getOidPais());
                    indicadorBalanceoAreaChequeo = new Character(pL.getInd_bala_area_cheq().charAt(0));
                }
                monFact.balancearAreaChequeo(consolidado,indicadorBalanceoAreaChequeo);
            }else
            if ("PEDCerrarArmado".equals(bId)){             //y agarrate manoleta!
                monCLP.crearListaPicado(consolidado);
            }else            
            if ("PEDGrabarDocumentoContable".equals(bId)){
                if (online != null && online.booleanValue()){
                    monTrata.grabarDocumentoContable(consolidado);
                }else{
                    monTrata.grabarDocumentoContableBatch(consolidado);
                }
            }else
            if ("PEDGenerarRegistroUnicoDeVenta".equals(bId)){
                monTrata.generarRegistroUnicoVenta(consolidado);
            }else
            if ("PEDGenerarRegistroEnCuentaCorriente".equals(bId)){
                monTrata.generarRegistroCC(consolidado);
            }else
            if ("PEDGenerarRegistroEnCuentaCorriente2".equals(bId)){
                monTrata.generarRegistroCC2(consolidado);
            }else
            if ("PEDGenerarDocumentosDeFacturacion".equals(bId)){
                if (validaEjecucionImpresionBelcenter(online, consolidado.getDtoCabecera().getAcceso())){
                    elemDTOProc = elemDTOProcAnt;
                    break;
                }else{
                    consolidado.setIndOnline(online);    
                    monIMpre.generarDocFactura(consolidado);
                }
                /*if (online != null && online.booleanValue()){
                    elemDTOProc = elemDTOProcAnt;
                    break;
                }else{
                    consolidado.setIndOnline(online);
                    monIMpre.generarDocFactura(consolidado);
                }*/
            } else 
            /* Agregado por AL - 19/05/2008 - Nuevo proceso de Impresion Colombia */
            if ("PEDGenerarDocumentosDeFacturacionSinPreImpresos".equals(bId)){                
                if (validaEjecucionImpresionBelcenter(online, consolidado.getDtoCabecera().getAcceso())){                    
                    elemDTOProc = elemDTOProcAnt;
                    break;
                }else{                    
                    consolidado.setIndOnline(online);    
                    monIMpre.generarDocFacturaColombia(consolidado);
                }
            }
            elemDTOProcAnt = new DTOProceso();
            elemDTOProcAnt.setBusinessID(elemDTOProc.getBusinessID());
            elemDTOProcAnt.setCodProceso(elemDTOProc.getCodProceso());
            elemDTOProcAnt.setOidProceso(elemDTOProc.getOidProceso());
            elemDTOProcAnt.setOidSubTipoPosicion(elemDTOProc.getOidSubTipoPosicion());
            elemDTOProcAnt.setOidTipoPosicion(elemDTOProc.getOidTipoPosicion());
            elemDTOProcAnt.setSecuencia(elemDTOProc.getSecuencia());
            
            if(log.isWarnEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.warn("Proceso "+bId+" ---> "+(System.currentTimeMillis()-comienzo));
        }
        DAOSolicitudCabecera daoSolicitudCabecera = new DAOSolicitudCabecera();
        DTOFACCabeceraSolicitud dtoFCS = consolidado.getDtoCabecera();
        dtoFCS.setProceso(elemDTOProc.getOidProceso());
        dtoFCS.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        daoSolicitudCabecera.actualizarProcesoEstado(dtoFCS);
    }
    
    private boolean validaEjecucionImpresionBelcenter(Boolean online, Long acceso){
        if (online!=null && online.booleanValue()){
            try{
                RecordSet rs = null;
                StringBuffer sb = new StringBuffer("select count(*) from seg_acces where oid_acce = "+acceso+" and ind_acce = 'B'");
                
                rs = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
                if (rs.getValueAt(0,0).toString().equals("0")){
                    return false;
                }else{
                    return true;
                }
            }catch (Exception e){
                UtilidadesLog.error("error al obtener el acceso belcenter",e);            
                return false;
            }
        }else{
            return false;
        }
    }
    
    private MONPEDValidacion getMONPEDValidacionHome() throws MareException {
        try{
            final InitialContext context = new InitialContext();
            return (((MONPEDValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPEDValidacion"), MONPEDValidacionHome.class)).create());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONValidacionCuadreOfertas getMONValidacionCuadreOfertasHome() throws MareException {
        try{
            final InitialContext context = new InitialContext();
            return (((MONValidacionCuadreOfertasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacionCuadreOfertas"), MONValidacionCuadreOfertasHome.class)).create());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONReversionCuadreOfertas getMONReversionCuadreOfertasHome() throws MareException {
        try{
            final InitialContext context = new InitialContext();
            return (((MONReversionCuadreOfertasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONReversionCuadreOfertas"), MONReversionCuadreOfertasHome.class)).create());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONTratamientosContables getMONTratamientosContablesHome() throws MareException {
        try{
            final InitialContext context = new InitialContext();
            return (((MONTratamientosContablesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONTratamientosContables"), MONTratamientosContablesHome.class)).create());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONImpresionSICC getMONImpresionSICCHome() throws MareException {
        try{
            final InitialContext context = new InitialContext();
            return (((MONImpresionSICCHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONImpresionSICC"), MONImpresionSICCHome.class)).create());
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONIncentivos getMONIncentivosHome() throws MareException{
        try{
            final InitialContext context = new InitialContext();
            return ((MONIncentivosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONIncentivos"), MONIncentivosHome.class)).create();
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONPremiacion getMONPremiacionHome() throws MareException{
        try{
            final InitialContext context = new InitialContext();
            return ((MONPremiacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class)).create();
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONBolsaFaltantes getMONBolsaFaltantesHome() throws MareException{
        try{
            final InitialContext context = new InitialContext();
            return ((MONBolsaFaltantesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONBolsaFaltantes"), MONBolsaFaltantesHome.class)).create();
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    
    private MONPEDValidacionLocalHome getMONPEDValidacionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONPEDValidacionLocalHome)context.lookup("java:comp/env/ejb/local/MONPEDValidacion");
    }

    private MONValidacionCuadreOfertasLocalHome getMONValidacionCuadreOfertasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONValidacionCuadreOfertasLocalHome)context.lookup("java:comp/env/ejb/local/MONValidacionCuadreOfertas");
    }

    private MONReversionCuadreOfertasLocalHome getMONReversionCuadreOfertasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONReversionCuadreOfertasLocalHome)context.lookup("java:comp/env/ejb/local/MONReversionCuadreOfertas");
    }
    
    private MONIncentivosLocalHome getMONIncentivosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONIncentivosLocalHome)context.lookup("java:comp/env/ejb/local/MONIncentivos");
    }

    private MONPremiacionLocalHome getMONPremiacionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONPremiacionLocalHome)context.lookup("java:comp/env/ejb/local/MONPremiacion");
    }

    private MONBolsaFaltantesLocalHome getMONBolsaFaltantesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONBolsaFaltantesLocalHome)context.lookup("java:comp/env/ejb/local/MONBolsaFaltantes");
    }
    
    private MONTratamientosContablesLocalHome getMONTratamientosContablesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONTratamientosContablesLocalHome)context.lookup("java:comp/env/ejb/local/MONTratamientosContables");
    }
    
    private MONImpresionSICCLocalHome getMONImpresionSICCLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONImpresionSICCLocalHome)context.lookup("java:comp/env/ejb/local/MONImpresionSICC");
    }
    
    private MONEnvioAgregadosBatchLocalHome getMONEnvioAgregadosBatchLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONEnvioAgregadosBatchLocalHome)context.lookup("java:comp/env/MONEnvioAgregadosBatch");
    }
    
    private MONFacturacionLocalHome getMONFacturacionLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (MONFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONFacturacion");
    }
    
    private MONCrearListaPicadoLocalHome getMONCrearListaPicadoLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (MONCrearListaPicadoLocalHome)context.lookup("java:comp/env/ejb/local/MONCrearListaPicado");
    }    
    
}