package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.dtos.ape.DTOCajaListaPicado;
import java.util.Comparator;

public class CajasComparator implements Comparator
{
    public CajasComparator()
    {
    }
    
    public int compare (Object obj1, Object obj2){
            DTOCajaListaPicado dto1 = (DTOCajaListaPicado) obj1;
            DTOCajaListaPicado dto2 = (DTOCajaListaPicado) obj2;
            
            if (dto1.getNumeroCaja().longValue() > dto2.getNumeroCaja().longValue()){
                return 1;
            }else if (dto1.getNumeroCaja().longValue() < dto2.getNumeroCaja().longValue()){
                return -1;
            }else{
                return 0;
            }            
    }        
}