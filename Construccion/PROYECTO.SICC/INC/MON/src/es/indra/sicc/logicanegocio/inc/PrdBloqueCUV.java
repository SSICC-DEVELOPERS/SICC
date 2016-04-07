package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;

// sapaza -- COL-SiCC-2013-0030 -- 28/11/2013
public class PrdBloqueCUV
        extends PrdBloque implements Serializable {
        
    private Long oidDetalleOferta;

    public PrdBloqueCUV() {
    }

    /*
     * Verifica si el producto esta contenido en el bloque de CUV.
     */
    public boolean validarProducto(Posicion pos, Long oidConcurso) {
        UtilidadesLog.info("PrdBloqueCUV.validarProducto(Posicion pos, Long oidConcurso):Entrada");
        if (!pos.getPeriodo().contenidoEn(this.getPeriodoDesde(), this.getPeriodoHasta())) {
            UtilidadesLog.info("PrdBloqueCUV.validarProducto:Salida PERIODO");
            return false;
        }

        if (!oidDetalleOferta.equals(pos.getOidDetalleOferta())) {
           UtilidadesLog.info("PrdBloqueCUV.validarProducto:Salida DETALLE OFERTA");
           return false;
        }

        UtilidadesLog.info("PrdBloqueCUV.validarProducto(Posicion pos, Long oidConcurso):Salida");
        return true;
    }

    public void setOidDetalleOferta(Long oidDetalleOferta) {
        this.oidDetalleOferta = oidDetalleOferta;
    }

    public Long getOidDetalleOferta() {
        return oidDetalleOferta;
    }
}
