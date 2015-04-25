package mips;

import java.util.HashMap;

public class Simulator {
	static boolean branch = false;
	static Memory instructions, data = new Memory();
	static Registers registers = new Registers();

	public static Memory getInstructions() {
		return instructions;
	}

	public static void setInstructions(Memory instructions) {
		Simulator.instructions = instructions;
	}

	public static Memory getData() {
		return data;
	}

	public static void setData(Memory data) {
		Simulator.data = data;
	}

	public static Registers getRegisters() {
		return registers;
	}

	public static void setRegisters(Registers registers) {
		Simulator.registers = registers;
	}

	private static int PC = -1;

	public void inputStoring(String[] inputInstruction) {
		for (String instr : inputInstruction) {
			String bInstr = Assembler.assemble(instr);
			instructions.write(++PC, bInstr);
		}

	}

	public void startPipe() {
		// make sure fetch checks if there is a new instruction

		PC = 0;
		int sizeOfMemory = instructions.getMemory().size();

		for (int i = 0; i < 9; i++) {
			if (i == 5) {
				cycle(4);
			}
			cycle(i);
		}

	}

	public void cycle(int i) {
		switch (i) {
		case 0:
			System.out.println("DAKHAL FETCH");
			IF.fetch();
			System.out.println("IFID Values " + Pipelining.getIFID());
			break;
		case 1:
			System.out.println("DAKHAL DECODE");
			ID.Decode();
			System.out.println("IFID Values " + Pipelining.getIFID());
			System.out.println("Pipelining.getIDEX()" + Pipelining.getIDEX());
			IF.fetch();
			break;
		case 2:
			System.out.println("Dakhal Execute");
			EX.execute();
			System.out.println("Pipelining.getEXMEM()" + Pipelining.getEXMEM());
			ID.Decode();
			IF.fetch();
			break;
		case 3:
			System.out.println("Dakhal MA");
			MA.doMA();
			System.out
					.println("Pipelining.getMEMWB() " + Pipelining.getMEMWB());
			EX.execute();
			ID.Decode();
			IF.fetch();
			break;
		case 4:
			System.out.println("Dakhal WB");
			WB.WriteToRegisters();
			System.out.println("REGISTER VALUES " + registers.registers);
			MA.doMA();
			EX.execute();
			ID.Decode();
			IF.fetch();
			break;
		case 5:
			WB.WriteToRegisters();
			MA.doMA();
			EX.execute();
			ID.Decode();
			break;
		case 6:
			WB.WriteToRegisters();
			MA.doMA();
			EX.execute();
			break;
		case 7:
			WB.WriteToRegisters();
			MA.doMA();
			break;
		case 8:
			WB.WriteToRegisters();
			System.out.println("REGISTER VALUES FEL AKHER KHALES" + registers.registers);
			break;
		default:
			break;
		}
		System.out.println("DATA MEMORY " + data.getMemory());
	}

	public static int getPC() {
		return PC;
	}

	public static void setPC(int pC) {
		PC = pC;
	}

	public Simulator() {
		instructions = new Memory();
		data = new Memory();
		registers = new Registers();
		Pipelining.initHashmaps();
	}

	public static void main(String[] args) {
		Simulator s = new Simulator();
		data.write(0, "23073942");
		data.write(1, "2");
		data.write(2, "3");
		data.write(3, "4");
		data.write(4, "5");

		instructions.write(0, "00000001001010100100100000100000");
		instructions.write(1, "00000001001010100101100000100000");
		instructions.write(2, "00000001001010100110000000100010");
		instructions.write(3, "00000001001010100110000000100010");
		instructions.write(4, "10101101010010010000000000000000");
		
		s.startPipe();
	}
}
