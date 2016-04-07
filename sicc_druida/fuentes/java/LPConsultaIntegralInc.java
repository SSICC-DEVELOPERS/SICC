import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.util.Vector;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;

public abstract class LPConsultaIntegralInc extends LPSICCBase{
	protected DTOCabeceraConsultaIntegral dtoCabecera;
	protected String accion;
	protected Long lIdioma;
    protected Long lPais;   
	private static final String CTE_DTO_CACHE = 
	"claveDTOCabeceraConsultaIntegral";

	public LPConsultaIntegralInc() { super(); }
  
	public void inicio() throws Exception {}
  
	public void ejecucion() throws Exception {}
  
	public DTOCabeceraConsultaIntegral getCabecera() throws Exception {
	    traza("LPConsultaIntegralInc.getCabecera - Entrada");
		DTOCabeceraConsultaIntegral cabecera = null;    		
	    try {
		    cabecera = (DTOCabeceraConsultaIntegral)
			this.getSessionCache().get(LPConsultaIntegralInc.CTE_DTO_CACHE);
	    }
		catch(Exception e){
			traza("****** No encontro el DTO en sesion");
	    }
    
		traza("****** DTOCabeceraConsultaIntegral: " + cabecera);    
	    traza("LPConsultaIntegralInc.getCabecera - Salida");
	    return cabecera;
	}
  
	public void setCabecera(DTOCabeceraConsultaIntegral DTOE){
		this.getSessionCache().put(LPConsultaIntegralInc.CTE_DTO_CACHE, DTOE);		
	}
}