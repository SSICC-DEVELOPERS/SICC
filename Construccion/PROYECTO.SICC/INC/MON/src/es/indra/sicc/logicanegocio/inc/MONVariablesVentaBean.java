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
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOResultadoConcursoVariablesVenta;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONVariablesVentaBean
        implements SessionBean {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /*
      /**
        * @throws es.indra.mare.common.exception.MareException
        * @return
        * @version 1.00 16/06/2005
        * @author: Carlos Leal
        * Descripcion: este método efectua los calculos de variables de venta.
        */
    public void calcularVariablesVenta(DTOFACProcesoCierre dtoe)
            throws MareException {
        UtilidadesLog.info("MONVariablesVentaBean.calcularVariablesVenta(DTOFACProcesoCierre dtoe):Entrada");
        UtilidadesLog.debug("****Entro MONVariablesVenta.calcularVariablesVenta****");
        UtilidadesLog.debug("*** dto: " + dtoe);

        InfoGerentesConcursos infoGerConc = new InfoGerentesConcursos(dtoe);
        DAOCargaVariablesVenta daoCarga = new DAOCargaVariablesVenta();
        DAOCalculoVariablesVenta daoCalculo = new DAOCalculoVariablesVenta();
        RecordSet rsGerConc;
        VariablesVentaHelper variablesVentaHelper = new VariablesVentaHelper();
        DTOResultadoConcursoVariablesVenta dtoResConc;
        Long auxOidConcurso = null;
        
        rsGerConc = daoCarga.obtenerGerentesConcursos(dtoe);
        UtilidadesLog.debug("rsGerConc: " + rsGerConc);

        int sizersGerConc = rsGerConc.getRowCount();
         UtilidadesLog.debug("sizersGerConc: " + sizersGerConc);

        for (int i = 0; i < sizersGerConc; i++) {
            UtilidadesLog.debug("Hay gerentes");

            AmbitoGeografico ambGeo = new AmbitoGeografico();
            ambGeo.setOidSubgerencia(rsGerConc.getValueAt(i, "OID_SUBG_VENT")==null?null:new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_SUBG_VENT")).longValue()));
            ambGeo.setOidRegion(rsGerConc.getValueAt(i, "OID_REGI")==null?null:new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_REGI")).longValue()));
            ambGeo.setOidZona(rsGerConc.getValueAt(i, "OID_ZONA")==null?null:new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_ZONA")).longValue()));
            ambGeo.setOidSeccion(rsGerConc.getValueAt(i, "OID_SECC")==null?null:new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_SECC")).longValue()));
            ambGeo.setOidTerritorio(rsGerConc.getValueAt(i, "OID_TERR_ADMI")==null?null:new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_TERR_ADMI")).longValue()));
            
            // vbongiov -- 6/04/2006 - inc 22684
            // Asigna el gerente de la UA
            Gerente ger = new Gerente();            
            Long oidCliente = new Long(((BigDecimal) rsGerConc.getValueAt(i, "CLIE_OID_CLIE")).longValue());
            
            ger.setOidCliente(oidCliente);
            
            if(ambGeo.getOidSeccion()!=null) {
                ambGeo.setLider(ger); 
            } else if(ambGeo.getOidZona()!=null) {
                ambGeo.setGerenteZona(ger); 
            } else if(ambGeo.getOidRegion()!=null) {
                ambGeo.setGerenteRegion(ger); 
            } else if(ambGeo.getOidSubgerencia()!=null) {
                ambGeo.setSubgerente(ger); 
            }
            

            Long oidParaGral = new Long(((BigDecimal) rsGerConc.getValueAt(i, "OID_PARA_GRAL")).longValue());
            
            int ambGeoComp = ((BigDecimal) rsGerConc.getValueAt(i, "VAL_AMBI_GEOG_COMP")).intValue();
            
            UtilidadesLog.debug("verifica AmbitoGeografico oidCliente: " + oidCliente);

            if (ambGeoComp == 0 && infoGerConc.cumpleAmbitoGeografico(oidParaGral, ambGeo, oidCliente)) {
                UtilidadesLog.debug("oidCliente cumple AmbitoGeografico: " + oidCliente);
                
                GerenteVariablesVenta gerVarVta = infoGerConc.getGerente(oidCliente);
                
                if(!oidParaGral.equals(auxOidConcurso)) {
                    gerVarVta.setProcesado(false);
                    auxOidConcurso = oidParaGral;
                }
                
                UnidadesAdministrativasGerenciadas backUnidGerenciadas = (UnidadesAdministrativasGerenciadas)deepCopy(gerVarVta.getUnidadesGerenciadas());
                UtilidadesLog.debug("UnidadesAdministrativasGerenciadas cloneada");
                
                // vbongiov -- 6/04/2006 - inc 22684
                if(backUnidGerenciadas.getUnidadesGerenciadas()!=null && (gerVarVta.getProcesado()==false)) {
                    UtilidadesLog.debug("oidCliente es gerente");
                    int sizeBackUni = backUnidGerenciadas.getUnidadesGerenciadas().size();
    
                    UtilidadesLog.debug("sizeBackUni: " + sizeBackUni);
    
                    for (int j = 0; j < sizeBackUni; j++) {
                        Long unidadGerenciada = (Long) backUnidGerenciadas.getUnidadesGerenciadas().get(j);
                        UtilidadesLog.debug("unidadGerenciada: " + unidadGerenciada);
                        
                        gerVarVta.getUnidadesGerenciadas().setUnidadGerenciada(unidadGerenciada);
                        gerVarVta.calcularResultadosVariables(infoGerConc.getPeriodoCierre());
                        dtoResConc = variablesVentaHelper.obtenerMontoUnidadesVenta(oidParaGral, infoGerConc, gerVarVta);
                        UtilidadesLog.debug("dtoResConc: " + dtoResConc);
                        
                        if(dtoResConc == null) {
                            dtoResConc = new DTOResultadoConcursoVariablesVenta();
                            dtoResConc.setOidConcurso(oidParaGral);
                            dtoResConc.setNumeroPedidos(Integer.valueOf("0"));
                            dtoResConc.setPrecioPromedioUnitario(new BigDecimal(0));
                            dtoResConc.setPromedioOrdenesPedidos(Double.valueOf("0"));
                            dtoResConc.setPromedioUnidadesPedidos(Double.valueOf("0"));
                            dtoResConc.setPromedioVentaPedidos(new BigDecimal(0));
                            dtoResConc.setTotalUnidadesVendidas(Long.valueOf("0"));
                            dtoResConc.setTotalVentaNetaEstadisticable(new BigDecimal(0));
                        }
                        
                        variablesVentaHelper.obtenerPrecioPromedioUnitario(dtoResConc);
                        daoCalculo.recuperarNumeroPedidos(dtoResConc, gerVarVta, infoGerConc);
                        variablesVentaHelper.obtenerPromedioVentaPedidos(dtoResConc);
                        variablesVentaHelper.obtenerPromedioUnidadesPedidos(dtoResConc);
                        variablesVentaHelper.obtenerPorcentajeActividad(dtoResConc, gerVarVta);
                        variablesVentaHelper.obtenerPromedioOrdenesPedidos(dtoResConc, gerVarVta);
                        daoCarga.guardarResultadosGerente(infoGerConc, dtoResConc, gerVarVta); //Descomentar cuando este resuelta la inc 19292
                        variablesVentaHelper.determinarGanadoras(infoGerConc, dtoResConc, gerVarVta);
                        
                        UtilidadesLog.debug("****Termino calculo para unidadGerenciada: " + unidadGerenciada);
                    }
                }
            }
            
        }

        UtilidadesLog.info("MONVariablesVentaBean.calcularVariablesVenta(DTOFACProcesoCierre dtoe):Salida");
    }
    
    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
 
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.error("ERROR ", e);
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }


}
