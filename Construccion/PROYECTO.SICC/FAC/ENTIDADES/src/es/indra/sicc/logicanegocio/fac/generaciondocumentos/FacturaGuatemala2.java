package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class FacturaGuatemala2 extends DocumentoFAC {
    private byte[] documento;
    
    public FacturaGuatemala2() {
    }

    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("FacturaGuatemala2.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
        FacturaGuatemala1 facGuatemala2 = new FacturaGuatemala1();
        facGuatemala2.componerFactura(datosDocLegal);
        this.documento = facGuatemala2.getDocument();
        UtilidadesLog.info("FacturaGuatemala2.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }

    public byte[] getDocument(){
        return this.documento;
    }
}