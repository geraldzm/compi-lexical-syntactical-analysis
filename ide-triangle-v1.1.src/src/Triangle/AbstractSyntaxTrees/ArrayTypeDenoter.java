/*
 * @(#)ArrayTypeDenoter.java                        2.1 2003/10/07
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

public class ArrayTypeDenoter extends TypeDenoter {

  public ArrayTypeDenoter (IntegerLiteral ilAST,IntegerLiteral il2AST, TypeDenoter tAST,
                    SourcePosition thePosition) {
    super (thePosition);
    IL = ilAST;
    IL2 = il2AST;
    T = tAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitArrayTypeDenoter(this, o);
  }

  public boolean equals (Object obj) {
    if (obj != null && obj instanceof ErrorTypeDenoter)
      return true;
    else if (obj != null && obj instanceof ArrayTypeDenoter)
      return this.IL.spelling.compareTo(((ArrayTypeDenoter) obj).IL.spelling) == 0 &&
             this.T.equals(((ArrayTypeDenoter) obj).T);
    else
      return false;
  }

  public IntegerLiteral IL;
  public IntegerLiteral IL2;
  public TypeDenoter T;
}
