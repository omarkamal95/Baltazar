package mips;

import java.util.*;

public class Assembler {
	// opcode, register number,
	private static String functionCode;
	private static String opcode;
	private static String function;
	private static String input1;
	private static String input2;
	private static String input3;
	private static String imdt;
	//private static String offset;   
	// private static HashMap regString = new HashMap();

	private static String[] instructionArray = new String[4];
	private static String resultCode;
	private static String shamt;
	private static String offset;
	

	public static String assemble(String instruction) {

		instructionArray = instruction.split(",");
		function = instructionArray[0];
		input1 = instructionArray[1];
		input2 = instructionArray[2];
		//input3= instructionArray[3];
		if(instructionArray.length>3){
			input3 = instructionArray[3];
		}



		return decideFormat();

	}
//public static void PutInMem(){
//	
//	for(int i=0,)
//	Simulator.instructions.write(0, value)
//}
	public static String decideFormat() {

		if (function.toLowerCase().equals("add")
				|| function.toLowerCase().equals("and")
				|| function.toLowerCase().equals("sub")
				|| function.toLowerCase().equals("nor")
				|| function.toLowerCase().equals("or")
				|| function.toLowerCase().equals("slt")
				|| function.toLowerCase().equals("sll")
				|| function.toLowerCase().equals("slr")
				|| function.toLowerCase().equals("sltu")) {

			return toMachineCodeR();
		}
		if (function.toLowerCase().equals("addi")
				|| function.toLowerCase().equals("andi")
				|| function.toLowerCase().equals("sw")
				|| function.toLowerCase().equals("lw")
				|| function.toLowerCase().equals("slti")
				|| function.toLowerCase().equals("lb")
				|| function.toLowerCase().equals("lbu")
				|| function.toLowerCase().equals("lui")
				|| function.toLowerCase().equals("beq")
				|| function.toLowerCase().equals("bne")) {

			return toMachineCodeI();
		} else {
			return "";
		}
	}

	private static String toMachineCodeI() {
		switch (function.toLowerCase()) {
		case "addi":{
			opcode = "001000";
			return opcode +toReg2Value()+ toReg1Value()+ toReg3Value();}
		case "lw":{
			opcode="100011";
			offset = input2;
			String [] resultOff=offset.split("\\(");
			String y=resultOff[0];
			int w=Integer.parseInt(y);
			y=moreDigits(16,w);
			String z=resultOff[1].substring(0,resultOff[1].length()-1);
			input3 = z;
			return opcode+toReg3Value()+toReg1Value()+y;
		}
		case "sw":{
			opcode="101011";
			offset = input2;
			String [] resultOff=offset.split("\\(");
			String y=resultOff[0];
			int w=Integer.parseInt(y);
			y=moreDigits(16,w);
			String z=resultOff[1].substring(0,resultOff[1].length()-1);
			input3 = z;
			return opcode+toReg3Value()+toReg1Value()+y;	


		}
		case "lb":{
			opcode="100000";
			offset = input2;
			String [] resultOff=offset.split("\\(");
			String y=resultOff[0];
			int w=Integer.parseInt(y);
			y=moreDigits(16,w);
			String z=resultOff[1].substring(0,resultOff[1].length()-1);
			input3 = z;
			return opcode+toReg3Value()+toReg1Value()+y;	
		}
		case "lbu":{
			opcode="100100";
			offset = input2;
			String [] resultOff=offset.split("\\(");
			String y=resultOff[0];
			int w=Integer.parseInt(y);
			y=moreDigits(16,w);
			String z=resultOff[1].substring(0,resultOff[1].length()-1);
			input3 = z;
			return opcode+toReg3Value()+toReg1Value()+y;	
		}
		case "sb":{
			opcode= "101000";
			offset = input2;
			String [] resultOff=offset.split("\\(");
			String y=resultOff[0];
			int w=Integer.parseInt(y);
			y=moreDigits(16,w);
			String z=resultOff[1].substring(0,resultOff[1].length()-1);
			input3 = z;
			return opcode+toReg3Value()+toReg1Value()+y;	

		}
		case "lui":{
			opcode="001111";
			String immidiate = moreDigits(5,Integer.parseInt(toReg3Value()));

			return opcode+"00000"+toReg1Value()+toReg3Value();
		}


		default: {
			return "";
		}
		}

	}

	public static String toMachineCodeR() {
		opcode = "000000";
		switch (function.toLowerCase()) {
		case "add": {
			functionCode = "100000";
			shamt = "00000";
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;

		}
		case "sub": {
			functionCode = "100010";
			shamt = "00000";
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "and": {
			functionCode = "100100";
			shamt = "00000";
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "nor": {
			functionCode = "100111";
			shamt = "000000";
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "or": {
			functionCode = "100101";
			opcode = "000000";
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "slt": {
			functionCode = "101010";
			shamt="00000";			
			return opcode + toReg2Value() + toReg3Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "sll": {
			functionCode = "000000";
			int x=Integer.parseInt(input3);
			shamt= moreDigits(5,x);
			return opcode +"00000" + toReg2Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "slr": {
			functionCode = "000010";
			int x=Integer.parseInt(input3);
			moreDigits(5,x);

			return opcode + "00000" + toReg2Value() + toReg1Value()
					+ shamt + functionCode;
		}
		case "sltu":{
			functionCode ="101001";
			return opcode + toReg2Value() + toReg1Value()+ toReg3Value()
					+"00000" + functionCode;}


		default: {
			return "";

		}
		}
	}

	public static String toReg1Value() {
		if (input1.equals("$zero")) {
			return resultCode = "00000";
		}
		if (input1.equals("$at")) {
			return resultCode = "00001";
		}
		if (input1.equals("$vo")) {
			return resultCode = "00010";
		}
		if (input1.equals("$v1")) {
			return resultCode = "00011";
		}
		if (input1.equals("$a0")) {
			return resultCode = "00100";
		}
		if (input1.equals("$a1")) {
			return resultCode = "00101";
		}
		if (input1.equals("$a2")) {
			return resultCode = "00110";
		}
		if (input1.equals("$a3")) {
			return resultCode = "00111";
		}
		if (input1.equals("$t0")) {
			return resultCode = "01000";
		}
		if (input1.equals("$t1")) {
			return resultCode = "01001";
		}
		if (input1.equals("$t2")) {
			return resultCode = "01010";
		}
		if (input1.equals("$t3")) {
			return resultCode = "01011";
		}
		if (input1.equals("$t4")) {
			return resultCode = "01100";
		}
		if (input1.equals("$t5")) {
			return resultCode = "01101";
		}
		if (input1.equals("$t6")) {
			return resultCode = "01110";
		}
		if (input1.equals("$t7")) {
			return resultCode = "01111";
		}
		if (input1.equals("$s0")) {
			return resultCode = "10000";
		}
		if (input1.equals("$s1")) {
			return resultCode = "10001";
		}
		if (input1.equals("$s2")) {
			return resultCode = "10010";
		}
		if (input1.equals("$s3")) {
			return resultCode = "10011";
		}
		if (input1.equals("$s4")) {
			return resultCode = "10100";
		}
		if (input1.equals("$s5")) {
			return resultCode = "10101";
		}
		if (input1.equals("$s6")) {
			return resultCode = "10110";
		}
		if (input1.equals("$s7")) {
			return resultCode = "10111";
		}
		if (input1.equals("$t8")) {
			return resultCode = "11000";
		}
		if (input1.equals("$t9")) {
			return resultCode = "11001";
		}
		if (input1.equals("$ko")) {
			return resultCode = "11010";
		}
		if (input1.equals("$k1")) {
			return resultCode = "11011";
		}
		if (input1.equals("$gp")) {
			return resultCode = "11100";
		}
		if (input1.equals("$sp")) {
			return resultCode = "11101";
		}
		if (input1.equals("$fp")) {
			return resultCode = "11110";
		}
		if (input1.equals("$ra")) {
			return resultCode = "11111";
		} else {
			return "";

		}
	}

	public static String toReg2Value() {
		if (input2.equals("$zero")) {
			return resultCode = "00000";
		}
		if (input2.equals("$at")) {
			return resultCode = "00001";
		}
		if (input2.equals("$vo")) {
			return resultCode = "00010";
		}
		if (input2.equals("$v1")) {
			return resultCode = "00011";
		}
		if (input2.equals("$a0")) {
			return resultCode = "00100";
		}
		if (input2.equals("$a1")) {
			return resultCode = "00101";
		}
		if (input2.equals("$a2")) {
			return resultCode = "00110";
		}
		if (input2.equals("$a3")) {
			return resultCode = "00111";
		}
		if (input2.equals("$t0")) {
			return resultCode = "01000";
		}
		if (input2.equals("$t1")) {
			return resultCode = "01001";
		}
		if (input2.equals("$t2")) {
			return resultCode = "01010";
		}
		if (input2.equals("$t3")) {
			return resultCode = "01011";
		}
		if (input2.equals("$t4")) {
			return resultCode = "01100";
		}
		if (input2.equals("$t5")) {
			return resultCode = "01101";
		}
		if (input2.equals("$t6")) {
			return resultCode = "01110";
		}
		if (input2.equals("$t7")) {
			return resultCode = "01111";
		}
		if (input2.equals("$s0")) {
			return resultCode = "10000";
		}
		if (input2.equals("$s1")) {
			return resultCode = "10001";
		}
		if (input2.equals("$s2")) {
			return resultCode = "10010";
		}
		if (input2.equals("$s3")) {
			return resultCode = "10011";
		}
		if (input2.equals("$s4")) {
			return resultCode = "10100";
		}
		if (input2.equals("$s5")) {
			return resultCode = "10101";
		}
		if (input2.equals("$s6")) {
			return resultCode = "10110";
		}
		if (input2.equals("$s7")) {
			return resultCode = "10111";
		}
		if (input2.equals("$t8")) {
			return resultCode = "11000";
		}
		if (input2.equals("$t9")) {
			return resultCode = "11001";
		}
		if (input2.equals("$ko")) {
			return resultCode = "11010";
		}
		if (input2.equals("$k1")) {
			return resultCode = "11011";
		}
		if (input2.equals("$gp")) {
			return resultCode = "11100";
		}
		if (input2.equals("$sp")) {
			return resultCode = "11101";
		}
		if (input2.equals("$fp")) {
			return resultCode = "11110";
		}
		if (input2.equals("$ra")) {
			return resultCode = "11111";
		} else {
			return "";

		}
	}

	public static String toReg3Value() {
		if (input3.equals("$zero")) {
			return resultCode = "00000";
		}
		if (input3.equals("$at")) {
			return resultCode = "00001";
		}
		if (input3.equals("$vo")) {
			return resultCode = "00010";
		}
		if (input3.equals("$v1")) {
			return resultCode = "00011";
		}
		if (input3.equals("$a0")) {
			return resultCode = "00100";
		}
		if (input3.equals("$a1")) {
			return resultCode = "00101";
		}
		if (input3.equals("$a2")) {
			return resultCode = "00110";
		}
		if (input3.equals("$a3")) {
			return resultCode = "00111";
		}
		if (input3.equals("$t0")) {
			return resultCode = "01000";
		}
		if (input3.equals("$t1")) {
			return resultCode = "01001";
		}
		if (input3.equals("$t2")) {
			return resultCode = "01010";
		}
		if (input3.equals("$t3")) {
			return resultCode = "01011";
		}
		if (input3.equals("$t4")) {
			return resultCode = "01100";
		}
		if (input3.equals("$t5")) {
			return resultCode = "01101";
		}
		if (input3.equals("$t6")) {
			return resultCode = "01110";
		}
		if (input3.equals("$t7")) {
			return resultCode = "01111";
		}
		if (input3.equals("$s0")) {
			return resultCode = "10000";
		}
		if (input3.equals("$s1")) {
			return resultCode = "10001";
		}
		if (input3.equals("$s2")) {
			return resultCode = "10010";
		}
		if (input3.equals("$s3")) {
			return resultCode = "10011";
		}
		if (input3.equals("$s4")) {
			return resultCode = "10100";
		}
		if (input3.equals("$s5")) {
			return resultCode = "10101";
		}
		if (input3.equals("$s6")) {
			return resultCode = "10110";
		}
		if (input3.equals("$s7")) {
			return resultCode = "10111";
		}
		if (input3.equals("$t8")) {
			return resultCode = "11000";
		}
		if (input3.equals("$t9")) {
			return resultCode = "11001";
		}
		if (input3.equals("$ko")) {
			return resultCode = "11010";
		}
		if (input3.equals("$k1")) {
			return resultCode = "11011";
		}
		if (input3.equals("$gp")) {
			return resultCode = "11100";
		}
		if (input3.equals("$sp")) {
			return resultCode = "11101";
		}
		if (input3.equals("$fp")) {
			return resultCode = "11110";
		}
		if (input3.equals("$ra")) {
			return resultCode = "11111";
		} else { int x=Integer.parseInt(input3);
		if(x<0){
			return moreNegDigits(16,x);
		}
		else{return moreDigits(16,x);
		//if(input3.charAt(0)== '-'){


		}}
		//

	}



	public static String moreDigits(int size, int x) {
				String binary = Integer.toBinaryString(x);
				for (int i = size - binary.length(); i > 0; i--) {
					binary = "0" + binary;
				}
				return binary;
		
	}
	public static String moreNegDigits(int size, int x) {
		String binary = Integer.toBinaryString(x);
		binary=binary.substring(16);

		for (int i = size - binary.length(); i > 0; i--) {
			binary = "1" + binary;
		}
		 return binary;
		 }

	public static void main(String[] args) {
	String instruction = assemble("add,$t1,$t1,$t2");
		System.out.println(instruction);
	System.out.println(instruction.length());
		//System.out.println(moreDigits(5, 2));
		//System.out.println("001000010010100111111111111111111111111111111100".length());

	}
}
