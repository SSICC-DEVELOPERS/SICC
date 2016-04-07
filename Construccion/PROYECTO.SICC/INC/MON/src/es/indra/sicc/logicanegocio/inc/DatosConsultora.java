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

import java.io.Serializable;
import java.util.HashMap;

public class DatosConsultora implements Serializable {
    private Long oidConsultora;
    private Periodo periodoPrimerContacto;
    private HashMap periodosConPedidos;
    private AmbitoGeografico unidadesAdmnistrativasGerenciadas;

    public DatosConsultora() {
    }

    public void setOidConsultora(Long oidConsultora) {
        this.oidConsultora = oidConsultora;
    }

    public Long getoidConsultora() {
        return oidConsultora;
    }

    public Periodo getPeriodoPrimerContacto() {
        return periodoPrimerContacto;
    }

    public void setPeriodoPrimerContacto(Periodo periodoPrimerContacto) {
        this.periodoPrimerContacto = periodoPrimerContacto;
    }

    public HashMap getPeriodosConPedidos() {
        return periodosConPedidos;
    }

    public void setPeriodosConPedidos(HashMap periodosConPedidos) {
        this.periodosConPedidos = periodosConPedidos;
    }

    public AmbitoGeografico getUnidadesAdmnistrativasGerenciadas() {
        return unidadesAdmnistrativasGerenciadas;
    }

    public void setUnidadesAdmnistrativasGerenciadas(AmbitoGeografico 
        unidadesAdmnistrativasGerenciadas) {
        this.unidadesAdmnistrativasGerenciadas = 
            unidadesAdmnistrativasGerenciadas;
    }

    //Este método determina si el cliente ha pasado al menos una solicitud para
    //el periodo dado. 
    public Boolean pasoPedidos(Long oidPeriodo) throws MareException {
        return new Boolean(this.periodosConPedidos.containsKey(oidPeriodo));
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("DatosConsultora:");
        
        sb.append(" oidConsultora:"
            + this.getoidConsultora());
        sb.append("; periodoPrimerContacto:"
            + this.getPeriodoPrimerContacto());
        sb.append("; periodosConPedidos:"
            + this.getPeriodosConPedidos());
        sb.append("; unidadesAdmnistrativasGerenciadas:"
            + this.getUnidadesAdmnistrativasGerenciadas());
      
        return sb.toString();
    }

}
