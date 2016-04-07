

/*
    INDRA/CAR/mmg
    $Id: ZonEstadZonaTransactionQuery.java,v 1.1 2009/12/03 18:42:12 pecbazalar Exp $
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
public class ZonEstadZonaTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonEstadZonaQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonEstadZonaConectorQueryList";

	// Definicion del constructor
	public ZonEstadZonaTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonEstadZona");
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			String codEstaZona = (String)getEntrada("codEstaZona");
			traza("MMG:: Valor de atributo codEstaZona: " + codEstaZona);
			if(codEstaZona != null && !codEstaZona.trim().equals("")) codEstaZona = codEstaZona.toUpperCase();
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String indInic = (String)getEntrada("indInic");
			traza("MMG:: Valor de atributo indInic: " + indInic);
			String impoVentMini = (String)getEntrada("impoVentMini");
			traza("MMG:: Valor de atributo impoVentMini: " + impoVentMini);
			String numConsMin = (String)getEntrada("numConsMin");
			traza("MMG:: Valor de atributo numConsMin: " + numConsMin);
			String numPediZona = (String)getEntrada("numPediZona");
			traza("MMG:: Valor de atributo numPediZona: " + numPediZona);
			String valoTiemMini = (String)getEntrada("valoTiemMini");
			traza("MMG:: Valor de atributo valoTiemMini: " + valoTiemMini);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonEstadZonaData zonEstadZonaFrom =new ZonEstadZonaData();
			ZonEstadZonaData zonEstadZonaTo = new ZonEstadZonaData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			zonEstadZonaFrom.setPaisOidPais(paisOidPaisData);
			zonEstadZonaFrom.setCodEstaZona(
				(java.lang.String)FormatUtils.parseObject(codEstaZona, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			zonEstadZonaFrom.setMarcOidMarc(marcOidMarcData);
			zonEstadZonaFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstadZonaFrom.setIndInic(
				(java.lang.String)FormatUtils.parseObject(indInic, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstadZonaFrom.setImpoVentMini(
				(java.lang.Double)FormatUtils.parseObject(impoVentMini, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstadZonaFrom.setNumConsMin(
				(java.lang.Long)FormatUtils.parseObject(numConsMin, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstadZonaFrom.setNumPediZona(
				(java.lang.Long)FormatUtils.parseObject(numPediZona, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			zonEstadZonaFrom.setValoTiemMini(
				(java.lang.Double)FormatUtils.parseObject(valoTiemMini, "java.lang.Double", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonEstadZonaTo = (ZonEstadZonaData)zonEstadZonaFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonEstadZonaFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonEstadZonaTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonEstadZonaFrom", zonEstadZonaFrom);
			dto.addProperty("zonEstadZonaTo", zonEstadZonaTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonEstadZona");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonEstadZona");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(zonEstadZonaFrom, zonEstadZonaTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	public void cmdPostQuery(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));zonEstadZonaFrom.setPaisOidPais(paisOculto);zonEstadZonaTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





