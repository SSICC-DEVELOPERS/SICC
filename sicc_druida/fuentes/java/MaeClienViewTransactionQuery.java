

/*
    INDRA/CAR/mmg
    $Id: MaeClienViewTransactionQuery.java,v 1.1 2009/12/03 18:43:10 pecbazalar Exp $
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
public class MaeClienViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codClie";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeClienViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeClienViewConectorQueryList";

	// Definicion del constructor
	public MaeClienViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeClienView");
			String codClie = (String)getEntrada("codClie");
			traza("MMG:: Valor de atributo codClie: " + codClie);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String indFichInsc = (String)getEntrada("indFichInsc");
			traza("MMG:: Valor de atributo indFichInsc: " + indFichInsc);
			String codDigiCtrl = (String)getEntrada("codDigiCtrl");
			traza("MMG:: Valor de atributo codDigiCtrl: " + codDigiCtrl);
			String valApe1 = (String)getEntrada("valApe1");
			traza("MMG:: Valor de atributo valApe1: " + valApe1);
			String valApe2 = (String)getEntrada("valApe2");
			traza("MMG:: Valor de atributo valApe2: " + valApe2);
			String valNom1 = (String)getEntrada("valNom1");
			traza("MMG:: Valor de atributo valNom1: " + valNom1);
			String valNom2 = (String)getEntrada("valNom2");
			traza("MMG:: Valor de atributo valNom2: " + valNom2);
			String valTrat = (String)getEntrada("valTrat");
			traza("MMG:: Valor de atributo valTrat: " + valTrat);
			String valCritBus1 = (String)getEntrada("valCritBus1");
			traza("MMG:: Valor de atributo valCritBus1: " + valCritBus1);
			String valCritBus2 = (String)getEntrada("valCritBus2");
			traza("MMG:: Valor de atributo valCritBus2: " + valCritBus2);
			String codSexo = (String)getEntrada("codSexo");
			traza("MMG:: Valor de atributo codSexo: " + codSexo);
			String fecIngr = (String)getEntrada("fecIngr");
			traza("MMG:: Valor de atributo fecIngr: " + fecIngr);
			String valApelCasa = (String)getEntrada("valApelCasa");
			traza("MMG:: Valor de atributo valApelCasa: " + valApelCasa);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeClienViewData maeClienViewFrom =new MaeClienViewData();
			MaeClienViewData maeClienViewTo = new MaeClienViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeClienViewFrom.setCodClie(
				(java.lang.String)FormatUtils.parseObject(codClie, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeClienViewFrom.setPaisOidPais(paisOidPaisData);
			maeClienViewFrom.setIndFichInsc(
				(java.lang.Long)FormatUtils.parseObject(indFichInsc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setCodDigiCtrl(
				(java.lang.String)FormatUtils.parseObject(codDigiCtrl, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValApe1(
				(java.lang.String)FormatUtils.parseObject(valApe1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValApe2(
				(java.lang.String)FormatUtils.parseObject(valApe2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValNom1(
				(java.lang.String)FormatUtils.parseObject(valNom1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValNom2(
				(java.lang.String)FormatUtils.parseObject(valNom2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValTrat(
				(java.lang.String)FormatUtils.parseObject(valTrat, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValCritBus1(
				(java.lang.String)FormatUtils.parseObject(valCritBus1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValCritBus2(
				(java.lang.String)FormatUtils.parseObject(valCritBus2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setCodSexo(
				(java.lang.String)FormatUtils.parseObject(codSexo, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setFecIngr(
				(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienViewFrom.setValApelCasa(
				(java.lang.String)FormatUtils.parseObject(valApelCasa, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeClienViewTo = (MaeClienViewData)maeClienViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeClienViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeClienViewTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeClienViewFrom", maeClienViewFrom);
			dto.addProperty("maeClienViewTo", maeClienViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeClienView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeClienView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





