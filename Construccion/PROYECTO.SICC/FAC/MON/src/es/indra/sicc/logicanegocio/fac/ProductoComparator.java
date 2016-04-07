package es.indra.sicc.logicanegocio.fac;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import java.util.Comparator;

public class ProductoComparator implements Comparator {

    public ProductoComparator() {
    }
    
    public int compare (Object obj1, Object obj2){
        DTOFACPosicionSolicitud dto1 = (DTOFACPosicionSolicitud) obj1;
        DTOFACPosicionSolicitud dto2 = (DTOFACPosicionSolicitud) obj2;

        return dto1.getDecripcionSAPI18N().toString().compareTo(dto2.getDecripcionSAPI18N().toString());
   }

}