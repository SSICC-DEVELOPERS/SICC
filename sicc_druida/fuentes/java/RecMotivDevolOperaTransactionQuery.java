

/*
    INDRA/CAR/mmg
    $Id: RecMotivDevolOperaTransactionQuery.java,v 1.1 2009/12/03 18:42:18 pecbazalar Exp $
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
public class RecMotivDevolOperaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecMotivDevolOperaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "RecMotivDevolOperaConectorQueryList";

	// Definicion del constructor
	public RecMotivDevolOperaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad RecMotivDevolOpera");
			String ropeOidOper = (String)getEntrada("ropeOidOper");
			traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
			String modvOidMotiDevo = (String)getEntrada("modvOidMotiDevo");
			traza("MMG:: Valor de atributo modvOidMotiDevo: " + modvOidMotiDevo);
			String valMarcDefe = (String)getEntrada("valMarcDefe");
			traza("MMG:: Valor de atributo valMarcDefe: " + valMarcDefe);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecMotivDevolOperaData recMotivDevolOperaFrom =new RecMotivDevolOperaData();
			RecMotivDevolOperaData recMotivDevolOperaTo = new RecMotivDevolOperaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.RecOperaViewData ropeOidOperData = null;
			if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
				ropeOidOperData = new es.indra.belcorp.mso.RecOperaViewData();
				ropeOidOperData.setId(new Long(ropeOidOper));
			}
			recMotivDevolOperaFrom.setRopeOidOper(ropeOidOperData);
			es.indra.belcorp.mso.RecMotivDevolData modvOidMotiDevoData = null;
			if(modvOidMotiDevo != null && !modvOidMotiDevo.trim().equals("")){
				modvOidMotiDevoData = new es.indra.belcorp.mso.RecMotivDevolData();
				modvOidMotiDevoData.setId(new Long(modvOidMotiDevo));
			}
			recMotivDevolOperaFrom.setModvOidMotiDevo(modvOidMotiDevoData);
			recMotivDevolOperaFrom.setValMarcDefe(
				(java.lang.Boolean)FormatUtils.parseObject(valMarcDefe, "java.lang.Boolean", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			recMotivDevolOperaTo = (RecMotivDevolOperaData)recMotivDevolOperaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, recMotivDevolOperaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, recMotivDevolOperaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recMotivDevolOperaFrom", recMotivDevolOperaFrom);
			dto.addProperty("recMotivDevolOperaTo", recMotivDevolOperaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(recMotivDevolOperaFrom, recMotivDevolOperaTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecMotivDevolOpera");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecMotivDevolOpera");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(recMotivDevolOperaFrom, recMotivDevolOperaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOperaFrom.setPaisOidPais(paisOculto); recMotivDevolOperaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recMotivDevolOperaFrom.setPaisOidPais(paisOculto); recMotivDevolOperaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





