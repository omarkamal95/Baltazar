package mips;

import java.util.HashMap;

public class Registers {
	HashMap<String, Integer> registers;
	
	public Registers(){
	registers = new HashMap<String, Integer>();
	
	registers.put("00000", 0);	//$zero
	registers.put("00001", 0);  //$at
	registers.put("00010", 0);	//$v0
	registers.put("00011", 0);	//$v1
	registers.put("00100", 0);	//$a0
	registers.put("00101", 0);	//$a1
	registers.put("00110", 0);	//$a2
	registers.put("00111", 0);	//$a3
	registers.put("01000", 0);	//$t0
	registers.put("01001", 0);	//$t1
	registers.put("01010", 0);	//$t2
	registers.put("01011", 0);	//$t3
	registers.put("01100", 0);	//$t4
	registers.put("01101", 0);	//$t5
	registers.put("01110", 0);	//$t6
	registers.put("01111", 0);	//$t7
	registers.put("10000", 10);	//$s0
	registers.put("10001", 0);	//$s1
	registers.put("10010", 0);	//$s2
	registers.put("10011", 0);	//$s3
	registers.put("10100", 0);	//$s4
	registers.put("10101", 0);	//$s5
	registers.put("10110", 0);	//$s6
	registers.put("10111", 0);	//$s7
	registers.put("11000", 0);	//$t8
	registers.put("11001", 0);	//$t9
	registers.put("11010", 0);	//$k0
	registers.put("11011", 0);	//$k1
	registers.put("11100", 0);	//$gp
	registers.put("11101", 0);	//$sp
	registers.put("11110", 0);	//$fp
	registers.put("11111", 0);	//$ra
}
	
	public int getRegValue(String address){
		return registers.get(address);
	}
	public void setReg(String address, int value){
		registers.put(address, value);
	}

	public void put(String regDestination, int parseInt) {
		registers.put(regDestination, parseInt);
	}
}
