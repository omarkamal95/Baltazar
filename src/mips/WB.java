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
				RegDestination = Pipelining.getMEMWB().get("RegWrite");
				WriteRegister = Pipelining.getMEMWB().get("WriteReg");
				value = Pipelining.getMEMWB().get("ReadData"); 
				load =Pipelining.getMEMWB().get("MemRead");
				System.out.println(WriteRegister);
				if(RegDestination.equals("1")){
					if(load.equals("0")){
					Simulator.getRegisters().put(WriteRegister, Integer.parseInt(Pipelining.getMEMWB().get("ALUResult"), 2));
				}
					else{
						Simulator.getRegisters().put(WriteRegister, Integer.parseInt(Pipelining.getMEMWB().get("ALUResult"),2));
					}
			}
			}
}
