package mips;

public class Assembler {
		static //opcode, register number, 
		String [] instructionArray = new String[4]; 
		public static void assemble (String instruction){
			instructionArray = instruction.split(",");
		}
		public static void main(String []args){
			assemble("add,$t4,$t0,$t2");
			for(int i =0;i<instructionArray.length; i++){
				System.out.println(instructionArray[i]);
			}
		}
}
