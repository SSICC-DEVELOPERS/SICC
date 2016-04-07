package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorCuponDePagoPeru extends FixedDocument implements ISerializableDocument
{
  public SerializadorCuponDePagoPeru()
  {
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 20;
        this.tamSecciones[1] = 20;
        this.tamSecciones[2] = 20;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
  }

public void rellenarTabla(Hashtable documento)
    {
        UtilidadesLog.info("SerializadorCuponDePagoPeru.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
        
        sMensaje = "";
        
        sMensaje = " ESTADO CUENTA CONSULTORA                           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);

        sMensaje = " CONSULTORA: <10>          <45>                                          ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);

        sMensaje = " ZONA: <14>                                             CAMPAÑA:<10|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);

        sMensaje = " TERRITORIO <10>                  ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);

        sMensaje = " <72|0|4>                                                                  ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <72|0|4>                                                                   ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(4);
        documento.put(iKey, sMensaje);
   
        sMensaje = " Fecha de Estado de Cuenta al: <10>                          ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);
   
        sMensaje=" <10>       <30>                            <11|1>       <11|1>       <11|1>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(6);
        documento.put(iKey, sMensaje);
   
   
        sMensaje = " Consultora: <11>                 ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);
   
        sMensaje = " <50>                                                                        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
   
        sMensaje = " Zona: <8>       Territorio: <8>               SALDO A PAGAR:<11|1>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(9);
        documento.put(iKey, sMensaje);
   
        sMensaje=" Fecha de Estado de Cuenta al: <10>                 ";
        sMensaje= this.agregarSaltosLinea(sMensaje,1);
        iKey=new Integer(10);
        documento.put(iKey, sMensaje);
        
        sMensaje=" Fecha de Vencimiento: <10>          ";
        sMensaje= this.agregarSaltosLinea(sMensaje,1);
        iKey=new Integer(11);
        documento.put(iKey, sMensaje);
        
        sMensaje="           ";
        sMensaje= this.agregarSaltosLinea(sMensaje,1);
        iKey=new Integer(12);
        documento.put(iKey, sMensaje);
        
        UtilidadesLog.info("SerializadorCuponDePagoPeru.rellenarTabla(Hashtable documento): Salida");
    }   
    
    
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.info("SerializadorCuponDePagoPeru.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        //this.bufferOut = cadena.getBytes();
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.info("SerializadorCuponDePagoPeru.componerDocumento(): Salida");
    } 
  
    
  // Añadido por la  BELC300015516
  public void addMensaje(String entrada)
  {
    MSG.add(entrada);
  } 
}