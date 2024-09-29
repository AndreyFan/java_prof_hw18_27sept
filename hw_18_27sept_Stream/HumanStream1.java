package de.telran.hw_18_27sept_Stream;

public class HumanStream1 { // создадим объект для задания 7
    public String name;
    public int age;

    public HumanStream1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "HumanStream1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
