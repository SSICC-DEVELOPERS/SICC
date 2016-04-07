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
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.dtos.car.DTONotificar;
import es.indra.sicc.dtos.car.DTOOrden;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.String;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Vector; 

public class LPNotificarOrdenesBloqueadas extends LPSICCBase {
	String casodeuso = new String();
	private Long     lIdioma = null;
    private Long     lPais = null;
    private String   sListaSelParseada = new String();

	public LPNotificarOrdenesBloqueadas() {
    }

	public void inicio() throws Exception
	{
		pagina("contenido_ordenes_bloqueadas_notificar");
	}

	public void ejecucion() throws Exception
	{
            //accion = "" { 
            //(No hay nada que hacer, lo hace en el onLoad) 
            //}             
            //accion = "Notificar" { 
            //notificar() 
            //}             
            //accion = "Imprimir" { 
            //imprimir() 
            //}
        this.rastreo();
        setTrazaFichero();
		try{
			String sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
			lIdioma = UtilidadesSession.getIdioma(this);
			lPais = UtilidadesSession.getPais(this);
            traza(">>>> Acción................" + sAccion);
            traza(">>>> Idioma................" + lIdioma);
            traza(">>>> Pais.................." + lPais);
            
			asignarAtributoPagina("cod","0277");
               
            asignarAtributo("VAR","hidConstanteCmnTRUE","valor", ConstantesCMN.VAL_TRUE.toString() );   
            asignarAtributo("VAR","hidConstanteMAEEmail","valor", ConstantesMAE.TIPO_COMUNICACION_EMAIL.toString() );   
            
            getConfiguracionMenu("LPNotificarOrdenesBloqueadas","");
            if (sAccion.equals("Notificar"))
            {
                notificar();
            }
            
            if (sAccion.equals("Imprimir"))
            {
                imprimir();
            }

        } catch (Exception exception) 
        {
            logStackTrace(exception);
            lanzarPaginaError(exception);
        } 
     
    }
    
    private void logStackTrace(Throwable e) throws Exception 
	{
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
    
    private void notificar() throws Exception 
    {
        pagina("salidaGenerica");	/*Envio oculto!*/
        try{
        String sOid = new String ();
        String sNumSolicitud = new String ();
        String sCodGerenteZona = new String ();
        String sComunicacion = new String ();
        
        Vector lVecOids =  new Vector();
        String sCodClie =  new String ();
        String sMedioCom = new String ();
        String sGrupoSol = new String ();
        String sStatus = new String ();
        String sMontoOrden = new String ();
        String sMtoDeudaVen = new String ();
        String sRes1 = new String ();
        String sRes2 = new String ();
        String sRes3 = new String ();
        String sRes4 = new String ();
        String sCodM = new String ();
        
        String sCodTipoCom = new String();
        
        //Se crea el DTONotificar dtoEMail 
        //Se crea el DTOOIDs dtoTfnoFax 
        DTONotificar dtoEMail = new DTONotificar();
        DTOOIDs dtoTfnoFax = new DTOOIDs();
        String sDetSolicitudes = conectorParametro("hidDetalleSolicitudes")==null?"":conectorParametro("hidDetalleSolicitudes");
        
        StringTokenizer stRows = new StringTokenizer(sDetSolicitudes, "$");
//Por cada fila de lstSolicitudes 
        ArrayList listaOrdenes = new ArrayList ();
    //Si lstSolicitudes(i) está seleccionada 
        for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
            StringTokenizer stColss = new StringTokenizer(stRows.nextToken(), "|");
//            sListaSelParseada = sListaSelParseada +"$" ;
            for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
                StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");
               
                for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                    String desc = stCols.nextToken().toString();
                    String valor = stCols.nextToken().toString();
                    
                     if(desc.equals("oid"))
                        sOid = valor;
                    if(desc.equals("cc"))
                        sCodClie = valor;
                    if(desc.equals("mc"))
                        sMedioCom = valor;
                    if(desc.equals("gs"))
                        sGrupoSol = valor;
                    if(desc.equals("es"))
                        sStatus = valor;
                    if(desc.equals("mo"))
                        sMontoOrden = valor;
                    if(desc.equals("md"))
                        sMtoDeudaVen = valor;
                    if(desc.equals("r1"))
                        sRes1 = valor;
                    if(desc.equals("r2"))
                        sRes2 = valor;
                    if(desc.equals("r3"))
                        sRes3 = valor;
                    if(desc.equals("r4"))
                        sRes4 = valor;
                    
                    if(desc.equals("oid"))
                        sOid = valor;
                    if(desc.equals("ns"))
                        sNumSolicitud = valor;
                    if(desc.equals("gz"))
                        sCodGerenteZona = valor;
                    if(desc.equals("co"))
                        sComunicacion = valor;
                    if(desc.equals("cm"))                    
                        sCodM =  valor;
                }
            }
				
				traza("codigo medio de comunicacion: " + sCodM);

            if (sCodM.equals(ConstantesMAE.CODIGO_TIPO_COMUNICACION_EMAIL.toString()) )
            {   
                traza("--- Comunicacion EMAIL ---");
                DTOOrden dtoOrden=  new DTOOrden();
                dtoOrden.setOidIdioma(lIdioma);
                dtoOrden.setOidPais(lPais);
                dtoOrden.setOid(Long.valueOf(sOid));
                String numSol = this.desFormatearNumero(sNumSolicitud,this.FORMATO_DEFAULT);
                dtoOrden.setNumSolicitud(Long.valueOf(numSol));
                dtoOrden.setCodGerenteZona(sCodGerenteZona);
                dtoOrden.setComunicacion(sComunicacion);
                listaOrdenes.add(dtoOrden);
					 traza("dtoOrden a enviar  " + dtoOrden);                    
            }
            else 
            {
                sCodTipoCom = ConstantesMAE.CODIGO_TIPO_COMUNICACION_TFNO;
					 
					 traza("ConstantesMAE.TIPO_COMUNICACION_TFNO = " + ConstantesMAE.CODIGO_TIPO_COMUNICACION_TFNO);
					 traza("ConstantesMAE.TIPO_COMUN_TFNO = " + ConstantesMAE.CODIGO_TIPO_COMUNICACION_FAX.toString());
                
					 if (sCodM.equals(sCodTipoCom.toString()) ||
                    sCodM.equals(ConstantesMAE.CODIGO_TIPO_COMUNICACION_FAX.toString()))
                {
                    traza("--- Comunicacion TEL-FAX ---");
                    lVecOids.add(new Long(sOid));
                }//Fin del Si
            }
          
            String sAux = "";
            if (sCodM.equals(sCodTipoCom.toString()) ||
                        sCodM.equals(ConstantesMAE.CODIGO_TIPO_COMUNICACION_FAX.toString()))
            {
                sAux = sOid + "|" + sCodClie + "|" + sMedioCom + "|" + sComunicacion +"|"+
                sGrupoSol + "|" + sStatus + "|" + sNumSolicitud +"|"+
                sMontoOrden + "|" + sMtoDeudaVen + "|" +
                sRes1 + "|" + sRes2 + "|" + sRes3 + "|" + sRes4 + "|" +
                sCodGerenteZona +"|"+ sCodM;
                sListaSelParseada = sListaSelParseada +"$" + sAux;
            }
           
         /*------------------*/   
        }//Fin del Bucle for
     

        if (!listaOrdenes.isEmpty())
        {
        //Si dtoEMail.ordenes tiene algún elemento (hay que hacer notificaciones por e-mail) 
            dtoEMail.setOrdenes(listaOrdenes);
            dtoEMail.setOidIdioma(lIdioma);
            dtoEMail.setOidPais(lPais);

                //IdNegocio = "CARNotificarMail" 
                MareBusinessID id = new MareBusinessID("CARNotificarMail");
                //Se invoca el conector ConectorNotificarMail 
                Vector paramEntrada = new Vector();
                paramEntrada.add(dtoEMail);
                paramEntrada.add(id);

                DruidaConector conSalida = conectar("ConectorNotificarMail",paramEntrada);
                traza("conSalida NotificarMail......." + conSalida);
        }//Fin del Si 


		traza("lVecOids: " + lVecOids.size());
        
        if (!lVecOids.isEmpty())
        {
            //Si dtoTfnoFax.oids tiene algún elemento (hay que hacer notificaciones por teléfono y/o fax) 
            Long[] lOids = new Long[lVecOids.size()];
            for (int i = 0; i < lOids.length; i++) {
                lOids[i] = (Long)lVecOids.elementAt(i);
            } 
            
            dtoTfnoFax.setOids( lOids);
            dtoTfnoFax.setOidIdioma(lIdioma);
            dtoTfnoFax.setOidPais(lPais);
                
            //IdNegocio = "CARNotificarTfnoFax"
            MareBusinessID id = new MareBusinessID("CARNotificarTfnoFax");
            //Se invoca el conector ConectorNotificarTfnoFax 
            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoTfnoFax);
            paramEntrada.add(id);

			traza("entra conector");
            DruidaConector conSalida = conectar("ConectorNotificarTfnoFax",paramEntrada);
            traza("conSalida NotificarTfnoFax......." + conSalida);
            
            cargaTfnoFax();
        }//Fin del Si 
        //Refrescar la lista lstSolicitudes
        asignarAtributo("VAR","ejecutar","valor","accionMensajeDeExito()");
    }catch(Exception ex)
    {
        asignarAtributo("VAR","ejecutarError","valor","accionError()");
        throw ex;
    }  
    }
    
    private void cargaTfnoFax() throws Exception 
    {
        String sDetSolicitudes = conectorParametro("hidDetalleSolicitudes")==null?"":conectorParametro("hidDetalleSolicitudes");

        //Carga la pantalla PaginaNotificarTfnoFax. 
        pagina("contenido_ordenes_bloqueadas_notificar_detalle");
		getConfiguracionMenu("LPNotificarOrdenesBloqueadas","");
        asignarAtributo("VAR","hidDetalleSolicitudes","valor", sListaSelParseada);
        
        asignarAtributo("VAR","hidConstanteMaeComFax","valor", ConstantesMAE.CODIGO_TIPO_COMUNICACION_FAX.toString() );
        //Por cada fila seleccionada en lstSolicitudes de PaginaNotificarOrdenesBloqueadas 
        //Carga la fila en la lista lstSolicitudes de PaginaNotificarTfnoFax 
        //Fin del Bucle 
        
        //Muestra la pantalla modal PaginaNotificarTfnoFax
    }
    
    private void imprimir() throws Exception 
    {
        //Muestra la pantalla modal PaginaImprimirNotificacion cargando en los 
        //label de la página los datos de las columnas correspondientes de la 
        //fila seleccionada en lstSolicitudes.
        String sDetSel = conectorParametro("hidDetalleSel")==null?"":conectorParametro("hidDetalleSel");

        pagina("contenido_ordenes_bloqueadas_notificar_2");
        getConfiguracionMenu("LPNotificarOrdenesBloqueadas","");
        String sOid ="";
        String sCodClie ="";
        String sMedioCom = "";
        String sGrupoSol = "";
        String sStatus = "";
        String sNumSolicitud ="";
        String sCodGerenteZona ="";
        String sComunicacion ="";  
        String sMontoOrden ="";  
        String sR1 ="";  
        String sR2 ="";  
        String sR3 ="";  
        String sR4 ="";  
        String sDeudaVen = "";
        
        StringTokenizer stColss = new StringTokenizer(sDetSel, "|");
        for(int conta =  0 ;stColss.hasMoreTokens(); conta++){								
            StringTokenizer stCols = new StringTokenizer(stColss.nextToken(), ":");				
            sListaSelParseada = sListaSelParseada +"$" + sListaSelParseada;
            for(int contad =  0 ;stCols.hasMoreTokens(); contad++){
                String desc = stCols.nextToken().toString();
                String valor = stCols.nextToken().toString();
                //traza(desc + " " + valor);
                sListaSelParseada = sListaSelParseada + "|"+ valor;
        
                if(desc.equals("oid"))
                    sOid = valor;
                if(desc.equals("cc"))
                    sCodClie = valor;
                if(desc.equals("mc"))
                    sMedioCom = valor;    
                if(desc.equals("gs"))
                    sGrupoSol = valor;
                if(desc.equals("es"))
                    sStatus = valor;
                if(desc.equals("ns"))
                    sNumSolicitud = valor;
                if(desc.equals("co"))
                    sComunicacion = valor;
                if (desc.equals("md"))    
                    sDeudaVen = valor;
                if (desc.equals("mo"))
                    sMontoOrden = valor;
                if (desc.equals("r1"))
                    sR1 = valor;
                if (desc.equals("r2"))
                    sR2 = valor;
                if (desc.equals("r3"))
                    sR3 = valor;
                if (desc.equals("r4"))
                    sR4 = valor;
                if(desc.equals("gz"))
                    sCodGerenteZona = valor;    
            }
        }
        
        
        asignarAtributo("VAR","codClie","valor", sCodClie);
        asignarAtributo("VAR","medioCom","valor", sMedioCom );
        asignarAtributo("VAR","grupoSol","valor", sGrupoSol );
        asignarAtributo("VAR","status","valor", sStatus);
        asignarAtributo("VAR","SolEntre","valor", sNumSolicitud);
        asignarAtributo("VAR","montoOrden","valor", sMontoOrden);
        asignarAtributo("VAR","deudaVencida","valor", sDeudaVen);
        asignarAtributo("VAR","r1","valor", sR1);
        asignarAtributo("VAR","r2","valor", sR2);
        asignarAtributo("VAR","r3","valor", sR3);
        asignarAtributo("VAR","r4","valor", sR4);
        asignarAtributo("VAR","gteZona","valor", sCodGerenteZona);

    }
}
