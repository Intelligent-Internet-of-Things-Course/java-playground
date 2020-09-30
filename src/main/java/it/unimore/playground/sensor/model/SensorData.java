package it.unimore.playground.sensor.model;

/**
 * Sensor data.
 */
public class SensorData {

	private DeviceDescriptor deviceDescriptor = null;

	private float value;

	public SensorData() {
	}

	public SensorData(DeviceDescriptor deviceDescriptor, float value) {
		this.deviceDescriptor = deviceDescriptor;
		this.value = value;
	}

	public DeviceDescriptor getDeviceDescriptor() {
		return deviceDescriptor;
	}

	public void setDeviceDescriptor(DeviceDescriptor deviceDescriptor) {
		this.deviceDescriptor = deviceDescriptor;
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
		sb.append("deviceDescriptor=").append(deviceDescriptor);
		sb.append(", value=").append(value);
		sb.append('}');
		return sb.toString();
	}
}
