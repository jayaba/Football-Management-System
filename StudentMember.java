package sample;

public class StudentMember extends DefaultMember {

    private String SchoolName;

    StudentMember(int membershipNumber, Date startMembershipDate,String name, String schoolName) {
        super(membershipNumber, startMembershipDate, name);
        this.SchoolName = schoolName;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }
}
