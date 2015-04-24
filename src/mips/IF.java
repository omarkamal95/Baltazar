package mips;

public class IF {

	public static void fetch() {
		Simulator.PC ++;
		Pipelining.IFID.put("instruction",Simulator.instructions.read(Simulator.PC) );
		Pipelining.IFID.put("PC",""+Simulator.PC );
	}

}
