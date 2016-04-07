package com.calipso.reportgenerator.reportcalculator.expression;

import java.io.Serializable;

/**
 * Representa una expresión constante cuyo valor es una magnitud
 */

public class MagnitudeExp extends ConstantExp implements Serializable {

  public boolean isMagnitude() {
    return true;
  }
}
