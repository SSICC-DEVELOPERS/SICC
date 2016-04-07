package es.indra.sicc.logicanegocio.fac;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import java.util.Comparator;

public class RutasComparator implements Comparator
{
    public RutasComparator()
    {
    }
    
    public int compare (Object obj1, Object obj2){
        DTOFACCabeceraSolicitud dto1 = (DTOFACCabeceraSolicitud) obj1;
        DTOFACCabeceraSolicitud dto2 = (DTOFACCabeceraSolicitud) obj2;
        
        // Modificado por Incidencia V_FAC_20
        /*if (dto1.getNumeroSecuenciaZonaRuta().longValue()>dto2.getNumeroSecuenciaZonaRuta().longValue()){
            return 1;
        }else if (dto1.getNumeroSecuenciaZonaRuta().longValue()<dto2.getNumeroSecuenciaZonaRuta().longValue()){
        */
        if (new Long(dto1.getSecuenciaRutaTerritorio().toString()).longValue() > new Long (dto2.getSecuenciaRutaTerritorio().toString()).longValue()){
            return 1;
        }else if (new Long (dto1.getSecuenciaRutaTerritorio().toString()).longValue() < new Long(dto2.getSecuenciaRutaTerritorio().toString()).longValue()){
            return -1;
        }else{        
            if (new Long(dto1.getCodigoCliente().toString()).longValue() > new Long(dto2.getCodigoCliente().toString()).longValue()){
                return 1;
            }else if (new Long(dto1.getCodigoCliente().toString()).longValue() < new Long(dto2.getCodigoCliente().toString()).longValue()){
                return -1;
            }else{
                return 0;
            }
        }
    }
}