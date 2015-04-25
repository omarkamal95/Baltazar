package mips;

import java.util.ArrayList;
import java.util.Arrays;
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
	private static String shamt;
	private static String jumpAddress;

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
		HashMap<String,String> IFID = Pipelining.getIFID();
		String instruction = IFID.get("instruction");
		System.err.println(instruction);
		opcode = instruction.substring(0,6);
		rs = instruction.substring(6, 11);
		rt = instruction.substring(11, 16);
		offset = instruction.substring(16);
		rd = instruction.substring(16, 21);
		shamt = instruction.substring(21, 26);
		functionCode = instruction.substring(26);
		jumpAddress = instruction.substring(6);
	}
	
	public static void loadDataFromRegisters() {
		HashMap<String,String> IFID = Pipelining.getIFID();
		HashMap<String, String> IDEX = Pipelining.getIDEX();
		// Shoof haneb3at el opcode lel controller ezay
		IFID.put("Opcode" , opcode);
		IFID.put("Rs", rs);	
		IFID.put("Rt", rt);
		System.out.println(rs);
		System.out.println(rt);
		
		String newRS = Integer.toBinaryString(Simulator.registers.getRegValue(rs));
		String newRT = Integer.toBinaryString(Simulator.registers.getRegValue(rt));
		
		signExtended = signExtend(offset);
		
		IDEX.put("ReadData1", newRS);
		IDEX.put("ReadData2", newRT);
		IDEX.put("Rd", rd);
		IDEX.put("Rt", rt);
		IDEX.put("Rs", rs);
		IDEX.put("PC", IDEX.get("PC"));
		IDEX.put("SignExtend", signExtended);
		IDEX.put("Function", functionCode);
		IDEX.put("Shamt", shamt);
		IDEX.put("JumpAddress", jumpAddress);
		
		
		
	}
	
	public static String signExtend(String toBeExtended) {
		char extend = toBeExtended.charAt(0);
			for(int i = 0; i < 16; i++) {
				toBeExtended = extend + toBeExtended;
			}
			return toBeExtended;
		}
	
	public static void Decode() {
		String Done = Pipelining.getIFID().get("Done");
		Pipelining.getIDEX().put("Done", Done);
		if (Done.equals("0")) {
		getDataFromPipline();
		loadDataFromRegisters();
		Control.Control();
		}
	}
	
	public static void main(String [] args) {
		Simulator.registers.setReg("01000", 2);//$t0
		Simulator.registers.setReg("01001", 2);//$t1
		Pipelining.initHashmaps();
		Pipelining.getIFID().put("instruction", "00000001001010000100100000100000");
		
		Decode();
		
		System.out.println(Pipelining.getIDEX().keySet());
		System.out.println(Pipelining.getIDEX().values());
		
		
		
	}
}
