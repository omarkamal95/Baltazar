package mips;

public class Assembler {
	// opcode, register number,
	private static String functionCode;
	private static String opcode;
	private static String function;
	private static String input1;
	private static String input2;
	private static String input3;
	static String[] instructionArray = new String[4];

	public static void assemble(String instruction) {
		instructionArray = instruction.split(",");
		function = instructionArray[0];
		input1 = instructionArray[1];
		input2 = instructionArray[2];
		input3 = instructionArray[3];
	}

	public static void toOpcode() {
		switch (function.toLowerCase()) {
		case "add": {
			functionCode = "100000";
			opcode = "000000";
		}
		case "sub": {
			functionCode = "100010";
			opcode = "000000";
		}
		case "and": {
			functionCode = "100100";
			opcode = "000000";
		}
		case "nor": {
			functionCode = "100111";
			opcode = "000000";
		}
		case "or": {
			functionCode = "100101";
			opcode = "000000";
		}
		case "slt": {
			functionCode = "101010";
			opcode = "000000";
		}
		case "sll": {
			functionCode = "000000";
			opcode = "000000";
		}
		case "slr": {
			functionCode = "000010";
			opcode = "000000";
		}
		case "addi":{
			opcode = "001000";
		}
		
		}
	}

}
