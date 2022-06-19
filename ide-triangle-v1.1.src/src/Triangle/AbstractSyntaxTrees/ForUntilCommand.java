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

public class ForUntilCommand extends Command { // gerald zamora

  public ForUntilCommand(Identifier identifier, Expression exp, Expression exp2, Expression eAST, Command cAST, Command leaAST, SourcePosition commandPos) {
    super (commandPos);
    I = identifier;
    E = exp;
    E1 = exp2;
    E3 = eAST;
    C = cAST;
    leaveE = leaAST;

  }

  public Object visit(Visitor v, Object o) {
    return v.visitForUntilCommand(this, o);
  }

  public Identifier I;
  public Expression E, E1, E3;
  public Command C, leaveE;
  public ForVarDeclaration var;
}
