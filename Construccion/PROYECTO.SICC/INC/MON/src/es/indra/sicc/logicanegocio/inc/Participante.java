package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;


/**
 * <p>Copyright 2005 � por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * Espa�a<br>
 * <p>Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * @date 25/04/2005
 * @author Gustavo Vi�ales
 */
public class Participante implements Serializable {
    private TipificacionCliente[] tipificacionCliente;
    private Long oidCliente;
    private AmbitoGeografico ambitoGeografico;
    private String nombre;

    public Participante() {
    }

    public void setTipificacionCliente(TipificacionCliente[] tipificacionCliente) {
        this.tipificacionCliente = tipificacionCliente;
    }

    public TipificacionCliente[] getTipificacionCliente() {
        return tipificacionCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setAmbitoGeografico(AmbitoGeografico ambitoGeografico) {
        this.ambitoGeografico = ambitoGeografico;
    }

    public AmbitoGeografico getAmbitoGeografico() {
        return ambitoGeografico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
