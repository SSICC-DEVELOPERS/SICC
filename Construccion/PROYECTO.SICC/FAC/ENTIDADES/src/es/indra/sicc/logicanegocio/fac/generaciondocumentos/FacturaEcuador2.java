package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

public class FacturaEcuador2 extends DocumentoFAC  {
    private byte[] documento;
    
    public FacturaEcuador2() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
        FacturaEcuador1 facecu2 = new FacturaEcuador1();
        facecu2.componerFactura(datosDocLegal);
        this.documento = facecu2.getDocument();
    }

    public byte[] getDocument(){
        return this.documento;
    }
}