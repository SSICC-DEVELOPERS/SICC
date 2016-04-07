import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.BelcorpError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.String;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;


public class LPModificarPosiciones extends LPSICCBase {
		String accion = null;
		public LPModificarPosiciones(){ 
            super();
      }
      
    public void inicio() throws Exception {
    }
      
    public void ejecucion() throws Exception { 
         setTrazaFichero();
         try{
            traza("entro en ejecucion");
            pagina("contenido_solicitud_modificar");
            this.getFormatosValidaciones();
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            String oidCabeceraSolicitud = conectorParametro("oidCabeceraSolicitud")==null?"":conectorParametro("oidCabeceraSolicitud");
            traza("Accion: " + accion);
            traza("oidCabeceraSolicitud: " + oidCabeceraSolicitud);
            //oidCabeceraSolicitud = "1"; //harcodeo
            
            if (accion.equals("")){
                obtenerPosiciones(oidCabeceraSolicitud);
            }
            if (accion.equals("guardar")){
                String oid = conectorParametroLimpia("hidOid","",true);
                modificarPosiciones(new Long(oid));            
            }            
         	getConfiguracionMenu(); 
        }catch(Exception e){
           lanzarPaginaError(e);
           logStackTrace(e);
		    }
         
    }

    private void obtenerPosiciones(String oid) throws Exception {
        traza("entro a obtenerPosiciones");
        Vector param = new Vector();
        DTOConsultarPosicionesSolicitud dto = new DTOConsultarPosicionesSolicitud();
        dto.setOidCabeceraSolicitud(new Long(oid));
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));        
        
        param.add(dto);
        param.add(new MareBusinessID("PEDConsultarPosicionesSolicitud"));
        traza("dto entrada: "+dto);
        
        DruidaConector dc = new DruidaConector();        
        traza("antes de conectar");
        dc = conectar("ConectorConsultarPosiciones", param);        
        traza("despues de conectar");        
        
			  DTOSalida dtoSalida =(DTOSalida) dc.objeto("dtoSalida");			
			  RecordSet rs = dtoSalida.getResultado();
        
        pagina("contenido_solicitud_modificar");
        traza("recordset: "+rs);
        asignarAtributo("VAR","hidOid","valor",oid);
        if (!(rs.esVacio()))  {
            String listado ="listado1";
           asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rs,rs.getColumnIdentifiers()),"dtoSalida");        
        }
    }   
    
    private void modificarPosiciones(Long oid) throws Exception {
    
    try{
        DTOCabeceraSolicitud dto = (DTOCabeceraSolicitud)conectorParametroSesion("DTOCabeceraSolicitud");
        traza("este es el dto obtenido de sesion: "+dto);
        //DTOCabeceraSolicitud dto = new DTOCabeceraSolicitud();
        dto.setOidPais(UtilidadesSession.getPais(this));
        if(oid!=null)
          dto.setOidCabeceraSolicitud(oid);
        dto.setIndicadorDigitacion(new Boolean("true"));
        traza("cabecera dto: "+dto);
		
        String posicionesEliminadas = conectorParametro("posicionesEliminadas")==null?"":conectorParametro("posicionesEliminadas");
        traza("posiciones eliminadas: "+posicionesEliminadas);
        StringTokenizer st = new StringTokenizer(posicionesEliminadas,",");
         while (st.hasMoreTokens()){
              dto = generarPosicion(dto,null,null,new Long(st.nextToken()),null);
         }
         traza("dto despues de posiciones eliminadas: "+dto);
        String valores = conectorParametro("valores")==null?"":conectorParametro("valores");
        traza("777777777777777777777");
		traza("valores: "+valores); 
		traza("777777777777777777777");
        StringTokenizer stv = new StringTokenizer(valores,",");
        traza("stv: "+ stv);        
        while (stv.hasMoreTokens()){
              String oids = stv.nextToken();
              traza("oid: "+oids);
              traza(new Character(oids.charAt(0)));
              if(new Character(oids.charAt(0)).toString().equals("a")){
                traza("este es un nuevo registro");
                String cod = stv.nextToken();
                String uni = stv.nextToken();
                String pos = stv.nextToken();
                
                traza ("cod" + cod );
                traza ("uni" + uni );
                traza ("pos" + pos );
                
                
                  dto = generarPosicion(dto,cod,new Long(uni),null,new Long(pos));
              }else{
                traza("este registro ya existia");
                String a = stv.nextToken();
                String b = stv.nextToken();
                String c = stv.nextToken();
                traza("codVenta: "+a+" unidadesDemandadas: "+b + "posicion:"+c);
                   if(!a.equals("undef")&&!b.equals("undef"))                  
                          dto = generarPosicion(dto,a,new Long(b),new Long(oids),new Long(c));
                   else if(!a.equals("undef")|| !b.equals("undef")){
                           if(!a.equals("undef"))
                                    dto = generarPosicion(dto,a,null,new Long(oids),new Long(c));                
                           else dto = generarPosicion(dto,null,new Long(b),new Long(oids),new Long(c));
                         }
              }
         }
         
			   //dto = obtenerValores(valores,dto);
         // Segun el diseño dice que los demas valores van en null
         
         
         traza("dto final: "+dto);
         Vector param = new Vector();
         param.add(dto);
         param.add(new MareBusinessID("PEDModificarPosicionesSolicitud"));
         DruidaConector dc = new DruidaConector();        
         traza("antes de conectar");
         dc = conectar("ConectorModificarPosicionesSolicitud", param);
         traza("despues de conectar");        
         
         DTOCabeceraSolicitud dtoSalida =(DTOCabeceraSolicitud) dc.objeto("dtoSalida");	
         traza("dtoSalida: "+dtoSalida);
         if(dtoSalida.getOK()!=null && !dtoSalida.getOK().booleanValue()){
              reportarErrores(dtoSalida);
			}else{
                traza("cierro pagina......");
                pagina("contenido_solicitud_modificar");
                asignarAtributo("VAR","fin","valor","S");
         }
    
    }catch(Exception e){
         lanzarPaginaError(e);
         logStackTrace(e);
		}
  }

	 private DTOCabeceraSolicitud obtenerValores(String valores, DTOCabeceraSolicitud dtoe) throws Exception {
   
      try{
              traza("en obtener valores");
              traza ("valores" + valores);
              StringTokenizer stv = new StringTokenizer(valores,"|");
              while (stv.hasMoreTokens()){
                  traza("dentro del while");
                  String posiciones = (String) stv.nextToken();
                  StringTokenizer stpos = new StringTokenizer(posiciones,",");
                  while (stpos.hasMoreTokens()){
                      traza("dentro del 2° while");
                      DTOPosicionSolicitud dto = new DTOPosicionSolicitud();
                      dto.setOidPais(UtilidadesSession.getPais(this));
                           String oids = stpos.nextToken();
                      traza("oids: "+oids);
                      if(new Character(oids.charAt(0)).toString().equals("a"))
                          traza("registro nuevo");
                      else
                          dto.setOidPosicionSolicitud(new Long(oids));
                     String tipoPos = stpos.nextToken();
                     traza("tipoPos: "+tipoPos);
                     String subTipoPos = stpos.nextToken();
                     traza("subTipoPos: "+subTipoPos);
                     String posi = stpos.nextToken();
                     traza("posi: "+posi);
                     if(!tipoPos.equals("undef"))
                       dto.setTipoPosicion(new Long(tipoPos));
                     traza("1");
                     if(!subTipoPos.equals("undef"))
                       dto.setSubtipoPosicion(new Long(subTipoPos));
                     traza("2");
                     if(!posi.equals("undef"))
                       dto.setNumeroPosicion(new Long(posi));
                     traza("antes de asignar codigo venta");
                     dto.setCodigoVenta(stpos.nextToken());
                     traza("OK");
                     String desCorta = stpos.nextToken();
                     traza("desCorta: "+desCorta);
                     String codProd = stpos.nextToken();
                     traza("codProd: "+codProd);
                     if(!codProd.equals("undef"))
                       dto.setProducto(new Long(codProd));
                     String desLarga = stpos.nextToken();
                     String unidad = stpos.nextToken();
                     String uniDem = stpos.nextToken();
                     if(!uniDem.equals("undef"))
                       dto.setUnidadesDemandadas(new Long(uniDem));
                      dto.setOK(new Boolean("true"));
        
                      ArrayList arr = new ArrayList();        
                      if(dtoe.getPosiciones()!=null)
                        arr = dtoe.getPosiciones();
                      arr.add(dto);
                      dtoe.setPosiciones(arr);
                  }
              }
               
     }catch(Exception e){
         lanzarPaginaError(e);
         logStackTrace(e);
		}
    return dtoe;	
   }
    
    
    private DTOCabeceraSolicitud generarPosicion (DTOCabeceraSolicitud dtoe, String codigoVenta, Long unidadesDemandadas,Long oid ,Long posicion) throws Exception {
        
        try {        
                    traza("en generarPosiciones (posicion)"+ posicion);
                    traza("en generarPosiciones (oid) "+ oid);
                    traza("en generarPosiciones (codigoVenta) "+ codigoVenta);
                    traza("en generarPosiciones (unidadesDemandadas) "+ unidadesDemandadas);
                    
                  //if((!codigoVenta.equals("") && codigoVenta!=null)||(!unidadesDemandadas.equals("") && unidadesDemandadas!=null)){
                    DTOPosicionSolicitud dto = new DTOPosicionSolicitud();
                    dto.setOidPais(UtilidadesSession.getPais(this));
                    dto.setOidPosicionSolicitud(oid);
			
					
                    if(codigoVenta!=null)
                      dto.setCodigoVenta(codigoVenta);
                      
                    if(posicion!=null)
                      dto.setNumeroPosicion(posicion);  
                    if(unidadesDemandadas!=null)  
                      dto.setUnidadesDemandadas(unidadesDemandadas);
                    dto.setOK(new Boolean("true"));
                    
                    
                    /*
                     if((codigoVenta!=null) || (unidadesDemandadas!=null)){
                      dto.setUnidadesDemandadas(unidadesDemandadas);
                      dto.setCodigoVenta(codigoVenta);
                      dto.setOK(new Boolean("true"));
                    }
                    */
                    ArrayList arr = new ArrayList();        
                    if(dtoe.getPosiciones()!=null)
                        arr = dtoe.getPosiciones();
                    arr.add(dto);
                    dtoe.setPosiciones(arr);

					if(accion.equals("guardar")){
							dtoe.setModificarPosiciones(Boolean.TRUE);
							traza(" modificarPosiciones: " + dtoe.getModificarPosiciones());
					}
				  //}
                  traza("salio: "+dto);
        }catch(Exception e){
            lanzarPaginaError(e);
            logStackTrace(e);
        } 
        
        return dtoe;
    }

    private void reportarErrores (DTOCabeceraSolicitud dtoe) throws Exception {
        traza("en reportarErrores");
        if(dtoe!=null){
            RecordSet rsSalida = new RecordSet();
            rsSalida.addColumn("Oid");            
            rsSalida.addColumn("tipoPosicion");            
            rsSalida.addColumn("subtipoPosicion");
            rsSalida.addColumn("posicion");
            rsSalida.addColumn("codigoVenta");
            rsSalida.addColumn("descripcionCorta");
            rsSalida.addColumn("codigoProducto");
            rsSalida.addColumn("descripcionLarga");
            rsSalida.addColumn("unidad");            
            rsSalida.addColumn("unidadesDemandadas");
            rsSalida.addColumn("validacion");
            if(dtoe.getPosiciones()!=null){
	            traza("getPosiciones: "+dtoe.getPosiciones());
					 Iterator it = dtoe.getPosiciones().iterator();
                while(it.hasNext()){
                  DTOPosicionSolicitud dto = (DTOPosicionSolicitud) it.next();
                  if(dto.getOK().booleanValue() == false){
                      Vector vec = new Vector();
                      vec.add(dto.getOidPosicionSolicitud());
                      vec.add(dto.getTipoPosicion());
                      vec.add(dto.getSubtipoPosicion());
                      vec.add(dto.getPosicionRecuperacion());
                      vec.add(dto.getCodigoVenta());
                      vec.add("");
                      //vec.add(dto.getDescripcionCorta());
                      vec.add(dto.getOidProducto());
                      vec.add("");                  
                      //vec.add(dto.getDescripcionLarga());
                      vec.add(dto.getUnidadesAtendidas());
                      vec.add(dto.getUnidadesDemandadas());
                      String err = obtenerDescripcionError(dto.getMensajeError());
                      if(dto.getUnidadesMaximas()!=null){
                          vec.add(err +" "+ dto.getUnidadesMaximas());
                      }else vec.add(err);          
                      rsSalida.addRow(vec);
                  } else {
                      Vector vec = new Vector();
                      vec.add(dto.getOidPosicionSolicitud());
                      vec.add(dto.getTipoPosicion());
                      vec.add(dto.getSubtipoPosicion());
                      vec.add(dto.getPosicionRecuperacion());
                      vec.add(dto.getCodigoVenta());
                      vec.add("");                  
                      //vec.add(dto.getDescripcionCorta());
                      vec.add(dto.getOidProducto());
                      vec.add("");                  
                      //vec.add(dto.getDescripcionLarga());
                      vec.add(dto.getUnidadesAtendidas());
                      vec.add(dto.getUnidadesDemandadas());
                      vec.add("");
                      rsSalida.addRow(vec);              
                  }
                }
            }
            traza("recordset: "+rsSalida);
            if (!(rsSalida.esVacio()))  {
                String listado ="listado1";
               asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", rsSalida,rsSalida.getColumnIdentifiers()),"dtoSalida");        
            }
            
        }
    
    }
    
    private String obtenerDescripcionError(String codigoError) throws Exception {
        MareException me = new MareException(null,null,UtilidadesError.armarCodigoError(codigoError));
        DTOError dtoError = (new BelcorpError()).obtenerError( me, UtilidadesSession.getIdioma_ISO(this), 
                      UtilidadesSession._ISO(this));
        return dtoError.getDescripcionError();
   }

    
	  private void logStackTrace(Throwable e) throws Exception {
       traza("Se produjo la excepcion: " + e.getMessage());
       ByteArrayOutputStream pila = new ByteArrayOutputStream();
       PrintStream out = new PrintStream(pila);
       if (e instanceof MareException) {
         MareException e2=(MareException)e;
         traza("Es una mare Exception con codigo de error: "+e2.getCode());
       }
       e.printStackTrace(out);
       traza("stack Trace : " +  pila.toString());
    }      
}      
