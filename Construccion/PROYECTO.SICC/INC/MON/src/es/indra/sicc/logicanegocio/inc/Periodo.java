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
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;

import java.sql.Date;

//import es.indra.sicc.dtos.inc.DTOClienteAnticipo;
public class Periodo
        implements Serializable {
    private Long oidPeriodo;
    private Date fechaDesde;
    private Date fechaHasta;
    private String codperiodo;
    private Long oidPais;
    private Long oidMarca;
    private Long oidCanal;

    public Periodo() {
    }

    /**
     * Este método calcula si el periodo comienza antes de la fecha que se le pasa por cabecera
     */
    public boolean antesDe(Date fechaEntrada) {

        boolean f = false;

        if ((this.fechaDesde.getTime() <= fechaEntrada.getTime())) {
            f= true;
        } 
        
        UtilidadesLog.debug("Periodo.antesDe, f("+f+")fechaDesde="+this.fechaDesde+"<= fechaEntrada="+fechaEntrada);

        return f;
    }

    /*
     * Define si el objeto pasado por parámetro es igual a la instancia.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            UtilidadesLog.debug("Periodo equals: false ");
            return false;
        }

        if (!this.getClass().isInstance(obj)) {
            UtilidadesLog.debug("Periodo equals: false ");
            return false;
        }

        Periodo castObj = (Periodo) obj;
 
        //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                               
        /*if ((this.getFechaDesde() != null) && (this.getFechaHasta() != null) && this.getFechaDesde().equals(castObj.getFechaDesde()) &&
                this.getFechaHasta().equals(castObj.getFechaHasta())) {*/
        if(this.getOidPeriodo().longValue() == castObj.getOidPeriodo().longValue()) {               
            UtilidadesLog.debug("Periodo equals: true ");
            return true;
        } else {
            UtilidadesLog.debug("Periodo equals: false ");
            return false;
        }
    }

    /*
     * Este metodo permite conocer si un periodo esta contenido entre dos periodos
     */
    public boolean contenidoEn(Periodo pini, Periodo pfin) {
        UtilidadesLog.info("Peridodo.contenidoEn(Periodo pini, Periodo pfin):Entrada");
        Periodo periodoInicAux;
        Periodo periodoFinAux;
              
        //UtilidadesLog.info("Entro a contenido en con pini: " + pini + " perio fin: " + pfin);
        if ((pini == null) && (pfin == null)) {
            //UtilidadesLog.info("los dos nulos");
            UtilidadesLog.info("[TRUE] Peridodo.contenidoEn(Periodo pini, Periodo pfin):Salida INI y FINA NULOS");
            return true;
        }

        if ((pini != null) && (pfin != null)) {
            if(FactoriaConcurso.getlog().isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("pini: " + pini.getOidPeriodo() + " pfin: " + pfin.getOidPeriodo() + " this.periodo: " + this.getOidPeriodo());        
              UtilidadesLog.debug("pini.getOidMarca(): " + pini.getOidMarca() + " pini.getOidPais(): " + pini.getOidPais() + " pini.getOidCanal(): " + pini.getOidCanal());
              UtilidadesLog.debug("pfin.getOidMarca(): " + pfin.getOidMarca() + " pfin.getOidPais(): " + pfin.getOidPais() + " pfin.getOidCanal(): " + pfin.getOidCanal());
            }   
        }
        
        if (pini != null) 
        {
            if (    !pini.getOidMarca().equals(this.getOidMarca())  || 
                    !pini.getOidPais().equals(this.getOidPais())    ||
                    !pini.getOidCanal().equals(this.getOidCanal())
                ) 
            {
                UtilidadesLog.info("[FALSE] Peridodo.contenidoEn(Periodo pini, Periodo pfin):Salida MARCA 1");
                return false;
            }

            periodoInicAux = pini;
        } else {
            periodoInicAux = this;
        }

        if (pfin != null) {
            if (    !pfin.getOidMarca().equals(this.getOidMarca())  || 
                    !pfin.getOidPais().equals(this.getOidPais())    ||
                    !pfin.getOidCanal().equals(this.getOidCanal())
                ) 
            {
                UtilidadesLog.info("[FALSE] Peridodo.contenidoEn(Periodo pini, Periodo pfin):Salida MARCA 2");
                return false;
            }

            periodoFinAux = pfin;
        } else {
            periodoFinAux = this;
        }

        //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                               
        /*if ((periodoInicAux.getFechaDesde().before(this.getFechaDesde()) || (periodoInicAux.getFechaDesde().compareTo(this.getFechaDesde()) == 0)) &&
                (this.getFechaHasta().before(periodoFinAux.getFechaHasta()) || (this.getFechaHasta().compareTo(periodoFinAux.getFechaHasta()) == 0))) {*/
        if((periodoInicAux.getCodperiodo().compareTo(this.getCodperiodo()) <= 0) &&               
            (this.getCodperiodo().compareTo(periodoFinAux.getCodperiodo()) <= 0)) {
            UtilidadesLog.info("[TRUE] Peridodo.contenidoEn(Periodo pini, Periodo pfin):Salida IN");
            return true;
            
        } else {
            UtilidadesLog.info("[FALSE] Peridodo.contenidoEn(Periodo pini, Periodo pfin):Salida OUT");
            return false;
        }
    }

    public boolean menorQue(Periodo periodoEntrada) {
        //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                               
        if(this.getCodperiodo().compareTo(periodoEntrada.getCodperiodo()) < 0) {
        //if (this.fechaDesde.before(periodoEntrada.fechaDesde)) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * Fecha de Creacion: 21/06/2005
    * Autor: Carlos Leal
    */
    public boolean mayorQue(Periodo periodoEntrada) {
        //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                               
        if(this.getCodperiodo().compareTo(periodoEntrada.getCodperiodo()) > 0) {
        //if (this.fechaHasta.after(periodoEntrada.fechaHasta)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @date 09/06/05
     */
    public Periodo calcularPeriodoPosterior(Integer numeroPeriodosPosteriores) throws MareException {
        /**
         * Operation Periodo calcularPeriodoPosterior (Integer numeroPeriodosPosteriores), in Class Periodo

           Documentation
           1.-Invocaremos al método DAOConcurso.obtenerPeriodoDespuesDe pasandole this y
           numeroPeriodosPosteriores. Devolveremos el objeto periodo que nos devuelve.
        */
        DAOConcursos dao = new DAOConcursos();
        
        return dao.obtenerPeriodoDespuesDe(this, new Long(numeroPeriodosPosteriores.longValue()));

    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @date 09/06/05
     */
    public Periodo calcularPeriodoAnterior(Integer numeroPeriodosPosteriores)
            throws MareException {
        /**
         * Operation Periodo calcularPeridoAnterior (Integer numeroPeriodosPosteriores), in Class Periodo

           Documentation
           1.-Invocaremos al método DAOConcurso.obtenerPeriodoAntesDe pasandole this.oidPeridodo y numeroPeriodosPosteriores. Devolveremos el objeto periodo que nos devuelve.
          */
        DAOConcursos dao = new DAOConcursos();

        return dao.obtenerPeriodoAntesDe(this.oidPeriodo, new Long(numeroPeriodosPosteriores.longValue()));
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getCodperiodo() {
        if (this.codperiodo == null) {
            this.actualizarCodigoPeriodo();
        }
        
        return codperiodo;
    }

    public void setCodperiodo(String codperiodo) {
        this.codperiodo = codperiodo;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }
    
    /**
     * Agregado por dmorello, 19/01/2006
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        
        sb.append("Periodo:");
        
        sb.append(" oidPeriodo:"
            + this.getOidPeriodo());
        sb.append("; fechaDesde:"
            + this.getFechaDesde());
        sb.append("; fechaHasta:"
            + this.getFechaHasta());
        sb.append("; codperiodo:"
            + this.getCodperiodo());
        sb.append("; oidPais:"
            + this.getOidPais());
        sb.append("; oidMarca:"
            + this.getOidMarca());
        sb.append("; oidCanal:"
            + this.getOidCanal());

        return sb.toString();
    }
        
    //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                                
    private void actualizarCodigoPeriodo() {
        DAOConcursos dao = new DAOConcursos();
        
        try {
            String codigoPeriodo = dao.obtenerCodigoPeriodo(this.getOidPeriodo());
            this.codperiodo = codigoPeriodo;
        } catch (Exception ex) {}    
    }

    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    public Integer calcularCantidadPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin) throws MareException {
        DAOConcursos dao = new DAOConcursos();
        
        return dao.calcularCantidadPeriodos(oidPeriodoInicio, oidPeriodoFin);
    }

}
