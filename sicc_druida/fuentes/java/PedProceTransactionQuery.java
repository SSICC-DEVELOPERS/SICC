

/*
    INDRA/CAR/mmg
    $Id: PedProceTransactionQuery.java,v 1.1 2009/12/03 18:35:07 pecbazalar Exp $
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
public class PedProceTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	public static final String CHOICE_ATTRIBUTE = "Descripcion";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedProceQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedProceConectorQueryList";

	// Definicion del constructor
	public PedProceTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedProce");
			String codProc = (String)getEntrada("codProc");
			traza("MMG:: Valor de atributo codProc: " + codProc);
			if(codProc != null && !codProc.trim().equals("")) codProc = codProc.toUpperCase();
			String Descripcion = (String)getEntrada("Descripcion");
			traza("MMG:: Valor de atributo Descripcion: " + Descripcion);
			String grprOidGrupProc = (String)getEntrada("grprOidGrupProc");
			traza("MMG:: Valor de atributo grprOidGrupProc: " + grprOidGrupProc);
			String progOidProg = (String)getEntrada("progOidProg");
			traza("MMG:: Valor de atributo progOidProg: " + progOidProg);
			String procOidProc = (String)getEntrada("procOidProc");
			traza("MMG:: Valor de atributo procOidProc: " + procOidProc);
			String tposOidTipoPosi = (String)getEntrada("tposOidTipoPosi");
			traza("MMG:: Valor de atributo tposOidTipoPosi: " + tposOidTipoPosi);
			String stpoOidSubtPosi = (String)getEntrada("stpoOidSubtPosi");
			traza("MMG:: Valor de atributo stpoOidSubtPosi: " + stpoOidSubtPosi);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedProceData pedProceFrom =new PedProceData();
			PedProceData pedProceTo = new PedProceData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedProceFrom.setCodProc(
				(java.lang.String)FormatUtils.parseObject(codProc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedProceFrom.setDescripcion(
				(java.lang.String)FormatUtils.parseObject(Descripcion, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.PedGrupoProceData grprOidGrupProcData = null;
			if(grprOidGrupProc != null && !grprOidGrupProc.trim().equals("")){
				grprOidGrupProcData = new es.indra.belcorp.mso.PedGrupoProceData();
				grprOidGrupProcData.setId(new Long(grprOidGrupProc));
			}
			pedProceFrom.setGrprOidGrupProc(grprOidGrupProcData);
			es.indra.belcorp.mso.PedProgrData progOidProgData = null;
			if(progOidProg != null && !progOidProg.trim().equals("")){
				progOidProgData = new es.indra.belcorp.mso.PedProgrData();
				progOidProgData.setId(new Long(progOidProg));
			}
			pedProceFrom.setProgOidProg(progOidProgData);
			es.indra.belcorp.mso.PedProceViewData procOidProcData = null;
			if(procOidProc != null && !procOidProc.trim().equals("")){
				procOidProcData = new es.indra.belcorp.mso.PedProceViewData();
				procOidProcData.setId(new Long(procOidProc));
			}
			pedProceFrom.setProcOidProc(procOidProcData);
			es.indra.belcorp.mso.PedTipoPosicData tposOidTipoPosiData = null;
			if(tposOidTipoPosi != null && !tposOidTipoPosi.trim().equals("")){
				tposOidTipoPosiData = new es.indra.belcorp.mso.PedTipoPosicData();
				tposOidTipoPosiData.setId(new Long(tposOidTipoPosi));
			}
			pedProceFrom.setTposOidTipoPosi(tposOidTipoPosiData);
			es.indra.belcorp.mso.PedSubtiPosicViewData stpoOidSubtPosiData = null;
			if(stpoOidSubtPosi != null && !stpoOidSubtPosi.trim().equals("")){
				stpoOidSubtPosiData = new es.indra.belcorp.mso.PedSubtiPosicViewData();
				stpoOidSubtPosiData.setId(new Long(stpoOidSubtPosi));
			}
			pedProceFrom.setStpoOidSubtPosi(stpoOidSubtPosiData);
			
			
			//Construimos el to
			pedProceTo = (PedProceData)pedProceFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedProceFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedProceTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedProceFrom", pedProceFrom);
			dto.addProperty("pedProceTo", pedProceTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedProce");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedProce");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





