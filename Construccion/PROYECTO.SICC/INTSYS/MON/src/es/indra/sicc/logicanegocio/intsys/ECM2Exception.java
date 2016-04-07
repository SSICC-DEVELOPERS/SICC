package es.indra.sicc.logicanegocio.intsys;

public class ECM2Exception extends Exception  {
    
    public ECM2Exception(String mensaje, Throwable e) {
        super(mensaje);
        super.initCause( e );
    }
}