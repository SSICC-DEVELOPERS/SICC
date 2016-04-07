

/*
    INDRA/CAR/mmg
    $Id: RecOperaViewTransactionQuery.java,v 1.1 2009/12/03 18:35:38 pecbazalar Exp $
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
public class RecOperaViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "valDescLarg";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecOperaViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecOperaViewConectorQueryList";

	// Definicion del constructor
	public RecOperaViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecOperaView");
			String codOper = (String)getEntrada("codOper");
			traza("MMG:: Valor de atributo codOper: " + codOper);
			if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
			String valDescLarg = (String)getEntrada("valDescLarg");
			traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
			String indAnul = (String)getEntrada("indAnul");
			traza("MMG:: Valor de atributo indAnul: " + indAnul);
			String indIngrEnvi = (String)getEntrada("indIngrEnvi");
			traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
			String valIngrDevu = (String)getEntrada("valIngrDevu");
			traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
			String valPerd = (String)getEntrada("valPerd");
			traza("MMG:: Valor de atributo valPerd: " + valPerd);
			String indEspeMercFisi = (String)getEntrada("indEspeMercFisi");
			traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
			String indDevuFisiFact = (String)getEntrada("indDevuFisiFact");
			traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
			String numCampHist = (String)getEntrada("numCampHist");
			traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
			String indEnviGeneDevu = (String)getEntrada("indEnviGeneDevu");
			traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
			String indDevuGeneEnvi = (String)getEntrada("indDevuGeneEnvi");
			traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
			String indFaltMerc = (String)getEntrada("indFaltMerc");
			traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecOperaViewData recOperaViewFrom =new RecOperaViewData();
			RecOperaViewData recOperaViewTo = new RecOperaViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			recOperaViewFrom.setCodOper(
				(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setValDescLarg(
				(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndAnul(
				(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndIngrEnvi(
				(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setValIngrDevu(
				(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setValPerd(
				(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndEspeMercFisi(
				(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndDevuFisiFact(
				(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setNumCampHist(
				(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndEnviGeneDevu(
				(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndDevuGeneEnvi(
				(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			recOperaViewFrom.setIndFaltMerc(
				(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			recOperaViewTo = (RecOperaViewData)recOperaViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recOperaViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recOperaViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recOperaViewFrom", recOperaViewFrom);
			dto.addProperty("recOperaViewTo", recOperaViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(recOperaViewFrom, recOperaViewTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecOperaView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecOperaView");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(recOperaViewFrom, recOperaViewTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaViewFrom.setPaisOidPais(paisOculto);
				recOperaViewTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOperaViewFrom.setPaisOidPais(paisOculto); 
				recOperaViewTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





