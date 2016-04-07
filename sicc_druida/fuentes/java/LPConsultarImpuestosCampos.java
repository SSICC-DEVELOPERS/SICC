

import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOModificarImpuesto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;


public class LPConsultarImpuestosCampos extends LPSICCBase {	
	
	public LPConsultarImpuestosCampos() {
		super();
	}

	private String casoDeUso=null;
	private String oid = null;
  private String accion = null;
	
	public void inicio() throws Exception {
    pagina("contenido_impuestos_ubigeo_insertar");
	}
	
public void ejecucion() throws Exception {
	setTrazaFichero();
 	
	try{
     //rastreo();
 
	   asignarAtributoPagina("cod","0400");
     accion     = conectorParametroLimpia("accion", "", true);
     casoDeUso  = conectorParametroLimpia("hidCasodeUso", "", true);	
     oid        = conectorParametroLimpia("oid", "", true);
     traza("el caso de uso es " + casoDeUso );
     asignarAtributo("VAR", "hidCasodeUso", "valor", casoDeUso);
     asignarAtributo("VAR", "oid", "valor", oid);

     if (casoDeUso.equals("consultar") )
     {
       traza("Asigna req = N ");
       this.asignarAtributo("CTEXTO", "txtCodigoSap","req","N");
       this.asignarAtributo("COMBO", "cbIndicadorImpuesto","req","N");
       this.asignarAtributo("COMBO", "cbCanal","req","N");       
       this.asignarAtributo("COMBO", "cbAcceso","req","N");              
       this.asignarAtributo("COMBO", "cbSubacceso","req","N");                     
     }
     

     if(accion.equals("")){
        /*Aca cargo el resto de la pantalla*/

        Vector paramEntrada_1 = new Vector();
        MareBusinessID id2 = new MareBusinessID("MAEConsultarImpuestos");
        DruidaConector conectorConsultar = new DruidaConector();
        DTOOID dtos = new DTOOID();
              
        dtos.setOid(new Long(oid));
        traza("el oid es " + oid);
        dtos.setOidPais(UtilidadesSession.getPais(this));
        dtos.setOidIdioma(UtilidadesSession.getIdioma(this));

        paramEntrada_1.add(dtos);
        paramEntrada_1.add(id2);

        conectorConsultar = conectar("ConectorConsultarImpuesto",paramEntrada_1);
        
        DTOConsultaImpuestoUBIGEO dtoConsImpu = (DTOConsultaImpuestoUBIGEO)conectorConsultar.objeto("DTOConsultaImpuestoUBIGEO");
        traza("el dto es " + dtoConsImpu);

        traza("Paso 0 "); 
        String producto  = dtoConsImpu.getProducto();
        traza("Paso 1 ");
        String impuesto  = dtoConsImpu.getImpuesto();
        traza("Paso 2 ");
        Long oidImpuesto = dtoConsImpu.getOidImpuesto();
        traza("Paso 3 ");
        String canal     = dtoConsImpu.getCanal();
        traza("Paso 4 ");
        String acceso    = dtoConsImpu.getAcceso();
        traza("Paso 5 ");
        String subAcceso = dtoConsImpu.getSubacceso();
        traza("Paso 6 ");
        

        asignarAtributo("VAR", "hProducto", "valor", producto);

        if((impuesto != null) && !(impuesto.equals(""))){
           asignarAtributo("VAR", "hImpuesto", "valor", impuesto);
           asignarAtributo("VAR", "hOidImpuesto", "valor", oidImpuesto.toString());
        }else{
           asignarAtributo("VAR", "hImpuesto", "valor", "");
           asignarAtributo("VAR", "hOidImpuesto", "valor", "");
           
        }
      
        asignarAtributo("VAR", "hCanal", "valor", canal);
        asignarAtributo("VAR", "hAcceso", "valor", acceso);
        asignarAtributo("VAR", "hSubacceso", "valor", subAcceso);
             
    } 

    
	
		
	} catch (Exception ex) {
           traza("EXCEPCION " + ex);
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           ex.printStackTrace(out);
           traza("EXCEPCION:" + stack.toString());
           lanzarPaginaError(ex);
  }				    
		
	
	getConfiguracionMenu();
  }
  
 }
