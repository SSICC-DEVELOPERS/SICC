package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Hashtable;

public class SerializadorDebito extends FixedDocument implements ISerializableDocument
{
  public SerializadorDebito()
  {
   
   this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 18;
        this.tamSecciones[1] = 12;
        this.tamSecciones[2] = 7;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
   
         
    }

    public void rellenarTabla(Hashtable documento){
        UtilidadesLog.info("SerializadorDebito.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
       
        // Sección 1
        sMensaje = "                                                                                ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);
        // MSG_SP
        
        sMensaje="                                   NRO CONTROL                                    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+="                                   <15>           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 5);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);
        
          
        /* dmorello, 12/10/2006: El RUC de la empresa se elimina */
        sMensaje = "";
        //sMensaje="                                                         RUC: <11>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje,3);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        
                    
        sMensaje=" CTA:<11>        REF:<10>       FEC:<10>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
        
        sMensaje=" <42>                                      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(4);
        documento.put(iKey, sMensaje);
        
        //sMensaje=" DIR: <41>                                     ";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje = " <46|0|3>                                      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <46|0|3>                                      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <46|0|3>                                      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);

        
        sMensaje=" <46|0|3>                                                                         ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        //sMensaje+=" <46|0|3>                                                                        "; 
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        //sMensaje+=" <46|0|3>                                                                        "; 
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(6);
        documento.put(iKey, sMensaje);
        
        sMensaje=" Código Interno:  <15>                                                           "; 
        //sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);
        
        // Sección 2
        
        sMensaje=" <9>        <42>                                         <5>   <9|1>     <9|1>    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
       
        // Sección 3
        
        //DBLG500000514 - @eiraola 20/04/2006 - Se incluye campo "Glosa"
        /* ************* AGREGADO ****************/
        sMensaje = this.agregarSaltosLinea("", 1);
        sMensaje+=" <81>                                                                               ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(9);
        documento.put(iKey, sMensaje);
        /* *********** FIN AGREGADO **************/
        
        sMensaje="            SON:<42|0|8>                                                           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+="            <42|0|8>                                          SUB.TOTAL <10|1>    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        //iKey = new Integer(9);
        iKey = new Integer(10);
        documento.put(iKey, sMensaje);
        
        //sMensaje="                                                   <10|1>               <10|1>   ";
        sMensaje="                                     <13|0|8>         <10|1>        19% <10|1>    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        //iKey = new Integer(10);
        iKey = new Integer(11);
        documento.put(iKey, sMensaje);
        
        sMensaje="                                     <17|0|8>         <10|1>            <10|1>    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        //iKey = new Integer(11);
        iKey = new Integer(12);
        documento.put(iKey, sMensaje);
        
        UtilidadesLog.info("SerializadorDebito.rellenarTabla(Hashtable documento): Salida");
    }
    
    // Modificado por la BELC300016798 
    public void componerDocumento(){
        UtilidadesLog.info("SerializadorDebito.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.info("SerializadorDebito.componerDocumento(): Salida");
    } 

    
    

}