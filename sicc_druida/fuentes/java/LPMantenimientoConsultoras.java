//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.DTODatosConsultora;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.math.BigDecimal;


public class LPMantenimientoConsultoras extends LPSICCBase {

   private String accion;
   private String opcionMenu;
   private String flagModificar;
   private String oidBuzonMensaje;
   private String codCliente;
   private String nombreApellidos ;
   private String datoVariable2;
   private String datoVariable3;
   private String datoVariable4;
   private String datoVariable5;
   private String datoVariable6;
   private String datoVariable7;
   private String datoVariable8;
   private String datoVariable9;
   private String datoVariable10;

  public LPMantenimientoConsultoras() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
     setTrazaFichero();

     try{
           
       accion             = conectorParametroLimpia("accion", "", true );
       String  oidMensaje = conectorParametroLimpia("oidMensaje", "",true);
       opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
	   flagModificar = conectorParametroLimpia("flagModificar", "", true);
       traza("la opcion menu es " + opcionMenu);

       traza("la accion es " + accion);
   

       if(accion.equals("")){
          inicializar();
       }
    
       if(accion.equals("Guardar")){
          guardarConsultora();
       }

       if(accion.equals("Modificar")){
          traza("entro en modificar");
          modificarConsultora();
       }

       if(accion.equals("GuardarModificacion")){
          guardarModificacionConsultora();
       }

       if(accion.equals("Detalle")){
          consultarConsultora();
       }

       if(accion.equals("Modificar Cliente")){
          modificarCliente();
       }

     }catch(Exception e){
           traza( e.toString() );
           logStackTrace( e );
           traza("*********Entro al catch");
           lanzarPaginaError(e);
     }
  }

   private void inicializar() throws Exception {


      if(opcionMenu.equals("Insertar mensaje")){
         String oidMensaje = conectorParametroLimpia("oidMensaje", "", true);
         pagina("contenido_lista_consultoras_insertar");

		 if(flagModificar.equals("true")){
			 asignarAtributo("VAR", "opcionMenu", "valor", "Modificar mensaje");
		 } else {
			 asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		 }

         asignarAtributo("VAR", "oidMensaje", "valor", oidMensaje);
         asignarAtributoPagina("cod", "0326");
         getConfiguracionMenu("LPMantenimientoConsultoras", "Insertar mensaje");
      }

      if(opcionMenu.equals("Modificar mensaje")){
         pagina("contenido_lista_consultoras_modificar");
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributoPagina("cod", "0325");
         getConfiguracionMenu("LPMantenimientoConsultoras", "Modificar mensaje");
      }

      if(opcionMenu.equals("Eliminar mensaje")){
         pagina("contenido_lista_consultoras_modificar");
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributoPagina("cod", "0328");
         getConfiguracionMenu("LPMantenimientoConsultoras", "Eliminar mensaje");
      }

      if(opcionMenu.equals("Consultar mensaje")){
         pagina("contenido_lista_consultoras_modificar");
         asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         asignarAtributoPagina("cod", "0327");
         getConfiguracionMenu("LPMantenimientoConsultoras", "Consultar mensaje");
      }

      asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

   }

   private void guardarConsultora() throws Exception {

      pagina("salidaGenerica");
      
      MareBusinessID id = new MareBusinessID("MSGInsertarDatosConsultora");

      DTODatosConsultora dto = crearMensajeInsertar();
      Vector param = new Vector();

      param.add(dto);
      param.add(id);

      DruidaConector con = conectar("ConectorInsertarDatosConsultora", param);  
      asignarAtributo( "VAR", "ejecutar", "valor", "insertoConExito('" + opcionMenu + "')");
     
   }

   private void modificarConsultora() throws Exception {
      oidBuzonMensaje = conectorParametroLimpia("oid", "", true);
      traza("el oid es " + oidBuzonMensaje);

		String clientes = conectorParametroLimpia("clientes", "", true);
		traza("clientes obtenidos: "+clientes);
		
      DTODatosConsultora dto = obtenerDatosConsultora();
      pagina("contenido_lista_consultoras_modificar_detalle");
      asignarAtributoPagina("cod", "0325");
      getConfiguracionMenu("LPMantenimientoConsultoras", "Modificar");
		asignarAtributo("VAR","clientes","valor",clientes);

      mostrarDatosConsultora(dto);
   }

   private void consultarConsultora() throws Exception {
      
      oidBuzonMensaje = conectorParametroLimpia("oid", "", true);
      traza("el oid es " + oidBuzonMensaje);
       
      DTODatosConsultora dto = obtenerDatosConsultora();
      pagina("contenido_lista_consultoras_modificar_detalle");

      if(opcionMenu.equals("Consultar mensaje")){
         asignarAtributoPagina("cod", "0327");
         getConfiguracionMenu("LPMantenimientoConsultoras", "Detalle");
      }else{
         asignarAtributoPagina("cod", "0328");
         getConfiguracionMenu("LPMantenimientoConsultoras", "DetalleEliminar");
      }   

      mostrarDatosConsultora(dto);
         
   }

   private void guardarModificacionConsultora() throws Exception {

     pagina("salidaGenerica");

     MareBusinessID id  = new MareBusinessID("MSGModificarDatosConsultora");

     DTODatosConsultora dto = crearMensajeModificar();

     Vector param = new Vector();

     param.add(dto);
     param.add(id);

     DruidaConector con = conectar("ConectorModificarDatosConsultora", param); 

     
   }
 

   private void mostrarDatosConsultora(DTODatosConsultora dto) throws Exception {
      
      asignarAtributo("CTEXTO", "CodCliente", "valor", (dto.getCodCliente() == null ? "" : dto.getCodCliente().toString() ));
      asignarAtributo("CTEXTO", "NombreApellidos", "valor", (dto.getNombreApellidos() == null ? "" : dto.getNombreApellidos().toString() ));
      asignarAtributo("AREATEXTO", "Variable2", "valor", (dto.getDatoVariable2() == null ? "" : dto.getDatoVariable2().toString() ));
      asignarAtributo("AREATEXTO", "Variable3", "valor", (dto.getDatoVariable3() == null ? "" : dto.getDatoVariable3().toString() ));
      asignarAtributo("AREATEXTO", "Variable4", "valor", (dto.getDatoVariable4() == null ? "" : dto.getDatoVariable4().toString() ));
      asignarAtributo("AREATEXTO", "Variable5", "valor", (dto.getDatoVariable5() == null ? "" : dto.getDatoVariable5().toString() ));
      asignarAtributo("AREATEXTO", "Variable6", "valor", (dto.getDatoVariable6() == null ? "" : dto.getDatoVariable6().toString() ));
      asignarAtributo("AREATEXTO", "Variable7", "valor", (dto.getDatoVariable7() == null ? "" : dto.getDatoVariable7().toString() ));
      asignarAtributo("AREATEXTO", "Variable8", "valor", (dto.getDatoVariable8() == null ? "" : dto.getDatoVariable8().toString() ));
      asignarAtributo("AREATEXTO", "Variable9", "valor", (dto.getDatoVariable9() == null ? "" : dto.getDatoVariable9().toString() ));
      asignarAtributo("AREATEXTO", "Variable10", "valor", (dto.getDatoVariable10() == null ? "" : dto.getDatoVariable10().toString() ));

      asignarAtributo("VAR", "accion", "valor", accion);
      asignarAtributo("VAR", "oidBuzonMensaje", "valor", (dto.getOidBuzon() == null ? "" : dto.getOidBuzon().toString() ));
      asignarAtributo("VAR", "oidCliente", "valor", (dto.getOidCliente() == null ? "" : dto.getOidCliente().toString() ));
      asignarAtributo("VAR", "codClienteOld", "valor", (dto.getCodCliente() == null ? "" : dto.getCodCliente().toString() ));
      asignarAtributo("VAR", "oidMensaje", "valor", (dto.getOidMensaje() == null ? "" : dto.getOidMensaje().toString() ));
      asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
      
         
   }
   
   private DTODatosConsultora obtenerDatosConsultora() throws Exception{
      DTODatosConsultora dtoDC = new DTODatosConsultora();
      
      DTOOID dto = new DTOOID();
      dto.setOid(new Long(oidBuzonMensaje));

      MareBusinessID id = new MareBusinessID("MSGObtenerDatosConsultora");
      
      Vector param = new Vector();
      param.add(dto);
      param.add(id);

      DruidaConector con = conectar("ConectorObtenerDatosConsultora", param);
      
      if( con != null ){
         dtoDC = (DTODatosConsultora)con.objeto( "dtoSalida" );
      }
      
      return dtoDC;
      
   }

   private DTODatosConsultora crearMensajeInsertar() throws Exception {
      DTODatosConsultora dto = new DTODatosConsultora();
     
      String oid           = conectorParametroLimpia("oidMensaje", "", true);
      String codCliente    = conectorParametroLimpia("CodCliente", "", true);
      String apenom        = conectorParametroLimpia("NombreApellidos","", true);
      String dv2           = conectorParametroLimpia("Variable2", "", true);
      String dv3           = conectorParametroLimpia("Variable3", "", true);
      String dv4           = conectorParametroLimpia("Variable4", "", true);
      String dv5           = conectorParametroLimpia("Variable5", "", true);
      String dv6           = conectorParametroLimpia("Variable6", "", true);
      String dv7           = conectorParametroLimpia("Variable7", "", true);
      String dv8           = conectorParametroLimpia("Variable8", "", true);
      String dv9           = conectorParametroLimpia("Variable9", "", true);
      String dv10          = conectorParametroLimpia("Variable10", "", true);

      dto.setOidPais(new Long(UtilidadesSession.getPais(this).toString()));
      dto.setOidMensaje(new Long(oid));
      dto.setCodCliente(codCliente);
      dto.setNombreApellidos(apenom);
      dto.setDatoVariable2(dv2);
      dto.setDatoVariable3(dv3);
      dto.setDatoVariable4(dv4);
      dto.setDatoVariable5(dv5);
      dto.setDatoVariable6(dv6);
      dto.setDatoVariable7(dv7);
      dto.setDatoVariable8(dv8);
      dto.setDatoVariable9(dv9);
      dto.setDatoVariable10(dv10);

      traza("el dto es " + dto);

      return dto;
   
   
   }

    private DTODatosConsultora crearMensajeModificar() throws Exception {
      DTODatosConsultora dto = new DTODatosConsultora();

      String oidBuzon      = conectorParametroLimpia("oidBuzonMensaje","",true);
      String oid           = conectorParametroLimpia("oidMensaje", "", true);
   //   String oidCliente    = conectorParametroLimpia("oidCliente", "", true);
      String codCliente    = conectorParametroLimpia("CodCliente", "", true);
      String codClienteOld = conectorParametroLimpia("codClienteOld", "", true);
      String apenom        = conectorParametroLimpia("NombreApellidos","", true);
      String dv2           = conectorParametroLimpia("Variable2", "", true);
      String dv3           = conectorParametroLimpia("Variable3", "", true);
      String dv4           = conectorParametroLimpia("Variable4", "", true);
      String dv5           = conectorParametroLimpia("Variable5", "", true);
      String dv6           = conectorParametroLimpia("Variable6", "", true);
      String dv7           = conectorParametroLimpia("Variable7", "", true);
      String dv8           =  conectorParametroLimpia("Variable8", "", true);
      String dv9           = conectorParametroLimpia("Variable9", "", true);
      String dv10          = conectorParametroLimpia("Variable10", "", true);

      dto.setOidPais(new Long(UtilidadesSession.getPais(this).toString()));
      dto.setOidBuzon(new Long(oidBuzon));  
      dto.setOidMensaje(new Long(oid));
      //dto.setOidCliente(new Long(oidCliente));
      
      dto.setCodCliente(codCliente);
      dto.setCodClienteOld(codClienteOld);
      dto.setNombreApellidos(apenom);
      dto.setDatoVariable2(dv2);
      dto.setDatoVariable3(dv3);
      dto.setDatoVariable4(dv4);
      dto.setDatoVariable5(dv5);
      dto.setDatoVariable6(dv6);
      dto.setDatoVariable7(dv7);
      dto.setDatoVariable8(dv8);
      dto.setDatoVariable9(dv9);
      dto.setDatoVariable10(dv10);

      traza("el dto es " + dto);

      return dto;
   
   }

	private void modificarCliente() throws Exception{

         pagina("salidaGenerica");
			Vector param = new Vector();
			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);
         String codCliente = conectorParametroLimpia("CodCliente", "", true);
         String nomApe = conectorParametroLimpia("clienteAnterior", "", true);
			traza("este es el nombre: "+nomApe);
			DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);
			dto.setCodigoCliente(codCliente);
			dto.setIndicadorSituacion(new Long(0));
			dto.setTamanioPagina(new Integer(10));

			traza("este es el dto entrante: "+dto);

			param.add(dto);
			param.add(new MareBusinessID("MAEBusquedaRapidaCliente"));
			try{
				traza("antes de conectar cliente");
				DruidaConector con = conectar("ConectorBusquedaRapidaCliente", param);
				traza("despues de conectar cliente");

				DTOSalida dtoS = (DTOSalida)con.objeto( "DTOSalida" );
				traza("dtoS: "+dtoS);
				RecordSet rs = dtoS.getResultado();
				String oid = ((BigDecimal) rs.getValueAt(0,"OID")).toString();
				String cod = (String) rs.getValueAt(0,"COD_CLIE");
				String nom = (String) rs.getValueAt(0,"VAL_NOM1");
				String ape = (String) rs.getValueAt(0,"VAL_APE1");
				String cad = oid + "," + nom + "," + ape;
				traza("cad: "+cad);
				traza("antes de asignar");
				asignarAtributo( "VAR", "ejecutar", "valor", "asignarDatosCliente('" + cad + "');");
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");
				traza("asigno y saleeeeee");			
			}catch (Exception e){
				traza("hubo un error, se asigna esto: "+nomApe);
				asignarAtributo("VAR", "ejecutar", "valor", "errorAlBuscar('"+ nomApe +"');");
				asignarAtributo("VAR", "cerrarVentana", "valor", "false");
				//throw e;
			}
	}

   

   private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());

         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);

         if (e instanceof MareException) {
             MareException e2 = (MareException) e;
             traza("Es una mare Exception con codigo de error: " + e2.getCode());
         }

         e.printStackTrace(out);
         traza("stack Trace : " + pila.toString());
    }
  
}


