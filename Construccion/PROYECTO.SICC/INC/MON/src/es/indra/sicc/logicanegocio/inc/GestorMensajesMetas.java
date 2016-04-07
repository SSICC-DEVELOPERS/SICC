package es.indra.sicc.logicanegocio.inc;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.inc.DTODatosGenMsgMetasVenta;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOMsgMetasYClientes;
import es.indra.sicc.dtos.inc.DTOMetasTipoVenta;
import java.math.BigDecimal;
import es.indra.sicc.util.BelcorpService;

import java.util.ArrayList;
import es.indra.sicc.logicanegocio.inc.DAOCalcularMetas;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import javax.ejb.CreateException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

// import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

public class GestorMensajesMetas {
    private static int CANT_DECIMALES = 2; 
    
    public GestorMensajesMetas()  { }
    
    public static synchronized void enviarMSGCalificacionMetasVentaPerf
    (
        DTOListaMetasTipoVenta  lista, 
        DTOConcurso             conc, 
        DTOBuzonMensajes        buzonAux
    ) 
    throws MareException 
    {    
        UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVentaPerf(DTOListaMetasTipoVenta listaMetas): Entrada");        
        ArrayList listaMetas = lista.getListaMetas();
        int cant = listaMetas.size();
        DTOMetasTipoVenta metaCliente = null;
        DTOBuzonMensajes dtoBuzon = null;
        

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;    

        UtilidadesLog.debug("JVM300 A, oidConcurso="+conc.getParamGenerales().getOid());

        query = new StringBuffer();            
        query.append("  SELECT N.NUM_CANT_INIC_PUNT NUM_CANT_INIC_PUNT, N.NUM_NIVE NUM_NIVE");
        query.append("   FROM INC_PARAM_NIVEL_PREMI N, ");
        query.append("        INC_PARAM_GENER_PREMI G, ");
        query.append("        INC_CONCU_PARAM_GENER P ");
        query.append(" WHERE P.OID_PARA_GRAL = " + conc.getParamGenerales().getOid());
        query.append(" AND   G.COPA_OID_PARA_GRAL = P.OID_PARA_GRAL ");
        query.append(" AND   N.PAGP_OID_PARA_GENE_PREM = G.OID_PARA_GENE_PREM ");
        query.append(" ORDER BY OID_PARA_NIVE_PREM  ");

        UtilidadesLog.debug("JVM300 B, QUERY="+query.toString());

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal incremento = new BigDecimal(0);  
        Double numNivelIncremento = new Double(0);             
        
        UtilidadesLog.debug("JVM300 B, getRowCount="+rs.getRowCount());
        
        DTOBuzonMensajes[] dtoBuzones = new DTOBuzonMensajes[cant * rs.getRowCount()];
        
        int idxBuzon=0;
        
        for(int j=0; j<rs.getRowCount(); j++){        
        
            numNivelIncremento = new Double(rs.getValueAt(j, "NUM_NIVE").toString());
            incremento = (BigDecimal) rs.getValueAt(j, "NUM_CANT_INIC_PUNT");
        
            for(int i=0; i<cant; i++) {
                metaCliente = (DTOMetasTipoVenta)listaMetas.get(i);
                
                dtoBuzon = new DTOBuzonMensajes();
                dtoBuzon.setOidPais(conc.getOidPais());
                dtoBuzon.setCodigoMensaje(conc.getParamCalificacion().getMensaje());
                dtoBuzon.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);
                dtoBuzon.setOidCliente(metaCliente.getOidCliente());
                
                SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
                String dateString = formatter.format(new java.util.Date(System.currentTimeMillis()));                          
                dtoBuzon.setDatoVariable1(dateString);
                //  Modificado por HRCS - Fecha 06/07/2007 - Incidencia Sicc20070287
                dtoBuzon.setDatoVariable2(metaCliente.getDpNombre1());
                dtoBuzon.setDatoVariable3(metaCliente.getDpApellido1());
                dtoBuzon.setDatoVariable4(metaCliente.getDpCodCliente());
                dtoBuzon.setDatoVariable5(metaCliente.getDpCodZona());
                if(metaCliente.getDpCodTerritorio()!=null) {            
                    dtoBuzon.setDatoVariable6(metaCliente.getDpCodTerritorio().toString());    
                }
                
                dtoBuzon.setDatoVariable7(conc.getParamGenerales().getCodPeriodoDesde());
                dtoBuzon.setDatoVariable8(conc.getParamGenerales().getCodPeriodoHasta());
                dtoBuzon.setDatoVariable9(buzonAux.getDatoVariable9());
                dtoBuzon.setDatoVariable10(buzonAux.getDatoVariable10());
                
                BigDecimal bdNumeroPuntos = null;
                BigDecimal meta = metaCliente.getValorMetas();
                BigDecimal factorConversion = conc.getObtencionPuntos().getFactorConversion();
                Integer numeroPuntos = conc.getObtencionPuntos().getPuntosAsignar();
                
                if(numeroPuntos!=null){
                    bdNumeroPuntos = new BigDecimal(numeroPuntos.intValue());    
                }            
                
                BigDecimal res2=new BigDecimal("0");
                
                if(meta!=null && factorConversion!=null && bdNumeroPuntos!=null
                && bdNumeroPuntos.intValue()!=0) {
                    BigDecimal res1 = meta.multiply(factorConversion);
                    res2 = res1.divide(bdNumeroPuntos, CANT_DECIMALES, BigDecimal.ROUND_HALF_UP);            
                    dtoBuzon.setDatoVariable11(res2.toString());                            
                }           
                
                if(metaCliente.getValorIncremento()!=null) {
                    dtoBuzon.setDatoVariable12(metaCliente.getValorIncremento().toString());    
                }

                dtoBuzon.setDatoVariable13(buzonAux.getDatoVariable13());
                
                // JVM, sicc 20070300, variables 14,15,16 y 17 
                dtoBuzon.setDatoVariable14(buzonAux.getDatoVariable14());
                dtoBuzon.setDatoVariable15(incremento.toString());            
                dtoBuzon.setDatoVariable16(res2.add(incremento).toString());
                dtoBuzon.setDatoVariable17(numNivelIncremento.toString());
                
                UtilidadesLog.debug("JVM300, getDatoVariable "+
                                                " 14="+ dtoBuzon.getDatoVariable14() +
                                                " 15="+ dtoBuzon.getDatoVariable15() +
                                                " 16="+ dtoBuzon.getDatoVariable16() +
                                                " 17="+ dtoBuzon.getDatoVariable17());                                                
                // -----------------------------------------------------------------
                dtoBuzones[idxBuzon++] = dtoBuzon;              
            }   
        }
        
        try {            
            MONGestionMensajesLocalHome mgmh = getMONGestionMensajesLocalHome();
            DTOBuzonMensajes[] dtoBuzonResultado = mgmh.create().insertarDatosMensajesBatch(dtoBuzones);
        }
        catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        catch (NamingException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }         


        UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVenta(DTOListaMetasTipoVenta listaMetas): Salida");                
    }
    
    public static synchronized void enviarMSGCalificacionMetasVenta(DTOOID DTOE)
    throws MareException {    
        UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVenta(DTOOID DTOE): Entrada");        
        
        DTODatosGenMsgMetasVenta dtoG = null;
        ArrayList metasClientes = null;
        DAOCalcularMetas dao = new DAOCalcularMetas();        
        dtoG = dao.buscarDatosGenMsgMetasVenta(DTOE.getOid());      
        
        if(dtoG==null) {
            UtilidadesLog.debug("DTODatosGenMsgMetasVenta es null");
            UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVenta(DTOOID DTOE): Salida");    
            return;
        }
        metasClientes = dao.buscarMetasYClientesPorConcurso(DTOE.getOid());        
        if(metasClientes==null) {
            UtilidadesLog.debug("ArrayList metasClientes es null");
            UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVenta(DTOOID DTOE): Salida");    
            return;            
        }
        
        int cant = metasClientes.size();
        for(int i=0; i<cant; i++) {
            DTOMsgMetasYClientes metaCliente = (DTOMsgMetasYClientes)metasClientes.get(i);
            UtilidadesLog.debug("********* i:" + i);
            UtilidadesLog.debug("********* DTOMsgMetasYClientes:" + metaCliente);
            
            DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
            
            dtoBuzon.setOidPais(DTOE.getOidPais());
            dtoBuzon.setCodigoMensaje(dtoG.getMensaje());
            dtoBuzon.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);
            dtoBuzon.setOidCliente(metaCliente.getCliente());
            
            SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
            String dateString = formatter.format(new java.util.Date(System.currentTimeMillis()));                          
            dtoBuzon.setDatoVariable1(dateString);
            
            dtoBuzon.setDatoVariable2(metaCliente.getNombre1());
            dtoBuzon.setDatoVariable3(metaCliente.getApellido1());
            dtoBuzon.setDatoVariable4(metaCliente.getCodCliente());
            dtoBuzon.setDatoVariable5(metaCliente.getCodZona());
            if(metaCliente.getCodTerritorio()!=null) {            
                dtoBuzon.setDatoVariable6(metaCliente.getCodTerritorio().toString());    
            }
            dtoBuzon.setDatoVariable7(dtoG.getPeriodoDesdeConc());
            dtoBuzon.setDatoVariable8(dtoG.getPeriodoHastaConc());
            dtoBuzon.setDatoVariable9(dtoG.getPeriodoDesdeCali());
            dtoBuzon.setDatoVariable10(dtoG.getPeriodoHastaCali());            
            
            BigDecimal bdNumeroPuntos = null;
            BigDecimal meta = metaCliente.getMeta();
            BigDecimal factorConversion = dtoG.getFactorConversion();
            Integer numeroPuntos = dtoG.getNumeroPuntos();
            
            UtilidadesLog.debug("**** meta:" + meta);
            UtilidadesLog.debug("**** factorConversion:" + factorConversion);
            UtilidadesLog.debug("**** numeroPuntos:" + numeroPuntos);
            
            if(numeroPuntos!=null){
                bdNumeroPuntos = new BigDecimal(numeroPuntos.intValue());    
            }            
            
            if(meta!=null && factorConversion!=null && bdNumeroPuntos!=null
            && bdNumeroPuntos.intValue()!=0) {
                BigDecimal res1 = meta.multiply(factorConversion);
                UtilidadesLog.debug("**** res1:" + res1);
                BigDecimal res2 = res1.divide(bdNumeroPuntos, CANT_DECIMALES,                
                BigDecimal.ROUND_HALF_UP);            
                UtilidadesLog.debug("**** res2:" + res2);
                dtoBuzon.setDatoVariable11(res2.toString());                            
            }           
            
            if(metaCliente.getIncremento()!=null) {
                dtoBuzon.setDatoVariable12(metaCliente.getIncremento().toString());    
            }
            dtoBuzon.setDatoVariable13(dtoG.getNumeroConcurso());   
            
            try {            
                MONGestionMensajesHome mgmh = MSGEjbLocators.getMONGestionMensajesHome();
                UtilidadesLog.debug("**** Llamando a insertaDatosMensajeBatch con: " + dtoBuzon);
                DTOBuzonMensajes dtoBuzonResultado = mgmh.create().insertaDatosMensajeBatch(dtoBuzon);
            }
            catch (CreateException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            catch (RemoteException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }            
        }        
        UtilidadesLog.info("GestorMensajesMetas.enviarMSGCalificacionMetasVenta(DTOOID DTOE): Salida");    
    }
    
  public void obtenerDatosMSG(Long periodoDesdeCali, Long periodoHastaCali, Long oidConcu, DTOBuzonMensajes dtoBuzon)
    throws MareException{
    UtilidadesLog.info("DAOSolicitudes.obtenerDatosMSG(Long periodoDesdeCali, Long periodoHastaCali, Long oidConcu):Entrada");
    RecordSet rs;
    StringBuffer query = new StringBuffer();

    query.append(" SELECT CP1.VAL_NOMB_PERI NOMBREPERIODODESDE, CP2.VAL_NOMB_PERI NOMBREPERIODOHASTA, CPG.NUM_CONC ");
    query.append(" ,VAL_NOMB ");                                                // JVM, sicc 20070300, se adiciona la recuperación de la descripción del concurso    
    query.append("   FROM CRA_PERIO CP1, CRA_PERIO CP2, INC_CONCU_PARAM_GENER CPG ");
    query.append(" WHERE CP1.OID_PERI = " + periodoDesdeCali);
    query.append(" AND CP2.OID_PERI = " + periodoHastaCali);
    query.append(" AND CPG.OID_PARA_GRAL = " + oidConcu);
    
    try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
        UtilidadesLog.error("ERROR ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    if( ! rs.esVacio() ){
        dtoBuzon.setDatoVariable9((rs.getValueAt(0,"NOMBREPERIODODESDE")).toString());
        dtoBuzon.setDatoVariable10((rs.getValueAt(0,"NOMBREPERIODOHASTA")).toString());
        dtoBuzon.setDatoVariable13((rs.getValueAt(0,"NUM_CONC")).toString());
        
        UtilidadesLog.debug("JVM300, setDatoVariable14");
        dtoBuzon.setDatoVariable14((rs.getValueAt(0,"VAL_NOMB")).toString()); // JVM, sicc 20070300, se adiciona la recuperación de la descripción del concurso    
        UtilidadesLog.debug("JVM300, getDatoVariable14="+dtoBuzon.getDatoVariable14());
    }
    UtilidadesLog.info("DAOSolicitudes.obtenerDatosMSG(Long periodoDesdeCali, Long periodoHastaCali, Long oidConcu):Salida");
  }
    

  private static MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
  }    
}