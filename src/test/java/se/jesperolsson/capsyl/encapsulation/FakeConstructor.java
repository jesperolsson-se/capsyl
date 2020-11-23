package se.jesperolsson.capsyl.encapsulation;

import com.github.javaparser.ast.expr.ObjectCreationExpr;

class FakeConstructor extends ObjectCreationExpr {

    @Override
    public String getTypeAsString() {
        return "fake";
    }
}
