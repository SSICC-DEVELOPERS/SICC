package es.indra.sicc.rep.logicanegocio;


import java.util.HashMap;
import java.lang.reflect.Field;

public class ConstantesREP{
    
    //POR FAVOR MANTENER ESTE ARCHIVO ORDENADO Y BIEN TABULADO!!!!
    //genericos
    public static String USUARIO = "USUARIO";
    public static String PAIS = "PAISVALUE";
    public static String PAISES = "PAISVALUES";    
    public static String DESCPAIS = "DESCPAIS";
    public static String MODULO = "MODULO";
    public static String IDIOMA = "IDIOMAVALUE";
    public static String FORMATOFECHA= "FORMATOFECHAVALUE";
    public static String SEPARADORDECIMALES= "SEPARADORDECIMALES";
    public static String RESUMEN = "RESUMEN";
    public static String TITULO = "TITULO";
    public static String FORMATOSALIDA = "FORMATOSALIDA";
    public static String EXTENSION = "EXTENSION";
    
    //seg
    public static String MARCA = "MARCAVALUE";
    public static String MARCAS = "MARCAVALUES";    
    public static String CANAL = "CANALVALUE";
    public static String CANALES = "CANALVALUES";    
    public static String EMPRESA = "EMPRESAVALUE";
    public static String EMPRESAS = "EMPRESAVALUES";    
    public static String DEPARTAMENTO = "DEPARTAMENTOVALUE";
    public static String DEPARTAMENTOS = "DEPARTAMENTOVALUES";    
    public static String REGION = "REGIONVALUE";
    public static String REGIONES = "REGIONVALUES";
    public static String REGIONESDESC = "REGIONDESCVALUES";
    public static String ZONA = "ZONAVALUE";
    public static String ZONAS = "ZONAVALUES";    
    public static String SECCION = "SECCIONVALUE";
  //  public static String SECCIONESDESC = "SECCIONDESCVALUE";    
    public static String SECCIONES = "SECCIONVALUES";
    public static String SECCIONESDESC = "SECCIONDESCVALUES";    
    public static String APELLIDOPATERNO = "APELLIDOPATERNOVALUE";
    public static String APELLIDOMATERNO = "APELLIDOMATERNOVALUE";
    public static String NOMBRE1 = "NOMBRE1VALUE";
    public static String NOMBRE2 = "NOMBRE2VALUE";
    
    //zon
    public static String SUBGERENCIAVENTA = "SUBGERENCIAVENTAVALUE";
    public static String SUBGERENCIAVENTAS = "SUBGERENCIAVENTAVALUES";
 
    public static String SUBGERENCIAVENTASDESC = "SUBGERENCIAVENTADESCVALUES";
    public static String PERIODODESDE = "PERIODODESDEVALUE";
    public static String PERIODOHASTA = "PERIODOHASTAVALUE";
 
    //mae
    public static String UNIDADNEGOCIO = "UNIDADNEGOCIOVALUE";
    public static String UNIDADNEGOCIOS = "UNIDADNEGOCIOVALUES";
    public static String NEGOCIO = "NEGOCIOVALUE";
    public static String NEGOCIOS = "NEGOCIOVALUES";
    public static String SUPERGENERICOS = "SUPERGENERICOVALUES";
    public static String GENERICO = "GENERICOVALUE";
    public static String GENERICOS = "GENERICOVALUES";
    public static String ALMACEN = "ALMACENVALUE";
    public static String ALMACENES = "ALMACENVALUES";
    public static String ESTADOMERCANCIADISPONIBLE = "ESTADOMERCANCIADISPONIBLEVALUE";
    public static String ESTADOMERCANCIADISPONIBLES = "ESTADOMERCANCIADISPONIBLEVALUES";
    public static String ESTADOMERCANCIACOMPROMETIDO = "ESTADOMERCANCIACOMPROMETIDOVALUE";
    public static String ESTADOMERCANCIACOMPROMETIDOS = "ESTADOMERCANCIACOMPROMETIDOVALUES";
    public static String ESTADOMERCANCIAASIGNADO = "ESTADOMERCANCIAASIGNADOVALUE";
    public static String ESTADOMERCANCIAASIGNADOS = "ESTADOMERCANCIAASIGNADOVALUES";
    public static String ESTADOMERCANCIARESERVADO = "ESTADOMERCANCIARESERVADOVALUE";
    public static String ESTADOMERCANCIARESERVADOS = "ESTADOMERCANCIARESERVADOVALUES";
    public static String PERIODO = "PERIODOVALUE";
    public static String PERIODOS = "PERIODOVALUES";
    public static String SUBGERENCIA = "SUBGERENCIAVALUE";
    public static String SUBGERENCIAS = "SUBGERENCIAVALUES";
    public static String TERRITORIO = "TERRITORIOVALUE";
    public static String TERRITORIODESC = "TERRITORIODESCVALUE";
    public static String TERRITORIOS = "TERRITORIOVALUES";
    public static String CODIGOCLIENTE = "CODIGOCLIENTEVALUE";
    public static String PERIODOCIERRE = "PERIODOCIERREVALUE";
    public static String PERIODOCIERREDESC = "PERIODOCIERREDESCVALUE";
    
    //cra
    public static String ANIO = "ANIOVALUE";
    public static String ACCESO = "ACCESOVALUE";
    public static String ACCESOS = "ACCESOVALUES";
    public static String OPCIONESIMPRESION = "OPCIONESIMPRESIONVALUE";
    public static String FECHAINICIOPERIODOVENTA = "FECHAINICIOPERIODOVENTAVALUE";
    public static String FECHAFINPERIODOVENTA = "FECHAFINPERIODOVENTAVALUE";
    public static String FECHAINICIOPERIODOFACTURACION = "FECHAINICIOPERIODOFACTURACIONVALUE";
    public static String FECHAFINPERIODOFACTURACION = "FECHAFINPERIODOFACTURACIONVALUE";
    public static String ACTIVIDAD = "ACTIVIDADVALUE";
    public static String ACTIVIDADES = "ACTIVIDADVALUES";
    public static String GRUPOZONA = "GRUPOZONAVALUE";
    public static String GRUPOZONAS = "GRUPOZONAVALUES";
    public static String GRUPOFACTURACION = "GRUPOFACTURACIONVALUE";
    public static String FECHA = "FECHAVALUE";
    public static String MODELO = "MODELOVALUE";
    
    //pre
    public static String CICLOVIDA = "CICLOVIDAVALUE";
    public static String TIPOOFERTA = "TIPOOFERTAVALUE";

    public static String CODIGOPRODUCTODESDE = "CODIGOPRODUCTODESDEVALUE";
    public static String CODIGOPRODUCTOHASTA = "CODIGOPRODUCTOHASTAVALUE";
    public static String CODIGOVENTADESDE = "CODIGOVENTADESDEVALUE";
    public static String CODIGOVENTAHASTA = "CODIGOVENTAHASTAVALUE";
    public static String TIPOESTRATEGIA = "TIPOESTRATEGIAVALUE";
    public static String OPERADORPRECIOCATALOGO = "OPERADORPRECIOCATALOGOVALUE";
    public static String PRECIOCATALOGO = "PRECIOCATALOGOVALUE";
    public static String OPERADORPRECIOCONTABLE = "OPERADORPRECIOCONTABLEVALUE";
    public static String PRECIOCONTABLE = "PRECIOCONTABLEVALUE";
    public static String CATALOGO = "CATALOGOVALUE";
    public static String CATALOGOS = "CATALOGOVALUES";
    public static String PAGINADESDE = "PAGINADESDEVALUE";
    public static String PAGINAHASTA = "PAGINAHASTAVALUE";
    public static String FORMAPAGO = "FORMAPAGOVALUE";
    public static String FORMAPAGOS = "FORMAPAGOVALUES";
    public static String VISTA = "VISTAVALUE";   
    
    public static String CRITERIOORDENACION1 = "CRITERIOORDENACION1VALUE";
    public static String CRITERIOORDENACION2 = "CRITERIOORDENACION2VALUE";
    public static String CRITERIOORDENACION3 = "CRITERIOORDENACION3VALUE";
    public static String NUMEROLINEADESDE = "NUMEROLINEADESDEVALUE";
    public static String NUMEROLINEAHASTA = "NUMEROLINEAHASTAVALUE";
    public static String DESCRIPCION = "DESCRIPCIONVALUE";
    public static String TIPOSOLICITUD = "TIPOSOLICITUDVALUE";
    public static String TIPOLINEA = "TIPOLINEAVALUE";
    public static String OPERADORUNIDADESTOTALES = "OPERADORUNIDADESTOTALESVALUE";
    public static String UNIDADESTOTALES = "UNIDADESTOTALESVALUE";
    public static String OPERADORUNIDADESFALTANTES = "OPERADORUNIDADESFALTANTESVALUE";
    public static String UNIDADESFALTANTES = "UNIDADESFALTANTESVALUE";
    public static String TIPORECUPERACION = "TIPORECUPERACIONVALUE";
    public static String CODIGORECUPERACIONDESDE = "CODIGORECUPERACIONDESDEVALUE";
    public static String CODIGORECUPERACIONHASTA = "CODIGORECUPERACIONHASTAVALUE";
    public static String TIPOALTERNATIVO = "TIPOALTERNATIVOVALUE";
    public static String TIPOREEMPLAZO = "TIPOREEMPLAZOVALUE";
    public static String DIFERENCIAESTIMADO = "DIFERENCIAESTIMADOVALUE";
    public static String DIFERENCIAPRECIO = "DIFERENCIAPRECIOVALUE";
    public static String CODIGOMATRIZDESC = "CODIGOMATRIZDESCVALUE";
    
    //dto
    public static String TIPODESCUENTO = "TIPODESCUENTOVALUE";
    public static String TIPODESCUENTOS = "TIPODESCUENTOVALUES";
    public static String NUMERODESCUENTO = "NUMERODESCUENTOVALUE";
    public static String NUMERODESCUENTOS = "NUMERODESCUENTOVALUES";
    public static String TIPOCLIENTE = "TIPOCLIENTEVALUE";
    public static String TIPOCLIENTES = "TIPOCLIENTEVALUES";
    public static String SUBTIPOCLIENTE = "SUBTIPOCLIENTEVALUE";
    public static String SUBTIPOCLIENTES = "SUBTIPOCLIENTEVALUES";
    public static String SUBTIPOCLIENTEDESC = "SUBTIPOCLIENTEDESCVALUE";
    public static String TIPOCLASIFICACION = "TIPOCLASIFICACIONVALUE";
    public static String TIPOCLASIFICACIONES = "TIPOCLASIFICACIONVALUES";
    public static String TIPOCLASIFICACIONDESC = "TIPOCLASIFICACIONDESCVALUE";
    public static String CLASIFICACION = "CLASIFICACIONVALUE";
    public static String CLASIFICACIONES = "CLASIFICACIONVALUES";
    public static String CLASIFICACIONDESC = "CLASIFICACIONDESCVALUE";
    public static String CLASESOLICITUD = "CLASESOLICITUDVALUE";
    public static String CLASESOLICITUDES = "CLASESOLICITUDVALUES";
    public static String TIPOSOLICITUDES = "TIPOSOLICITUDVALUES";
    public static String SUBTIPOSOLICITUD = "SUBTIPOSOLICITUDVALUE";
    public static String SUBTIPOSOLICITUDES = "SUBTIPOSOLICITUDVALUES";
    public static String NUMEROSOLICITUD = "NUMEROSOLICITUDVALUE";
    public static String ESTRATEGIA = "ESTRATEGIAVALUE";
    public static String ESTRATEGIAS = "ESTRATEGIAVALUES";
      
    //mav
    public static String OPERADORUNIDADESESTIMADAS = "OPERADORUNIDADESESTIMADASVALUE";
    public static String OPERADORCANTIDADESTIMADA = "OPERADORCANTIDADESTIMADAVALUE";
    public static String UNIDADESTIMADA = "UNIDADESTIMADAVALUE";
    public static String CANTIDADESTIMADA = "CANTIDADESTIMADAVALUE";
    public static String CICLOVIDAS = "CICLOVIDAVALUES";
    public static String FECHADESDE = "FECHADESDEVALUE";
    public static String FECHAHASTA = "FECHAHASTAVALUE";
    public static String TIPOOFERTAS = "TIPOOFERTAVALUES";
    public static String ACTIVIDADDESC = "ACTIVIDADDESCVALUE";
    public static String ACTIVIDADESDESC = "ACTIVIDADDESCVALUES";
    
    //EDU
    public static String CURSO = "CURSOVALUE";    
    public static String CODIGOCURSO = "CODIGOCURSOVALUE";
    public static String CODIGOTIPOCURSO = "CODIGOTIPOCURSOVALUE";
    public static String FECHADISPONIBLE = "FECHADISPONIBLEVALUE";
    public static String FECHALANZAMIENTO = "FECHALANZAMIENTOVALUE";
    public static String FECHAFINCURSO = "FECHAFINCURSOVALUE";
    public static String PERIODOMEDICION = "PERIODOMEDICIONVALUE";
    public static String CODIGOPLANTILLA = "CODIGOPLANTILLAVALUE";
    public static String MODALIDADPARTICIPANTE = "MODALIDADPARTICIPANTEVALUE";
    public static String TAMANIOMUESTRACOMPARATIVA = "TAMANIOMUESTRACOMPARATIVAVALUE";
    public static String MODALIDADMUESTRAVENTAS = "MODALIDADMUESTRAVENTASVALUE";
    public static String REGIONDESC = "REGIONDESCVALUE";
    public static String ZONADESC = "ZONADESCVALUE";
    public static String PERIODODESDEDESC = "PERIODODESDEDESCVALUE";
    public static String PERIODOHASTADESC = "PERIODOHASTADESCVALUE";
    public static String CRITERIOSDESC = "CRITERIOSDESCVALUE";
    
    //car
    public static String NIVELRIESGO = "NIVELRIESGOVALUE";
    public static String NIVELTRAMO = "NIVELTRAMOVALUE";
    public static String NIVEL = "NIVELVALUE";
    public static String ESTATUSSOLICITUD = "ESTATUSSOLICITUDVALUE";
    public static String ESTATUSCREDITOSOLICITUD = "ESTATUSCREDITOSOLICITUDVALUE";
    public static String MOTIVOBLOQUEO = "MOTIVOBLOQUEOVALUE";
    public static String MOTIVOAPROBACION = "MOTIVOAPROBACIONVALUE";
    public static String INFORMADOGERENTEZONA = "INFORMADOGERENTEZONAVALUE";
    public static String REPRESENTANTECREDITO = "REPRESENTANTECREDITOVALUE";
    public static String TIPOORDEN = "TIPOORDENVALUE";
    
    //cal
    public static String TIPOCLIENTE1 = "TIPOCLIENTE1VALUE";
    public static String TIPOCLIENTE2 = "TIPOCLIENTE2VALUE";
    public static String TIPOCLIENTE3 = "TIPOCLIENTE3VALUE";
    public static String TIPOCLIENTE4 = "TIPOCLIENTE4VALUE";    
    public static String TIPOCLIENTE5 = "TIPOCLIENTE5VALUE";    
    public static String TIPOCLIENTE6 = "TIPOCLIENTE6VALUE";    
    public static String TIPOCLIENTEDESC = "TIPOCLIENTEDESCVALUE";
    public static String TIPOCLIENTE1DESC = "TIPOCLIENTE1DESCVALUE";
    public static String TIPOCLIENTE2DESC = "TIPOCLIENTE2DESCVALUE";
    public static String TIPOCLIENTE3DESC = "TIPOCLIENTE3DESCVALUE";
    public static String TIPOCLIENTE4DESC = "TIPOCLIENTE4DESCVALUE";    
    public static String TIPOCLIENTE5DESC = "TIPOCLIENTE5DESCVALUE";    
    public static String TIPOCLIENTE6DESC = "TIPOCLIENTE6DESCVALUE";    
    
    public static String FECHAINICIO = "FECHAINICIOVALUE";     
    public static String FECHAFIN = "FECHAFINVALUE";     

    public static String PLANTILLA = "PLANTILLAVALUE";         
    public static String MOTIVOS = "MOTIVOVALUES";
    public static String BUZON = "BUZONVALUE";
    public static String BUZONDESC = "BUZONDESCVALUE";
    public static String AGENTE = "AGENTEVALUE";
    public static String AREASEGUIMIENTO = "AREASEGUIMIENTOVALUE";
    
    //ped
    public static String SUBACCESO = "SUBACCESOVALUE";
    public static String SUBACCESOS = "SUBACCESOVALUES";
    public static String NOMBREGERENTES = "NOMBREGERENTEVALUES";
    public static String LOTEINICIO = "LOTEINICIOVALUE";
    public static String LOTEFIN = "LOTEFINVALUE";
    public static String TIPODESPACHOS = "TIPODESPACHOVALUES";
    
    //bel
    public static String GRUPODIFERENCIAS = "GRUPODIFERENCIASVALUES";
    public static String FECHACIERRE = "FECHACIERREVALUE";
    public static String ESTADOMERCANCIA = "ESTADOMERCANCIAVALUE";
    public static String CODIGODESCUENTO = "CODIGODESCUENTOVALUE";
    public static String HORADESDE = "HORADESDEVALUE";
    public static String HORAHASTA = "HORAHASTAVALUE";
    public static String DETALLE = "DETALLEVALUE";
    public static String CAJA = "CAJAVALUE";
    public static String CAJAS = "CAJAVALUES";
    public static String ESTADOMERCANCIATESTER = "ESTADOMERCANCIATESTERVALUE";
    public static String ESTADOMERCANCIAVENTA = "ESTADOMERCANCIAVENTAVALUE";
    public static String ESTADOMERCANCIADEVOLUCION = "ESTADOMERCANCIADEVOLUCIONVALUE";
    public static String ESTADOMERCANCIATRANSITO = "ESTADOMERCANCIATRANSITOVALUE";
    public static String MARCAPRODUCTO = "MARCAPRODUCTOVALUE";    
    public static String MARCAPRODUCTODESC = "MARCAPRODUCTOVALUEDESC";    
    
    public static String MARCAPRODUCTOS = "MARCAPRODUCTOVALUES";
    public static String GRUPO = "GRUPOVALUE";
    public static String RANGOFECHAS = "RANGOFECHASVALUE";
    public static String OPERACIONES = "OPERACIONVALUES";
    public static String OPERACION = "OPERACIONVALUE";
    public static String ESPECIALISTA = "ESPECIALISTAVALUE";
    public static String CODIGOPRODUCTO = "CODIGOPRODUCTOVALUE";
    public static String CODIGOPRODUCTOS = "CODIGOPRODUCTOVALUES";
    public static String TIPOREPORTE = "TIPOREPORTEVALUE";
    public static String TIPODETALLE = "TIPODETALLEVALUE";

    
    //rep
    
    public static String TIPODOCUMENTOLEGAL = "TIPODOCUMENTOLEGALVALUE";
    public static String SERIE = "SERIEVALUE";
    public static String TIPOINFORME = "TIPOINFORMEVALUE";


    //CCC
    public static String BANCO = "BANCOVALUE";
    public static String BANCOS = "BANCOVALUES";
    public static String BANCOSDESC = "BANCODESCVALUES";
    public static String CUENTACORRIENTE = "CUENTACORRIENTEVALUE";
    public static String CUENTACORRIENTES = "CUENTACORRIENTEVALUES";
    public static String CUENTACORRIENTESDESC = "CUENTACORRIENTEDESCVALUES";
    public static String CODIGOTERRITORIODESDE = "CODIGOTERRITORIODESDEVALUE";
    public static String CODIGOTERRITORIOHASTA = "CODIGOTERRITORIOHASTAVALUE";
    public static String MARCADESC = "MARCADESCVALUE";
    public static String MARCASDESC = "MARCADESCVALUES";
    public static String CANALDESC = "CANALDESCVALUE";
    public static String CANALESDESC = "CANALDESCVALUES";
    public static String ORDEN = "ORDENVALUE";
    public static String AGRUPACION = "AGRUPACIONVALUE";
    public static String ORDENDESC = "ORDENDESCVALUE";    
    public static String FECHADEPROCESODESDE = "FECHADEPROCESODESDEVALUE";   
    public static String FECHADEPROCESOHASTA = "FECHADEPROCESOHASTAVALUE"; 
    public static String CRITERIODEORDENAMIENTO = "CRITERIODEORDENAMIENTOVALUE"; 
    public static String TIPOCARGOABONO = "TIPOCARGOABONOVALUE"; 
    public static String TIPOCARGOABONOS = "TIPOCARGOABONOVALUES"; 
    public static String TIPOCARGOABONOSDESC = "TIPOCARGOABONODESCVALUES"; 
    public static String NUMEROCOMPROBANTE = "NUMEROCOMPROBANTEVALUE"; 
    public static String NUMEROCOMPROBANTES = "NUMEROCOMPROBANTEVALUES"; 
    public static String PROCESO = "PROCESOVALUE"; 
    public static String PROCESOS = "PROCESOVALUES";  
    public static String CRITERIOSELECCIONDESC = "CRITERIOSELECCIONDESCVALUE"; 
    public static String TERRITORIODESDE = "TERRITORIODESDEVALUE"; 
    public static String TERRITORIOHASTA= "TERRITORIOHASTAVALUE"; 
    public static String TIPOREPORTEDESC = "TIPOREPORTEDESCVALUE"; 
    public static String FECHADEVALORDESDE= "FECHADEVALORDESDEVALUE"; 
    public static String FECHADEVALORHASTA= "FECHADEVALORHASTAVALUE"; 
    public static String FECHAVALORDESDE= "FECHAVALORDESDEVALUE"; 
    public static String FECHAVALORHASTA= "FECHAVALORHASTAVALUE"; 
    public static String SECCIONDESC= "SECCIONDESCVALUE"; 
    public static String ZONASDESC= "ZONADESCVALUES"; 
    public static String FECHACONTABLE = "FECHACONTABLEVALUE";
    public static String FECHACONTABLEDESC = "FECHACONTABLEDESCVALUE";
    public static String EJERCICIO = "EJERCICIOVALUE";
    public static String EJERCICIOCONTABLE = "EJERCICIOCONTABLEVALUE";
    public static String TIPOPERIODO = "TIPOPERIODOVALUE";
    public static String CRITERIOORDENAMIENTO = "CRITERIOORDENAMIENTOVALUE";
    public static String TIPODEPERIODO = "TIPODEPERIODOVALUE";
    public static String PERIODOCONTABLE = "PERIODOCONTABLEVALUE";
    public static String PERIODOCONTABLEDESC = "PERIODOCONTABLEDESCVALUE";
    public static String PERIODOCOMERCIAL = "PERIODOCOMERCIALVALUE";
    public static String PERIODOCOMERCIALDESC = "PERIODOCOMERCIALDESCVALUE";
    public static String EJERCICIOPERIODOCOMERCIAL = "EJERCICIOPERIODOCOMERCIALVALUE";
    public static String FECHALIQUIDACION = "FECHALIQUIDACIONVALUE";
    
    //cob 
    public static String FECHAASIGNACION = "FECHAASIGNACIONVALUE";
    public static String GRUPOUSUARIOS = "GRUPOUSUARIOSVALUE";
    public static String ORDENCOLUMNA1 = "ORDENCOLUMNA1VALUE";
    public static String ORDENCOLUMNA2 = "ORDENCOLUMNA2VALUE";
    public static String ORDENCOLUMNA3 = "ORDENCOLUMNA3VALUE";
    public static String CAMPOSBUSQUEDA = "CAMPOSBUSQUEDAVALUE";
    public static String ETAPACOBRANZA = "ETAPACOBRANZAVALUE";
    public static String CARTERA = "CARTERAVALUE";
    public static String USUARIOCOBRANZA = "USUARIOCOBRANZAVALUE";
    public static String USUARIOCOBRANZADESC = "USUARIOCOBRANZADESCVALUE";
    public static String GRUPODEUSUARIO = "GRUPODEUSUARIOVALUE";
    public static String GRUPODEUSUARIODESC = "GRUPODEUSUARIODESCVALUE";
    public static String PERIODOSDESC = "PERIODODESCVALUES";
    public static String PERIODODESC = "PERIODODESCVALUE";
    public static String COMISION = "COMISIONVALUE";
    public static String TIPOCOMISION = "TIPOCOMISIONVALUE";
   

    //FAC
    public static String ACCESODESC = "ACCESODESCVALUE";  
    public static String MES = "MESVALUE";  
    
    //REC
    public static String CANTIDADPRODUCTOS = "CANTIDADPRODUCTOSVALUE";
    public static String OPERACION1 = "OPERACION1VALUE";
    public static String OPERACION2 = "OPERACION2VALUE";
    public static String OPERACION3 = "OPERACION3VALUE";
    public static String OPERACION4 = "OPERACION4VALUE";
    public static String TIPOOPERACION = "TIPOOPERACIONVALUE";
    public static String TIPOOPERACIONES = "TIPOOPERACIONVALUES";
    public static String CANTIDADZONAS = "CANTIDADZONASVALUE";
    public static String PERIODOINICIAL = "PERIODOINICIALVALUE";
    public static String PERIODOFINAL = "PERIODOFINALVALUE";
    public static String PERIODOINICIALDESC = "PERIODOINICIALDESCVALUE";
    public static String CANTIDADCONSULTORAS= "CANTIDADCONSULTORASVALUE";
    public static String PERIODOFINALDESC = "PERIODOFINALDESCVALUE";
    public static String TIPOCAMPANIA = "TIPOCAMPANIAVALUE";
    public static String TIPOORDENACION = "TIPOORDENACIONVALUE";
    public static String TIPOCATALOGO = "TIPOCATALOGOVALUES";
    public static String QUIEBREUNIDADNEGOCIO = "QUIEBREUNIDADNEGOCIOVALUE";
    public static String CANTIDADREGISTROS = "CANTIDADREGISTROSVALUE";
    public static String CAMPANIAINICIAL = "CAMPANIAINICIALVALUE";
    public static String CAMPANIAFINAL = "CAMPANIAFINALVALUE";
    public static String TIPODOCUMENTOSLEGAL = "TIPODOCUMENTOLEGALVALUES";
    public static String TIPOCAMPANIADESC = "TIPOCAMPANIADESCVALUE";
    public static String CLASES = "CLASEVALUES";
    public static String CUENTASCORRIENTESBANCARIAS = "CUENTACORRIENTEBANCARIAVALUES";
    public static String CAMPANIA = "CAMPANIAVALUE";
    public static String CAMPANIADESC = "CAMPANIADESCVALUE";
    public static String FORMAINGRESOS = "FORMAINGRESOVALUES";
    public static String CODIGOVENTA = "CODIGOVENTAVALUE";
    public static String CODIGOVENTAS = "CODIGOVENTAVALUES";
    public static String PERIODOINICIO = "PERIODOINICIOVALUE";
    public static String PERIODOFIN = "PERIODOFINVALUE";
    public static String PERIODOINICIODESC = "PERIODOINICIODESCVALUE";
    public static String PERIODOFINDESC = "PERIODOFINDESCVALUE";
    public static String TRAMOINICIAL = "TRAMOINICIALVALUE";
    public static String TRAMOFINAL = "TRAMOFINALVALUE";
    public static String PUNTOINGRESOS = "PUNTOINGRESOVALUES";
    public static String OPERACIONDESC = "OPERACIONDESCVALUE";
    public static String OPERACIONESDESC = "OPERACIONDESCVALUES";
    public static String TIPOOPERACIONESDESC = "TIPOOPERACIONDESCVALUES";
    //inc
    public static String NUMEROCONCURSOS = "NUMEROCONCURSOVALUES";
    public static String NUMEROCONCURSO = "NUMEROCONCURSOVALUE";
    public static String NUMEROCONCURSODESC = "NUMEROCONCURSODESCVALUE";
    public static String NIVELESCONCURSO = "NIVELESCONCURSOVALUE";
    public static String NIVELESCONCURSOS = "NIVELESCONCURSOVALUES";
    public static String TIPOVENTA = "TIPOVENTAVALUE";
    public static String TIPOVENTADESC = "TIPOVENTADESCVALUE";
    public static String CANTIDADESTIMADAPEDIDO = "CANTIDADESTIMADAPEDIDOSVALUE";
    public static String CANTIDADESTIMADAPEDIDOS = "CANTIDADESTIMADAPEDIDOSVALUES";
    public static String UNIDADESCOMPRADA = "UNIDADESCOMPRADASVALUE";
    public static String UNIDADESCOMPRADAS = "UNIDADESCOMPRADASVALUES";
    public static String CAMPANIAANALISIS = "CAMPANIAANALISISVALUE";
    public static String CAMPANIASANALISIS = "CAMPANIAANALISISVALUES";
    public static String NUMERORECOMENDADAS = "NUMERORECOMENDADASVALUES";
    public static String NUMERORECOMENDADA = "NUMERORECOMENDADASVALUE";
    public static String NUMEROPUESTOS = "NUMEROPUESTOSVALUE";
    public static String MOTIVOSINCUMPLIMIENTO = "MOTIVOSINCUMPLIMIENTOVALUE";
    public static String MOTIVOSINCUMPLIMIENTOS = "MOTIVOSINCUMPLIMIENTOVALUES";
    public static String NUMEROPROPUESTO = "NUMEROPROPUESTOVALUE";
    public static String NUMEROPROPUESTOS = "NUMEROPROPUESTOVALUES";
    public static String RESPONSABLEPERDIDA = "RESPONSABLEPERDIDAVALUE";
    public static String RESPONSABLESPERDIDA = "RESPONSABLEPERDIDAVALUES";
    public static String ASUMEPERDIDA = "ASUMEPERDIDAVALUE";
    public static String ASUMEPERDIDAS = "ASUMEPERDIDAVALUES";
    public static String PERCENTILES = "PERCENTILVALUES";
    public static String PERCENTIL = "PERCENTILVALUE";
    public static String MONEDA = "MONEDAVALUE";
    public static String MONEDADESC = "MONEDADESCVALUE";
    public static String MONEDAS = "MONEDAVALUES";
    public static String SELECCIONOPREMIO= "SELECCIONOPREMIOVALUE";    
    public static String RANGOVENTAS = "RANGOVENTAVALUES";
    public static String RANGOVENTA = "RANGOVENTAVALUE";
    public static String TIPOVARIACION = "TIPOVARIACIONVALUE";
    public static String VARIACIONDESDE = "VARIACIONDESDEVALUE";
    public static String VARIACIONHASTA = "VARIACIONHASTAVALUE";
    public static String VARIACION1DESDE = "VARIACION1DESDEVALUE";
    public static String VARIACION1HASTA = "VARIACION1HASTAVALUE";
    public static String VARIACION2DESDE = "VARIACION2DESDEVALUE";
    public static String VARIACION2HASTA = "VARIACION2HASTAVALUE";
    public static String VARIACION3DESDE = "VARIACION3DESDEVALUE";
    public static String VARIACION3HASTA = "VARIACION3HASTAVALUE";
    public static String VARIACION4DESDE = "VARIACION4DESDEVALUE";
    public static String VARIACION4HASTA = "VARIACION4HASTAVALUE";
    public static String VARIACION5DESDE = "VARIACION5DESDEVALUE";
    public static String VARIACION5HASTA = "VARIACION5HASTAVALUE";
    public static String VARIACION6DESDE = "VARIACION6DESDEVALUE";
    public static String VARIACION6HASTA = "VARIACION6HASTAVALUE";
    public static String MONTOVENTAS = "MONTOVENTAVALUES";
    public static String MONTOVENTA = "MONTOVENTAVALUE";
    public static String RESULTADOS = "RESULTADOVALUES";
    public static String RESULTADO = "RESULTADOVALUE";
    public static String BASECALCULO = "BASECALCULOVALUE";
    public static String BASECALCULOS = "BASECALCULOVALUES";
    public static String RANGONUMEROPEDIDODESDE = "RANGONUMEROPEDIDODESDEVALUE";
    public static String RANGONUMEROPEDIDOHASTA = "RANGONUMEROPEDIDOHASTAVALUE";
    public static String INGRESOSCAMPANIA = "INGRESOSCAMPANIAVALUE";
    public static String NUMERORECOMENDADASEFECTIVA = "NUMERORECOMENDADASEFECTIVAVALUE";
    public static String NUMERORECOMENDADASEFECTIVAS = "NUMERORECOMENDADASEFECTIVAVALUES";
    public static String VARIABLEVENTA = "VARIABLEVENTAVALUE";
    public static String VARIABLEVENTAS = "VARIABLEVENTAVALUES";
    public static String PORCENTAJEGANADORAS = "PORCENTAJEGANADORASVALUE";
    public static String CONCURSO = "CONCURSOVALUE";
    public static String CONCURSOS = "CONCURSOVALUES";
    public static String TIPOAPORTE = "TIPOAPORTEVALUE";
    public static String EVENTOSCONSULTORAS = "EVENTOSCONSULTORASVALUE";
    public static String EXCEPCIONESTIPOOFERTAS = "EXCEPCIONESTIPOOFERTASVALUE";
    public static String VARIABLESVENTA = "VARIABLESVENTAVALUE";
    public static String NUMEROPEDIDOANIOANTERIOR = "NUMEROPEDIDOANIOANTERIORVALUE";
    public static String INGRESOPORCOMPANIA = "INGRESOPORCOMPANIAVALUE";
    public static String NUMEROSUBGERENCIAVENTAS = "NUMEROSUBGERENCIAVENTASVALUE";
    public static String NUMEROZONAS = "NUMEROZONASVALUE";
    public static String VARIACION = "VARIACIONVALUE";
    public static String UNIDADNEGOCIODESC = "UNIDADNEGOCIODESCVALUE";
    public static String NEGOCIODESC = "NEGOCIODESCVALUE";
    public static String NUMEROREGIONES = "NUMEROREGIONESVALUE";
    public static String TIPOPROCESOS = "TIPOPROCESOSVALUES";

	//COM
    public static String CANTIDADDIASDESC = "CANTIDADDIASDESCVALUE";
    public static String PAISCOMBO = "PAISCOMBOVALUE";
    public static String SOLOIMPRIMIBLES = "SOLOIMPRIMIBLESVALUE";
    
	



    public static HashMap getFields(){
      HashMap hashMap = new HashMap();
      Field field[] = ConstantesREP.class.getDeclaredFields();
      for (int i = 0; i < field.length; i++) {
          try {
              hashMap.put(field[i].getName(),field[i].get(null).toString());
          } catch (IllegalAccessException e) { }
      }
      return hashMap;
    }

    public static HashMap getValueFields(){
      HashMap hashMap = new HashMap();
      Field field[] = ConstantesREP.class.getDeclaredFields();
      for (int i = 0; i < field.length; i++) {
          try {
              hashMap.put(field[i].get(null).toString(), field[i].getName());
          } catch (IllegalAccessException e) { }
      }
      return hashMap;
    }

  }

