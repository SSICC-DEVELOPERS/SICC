package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosDetalleBoletaEntregaColombia extends DTOBelcorp  {
    private Long indicadorAgrupacion;
    private Long unidades;
    private String descProducto;
    private String descModulo;

    public DTODatosDetalleBoletaEntregaColombia() {
    }

    public Long getIndicadorAgrupacion() {
        return indicadorAgrupacion;
    }

    public void setIndicadorAgrupacion(Long indicadorAgrupacion) {
        this.indicadorAgrupacion = indicadorAgrupacion;
    }

    public Long getUnidades() {
        return unidades;
    }

    public void setUnidades(Long unidades) {
        this.unidades = unidades;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public String getDescModulo() {
        return descModulo;
    }

    public void setDescModulo(String descModulo) {
        this.descModulo = descModulo;
    }
}