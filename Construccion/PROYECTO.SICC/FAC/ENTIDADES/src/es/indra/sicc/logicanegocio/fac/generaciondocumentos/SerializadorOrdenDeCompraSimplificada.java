package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorOrdenDeCompraSimplificada extends FixedDocument implements ISerializableDocument
{
  public SerializadorOrdenDeCompraSimplificada()
  {
  
        
        this.MSG = new ArrayList();
        this.numeroSecciones = 2;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 28;
        this.tamSecciones[1] = 40;
        
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
  
  }
  public void rellenarTabla(Hashtable documento)
    {
        UtilidadesLog.debug("SerializadorOrdenDeCompraSimplificada.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
        
        sMensaje = "";
        
        sMensaje = "         <15>          ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);

        sMensaje = "            <10>        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);

        sMensaje = "        <42>                                                        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);

        sMensaje = "               <30|0|3>                      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <52|0|3>                                                   ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);

        sMensaje = "           <12>                                              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(4);
        documento.put(iKey, sMensaje);
   
        UtilidadesLog.debug("SerializadorOrdenDeCompraSimplificada.rellenarTabla(Hashtable documento): Salida");      
    }   
    
    
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.debug("SerializadorOrdenDeCompraSimplificada.componerDocumento()): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++){
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorOrdenDeCompraSimplificada.componerDocumento()): Salida");
    } 
 
  
 // Añadido por la  BELC300015516
  public void addMensaje(String entrada)
  {
    MSG.add(entrada);
  } 
  
  
}