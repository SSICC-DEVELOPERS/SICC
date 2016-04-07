package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesLog;

public class FacturaPanama2 extends DocumentoFAC  {
    private byte[] documento;
    
    public FacturaPanama2() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
        UtilidadesLog.info("FacturaPanama2.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
        FacturaPanama1 facpan2 = new FacturaPanama1();
        facpan2.componerFactura(datosDocLegal);
        this.documento = facpan2.getDocument();
        UtilidadesLog.info("FacturaPanama2.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }

    public byte[] getDocument(){
        return this.documento;
    }
}