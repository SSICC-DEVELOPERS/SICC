/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;


public class DTODatosTipoFormulario extends DTOBelcorp {
    private Long oidFormulario;
    private Long idImpresoraVirtual;
    private String rutinaDiseñoFormulario;

    public DTODatosTipoFormulario() {
        super();
    }

    public Long getIdImpresoraVirtual() {
        return idImpresoraVirtual;
    }

    public void setIdImpresoraVirtual(Long newIdImpresoraVirtual) {
        idImpresoraVirtual = newIdImpresoraVirtual;
    }

    public Long getOidFormulario() {
        return oidFormulario;
    }

    public void setOidFormulario(Long newOidFormulario) {
        oidFormulario = newOidFormulario;
    }

    public String getRutinaDiseñoFormulario() {
        return rutinaDiseñoFormulario;
    }

    public void setRutinaDiseñoFormulario(String newRutinaDiseñoFormulario) {
        rutinaDiseñoFormulario = newRutinaDiseñoFormulario;
    }
}
