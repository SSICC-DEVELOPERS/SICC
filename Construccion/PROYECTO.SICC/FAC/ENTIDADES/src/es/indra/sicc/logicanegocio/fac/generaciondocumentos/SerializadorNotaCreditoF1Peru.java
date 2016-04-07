package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import es.indra.sicc.util.UtilidadesLog;

public class SerializadorNotaCreditoF1Peru extends FixedDocument implements ISerializableDocument
{
	// Comunes
	private String superString;
	
    /**
     * Constructor vacío
     */
    public SerializadorNotaCreditoF1Peru()
    {
        superString="";
        this.MSG = new ArrayList();
        this.numeroSecciones = 3;
        tamSecciones = new int[numeroSecciones];
        this.tamSecciones[0] = 22;
        //this.tamSecciones[1] = 40;
        //LO dejamos en 34 porque se adapta al tamaño de los documentos legales
        this.tamSecciones[1] = 54;
        this.tamSecciones[2] = 7;
        this.htDocumentFormat = new Hashtable();
        this.rellenarTabla(this.htDocumentFormat);
    }

    public void rellenarTabla(Hashtable documento)
    {
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.rellenarTabla(Hashtable documento): Entrada");
        String sMensaje;
        Integer iKey;
        
        sMensaje = "";
        
        sMensaje = "                                                                   PAG.<3|1> DE <3|1>";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 5);
        sMensaje = this.agregarSaltosLinea(sMensaje, 7);
        iKey = new Integer(0);
        documento.put(iKey, sMensaje);
        // MSG_02
        sMensaje = " CAMPAÑA:<8>      EMISION:<10>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(2);
        documento.put(iKey, sMensaje);
        // MSG_21
        sMensaje = " BOL. DESPACHO REF:<13>          CMP. REF:<6>    ";
        sMensaje=this.agregarSaltosLinea(sMensaje,1);
        iKey=new Integer(13);
        documento.put(iKey, sMensaje);
        // MSG_03
        // De tamanyo 7 no creo que entre. Preguntar a Gonzalo
        /* dmorello, 12/10/2006: Se elimina el RUC de la empresa */
        //sMensaje = " ZONA:<12>        CUENTA:<15>                            RUC: <11>       ";
        sMensaje = " ZONA:<12>        CUENTA:<15>                            ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(3);
        documento.put(iKey, sMensaje);
// Ya no existe. Ahora esta integrado en el 3        
// MSG_01
//sMensaje = "                                                       R.U.C.: <11>        ";
//sMensaje = this.agregarSaltosLinea(sMensaje, 2);
//iKey = new Integer(1);
//documento.put(iKey, sMensaje);
        // MSG_04
        sMensaje = " <47>                                                "  ;
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " RUC:<11>       ";
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
        iKey = new Integer(5);
        
        documento.put(iKey, sMensaje);
        sMensaje=" <47|0|6>                                            BOLETA DESPACHO:<13|1>         ";
        //sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        //iKey = new Integer(6);
        //documento.put(iKey, sMensaje);
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        // MSG_08
        //sMensaje="                                                     CODIGO INTERNO: <13|1>         ";
        sMensaje += " <47|0|6>                                            CODIGO INTERNO: <13|1>         ";
        sMensaje = this.agregarSaltosLinea(sMensaje,1);
        sMensaje += " <47|0|6>                                        ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        iKey = new Integer(8);
        documento.put(iKey, sMensaje);
        // MSG_11
        sMensaje=MSG_SEPARADOR;
         sMensaje=this.agregarSaltosLinea(sMensaje,1);
        iKey= new Integer(10);
        documento.put(iKey, sMensaje);
        
        
        sMensaje = " <4|1> <36>                                 <9>       <8|1>    <8|1>    <11|1>     ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(11);
        documento.put(iKey, sMensaje);
        
        //sMensaje = this.agregarSaltosLinea("", 1);
        //sMensaje +=" <81>                                                                             ";
        sMensaje = " <81>                                                                             ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(12);
        documento.put(iKey, sMensaje);
        
        sMensaje = " <6|1>  UNIDADES <16|1>          <13|1>       ) <21|1>                <12|1>      ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 4);
        iKey = new Integer(21);
        documento.put(iKey, sMensaje);
        // MSG_22
        sMensaje = " SON: <41|0|22>                                ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <46|0|22>                                     <11|1>      S/.<20|1>              ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        sMensaje += " <46|0|22>                                     ";
        sMensaje = this.agregarSaltosLinea(sMensaje, 1);
        iKey = new Integer(22);
        documento.put(iKey, sMensaje);
        
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.rellenarTabla(Hashtable documento): Salida");
    }

    /**
     * Compone el documento completo, transformándolo en un byte[] y almacenándolo en la propiedad "bufferOut"
     */
    // Modificado por la BELC300016798 
    public void componerDocumento()
    
    {
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.componerDocumento(): Entrada");
        StringBuffer cadena = new StringBuffer("");
        
        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }

        //char[] cadenaChar = cadena.toCharArray();
        //cadena = new String(cadenaChar);
        this.bufferOut = cadena.toString().getBytes();
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.componerDocumento(): Salida");
    } 

    
    
    public void componerDocumentoString()
    {
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.componerDocumentoString(): Entrada");
        StringBuffer cadena = new StringBuffer("");

        for (int i = 0; i < MSG.size(); i++)
        {
            cadena.append(MSG.get(i).toString());
        }

        superString = cadena.toString();
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.componerDocumentoString(): Salida");
    }

  public String getDocumentoString()
  {
    return superString;
  }


  protected void saveDocumentXSL(String path, String filename,String datos) throws Exception
    {
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.saveDocumentXSL(String path, String filename,String datos): Entrada");
        File fichero = new File(path + filename);
        FileOutputStream fStream = new FileOutputStream(fichero);
  
        fStream.write(datos.getBytes());
        fStream.flush();
        fStream.close();
        UtilidadesLog.debug("SerializadorNotaCreditoF1Peru.saveDocumentXSL(String path, String filename,String datos): Salida");
    }

public ArrayList getMSG()
  {
    return MSG;
  }
}
