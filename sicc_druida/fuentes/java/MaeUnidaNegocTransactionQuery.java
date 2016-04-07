

/*
    INDRA/CAR/mmg
    $Id: MaeUnidaNegocTransactionQuery.java,v 1.1 2009/12/03 18:33:22 pecbazalar Exp $
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
public class MaeUnidaNegocTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeUnidaNegocQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeUnidaNegocConectorQueryList";

	// Definicion del constructor
	public MaeUnidaNegocTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeUnidaNegoc");
			String codUnidNego = (String)getEntrada("codUnidNego");
			traza("MMG:: Valor de atributo codUnidNego: " + codUnidNego);
			if(codUnidNego != null && !codUnidNego.trim().equals("")) codUnidNego = codUnidNego.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			MaeUnidaNegocData maeUnidaNegocFrom =new MaeUnidaNegocData();
			MaeUnidaNegocData maeUnidaNegocTo = new MaeUnidaNegocData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeUnidaNegocFrom.setCodUnidNego(
				(java.lang.String)FormatUtils.parseObject(codUnidNego, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeUnidaNegocFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeUnidaNegocTo = (MaeUnidaNegocData)maeUnidaNegocFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeUnidaNegocFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeUnidaNegocTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeUnidaNegocFrom", maeUnidaNegocFrom);
			dto.addProperty("maeUnidaNegocTo", maeUnidaNegocTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(maeUnidaNegocFrom, maeUnidaNegocTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad MaeUnidaNegoc");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad MaeUnidaNegoc");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(maeUnidaNegocFrom, maeUnidaNegocTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeUnidaNegocData maeUnidaNegocFrom, MaeUnidaNegocData maeUnidaNegocTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeUnidaNegocFrom.setPaisOidPais(paisOculto);maeUnidaNegocTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(MaeUnidaNegocData maeUnidaNegocFrom, MaeUnidaNegocData maeUnidaNegocTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeUnidaNegocFrom.setPaisOidPais(paisOculto);maeUnidaNegocTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





