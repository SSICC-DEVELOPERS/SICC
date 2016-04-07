package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class NotaCreditoF2Guatemala extends DocumentoFAC {
    private byte[] documento;
    
    public NotaCreditoF2Guatemala() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("NotaCreditoF2Guatemala.componerFactura(DTODocLegal datosDocLegal): Entrada");     
        FacturaGuatemala1 notaCreditoGuatemala2 = new FacturaGuatemala1();
        notaCreditoGuatemala2.componerFactura(datosDocLegal);
        this.documento = notaCreditoGuatemala2.getDocument();
        UtilidadesLog.info("NotaCreditoF2Guatemala.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }
    
    public byte[] getDocument(){
        return this.documento;
    }
}