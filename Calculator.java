import java.util.Arrays;

import org.apache.bcel.*;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

public class Calculator {

	public static void main(String[] args) throws Exception {
		JavaClass myClass = Repository.lookupClass("HowMany");

		ClassGen cg = new ClassGen(myClass);
		ConstantPoolGen cp = cg.getConstantPool();

		for(Method m:cg.getMethods()) {
			MethodGen mg = new MethodGen(m, cg.getClassName(), cp);
			System.out.println(m.getName());

			InstructionList il = mg.getInstructionList();
			InstructionHandle[] iHand = il.getInstructionHandles();

			for(int i=0; i<iHand.length; i++) {
				Instruction inst = iHand[i].getInstruction();
				String a = inst.getName();
				
				if(a.equals("goto")) {
					GOTO g = (GOTO)inst;
					System.out.print(g);
					System.out.print("\t");
					// System.out.print(g.getPosition());
					System.out.print("\t");
					System.out.print(g.getTarget());
					System.out.print("\t");
					System.out.println(g.getIndex());
				} else {
					System.out.println(a);
				}

			}

		}
	}

}