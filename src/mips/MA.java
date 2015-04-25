package mips;

public class MA {
			static String location;
			// location in the memory
			static String whatHappens;
			// Lw, sw, branch
			static String data;
			// data if sw is going to happen
			static int loc;
			// location from binary to decimal
			static Memory DataMemory;
			// Memory that has ld/sw performed on
			
			static String readResult;
			// the value read from the memory
			
			static int PCofMA;
			// the value of PC at the instance
			
			static String OpCodeSubString;
			// first 6 bits of the current Instruction's opcode to check lb/lbu/sb/lui/sw/lw
		
		public MA( ){
			
			whatHappens = Pipelining.getEXMEM().get("Branch");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemRead");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemWrite");
			
			data = Pipelining.getIDEX().get("Data2");
			
			location = Pipelining.getIDEX().get("ALUResult");
			loc = Integer.parseInt(location, 2); 
			
			PCofMA = Simulator.getPC();
			
			OpCodeSubString = (Assembler.getResultCode()).substring(0,5);
			
			doMA();
			
		}
		
		public void doMA(){
			
			switch(whatHappens){
			
			case "100":
				//Branch
				break;
				
			case "010":
				// Memory Read
				readResult = DataMemory.read(loc);
				Pipelining.getMEMWB().put("ReadData", readResult);
				
						switch(OpCodeSubString){
						case "100101": 
					// lb
					Pipelining.getMEMWB().put("ReadData", readResult.substring(0, 7));
						case "":
												}
				
				break;
				
			case "001":
				// Memory Write
				// Moves to WB of the last pipelining hashmap
				Pipelining.getMEMWB().put("RegWrite",data);
				break;
			}
		}

		public Memory getDataMemory() {
			return DataMemory;
		}

		public void setDataMemory(Memory dataMemory) {
			//DATA MEMORY men fein!?
			DataMemory = dataMemory;
		}

		public String getReadResult() {
			return readResult;
		}

		public void setReadResult(String readResult) {
			this.readResult = readResult;
		}
		
		
}
