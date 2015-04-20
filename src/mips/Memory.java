package mips;

import java.util.HashMap;

public class Memory {
	HashMap<Integer, String> M;
	
	public String read(int address){
		return M.get(address);
	}
	public void write(int address, String value){
		M.put(address, value);
	}
	public HashMap<Integer, String> getMemory(){
		return M;
	}
}
