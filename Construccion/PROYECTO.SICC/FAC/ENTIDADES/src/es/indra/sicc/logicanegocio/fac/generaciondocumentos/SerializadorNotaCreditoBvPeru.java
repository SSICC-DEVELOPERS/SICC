package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.UtilidadesLog;

public class SerializadorNotaCreditoBvPeru extends FixedDocument implements ISerializableDocument 
{
  public SerializadorNotaCreditoBvPeru()
  {
  this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 22;
        //this.tamSecciones[1] = 41;
        //LO dejamos en 53 porque se adapta al tamaño de los documentos legales
        this.tamSecciones[1] = 54;
        this.tamSecciones[2] = 7;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
 
  }
  
   public void rellenarTabla(Hashtable documento)
    
    {
        UtilidadesLog.debug("SerializadorNotaCreditoBvPeru.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
       
        // Sección 1
        sMensaje="                                                                   PAG.<3|1> DE <3|1> ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 7);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);
        // MSG_SP
        
        sMensaje=" CAMPAÑA:<8>      EMISION:<10>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);
        
        sMensaje=" BOL. DESPACHO REF:<13>          CMP. REF:<6>    ";
        sMensaje=this.agregarSaltosLinea(sMensaje,1);
        iKey=new Integer(12);
        documento.put(iKey, sMensaje);        
        
        // La cuenta se va a cortar...Deberçia ser 11, pero se sale de la caja. 
        // Esperando respuesta de diseño.
        /* dmorello, 12/10/2006: Se elimina el RUC de la empresa */
        //sMensaje=" ZONA:<11>        CUENTA:<15>                    RUC: <11>         ";
        sMensaje=" ZONA:<11>        CUENTA:<15>                    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        
                    
        //sMensaje=" <31>                            DNI:<11>       ";
        // Modificado por incidencia 21209
        //sMensaje=" <31>                           <14>            ";
        sMensaje = " <47>                                           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <15>           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
        
        sMensaje=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        
        iKey = new Integer(4);
        documento.put(iKey, sMensaje);
        sMensaje=" <47|0|3>                                            CODIGO INTERNO: <13|1>           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|3>                                            BOLETA DESPACHO:<13|1>        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);
        
        // Sección 2
        
        sMensaje=" <4|1> <36>                                 <9>       <8|1>    <8|1>    <11|1>     ";
        //sMensaje="<4|1> <37>                                <8|1>    <8|1>    <8|1>    <11|1>     ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);
        
        //sMensaje = this.agregarSaltosLinea("", 1);
        //sMensaje +=" <80>                                                                              ";
        sMensaje =" <80>                                                                              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
        
        
        sMensaje=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(13); //modificado por Sapaza, fecha 12-12-2007, incidencia SiCC-20070527
        documento.put(iKey, sMensaje);      

       
        // Sección 3
        sMensaje=" <6|1>  UNIDADES <16|1>          <13|1>       ) <21|1>                <12|1>      ";
        //sMensaje="<6|1>  UNIDADES <17|1>          <13|1>       <22|1>               <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        iKey = new Integer(9);
        documento.put(iKey, sMensaje);
        
        
        
        sMensaje=" SON: <52|0|9>                                            ";
        sMensaje=this.agregarSaltosLinea(sMensaje,1);
        sMensaje+=" <57|0|9>                                                  S/.<20|1>              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <57|0|9>                                                 ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(10);
        documento.put(iKey, sMensaje);
        
       sMensaje=MSG_SEPARADOR;
       sMensaje=this.agregarSaltosLinea(sMensaje,1);
       iKey= new Integer(11);
       documento.put(iKey, sMensaje);
        
       UtilidadesLog.debug("SerializadorNotaCreditoBvPeru.rellenarTabla(Hashtable documento): Salida"); 
        
    }
    
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.debug("SerializadorNotaCreditoBvPeru.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++){
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorNotaCreditoBvPeru.componerDocumento(): Salida");
    } 

    
    

  
  
}