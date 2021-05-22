package org.hoangit3.model;

public class Department {
    private int did;
    private String dName;

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dName='" + dName + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
