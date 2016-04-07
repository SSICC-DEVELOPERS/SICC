package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaBP extends DTOAuditableSICC  {
	private RecordSet subgerencia;
	private RecordSet region;
	private RecordSet zona;
	private RecordSet subtipoCliente;
	private RecordSet tipoClasificacion;
	private RecordSet clasificacion;
	private RecordSet acceso;
	private RecordSet subacceso;
    // Agregado por incidencia SICC20070356 - Rafael Romero - 05/09/2007
    // se agregan metodos de acceso
    private RecordSet valoresDefecto;
    // Fin agregado SICC20070356
    
        // sapaza -- PER-SiCC-2013-0355 -- 04/04/2013
        private String indValidaPrecioContable;
        
        // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
        private String descripcionAlmacen;

	public DTOCargaBP() {
	}

	public RecordSet getSubgerencia() {
		return subgerencia;
	}

	public void setSubgerencia(RecordSet newSubgerencia) {
		subgerencia = newSubgerencia;
	}

	public RecordSet getRegion() {
		return region;
	}

	public void setRegion(RecordSet newRegion) {
		region = newRegion;
	}

	public RecordSet getZona() {
		return zona;
	}

	public void setZona(RecordSet newZona) {
		zona = newZona;
	}

	public RecordSet getAcceso() {
		return acceso;
	}

	public void setAcceso(RecordSet newAcceso) {
		acceso = newAcceso;
	}

	public RecordSet getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(RecordSet newClasificacion) {
		clasificacion = newClasificacion;
	}

	public RecordSet getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(RecordSet newSubacceso) {
		subacceso = newSubacceso;
	}

	public RecordSet getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(RecordSet newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}

	public RecordSet getTipoClasificacion() {
		return tipoClasificacion;
	}

	public void setTipoClasificacion(RecordSet newTipoClasificacion) {
		tipoClasificacion = newTipoClasificacion;
	}

    public RecordSet getValoresDefecto() {
        return valoresDefecto;
    }

    public void setValoresDefecto(RecordSet valoresDefecto) {
        this.valoresDefecto = valoresDefecto;
    }

    public void setIndValidaPrecioContable(String indValidaPrecioContable) {
        this.indValidaPrecioContable = indValidaPrecioContable;
    }

    public String getIndValidaPrecioContable() {
        return indValidaPrecioContable;
    }

    public void setDescripcionAlmacen(String descripcionAlmacen) {
        this.descripcionAlmacen = descripcionAlmacen;
    }

    public String getDescripcionAlmacen() {
        return descripcionAlmacen;
    }
}
