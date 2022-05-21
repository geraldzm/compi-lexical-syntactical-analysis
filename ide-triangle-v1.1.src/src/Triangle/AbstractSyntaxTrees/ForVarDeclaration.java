package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForVarDeclaration extends Declaration {

    public ForVarDeclaration(Identifier iAST, TypeDenoter tAST, Expression E1,
                             SourcePosition thePosition) {
        super(thePosition);
        I = iAST;
        T = tAST;
        e1 = E1;
    }

    public Object visit(Visitor v, Object o) {
        return v.visitForVarDeclaration(this, o);
    }

    public Identifier I;
    public TypeDenoter T;
    public Expression e1;
}