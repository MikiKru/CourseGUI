package model;

public class Participant {
    private String particip_name;
    private String particip_lastname;

    public Participant(String particip_name, String particip_lastname) {
        this.particip_name = particip_name;
        this.particip_lastname = particip_lastname;
    }

    public String getParticip_name() {
        return particip_name;
    }

    public void setParticip_name(String particip_name) {
        this.particip_name = particip_name;
    }

    public String getParticip_lastname() {
        return particip_lastname;
    }

    public void setParticip_lastname(String particip_lastname) {
        this.particip_lastname = particip_lastname;
    }
}
