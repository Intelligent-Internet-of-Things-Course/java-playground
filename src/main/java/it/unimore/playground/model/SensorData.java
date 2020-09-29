package it.unimore.playground.model;

/** Sensor data.
 */
public class SensorData {

	public String id;
	
	public float value;

	public SensorData() {
	}

	public SensorData(String id, float value) {
		this.id = id;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}
