/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.dto.DTODatosMatrizDescuentos;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;


public class DTOGlobalDescuento extends DTOAuditableSICC {

    private DTODatosMatrizDescuentos datosMatriz;
    private DTODescuentoDG datosGralesDto;
    private DTOEAlcanceTipoCliente alcanceTipoCliente;
    private DTOListaDescuentoCliente alcanceCliente;
    private DTOAlcanceAdministrativoDto alcanceAdministrativo;
    private DTOSBaseCalculo baseCalculo;
    private DTOListaBasesAplicacionDto basesAplicacion;
    private Boolean indDatosGralesDto;
    private Boolean indAlcanceTipoCliente;
    private Boolean indAlcanceCliente;
    private Boolean indAlcanceAdministrativo;
    private Boolean indBaseCalculo;
    private Boolean indBaseAplicacion;

    public DTOGlobalDescuento()
    {
    }
    
   public DTODatosMatrizDescuentos getDatosMatriz()
   {
      return this.datosMatriz;
   }

   public void setDatosMatriz(DTODatosMatrizDescuentos datosMatriz)
   {
      this.datosMatriz = datosMatriz;
   }


   public DTODescuentoDG getDatosGralesDto()
   {
      return this.datosGralesDto;
   }

   public void setDatosGralesDto(DTODescuentoDG datosGralesDto)
   {
      this.datosGralesDto = datosGralesDto;
   }


   public DTOEAlcanceTipoCliente getAlcanceTipoCliente()
   {
      return this.alcanceTipoCliente;
   }

   public void setAlcanceTipoCliente(DTOEAlcanceTipoCliente alcanceTipoCliente)
   {
      this.alcanceTipoCliente = alcanceTipoCliente;
   }
    
    
   public DTOListaDescuentoCliente getAlcanceCliente()
   {
      return this.alcanceCliente;
   }

   public void setAlcanceCliente(DTOListaDescuentoCliente alcanceCliente)
   {
      this.alcanceCliente = alcanceCliente;
   }


   public DTOAlcanceAdministrativoDto getAlcanceAdministrativo()
   {
      return this.alcanceAdministrativo;
   }

   public void setAlcanceAdministrativo(DTOAlcanceAdministrativoDto alcanceAdministrativo)
   {
      this.alcanceAdministrativo = alcanceAdministrativo;
   }


   public DTOSBaseCalculo getBaseCalculo()
   {
      return this.baseCalculo;
   }

   public void setBaseCalculo(DTOSBaseCalculo baseCalculo)
   {
      this.baseCalculo = baseCalculo;
   }    
    

   public DTOListaBasesAplicacionDto getBasesAplicacion()
   {
      return this.basesAplicacion;
   }

   public void setBasesAplicacion(DTOListaBasesAplicacionDto basesAplicacion)
   {
      this.basesAplicacion = basesAplicacion;
   }    

    
   public Boolean getIndDatosGralesDto()
   {
      return this.indDatosGralesDto;
   }

   public void setIndDatosGralesDto(Boolean indDatosGralesDto)
   {
      this.indDatosGralesDto = indDatosGralesDto;
   }      
    
    
   public Boolean getIndAlcanceTipoCliente()
   {
      return this.indAlcanceTipoCliente;
   }

   public void setIndAlcanceTipoCliente(Boolean indAlcanceTipoCliente)
   {
      this.indAlcanceTipoCliente = indAlcanceTipoCliente;
   }       
    
    
   public Boolean getIndAlcanceCliente()
   {
      return this.indAlcanceCliente;
   }

   public void setIndAlcanceCliente(Boolean indAlcanceCliente)
   {
      this.indAlcanceCliente = indAlcanceCliente;
   }       
        
    
   public Boolean getIndAlcanceAdministrativo()
   {
      return this.indAlcanceAdministrativo;
   }

   public void setIndAlcanceAdministrativo(Boolean indAlcanceAdministrativo)
   {
      this.indAlcanceAdministrativo = indAlcanceAdministrativo;
   }          
    
    
   public Boolean getIndBaseCalculo()
   {
      return this.indBaseCalculo;
   }

   public void setIndBaseCalculo(Boolean indBaseCalculo)
   {
      this.indBaseCalculo = indBaseCalculo;
   }          
    
    
   public Boolean getIndBaseAplicacion()
   {
      return this.indBaseAplicacion;
   }

   public void setIndBaseAplicacion(Boolean indBaseAplicacion)
   {
      this.indBaseAplicacion = indBaseAplicacion;
   }      

}