//import AdaptadorConectorPaginacion;
//import DruidaTransactionComun;

import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaConectorException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.util.UtilidadesSession;

import java.sql.Date;

import java.text.*;

import java.util.StringTokenizer;
import java.util.Vector;

public class DTBuscarCliente extends DruidaTransactionComun {
	
	
    public static String TOKEN_VACIO = " ";
    /*this.SEPARADOR_PARAMETROS 
	this.NOMBRE_SESION_PAIS
	this.NOMBRE_SESION_IDIOMA
	this.NOMBRE_DTO_PAIS
	this.NOMBRE_DTO_IDIOMA
	*/
	private String posicion;
	private String parametros;

	/*public void DTBuscarCliente()
	{
		try
		{
			
			//write("Constructor");
    		String posicion = (String) getEntrada("oidE");
  			String parametros = (String) getEntrada("parametros");
			//write("Obtuvo params");
			this.ejecucion();

		}
		catch (Exception ex)
		{
			//write("Excepcion: " + ex);
		}

	}*/

/*    public void inicio() throws Exception  {
		//write("1");
        setParsear();
		//write("2");
        org.w3c.dom.Document document = getParser().convierte("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><PAGINA></PAGINA>");
		//write("3");
        setXML(document);
		//write("4");
        setTrazaFichero();
		//write("5");
        setTrazaWeb();
		//write("INICIO");
    }*/


		public void ejecucion() throws Exception
	{    
			//write("Entro a Ejecucion");
			
		setTrazaFichero();
   		try {
    		//Obtengo los parámetros
			traza("entre a DTBuscarCliente");
    		String posicion = (String) getEntrada("oidE");
  			String parametros = (String) getEntrada("parametros");
			traza("posicion: " + posicion);
			traza("parametros: " + parametros);

			//obtenemos el tamaño configurado de la pagina
			int pageSize =  this.getPageSize();
			Integer page = new Integer(pageSize);
			//traza("pageSize: " + page.toString() );


			//short posicionS = Short.valueOf(posicion).shortValue();//( (posicion.length()>2)?null:Short.valueOf(posicion).shortValue() );
/*			Long pos = new Long(posicion);
			pos = new Long( pos.longValue() * page.longValue() );
			traza("posicion relativa: " + posicion);
			traza("posicion real: " + pos.toString() );*/
			
			//obtenemos DTOCliente
			DTOCliente dtoClie = new DTOCliente();
			dtoClie = creardtoCliente(Long.valueOf(posicion), page, parametros);
			//dtoClie = creardtoCliente(pos, page, parametros);

			//conectamos con el ConectorBusquedaClientes
			MareBusinessID id;
			DruidaConector conectorBCliente;
			Vector paramEntrada  = new Vector();
			id = new MareBusinessID("MAEBusquedaClientes");
			paramEntrada.add(dtoClie);
			paramEntrada.add(id);
/*			paramEntrada.addElement(dtoClie);
			paramEntrada.addElement(id);*/

			traza("Antes de conectar");
			conectorBCliente = conectar("ConectorBusquedaClientes",paramEntrada);
			traza("Luego de conectar");
			traza("conector: " + conectorBCliente.getXML() );
			
			//creamos la clase AdaptadorConectorPaginacion
			traza("pageSize: " + pageSize);
			//traza("posicionS: " +  posicionS);



			//AdaptadorConectorPaginacion adapatador = new AdaptadorConectorPaginacion(conectorBCliente, pageSize, posicionS);
			AdaptadorConectorPaginacion adapatador = new AdaptadorConectorPaginacion(conectorBCliente, pageSize, new Long(0).shortValue());
			//AdaptadorConectorPaginacion adapatador = new AdaptadorConectorPaginacion(conectorBCliente, pageSize, pos.shortValue() );
			DruidaConector dc = adapatador.obtenerConectorPaginacion();
			setConector(dc);

		} catch (Exception e) {
				traza(e);
				throw new DruidaConectorException(obtenerMensajeError(e));
   	}

    }


private DTOCliente creardtoCliente(Long posicion, Integer pageSize, String parametros) throws Exception{
		traza("entre a DTBuscarCliente creardtocliente");
			DTOCliente dtoClie = new DTOCliente();
      parametros = " " + parametros;
			StringTokenizer stk = new StringTokenizer(parametros,SEPARADOR_PARAMETROS);
			traza("Nro. parametros: "+stk.countTokens());
			traza("parametros: " + parametros);
			//stk.countTokens()
			
			//while (stk.hasMoreTokens()){            
            DTOCrearClienteBasico dtoCrearCliBas = new DTOCrearClienteBasico();
            String strSTK = tokenizar(stk);
            traza("paso 1 ");

            Vector vec = new Vector();
            traza("paso 2 " + strSTK);
            if(!(strSTK.equals(" "))){
                vec = obtieneTipos(strSTK);

                RecordSet rTipos    = new RecordSet();
                traza("paso 3 ");
                RecordSet rSubTipos = new RecordSet();
                traza("paso 4 ");
            
                rTipos    = (RecordSet)vec.get(0);
                traza("paso 5");
                rSubTipos = (RecordSet)vec.get(1);
                traza("paso 6");
            

                int cantDto = 0;
                traza("paso 7");
                for (int i=0 ;i < rTipos.getRowCount() ; i++)  {
                  traza("paso 8  y " + i);
                  cantDto++;
                }

                DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[cantDto];
                traza("paso 9");
            
                for (int i=0 ;i < rTipos.getRowCount() ; i++){
                   traza("paso 10");
                   dtoTipoSubClie[i]= new DTOTipoSubtipoCliente();
                   traza("paso 11 " + rTipos.getValueAt(i, 0));
                   dtoTipoSubClie[i].setTipo( ((String)rTipos.getValueAt(i, 0)).equals(TOKEN_VACIO)?null:new Long( (String)rTipos.getValueAt(i, 0)) );
               
                   traza("paso 12");
            
                }
                for (int i=0 ;i < rSubTipos.getRowCount() ; i++){
                   //dtoTipoSubClie[i]= new DTOTipoSubtipoCliente();
                   dtoTipoSubClie[i].setSubtipo( ((String)rSubTipos.getValueAt(i, 1)).equals(TOKEN_VACIO)?null:new Long( (String)rSubTipos.getValueAt(i, 1)) );
              
                }

            
                //DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[1];
                //dtoTipoSubClie[0]= new DTOTipoSubtipoCliente();
                //String strSTK = tokenizar(stk);
                /*dtoTipoSubClie[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
          traza("Tipo: " + strSTK);
                strSTK = tokenizar(stk);
                dtoTipoSubClie[0].setSubtipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
          traza("SubTipo: " + strSTK);*/
            

      
                for (int t = 0; t < dtoTipoSubClie.length; t++) {
                   traza("DTO A ENVIAR TIPOSUBT" + dtoTipoSubClie[t]);
                }

                dtoCrearCliBas.setTiposSubtipos(dtoTipoSubClie);     
            }else{
               DTOTipoSubtipoCliente[] dtoTipoSubClie = new DTOTipoSubtipoCliente[1];
               dtoTipoSubClie[0]= new DTOTipoSubtipoCliente();
               dtoTipoSubClie[0].setTipo(null);
               dtoTipoSubClie[0].setSubtipo(null);
               dtoCrearCliBas.setTiposSubtipos(dtoTipoSubClie);

               for (int t = 0; t < dtoTipoSubClie.length; t++) {
                   traza("DTO A ENVIAR TIPOSUBT" + dtoTipoSubClie[t]);
               }
            }
			//traza("dtoTipoSubClie: " + dtoTipoSubClie[0].toString() );
			traza("0");


			
            DTOIdentificacion[] dtoIdentif = new DTOIdentificacion[1];
            dtoIdentif[0] = new DTOIdentificacion();
            strSTK = tokenizar(stk);
            dtoIdentif[0].setTipoDocumento( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );            
			traza("tipoDoc: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setEsPrincipal( strSTK.equals(TOKEN_VACIO)?null:(strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );
			traza("EsPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setNumeroDocumento( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("NumDoc: " + strSTK);
            strSTK = tokenizar(stk);
            dtoIdentif[0].setIndPersonaEmpresa( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("IndicadorPersona: " + strSTK);
            dtoCrearCliBas.setIdentificaciones(dtoIdentif);

			traza("dtoIdentif: + " + dtoIdentif[0].toString());
			traza("1");
                  
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setCodigoCliente( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("CodigoCliente: " + strSTK);
			traza("1-1");
            strSTK = tokenizar(stk);

            dtoCrearCliBas.setApellido1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Apellido 1: " + strSTK);
            strSTK = tokenizar(stk);
			traza("1-2");
            dtoCrearCliBas.setApellido2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Apellido 2: " + strSTK);
            strSTK = tokenizar(stk);
						traza("1-3");
            dtoCrearCliBas.setApellidoCasada( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Apellido Casada: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setNombre1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Nombre 1: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setNombre2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Nombre 2: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setTratamiento( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Tratamiento: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setSexo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Sexo: " + strSTK);
            strSTK = tokenizar(stk);
			traza("1-4");
            //dtoCrearCliBas.setFechaIngreso( toDate(strSTK) );
			dtoCrearCliBas.setFechaIngreso( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("FechaIngreso: " + strSTK);
            strSTK = tokenizar(stk);
            dtoCrearCliBas.setFormaPago(strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK));
			traza("FormaPago: " + strSTK);
//			traza("dtoCrearClienteBasico: " + dtoCrearCliBas.toString());

			traza("2");
            DTODireccion[] dtoDire = new DTODireccion[1];
            dtoDire[0] = new DTODireccion();
            strSTK = tokenizar(stk);
            dtoDire[0].setTipoDireccion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("TipoDireccion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setTipoVia( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("TipoVia: " + strSTK);
            strSTK = tokenizar(stk);
            //dtoDire[0].setVia( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			dtoDire[0].setVia(new Long(42163));
			//traza("Via - Al no usarse se setea a cualquier valor:  ");
			//traza("Via: " + strSTK );
            strSTK = tokenizar(stk);
            dtoDire[0].setNumeroPrincipal( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("NumPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setCodigoPostal( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("CodigoPostal: " + strSTK);
            /*strSTK = tokenizar(stk);
            dtoDire[0].setInterior( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Interior: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setManzana( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Manzana: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setLote( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Lote: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setKilometro( strSTK.equals(TOKEN_VACIO)?null:Integer.valueOf(strSTK) );
			traza("Kilometro: " + strSTK);*/
            strSTK = tokenizar(stk);
            dtoDire[0].setObservaciones( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Observaciones: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setEsDireccionPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE :Boolean.TRUE ) );
			traza("EsDirPrincipal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoDire[0].setNombreVia( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("NombreVia: " + strSTK);
            dtoCrearCliBas.setDirecciones(dtoDire);

			traza("dtoDire: " + dtoDire[0].toString() );                
			traza("3");                
            DTOClienteMarca[] dtoClieMarca = new DTOClienteMarca[1];
            dtoClieMarca[0] = new DTOClienteMarca();
            strSTK = tokenizar(stk);
            dtoClieMarca[0].setMarca( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Marca: " + strSTK);
            dtoCrearCliBas.setMarcas(dtoClieMarca);
			traza("dtoClieMarca: " + dtoClieMarca[0].toString() );
			traza("4");

            DTOClasificacionCliente[] dtoClasiClie = new DTOClasificacionCliente[1];
            dtoClasiClie[0] = new DTOClasificacionCliente();
			strSTK = tokenizar(stk);
            dtoClasiClie[0].setMarca( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("MarcaClasif: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setCanal( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Canal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setTipoClasificacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("TipoClasif: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClasiClie[0].setClasificacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Clasif: " + strSTK);
            dtoCrearCliBas.setClasificaciones(dtoClasiClie);
			traza("dtoClasiClie: " + dtoClasiClie[0].toString());
			traza("5");

			//rellenamos los atributos de DTOCliente
            dtoClie.setBase(dtoCrearCliBas);

			//SICC-DMCO-MAE-GCC-006 - Cleal 
			strSTK = tokenizar(stk);
			dtoClie.setIndicadorActivo(strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK));
			traza("Indicador Activo: " + strSTK);
			//

            strSTK = tokenizar(stk);
            dtoClie.setCriterioBusqueda1( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Criterio 1: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCriterioBusqueda2( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Criterio 2: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaNacimiento( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("Fecha Nac: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCodigoEmpleado( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Codigo Empleado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNacionalidad( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Nacionalidad: " + strSTK);
/*            strSTK = tokenizar(stk);                
            dtoClie.setEdad( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>2)?null:Short.valueOf(strSTK) );
			traza("Edad: " + strSTK);*/
            strSTK = tokenizar(stk);
            dtoClie.setEstadoCivil( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("EstadoCivil: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setOcupacion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Ocupacion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setProfesion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Profesion: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCentroTrabajo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Centro Trabajo: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCargo( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Cargo: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNivelEstudios( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Nivel de Estudios: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCentroEstudios( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Centro de Estudios: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNumeroHijos( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:Byte.valueOf(strSTK) );
			traza("NumeroHijos: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setPersonasDependientes( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:Byte.valueOf(strSTK) );
			traza("PersonasDependientes: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setNSEP( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("NSEP: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setCicloVida( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Ciclo Vida: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setDeseaCorrespondencia( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE ) );
			traza("DeseaCorrespondencia: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setImporteIngresos( strSTK.equals(TOKEN_VACIO)?null:Double.valueOf(strSTK) );
			traza("Importe Ingresos: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setPaisContactado( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("PaisContactado: " + strSTK);
            strSTK = tokenizar(stk);      
            dtoClie.setClienteContactado( strSTK.equals(TOKEN_VACIO)?null:strSTK ); //codigoClienteContactado
			traza("Cliente Contactado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setTipoClienteContactado( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Tipo Cliente Contactado: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setTipoContacto( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Tipo Contacto: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaPrimerContacto( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("Fecha Primer Contacto: " + strSTK);
            strSTK = tokenizar(stk);
            dtoClie.setFechaSiguienteContacto( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("Fecha Sig. Contacto: " + strSTK);
            //strSTK = tokenizar(stk);
            //dtoClie.setFechaPrimerPedidoContactado( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			//traza("Fecha Primer Pedido Contacto: " + strSTK);
			//traza("dtoClie: " + dtoClie.toString());
            // by Ssantana
            strSTK = tokenizar(stk);
            dtoClie.setMarcaContacto( strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );
      traza("Marca contacto: " + strSTK);

            strSTK = tokenizar(stk);
            dtoClie.setCanalContacto( strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );
      traza("Canal contacto: " + strSTK);

            strSTK = tokenizar(stk);
            dtoClie.setPeriodoContacto(strSTK.equals(TOKEN_VACIO)?null:new Long(strSTK) );            
      traza("Periodo contacto: " + strSTK);
            // end by Ssantana
      
			traza("6");

            DTOVinculo[] dtoVinculo = new DTOVinculo[1];
            dtoVinculo[0] = new DTOVinculo();
            strSTK = tokenizar(stk);
            dtoVinculo[0].setPais( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Pais: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );
			traza("Principal: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setFechaDesde( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("Fecha Desde: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setFechaHasta( strSTK.equals(TOKEN_VACIO)?null:toDate(strSTK) );
			traza("Fecha Hasta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setCodigoCliente( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("CodCliente: " + strSTK);
            strSTK = tokenizar(stk);
            dtoVinculo[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );                
			traza("Tipo: " + strSTK);
            dtoClie.setVinculos(dtoVinculo);  
			traza("dtoVinculo: " + dtoVinculo[0].toString() );
			traza("7");
            DTOPreferencia[] dtoPreferencia = new DTOPreferencia[1];
            dtoPreferencia[0] = new DTOPreferencia();
            strSTK = tokenizar(stk);
            dtoPreferencia[0].setDescripcion( strSTK.equals(TOKEN_VACIO)?null:strSTK  );
			traza("Descripcion Preferencia: " + strSTK);
            strSTK = tokenizar(stk);
            dtoPreferencia[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Tipo Pref: " + strSTK);
            dtoClie.setPreferencias(dtoPreferencia);
			traza("dtoPreferencia: " + dtoPreferencia[0].toString() );
			traza("8");
            dtoClie.setObservaciones(null);

            DTOComunicacion[] dtoComunica = new DTOComunicacion[1];
            dtoComunica[0] = new DTOComunicacion();
            strSTK = tokenizar(stk);
            dtoComunica[0].setTipoComunicacion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Tipo comm: " + strSTK);
            strSTK = tokenizar(stk);				
            dtoComunica[0].setDiaComunicacion( strSTK.equals(TOKEN_VACIO)||(strSTK.length()>1)?null:(new Character(strSTK.charAt(0))) );
			traza("Dia Comm: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setTextoComunicacion( strSTK.equals(TOKEN_VACIO)?null:strSTK );
			traza("Texto comm: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setPrincipal( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE ) );
			traza("Principal: " + strSTK);
            strSTK = tokenizar(stk);
    /*        if (strSTK != null)
              strSTK = strSTK.trim();
            else
              strSTK = "";*/
            //dtoComunica[0].setHoraDesde( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            dtoComunica[0].setHoraDesde( strSTK.equals(TOKEN_VACIO)?null:this.toHoraAsLong(strSTK) );            
			traza("Hora Desde: " + strSTK);
            strSTK = tokenizar(stk);
            //dtoComunica[0].setHoraHasta( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            dtoComunica[0].setHoraHasta( strSTK.equals(TOKEN_VACIO)?null:this.toHoraAsLong(strSTK) );                        
			traza("Hora Hasta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoComunica[0].setIntervaloComunicacion( strSTK.equals(TOKEN_VACIO)?null:( strSTK.equals("false")?Boolean.FALSE:Boolean.TRUE ) );
            dtoClie.setComunicaciones(dtoComunica);       
			traza("dtoComunica: " + dtoComunica[0].toString() );
			traza("9");

            DTOTarjeta[] dtoTarjeta = new DTOTarjeta[1];
            dtoTarjeta[0] = new DTOTarjeta();
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setTipo( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
			traza("Tipo Tarjeta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setClase( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
      			traza("Clase Tarjeta: " + strSTK);
            strSTK = tokenizar(stk);
            dtoTarjeta[0].setBanco( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
      			traza("Banco: " + strSTK);
            dtoClie.setTarjetas(dtoTarjeta);
            traza("dtoTarjeta: " + dtoTarjeta[0].toString());
            traza("10");

            strSTK = tokenizar(stk);
            DTOProblemaSolucion[] dtoProbleSolu = new DTOProblemaSolucion[1];
            dtoProbleSolu[0]= new DTOProblemaSolucion();
            traza("------------- Propblema Solucion -----------------");

        //    dtoProbleSolu[0].set = armaProblemaSolucion(stk);
            
            traza("EL TOK ES " + strSTK);
            
            dtoProbleSolu[0].setTipoProblema( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            
            strSTK = tokenizar(stk);
            traza("dale");
      
            dtoProbleSolu[0].setDescripcionProblema( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            strSTK = tokenizar(stk);
            traza("antes tipo sol");
            dtoProbleSolu[0].setTipoSolucion( strSTK.equals(TOKEN_VACIO)?null:Long.valueOf(strSTK) );
            traza("despues tipo sol");

            strSTK = tokenizar(stk);
      
            dtoProbleSolu[0].setDescripcionSolucion( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            strSTK = tokenizar(stk);

            dtoProbleSolu[0].setSolucion( strSTK.equals(TOKEN_VACIO)?null:(strSTK.equals("0")?Boolean.FALSE:Boolean.TRUE) );

            strSTK = tokenizar(stk);
      
            dtoProbleSolu[0].setNegocio( strSTK.equals(TOKEN_VACIO)?null:strSTK );

            dtoClie.setProblemasSoluciones(dtoProbleSolu);
            
      			traza("dtoProbleSolu: " + dtoProbleSolu[0].toString());
            traza("11");
            dtoClie.setPsicografias(null);

            dtoClie.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoClie.setOidPais(UtilidadesSession.getPais(this));  				
			      dtoClie.setIndicadorSituacion( new Long( posicion.longValue() ) );

            dtoClie.setTamanioPagina(pageSize);
            traza("Salio");
           return dtoClie; 

             /*
             * estos parametros no cargue corroboara que no se me haya pasado algo!!
             * dtoClie.setPaisContactado();
            dtoClie.setOid(long);
            dtoClie.setOidClienteContactado(long);
             dtoClie.setTipoClienteContacto(dtoClie);
            */
	
         }
	

    
    /*******FECHA**************/
	private Date toDate(String sFecha) throws Exception
    {
		String formatoFecha = UtilidadesSession.getFormatoFecha(this);
		traza("formatoSesion: " + formatoFecha);
		//formatoFecha = formatoFecha.replace("m","M");
    formatoFecha = formatoFecha.replace('m', 'M');
		//SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat miFecha = new SimpleDateFormat(formatoFecha);
	    /* La fecha viene de la forma dd/MM/yyyy */
		java.util.Date fecha = miFecha.parse(sFecha);
        miFecha = new SimpleDateFormat(formatoFecha);

	    String fechaRes = miFecha.format(fecha);
		fecha = miFecha.parse(fechaRes);
    traza(fechaRes);
    	//java.sql.Date sql = new java.sql.Date(fecha.getTime() + (86400*1000));
		java.sql.Date sql = new java.sql.Date(fecha.getTime());
    traza("sql Date: " + sql.toString() );
    
		return sql;
	}

  private String tokenizar(StringTokenizer tok) throws Exception{
		String str = tok.nextToken();
		if (str == null){
			traza("str es null");
		}else{
			traza("str: " + str);
		}
		return str;
	}

  private Vector obtieneTipos(String cadena) throws Exception{
        System.out.println("------ Entrando a obtiene Tipos --------");
        RecordSet tiposCliente = new RecordSet();
        RecordSet subTipos = new RecordSet();
        Vector vSubTipos = new Vector();
        Long[] subtipos = null;

        Vector vTipos = new Vector();
        Vector vSubtipos = new Vector();
        
        tiposCliente.setColumnCount(2);
        subTipos.setColumnCount(3);
        Vector vTiposCol = new Vector();
        vTiposCol.add("OID_CLIENTE");
        vTiposCol.add("DESC_CLIENTE");
        tiposCliente.setColumnIdentifiers( vTiposCol );

        vTiposCol = new Vector();
        vTiposCol.add("OID_CLIENTE");
        vTiposCol.add("OID_SUBTIPO");
        vTiposCol.add("DESC_CLIENTE");        
        subTipos.setColumnIdentifiers(vTiposCol);

        StringTokenizer tok = new StringTokenizer(cadena, ";");
        StringTokenizer tokCampo = null;
        String valor = null;
        String sCampo = null;
        int contadorFilas = 0;
        int contadorCampos = 0;
        traza("Entra al while");
        traza("Fila: " + contadorFilas); // Seria 0. 
        while ( tok.hasMoreTokens() )
        {
          int i = 0; // Se procesa el token cuando i = 0 e i = 2 (Id Cliente y Descripcion).
          sCampo = tok.nextToken();
          traza("sCampo: " + sCampo);
          tokCampo = new StringTokenizer(sCampo, "=");
          while ( tokCampo.hasMoreTokens() )  // Proceso el 4campo actual.
          {
              traza("Procesa campo " + contadorCampos);
              traza("el campo es " + valor);
              valor = tokCampo.nextToken();
              traza("paso 1 ");// Este no importa, es el nombre del campo.
              traza("el campo es 2 " + valor);
              valor = tokCampo.nextToken();
              traza("paso 2");// Valor del campo, este es el que importa.
              if ( contadorCampos == 0 ){ // Se tiene el Oid Tipo 
                  traza("es campo0");
                tiposCliente.setRowCount( tiposCliente.getRowCount()+1 );
                subTipos.setRowCount( subTipos.getRowCount()+1);
                tiposCliente.setValueAt(valor, contadorFilas, 0);
                subTipos.setValueAt(valor, contadorFilas, 0);
              }

              if ( contadorCampos == 1) {// Se tiene el Oid Subtipo
                traza("es campo2");
                if(!(valor.equals(" ") || !(valor == null))){
                   traza("entro al if");
                   vSubTipos.add(new Long(valor));
                   subTipos.setValueAt(valor, contadorFilas, 1);
                }else{
                   traza("entro al else");
                   vSubTipos.add(null);
                   subTipos.setValueAt(valor, contadorFilas, 1);
                }
              }

              if ( contadorCampos == 2) // Se tiene la Desc Tipo
                tiposCliente.setValueAt(valor, contadorFilas, 1);

              if ( contadorCampos == 3) // Se tiene la Desc Subtipo
                subTipos.setValueAt(valor, contadorFilas, 2);
              
          }
          contadorCampos++;

          if (contadorCampos == 4)
          {
            contadorFilas++;
            contadorCampos = 0;
            traza("Fila: " + contadorFilas);            
          }


        }

        // Arma el array Long[] con los oid Subtipos
        Long[] sRetorno = (Long[]) vSubTipos.toArray( new Long[vSubTipos.size()] );
        traza("tiposCliente: " + tiposCliente);
        traza("subTipos: " + subTipos);

        Vector v = new Vector();
        v.add(tiposCliente);
        v.add(subTipos);
        v.add(sRetorno);

        return v;
        
      
    }

   private Long toHoraAsLong(String sHora) throws Exception
   {
     // by Ssantana 
     // Recibe una hora de formato HH:mm y devuelve un Long
     // cuyo valor representa esa hora. 
    traza("1");
     SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
    traza("2");     
     java.util.Date fecha = simpleDate.parse(sHora);
    traza("3");     
     Long time = new Long(fecha.getTime());
    traza("4");     

     return time;
     
   }    


 

}
