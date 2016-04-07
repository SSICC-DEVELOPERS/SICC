
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


public class LPModificacionImpuestos extends LPSICCBase {	
	
	public LPModificacionImpuestos() {
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
     rastreo();
 
		 asignarAtributoPagina("cod","0398");
     accion     = conectorParametroLimpia("accion", "", true);
     casoDeUso  = conectorParametroLimpia("hidCasodeUso", "", true);	
     oid        = conectorParametroLimpia("oid", "", true);
     traza("el caso de uso es " + casoDeUso );
     asignarAtributo("VAR", "hidCasodeUso", "valor", casoDeUso);
     asignarAtributo("VAR", "oid", "valor", oid);
     

     if(accion.equals("")){
       
        
        /*con estos datos cargo el combo de tasas de impuesto*/
       
        traza("el oid es " + oid);
        Vector paramEntrada = new Vector();
        MareBusinessID id = new MareBusinessID("MAEObtenerTasasImpuesto");
        DruidaConector conectorComboTasa = new DruidaConector();
        DTOBelcorp dto = new DTOBelcorp();

        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));

        paramEntrada.add(dto);
        paramEntrada.add(id);
               
        conectorComboTasa = conectar("ConectorComboTasasImpuesto",paramEntrada);
        DTOSalida dtoTasa = (DTOSalida)conectorComboTasa.objeto("DTOSalida");
            
        RecordSet rsTasas      = dtoTasa.getResultado();
        Vector colTasas        = rsTasas.getColumnIdentifiers();
        int numColTasas        = rsTasas.getColumnCount();
        DruidaConector tasas   = UtilidadesBelcorp.generarConector("DTOSalida.resultado_ROWSET",rsTasas, colTasas);
        asignar("COMBO","cbIndicadorImpuesto", tasas, "DTOSalida.resultado_ROWSET");

        /*Aca cargo el resto de la pantalla*/

        Vector paramEntrada_1 = new Vector();
        MareBusinessID id2 = new MareBusinessID("MAEConsultarImpuestos");
        DruidaConector conectorConsultar = new DruidaConector();
        DTOOID dtos = new DTOOID();
              
        dtos.setOid(new Long(oid));
        dtos.setOidPais(UtilidadesSession.getPais(this));
        dtos.setOidIdioma(UtilidadesSession.getIdioma(this));

        paramEntrada_1.add(dtos);
        paramEntrada_1.add(id2);

        conectorConsultar = conectar("ConectorConsultarImpuesto",paramEntrada_1);
        
        DTOConsultaImpuestoUBIGEO dtoConsImpu = (DTOConsultaImpuestoUBIGEO)conectorConsultar.objeto("DTOConsultaImpuestoUBIGEO");

        String producto  = dtoConsImpu.getProducto();
        Long oidImpuesto = dtoConsImpu.getOidImpuesto();
        String canal     = dtoConsImpu.getCanal();
        String acceso    = dtoConsImpu.getAcceso();
        String subAcceso = dtoConsImpu.getSubacceso();
        

        asignarAtributo("VAR", "hProducto", "valor", producto);

        if((oidImpuesto != null) && !(oidImpuesto.equals(""))){
           asignarAtributo("VAR", "hOidImpuesto", "valor", oidImpuesto.toString());
        }

        asignarAtributo("VAR", "hCanal", "valor", canal);
        asignarAtributo("VAR", "hAcceso", "valor", acceso);
        asignarAtributo("VAR", "hSubacceso", "valor", subAcceso);
             
    } 

    if(accion.equals("guardar")){
       pagina("salidaGenerica");
       traza("entro a guardar");
       Vector paramModificar = new Vector();
       traza("PAso 1");
       MareBusinessID idGuardar = new MareBusinessID("MAEModificarImpuesto");
       traza("PAso 2");
       DTOModificarImpuesto dtoMod = new DTOModificarImpuesto();
       traza("PAso 3");
       DruidaConector conectorModificar = new DruidaConector();
       traza("PAso 4");

       String impuesto = conectorParametroLimpia("cbIndicadorImpuesto", "", true);
       traza("el impuesto es " + impuesto);
       traza("el oid es " + oid);
       traza("PAso 5");
       dtoMod.setOid(new Long(oid));
       if((impuesto != null) && !(impuesto.equals(""))){
          dtoMod.setImpuesto(new Long(impuesto));
       }else{
          dtoMod.setImpuesto(null);
       }
       traza("PAso 7");

       paramModificar.add(dtoMod);
       paramModificar.add(idGuardar);
       traza("PAso 8");
       
       traza("PAso 9");

       conectorModificar = conectar("ConectorModificarImpuesto",paramModificar);
       asignarAtributo("VAR","ejecutar","valor","modificoOk();");
       asignarAtributo("VAR","ejecutarError","valor","noModifico();");
       
    }
	
		
	} catch (Exception ex) {
           traza("EXCEPCION " + ex);
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           ex.printStackTrace(out);
           traza("EXCEPCION:" + stack.toString());
           lanzarPaginaError(ex);
  }				    
		
	
	getConfiguracionMenu("LPModificacionImpuestos", "Modificar");
  }
  
 }
