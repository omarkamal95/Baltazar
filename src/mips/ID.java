package mips;

public class ID {

	private Registers registers = new Registers();
	private String WriteReg;
	private int DataOne;
	private int DataTwo;

	public int getDataOne() {
		return DataOne;
	}

	public int getDataTwo() {
		return DataTwo;
	}

	public Registers getRegisters() {
		return registers;
	}

	public String getWriteReg() {
		return WriteReg;
	}
	
	public ID(String RegOne, String RegTwo, String regDst, String toMuxOne,
			String WriteData) {

		if (Integer.parseInt(regDst) == 1) {
			WriteReg = toMuxOne;
		} else {
			WriteReg = RegTwo;
		}
		DataOne = registers.getRegValue(RegOne);
		DataTwo = registers.getRegValue(RegTwo);

	}
}
