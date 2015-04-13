import java.util.HashMap;


public class Simulator {
	
	// Memories are fixed arrays for easier accesing of indexes
	int [] instructionMemory, dataMemory;
	
	// register names should be stored as $0, $s0, $t0 
	HashMap <String, Integer> registers;
	
	 /*
	  * gets the binary value of an integer and saves it in a 
	  * string of n characters (bits). 
	  * n is the number of bits of the resulting string
	  */	
	public String toNBitsBinaryString(int value, int n) {
		String binString = Integer.toBinaryString(value);
		while (binString.length() < n) {
			binString += 0 + binString;
		}
		
		return binString;
	}
	
//	initialize registers with zeros
	public void initRegisters() {
		registers = new HashMap<String, Integer>();
		
		registers.put("$0", 0);
		registers.put("$a0", 0);
		registers.put("$a1", 0);
		registers.put("$a2", 0);
		registers.put("$a3", 0);
		registers.put("$v0", 0);
		registers.put("$v1", 0);
		registers.put("$t0", 0);
		registers.put("$t1", 0);
		registers.put("$t2", 0);
		registers.put("$t3", 0);
		registers.put("$t4", 0);
		registers.put("$t5", 0);
		registers.put("$t6", 0);
		registers.put("$t7", 0);
		registers.put("$t8", 0);
		registers.put("$t9", 0);
		registers.put("$s0", 0);
		registers.put("$s1", 0);
		registers.put("$s2", 0);
		registers.put("$s3", 0);
		registers.put("$s4", 0);
		registers.put("$s5", 0);
		registers.put("$s6", 0);
		registers.put("$s7", 0);
		registers.put("$ra", 0);
		
	}
	
	
	
}
