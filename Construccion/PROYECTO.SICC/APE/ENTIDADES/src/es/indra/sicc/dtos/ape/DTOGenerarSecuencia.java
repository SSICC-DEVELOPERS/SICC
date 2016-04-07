package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Comparator;

public class DTOGenerarSecuencia extends DTOBelcorp implements Comparator {
    Long codigoSublinea;
    Long oidZona;

    public DTOGenerarSecuencia(){}
    
    public void setCodigoSublinea(Long codigoSublinea) {
        this.codigoSublinea = codigoSublinea;
    }

    public Long getCodigoSublinea() {
        return codigoSublinea;
    }
    
    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }
    
    public int compare (Object obj1, Object obj2){
        DTOGenerarSecuencia dto1 = (DTOGenerarSecuencia) obj1;
        DTOGenerarSecuencia dto2 = (DTOGenerarSecuencia) obj2;
        
        if (dto1.getCodigoSublinea().longValue() > dto2.getCodigoSublinea().longValue())
            return 1;
        else if (dto1.getCodigoSublinea().longValue() < dto2.getCodigoSublinea().longValue())    
            return -1;
        else {
            if(dto1.getOidZona().longValue() > dto2.getOidZona().longValue())
                return 1;
            else if (dto1.getOidZona().longValue() < dto2.getOidZona().longValue())
                return -1;
            else
                return 0;
        }        
    }    
}