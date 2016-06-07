javac NewTest.java
javac -cp bcel.jar Obfuscate.java
java -cp .;bcel.jar Obfuscate
rem java -cp .;bcel.jar Obfuscate -t
javac NewTestTest.java
java NewTestTest