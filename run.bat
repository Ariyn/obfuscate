rem copy Test-original.class Test.class
rem javac -cp bcel.jar Obfuscate.java
rem java -cp .;bcel.jar Obfuscate
rem java -cp .;bcel.jar Obfuscate -t
rem javac NewTestTest.java
rem java NewTestTest
rem java Test

javac -cp bcel.jar Calculator.java
java -cp .;bcel.jar Calculator