package sample;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyGymManager implements GymManager{
    private List<DefaultMember> Members;

    MyGymManager(){
        this.Members = new ArrayList<>();
    }

    public List<DefaultMember> getMembers() {
        return Members;
    }

    public void setMembers(List<DefaultMember> members) {
        Members = members;
    }

    @Override
    public void AddMember(DefaultMember member) {
        Members.add(member);
        System.out.println("Member Added");
    }

    @Override
    public void DeleteMember(DefaultMember member) {
        Members.remove(member);
        System.out.println("Member Deleted");
    }

    @Override
    public void PrintMembers() {
        Members.forEach(member -> {
            System.out.println(Members.indexOf(member)+". "+"Membership Number : " + member.getMembershipNumber() +
                    ", Member Type : " + member.getClass().getTypeName() +
                    ", Membership Starting Date : " + member.getStartMembershipDate().toString() +
                    ", Member Name : " + member.getName());
        });
    }

    @Override
    public void Sort() {
        Comparator<DefaultMember> compareByName = (DefaultMember o1, DefaultMember o2) ->
                o1.getName().compareTo(o1.getName());
        Members.sort(compareByName);
    }

    @Override
    public void Save(String FileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
        for (DefaultMember member : Members) {
            writer.write("Membership Number : " + member.getMembershipNumber() +
                    ", Member Type : " + member.getClass().getTypeName() +
                    ", Membership Starting Date : " + member.getStartMembershipDate().toString() +
                    ", Member Name : " + member.getName());
            writer.newLine();
        }
        writer.close();
        File file = new File(FileName);
        Desktop.getDesktop().open(file);
        System.out.println("File Saved");
    }
}
