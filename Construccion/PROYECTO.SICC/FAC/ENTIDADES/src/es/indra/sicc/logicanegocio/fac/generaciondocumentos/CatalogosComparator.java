package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import java.util.Comparator;

public class CatalogosComparator implements Comparator {
    public CatalogosComparator() {
    }
    
    public int compare (Object obj1, Object obj2){
        DTOAgrupaCatalogos dto1 = (DTOAgrupaCatalogos) obj1;
        DTOAgrupaCatalogos dto2 = (DTOAgrupaCatalogos) obj2;
        
        return dto1.getCodigoAgrupacion().toString().compareTo(dto2.getCodigoAgrupacion().toString());
    }    
}