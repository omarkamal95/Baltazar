
package mips;

import java.util.HashMap;

public class Pipelining {
	private static HashMap<String, String> IFID;
	private static HashMap<String, String> IDEX;
	private static HashMap<String, String> EXMEM;
	private static HashMap<String, String> MEMWB;

	public static void initHashmaps() {
		IFID = new HashMap<String, String>();
		IDEX = new HashMap<String, String>();
		EXMEM = new HashMap<String, String>();
		MEMWB = new HashMap<String, String>();

		IFID.put("instruction", "0");
		IFID.put("PCindex", "0");
		IFID.put("Opcode", "0");

		IDEX.put("PCindex", "0");
		IDEX.put("data1", "0");
		IDEX.put("data2", "0");
		IDEX.put("toMUX0", "0");
		IDEX.put("toMUX1", "0");
		IDEX.put("SignExtend", "0");
		
		//ex
		IDEX.put("RegDst", "0");
		IDEX.put("ALUOp", "0");
		IDEX.put("ALUSrc", "0");
		//m
		IDEX.put("Branch", "0");
		IDEX.put("MemRead", "0");
		IDEX.put("MemWrite", "0");
		
		//wb
		IDEX.put("RegWrite", "0");
		IDEX.put("MemToReg", "0");
		
		//m
		EXMEM.put("Branch", "0");
		EXMEM.put("MemWrite", "0");
		EXMEM.put("MemRead", "0");
		
		//wb
		EXMEM.put("MemToReg", "0");
		EXMEM.put("RegWrite", "0");
		
		EXMEM.put("Zero", "0");
		EXMEM.put("ALUResult", "0");
		EXMEM.put("PCindex", "0"); //after multiplying by 4 to get offset
		EXMEM.put("data2", "0"); //from register block
		EXMEM.put("WriteReg", "0"); 
		
		//wb
		MEMWB.put("MemToReg", "0");
		MEMWB.put("RegWrite", "0");
		MEMWB.put("ReadData", "0");
		MEMWB.put("MemAddress", "0");
		
		MEMWB.put("WriteReg", "0"); 
	}

	public static HashMap<String, String> getIFID() {
		return IFID;
	}

	public static void setIFID(HashMap<String, String> iFID) {
		IFID = iFID;
	}

	public static HashMap<String, String> getIDEX() {
		return IDEX;
	}

	public static void setIDEX(HashMap<String, String> iDEX) {
		IDEX = iDEX;
	}

	public static HashMap<String, String> getEXMEM() {
		return EXMEM;
	}

	public static void setEXMEM(HashMap<String, String> eXMEM) {
		EXMEM = eXMEM;
	}

	public static HashMap<String, String> getMEMWB() {
		return MEMWB;
	}

	public static void setMEMWB(HashMap<String, String> mEMWB) {
		MEMWB = mEMWB;
	}
	public static HashMap<String, String> getEXMEM(HashMap<String, String> mEMWB) {
		return EXMEM;
	}
}
