

/*
    INDRA/CAR/mmg
    $Id: MsgMensaTransactionQuery.java,v 1.1 2009/12/03 18:38:23 pecbazalar Exp $
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
public class MsgMensaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "desMens";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMsgMensaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MsgMensaConectorQueryList";

	// Definicion del constructor
	public MsgMensaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MsgMensa");
			String codMens = (String)getEntrada("codMens");
			traza("MMG:: Valor de atributo codMens: " + codMens);
			if(codMens != null && !codMens.trim().equals("")) codMens = codMens.toUpperCase();
			String desMens = (String)getEntrada("desMens");
			traza("MMG:: Valor de atributo desMens: " + desMens);
			String valBloqGrupPerm = (String)getEntrada("valBloqGrupPerm");
			traza("MMG:: Valor de atributo valBloqGrupPerm: " + valBloqGrupPerm);
			String fecPermDesd = (String)getEntrada("fecPermDesd");
			traza("MMG:: Valor de atributo fecPermDesd: " + fecPermDesd);
			String fecPermHast = (String)getEntrada("fecPermHast");
			traza("MMG:: Valor de atributo fecPermHast: " + fecPermHast);
			String valText = (String)getEntrada("valText");
			traza("MMG:: Valor de atributo valText: " + valText);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MsgMensaData msgMensaFrom =new MsgMensaData();
			MsgMensaData msgMensaTo = new MsgMensaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			msgMensaFrom.setCodMens(
				(java.lang.String)FormatUtils.parseObject(codMens, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMensaFrom.setDesMens(
				(java.lang.String)FormatUtils.parseObject(desMens, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMensaFrom.setValBloqGrupPerm(
				(java.lang.String)FormatUtils.parseObject(valBloqGrupPerm, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMensaFrom.setFecPermDesd(
				(java.sql.Date)FormatUtils.parseObject(fecPermDesd, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMensaFrom.setFecPermHast(
				(java.sql.Date)FormatUtils.parseObject(fecPermHast, "java.sql.Date", 
			UtilidadesSession.getFormatoFecha(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			msgMensaFrom.setValText(
				(java.lang.String)FormatUtils.parseObject(valText, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			msgMensaTo = (MsgMensaData)msgMensaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, msgMensaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, msgMensaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("msgMensaFrom", msgMensaFrom);
			dto.addProperty("msgMensaTo", msgMensaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MsgMensa");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MsgMensa");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





