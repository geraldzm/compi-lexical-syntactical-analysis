/*
 * @(#)WhileCommand.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForDoCommand extends Command { // gerald zamora

  public ForDoCommand(Identifier identifier, Expression eAST, Expression e1AST, Command cAST, Command leaveAST, SourcePosition thePosition) {
    super (thePosition);
    I = identifier;
    E = eAST;
    E1 = e1AST;
    C = cAST;
    leaveC = leaveAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForDoCommand(this, o);
  }

  public Identifier I;
  public Expression E, E1;
  public Command C, leaveC;
  public ForVarDeclaration var;
}
