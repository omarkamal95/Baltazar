package mips;

public class WB {
			
			static String RegDestination; // 
			static String WriteRegister; // Will we WB? 
			
			public WB(){
				
				WriteRegister = Pipelining.getMEMWB().get("RegWrite");
				RegDestination = Pipelining.getMEMWB().get("WriteReg"); 
				
				
				
			}
			
			public static void WriteToRegisters(){
				WriteRegister = Pipelining.getMEMWB().get("RegWrite");
				RegDestination = Pipelining.getMEMWB().get("WriteReg");
				if(WriteRegister=="1"){
					Registers.getRegisters().put(RegDestination, Integer.parseInt(Pipelining.getIDEX().get("ALUResult")));
				}
			}
}
