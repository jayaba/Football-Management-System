package sample;

public class DefaultMember {
    private int MembershipNumber;
    private Date StartMembershipDate;
    private String Name;

    DefaultMember(int membershipNumber,Date startMembershipDate,String name){
        this.MembershipNumber = membershipNumber;
        this.StartMembershipDate = startMembershipDate;
        this.Name = name;
    }

    public int getMembershipNumber() {
        return MembershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        MembershipNumber = membershipNumber;
    }

    public Date getStartMembershipDate() {
        return StartMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        StartMembershipDate = startMembershipDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
