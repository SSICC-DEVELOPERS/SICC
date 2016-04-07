/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.cra;
import java.io.Serializable;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Subm�dulo:         
 * Componente:        DTO's
 * Fecha:             06/06/2003
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del 
 *                    Modelo de Componentes SICC-DMCO-CRA-001-222
 *                    
 * @version           1.0
 * @autor             Federico G. Stilman
 * @version           2.0
 * @autor             Carlos Ferreira
 */

public class DTOID extends DTOAuditableSICC {
    private Long pais;
    private Long canal;
    private Long marca;
    private Long oid;
    private Long acceso;

    public DTOID() {
        super();
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }
    public Long getAcceso()
    {
        return acceso;
    }

    public void setAcceso(Long acceso)
    {
        this.acceso = acceso;
    }
}