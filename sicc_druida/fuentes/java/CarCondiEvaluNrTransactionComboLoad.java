

/*
    INDRA/CAR/mmg
    $Id: CarCondiEvaluNrTransactionComboLoad.java,v 1.1 2009/12/03 18:32:31 pecbazalar Exp $
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
public class CarCondiEvaluNrTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarCondiEvaluNrQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "CarCondiEvaluNrConectorCombo";

	// Definicion del constructor
	public CarCondiEvaluNrTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad CarCondiEvaluNr");
			
			String penrOidParaEvalNr = (String)getEntrada("penrOidParaEvalNr");
			traza("MMG:: Valor de atributo penrOidParaEvalNr: " + penrOidParaEvalNr);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarCondiEvaluNrData carCondiEvaluNr =new CarCondiEvaluNrData();
			es.indra.belcorp.mso.CarParamEvaluNrData penrOidParaEvalNrData = null;
			if(penrOidParaEvalNr != null && !penrOidParaEvalNr.trim().equals("")){
				penrOidParaEvalNrData = new es.indra.belcorp.mso.CarParamEvaluNrData();
				penrOidParaEvalNrData.setId(new Long(penrOidParaEvalNr));
			}
			carCondiEvaluNr.setPenrOidParaEvalNr(penrOidParaEvalNrData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carCondiEvaluNrFrom", carCondiEvaluNr);
			dto.addProperty("carCondiEvaluNrTo", carCondiEvaluNr.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarCondiEvaluNr");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarCondiEvaluNr");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


