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
			
			static String jumpFlag;
			
			static String byteFlag;
			
			static String unsignedFlag;
			
			static String upperFlag;
		
		public MA( ){
			
			whatHappens = Pipelining.getEXMEM().get("Branch");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemRead");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemWrite");
			
			data = Pipelining.getIDEX().get("Data2");
			
			location = Pipelining.getIDEX().get("ALUResult");
			loc = Integer.parseInt(location, 2); 
			
			PCofMA = Simulator.getPC();
			
			
			jumpFlag = Pipelining.getIDEX().get("Jump");
			byteFlag = Pipelining.getIDEX().get("Byte");
			unsignedFlag = Pipelining.getIDEX().get("Byte"); 
			upperFlag = Pipelining.getIDEX().get("Upper"); 
			
			doMA();
			
		}
		
		public void doMA(){
			readResult = DataMemory.read(loc);
			
			switch(whatHappens){
			
			case "100":
				//Branch
				break;
				
			case "010":
				// Memory Read
				
				if(upperFlag=="1"){
					// The immediate value is shifted left 16 bits and stored in the register. The lower 16 bits are zeroes
					String upperI = readResult.substring(0,15);
					upperI = "0000000000000000" + upperI;
					Pipelining.getMEMWB().put("ReadData", upperI);	
				}
				if (byteFlag=="1" && unsignedFlag=="1"){
					String upperByte = readResult.substring(0,7);
					upperByte = "00000000000000000000000000000000" + upperByte;
					Pipelining.getMEMWB().put("ReadData", upperByte);
				}
				
				
							break;			
				
			case "001":
				// Memory Write
				// Moves to WB of the last pipelining hashmap
				if(byteFlag=="1"){
				data = data.substring(0,7);
				}
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
