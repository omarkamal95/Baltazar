package mips;

public class IF {

	public static void fetch() {
		Simulator.setPC(Simulator.getPC() + 1);
		Pipelining.getIFID().put("instruction",Simulator.instructions.read(Simulator.getPC()) );
		Pipelining.getIFID().put("PC",""+Simulator.getPC() );
	}

}
