package mips;

import com.sun.xml.internal.ws.api.pipe.Pipe;

public class Control {
	private static String RegDst; // determines if we have an RD?, goes into the
							// register
							// class
	private static String Branch = "0"; // does it branch?
	private static String MemRead = "0"; // read from memory?
	private static String MemToReg = "0"; // put into reg
	private static String ALUOp = "00"; // two bits for the ALUControl
	private static String MemWrite = "0"; // write into memory
	private static String ALUSrc = "0"; // to determine where the second ALU input is from
	private static String RegWrite = "0"; // will we write to reg?
	private static String opcode = "0";
	private static String Jump = "0";
	private static String Byte = "0";
	private static String Unsigned = "0";
	private static String Upper = "0";
	
	
	public static void Control() {

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
			Unsigned = "0";
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
			Unsigned = "0";
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
			Unsigned = "0";
			break;
		// sw
		case "101011":
			Branch = "0";
			MemRead = "1";
			ALUOp = "00";
			MemWrite = "1";
			ALUSrc = "1";
			RegWrite = "0";
			Unsigned = "0";
			break;
		//sb
		case "101000":
			Branch = "0";
			MemRead = "1";
			ALUOp = "00";
			MemWrite = "1";
			ALUSrc = "1";
			RegWrite = "0";
			Byte="1";
			Unsigned = "0";
			break;
		// beq
		case "000100":
			Branch = "1";
			MemRead = "0";
			ALUOp = "01";
			MemWrite = "0";
			ALUSrc = "0";
			RegWrite = "0";
			Unsigned = "0";
			break;
		// bne
		case "000101":
			Branch = "1";
			MemRead = "0";
			ALUOp = "11";
			MemWrite = "0";
			ALUSrc = "0";
			RegWrite = "0";
			Unsigned = "0";
			break;
		// lui
		case "001111":
			RegDst = "0";
			Branch = "0	";
			MemRead = "1";
			MemWrite = "0";
			MemToReg = "1";
			ALUOp = "11";
			ALUSrc = "1";
			RegWrite = "1";
			Upper="1";
			Unsigned = "0";
			break;
		// j
		case "000010":
			Branch = "0";
			MemRead = "0";
			MemWrite = "0";
			RegWrite = "0";
			Jump="10";
			Unsigned = "0";
			break;
		// jal
		case "000011":
			Branch = "0";
			MemRead = "0";
			MemWrite = "0";
			RegWrite = "1";
			Jump = "01";
			Unsigned = "0";
			break;
		//lb
		case "100000":
			Byte="1";
			RegDst = "0";
			Branch = "0";
			MemRead = "1";
			MemWrite = "0";
			MemToReg = "1";
			ALUOp = "00";
			ALUSrc = "1";
			RegWrite = "1";
			Unsigned = "0";
			break;
		//lbu
		case "100100":
			Byte="1";
			RegDst = "0";
			Branch = "0";
			MemRead = "1";
			MemWrite = "0";
			MemToReg = "1";
			ALUOp = "00";
			ALUSrc = "1";
			RegWrite = "1";
			Unsigned = "1";
			break;
		
		
		}

		// Moves from control to hashmap
		Pipelining.getIDEX().put("MemToReg", MemToReg);
		Pipelining.getIDEX().put("RegWrite", RegWrite);

		Pipelining.getIDEX().put("RegDst", RegDst);
		Pipelining.getIDEX().put("ALUOp", ALUOp);
		Pipelining.getIDEX().put("ALUSrc", ALUSrc);

		Pipelining.getIDEX().put("Branch", Branch);
		Pipelining.getIDEX().put("MemRead", MemRead);
		Pipelining.getIDEX().put("MemWrite", MemWrite);
		Pipelining.getIDEX().put("Jump", Jump);
		Pipelining.getIDEX().put("Byte", Byte);
		Pipelining.getIDEX().put("Unsigned", Unsigned);
	}
}
