

/*
    INDRA/CAR/mmg
    $Id: MaePreguEncueTransactionQuery.java,v 1.1 2009/12/03 18:39:23 pecbazalar Exp $
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
public class MaePreguEncueTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaePreguEncueQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaePreguEncueConectorQueryList";

	// Definicion del constructor
	public MaePreguEncueTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad MaePreguEncue");
			String codPreg = (String)getEntrada("codPreg");
			traza("MMG:: Valor de atributo codPreg: " + codPreg);
			if(codPreg != null && !codPreg.trim().equals("")) codPreg = codPreg.toUpperCase();
			String valPesoPreg = (String)getEntrada("valPesoPreg");
			traza("MMG:: Valor de atributo valPesoPreg: " + valPesoPreg);
			String enseOidEncu = (String)getEntrada("enseOidEncu");
			traza("MMG:: Valor de atributo enseOidEncu: " + enseOidEncu);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			MaePreguEncueData maePreguEncueFrom =new MaePreguEncueData();
			MaePreguEncueData maePreguEncueTo = new MaePreguEncueData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maePreguEncueFrom.setCodPreg(
				(java.lang.String)FormatUtils.parseObject(codPreg, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maePreguEncueFrom.setValPesoPreg(
				(java.lang.Long)FormatUtils.parseObject(valPesoPreg, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeEncueNseViewData enseOidEncuData = null;
			if(enseOidEncu != null && !enseOidEncu.trim().equals("")){
				enseOidEncuData = new es.indra.belcorp.mso.MaeEncueNseViewData();
				enseOidEncuData.setId(new Long(enseOidEncu));
			}
			maePreguEncueFrom.setEnseOidEncu(enseOidEncuData);
			maePreguEncueFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maePreguEncueTo = (MaePreguEncueData)maePreguEncueFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maePreguEncueFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maePreguEncueTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maePreguEncueFrom", maePreguEncueFrom);
			dto.addProperty("maePreguEncueTo", maePreguEncueTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad MaePreguEncue");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad MaePreguEncue");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





