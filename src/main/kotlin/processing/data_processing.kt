package processing

import streams.*


fun atLeastOneGradeA(student: Student): Boolean {
	return student.grades.any { grade -> grade.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
	return students.map { it.age }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
	return students.filter { it.age >= minAge }

}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
	return students.count{it.gender == Gender.MALE}
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
	return getStudentAges(students.filter{it.gender == Gender.FEMALE}).average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
	return getStudentAges(students).reduce{acc,i -> acc*i}
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
	return student.grades.map { it.type.value }.filter { it != 0 }.reduce {acc, i -> acc * i}
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
	return student.grades.filter { it.subject == Subject.MATH }.maxByOrNull { it }
}

fun getSortedAges(students: List<Student>): List<Int> {
	return getStudentAges(students).sorted()
}

// endregion
