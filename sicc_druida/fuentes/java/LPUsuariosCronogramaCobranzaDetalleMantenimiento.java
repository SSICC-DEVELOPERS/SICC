import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOUsuarEtapaCobraDetal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPUsuariosCronogramaCobranzaDetalleMantenimiento extends LPSICCBase {           
  public LPUsuariosCronogramaCobranzaDetalleMantenimiento() {	 
     super();
  }
  
  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     String casoDeUso = conectorParametroLimpia("casoDeUso","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        traza("la accion es " + accion);
        traza("el indicador cu es  " + casoDeUso);
        
        if (accion.equals("insertar")){
           cargarPantalla(accion);
        }
        
        if(accion.equals("guardar")){
          guardar();
        }
        
        if(accion.equals("detalleUsuario")){
           detalleUsuario(accion);
        }
        
        if((accion.equals("consultar")) || (accion.equals("eliminar")) ||(accion.equals("modificar"))){
            consultar();
            
        }
        
        if(accion.equals("modificarUsuario")){
           modificarUsuario(accion);
        }
        
        if(accion.equals("guardarModificacion")){
           guardarModificacion();
        }
        
		asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
		asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
		asignarAtributo("VAR", "casoDeUso", "valor", accion);
        cargarMenuSecundario(accion, casoDeUso);
        
       // getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleAsignar");
     
     } catch (Exception ex) {
                  
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
     }

    
  }
  
  private void cargarMenuSecundario(String accion, String casoDeUso) throws Exception{
     
     if(accion.equals("insertar")){
        asignarAtributoPagina("cod", "0658");
        getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "insertar");
     }
     
     if(accion.equals("consultar")){
        asignarAtributoPagina("cod", "0661");
        getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "consultar");
     }  
       
     if(accion.equals("eliminar")){
       asignarAtributoPagina("cod", "0660");
       getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "eliminar");
     }
     
     if(accion.equals("modificar")){
       asignarAtributoPagina("cod", "0659"); 
       getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "modificar");
     }
          
     if((accion.equals("detalleUsuario")) && (casoDeUso.equals("consultar"))){
       asignarAtributoPagina("cod", "0661");
       getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "consultarDetalle");
     }        
     
     if((accion.equals("detalleUsuario")) && (casoDeUso.equals("eliminar"))){
       asignarAtributoPagina("cod", "0660");
       getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "eliminarDetalle");
     }
     
     if(accion.equals("modificarUsuario")){
       asignarAtributoPagina("cod", "0659");
       getConfiguracionMenu("LPUsuariosCronogramaCobranzaDetalleMantenimiento", "modificarDetalle");
     }
    
  }
  
  private void cargarPantalla(String accion) throws Exception{
     pagina("contenido_usuarios_cronograma_cobranzas_detalle_asignar");   
       
     ComposerViewElementList cv = crearParametrosEntrada(accion);
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     asignar("COMBO","cbUsuario",resultados,"COBRecuperarUsuariosCabecera");
     asignar("COMBO","cbMetodoLiquidacionDefecto",resultados,"COBRecuperarLiquidacion");
     asignar("COMBO","cbGuiaArgumentalDefecto",resultados,"COBRecuperarGuiaArgumental");
	 //MOdificacion mdolce 14/10/2005
	 if(!accion.equals("insertar")){
	    asignar("COMBO","cbTipoCargo",resultados,"COBRecuperarTiposCargo");
	 }
     
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
   }
          
   private void guardar() throws Exception{
      traza("entro a guardar");
      pagina("salidaGenerica");

      String usuario    = conectorParametroLimpia("usuario", "", true);
      String etapaDeuda = conectorParametroLimpia("etapaDeuda", "", true);
      String tipoCargo = conectorParametroLimpia("tipoCargo", "", true);
      String sgv        = conectorParametroLimpia("sgv", "", true);
      String region     = conectorParametroLimpia("region", "", true);
      String zona       = conectorParametroLimpia("zona", "", true);
      String seccion    = conectorParametroLimpia("seccion", "", true);
      String territorio = conectorParametroLimpia("territorio", "", true);
      String metodoLiqui = conectorParametroLimpia("metodoLiqui", "", true);
      String guionArgCabec = conectorParametroLimpia("guionArgCabec", "", true);
      String observaciones = conectorParametroLimpia("observaciones", "", true);
            
      DTOUsuarEtapaCobraDetal dto = new DTOUsuarEtapaCobraDetal();
      
      
      dto.setOidUsuarioEtapCobra(new Long(usuario));
      traza("paso 13");
      dto.setOidEtapaDeudaTCarg(new Long(etapaDeuda));
      traza("paso 14");
      dto.setOidTipoCargo(new Long(tipoCargo));
      traza("paso 15");
      dto.setOidSubgeVentas(new Long(sgv));
      traza("paso 16");
      
      if((region != null) && !(region.equals(""))){
         dto.setOidRegion(new Long(region));    
      }else{
         dto.setOidRegion(null);
      }
      
      if((zona != null) && !(zona.equals(""))){
         dto.setOidZona(new Long(zona));    
      }else{
         dto.setOidZona(null);
      }
      
      if((seccion != null) && !(seccion.equals(""))){
         dto.setOidSeccion(new Long(seccion));    
      }else{
         dto.setOidSeccion(null);
      }
     
      if((territorio != null) && !(territorio.equals(""))){
         dto.setOidTerritorio(new Long(territorio));    
      }else{
         dto.setOidTerritorio(null);
      }
      
      if((metodoLiqui != null) && !(metodoLiqui.equals(""))){
         dto.setOidMetodoLiqui(new Long(metodoLiqui));    
      }else{
         dto.setOidMetodoLiqui(null);
      }
      
      if((guionArgCabec != null) && !(guionArgCabec.equals(""))){
         dto.setOidGuionArgCabec(new Long(guionArgCabec));    
      }else{
         dto.setOidGuionArgCabec(null);
      }
      
      if((observaciones != null) && !(observaciones.equals(""))){
         dto.setObservaciones(observaciones);    
      }else{
         dto.setObservaciones(null);
      }
           
      
      MareBusinessID id = new MareBusinessID("COBGuardarAsignacionUsuarioCronogramDetalle");
      Vector vec = new Vector();
      traza("el dto a guardar es " + dto);
      vec.add(dto);
      vec.add(id);
      
      DruidaConector conectorInsertar = new DruidaConector();
      conectorInsertar = conectar("ConectorGuardarAsignacionUsuarioCronogramDetalle",vec);
      asignarAtributo( "VAR", "ejecutar", "valor", "insertoConExito()");

        
  }
  
  private void detalleUsuario(String accion) throws Exception{
     cargarPantalla(accion);
     
     String oid = conectorParametroLimpia("oid", "", true) ;
     traza("el oid es " + oid);
     
     DTOOID dtoOid = new DTOOID();
     dtoOid.setOid(new Long(oid));
     MareBusinessID id = new MareBusinessID("COBDetalleUsuCobCronDet");
       
     Vector vec = new Vector();
     vec.add(dtoOid);
     vec.add(id);
         
     DruidaConector conector = new DruidaConector();
     conector = conectar("ConectorDetalleUsuCobCronDet",vec);
     
     DTOUsuarEtapaCobraDetal dto = null;
     
     if( conector != null ){
          dto = (DTOUsuarEtapaCobraDetal)conector.objeto( "dtoSalida" );
     }
     
     asignarAtributo("VAR","usuario", "valor", dto.getOidUsuarioEtapCobra().toString());
     asignarAtributo("VAR", "etapaDeuda", "valor", dto.getOidEtapaDeudaTCarg().toString());
     asignarAtributo("VAR", "tipoCargo", "valor", dto.getOidTipoCargo().toString())     ;
     asignarAtributo("VAR", "marca", "valor", dto.getOidMarca().toString());
     asignarAtributo("VAR", "canal", "valor", dto.getOidCanal().toString());
     asignarAtributo("VAR", "sgv", "valor", dto.getOidSubgeVentas().toString());
     asignarAtributo("VAR", "region", "valor", (dto.getOidRegion() == null ? "" : dto.getOidRegion().toString() ));
     asignarAtributo("VAR", "zona", "valor", (dto.getOidZona() == null ? "" : dto.getOidZona().toString() ));
     asignarAtributo("VAR", "seccion", "valor", (dto.getOidSeccion() == null ? "" : dto.getOidSeccion().toString() ));
     asignarAtributo("VAR", "territorio", "valor", (dto.getOidTerritorio() == null ? "" : dto.getOidTerritorio().toString() ));
     asignarAtributo("VAR", "metodoLiqui", "valor", (dto.getOidMetodoLiqui() == null ? "" : dto.getOidMetodoLiqui().toString() ));
     asignarAtributo("VAR", "guionArgCabec", "valor", (dto.getOidGuionArgCabec() == null ? "" : dto.getOidGuionArgCabec().toString() ));
     asignarAtributo("VAR", "observaciones", "valor", (dto.getObservaciones() == null ? "" : dto.getObservaciones() ));
     asignarAtributo("VAR", "deshabilitarTodo", "valor", "true");
         
 
  }
  
  private void consultar() throws Exception{  
     pagina("contenido_usuarios_cronograma_cobranzas_detalle_modificar");
     
     ComposerViewElementList cv = crearParametrosEntradaChico();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());

     asignar("COMBO","cbUsuario",resultados,"COBRecuperarUsuariosCabecera");

//Incidencia Peru     asignar("COMBO","cbTipoCargo",resultados,"COBRecuperarTiposCargo");
     
  }
  
  private void modificarUsuario(String accion) throws Exception{
     cargarPantalla(accion);
     
     String oid = conectorParametroLimpia("oid", "", true) ;
     traza("el oid es " + oid);
     
     DTOOID dtoOid = new DTOOID();
     dtoOid.setOid(new Long(oid));
     MareBusinessID id = new MareBusinessID("COBDetalleUsuCobCronDet");
       
     Vector vec = new Vector();
     vec.add(dtoOid);
     vec.add(id);
         
     DruidaConector conector = new DruidaConector();
     conector = conectar("ConectorDetalleUsuCobCronDet",vec);
     
     DTOUsuarEtapaCobraDetal dto = null;
     
     if( conector != null ){
          dto = (DTOUsuarEtapaCobraDetal)conector.objeto( "dtoSalida" );
     }
     
     asignarAtributo("VAR","usuario", "valor", dto.getOidUsuarioEtapCobra().toString());
     asignarAtributo("VAR", "etapaDeuda", "valor", dto.getOidEtapaDeudaTCarg().toString());
     asignarAtributo("VAR", "tipoCargo", "valor", dto.getOidTipoCargo().toString())     ;
     asignarAtributo("VAR", "marca", "valor", dto.getOidMarca().toString());
     asignarAtributo("VAR", "canal", "valor", dto.getOidCanal().toString());
     asignarAtributo("VAR", "sgv", "valor", dto.getOidSubgeVentas().toString());
     asignarAtributo("VAR", "region", "valor", (dto.getOidRegion() == null ? "" : dto.getOidRegion().toString() ));
     asignarAtributo("VAR", "zona", "valor", (dto.getOidZona() == null ? "" : dto.getOidZona().toString() ));
     asignarAtributo("VAR", "seccion", "valor", (dto.getOidSeccion() == null ? "" : dto.getOidSeccion().toString() ));
     asignarAtributo("VAR", "territorio", "valor", (dto.getOidTerritorio() == null ? "" : dto.getOidTerritorio().toString() ));
     asignarAtributo("VAR", "metodoLiqui", "valor", (dto.getOidMetodoLiqui() == null ? "" : dto.getOidMetodoLiqui().toString() ));
     asignarAtributo("VAR", "guionArgCabec", "valor", (dto.getOidGuionArgCabec() == null ? "" : dto.getOidGuionArgCabec().toString() ));
     asignarAtributo("VAR", "observaciones", "valor", (dto.getObservaciones() == null ? "" : dto.getObservaciones() ));
     asignarAtributo("VAR", "deshabilitarTodo", "valor", "false");
     asignarAtributo("VAR", "oid", "valor", oid);
       
  }
  
  private void guardarModificacion() throws Exception{
      DTOUsuarEtapaCobraDetal dto = new DTOUsuarEtapaCobraDetal();
      pagina("salidaGenerica");
      String oid = conectorParametroLimpia("oid", "", true);
      traza("el oid es " + oid);
      dto.setOidUsuarioEtapCobra(new Long(oid));
      
      
      String usuario    = conectorParametroLimpia("usuario", "", true);
      String etapaDeuda = conectorParametroLimpia("etapaDeuda", "", true);
      String tipoCargo = conectorParametroLimpia("tipoCargo", "", true);
      String sgv        = conectorParametroLimpia("sgv", "", true);
      String region     = conectorParametroLimpia("region", "", true);
      String zona       = conectorParametroLimpia("zona", "", true);
      String seccion    = conectorParametroLimpia("seccion", "", true);
      String territorio = conectorParametroLimpia("territorio", "", true);
      String metodoLiqui = conectorParametroLimpia("metodoLiqui", "", true);
      String guionArgCabec = conectorParametroLimpia("guionArgCabec", "", true);
      String observaciones = conectorParametroLimpia("observaciones", "", true);
      
      dto.setOidUsuarioCobDeta(new Long(oid));
      dto.setOidUsuarioEtapCobra(new Long(usuario));
      traza("paso 13");
      dto.setOidEtapaDeudaTCarg(new Long(etapaDeuda));
      traza("paso 14");
      dto.setOidTipoCargo(new Long(tipoCargo));
      traza("paso 15");
      dto.setOidSubgeVentas(new Long(sgv));
      traza("paso 16");
      
      if((region != null) && !(region.equals(""))){
         dto.setOidRegion(new Long(region));    
      }else{
         dto.setOidRegion(null);
      }
      
      if((zona != null) && !(zona.equals(""))){
         dto.setOidZona(new Long(zona));    
      }else{
         dto.setOidZona(null);
      }
      
      if((seccion != null) && !(seccion.equals(""))){
         dto.setOidSeccion(new Long(seccion));    
      }else{
         dto.setOidSeccion(null);
      }
     
      if((territorio != null) && !(territorio.equals(""))){
         dto.setOidTerritorio(new Long(territorio));    
      }else{
         dto.setOidTerritorio(null);
      }
      
      if((metodoLiqui != null) && !(metodoLiqui.equals(""))){
         dto.setOidMetodoLiqui(new Long(metodoLiqui));    
      }else{
         dto.setOidMetodoLiqui(null);
      }
      
      if((guionArgCabec != null) && !(guionArgCabec.equals(""))){
         dto.setOidGuionArgCabec(new Long(guionArgCabec));    
      }else{
         dto.setOidGuionArgCabec(null);
      }
      
      if((observaciones != null) && !(observaciones.equals(""))){
         dto.setObservaciones(observaciones);    
      }else{
         dto.setObservaciones(null);
      }
      
      MareBusinessID id = new MareBusinessID("COBGuardarModificacionAsignacionUsuarioCronogramDetalle");
      Vector vec = new Vector();
      
      vec.add(dto);
      vec.add(id);
      traza("el DTO a guardar modificar es " + dto);
      DruidaConector conectorInsertar = new DruidaConector();
      conectorInsertar = conectar("ConectorGuardarAsignacionUsuarioCronogramDetalle",vec);
      asignarAtributo( "VAR", "ejecutar", "valor", "modificoConExito()");
  
  }
  
  private ComposerViewElementList crearParametrosEntrada(String accion) throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
     
     //Carga de combo UsuariosCabecera
     ComposerViewElement cbUsuariosCabecera = new ComposerViewElement();
     cbUsuariosCabecera.setIDBusiness("COBRecuperarUsuariosCabecera");
     cbUsuariosCabecera.setDTOE(dtoBel);
     
     //Carga de combo Liquidacion
     ComposerViewElement cbLiquidacion = new ComposerViewElement();
     cbLiquidacion.setIDBusiness("COBRecuperarLiquidacion");
     cbLiquidacion.setDTOE(dtoBel);
     
     //Carga de combo Guia Argumental
     ComposerViewElement cbGuiaArgumnetal = new ComposerViewElement();
     cbGuiaArgumnetal.setIDBusiness("COBRecuperarGuiaArgumental");
     cbGuiaArgumnetal.setDTOE(dtoBel);
     
     //Carga el combo de tipos cargo
     ComposerViewElement cbTipoCargo = new ComposerViewElement();
     cbTipoCargo.setIDBusiness("COBRecuperarTiposCargo");
     cbTipoCargo.setDTOE(dtoBel);
     
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
     lista.addViewElement(cbUsuariosCabecera);   
     lista.addViewElement(cbLiquidacion);   
     lista.addViewElement(cbGuiaArgumnetal);   
     lista.addViewElement(cbTipoCargo);
         
     
     return lista;
  }
  
  private ComposerViewElementList crearParametrosEntradaChico() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
     ComposerViewElementList lista = new ComposerViewElementList();
         
     
     //Carga de combo UsuariosCabecera
     ComposerViewElement cbUsuariosCabecera = new ComposerViewElement();
     cbUsuariosCabecera.setIDBusiness("COBRecuperarUsuariosCabecera");
     cbUsuariosCabecera.setDTOE(dtoBel);
     
     
     //Cargo el combo de tipo cargo
  /*   ComposerViewElement cbTipoCargo = new ComposerViewElement();
     cbTipoCargo.setIDBusiness("COBRecuperarTiposCargo");
     cbTipoCargo.setDTOE(dtoBel);
    */     
     lista.addViewElement(cbUsuariosCabecera);   
//     lista.addViewElement(cbTipoCargo);   
         
     
     return lista;
  }
  
  
}



