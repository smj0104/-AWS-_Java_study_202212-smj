package j20_JSON.builder;

public class ShowComputerInfo {
	private String cpuType ;
	private  int ramSize ;
	private  int ssdSize ;
	
	public static class Builder {
		private String cpuType;
		private int ramSize;
		private int ssdSize;
		
		public Builder cpuType(String cpu) {
			this.cpuType = cpu;
			return this;
		}
		
		public Builder ramSize(int ram) {
			this.ramSize = ram;
			return this;
		}
		
		public Builder ssdSize(int ssd) {
			this.ssdSize = ssd;
			return this;
		}
		public ShowComputerInfo build() {
			return new ShowComputerInfo();
		}
	}
	
	public void  ShowComputerInformation(Builder builder) {
		this.cpuType = builder.cpuType;
		this.ramSize = builder.ramSize;
		this.ssdSize = builder.ssdSize;
		
	}

	
	@Override
	public String toString() {
		return "CPU 종류(intel/AMD) :  " + cpuType + "RAM 용량(GB):  " +  ramSize
				+ "SSD 용량(GB) : " + ssdSize;
		
	}
	
	

}
