package mips;

import java.util.HashMap;

import com.sun.org.apache.xalan.internal.xsltc.dom.LoadDocument;

public class ID {

	private String WriteReg;
	private static String rs;
	private static String rt;
	private static String rd;
	private static String opcode;
	private static String offset;
	private static String functionCode;
	private static String signExtended;

	public String getRs() {
		return rs;
	}

	public String getRt() {
		return rt;
	}

	public String getWriteReg() {
		return WriteReg;
	}
	
	public static void getDataFromPipline() {
		HashMap<String,String> IFID = Piplining.getIFID();
		String instruction = IFID.get("instruction");
		opcode = instruction.substring(0,5);
		rs = instruction.substring(6, 10);
		rt = instruction.substring(11, 15);
		offset = instruction.substring(16);
		rd = instruction.substring(16, 20);
		functionCode = instruction.substring(26);		
	}
	
	public static void loadDataFromRegisters() {
		HashMap<String,String> IFID = Piplining.getIFID();
		HashMap<String, String> IDEX = Piplining.getIDEX();
		// Shoof haneb3at el opcode lel controller ezay
		IFID.put("Opcode" , opcode);
		IFID.put("Rs", rs);
		IFID.put("Rt", rt);
		
		String newRS = Integer.toString(Simulator.registers.getRegValue(rs));
		String newRT = Integer.toString(Simulator.registers.getRegValue(rt));
		
		signExtended = signExtend(offset);
		
		IDEX.put("Rs", newRS);
		IDEX.put("Rt", newRT);
		IDEX.put("Rd", rd);
		IDEX.put("PC", IDEX.get("PC"));
		IDEX.put("SignExtended", signExtended);
		IDEX.put("Function", functionCode);
		
	}
	
	public static String signExtend(String toBeExtended) {
		char extend = toBeExtended.charAt(0);
			for(int i = 0; i < 16; i++) {
				toBeExtended = extend + toBeExtended;
			}
			return toBeExtended;
		}
	
	public ID() {

		
	}
	
	public static void Decode() {
		getDataFromPipline();
		loadDataFromRegisters();
		
	}
}
