package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.UtilidadesLog;

public class SerializadorTextFacturaPeru1 extends FixedDocument implements ISerializableDocument
{
	   
    public SerializadorTextFacturaPeru1()
    {
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 22;
        //this.tamSecciones[1] = 40;
        //LO dejamos en 53 porque se adapta al tamaño de los documentos legales
        this.tamSecciones[1] = 54;
        this.tamSecciones[2] = 9;
      	this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
    }

    public void rellenarTabla(Hashtable documento)
    {
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
        
        sMensaje = "                                                                   PAG.<4|1> DE<4|1>";
        sMensaje = this.agregarSaltosLinea(sMensaje, 7);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);
        // MSG_02
        sMensaje = " CAMPAÑA:<8>      EMISION:<10>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        // MSG_03
        // Modificado por la BELC300018205. CUENTA pasa de 9 a 11
        sMensaje = " ZONA:<11>        CUENTA:<11>                  ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
        // MSG_01
        //sMensaje = "                                                       R.U.C.: <11>        ";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 2);
        //iKey = new Integer(1);
        //documento.put(iKey, sMensaje);
        // Se integra el MSG_01 con el MSG_05
        // MSG_05
        /* dmorello, 12/10/2006: Se elimina el RUC de la empresa */
        //sMensaje = " <47>                                                    RUC: <11|1>     ";
        sMensaje = " <47>                                                    ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(5);
        documento.put(iKey, sMensaje);
        // MSG_04
        sMensaje = " RUC:<11>        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(4);
        documento.put(iKey, sMensaje);
        // MSG_06
        sMensaje = " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(6);
        documento.put(iKey, sMensaje);
        // MSG_08
        sMensaje = " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <47|0|4>                                       ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        //sMensaje += " <47|0|4>                                       ";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <47|0|4>                                            CODIGO INTERNO: <13|1>        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        /* dmorello, 13/10/2006: Se suben una linea el codigo y la boleta */
        sMensaje += " <47|0|4>                                            BOLETA DESPACHO:<13|1>        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
        // MSG_07
        //sMensaje = "                                                     BOLETA DESPACHO:<13|1>        ";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje = this.agregarSaltosLinea("", 1);
        iKey = new Integer(7);
        documento.put(iKey, sMensaje);
        // MSG_11
        sMensaje=MSG_SEPARADOR;
         sMensaje=this.agregarSaltosLinea(sMensaje,1);
        iKey= new Integer(10);
        documento.put(iKey, sMensaje);
        
        
        sMensaje = " <4|1> <35>                                <9>       <8|1>    <8|1>    <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(11);
        documento.put(iKey, sMensaje);
        
        //sMensaje = this.agregarSaltosLinea("", 1);
        sMensaje = " <81>                                                                               ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(12);
        documento.put(iKey, sMensaje);
        // MSG_21
        sMensaje = " <6|1>  UNIDADES <16|1>          <13|1>       ) <21|1>                <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 3);
        iKey = new Integer(21);
        documento.put(iKey, sMensaje);
        // MSG_22
        sMensaje = this.agregarSaltosLinea("",1);
        sMensaje += " SON: <40|0|22>                                ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <45|0|22>                                     <11|1>      S/.<20|1>                 ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        /*
         * SICC-GCC-FAC-002 - dmorello, 18/10/2006
         * Se agregan a continuacion la percepcion y el nuevo total.
         * Se modifica la longitud de la ultima linea del total expresado en texto
         * para que el texto "PERCEPCION" tenga lugar en la posicion necesaria.
         */
        sMensaje += " <41|0|22>                                 <15>               <20|1>                 ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += "                                           <19>               <20|1>                 ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(22);
        documento.put(iKey, sMensaje);
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.rellenarTabla(Hashtable documento): Salida");
    }

    /**
     * Compone el documento completo, transformándolo en un byte[] y almacenándolo en la propiedad "bufferOut"
     */
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++){
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorTextFacturaPeru1.componerDocumento(): Salida");
    } 
    
    
}
