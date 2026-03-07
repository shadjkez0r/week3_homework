package evg.megatron.adapter;

import evg.megatron.builder.Gender;

import java.util.Objects;

public class LooneyTunesCharacter {
    private final String name;
    private final Gender gender;
    private final int yearOfRelease;

    public LooneyTunesCharacter(String name, Gender gender, int yearOfRelease) {
        this.name = name;
        this.gender = gender;
        this.yearOfRelease = yearOfRelease;
    }

    public String getName() {
        return name;
    }


    public Gender getGender() {
        return gender;
    }


    public int getYearOfRelease() {
        return yearOfRelease;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LooneyTunesCharacter that = (LooneyTunesCharacter) o;
        return yearOfRelease == that.yearOfRelease && Objects.equals(name, that.name) && gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, yearOfRelease);
    }

    @Override
    public String toString() {
        return "LooneyTunesCharacter{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
