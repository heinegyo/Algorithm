package phase1.week1.linearSearch;

public class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public  boolean equals(Object obj){
        if (this==obj)
            return true;
        if(this == null)
            return false;
        //
        if(this.getClass()!= obj.getClass())
            return false;
        Student another = (Student)obj;
        return this.name.toLowerCase().equals(another.name.toLowerCase());
    }
}
