package mips;

public class EX {

	
	public static void execute(){
		
		String Done = Pipelining.getIDEX().get("Done");
		Pipelining.getEXMEM().put("Done", Done);
		if (Done.equals("0")) {
			
		ALU.eALU();
		
		String signExtend = Pipelining.getIDEX().get("SignExtend");
		int se = Integer.parseInt(signExtend, 2);
		int addex = se +  Simulator.getPC();
		
		Pipelining.getEXMEM().put("RegWrite", ""+Pipelining.getIDEX().get("RegWrite"));
		Pipelining.getEXMEM().put("MemWrite", ""+Pipelining.getIDEX().get("MemWrite"));
		Pipelining.getEXMEM().put("MemRead", ""+Pipelining.getIDEX().get("MemRead"));
		Pipelining.getEXMEM().put("MemToReg", ""+Pipelining.getIDEX().get("MemToReg"));
		Pipelining.getEXMEM().put("AddEx", ""+addex);
		Pipelining.getEXMEM().put("Branch", ""+Pipelining.getIDEX().get("Branch"));
		Pipelining.getEXMEM().put("ReadData2", Pipelining.getIDEX().get("ReadData2"));
		Pipelining.getEXMEM().put("ReadData1", Pipelining.getIDEX().get("Rs"));
		
		
		if (Integer.parseInt(Pipelining.getEXMEM().get("Zero")) == 1 && 
				Integer.parseInt(Pipelining.getIDEX().get("Branch")) == 1) {
				
			
		
			Simulator.branch= true;
			
			if(Integer.parseInt(Pipelining.getIDEX().get("Jump")) == 1 ){
				Simulator.setPC(Integer.parseInt(Pipelining.getIDEX().get("JumpAdress")));
			}
			else {
				Simulator.setPC(addex);
			}
			
		}
		
		
		if(Integer.parseInt(Pipelining.getIDEX().get("RegDst")) == 1) {
			Pipelining.getEXMEM().put("WriteReg", Pipelining.getIDEX().get("Rd"));
			
		} else {
			Pipelining.getEXMEM().put("WriteReg", Pipelining.getIDEX().get("Rt"));
			
		}
		
		}
		
	}
}
