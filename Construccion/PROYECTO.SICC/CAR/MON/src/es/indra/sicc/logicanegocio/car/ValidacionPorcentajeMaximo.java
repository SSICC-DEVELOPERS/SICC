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

public class ValidacionPorcentajeMaximo  {

    private BigDecimal deudaVencidaCliente;
    private BigDecimal deudaTotal;
    private BigDecimal valorPorcentaje;   

    public ValidacionPorcentajeMaximo(BigDecimal deudaVen, BigDecimal deudaTotal, BigDecimal valorPor) {
        this.deudaVencidaCliente = deudaVen;
        this.deudaTotal = deudaTotal;
        this.valorPorcentaje = valorPor;
    }   

    public Boolean validar() {
        UtilidadesLog.info("ValidacionPorcentajeMaximo.validar():Entrada");

        if(this.deudaTotal.compareTo(new BigDecimal(0))== 0){
            UtilidadesLog.info("ValidacionPorcentajeMaximo.validar():Salida");
            return Boolean.TRUE;
        }
        
        UtilidadesLog.debug("this.deudaVencidaCliente: " + this.deudaVencidaCliente);
        UtilidadesLog.debug("this.deudaTotal: " + this.deudaTotal);
        UtilidadesLog.debug("this.valorPorcentaje: " + this.valorPorcentaje);
 
        int compare = this.deudaVencidaCliente.divide(this.deudaTotal, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).compareTo(this.valorPorcentaje);
        
        if(compare == 1){            
            UtilidadesLog.info("ValidacionPorcentajeMaximo.validar():Salida");
            return Boolean.FALSE;
        } else {
            UtilidadesLog.info("ValidacionPorcentajeMaximo.validar():Salida");
            return Boolean.TRUE;
        }         
    }
    
}