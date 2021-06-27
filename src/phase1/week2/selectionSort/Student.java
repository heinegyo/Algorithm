package phase1.week2.selectionSort;

public class Student implements Comparable<Student>{
    private String name;
    private  int score;

    public Student(String name, int score){
        this.name = name;
        this.score =score;
    }

    public  boolean equals(Object obj){
        if (this==obj)
            return true;
        if(this == null)
            return false;
        if(this.getClass()!= obj.getClass())
            return false;

        Student another = (Student)obj;
        return this.name.equals(another.name);
    }

    @Override
    public int compareTo(Student another) {
        // if (this.score < another.score)
        //     return -1;
        // else if (this.score == another.score)
        //     return 0;
        // return 1;

        // return this.score - another.score;
        return  another.score-this.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s,score:%d)",name,score);
    }
}
