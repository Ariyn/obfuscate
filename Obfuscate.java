import java.util.Arrays;

import org.apache.bcel.*;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

public class Obfuscate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JavaClass myClass = Repository.lookupClass("NewTest");
		// System.out.println("*******Constant Pool*********");
		// System.out.println(myClass.getConstantPool());
		// System.out.println("*******Fields*********");
		// System.out.println(Arrays.toString(myClass.getFields()));
		
		// findConstant(myClass.getConstantPool(), "sample");

		int a = (int) (Math.random()*10);

		System.out.println("*******Methods*********");
		for(Method m: myClass.getMethods()){
			System.out.println(m);
		}

		ClassGen cg = addRandomMethod(new ClassGen(myClass));
		cg.getJavaClass().dump("NewTest.class");
		// cg.getMethods()
		System.out.println("*******Methods*********");
		for(Method m: cg.getMethods()){
			System.out.println(m);
			// System.out.println(m.getCode());
		}		
	}	
	// int a = (int) (Math.random()*10);

	private static void findConstant(ConstantPool cp, String tag) {
		System.out.println("*******Constants*********");
		for(Constant c: cp.getConstantPool()) {
			if(c != null) {
				System.out.print(c);
				System.out.print("\t");
				System.out.println(c.getTag());
			}
		}
		System.out.println("\n");
	}

	private static ClassGen addRandomMethod(ClassGen cg) {
		ConstantPoolGen cp = cg.getConstantPool();
		InstructionList il = new InstructionList();
		InstructionFactory iFac = new InstructionFactory(cg, cp);

		GETSTATIC getStatic = iFac.createGetStatic("java.lang.System", "out", new ObjectType("java.io.PrintStream"));

		il.append(getStatic);
		il.append(new ALOAD(0));
		// il.append(new INVOKESTATIC(cp.addMethodref("java/lang/Math", "random", "()D")));
		// il.append(new ALOAD(0));
		il.append(iFac.createInvoke("java/io/PrintStream", "println", Type.VOID, new Type[] {Type.STRING}, Constants.INVOKEVIRTUAL));
		il.append(new RETURN());

		MethodGen mg = new MethodGen (
			Constants.ACC_STATIC | Constants.ACC_PUBLIC,
			Type.VOID,
			new Type[] {Type.STRING},
			new String[] {"str"},
			"willBeAdded",
			"NewTest",
			il,
			cp
		);

		mg.setMaxLocals();
		mg.setMaxStack();
		// Method java/lang/Math.random:()D

		cg.addMethod(mg.getMethod());
		return cg;
	}
}

