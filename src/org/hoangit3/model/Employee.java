package org.hoangit3.model;

public class Employee {
    private int eid;
    private String eName;
    private String eAddress;
    private int did;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", eName='" + eName + '\'' +
                ", eAddress='" + eAddress + '\'' +
                ", did=" + did +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
