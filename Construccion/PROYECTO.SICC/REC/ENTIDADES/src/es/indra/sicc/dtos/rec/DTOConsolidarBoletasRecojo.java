package es.indra.sicc.dtos.rec;

import es.indra.sicc.util.DTOBelcorp;

import java.util.ArrayList;
import java.util.Date;

/**
 * Creado por cambio 20080765
 * @author dmorello
 * @since 18/08/2009
 */
public class DTOConsolidarBoletasRecojo extends DTOBelcorp {

    private Long oidConsolidado;
    private Long oidCliente;
    private Long numeroBoleta;
    private Long numeroFactura;
    private Long oidEstadoRecojo;
    private Date fechaRecojo;
    private Boolean indPedidoServicio;
    private Long oidBoletaRecojoConsolidado;
    private ArrayList oidsSolicitudesOrigen;
    private Long[] oidsBoletasConsolidar;

    public DTOConsolidarBoletasRecojo() {
    }

    public void setOidConsolidado(Long oidConsolidado) {
        this.oidConsolidado = oidConsolidado;
    }

    public Long getOidConsolidado() {
        return oidConsolidado;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setNumeroBoleta(Long numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public Long getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setOidEstadoRecojo(Long oidEstadoRecojo) {
        this.oidEstadoRecojo = oidEstadoRecojo;
    }

    public Long getOidEstadoRecojo() {
        return oidEstadoRecojo;
    }

    public void setFechaRecojo(Date fechaRecojo) {
        this.fechaRecojo = fechaRecojo;
    }

    public Date getFechaRecojo() {
        return fechaRecojo;
    }

    public void setIndPedidoServicio(Boolean indPedidoServicio) {
        this.indPedidoServicio = indPedidoServicio;
    }

    public Boolean getIndPedidoServicio() {
        return indPedidoServicio;
    }

    public void setOidBoletaRecojoConsolidado(Long oidBoletaRecojoConsolidado) {
        this.oidBoletaRecojoConsolidado = oidBoletaRecojoConsolidado;
    }

    public Long getOidBoletaRecojoConsolidado() {
        return oidBoletaRecojoConsolidado;
    }

    public void setOidsSolicitudesOrigen(ArrayList oidsSolicitudesOrigen) {
        this.oidsSolicitudesOrigen = oidsSolicitudesOrigen;
    }

    public ArrayList getOidsSolicitudesOrigen() {
        return oidsSolicitudesOrigen;
    }

    public void setOidsBoletasConsolidar(Long[] oidsBoletasConsolidar) {
        this.oidsBoletasConsolidar = oidsBoletasConsolidar;
    }

    public Long[] getOidsBoletasConsolidar() {
        return oidsBoletasConsolidar;
    }
}
