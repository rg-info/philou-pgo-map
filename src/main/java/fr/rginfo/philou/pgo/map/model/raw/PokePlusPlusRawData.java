package fr.rginfo.philou.pgo.map.model.raw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PokePlusPlusRawData {
  private List<Map<String, String>> protos = new ArrayList<>();
  private int submit_version;
  private double longitude;
  private double latitude;
  private String uuid;
  private String validation1;
  private int trainerlvl;
  private long timestamp;

  public List<Map<String, String>> getProtos() {
    return protos;
  }

  public void setProtos(List<Map<String, String>> protos) {
    this.protos.addAll(protos);
  }

  public int getSubmit_version() {
    return submit_version;
  }

  public void setSubmit_version(int submit_version) {
    this.submit_version = submit_version;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getValidation1() {
    return validation1;
  }

  public void setValidation1(String validation1) {
    this.validation1 = validation1;
  }

  public int getTrainerlvl() {
    return trainerlvl;
  }

  public void setTrainerlvl(int trainerlvl) {
    this.trainerlvl = trainerlvl;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
