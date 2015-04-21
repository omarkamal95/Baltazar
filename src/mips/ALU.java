package mips;

public class ALU {
	private String inputOne;
	private String inputTwo;
	private String opcode;
	static Memory dataMemory = new Memory();

	public void typeOfInstruction(String instruction) {
		opcode = instruction.substring(0, 5);
		// R
		if (opcode.equals("00000")) {
			String rs = instruction.substring(6, 10);
			String rt = instruction.substring(11, 15);
			String rd = instruction.substring(16, 20);
			String shamt = instruction.substring(21, 25);
			String funct = instruction.substring(26, 31);
		}
	}

	public ALU(int ALUSrc, String signExtend, String DataOne, String DataTwo) {
		inputOne = DataOne;
		if (ALUSrc == 1)
			inputTwo = signExtend;
		else
			inputTwo = DataTwo;
	}

	public static String executeR(String opcode, String rs, String rt,
			String rd, String shamt, String funcode) {

		switch (funcode) {
		// handle overflow!
		// Add
		case "100000":
			return rd = (Integer.parseInt(rs, 2) + Integer.parseInt(rt, 2))
					+ "";
			// Subtract
		case "100010":
			return rd = (Integer.parseInt(rs, 2) - Integer.parseInt(rt, 2))
					+ "";
			// AND
		case "100100":
			return rd = to5Digits((Integer.parseInt(rs, 2) & Integer.parseInt(
					rt, 2)));
			// NOR
		case "100111":
			return rd = to5Digits(~(Integer.parseInt(rs, 2) | Integer.parseInt(
					rt, 2)));
			// OR
		case "100101":
			return rd = to5Digits((Integer.parseInt(rs, 2) | Integer.parseInt(rt, 2)));
			// Set Less Than
		case "101010":
			if (Integer.parseInt(rs, 2) < Integer.parseInt(rt, 2))
				return rd = "00001";
			return rd = "00000";
			// Shift logic left
		case "000000":
			return rd = to5Digits((Integer.parseInt(rt, 2) << Integer.parseInt(shamt, 2)));
			// Shift Logic Right
		case "000010":
			return rd = to5Digits((Integer.parseInt(rt, 2) >>> Integer.parseInt(shamt, 2)));
		default:
			return rd = "00000";

		}
	}

	// Excute I Type
	public static String executeI(String opcode, String rs, String rt,
			String address) {
		switch (opcode) {
		// Addi
		case "001000":
			return rt = to5Digits((Integer.parseInt(rs, 2) + Integer.parseInt(
					address, 2)));
			// Slti
		case "001010":
			if (Integer.parseInt(rs, 2) < Integer.parseInt(address, 2))
				return rt = "00001";
			return rt = "00000";
			// Load
		case "100011":
			return rt = to5Digits(Integer.parseInt(rs, 2)
					+ Integer.parseInt(address, 2));
			// Store
		case "101011":
			return to5Digits(Integer.parseInt(rs, 2)
					+ Integer.parseInt(address, 2));

		default:
			return "0";
		}

	}

	public static String to5Digits(int x) {
		String binary = Integer.toBinaryString(x);
		for (int i = 5 - binary.length(); i > 0; i--) {
			binary = "0" + binary;
		}
		return binary;
	}

	public static void main(String[] args) {
		System.out.println(executeI("001000", "00010", "00001",
				"0000000000000001"));
		System.out.println(to5Digits(2));
	}
}
