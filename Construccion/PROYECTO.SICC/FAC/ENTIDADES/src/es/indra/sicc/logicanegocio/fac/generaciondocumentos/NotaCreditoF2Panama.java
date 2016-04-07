package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class NotaCreditoF2Panama  extends DocumentoFAC  {
    private byte[] documento;
    
    public NotaCreditoF2Panama() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("NotaCreditoF2Panama.componerFactura(DTODocLegal datosDocLegal): Entrada");     
        FacturaPanama1 notaCreditoPanama2 = new FacturaPanama1();
        notaCreditoPanama2.componerFactura(datosDocLegal);
        this.documento = notaCreditoPanama2.getDocument();
        UtilidadesLog.info("NotaCreditoF2Panama.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }
    
    public byte[] getDocument(){
        return this.documento;
    }

}