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
 
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import java.sql.Date;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.druida.DruidaConector;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.edu.DTOParticipante;

public class LPParticipantes extends LPRegistro {
          
	private String accion = null;
    private String casoUso = null;   
    private Long idioma;
    private Long pais;   
          
    public LPParticipantes() {
    	super();
    }

    public void inicio() throws Exception {
                  
    }

    public void ejecucion() throws Exception {
    	setTrazaFichero();
        try  {         
        	traza("LPParticipantes Entrada");
			pagina("contenido_cursos_participacion");  			
            this.idioma = UtilidadesSession.getIdioma(this);
            this.pais = UtilidadesSession.getPais(this);
            asignar("VAR", "idioma", idioma.toString());
        	asignar("VAR", "pais", pais.toString());
            this.accion = conectorParametroLimpia("accion","", true);
            traza("Accion definida : "+accion);

            if(this.accion.equals("")){
            	muestraPantalla();
            }else if(this.accion.equals("Registrar")){
            	registrarAsistencia(this.idioma, this.pais);
            }
                          
            traza("LPParticipantes Salida");
		}catch ( Exception e )  {
        	e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e);
        }              
	}

	private void muestraPantalla() throws Exception{
    	//Muestra la pantalla de Participantes a un curso 
		traza("LPParticipantes muestraPantalla Entrada");
		try{
			this.generarHiddenFormatoFecha();
			asignarAtributo("PAGINA","contenido_cursos_participacion", "cod", "0206");
            asignarAtributo("PAGINA","contenido_cursos_participacion", "msgle", "Registrar asistencia a cursos");
            getConfiguracionMenu("LPParticipantes", ""); 
			String oid = conectorParametroLimpia("oidSeleccionado","",true);
			asignar("VAR","oidCurso",oid);
	
		}catch ( Exception e )  {
        	e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
        }                  
        traza("LPParticipantes muestraPantalla Salida");		
	}
	
	private void registrarAsistencia(Long idioma, Long pais) throws Exception{
		//Realiza el registro de asistencia de todos aquellos participantes para los que se ha puesto fecha de asistencia.
		try{
			traza("LPParticipantes registrarAsistencia Entrada");
			this.generarHiddenFormatoFecha();
			pagina("salidaGenerica");
			asignar("VAR", "cerrarVentana", "false");
            asignar("VAR", "ejecutar", "insercionCorrecta();"); 
			
			DTORegistrarAsistencia dtoe = new DTORegistrarAsistencia();
			Vector vector = new Vector();  			 
			// se cargan valores en el dto
			dtoe.setOidPais(this.pais);
			dtoe.setOidIdioma(this.idioma);
			dtoe.setOperacion(ConstantesEDU.REG_ASIS);
			String oid = conectorParametroLimpia("oidCurso","",true);
			traza("oid seleccionado = "+oid);
			dtoe.setOidCurso(new Long(oid));
			// recorrer la lista editable y si la fecha esta rellena se guarda el elemento en un array
			StringTokenizer st = null;
			String lista = conectorParametroLimpia("lista","",true);
			traza("lista = "+lista);
			st = new StringTokenizer(lista, "#");
			int i=0;
			while (st.countTokens() > 0) {
				String fila = st.nextToken();
				if (!fila.equals("")) {
					//Obtenemos los valores de la fila
					StringTokenizer stFila = new StringTokenizer(fila, "@");
            		if (stFila.countTokens() > 0) {
						String strOidParticipante = this.cadena(stFila.nextToken());
						Long oidParticipante = new Long(strOidParticipante);
                  		String strFechaAsistencia=this.cadena(stFila.nextToken());
                  		traza("fecha = "+strFechaAsistencia);                  		
                  		String strOidTipoCliente= this.cadena(stFila.nextToken());
                   		Long oidTipoCliente = new Long(strOidTipoCliente);
                  		String strOidCliente = this.cadena(stFila.nextToken());
                  		Long oidCliente = new Long(strOidCliente);
                  		                  		
                  		//si la fecha la ha rellenado el usuario
                 		if (strFechaAsistencia!=null) {
                 			DTOParticipante dtoParticipante=new DTOParticipante();
                 			dtoParticipante.setOidIdioma(this.idioma);
                        	dtoParticipante.setOidParticipante(oidParticipante);
                        	dtoParticipante.setFecAsistencia(this.fecha(strFechaAsistencia));
                            dtoParticipante.setOidCliente(oidCliente);
                        	dtoParticipante.setOidTipoCliente(oidTipoCliente);
                        	traza("dtoParticipante = "+dtoParticipante);
                        	vector.add(dtoParticipante);
                        	
                  		} 
                  		            
						
					}                                  
				}		                
			} // fin while 
			
			//comprobamos si el vector tiene datos
            DTOParticipante dtoP[]=null;
            if (!vector.isEmpty()){
            	dtoP = new DTOParticipante[vector.size()];
            	for(int j=0; j<vector.size(); j++){
                	dtoP[j]=new DTOParticipante();
                    dtoP[j]=(DTOParticipante)vector.get(j);
               	}	
            }
                         			          
			dtoe.setParticipantes(dtoP); 
			traza("Pais ="+dtoe.getOidPais()); 
			traza("DTORegistrarAsistencia = "+dtoe);
			registro(dtoe);
			                
		}catch ( Exception e )  {
        	e.printStackTrace();
            this.logStackTrace(e);
            lanzarPaginaError(e);
        }                  	
		traza("LPParticipantes registrarAsistencia Salida");
		
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
      

}


