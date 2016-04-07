package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class NotaCreditoF1Panama extends DocumentoFAC  {
    private byte[] documento;
    
    public NotaCreditoF1Panama() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("NotaCreditoF1Panama.componerFactura(DTODocLegal datosDocLegal): Entrada");     
        FacturaPanama1 notaCreditoPanama1 = new FacturaPanama1();
        notaCreditoPanama1.componerFactura(datosDocLegal);
        this.documento = notaCreditoPanama1.getDocument();
        UtilidadesLog.info("NotaCreditoF1Panama.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }
    
    public byte[] getDocument(){
        return this.documento;
    }
}
