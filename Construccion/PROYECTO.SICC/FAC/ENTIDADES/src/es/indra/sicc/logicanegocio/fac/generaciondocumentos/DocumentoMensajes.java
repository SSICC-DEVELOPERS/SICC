/**
 * Copyright 2004 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.fac.generaciondocumentos;


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.SerializadorMensajes;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.dtos.msg.DTOSeccion;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.FactoriaSerializador;

public class DocumentoMensajes extends DocumentoFAC  {

    private UtilidadesLog log = new UtilidadesLog(); 
    private byte [] documento;
    
    public DocumentoMensajes() {
    }
    public byte[] getDocument (){
        return documento;
    }
  
  // Modificado por la BELC300012930, BELC300015959 (ahora lanza excepci�n)
    public void componerFactura(ArrayList datosEntrada, Long oidPatron) throws MareException{
        UtilidadesLog.info("DocumentoMensajes.componerFactura(ArrayList datosEntrada, Long oidPatron): Entrada"); 
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("***oidPatron="+oidPatron);
          UtilidadesLog.debug("***datosEntrada.size="+datosEntrada.size());
        }  
        /*for(int i=0; i<datosEntrada.size(); i++){
             UtilidadesLog.debug("***mensaje["+i+"]="+((DTOImpresion)datosEntrada.get(i)).getTexto());
        }*/
          
        //RESUMEN: El objetivo de este m�todo es generar todo el documento procesando 
        //cada uno de los mensajes de las secicones que componen el patron.
    
        /*1.- Obtengo la instancia del objeto FactoriaSerializador mediante el m�todo estatico getFactoriaSerializador. 
        Crear un DTOOID con los siguientes valores: 
        DTOOID.oid = oidPatron 
        DTOOID.idioma = datosEntrada[0].idioma 
        DTOOID.pais = datosEntrada[0].pais */
    
        //Aki obtendria el objeto de FactoriaSerializador
        FactoriaSerializador factoriaSerializador = FactoriaSerializador.getFactoriaSerializador();
      
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(oidPatron);
        dtoOID.setOidIdioma(((DTOImpresion)datosEntrada.get(0)).getOidIdioma());
        dtoOID.setOidPais(((DTOImpresion)datosEntrada.get(0)).getOidPais());
    
        //Llamamos al m�todo getSerializador(DTOOID) para obtener una instancia 
        //de un serializadorMensaje con ese patron asociado.
        SerializadorMensajes serializadorMensajes = factoriaSerializador.getSerializador(dtoOID);
    
        //2.- Se obtiene el DTOPatron de nuestro serializador. 
            // a�adirEtiquetaPatron(FALSE, DTOPatron.codigo)
        DTOPatron dtoPatron = serializadorMensajes.getPatronAsociado();
  
        serializadorMensajes.a�adirEtiqueta(Boolean.FALSE, dtoPatron.getCodigo());
        
        // 3.- Por cada Seccion del patron, iremos accediendo a sus mensajes y por cada uno
        // llamaremos al m�todo addMensaje del serializador, pasandole el oidMensaje del
        // mensaje que estamos explorando y el arrayList que nos entra por cabecera. 
        // A�adido por la BELC300012930:
        // Por cada secci�n que recorramos tendremos que llamar al m�todo a�adirEtiquetaSeccion del
        // serializador: cuando empezamos a analizar una seccion lo llamamos pasandole false y
        // el valor de los atributos literalIdentificador del objeto DTOSeccion y
        // cuando analicemos el �ltimo mensaje de la secci�n lo llamamos pasandole TRUE y desMetacaracter..
  
        ArrayList listaSecciones = dtoPatron.getSecciones();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("listaSecciones: " + listaSecciones);
        
        if (listaSecciones==null)
            listaSecciones = new ArrayList();
        for(int i = 0;i<listaSecciones.size(); i++){
            DTOSeccion seccion = (DTOSeccion)listaSecciones.get(i);
            ArrayList listaMensajes = seccion.getMensajes();
            
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("i == " + i);
              UtilidadesLog.debug("seccion: " + seccion);
            }  
      
            // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
            if(seccion.getLiteralSuperiorInicio() != null)
                serializadorMensajes.a�adirEtiqueta(Boolean.FALSE, seccion.getLiteralSuperiorInicio());

            // A�adido por la BELC300012930
            serializadorMensajes.a�adirEtiqueta(Boolean.FALSE, seccion.getLiteralIdentificador());
      
            for(int j = 0; j<listaMensajes.size(); j++){
                DTOMensajeSeccion mensaje = (DTOMensajeSeccion)listaMensajes.get(j);
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("***N�mero mensaje="+j+". oidMensaje="+mensaje.getOidMensaje());
                  UtilidadesLog.debug("***N�mero mensaje="+j+". oidMensaje="+mensaje.getTexto());
                }  
                serializadorMensajes.addMensaje(mensaje,datosEntrada);
            }
            // A�adido por la BELC300012930
            // Modificado por la 
            serializadorMensajes.a�adirEtiqueta(Boolean.TRUE, seccion.getLiteralIdentificador());
            
             // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
            if(seccion.getLiteralSuperiorFin() != null)
                serializadorMensajes.a�adirEtiqueta(Boolean.TRUE, seccion.getLiteralSuperiorFin());
        }
          
        //4.---NEW Llamamos al m�todo del serializador
        //a�adirEtiquetaPatron(TRUE, DTOPatron.codigo)        
        serializadorMensajes.a�adirEtiqueta(Boolean.TRUE, dtoPatron.getCodigo());
        
        
        //5.- Una vez recorrido todo el patron secci�n por secci�n y 
        //mensaje por mensaje, se llamar� al m�todo componerDocumento 
        //para asignar lo que nos devuelve a nuestra variable documento.
        documento = serializadorMensajes.componerDocumento();
        UtilidadesLog.info("DocumentoMensajes.componerFactura(ArrayList datosEntrada, Long oidPatron): Salida"); 
    }
}