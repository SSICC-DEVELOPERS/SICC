
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
//import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cob.DTOCronogramaGenerado;
import es.indra.sicc.dtos.cob.DTOGenerarCronogramaCOBPeriodo;
import es.indra.sicc.dtos.cob.DTOEBuscarCronogramaCOBPeriodo;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;



import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOColeccion;


public class LPCronogramaCOBPeriodoModificar extends LPSICCBase
{
	private String cajaTxtInvalida = null;
// ----------------------------------------------------------------------------------------------
     public LPCronogramaCOBPeriodoModificar() {
        super();
     }	

// ----------------------------------------------------------------------------------------------     
     public void inicio() throws Exception {
        this.pagina("contenido_cronograma_cobranza_periodo_modificar");     
        this.getFormatosValidaciones();
        this.asignarAtributoPagina("cod", "0274");
     }

// ----------------------------------------------------------------------------------------------
     public void ejecucion() throws Exception 
     {  
        String sAccion = null;
        try {
            this.setTrazaFichero();
            traza("-------- Entra a LPCronogramaCOBPeriodoModificar()");
            sAccion = this.conectorParametroLimpia("accion", "", true);
            traza("sAccion: " + sAccion);
            
            if (sAccion.equals("") )
            {
              this.getConfiguracionMenu("LPCronogramaCOBPeriodoModificar", "");
              this.cargarPagina();
            }
            
            if (sAccion.equals("buscar") )
            {
              this.getConfiguracionMenu("LPCronogramaCOBPeriodoModificar", "buscar");
              this.buscar();
            }
            
            if (sAccion.equals("guardarCronograma") )
            {
              this.guardarCronograma();
            }
            
            } catch (Exception ex)
            {
              ex.printStackTrace();
              // Por si pincha en el Envia Oculto del Buscar.
              if (sAccion.equals("buscar"))
              {
                this.getConfiguracionMenu("LPCronogramaCOBPeriodoModificar", "");              
                asignarAtributo("VAR", "ejecutarError", "valor", "errorAlBuscar()");
              }
              this.lanzarPaginaError(ex);
            }
        
     }
     
// ----------------------------------------------------------------------------------------------     
     private void cargarPagina() throws Exception
     {
        traza("cargarPagina");
        Long oidPais = UtilidadesSession.getPais(this);
        Long oidIdioma = UtilidadesSession.getIdioma(this);
        
        // Cargo en var. de form. valores de Sesion.
        this.asignarAtributo("VAR", "hPais", "valor", oidPais.toString());
        this.asignarAtributo("VAR", "hIdioma", "valor", oidIdioma.toString() );
        
        // Llamo a la parte servidora para obtener Marcas y Canales
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(oidPais);
        dtoBelcorp.setOidPais(oidIdioma);
        
        ComposerViewElement cElement1 = new ComposerViewElement();
        ComposerViewElement cElement2 = new ComposerViewElement();
        ComposerViewElementList compList = new ComposerViewElementList();
        
        cElement1.setDTOE(dtoBelcorp);
        cElement1.setIDBusiness("SEGConsultaCanales");
        
        cElement2.setDTOE(dtoBelcorp);
        cElement2.setIDBusiness("SEGConsultaMarcas");
        
        compList.addViewElement(cElement1);
        compList.addViewElement(cElement2);
        
        ConectorComposerView conCompView = new ConectorComposerView(compList, this.getRequest() );
        traza("Conectando para completar Combos Canal y Marca....");
        conCompView.ejecucion();
        traza("Conexion Done!");
        DruidaConector con = conCompView.getConector();
        
        this.asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
        this.asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");              
     }
     
     
// ----------------------------------------------------------------------------------------------     
     private void buscar() throws Exception
     {
         String sMarca = this.conectorParametro("hMarca");
         String sCanal = this.conectorParametro("hCanal");         
         String sPeriodo = this.conectorParametro("hPeriodo");                  
         
         this.pagina("salidaGenerica");
         Long nIdioma = UtilidadesSession.getIdioma(this);
         Long nPais = UtilidadesSession.getPais(this);
         
         DTOEBuscarCronogramaCOBPeriodo dtoBuscarCrono = new DTOEBuscarCronogramaCOBPeriodo();
         if ( sMarca != null && !sMarca.equals("") )
           dtoBuscarCrono.setMarca(new Long(sMarca));
           
         if ( sCanal != null && !sCanal.equals("") )
           dtoBuscarCrono.setCanal(new Long(sCanal));

         if ( sPeriodo != null && !sPeriodo.equals("") )
           dtoBuscarCrono.setPeriodo(new Long(sPeriodo));
           
         dtoBuscarCrono.setOidIdioma(nIdioma);
         dtoBuscarCrono.setOidPais(nPais);
         dtoBuscarCrono.setPaginado(new Boolean(false));
         traza("dtoBuscarCrono: " + dtoBuscarCrono);
         
         MareBusinessID bussId = new MareBusinessID("COBBuscarCronogramaCOBPeriodo");
         Vector vParams = new Vector();
         vParams.add(dtoBuscarCrono);
         vParams.add(bussId);
         DruidaConector con = this.conectar("ConectorBuscarCronogramaCOBPeriodo", vParams);
         DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");      
         
         traza("DTOSalida: " + dtoSalida);
         
         RecordSet r = dtoSalida.getResultado();
         if (!r.esVacio())
         {
           String listaParseada = this.generaStringLista(r);
           this.asignarAtributo("VAR", "ejecutar", "valor", "llenaLista('" + listaParseada + "');");
         }
         
     }
     
// ----------------------------------------------------------------------------------------------     
     private void guardarCronograma() throws Exception 
     {
        traza(" ------ LPCronogramaCOBPeriodoModificar.guardarCronograma");
        DTOColeccion dtoColeccion = new DTOColeccion();
        DTOCronogramaCobranza dtoCrono = new DTOCronogramaCobranza();
        ArrayList aList = new ArrayList();
        Vector vParams = null;
        MareBusinessID bussId = null;
        
        String sOidsModificados = this.conectorParametroLimpia("oidFilaModificada", "", true);
        String sFechaCierre = this.conectorParametroLimpia("hFechaCierre", "", true);
        String sFechaEvaluacion = this.conectorParametroLimpia("hFechaEvaluacion", "", true);
        String sFechaAuditoria = this.conectorParametroLimpia("hFechaAuditoria", "", true);
        
        
        String sEdadInicial = this.conectorParametroLimpia("hEdadInicial", "", true);
        String sEdadFinal = this.conectorParametroLimpia("hEdadFinal", "", true);
        String sFechaFacturacion = this.conectorParametroLimpia("hFechaFacturacion", "", true);


        this.pagina("salidaGenerica");
        
        // Quita [ ] de sFechaEvaluacio y sFechaAuditoria
        sFechaEvaluacion = sFechaEvaluacion.substring(1, sFechaEvaluacion.length()-1);
        sFechaAuditoria = sFechaAuditoria.substring(1, sFechaAuditoria.length()-1);
        traza("sFechaEvaluacion: " + sFechaEvaluacion);
        traza("sFechaAuditoria: " + sFechaAuditoria);	
        
        traza("sFechaCierre: " + sFechaCierre);
        traza("sEdadFinal: " + sEdadFinal);
        traza("sEdadInicial: " + sEdadInicial);
        traza("sFechaFacturacion: " + sFechaFacturacion);
        
        Long[] oids = this.parseaOids(sOidsModificados);
        Long[] arrayEdadInicial = this.parseaOids(sEdadInicial);
        Long[] arrayEdadFinal = this.parseaOids(sEdadFinal);
        
        java.sql.Date[] arrayFechaCierre = this.parseaFecha(sFechaCierre);
        java.sql.Date[] arrayFechaEval = this.parseaFecha(sFechaEvaluacion);
        java.sql.Date[] arrayFechaAuditoria = this.parseaFecha(sFechaAuditoria);
        java.sql.Date[] arrayFechaFacturacion = this.parseaFecha(sFechaFacturacion);
		
		  int cantidadCiclos = 	  oids.length	  ;
   	  int i=0;
		  boolean ok =true;
		  boolean error = false;
		 

       while(ok &&  i<cantidadCiclos){
		 
        
          ok = fechasCorrectas( arrayFechaAuditoria[i], arrayFechaCierre[i], arrayFechaFacturacion[i], 
                                      arrayFechaEval[i], arrayEdadInicial[i], arrayEdadFinal[i]);
          if ( ok	){
					traza("las fechas son correctas ");
					dtoCrono = new DTOCronogramaCobranza();	 
					dtoCrono.setOidCobranza(oids[i]);

					dtoCrono.setFechaAuditoria(arrayFechaAuditoria[i]);
					traza("DTOCronogramaoid Fecha Auditoria " + arrayFechaAuditoria[i]);
					dtoCrono.setFechaCierre(arrayFechaCierre[i]);          
					traza("DTOCronogramaoid Fecha Cierrre " + arrayFechaCierre[i]);
					dtoCrono.setFechaEvaluacion(arrayFechaEval[i]);
					traza("DTOCronogramaoid Fecha Evaluacion " + arrayFechaEval[i]);

					traza("DTOCronograma a anyadir: " + dtoCrono);
					aList.add(dtoCrono);

			  }	else {
					error = true;
			  } 
			 i++;
        }
        if (ok){
			
			dtoColeccion.setLista(aList);
			bussId = new MareBusinessID("COBGuardarCronogramaCobranzas");        
			vParams = new Vector();
			vParams.add(dtoColeccion);
			vParams.add(bussId);
        
			this.conectar("ConectorGuardarCronogramaCobranzas", vParams);
		  }
        
			
        if ( error ){
          traza("No es ok, alguna fecha es invalida");
          asignarAtributo("VAR", "ejecutar", "valor", "errorAlGuardar(true," + i +",'"+this.cajaTxtInvalida+"')");
        } else{
		  	 traza("es ok, ejecutamos funcion java script");
			 asignarAtributo("VAR", "ejecutar", "valor", "errorAlGuardar(false,-1,'"+this.cajaTxtInvalida+"')");
		  }
			

     }
     
  private boolean fechasCorrectas(java.sql.Date FechaAuditoria,  java.sql.Date FechaCierre,
                                    java.sql.Date FechaFacturacion,java.sql.Date FechaEval, Long EdadInicial, Long EdadFinal )throws Exception{
	 
     traza(" ------ LPCronogramaCOBPeriodoModificar.fechasCorrectas");
     boolean ok = true;
    
      if (FechaCierre != null ){
          ok = FechaCierre.getTime() >= (FechaFacturacion.getTime() + EdadInicial.longValue() * 86400000  )  && 
            FechaCierre.getTime() <= (FechaFacturacion.getTime() + EdadFinal.longValue() * 86400000) ;      
         
          this.traza("En FechaCierre ok es : "+ok);
			 if (!ok){
						this.cajaTxtInvalida =  "fechaCierre";
			 }
      }
      
      if (FechaEval != null && ok  ){
          ok =  ok &&  ( FechaEval.getTime() >=(FechaFacturacion.getTime() + EdadInicial.longValue() * 86400000 ) &&
            FechaEval.getTime() <= (FechaFacturacion.getTime() + EdadFinal.longValue()*86400000) ) ;
            this.traza("En FechaEvaluacion ok es : "+ ok);   
				if (!ok){
						this.cajaTxtInvalida =  "fechaEval";
				}
       }
       if (FechaAuditoria !=null && ok ){
          ok =  ok &&  ( FechaAuditoria.getTime() >= (FechaFacturacion.getTime() + EdadInicial.longValue() *86400000  ) &&
              FechaAuditoria.getTime() <=(FechaFacturacion.getTime() + EdadFinal.longValue() * 86400000) ) ;
              this.traza("En FechaAuditoria ok es : "+ok);
				  if (!ok){
						this.cajaTxtInvalida =  "fechaAuditoria";
				  }
       }
       this.traza("ok termina con valor "+ok);
       return ok;
  }
// ----------------------------------------------------------------------------------------------         
    
	  private String generaStringLista(RecordSet r) throws Exception
     {
       traza("----- Metodo generaStringLista");
       StringBuffer sqlQuery = new StringBuffer("");
       BigDecimal bigBuffer = null;
       for (int i = 0; i <  r.getRowCount(); i++)
       {
           // Formato de Tupla
           // Col 0 y 1, BigDecimal
           // Col 2 - 12 String
           // Col 13 - 15 Fecha
           
           traza("Fila " + i);
           if (i != 0)
             sqlQuery.append("|");
           // Oid
           bigBuffer = (BigDecimal) r.getValueAt(i,0);
           if (bigBuffer != null) {
              traza("Oid: " + bigBuffer.toString() );           
              sqlQuery.append( bigBuffer.toString() );
           } else {
              sqlQuery.append(" ");              
              traza("Oid NULL");
            }

           sqlQuery.append("@");
           
           // ID Cart. (se debe hacer formateo de numero)
           bigBuffer = (BigDecimal) r.getValueAt(i, 1);
           if (bigBuffer != null)
           {
              String numeroFormateado = this.desFormatearNumero(bigBuffer.toString(), 
                                                                LPSICCBase.FORMATO_DEFAULT);
              sqlQuery.append(numeroFormateado);
              traza("IdCartera: " + numeroFormateado);
           } else {
              traza("IdCartera NULL");
              sqlQuery.append(" ");
           }            
           
           sqlQuery.append("@");
           
           // Del campo 2 al 11 son todos String.
           for (int j = 2; j < 12; j++)
           {
               if (j != 2)
                 sqlQuery.append("@");
                 
               String sValor = (String) r.getValueAt(i, j);
               if (sValor != null)
               {
                 sqlQuery.append(sValor);  
                 traza("Campo String " + j + ": " + sValor);
               }
               else {
                 traza("Campo String " + j + " - NULl");               
                 sqlQuery.append(" ");
               }
           }
           
           sqlQuery.append("@");
           
           // El campo 13 (cod teritorio es big decimal )
           // Incidencia 18322 pperez
           
           BigDecimal bigValor = (BigDecimal) r.getValueAt(i, 12);
           if (bigValor != null)  {
                traza("Campo BigDecimal 12:" + bigValor.toString());
                sqlQuery.append(bigValor.toString());
           } else {
                traza("Campo Big Decimal 12 NULL");
                sqlQuery.append(" ");
           }
           
           sqlQuery.append("@");
           
           // Del campo 13 al 15 son fechas
           for (int j = 13; j < 16; j++)
           {
               if (j != 13)
                 sqlQuery.append("@");
                
               java.sql.Date dateValor = (java.sql.Date) r.getValueAt(i, j);
               if (dateValor != null)
               {
                  String sFecha = this.formateaFecha(dateValor);
                  traza("Campo String " + j + ": " + sFecha);                  
                  sqlQuery.append(sFecha);
               }
               else
               {
                  traza("Campo String " + j + " NULL");
                  sqlQuery.append(" ");
               }
           }
           
            sqlQuery.append("@");
            
           for (int j = 16; j < 18; j++)
           {
             bigBuffer = (BigDecimal) r.getValueAt(i,j);
             if (bigBuffer != null) {
                    traza("Oid: " + bigBuffer.toString() );           
                    sqlQuery.append( bigBuffer.toString() );
                 } else {
                    sqlQuery.append(" ");              
                    traza("Oid NULL");
                  }  
               sqlQuery.append("@");
			  }

			  java.sql.Date dateValor = (java.sql.Date) r.getValueAt(i, 18);
        if (dateValor != null){
                  String sFecha = this.formateaFecha(dateValor);
                  traza("Campo String " +  ": " + sFecha);                  
                  sqlQuery.append(sFecha);
        }
               else
        {
                  traza("Campo String " + " NULL");
                  sqlQuery.append(" ");
        }
      }

       traza("SQL Query: " + sqlQuery.toString() );
       return sqlQuery.toString();
     }
     
 // ---------------------------------------------------------------------------------------------    
   private String formateaFecha(java.sql.Date fecha) throws Exception
   {
     traza(" Entra a FormateaFecha");
     String sFechaFormateada = null;
     String sFormatoFecha = null;
     SimpleDateFormat simpleDate = null;
     
     sFormatoFecha = UtilidadesSession.getFormatoFecha(this);
     sFormatoFecha = sFormatoFecha.replace('m', 'M');
     simpleDate = new SimpleDateFormat(sFormatoFecha);
     
     sFechaFormateada = simpleDate.format(fecha);
     
     traza("Fecha Formateada: " + sFechaFormateada);
     return sFechaFormateada;
   }     
   
   private java.sql.Date[] parseaFecha(String cadenaFechas) throws Exception
   {
      // Recibe una cadena con formato "fecha1,fecha2,fecha3,..."
      // - Las fechas se hallan en formato de sesion del usuario
      // - En cualquier momento, un espacio en blanco en lugar de una fecha
      //   indica que se debe tomar como null.
      traza(" Entra a parseaFecha");
      
      java.sql.Date[] arrayRetorno = null;
      Vector vBuffer = new Vector();
      
      StringTokenizer sTok = new StringTokenizer(cadenaFechas, ",");
      String sFormatoFecha = UtilidadesSession.getFormatoFecha(this);
      sFormatoFecha = sFormatoFecha.replace('m', 'M');
      SimpleDateFormat simpleDate = new SimpleDateFormat(sFormatoFecha);
      
      while ( sTok.hasMoreTokens() )
      {
         java.sql.Date sqlDate = null;
         String sToken = sTok.nextToken();
         if ( !sToken.equals(" ") )
         {
            java.util.Date utilDate = simpleDate.parse(sToken);
            sqlDate = new java.sql.Date( utilDate.getTime() );
            vBuffer.add(sqlDate);
         } else {
           vBuffer.add(null);
         }
      }
      arrayRetorno = (java.sql.Date[]) vBuffer.toArray(new java.sql.Date[vBuffer.size()]);
      return arrayRetorno;
   }
   
   private Long[] parseaOids(String cadenaOids) throws Exception
   {
      traza(" Entra a parseaOids");   
      
      Long[] arrayRetorno = null;
      Vector vBuffer = new Vector();
      StringTokenizer sTok = new StringTokenizer(cadenaOids, ",");
      while ( sTok.hasMoreTokens() )
      {
         String sToken = sTok.nextToken();
         vBuffer.add(new Long(sToken));
      }
   
      arrayRetorno = (Long[]) vBuffer.toArray(new Long[vBuffer.size()]);
      return arrayRetorno;
      
   }
  
}
