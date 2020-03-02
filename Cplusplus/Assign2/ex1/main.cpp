/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */
#include <iostream>
#include "Student.h"
#include <fstream>
#include <vector>
#include <string>
#include <sstream>
#include <iterator>
#include <algorithm>
#include <iomanip>

using namespace std;

void firstFunc(vector<Student>students,float mark);

void secondFunc(vector<Student>students,string module, float mark);

int main(){
    vector <Student> vector_of_students;
    vector <string> vector_of_marks;
    vector<string> result;

    ifstream readFile;
    string words;

    //reading students text file
    cout<<"Please enter file name for student : "<<endl;
    cin>>words;

    readFile.open(words);

    if(!readFile.is_open()){
        cout<<"ERROR: "<<words<<" not found in the system!"<<endl;
        exit(1);
    } else {
        while (!readFile.eof()) {
            getline(readFile, words);
            //break each line and store it into a new vector
            //add the elements into students object accordingly
            istringstream iss(words);
            vector<string> tempVec;
            for (string s; iss >> s;) {
                tempVec.push_back(s);
            }
            vector_of_students.push_back(Student(tempVec.at(1) + " " + tempVec.at(2),
                                                 tempVec.at(1) + " " + tempVec.at(2),
                                                 stoi(tempVec.at(0))));
            tempVec.clear();

        }
        readFile.close();
    }

    //reading mark text file
    cout<<"Please enter file name for mark : "<<endl;
    cin>>words;
    readFile.open(words);
    if(!readFile.is_open()){
        cout<<"ERROR: "<<words<<" not found in the system!"<<endl;
        exit(1);
    }else{
        while(!readFile.eof()) {
            getline(readFile, words);
            istringstream iss(words);

            //break the line into substring and add into a vector
            for (string s; iss >> s;) {
                vector_of_marks.push_back(s);
            }

            //iterate through the collection of student objects
            //add module and mark to the map if it matches to reg. no
            bool isfound=false;
            for (vector<Student>::iterator it = vector_of_students.begin(); it != vector_of_students.end(); it++) {
                if (stoi(vector_of_marks.at(0))==it->getRegNo()) {
                    result.push_back(vector_of_marks.at(0)+"\t"+vector_of_marks.at(1)+"\t"+vector_of_marks.at(2));
                    it->addMark(vector_of_marks.at(1),stof(vector_of_marks.at(2)));
                    isfound=true;
                }
            }
            //output if the reg. no doesn't exist in the student record file
            if(!isfound){
                cout <<"WARNING: Reg. No " << vector_of_marks.at(0) << " not found in the Student record" << endl;
                cout<<'\n';
            }
            vector_of_marks.clear();

        } //end of read marks text file

        //Display all marks
        cout << "Reg No"<<"\t"<<"Module"<<"\t"<<"Mark" << endl;
        for(vector<string>::iterator it = result.begin(); it != result.end(); ++it) {
            cout << *it<<endl;
        }
    }
    readFile.close();
    char  userInput;
    cout<<"Please enter the following options"<<endl;
    cout<<"'f' = first function"<<endl;
    cout<<"'s' = second function"<<endl;
    cout<<"'q' = quit"<<endl;
    cout<<">> ";
    cin>>userInput;

    while(userInput!='q'){
          if(userInput=='f'){
            float mark;
            cout<<"Please enter mark to print all students "<<endl;
            cin>>mark;
            cout<<setw(20)<<left<<"Name"<<setw(10)<<"Min"<<setw(10)<<"Max"<<setw(10)<<"Average"<<endl;
            //calling the first function that holds two arguments
            firstFunc(vector_of_students,mark);
        }else if (userInput=='s'){
            string moduleName;
            float mark;
            cout<<"Please enter the module name "<<endl;
              cin>>moduleName;
              std::transform(moduleName.begin(), moduleName.end(),moduleName.begin(), ::toupper); //convert string to upper letters

            cout<<"Please enter number for mark"<<endl;
              cin>>mark;
              //calling the second function that holds three arguments
            secondFunc(vector_of_students,moduleName,mark);
        }else{cout<<endl;
              cout<<"Error: "<<userInput<<" not a valid option"<<endl;
          }
        cout<<endl;
        cout<<"Please enter the following options"<<endl;
        cout<<"'f' =first function"<<endl;
        cout<<"'s' =second function"<<endl;
        cout<<"'q' = quit"<<endl;
        cout<<">> ";
        cin>>userInput;
    }

    cout<<"__________End of the program___________"<<endl;
    return 0;
}

/* method that takes student collection and float as its
 * argument and print out the each student that has average,
 * min or max higher than equal to second argument "mark"
 */
void firstFunc(vector<Student>students,float mark){
    float min=0,max=0;
    float average=0;
    vector<string> studentMark;
    map<string,float> studentMap;

    //searching for each student from the collection
    //adding students' mark to temporary map
    for(size_t temp=0; temp<students.size();temp++){
        studentMap=students[temp].getCopy();
        if(studentMap.size()==0){
            cout<<students[temp].getName()<<" doesn't have any record of marks"<<endl;
            continue;
        }
        //vector holds each student's marks from the map
        vector<float> tempMark;
        for(map<string, float>::iterator MIt= studentMap.begin(); MIt!=studentMap.end(); MIt++) {
            tempMark.push_back(MIt->second);
        }

        min= *min_element(tempMark.begin(),tempMark.end()); //get the minimum mark
        max= *max_element(tempMark.begin(),tempMark.end()); //get the maximum mark

        int counter=0;
        float totalMark=0;
        //get the average mark for each student
        for(vector<float>::iterator VIt=tempMark.begin();VIt!=tempMark.end();VIt++){
            totalMark+=*VIt;
            counter++;
        }
        average=totalMark/counter;
        //output if the argument mark is lower than equal to average, min and max
        if(average>=mark || min>=mark|| max>=mark) {
            cout << students[temp]<<setw(10)<<min<<setw(10)<<max<<setw(10)<<average<<endl;
        }
    }


}
/* method that takes student collection, a string and float as its
 * arguments and print out the each student that has mark,
 * for that module that passed into argument
 */
void secondFunc(vector<Student>students,string module, float mark){
    vector<string> studentMark;
    map<string, float> studentMap;

    cout<<"Name"<<"\t"<<"Module"<<"\t"<<"Mark"<<endl;
    for(int temp=0;temp<students.size();temp++){
        studentMap=students[temp].getCopy();

        for(map<string,float>::const_iterator MIter=studentMap.begin();MIter!=studentMap.end();MIter++){
            if((MIter->first==module) && (MIter->second>=mark)){
                cout<<students[temp].getName()<<"\t"<<module<<"\t"<<MIter->second<<endl;
            }

        }
    }

}
