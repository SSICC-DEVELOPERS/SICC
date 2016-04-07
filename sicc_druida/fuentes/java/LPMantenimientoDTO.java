/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentos;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*Imports para el uso del subsistema GestorCargaPantalla */
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              DTO - Descuentos
 * Componente:          LPMantenimientoDTO
 * Fecha:               06/07/2004
 * Dcoumentacion:       
 *                      documentos: SICC-DMCO-DTO-201-324
 * Observaciones:
 * @version             3.0
 * @author              Cintia Verónica Argain
 */
public class LPMantenimientoDTO extends LPSICCBase {
    private String   sCasoDeUso = null;
    private Long     lPais = null;
    private String   lDescPais = null;
    private Long     lIdioma = null;
    private Long     lOidDescuento = null;
    private String   sAccion  = "";

    public LPMantenimientoDTO() {
    }

    public void inicio() throws Exception {
        pagina("contenido_descuentos_buscar");
        this.getFormatosValidaciones();
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
         try{
                traza("<<<<<<<<< Inicializando LPMantenimientoDTO >>>>>>>>>>>>");		
                String sAccion = conectorParametro("accion")==null?"":
                                                    conectorParametro("accion");
                traza("Accion: "+sAccion);
                //this.rastreo();
                lIdioma = UtilidadesSession.getIdioma(this);
                lPais = UtilidadesSession.getPais(this);
                lDescPais = UtilidadesSession.getDescripcionPais(this);
                sCasoDeUso = conectorParametro("casoDeUso")==null?"":
                                                  conectorParametro("casoDeUso");
                traza("Cargando menu.....01-04-2005");
                traza("CU..................." + sCasoDeUso);
        
                traza("Descripcion  Pais " + lDescPais );
                asignarAtributo("VAR","casoDeUso","valor",sCasoDeUso);
                asignarAtributo("VAR","accion","valor",sAccion);
                asignarAtributo("VAR","descPais","valor",lDescPais.toString());
                asignarAtributo("VAR","oidPais","valor",lPais.toString());        
                asignarAtributo("VAR","oidIdioma","valor",lIdioma.toString());
                traza("Desc Pais " + lDescPais );
            if (sCasoDeUso.equals("consultar")){
               getConfiguracionMenu("LPMantenimientoDTO","consultar");			 
            }

            if (sAccion.equals("consultar")) {
                traza("<<<<>>>> CASO DE USO  " + sCasoDeUso);
                if ((sCasoDeUso.equals("consultar"))||
                      (sCasoDeUso.equals( "modificar"))) {
                    getConfiguracionMenu("LPMantenimientoDTO","consultar");
                    traza("paso menu");
                    asignarAtributo("VAR","maxSel","valor","1");
                }             
                if( sCasoDeUso.equals("eliminar")){                    
                    getConfiguracionMenu("LPMantenimientoDTO","eliminar");
                    asignarAtributoPagina("cod","0343");                    
                    traza("paso menu");                    
                    //Permitir seleccionar varios registros en pantalla
                    String oids = conectorParametro( "codSeleccionados" );
                    traza("(ELIMINAR)codSeleccionados "  + oids);
                    asignarAtributo("VAR","maxSel","valor","");
                }

                DTOBelcorp dtoB = new DTOBelcorp();
                dtoB.setOidIdioma(lIdioma);
                dtoB.setOidPais(lPais); 
                
                cargarMarcaCanal(dtoB);
            } else if (sAccion.equals("seleccionar")) {
                DTOEBuscarDescuentos dtoE = new DTOEBuscarDescuentos();
                if(!conectorParametroLimpia("txtNumDescuento","",true).equals(""))
                    dtoE.setOidDescuento(new Long(
                          conectorParametroLimpia("txtNumDescuento","",true)));
                if(!conectorParametroLimpia("txtDescripcion","",true).equals(""))
                    dtoE.setDescripcion(
                            conectorParametroLimpia("txtDescripcion","",true));
                if(!conectorParametroLimpia("cbActivo","",true).equals(""))
                    dtoE.setActivo(new Boolean(
                              conectorParametroLimpia("cbActivo","",true)));
                if(!conectorParametroLimpia("cbMarca","",true).equals(""))
                    dtoE.setOidMarca(new Long(
                              conectorParametroLimpia("cbMarca","",true)));
                if(!conectorParametroLimpia("cbCanal","",true).equals(""))
                    dtoE.setOidCanal(new Long(
                          conectorParametroLimpia("cbCanal","",true)));
                if(!conectorParametroLimpia("cbPeriodoDesde","",true).equals(""))
                    dtoE.setOidPeriodoDesde(new Long(
                          conectorParametroLimpia("cbPeriodoDesde","",true)));
                if(!conectorParametroLimpia("cbPeriodoHasta","",true).equals(""))
                    dtoE.setOidPeriodoHasta(new Long(
                          conectorParametroLimpia("cbPeriodoHasta","",true)));
 
                traza("guardo en sesion: "+dtoE);    
                conectorParametroSesion("DTOEBuscarDescuentos",dtoE);
                    
                DTOOID dtoOid = new DTOOID();
                String sOids = conectorParametro("codSeleccionados");
                traza(">>>>>>>>> ID Seleccionados...: " +sOids);
                dtoOid.setOid(new Long(sOids));
                dtoOid.setOidIdioma(lIdioma);
                dtoOid.setOidPais(lPais);


                conectorParametroSesion("DTODescuentoSeleccionado", dtoOid);
                sCasoDeUso =  (String)conectorParametro("casoDeUso");
                traza("<<<<>>>> CASO DE USO de la sesion " + sCasoDeUso);

                conectorParametroSesion("DTOUltimaLP","LPMantenimientoDTO");

                conectorAction("LPMantenimientoDTODG");
                //DMCO-DTO-BELC300014763
                /*........... La invoca con accion "" ...............*/
                conectorActionParametro("accion","");
                /*........... Pasar parametro "casoDeUso" recibida ...........*/
                conectorActionParametro("casoDeUso",sCasoDeUso);
            } else if (sAccion.equals("modificar")) {
                    getConfiguracionMenu("LPMantenimientoDTO","modificar"); 
                    asignarAtributoPagina("cod","0354");
                    traza("paso menu");
                    DTOBelcorp dtoB = new DTOBelcorp();
                    dtoB.setOidIdioma(lIdioma);
                    dtoB.setOidPais(lPais); 
                    cargarMarcaCanal(dtoB);
                    getConfiguracionMenu();                 
				}

			 if (sAccion.equals("volver")){
                traza("**** accion -> volver****");
                pagina("contenido_descuentos_buscar");
                String sCasoDeUso = conectorParametroLimpia(
                                                "hidCasoDeUso","",true);
                if( sCasoDeUso.equals("eliminar")){     
                    traza("**** CasodeUso = eliminar ****");
                    getConfiguracionMenu("LPMantenimientoDTO","eliminar");
                    asignarAtributoPagina("cod","0343");                
                }
                if( sCasoDeUso.equals("modificar")){              
                    traza("**** CasodeUso = modificar ****");
                    getConfiguracionMenu("LPMantenimientoDTO","modificar");
                    asignarAtributoPagina("cod","0354");                
                }
                if( sCasoDeUso.equals("consultar")){             
                    traza("**** CasodeUso = consultar ****");
                    getConfiguracionMenu("LPMantenimientoDTO","consultar");
                    asignarAtributoPagina("cod","0233");                
                }
                DTOBelcorp dtoB = new DTOBelcorp();
                dtoB.setOidIdioma(lIdioma);
                dtoB.setOidPais(lPais); 
                cargarMarcaCanal(dtoB);
                DTOPeriodo dtoC  = new DTOPeriodo();
                dtoC.setPais(lPais);
                dtoC.setOidPais(lPais);
                cargarPeriodos(dtoC);
                DTOEBuscarDescuentos dto =(DTOEBuscarDescuentos) 
                            conectorParametroSesion("DTOEBuscarDescuentos");
                if(dto.getOidDescuento()!=null)
                    asignarAtributo("VAR","oidDescuento","valor",
                                        dto.getOidDescuento().toString());
                if(dto.getDescripcion()!=null)                
                    asignarAtributo("VAR","descripcion","valor",
                                            dto.getDescripcion());
                if(dto.getActivo()!=null)                
                    asignarAtributo("VAR","activo","valor",
                                        dto.getActivo().toString());
                if(dto.getOidMarca()!=null)                
                    asignarAtributo("VAR","oidMarca","valor",
                                        dto.getOidMarca().toString());
                if(dto.getOidCanal()!=null)                
                    asignarAtributo("VAR","oidCanal","valor",
                                        dto.getOidCanal().toString());
                if(dto.getOidPeriodoDesde()!=null)                
                    asignarAtributo("VAR","periodoDesde","valor",
                                    dto.getOidPeriodoDesde().toString());                
                if(dto.getOidPeriodoHasta()!=null)                
                    asignarAtributo("VAR","periodoHasta","valor",
                                      dto.getOidPeriodoHasta().toString());                
                asignarAtributo("VAR","casoDeUso","valor",sCasoDeUso);
                traza("caso de uso: "+sCasoDeUso);
                asignarAtributo("VAR","caso","valor","volver");    
			}                
          getConfiguracionMenu(); 
      }catch(Exception ex) {
           traza("error!! " + ex);
           logStackTrace(ex);
           this.lanzarPaginaError(ex);
      }
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


    /*=================Uso del subsistema GestorCargaPantalla==================*/
    private void cargarMarcaCanal(DTOBelcorp dtoBel) throws Exception{
        //Preparamos los parametros del subsistema
        ComposerViewElementList cv = crearParametrosEntradaMarcaCanal(dtoBel);
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(cv,
                                                            this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        //Cargamos los combos con los resultados
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        
        traza(">>>>>>>> Salio de cargarMarcaCanal");
    }

    private void cargarPeriodos(DTOPeriodo dtoBel) throws Exception{
        //Preparamos los parametros del subsistema
        ComposerViewElementList cv = crearParametrosEntradaPeriodo(dtoBel);
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(cv, 
                                                            this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        //Cargamos los combos con los resultados
        asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtenerPeriodos");
        asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtenerPeriodos");
        
        traza(">>>>>> Salio de cargarPeriodos");
    }
    

    private ComposerViewElementList crearParametrosEntradaMarcaCanal(DTOBelcorp dtoBel){
        
          ComposerViewElementList lista = new ComposerViewElementList();
          //Combo Marca
          ComposerViewElement ci1 = new ComposerViewElement();
          ci1.setIDBusiness("SEGConsultaMarcas");
          //Combo Canal
          ComposerViewElement ci2 = new ComposerViewElement();
          ci2.setIDBusiness("SEGConsultaCanales");
          ci2.setDTOE(dtoBel);
      
          lista.addViewElement(ci1);
          lista.addViewElement(ci2);
          return lista;
	  }

    private ComposerViewElementList crearParametrosEntradaPeriodo(DTOPeriodo dtoBel){
        
          ComposerViewElementList lista = new ComposerViewElementList();
              //Combo PeriodoDesde
          ComposerViewElement ci3 = new ComposerViewElement();
          ci3.setIDBusiness("CRAObtenerPeriodos");
          ci3.setDTOE(dtoBel);
      
          lista.addViewElement(ci3);
          lista.addViewElement(ci3);
          return lista;
	}

}

