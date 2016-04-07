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

package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.dtos.msg.DTOMensajeSeccion;
import es.indra.sicc.dtos.msg.DTOPatron;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.Parseador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorMensajes extends VariableDocument implements ISerializableDocument
{
  
  private DTOPatron patronAsociado;
  private Hashtable tablaDeMensajes;
  static private SerializadorMensajes singleton = null;
  // Constantes añadidas por la BELC300012930
  static final String textoEtiquetaMSG = "msg"; 
  static final String textoEtiquetaSEC = "seccion"; 
  private UtilidadesLog log = new UtilidadesLog(); 
  
   SerializadorMensajes(DTOOID oidPatron)
  {
 /* ENTRADA: DTOOID (el atributo oid es un oidPatron que nos da información sobre que patron tiene que tener asociado esta instancia). 
SALIDA: 
RESUMEN: Es el constructor de la clase SerializadoMensaje. Al crearse se inicializan el atributo MSG y al atributo patronAsociado se le asigna un DTOPatron que optendremos mediante un DAO 

1.- patronAsociado = Llamamos al método recuperarEstructuraPatron (DTOE), que nos 
devolverá un DTOPatron que asignaremos a nuestro atributo patronAsociado. 
2.- Creamos unas nueva instancia del atributo MSG // this.MSG = new ArrayList();*/

//Inicidencia BELC300011467
        UtilidadesLog.debug(" ***Constructor SerializadorMensajes: Entrada");
        this.MSG = new ArrayList();
		DAOPatron dao= new DAOPatron();
		try{
            UtilidadesLog.debug(" ***Antes del ejecutar el metdo DAOPatron.recuperarEstructuraPatron");        
            patronAsociado = dao.recuperarEstructuraPatron(oidPatron);
            UtilidadesLog.debug(" ***Despues de ejecutar el metdo DAOPatron.recuperarEstructuraPatron");
		} catch(Exception e){
            UtilidadesLog.error("ERROR",e);
		}
		//this.MSG = new ArrayList();
  
  }

  



  
  //Cambios nuevo diseño. Modificado por la BELC300012930, BELC300015959
  // Modificado por BELC300019229
  public void addMensaje(DTOMensajeSeccion mensaje, ArrayList datos) throws MareException
	{
	//ENTRADA: mensaje : DTOMensajeSeccion, datos : ArrayList (contiene objetos del tipo DTOImpersion) 
	//SALIDA: 
	//RESUMEN: El objetivo de este método es procesar un mensaje perteneciente a una seccion de un patrón. 
	//Consiste en analizar el mensaje, detectar el tipo (G1 o G2), y si es G1 sustituir los datos variables que contenga. 
	 if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
	   UtilidadesLog.debug("SerializadorMensajes.addMensaje(DTOMensajeSeccion mensaje, ArrayList datos): Entrada");
		

	//1.- Recuperamos en el ArrayList datos los DTOImpresion que tenga el oid de mensaje (puede haber de 0 a n). 
	
	boolean encontrado = false;
    Parseador parse = null;
    String cadena = null;

	for (int i=0;i<datos.size();i++){
    if (((DTOImpresion)datos.get(i)).getOidMensaje().longValue() == mensaje.getOidMensaje().longValue()){

		//2.1. Consultamos si el oidTipoMensaje del DTOImpresion es G1 (ver interfaces.MSG.constantes.TIPO_G1) 
			if(((DTOImpresion)datos.get(i)).getOidTipoMensaje().longValue() == ConstantesMSG.OID_TIPO_G1.longValue()){
			//- nos creamos una instancia del objeto Parseador y llamamos a su método sustituriEtiquetasVariables(texto : String, datos : DTOImpresion), pasandole como primer parámetro mensaje.texto y como segundo el objeto DTOImpresion que corresponda a la vuelta del bucle. 
			//- a nuestro atributo MSG le añadimos el String devuelto por el método sustituirEtiquetaVariable del paso anterior. 
				//parse = new Parseador();
                parse = Parseador.getInstance();
            
                // Modificado por BELC300012930
                DTOImpresion dtoImpresion = (DTOImpresion)datos.get(i);
		if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("Este es el texto fijo del mensaje " +  dtoImpresion.getOidMensaje() + " : "  + dtoImpresion.getTexto());
                
                // dmorello, 19/07/2006: Del DTO que viene de MSG omo el texto del mensaje
                //cadena = parse.sustituirEtiquetasVariables(mensaje.getTexto(),((DTOImpresion)datos.get(i)));
                cadena = parse.sustituirEtiquetasVariables(dtoImpresion.getTexto(),dtoImpresion);
		if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug(" Esta es la cadena devuelta: " + cadena);
                this.MSG.add(cadena);
			}else{
				//a nuestro atributo MSG le añadimos mensaje.texto directamente 

                // Modificado por BELC300012930
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug("Este es el texto fijo del mensaje " +  mensaje.getOidMensaje() + " : "  + mensaje.getTexto());
                cadena = new String(mensaje.getTexto());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                  UtilidadesLog.debug(" Esta es la cadena devuelta: " + cadena);

				this.MSG.add(cadena);
			}

    	    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("Mensaje imprimido="+mensaje.getOidMensaje());
	  }
	}
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
	  UtilidadesLog.debug("SerializadorMensajes.addMensaje(DTOMensajeSeccion mensaje, ArrayList datos): Salida");
  }
  


  public byte[] componerDocumento()
  {
    //Incidencia BELC300011466 modifica el diseño.	
    /*ENTRADA:
    SALIDA: byte[]
    RESUMEN: Este método asigna a nuestra variable bufferOut[] el contenido del ArrayList MSG. Es decir, procesa
    todos los Strings que componen el mensaje y los concatena a un solo array de bytes
    
    1.- Declaramos una variable salida de tipo String inicialmente vacia
    2.- Recorremos el ArrayList MSG 
        1.1.- Consultamos cada posicion(indice) de MSG q será un String
        1.2.- La concatenamos a la variable salida  
    3.- Devolvemos la variable salida transformada a byte[]
    Ahora se concatena todo es un String y luego se transforma en byte[] para devolverlo*/

        UtilidadesLog.debug("SerializadorMensajes.componerDocumento(): Entrada"); 
		StringBuffer salida = new StringBuffer("");

        for (int i = 0; i < this.MSG.size(); i++)
        {
            salida.append(MSG.get(i).toString());
            //salida.append("\n\r");
        }
        this.bufferOut = salida.toString().getBytes();
        MSG.clear();
        UtilidadesLog.debug("SerializadorMensajes.componerDocumento(): Salida"); 
		return bufferOut;
    }

    // Añadido por la 12930
    // Modificado por la BELC300019229
    public void añadirEtiqueta(Boolean fin, String descripcion) {
        UtilidadesLog.debug("SerializadorMensajes.añadirEtiqueta(Boolean fin, String descripcion): Entrada"); 
        // ENTRADA: fin: boolean, codigo: String, descripcion: Stirng
        // SALIDA:
        // RESUMEN: El objetivo de este método es concatenar las etiquetas de sección al texto.
        
        StringBuffer cadena = null;
        if (descripcion == null)
            return;
        if(fin.booleanValue()==true){
            cadena = new StringBuffer().append("</").append(descripcion).append(">");
        } else {
            cadena = new StringBuffer().append("<").append(descripcion).append(">");
            //cadena = "<"+descripcion+">";
        }
        
        this.MSG.add(cadena.toString());
    	UtilidadesLog.debug("SerializadorMensajes.añadirEtiqueta(Boolean fin, String descripcion): Salida"); 
    }

	public DTOPatron getPatronAsociado() {
		return patronAsociado;
	}

	public void setPatronAsociado(DTOPatron newPatronAsociado) {
		patronAsociado = newPatronAsociado;
	}
        
}