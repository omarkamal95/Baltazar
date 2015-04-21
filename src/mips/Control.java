package mips;

public class Control {
	private int RegDst; // determines if we have an RD?, goes into the register
						// class
	private int Branch; // does it branch?
	private int MemToRead; // read from memory?
	private int MemToReg; // put into reg
	private String ALUOp; // two bits for the ALUControl
	private int MemWrite; // write into memory
	private int ALUSrc; // to determine where the second ALU input is from
	private int RegWrite; // will we write to reg?

	public String getALUOp() {
		return ALUOp;
	}

	public int getALUSrc() {
		return ALUSrc;
	}

	public int getBranch() {
		return Branch;
	}

	public int getMemToRead() {
		return MemToRead;
	}

	public int getMemToReg() {
		return MemToReg;
	}

	public int getMemWrite() {
		return MemWrite;
	}

	public int getRegDst() {
		return RegDst;
	}

	public int getRegWrite() {
		return RegWrite;
	}

	public void setALUOp(String aLUOp) {
		ALUOp = aLUOp;
	}

	public void setALUSrc(int aLUSrc) {
		ALUSrc = aLUSrc;
	}

	public void setBranch(int branch) {
		Branch = branch;
	}

	public void setMemToRead(int memToRead) {
		MemToRead = memToRead;
	}

	public void setMemToReg(int memToReg) {
		MemToReg = memToReg;
	}

	public void setMemWrite(int memWrite) {
		MemWrite = memWrite;
	}

	public void setRegDst(int regDst) {
		RegDst = regDst;
	}

	public void setRegWrite(int regWrite) {
		RegWrite = regWrite;
	}

	public Control(String opcode) {
		switch (opcode) {
		// all R-Instructions
		case "000000":
			RegDst = 1;
			Branch = 0;
			MemToRead = 0;
			MemToReg = 0;
			ALUOp = "10";
			MemWrite = 0;
			ALUSrc = 0;
			RegWrite = 1;
			break;
		// addi
		case "001000":
			RegDst = 0;
			Branch = 0;
			MemToRead = 0;
			MemToReg = 0;
			ALUOp = "00";
			MemWrite = 0;
			ALUSrc = 1;
			RegWrite = 1;
			break;
		// ori
		case "001101":
			RegDst = 0;
			Branch = 0;
			MemToRead = 0;
			MemToReg = 0;
			ALUOp = "11";
			MemWrite = 0;
			ALUSrc = 1;
			RegWrite = 1;
			break;
		// lw
		case "100011":
			RegDst = 0;
			Branch = 0;
			MemToRead = 1;
			MemWrite = 0;
			MemToReg = 1;
			ALUOp = "00";
			ALUSrc = 1;
			RegWrite = 1;
			break;
		// sw
		case "101011":
			Branch = 0;
			MemToRead = 1;
			ALUOp = "00";
			MemWrite = 1;
			ALUSrc = 1;
			RegWrite = 0;
			break;
		// beq
		case "000100":
			Branch = 1;
			MemToRead = 0;
			ALUOp = "01";
			MemWrite = 0;
			ALUSrc = 0;
			RegWrite = 0;
			break;
		// j
		case "000010":
			Branch = 0;
			MemToRead = 0;
			MemWrite = 0;
			RegWrite = 0;
			break;
		}
	}
}
