import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.logicanegocio.intsys.ConstantesOCR;
import es.indra.sicc.dtos.intsys.DTOInterfaz;


public class LPEnviarConsultoras extends LPSICCBase {

  public LPEnviarConsultoras() {
    super();
  }
    
  public void inicio() throws Exception {
      pagina("contenido_consultora_enviar");
      this.getConfiguracionMenu();
  }

  public void ejecucion() throws Exception {
      
	  rastreo();

      setTrazaFichero();
      String accion = conectorParametro("accion");
      accion = (accion==null )?"":accion;
      traza("accion en LPGenerarConsultoras: " + accion);   
      try{
          if(accion.equals("")){
            this.iniciarLP();
          }

      if(accion.equals("Guardar")){
        conectorAction("LPGenerarFicheroDeEnviarConsultoras");
        conectorActionParametro("action","");
        }
      }catch (Exception ex) {
     traza("Error en ejecucion");

		    this.lanzarPaginaError(ex);
	   }
      
  }
  //**************************************************************************************
  private void iniciarLP()throws Exception{
        MareBusinessID idBusiness = new MareBusinessID("INTObtenerValoresPorDefecto");
		DTOInterfaz dto = new DTOInterfaz();
		dto.setCodInterfaz(ConstantesOCR.OCR_INTERFAZ_CONSULTORAS);
        Vector params = new Vector();
        params.add(dto);
        params.add(idBusiness);
        DruidaConector con = conectar("ConectorObtenerValoresPorDefecto", params);
        DTOSalida out =(DTOSalida)con.objeto("dtoSalida");
        RecordSet rs = out.getResultado();
         if (!rs.esVacio()) {
        Long lote = (Long) rs.getValueAt(0,"Numero_Lote");
          asignarAtributo("VAR","labelLote","valor",lote.toString());
        String desc = (String) rs.getValueAt(0,"Descripcion");
        traza("*************************" + desc);
          asignarAtributo("VAR","labelDescripcion","valor",desc);
      }

        asignarAtributo("VAR","casoDeUso","valor","EnviarConsultoras");
  }

  

  
}