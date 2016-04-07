/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocalHome;


import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONActualizarEstadoReclamosBean implements SessionBean  {
    
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    this.ctx=ctx;
    }

    public void actualizarEstadoReclamosFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException {
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamosFacturacion(DTOFACCabeceraSolicitud):Entrada");
        this.actualizarEstadoReclamos(cabeceraSolicitud,false);
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamosFacturacion(DTOFACCabeceraSolicitud):Salida");
    }

    public void actualizarEstadoReclamosRevertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException {
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamosRevertirFacturacion(DTOFACCabeceraSolicitud):Entrada");
        this.actualizarEstadoReclamos(cabeceraSolicitud,true);
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamosRevertirFacturacion(DTOFACCabeceraSolicitud):Salida");
    }
    
    private void actualizarEstadoReclamos (DTOFACCabeceraSolicitud cabeceraSolicitud, boolean reversion) throws MareException{
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamos (Long , boolean):Entrada");
        
        DAORec dao = new DAORec();
        RecordSet operaciones = dao.obtenerOperacionesSolicitud(cabeceraSolicitud.getOidCabeceraSolicitud());
        
        if (reversion == false){
            if (operaciones != null && !operaciones.esVacio()){
                for (int i = 0; i < operaciones.getRowCount(); i ++){
                    Long oidOperacion = new Long(operaciones.getValueAt(i,"OID").toString());
                    this.actualizarOperacion(oidOperacion, ConstantesREC.ESTADO_OPERACION_FACTURADO, new Date(System.currentTimeMillis()));
                }
            }
            if (operaciones != null && !operaciones.esVacio()){
                for (int i = 0; i < operaciones.getRowCount(); i ++){
                    Long oidOperacion = new Long(operaciones.getValueAt(i,"OID").toString()); 
                    Long oidReclamo = new Long(operaciones.getValueAt(i,"OID_RECLAMO").toString());
                    
                    boolean facturarReclamo = validarOperacionesReclamo(oidReclamo);
                    
                    if (facturarReclamo){
                        this.actualizarReclamo(oidReclamo,ConstantesREC.ESTADO_RECLAMO_FACTURADO);
                    }
                }
            }
            
            //REC-001 jrivas
            this.actualizarBoletaRecojo(cabeceraSolicitud);
            
        } else {
            if (operaciones != null && !operaciones.esVacio()){
                for (int i = 0; i < operaciones.getRowCount(); i++){
                    Long oidOperacion = new Long(operaciones.getValueAt(i,"OID").toString());
                    this.actualizarLineasOperacion(oidOperacion, ConstantesREC.ESTADO_LINEA_ENVIADO);
                    
                    this.actualizarOperacion(oidOperacion, ConstantesREC.ESTADO_OPERACION_ENVIADO, null); 
                    
                    Long oidReclamo = new Long(operaciones.getValueAt(i,"OID_RECLAMO").toString());
                    actualizarReclamo(oidReclamo, ConstantesREC.ESTADO_RECLAMO_ENVIADO);
                }
            }
            
        }
        
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarEstadoReclamos (Long , boolean):Salida");
    }
    
    private boolean validarOperacionesReclamo (Long oidReclamo) throws MareException{
        UtilidadesLog.info("MONActualizarEstadoReclamos.validarOperacionesReclamo (Long):Salida");
        UtilidadesLog.debug("Datos de entrada " + oidReclamo);
        OperacionReclamoLocalHome orLH = new OperacionReclamoLocalHome();
        Collection operaciones = null;
        
        try{
            operaciones = orLH.findByCabeceraReclamo(oidReclamo);
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONActualizarEstadoReclamos.validarOperacionesReclamo: Finder operacionReclamo", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        Iterator itOperaciones = operaciones.iterator();
        while (itOperaciones.hasNext()){
            OperacionReclamoLocal operacion = (OperacionReclamoLocal) itOperaciones.next();
            if (operacion.getEstadoOperacion().longValue() != ConstantesREC.ESTADO_OPERACION_FACTURADO.longValue()){
                UtilidadesLog.info("MONActualizarEstadoReclamos.validarOperacionesReclamo (Long):Salida");
                return false;
            }
        }
        UtilidadesLog.info("MONActualizarEstadoReclamos.validarOperacionesReclamo (Long):Salida");
        return true;
    }
    
    private void actualizarLineasOperacion (Long oidOperacion, Character estado) throws MareException{
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarLineasOperacion (Long , Character):Entrada");
        LineasOperacionReclamoLocalHome lorLH = new LineasOperacionReclamoLocalHome();

        Collection lineas = null;
        try{
            lineas = lorLH.findByOperacion(oidOperacion);
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONActualizarEstadoReclamos.actualizarLineasOperacion: Finder lineasoperacion", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch (PersistenceException e) {
            ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        Iterator itLineas = lineas.iterator();
        
        while (itLineas.hasNext()){
            LineasOperacionReclamoLocal lineasOperacionReclamo = (LineasOperacionReclamoLocal) itLineas.next();
            lineasOperacionReclamo.setIndicadorEstado(estado);
            lorLH.merge(lineasOperacionReclamo);
        }
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarLineasOperacion (Long , Character):Salida");
    }

    private void actualizarOperacion (Long oidOperacion, Long estado, Date fecha) throws MareException{
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarOperacion (Long , Long , Date):Entrada");
        
        OperacionReclamoLocalHome orLH = new OperacionReclamoLocalHome();
        
        OperacionReclamoLocal operacion = null;
        
        try{
            operacion = orLH.findByPrimaryKey(oidOperacion);
        } catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONActualizarEstadoReclamos.actualizarLineasOperacion: Finder lineasoperacion", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch (PersistenceException e) {
                ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        operacion.setEstadoOperacion(estado);  
        operacion.setFechaFacturacion(new java.sql.Date(fecha.getTime()));
        orLH.merge(operacion);

        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarOperacion (Long , Long , Date):Salida");
    }
    
    private void actualizarReclamo (Long oidReclamo, Long estado) throws MareException{
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarReclamo (Long , Long):Entrada");
        
        CabeceraReclamoLocalHome crLH = new CabeceraReclamoLocalHome();
        
        CabeceraReclamoLocal cabeceraReclamo = null;
        
        try{
            cabeceraReclamo = crLH.findByPrimaryKey(oidReclamo);
        }catch (NoResultException e){
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONActualizarEstadoReclamos.actualizarReclamo: Finder CabeceraReclamo", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch (PersistenceException e) {
            ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        cabeceraReclamo.setEstadoReclamo(estado);
        crLH.merge(cabeceraReclamo);
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarReclamo (Long , Long):Salida");
    }
    
    //REC-001 jrivas
    private void actualizarBoletaRecojo(DTOFACCabeceraSolicitud dto) throws  MareException {
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarBoletaRecojo (DTOFACCabeceraSolicitud dto):Entrada");      
        StringBuffer cadena = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
        String fechaRecojo = null;
        if (dto.getFechaEntrega() != null) {
            fechaRecojo = sdf.format(dto.getFechaEntrega());
        }
        String fechaEmision = sdf.format(dto.getFechaFacturacion());
        
        cadena.append(" UPDATE REC_BOLET_RECOJ ");
        cadena.append("    SET FEC_EMIS = TO_DATE ('" + fechaEmision + "', 'YYYY-MM-DD'), ");
        if (dto.getFechaEntrega() != null) {
            cadena.append("        FEC_RECO = TO_DATE ('" + fechaRecojo + "', 'YYYY-MM-DD'), ");
        } else {
            cadena.append("        FEC_RECO = null, ");
        }
        if (dto.getIndPedidoServicio() != null && dto.getIndPedidoServicio().booleanValue()) {
            cadena.append("        IND_PEDI_SERV = 1, ");
        } else {
            cadena.append("        IND_PEDI_SERV = 0, ");
        }
        cadena.append("        NUM_FACT = " + dto.getNumeroConsolidado());
        cadena.append("  WHERE OID_BOLE_RECO = ");
        cadena.append("           (SELECT OID_BOLE_RECO ");
        cadena.append("              FROM (SELECT   BR.OID_BOLE_RECO, BR.NUM_BOLE ");
        cadena.append("                        FROM REC_SOLIC_OPERA SO, REC_OPERA_RECLA OPR, REC_BOLET_RECOJ BR ");
        cadena.append("                       WHERE SO.SOCA_OID_SOLI_CABE = " + dto.getOidCabeceraSolicitud());
        cadena.append("                         AND SO.OPRE_OID_OPER_RECL = OPR.OID_OPER_RECL ");
        cadena.append("                         AND OPR.CARE_OID_CABE_RECL = BR.CARE_OID_CABE_RECL ");
        cadena.append("                    ORDER BY BR.NUM_BOLE DESC) ");
        cadena.append("             WHERE ROWNUM = 1) ");
        
 		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			bs.dbService.executeUpdate(cadena.toString());
		} catch (Exception e) {
			UtilidadesLog.error("ERROR: ",e);
		     ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		 }        
        UtilidadesLog.info("MONActualizarEstadoReclamos.actualizarBoletaRecojo (DTOFACCabeceraSolicitud dto):Salida");               
 
    }
    
}