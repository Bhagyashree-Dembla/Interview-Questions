import java.util.Objects;

public class ComparableImplementation implements Comparable<ComparableImplementation> {
String name;
int age;

    public ComparableImplementation(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ComparableImplementation other = (ComparableImplementation) obj;
        return age == other.age && Objects.equals(name,other.name);
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(ComparableImplementation o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString(){
        return name + "(" + age + ")";
    }
}
