package j20_JSON;
public class Computer {
  private String cpuType;
  private int ramSize;
  private int ssdSize;
  
  private Computer(Builder builder) {
    this.cpuType = builder.cpuType;
    this.ramSize = builder.ramSize;
    this.ssdSize = builder.ssdSize;
  }
  
  public static class Builder {
    private String cpuType;
    private int ramSize;
    private int ssdSize;
    
    public Builder CpuType(String cpuType) {
      this.cpuType = cpuType;
      return this;
    }
    
    public Builder RamSize(int ramSize) {
      this.ramSize = ramSize;
      return this;
    }
    
    public Builder SsdSize(int ssdSize) {
      this.ssdSize = ssdSize;
      return this;
    }
    
    public Computer build() {
      return new Computer(this);
    }
  }
  @Override
  public String toString() {
	  return "CPU 종류(intel/AMD): " + this.cpuType 	
			  + "RAM 용량(GB): " + this.ramSize
			  + "SSD 용량(GB): " + this.ssdSize;
	  
  }
   
  public void showComputerInfo() {

  }
}