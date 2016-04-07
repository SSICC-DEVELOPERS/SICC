package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.io.File;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Hashtable;
//import serializador.Cadenas;

import es.indra.sicc.util.UtilidadesLog;

public abstract class AbstractDocument
{
  protected ArrayList MSG;
  protected byte[] bufferOut;
  
  protected char linefeed[] = {'\n','\r'};
  protected String MSG_BLANK = new String(linefeed);
  
  //protected String MSG_BLANK = "\n";
  protected String MSG_SEPARADOR = " =================================================================================";
  protected String SEPARA_INFO = "|";
  protected char INICIO_DATO = '<';
  protected char FIN_DATO = '>';
  protected int margenIzquierdo;
  protected int numeroSecciones;
  protected int[] tamSecciones;
  protected int contadorLineas;
  private Hashtable htMultilinea;
  protected Hashtable htDocumentFormat;
  protected String finDePagina="\f";
  private UtilidadesLog log = new UtilidadesLog();
    
  /**
  * Constructor de la clase
  */
    public AbstractDocument()
    {
        // Se inicia el contador de líneas
        margenIzquierdo = 0;
        contadorLineas = 0;
        htMultilinea = null;
    }

	/**
	* Añade una sección al documento, completando la anterior con líneas en blanco si existe
	* @param numeroSeccion
	*/
	public void addSeccion(int numeroSeccion)
	{
	UtilidadesLog.info("AbstractDocument.addSeccion(int numeroSeccion): Entrada");	
    completarSeccion(numeroSeccion);
    UtilidadesLog.info("AbstractDocument.addSeccion(int numeroSeccion): Salida");	
    /*
    switch (numeroSeccion)
		{
			case 1 :
				this.MSG.add(MSG_BLANK);
				this.aumentarContadorLinea();
				break;
      
			default :
				completarSeccion(numeroSeccion);
				break;
		}
	  */
  }

  public void insertarCaracterFinDePagina()
  {
    //UtilidadesLog.info("AbstractDocument.insertarCaracterFinDePagina(): Entrada");	
    this.MSG.add(this.finDePagina);
    //UtilidadesLog.info("AbstractDocument.insertarCaracterFinDePagina(): Salida");	
  }


  public void resetearContadorLineas()
  {
    contadorLineas=0;
  }


	/**
	 * Completa la sección con líneas en blanco
	 * @param nSeccion
	 */
	
  public int contarSaltosDeLinea(String mensa){
      UtilidadesLog.info("AbstractDocument.contarSaltosDeLinea(String mensa): Entrada");	
      int numLineas=0;
      char[] aux=  mensa.toCharArray();
      
      char character;
      for(int i=0; i<aux.length; i++){
            character=aux[i];
            if(character=='\n'){
                numLineas++;
            }
      }
     
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
        UtilidadesLog.debug("EL MENSAJE: "+mensa+" TIENE: "+numLineas+" LINEAS");
      UtilidadesLog.info("AbstractDocument.contarSaltosDeLinea(String mensa): Salida");	
      return numLineas;
  }
  
  
  private void completarSeccion(int nSeccion)
	{
		/*
    int lineasSeccion = 0;
		for (int i = 0; i <= nSeccion; i++)
		{
			lineasSeccion += this.tamSecciones[i];
		}
		int lineasContadas = this.contadorLineas;
		for (int j = lineasContadas; j < lineasSeccion; j++)
		{
			MSG.add(this.MSG_BLANK);
			this.aumentarContadorLinea();
		}
	*/
    UtilidadesLog.info("AbstractDocument.completarSeccion(int nSeccion): Entrada");	
    UtilidadesLog.debug("CONTADOR_LINEAS="+contadorLineas);
    UtilidadesLog.debug("TAMAÑO DE SECCION="+this.tamSecciones[nSeccion]);
    int lineasFaltantes=this.tamSecciones[nSeccion]-contadorLineas;
    for(int j =0; j<lineasFaltantes;j++)
    {
      MSG.add(" "+this.MSG_BLANK);
			this.aumentarContadorLinea(1);
    }
    this.resetearContadorLineas();
    UtilidadesLog.debug("PONGO EL NÚMERO DE LINEAS A 0");
    UtilidadesLog.info("AbstractDocument.completarSeccion(int nSeccion): Salida");	
  }

	/**
	 * Añade un mensaje mediante la clave del mensaje y sus datos
	 */
	public void addMensaje(int mensaje, ArrayList datos)
	{
        //UtilidadesLog.info("AbstractDocument.addMensaje(int mensaje, ArrayList datos): Entrada");	
		String sMensaje = "";
		Integer iKey = new Integer(mensaje);
		sMensaje = (String)this.htDocumentFormat.get(iKey);
		sMensaje = this.procesarMensaje(sMensaje, datos);
		int numSaltos= contarSaltosDeLinea(sMensaje);
    
      this.aumentarContadorLinea(numSaltos);
    
    this.MSG.add(sMensaje);
    //UtilidadesLog.info("AbstractDocument.addMensaje(int mensaje, ArrayList datos): Salida");	
	}
    
	protected String agregarSaltosLinea(String cadena, int saltos){
        //UtilidadesLog.info("AbstractDocument.agregarSaltosLinea(String cadena, int saltos): Entrada");	
		StringBuffer sRespuesta = new StringBuffer(cadena);
		for (int i = 0; i < saltos; i++){
			sRespuesta.append(" "+this.MSG_BLANK);
			//this.aumentarContadorLinea();
      
		}
		//this.aumentarContadorLinea();
        //UtilidadesLog.info("AbstractDocument.agregarSaltosLinea(String cadena, int saltos): Salida");	    
        return sRespuesta.toString();
	}

	public String toString()
	{
        UtilidadesLog.info("AbstractDocument.toString(): Entrada");	
		StringBuffer sRespuesta = new StringBuffer("");

		for (int i = 0; i < MSG.size(); i++){
			sRespuesta.append(MSG.get(i).toString());
		}
        UtilidadesLog.info("AbstractDocument.toString(): Entrada");	
		return sRespuesta.toString();
	}

    /**
     * Añade una unidad al contador de líneas añadidas 
     */
    protected void aumentarContadorLinea(int num)
    {
        contadorLineas=contadorLineas+num;
        //UtilidadesLog.debug("aumento en 1 las lineas");
    }

    protected String procesoMultilinea(String cadena, ArrayList aDatosIn)
    {
        String sRespuesta = cadena;
        ArrayList aDatos = new ArrayList();

        return sRespuesta;
    }

    /**
     * Procesa un mensaje, sustituyendo por orden los datos en su lugar
     * @param msg
     * @param datos
     * @return String
     */
    protected String procesarMensaje(String sMensaje, ArrayList aDatos)
    {
        //UtilidadesLog.info("AbstractDocument.procesarMensaje(String sMensaje, ArrayList aDatos): Entrada");	
        String sRespuesta = sMensaje;
        String sLongitud = null;
        String sDato;
        for (int j = 0; j < aDatos.size(); j++)
        {
            sDato = (String)aDatos.get(j);
            sRespuesta = agregarDatoCadena(sRespuesta, sDato);
        }
        //UtilidadesLog.info("AbstractDocument.procesarMensaje(String sMensaje, ArrayList aDatos): Salida");	
        return sRespuesta;
    }

    /**
     * Agrega un dato a una cadena en una posición, 
     * teniendo en cuenta el tamaño máximo del dato en la cadena
     * @param cadena
     * @param dato
     * @return String
     */
        protected String agregarDatoCadena(String cadena, String sDatoIn)
    {
        UtilidadesLog.info("AbstractDocument.agregarDatoCadena(String cadena, String sDatoIn): Entrada");	
        // Se buscan las posiciones de inicio y final del dato 
        ArrayList aPosIni = Cadenas.obtenerPosicionesCaracter(cadena, INICIO_DATO);
        //UtilidadesLog.debug("TAMAÑO DEL ARRAY RESULTADO: "+aPosIni.size());
        ArrayList aPosFin = Cadenas.obtenerPosicionesCaracter(cadena, FIN_DATO);
        if (aPosIni.size()>0 && aPosFin.size()>0){
            int iPosIni = ((Integer)aPosIni.get(0)).intValue();
            int iPosFin = ((Integer)aPosFin.get(0)).intValue();
            // Se extrae la información del dato
            String sInfoDato = cadena.substring(iPosIni + 1, iPosFin);
            ArrayList aInfoDato = Cadenas.extraerInfoDato(sInfoDato, SEPARA_INFO);
            String sLongMax = "";
            String sAlineacion = "" + Cadenas.AL_IZQ;
            String sDatoMultilinea = "";
            for (int i = 0; i < aInfoDato.size(); i++)
            {
                switch (i)
                {
                    case 0 :
                        sLongMax = aInfoDato.get(0).toString();
                        break;
                    case 1 :
                        sAlineacion = aInfoDato.get(1).toString();
                        break;
                    case 2 :
                        sDatoMultilinea = aInfoDato.get(2).toString();
                }
            }
            int iLongMax = Integer.parseInt(sLongMax);
            int iAlineacion = Integer.parseInt(sAlineacion);
            // Se crea la nueva cadena mediante un buffer de cadena
            StringBuffer sb = new StringBuffer();
            // Se añade la sección de cadena anterior al carácter de inicio del dato
            String sInicial = cadena.substring(0, iPosIni);
            sb.append(sInicial);
            // Se procesa el dato, adaptándolo a su longitud y alineación
            String sDato = this.procesarDato(sDatoIn, iLongMax, iAlineacion, sDatoMultilinea);
            sb.append(sDato);
            // Se añade la sección de cadena posterior al carácter de fin del dato
            String sFinal = "";
            if ((iPosIni + iLongMax) < cadena.length())
            {
                if (iLongMax > (iPosFin - iPosIni + 1))
                {
                    sFinal = cadena.substring(iPosIni + iLongMax);
                }
                else
                {
                    sFinal = cadena.substring(iPosFin + 1);
                }
            }
    
            sb.append(sFinal);
            UtilidadesLog.info("AbstractDocument.agregarDatoCadena(String cadena, String sDatoIn): Salida 1");	 
            return sb.toString();
        }else{
            UtilidadesLog.info("AbstractDocument.agregarDatoCadena(String cadena, String sDatoIn): Salida 2");	
            return cadena;
        }
    }

    /**
     * Procesa un dato, consiste en completar con blancos a la longitud máxima
     * o truncar la longitud a la longitud máxima si la longitud del dato es mayor
     * @param sDato
     * @param iLongMax
     * @param iAlineacion
     * @return String
     */
    protected String procesarDato(String sDato, int iLongMax, int iAlineacion, String sDatoMultilinea)
    {
        UtilidadesLog.info("AbstractDocument.procesarDato(String sDato, int iLongMax, int iAlineacion, String sDatoMultilinea): Entrada");	
        String sRespuesta = sDato;
        // Tratamiento multilinea
        if (sDatoMultilinea.length() > 0)
        {
            /**
             * Proceso multilinea:
             * =======================================================================================
             * 1º Buscar en la hashtable si existe algún dato con la referencia contenida en sDatoMultilinea
             * 2º Si hay alguna referencia añadirla por la izquierda al dato con un espacio intermedio
             * 3º Verificar si la cadena resultante es mayor que la longitud máxima
             * 4º Si la cadena resultante es mayor que la longitud máxima se truncará y la parte sobrante
             * 	  se añadirá con la misma referencia a la hashtable
             * 5º La cadena truncada será añadida a sRespuesta para continuar el tratamiento del dato
             */
            // Se busca referencia anterior
            String sGuardada = null;
            if (this.htMultilinea!=null&&this.htMultilinea.containsKey(sDatoMultilinea))
            {
                sGuardada = (String)this.htMultilinea.get(sDatoMultilinea);
            }
            // Se agrega la refencia anterior si existe a sRespuesta por la izquierda si no se continúa
            if (sGuardada != null)
            {
                sRespuesta = Cadenas.agregarBlanco(sGuardada, Cadenas.AL_IZQ) + sRespuesta;
            }
            // Se comprueba la longitud y se trunca la cadena si es necesario
            if (sRespuesta.length() > iLongMax)
            {
				String[] split = Cadenas.dividirCadena(sRespuesta, iLongMax);
				sRespuesta = split[0];
				// Añadimos el resto de la cadena a la hashtable
				if (htMultilinea== null) htMultilinea = new Hashtable();
				this.htMultilinea.put(sDatoMultilinea, split[1]);
            } else if(this.htMultilinea!=null) {
                // Añadido por hsanchez
                // sRespuesta entra, debe desaparecer la entrada en el Hastable
                this.htMultilinea.remove(sDatoMultilinea);
            }
        }
        if (sRespuesta.length() < iLongMax)
        {
            sRespuesta = Cadenas.completarBlancos(sRespuesta, iLongMax, iAlineacion);
        }
        else if (sRespuesta.length() >= iLongMax)
        {
            sRespuesta = sRespuesta.substring(0, iLongMax);
        }
        UtilidadesLog.info("AbstractDocument.procesarDato(String sDato, int iLongMax, int iAlineacion, String sDatoMultilinea): Salida");
        return sRespuesta;
    }

    /**
     * @param path
     * @param filename
     * @roseuid 4145879301BD
     */
    protected void saveDocument(String path, String filename) throws Exception
    {
        UtilidadesLog.info("AbstractDocument.saveDocument(String path, String filename): Entrada");
        File fichero = new File(path + filename);
        FileOutputStream fStream = new FileOutputStream(fichero);
        fStream.write(bufferOut);
        fStream.flush();
        fStream.close();
        UtilidadesLog.info("AbstractDocument.saveDocument(String path, String filename): Salida");
    }
}
