

/*
    INDRA/CAR/mmg
    $Id: CccTipoTransTransactionQuery.java,v 1.1 2009/12/03 18:34:08 pecbazalar Exp $
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
public class CccTipoTransTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccTipoTransQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccTipoTransConectorQueryList";

	// Definicion del constructor
	public CccTipoTransTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad CccTipoTrans");
			String codTipoTran = (String)getEntrada("codTipoTran");
			traza("MMG:: Valor de atributo codTipoTran: " + codTipoTran);
			if(codTipoTran != null && !codTipoTran.trim().equals("")) codTipoTran = codTipoTran.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String codTipoTranCheq = (String)getEntrada("codTipoTranCheq");
			traza("MMG:: Valor de atributo codTipoTranCheq: " + codTipoTranCheq);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CccTipoTransData cccTipoTransFrom =new CccTipoTransData();
			CccTipoTransData cccTipoTransTo = new CccTipoTransData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			cccTipoTransFrom.setCodTipoTran(
				(java.lang.String)FormatUtils.parseObject(codTipoTran, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccTipoTransFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			cccTipoTransFrom.setCodTipoTranCheq(
				(java.lang.String)FormatUtils.parseObject(codTipoTranCheq, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccTipoTransTo = (CccTipoTransData)cccTipoTransFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccTipoTransFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccTipoTransTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccTipoTransFrom", cccTipoTransFrom);
			dto.addProperty("cccTipoTransTo", cccTipoTransTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(cccTipoTransFrom, cccTipoTransTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CccTipoTrans");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CccTipoTrans");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(cccTipoTransFrom, cccTipoTransTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));cccTipoTransFrom.setPaisOidPais(paisOculto);cccTipoTransTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));cccTipoTransFrom.setPaisOidPais(paisOculto);cccTipoTransTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





