package managingstudents

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class StudentServiceSpec extends Specification implements ServiceUnitTest<StudentService>{

    void "Test the index action returns the correct model"() {
        given:
        controller.studentService = Mock(StudentService) {
            list() >> [new Student(firstName: 'John',lastName: 'Doe')]
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        model.studentList.size() == 1
        model.studentList[0].firstName == 'John'
        model.studentList[0].lastName == 'Doe'
    }
}
