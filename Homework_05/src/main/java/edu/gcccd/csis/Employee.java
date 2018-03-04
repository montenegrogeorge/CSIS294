package edu.gcccd.csis;

public class Employee {
    //Private Member variables of the employee
    private String employeeName = "";
    private String jobTitle = "";
    private String organization = "";
    private String birthday = "";

    //Public Constructor
    public Employee(String employeeName, String jobTitle, String organization, String birthday){
        this.employeeName = employeeName;
        this.jobTitle = jobTitle;
        this.organization = organization;
        this.birthday = birthday;
    }

    // Getters for the Employee Class
    public String getName(){
        return (employeeName);
    }

    public String getTitle() {
        return (jobTitle);
    }

    public String getOrganization() {
        return (organization);
    }

    public String getBirthday() {
        return (birthday);
    }

    // Setters for Employee
    public void setName(String name){
        employeeName = name;
    }

    public void setTitle(String title) {
        jobTitle = title;
    }

    public void setOrganization(String org) {
        organization = org;
    }

    public void setBirthday(String date) {
        birthday = date;
    }

    // Overriden functions
    @Override
    public String toString() {
        return (employeeName + " " + jobTitle + " " + organization + " " + birthday);
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Employee
                && employeeName.equals(((Employee) obj).employeeName)
                && jobTitle.equals(((Employee) obj).jobTitle)
                && organization.equals(((Employee) obj).organization)
                && birthday.equals(((Employee) obj).birthday);
    }

}
