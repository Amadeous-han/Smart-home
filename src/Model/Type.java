package Model;

public class Type {
	 private String Id;
	 private String TName;
	 private int Tdelete;
	 public String getID() {return Id;}
	 public void setID(String id) {Id=id;}
	    
	 public String getTName() {return TName;}
	 public void setTname(String name) {TName=name;}
	    
	 public int getDelete() {return Tdelete;}//0√ª…æ£¨1…æ¡À 
	 public void setDelete(int d) {Tdelete=d;}
}
