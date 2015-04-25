package mips;

import java.util.HashMap;

public class ALU {
	private static String inputOne;
	private static String inputTwo;
	private String opcode;
	static Memory dataMemory = new Memory();
	static HashMap<String, String> IDEX;
	static HashMap<String, String> EXMEM;

	

	public static void eALU() {
		String ALUOp = IDEX.get("ALUOp");
		String functionCode = IDEX.get("Function");
		inputOne = IDEX.get("ReadData1");
		if (IDEX.get("ALUSrc") == "1")
			inputTwo = IDEX.get("SignExtend");
		else
			inputTwo = IDEX.get("ReadData2");
		switch (ALUOp) {
		// add -- LW and SW
		case "00":
			EXMEM.put(
					"ALUResult",
					moreDigits(5, (Integer.parseInt(inputOne, 2) + Integer
							.parseInt(inputTwo, 2))));
			break;
		// sub -- BRANCH
		case "01":
			EXMEM.put(
					"ALUResult",
					moreDigits(5, (Integer.parseInt(inputOne, 2) - Integer
							.parseInt(inputTwo, 2))));
			if (Integer.parseInt(EXMEM.get("ALUResult")) == 0)
				EXMEM.put("Zero", "1");
			else
				EXMEM.put("Zero", "0");
			break;
		// R-INSTRUCTIONS
		case "10":
			switch (functionCode) {
			// add
			case "100000":
				EXMEM.put(
						"ALUResult", moreDigits(5, (Integer.parseInt(inputOne, 2) + Integer
								.parseInt(inputTwo, 2))));
				break;
			// sub
			case "100010":
				EXMEM.put(
						"ALUResult",
						moreDigits(5, (Integer.parseInt(inputOne, 2) - Integer
								.parseInt(inputTwo, 2))));
				break;
			// and
			case "100100":
				EXMEM.put(
						"ALUResult",
						moreDigits(5, (Integer.parseInt(inputOne, 2) & Integer
								.parseInt(inputTwo, 2))));
				break;
			// or
			case "100101": 
				EXMEM.put(
						"ALUResult", moreDigits(5, (Integer.parseInt(inputOne, 2) ^ Integer
								.parseInt(inputTwo, 2))));
				break;
			// nor
			case "100111":
				EXMEM.put(
						"ALUResult", moreDigits(5, ~(Integer.parseInt(inputOne, 2) | Integer.parseInt(inputTwo, 2))));
				break;
				// slt
			case "101010":
				if (Integer.parseInt(inputOne, 2) > Integer.parseInt(inputTwo,
						2))
					EXMEM.put("ALUResult", "0");
				else
					EXMEM.put("ALUResult", "1");
				break;
			// sll
			case "000000":
				EXMEM.put("ALUResult", moreDigits(
						5,
						(Integer.parseInt(inputOne, 2) << Integer.parseInt(
								IDEX.get("Shamt"), 2))));
				break;
				//srl
			case "000010":
				EXMEM.put(
						"ALUResult", moreDigits(5,
						(Integer.parseInt(inputOne, 2) >>> Integer.parseInt(
								IDEX.get("Shamt"), 2))));
				break;
				//jr --not sure, t2reeban msh bydkholhom
			case "001000":
				EXMEM.put("ALUResult", inputTwo);
				break;

			}
			break;
		case "11":
			//bne
			EXMEM.put(
					"ALUResult",
					moreDigits(5, (Integer.parseInt(inputOne, 2) - Integer
							.parseInt(inputTwo, 2))));
			if (Integer.parseInt(EXMEM.get("ALUResult")) == 0)
				EXMEM.put("Zero", "0");
			else
				EXMEM.put("Zero", "1");
			break;
		default:
			break;
		
		}
	}

	public static String moreDigits(int size, int x) {
		String binary = Integer.toBinaryString(x);
		for (int i = size - binary.length(); i > 0; i--) {
			binary = "0" + binary;
		}
		return binary.substring(binary.length() - size, binary.length());

	}
	public static void main(String[] args) {
		Pipelining.initHashmaps();
		IDEX = Pipelining.getIDEX();
		EXMEM = Pipelining.getEXMEM();
		IDEX.put("ReadData1", "00100");
		IDEX.put("ReadData2", "00001");
		IDEX.put("Jump", "0");
		IDEX.put("ALUOp", "00");
		IDEX.put("SignExtend", "0000000");
		IDEX.put("Function", "000010");
		IDEX.put("ALUSrc", "0");
		IDEX.put("shamt", "00001");
		eALU();
		System.out.println(EXMEM.get("ALUResult"));
		System.out.println(EXMEM.get("Zero"));
		//System.out.println(moreDigits(5, Integer.parseInt(EXMEM.get("ALUResult"))));
	}
}
