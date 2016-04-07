

/*
    INDRA/CAR/mmg
    $Id: ComTipoClienComisCabecTransactionQuery.java,v 1.1 2009/12/03 18:32:28 pecbazalar Exp $
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
public class ComTipoClienComisCabecTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGComTipoClienComisCabecQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ComTipoClienComisCabecConectorQueryList";

	// Definicion del constructor
	public ComTipoClienComisCabecTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ComTipoClienComisCabec");
			String codClas = (String)getEntrada("codClas");
			traza("MMG:: Valor de atributo codClas: " + codClas);
			if(codClas != null && !codClas.trim().equals("")) codClas = codClas.toUpperCase();
			String codSubc = (String)getEntrada("codSubc");
			traza("MMG:: Valor de atributo codSubc: " + codSubc);
			if(codSubc != null && !codSubc.trim().equals("")) codSubc = codSubc.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			ComTipoClienComisCabecData comTipoClienComisCabecFrom =new ComTipoClienComisCabecData();
			ComTipoClienComisCabecData comTipoClienComisCabecTo = new ComTipoClienComisCabecData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			comTipoClienComisCabecFrom.setCodClas(
				(java.lang.String)FormatUtils.parseObject(codClas, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			comTipoClienComisCabecFrom.setCodSubc(
				(java.lang.Long)FormatUtils.parseObject(codSubc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			comTipoClienComisCabecFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			comTipoClienComisCabecTo = (ComTipoClienComisCabecData)comTipoClienComisCabecFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, comTipoClienComisCabecFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, comTipoClienComisCabecTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("comTipoClienComisCabecFrom", comTipoClienComisCabecFrom);
			dto.addProperty("comTipoClienComisCabecTo", comTipoClienComisCabecTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(comTipoClienComisCabecFrom, comTipoClienComisCabecTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad ComTipoClienComisCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad ComTipoClienComisCabec");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(comTipoClienComisCabecFrom, comTipoClienComisCabecTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabecFrom.setPaisOidPais(paisOculto);comTipoClienComisCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo, DruidaConector result) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                comTipoClienComisCabecFrom.setPaisOidPais(paisOculto);
                comTipoClienComisCabecTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
	}
	
	
}





