

/*
    INDRA/CAR/mmg
    $Id: CarParamGenerCarteTransactionComboLoad.java,v 1.1 2009/12/03 18:34:14 pecbazalar Exp $
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
public class CarParamGenerCarteTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarParamGenerCarteQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "CarParamGenerCarteConectorCombo";

	// Definicion del constructor
	public CarParamGenerCarteTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad CarParamGenerCarte");
			
			String nireOidNiveRedo = (String)getEntrada("nireOidNiveRedo");
			traza("MMG:: Valor de atributo nireOidNiveRedo: " + nireOidNiveRedo);
			
			String inijOidIndiNiveJera = (String)getEntrada("inijOidIndiNiveJera");
			traza("MMG:: Valor de atributo inijOidIndiNiveJera: " + inijOidIndiNiveJera);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarParamGenerCarteData carParamGenerCarte =new CarParamGenerCarteData();
			es.indra.belcorp.mso.CarNivelRedonData nireOidNiveRedoData = null;
			if(nireOidNiveRedo != null && !nireOidNiveRedo.trim().equals("")){
				nireOidNiveRedoData = new es.indra.belcorp.mso.CarNivelRedonData();
				nireOidNiveRedoData.setId(new Long(nireOidNiveRedo));
			}
			carParamGenerCarte.setNireOidNiveRedo(nireOidNiveRedoData);
			es.indra.belcorp.mso.CarIndicNivelJerarData inijOidIndiNiveJeraData = null;
			if(inijOidIndiNiveJera != null && !inijOidIndiNiveJera.trim().equals("")){
				inijOidIndiNiveJeraData = new es.indra.belcorp.mso.CarIndicNivelJerarData();
				inijOidIndiNiveJeraData.setId(new Long(inijOidIndiNiveJera));
			}
			carParamGenerCarte.setInijOidIndiNiveJera(inijOidIndiNiveJeraData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carParamGenerCarteFrom", carParamGenerCarte);
			dto.addProperty("carParamGenerCarteTo", carParamGenerCarte.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarParamGenerCarte");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarParamGenerCarte");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


