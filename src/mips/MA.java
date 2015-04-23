package mips;

public class MA {
			String location;
			// location in the memory
			String whatHappens;
			// Lw, sw, branch
			String data;
			// data if sw is going to happen
			int loc;
			// location from binary to decimal
			Memory DataMemory;
			
			String readResult;
		
		public MA( ){
			
			whatHappens = Pipelining.getEXMEM().get("Branch");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemRead");
			whatHappens = whatHappens + Pipelining.getEXMEM().get("MemWrite");
			
			data = Pipelining.getIDEX().get("Data2");
			
			location = Pipelining.getIDEX().get("ALUResult");
			loc = Integer.parseInt(location, 2); 
			
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
				
				break;
			case "001":
				// Memory Write
				// Moves to WB of the last pipelining hashmap
				Pipelining.getMEMWB().put("RegWrite",data);
				break;
			}
		}
		
		
}
