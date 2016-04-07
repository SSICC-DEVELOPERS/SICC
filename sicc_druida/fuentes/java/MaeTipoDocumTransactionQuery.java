

/*
    INDRA/CAR/mmg
    $Id: MaeTipoDocumTransactionQuery.java,v 1.1 2009/12/03 18:38:22 pecbazalar Exp $
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
public class MaeTipoDocumTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeTipoDocumQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "MaeTipoDocumConectorQueryList";

	// Definicion del constructor
	public MaeTipoDocumTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad MaeTipoDocum");
			String codTipoDocu = (String)getEntrada("codTipoDocu");
			traza("MMG:: Valor de atributo codTipoDocu: " + codTipoDocu);
			if(codTipoDocu != null && !codTipoDocu.trim().equals("")) codTipoDocu = codTipoDocu.toUpperCase();
			String indObli = (String)getEntrada("indObli");
			traza("MMG:: Valor de atributo indObli: " + indObli);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String valSigl = (String)getEntrada("valSigl");
			traza("MMG:: Valor de atributo valSigl: " + valSigl);
			String valLong = (String)getEntrada("valLong");
			traza("MMG:: Valor de atributo valLong: " + valLong);
			String indDni = (String)getEntrada("indDni");
			traza("MMG:: Valor de atributo indDni: " + indDni);
			String indDocIdenFisc = (String)getEntrada("indDocIdenFisc");
			traza("MMG:: Valor de atributo indDocIdenFisc: " + indDocIdenFisc);
			String tidoOidTipoDocu = (String)getEntrada("tidoOidTipoDocu");
			traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeTipoDocumData maeTipoDocumFrom =new MaeTipoDocumData();
			MaeTipoDocumData maeTipoDocumTo = new MaeTipoDocumData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			maeTipoDocumFrom.setCodTipoDocu(
				(java.lang.String)FormatUtils.parseObject(codTipoDocu, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setIndObli(
				(java.lang.String)FormatUtils.parseObject(indObli, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setValSigl(
				(java.lang.String)FormatUtils.parseObject(valSigl, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setValLong(
				(java.lang.Long)FormatUtils.parseObject(valLong, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setIndDni(
				(java.lang.String)FormatUtils.parseObject(indDni, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			maeTipoDocumFrom.setIndDocIdenFisc(
				(java.lang.String)FormatUtils.parseObject(indDocIdenFisc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
			if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
				tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
				tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
			}
			maeTipoDocumFrom.setTidoOidTipoDocu(tidoOidTipoDocuData);
			
			
			//Construimos el to
			maeTipoDocumTo = (MaeTipoDocumData)maeTipoDocumFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, maeTipoDocumFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, maeTipoDocumTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeTipoDocumFrom", maeTipoDocumFrom);
			dto.addProperty("maeTipoDocumTo", maeTipoDocumTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(maeTipoDocumFrom, maeTipoDocumTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeTipoDocum");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeTipoDocum");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(maeTipoDocumFrom, maeTipoDocumTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocumFrom.setPaisOidPais(paisOculto);maeTipoDocumTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
	public void cmdPostQuery(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, DruidaConector result) throws Exception{
		SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));maeTipoDocumFrom.setPaisOidPais(paisOculto);maeTipoDocumTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
	}
	
	
}





