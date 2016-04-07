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

public class ValidacionDeudaVencida  {

    private Long diasAtrasoDeuda;
    private Long numdias;
    private Long diasAdicionalesDeudaVencida;   

    public ValidacionDeudaVencida(Long diasAtraso, Long numDias, Long diasAdi) {
        this.diasAtrasoDeuda = diasAtraso;
        this.numdias = numDias;
        this.diasAdicionalesDeudaVencida = diasAdi;
    }

    public void setDiasAdicionalesDeudaVencida(Long dias) {
        this.diasAdicionalesDeudaVencida = dias;
    }

    public Boolean validar() {
        UtilidadesLog.info("ValidacionDeudaVencida.validar():Entrada ");

       UtilidadesLog.debug("diasAtrasoDeuda.longValue() y numdias.longValue(): " + diasAtrasoDeuda.longValue() + " - " + numdias.longValue()); 
    
        if (diasAtrasoDeuda.longValue() > numdias.longValue()) {
            if((diasAtrasoDeuda.longValue()-numdias.longValue()) <= diasAdicionalesDeudaVencida.longValue()) { 
                UtilidadesLog.info("ValidacionDeudaVencida.validar():Salida ");
                return Boolean.TRUE;
            } else {
                UtilidadesLog.info("ValidacionDeudaVencida.validar():Salida ");
                return Boolean.FALSE;
            }
        } else {
            UtilidadesLog.info("ValidacionDeudaVencida.validar():Salida ");
            return Boolean.TRUE;
        }
    }
    
}