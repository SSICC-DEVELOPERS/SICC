

/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacTransactionQuery.java,v 1.1 2009/12/03 18:36:19 pecbazalar Exp $
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
public class BelTipoMovimAlmacTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "codTipoMovi";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimAlmacQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelTipoMovimAlmacConectorQueryList";

	// Definicion del constructor
	public BelTipoMovimAlmacTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelTipoMovimAlmac");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String codTipoMovi = (String)getEntrada("codTipoMovi");
			traza("MMG:: Valor de atributo codTipoMovi: " + codTipoMovi);
			String codMoviSap = (String)getEntrada("codMoviSap");
			traza("MMG:: Valor de atributo codMoviSap: " + codMoviSap);
			String indMoviEntrAlma = (String)getEntrada("indMoviEntrAlma");
			traza("MMG:: Valor de atributo indMoviEntrAlma: " + indMoviEntrAlma);
			String indMantMovi = (String)getEntrada("indMantMovi");
			traza("MMG:: Valor de atributo indMantMovi: " + indMantMovi);
			String indSap = (String)getEntrada("indSap");
			traza("MMG:: Valor de atributo indSap: " + indSap);
			String esmeOidEstaMerc1 = (String)getEntrada("esmeOidEstaMerc1");
			traza("MMG:: Valor de atributo esmeOidEstaMerc1: " + esmeOidEstaMerc1);
			String esmeOidEstaMerc2 = (String)getEntrada("esmeOidEstaMerc2");
			traza("MMG:: Valor de atributo esmeOidEstaMerc2: " + esmeOidEstaMerc2);
			String codOper1 = (String)getEntrada("codOper1");
			traza("MMG:: Valor de atributo codOper1: " + codOper1);
			String codOper2 = (String)getEntrada("codOper2");
			traza("MMG:: Valor de atributo codOper2: " + codOper2);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			BelTipoMovimAlmacData belTipoMovimAlmacFrom =new BelTipoMovimAlmacData();
			BelTipoMovimAlmacData belTipoMovimAlmacTo = new BelTipoMovimAlmacData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			belTipoMovimAlmacFrom.setPaisOidPais(paisOidPaisData);
			belTipoMovimAlmacFrom.setCodTipoMovi(
				(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacFrom.setCodMoviSap(
				(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacFrom.setIndMoviEntrAlma(
				(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacFrom.setIndMantMovi(
				(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacFrom.setIndSap(
				(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc1Data = null;
			if(esmeOidEstaMerc1 != null && !esmeOidEstaMerc1.trim().equals("")){
				esmeOidEstaMerc1Data = new es.indra.belcorp.mso.BelEstadMercaData();
				esmeOidEstaMerc1Data.setId(new Long(esmeOidEstaMerc1));
			}
			belTipoMovimAlmacFrom.setEsmeOidEstaMerc1(esmeOidEstaMerc1Data);
			es.indra.belcorp.mso.BelEstadMercaData esmeOidEstaMerc2Data = null;
			if(esmeOidEstaMerc2 != null && !esmeOidEstaMerc2.trim().equals("")){
				esmeOidEstaMerc2Data = new es.indra.belcorp.mso.BelEstadMercaData();
				esmeOidEstaMerc2Data.setId(new Long(esmeOidEstaMerc2));
			}
			belTipoMovimAlmacFrom.setEsmeOidEstaMerc2(esmeOidEstaMerc2Data);
			belTipoMovimAlmacFrom.setCodOper1(
				(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacFrom.setCodOper2(
				(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			belTipoMovimAlmacTo = (BelTipoMovimAlmacData)belTipoMovimAlmacFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belTipoMovimAlmacFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belTipoMovimAlmacTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belTipoMovimAlmacFrom", belTipoMovimAlmacFrom);
			dto.addProperty("belTipoMovimAlmacTo", belTipoMovimAlmacTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad BelTipoMovimAlmac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad BelTipoMovimAlmac");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





