package es.indra.sicc.logicanegocio.cob;
import java.util.Comparator;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.util.UtilidadesLog;

public class cronogramasComparator implements Comparator
{
    public cronogramasComparator()
    {
    }
    
    public int compare(Object obj1, Object obj2) {
        UtilidadesLog.info("cronogramasComparator.compare Entrada");
        DTOCronogramaCobranza dto1 = (DTOCronogramaCobranza) obj1;
        DTOCronogramaCobranza dto2 = (DTOCronogramaCobranza) obj2;    
        
        if (dto1.getOidSubgerenciaVentas().longValue() > dto2.getOidSubgerenciaVentas().longValue()){
            return -1;
        } else if (dto1.getOidSubgerenciaVentas().longValue() < dto2.getOidSubgerenciaVentas().longValue()){    
            return 1;
        } else {
            if (dto1.getOidRegion().longValue() > dto2.getOidRegion().longValue()){    
                return -1;
            } else if (dto1.getOidRegion().longValue() < dto2.getOidRegion().longValue()){    
                return 1;
            } else {
                if (dto1.getOidZona().longValue() > dto2.getOidZona().longValue()){    
                    return -1;
                } else if (dto1.getOidZona().longValue() < dto2.getOidZona().longValue()){    
                    return 1;
                } else {
                    if (dto1.getOidSeccion().longValue() > dto2.getOidSeccion().longValue()){    
                        return -1;
                    } else if (dto1.getOidSeccion().longValue() < dto2.getOidSeccion().longValue()){    
                        return 1;
                    } else {
                        if (dto1.getOidTerritorio().longValue() > dto2.getOidTerritorio().longValue()){    
                            return -1;
                        } else if (dto1.getOidTerritorio().longValue() < dto2.getOidTerritorio().longValue()){    
                            return 1;
                        } else {
                            return 0;
                        }
                    }    
                }    
            }    
        }    
        
    }
}