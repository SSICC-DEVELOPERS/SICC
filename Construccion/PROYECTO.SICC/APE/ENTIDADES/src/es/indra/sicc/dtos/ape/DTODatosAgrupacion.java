package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODatosAgrupacion extends DTOSiccPaginacion {
    private Long oidCentroDistribucion;
    private Long numeroAgrupacion;

    public DTODatosAgrupacion() {
    }

    public Long getOidCentroDistribucion() {
        return oidCentroDistribucion;
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getNumeroAgrupacion() {
        return numeroAgrupacion;
    }

    public void setNumeroAgrupacion(Long numeroAgrupacion) {
        this.numeroAgrupacion = numeroAgrupacion;
    }
}