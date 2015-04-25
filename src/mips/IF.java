package mips;

public class IF {

	public static void fetch() {
		
		if(!Simulator.branch) {
		Simulator.setPC(Simulator.getPC() + 1);
		}
		Simulator.branch = false;
		Pipelining.getIFID().put("instruction",Simulator.instructions.read(Simulator.getPC()) );
		Pipelining.getIFID().put("PC",""+Simulator.getPC() );
	}
}
