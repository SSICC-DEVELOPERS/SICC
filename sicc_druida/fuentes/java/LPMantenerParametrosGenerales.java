import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenerParametrosGenerales extends LPIncentivos{ 
  String datosObligatorios; //Vale "S" o "N"

  String oidPlantilla;
  String nombrePlantilla;

  DTOConcurso dtoConcurso;
  String cteDTOCache;
  
  String oidConcurso;

  //VARs de paginas correspondientes a componentes
  String sActivo;
  String sMarca;
  String sCanal;

  String nombreConcurso;

  //String con los oids de los accesos seleccionados en la lista de pantalla
  //Tiene el siguiente formato:
  //xx|xx|xx|xx|xx|xx|xx|xx|xx|xx|xx|..
  String sAccesos;

  String sPeriodoDesde;
  String sPeriodoHasta;
  String sIndDevoluciones;
  String sIndAnulaciones;
  String sIndFaltantesNoAnunciados;
  String sOidDirigidoA; //es el oid del campo "dirigido a" de la pantalla.
                              //en pantalla este campo es un label.
  String sExpresionPuntaje;
  String sConcursoPruebas;
  String sObservaciones;
  String sTipoConcursoIVR;

  String codPeriodoDesde;
  String codPeriodoHasta;

  //jrivas 30-1-2007 Dupla Cyzone
  String sIndDuplaCyzone;

  //cvalenzu 3/7/2007 cambio fac-003
  String sTipoPrograma;

  // vbongiov -- Cambio 20080809 -- 7/04/2009
  String sIndNoGeneraPunt;

  // vbongiov -- Cambio 20090930 -- 16/07/2009
  String sCbClasificacionConcurso;

  // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
  String sCbTipoOfertaConcurso;

  // sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
  String oidVigenciaConcurso;
  
  // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
  String sIndMultiMarca;
  String sPuntosAbonar;

  //FLAGS DE ESTADOS DE PESTANYAS
  //Las siguientes estan siempre habilitadas  
  //ParametrosGenerales 
  //Premios 
  //Requisitos de Premiación 
  //Obtención de Puntos 
  //Despacho de Premios 
  //----------------------

  //Las siguientes pueden cambiar de estado
  //Productos
  //Ambito geografico
  //Calificacion
  //Gerentes
  //Consultoras
  //Programa nuevas
  //Multinivel

  public LPMantenerParametrosGenerales(){ super(); }

  public void inicio(){}
  
  public void ejecucion() throws Exception {  
    setTrazaFichero();  
    traza("LPMantenerParametrosGenerales.ejecucion()");
  
    accion = this.conectorParametroLimpia("accion", "", true);
    opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
    oidPlantilla = this.conectorParametroLimpia("oidPlantilla", "", true);
    
    oidVigenciaConcurso = this.conectorParametroLimpia("oidVigenciaConcurso", "", true);
    
    traza("--FLAGS DE ESTADO DE PESTANYAS------------------------------------");
    
    this.obtenerFlagsPestanyas();
    
    traza("accion: " + accion);
    traza("opcionMenu: " + opcionMenu);
    traza("oidPlantilla: " + oidPlantilla);
    traza("oidVigenciaConcurso: " + oidVigenciaConcurso);
    
    datosObligatorios = this.conectorParametroLimpia("datosObligatorios", "", true);
    oidConcurso = this.conectorParametroLimpia("oidConcurso", "", true);
                    
    nombreConcurso = this.conectorParametroLimpia("txtNombreConcurso", "", true);
    sActivo = this.conectorParametroLimpia("hIndActivarConcurso", "", true);
    sMarca = this.conectorParametroLimpia("hMarca", "", true);
    sCanal = this.conectorParametroLimpia("hCanal", "", true);
    sAccesos = this.conectorParametroLimpia("hAccesos", "", true);
    sPeriodoDesde = this.conectorParametroLimpia("hOidPeriodoDesde", "", true);
    sPeriodoHasta = this.conectorParametroLimpia("hOidPeriodoHasta", "", true);
    sIndDevoluciones = this.conectorParametroLimpia("hIndDevoluciones", "", true);
    sIndAnulaciones = this.conectorParametroLimpia("hIndAnulaciones", "", true);
    sIndFaltantesNoAnunciados = this.conectorParametroLimpia("hIndFaltantesNoAnunciados", "", true);
    sOidDirigidoA = this.conectorParametroLimpia("hOidDirigidoA", "", true);
    sExpresionPuntaje = this.conectorParametroLimpia("txtExpresionPuntaje", "", true);
    sConcursoPruebas = this.conectorParametroLimpia("hIndPruebas", "", true);
    sObservaciones = this.conectorParametroLimpia("atxtObservaciones", "", true);
    sTipoConcursoIVR = this.conectorParametroLimpia("hTipoConcursoIVR", "", true);   
    //Agregado por cvalenzu - 31/05/2006
	codPeriodoDesde = this.conectorParametroLimpia("codPeriodoDesde", "", true);
    codPeriodoHasta = this.conectorParametroLimpia("codPeriodoHasta", "", true);   
    //FIN - Agregado por cvalenzu - 31/05/2006

    //jrivas 30-1-2007 Dupla Cyzone
	sIndDuplaCyzone = this.conectorParametroLimpia("hIndDuplaCyzones", "", true);   

    //cvalenzu 3/7/2007 cambio fac-003
	sTipoPrograma = this.conectorParametroLimpia("hTipoPrograma", "", true);   

	// vbongiov -- Cambio 20080809 -- 7/04/2009
	sIndNoGeneraPunt = this.conectorParametroLimpia("hIndNoGeneraPunt", "", true);   

    // vbongiov -- Cambio 20090930 -- 16/07/2009
	sCbClasificacionConcurso = this.conectorParametroLimpia("hClasificacionConcurso", "", true);   

    // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
	sCbTipoOfertaConcurso = this.conectorParametroLimpia("hTipoOfertaConcurso", "", true);   

    // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
	sIndMultiMarca = this.conectorParametroLimpia("hIndMultiMarca", "", true);   
	sPuntosAbonar = this.conectorParametroLimpia("txtPuntosAbonar", "", true);

	
    try{
      if(accion.equals("")){
          this.inicializar();
          this.cargarPantalla();
      }
            else if(accion.equals("cargar")){
          this.cargarPantalla();
      }
            else if(accion.equals("almacenar")){
          this.almacenar();
          this.redirigir();
      }
            else if(accion.equals("redirigir")){
          this.almacenar();
                    this.redirigir();
      }
            else if(accion.equals("guardar")){
          traza("ESTOY EN EL GUARDAR ");
          traza("antes del almacenar");
          this.almacenar();
          traza("sale del almacenar");
          this.guardar();
          traza("sale del guardar");
      }
    }catch(Exception e){
      traza("Excepcion en LPMantenerParametrosGenerales: " + e.toString());
      traza(e);
      this.lanzarPaginaError(e);
    }    
  }
  
  private void inicializar() throws Exception {  
    traza("LPMantenerParametrosGenerales.inicializar()");
    traza("this.opcionMenu: " + this.opcionMenu);
  
    DTOOID dtoOID = new DTOOID();
    dtoOID.setOidPais(UtilidadesSession.getPais(this));
    dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));

    Vector params = null;
    DruidaConector con = null;

    try{
      dtoOID.setOid(oidPlantilla!=null&&oidPlantilla.length()>0?new Long(oidPlantilla):null);
    }catch(NumberFormatException nfe){}

    traza("OID a enviar: " + dtoOID.getOid());

    DTOPlantilla dtoPlan = null;

    MareBusinessID id = new MareBusinessID("INCObtenerPlantilla");
  
    params = new Vector();
    params.add(dtoOID);
    params.add(id);
  
    //TODO: falta definir en DMCO el conector y la mlnf
    traza("--> va a conectar: INCObtenerPlantilla");
    con = this.conectar("ConectorObtenerPlantilla", params);
    
    //se obtiene dtoPlan
    dtoPlan = (DTOPlantilla)con.objeto("dtoPlantilla");
    traza("dtoPlan: " + dtoPlan);
    traza("opcionMenu: " + this.opcionMenu);
    //--------------------------------------------------------------------------
  

          if(this.opcionMenu != null && this.opcionMenu.equalsIgnoreCase("Crear Concurso")){  
                    traza("entro por this.opcionMenu.equalsIgnoreCase(\"Crear Concurso\")");      

                    //Se guardan los datos necesarios de la plantilla en el dtoConcurso, 
                    //para ello recuperamos el dtoConcurso.
                    DTOConcurso dtoc = this.getConcurso();
            
                    if(dtoc == null){
                              dtoc = new DTOConcurso();
                    }
  
                    //jrivas 8/6/2005
                    //guardo el oidPlantilla dentro del DTOparametroGeneralesConcurso.
                    if (dtoc.getParamGenerales()==null) {
                              DTOParametrosGeneralesConcurso dtopg = new DTOParametrosGeneralesConcurso();
                              dtopg.setOidPlantilla(dtoPlan.getOidPlantilla());
                              dtoc.setParamGenerales(dtopg);
                    } else {
                              DTOParametrosGeneralesConcurso dtopg = dtoc.getParamGenerales();
                              dtopg.setOidPlantilla(dtoPlan.getOidPlantilla());
                              dtoc.setParamGenerales(dtopg);
                    }
          

                    dtoc.setPlantilla(dtoPlan);  
          dtoc.setOidPais(UtilidadesSession.getPais(this));
                    dtoc.setOidIdioma(UtilidadesSession.getIdioma(this));

              traza("DTOConcurso en sesion: " + dtoc);

                    //Se inicializan todas los indicadores de las pestañas a false, 
                    //porque ninguna se ha rellenado 
                    dtoc.setIndParamGenerales(Boolean.FALSE);
                    dtoc.setIndAmbitosGeograficos(Boolean.FALSE);
                    dtoc.setIndProductosValidos(Boolean.FALSE);
                    dtoc.setIndProductosExcluidos(Boolean.FALSE);
                    dtoc.setIndProductosBonificados(Boolean.FALSE);
                    dtoc.setIndProductosExigidos(Boolean.FALSE);
                    dtoc.setIndPremios(Boolean.FALSE);
                    dtoc.setIndRequisitosPremacion(Boolean.FALSE);
                    dtoc.setIndObtencionPuntos(Boolean.FALSE);
                    dtoc.setIndDespachoPremios(Boolean.FALSE);
                    dtoc.setIndCalificacion(Boolean.FALSE);
                    dtoc.setIndGerentes(Boolean.FALSE);
                    dtoc.setIndConsultoras(Boolean.FALSE);
                    dtoc.setIndProgramaNuevas(Boolean.FALSE);
                    dtoc.setIndEstatusVenta(Boolean.FALSE);
                    dtoc.setIndEstatusVentaConsultoras(Boolean.FALSE);
                    dtoc.setIndMontoVentaRecomendadas(Boolean.FALSE);
                    dtoc.setIndClasificacionParticipantes(Boolean.FALSE);
                    dtoc.setIndMultinivel(Boolean.FALSE);
                    dtoc.setIndNivelPremiacion(Boolean.FALSE);
                    dtoc.setIndCursosExigidosPremiacion(Boolean.FALSE);
                    dtoc.setIndProductosExigidosPremiacion(Boolean.FALSE);
                    dtoc.setIndVariablesVenta(Boolean.FALSE);
                    dtoc.setIndVariablesVentaProyectada(Boolean.FALSE);
      
      // Agregados por ssantana, 31/5/2005
      // ---------------------------------
      // Se setea esto por defecto, con motivo del guardar() de LPIncentivos
      dtoc.setIndObligParamGenerales(Boolean.FALSE);
      dtoc.setIndObligProductos(Boolean.FALSE);
      dtoc.setIndObligPremios(Boolean.FALSE);
      dtoc.setIndObligRequisitosPremiacion(Boolean.FALSE);
      
      dtoc.setIndObligObtencionPuntos(Boolean.FALSE);
      
      dtoc.setIndObligDespachoPremios(Boolean.FALSE);
      dtoc.setIndObligGerentes(Boolean.FALSE);
      dtoc.setIndObligConsultoras(Boolean.FALSE);
      dtoc.setIndObligProductosValidos(Boolean.FALSE);
      dtoc.setIndObligMultinivel(Boolean.FALSE);
      dtoc.setIndObligAmbitosGeograficos(Boolean.FALSE);
      
      dtoc.setIndObligProductosExcluidos(Boolean.FALSE);
      dtoc.setIndObligProductosBonificados(Boolean.FALSE);
      dtoc.setIndObligProductosBonificados(Boolean.FALSE);
      dtoc.setIndObligProductosExigidos(Boolean.FALSE);
      dtoc.setIndObligProductosACalificar(Boolean.FALSE);
      dtoc.setIndObligProductosExcluidosCalificacion(Boolean.FALSE);
      dtoc.setIndObligCalificacion(Boolean.FALSE);
      dtoc.setIndClasificacionParticipantesCalificacion(Boolean.FALSE);
      
      dtoc.setIndProductosACalificar(Boolean.FALSE);
      dtoc.setIndProductosExcluidosCalificacion(Boolean.FALSE);
      dtoc.setIndObligProgramaNuevas(Boolean.FALSE);
      dtoc.setIndVariablesVentaRanking(Boolean.FALSE);
      dtoc.setIndObligVariablesVentaRanking(Boolean.FALSE);
      dtoc.setIndParamCalificacion(Boolean.FALSE);
      
      traza("termino de asignar a DTOConcurso");

      //--------------------------------------------------------------------------
      //TODO
      //Por defecto, se deshabilitan todas las pestañas, excepto las siguientes, 
      //que siempre estarán habilitadas: 
      //Habilitar pestaña ParametrosGenerales 
      //Habilitar pestaña Productos 
      //Habilitar pestaña Premios 
      //Habilitar pestaña Requisitos de Premiación 
      //Habilitar pestaña Obtención de Puntos 
      //Habilitar pestaña Despacho de Premios 
      //--------------------------------------------------------------------------

      //Se habilitan las siguientes pestañas dependiendo de los indicadores de la 
      //plantilla: 
           
           //Cleal - 20896 
           this.sIndEstadoProductos = "S";
           if(dtoPlan.getIndProductosValidos()!=null && dtoPlan.getIndProductosValidos().booleanValue()){
                  if(dtoPlan.getIndProductosExigidos()!=null && dtoPlan.getIndProductosExcluidos()!=null && dtoPlan.getIndProductosBonificados()!=null && 
                      !dtoPlan.getIndProductosExigidos().booleanValue() && !dtoPlan.getIndProductosExcluidos().booleanValue() && !dtoPlan.getIndProductosBonificados().booleanValue()){
                           
                           this.sIndEstadoProductos = "N";
                  }
           }
           //

      //Pestanya Calificacion
      if(dtoPlan.getIndFaseCalificacion() != null && dtoPlan.getIndFaseCalificacion().booleanValue()){
          this.sIndEstadoCalificion = "S";
          
          dtoOID = new DTOOID();
          dtoOID.setOid(dtoPlan.getOidDirigidoA());
          dtoOID.setOidPais(UtilidadesSession.getPais(this));
          dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
          
          id = new MareBusinessID("INCObtenerParticipantesConcurso");
          
          params = new Vector();
          params.add(dtoOID);
          params.add(id);
      
          traza("va a conectar INCObtenerParticipantesConcurso");
          con = this.conectar("ConectorObtenerParticipantesConcurso", params);
          traza("conecto");
          
          DTOSalida dtos = (DTOSalida)con.objeto("dtoSalida");
          RecordSet rs = dtos.getResultado();
          DTOParticipante dto = null;
          Object o = null;
          ArrayList al = new ArrayList();
          
          if (rs != null) {
                              for(int i = 0; i < rs.getRowCount(); i++){
                                 dto = new DTOParticipante();
                                 dto.setOid( (o = rs.getValueAt(i, "OID_PART_CONC_CABE"))!=null?new Long(((BigDecimal)o).toString()):null);
                                 dto.setDescripcion((o = rs.getValueAt(i, "INC_PARTI"))!=null? o.toString():"");
                                 al.add(dto);
                              }
                    }
                    if(dtoc.getCalificacionParticipantes() == null){
                      dtoc.setCalificacionParticipantes(new DTOCalificacionParticipantes());
                    }
                    
                    dtoc.getCalificacionParticipantes().setLstParticipantes(al);
                    
      }

            traza("dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS) " + dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS));
            traza("dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE) " + dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE));
            
      //Pestanya Gerentes
      if( dtoPlan.getOidDirigidoA() != null && 
            dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)) {
      
          this.sIndEstadoGerentes = "S";
      
          //Sólo se obtiene la lista de Participantes de la entidad ParticipantesConcurso 
          //(ya que la lista de Clasificacion Participantes todavía no ha sido creada, 
          //pues se crea al crear el concurso).
          dtoOID = new DTOOID();
          dtoOID.setOid(dtoPlan.getOidDirigidoA());
          dtoOID.setOidPais(UtilidadesSession.getPais(this));
          dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
          
          id = new MareBusinessID("INCObtenerParticipantesConcurso");
      
          params = new Vector();
          params.add(dtoOID);
          params.add(id);
          
          traza("va a conectar INCObtenerParticipantesConcurso");
          con = this.conectar("ConectorObtenerParticipantesConcurso", params);
          traza("conecto");
          
          DTOSalida dtos = (DTOSalida)con.objeto("dtoSalida");
          
          RecordSet rs = dtos.getResultado();
          DTOParticipante dto = null;
          Object o = null;
          ArrayList al = new ArrayList();

          if (rs != null) {
                              for(int i = 0; i < rs.getRowCount(); i++){
                                 dto = new DTOParticipante();
                                 dto.setOid( (o = rs.getValueAt(i, "OID_PART_CONC_CABE"))!=null?new Long(((BigDecimal)o).toString()):null);
                                 dto.setDescripcion((o = rs.getValueAt(i, "INC_PARTI"))!=null? o.toString():"");
                                 al.add(dto);
                              }
          }
          if(dtoc.getClasificParticipantes() == null){
            dtoc.setClasificParticipantes(new DTOClasificacionParticipantes());
          }
          
          dtoc.getClasificParticipantes().setLstParticipantes(al);

          // Agregado por ssantana, 26/5/2005 x inc. 18305
          traza("Obteniendo ListaMontoVentaRecomendadas para Gerentes");          
          ArrayList aListTipoMontoVenta = obtenerArrayListaMontoVentas();
          DTOListaMontoVentaRecomendadas dtoLista = new DTOListaMontoVentaRecomendadas();
          dtoLista.setMontosVenta(aListTipoMontoVenta);
          dtoc.setListaMontoVentaRecomendadas(dtoLista);
          // Fin Agregado ssantana. 
          
      }
  
      //Pestanya Consultoras
            if( dtoPlan.getOidDirigidoA() != null && 
            dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)) {
  
          this.sIndEstadoConsultoras = "S";

          //Sólo se obtiene la lista de Participantes de la entidad ParticipantesConcurso 
          //(ya que la lista de Clasificacion Participantes todavía no ha sido creada, 
          //pues se crea al crear el concurso) 
          
          dtoOID = new DTOOID();
          dtoOID.setOid(dtoPlan.getOidDirigidoA());
          dtoOID.setOidPais(UtilidadesSession.getPais(this));
          dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
          
          id = new MareBusinessID("INCObtenerParticipantesConcurso");
          
          params = new Vector();
          params.add(dtoOID);
          params.add(id);
          
          traza("va a conectar INCObtenerParticipantesConcurso");
          con = this.conectar("ConectorObtenerParticipantesConcurso", params);
          traza("conecto");
          
          DTOSalida dtos = (DTOSalida)con.objeto("dtoSalida");
      
          RecordSet rs = dtos.getResultado();
          DTOParticipante dto = null;
          Object o = null;
          ArrayList al = new ArrayList();

          if (rs != null) {
                              for(int i = 0; i < rs.getRowCount(); i++){
                                 dto = new DTOParticipante();
                                 dto.setOid( (o = rs.getValueAt(i, "OID_PART_CONC_CABE"))!=null?new Long(((BigDecimal)o).toString()):null);
                                 dto.setDescripcion((o = rs.getValueAt(i, "INC_PARTI"))!=null? o.toString():"");
                                 al.add(dto);
                              }
                    }
                    
          if(dtoc.getClasificParticipantes() == null){
            dtoc.setClasificParticipantes(new DTOClasificacionParticipantes());
          }
          
          dtoc.getClasificParticipantes().setLstParticipantes(al);
          
          // Agregado por ssantana, 26/5/2005 x inc. 18305
          traza("Obteniendo ListaMontoVentaRecomendadas para Consultoras");
          ArrayList aListTipoMontoVenta = obtenerArrayListaMontoVentas();
          DTOListaMontoVentaRecomendadas dtoLista = new DTOListaMontoVentaRecomendadas();
          dtoLista.setMontosVenta(aListTipoMontoVenta);
          dtoc.setListaMontoVentaRecomendadas(dtoLista);
          // Fin Agregado ssantana.           
      }
      
      //Pestanya Programa Nuevas
      if(dtoPlan.getIndProgramaNuevas() != null && dtoPlan.getIndProgramaNuevas().booleanValue()){
          this.sIndEstadoProgramaNuevas = "S";
      }
      
      if(dtoPlan.getIndMultinivel() != null && dtoPlan.getIndMultinivel().booleanValue()){
          this.sIndEstadoMultinivel = "S";
      }      
            
            if(dtoPlan.getIndAmbitoGeografico() != null && !dtoPlan.getIndAmbitoGeografico().booleanValue()){
          //Si es inactivo quiere decir que no es ámbito geográfico completo, 
          //por lo que se elejirá el ámbito geográfico en la pestaña
          this.sIndEstadoAmbitoGeografico = "S";
      }
            else {
                    this.sIndEstadoAmbitoGeografico = "N";
            }
                     /* Cleal - 20896
            //Agregado por incidencia 20810
            if(dtoPlan.getIndProductosValidos()!=null && !dtoPlan.getIndProductosValidos().booleanValue()) {
                    sIndEstadoProductos = "S";
            }
            else {
                    sIndEstadoProductos = "N";
            }
            //Agregado por incidencia 20810
                           */
            this.setConcurso(dtoc);    
    }
          else if(this.opcionMenu != null && (this.opcionMenu.equalsIgnoreCase("Modificar Concurso") || 
          this.opcionMenu.equalsIgnoreCase("Consultar Concurso"))){    
      traza("entro por opcionMenu == ModificarConcurso o opcionMenu == ConsultarConcurso");
    
      //Esta LP se llama desde la LPMantenimientoConcursos y recibe el oidConcurso 
      //y el oidPlantilla.
      
      //Se realiza la carga del dtoConcurso según los datos existentes en las 
      //entidades (puesto que es una modficacion).
      
      dtoOID = new DTOOID();
      
      try{
          dtoOID.setOid(oidConcurso!=null&&oidConcurso.length()>0? new Long(oidConcurso):null);
      }catch(NumberFormatException nfe){}

      dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoOID.setOidPais(UtilidadesSession.getPais(this));

      id = new MareBusinessID("INCObtenerDatosConcurso");
      
      params = new Vector();
      params.add(dtoOID);
      params.add(id);
      
      traza("va a conectar INCObtenerDatosConcurso");
      con = this.conectar("ConectorObtenerDatosConcurso", params);
      traza("conecto");
      
      //TODO: revisar la clave de salida del conector
      DTOConcurso dtoConcurso = (DTOConcurso)con.objeto("dtoSalida");

      dtoConcurso.setOidPais(UtilidadesSession.getPais(this));
      dtoConcurso.setOidIdioma(UtilidadesSession.getIdioma(this));

           //Cleal - 20896 
           this.sIndEstadoProductos = "S";
           if(dtoPlan.getIndProductosValidos()!=null && dtoPlan.getIndProductosValidos().booleanValue()){
                  if(dtoPlan.getIndProductosExigidos()!=null && dtoPlan.getIndProductosExcluidos()!=null && dtoPlan.getIndProductosBonificados()!=null && 
                      !dtoPlan.getIndProductosExigidos().booleanValue() && !dtoPlan.getIndProductosExcluidos().booleanValue() && !dtoPlan.getIndProductosBonificados().booleanValue()){
                           
                           this.sIndEstadoProductos = "N";
                  }
           }
           //

      //Habilitacion de pestanyas
      //Calificacion
      if(dtoPlan.getIndFaseCalificacion() != null && dtoPlan.getIndFaseCalificacion().booleanValue()){
          this.sIndEstadoCalificion = "S";
      }
      
      //Gerentes
      if(dtoPlan.getOidDirigidoA() != null && 
            dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE)){
          this.sIndEstadoGerentes = "S";
      }

      //Consultoras
      if(dtoPlan.getOidDirigidoA() != null && 
            dtoPlan.getOidDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
          this.sIndEstadoConsultoras = "S";
      }
      
      //Programa nuevas
      if(dtoPlan.getIndProgramaNuevas() != null && dtoPlan.getIndProgramaNuevas().booleanValue()){
          this.sIndEstadoProgramaNuevas = "S";
      }
      
      //Multinivel
      if(dtoPlan.getIndMultinivel() != null && dtoPlan.getIndMultinivel().booleanValue()){
          this.sIndEstadoMultinivel = "S";
      }
      
      //Ambito Geografico
      if(dtoPlan.getIndAmbitoGeografico() != null && 
            !dtoPlan.getIndAmbitoGeografico().booleanValue()){
          //Si es inactivo quiere decir que no es ámbito geográfico completo, 
          //por lo que se elejirá el ámbito geográfico en la pestaña.
          this.sIndEstadoAmbitoGeografico = "S";
      }
            else {
                    this.sIndEstadoAmbitoGeografico = "N";
            }

            //Productos
            /* Cleal - 20896
                     //Agregado por incidencia 20810
            if(dtoPlan.getIndProductosValidos()!=null && !dtoPlan.getIndProductosValidos().booleanValue()) {
                    sIndEstadoProductos = "S";
            }
            else {
                    sIndEstadoProductos = "N";
            }
            //Agregado por incidencia 20810
                    */
      this.setConcurso(dtoConcurso);
    }
  }
  
	/*
	Modificado por Cristian Valenzuela
	4/5/2006
	Cambios Versionado	
	*/
	public void cargarPantalla() throws Exception {  
		traza("LPMantenerParametrosGenerales.cargarPantalla() - Entrada");  
        this.pagina("contenido_parametros_generales_mantener");
        
        // Validaciones
        this.getFormatosValidaciones();
    
        getConfiguracionMenu("LPMantenerParametrosGenerales", "Crear Concurso");      
        if(opcionMenu.equals("Crear concurso")){
	        asignarAtributoPagina("cod", "0491");
        } 
        else if(opcionMenu.equals("Consultar Concurso")){
		    asignarAtributoPagina("cod", "0493");
        }
        else if(opcionMenu.equals("Modificar Concurso")){
			asignarAtributoPagina("cod", "0486");
        }  

        DTOConcurso dtoc = this.getConcurso();
        ComposerViewElementList cv = this.crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        asignar("COMBO", "cbAcceso", resultados, "INCObtenerAccesos");
        asignar("COMBO", "cbMarca", resultados, "INCObtenerMarcas");
        asignar("COMBO", "cbTipoConcursoIVR", resultados, "INCConsultaTiposConcursoIVR");
		//agregado por cvalenzu - cambio fac-003
		asignar("COMBO", "cbTipoPrograma", resultados, "INCObtenerTiposPrograma");
		
		// vbongiov -- Cambio 20090930 -- 16/07/2009
		asignar("COMBO", "cbClasificacionConcurso", resultados, "INCObtenerClasificacionConcurso");

		// sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
		asignar("COMBO", "cbTipoOfertaConcurso", resultados, "INCObtenerTipoOfertaConcurso");
		
		Vector salida = valorRowset("INCObtenerTipoOfertaConcurso", resultados);
		if(salida.size()>0 && (!opcionMenu.equals("Consultar Concurso"))) {
			asignarAtributo("COMBO","cbTipoOfertaConcurso","req","S");
			asignarAtributoElementoValidacion("cbTipoOfertaConcurso","required","true"); 					
		}
		
        // Agregado por INC 21038
        // El combo ctTipoConcursoIVR tomará el valor correspondiente a la plantilla del concurso
        Long oidTipoConcursoIVR = dtoc.getPlantilla().getOidTipoConcursoIVR();
        if (oidTipoConcursoIVR != null) {
			this.asignarAtributo("VAR","hTipoConcursoIVR","valor",oidTipoConcursoIVR.toString());
        }

        this.asignarAtributo("VAR", "hdtNumPlantilla", "valor", 
		dtoc.getPlantilla().getOidPlantilla().toString());

        if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getAttriTraducible() != null && 
			dtoc.getPlantilla().getAttriTraducible().size() > 0){

            traza("*********** Ingreso a obtener nombre plantilla");
          
            Vector vTradu = dtoc.getPlantilla().getAttriTraducible();
            Iterator i = vTradu.iterator();
            DTOI18nSICC dto = null;
            String valorI18N = "";
            Long oidIdioma = UtilidadesSession.getIdioma(this);

            while(i.hasNext()){
				dto = (DTOI18nSICC)i.next();
                if(dto.getOidIdioma().equals(dto.getOidIdioma())){
		          valorI18N = dto.getValorI18n();
                  break;
                }
            }
 
			traza("******** Nombre plantilla: " + valorI18N);
            this.asignarAtributo("VAR", "hdtNombrePlantilla", "valor", valorI18N);
        }

        if(dtoc.getIndParamGenerales() != null && dtoc.getIndParamGenerales().booleanValue()){    
			traza("*********** CONDICION 1");
            traza("0.1");

            if ( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOid() != null ) {
		        this.asignarAtributo("VAR", "hOidConcurso", "valor", 
                dtoc.getParamGenerales().getOid().toString());
            }
                              
            traza("0.2");
                              
            if (dtoc.getPlantilla() != null && dtoc.getPlantilla().getOidPlantilla() != null){
				this.asignarAtributo("VAR", "hdtNumPlantilla", "valor", 
                dtoc.getPlantilla().getOidPlantilla().toString());
            }
    
            traza("0.3");

            this.asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
                         
            traza("0.4");
                        
            if ( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidCanal() != null) {				
                this.asignarAtributo("VAR", "hCanal", "valor", 
				dtoc.getParamGenerales().getOidCanal().toString() );
            }

            traza("1");

            if (dtoc.getPlantilla() != null && dtoc.getPlantilla().getAttriTraducible() != null 
	            && !dtoc.getPlantilla().getAttriTraducible().isEmpty()){
                DTOI18nSICC dtoI18N = (DTOI18nSICC)dtoc.getPlantilla().getAttriTraducible().elementAt(0);
                this.asignarAtributo("VAR", "hdtNombrePlantilla", "valor", dtoI18N.getValorI18n());
            }

            traza("2");

            if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getNombreConcurso() != null){
		       this.asignarAtributo("CTEXTO", "txtNombreConcurso", "valor", dtoc.getParamGenerales().getNombreConcurso());
            }
          
            traza("3");

            if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndActivo() != null && 
			    dtoc.getParamGenerales().getIndActivo().booleanValue()){
                this.asignarAtributo("VAR", "hIndActivarConcurso", "valor", "S");
            }
            else{
				this.asignarAtributo("VAR", "hIndActivarConcurso", "valor", "N");
            }

            traza("4");
            
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidMarca() != null){
				this.asignarAtributo("VAR", "hMarca", "valor", 
				dtoc.getParamGenerales().getOidMarca().toString());
            }

            traza("5");
            
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidCanal() != null ){
				this.asignarAtributo("VAR", "hCanal", "valor", 
				dtoc.getParamGenerales().getOidCanal().toString());
            }

            traza("6");    
            
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getDesCanal() != null ){
				this.asignarAtributo("VAR", "hDescCanal", "valor", 
				dtoc.getParamGenerales().getDesCanal());
            }

            //recorrer dtoConcurso.paramGenerales.lstAccesos y seleccionar en lstAcceso
            //de la página, los valores cuyos oids coincidan.
            ArrayList alAccesos = dtoc.getParamGenerales().getLstAccesos();
            traza("6");      
            if(alAccesos != null && alAccesos.size() > 0){
				Iterator i = alAccesos.iterator();
                String oid = null;
                StringBuffer accesos = new StringBuffer("");
                                         
                while(i.hasNext()){
					oid = i.next().toString();
 
					if(accesos.length() > 0){
						accesos.append("|");
                    }
                    
					traza("7");            
                    accesos.append(oid);
                }
                                 
                this.asignarAtributo("VAR", "hAccesos", "valor", accesos.toString());
            }
      
	       //- seleccionar en cbPeriodoDesde el valor cuyo oid es igual a 
		   //dtoConcurso.paramGenerales.oidPeriodoDesde 
		   //- seleccionar en cbPeriodoHasta el valor cuyo oid es igual a 
		   //dtoConcurso.paramGenerales.oidPeriodoHasta 

           //<VAR nombre="hOidPeriodoDesde" valor=""/>
           //<VAR nombre="hOidPeriodoHasta" valor=""/>
		   
           if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidPeriodoDesde() != null){
				this.asignarAtributo("VAR", "hOidPeriodoDesde", "valor", 
				dtoc.getParamGenerales().getOidPeriodoDesde().toString());
		   }		   
			
		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidPeriodoHasta() != null){
				this.asignarAtributo("VAR", "hOidPeriodoHasta", "valor", 
				dtoc.getParamGenerales().getOidPeriodoHasta().toString());
		   }

		   //Agregado por Cristian Valenzuela - 4/5/2006 - Cambios versionado
		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidPeriodoDesde() != null){
			   this.asignarAtributo("VAR", "oidPeriodoDesde", "valor", 
				dtoc.getParamGenerales().getOidPeriodoDesde().toString());
		   }

		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidPeriodoHasta() != null){
   				this.asignarAtributo("VAR", "oidPeriodoHasta", "valor", 
				dtoc.getParamGenerales().getOidPeriodoHasta().toString());
		   }

   		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getCodPeriodoDesde() != null){
			   this.asignarAtributo("VAR", "codPeriodoDesde", "valor", 
				dtoc.getParamGenerales().getCodPeriodoDesde());
		   }

		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getCodPeriodoHasta() != null){
   				this.asignarAtributo("VAR", "codPeriodoHasta", "valor", 
				dtoc.getParamGenerales().getCodPeriodoHasta());
		   }
   		   //FIN - Agregado por Cristian Valenzuela - 4/5/2006 - Cambios versionado
      
		   //- chkIndDevoluciones = dtoConcurso.paramGenerales.indDevoluciones 
		   // seleccionar o no el check, segun el indicador esté en uno o en cero 
		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndDevoluciones() != null){
				this.asignarAtributo("VAR", "hIndDevoluciones", "valor", 
				dtoc.getParamGenerales().getIndDevoluciones().booleanValue()?"S":"N");
		   }
			
			traza("10");
			//- chkIndAnulaciones = dtoConcurso.paramGenerales.indAnulaciones 
			// seleccionar o no el check, segun el indicador esté en uno o en cero 
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndAnulaciones() != null){
				this.asignarAtributo("VAR", "hIndAnulaciones", "valor", 
				dtoc.getParamGenerales().getIndAnulaciones().booleanValue()?"S":"N");
			}
      
			//- chkIndFaltantesNoAnunciados = dtoConcurso.paramGenerales.indFaltantesNoAnunciados 
			// seleccionar o no el check, segun el indicador esté en uno o en cero 
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndFaltantesNoAnunciados() != null){
				this.asignarAtributo("VAR", "hIndFaltantesNoAnunciados", "valor", 
				dtoc.getParamGenerales().getIndFaltantesNoAnunciados().booleanValue()?"S":"N");
			}
			
			traza("11");
			//*************************** CAMBIO
			traza("*********** dtoc.getPlantilla().getDesDirigidoA() " + dtoc.getPlantilla().getDesDirigidoA());
			if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getDesDirigidoA() != null){
				this.asignarAtributo("VAR", "hDirigidoA", "valor", dtoc.getPlantilla().getDesDirigidoA());
			}
			
			//*************************** CAMBIO

		    //- oidDirigidoA = dtoConcurso.paramGenerales.oidDirigidoA 
			//se guarda en la variable oculta de la página 
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidDirigidoA() != null){
				this.asignarAtributo("VAR", "hOidDirigidoA", "valor", 
				dtoc.getParamGenerales().getOidDirigidoA().toString());
			}	

		    traza("expresion puntaje");

			//- txtExpresionPuntaje = dtoConcurso.paramGenerales.expresionPuntaje
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getExpresionPuntaje() != null){      
				traza("expresion puntaje: " + dtoc.getParamGenerales().getExpresionPuntaje());      
	            this.asignarAtributo("CTEXTO", "txtExpresionPuntaje", "valor", 
                dtoc.getParamGenerales().getExpresionPuntaje());
			}
			
			traza("12");
	        //- chkIndConcursoPruebas = dtoConcurso.paramGenerales.indPruebas 
			// seleccionar o no el check, segun el indicador esté en uno o en cero 
		    if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndPruebas() != null){
				this.asignarAtributo("VAR", "hIndPruebas", "valor", 
				dtoc.getParamGenerales().getIndPruebas().booleanValue()?"S":"N");
			}

	       //- txtObservaciones = dtoConcurso.paramGenerales.observaciones 
		   if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getObservaciones() != null){
				this.asignarAtributo("AREATEXTO", "atxtObservaciones", "valor", 
				dtoc.getParamGenerales().getObservaciones());
                
				this.asignarAtributo("VAR", "tempObservaciones", "valor", 
				dtoc.getParamGenerales().getObservaciones());
			}

		    //seleccionar en cbTipoConcursoIVR el valor cuyo oid es igual a 
	        //dtoConcurso.paramGenerales.oidTipoConcursoIVR         
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidTipoConcursoIVR() != null){
				this.asignarAtributo("VAR", "hTipoConcursoIVR", "valor", 
				dtoc.getParamGenerales().getOidTipoConcursoIVR().toString());
			}
			
			traza("13");
		    //oidPlantilla = dtoConcurso.plantilla.oidPlantilla 
	        //se guarda en la variable oculta de la página 
			if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getOidPlantilla() != null){
				this.asignarAtributo("VAR", "hOidPlantilla", "valor", 
				dtoc.getPlantilla().getOidPlantilla().toString());
			} 

			//jrivas 30-1-2007 Dupla Cyzone
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndDuplaCyzone() != null){
				this.asignarAtributo("VAR", "hIndDuplaCyzones", "valor", 
				dtoc.getParamGenerales().getIndDuplaCyzone().booleanValue()?"S":"N");
			}

			//cvalenzu - 3/7/2007 - cambio fac-003
			//seleccionar en cbTipoPrograma el valor cuyo oid es igual a 
			//dtoConcurso.paramGenerales.oidTipoPrograma         
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidTipoPrograma() != null){
				this.asignarAtributo("VAR", "hTipoPrograma", "valor", 
				dtoc.getParamGenerales().getOidTipoPrograma().toString());
			}

			// vbongiov -- Cambio 20080809 -- 7/04/2009
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndNoGeneraPunt() != null){
				this.asignarAtributo("VAR", "hIndNoGeneraPunt", "valor", 
				dtoc.getParamGenerales().getIndNoGeneraPunt().booleanValue()?"S":"N");
			}

			// vbongiov -- Cambio 20090930 -- 16/07/2009
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidClasificacionConcurso() != null){
				this.asignarAtributo("VAR", "hClasificacionConcurso", "valor", 
				dtoc.getParamGenerales().getOidClasificacionConcurso().toString());
			}
			
			// sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getOidTipoOfertaConcurso() != null){
				this.asignarAtributo("VAR", "hTipoOfertaConcurso", "valor", 
				dtoc.getParamGenerales().getOidTipoOfertaConcurso().toString());
			}

			// sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
			if( dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getIndMultiMarca() != null){
				this.asignarAtributo("VAR", "hIndMultiMarca", "valor", 
						dtoc.getParamGenerales().getIndMultiMarca().booleanValue()?"S":"N");
			}
			if(dtoc.getParamGenerales() != null && dtoc.getParamGenerales().getPuntosAbonar() != null){      
	            this.asignarAtributo("CTEXTO", "txtPuntosAbonar", "valor", 
	            				dtoc.getParamGenerales().getPuntosAbonar().toString());
			}
			
		}
		else{ //********************************************************************
    
			traza("ENTRO POR CONDICION 2");    
	        this.asignarAtributo("VAR", "hOidConcurso", "valor", "");
    
			if (dtoc.getPlantilla() != null && dtoc.getPlantilla().getOidPlantilla() != null){
				this.asignarAtributo("VAR", "hdtNumPlantilla", "valor", 
				dtoc.getPlantilla().getOidPlantilla().toString());
			}

	        if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getAttriTraducible() != null && 
		      dtoc.getPlantilla().getAttriTraducible().size() > 0){
          
			  //TODO(LISTO) Poner el nombre correcto
			  DTOI18nSICC dtoI18N = (DTOI18nSICC)dtoc.getPlantilla().getAttriTraducible().elementAt(0);
			  this.asignarAtributo("VAR", "hdtNombrePlantilla", "valor", dtoI18N.getValorI18n());
            
			  //this.asignarAtributo("VAR", "hdtNombrePlantilla", "valor", 
			  //  dtoc.getPlantilla().getAttriTraducible().elementAt(1).toString());
			  //this.asignarAtributo("VAR", "hdtNombrePlantilla", "valor", "la Plantilla");
			}
      
			this.asignarAtributo("VAR", "hIndDevoluciones", "valor", "S");
			this.asignarAtributo("VAR", "hIndAnulaciones", "valor", "S");
			this.asignarAtributo("VAR", "hIndFaltantesNoAnunciados", "valor", "S");

			//- txtDirigidoA = dtoConcurso.plantilla.desDirigidoA      
			if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getDesDirigidoA() != null){
				this.asignarAtributo("VAR", "hDirigidoA", "valor", dtoc.getPlantilla().getDesDirigidoA());
			}

			//oidDirigidoA = dtoConcurso.plantilla.oidDirigidoA 
			//se guarda en la variable oculta de la página 
			if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getOidDirigidoA() != null){
				this.asignarAtributo("VAR", "hOidDirigidoA", "valor", 
				dtoc.getPlantilla().getOidDirigidoA().toString());
			}
      
			// INC 21037
            // Se setea el textField "Expresión puntaje" con el valor por defecto al crear un concurso
            this.asignarAtributo("CTEXTO", "txtExpresionPuntaje", "valor", ConstantesINC.DES_EXPRESION_PUNTAJE);
      
			//se guarda en la variable oculta de la página, para recargar las combo cbPeriodoDesde y periodoHasta 
			if(dtoc.getPlantilla() != null && dtoc.getPlantilla().getOidCanal() != null){
				this.asignarAtributo("VAR", "hCanal", "valor", dtoc.getPlantilla().getOidCanal().toString());
			}

			if( dtoc.getPlantilla() != null && dtoc.getPlantilla().getDesCanal() != null ){
				this.asignarAtributo("VAR", "hDescCanal", "valor", dtoc.getPlantilla().getDesCanal());
			}

			//jrivas 30-1-2007 Dupla Cyzone
			this.asignarAtributo("VAR", "hIndDuplaCyzones", "valor", "N");

			// vbongiov -- Cambio 20080809 -- 7/04/2009
			this.asignarAtributo("VAR", "hIndNoGeneraPunt", "valor", "N");

        } // else

		traza("0.3");
		this.asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
	    this.asignarAtributo("VAR", "accion", "valor", this.accion);
		this.asignarAtributo("VAR", "opcionMenu", "valor", this.opcionMenu);
		
		// sapaza -- PER-SiCC-2011-0295 -- 17/06/2011
		this.asignarAtributo("VAR", "oidVigenciaConcurso", "valor", this.oidVigenciaConcurso);
		
	    this.asignarAtributo("VAR", "idPestanya", "valor", this.idPestanyaDest);    
	    //Asigna los flags para habilitar pesyanyas
		this.cargarFlagsPestanyas();
  }
  
  private ComposerViewElementList crearParametrosEntrada() throws Exception {
    DTOConcurso dtoc = this.getConcurso();
  
    DTOOID dtoOID = new DTOOID();
    dtoOID.setOidPais(UtilidadesSession.getPais(this));
    dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
    dtoOID.setOid(dtoc.getPlantilla().getOidPlantilla());
    
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidPais(UtilidadesSession.getPais(this));
    dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

    ComposerViewElementList lista = new ComposerViewElementList(); 
    ComposerViewElement cve = null;
    
    // Marcas
    cve = new ComposerViewElement();
    cve.setIDBusiness("INCObtenerMarcas");
    cve.setDTOE(dtoOID);
    lista.addViewElement(cve);
    
    // Accesos
    cve = new ComposerViewElement();
    cve.setIDBusiness("INCObtenerAccesos");
    cve.setDTOE(dtoOID);
    lista.addViewElement(cve);

    // Tipos concurso IVR
    cve = new ComposerViewElement();
    cve.setIDBusiness("INCConsultaTiposConcursoIVR");
    cve.setDTOE(dtoe);
    lista.addViewElement(cve);

    // cvalenzu - 3/7/2207
	// cambio fac-003
	// Tipos programa
	cve = new ComposerViewElement();
	cve.setIDBusiness("INCObtenerTiposPrograma");
	cve.setDTOE(dtoe);	
	lista.addViewElement(cve);

	// vbongiov -- Cambio 20090930 -- 16/07/2009
	cve = new ComposerViewElement();
	cve.setIDBusiness("INCObtenerClasificacionConcurso");
	cve.setDTOE(dtoe);	
	lista.addViewElement(cve);

	// vbongiov -- PER-SiCC-2011-0042 -- 18/01/2011
	cve = new ComposerViewElement();
	cve.setIDBusiness("INCObtenerTipoOfertaConcurso");
	cve.setDTOE(dtoe);	
	lista.addViewElement(cve);
    
    return lista;
  }
  
  public void almacenar() throws Exception {
	traza("LPMantenerParametrosGenerales.almacenar() - Entrada");

	DTOConcurso dtoc = this.getConcurso();    
    dtoc.setIndParamGenerales(Boolean.TRUE); 
    
	traza("1" + datosObligatorios);
    dtoc.setIndObligParamGenerales(datosObligatorios!=null&&(datosObligatorios.equalsIgnoreCase("S")
    ||datosObligatorios.equalsIgnoreCase("true"))?Boolean.TRUE:Boolean.FALSE);
    traza("1");

    traza("2");    

	if(dtoc.getParamGenerales() == null){
      dtoc.setParamGenerales(new DTOParametrosGeneralesConcurso());
    }
    
    dtoc.getParamGenerales().setNombreConcurso(nombreConcurso);
    traza("Antes de setear indActivo: " + sActivo);

    dtoc.getParamGenerales().setIndActivo(sActivo!=null&&
    sActivo.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

    traza("despues de setear indActivo: " + dtoc.getParamGenerales().getIndActivo());

    //Agregado por dmaneiro, 15/11/2005. Inc. 21039
    dtoc.getParamGenerales().setIndRanking(Boolean.FALSE);
      
    // Agregado por ssantana, 1/6/2005
    // Setea el Pais e Idioma de Sesion.
    dtoc.getParamGenerales().setOidPais( UtilidadesSession.getPais(this) );
    dtoc.getParamGenerales().setOidIdioma( UtilidadesSession.getIdioma(this));

    //Jrivas 16/6/2005
    dtoc.getParamGenerales().setDesCanal(dtoc.getPlantilla().getDesCanal());
    traza("3");

	try {      
      String marca = conectorParametro("hMarca");
      traza("marca " + marca);         

      if (marca != null && !marca.equals("")){
	      dtoc.getParamGenerales().setOidMarca(new Long(marca));
      }         
    }
	catch(NumberFormatException nfe){}

    try {   
		 String canal = conectorParametro("hCanal");
         traza("canal " + canal);      
	     dtoc.getParamGenerales().setOidCanal(canal!=null&&canal.length()>0?  new Long(canal):null);
             
    }catch(NumberFormatException nfe){}

    dtoc.getParamGenerales().setLstAccesos(this.obtenerListaAccesos());

    traza("4");

	try{    
      traza("sPeriodoDesde *** " + sPeriodoDesde);
          
      String desde = conectorParametro("hOidPeriodoDesde");
      
      traza("desde " + desde);

      if (desde != null && !desde.equals("")){
	      dtoc.getParamGenerales().setOidPeriodoDesde(new Long(desde));
      }
	  else {
		dtoc.getParamGenerales().setOidPeriodoDesde(null);
      }
          
    }catch(NumberFormatException nfe){
          traza(nfe);
          }
    
    try {    
      traza("sPeriodoHasta " + sPeriodoHasta);
      String hasta = conectorParametro("hOidPeriodoHasta");
      traza("hasta " + hasta);
      
      if (hasta != null && !hasta.equals("")){      
		dtoc.getParamGenerales().setOidPeriodoHasta(new Long(hasta));
      }
	  else {
		dtoc.getParamGenerales().setOidPeriodoHasta(null);
      }

    }catch(NumberFormatException nfe){}

    dtoc.getParamGenerales().setIndDevoluciones(sIndDevoluciones!=null&&
      sIndDevoluciones.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

    dtoc.getParamGenerales().setIndAnulaciones(sIndAnulaciones!=null&&
      sIndAnulaciones.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

    dtoc.getParamGenerales().setIndFaltantesNoAnunciados(
      sIndFaltantesNoAnunciados!=null&&
      sIndFaltantesNoAnunciados.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

    try{
      dtoc.getParamGenerales().setOidDirigidoA(sOidDirigidoA!=null&&
          sOidDirigidoA.length()>0?new Long(sOidDirigidoA):null);
    }catch(NumberFormatException nfe){}

    dtoc.getParamGenerales().setExpresionPuntaje(sExpresionPuntaje);

    dtoc.getParamGenerales().setIndPruebas(sConcursoPruebas!=null&&
    sConcursoPruebas.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

    dtoc.getParamGenerales().setObservaciones(sObservaciones);
    traza("5");

	try{
      dtoc.getParamGenerales().setOidTipoConcursoIVR( sTipoConcursoIVR!=null&&
          sTipoConcursoIVR.length()>0?new Long(sTipoConcursoIVR):null);
    }catch(NumberFormatException nfe){}

    traza("antes de set concurso");         

	//Agregado por cvalenzu - 31/05/2006
	dtoc.getParamGenerales().setCodPeriodoDesde(codPeriodoDesde);
	dtoc.getParamGenerales().setCodPeriodoHasta(codPeriodoHasta);
	//FIN - Agregado por cvalenzu - 31/05/2006

    //jrivas 30-1-2007 Dupla Cyzone
	dtoc.getParamGenerales().setIndDuplaCyzone(sIndDuplaCyzone!=null&&
    sIndDuplaCyzone.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

	//cvalenzu 3/7/2007 - cambio fac-003
	if (sTipoPrograma != null && !sTipoPrograma.equals("")){
		dtoc.getParamGenerales().setOidTipoPrograma(new Long(sTipoPrograma));
	}

	// vbongiov -- Cambio 20080809 -- 7/04/2009
	dtoc.getParamGenerales().setIndNoGeneraPunt(sIndNoGeneraPunt!=null&&
    sIndNoGeneraPunt.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);

	// vbongiov -- Cambio 20090930 -- 16/07/2009  
	if (sCbClasificacionConcurso != null && !sCbClasificacionConcurso.equals("")){
		dtoc.getParamGenerales().setOidClasificacionConcurso(new Long(sCbClasificacionConcurso));
	} else {
		dtoc.getParamGenerales().setOidClasificacionConcurso(null);
	}

	// sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
	if (sCbTipoOfertaConcurso != null && !sCbTipoOfertaConcurso.equals("")){
		dtoc.getParamGenerales().setOidTipoOfertaConcurso(new Long(sCbTipoOfertaConcurso));
	} else {
		dtoc.getParamGenerales().setOidTipoOfertaConcurso(null);
	}

	// sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
	dtoc.getParamGenerales().setIndMultiMarca(sIndMultiMarca!=null&&
			sIndMultiMarca.equalsIgnoreCase("S")?Boolean.TRUE:Boolean.FALSE);
	
	if (sPuntosAbonar != null && !sPuntosAbonar .equals("")){
		dtoc.getParamGenerales().setPuntosAbonar(new Long(sPuntosAbonar));
	} else {
		dtoc.getParamGenerales().setPuntosAbonar(null);
	}

    this.setConcurso(dtoc);
  }
  
 
  //metodos de servicio
  private ArrayList obtenerListaAccesos(){
    ArrayList ar = new ArrayList();
  
    if(sAccesos != null){
      StringTokenizer st = new StringTokenizer(sAccesos, "|");
      String token = null;
      Long lToken = null;
      
      while(st.hasMoreTokens()){
          token = st.nextToken();
          
          if(token != null && token.length() > 0){
            try{
              lToken = new Long(token);
              ar.add(lToken);
            }catch(NumberFormatException nfe){}
          }
      }
    }
    
    return ar;
  }
  
  
 
  private void invocarPestanya(String lp) throws Exception {
    this.conectorAction(lp);
    //this.pasarFlagsPestanyas();
    this.conectorActionParametro("accion", "");
  }
  
  
  private ArrayList parsearRecordSetMontoVenta(DTOSalida dto) throws Exception {
     UtilidadesLog.info("Entrando a obtenerArrayListaMontoVentas()");
     UtilidadesLog.info("DTOSalida Entrada: " + dto);
     // Recorre el Recordset del DTOSalida y por cada tupla del mismo, 
     // crea un DTOMontoVentaRecomendadas 
     ArrayList aList = new ArrayList();
     RecordSet r = dto.getResultado();
    
     // Si hay registros en el RecordSet, los procesa. 
     if ( !r.esVacio() ) {
      
          int cantRegistros = r.getRowCount();
          DTOMontoVentaRecomendadas dtoMontoVentaRecomendada = null;
          BigDecimal bigOid = null;
          String sDescTipo = null;
         
          // Genera por cada registro, un DTO en el ArrayList. 
          for ( int i = 0; i < cantRegistros; i++) {
             dtoMontoVentaRecomendada = new DTOMontoVentaRecomendadas();
             
             bigOid = (BigDecimal) r.getValueAt(i, 0);
             sDescTipo = (String) r.getValueAt(i, 1);
              
             dtoMontoVentaRecomendada.setOidMontoVenta(null);
//Cleal - 21045
//                         dtoMontoVentaRecomendada.setCantidad(new BigDecimal(0));
             dtoMontoVentaRecomendada.setOidTipoMontoVenta( new Long(bigOid.longValue()) );
             dtoMontoVentaRecomendada.setDescTipoMontoVenta(sDescTipo);
             aList.add(dtoMontoVentaRecomendada);
          }
     }
      
     return aList;
    
  }
  
  
  /**
   * @Author: ssantana, 26/5/2005, x inc. 18305
   * @throws java.lang.Exception
   * @return ArrayList
   * @param DTOSalida dto
   */
  private ArrayList obtenerArrayListaMontoVentas() throws Exception {
          // *********************************************************************
          //   Agregado por ssantana, 26/5/2005
          //   Inc. 18305
          //   Se obtienen los tiposMontoVentaRecomendadas para poder cargar 
          //   la lista de la ventana modal la primera vez que se ingrese.
          // *********************************************************************
          
          DTOBelcorp dtoBelcorp = new DTOBelcorp();
          DruidaConector conTipoMontoVentaRecom = null;
          DTOSalida dtoSalida = null;
          ArrayList aListMontoVentas = null;
          MareBusinessID bussID = new MareBusinessID("INCObtenerTipoMontoVentaRecomendada");
          Vector vParams = new Vector();
          
          dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));

          vParams.add(dtoBelcorp);          
          vParams.add(bussID);
          
          conTipoMontoVentaRecom = this.conectar("ConectorObtenerTipoMontoVentaRecomendada", vParams);
          dtoSalida = (DTOSalida) conTipoMontoVentaRecom.objeto("DTOSalida");
          
          // Arma el ArrayList para luego setearlo. 
          aListMontoVentas = this.parsearRecordSetMontoVenta(dtoSalida);
          
          return aListMontoVentas;          
  } 
}

