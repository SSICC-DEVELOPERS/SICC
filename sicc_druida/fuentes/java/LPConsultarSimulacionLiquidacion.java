//$Id: LPConsultarSimulacionLiquidacion.java,v 1.1 2009/12/03 18:36:25 pecbazalar Exp $ 
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
 * 
 * Autor: Viviana Bongiovanni
 */


import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOSimulacionComisiones;
import es.indra.sicc.dtos.cob.DTOSimulacionLiquidacion;
import es.indra.sicc.dtos.cob.DTOUsuariosCobComboPerfil;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPConsultarSimulacionLiquidacion extends LPSICCBase{


	public LPConsultarSimulacionLiquidacion()  {
	  super();
	}  

	public void inicio() throws Exception {			
		pagina("Contenido_simulacion_liquidacion_consultar");
	}


	public void ejecucion() throws Exception{

		setTrazaFichero();

		String accion = conectorParametroLimpia("accion", "", true);
		Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);
		
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
		asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString());

		traza("accion: " + accion);

		try{
			if( accion.equals("")){	
				this.rastreo();
				this.getFormatosValidaciones();  		
				this.cargarPagina(true);
			}else if( accion.equals("generarLiquidacion")){
				this.getFormatosValidaciones();  				
                this.cargarPagina(false);
			}else if( accion.equals("simular")){ 
				this.simular();
			}else if( accion.equals("visualizarSimulacion")){
				this.visualizarSimulacion();
			}

	 }catch (Exception e){   

	   logStackTrace(e);
	   this.lanzarPaginaError(e);

	 }
     // Configura menu secundario
	 getConfiguracionMenu();

	}//fin ejecucion


    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            e.printStackTrace ();
         }
    }



    private void cargarPagina(boolean simulacion) throws Exception{
        traza("metodo cargarPagina()"); 

		if(!simulacion){
			traza("titulo generacion");
            asignarAtributoPagina("cod", "0265");            
		}

		// Carga de Usuario
		DTOUsuariosPerfil dtoUsuariosPerfil = new DTOUsuariosPerfil();
		dtoUsuariosPerfil.setOidPais(UtilidadesSession.getPais(this));

		MareBusinessID id = new MareBusinessID("COBObtenerUsuariosCobComboPerfil");
	    Vector paramEntrada = new Vector();
	    paramEntrada.add(dtoUsuariosPerfil);
	    paramEntrada.add(id);
	    traza("antes conector");
	    DruidaConector conectorObtenerUsuariosCobComboPerfil = conectar("ConectorObtenerUsuariosCobComboPerfil", paramEntrada);
	    traza("despues conector");

		DTOUsuariosCobComboPerfil dtoUsuarios  = (DTOUsuariosCobComboPerfil) conectorObtenerUsuariosCobComboPerfil.objeto("DTOUsuariosCobComboPerfil");

		asignar("COMBO","cbUsuarioCobranza",conectorObtenerUsuariosCobComboPerfil,"dtoSalida.usuarios_ROWSET");			

		asignarAtributo("VAR", "hTipoUsuario", "valor", dtoUsuarios.getTipoUsuario().toString());
		asignarAtributo("VAR", "hSimulacion", "valor", simulacion==true?"S":"N");
		asignarAtributo("VAR", "hFormatoFecha", "valor", UtilidadesSession.getFormatoFecha(this));

		
	    // Carga incial de combos
        traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        traza("antes de asignar los COMBOS");
        asignar("COMBO","cbEtapa",resultados,"COBObtenerEtapasUsuarioCOB");             
		asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");    
		asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");    
		
        // Valores por defecto
		Long marcaDft = UtilidadesSession.getMarcaPorDefecto(this);
        Long canalDft = UtilidadesSession.getCanalPorDefecto(this);

		asignarAtributo("VAR", "hCbMarca", "valor", marcaDft.toString());
		asignarAtributo("VAR", "hCbCanal", "valor", canalDft.toString());
    
    }  

	


    private ComposerViewElementList crearParametrosEntrada() throws Exception{
        traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();

        DTOBelcorp dtoBel = new DTOBelcorp();
        traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

        DTOOID dtoOID= new DTOOID();
        dtoOID.setOidPais(UtilidadesSession.getPais(this));

        // Etapa
		ComposerViewElement etapa = new ComposerViewElement();        
		etapa.setIDBusiness("COBObtenerEtapasUsuarioCOB");
		etapa.setDTOE(dtoOID);
        
        lista.addViewElement(etapa);

		// Marca
		ComposerViewElement marca = new ComposerViewElement();        
		marca.setIDBusiness("SEGConsultaMarcas");
		marca.setDTOE(dtoBel);
        
        lista.addViewElement(marca);

		// Canal
		ComposerViewElement canal = new ComposerViewElement();        
		canal.setIDBusiness("SEGConsultaCanales");
		canal.setDTOE(dtoBel);
        
        lista.addViewElement(canal);
		
        return lista;
    }


	private void simular() throws Exception{
		traza("metodo simular");

		pagina("salidaGenerica");

		try	{
				
			String  simulacion = conectorParametroLimpia("hSimulacion", "", true);
			
			DTOSimulacionLiquidacion dto = new DTOSimulacionLiquidacion();

			Long pais = UtilidadesSession.getPais(this);
			Long idioma = UtilidadesSession.getIdioma(this);
		
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);
			dto.setSimulacion(simulacion.equals("S")?Boolean.TRUE:Boolean.FALSE);

			// Arma las simulaciones de comisiones
		    String  regSimulacion = conectorParametroLimpia("regSimulacion","",true);
		    DTOSimulacionComisiones dtoSimulacionComisiones = null;
		    ArrayList arrLstSimulacionComisiones = new ArrayList();

		    StringTokenizer stkRegSimulacion = new StringTokenizer(regSimulacion,"|");

			String importeDeuAsignada = null;
			String importeDeuCancelada = null;

			while (stkRegSimulacion.hasMoreTokens()) {
				  String reg = stkRegSimulacion.nextToken();

				  StringTokenizer stkReg =  new StringTokenizer(reg,"#");

				  dtoSimulacionComisiones = new DTOSimulacionComisiones();

				  dtoSimulacionComisiones.setOidPais(pais);
				  dtoSimulacionComisiones.setOidIdioma(idioma);

				  traza("Rownum: " + stkReg.nextToken());
                   
				  dtoSimulacionComisiones.setCodigoUsuario(stkReg.nextToken());  
				  traza("cod Etapa: " + stkReg.nextToken());
				  dtoSimulacionComisiones.setMarca(stkReg.nextToken());
				  dtoSimulacionComisiones.setCanal(stkReg.nextToken());
                  traza("cod Periodo: " + stkReg.nextToken());

				  importeDeuAsignada = stkReg.nextToken();					
				  dtoSimulacionComisiones.setImporteDeuAsignada(importeDeuAsignada.equals(" ")?null:new BigDecimal(desFormatearNumero(importeDeuAsignada,LPSICCBase.FORMATO_MONEDA)));

                  importeDeuCancelada = stkReg.nextToken();
				  dtoSimulacionComisiones.setImporteDeuCancelada(importeDeuCancelada.equals(" ")?null:new BigDecimal(desFormatearNumero(importeDeuCancelada,LPSICCBase.FORMATO_MONEDA)));
                  String fechaAsignacion = stkReg.nextToken();
                  dtoSimulacionComisiones.setFechaCalculo(new java.sql.Date(conectorParametroFecha(fechaAsignacion).getTime()));
                  //traza("fecha asignacion: " + stkReg.nextToken());
				  dtoSimulacionComisiones.setMetodoLiquidacion(stkReg.nextToken());
				  traza("Ind liqudacion: " + stkReg.nextToken());
                  traza("Ind liqudacion grupo: " + stkReg.nextToken());
				  traza("Desc escala: " + stkReg.nextToken());
				  dtoSimulacionComisiones.setOidUsuario(new Long(stkReg.nextToken().toString()));
				  dtoSimulacionComisiones.setOidEtapa(new Long(stkReg.nextToken().toString()));
				  dtoSimulacionComisiones.setOidPeriodo(new Long(stkReg.nextToken().toString()));
				  dtoSimulacionComisiones.setOidMetodoLiquidacion(new Long(stkReg.nextToken().toString()));
				  dtoSimulacionComisiones.setOidBaseEscala(new Long(stkReg.nextToken().toString()));				  
				  dtoSimulacionComisiones.setPeriodo(stkReg.nextToken());
				  dtoSimulacionComisiones.setCodCliente(stkReg.nextToken());
				  dtoSimulacionComisiones.setEtapa(stkReg.nextToken());
   				 
				  arrLstSimulacionComisiones.add(dtoSimulacionComisiones);
			}

            traza("arrLstSimulacionComisiones: " + arrLstSimulacionComisiones);

			dto.setLiquidaciones((DTOSimulacionComisiones[])arrLstSimulacionComisiones.toArray(new DTOSimulacionComisiones[0]));


			// Llamamos al Conector con el dto creado. 
			Vector parametros = new Vector();
			MareBusinessID idBusiness = new MareBusinessID("COBSimulacionComision");

			parametros.add(dto);
			parametros.add(idBusiness);
			traza("Conectando a ConectorSimulacionLiquidacion... ");
			DruidaConector conectorSimulacionLiquidacion = conectar("ConectorSimulacionLiquidacion", parametros);
			traza("Conectó.");

			// Recibe un DTOSimulacionLiquidacion
			DTOSimulacionLiquidacion dtoSimulacion = (DTOSimulacionLiquidacion)conectorSimulacionLiquidacion.objeto("DTOSimulacionLiquidacion");
			String cadena ="";
            // Simulación - Datos a visualizar
			if(simulacion.equals("S")){			
                traza("Entro por simulación");

  			  // Levanta la modal
				cadena = armarCadena(dtoSimulacion);
				asignarAtributo("VAR", "ejecutar", "valor", "simulacionOK('" + cadena+ "')");


			} else {
  			  traza("Entro por generación");
			  // Levanta la modal
				cadena = armarCadena(dtoSimulacion);
				asignarAtributo("VAR", "ejecutar", "valor", "generacionOK('" + cadena+ "')");
			}
			

		}catch (Exception e){   		   
		   
		   asignarAtributo("VAR", "ejecutarError", "valor", "errorAlSimular()");
		   throw e;
		}
	}
    


    private void visualizarSimulacion() throws Exception{
		   traza("visualizarSimulacion");

		   pagina("contenido_simulacion_liquidacion_consultar_detalle");

		   String datosSimulacion = conectorParametroLimpia("datosSimulacion", "", true);

		   traza("datosSimulacion: " + datosSimulacion);

		   asignarAtributo("VAR", "datosSimulacion", "valor", datosSimulacion);          
		   
    }



	public static String replace(String s, String s1, String s2) {
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
        while((j = s.indexOf(s1, i)) >= 0) 
        {
            if(stringbuffer == null)
            {
                stringbuffer = new StringBuffer(s.length() * 2);
            }
            stringbuffer.append(s.substring(i, j));
            stringbuffer.append(s2);
            i = j + k - 1;
        }
        if(i != 0)
        {
            stringbuffer.append(s.substring(i));
            s3 = stringbuffer.toString();
        }
        return s3;
    }


    private String armarCadena  (DTOSimulacionLiquidacion dto) throws Exception{

	  DTOSimulacionComisiones[] dtoSimulacionComisionesArr = dto.getLiquidaciones();
	  traza("resultado Simulacion: " + dtoSimulacionComisionesArr);
   	  DTOSimulacionComisiones dtoSimul = null;
	  String cadena = "";
	  int cont = 0;
	  java.sql.Date fechaCalculoSQL = null;
	  Date fechaCalculo = null;
	  String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
	  for(int j=0; j< dtoSimulacionComisionesArr.length; j++){
	    if(j!=0) {
		  cadena = cadena + "|";
	    }
		dtoSimul = dtoSimulacionComisionesArr[j];
		traza("resultado Simulacion: " + dtoSimul);
        // Oid de la lista
     	cadena = cadena + cont + "#";
	    cont++;
		cadena = cadena + (dtoSimul.getIdLiquidacion()==null?" ":dtoSimul.getIdLiquidacion()) + "#";
     	// Fecha calculo
	    fechaCalculoSQL = dtoSimul.getFechaCalculo();					
		fechaCalculo = new Date(fechaCalculoSQL.getTime());
		cadena = cadena +  UtilidadesBelcorp.fechaFormateada(fechaCalculo ,formatoFechaPais) + "#";
		cadena = cadena + dtoSimul.getMetodoLiquidacion() + "#";
     	cadena = cadena + dtoSimul.getCodigoUsuario() + "#";
	    cadena = cadena + dtoSimul.getEtapa() + "#";
		cadena = cadena + dtoSimul.getMarca() + "#";
		cadena = cadena + dtoSimul.getCanal() + "#";
		cadena = cadena + dtoSimul.getPeriodo() + "#";
		cadena = cadena + dtoSimul.getCodCliente() + "#";

		cadena = cadena + UtilidadesBelcorp.formateaNumeroSICC(dtoSimul.getImporteDeuAsignada().toString(), this.FORMATO_DEFAULT, this) + "#";
		cadena = cadena + UtilidadesBelcorp.formateaNumeroSICC(dtoSimul.getImporteDeuCancelada().toString(), this.FORMATO_DEFAULT, this) + "#";
		
		cadena = cadena + UtilidadesBelcorp.formateaNumeroSICC(dtoSimul.getComisionCalculada().toString(), this.FORMATO_DEFAULT, this) + "#";

		if(dtoSimul.getImporteDeuAsignadaEtapaAnt()!=null){
          cadena = cadena + UtilidadesBelcorp.formateaNumeroSICC(dtoSimul.getImporteDeuAsignadaEtapaAnt().toString(), this.FORMATO_DEFAULT, this);
		} else{
		  cadena = cadena + " ";
		}
      }
      traza("cadena: " + cadena);
	  return cadena;

	}
	
}
