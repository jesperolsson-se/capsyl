package se.jesperolsson;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.File;

public class VoidVisitorStarter extends VoidVisitorAdapter {

    private final File source;

    public VoidVisitorStarter(File source) {
        this.source = source;
    }

    public void print() throws Exception {
        CompilationUnit cu = StaticJavaParser.parse(source);
        VoidVisitor encapsulationPrinter = new EncapsulationPrinter();
        encapsulationPrinter.visit(cu, null);

        // Visualize the AST in DOT.
        /*DotPrinter printer = new DotPrinter(true);
        try (FileWriter fileWriter = new FileWriter("ast.dot");
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(printer.output(cu));
        }*/
    }
}
