package mips;

import java.util.ArrayList;
import java.util.HashMap;

public class Memory {
	ArrayList<String> M;
	
	public String read(int address){
		return M.get(address);
	}
	public void write(int address, String value){
		M.set(address, value);
	}
	public ArrayList<String> getMemory(){
		return M;
	}
}
