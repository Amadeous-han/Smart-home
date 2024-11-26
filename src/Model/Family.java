package Model;

public class Family {
	private String Id;
	private String Fname;
	private int Fdelete;
	
	public String getID() {return Id;}
    public void setID(String id) {Id=id;}
    
    public String getFName() {return Fname;}
    public void setFName(String name) {Fname=name;}
    
    public int getDelete() {return Fdelete;}//0√ª…æ£¨1…æ¡À 
    public void setDelete(int d) {Fdelete=d;}
	
}
