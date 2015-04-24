package mips;

public class IF {

	public static void fetch() {
		if(!Simulator.branch) {
		Simulator.PC ++;
		}
		Simulator.branch = false;
		Pipelining.getIFID().put("instruction",Simulator.instructions.read(Simulator.PC) );
		Pipelining.getIFID().put("PC",""+Simulator.PC );
	}

}
