cp Test-original.class Test.class
javac -cp bcel.jar Obfuscate.java
java -cp .:bcel.jar Obfuscate
java Test