package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {

        static DoStringStuff concatenate = (str1, str2) -> str1 + " " + str2;
        /*static DoStringStuff getBiggestString = (str1, str2) -> {
            if(str1.length() >= str2.length()) return str1;
            else return str2;
        };*/
        static DoubleOperator addition = (n1, n2) -> n1 + n2;
        static DoubleOperator subtraction = (n1, n2) -> n1 - n2;
        static DoubleOperator multiplication = (n1, n2) -> n1 * n2;

        //                                                                  boolean expression ? return this if true : return this if false;
        static DoStringStuff getBiggestString = (str1, str2) -> str1.length() >= str2.length() ? str1 : str2;

        public static String doStringStuff(String input1, String input2, DoStringStuff logic) {
            return logic.operate(input1, input2);
        }

        public static double calcOperation(double n1, double n2, DoubleOperator doubleOperator) {
            return doubleOperator.apply(n1, n2);
        }

        public static ArrayList<Todo> filterTasks(ArrayList<Todo> todoList, TaskFilter filter){
           ArrayList<Todo> result = new ArrayList<>();
            for (Todo todo : todoList) {
                if (filter.matches(todo)) {
                    result.add(todo);
                }
            }
            return result;
        }

        public static void main(String[] args) {

            // String operate(String s1, String s2);
            // (params) -> {method body}
            // {} and return are needed if the method body is more than one row.
            // () around the parameters are only needed if there is more than one parameter
            //DoStringStuff concatenate = (str1, str2) -> str1 + " " + str2;

            System.out.println(doStringStuff("Mehrdad", "Javan", concatenate));
            System.out.println(doStringStuff("Mehrdad", "Javan", getBiggestString));

            System.out.println(calcOperation(3.0, 2.0, addition));
            System.out.println(calcOperation(3.0, 2.0, subtraction));
            System.out.println(calcOperation(3.0, 2.0, multiplication));

            ArrayList<Todo> inMemoryStorage = new ArrayList<>();
            // adding tasks to the list.
            inMemoryStorage.add(new Todo("Buy groceries", false, 2));
            inMemoryStorage.add(new Todo("Finish assignment", true, 1));
            inMemoryStorage.add(new Todo("Call mom", false, 3));
            inMemoryStorage.add(new Todo("Go to the gym", true, 2));
            inMemoryStorage.add(new Todo("Read a book", false, 1));

            // Version 1:
            System.out.println("Version 1 of completed and incompleted tasks");
            TaskFilter completedFilter = (todo) -> todo.isCompleted();
            // Completed Tasks
            List<Todo> completedTasks = new ArrayList<>();
            for (Todo todo : inMemoryStorage) {
                if (completedFilter.matches(todo)) {
                    completedTasks.add(todo);
                }
            }
            System.out.println("completedTasks = " + completedTasks);

            TaskFilter incompletedFilter = (todo) -> !todo.isCompleted();
            // Incompleted Tasks
            List<Todo> incompletedTasks = new ArrayList<>();
            for (Todo todo : inMemoryStorage) {
                if (incompletedFilter.matches(todo)) {
                    incompletedTasks.add(todo);
                }
            }
            System.out.println("inCompletedTasks = " + incompletedTasks + "\n");

            // Version 2
            System.out.println("Version 2 of completed and incompleted tasks");
            // Completed Tasks
            System.out.println("completedTasks2 = " + filterTasks(inMemoryStorage, completedFilter));
            // Incompleted Tasks
            System.out.println("incompletedTasks2 = " + filterTasks(inMemoryStorage, (todo) -> !todo.isCompleted()));
            // System.out.println("incompletedTasks2 = " + filterTasks(inMemoryStorage, incompletedFilter));


            // High Prio Tasks (priority = 1)
            System.out.println("High Prio Tasks: " + filterTasks(inMemoryStorage, (todo) -> todo.getPriority() == 1));

            // High Prio Tasks & Incompleted Tasks
            System.out.println("High Prio Tasks: " + filterTasks(inMemoryStorage, (todo) -> todo.getPriority() == 1 && !todo.isCompleted()));
        }
    }