package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalleFacturacion;
import java.util.Comparator;

public class AnaquelComparador implements Comparator
{
    public AnaquelComparador()
    {
    }
    
    public int compare (Object obj1, Object obj2){
            DTOListaPicadoDetalleFacturacion dto1 = (DTOListaPicadoDetalleFacturacion) obj1;
            DTOListaPicadoDetalleFacturacion dto2 = (DTOListaPicadoDetalleFacturacion) obj2;
            
            return (dto1.getNumeroAnaquel().compareTo(dto2.getNumeroAnaquel()));
    }  
    
}