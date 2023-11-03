Simple framework to easily run Leetcode-like exercises in your IDE

Steps to add new exercise:
 - create a new class with the name of your exercise
 - extend AbstractLeetcodeExercise and create an arg-constructor and implement the method exerciseLogic
 - implement a public static method that returns a List of ArgsAndExpected with your test cases
 - add your newly created class to the static exercise list in the Main class
 - run the main in Main

Existing exercises should serve as example for other implementation details
