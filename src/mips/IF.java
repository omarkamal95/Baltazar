package mips;

import com.sun.org.apache.bcel.internal.generic.Instruction;

public class IF {

	public static void fetch() {
		if (Simulator.getPC() < Simulator.instructions.getMemory().size()) {
		String instructionFromMemory = Simulator.instructions.read(Simulator.getPC());
			Simulator.branch = false;
			Pipelining.getIFID().put("instruction",instructionFromMemory);
			Pipelining.getIFID().put("PC",""+Simulator.getPC() );
			Pipelining.getIFID().put("Done", "0");
			if(!Simulator.branch) {
				Simulator.setPC(Simulator.getPC() + 1);
			}
		} else {
			Pipelining.getIFID().put("Done", "1");
		}
	}
}
