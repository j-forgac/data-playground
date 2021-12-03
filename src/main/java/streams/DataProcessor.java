package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        AtomicBoolean bool = new AtomicBoolean(false);
        student.getGrades().forEach((grade) -> {
            if (grade.getType().equals(GradeType.A)) bool.set(true);
        });
        return bool.get();
    }

    public static List<Integer> getStudentAges(List<Student> students) {
        ArrayList<Integer> ages = new ArrayList<>();
        students.forEach(student -> ages.add(student.getAge()));
        return ages;
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        ArrayList<Student> studentsWithMinAge = new ArrayList<>();
        students.forEach(student -> {
            if (student.getAge() >= minAge) studentsWithMinAge.add(student);
        });
        return studentsWithMinAge;
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return (int) students.stream().filter(student -> student.getGender() == Gender.MALE).count();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        var ref = new Object() {
            int count = 0;
            double sum = 0;
        };
        students.forEach(student -> {
            if (student.getGender() == Gender.FEMALE) {
                ref.count++;
                ref.sum += student.getAge();
            }
        });
        return ref.sum / ref.count;
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).reduce(1, (a, b) -> a * b);
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().mapToInt(grade -> grade.getType().getValue()).reduce(1, (a, b) -> a * b);
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.empty();
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return new ArrayList<>();
    }

    // endregion
}
