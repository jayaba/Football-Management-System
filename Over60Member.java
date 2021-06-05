package sample;

public class Over60Member extends  DefaultMember{
    int Age;

    Over60Member(int membershipNumber, Date startMembershipDate,String name,int age) {
        super(membershipNumber, startMembershipDate, name);
        this.Age = age;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
