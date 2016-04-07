package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import java.util.Comparator;

public class PosicionesComparator implements Comparator {
    public PosicionesComparator() {
    }
    
    public int compare (Object obj1, Object obj2){
        DTOFACDocumentoContableDetalle dto1 = (DTOFACDocumentoContableDetalle) obj1;
        DTOFACDocumentoContableDetalle dto2 = (DTOFACDocumentoContableDetalle) obj2;
        
        if (dto1.getCodAgrupCatalogo().toString().equals(dto2.getCodAgrupCatalogo().toString())) {
          if (dto1.getCodigoVenta() != null && dto2.getCodigoVenta() != null) {
            return dto1.getCodigoVenta().toString().compareTo(dto2.getCodigoVenta().toString());           
          } else {
            if (dto1.getCodigoVenta() == null && dto2.getCodigoVenta() != null) {
                return 1;
            } else if (dto1.getCodigoVenta() != null && dto2.getCodigoVenta() == null) {
                return -1;                
            } else {
                return dto1.getCodigoVentaFicticio().toString().compareTo(dto2.getCodigoVentaFicticio().toString());           
            }
          }           
        } else {
          return dto1.getCodAgrupCatalogo().toString().compareTo(dto2.getCodAgrupCatalogo().toString());
        }    
        
    }    

}