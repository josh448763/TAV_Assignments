
class USBConnection implements USB {
	    
	private int i = 5;
	
	@Override
	public void sendSensorData(String s) {
		// Do nothing
	}

	@Override
	public String readSpeedTorque() {
		if(i < 0 || i > 255){
			i = 0;
		}
		String buffer = build_SpeedTorqueBitstreamString(i, i);
		i++;
		
		return buffer;
		
	}
	
private String build_SpeedTorqueBitstreamString(int speed, int torque){
		
		String speedString = String.format("%8s", Integer.toBinaryString(speed)).replace(' ', '0');
		String torqueString = String.format("%8s", Integer.toBinaryString(torque)).replace(' ', '0');
		
		String sDel = "001010100111001100101010"; // *s* - start of package delimiter
		String eDel = "001010100110010100101010"; // *e* - end of package delimiter
		String vDel = "001010100111011000101010"; //*v* - speed delimiter
		String tDel = "001010100111010000101010"; // *t* - torque delimiter
		
		String result = sDel + vDel + speedString + tDel + torqueString + eDel;
		
		return result; }
	
	
}