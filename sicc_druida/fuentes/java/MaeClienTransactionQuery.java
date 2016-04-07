

/*
    INDRA/CAR/mmg
    $Id: MaeClienTransactionQuery.java,v 1.1 2009/12/03 18:35:29 pecbazalar Exp $
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
public class MaeClienTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	public static final String CHOICE_ATTRIBUTE = "codClie";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeClienQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeClienConectorQueryList";

	// Definicion del constructor
	public MaeClienTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeClien");
			String codClie = (String)getEntrada("codClie");
			traza("MMG:: Valor de atributo codClie: " + codClie);
			String indFichInsc = (String)getEntrada("indFichInsc");
			traza("MMG:: Valor de atributo indFichInsc: " + indFichInsc);
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
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
			String fopaOidFormPago = (String)getEntrada("fopaOidFormPago");
			traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
			String valApelCasa = (String)getEntrada("valApelCasa");
			traza("MMG:: Valor de atributo valApelCasa: " + valApelCasa);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeClienData maeClienFrom =new MaeClienData();
			MaeClienData maeClienTo = new MaeClienData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeClienFrom.setCodClie(
				(java.lang.String)FormatUtils.parseObject(codClie, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setIndFichInsc(
				(java.lang.Long)FormatUtils.parseObject(indFichInsc, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeClienFrom.setPaisOidPais(paisOidPaisData);
			maeClienFrom.setCodDigiCtrl(
				(java.lang.String)FormatUtils.parseObject(codDigiCtrl, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValApe1(
				(java.lang.String)FormatUtils.parseObject(valApe1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValApe2(
				(java.lang.String)FormatUtils.parseObject(valApe2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValNom1(
				(java.lang.String)FormatUtils.parseObject(valNom1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValNom2(
				(java.lang.String)FormatUtils.parseObject(valNom2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValTrat(
				(java.lang.String)FormatUtils.parseObject(valTrat, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValCritBus1(
				(java.lang.String)FormatUtils.parseObject(valCritBus1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setValCritBus2(
				(java.lang.String)FormatUtils.parseObject(valCritBus2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setCodSexo(
				(java.lang.String)FormatUtils.parseObject(codSexo, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeClienFrom.setFecIngr(
				(java.sql.Date)FormatUtils.parseObject(fecIngr, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPagoData = null;
			if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
				fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoTaponData();
				fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
			}
			maeClienFrom.setFopaOidFormPago(fopaOidFormPagoData);
			maeClienFrom.setValApelCasa(
				(java.lang.String)FormatUtils.parseObject(valApelCasa, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeClienTo = (MaeClienData)maeClienFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeClienFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeClienTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeClienFrom", maeClienFrom);
			dto.addProperty("maeClienTo", maeClienTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeClien");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeClien");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





