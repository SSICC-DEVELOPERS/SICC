//function TListado(nombre,ancho,alto,GrBorde,GrHCab,GrHDat,GrV,ColHDat,ColVDat,ColVCab,accion,anchos,tipoAnchos,colMinimiz,altoFila,altoCab,anchoColMinim,datos,tiposCol,ordenCol,txtCab,estilosCab,coloresCab,estilosDat,nbsp,ajusteMin,nowrap,btnOff,btnOn,btnSel,btnDesac,btnMinN,btnMinS,btnMaxN,btnMaxS,btnConROver,imgFondCab,minFilas,maxSel,msgErrMaxSel,colOn,colSel,ordenarCol,onSetDatos,onAfterSetDatos,txtMinim,alertsDebug,tipEnvio,formaEnvio,NSdoc,onLoad,repintarCab,ColFonScr,grpCab,deseleccSiMax,ajustarAMitadInf,btnOrd,btnOrdInv,hayBtnOrdenar,hayTitulo,datosTitulo,nombrePaginado,tipoSeleccion,scrollAsociado,barraScroll,primerRefresco,accionDobleClick,msegDobleClick,autoScroll,onClickColumna,renderOptimizado,tooltipsCab) {
function TListado(nombre,ancho,alto,GrBorde,GrHCab,GrHDat,GrV,ColHDat,ColVDat,ColVCab,accion,anchos,tipoAnchos,colMinimiz,altoFila,altoCab,anchoColMinim,datos,tiposCol,ordenCol,txtCab,estilosCab,coloresCab,estilosDat,nbsp,ajusteMin,nowrap,btnOff,btnOn,btnSel,btnDesac,btnMinN,btnMinS,btnMaxN,btnMaxS,btnConROver,imgFondCab,minFilas,maxSel,msgErrMaxSel,colOn,colSel,ordenarCol,onSetDatos,onAfterSetDatos,txtMinim,alertsDebug,tipEnvio,formaEnvio,onLoad,repintarCab,ColFonScr,grpCab,deseleccSiMax,ajustarAMitadInf,btnOrd,btnOrdInv,hayBtnOrdenar,hayTitulo,datosTitulo,nombrePaginado,tipoSeleccion,scrollAsociado,barraScroll,primerRefresco,accionDobleClick,msegDobleClick,autoScroll,onClickColumna,renderOptimizado,tooltipsCab) {
   this.ancho=ancho;
   this.alto=alto;
   this.tiposCol=tiposCol;
   this.ordenCol=ordenCol;
   this.txtCab=txtCab;
   this.accion=accion;
   this.anchos=anchos;
   this.tipoAnchos=tipoAnchos;
   this.nombre=nombre;
   this.altoFila=altoFila
   this.altoCab=altoCab
   this.GrBorde=GrBorde;
   this.GrHDat=GrHDat; //Grosor Lineas Horizontales en los Datos
   this.GrHCab=GrHCab; //Grosor Lineas Horizontales en los Datos
   this.GrV=GrV; //Grosor Lineas Verticales en los Datos y la cabecera
   this.ColHDat=ColHDat; //Color Lineas Horizontales en los Datos
   this.ColVDat=ColVDat; //Color Lineas Verticales en los Datos 
   this.ColVCab=ColVCab; //Color Lineas Verticales en la cabecera
   this.estilosCab=estilosCab;
   this.coloresCab=coloresCab;
   this.estilosDat=estilosDat;
   this.ajusteMin=ajusteMin
   this.nowrap=nowrap
   this.btnOff=btnOff
   this.btnOn=btnOn
   this.btnSel=btnSel
   this.btnMinN=btnMinN
   this.btnMinS=btnMinS
   this.btnMaxN=btnMaxN
   this.btnMaxS=btnMaxS
   this.btnDesac=btnDesac
   this.btnConROver=btnConROver; //False - - > no hay rollover
   this.imgFondCab=imgFondCab;
   this.maxSel=maxSel; //Maximo de entradas a seleccionar (-1 --> ,multiseleccion   0 - - > ninguno)
   this.msgErrMaxSel=msgErrMaxSel
   this.colOn=colOn;
   this.colSel=colSel;
   this.ordenarCol=ordenarCol;
   this.datos=datos;
   this.onSetDatos=onSetDatos;//JS a ejecutar al hacer un setDatos()
   this.onAfterSetDatos=onAfterSetDatos;//JS a ejecutar al hacer un setDatos()
   this.anchoColMinim=anchoColMinim; //ancho de las columnas minimizadas
   this.colMinimiz=colMinimiz;
   this.minFilas=minFilas; //Si hay menos que eso se pintan vacias 
   this.txtMinim=txtMinim; //true --> sale txt columnas cuando minimizo
   this.alertsDebug=alertsDebug;
   this.tipEnvio=tipEnvio; //edicion (envio altas bajas y modif) o bien seleccion (solo los cod selecc)
   this.formaEnvio=formaEnvio; //serializado o xml
   //this.NSdoc=NSdoc; //Ruta de la capa contenedora del listado en NS
   this.onLoad=onLoad; //La primera vez que se repinta puedo p. ej. modif. los datos
   this.repintarCab=repintarCab;//Si es N no repinto la cab (x ej. porque no hay)
   this.ColFonScr=ColFonScr; //color de fondo del cuadro del scroll de la cabecera
   this.grpCab=grpCab; //Grupos de la cabecera. Si todos son null no hay grupos
   this.deseleccSiMax=deseleccSiMax; //Si true deseleccionamos uno cuando máximo seleccionado y selecc. Otro.
   this.ajustarAMitadInf=ajustarAMitadInf; // Si true, en la cabecera, cuando hay grupos se ajustan los que no tienen grupo a la mitad inferior
   this.btnOrd=btnOrd; //Iconos que identifican la columna por la que se está ordenando en este momento
   this.btnOrdInv=btnOrdInv; //Iconos que identifican la columna por la que se está ordenando en este momento
   this.hayBtnOrdenar=hayBtnOrdenar; //Si lo hay se pinta un icono junto al nombre de columna por el que acabamos de ordenar
   this.hayTitulo=hayTitulo; //Si lo hay se pinta una linea de titulo
   this.datosTitulo=datosTitulo; //datos de la linea de titulo, si los hay: (Si no existe, [])   [texto,@ID,alto]
   this.nombrePaginado=nombrePaginado;//Si hay paginado guardamos el nombre
   this.tipoSeleccion=tipoSeleccion;//"fila" o "celda"
   this.scrollAsociado=scrollAsociado;//"S" o "N"
   this.barraScroll=barraScroll;//"nunca" o "siempre" o "automatico"
   this.primerRefresco=primerRefresco;//"N" --> no hace repinta() al principio
   this.accionDobleClick=accionDobleClick;
   this.msegDobleClick=msegDobleClick;
   this.autoScroll=autoScroll;//Si true se hace scroll al focalizar un objeto
   this.onClickColumna=onClickColumna; //Puede ser null
   this.renderOptimizado=renderOptimizado;
   this.tooltipsCab=tooltipsCab;

   this.IDDBLCLICK=null;
   this.hayDobleClic=(accionDobleClick!="")?true:false;
   this.anchoScroll=(this.barraScroll=="nunca")?0:16;
   this.anchosOld=DrGeneraCopiaDeArray(this.anchos);
   this.datosOld=null; //Almacen para salvar 
   this.filaSelecc=-1; //la última fila marcada o desmarcada. Al ppo vale -1;
   this.selecc=null; //Array. Normal(0), fila seleccionada (1) o desactivada (-1)
   this.seleccOld=null; //Almacen para salvar 
   this.form=null; //Formulario interno
   this.colOcultas=0; //num de columnas ocultas
   this.ultColNoOcul=0; //ultima col. no oculta
   this.estOrden=null; //True o False, para controlar si el orden es ascendente / descendente
   this.validac=null; //validación de cada columna. 
   this.estadoCol=null; //Sale de tomar lo de tiposCol
   this.tipColForm=[["CAJATEXTO","Texto"],["COMBO","Combo"],["AREATEXTO","Textarea"],["CHECKBOX","Checkbox"],["RADIOBUTTON","Radio"]] //Columnas de tipo 'formulario'. Seg columna es el ...TC
   this.tag="LISTAEDITABLE";
   this.TC="Listado";
   this.colADat=null; //Array que me relaciona las columnas visibles con el array interno de datos
   this.celdSelecc=[-1,-1,-1] //Seleccion de una celda 

   this.numPintadosDat=0;
   if (window.DR_DEBUG_JS) {
      if (window.drd_listas==null) {
         window.drd_listas=[]
         }
      window.drd_listas[window.drd_listas.length]=this;
      }

   //Calculamos la longitud (columnas) que tienen que tener los datos
   var cont=0,i;
   for (i=0;i<this.tiposCol.length;i++)
      if (this.tiposCol[i][0].toUpperCase()=="BOTON")
         cont++;
   this.numColDat=this.tiposCol.length-cont;

   this.nbsp=""; // a meter delante del nombre
   for  (i=0;i<nbsp;i++)
      this.nbsp +="&nbsp;";

   if (this.ordenarCol) {
      this.estOrden=new Array()
      for  (i=0;i<this.tiposCol.length;i++)
         this.estOrden[i]=false; //Controlaremos ascendente / descendente
      }

   this.validac=new Array();
   this.estadoCol=new Array();
   for (i=0;i<this.tiposCol.length;i++)   {
      var a=this.tiposCol[i];
      var j=0;
      var c=new Array();//acumulamos estados
      //Separamos los estados de los tipos
      while(j<a.length && "MINIMIZADA,OCULTA".indexOf(a[j])!=-1) {
         c[c.length]=a[j];
         j++;
         }
      var b=new Array();//acumulamos tipos
      while (j<a.length)   {
         b[b.length]=a[j];
         j++;
         }
      this.tiposCol[i]=b;
      this.estadoCol[i]=(c.length==0)?[""]:c;
      
      if (b[0]=='CAJATEXTO' || b[0]=='AREATEXTO')  
         this.validac[i]=b[5];
      else
         this.validac[i]="null";
      }

   this.tipEnvio=((this.tipEnvio.toUpperCase())=='EDICION')?'E':'S'; //Edición o Seleccion

   this.hayGruposCab=false; //Grupos en la cabecera
   for (var ff=0;ff<this.grpCab.length;ff++) 
      if (this.grpCab[ff]!=null)
         this.hayGruposCab=true;

   this.ultimaOrdenada=null;

   //Precarga de imagenes. Ojo, si la imagen no existe no debería tener delante el drdpath, si no ser ''
   //DrdPrecImgs(btnOff,btnOn,btnSel,btnDesac,btnMinN,btnMinS,btnMaxN,btnMaxS,btnOrd,btnOrdInv,imgFondCab);

   // ******************************************************* RELATIVAS A MANEJO INTERNO DE LOS DATOS

   //Inicia las variables
   // .................................................  init
   this.init = function () {

      this.recalculaColADat();

      //Inicializamos las variables JS correspondientes a las capas (CpXXX por ejemplo);
      this.generaVariablesCapas();

      //separamos los estilos de las filas segun las comas
      var i;
      for (i=0;i<this.estilosDat.length;i++) {
         var a=this.estilosDat[i];
         if (a.length==1)
            if (a[0].indexOf(',')!=-1) 
               this.estilosDat[i]=a[0].split(',');
         }

      this.recalculaOcultas();

      if (this.ajusteMin) 
         this.ajustaAnchosMinimos();

      this.ajustaSelecc();
      this.resetDatosOld(); //Mantenemos una copia de datos

      //this.ajustaSelecc();
      
      eval (this.onLoad);

      if (this.primerRefresco)
         this.repinta();
      this.repintaTit();//No se repinta cada vez ya que se supone que no va a variar mucho

      if (this.scrollAsociado!="")  {
         var listaasoc=eval (this.scrollAsociado);
         if (listaasoc && listaasoc.tag && listaasoc.tag=="LISTAEDITABLE") {
            var elScroll=eval("CpScroll"+this.nombre);
            if (elScroll)
               elScroll.asociay="CpScroll"+this.scrollAsociado;
            }
         }

      if (this.barraScroll=="siempre")  {
         var elScroll=document.all["CpScroll"+this.nombre];
         if (elScroll)
            elScroll.style.overflow='scroll';
         }
      else if (this.barraScroll=="nunca")  {
         var elScroll=document.all["CpScroll"+this.nombre];
         if (elScroll)
            elScroll.style.overflow='hidden';
         }

      }

    


   // calcula el array que me lleva desde las columnas visibles hasta los datos. Para los botones me lleva a datos[n][0]--> el código
   // Las columnas ocultas cuentan como visibles
   // ................................................  recalculaColADat
   this.recalculaColADat = function() {
      this.colADat=new Array();
      var cont=1;
      for (var i=0;i<this.tiposCol.length;i++)  {
         if((this.tiposCol[i][0].toUpperCase())=='BOTON')   {
            this.colADat[i]=0;
            }
         else  {
            this.colADat[i]=cont;
            cont++;
            }
         }
      //alert(this.colADat);
      }


   // Genera punteros internos a capas relacionadas
   // ................................................  generaVariablesCapas
   this.generaVariablesCapas = function() {
      //Cpxxx 
      //DrGeneraCapaScript("Cp"+this.nombre,'visible','',this.NSdoc);
      DrGeneraCapaScript("Cp"+this.nombre,'visible','');

      //Si Scroll Nativo monto nsdoc (para que pueda focalizar bien y abrir las columnas)
      if (window.FLAG_SCR_NATIVO && window.FLAG_SCR_NATIVO=='S')  {
         eval("CpScroll"+this.nombre+".nsdoc='"+this.NSdoc+".CpScroll"+this.nombre+".document'");
         }

      //cpCab y cpDat
      if (this.altoCab==0) 
         this.cpCab=null
      else  {
         if (ns)  {
            var cab=eval("CpCab"+this.nombre+".nsLay");
            this.cpCab=eval(cab);
            }
         else  {
            this.cpCab=document.all["CpCab"+this.nombre];
            this.cpCab.style.overflow = "hidden"
            }
         }
      if (!window.FLAG_SCR_NATIVO || window.FLAG_SCR_NATIVO!='S')  {
         if (ns)  {
            var rut=eval("CpScroll"+this.nombre+".nsdoc");
            this.cpDat=eval(rut+".CpScroll"+this.nombre);
            }
         else  
            this.cpDat=document.all["CpScroll"+this.nombre];   
         }
      else  { //ie y scroll nativo
         this.cpDat=document.all["CpScroll"+this.nombre];   
         }

      if (!this.hayTitulo) 
         this.cpTit=null
      else  {
         if (ns)  {
            var cab=eval("CpTit"+this.nombre+".nsLay");
            this.cpTit=eval(cab);
            }
         else  {
            this.cpTit=document.all["CpTit"+this.nombre];
            this.cpTit.style.overflow = "hidden"
            }
         }
      }


   // calcula ultColNoOcul y colOcultas
   // .................................................  recalculaOcultas
   this.recalculaOcultas = function () {
      this.colOcultas=0;
      for (i=0;i<this.estadoCol.length;i++)
         if (this.estadoCol[i][0].toUpperCase() == "OCULTA")  
            this.colOcultas++;

      this.ultColNoOcul=this.anchos.length-1
      while (this.estadoCol[this.ultColNoOcul][0].toUpperCase() == "OCULTA")
         this.ultColNoOcul--;
      }


   // copia interna del array de datos
   // .................................................  resetDatosOld
   this.resetDatosOld = function () {
      this.datosOld=DrGeneraCopiaDeArray(this.datos);
      this.seleccOld=DrGeneraCopiaDeArray(this.selecc);
      }


   //reajusta la lista interna de seleccion 
   // .................................................  ajustaSelecc
   this.ajustaSelecc = function () { 
      var i;
      this.selecc=new Array();
      //Regenero la lista de estados para las filas
      for (i=0;i<this.datos.length;i++)  {
         this.selecc[i]=0; //Mejora: Que conserve los estados
         }
      this.filaSelecc=-1;
      }



   // ******************************************************************* RELATIVAS A SELECCIÓN / DESELECCIÓN


   //selecciona una opción con un cierto codigo
   // ................................................. seleccionaCod
   this.seleccionaCod = function (codigo,img) { // seleccionaCod
      var fila=DrIndiceEnArray(this.datos,codigo,0);
      if (fila==-1) {
         if (this.alertsDebug)
            this.daMensajeError("No existe la fila con codigo '"+codigo+"'");
         return -1; //Error
         }
      if (img==null)
         this.selecciona(fila);
      else
         this.selecciona(fila,img);
      }


   //selecciona una opción con un cierto numero de fila
   // ................................................. selecciona
   this.selecciona = function (indice,img) {
      //Esta función se llama cada vez que repintamos.
      this.filaSelecc=indice;
      //Si intento selecc. una ya selecc, salgo sin dar error
      if (indice<this.datos.length && this.selecc[indice]==1) {
         if (this.alertsDebug)
            this.daMensajeError("Se está intentando seleccionar una fila que ya estaba seleccionada.");
         return;
         }
      var n=this.numSelecc();
      if (this.maxSel>=0 && n>=this.maxSel )  {
         if (!this.deseleccSiMax)   {
            if (this.msgErrMaxSel!="")
               this.daMensajeError(msgErrMaxSel);
            return -1;
            }
         else  {
            //Deselecciono la primera que esté seleccionada.
            var enc=false,ind=0;
            while (!enc && ind<this.selecc.length) {
               if (this.selecc[ind]==1)   {
                  enc=true;
                  }
               ind ++;
               }
            this.deselecciona (ind-1);
            //this.selecc[indice]==1
            }
         }
      if (indice<this.datos.length)
         this.selecc[indice]=1
      //Si le pasamos img es la imagen del boton
      if (img==null)
         this.modifImgBtnFila(indice,this.btnSel);
      else
         this.modifImgBtnFila(indice,img);//desresaltaFila marcaFila
      if (ie && this.colSel!="")
         this.ponColorFondoFila(indice,this.colSel);
      if (this.autoScroll)  {
         var ff=this.dameTR(indice)
         ff.scrollIntoView(false)
         }
      }


   this.dameTR = function (fila) {   // Retorna el TR correspondiente
      var j,tab=document.all["tblDat"+this.nombre];
      var fila;
      if (this.renderOptimizado || this.GrHDat > 0)
         fila=tab.rows(fila*2);
      else
         fila=tab.rows(fila);
      return fila;
      }

   //deselecciona una opción
   // .................................................  deselecciona
   this.deselecciona = function (indice,img) {
      this.filaSelecc=indice;
      if (indice<this.datos.length)
         this.selecc[indice]=0;
      //Si le pasamos img es la url de la imagen
      if (img==null)
         this.modifImgBtnFila(indice,this.btnOff);
      else
         this.modifImgBtnFila(indice,img);
      if (ie && this.colSel!="")
         this.ponColorFondoFila(indice,"");
      }


   //retorna el numero de filas seleccionadas
   // ................................................. numSelecc
   this.numSelecc = function () {
      var i,r=0;;
      for (i=0;i<this.selecc.length;i++)
         if (this.selecc[i]==1)
            r++
      return r;
      }
   
   
   //retorna los códigos de las opciones seleccionadas
   // .................................................  codSeleccionados
   this.codSeleccionados = function () {
      var i,r=new Array();
      for (i=0;i<this.datos.length;i++)
         if (this.selecc[i]==1)
            if (!DrExisteEnArray(r,this.datos[i][0]))  {
               r[r.length]=this.datos[i][0];
               }
      return r;
      }


   //retorna todos los códigos
   // .................................................  codigos
   this.codigos = function () {
      var i,r=new Array();
      for (i=0;i<this.datos.length;i++)
         r[r.length]=this.datos[i][0];
      return r;
      }


   //desactiva una opción
   // .................................................  desactiva
   this.desactiva = function (indice) {
      if (indice<this.datos.length)
         this.selecc[indice]=-1;
      //Busco las imagenes asociadas y las modifico:
      this.modifImgBtnFila(indice,this.btnDesac);
      }


   //reactiva una opción desactivada
   // .................................................  activa
   this.activa = function (indice) {
      if (indice<this.datos.length)
         this.selecc[indice]=0;
      //Busco las imagenes asociadas y las modifico:
      this.modifImgBtnFila(indice,this.btnOff);
      }


   //modifica las imagenes de boton de una fila
   // .................................................  modifImgBtnFila
   this.modifImgBtnFila = function (indice,url) {
      var i;
      for (i=0;i<this.tiposCol.length;i++)   {
         if ((this.tiposCol[i][0]).toUpperCase()=="BOTON")  {
            var nombre="img_"+this.nombre+"_"+indice+"_"+i;
            MM_swapImage(nombre,'',url,1);   
            }
         }
      }


   // ************************************************ RELATIVAS AL REFRESCO GRÁFICO 


   //Repinta y ajusta la lista completamente tras un cambio. Se pierden los estados de los botones.
   // .................................................  reajusta
   this.reajusta = function (noRepintar) {
      this.ajustaSelecc();
      //Esto lo último
      if (!noRepintar)
         this.repinta();
      }


   //Repinta. No ajusta la lista de seleccion si ha cambiado el numero de opciones
   // .................................................  repinta
   this.repinta = function () {
      this.repintaDat();
      this.repintaCab();
      //this.repintaTit();
      }


   //ensancha los anchos de las columnas hasta el mínimo si es que no lo alcanzan
   //Quita el ancho a las ocultas y le da un ancho mínimo a las minimizadas
   // .................................................  ajustaAnchosMinimos
   this.ajustaAnchosMinimos = function () {
      var acum=0,acum1=0;acum2=0;

      //acumulo los anchos de las columnas
      for (i=0;i<this.anchosOld.length;i++)  {
         var obj=this.estadoCol[i][0].toUpperCase();
         if (obj == "MINIMIZADA") {  
            acum1+=this.anchoColMinim //minimizada la considero fija
            }
         else if (obj != "OCULTA") {
            if ( this.tipoAnchos[i]!='F')
               acum+=this.anchosOld[i]; //Guardo total columnas no fijas
            else
               acum1+=this.anchosOld[i]; //Guardo total columnas fijas
            }
         }

      //Calculo el ancho mínimo deseado
      var anchoMinimo=this.ancho-(this.GrBorde*2)-(this.anchoScroll)-((this.anchosOld.length-this.colOcultas)*this.GrV);

      if (anchoMinimo>(acum+acum1)) { //No llegamos la ancho minimo
         for (i=0;i<this.anchos.length-1;i++) {
            var obj=this.estadoCol[i][0].toUpperCase();
            if (obj == "OCULTA")
               this.anchos[i]=0;
            else if (obj == "MINIMIZADA") {
               this.anchos[i]=this.anchoColMinim;
               }
            else  {
               if (this.tipoAnchos[i]!='F')  {
                  this.anchos[i]=Math.ceil( (this.anchosOld[i]*(anchoMinimo-acum1))/acum )
                  }
               else
                  this.anchos[i]=this.anchosOld[i];
               }
               acum2+=this.anchos[i]; //Sirve para el reajuste
            }
         //Reajusto usando la última columna
         this.anchos[this.anchosOld.length-1] = anchoMinimo-acum2;
         //Probl: si la última era oculta, muevo el valor hasta el anterior que no lo sea y lo sumo
         if (this.estadoCol[this.anchos.length-1][0].toUpperCase() == "OCULTA")   {
            this.anchos[this.ultColNoOcul]+=this.anchos[this.anchos.length-1];
            this.anchos[this.anchos.length-1]=0;
            }
         }
      else  {
         for (i=0;i<this.anchos.length;i++) {
            var obj=this.estadoCol[i][0].toUpperCase();
            if (obj == "OCULTA")
               this.anchos[i]=0;
            else if (obj == "MINIMIZADA") {
               this.anchos[i]=this.anchoColMinim;
               }
            else  {
               this.anchos[i]=this.anchosOld[i];
               }
            }
         }
      }

   //Controla los eventos de onclick sobre la fila cuando la selección es por filas (llamado desde repintaDat())
   this.elOnClick=function (i) {
      this.IDDBLCLICK=null
      if(this.selecc[i]==0)
         this.selecciona(i);
      else if(this.selecc[i]==1)
         this.deselecciona(i)
      if(this.selecc[i]!=-1){
         var FILAEVENTO=i;
         eval(this.accion);
         }
      }

   this.elOnDblClick=function (i)  {
      if(this.selecc[i]!=-1){
         if (this.IDDBLCLICK==null)
            return //Hemos hecho el click
         clearTimeout(this.IDDBLCLICK);
         if(this.selecc[i]==0)
            this.selecciona(i);
         else if(this.selecc[i]==1)
            this.deselecciona(i)
         var FILAEVENTO=i;
         eval(this.accionDobleClick);
         }
      }

// Repintado de los datos (versión rápida) con sus eventos

/*
            if (this.hayDobleClic)  {
               ondblclick=" ondblclick=\""+this.nombre+".elOnDblClick("+i+");\" ";
               onclick=this.nombre+".IDDBLCLICK=setTimeout('"+onclick+"',"+this.msegDobleClick+");";
               }
*/

   //this.aplicarTrucoIE55=(navigator && navigator.appVersion.indexOf("MSIE 5.5")!=-1)?true:false;


//Meter en plantilla renderOptimizado="S" [X]

//Meter en plantilla .brdTblDatLED td {border-right: 1px solid white; border-bottom: 2px solid #EEEEEE} [X]

      //Funcionalidades: 
         //datos [X]
         //bordes JS[X] XSL[X]
         //Col ocultas [X]
         //Col minimizadas [X]
         //Col tipo boton [X]
         //eventos rollover[X] seleccion[X] dobleclick[X]
         //Anchos [X]
         //Altos [X]
         //Campos de formulario[X]  probar[ ]
         //Ordenar por columnas[X]
         //Truco? [X]NO PARECE QUE MEJORE ¿¿¿???
         //Grupos Columnas [ ]
         //Desabilitados [X]
         //Probar los métodos de la lista
         //Javi quiere poder poner los bordes con estilos en vez de con los anchos. Quiere grupos.
         //Javi quiere que puedas modificar una fila concreta de la lista

      //this.renderOptimizado=true; //Llevar esto a la plantilla XX[X]

      //Arreglar indices (-1)? [X]
      //Que no escape aquí si no al pintar el elemento [ ]
      //Desaparecen los botones después de usarse ... [X]

      //Dificultades:
         // botones no ocupan lugar en datos
         // En ocultas?
         // primera columna de datos es de códigos y no se usa

   this.repintaDat_simplificado = function () {//Función de render rápido (¿ menos funcionalidad ?)
      var debeEscapar = /<|>|\"/;
      var minombre=this.nombre;
      var dat=this.datos;
      var elOnMouseOverTabla="",elOnMouseOutTabla="",elOnClickTabla="",elOnDblClickTabla="";

      if (this.colOn!="")   {
         elOnMouseOverTabla=" onMouseOver="+minombre+".onMouseOverTabla() "
         elOnMouseOutTabla=" onMouseOut="+minombre+".onMouseOutTabla() "
         }

      //if (this.colSel!="" || this.elOnClick!="") {
      if ((this.colOn!="" || this.colSel!="") && this.tipoSeleccion=="fila") {
         if (this.hayDobleClic)  {
            elOnClickTabla=" onClick=window.TOSrcEvent=window.event.srcElement;"+minombre+".IDDBLCLICK=setTimeout('"+minombre+".onClickTabla(true)',"+this.msegDobleClick+") "
            elOnDblClickTabla=" ondblclick="+minombre+".onDblclickTabla() "
            }
         else
            elOnClickTabla=" onClick="+minombre+".onClickTabla() "
         }
      var txt=[];
      txt.mete("<FORM action=\"\" name=\"form"+minombre+"\">")
      txt.mete("<TABLE ID=tblDat"+minombre+" border=0 cellspacing=0 cellpadding=0 class=brdTblDat"+minombre+" "+ elOnMouseOverTabla + elOnMouseOutTabla + elOnClickTabla + elOnDblClickTabla +">")
      //Preproceso:
      //preparo una matriz de columnas ocultas y minimizadas y de relación con el índice de la matriz de datos (por los botones)
      var colVisible=[], colMinimizada=[], colIndEnDatos=[];//Indice de la columna de datos asociada a esa columna de la lista. Relacionado con los botones
         //Hay que quitar la primera columna de los datos (codigo)
         //Hay que asociar columnas de datos solo a los tipos de columna que los requieran (boton no lo requiere)
      var columnaDatos=1;
      for (var c=0,tam=this.tiposCol.length;c<tam;c++)   {
         colVisible.mete( (this.estadoCol[c][0].toUpperCase()!="OCULTA")?true:false );
         colMinimizada.mete( (this.estadoCol[c][0].toUpperCase()!="MINIMIZADA")?false:true );
         if (this.tiposCol[c][0].toUpperCase() == "BOTON")
            colIndEnDatos.mete(-1);//Al boton le asignamos un -1
         else  {
            colIndEnDatos.mete(columnaDatos);
            columnaDatos++;
            }
         }
      var elHhtmlTr=(this.altoFila!='')?"<TR height="+this.altoFila+">":"<TR>"
      for (var f=0,tam=dat.length;f<tam;f++)   {//Por cada fila a partir de la segunda ...
         txt.mete(elHhtmlTr);
         for (var c=0,tam2=this.tiposCol.length;c<tam2;c++)   {//Por cada columna ...
            if (colVisible[c]) {//Si la columna es visible
               var cEst=this.estilosDat[c]
               var estilotd=cEst[f%(cEst.length)];
               txt.mete("<TD ID="+estilotd+">");
               var eldato="";
               if (colIndEnDatos[c]!=-1) { //Si no es boton  
                  var datoTemp = this.datos[f][colIndEnDatos[c]]+"";
                  if(debeEscapar.test(datoTemp))
                     eldato=DrdEscHTML(datoTemp)
                  else 
                     eldato=datoTemp;
                  }
               if (!colMinimizada[c]) {
                  var t2=this.nbsp+this.pintaElemento(this.tiposCol[c] , eldato ,f,c);
                  if (t2=="")
                     txt.mete("&nbsp;")//Para que se vean los estilos
                  else 
                     txt.mete(t2)
                  }
               else
                  txt.mete("&nbsp;");
               if (f==0)
                  txt.mete("<BR><div style=height:1;width:"+this.anchos[c]+"><x/></div>");
               txt.mete("</TD>");
               }
            }
         txt.mete("</TR>");
         }
      txt.mete("</TABLE>");
      scroll_to('CpScroll'+minombre,txt.join(''));
      if (!window.FLAG_SCR_NATIVO || window.FLAG_SCR_NATIVO!='S')  
         this.form=this.cpDat.document["form"+this.nombre]; 
      else  
         this.form=document["form"+this.nombre];
      this.cargaEstadoBotones(this.selecc);
      }

   /* Las siguientes funciones son solo para el pintado rapido : */

   this.onMouseOverTabla = function () {
      var elTR=event.toElement;
      while (elTR.tagName!="TR" && elTR.tagName!="TABLE" && elTR.parentElement)
         elTR=elTR.parentElement
      if (elTR.tagName!="TR")
         return
      if (this.colOn!="" && this.colSel!="")  {
         if(this.selecc[elTR.rowIndex]==0)
            this.ponColorFondoFila(elTR.rowIndex,this.colOn);
         }
      else if (this.colOn!="") {
         if(this.selecc[elTR.rowIndex]!=-1)
            this.ponColorFondoFila(elTR.rowIndex,this.colOn);
         }
      }

   this.onMouseOutTabla = function () {
      var elTR=event.fromElement; 
      while (elTR.tagName!="TR" && elTR.tagName!="TABLE" && elTR.parentElement)
         elTR=elTR.parentElement
      if (elTR.tagName!="TR")
         return
      if (this.colOn!="" && this.colSel!="")  {
         if(this.selecc[elTR.rowIndex]==0)
            this.ponColorFondoFila(elTR.rowIndex,"");
         }
      else if (this.colOn!="") {
         if(this.selecc[elTR.rowIndex]!=-1)
            this.ponColorFondoFila(elTR.rowIndex,"");
         }
      }

   this.onClickTabla = function (vengoDeTimeout) {
      if (vengoDeTimeout)
         var elTR=window.TOSrcEvent; 
      else
         var elTR=event.srcElement;
      while (elTR.tagName!="TR" && elTR.tagName!="TABLE" && elTR.parentElement)
         elTR=elTR.parentElement
      if (elTR.tagName!="TR")
         return;
      this.elOnClick(elTR.rowIndex)
      }

   this.onDblclickTabla = function () {
      if (this.IDDBLCLICK==null)
         return //Hemos hecho el click
      clearTimeout(this.IDDBLCLICK);
      var elTR=window.TOSrcEvent;
      while (elTR.tagName!="TR" && elTR.tagName!="TABLE" && elTR.parentElement)
         elTR=elTR.parentElement
      if (elTR.tagName!="TR")
         return;
      var FILAEVENTO=elTR.rowIndex;
      if(this.selecc[FILAEVENTO]==0)
         this.selecciona(FILAEVENTO);
      else if(this.selecc[FILAEVENTO]==1)
         this.deselecciona(FILAEVENTO)
      eval(this.accionDobleClick);
      }

   Array.prototype.mete= function (obj)   {//Mucho mas rapido que ir sumando en una cadena
      this[this.length]=obj;
      }
   /*Array.prototype.concatena= function (obj)   {
      return (this.join(''))
      }*/

   this.dameTrConIndice=function (indice)  {
      return document.all["tblDat"+this.nombre].rows(indice);
      }





// -.-.-.-.-.-.-.-.




   //Repinta la lista de datos
   // .................................................  repintaDat
   this.repintaDat = function () {
      if (this.numPintadosDat==0 && this.datos.length==0)
         return
      this.numPintadosDat++;
      if (this.renderOptimizado)
         this.repintaDat_simplificado();
      else
         this.repintaDat_normal();
      }

   this.repintaDat_normal = function ()   {
      var i,j,txt="";
      txt+="<form action=\"\" name=\"form"+this.nombre+"\">";
      txt+="<table ";
      if (!ns) 
         txt+=" ID=\"tblDat"+this.nombre+"\" ";
      txt+="border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >";
      for (i=0;i<this.datos.length;i++)   {//Por cada fila ...
         var celdaReal=0;
         if (!ns && (this.colOn!="" || this.colSel!="") && this.tipoSeleccion=="fila") {//Preparamos el javascript del rollover y la seleccion de FILA
            var onmover="",onmout="",onclick="",ondblclick="";
            if (this.colOn!="" && this.colSel!="")  {
               onmover="if("+this.nombre+".selecc["+i+"]==0) "+this.nombre+".resaltaFila("+i+")";
               onmout="if("+this.nombre+".selecc["+i+"]==0) "+this.nombre+".desresaltaFila("+i+")";
               }
            else if (this.colOn!="") {
               onmover="if("+this.nombre+".selecc["+i+"]!=-1) "+this.nombre+".resaltaFila("+i+")";
               onmout="if("+this.nombre+".selecc["+i+"]!=-1) "+this.nombre+".desresaltaFila("+i+")";
               }
            onclick=this.nombre+".elOnClick("+i+");";//Optimizar, no nos haría falta lo anterior
            //Ahora modificamos si hay necesidad de diferenciar click simple de doble click
            if (this.hayDobleClic)  {
               ondblclick=" ondblclick=\""+this.nombre+".elOnDblClick("+i+");\" ";
               onclick=this.nombre+".IDDBLCLICK=setTimeout('"+onclick+"',"+this.msegDobleClick+");";
               }
            txt+="<tr onmouseover=\""+onmover+"\")' onmouseout=\""+onmout+"\" onclick=\""+onclick+"\" "+ondblclick+">";
            }
         else
            txt+="<tr>";

         var botonesTratados=0; // para saber que columna de datos tomar. Los botones no ocupan "dato"

         //Pinto cada columna de la fila
         var anch=0;
         var conta=this.tiposCol.length-this.colOcultas; //Lo uso para controlar cual es la última col. visible (campos ocult)
         for (j=1;j<this.tiposCol.length+1;j++)   { //Por cada columna ...
            if (this.estadoCol[j-1][0].toUpperCase() != "OCULTA")  {
               conta--; //En realidad solo lo uso para NS
               var elancho=this.anchos[j-1];
               if (ns && conta==0)               
                  elancho--; // ya que vamos a meter una columna más de un pixel para meter un último <a/>
               var estil=this.estilosDat[j-1][i%(this.estilosDat[j-1].length)];

               //Si la selección es por CELDAS preparo el javascript:
               var onmover="",onmout="",onclick="";
               if (!ns && (this.colOn!="" || this.colSel!="") && this.tipoSeleccion=="celda") {//Preparamos el javascript del rollover y la seleccion de CELDA
                  if (this.colOn!="" && this.colSel!="")  {
                     onmover="var ll="+this.nombre+"; if (ll.celdSelecc[0]!="+i+" || ll.celdSelecc[1]!="+j+") ll.resaltaCelda("+i+","+celdaReal+")";
                     onmout="var ll="+this.nombre+";if (ll.celdSelecc[0]!="+i+" || ll.celdSelecc[1]!="+j+") ll.desresaltaCelda("+i+","+celdaReal+")";
                     onclick=" var ll="+this.nombre+"; if (ll.celdSelecc[0]!=-1){ll.desresaltaCelda(ll.celdSelecc[0],ll.celdSelecc[2])} ;ll.ponColorFondoCelda("+i+","+celdaReal+",ll.colSel); "
                     //onclick="if("+this.nombre+".selecc["+i+"]==0){"+this.nombre+".selecciona("+i+")} else if("+this.nombre+".selecc["+i+"]==1) {"+this.nombre+".deselecciona("+i+")};";
                     }
                  onclick+="var ll="+this.nombre+"; if(ll.celdSelecc[0]!="+i+" || ll.celdSelecc[1]!="+j+" || ll.celdSelecc[2]!="+celdaReal+"){ll.celdSelecc=["+i+","+j+","+celdaReal+"];var FILAEVENTO="+i+";"+ DrdEscHTML(this.accion)+"}";
                  //txt+="<tr onmouseover=\""+onmover+"\")' onmouseout=\""+onmout+"\" onclick=\""+onclick+"\">";
                  }
               if (onmover!="") onmover=" onmouseover=\""+onmover+"\" ";
               if (onmout!="") onmout=" onmouseout=\""+onmout+"\" ";
               if (onclick!="") onclick=" onclick=\""+onclick+"\" ";

               txt+="<td "+(this.nowrap?"nowrap":"")+" "+onmover+onmout+onclick+" height=\""+this.altoFila+"\"  ID=\""+estil+"\"  class=\""+estil+"\">"

               if (this.tiposCol[j-1][0].toUpperCase() == "BOTON")  {
                  txt+=this.pintaElemento(this.tiposCol[j-1],"",i,j-1);
                  botonesTratados++;
                  }
               else  if (this.estadoCol[j-1][0] != "MINIMIZADA")  {
                  txt+=this.nbsp+this.pintaElemento(this.tiposCol[j-1],DrdEscHTML(this.datos[i][j-botonesTratados]),i,j-1);
                  }
               else if (this.estadoCol[j-1][0] == "MINIMIZADA" && ns)   {
                  txt+="&nbsp;" //Para que aparezcan los estilos
                  }

               if (i==0)   {
                  txt+="<br>";
                  if (ns && j>1) {
                     //txt+="<a NAME=\"c"+(j-2)+"\" >";//Si NS meto esto para calcular luego posiciones
                     txt+="<a NAME=\"c"+anch+"\" >";//Si NS meto esto para calcular luego posiciones
                     anch ++;
                     }
					txt+="<img style=\"visibility:hidden\" width=\""+elancho+"\" height=\"1\">";
                  if (ns) 
                     txt+="</a>";
                  }
               txt+="</td>";
               celdaReal++;

               if(ns && conta==0) { //En NS ponemos al final una celda más con el <a/> necesario para calcular
                  if (i==0)
                     txt+="<td width=\"1\" ID=\""+this.estilosDat[j-1][0]+"\" class=\""+this.estilosDat[j-1][0]+"\"><a NAME=\"c"+anch+"\" ><img style=\"visibility:hidden\"  width=\"1\" height=\"3\"></a></td>";
                  else
                     txt+="<td ID=\""+this.estilosDat[j-1][0]+"\" class=\""+this.estilosDat[j-1][0]+"\"><img style=\"visibility:hidden\" width=\"1\" height=\"3\"></td>";
                  celdaReal++;
                  }

               if (this.GrV>0) { //ponemos la linea vertical
                  txt+="<td bgcolor=\""+this.ColVDat+"\" width=\""+this.GrV+"\">";
                  txt+="<img style=\"visibility:hidden\" width=\""+this.GrV+"\" height=\"1\">";
                  txt+="</td>";
                  celdaReal++;
                  }
               }
            }
         txt+="</tr>";

         if (GrHDat>0) {
            var elcolspan=this.anchos.length - this.colOcultas;
            if (this.GrV>0)
               elcolspan=elcolspan*2;
            if (ns)
               elcolspan++;
            txt+="<tr bgcolor=\""+this.ColHDat+"\"><td colspan=\""+elcolspan+"\" height=\""+this.GrHDat+"\"><img style=\"visibility:hidden\" height=\""+this.GrHDat+"\"></td></tr>";
            }

         }
      txt+="</table>";

      scroll_to('CpScroll'+this.nombre, txt); 

      onScrollNativoIE('CpScroll'+this.nombre)

      //Regeneramos el puntero al formulario
      if (!window.FLAG_SCR_NATIVO || window.FLAG_SCR_NATIVO!='S')  
         this.form=eval("this.cpDat.document.form"+this.nombre); 
      else  
         this.form=eval("document.form"+this.nombre); 

      //Actualizamos el estado de los botones
      this.cargaEstadoBotones(this.selecc);
      }


   //repinta el titulo
   // .................................................  cargaEstadoBotones
   this.repintaTit = function () {
      if (!this.hayTitulo)
         return;
      //this.datosTitulo=datosTitulo; //datos de la linea de titulo, si los hay: (Si no existe, [])   [texto,@ID]
      var txt=this.datosTitulo[0];
      txt="<td class=\""+this.datosTitulo[1]+"\" id=\""+this.datosTitulo[1]+"\">"+this.nbsp+txt+"</td>";
      if (this.GrBorde && this.GrBorde>0)
         txt="<td width=\""+this.GrBorde+"\"><img style=\"visibility:hidden\" width=\""+this.GrBorde+"\" height=\"1\"></td>"
            +txt
            +"<td width=\""+this.GrBorde+"\"><img style=\"visibility:hidden\" width=\""+this.GrBorde+"\" height=\"1\"></td>"
      txt="<table width=\"100%\" height=\""+this.datosTitulo[2]+"\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr>"+txt+"</tr></table>";

      if (ns)  {
         this.cpTit.document.open()
         this.cpTit.document.write(txt)
         this.cpTit.document.close()
         }
      else
         this.cpTit.innerHTML=txt;
      }

   
   //carga los estados de boton que se le pasen
   // .................................................  cargaEstadoBotones
   this.cargaEstadoBotones = function (nuevoSelecc) {
      for (i=0;i<nuevoSelecc.length;i++)  {
         if (nuevoSelecc[i]==1)  {
            if (this.selecc[i]==1)
               this.selecc[i]=0;
            this.selecciona(i);
            }
         else if (nuevoSelecc[i]==-1)
            this.desactiva(i); 
         }
      }


   //Repinta la cabecera de la lista en función de la lista de datos
   // .................................................  repintaCab
   this.repintaCab = function () {

      var cabWrap=this.nowrap?" nowrap ":"";

      if (this.altoCab==0)
         return;
      if (!this.repintarCab)
         return;
      var i,txt="";

      //Calculo anchosCab
      if (this.datos.length==0)  {//Si no hay datos la pinto normal... 
         var c,anchosCab=new Array();
         for (c=0;c<this.anchos.length;c++)
            if (this.estadoCol[c][0].toUpperCase() != "OCULTA")
               anchosCab[anchosCab.length]=this.anchos[c]
         }
      else  {//Si hay datos utilizo sus anchos
         //Calculo los anchos de las imagenes
         var anchosCab= new Array();
         if (window.ns)  {
            var lax,acum=0;
            for (i=0;i<(this.anchos.length-1-this.colOcultas);i++)  {
               lax=this.cpDat.document.anchors["c"+i].x - this.GrV;
               anchosCab[i]=lax-acum; 
               acum += (this.cpDat.document.anchors["c"+i].x - acum);
               }
            lax=this.cpDat.document.anchors["c"+(this.anchos.length-1-this.colOcultas)].x;
            anchosCab[this.anchos.length-1-this.colOcultas]=lax-acum+1;
            }
         else  { //(if IE)
            var celdas=document.all["tblDat"+this.nombre].rows[0].cells;
            for (i=0;i<this.anchos.length-this.colOcultas;i++)  {
               if (this.GrV==0 || this.renderOptimizado) 
                  anchosCab[i]=(celdas(i).clientWidth);
               else
                  anchosCab[i]=(celdas(i*2).clientWidth);
               }
            }
         }
      
      txt+="<table border=0 cellspacing=0 cellpadding=0>";

      //PRIMERA FILA
      txt+="<tr>";

      var segundaFilaGrp=""; //Si hay agrupaciones preparamos también las siguientes filas de la tabla
      var terceraFilaGrp="";

      var rspan=0;
      
      if (this.hayGruposCab)  {
         if (this.GrV>0)
            rspan="rowspan=\"3\"";
         else
            rspan="rowspan=\"2\""; //Porque no hay línea horizontal separando la cabecera de la subcabecera
         }

      var primGrupNoOculta=-1;

      //Calculo para luego la primera columna no oculta
      var primNoOculta=-1;
      for (i=0;i<this.estadoCol.length && primNoOculta==-1;i++)   
         if (this.estadoCol[i][0].toUpperCase() != "OCULTA")
            primNoOculta=i;

      //Y ahora trato cada columna, ya sea generando la celda o preparandola para la siguiente fila si hay grupos
      for (i=0;i<anchosCab.length+this.colOcultas;i++)  { //Por cada columna ...

         var elestilo=this.estilosCab[i];

         var obj=this.estadoCol[i][0].toUpperCase();

         var estoyEnCeldaAgrupada=(this.hayGruposCab && this.grpCab[i]!=null);
         var colSpanAgrupada="";
        
         if (estoyEnCeldaAgrupada)   {

            if (this.grpCab[i].length>0)   { // Y si es la primera del grupo (la que tengo que procesar con colspan), el resto las ignoro
               //Calculo el colSpan. Si sale igual a -1 están ocultas todas
               var colOcultasGrupo=0;
               for (var fff=i;fff< (i+this.grpCab[i][0]);fff++)   
                  if (this.estadoCol[fff][0].toUpperCase() == "OCULTA")
                     colOcultasGrupo++;

               if (this.GrV > 0)
                  colSpanAgrupada=((2 * (this.grpCab[i][0] - colOcultasGrupo)) -1); //He de quitar las columnas ocultas
               else
                  colSpanAgrupada=(( (this.grpCab[i][0] - colOcultasGrupo)) ); //He de quitar las columnas ocultas

               //Calculo la primera no oculta
               primGrupNoOculta=-1
               for (fff=i;fff< (i+this.grpCab[i][0]) && primGrupNoOculta==-1;fff++)   {
                  if (this.estadoCol[fff][0].toUpperCase() != "OCULTA")
                     primGrupNoOculta=fff;
                  }
               if (colSpanAgrupada!=-1) { //Si no esta oculto todo el grupo
                  //barra vertical
                  if (i>primNoOculta && GrV>0)   
                     txt+="<td  bgcolor=\""+this.ColVCab+"\" "+rspan+"><img style=\"visibility:hidden\" width=\"1\" height=\""+this.altoCab+"\"></td>"
                  //Celda con nombre del grupo
                  txt+="<td  height=\""+Math.round((this.altoCab/2)-1)+"\" bgcolor=\""+this.grpCab[i][3]+"\" colspan=\""+ colSpanAgrupada  +"\" class=\""+this.grpCab[i][2]+"\" id=\""+this.grpCab[i][2]+"\" style=border:none>";
                  txt+=this.nbsp+this.grpCab[i][1];
                  txt+="</td>";
                  if (this.GrV>0)
                     segundaFilaGrp+="<td  height=\""+this.GrV+"\" bgcolor=\""+this.ColVCab+"\" colspan=\""+ colSpanAgrupada  +"\"><img style=\"visibility:hidden\" width=\"1\" height=\""+this.GrV+"\"></td>";
                  }
               }
            }

         //Resto de la celda. Solo se añade ahora si no estaba agrupada. Si está agrupada se prepara para la tercera fila (terceraFilaGrp)

         if (obj != "OCULTA")  { //Si no es oculta ...
            //var txtFocus=" onfocus=\"if (document.all['CpScroll"+this.nombre+"']) document.all['CpScroll"+this.nombre+"'].focus(); if (document.all['CpScroll"+this.nombre+"'].onscroll) document.all['CpScroll"+this.nombre+"'].onscroll()\"";
            //var txtFocus=" onfocus=\"if (document.all['CpScroll"+this.nombre+"']) document.all['CpScroll"+this.nombre+"'].focus();";
            var txtFocus=""

            //if (i<=primNoOculta)
            //txtFocus=" onfocus=\"focalizaPrimeroEnLista('"+this.nombre+"');\" ";

            eval("CpCab"+this.nombre).asociax='CpScroll'+this.nombre;
            eval("CpCab"+this.nombre).tipoAsoc='scrollInterno';
            eval("CpCab"+this.nombre).xoffset=2;

            txtFocus=" onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+";onScrollNativoIE('CpCab"+this.nombre+"')\" ";

            //barra vertical (celdas no agrupadas)
            if (i>primNoOculta && GrV>0 && !estoyEnCeldaAgrupada)   
               txt+="<td  bgcolor=\""+this.ColVCab+"\" "+rspan+"><img style=\"visibility:hidden\" width=\"1\" height=\""+this.altoCab+"\"></td>"

            //barra vertical (celdas agrupadas, solo preparo)
            //if (estoyEnCeldaAgrupada && this.grpCab[i].length==0 ) //agrupada pero no la primera del grupo
            if (estoyEnCeldaAgrupada && i>primGrupNoOculta && this.GrV>0) //agrupada pero no la primera del grupo
               terceraFilaGrp +="<td  bgcolor=\""+this.ColVCab+"\" ><img style=\"visibility:hidden\" width=\"1\" height=\""+Math.round((this.altoCab/2)-1)+"\"></td>";

            // celda con el texto de la columna
            var eltexto="";
            if (obj!="MINIMIZADA") { //sin minimizar

               eltexto=this.txtCab[i];
               var txtBtnOrd="";
               if(this.hayBtnOrdenar && i==this.ultimaOrdenada){
                  if (this.estOrden[i])
                     txtBtnOrd="<img src=\""+this.btnOrd+"\" border=\"0\" align=\"middle\" >";
                  else
                     txtBtnOrd="<img src=\""+this.btnOrdInv+"\" border=\"0\" align=\"middle\" >";              
                  }

               if ( this.ordenarCol || this.onClickColumna )  {
                  var eltexto2="<a "+txtFocus+" onclick=\""
                  if (this.onClickColumna)
                     eltexto2+="var COLUMNAEVENTO="+i+";"+DrEscHTML(this.onClickColumna)+";";
                  if (this.ordenarCol)
                     eltexto2+=this.nombre+".ordenaPorColumna("+i+");"
                  eltexto2+="return false;\" class=\""+elestilo+"\" id=\""+elestilo+"\" style=border:none href='JavaScript:void(null)'>"+eltexto+txtBtnOrd+"</a>"
                  eltexto=eltexto2;
                  }

               eltexto=this.nbsp+eltexto;
               if (this.colMinimiz[i]==1) {
                  var nombreImg="img_"+this.nombre+"_"+i;
                  var txtNombre=(ns)?"":"  name=\""+nombreImg+"\"  "
                  var onmouseover="";
                  var onmouseout="";
                  if (this.btnConROver && ie)   {
                     onmouseover=" onmouseOver=\"MM_swapImage('"+nombreImg+"','','"+this.btnMinS+"',1)\" ";
                     onmouseout=" onmouseOut=\"MM_swapImgRestore()\"";
                     }
                  var enlazMinim="<a "+txtFocus+onmouseover+onmouseout+" href='JavaScript:void(null)' onclick=\""+this.nombre+".minimiza("+i+");return false;\"><img src=\""+this.btnMinN+"\" "+txtNombre+" border=\"0\" align=\"middle\" ></a>"
                  eltexto="<table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td  align=\"left\" class=\""+elestilo+"\" id=\""+elestilo+"\" style=border:none>"+eltexto+"</td><td align=\"right\">"+enlazMinim+"</td></tr></table>"
                  }
               }
            else  {  //Estaba minimizada ...          
               var nombreImg="img_"+this.nombre+"_"+i;
               var onmouseover="";
               var onmouseout="";
               if (this.btnConROver && ie)   {
                  onmouseover="MM_swapImage('"+nombreImg+"','','"+this.btnMaxS+"',1)";
                  onmouseout="MM_swapImgRestore()";
                  }
               var txtNombre=(ns)?"":"  name=\""+nombreImg+"\"  "
               var txtEtiq=(this.txtMinim?this.nbsp+this.txtCab[i]:"")
               eltexto="<a "+txtFocus+" href='JavaScript:void(null)'  onclick=\""+this.nombre+".maximiza("+i+");return false;\" class=\""+elestilo+"\" id=\""+elestilo+"\" style=border:none "+ (onmouseout!=""?"onMouseOut=\""+onmouseout+"\"":"") +  (onmouseover!=""?" onMouseOver=\""+onmouseover+"\"":"") +">"+txtEtiq+"<img src=\""+this.btnMaxN+"\" "+txtNombre+" border=\"0\" align=\"middle\" ></a>"
               }

            if (estoyEnCeldaAgrupada) { 
               terceraFilaGrp+="<td  height=\""+Math.round((this.altoCab/2)-this.GrV)+"\" "+(this.coloresCab[i]!=''?" bgcolor=\""+this.coloresCab[i]+"\" ":"")+" id=\""+elestilo+"\" class=\""+elestilo+"\" "+cabWrap+">"+eltexto+"</td>";
               }
            else  {
               var elTooltip="";
               if (this.tooltipsCab[i]!="")
                  elTooltip=" title=\"" + DrEscHTML(this.tooltipsCab[i]) + "\" ";
               if (this.ajustarAMitadInf) {
                  txt+="<td "+elTooltip+" valign=\"bottom\" "+rspan+" height=\""+this.altoCab+"\" "+(this.coloresCab[i]!=''?" bgcolor=\""+this.coloresCab[i]+"\" ":"")+" "+cabWrap+">"
                        +"<table width=\"100%\" height=\""+Math.round((this.altoCab/2)- this.GrV )+"\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td id=\""+elestilo+"\" class=\""+elestilo+"\"  >"
                        +eltexto
                        +"</td></tr></table>"
                     +"</td>";
                  }
               else
                  txt+="<td "+elTooltip+" "+rspan+" height=\""+this.altoCab+"\" "+(this.coloresCab[i]!=''?" bgcolor=\""+this.coloresCab[i]+"\" ":"")+" id=\""+elestilo+"\" class=\""+elestilo+"\" "+cabWrap+">"+eltexto+"</td>";
               }
            }
         }


      //Además creo la columna del scroll
      if (this.GrV>0)   
         txt+="<td bgcolor=\""+this.ColVCab+"\" "+rspan+"><img style=\"visibility:hidden\" width=\"1\" height=\"1\"></td>";
      var clscr=(this.ColFonScr!='')?" bgcolor=\""+this.ColFonScr+"\" ":""
      txt+="<td "+rspan+" "+clscr+" id=\""+this.estilosCab[this.ultColNoOcul]+"\" class=\""+this.estilosCab[this.ultColNoOcul]+"\" ><img style=\"visibility:hidden\" width=\"1\" height=\"1\"></td>"; //Por el SCROLL
      txt+="<td "+rspan+" bgcolor=\""+this.ColVCab+"\"><img style=\"visibility:hidden\" width=\"1\" height=\"1\"></td>";
      txt+="</tr>"

      //Si había grupos he de crear la segunda y tercera filas
      if (this.hayGruposCab) {
         if (segundaFilaGrp!="") txt+="<tr>" + segundaFilaGrp + "</tr>"; //"<tr><td colspan=\"3\"></td></tr>";
         txt+="<tr>" + terceraFilaGrp + "</tr>"; 
         }

      //FILA

      var colsp=(anchosCab.length)
      if (this.GrV>0)
         colsp=colsp*2;
      colsp+=2;
      txt+="<tr><td colspan=\""+colsp+"\" height=\""+this.GrHCab+"\"></td></tr>";

      //FILA

      //Para fijar los anchos ...
      var txtUltFila="<tr>";
      for (i=0;i<anchosCab.length;i++)  { 
         if (i>0 )   {
            if (this.GrV>0)
               txtUltFila+="<td><img style=\"visibility:hidden\" width=\""+this.GrV+"\" height=\"1\"></td>"
            }
         txtUltFila+="<td><img style=\"visibility:hidden\" width=\""+anchosCab[i]+"\" height=\""+this.GrBorde+"\"></td>";
         }
      if (this.GrV>0)
         txtUltFila+="<td><img style=\"visibility:hidden\" width=\""+this.GrV+"\" height=\"1\"></td>";
      txtUltFila+="<td><img style=\"visibility:hidden\" width=\""+this.anchoScroll+"\" height=\"1\"></td>"; //Por el SCROLL
      txtUltFila+="<td><img style=\"visibility:hidden\" width=\"1\" height=\"1\"></td>";
      txtUltFila+="</tr>"

      txt+=txtUltFila + "</table>";

      //Por último introducimos el txt en la capa
      if (ns)  {
         this.cpCab.document.open()
         this.cpCab.document.write(txt)
         this.cpCab.document.close()
         }
      else
         this.cpCab.innerHTML=txt;

      //ppp=window.open();
      //ppp.document.body.innerTEXT=txt;
      //         if (this.ajustarAMitadInf) alert(txt);
      //alert(txt);
      }


   // Retorna el código html de un elemento de datos según su tipo
   // .................................................  pintaElemListado (aux)
   this.pintaElemento = function (def,dato,fila,col) { 
      var obj=def[0].toUpperCase();

      switch (obj)   {
      //if (obj=="TEXTO")
      case "TEXTO":
         return dato;
         break;
      case "BOTON":
      //else if (obj=="BOTON") {
         var nombreImg="img_"+this.nombre+"_"+fila+"_"+col;
         var onclick="",onmouseover="",onmouseout="";
         if (this.btnConROver)   {
            if (ie)
               onclick="window.event.cancelBubble=true;"; 
            onmouseover="if("+this.nombre+".selecc["+fila+"]==0){MM_swapImage('"+nombreImg+"','','"+this.btnOn+"',1)}";
            onmouseout="if("+this.nombre+".selecc["+fila+"]==0){MM_swapImgRestore()}";
            }
         else  {
            if (ie)
               onclick="window.event.cancelBubble=true;";
            onmouseover="";
            onmouseout="";
            }
         onclick+="if("+this.nombre+".selecc["+fila+"]==0){"+this.nombre+".selecciona("+fila+")} else if("+this.nombre+".selecc["+fila+"]==1) {"+this.nombre+".deselecciona("+fila+")};"; //XXX
         onclick+="if("+this.nombre+".selecc["+fila+"]!=-1){var FILAEVENTO="+fila+";"+ DrdEscHTML(this.accion)+";}";
         return "<a onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" href=\"JavaScript:void(null)\" "+ (onmouseout!=""?"onMouseOut=\""+onmouseout+"\"":"") +  (onmouseover!=""?" onMouseOver=\""+onmouseover+"\"":"") +" onclick=\""+onclick+"\"><img src=\""+this.btnOff+"\" name=\""+nombreImg+"\" border=\"0\" ></a>";
         //}
         break;
      //else if (obj=="COMBO") {
      case "COMBO":
         var i,txt="",txt2="";
         var elonchange=(def[7] && def[7]!="")?" onchange=\"FILAEVENTO="+fila+";"+DrEscHTML(def[7])+"\" ":"";
         var eldisabled=(def[8])?" disabled=\"true\" ":"";
         var elonshtab="",elontab="",elonkeydown="";
         if (def[9] != "" || def[10] != "")  {
            if (def[9] != "")
               elonkeydown+="if(!event.shiftKey) {" +def[9]+ "} ";
            if (def[10] != "")
               elonkeydown+="if(event.shiftKey) {" +def[10]+ "} ";
            elonkeydown=" onkeydown=\"var FILAEVENTO="+fila+";if (event.keyCode==9) {" + elonkeydown + "}\" ";
            }
         txt+="<SELECT onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" " + elonkeydown + eldisabled + elonchange + (ie?"onclick=\"window.event.cancelBubble=true;\"":"")+" SIZE=\""+def[6]+"\" CLASS=\""+def[3]+"\"  NAME=\""+def[1]+"_"+fila+"\" ID=\""+def[3]+"\" "+(def[5]?"multiple":"")+" >"
         if (def[2].length==0) //Si la combo está vacía ...
            txt+="<OPTION VALUE=\"\"></OPTION>";    
         for (i=0;i<def[2].length;i++) {
            if (def[2][i][0]==dato)
               txt2=" SELECTED ";
            else 
               txt2="";
            txt+="<OPTION "+txt2+" VALUE=\""+def[2][i][0]+"\">"+def[2][i][1]+"</OPTION>";        
            }
         txt+="</SELECT>"
         return txt;
         //}
         break;
      //else if (obj=="CAJATEXTO") {
      case "CAJATEXTO":
         var elonshtab="",elontab="",elonkeydown="",elonfocus="";
         if (def[9] != "" || def[10] != "" || def[12] != "")  {
            if (def[9] != "")
               elonkeydown+="if(!event.shiftKey) {" +def[9]+ "} ";
            if (def[10] != "")
               elonkeydown+="if(event.shiftKey) {" +def[10]+ "} ";
            if (def[9] != "" || def[10] != "" )
               elonkeydown="if (TECLAEVENTO==9) {" + DrEscHTML(elonkeydown) + "} "
            elonkeydown=" onkeydown=\"var TECLAEVENTO=event.keyCode;var FILAEVENTO="+fila+";"+elonkeydown+DrEscHTML(def[12])+" \" ";
            }
        /* if (def[11] != "" )
            elonfocus=DrEscHTML(def[11])*/
         var elonBlur=(def[11] && def[11]!="")?" onblur=\"var FILAEVENTO="+fila+";"+DrEscHTML(def[11])+"\" ":"";
         var elonBlur=(def[11] && def[11]!="")?" onblur=\"var FILAEVENTO="+fila+";"+DrEscHTML(def[11])+"\" ":"";
         var elonchange=(def[7] && def[7]!="")?" onchange=\"var FILAEVENTO="+fila+";"+DrEscHTML(def[7])+"\" ":"";
         if (def[13] && def[13]!="")
            elonfocus=" onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"var FILAEVENTO="+fila+";"+DrEscHTML(def[13])+"\" "
         else
            elonfocus=" onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" "
         var eldisabled=(def[8])?" disabled=\"true\" ":"";
         var txt="<INPUT " + elonfocus + elonkeydown + eldisabled + (ie?" onclick=\"window.event.cancelBubble=true;\"":"")+" TYPE=\"text\" CLASS=\""+def[4]+"\" ID=\""+def[4]+"\" NAME=\""+def[1]+"_"+fila+"\" VALUE=\""+dato+"\" SIZE=\""+def[2]+"\" MAXLENGTH=\""+def[3]+"\" "+elonchange+elonBlur+"></INPUT>";
         return txt;
         //}
         break;
      //else if (obj=="AREATEXTO") {
      case "AREATEXTO":
         var cc="",rr="";
         if (def[2]!=null) cc=" rows=\""+def[2]+"\" ";
         if (def[3]!=null) rr=" cols=\""+def[3]+"\" ";
         var elonkeydown="";
         if (def[8] != "")
            elonkeydown+="if(!event.shiftKey) {" +def[8]+ "} ";
         if (def[9] != "")
            elonkeydown+="if(event.shiftKey) {" +def[9]+ "} ";
         if (def[8] != "" || def[9] != "" )  {
            elonkeydown=" var TECLAEVENTO=event.keyCode;var FILAEVENTO="+fila+";if (TECLAEVENTO==9) {" + DrEscHTML(elonkeydown) + "} "
            elonkeydown=" onkeydown=\""+elonkeydown+" \" ";
            }
         var txt="<textarea  onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" "+cc+rr+" NAME=\""+def[1]+"_"+fila+"\" "+(ie?"onclick=\"window.event.cancelBubble=true;\"":"")+" CLASS=\""+def[4]+"\" "+elonkeydown+" ID=\""+def[4]+"\" >"+dato+"</textarea>";
         return txt;
         //}
         break;
      //else if (obj=="CHECKBOX") {
      case "CHECKBOX":
         var elonshtab="",elontab="",elonkeydown="";
         if (def[4] != "" || def[5] != "")  {
            if (def[4] != "")
               elonkeydown+="if(!event.shiftKey) {" +def[4]+ "} ";
            if (def[5] != "")
               elonkeydown+="if(event.shiftKey) {" +def[5]+ "} ";
            elonkeydown=" onkeydown=\"var FILAEVENTO="+fila+";if (event.keyCode==9) {" + elonkeydown + "}\" ";
            }
         var elonchange=(def[3] && def[3]!="")?" onclick=\"FILAEVENTO="+fila+";"+DrEscHTML(def[3])+";cancelaEventos()\" ":" onclick=\"cancelaEventos()\" ";
         var eldisabled=(def[6])?" disabled=\"true\" ":"";
         var txt="<input  onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" type=\"checkbox\" "+ elonkeydown + elonchange + ((dato=='s' || dato=='S')?" CHECKED ":"") +" name=\""+def[1]+"_"+fila+"\" value=\"S\" "+eldisabled+">";
         return txt;
         //}
         break;
      //else if (obj=="RADIOBUTTON") {
      case "RADIOBUTTON":
         var txt="";
         var elonclick=(def[4] && def[4]!="")?" onclick=\"var FILAEVENTO="+fila+";"+DrEscHTML(def[4])+";cancelaEventos()\" ":" onclick=\"cancelaEventos()\" ";
         for (var j=0;j<def[2].length;j++){
            txt+="<INPUT  onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" "+elonclick+" TYPE=\"radio\" NAME=\""+def[1]+"_"+fila+"\" VALUE=\""+def[2][j][0]+"\" "+((dato==def[2][j][0])?"CHECKED":"")+" "+elonchange+" >"+def[2][j][1];
            }
         return txt;
         //}
         break;
      //else if (obj=="HIPERENLACE") {
      case "HIPERENLACE":
         var est=(def[1])?" CLASS=\""+def[1]+"\" ID=\""+def[1]+"\" "  : "";
         var arr=dato.split("|")
         var tex=arr[0]
         var href=(arr[1])?arr[1]:arr[0];
         var ret=";return false;";
         if (href==''||href==' ')
            href='JavaScript:void(null)';
         else  
            ret="";
         var js=(arr.length>2)?arr[2]:"";
         var txt="<a  onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" "+est+" href=\""+DrdEscHTML(href)+"\" onclick=\""+DrdEscHTML(js)+ret+"\" >"+DrdEscHTML(tex)+"</a>";
         return txt;
         //}
         break;
      //else if (obj=="IMAGEN") {
      case "IMAGEN":
         var txt="";
         if (dato!="" && dato !=" ")
            txt+="<img id=\"IMG_"+col+"_"+fila+"\" src=\""+DrdImgPath()+dato+"\" border=\"0\" align=\"absmiddle\">";
         return txt;
         //}
         break;
      //else if (obj=="BOTONYTEXTO") {          //normal|rollover|js|texto|ID|tooltip
      case "BOTONYTEXTO":
         var txt="";
         var args=dato.split('|');
         var urlnormal="";
         var urlrollover="";
         var js="";
         var texto="";
         var elID="";
         var elTooltip="";
         if (args[0]) urlnormal=args[0]
         if (args[1]) urlrollover=args[1]
         if (args[2]) js=args[2]
         if (args[3]) texto=args[3]
         if (args[4]) elID=args[4]
         if (args[5]) elTooltip=args[5]
         if (elTooltip!="")
            var htmltooltip=" title=\""+DrEscHTML(elTooltip)+"\" "
         txt=texto;
         if (elID!="" && js=="" && !(urlrollover!="" && urlnormal!="")) 
            txt="<span id=\""+elID+"\" class=\""+elID+"\" "+htmltooltip+">"+txt+"</span>"
         var nombreImg=this.nombre+"_img_"+fila+"_"+col
         if (urlnormal!="") 
            txt="<img  "+htmltooltip+" onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" src=\""+DrdImgPath()+urlnormal+"\" border=\"0\" align=\"absmiddle\" id=\""+nombreImg+"\">"+txt
         var jsrollover=""
         if (urlrollover!="" && urlnormal!="")
            jsrollover=" onMouseOver=\"document.all['"+nombreImg+"'].src='"+DrdImgPath()+urlrollover+"'\" onMouseOut=\"document.all['"+nombreImg+"'].src='"+DrdImgPath()+urlnormal+"'\" "
         var jsonclick=""
         if (js!="")
            jsonclick=" onClick=\"cancelaEventos();var FILAEVENTO="+fila+";"+DrEscHTML(js)+"\" "
         if (js!="" || (urlrollover!="" && urlnormal!=""))
            txt="<a "+htmltooltip+" onfocus=\""+(this.autoScroll?"this.scrollIntoView(false);":"")+"\" id=\""+elID+"\" class=\""+elID+"\" href=\"javascript:void(null)\" "+jsrollover+" "+jsonclick+">"+txt+"</a>"
         return txt;
         //}
         break;
         }
      }   



   // ************************************************ CONTROL DE EVENTOS 


   // .................................................  onScr
   this.onScr = function () {
      }


   // Resaltamos una fila con el color de rollover
   // .................................................  resaltaFila
   this.resaltaFila = function (fila) {
      //Para tipo FILA, IE      
      this.ponColorFondoFila(fila,this.colOn);
      }


   // Quitamos el color de rollover o de seleccion a la fila
   // .................................................  desresaltaFila
   this.desresaltaFila = function (fila) {
      //Para tipo FILA, IE      
      this.ponColorFondoFila(fila,"");
      }

   // Resaltamos una celda con el color de rollover
   // .................................................  resaltaCelda
   this.resaltaCelda = function (fila,col) {
      this.ponColorFondoCelda(fila,col,this.colOn);
      }


   // Quitamos el color de rollover o de seleccion a la celda
   // .................................................  desresaltaCelda
   this.desresaltaCelda = function (fila,col) {
      this.ponColorFondoCelda(fila,col,"");
      }


   // Resaltamos una fila con el color de seleccionado
   // .................................................  marcaFila
   this.marcaFila = function (fila) {
      //Para tipo FILA, IE      
      this.ponColorFondoFila(fila,this.colSel);
      }


   // ponemos el fondo de una fila a un cierto color
   // .................................................  ponColorFondoFila
   this.ponColorFondoFila = function (fila,color) {
      //Para tipo FILA, IE      
      var j,tab=document.all["tblDat"+this.nombre];
      if (this.renderOptimizado) {
         var fila=tab.rows(fila);
         for (j=0;j<fila.cells.length;j++)  
            fila.cells(j).style.backgroundColor=color;
         }
      else  {
         var fila;
         if (this.GrHDat > 0)
            fila=tab.rows(fila*2);
         else
            fila=tab.rows(fila);
         for (j=0;j<fila.cells.length;j++)  {
            if (this.GrV==0 ||DrEsPar(j))   {
               fila.cells(j).style.backgroundColor=color;
               }
            }
         }
      }


   // ponemos el fondo de una fila a un cierto color
   // .................................................  ponColorFondoCelda
   this.ponColorFondoCelda = function (fila,col,color) {
      var j,tab=document.all["tblDat"+this.nombre];
      var fila;
      if (!this.renderOptimizado && this.GrHDat > 0)
         fila=tab.rows(fila*2);
      else
         fila=tab.rows(fila);
      fila.cells(col).style.backgroundColor=color;
      }


   // Ordena según una columna de datos
   // .................................................  ordenaPorColumna
   this.ordenaPorColumna = function (columna,noRepintar) {
      this.ultimaOrdenada=columna;

      //Primero actualizo 'datos' con los objetos dinámicos
      this.actualizaDat();

      var i,list=new Array();
      //list: (array) ordeno X la prim. columna y en la segunda tengo el orden original

      for (i=0;i<this.datos.length;i++)   {
         list[i]=new Array();
         if (this.ordenCol[columna]==1){ //'numerico' por ejemplo 12537.345
            try  {list[i][0]=eval(this.datos[i][this.colADat[columna]]+"");}
            catch(e)  {list[i][0]=0}
            }
         else if (this.ordenCol[columna]==2){ //'dd-mm-aaaa'
            var lafecha=this.datos[i][this.colADat[columna]]+""
            if (lafecha.length==10) 
               list[i][0]=lafecha.substr(6,4)+lafecha.substr(3,2)+lafecha.substr(0,2)
            else {
               if (lafecha.length==19)
					 list[i][0]=lafecha.substr(6,4)+lafecha.substr(3,2)+lafecha.substr(0,2)+lafecha.substr(11,2)+lafecha.substr(14,2)+lafecha.substr(17,2)
			   else
					 list[i][0]=lafecha
			   }
            }
         else if (this.ordenCol[columna]==3){ //'comaDecimalFormateado' por ejemplo 12.537,345
            try   {
               var arrValNum=(this.datos[i][this.colADat[columna]]+"").replace(/\./gi,"").replace(/,/gi,".");
               list[i][0]=eval( arrValNum );
               }
            catch(e)
               {list[i][0]=0}
            }
         else if (this.ordenCol[columna]==4){ //'dd-mm-aa'
            var lafecha=this.datos[i][this.colADat[columna]]+""
            if (lafecha.length==8) 
               list[i][0]=lafecha.substr(6,2)+lafecha.substr(3,2)+lafecha.substr(0,2)
            else
               list[i][0]=lafecha
            }
         else {//Alfanumérico
            list[i][0]=this.datos[i][this.colADat[columna]]+"";
            }
         list[i][1]=i;
         }
      var resp=DrOrdenaDoble(list,this.estOrden[columna]);
      var nuevoDatos=new Array();
      var nuevoSelecc=new Array();
      for (i=0;i<list.length;i++)   {
         nuevoDatos[i]=this.datos[resp[i][1]];
         nuevoSelecc[i]=this.selecc[resp[i][1]];
         }
      this.datos=nuevoDatos;
      //this.selecc=nuevoSelecc;
      this.estOrden[columna]=!(this.estOrden[columna]);
      this.reajusta(noRepintar);
      if (!noRepintar)
      //Debemos recuperar el estado de los botones. Gráficamente también  //
         this.cargaEstadoBotones(nuevoSelecc);
      }


   // alterna la visibilidad de una columna o la pone visible o invisible
   // .................................................  alternaVerColumna
   this.alternaVerColumna = function (columna,visib,noRepintar) { //La numeración ignora la columna de códigos pero NO las ocultas
      //Si no le paso visib alterna. Si se lo paso true -> visible
      var arr = this.estadoCol[columna];
      if (visib==null)  {
         if (arr[0].toUpperCase()!="OCULTA" )   
            arr.splice( 0, 0,"OCULTA");
         else 
            arr.splice( 0, 1);
         }
      else  {
         if (!visib && arr[0].toUpperCase()!="OCULTA" )   {
            var tt=new Array();
            tt[0]="OCULTA";
            for (var rr=0;rr<arr.length;rr++)   
               tt[rr+1]=arr[rr];
            this.estadoCol[columna]=tt;
            //arr.splice( 0, 0,"OCULTA");
            }
         else if (visib && arr[0].toUpperCase()=="OCULTA" )
            arr.splice(0,1);
         /*
        if (!visib && arr[0].toUpperCase()!="OCULTA" )   
            arr.splice( 0, 0,"OCULTA");
         else if (visib && arr[0].toUpperCase()=="OCULTA" )
            arr.splice( 0, 1);
            */
         }
      if (arr.length==0)
         arr[0]="";
      this.recalculaOcultas();
      this.ajustaAnchosMinimos();
      if (!noRepintar)
         this.repinta();
      }


   //recorro los objetos del DOM y actualizo this.datos en consonancia
   // .................................................  actualizaDat
   this.actualizaDat = function () {
      var c,i,sepCod="|";
      for (c=0;c<this.tiposCol.length;c++)   {
         var arr=this.estadoCol[c]
         var obj=arr[0].toUpperCase();
         if (obj != "MINIMIZADA" && obj != "OCULTA") {
            var tipo=(this.tiposCol[c][0]).toUpperCase();

            if (tipo=="CAJATEXTO"||tipo=="AREATEXTO")  {
               for (i=0;i<this.datos.length;i++)   {
                  var campo=eval ("this.form."+tiposCol[c][1]+"_"+i);
                  if (campo)
                     this.datos[i][[this.colADat[c]]]=campo.value;
                  }
               }
            else if (tipo=="CHECKBOX")  {
               for (i=0;i<this.datos.length;i++)  { 
                  var campo=eval ("this.form."+tiposCol[c][1]+"_"+i)
                  if (campo)
                     this.datos[i][[this.colADat[c]]]=campo.checked?"S":"N";
                  }
               }
            else if (tipo=="RADIOBUTTON")  {
               for (i=0;i<this.datos.length;i++) {  
                  var n=eval("this.form."+tiposCol[c][1]+"_"+i);
                  if (n)
                     for(var j=0;j<n.length;j++)
                        if (n[j].checked) 
                           this.datos[i][[this.colADat[c]]]=n[j].value;
                  }
               }
            else if (tipo=="COMBO" )  {
               for (i=0;i<this.datos.length;i++)   {
                  var n=eval("this.form."+tiposCol[c][1]+"_"+i);
                  if (n)   {
                     if (this.tiposCol[c][5])   { //Si es múltiple
                        var rr="";
                        for(var j=0;j<n.length;j++)
                           if (n.options[j].selected) { 
                              rr=rr + (rr!=""?sepCod:"") + n.options[j].value ;
                              }
                        this.datos[i][this.colADat[c]]=rr;
                        }
                     else  {
                        this.datos[i][this.colADat[c]]=eval ("n.options[this.form."+tiposCol[c][1]+"_"+i+".selectedIndex].value");
                        }
                     }
                  }
               }
            }
         }
      }


   //da un mensaje de error
   // ................................................. daMensajeError
   this.daMensajeError = function (msg) {
      alert(msg);
      }


   //Maximiza una columna minimizada
   // ................................................. maximiza
   this.maximiza = function (columna,noRepintar) {
      this.actualizaDat();
      var arr=this.estadoCol[columna]
      var obj=arr[0].toUpperCase();
      if (obj == "MINIMIZADA") 
         arr.splice( 0, 1);
      if (arr.length==0)
         arr[0]="";
      this.ajustaAnchosMinimos();
      if (!noRepintar)
         this.repinta();
      }


   //Minimiza una columna maximizada
   // ................................................. minimiza
   this.minimiza = function (columna,noRepintar) {
      this.actualizaDat();
      var arr=this.estadoCol[columna]
      var obj=arr[0].toUpperCase();
      if (obj == "MINIMIZADA")   
         return;
      arr.splice(0,0,"MINIMIZADA");
      this.ajustaAnchosMinimos();
      if (!noRepintar)
         this.repinta();
      }


   //Mueve el scroll hasta el elemento con un cierto codigo
   this.scrollTo = function (codigo)   {
      var fila=DrIndiceEnArray(this.datos,codigo,0);
      if (fila==-1) {
         if (this.alertsDebug)
            this.daMensajeError("No existe la fila con codigo '"+codigo+"'");
         return -1; //Error
         }
         //alert(this.cpDat.scrollTop);
      }

   this.oculta = function ()  {
      if (!ie)
         return;
      escondeCapa(document.all["Cp"+this.nombre]);
      if (document.all["CpLin1"+this.nombre]){
         escondeCapa(document.all["CpLin1"+this.nombre]);
         escondeCapa(document.all["CpLin2"+this.nombre]);
         escondeCapa(document.all["CpLin3"+this.nombre]);
         escondeCapa(document.all["CpLin4"+this.nombre]);
         }
      if (this.nombrePaginado!="")  {
         var pag=eval(this.nombrePaginado);
         cpbtn1=document.all[pag.ret.nombre+"Div"];
         cpbtn2=document.all[pag.ava.nombre+"Div"];
         if (cpbtn1) 
            escondeCapa(cpbtn1);
         if (cpbtn2) 
            escondeCapa(cpbtn2);
         }
      }

   this.muestra = function ()  {
      if (!ie)
         return;
      muestraCapa(document.all["Cp"+this.nombre]);
      if (document.all["CpLin1"+this.nombre]){
         muestraCapa(document.all["CpLin1"+this.nombre]);
         muestraCapa(document.all["CpLin2"+this.nombre]);
         muestraCapa(document.all["CpLin3"+this.nombre]);
         muestraCapa(document.all["CpLin4"+this.nombre]);
         }
      if (this.nombrePaginado!="")  {
         var pag=eval(this.nombrePaginado);
         cpbtn1=document.all[pag.ret.nombre+"Div"];
         cpbtn2=document.all[pag.ava.nombre+"Div"];
         if (cpbtn1) 
            muestraCapa(cpbtn1);
         if (cpbtn2) 
            muestraCapa(cpbtn2);
         }
      }


   // ************************************************ RELATIVAS A LA MODIFICACION DE LOS DATOS


   // inserta una nueva opción en el listado
   // .................................................  insertar
   this.insertar = function (dat,noRepintar) {
      this.actualizaDat();
      if (!dat[0])
         return;
      for (var f=0;f<dat.length;f++)
         dat[f]=""+dat[f];
      this.datos[this.datos.length]=dat;
      var ss=this.selecc;
      this.reajusta(noRepintar);
      //Debemos recuperar el estado de los botones. Gráficamente también
      if (!noRepintar)  {
         this.cargaEstadoBotones(ss);
         //Hacemos scroll hasta el último
         if (ie)
            this.cpDat.scrollTop=1000000000
         }
      }


   // eliminar una fila del listado
   // .................................................  eliminar
   this.eliminar = function (fila,cantidad,noRepintar) {
      if (this.datos.length <= fila)   {
         if (this.alertsDebug)
            this.daMensajeError("No existe la fila a eliminar");
         return;
         }
      if (cantidad==null)
         cantidad=1;
      this.actualizaDat();
      this.datos.splice( fila, cantidad);
      this.selecc.splice( fila, cantidad);
      var ss=this.selecc;
      this.reajusta(noRepintar);
      //Debemos recuperar el estado de los botones. Gráficamente también
      if (!noRepintar)
         this.cargaEstadoBotones(ss);
      }


   // eliminar las filas seleccionadas
   // .................................................  eliminarSelecc
   this.eliminarSelecc = function (noRepintar) {
      var i;
      this.actualizaDat();
      for(i=0;i<this.selecc.length;i++)   {
         if (this.selecc[i]==1) {
            this.datos.splice(i,1);
            this.selecc.splice(i,1);
            i--;
            }
         }
      var ss=this.selecc;
      this.reajusta(noRepintar);
      //Debemos recuperar el estado de los botones. Gráficamente también
      if (!noRepintar)
         this.cargaEstadoBotones(ss);
      }



   // recupera el estado salvado anteriormente.
   // .................................................  load
   this.load = function (noRepintar) {
      var ss=this.seleccOld;
      this.datos=this.datosOld;
      this.reajusta(noRepintar);
      if (!noRepintar)
         this.cargaEstadoBotones(ss);
      this.resetDatosOld();
      }


   // salva el estado.
   // .................................................  load
   this.save = function () {
      this.actualizaDat();
      this.resetDatosOld();
      }



   // retorna un array con los codigos de las opciones eliminadas.
   // .................................................  bajas
   this.bajas = function () {
      this.actualizaDat();
      var i,r=new Array();
      for (i=0;i<this.datosOld.length;i++)   
         if (!DrExisteEnArray(this.datos,this.datosOld[i][0],0))
            r[r.length]=this.datosOld[i][0];
      return (r);
      }


   // retorna un array bidimensional con los datos de las opciones nuevas.
   // .................................................  altas
   this.altas = function () {
      this.actualizaDat();
      var i,r=new Array();
      for (i=0;i<this.datos.length;i++)   
         if (!DrExisteEnArray(this.datosOld,this.datos[i][0],0))  
            r[r.length]=this.datos[i];
      return (r);
      }


   // retorna un array bidimensional con los datos de las opciones modificadas.
   // .................................................  modificaciones
   this.modificaciones = function () {
      this.actualizaDat();
      var i,r=new Array();
      for (i=0;i<this.datosOld.length;i++)   {
         var n=DrIndiceEnArray(this.datos,this.datosOld[i][0],0);
         if (n!=-1)   {
            var modif=false,j;
            for (j=0;!modif && j<this.datosOld[i].length;j++)  { //Busco modificaciones
               if (this.datos[n][j]!=this.datosOld[i][j])   {
                  modif=true;
                  r[r.length]=this.datos[n];
                  }
               }
            }
         }
      return (r);
      }


   // modifica el dato de una columna y de una fila con un cierto codigo
   // .................................................  insertaDato
   this.insertaDato = function (codigo,columna,dato,noRepintar) {
      this.actualizaDat();
      var fila=DrIndiceEnArray(this.datos,codigo,0);
      if (fila==-1) {
         if (this.alertsDebug)
            this.daMensajeError("No existe la fila con codigo '"+codigo+"'");
         return -1; //Error
         }
      this.datos[fila][this.colADat[columna]]=dato;
      if (!noRepintar)
         this.repinta();
      }


   // retorna el dato de una columna y de una fila con un cierto codigo
   // .................................................  extraeDato
   this.extraeDato = function (codigo,columna) {
      this.actualizaDat();
      var fila=DrIndiceEnArray(this.datos,codigo,0);
      if (fila==-1) {
         if (this.alertsDebug)
            this.daMensajeError("No existe la fila con codigo '"+codigo+"'");
         return null; //Error
         }
      return this.datos[fila][this.colADat[columna]];
      }


   // genera un codigo que no exista en el listado.
   // .................................................  generaCodigo
   this.generaCodigo = function (b) {
      if (b==null)
         b="cod";
      var i=0;
      var r=b+i;
      while (DrExisteEnArray(this.datos,r,0)) {
         i++;
         r=b+i;
         }
      return (r);
      }


   // prepara los campos para poder usar funciones druida de validación con el formulario interno ('frm'+Nombre)
   // .................................................  preparaCampos
   this.preparaCamposDR = function () {
      var nombrF="frm"+this.nombre; //Nombre del falso formulario
      var nombrFReal="form"+this.nombre; //Nombre del formulario

      //Simulamos el formulario
      eval("window."+nombrF+"=new Object()");
      
      //Esto para que funcione el focaliza
      eval("window."+nombrFReal+"=new Object()");
      eval("window."+nombrFReal+".TC='Formulario'");

      //Simulamos el formulario 'repetido'
      eval("document."+nombrF+"=new Object()");
      eval("document."+nombrF+".elements=new Array()");

      for (var i=0;i<this.tiposCol.length;i++)  { //Por cada columna ...
         //Si es de tipo formulario preparo el elemento
         var k=0,encontrado=false;
         while (k<this.tipColForm.length && !encontrado) {
            if (this.tipColForm[k][0]==this.tiposCol[i][0])   {
               encontrado=true;
               k--; //Para que salga la k que me interesa
               }
            k++;
            }
         
         if (encontrado)  { //Si es de tipo form
            //Preparo los elem de la columna 
            for (var j=0;j<this.datos.length;j++)  {
               //Para el formulario repetido ...
               var nCampo=this.tiposCol[i][1]+"_"+j;
               eval("document."+nombrF+".elements[document."+nombrF+".elements.length]=new Object()");
               eval("document."+nombrF+".elements[document."+nombrF+".elements.length-1].name='"+nCampo+"'");
               
               //Para el formulario normal ...
               var nfinal="window."+nombrF+"."+nCampo;
               eval(nfinal+"=new Object()");

               //Es obligatoria?
               var tipo=(this.tiposCol[i][0]).toUpperCase();
               if (
                  (tipo=="COMBO"&&(this.tiposCol[i][4]).toUpperCase()=='S')
                  || (tipo=="CAJATEXTO"&&(this.tiposCol[i][6]).toUpperCase()=='S')
                  || (tipo=="AREATEXTO"&&(this.tiposCol[i][6]).toUpperCase()=='S')
                  || (tipo=="CHECKBOX"&&(this.tiposCol[i][2]).toUpperCase()=='S')
                  || (tipo=="RADIOBUTTON"&&(this.tiposCol[i][3]).toUpperCase()=='S')
                  ) {
                  var mv="I";
                  }
               else
                  var mv="i"
               //var rut=eval("CpScroll"+this.nombre+".nsdoc")+".CpScroll"+this.nombre+".document."+nombrFReal+"."+nCampo;
               eval(nfinal+"MV='"+mv+"'");
               //eval(nfinal+"NS='"+rut+"'");
               eval(nfinal+"IE='document."+nombrFReal+"."+nCampo+"'");
               if (this.validac[i]!="")
                  eval(nfinal+"TV=this.validac[i]");
               else 
                  eval(nfinal+"TV='null'");
               var eltipo="";
               if (this.estadoCol[i][0] == "OCULTA"){
                  eval(nfinal+"TC='Hidden';");
                  eval("document."+nombrF+"."+nCampo+"=new Object();");
                  eval("document."+nombrF+"."+nCampo+".value=\""+  DrEscJS(this.datos[j][i]) +"\";");
                  }
               else if(this.estadoCol[i][0]  == "MINIMIZADA") {
                  eval(nfinal+"TC='ColMinim'");
                  eval(nfinal+"COL="+i+"");//guardamos la columna 
                  eval(nfinal+"PADR='"+this.nombre+"'"); //Y guardamos el objeto listado para poder focalizar cuando haya error
                  eval("document."+nombrF+"."+nCampo+"=new Object();");
                  eval("document."+nombrF+"."+nCampo+".value=\""+  DrEscJS(this.datos[j][i]) +"\";");
                  }
               else  {
                  eval(nfinal+"TC='"+this.tipColForm[k][1]+"'");
                  }
               }
            }
         }
     }


   // retorna el valor esperado en función del modo de envio (edicion/seleccion) y de forma serializada
   // .................................................  get
   this.get = function ()  {
      var v;
      if (this.tipEnvio=='E') {//Edición
         if (this.formaEnvio.toUpperCase()=='XML'){
            v=this.AltBajModifXml();
            }
         else  {
            v=this.AltBajModifSerializ();
            }
         }
      else //Seleccion
         v=this.codSeleccionados();
      return v;
      }


   this.limpia = function (noRepintar)   {
      this.setDatos([],noRepintar);
      }


   // Sustituye los datos de la lista por un nuevo array de datos
   // .................................................  setDatos
   this.setDatos = function (datos,noRepintar)   {
      if (this.onSetDatos!="")
         eval (this.onSetDatos);
      this.datos=datos;
      this.ajustaDatos();//Añade columnas vacias si hace falta
      this.ajustaSelecc();
      if (this.onAfterSetDatos!="")
         eval (this.onAfterSetDatos);
      if (!noRepintar)
         this.repinta();
      }



   // Añade columnas vacias al array de datos si hace falta
   // .................................................  ajustaDatos
   this.ajustaDatos = function ()   {
      var i;
      for (i=0;i<this.datos.length;i++)   {
         while (this.datos[i].length<this.numColDat)  {
            this.datos[i][this.datos[i].length]="";
            }
         }
      }


   // retorna las altas bajas y modificaciones de forma serializada
   // .................................................  AltBajModifSerializ
   this.AltBajModifXml = function ()  {
      var r="<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>";
      r+="<ROWSET2>";

      var b=this.bajas();
      var a=this.altas();
      var m=this.modificaciones();
      var B=new Array();
      B[0]=b;

      r+=DrArrayAXml(B,"BAJAS");
      r+=DrArrayAXml(a,"ALTAS");
      r+=DrArrayAXml(m,"MODIFICACIONES");

      r+="</ROWSET2>";

      return r;
      }


   // retorna las altas bajas y modificaciones de forma serializada
   // .................................................  AltBajModifSerializ
   this.AltBajModifSerializ = function ()  {
      var r = new Array();
      var b=this.bajas();
      var a=this.altas();
      var m=this.modificaciones();
      if (b!=null && b.length>0) 
         for (var i=0;i<b.length;i++)  {
            r[r.length]=new Array();
            r[r.length-1][0]="B";
            r[r.length-1][1]=b[i];
            }
      if (a!=null )
         for (var i=0;i<a.length;i++)
            r[r.length]=DrInsertaCaracter(a[i],"A"); //Insertamos una A para las altas
      if (c!=null )
         for (var i=0;i<m.length;i++)
            r[r.length]=DrInsertaCaracter(m[i],"M"); //Insertamos una M para las modificaciones
      //alert(r.join(" + "));
     // if (this.formaEnvio.toUpperCase()=='XML'){
     //    return (DrArrayAXml(r));
     //    }
     // else  {
         return (DrSerializa(r));
     //    }
      }



   // ************************************************ ALIAS USADOS SOLO PARA COMUNICACION CON OTROS OBJETOS (paginado p.ej.)

   this.display = function () {this.repinta()} //Es un alias de repinta

   this.on = function (codigo,img) {   //Es un ALIAS de seleccionaCod
      if (img==null)
         this.seleccionaCod(codigo);
      else
         this.seleccionaCod(codigo,img);
      }

   this.datos.borrar = function () {
      this.datos=new Array();
      }

   this.seleccion=new Object();
   this.seleccion.borrar = function () {
      this.ajustaSelecc();
      }

   this.ultimo_pulsado=null;

   }//Fin de la clase








//Convierte un array o un array de arrays en una forma serializada
// .................................................  DrSerializa 
function DrSerializa (arr) {
   var sep1='|', sep2='#', esc='$';
   var r="$D:"; //Formato de datos de Druida, 3 caract. de cabecera
   for (var i=0;i<arr.length;i++)   {
      if (i!=0)
         r+=sep1;
      if (arr[i].length && arr[i].length>0 && arr[i][0].length)   {
         for (var j=0;j<arr[i].length;j++)   {
            if (j!=0)
               r+=sep2;
            r+=DrEscapa(arr[i][j],esc,sep1+sep2);
            //r+=arr[i][j];
            }
         }
      else  {
         r+=DrEscapa(arr[i],esc,sep1+sep2);
         //r+=arr[i];
         }
      }
   return r;
   }


//Convierte un array o un array de arrays en un xml
// .................................................  DrArrayAXml 
function DrArrayAXml (arr,ID) {
   var r="<ROWSET"+(ID!=null?" NOMBRE=\""+ID+"\" ":"")+">",i,j;
   for (i=0;i<arr.length;i++)   {
      r+="<ROW ID=\""+i+"\">";
      for (j=0;j<arr[i].length;j++)   {
         r+="<CAMPO NOMBRE=\""+j+"\" TIPO=\"STRING\">"+DrdEscXML(arr[i][j])+"</CAMPO>"
         }
      r+="</ROW>";
      }
   r+="</ROWSET>";
   return r;
   }



// Usada para escapar textos
// ................................................  DrEscapa
function DrEscapa(valor,carEscape,carAEscap)  {

   if (carAEscap.indexOf(carEscape)==-1)
      carAEscap=carEscape+carAEscap;
   var r=valor;

   var s="",j;
   for (j=0;j<r.length;j++)  {
      if (carAEscap.indexOf(r.charAt(j))!=-1)   {
         s=s+carEscape;
         }
      s=s+r.charAt(j);
      }

   return s;
   }


// Ordena por burbuja
// .................................................  DrOrdenaDoble (aux)
function DrOrdenaDoble(arr,valor)  {
   //Array, true/false según queramos de mayor a menor o viceversa
   if (valor==null)
      valor=true;
   //Ordeno por burbuja
   //Mejora: implementar quickshort
   if (arr.length<2)
      return arr;
   var i,j,im1,im2;
   if (valor)
      for (i=arr.length-1;i>0;i--)  {
         for (j=0;j<i;j++) {
            if (arr[j][0]>arr[j+1][0]) {
               im1=arr[j][0];
               im2=arr[j][1];
               arr[j][0]=arr[j+1][0];
               arr[j][1]=arr[j+1][1];
               arr[j+1][0]=im1;
               arr[j+1][1]=im2;
               }
            }
         }
   else
      for (i=arr.length-1;i>0;i--)  {
         for (j=0;j<i;j++) {
            if (arr[j][0]<arr[j+1][0]) {
               im1=arr[j][0];
               im2=arr[j][1];
               arr[j][0]=arr[j+1][0];
               arr[j][1]=arr[j+1][1];
               arr[j+1][0]=im1;
               arr[j+1][1]=im2;
               }
            }
         }
   return arr;
   }


// .................................................  DrEsPar (aux)
function DrEsPar(n)  {
   return (n%2 == 0)
   }

/*
// Escapar en HTML 
// .................................................  DrEscHTML (aux)
function DrEscHTML (cad) {
   if (cad!=null)
      return cad.replace(/</gi,"&lt;").replace(/"/gi,"&quot;"); 
   return "";
   }
*/
function DrEscHTML (cad) {
   if (cad!=null)
      return cad.replace(/&/gi,"&amp;").replace(/</gi,"&lt;").replace(/"/gi,"&quot;"); 
   return "";
   }

//Escapar en JS
// .................................................  DrEscJS (aux)
function DrEscJS (cad) {
   if (cad!=null)
      return cad.replace(/\\/gi,"\\\\").replace(/"/gi,"\\\""); 
   return "";
   }


//Buscar un dato en una columna de un array bidimensional
// .................................................  DrExisteEnArray (aux)
function DrExisteEnArray(array,dato,columna)   {
   var i;
   for (i=0;i<array.length;i++)  {
      if (columna==null)   {
         if (array[i]==dato)
            return true;
         }
      else  {
         if (array[i][columna]==dato)
            return true;
         }
      }
   return false;
   }


//Buscar un dato en una columna de un array bidimensional, retorna indice
// .................................................  DrIndiceEnArray (aux)
function DrIndiceEnArray(array,dato,columna)   {
   var i;
   for (i=0;i<array.length;i++)  {
      if (columna==null)   {
         if (array[i]==dato)
            return i;
         }
      else  {
         if (array[i][columna]==dato)
            return i;
         }
      }
   return -1;
   }


// Mete el caracter en la primera posicion de un array
// .................................................  DrIndiceEnArray (aux)
function DrInsertaCaracter(array,caracter)   {
   var r=new Array();
   r[0]=caracter;
   for (var i=0;i<array.length;i++)
      r[i+1]=array[i];
   return r;
   }


// .................................................  DrGeneraCopiaDeArray (aux)
function DrGeneraCopiaDeArray(array)   {
   var r=new Array();
   var i,j;
   for (i=0;i<array.length;i++)   {
      if (array[i].length) {
         r[i]=new Array();
         for (j=0;j<array[i].length;j++)
            r[i][j]=array[i][j];
         }
      else  {
         r[i]=array[i];
         }
      }
   return r;
   }




// Generamos las variables JS de la capa como si se generara desde la plantilla
// .................................................  DrGeneraCapaScript
//function DrGeneraCapaScript(nombre,visibilidad,contravsb,nsdoc)   {
function DrGeneraCapaScript(nombre,visibilidad,contravsb)   {
   //visibilidad --> 'hidden' / 'visible'
   if (ns)
      eval(nombre+"=new Object();");
   else
      eval("if(!"+nombre+") "+nombre+"=new Object();");
   eval(nombre+".TC='Capa';");
   eval(nombre+".vsb='"+visibilidad+"'");
   eval(nombre+".contravsb='"+contravsb+"'");
   //eval(nombre+".nsdoc='"+nsdoc+"'");
   }




function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr;
  for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) 
      x.src=x.oSrc;
   }


function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}



function focalizaPrimeroEnLista(nLista)   {
   var elscr=document.all['CpScroll'+nLista]
   if (elscr)   {
      var filas=elscr.all.tags("TR");
      var elems=filas[0].all.tags("A");
      if (elems && elems.length)
         elems[0].focus();
      else {
         elems=filas[0].all.tags("INPUT");
         if (elems && elems.length)
            elems[0].focus();
         }
      }
   }


function cancelaEventos(){
   if (!ns)
      window.event.cancelBubble=true;
   return false;
   }

/*
function elOnChangeCheckboxLista (OBJETOFRM,eljs)  {
   alert('OK')
   return true;
   }
*/
 /*
   
   this.ancho=ancho;
   this.alto=alto;
   this.tiposCol=tiposCol;
   this.ordenCol=ordenCol;
   this.txtCab=txtCab;
   this.accion=accion;
   this.anchos=anchos;
   this.tipoAnchos=tipoAnchos;
   this.nombre=nombre;
   this.altoFila=altoFila
   this.altoCab=altoCab
   this.GrBorde=GrBorde;
   this.GrHDat=GrHDat; //Grosor Lineas Horizontales en los Datos
   this.GrHCab=GrHCab; //Grosor Lineas Horizontales en los Datos
   this.GrV=GrV; //Grosor Lineas Verticales en los Datos y la cabecera
   this.ColHDat=ColHDat; //Color Lineas Horizontales en los Datos
   this.ColVDat=ColVDat; //Color Lineas Verticales en los Datos 
   this.ColVCab=ColVCab; //Color Lineas Verticales en la cabecera
   this.estilosCab=estilosCab; 
   this.estilosDat=estilosDat;
   this.ajusteMin=ajusteMin
   this.nowrap=nowrap
   this.btnOff=btnOff
   this.btnOn=btnOn
   this.btnSel=btnSel
   this.btnMinN=btnMinN
   this.btnMinS=btnMinS
   this.btnMaxN=btnMaxN
   this.btnMaxS=btnMaxS
   this.btnDesac=btnDesac
   this.btnConROver=btnConROver; //False - - > no hay rollover
   this.imgFondCab=imgFondCab;
   this.maxSel=maxSel; //Maximo de entradas a seleccionar (-1 --> ,multiseleccion   0 - - > ninguno)
   this.msgErrMaxSel=msgErrMaxSel
   this.colOn=colOn;
   this.formaEnvio=formaEnvio; //serializado o xml
   this.colSel=colSel;
   this.ordenarCol=ordenarCol;
   this.datos=datos;
   this.onSetDatos=onSetDatos;//JS a ejecutar al hacer un setDatos()
   this.anchoColMinim=anchoColMinim; //ancho de las columnas minimizadas
   this.colMinimiz=colMinimiz;
   this.minFilas=minFilas; //Si hay menos que eso se pintan vacias 
   this.txtMinim=txtMinim; //true --> sale txt columnas cuando minimizo
   this.alertsDebug=alertsDebug;
   this.tipEnvio=tipEnvio; //edicion (envio altas bajas y modif) o bien seleccion (solo los cod selecc)
   this.NSdoc=NSdoc; //Ruta de la capa base del listado en NS
   this.onLoad=onLoad; //La primera vez que se repinta puedo p. ej. modif. los datos
   this.repintarCab=repintarCab;//Si es N no repinto la cab (x ej. porque no hay)
   this.anchosOld=DrGeneraCopiaDeArray(this.anchos);
   this.datosOld=null; //Almacen para salvar 
   this.filaSelecc=-1; //la última fila marcada o desmarcada. Al ppo vale -1;
   this.selecc=null; //Array. Normal(0), fila seleccionada (1) o desactivada (-1)
   this.seleccOld=null; //Almacen para salvar 
   this.form=null; //Formulario interno
   this.colOcultas=0; //num de columnas ocultas
   this.ultColNoOcul=0; //ultima col. no oculta
   this.estOrden=null; //True o False, para controlar si el orden es ascendente / descendente
   this.validac=null; //validación de cada columna. 
   this.estadoCol=null; //Sale de tomar lo de tiposCol
   this.tipColForm=[["CAJATEXTO","Texto"]] //Columnas de tipo 'formulario'. Seg columna es el ...TC
   this.tag="LISTAEDITABLE"; //
   this.validac=new Array();
   this.estadoCol=new Array();
   this.tipEnvio=((this.tipEnvio.toUpperCase())=='EDICION')?'E':'S'; //Edición o Seleccion


// ******************************************************* RELATIVAS A MANEJO INTERNO DE LOS DATOS
  
   this.init = function ()  //Inicia las variables
   this.generaVariablesCapas = function()  // Genera punteros internos a capas relacionadas
   this.recalculaOcultas = function ()  // calcula ultColNoOcul y colOcultas
   this.resetDatosOld = function () // copia interna del array de datos
   this.ajustaSelecc = function () //reajusta la lista interna de seleccion 

// ******************************************************************* RELATIVAS A SELECCIÓN / DESELECCIÓN

   this.seleccionaCod = function (codigo,img) //selecciona una opción con un cierto codigo
   this.selecciona = function (indice,img) //selecciona una opción con un cierto numero de fila
   this.deselecciona = function (indice,img) //deselecciona una opción
   this.numSelecc = function () //retorna el numero de filas seleccionadas
   this.codSeleccionados = function () //retorna los códigos de las opciones seleccionadas
   this.codigos = function () //retorna todos los códigos
   this.desactiva = function (indice) //desactiva una opción
   this.activa = function (indice) //reactiva una opción desactivada
   this.modifImgBtnFila = function (indice,url) //modifica las imagenes de boton de una fila
 
// ************************************************ RELATIVAS AL REFRESCO GRÁFICO 

   this.reajusta = function () //Repinta y ajusta la lista completamente tras un cambio. Se pierden los estados de los botones.
   this.repinta = function () //Repinta. No ajusta la lista de seleccion si ha cambiado el numero de opciones
   this.ajustaAnchosMinimos = function () //ensancha los anchos de las columnas hasta el mínimo si es que no lo alcanzan. Quita el ancho a las ocultas y le da un ancho mínimo a las minimizadas
   this.repintaDat = function () //Repinta la lista de datos
   this.cargaEstadoBotones = function (nuevoSelecc) //carga los estados de boton que se le pasen
   this.repintaCab = function () //Repinta la cabecera de la lista en función de la lista de datos
   this.pintaElemento = function (def,dato,fila,col) // Retorna el código html de un elemento de datos según su tipo

// ************************************************ CONTROL DE EVENTOS 

   this.onScr = function () 
   this.resaltaFila = function (fila) // Resaltamos una fila con el color de rollover
   this.desresaltaFila = function (fila) // Quitamos el color de rollover o de seleccion a la fila
   this.marcaFila = function (fila) // Resaltamos una fila con el color de seleccionado
   this.ponColorFondoFila = function (fila,color) // ponemos el fondo de una fila a un cierto color
   this.ordenaPorColumna = function (columna) // Ordena según una columna de datos
   this.alternaVerColumna = function (columna,visib) { // alterna la visibilidad de una columna o la pone visible o invisible. La numeración ignora la columna de códigos pero NO las ocultas
   this.actualizaDat = function () { //recorro los objetos del DOM y actualizo this.datos en consonancia
   this.daMensajeError = function (msg) //da un mensaje de error
   this.maximiza = function (columna) //Maximiza una columna minimizada
   this.minimiza = function (columna) //Minimiza una columna maximizada
   this.scrollTo = function (codigo)  //Mueve el scroll hasta el elemento con un cierto codigo
  
// ************************************************ RELATIVAS A LA MODIFICACION DE LOS DATOS

   this.insertar = function (dat) // inserta una nueva opción en el listado
   this.eliminar = function (fila,cantidad) // eliminar una fila del listado
   this.eliminarSelecc = function () // eliminar las filas seleccionadas
   this.load = function () // recupera el estado salvado anteriormente.
   this.save = function () // salva el estado.
   this.bajas = function () // retorna un array con los codigos de las opciones eliminadas.
   this.altas = function () // retorna un array bidimensional con los datos de las opciones nuevas.
   this.modificaciones = function () // retorna un array bidimensional con los datos de las opciones modificadas.
   this.insertaDato = function (codigo,columna,dato) // modifica el dato de una columna y de una fila con un cierto codigo
   this.extraeDato = function (codigo,columna)  // retorna el dato de una columna y de una fila con un cierto codigo
   this.generaCodigo = function (b) // genera un codigo que no exista en el listado.
   this.preparaCamposDR = function () // prepara los campos para poder usar funciones druida de validación con el formulario interno ('frm'+Nombre)
   this.get = function ()  // retorna el valor esperado en función del modo de envio (edicion/seleccion) y de forma serializada
   this.setDatos = function (datos)  // Sustituye los datos de la lista por un nuevo array de datos
   this.ajustaDatos = function ()  // Añade columnas vacias al array de datos si hace falta
   this.AltBajModifSerializ = function () // retorna las altas bajas y modificaciones de forma serializada

// ************************************************ ALIAS USADOS SOLO PARA COMUNICACION CON OTROS OBJETOS (paginado p.ej.)

   this.display //Es un alias de repinta
   this.on //Es un ALIAS de seleccionaCod
   this.datos.borrar 
   this.seleccion.borrar = function () {
   this.ultimo_pulsado=null;

// ************************************************ Fin de clase


function DrSerializa (arr) //Convierte un array o un array de arrays en una forma serializada
// Usada para escapar textos
function DrEscapa(valor,carEscape,carAEscap)  {
// Ordena por burbuja
function DrOrdenaDoble(arr,valor)  {
// .................................................  DrEsPar (aux)
function DrEsPar(n)  {
//Escapar en JS
function DrEscJS (cad) {
//Buscar un dato en una columna de un array bidimensional
function DrExisteEnArray(array,dato,columna)   {
//Buscar un dato en una columna de un array bidimensional, retorna indice
function DrIndiceEnArray(array,dato,columna)   {
// Mete el caracter en la primera posicion de un array
function DrInsertaCaracter(array,caracter)   {
// .................................................  DrGeneraCopiaDeArray (aux)
function DrGeneraCopiaDeArray(array)   {
//Precarga img
function DrPrecargaImg () {
// Generamos las variables JS de la capa como si se generara desde la plantilla
function DrGeneraCapaScript(nombre,visibilidad,contravsb,nsdoc)   {
function MM_swapImgRestore() { //v3.0
function MM_findObj(n, d) { //v4.01
function MM_swapImage() { //v3.0


*/

function escondeCapa(laCapa)  {// solo IE
   if (laCapa.offsetLeft >= 0)   {
      laCapa.oldX=laCapa.offsetLeft;
      laCapa.style.left=-6000;
      }
   }

function muestraCapa (laCapa) {// solo IE
   if (laCapa.oldX && laCapa.offsetLeft < 0)   {
      laCapa.style.left=laCapa.oldX;
      }
   }

