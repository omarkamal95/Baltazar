package mips;

public class IF {
	private String instruction;
	private static int index;
	private Memory instructions = new Memory();
	private String toSignExtend;
	private String toMUXOne;
	private String toMUXZero;
	private String toRegTwo;
	private String toRegOne;
	private String opcode;

	public String getInstruction() {
		return instruction;
	}

	public static int getIndex() {
		return index;
	}

	public Memory getInstructions() {
		return instructions;
	}

	public String getOpcode() {
		return opcode;
	}

	public String getToMUXOne() {
		return toMUXOne;
	}

	public String getToMUXZero() {
		return toMUXZero;
	}

	public String getToRegOne() {
		return toRegOne;
	}

	public String getToRegTwo() {
		return toRegTwo;
	}

	public String getToSignExtend() {
		return toSignExtend;
	}

	public IF() {
		index++;
		instruction = instructions.read(index).toString();
		InstructionMemory(instruction);
	}

	public void InstructionMemory(String instruction) {
		toSignExtend = instruction.substring(16, 31);
		toMUXOne = instruction.substring(16, 20);
		toMUXZero = instruction.substring(11, 15);
		toRegTwo = instruction.substring(11, 15);
		toRegOne = instruction.substring(0, 5);
		opcode = instruction.substring(26, 31);
	}
}
