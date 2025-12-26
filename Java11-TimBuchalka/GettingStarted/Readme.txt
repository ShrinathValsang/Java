*** Notes from the course ***

1.  FQCN - fully qualified class name
    package statement is used to group classes into logical set that have some
    commonality.
    package statement is the first line of the code (exluding comments and
    empty lines).
    To have the compiler create class files in exploded directories, that
    represent your package names:
    javac -d {directory} foo.java
    java.lang.{className} is implicit i.e. all classes under java.lang package
    are already imported.

2.  Types of imports
    - single type import - Takes precedence on import-on-demand. But it prevents
    creating class with the same name.
        e.g. import garden.vegetables.VineVegetable;

    - import on demand
        e.g. import garden.vegetables.*;

    - Static imports were introduced in Java 7 and are specific only to static
    methods and static class variables. 'import static' actually don't import
    classes at all but static class attributes or methods.

    - static type import
        e.g. import static java.land.Math.PI;
        import static java.land.Math.sqrt;

    - static import on demand
        e.g. import static java.land.Math.*;


3.  package name can be the same as the class name

    package PackageTests;

    public class PackageTests {
        public static void main(String...args) {
            System.out.println("this is package test") // Runs fine.
        }
    }

    Import statement 'import a.*' only imports classes directly under directory
    'a' and not classes in the subdirectories (such as classes under 'a.b' or
    'a.b.c').


    It is ok to create a class that is already defined in the 'java.lang'
    package.

    class Number {
        Numnber number;
        java.lang.Number number1; //works fine.

    }

    

4.  Why Java?
    - Java is derived from C, C++ but simplified.
    - Java is architecture neutral
    - Java is object-oriented
    - Java is statically typed
    - Java is dynamic programming language
    - Java supports multi-threaded processing
    - Java supports distributed computing
    - Java environment handles memory management and not by developers
    - C/C++ are compiled into machine specific assembly language but Java is
    designed as a writed-once-run-anywhere language.
    - Java

5.