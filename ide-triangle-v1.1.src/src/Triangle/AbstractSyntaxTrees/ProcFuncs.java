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


public class ProcFuncs extends Declaration {

  public ProcFuncs (Declaration pf1AST, Declaration pf2AST, SourcePosition thePosition) {
    super (thePosition);
    PF1 = pf1AST;
    PF2 = pf2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitProcFuncs(this, o);
  }

  public Declaration PF1, PF2;
}