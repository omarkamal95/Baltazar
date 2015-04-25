package mips;

public class WB {

	static String RegDestination; //
	static String WriteRegister; // Will we WB?
	static String value;
	static String load;

	public WB() {

		WriteRegister = Pipelining.getMEMWB().get("RegWrite");
		RegDestination = Pipelining.getMEMWB().get("WriteReg");

	}

	public static void WriteToRegisters() {
		String Done = Pipelining.getMEMWB().get("Done");

		if (Done.equals("0")) {
			RegDestination = Pipelining.getMEMWB().get("RegWrite");
			WriteRegister = Pipelining.getMEMWB().get("WriteReg");
			value = Pipelining.getMEMWB().get("ReadData");
			load = Pipelining.getMEMWB().get("MemRead");
			if (RegDestination.equals("1")) {
				if (load.equals("1")) {
					
					Simulator.getRegisters().put(
							WriteRegister,Integer.parseInt(value));
				} else {
					Simulator.getRegisters().put(
							WriteRegister,Integer.parseInt(value));

					// Simulator.getRegisters().put(WriteRegister,
					// Integer.parseInt(Pipelining.getMEMWB().get("ALUResult"),2));
				}
			}
		}
	}
}
