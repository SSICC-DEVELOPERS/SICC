package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.DTOBelcorp;

public class DTOSubtotalesDetalleFactura extends DTOBelcorp  {
    private Long subtotalUnidadesSolicitadas;
    private Long subtotalUnidadesAtendidas;
    private Long subtotalUnidadesFaltantes;
    private Float subtotalPrecioTotal;
    private Float subtotalDescuentos;
    private Float subtotalTotalconDescuentos;

    public DTOSubtotalesDetalleFactura() {
        setSubtotalDescuentos(new Float(0));
        setSubtotalPrecioTotal(new Float(0));
        setSubtotalTotalconDescuentos(new Float(0));
        setSubtotalUnidadesAtendidas(new Long(0));
        setSubtotalUnidadesFaltantes(new Long(0));
        setSubtotalUnidadesSolicitadas(new Long(0));
    }

    public Long getSubtotalUnidadesSolicitadas() {
        return subtotalUnidadesSolicitadas;
    }

    public void setSubtotalUnidadesSolicitadas(Long subtotalUnidadesSolicitadas) {
        this.subtotalUnidadesSolicitadas = subtotalUnidadesSolicitadas;
    }

    public Long getSubtotalUnidadesAtendidas() {
        return subtotalUnidadesAtendidas;
    }

    public void setSubtotalUnidadesAtendidas(Long subtotalUnidadesAtendidas) {
        this.subtotalUnidadesAtendidas = subtotalUnidadesAtendidas;
    }

    public Long getSubtotalUnidadesFaltantes() {
        return subtotalUnidadesFaltantes;
    }

    public void setSubtotalUnidadesFaltantes(Long subtotalUnidadesFaltantes) {
        this.subtotalUnidadesFaltantes = subtotalUnidadesFaltantes;
    }

    public Float getSubtotalPrecioTotal() {
        return subtotalPrecioTotal;
    }

    public void setSubtotalPrecioTotal(Float subtotalPrecioTotal) {
        this.subtotalPrecioTotal = subtotalPrecioTotal;
    }

    public Float getSubtotalDescuentos() {
        return subtotalDescuentos;
    }

    public void setSubtotalDescuentos(Float subtotalDescuentos) {
        this.subtotalDescuentos = subtotalDescuentos;
    }

    public Float getSubtotalTotalconDescuentos() {
        return subtotalTotalconDescuentos;
    }

    public void setSubtotalTotalconDescuentos(Float subtotalTotalconDescuentos) {
        this.subtotalTotalconDescuentos = subtotalTotalconDescuentos;
    }
}