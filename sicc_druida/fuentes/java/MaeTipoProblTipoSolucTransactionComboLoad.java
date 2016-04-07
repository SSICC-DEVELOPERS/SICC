

/*
    INDRA/CAR/mmg
    $Id: MaeTipoProblTipoSolucTransactionComboLoad.java,v 1.1 2009/12/03 18:35:22 pecbazalar Exp $
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
public class MaeTipoProblTipoSolucTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeTipoProblTipoSolucQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "MaeTipoProblTipoSolucConectorCombo";

	// Definicion del constructor
	public MaeTipoProblTipoSolucTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad MaeTipoProblTipoSoluc");
			
			String tipbOidTipoProb = (String)getEntrada("tipbOidTipoProb");
			traza("MMG:: Valor de atributo tipbOidTipoProb: " + tipbOidTipoProb);
			
			String tsocOidTipoSolu = (String)getEntrada("tsocOidTipoSolu");
			traza("MMG:: Valor de atributo tsocOidTipoSolu: " + tsocOidTipoSolu);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeTipoProblTipoSolucData maeTipoProblTipoSoluc =new MaeTipoProblTipoSolucData();
			es.indra.belcorp.mso.MaeTipoProblData tipbOidTipoProbData = null;
			if(tipbOidTipoProb != null && !tipbOidTipoProb.trim().equals("")){
				tipbOidTipoProbData = new es.indra.belcorp.mso.MaeTipoProblData();
				tipbOidTipoProbData.setId(new Long(tipbOidTipoProb));
			}
			maeTipoProblTipoSoluc.setTipbOidTipoProb(tipbOidTipoProbData);
			es.indra.belcorp.mso.MaeTipoSolucData tsocOidTipoSoluData = null;
			if(tsocOidTipoSolu != null && !tsocOidTipoSolu.trim().equals("")){
				tsocOidTipoSoluData = new es.indra.belcorp.mso.MaeTipoSolucData();
				tsocOidTipoSoluData.setId(new Long(tsocOidTipoSolu));
			}
			maeTipoProblTipoSoluc.setTsocOidTipoSolu(tsocOidTipoSoluData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeTipoProblTipoSolucFrom", maeTipoProblTipoSoluc);
			dto.addProperty("maeTipoProblTipoSolucTo", maeTipoProblTipoSoluc.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeTipoProblTipoSoluc");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeTipoProblTipoSoluc");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


