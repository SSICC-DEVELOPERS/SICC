/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
//import LPSICCBase;
//import LPRegistro;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.edu.DTOParticipante;
import es.indra.sicc.dtos.edu.DTORegistrarHistorico;
//import es.indra.sicc.dtos.edu.DTOParticipantesValidados;


import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;


import java.util.Vector;
import java.util.StringTokenizer;
import java.sql.Date;

import es.indra.mare.common.mln.MareBusinessID;

//pruebas
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.edu.DTOOIDCurso;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;

public class LPExtemporaneas extends LPRegistro {
	
	public LPExtemporaneas() {
	          super();
	}
    
    private String accion = null;
    private String casoUso = null;   
    private Long idioma;
    private Long pais;   
           
	public void inicio() throws Exception {
		
	}	
	
	public void ejecucion() throws Exception {
		try {
			//rastreo();
			setTrazaFichero();
			traza("*** Entrada - LPExtemporaneas - ejecucion ***");
      this.pais = UtilidadesSession.getPais(this); 
      this.idioma = UtilidadesSession.getIdioma(this);
      
			//mostramos la pagina 
			/*pagina("contenido_extemporaneas_cursos_actualizar");
			//Obtenemos el pais y el idioma de la sesion
			this.pais = UtilidadesSession.getPais(this); 
			this.idioma = UtilidadesSession.getIdioma(this);
			
			asignarAtributo ("VAR", "pais", "valor", pais.toString());
			asignarAtributo("VAR", "idioma", "valor", idioma.toString());*/
			
			this.accion = conectorParametroLimpia("accion", "", true);
			traza("Ejecucion  Accion: "+accion);
			
			//obtenemos el pais y el idioma de la sesion
			if (accion.equals("")) {
         pagina("contenido_extemporaneas_cursos_actualizar");
         //Obtenemos el pais y el idioma de la sesion
         this.asignarAtributo("VAR", "pais", "valor", pais.toString());
         this.asignarAtributo("VAR", "idioma", "valor", idioma.toString());
         String sTipoCurso = this.conectorParametroLimpia("oidTipoCurso", 
                                                          "", 
                                                          true);
                                                          
         traza("Lee tipoCurso y lo asigna - Valor: " + sTipoCurso);
         this.asignarAtributo("VAR", "oidTipoCurso", "valor", sTipoCurso);
         this.muestraPantalla();							
      } else if (accion.equals("Registrar")){
         this.registraAsistencia(this.idioma,this.pais); 
      } else if (accion.equals("Obtener Datos Cliente")) {
         this.obtenerDatosCliente();
      }
		} catch(Exception e) {
			logStackTrace(e);
			lanzarPaginaError(e);			
		}
		traza("*** Salida- LPExtemporaneas - ejecucion ***");
	}
	
	private void muestraPantalla() throws Exception {
		traza("*** Entrada- LPExtemporaneas - muestraPantalla ***");
		//para validar la fecha que introduce el usuario
		this.generarHiddenFormatoFecha();
    
    // Agregado por ssantana, 5/12/2005, SICC-GCC-EDU-009
    Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
    asignar("VAR", "longitudCodigoCliente", longitudCodigoCliente.toString());
    // Fin Agregado por ssantana, 5/12/2005, SICC-GCC-EDU-009
		
		asignarAtributo("PAGINA","contenido_extemporaneas_cursos_actualizar", "cod", "0210");
    asignarAtributo("PAGINA","contenido_extemporaneas_cursos_actualizar", "msgle", "Registrar extemporaneas a cursos");
		//getConfiguracionMenu("LPInvitadas", "");
    getConfiguracionMenu("LPExtemporaneas", "");
		
		//rellenar el campo oculto oidCurso de la pagina
		String strOidCurso=conectorParametroLimpia("oid","",true);
    traza("strOidCurso: "+ strOidCurso);
		asignar("VAR","oidCurso",strOidCurso);
    
  	traza("*** Salida- LPExtemporaneas - muestraPantalla ***");
		
	}
	
	private void registraAsistencia(Long idioma, Long pais) throws Exception {
		/*Realiza el registro de asistencia de todos aquellos participantes para los que se ha puesto fecha de asistencia. */

    Long lOidCurso = null;
    Long lOidTipoCurso = null;
		DTORegistrarAsistencia dtoe = new DTORegistrarAsistencia();
		Vector vector=new Vector();
    DTOParticipante dtoParticipante = null;
    DTOParticipante[] dtoPLista = null;    
    DTOParticipante[] dtoPValidos = null;        
    StringTokenizer st = null;
    DTOParticipantesValidados dtoPValidados = null;
    StringBuffer sFuncion = new StringBuffer("");
    DTOOID dtoOidCurso = null;
    
		traza("*** Entrada- LPExtemporaneas - registraAsistencia ***");
    String sOidCurso = this.conectorParametroLimpia("oidCurso","",true);   
    lOidCurso = Long.valueOf(sOidCurso);
    String sTipoCurso = this.conectorParametroLimpia("oidTipoCurso", "", true);
    lOidTipoCurso = Long.valueOf(sTipoCurso);
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "false");
		//asignar("VAR", "ejecutar", "insercionCorrecta();");  // funcion que se ejecuta cuando todo es correcto
		  //Fin Salida Generica
		  
		
    /*
     * Parseamos la ListaEditable para posterior uso. 
     */
		String lista=conectorParametroLimpia("lista","",true);
		traza("lista = "+lista);
    dtoPLista = this.parseaLista(lista);
    /*
     * Fin Parseo Lista Editable. 
     */
     
    dtoPValidados = this.validarOperacion(dtoPLista, 
                                          lOidCurso, 
                                          this.pais,
                                          lOidTipoCurso);
                                          
    /*
     * Armamamos la cabecera del DTORegistrarAsistencia dtoe
     */
    dtoe = new DTORegistrarAsistencia();
    dtoe.setOidPais( this.pais );
    dtoe.setOidIdioma( this.idioma );
    dtoe.setOperacion( ConstantesEDU.REG_EXT );
    dtoe.setOidCurso( lOidCurso );
    
    /*
     * Seteamos dtoe.participantes con el array de DTOParticipantes Validos
     * y completmos los datos que faltan. 
     */
    dtoe.setParticipantes(dtoPValidados.getValidos());
    dtoPValidos = dtoe.getParticipantes();    
    int nSize = dtoPValidos.length;
    traza("Cantidad de Participantes Validos: " + nSize);
    
    for ( int i=0; i < nSize; i++) {
       dtoe.getParticipantes()[i].setAsistenciaCurso(Integer.valueOf("2"));
       dtoe.getParticipantes()[i].setNumConvoc(Integer.valueOf("2"));
    }
    this.registro(dtoe);
    
    /*
     * Manejo de Participantes No Validos
     */
    int cantPartNoValidos = dtoPValidados.getNoValidos().length;
    traza("cant. Participantes No Validos: " + cantPartNoValidos);
    sFuncion = new StringBuffer("insercionCorrecta('");        
    
    if ( cantPartNoValidos > 0 ) {
       String sErrorGUI = "UIEDU0007";
       traza("AAA");
       StringBuffer sNroRegistro = new StringBuffer("");
       for (int i = 0; i < cantPartNoValidos; i++) {
          traza("BBB - " + i);
          if ( i != 0 ) {
            sNroRegistro.append(",");
          }
          sNroRegistro.append(dtoPValidados.getNoValidos()[i].getNumeroRegistro());
       }
       traza("CCC");       
       sFuncion.append(sErrorGUI);
       traza("DDD");              
       sFuncion.append("', '");
       traza("EEE");       
       sFuncion.append(sNroRegistro.toString());
       traza("FFF");
       sFuncion.append("')");
    } else {
       traza("GGG");       
       sFuncion.append("', '')");
    }
    
    this.asignarAtributo("VAR", 
                         "ejecutar", 
                         "valor", 
                         sFuncion.toString());
              
    /*
     * Invoca a MONInformes.generarPasoHistoricoExtemporaneas();


     */
    traza("MAD EL DTO TIENE ALGO? " + dtoPValidados.getValidos().toString());
    if(dtoPValidados.getValidos() != null && dtoPValidados.getValidos().length > 0)	{
		DTORegistrarHistorico dtoR = new DTORegistrarHistorico();
			

		DTOParticipante[] dtoEnviar = dtoPValidados.getValidos();

		dtoR.setValidos(dtoEnviar);
		dtoR.setOidIdioma(this.idioma);
		dtoR.setOidPais(this.pais);
		dtoR.setOidTipoCurso(lOidTipoCurso);
		dtoR.setOidCurso(lOidCurso);

		 
		/*dtoOidCurso = new DTOOID();
		dtoOidCurso.setOid(lOidCurso);
		dtoOidCurso.setOidIdioma(this.idioma);
		dtoOidCurso.setOidPais(this.pais);*/
		
		MareBusinessID busID = new MareBusinessID("EDUGenerarPasoHistoricoExtemporaneas");
		Vector vParams = new Vector();
		
		vParams.add(dtoR);
		vParams.add(busID);
		traza("Conectando a MONInformes.generarPasoHistoricoExtemporaneas()");
		this.conectar("ConectorGenerarPasoHistoricoExtemporaneas", vParams);

		traza("*** Salida- LPExtemporaneas - registraAsistencia ***");
	}

	}
	
 private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
 }
 
 private String cadena(String entrada){
   if (entrada != null && !entrada.equals("-")) return entrada;
            return null;
 }


 private java.sql.Date fecha(String entrada)  throws Exception {
   if (entrada != null && !entrada.equals("-")) return new java.sql.Date((UtilidadesBelcorp.getDatefromSICCStringFormat(entrada, UtilidadesSession.getFormatoFecha(this))).getTime());
       return null;
 }
 
  /**
   * @author: ssantana, 6/12/2005, SICC-GCC-EDU-009
   * @throws java.lang.Exception
   */
 private void obtenerDatosCliente() throws Exception {
   String sCodigoCliente = 
                     this.conectorParametroLimpia("codigoCliente", "" , true);
   traza("sCodigoCliente: " + sCodigoCliente);                     
   pagina("salidaGenerica");
   this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
   this.asignarAtributo("VAR", "ejecutarError", "valor", "errorBusquedaCliente()");
   //traza("sCodigoCliente: " + sCodigoCliente);
   
   DTOBusquedaRapidaCliente dtoBusquedaRapida = new DTOBusquedaRapidaCliente();
   Vector vParams = new Vector(); 
   MareBusinessID busId = new MareBusinessID("MAEBusquedaRapidaCliente");
   
   dtoBusquedaRapida.setCodigoCliente(sCodigoCliente);
   dtoBusquedaRapida.setOidIdioma(UtilidadesSession.getIdioma(this));
   dtoBusquedaRapida.setOidPais(UtilidadesSession.getPais(this));
   dtoBusquedaRapida.setTamanioPagina(Integer.valueOf("1"));
   
   vParams.add(dtoBusquedaRapida);
   vParams.add(busId);
   DruidaConector con = this.conectar("ConectorBusquedaRapidaCliente", vParams);
   DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");
   RecordSet r = dtoSalida.getResultado();
   traza("r: " + r);
   
   StringBuffer sFuncion = new StringBuffer("");
   Long oidCliente = Long.valueOf( r.getValueAt(0,0).toString() );
   String sNombre1 = (String) r.getValueAt(0,2);
   String sNombre2 = (String) r.getValueAt(0,3);     
   String sApellido1 = (String) r.getValueAt(0,4);     
   String sApellido2 = (String) r.getValueAt(0,5);
   
   // Armo la funcion de jscript a llamar con sus valores correspondientes. 
   sFuncion.append("anyadeCampoALista('" + oidCliente.toString() + "', ");
   sFuncion.append("'" + sNombre1 + "', ");
   sFuncion.append("'" + sNombre2 + "', ");
   sFuncion.append("'" + sApellido1 + "', ");
   sFuncion.append("'" + sApellido2 + "')");
   traza("sFuncion: " + sFuncion.toString());
   
   // Seteo la llamada a la funcion de jscript    
   this.asignarAtributo("VAR", "ejecutar", "valor", sFuncion.toString());
 }
 

  /**
   * @author: ssantana, 7/12/2005, SICC-GCC-EDU-009
   * @throws java.lang.Exception
   * @return DTOParticipantesValidados
   * @param Long pais
   * @param Long curso
   * @param DTOParticipante[] lstParticipantes
   */
  private DTOParticipantesValidados validarOperacion(DTOParticipante[] 
                                                                lstParticipantes, 
                                                    Long curso, 
                                                    Long oidPais,
                                                    Long tipoCurso) throws Exception {
    
    DTOParticipante[] dtoPart = null;
    DTOParticipante[] arrayPValidos = null;
    DTOParticipante[] arrayPNoValidos = null;
    DTOParticipantesValidados dtoServidor = null;
    DTOParticipantesValidados dtoPValidados = null;
    DTOParticipante dtoPartA = null;
    DTOParticipante dtoPartB = null;
    MareBusinessID busId = new MareBusinessID("EDUObtenerParticipantesValidos");                
    Vector vParams = new Vector(); 
    Vector vValidos = new Vector();
    Vector vNoValidos = new Vector();
    
    DTOOIDs dtoOids = new DTOOIDs();
    Long[] oids = new Long[3];
    oids[0] = curso;
    oids[1] = oidPais;
    oids[2] = tipoCurso;
    traza("oidCurso: " + curso);
    traza("oidTipoCurso: " + tipoCurso);    
    traza("oidPais: " + oidPais);
    dtoOids.setOids(oids);
    
    
    vParams.add(dtoOids);
    vParams.add(busId);
    DruidaConector con = this.conectar("ConectorObtenerParticipantesValidos", 
                                       vParams);
    dtoServidor = (DTOParticipantesValidados)con.objeto("DTOParticipantes");
    dtoPart = dtoServidor.getValidos();
                          
    /*
     * Recorro la lista lstParticipantes y hago la validación 
     */
    int sizeListaParam = lstParticipantes.length;
    int sizeListaBD = dtoPart.length;
    
    for (int i = 0; i < sizeListaParam; i++ ) {
       // Tomo el elemento [i] del array por parámetro lstParticipantes.
       dtoPartA = lstParticipantes[i];
       Long oidClienteParam = dtoPartA.getOidCliente();
       
       boolean match = false;
       for (int j = 0; (j < sizeListaBD) && (!match); j++ ) {
          // Tomo el segundo elemento [j] del array obtenido en consulta.
          dtoPartB = dtoPart[j]; 
          Long oidClienteBD = dtoPartB.getOidCliente();
          if (oidClienteParam.equals(oidClienteBD)  ) {
             traza("Match en oidCliente: " + oidClienteParam);
             dtoPartA.setOidParticipante(dtoPartB.getOidParticipante());
             vValidos.add(dtoPartA);
             match = true;
          }
       }
       
       if (!match) {
         traza("No hubo match para oidCliente " + oidClienteParam);
         vNoValidos.add(dtoPartA);
       }
    }
    /*
     * Terminé de validar. 
     */
     
    arrayPValidos = (DTOParticipante[]) 
                      vValidos.toArray( new DTOParticipante[vValidos.size()] );
    arrayPNoValidos = (DTOParticipante[]) 
                      vNoValidos.toArray( new DTOParticipante[vNoValidos.size()] );
                      
    dtoPValidados = new DTOParticipantesValidados();
    dtoPValidados.setValidos(arrayPValidos);
    dtoPValidados.setNoValidos(arrayPNoValidos);
    
    return dtoPValidados;
    
 }
 
 
  /**
   * @author: ssantana, 9/12/2005, SICC-GCC-EDU-009
   * @throws java.lang.Exception
   * @return DTOParticipante[]
   * @param String sLista
   */
 private DTOParticipante[] parseaLista(String sLista) throws Exception {
    DTOParticipante[] dtoPLista = null;
    DTOParticipante dtoParticipante = null;
    Vector vector = new Vector();
    StringTokenizer st = new StringTokenizer(sLista,"#");
    while (st.hasMoreTokens()) {
       String fila = st.nextToken();
       traza("Fila: " + fila);
       StringTokenizer stFila = new StringTokenizer(fila,"@");
       traza("ACA Afuera");          
       while (stFila.hasMoreTokens()) {
          dtoParticipante=new DTOParticipante();
          traza("ACA");          
          String sNroRegistro = stFila.nextToken();
          String sFechaAsistencia = stFila.nextToken();
          String sOidCliente = stFila.nextToken();
          Integer iOidParticipante = Integer.valueOf(sNroRegistro);
          Long lOidCliente = Long.valueOf(sOidCliente);
          traza("ACA2");            
          dtoParticipante.setOidIdioma(idioma);
          dtoParticipante.setNumeroRegistro(iOidParticipante);
          dtoParticipante.setFecAsistencia(this.fecha(sFechaAsistencia));
          dtoParticipante.setOidCliente(lOidCliente);
          traza("dtoParticipante = "+dtoParticipante);
          vector.add(dtoParticipante);
        }	
        traza("ACA Afuera 2");          
    }
    dtoPLista = (DTOParticipante[]) 
                        vector.toArray( new DTOParticipante[vector.size()] );
   
   
   
   return dtoPLista;
 }
 
 
 
}