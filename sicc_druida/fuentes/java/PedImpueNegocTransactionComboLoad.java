

/*
    INDRA/CAR/mmg
    $Id: PedImpueNegocTransactionComboLoad.java,v 1.1 2009/12/03 18:35:57 pecbazalar Exp $
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
public class PedImpueNegocTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedImpueNegocQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "PedImpueNegocConectorCombo";

	// Definicion del constructor
	public PedImpueNegocTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad PedImpueNegoc");
			
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			
			String negoOidNego = (String)getEntrada("negoOidNego");
			traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
			
			String taimOidTasaImpu = (String)getEntrada("taimOidTasaImpu");
			traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedImpueNegocData pedImpueNegoc =new PedImpueNegocData();
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedImpueNegoc.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.MaeNegocData negoOidNegoData = null;
			if(negoOidNego != null && !negoOidNego.trim().equals("")){
				negoOidNegoData = new es.indra.belcorp.mso.MaeNegocData();
				negoOidNegoData.setId(new Long(negoOidNego));
			}
			pedImpueNegoc.setNegoOidNego(negoOidNegoData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
			if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
				taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
			}
			pedImpueNegoc.setTaimOidTasaImpu(taimOidTasaImpuData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedImpueNegocFrom", pedImpueNegoc);
			dto.addProperty("pedImpueNegocTo", pedImpueNegoc.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedImpueNegoc");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedImpueNegoc");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


