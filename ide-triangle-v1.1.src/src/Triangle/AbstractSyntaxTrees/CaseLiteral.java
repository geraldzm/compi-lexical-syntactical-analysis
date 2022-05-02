/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leonardo
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseLiteral extends Terminal {

  public CaseLiteral (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
  }

  public Object visit (Visitor v, Object o) {
    return v.visitCaseLiteral(this, o);
  }

}




