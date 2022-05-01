/*
 * @(#)NothingCommand.java                       
 *  Leonardo
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class NothingCommand extends Command {

  public NothingCommand (SourcePosition thePosition) {
    super (thePosition);
  }

  public Object visit(Visitor v, Object o) {
    return v.visitNothingCommand(this, o);
  }
}
