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
package es.indra.sicc.logicanegocio.car;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;

public class ValidacionCredito  {

    private BigDecimal lineaCreditoDisponible;
    private BigDecimal lineaCreditoDisponibleBase;
    private BigDecimal lineaCredito;
    private BigDecimal excesoLineaCredito;
    private Double porcentajeValidacion;
    private Integer indValidacion;
    private Date fechaVigenciaHasta;
    private Date fechaSolicitud;
    private Date fechaVigenciaDesde;

    public ValidacionCredito(BigDecimal lineaCreditoDisponibleBase, BigDecimal lineaCredito, BigDecimal excesoLineaCredito,
                             Double porcentajeValidacion, Integer indValidacion, Date fechaVigenciaHasta, 
                             Date fechaVigenciaDesde, Date fechaSolicitud) {
        
        this.lineaCreditoDisponibleBase = lineaCreditoDisponibleBase;
        this.lineaCredito = lineaCredito;
        this.excesoLineaCredito = excesoLineaCredito;
        this.porcentajeValidacion = porcentajeValidacion;
        this.indValidacion = indValidacion;
        this.fechaVigenciaHasta = fechaVigenciaHasta;
        this.fechaVigenciaDesde = fechaVigenciaDesde;
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setExcesoLineaCredito(BigDecimal exceso) {
        this.excesoLineaCredito = exceso;
    }

    private Boolean validarFechaSolicitud() {
        UtilidadesLog.info("ValidacionCredito.validarFechaSolicitud():Entrada ");

        if(this.fechaVigenciaDesde == null || this.fechaVigenciaHasta == null){
            UtilidadesLog.info("ValidacionCredito.validarFechaSolicitud():Salida ");
            return Boolean.FALSE;
        }

        if((this.fechaVigenciaDesde.getTime() <= this.fechaSolicitud.getTime()) && 
           (this.fechaSolicitud.getTime() <= this.fechaVigenciaHasta.getTime())){    
           UtilidadesLog.info("ValidacionCredito.validarFechaSolicitud():Salida ");
            return Boolean.TRUE;            
        }else{
            UtilidadesLog.info("ValidacionCredito.validarFechaSolicitud():Salida ");
            return Boolean.FALSE;
        }
    }

    private void modificarLineaCreditoDisponible() {
        UtilidadesLog.info("ValidacionCredito.modificarLineaCreditoDisponible():Entrada ");
        BigDecimal valorCalculo=(new BigDecimal(this.porcentajeValidacion.toString())).multiply(lineaCreditoDisponible).divide(new BigDecimal("100"), BigDecimal.ROUND_UP);

        if (this.indValidacion == null){
            return;
        }
        // Ampliación
        if(this.indValidacion.equals(Integer.valueOf("1"))){
            this.lineaCreditoDisponible = valorCalculo.add(this.lineaCreditoDisponible);
        }

        // Reducción
        if(this.indValidacion.equals(Integer.valueOf("2"))){
            this.lineaCreditoDisponible = this.lineaCreditoDisponible.subtract(valorCalculo);
        }
        UtilidadesLog.info("ValidacionCredito.modificarLineaCreditoDisponible():Salida ");
    }

    public Boolean validar() {
        UtilidadesLog.info("ValidacionCredito.validar():Entrada ");

        if(this.lineaCredito.compareTo(new BigDecimal(0))== 0){
            UtilidadesLog.info("ValidacionCredito.validar():Salida ");
            return Boolean.FALSE;
        }

        this.lineaCreditoDisponible = this.lineaCreditoDisponibleBase;

        // Valida fecha de la solicitud
        if(this.validarFechaSolicitud().booleanValue()){
            this.modificarLineaCreditoDisponible();
        }
        
        // Valida el credito
        if(this.lineaCreditoDisponible.compareTo(new BigDecimal("0")) == -1){       
        
            int compare = this.lineaCreditoDisponible.negate().divide(this.lineaCredito, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100")).compareTo(this.excesoLineaCredito);

            if(compare == 1){
                UtilidadesLog.info("ValidacionCredito.validar():Salida ");
                return Boolean.FALSE;
            } else {
                UtilidadesLog.info("ValidacionCredito.validar():Salida ");
                return Boolean.TRUE;
            }        
            
        } else {
            UtilidadesLog.info("ValidacionCredito.validar():Salida ");
            return Boolean.TRUE;
        }         
    }
    
}