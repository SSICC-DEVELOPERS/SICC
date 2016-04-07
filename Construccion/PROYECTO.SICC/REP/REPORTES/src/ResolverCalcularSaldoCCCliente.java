import com.calipso.reportgenerator.reportcalculator.AbstractMONResolver;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.CCCEjbLocators;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

public class ResolverCalcularSaldoCCCliente extends AbstractMONResolver{

  public ResolverCalcularSaldoCCCliente(){
  }
  
  protected MareDTO getDTO(Map paramValues, Collection row){
    DTOSaldosPorFechasyVtos dtoResult = new DTOSaldosPorFechasyVtos();
    /*
     * NOTA IMPORTANTE: esta mal pasado. Este es el codigo de cliente, se
     * necesita pasar el OID. Revisar la query para agregar ese campo
     * 
     * NOTA2: Esta clase es obsoleta, ahora se lanza directamente la query
     * 
     */
    String cli = ((Vector)row).elementAt(4).toString();
    Long cliente = Long.valueOf(cli);    
    dtoResult.setOidCliente(cliente);
    if(paramValues.get(ConstantesREP.IDIOMA)!=null){
      Long idioma = Long.valueOf(paramValues.get(ConstantesREP.IDIOMA).toString());
      dtoResult.setOidIdioma(idioma);
    }
    if(paramValues.get(ConstantesREP.PAISES)!=null){
      dtoResult.setOidPais(Long.valueOf(paramValues.get(ConstantesREP.PAISES).toString()));
    }
    return dtoResult;
  }
  
  protected Object getValue(Map params,MareDTO dto) throws Exception{
    return new Float(CCCEjbLocators.getMONInterfaceModulosHome().create().calcularSaldoCCCliente((DTOSaldosPorFechasyVtos)dto).getTotal().floatValue()); 
  }

}