

/*
    INDRA/CAR/mmg
    $Id: MaeUnidaMedidTransactionQuery.java,v 1.1 2009/12/03 18:32:23 pecbazalar Exp $
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
public class MaeUnidaMedidTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	public static final String CHOICE_ATTRIBUTE = "desAbre";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeUnidaMedidQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeUnidaMedidConectorQueryList";

	// Definicion del constructor
	public MaeUnidaMedidTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeUnidaMedid");
			String codUnidMedi = (String)getEntrada("codUnidMedi");
			traza("MMG:: Valor de atributo codUnidMedi: " + codUnidMedi);
			if(codUnidMedi != null && !codUnidMedi.trim().equals("")) codUnidMedi = codUnidMedi.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String desAbre = (String)getEntrada("desAbre");
			traza("MMG:: Valor de atributo desAbre: " + desAbre);
			String magnOidMagn = (String)getEntrada("magnOidMagn");
			traza("MMG:: Valor de atributo magnOidMagn: " + magnOidMagn);
			String indUmStnd = (String)getEntrada("indUmStnd");
			traza("MMG:: Valor de atributo indUmStnd: " + indUmStnd);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeUnidaMedidData maeUnidaMedidFrom =new MaeUnidaMedidData();
			MaeUnidaMedidData maeUnidaMedidTo = new MaeUnidaMedidData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeUnidaMedidFrom.setCodUnidMedi(
				(java.lang.String)FormatUtils.parseObject(codUnidMedi, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeUnidaMedidFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeUnidaMedidFrom.setDesAbre(
				(java.lang.String)FormatUtils.parseObject(desAbre, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeMagniData magnOidMagnData = null;
			if(magnOidMagn != null && !magnOidMagn.trim().equals("")){
				magnOidMagnData = new es.indra.belcorp.mso.MaeMagniData();
				magnOidMagnData.setId(new Long(magnOidMagn));
			}
			maeUnidaMedidFrom.setMagnOidMagn(magnOidMagnData);
			maeUnidaMedidFrom.setIndUmStnd(
				(java.lang.String)FormatUtils.parseObject(indUmStnd, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			maeUnidaMedidTo = (MaeUnidaMedidData)maeUnidaMedidFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeUnidaMedidFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeUnidaMedidTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeUnidaMedidFrom", maeUnidaMedidFrom);
			dto.addProperty("maeUnidaMedidTo", maeUnidaMedidTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeUnidaMedidFrom, maeUnidaMedidTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeUnidaMedid");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeUnidaMedid");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeUnidaMedidFrom, maeUnidaMedidTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeUnidaMedidData maeUnidaMedidFrom, MaeUnidaMedidData maeUnidaMedidTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeUnidaMedidFrom.setPaisOidPais(paisOculto);maeUnidaMedidTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(MaeUnidaMedidData maeUnidaMedidFrom, MaeUnidaMedidData maeUnidaMedidTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeUnidaMedidFrom.setPaisOidPais(paisOculto);maeUnidaMedidTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





