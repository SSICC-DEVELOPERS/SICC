package es.indra.sicc.logicanegocio.app;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import java.util.Comparator;

public class RutasClienteComparator implements Comparator {
    public RutasClienteComparator() {
    }
    
     public int compare (Object obj1, Object obj2){
        DTOFACCabeceraSolicitud dto1 = (DTOFACCabeceraSolicitud) obj1;
        DTOFACCabeceraSolicitud dto2 = (DTOFACCabeceraSolicitud) obj2;
        
        if (new Long(dto1.getSecuenciaRutaTerritorio().toString()).longValue() > new Long (dto2.getSecuenciaRutaTerritorio().toString()).longValue()) {
            return 1;
        } else if (new Long (dto1.getSecuenciaRutaTerritorio().toString()).longValue() < new Long(dto2.getSecuenciaRutaTerritorio().toString()).longValue()) {
            return -1;
        } else {        
            if (dto1.getOidCliente().longValue() > dto2.getOidCliente().longValue()) {
                return 1;
            } else if (dto1.getOidCliente().longValue() < dto2.getOidCliente().longValue()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}