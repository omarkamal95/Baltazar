package mips;

public class Control {
	private int RegDst; // determines if we have an RD?, goes into the register
						// class
	private int Branch; //does it branch?
	private int MemToRead; //read from memory?
	private int MemToReg; //put into reg
	private String ALUOp; // two bits for the ALUControl
	private int MemWrite;	//write into memory
	private int ALUSrc;	//to determine where the second ALU input is from 
	private int RegWrite;	//will we write to reg?

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
}
