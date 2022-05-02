/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Leonardo
 */
public class VarInitialized extends Declaration {
  public VarInitialized (Identifier iAST, Expression tAST,
                         SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    T = tAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitVarInitialized(this, o);
  }

  public Identifier I;
  public Expression T;
}

