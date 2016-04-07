import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.UtilidadesSession;

public class LPComisiones extends LPSICCBase {  
	private String cteDTOCache = "claveDTOComisiones";
	public int idPestanya;
	private DTOComisiones dtoComision;
	public String marcaTemp;
	public String canalTemp;
	public String opcionMenu;
	public String titulo;
	public String oidTipoPlantilla;
	public String estadoVentana;

	public LPComisiones() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception { }  	
  
	public DTOComisiones getComision() {     
		return (DTOComisiones)this.getSessionCache().get(cteDTOCache);
	}
  
	public void setComision(DTOComisiones dtoComisiones) {     
		this.getSessionCache().put(cteDTOCache, dtoComisiones);
	}

	public void redirigir (Integer idPestanyaDest) throws Exception {
		traza("************ Entre a redirigir - LPComisiones");
		traza("************ idPestanyaDest " + idPestanyaDest.toString());
		traza("************ marcaTemp " + marcaTemp);
		traza("************ canalTemp " + canalTemp);
		traza("************ opcionMenu " + opcionMenu);
		traza("************ titulo " + titulo);
		traza("************ oidTipoPlantilla " + oidTipoPlantilla);
		traza("************ estadoVentana " + estadoVentana);

		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		String sComisionEscalonada = getComision().getComisionEscalonada()!=null && 
									getComision().getComisionEscalonada().booleanValue()?"S":"N";
		
		if(idPestanya!=idPestanyaDest.intValue()) {
			if(idPestanyaDest.intValue() == ConstantesCOMPestanyas.PESTANYA_DATOS_GENERALES) {
				conectorAction("LPMantenimientoComisionesDatosGenerales");
				conectorActionParametro("accion", "cargar");        
				conectorActionParametro("opcionMenu", opcionMenu);       
				conectorActionParametro("titulo", titulo);       
				conectorActionParametro("oidTipoPlantilla", oidTipoPlantilla);  
				conectorActionParametro("estadoVentana", estadoVentana);  
			}
			if(idPestanyaDest.intValue() == ConstantesCOMPestanyas.PESTANYA_PRODUCTOS) {
				conectorAction("LPMantenimientoComisionesProductos");
				conectorActionParametro("accion", "");        
				conectorActionParametro("marcaTemp", marcaTemp);        
				conectorActionParametro("canalTemp", canalTemp);         
				conectorActionParametro("opcionMenu", opcionMenu);     
				conectorActionParametro("titulo", titulo);       
				conectorActionParametro("oidTipoPlantilla", oidTipoPlantilla);  
				conectorActionParametro("estadoVentana", estadoVentana);  
				
				// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
				conectorActionParametro("sComisionEscalonada", sComisionEscalonada);
			}
			if(idPestanyaDest.intValue() == ConstantesCOMPestanyas.PESTANYA_CLIENTES) {
				conectorAction("LPMantenimientoComisionesClientes");
				conectorActionParametro("accion", "");        
				conectorActionParametro("marcaTemp", marcaTemp);        
				conectorActionParametro("canalTemp", canalTemp);        
				conectorActionParametro("opcionMenu", opcionMenu);    
				conectorActionParametro("titulo", titulo);       
				conectorActionParametro("oidTipoPlantilla", oidTipoPlantilla);  
				conectorActionParametro("estadoVentana", estadoVentana);
				
				// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
				conectorActionParametro("sComisionEscalonada", sComisionEscalonada);
			}
			if(idPestanyaDest.intValue() == ConstantesCOMPestanyas.PESTANYA_DATOS_CALCULO) {
				conectorAction("LPMantenimientoComisionesDatosCalculo");
				conectorActionParametro("accion", "");        
				conectorActionParametro("marcaTemp", marcaTemp);        
				conectorActionParametro("canalTemp", canalTemp);       
				conectorActionParametro("opcionMenu", opcionMenu);    
				conectorActionParametro("titulo", titulo);       
				conectorActionParametro("oidTipoPlantilla", oidTipoPlantilla);  
				conectorActionParametro("estadoVentana", estadoVentana);  
			}
			if(idPestanyaDest.intValue() == ConstantesCOMPestanyas.PESTANYA_ESCALONADA) {
				conectorAction("LPMantenimientoComisionesEscalonada");
				conectorActionParametro("accion", "");        
				conectorActionParametro("marcaTemp", marcaTemp);        
				conectorActionParametro("canalTemp", canalTemp);       
				conectorActionParametro("opcionMenu", opcionMenu);    
				conectorActionParametro("titulo", titulo);       
				conectorActionParametro("oidTipoPlantilla", oidTipoPlantilla);  
				conectorActionParametro("estadoVentana", estadoVentana);  
			}     
		}    
	}

	public void verificarDatosComision () throws Exception {
		traza("************ Entre a verificarDatosComision");
		DTOComisiones dtoComisiones = this.getComision();
		traza("************ dtoComisiones:" + dtoComisiones);
	
		if(dtoComisiones==null) {
			dtoComisiones = new DTOComisiones();
		}

		if((dtoComisiones.getComisionesClientes()==null) || (dtoComisiones.getComisionesClientes().size() < 1)) {		
			asignarAtributo("VAR", "datosPestanyaClientes", "valor", "false");          
		}
		else {
			asignarAtributo("VAR", "datosPestanyaClientes", "valor", "true");          
		}

		if((dtoComisiones.getComisionesVentas()==null) && (dtoComisiones.getComisionesCobranza()==null)){		
			asignarAtributo("VAR", "datosPestanyaDatosCalculo", "valor", "false");          
		}
		else {
			asignarAtributo("VAR", "datosPestanyaDatosCalculo", "valor", "true");          
		}
	}

	public void guardar () throws Exception {
		setTrazaFichero();
	    traza("************ Entre a guardar - LPComisiones");

	    DTOComisiones dtoComisiones = this.getComision();
		Long lPais = UtilidadesSession.getPais(this);
 	    dtoComisiones.setOidPais(lPais);

		Long lIdioma = UtilidadesSession.getIdioma(this);
		dtoComisiones.setOidIdioma(lIdioma);
    
        MareBusinessID businessID = new MareBusinessID("COMGuardarComisiones");
		Vector parametros = new Vector();
		parametros.add(dtoComisiones);
		parametros.add(businessID);
		
		try {      
			traza("******************* Antes de conectar");			
			DruidaConector con = conectar("ConectorGuardarComisiones", parametros);
			traza("******************* Despues de conectar");
		}
		catch(Exception e) {
			traza("******************* Entro al catch...");        
			asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
			throw e;
		} 
	}   
}