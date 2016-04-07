package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.UtilidadesLog;

public class SerializadorBoletaVentaPeru extends FixedDocument implements ISerializableDocument 
{
  public SerializadorBoletaVentaPeru()
  {
  this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 22;
        //this.tamSecciones[1] = 39;
        //this.tamSecciones[1] = 41;
        //LO dejamos en 34 porque se adapta al tamaño de los documentos legales
        this.tamSecciones[1] = 54;
        this.tamSecciones[2] = 9;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
 
  }
  
   public void rellenarTabla(Hashtable documento)
    {
        UtilidadesLog.info("SerializadorBoletaVentaPeru.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
       
        // Sección 1
        sMensaje="                                                                   PAG <3|1> DE <3|1>";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 5);
        sMensaje = this.agregarSaltosLinea(sMensaje, 7);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);
        // MSG_SP
        
        sMensaje=" CAMPAÑA:<9>      EMISION:<10>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(1);
        documento.put(iKey, sMensaje);
        
          
        sMensaje=" ZONA:<11>        CUENTA:<15>           ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        
                    
        //sMensaje=" <47>                                                        RUC:<10|1>    ";
        sMensaje = " <47>                                                        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        //sMensaje +=" DNI:<12>        ";
        sMensaje +=" <15>           ";
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
        
        //incidencia 21230
        sMensaje=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                            CODIGO INTERNO: <13|1>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <47|0|4>                                            BOLETA DESPACHO:<13|1>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);
        
        //antes incidencia 21230
        /*sMensaje="                                                     BOL. DESPACHO   <13|1>       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(6);
        documento.put(iKey, sMensaje);*/
        
        // Sección 2
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
        iKey = new Integer(13);
        documento.put(iKey, sMensaje);      
        
        
        sMensaje=" <4|1> <36>                                 <9>       <8|1>    <8|1>    <11|1>     ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);
        
        //sMensaje = this.agregarSaltosLinea("", 1);
        sMensaje = " <80>                                                                              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
        // Sección 3
        
        //sMensaje=" <6|1>  UNIDADES <16|1>           <13|1>        <21|1>                <12|1>      ";
        sMensaje=" <6|1>  UNIDADES <16|1>          <13|1>       ) <21|1>                <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        iKey = new Integer(9);
        documento.put(iKey, sMensaje);        
        
        sMensaje=" SON:<53|0|9>                                             ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+=" <57|0|9>                                                  S/.<20|1>              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        // SICC-GCC-FAC-002 - dmorello, 20/10/2006: Se agregan la percepcion y el nuevo total
        sMensaje+=" <41|0|9>                                  <15>               <20|1>              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje+="                                           <19>               <20|1>              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(10);
        documento.put(iKey, sMensaje);
        
       sMensaje=MSG_SEPARADOR;
       sMensaje=this.agregarSaltosLinea(sMensaje,1);
       iKey= new Integer(11);
       documento.put(iKey, sMensaje);
       
       sMensaje=MSG_SEPARADOR;
       sMensaje=this.agregarSaltosLinea(sMensaje,1);
       iKey= new Integer(12);
       documento.put(iKey, sMensaje);

       UtilidadesLog.info("SerializadorBoletaVentaPeru.rellenarTabla(Hashtable documento): Salida"); 
        
    }
    
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.info("SerializadorBoletaVentaPeru.componerDocumento(): Entrada");
        /*String cadena = "";
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena += MSG.get(i).toString();
        }

        char[] cadenaChar = cadena.toCharArray();
        cadena = new String(cadenaChar);
        this.bufferOut = cadena.getBytes();*/
        StringBuffer cadena = new StringBuffer("");
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }
        this.bufferOut = cadena.toString().getBytes();
        
        UtilidadesLog.info("SerializadorBoletaVentaPeru.componerDocumento(): Salida");
    } 

    
    

  
  
}