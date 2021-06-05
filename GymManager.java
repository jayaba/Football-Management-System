package sample;

import java.io.IOException;

public interface GymManager {
    void AddMember(DefaultMember member);
    void DeleteMember(DefaultMember member);
    void PrintMembers();
    void Sort();
    void Save(String FileName) throws IOException;
}
