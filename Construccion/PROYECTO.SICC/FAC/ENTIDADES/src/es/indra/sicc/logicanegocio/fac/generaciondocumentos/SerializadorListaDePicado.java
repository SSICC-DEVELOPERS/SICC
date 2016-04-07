package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import es.indra.sicc.util.UtilidadesLog;

public class SerializadorListaDePicado extends FixedDocument implements ISerializableDocument
{
    public SerializadorListaDePicado()
    {
        this.MSG = new ArrayList();
    }

  public void addMensaje(String entrada)
  {
    MSG.add(entrada);
  } 
  
    public void componerDocumento(String etiquetaTotPag, String contadorTotPag)
    
    {
        UtilidadesLog.info("SerializadorListaDePicado.componerDocumento(): Entrada");
        /*String cadena = "";
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena += MSG.get(i).toString();
        }

        char[] cadenaChar = cadena.toCharArray();
        cadena = new String(cadenaChar);
        this.bufferOut = cadena.getBytes();*/
        StringBuffer cadena = new StringBuffer("");
        String aux  = null;
        String aux1 = null;
        for (int i = 0; i < MSG.size(); i++)
        {
            aux = MSG.get(i).toString();
            //UtilidadesLog.debug("aux : " + aux);
            aux1 = aux.toString().replaceAll(etiquetaTotPag, contadorTotPag);
            //UtilidadesLog.debug("aux1 : " + aux1);
            //cadena.append(MSG.get(i).toString());
            MSG.set(i, aux1);
            cadena.append(aux1);
        }
        //reemplazo la etiqueta: "####", por: cantTotaPag
        UtilidadesLog.debug("contadorTotPag: " + contadorTotPag);
        UtilidadesLog.debug("etiquetaTotPag: " + etiquetaTotPag);
        //String aux = cadena.toString();
        //aux = aux.replaceAll(etiquetaTotPag, contadorTotPag);
        //this.bufferOut = aux.getBytes();
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.info("SerializadorListaDePicado.componerDocumento(): Salida");
        
    }   
}