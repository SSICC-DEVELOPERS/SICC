

/*
    INDRA/CAR/mmg
    $Id: PedAtribEspecTransactionQuery.java,v 1.1 2009/12/03 18:34:37 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.utils.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class PedAtribEspecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desAtri";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedAtribEspecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedAtribEspecConectorQueryList";

	// Definicion del constructor
	public PedAtribEspecTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesión la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los últimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad PedAtribEspec");
			String codAtri = (String)getEntrada("codAtri");
			traza("MMG:: Valor de atributo codAtri: " + codAtri);
			String desAtri = (String)getEntrada("desAtri");
			traza("MMG:: Valor de atributo desAtri: " + desAtri);
			String valForm = (String)getEntrada("valForm");
			traza("MMG:: Valor de atributo valForm: " + valForm);
			String moduOidModu = (String)getEntrada("moduOidModu");
			traza("MMG:: Valor de atributo moduOidModu: " + moduOidModu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedAtribEspecData pedAtribEspecFrom =new PedAtribEspecData();
			PedAtribEspecData pedAtribEspecTo = new PedAtribEspecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedAtribEspecFrom.setCodAtri(
				(java.lang.String)FormatUtils.parseObject(codAtri, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedAtribEspecFrom.setDesAtri(
				(java.lang.String)FormatUtils.parseObject(desAtri, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedAtribEspecFrom.setValForm(
				(java.lang.String)FormatUtils.parseObject(valForm, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegModulData moduOidModuData = null;
			if(moduOidModu != null && !moduOidModu.trim().equals("")){
				moduOidModuData = new es.indra.belcorp.mso.SegModulData();
				moduOidModuData.setId(new Long(moduOidModu));
			}
			pedAtribEspecFrom.setModuOidModu(moduOidModuData);
			
			
			//Construimos el to
			pedAtribEspecTo = (PedAtribEspecData)pedAtribEspecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedAtribEspecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedAtribEspecTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedAtribEspecFrom", pedAtribEspecFrom);
			dto.addProperty("pedAtribEspecTo", pedAtribEspecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedAtribEspec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedAtribEspec");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





