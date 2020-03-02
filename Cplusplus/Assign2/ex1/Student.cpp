/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#include "Person.h"
#include "Student.h"
#include <iostream>
#include <iomanip>

using  namespace std;

Student::Student(const string &name1, const string &name, int regNo) : Person(name1) {
    this->name=name;
    this->name=name1;
    this->regNo=regNo;
    map<string, float>marks;

}

//return registration  number
int Student::getRegNo() const {
    return  this->regNo;
}
// method to add the mark to the map
// if a mark for the module is already present it should be overwritten
void Student::addMark(const string &module, float mark) {
    marks[module]=mark;
}

//method returns a copy of the map
map<string, float> Student::getCopy() {
    return marks;
}


// method to retrieve the mark for a module
// should throw NoMarkException if student has no mark for that module
float Student::getMark(const string &module) const throw(NoMarkException) {

    for (map<string,float>::const_iterator it = marks.begin(); it != marks.end(); ++it) {
        if (module==it->first)
            return it->second;
        else{
            cout<<"No mark found for this module"<<endl;
        }
    }
}
ostream& operator << (ostream &str, const Student &s) {
    str<<setw(20)<<left<<s.name;
    return str;

}
