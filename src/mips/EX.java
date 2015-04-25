package mips;

public class EX {

	
	public static void execute(){
		
		ALU.eALU();
		
		String signExtend = Pipelining.getIDEX().get("SignExtend");
		int se = Integer.parseInt(signExtend, 2);
		int addex = se +  Simulator.PC;
		
		Pipelining.getEXMEM().put("MemWrite", ""+Pipelining.getIDEX().get("MemWrite"));
		Pipelining.getEXMEM().put("MemRead", ""+Pipelining.getIDEX().get("MemRead"));
		Pipelining.getEXMEM().put("MemtoReg", ""+Pipelining.getIDEX().get("MemtoReg"));
		Pipelining.getEXMEM().put("AddEx", ""+addex);
		Pipelining.getEXMEM().put("Branch", ""+Pipelining.getIDEX().get("Branch"));
		Pipelining.getEXMEM().put("ReadData2", Pipelining.getIDEX().get("ReadData2"));
		
		
		if (Integer.parseInt(Pipelining.getEXMEM().get("Zero")) == 1 && 
				Integer.parseInt(Pipelining.getIDEX().get("Branch")) == 1) {
				
			
		
			Simulator.branch= true;
			
			if(Integer.parseInt(Pipelining.getIDEX().get("Jump")) == 1 ){
				Simulator.PC = Integer.parseInt(Pipelining.getIDEX().get("JumpAdress"));
			}
			else {
				Simulator.PC = addex;
			}
			
		}
		
		
		
		if(Integer.parseInt(Pipelining.getIDEX().get("RegDest")) == 1) {
			Pipelining.getEXMEM().put("WriteReg", Pipelining.getIDEX().get("Rd"));
			
		} else {
			Pipelining.getEXMEM().put("WriteReg", Pipelining.getIDEX().get("Rt"));
			
		}
		
		
				
		
	}
}
