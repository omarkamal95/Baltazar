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

	public void inputStoring(String [] inputInstruction){
		for (String instr : inputInstruction) {
			String bInstr = Assembler.assemble(instr);
			instructions.write(++PC, bInstr);
		}
		
	}
	
	public void startPipe (){
		//make sure fetch checks if there is a new instruction
		
		PC = 0;
		int sizeOfMemory = instructions.getMemory().size();
		
//		while(sizeOfMemory - PC >= 0) {
		for (int i = 0; i < 5; i++) {
			
//			if (i == 5){
//				while(instructions.read(PC+1) != null){
//					cycle(4);
//				}
//			}
			cycle(i);
		}
//		}
		
		
		
	}
	
	public void cycle (int i){
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
//			IF.fetch();	
			break;
		case 2:
			System.out.println("Dakhal Execute");
			EX.execute();
			System.out.println("Pipelining.getEXMEM()" + Pipelining.getEXMEM());
//			ID.Decode();
//			IF.fetch();
			break;
		case 3:
			System.out.println("Dakhal MA");
			MA.doMA();
			System.out.println("Pipelining.getMEMWB() " + Pipelining.getMEMWB());
//			EX.execute();
//			ID.Decode();
//			IF.fetch();
			break;
		case 4:
			System.out.println("Dakhal WB");
			WB.WriteToRegisters();
			System.out.println("REGISTER VALUES " + registers.registers);
//			MA.doMA();
//			EX.execute();
//			ID.Decode();
//			IF.fetch();
			break;
	/*	case 5:
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
			break;	
	*/	default:
			break;
		}
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

	public static void main (String[]args){
		Simulator s = new Simulator();
		instructions.write(0, "00000001010010010100100000101011");
		s.startPipe();
	}
}
