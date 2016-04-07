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
 * @author Sergio Saavedra
 * @date 01/07/2005
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005  
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOMontoUnidades;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;


public class ClienteConcursoBaseCalculoRanking implements Serializable {
    private Long oidCliente;
    private DatosConcurso concurso;
    private DatosConsultora cliente;
    private ResultadosRanking resultado;
    private Periodo periodoCalculo;

    /**
     * Sistema: Belcorp
     * Módulo: INC
     * Fecha:  05/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public ClienteConcursoBaseCalculoRanking(Long oidCliente,
        DatosConcurso datosConc, Periodo periodoCalculo)
        throws MareException {
        this.concurso = datosConc;

        DAOVariablesVentaRanking daoVvr = new DAOVariablesVentaRanking();
        this.concurso.setPeriodoDesde(daoVvr.recuperarPeriodoDesde(
                this.concurso.getOidConcurso()));
        this.concurso.setPeriodoHasta(daoVvr.recuperarPeriodoHasta(
                this.concurso.getOidConcurso()));
        this.concurso.setPeriodosConcurso(daoVvr.recuperarPeriodosConcurso(
                this.concurso.getOidConcurso()));

        this.oidCliente = oidCliente;
        this.resultado = new ResultadosRanking();
        this.periodoCalculo = periodoCalculo;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return this.oidCliente;
    }

    public void setConcurso(DatosConcurso concurso) {
        this.concurso = concurso;
    }

    public DatosConcurso getConcurso() {
        return this.concurso;
    }

    public void setCliente(DatosConsultora cliente) {
        this.cliente = cliente;
    }

    public DatosConsultora getCliente() {
        return this.cliente;
    }

    public void setResultado(ResultadosRanking resultado) {
        this.resultado = resultado;
    }

    public ResultadosRanking getResultado() {
        return this.resultado;
    }

    public void setPeriodoCalculo(Periodo periodoCalculo) {
        this.periodoCalculo = periodoCalculo;
    }

    public Periodo getPeriodoCalculo() {
        return this.periodoCalculo;
    }

    /**
      * Descripcion: Este método calcula el resultado base calculo para el 
      * cliente (oidCliente) en el periodo recibido por parametro 
      * (oidPeriodoCalculo).
      *  Si el cliente es un gerente el resultado
      * es la sumatoria del resultado de cada una de sus consultoras. 
      * Si el cliente es la consultora
      * el resultado se obtiene directamente.
      */
    public Boolean calcularResultado() throws MareException {
        UtilidadesLog.info(
            "ClienteConcursoBaseCalculoRanking.calcularResultado(): Entrada");

        if (this.concurso.getDirigidoA().equals(ConstantesINC
            .OID_DIRIGIDO_A_GERENTE)) {
            UtilidadesLog.info("concurso.getDirigidoA(): Gerentes");

            BigDecimal contador = new BigDecimal(0);

            DAOGerentes daoGer = new DAOGerentes();
            DAOBaseCalculo daoBC = new DAOBaseCalculo();
            UnidadesAdministrativasGerenciadas uniAdmGerenciadas = daoGer
                .obtenerUnidadesAdministrativasGerente(this.periodoCalculo
                .getOidPais(), this.periodoCalculo.getOidMarca(),
                    this.periodoCalculo.getOidCanal(), this.oidCliente);
            UtilidadesLog.debug("UnidadesAdministrativasGerenciadas.getSubGer"
                +"encias(): " + uniAdmGerenciadas.getSubGerencias());
            UtilidadesLog.debug("UnidadesAdministrativasGerenciadas.getRegio"
                +"nes(): " + uniAdmGerenciadas.getRegiones());
            UtilidadesLog.debug("UnidadesAdministrativasGerenciadas.getZonas"
                +"(): " + uniAdmGerenciadas.getZonas());
            UtilidadesLog.debug("UnidadesAdministrativasGerenciadas.getSeccio"
                +"nes(): " + uniAdmGerenciadas.getSecciones());
            UtilidadesLog.debug("UnidadesAdministrativasGerenciadas.getUnida"
                +"desGerenciadas(): " + uniAdmGerenciadas
                    .getUnidadesGerenciadas());
                    
            // Procesa solo los gerentes reales        
            if(uniAdmGerenciadas.getSubGerencias()!=null || uniAdmGerenciadas.getRegiones()!=null 
               || uniAdmGerenciadas.getZonas()!=null || uniAdmGerenciadas.getSecciones()!=null) {
               
                UtilidadesLog.debug("es gerente: " + this.oidCliente);

                RecordSet rsConsultoras = daoBC.obtenerConsultoras(this.concurso
                    .getPeriodoDesde(),this.concurso.getPeriodoHasta(), 
                    uniAdmGerenciadas);
    
                UtilidadesLog.debug("rsConsultoras: " + rsConsultoras);
    
                if ((rsConsultoras != null) && (rsConsultoras.getRowCount() > 0)) {
                    Object o = null;
    
                    for (int pos = 0; rsConsultoras.getRowCount() > pos; pos++) {
                        o = rsConsultoras.getValueAt(pos, "clie_oid_clie");
    
                        if (o != null) {
                            UtilidadesLog.debug("rsConsultora a procesar: " +
                                o.toString());
                            contador = contador.add(this.procesarConsultora(
                                        new Long(((BigDecimal) o).toString()),
                                        uniAdmGerenciadas));
                            UtilidadesLog.debug("contador parcial: " + contador);
                        }
                    }
                }
    
                UtilidadesLog.debug("contador final: " + contador);
    
                this.actualizarResultado(contador);
                
            } else {
                UtilidadesLog.debug("no es gerente: " + this.oidCliente);
                return null;
            }
            
        } else {
            UtilidadesLog.info("concurso.getDirigidoA(): Consultora");
            this.actualizarResultado(this.procesarConsultora(this.oidCliente,
                    null));
        }
        
        UtilidadesLog.info(
            "ClienteConcursoBaseCalculoRanking.calcularResultado(): Salida");
        return Boolean.TRUE;
    }

    /**
     */
    public void actualizarResultado(BigDecimal valor) throws MareException {
        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.actualizarResul"
            +"tado(BigDecimal valor): Entrada");

        if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_MONTO.longValue()) {
            this.resultado.setMontoVentas(valor);
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_UNIDADES.longValue()) {
            this.resultado.setUnidadesVendidas(new Long(valor.toString()));
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_NPEDIDOS.longValue()) {
            this.resultado.setNumeroPedidos(new Long(valor.toString()));
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_RECOMENDADAS.longValue()) {
            this.resultado.setNumeroRecomendadas(new Long(valor.toString()));
        }

        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.actualizarResul"
            +"tado(BigDecimal valor): Salida");
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @autor SCS
     * @ Descripcion: este método procesa una consultora.
     */
    public BigDecimal procesarConsultora(Long oidConsultora,
        UnidadesAdministrativasGerenciadas uniAdmGerenciadas) 
        throws MareException {
        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.procesarConsul"
            +"tora(Long oidConsultora,UnidadesAdministrativasGerenciadas uniAd"
            +"mGerenciadas): Entrada");

        Periodo periodoDesde = new Periodo();
        Periodo auxPeriodoCalculo = null;
        MONRanking monRanking = this.getMONRanking();
        
        // vbongiov -- 11/06/2006 -- inc DBLG500000934
        periodoDesde = this.concurso.getPeriodoDesde();
        
        if(!((ConstantesINC.OID_BASE_CALCULO_MONTO.equals(this.concurso.getBaseCalculo()) ||
             ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(this.concurso.getBaseCalculo())) 
             && ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.equals(this.concurso.getDirigidoA()))) {
             
                if (ConstantesINC.TIPO_RANKING_EVOLUTIVO.equals(this.concurso.getTipoRanking())) {
                    periodoDesde = this.periodoCalculo;           
                }               
        }                   

        if (this.concurso.getTipoRanking().longValue() == ConstantesINC.TIPO_RANKING_EVOLUTIVO.longValue()) {
            auxPeriodoCalculo = this.periodoCalculo;
            
        } else if (this.concurso.getTipoRanking().longValue() == ConstantesINC.TIPO_RANKING_INTERACTIVO.longValue()) {
            
            if(this.periodoCalculo.getFechaDesde().getTime() > this.concurso.getPeriodoHasta().getFechaDesde().getTime()) {
               auxPeriodoCalculo = this.concurso.getPeriodoHasta();
            } else {               
               auxPeriodoCalculo = this.periodoCalculo;
            }
        }

        UtilidadesLog.debug("periodoDesde: " + periodoDesde.getOidPeriodo());
        
        // vbongiov -- 27/07/2006 -- inc DBLG500000937
        // Obtiene datos consultora
        DatosConsultora datosConsultora = new DatosConsultora();
        ConcursosRankingHelper concursosRankingHelper = new ConcursosRankingHelper();
        
        datosConsultora = concursosRankingHelper.obtenerDatosConsultora(oidConsultora);
        UtilidadesLog.info("DatosConsultora: " + datosConsultora);

        if (this.concurso.getBaseCalculo().longValue() == ConstantesINC.OID_BASE_CALCULO_MONTO.longValue()) {
            UtilidadesLog.info("Base Calculo: Monto");
            
            if (this.cumpleExigenciasActividadConstancia(datosConsultora, auxPeriodoCalculo)) {
                UtilidadesLog.info("cumple ActividadConstancia");
                try{
                    monRanking.preProcesoSolicitudesRanking(oidConsultora, this.concurso.getOidConcurso(),
                                                        periodoDesde, auxPeriodoCalculo);
                } catch (RemoteException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }  
                
               // vbongiov -- 27/07/2006 -- inc DBLG500000937
                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                DTOMontoUnidades dtoDTOMontoUnidades = daoBC
                    .obtenerMontoUnidadesRanking(oidConsultora, this.concurso
                        .getOidConcurso(), periodoDesde, auxPeriodoCalculo, 
                            uniAdmGerenciadas);
    
                return dtoDTOMontoUnidades.getMonto();
                
            } else {
                UtilidadesLog.info("no cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                daoBC.grabarClienteFaltaConstanciaActividad(oidConsultora,
                    auxPeriodoCalculo);

                return new BigDecimal(0);
            }
            
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC.OID_BASE_CALCULO_UNIDADES.longValue()) {
            UtilidadesLog.info("Base Calculo: Unidades");
            
            // vbongiov -- 27/07/2006 -- inc DBLG500000937
            if (this.cumpleExigenciasActividadConstancia(datosConsultora, auxPeriodoCalculo)) {
                UtilidadesLog.info("cumple ActividadConstancia");
                try{
                    monRanking.preProcesoSolicitudesRanking(oidConsultora, this.concurso.getOidConcurso(),
                                                        periodoDesde, auxPeriodoCalculo);
                           
                } catch (RemoteException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }    
    
                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                DTOMontoUnidades dtoDTOMontoUnidades = daoBC.obtenerMontoUnidadesRanking(
                        oidConsultora,this.concurso.getOidConcurso(),
                        periodoDesde, auxPeriodoCalculo, uniAdmGerenciadas);
    
                return new BigDecimal(dtoDTOMontoUnidades.getUnidades().toString());
                
            } else {
                UtilidadesLog.info("no cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                daoBC.grabarClienteFaltaConstanciaActividad(oidConsultora,
                    auxPeriodoCalculo);

                return new BigDecimal(0);
            }
            
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_NPEDIDOS.longValue()) {
            UtilidadesLog.info("Base Calculo: Pedidos");
            
            // vbongiov -- 27/07/2006 -- inc DBLG500000937
            if (this.cumpleExigenciasActividadConstancia(datosConsultora, auxPeriodoCalculo)) {
                UtilidadesLog.info("cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();

                return daoBC.calcularNumeroPedidos(oidConsultora, periodoDesde,
                    auxPeriodoCalculo, uniAdmGerenciadas);
            } else {
                UtilidadesLog.info("no cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                daoBC.grabarClienteFaltaConstanciaActividad(oidConsultora,
                    auxPeriodoCalculo);

                return new BigDecimal(0);
            }
        } else if (this.concurso.getBaseCalculo().longValue() == ConstantesINC
            .OID_BASE_CALCULO_RECOMENDADAS.longValue()) {
            UtilidadesLog.info("Base Calculo: Recomendadas");

            // vbongiov -- 27/07/2006 -- inc DBLG500000937
            if (this.cumpleExigenciasActividadConstancia(datosConsultora, auxPeriodoCalculo)) {
                UtilidadesLog.info("cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();

                return daoBC.calcularRecomendadas(oidConsultora, periodoDesde,
                    auxPeriodoCalculo, uniAdmGerenciadas);
            } else {
                UtilidadesLog.info("no cumple ActividadConstancia");

                DAOBaseCalculo daoBC = new DAOBaseCalculo();
                daoBC.grabarClienteFaltaConstanciaActividad(oidConsultora,
                    auxPeriodoCalculo);

                return new BigDecimal(0);
            }
        }

        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.procesarConsul"
            +"tora(Long oidConsultora, UnidadesAdministrativasGerenciadas "
                +"uniAdmGerenciadas): Salida");

        return null;
    }
    
    /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   27/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000937
   */
    public boolean cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo) throws MareException {
        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Entrada");
        
        if(ConstantesINC.TIPO_EXIGENCIA_ACTIVIDAD.equals(this.getConcurso().getTipoExigenciaRanking())){
            UtilidadesLog.info("verifica actividad");
            if (this.concurso.esActiva(cliente, auxPeriodoCalculo).booleanValue()) {
                UtilidadesLog.info("es activa");
                UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Salida");
                return true;
            } else {
                UtilidadesLog.info("no es activa");
                UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Salida");
                return false;
            }
          
        } else if(ConstantesINC.TIPO_EXIGENCIA_CONSTANCIA.equals(this.getConcurso().getTipoExigenciaRanking())){
            UtilidadesLog.info("verifica constancia");
            if (this.concurso.esConstante(cliente, auxPeriodoCalculo).booleanValue()) {
                UtilidadesLog.info("es constante");
                UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Salida");
                return true;
            } else {
                UtilidadesLog.info("no es constante");
                UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Salida");
                return false;
            }
        }
        
        UtilidadesLog.info("ClienteConcursoBaseCalculoRanking.cumpleExigenciasActividadConstancia (DatosConsultora cliente, Periodo auxPeriodoCalculo): Salida");
        return true;
    }
    
    private MONRanking getMONRanking() throws MareException {
   
      MONRanking monRanking = null;
   
      try{
      
          final InitialContext context = new InitialContext();
          MONRankingHome monRankingHome = (MONRankingHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRanking"), MONRankingHome.class);
  
          monRanking = monRankingHome.create();
          
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
      return monRanking;
  }
  
   
}
