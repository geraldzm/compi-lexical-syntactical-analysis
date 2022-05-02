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
public class ChooseCommand extends Command{
   public ChooseCommand(Expression eAST, Cases cAST, Command bAST,SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    B = cAST;
    C = bAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitChooseCommand(this, o);
  }

  public Expression E;
  public Cases B;  
  public Command C;
}
