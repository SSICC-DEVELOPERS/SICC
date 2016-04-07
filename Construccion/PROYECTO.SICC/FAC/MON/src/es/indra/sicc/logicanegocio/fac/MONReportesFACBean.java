package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACReporte;
import es.indra.sicc.entidades.fac.DTRSegmentosClientesLocal;
import es.indra.sicc.entidades.fac.DTRSegmentosZonaLocal;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.entidades.fac.DTRSegmentosClientesLocalHome;
import es.indra.sicc.entidades.fac.DTRSegmentosZonaLocalHome;

public class MONReportesFACBean implements SessionBean 
{
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
    SessionContext ctx;

    public void validarSegmentoZona(DTOFACReporte dtoe) throws MareException
    {
        UtilidadesLog.info("MONReportesFAC.validarSegmentoZona(DTOFACReporte dtoe):Entrada");
        /*Intento recuperar datos de DTR-Segmento-Zona*/
        DAOFACReportes dao = new DAOFACReportes();
        RecordSet r = dao.obtenerDatosSegmentosZonas(dtoe);
        /*Si los hay, pregunto si quiero borrarlos lanzando un exception*/
        if (!(r.esVacio() || r.getValueAt(0,0)==null || r.getValueAt(0,0).toString().length() < 1 || r.getValueAt(0,0).toString().equals("0"))){
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC,ErroresDeNegocio.FAC_REP_0001));
        }
        /*else llamo al metodo generarNivelesSegmentoConsultora*/
        try{
            /*Continuo con la ejecucion del metodo generarNivelesSegmentoConsultora*/
            generarNivelesSegmentoConsultora(dtoe);
            UtilidadesLog.info("MONReportesFAC.validarSegmentoZona(DTOFACReporte dtoe):Salida");
        }catch(MareException e){
            UtilidadesLog.error("MONReportesFAC.validarSegmentoZona: "+e);
            ctx.setRollbackOnly();
            throw e;            
        }
    }

    public void generarNivelesSegmentoConsultora(DTOFACReporte dtoe) throws MareException{
        UtilidadesLog.info("MONReportesFAC.generarNivelesSegmentoConsultora(DTOFACReporte dtoe):Entrada");
        try{
            DAOFACReportes dao = new DAOFACReportes();
            RecordSet r = dao.obtenerDatosCabeceraSolicitud(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            ArrayList insertados = new ArrayList();
            for (int i = 0 ; i < r.getRowCount() ; i++){
                Long periodo = null;
                Long region = null;
                Long zona = null;
                Long cliente = null;
                Double venta = null;
                Long nPedidos = null;
                Double pmnp = null;
                Double importeDesc1 = null;
                Double importeDesc3 = null;
                
                if (r.getValueAt(i,"PERD_OID_PERI")!=null && r.getValueAt(i,"PERD_OID_PERI").toString().length()>0)
                    periodo = Long.valueOf(r.getValueAt(i,"PERD_OID_PERI").toString());
                if (r.getValueAt(i,"OID_REGI")!=null && r.getValueAt(i,"OID_REGI").toString().length()>0)
                    region = Long.valueOf(r.getValueAt(i,"OID_REGI").toString());
                if (r.getValueAt(i,"OID_ZONA")!=null && r.getValueAt(i,"OID_ZONA").toString().length()>0)
                    zona = Long.valueOf(r.getValueAt(i,"OID_ZONA").toString());
                if (r.getValueAt(i,"CLIE_OID_CLIE")!=null && r.getValueAt(i,"CLIE_OID_CLIE").toString().length()>0)
                    cliente = Long.valueOf(r.getValueAt(i,"CLIE_OID_CLIE").toString());
                if (r.getValueAt(i,"VENTA")!=null && r.getValueAt(i,"VENTA").toString().length()>0)
                    venta = Double.valueOf(r.getValueAt(i,"VENTA").toString());
                if (r.getValueAt(i,"N_PEDIDOS")!=null && r.getValueAt(i,"N_PEDIDOS").toString().length()>0)
                    nPedidos = Long.valueOf(r.getValueAt(i,"N_PEDIDOS").toString());
                if (r.getValueAt(i,"PMNP")!=null && r.getValueAt(i,"PMNP").toString().length()>0)
                    pmnp = Double.valueOf(r.getValueAt(i,"PMNP").toString());
                if (r.getValueAt(i,"IMP_DESC_1")!=null && r.getValueAt(i,"IMP_DESC_1").toString().length()>0)
                    importeDesc1 = Double.valueOf(r.getValueAt(i,"IMP_DESC_1").toString());
                if (r.getValueAt(i,"IMP_DESC_3")!=null && r.getValueAt(i,"IMP_DESC_3").toString().length()>0)
                    importeDesc3 = Double.valueOf(r.getValueAt(i,"IMP_DESC_3").toString());

                DTRSegmentosClientesLocal dtr = getDTRSegmentosClientesLocalHome().create(cliente, region, zona, periodo, null, nPedidos, venta, pmnp, importeDesc1, importeDesc3);
                UtilidadesLog.info("Se va a agregar -> "+dtr.getOid());
                insertados.add(dtr.getOid());
            }
            r = null;
            /*Ahora realizamos una query sobre DTR-Segmentos-Clientes para llenar DTR-Segmemtos-Zonas*/
            r = dao.obtenerDatosSegmentosClientes(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            
            for (int i = 0 ; i < r.getRowCount() ; i++){
                Long periodo = null;
                Long region = null;
                Long zona = null;
                Double venta = null;
                Long nPedidos = null;
                Double pmnp = null;
                
                if (r.getValueAt(i,"PERD_OID_PERI")!=null && r.getValueAt(i,"PERD_OID_PERI").toString().length()>0)
                    periodo = Long.valueOf(r.getValueAt(i,"PERD_OID_PERI").toString());
                if (r.getValueAt(i,"ZORG_OID_REGI")!=null && r.getValueAt(i,"ZORG_OID_REGI").toString().length()>0)
                    region = Long.valueOf(r.getValueAt(i,"ZORG_OID_REGI").toString());
                if (r.getValueAt(i,"ZZON_OID_ZONA")!=null && r.getValueAt(i,"ZZON_OID_ZONA").toString().length()>0)
                    zona = Long.valueOf(r.getValueAt(i,"ZZON_OID_ZONA").toString());
                if (r.getValueAt(i,"VENTA")!=null && r.getValueAt(i,"VENTA").toString().length()>0)
                    venta = Double.valueOf(r.getValueAt(i,"VENTA").toString());
                if (r.getValueAt(i,"N_PEDIDO")!=null && r.getValueAt(i,"N_PEDIDO").toString().length()>0)
                    nPedidos = Long.valueOf(r.getValueAt(i,"N_PEDIDO").toString());
                if (r.getValueAt(i,"PMNP")!=null && r.getValueAt(i,"PMNP").toString().length()>0)
                    pmnp = Double.valueOf(r.getValueAt(i,"PMNP").toString());

                DTRSegmentosZonaLocal dtr = getDTRSegmentosZonaLocalHome().create(region, zona, periodo, nPedidos, venta, pmnp );
                
            }
            r = null;
            /*Calculo de niveles Nuevas*/
            r = dao.obtenerDatosSegmentosClientesNueva(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            for (int i = 0 ; i < r.getRowCount() ; i++){
                UtilidadesLog.info("OIDSegmento -> "+r.getValueAt(i,"OID_SEGM_CLIE"));
                UtilidadesLog.info("NIVEL -> "+r.getValueAt(i,"NIVEL"));
                Long segmClie = Long.valueOf(r.getValueAt(i,"OID_SEGM_CLIE").toString());
                if (!validarInsertados(insertados, segmClie))continue;
                Long nivel = Long.valueOf(r.getValueAt(i,"NIVEL").toString());
                DTRSegmentosClientesLocal dtr = getDTRSegmentosClientesLocalHome().findByPrimaryKey(segmClie);
                dtr.setNvsgOidNiveSegm(nivel);
            }
            r = null;
            /*Calculo de niveles Reingresos*/
            r = dao.obtenerDatosSegmentosClientesReingresos(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            for (int i = 0 ; i < r.getRowCount() ; i++){
                UtilidadesLog.info("OIDSegmento -> "+r.getValueAt(i,"OID_SEGM_CLIE"));
                UtilidadesLog.info("NIVEL -> "+r.getValueAt(i,"NIVEL"));
                Long segmClie = Long.valueOf(r.getValueAt(i,"OID_SEGM_CLIE").toString());
                if (!validarInsertados(insertados, segmClie))continue;
                Long nivel = Long.valueOf(r.getValueAt(i,"NIVEL").toString());
                DTRSegmentosClientesLocal dtr = getDTRSegmentosClientesLocalHome().findByPrimaryKey(segmClie);
                dtr.setNvsgOidNiveSegm(nivel);
                
            }      
            r = null;
            /*Calculo de niveles */
            r = dao.obtenerDatosCalculoNiveles(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            for (int i = 0 ; i < r.getRowCount() ; i++){
                UtilidadesLog.info("OIDSegmento -> "+r.getValueAt(i,"OID_SEGM_CLIE"));
                UtilidadesLog.info("NIVEL -> "+r.getValueAt(i,"NIVEL"));
                Long segmClie = Long.valueOf(r.getValueAt(i,"OID_SEGM_CLIE").toString());
                if (!validarInsertados(insertados, segmClie))continue;
                Long nivel = null;
                if (r.getValueAt(i,"NIVEL")!=null){
                nivel = Long.valueOf(r.getValueAt(i,"NIVEL").toString());
                }
                DTRSegmentosClientesLocal dtr = getDTRSegmentosClientesLocalHome().findByPrimaryKey(segmClie);
                dtr.setNvsgOidNiveSegm(nivel);
                
            }  
            r = null;
            /*Calculo de Egresos */
            r = dao.obtenerDatosSegmentosEgresos(dtoe);
            UtilidadesLog.info("RecordSet.getRowCount -> "+r.getRowCount());
            for (int i = 0 ; i < r.getRowCount() ; i++){
                UtilidadesLog.info("OIDSegmento -> "+r.getValueAt(i,"OID_SEGM_CLIE"));
                UtilidadesLog.info("NIVEL -> "+r.getValueAt(i,"NIVEL"));
                Long segmClie = Long.valueOf(r.getValueAt(i,"OID_SEGM_CLIE").toString());
                Long nivel = Long.valueOf(r.getValueAt(i,"NIVEL").toString());
                if (!validarInsertados(insertados, segmClie))continue;
                DTRSegmentosClientesLocal dtr = getDTRSegmentosClientesLocalHome().findByPrimaryKey(segmClie);
                dtr.setNvsgOidNiveSegm(nivel);
                dtr.setValPmnp(Double.valueOf("0"));
                dtr.setNumPedi(Long.valueOf("0"));
                dtr.setValVent(Double.valueOf("0"));
            }  
        } catch(Exception e) {
            if (e instanceof MareException)
                throw (MareException)e;
            UtilidadesLog.error("MONReportesFAC.generarNivelesSegmentoConsultora: "+e);
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONReportesFAC.generarNivelesSegmentoConsultora(DTOFACReporte dtoe):Salida");
    }
    
    private boolean validarInsertados(ArrayList array, Long oid){
        for (int i = 0; i<array.size(); i++){
            if (((Long)array.get(i)).longValue() == oid.longValue()){
                UtilidadesLog.info("Se borro -> "+array.get(i));
                array.remove(i);
                return true;
            }
        }
        UtilidadesLog.info("NO Se borro nada");
        return false;
    }

    public void eliminarRegistrosSegmentosZonasClientes(DTOFACReporte dtoe) throws MareException{
        UtilidadesLog.info("MONReportesFAC.eliminarRegistrosSegmentosZonasClientes(DTOFACReporte dtoe):Entrada");
        DAOFACReportes dao = new DAOFACReportes();
        try{
            /*Elimino los registros en las entidades DTR-Segmento-Zona y DTR-Segmento-Clientes*/
            dao.eliminarRegistrosSegmentoZonaClientes(dtoe);
            /*Continuo con la ejecucion del metodo generarNivelesSegmentoConsultora*/
            generarNivelesSegmentoConsultora(dtoe);
        }catch(MareException e){
            UtilidadesLog.error("MONReportesFAC.eliminarRegistrosSegmentosZonasClientes: "+e);
            ctx.setRollbackOnly();
            throw e;            
        }
        UtilidadesLog.info("MONReportesFAC.eliminarRegistrosSegmentosZonasClientes(DTOFACReporte dtoe):Salida");
    }

    private DTRSegmentosClientesLocalHome getDTRSegmentosClientesLocalHome() throws MareException {
      return new DTRSegmentosClientesLocalHome();
    }

    private DTRSegmentosZonaLocalHome getDTRSegmentosZonaLocalHome() throws MareException {
      return new DTRSegmentosZonaLocalHome();
    }


}
