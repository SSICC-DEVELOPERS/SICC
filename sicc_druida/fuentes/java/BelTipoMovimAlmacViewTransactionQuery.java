

/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacViewTransactionQuery.java,v 1.1 2009/12/03 18:36:19 pecbazalar Exp $
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
public class BelTipoMovimAlmacViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "codTipoMovi";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGBelTipoMovimAlmacViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "BelTipoMovimAlmacViewConectorQueryList";

	// Definicion del constructor
	public BelTipoMovimAlmacViewTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad BelTipoMovimAlmacView");
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
			String codOper1 = (String)getEntrada("codOper1");
			traza("MMG:: Valor de atributo codOper1: " + codOper1);
			String codOper2 = (String)getEntrada("codOper2");
			traza("MMG:: Valor de atributo codOper2: " + codOper2);
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			BelTipoMovimAlmacViewData belTipoMovimAlmacViewFrom =new BelTipoMovimAlmacViewData();
			BelTipoMovimAlmacViewData belTipoMovimAlmacViewTo = new BelTipoMovimAlmacViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			belTipoMovimAlmacViewFrom.setPaisOidPais(paisOidPaisData);
			belTipoMovimAlmacViewFrom.setCodTipoMovi(
				(java.lang.String)FormatUtils.parseObject(codTipoMovi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setCodMoviSap(
				(java.lang.String)FormatUtils.parseObject(codMoviSap, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setIndMoviEntrAlma(
				(java.lang.Long)FormatUtils.parseObject(indMoviEntrAlma, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setIndMantMovi(
				(java.lang.Long)FormatUtils.parseObject(indMantMovi, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setIndSap(
				(java.lang.Long)FormatUtils.parseObject(indSap, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setCodOper1(
				(java.lang.String)FormatUtils.parseObject(codOper1, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			belTipoMovimAlmacViewFrom.setCodOper2(
				(java.lang.String)FormatUtils.parseObject(codOper2, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			belTipoMovimAlmacViewTo = (BelTipoMovimAlmacViewData)belTipoMovimAlmacViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, belTipoMovimAlmacViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, belTipoMovimAlmacViewTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("belTipoMovimAlmacViewFrom", belTipoMovimAlmacViewFrom);
			dto.addProperty("belTipoMovimAlmacViewTo", belTipoMovimAlmacViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad BelTipoMovimAlmacView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad BelTipoMovimAlmacView");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





