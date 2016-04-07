package es.indra.sicc.dtos.zon;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOEstructuraVialRegistro extends DTOAuditableSICC {
    private String Operacion;
    private String codTerritorio;
    private String codVia;
	private String numViaSegmento;
	private String numInicio;
	private String numFin;
    private String sentido;
    private String lado;
    private String UBIGEO;
	

    public DTOEstructuraVialRegistro() {
    }

    public void setOperacion(String newOperacion) {
        Operacion = newOperacion;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setCodTerritorio(String newCodTerritorio) {
        codTerritorio = newCodTerritorio;
    }

    public String getCodTerritorio() {
        return codTerritorio;
    }

    public String getNumInicio() {
		return numInicio;
    }

    public String getNumFin() {
		return numFin;
    }

    public void setSentido(String newSentido) {
        sentido = newSentido;
    }

    public String getSentido() {
        return sentido;
    }

    public void setLado(String newLado) {
        lado = newLado;
    }

    public String getLado() {
        return lado;
    }

    public void setNumInicio(String newNumInicio) {
		numInicio = newNumInicio;
    }

    public void setNumFin(String newNumFin) {
		numFin = newNumFin;
    }

    public String getUBIGEO() {
        return UBIGEO;
    }

    public void setUBIGEO(String newUBIGEO) {
        UBIGEO = newUBIGEO;
    }

    public String getCodVia() {
		return codVia;
    }

    public void setCodVia(String newCodVia) {
		codVia = newCodVia;
    }

    public String getNumViaSegmento() {
		return numViaSegmento;
    }

    public void setNumViaSegmento(String newNumViaSegmento) {
		numViaSegmento = newNumViaSegmento;
    }
}
