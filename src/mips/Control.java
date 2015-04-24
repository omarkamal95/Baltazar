package mips;

public class Control {
	private String RegDst; // determines if we have an RD?, goes into the register
						// class
	private String Branch; // does it branch?
	private String MemRead; // read from memory?
	private String MemToReg; // put into reg
	private String ALUOp; // two bits for the ALUControl
	private String MemWrite; // write into memory
	private String ALUSrc; // to determine where the second ALU input is from
	private String RegWrite; // will we write to reg?
	private String opcode;
	

	

	public Control() {
		
		opcode = Pipelining.getIFID().get("Opcode");
		
		switch (opcode) {
		// all R-Instructions
		case "000000":
			RegDst = "1";
			Branch = "0";
			MemRead = "0";
			MemToReg = "0";
			ALUOp = "10";
			MemWrite = "0";
			ALUSrc = "0";
			RegWrite = "1";
			break;
		// addi
		case "001000":
			RegDst = "0";
			Branch = "0";
			MemRead = "0";
			MemToReg = "0";
			ALUOp = "00";
			MemWrite = "0";
			ALUSrc = "1";
			RegWrite = "1";
			break;
		// ori
		case "001101":
			RegDst = "0";
			Branch = "0";
			MemRead = "0";
			MemToReg = "0";
			ALUOp = "11";
			MemWrite = "0";
			ALUSrc = "1";
			RegWrite = "1";
			break;
		// lw
		case "100011":
			RegDst = "0";
			Branch = "0";
			MemRead = "1";
			MemWrite = "0";
			MemToReg = "1";
			ALUOp = "00";
			ALUSrc = "1";
			RegWrite = "1";
			break;
		// sw
		case "101011":
			Branch = "0";
			MemRead = "1";
			ALUOp = "00";
			MemWrite = "1";
			ALUSrc = "1";
			RegWrite = "0";
			break;
		// beq
		case "000100":
			Branch = "1";
			MemRead = "0";
			ALUOp = "01";
			MemWrite = "0";
			ALUSrc = "0";
			RegWrite = "0";
			break;
		// j
		case "000010":
			Branch = "0";
			MemRead = "0";
			MemWrite = "0";
			RegWrite = "0";
			break;
		}
		
	}
	
	
	public void WriteToHashMap(){
		// Moves from control to hashmap
		Pipelining.getIDEX().put("MemToReg", MemToReg);
		Pipelining.getIDEX().put("RegWrite", RegWrite);
		
		Pipelining.getIDEX().put("RegDst", RegDst);
		Pipelining.getIDEX().put("ALUOp", ALUOp);
		Pipelining.getIDEX().put("ALUSrc", ALUSrc);
		
		Pipelining.getIDEX().put("Branch", Branch);
		Pipelining.getIDEX().put("MemRead", MemRead);
		Pipelining.getIDEX().put("MeWritee", MemWrite);
	
	}
}
