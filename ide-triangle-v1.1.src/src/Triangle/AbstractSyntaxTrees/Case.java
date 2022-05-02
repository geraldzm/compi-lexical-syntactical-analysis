/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author Leonardo
 */

import Triangle.SyntacticAnalyzer.SourcePosition;

public class Case extends Cases {

  public Case (CaseLiteral aCasLit, CaseLiteral bCasLit, Command leaAST, SourcePosition thePosition, Cases nCase) {
    super (thePosition);
  
    A = aCasLit;
    B = bCasLit;
    C = nCase;
    this.leaAST = leaAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCase(this, o);
  }

  public CaseLiteral A, B;
  public Command leaAST;  
  public Cases C;  
}
