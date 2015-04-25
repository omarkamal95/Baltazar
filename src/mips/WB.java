package mips;

public class WB {
			
			static String RegDestination; // 
			static String WriteRegister; // Will we WB? 
			static String value;
			static String load;
			
			public WB(){
				
				WriteRegister = Pipelining.getMEMWB().get("RegWrite");
				RegDestination = Pipelining.getMEMWB().get("WriteReg"); 
				
				
			}
			
			public static void WriteToRegisters(){
				WriteRegister = Pipelining.getMEMWB().get("RegWrite");
				RegDestination = Pipelining.getMEMWB().get("WriteReg");
				value = Pipelining.getMEMWB().get("ReadData"); 
				load =Pipelining.getEXMEM().get("MemRead");
				
				if(WriteRegister=="1"){
					if(load=="0"){
					Registers.getRegisters().put(RegDestination, Integer.parseInt(Pipelining.getIDEX().get("ALUResult")));
				}
					else{
						Registers.getRegisters().put(RegDestination, Integer.parseInt(Pipelining.getMEMWB().get("ReadData")));
					}
			}
			}
}
