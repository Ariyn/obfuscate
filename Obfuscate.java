import java.util.Arrays;

import org.apache.bcel.*;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

public class Obfuscate {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		JavaClass myClass = Repository.lookupClass("Test");
		// System.out.println("*******Constant Pool*********");
		// System.out.println(myClass.getConstantPool());
		// System.out.println("*******Fields*********");
		// System.out.println(Arrays.toString(myClass.getFields()));
		
		// findConstant(myClass.getConstantPool(), "sample");

		// int a = (int) (Math.random()*10);

		// System.out.println("*******Methods*********");
		// for(Method m: myClass.getMethods()){
		// 	System.out.println(m);
		// }

		ClassGen cg = addRandomMethod(new ClassGen(myClass));
		cg = changeSampleMethod(cg);
		cg.getJavaClass().dump("Test.class");
		// cg.getMethods()
		// System.out.println("*******Methods*********");
		// for(Method m: cg.getMethods()){
		// 	System.out.println(m);
		// 	// System.out.println(m.getCode());
		// }		
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

		il.append(new DLOAD(0));
		il.append(new DCONST(1));
		il.append(new DADD());
		il.append(new LDC2_W(cp.addDouble(2.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(2.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(3.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(5.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(7.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(11.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(13.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(37.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(6.0)));
		il.append(new DSUB());
		il.append(new LDC2_W(cp.addDouble(9.0)));
		il.append(new DDIV());
		il.append(new DSTORE(1));
		il.append(new DLOAD(3));
		il.append(new DCONST(1));
		il.append(new DADD());
		il.append(new LDC2_W(cp.addDouble(2.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(3.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(5.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(5.0)));
		il.append(new DMUL());
		il.append(new LDC2_W(cp.addDouble(823.0)));

		il.append(new DMUL());
		il.append(new DSTORE(3));
		il.append(new DLOAD(1));
		il.append(new DLOAD(3));
		il.append(new DCMPL());
		
		InstructionHandle ih = il.append(new ICONST(1));

		il.append(new IRETURN());
		il.append(new ICONST(0));
		InstructionHandle ih2 = il.insert(new IRETURN());

		il.append(ih, new IFLE(ih2));

		// il.append(new POP());

		MethodGen mg = new MethodGen (
			Constants.ACC_PUBLIC | Constants.ACC_STATIC,
			Type.INT,
			new Type[] {Type.DOUBLE, Type.DOUBLE},
			new String[] {"r1", "r2"},
			"MakeItSuperRandom",
			"Test",
			il,
			cp
		);

		mg.setMaxLocals();
		mg.setMaxStack();
		// Method java/lang/Math.random:()D

		cg.addMethod(mg.getMethod());
		return cg;
	}

	private static ClassGen changeSampleMethod(ClassGen cg) {
		ConstantPoolGen cp = cg.getConstantPool();
		InstructionFactory iFac = new InstructionFactory(cg, cp);

		for(Method m:cg.getMethods()) {
			if(m.getName().equals("main")) {
				MethodGen mg = new MethodGen(m, cg.getClassName(), cp);
				// int ddIndex = mg.addLocalVariable("dd", Type.DOUBLE, null, null).getIndex();

				InstructionList il = mg.getInstructionList();
				InstructionHandle[] iHand = il.getInstructionHandles();

				il = addRandom(il, iFac, iHand, 11);
				il = addRandom(il, iFac, iHand, 13);
				il = addRandom(il, iFac, iHand, 15);
				il = addRandom(il, iFac, iHand, 17);
				il = addRandom(il, iFac, iHand, 49);

				for(int i=0; i<iHand.length; i++) {
					Instruction inst = iHand[i].getInstruction();
					


				}
				il.setPositions();
				mg.setInstructionList(il);
				mg.setMaxStack();
				mg.setMaxLocals();
				mg.removeLineNumbers();

				cg.replaceMethod(m, mg.getMethod());
			} else if(m.getName().equals("mystery")) {
				MethodGen mg = new MethodGen(m, cg.getClassName(), cp);
				// int ddIndex = mg.addLocalVariable("dd", Type.DOUBLE, null, null).getIndex();

				InstructionList il = mg.getInstructionList();
				InstructionHandle[] iHand = il.getInstructionHandles();

				il = addRandom(il, iFac, iHand, 10);
				il = addRandom(il, iFac, iHand, 13);
				il = addRandom(il, iFac, iHand, 20);
				il = addRandom(il, iFac, iHand, 17);
				il = addRandom(il, iFac, iHand, 30);

				for(int i=0; i<iHand.length; i++) {
					Instruction inst = iHand[i].getInstruction();
					


				}
				il.setPositions();
				mg.setInstructionList(il);
				mg.setMaxStack();
				mg.setMaxLocals();
				mg.removeLineNumbers();

				cg.replaceMethod(m, mg.getMethod());
			}
		}

		return cg;
	}

	private static InstructionList addRandom(InstructionList il, InstructionFactory iFac, InstructionHandle[] iHand, int index) {

		il.insert(iHand[index], new DCONST(1.0));
		il.insert(iHand[index], new DCONST(1.0));

		InvokeInstruction invoke =  iFac.createInvoke("Test", "MakeItSuperRandom", Type.INT, new Type[] { Type.DOUBLE, Type.DOUBLE }, Constants.INVOKESTATIC);
		il.insert(iHand[index], invoke);
		// il.insert(iHand[49], invoke);
		// il.insert(iHand[49], new DUP());
		// il.insert(iHand[49], new ICONST(0));
		il.insert(iHand[index], new IFNE(iHand[index]));
		return il;
	}
}

// 2: aload_0
// 3: invokespecial #28                 // Method random:()Z
// 6: ifeq          19
// 9: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;