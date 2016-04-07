package es.indra.sicc.logicanegocio.ape;
import java.util.Comparator;
import es.indra.sicc.dtos.ape.DTOGenerarSecuencia;

public class ZonasComparator implements Comparator
{
    public ZonasComparator()
    {
    }
    
    public int compare (Object obj1, Object obj2){
            DTOGenerarSecuencia dto1 = (DTOGenerarSecuencia) obj1;
            DTOGenerarSecuencia dto2 = (DTOGenerarSecuencia) obj2;
            
            if (dto1.getOidZona().longValue() > dto2.getOidZona().longValue()){
                return 1;
            }else if (dto1.getOidZona().longValue() < dto2.getOidZona().longValue()){
                return -1;
            }else{
                return 0;
            }            
    }        
}