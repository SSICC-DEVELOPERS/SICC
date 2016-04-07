/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 *
 * @date 30/06/2005
 * @author SCS
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 * 
 * 
*/
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.util.ArrayList;

public class DatosConcurso implements Serializable {
    private Long oidConcurso;
    private Long baseCalculo;
    private Long dirigidoA;
    private Long tipoRanking;
    private Periodo periodoDesde;
    private Periodo periodoHasta;
    private ArrayList periodosConcurso;
    // vbongiov -- 27/07/2006 -- inc DBLG500000937
    private Long tipoExigenciaRanking;

    public DatosConcurso() {
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setBaseCalculo(Long baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public Long getBaseCalculo() {
        return baseCalculo;
    }

    public void setDirigidoA(Long dirigidoA) {
        this.dirigidoA = dirigidoA;
    }

    public Long getDirigidoA() {
        return dirigidoA;
    }

    public void setTipoRanking(Long tipoRanking) {
        this.tipoRanking = tipoRanking;
    }

    public Long getTipoRanking() {
        return tipoRanking;
    }

    public void setPeriodoDesde(Periodo periodoDesde) {
        this.periodoDesde = periodoDesde;
    }

    public Periodo getPeriodoDesde() {
        return periodoDesde;
    }

    public void setPeriodoHasta(Periodo periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    public Periodo getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodosConcurso(ArrayList periodosConcurso) {
        this.periodosConcurso = periodosConcurso;
    }

    public ArrayList getPeriodosConcurso() {
        return periodosConcurso;
    }
    
    public Long getTipoExigenciaRanking() {
      return tipoExigenciaRanking;
    }
  
    public void setTipoExigenciaRanking(Long tipoExigenciaRanking) {
      this.tipoExigenciaRanking = tipoExigenciaRanking;
    }

    //Descripcion: Este método determina si el cliente es Activo para un rango
    //de periodos 
    public Boolean esActiva(DatosConsultora cliente, Periodo periodoCalculo)
            throws MareException {
        UtilidadesLog.info("DatosConcurso.esActiva(DatosConsultora cliente, "
            +"Periodo periodoCalculo):Entrada");
        UtilidadesLog.info("dentro de esActiva, DatosConsultora/Periodo : "
            + cliente + " / " + periodoCalculo);

        boolean retorno = true;
        Periodo periodoIngreso = (cliente.getPeriodoPrimerContacto() != null) 
            ? cliente.getPeriodoPrimerContacto() : this.getPeriodoDesde();
        Periodo periodoInicial = (!(periodoIngreso.menorQue(
            this.periodoDesde))) ? this.periodoDesde : periodoIngreso;
        Periodo periodoFinal = (periodoCalculo.menorQue(this.periodoHasta) 
            || periodoCalculo.equals(this.periodoHasta)) ? periodoCalculo : this.periodoHasta;
            
        UtilidadesLog.debug("periodoIngreso: " + periodoIngreso);
        UtilidadesLog.debug("periodoInicial: " + periodoInicial);
        UtilidadesLog.debug("periodoFinal: " + periodoFinal);                                                                                                                       

        if ((this.periodosConcurso != null) && (this.periodosConcurso.size()
            > 0)) {
            int contador = 0;

            for (int j = 0; j < periodosConcurso.size(); j++) {
                Periodo registro = (Periodo) periodosConcurso.get(j);
                
                UtilidadesLog.debug("registro: " + registro);

                if ((registro.getFechaDesde().getTime() >= periodoInicial
                    .getFechaDesde().getTime()) &&
                        (registro.getFechaDesde().getTime() <= periodoFinal
                            .getFechaDesde().getTime())) {
                    if (!cliente.pasoPedidos(registro.getOidPeriodo()).booleanValue()) {
                        UtilidadesLog.debug(" no paso pedido en: " + registro.getOidPeriodo());
                        contador++;
                    }

                    if (contador > 1) {
                        retorno = false;

                        break;
                    } else {
                        contador = 0;
                    }
                }
            }
        }
        UtilidadesLog.info("DatosConcurso.esActiva(DatosConsultora cliente,"
            +"Periodo periodoCalculo):Salida");
        return new Boolean(retorno);
    }

 
    /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   27/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000937
   */
    public Boolean esConstante(DatosConsultora cliente, Periodo periodoCalculo) throws MareException {
        UtilidadesLog.info("DatosConcurso.esConstante(DatosConsultora cliente, Periodo periodoCalculo):Entrada");
        UtilidadesLog.info("DatosConsultora/Periodo : " + cliente + " / " + periodoCalculo);

        boolean retorno = true;
        Periodo periodoIngreso = (cliente.getPeriodoPrimerContacto() != null)? cliente.getPeriodoPrimerContacto() : this.getPeriodoDesde();
        Periodo periodoInicial = (!(periodoIngreso.menorQue(this.periodoDesde))) ? this.periodoDesde : periodoIngreso;
        Periodo periodoFinal = (periodoCalculo.menorQue(this.periodoHasta) ||
                                periodoCalculo.equals(this.periodoHasta)) ? periodoCalculo : this.periodoHasta;
                                
        UtilidadesLog.debug("periodoIngreso: " + periodoIngreso);
        UtilidadesLog.debug("periodoInicial: " + periodoInicial);
        UtilidadesLog.debug("periodoFinal: " + periodoFinal);
   
        if ((this.periodosConcurso != null) && (this.periodosConcurso.size() > 0)) {
            int contador = 0;

            for (int j = 0; j < periodosConcurso.size(); j++) {
                Periodo registro = (Periodo) periodosConcurso.get(j);
                
                UtilidadesLog.debug("registro: " + registro);

                if ((registro.getFechaDesde().getTime() >= periodoInicial.getFechaDesde().getTime()) &&
                    (registro.getFechaDesde().getTime() <= periodoFinal.getFechaDesde().getTime())) {
                    
                    if (!cliente.pasoPedidos(registro.getOidPeriodo()).booleanValue()) {
                        UtilidadesLog.debug(" no es constante, no paso pedido en: " + registro.getOidPeriodo());
                        UtilidadesLog.info("DatosConcurso.esConstante(DatosConsultora cliente, Periodo periodoCalculo):Salida");
                        return Boolean.FALSE;
                    }
                }
            }
        }

        UtilidadesLog.debug("es constante");
        UtilidadesLog.info("DatosConcurso.esConstante(DatosConsultora cliente, Periodo periodoCalculo):Salida");
        return Boolean.TRUE;
    
    }
    
     public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("DatosConcurso:");
        
        sb.append(" oidConcurso:"
            + this.getOidConcurso());
        sb.append("; baseCalculo:"
            + this.getBaseCalculo());
        sb.append("; dirigidoA:"
            + this.getDirigidoA());
        sb.append("; tipoRanking:"
            + this.getTipoRanking());            
        sb.append(" periodoDesde:"
            + this.getPeriodoDesde());
        sb.append("; periodoHasta:"
            + this.getPeriodoHasta());
        sb.append("; periodosConcurso:"
            + this.getPeriodosConcurso());
        sb.append("; tipoExigenciaRanking:"
            + this.getTipoExigenciaRanking());
      
        return sb.toString();
    }
}
