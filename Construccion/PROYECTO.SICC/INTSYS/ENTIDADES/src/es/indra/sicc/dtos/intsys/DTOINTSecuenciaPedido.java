package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTSecuenciaPedido extends DTOBelcorp {

    private String codigoZona;
    private Integer ruta;
    private String codigoTerritorio;
    private String numeroPedido;
    private Integer secuenciaTerritorio;
    private String indicadorPedidoServicio;

    public DTOINTSecuenciaPedido() {
    }


    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }


    public String getCodigoZona() {
        return codigoZona;
    }


    public void setRuta(Integer ruta) {
        this.ruta = ruta;
    }


    public Integer getRuta() {
        return ruta;
    }


    public void setCodigoTerritorio(String codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }


    public String getCodigoTerritorio() {
        return codigoTerritorio;
    }


    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }


    public String getNumeroPedido() {
        return numeroPedido;
    }


    public void setSecuenciaTerritorio(Integer secuenciaTerritorio) {
        this.secuenciaTerritorio = secuenciaTerritorio;
    }


    public Integer getSecuenciaTerritorio() {
        return secuenciaTerritorio;
    }


    public void setIndicadorPedidoServicio(String indicadorPedidoServicio) {
        this.indicadorPedidoServicio = indicadorPedidoServicio;
    }


    public String getIndicadorPedidoServicio() {
        return indicadorPedidoServicio;
    }
}