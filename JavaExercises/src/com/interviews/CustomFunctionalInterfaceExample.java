package com.interviews;

/**
 * A custom functional interface which transform an input type T to the result type R.
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
interface MyFunction<T, R> {
    R transform(T t);
}

@FunctionalInterface
interface MyLogger<T> {
    void log(T t);
}


public class CustomFunctionalInterfaceExample {


    public static void main(String[] args) {

        MyLogger<String> logger = errorMsg -> {
            String timestamp = java.time.LocalDateTime.now().toString();
            System.out.println("[" + timestamp + "] ERROR: " + errorMsg);
        };

        logger.log("error occurred while transforming the object");

        MyFunction<Double, String> function = new MyFunction<Double, String>() {
            @Override
            public String transform(Double aDouble) {
                return "";
            }
        };

        MyFunction<Double, String> percentageToGradeFunction = d -> {
            /*if (d >= 75d) return "Distinction"
            else if (d >= 70d) return "First Class";
            else if (d >= 60d) return "Second Class";
            else if (d >= 40d) return "Third Class";
            return "Failed";*/

            if (d >= 75.00d) {
                return "Distinction";
            } else if (d >= 70.00d) {
                return "First Class";
            } else if (d >= 60.00d) {
                return "Second Class";
            } else if (d >= 40.00d) {
                return "Third Class";
            }
            return "Failed";
        };

        double marks = 75.00d;
        System.out.println("Grade for marks " + marks + ": " + percentageToGradeFunction.transform(marks));

        marks = 00d;
        System.out.println("Grade for marks " + marks + ": " + percentageToGradeFunction.transform(marks));

        marks = 41d;
        System.out.println("Grade for marks " + marks + ": " + percentageToGradeFunction.transform(marks));

    }
}
