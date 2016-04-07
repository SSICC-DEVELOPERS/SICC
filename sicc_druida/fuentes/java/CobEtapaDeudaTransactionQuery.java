

/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaTransactionQuery.java,v 1.1 2009/12/03 18:36:57 pecbazalar Exp $
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
public class CobEtapaDeudaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "valDesc";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCobEtapaDeudaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CobEtapaDeudaConectorQueryList";

	// Definicion del constructor
	public CobEtapaDeudaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CobEtapaDeuda");
			String codEtapDeud = (String)getEntrada("codEtapDeud");
			traza("MMG:: Valor de atributo codEtapDeud: " + codEtapDeud);
			if(codEtapDeud != null && !codEtapDeud.trim().equals("")) codEtapDeud = codEtapDeud.toUpperCase();
			String valDesc = (String)getEntrada("valDesc");
			traza("MMG:: Valor de atributo valDesc: " + valDesc);
			String valEdadInic = (String)getEntrada("valEdadInic");
			traza("MMG:: Valor de atributo valEdadInic: " + valEdadInic);
			String valEdadFina = (String)getEntrada("valEdadFina");
			traza("MMG:: Valor de atributo valEdadFina: " + valEdadFina);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			CobEtapaDeudaData cobEtapaDeudaFrom =new CobEtapaDeudaData();
			CobEtapaDeudaData cobEtapaDeudaTo = new CobEtapaDeudaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cobEtapaDeudaFrom.setCodEtapDeud(
				(java.lang.String)FormatUtils.parseObject(codEtapDeud, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobEtapaDeudaFrom.setValDesc(
				(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobEtapaDeudaFrom.setValEdadInic(
				(java.lang.Long)FormatUtils.parseObject(valEdadInic, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cobEtapaDeudaFrom.setValEdadFina(
				(java.lang.Long)FormatUtils.parseObject(valEdadFina, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cobEtapaDeudaTo = (CobEtapaDeudaData)cobEtapaDeudaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cobEtapaDeudaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cobEtapaDeudaTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cobEtapaDeudaFrom", cobEtapaDeudaFrom);
			dto.addProperty("cobEtapaDeudaTo", cobEtapaDeudaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(cobEtapaDeudaFrom, cobEtapaDeudaTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad CobEtapaDeuda");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad CobEtapaDeuda");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(cobEtapaDeudaFrom, cobEtapaDeudaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeudaFrom.setPaisOidPais(paisOculto); cobEtapaDeudaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeudaFrom.setPaisOidPais(paisOculto); cobEtapaDeudaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





