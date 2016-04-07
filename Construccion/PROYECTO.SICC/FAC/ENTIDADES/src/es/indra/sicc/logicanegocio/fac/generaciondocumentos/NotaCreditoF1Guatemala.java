package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class NotaCreditoF1Guatemala extends DocumentoFAC {
    private byte[] documento;
    
    public NotaCreditoF1Guatemala() {
    }

    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("NotaCreditoF1Guatemala.componerFactura(DTODocLegal datosDocLegal): Entrada");     
        FacturaGuatemala1 notaCreditoGuatemala1 = new FacturaGuatemala1();
        notaCreditoGuatemala1.componerFactura(datosDocLegal);
        this.documento = notaCreditoGuatemala1.getDocument();
        UtilidadesLog.info("NotaCreditoF1Guatemala.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }
    
    public byte[] getDocument(){
        return this.documento;
    }
}

