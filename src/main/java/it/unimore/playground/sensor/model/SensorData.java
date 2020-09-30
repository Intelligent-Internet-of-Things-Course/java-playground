package it.unimore.playground.sensor.model;

/**
 * Sensor data.
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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("SensorData{");
		sb.append("id='").append(id).append('\'');
		sb.append(", value=").append(value);
		sb.append('}');
		return sb.toString();
	}
}
