package it.unimore.playground.sensor.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-playground
 * @created 30/09/2020 - 12:37
 */
public class ServiceDescriptor {

    private String uniqueId;

    private String versionIdentifier;

    private int releaseNumber;

    private String producer;

    public ServiceDescriptor() {
    }

    public ServiceDescriptor(String uniqueId, String versionIdentifier, int releaseNumber, String producer) {
        this.uniqueId = uniqueId;
        this.versionIdentifier = versionIdentifier;
        this.releaseNumber = releaseNumber;
        this.producer = producer;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getVersionIdentifier() {
        return versionIdentifier;
    }

    public void setVersionIdentifier(String versionIdentifier) {
        this.versionIdentifier = versionIdentifier;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceDescriptor{");
        sb.append("uniqueId='").append(uniqueId).append('\'');
        sb.append(", versionIdentifier='").append(versionIdentifier).append('\'');
        sb.append(", releaseNumber=").append(releaseNumber);
        sb.append(", producer='").append(producer).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
