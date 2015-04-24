package mips;

public class Simulator {
	static Memory instructions, data = new Memory();
	static Registers registers = new Registers();	
	private static int PC = -1;
	static 	

	public void inputStoring(String [] inputInstruction){
		for (String instr : inputInstruction) {
			String bInstr = Assembler.assemble(instr);
			instructions.write(++PC, bInstr);
		}
		
	}
	
	public void startPipe (){
		PC = -1;
		while(!instructions.equals(null)){
		for (int i = 0; i < 5; i++) {
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

			default:
				break;
			}
		}
		
		
		
	}
	
	public void cycle (){
		
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
