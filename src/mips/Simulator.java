package mips;

public class Simulator {
	static boolean branch = false;
	static Memory instructions, data = new Memory();
	static Registers registers = new Registers();	
	private static int PC = -1;

	public void inputStoring(String [] inputInstruction){
		for (String instr : inputInstruction) {
			String bInstr = Assembler.assemble(instr);
			instructions.write(++PC, bInstr);
		}
		
	}
	
	public void startPipe (){
		//make sure fetch checks if there is a new instruction
		PC = -1;
		while(!instructions.equals(null));
		for (int i = 0; i < 9; i++) {
			if (i ==5){
				while(!instructions.read(PC+1).isEmpty()){
					cycle(4);
				}
			}
			cycle(i);
		}
		
		
		
	}
	
	public void cycle (int i){
		switch (i) {
		case 0:
			IF.fetch();
			break;
		case 1:
			ID.Decode();
			IF.fetch();
			break;
		case 2:
			EX.
			ID.Decode();
			IF.fetch();
			break;
		case 3:
			MEM.
			EX.
			ID.Decode();
			IF.fetch();
			break;
		case 4:
			WB.
			MEM.
			EX.
			ID.Decode();
			IF.fetch();
			break;
		case 5:
			WB.
			MEM.
			EX.
			ID.Decode();
			break;
		case 6:
			WB.
			MEM.
			EX.
			break;
		case 7:
			WB.
			MEM.
			break;
		case 8:
			WB.
			break;	
		default:
			break;
		}
	}
	
	public static void main (String[]args){
		
	}
	
	public static int getPC() {
		return PC;
	}

	public static void setPC(int pC) {
		PC = pC;
	}
}
