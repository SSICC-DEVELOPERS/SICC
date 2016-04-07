

/*
    INDRA/CAR/mmg
    $Id: ZonSecciViewTransactionComboLoad.java,v 1.1 2009/12/03 18:37:01 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class ZonSecciViewTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonSecciViewQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "ZonSecciViewConectorCombo";

	// Definicion del constructor
	public ZonSecciViewTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad ZonSecciView");
			
			String zzonOidZona = (String)getEntrada("zzonOidZona");
			traza("MMG:: Valor de atributo zzonOidZona: " + zzonOidZona);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonSecciViewData zonSecciView =new ZonSecciViewData();
			es.indra.belcorp.mso.ZonZonaViewData zzonOidZonaData = null;
			if(zzonOidZona != null && !zzonOidZona.trim().equals("")){
				zzonOidZonaData = new es.indra.belcorp.mso.ZonZonaViewData();
				zzonOidZonaData.setId(new Long(zzonOidZona));
			}
			zonSecciView.setZzonOidZona(zzonOidZonaData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonSecciViewFrom", zonSecciView);
			dto.addProperty("zonSecciViewTo", zonSecciView.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonSecciView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonSecciView");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


