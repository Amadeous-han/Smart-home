package Model;

public class User {
    private String Id;
    private String FId;
    private String UName;
    private String UCode;
    private String gender;
    private int Udelete;
    
    public String getID() {return Id;}
    public void setID(String id) {Id=id;}
    
    public String getFID() {return FId;}
    public void setFID(String fid) {FId=fid;}
    
    public String getUName() {return UName;}
    public void setUName(String name) {UName=name;}
    
    public String getUCode() {return UCode;}
    public void setUCode(String code) {UCode=code;}
    
    public String getGender() {return gender;}
    public void setGender(String gen) {gender=gen;}
    
    public int getDelete() {return Udelete;}//0√ª…æ£¨1…æ¡À 
    public void setDelete(int d) {Udelete=d;}
	
}
