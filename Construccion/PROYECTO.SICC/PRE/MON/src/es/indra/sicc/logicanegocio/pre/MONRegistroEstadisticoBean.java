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
package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.MatrizEstadisticaCodigoVentaLocal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.pre.MatrizEstadisticaCampanyaLocal;
import es.indra.sicc.entidades.pre.MatrizEstadisticaCampanyaLocalHome;
import es.indra.sicc.entidades.pre.MatrizEstadisticaCodigoVentaLocalHome;
import es.indra.sicc.entidades.pre.MatrizEstadisticaDevolucionesLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class MONRegistroEstadisticoBean implements SessionBean  {

    private SessionContext ctx;
    
    public void ejbCreate() {  }
    public void ejbActivate() {  }
    public void ejbPassivate() {  }
    public void ejbRemove() {  }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void generarRegistroEstadistico(DTOFACProcesoCierre dtoE) throws MareException {
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarRegistroEstadistico(DTOFACProcesoCierre dtoE): Entrada");

        this.generarEstadisticasCampanya(dtoE.getPeriodo());
        
        /* pperez - Este metodo ya no se debe ejecutar, fue reemplazado por un trigger en ped_solic_cabec --------  */
        /*  el cual carga la tabla PRE_MATRI_ESTAD_CODIG_VENT ----------------------------------------------------  */
        //this.generarEstadisticasCodigoVenta(dtoE.getPeriodo()); ------------------------------------------------  */
        /* -------------------------------------------------------------------------------------------------------  */
        this.generarEstadisticasDevoluciones(dtoE.getPeriodo());

        //BELC300018855    
        CabeceraMFLocalHome cabLH = new CabeceraMFLocalHome();
        CabeceraMFLocal cabeceraMF = null;
        try{
            cabeceraMF = cabLH.findByUK(dtoE.getPeriodo());
            cabeceraMF.setRegistroEstadisticoGenerado(Boolean.TRUE);
            cabLH.merge(cabeceraMF);
            
        } catch (NoResultException e) {            
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarRegistroEstadistico(DTOFACProcesoCierre dtoE): Salida");
    }

    public void generarEstadisticasCampanya(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasCampanya(Long oidPeriodo): Entrada");
        
        CabeceraMFLocal cabeceraMF = null;
        
        try{
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            cabeceraMF = cmflh.findByUK(oidPeriodo);
        } catch (NoResultException e){            
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        DAORegistroEstadistico dao = new DAORegistroEstadistico();
        RecordSet rs = dao.obtenerDatosEstadísticos(oidPeriodo);
        //Long numeroRealSolicitudes = dao.obtenerNumeroRealPedidos(oidPeriodo);
        Long numeroRealSolicitudes =  new Long(((BigDecimal)rs.getValueAt(0,"NREALSOLIC")).longValue());

        //Long numeroRealClientes = dao.obtenerNumeroRealClientes(oidPeriodo);
        Long numeroRealClientes = new Long(((BigDecimal)rs.getValueAt(0,"NREALCLIENTES")).longValue());

        //Long numeroRealUnidades = dao.obtenerNumeroRealUnidades(oidPeriodo);
        Long numeroRealUnidades = new Long(((BigDecimal)rs.getValueAt(0,"NREALUNID")).longValue());

        //BigDecimal montoFacturadoRealLocal = dao.obtenerMontoFacturadoRealLocal(oidPeriodo);
        BigDecimal montoFacturadoRealLocal = (BigDecimal)rs.getValueAt(0,"MONTOFACTREAL");

        /*
         * BELC300024390 - dmorello, 15/12/2006
         * Se calculara el monto en dolares DIVIDIENDO por el tipo de cambio.
         * También se hacen correcciones para evitar posibles perdidas de precision
         */
        //double mfr = montoFacturadoRealLocal != null ? montoFacturadoRealLocal.doubleValue() : 0;
        //double tipoCambio = cabeceraMF.getTipoCambio() != null ? cabeceraMF.getTipoCambio().doubleValue() : 0;
        
        //BigDecimal montoFacturadoRealDolares = new BigDecimal(mfr * tipoCambio);
        
        BigDecimal tipoCambio;
        if (cabeceraMF.getTipoCambio() != null)
            tipoCambio = new BigDecimal(cabeceraMF.getTipoCambio().toString());
        else
            tipoCambio = null;
        
        BigDecimal montoFacturadoRealDolares;
        if (montoFacturadoRealLocal != null) {
            // El tipo de cambio viene informado cuando la moneda no es nula
            if (cabeceraMF.getMoneda() != null)
                montoFacturadoRealDolares = montoFacturadoRealLocal.divide(tipoCambio, BigDecimal.ROUND_HALF_EVEN);
            else
                montoFacturadoRealDolares = montoFacturadoRealLocal;
        } else {
            montoFacturadoRealDolares = new BigDecimal(0);
        }
        /* Fin BELC300024390 dmorello 15/12/2006 */

        //Long numeroRealPedidosAnulados = dao.obtenerNumeroRealPedidosAnulados(oidPeriodo);
        Long numeroRealPedidosAnulados = new Long(((BigDecimal)rs.getValueAt(0,"NREALPEDIANULA")).longValue());

        //BigDecimal montoLocalAnulaciones = dao.obtenerMontoLocalAnulaciones(oidPeriodo);
        BigDecimal montoLocalAnulaciones = (BigDecimal)rs.getValueAt(0,"MONTOREALANUL");

        //Long numeroRealPedidosDevueltos = dao.obtenerNumeroRealPedidosDevueltos(oidPeriodo);
        Long numeroRealPedidosDevueltos = new Long(((BigDecimal)rs.getValueAt(0,"NREALPEDIDEVO")).longValue());

        //BigDecimal montoLocalDevoluciones = dao.obtenerMontoLocalDevoluciones(oidPeriodo);
        BigDecimal montoLocalDevoluciones = (BigDecimal)rs.getValueAt(0,"MONTOREALDEVO");

        // Actualiza la entidad "Matriz - Estadistica Campaña" 
        // Si ya existen datos para la campaña, los elimina
        MatrizEstadisticaCampanyaLocal matrizEstadisticaCampanya = null;
        MatrizEstadisticaCampanyaLocalHome mecLH = this.getMatrizEstadisticaCampanyaLocalHome();
        try{
            matrizEstadisticaCampanya = mecLH.findByUK(cabeceraMF.getOid());
        } catch (NoResultException e) {
            UtilidadesLog.debug("*** Metodo MONRegistroEstadistico.generarEstadisticasCampanya: noresultexception al buscar en MatrizEstadisticaCampanya");
        }

        if (matrizEstadisticaCampanya != null) {
            try {
                mecLH.remove(matrizEstadisticaCampanya);                
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        } 
        
        try{
            matrizEstadisticaCampanya = mecLH.create(cabeceraMF.getOid());
        } catch (PersistenceException e){
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        matrizEstadisticaCampanya.setNumeroEstimadoPedidos(cabeceraMF.getNumeroPedidosEstimados());
        matrizEstadisticaCampanya.setNumeroEstimadoUnidades(cabeceraMF.getUnidadesEstimadas());
        matrizEstadisticaCampanya.setNumeroEstimadoClientes(cabeceraMF.getClientesEstimados());
        matrizEstadisticaCampanya.setMontoEstimadoLocal(new BigDecimal(cabeceraMF.getTotalMontoVentaNeta().doubleValue()));        
        /*
         * dmorello, 28/11/2006:
         * Se calcula el monto estimado en dolares DIVIDIENDO por el tipo de cambio
         * Se hacen tambien correcciones para evitar perdidas de precision
         */
        //double totalMontoVentaNeta = cabeceraMF.getTotalMontoVentaNeta() != null ? cabeceraMF.getTotalMontoVentaNeta().doubleValue() : 0;
        BigDecimal totalMontoVentaNeta;
        if (cabeceraMF.getTotalMontoVentaNeta() != null)
            totalMontoVentaNeta = new BigDecimal(cabeceraMF.getTotalMontoVentaNeta().toString());
        else
            totalMontoVentaNeta = new BigDecimal(0);
            
        BigDecimal montoEstimadoDolares;
        // El tipo de cambio viene informado cuando la moneda no es nula
        if (cabeceraMF.getMoneda() != null)
            montoEstimadoDolares = totalMontoVentaNeta.divide(tipoCambio, BigDecimal.ROUND_HALF_EVEN);
        else
            montoEstimadoDolares = totalMontoVentaNeta;
        
        matrizEstadisticaCampanya.setMontoEstimadoDolares(montoEstimadoDolares);
        /* Fin BELC300024390 dmorello 28/11/2006 */
        matrizEstadisticaCampanya.setNumeroRealPedidos(numeroRealSolicitudes);
        matrizEstadisticaCampanya.setNumeroRealUnidades(numeroRealUnidades);
        matrizEstadisticaCampanya.setNumeroRealClientes(numeroRealClientes);
        matrizEstadisticaCampanya.setMontoFacturadoLocal(montoFacturadoRealLocal);
        matrizEstadisticaCampanya.setMontoFacturadoDolares(montoFacturadoRealDolares);
        matrizEstadisticaCampanya.setNumeroPedidosAnulados(numeroRealPedidosAnulados);
        matrizEstadisticaCampanya.setMontoLocalAnulaciones(montoLocalAnulaciones);
        matrizEstadisticaCampanya.setNumeroPedidosDevueltos(numeroRealPedidosDevueltos);
        matrizEstadisticaCampanya.setMontoLocalDevoluciones(montoLocalDevoluciones);
        mecLH.merge(matrizEstadisticaCampanya);
        
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasCampanya(Long oidPeriodo): Salida");
    }

    public void generarEstadisticasCodigoVenta(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasCodigoVenta(Long oidPeriodo): Entrada");
        
        DAORegistroEstadistico dao = new DAORegistroEstadistico();
        RecordSet estadisticasCV = dao.obtenerEstadisticasCV(oidPeriodo);
        
        RecordSet estadisticasCVanuladas = dao.obtenerEstadisticasCVanuladas(oidPeriodo);
        
        RecordSet estadisticasCVdevueltas = dao.obtenerEstadisticasCVdevueltas(oidPeriodo);
        
        if (!estadisticasCV.esVacio()){
            for (int i = 0; i < estadisticasCV.getRowCount(); i++){
                String codigoVenta = estadisticasCV.getValueAt(i, "CODIGO_VENTA").toString();
                int posicionAnulada = -1;
                int posicionDevuelta = -1;
                
                if (!estadisticasCVanuladas.esVacio()){
                    for (int j = 0; j < estadisticasCVanuladas.getRowCount(); j++){
                        if (codigoVenta.equals(estadisticasCVanuladas.getValueAt(j,"CODIGO_VENTA").toString())){
                            posicionAnulada = j;
                            break;
                        }
                    }
                }
                
                if (!estadisticasCVdevueltas.esVacio()){
                    for (int j = 0; j < estadisticasCVdevueltas.getRowCount(); j++){
                        if (codigoVenta.equals(estadisticasCVdevueltas.getValueAt(j,"CODIGO_VENTA").toString())){
                            posicionDevuelta = j;
                            break;
                        }
                    }
                }
                
                MatrizEstadisticaCodigoVentaLocal matrizEstadisticaCodigoVenta = null;
                MatrizEstadisticaCodigoVentaLocalHome mecvLH = this.getMatrizEstadisticaCodigoVentaLocalHome();
                try{
                    matrizEstadisticaCodigoVenta = mecvLH.findByUK(new Long(estadisticasCV.getValueAt(i,"OID_MF").toString()));
                    mecvLH.remove(matrizEstadisticaCodigoVenta);
                } catch(NoResultException e) {
                    UtilidadesLog.debug("*** Metodo MONRegistroEstadistico.generarEstadisticasCodigoVenta: noresultexception al buscar en MatrizEstadisticaCodigoVenta");
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();                    
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
                
                try {
                    matrizEstadisticaCodigoVenta = mecvLH.create(new Long(estadisticasCV.getValueAt(i, "OID_MF").toString()));
                } catch (PersistenceException e){
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                matrizEstadisticaCodigoVenta.setUnidadesEstimadas(new Long(estadisticasCV.getValueAt(i, "UNIDADES_ESTIMADAS").toString()));
                matrizEstadisticaCodigoVenta.setMontoEstimadoFacturar((BigDecimal)estadisticasCV.getValueAt(i, "MONTO_ESTIMADO_LOCAL")); 
                matrizEstadisticaCodigoVenta.setUnidadesFacturadas(new Long(estadisticasCV.getValueAt(i, "UNIDADES_FACTURADAS").toString())); 
                matrizEstadisticaCodigoVenta.setMontoFacturado((BigDecimal)estadisticasCV.getValueAt(i, "MONTO_FACTURADO"));
                matrizEstadisticaCodigoVenta.setUnidadesFaltantes(new Long(estadisticasCV.getValueAt(i, "UNIDADES_FALTANTES").toString()));
                double montoFacturado = matrizEstadisticaCodigoVenta.getMontoEstimadoFacturar() != null ? 
                                            matrizEstadisticaCodigoVenta.getMontoEstimadoFacturar().doubleValue() : 0;
                long unidadesFacturadas = matrizEstadisticaCodigoVenta.getUnidadesFacturadas() != null ?
                                        matrizEstadisticaCodigoVenta.getUnidadesFacturadas().longValue() : 0;
                long unidadesFaltantes = matrizEstadisticaCodigoVenta.getUnidadesFaltantes() != null ?
                                        matrizEstadisticaCodigoVenta.getUnidadesFaltantes().longValue() : 0;
                if (unidadesFacturadas != 0){
                    matrizEstadisticaCodigoVenta.setMontoFaltante(new BigDecimal((montoFacturado / unidadesFacturadas) * unidadesFaltantes));
                }
                
                if (posicionAnulada != -1){
                    matrizEstadisticaCodigoVenta.setUnidadesAnuladas(new Long(estadisticasCVanuladas.getValueAt(posicionAnulada, "UNIDADES_ANULADAS").toString())); 
                    matrizEstadisticaCodigoVenta.setMontoAnulado((BigDecimal)estadisticasCVanuladas.getValueAt(posicionAnulada, "MONTO_ANULADO"));     
                }else{
                    matrizEstadisticaCodigoVenta.setUnidadesAnuladas(new Long(0));
                    matrizEstadisticaCodigoVenta.setMontoAnulado(new BigDecimal(0));
                }
                
                
                if (posicionDevuelta != -1){
                    matrizEstadisticaCodigoVenta.setUnidadesDevueltas(new Long(estadisticasCVdevueltas.getValueAt(posicionDevuelta, "UNIDADES_DEVUELTAS").toString())); 
                    matrizEstadisticaCodigoVenta.setMontoDevuelto((BigDecimal)estadisticasCVdevueltas.getValueAt(posicionDevuelta, "MONTO_DEVUELTO"));
                }else{
                    matrizEstadisticaCodigoVenta.setUnidadesDevueltas(new Long(0));
                    matrizEstadisticaCodigoVenta.setMontoDevuelto(new BigDecimal(0));
                }
                mecvLH.merge(matrizEstadisticaCodigoVenta);
                                
            }
        }
        
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasCodigoVenta(Long oidPeriodo): Salida");
    } 

    public void generarEstadisticasDevoluciones(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasDevoluciones(Long oidPeriodo): Entrada");
        
        DAORegistroEstadistico dao = new DAORegistroEstadistico();
        dao.generarEstadisticasDevolucion(oidPeriodo);        

        UtilidadesLog.info("MONRegistroEstadisticoBean.generarEstadisticasDevoluciones(Long oidPeriodo): Salida");        
    }
    
    private MatrizEstadisticaCampanyaLocalHome getMatrizEstadisticaCampanyaLocalHome() {
        MatrizEstadisticaCampanyaLocalHome matrizEstadisticaCampanyaLocalHome = new MatrizEstadisticaCampanyaLocalHome();
        return matrizEstadisticaCampanyaLocalHome;
    }

    private MatrizEstadisticaCodigoVentaLocalHome getMatrizEstadisticaCodigoVentaLocalHome() {
        MatrizEstadisticaCodigoVentaLocalHome matrizEstadisticaCodigoVentaLocalHome = new MatrizEstadisticaCodigoVentaLocalHome();
        return matrizEstadisticaCodigoVentaLocalHome;
    }

    private MatrizEstadisticaDevolucionesLocalHome getMatrizEstadisticaDevolucionesLocalHome() {
        MatrizEstadisticaDevolucionesLocalHome matrizEstadisticaDevolucionesLocalHome =  new MatrizEstadisticaDevolucionesLocalHome();
        return matrizEstadisticaDevolucionesLocalHome;
    }
}