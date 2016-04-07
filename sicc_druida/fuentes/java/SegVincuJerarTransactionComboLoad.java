

/*
    INDRA/CAR/mmg
    $Id: SegVincuJerarTransactionComboLoad.java,v 1.1 2009/12/03 18:37:40 pecbazalar Exp $
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
public class SegVincuJerarTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegVincuJerarQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "SegVincuJerarConectorCombo";

	// Definicion del constructor
	public SegVincuJerarTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad SegVincuJerar");
			
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			
			String acceOidAcce = (String)getEntrada("acceOidAcce");
			traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
			
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegVincuJerarData segVincuJerar =new SegVincuJerarData();
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			segVincuJerar.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			segVincuJerar.setCanaOidCana(canaOidCanaData);
			es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
			if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
				acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
				acceOidAcceData.setId(new Long(acceOidAcce));
			}
			segVincuJerar.setAcceOidAcce(acceOidAcceData);
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			segVincuJerar.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			segVincuJerar.setSociOidSoci(sociOidSociData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segVincuJerarFrom", segVincuJerar);
			dto.addProperty("segVincuJerarTo", segVincuJerar.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegVincuJerar");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegVincuJerar");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


