package Model;

public class Data {
	private String IdData;
	//humidity
	private int Wet;
	
	private int Temperature;
	//Light intensity
	private int Light;
	//Window opening
    private int Window;
    //Data presence
    private int DataDelete;
    //Device id
    private String Equipment_id;
    //Monitoring time
    private String Time;
    
    private String Ename;
    
    private String Fid;
    
    private int Number;
    
	public int getNumber() {
		return Number;
	}
	/**
	 * @param idData the idData to set
	 */
	public void setNumber(int number) {
		Number= number;
	}
	public String getTime() {
		return Time;
	}
	/**
	 * @param idData the idData to set
	 */
	public void setTime(String time) {
		Time = time;
	}
	/**
	 * @return the idData
	 */
	public String getIdData() {
		return IdData;
	}
	/**
	 * @param idData the idData to set
	 */
	public void setIdData(String idData) {
		IdData = idData;
	}
	/**
	 * @return the wet
	 */
	public int getWet() {
		return Wet;
	}
	/**
	 * @param wet the wet to set
	 */
	public void setWet(int wet) {
		Wet = wet;
	}
	/**
	 * @return the temperature
	 */
	public int getTemperature() {
		return Temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(int temperature) {
		Temperature = temperature;
	}
	/**
	 * @return the light
	 */
	public int getLight() {
		return Light;
	}
	/**
	 * @param light the light to set
	 */
	public void setLight(int light) {
		Light = light;
	}
	/**
	 * @return the window
	 */
	public int getWindow() {
		return Window;
	}
	/**
	 * @param window the window to set
	 */
	public void setWindow(int window) {
		Window = window;
	}
	/**
	 * @return the dataDelete
	 */
	public int getDataDelete() {
		return DataDelete;
	}
	/**
	 * @param dataDelete the dataDelete to set
	 */
	public void setDataDelete(int dataDelete) {
		DataDelete = dataDelete;
	}
	/**
	 * @return the equipment_id
	 */
	public String getEquipment_id() {
		return Equipment_id;
	}
	/**
	 * @param equipment_id the equipment_id to set
	 */
	public void setEquipment_id(String equipment_id) {
		Equipment_id = equipment_id;
	}
	/**
	 * @return the time
	 */
	public String getEname() {
		return Ename;
	}
	/**
	 * @param time the time to set
	 */
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getFid() {
		return Fid;
	}
	/**
	 * @param time the time to set
	 */
	public void setFid(String fid) {
		Fid= fid;
	}
}
