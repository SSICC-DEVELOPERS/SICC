package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

public class NotaCreditoF1Ecuador extends DocumentoFAC  {
    private byte[] documento;
    
    public NotaCreditoF1Ecuador() {
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