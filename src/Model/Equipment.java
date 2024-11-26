package Model;

public class Equipment {
	 private String Id;
	 private String EName;
	 private String function;
	 private String FId;
	 private String VId;
	 private String TId;
	 private int Edelete;
	 public String getID() {return Id;}
	 public void setID(String id) {Id=id;}
	 
	 public String getFID() {return FId;}
	 public void setFID(String id) {FId=id;}
	 
	 public String getVID() {return VId;}
	 public void setVID(String id) {VId=id;}
	 
	 public String getTID() {return TId;}
	 public void setTID(String id) {TId=id;}
	    
	 public String getEName() {return EName;}
	 public void setEname(String name) {EName=name;}
	 
	 public String getFunction() {return function;}
	 public void setFunction(String f) {function=f;}
	 
	 public int getDelete() {return Edelete;} 
	 public void setDelete(int d) {Edelete=d;}
}
