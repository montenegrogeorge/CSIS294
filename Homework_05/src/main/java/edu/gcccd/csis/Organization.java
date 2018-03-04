package edu.gcccd.csis;

public class Organization {
    private String organizationName = "";
    private int numOfEmployees = 0;

    public Organization(String organizationName, int numOfEmployees) {

        this.organizationName = organizationName;
        this.numOfEmployees = numOfEmployees;
    }

    // Organization getters
    public String getOrganizationName() {
        return organizationName;
    }

    public int getNumOfEmployees(){
        return numOfEmployees;
    }

    // Organization setters
    public void setOrganizationName(String name) {
        organizationName = name;
    }

    @Override
    public String toString() {
        return (organizationName + " " + numOfEmployees);
    }

    @Override
    public boolean equals(Object comp) {
        return comp instanceof Organization
                && organizationName.equals(((Organization) comp).organizationName)
                && numOfEmployees == ((Organization) comp).numOfEmployees;
    }


}
