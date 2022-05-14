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


public class Recursive extends Declaration {

  public Recursive (Declaration pf1AST, SourcePosition thePosition) {
    super (thePosition);
    PF1 = pf1AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitRecursive(this, o);
  }

  public Declaration PF1;
}