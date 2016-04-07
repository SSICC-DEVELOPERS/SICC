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

package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTORevertirCCFac  extends DTOBelcorp{

	
	private Long oidSubacceso; 
	private String numIdentCuota;
	private Long oidEmpresa;
    private String appLogUser;

	public DTORevertirCCFac() {
	}

	public String getNumIdentCuota() {
		return numIdentCuota;
	}

	public void setNumIdentCuota(String newNumIdentCuota) {
		numIdentCuota = newNumIdentCuota;
	}

	public Long getOidEmpresa() {
		return oidEmpresa;
	}

	public void setOidEmpresa(Long newOidEmpresa) {
		oidEmpresa = newOidEmpresa;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}


    public void setAppLogUser(String appLogUser)
    {
        this.appLogUser = appLogUser;
    }


    public String getAppLogUser()
    {
        return appLogUser;
    }
	
}