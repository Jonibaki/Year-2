/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */
#include <iostream>
#include "ReadFilteredWords.h"
#include "FirstFiltered.h"
#include "SecondFiltered.h"
#include "ThirdFiltered.h"
#include <map>
#include <vector>

using namespace std;
int main(){
    vector<string>maxVector;
    vector<string>minVector;
    string minWord, maxWord;
    int min=1, max=1,minCounter,maxCounter;
    map<string,int> wordcount;

    char file[20];
    int userOption;
    cout<<"Please enter the file name >> ";
    cin>>file;

    //objects of the derived class takes text file as its argument
    FirstFiltered firstFiltered(file);
    SecondFiltered secondFiltered(file);
    ThirdFiltered thirdFiltered(file);

    //pointers of the abstract class
    ReadFilteredWords *ptrA, *ptrB, *ptrC;

    cout<<"Please select the following options:"<<endl;
    cout<<"Enter 1 : (first filtered)"<<endl;
    cout<<"Enter 2 : (second filtered)"<<endl;
    cout<<"Enter 3 : (third filtered)"<<endl;
    cout<<">>";
    cin>>userOption;


    /* user input determine each filter to be fired up
     * input 1,2 or 3 call for different cases. Furthermore,
     * it calls the filtered function to get filtered words and add it to a map
     */
    switch(userOption) {
        //first filter
        case 1 : {
            ptrA=&firstFiltered;
            string temp = ptrA->getNextFilteredWord();

            //get the filtered word until word is an empty string
            while (temp != "") {
                wordcount[temp]++; //add to map
                temp = firstFiltered.getNextFilteredWord();
            }

            //print out all the words from the map
            for (map<string, int>::const_iterator MIt = wordcount.begin(); MIt != wordcount.end(); MIt++) {
                cout <<MIt->first << " : " << MIt->second << endl;
            }

            cout<<endl;
            cout<<"Analysing the first filtered function..."<<endl;
            cout<<">> Total entries of word(s): "<<wordcount.size()<<endl;

            //get the maximum and minimum occurrence of word(s)from the map and assigned to variables
            for (map<string, int>::const_iterator MIt = wordcount.begin();MIt!=wordcount.end(); ++MIt) {
                if (min>= MIt->second) {
                    min = MIt->second;
                    minWord=MIt->first;
                    minCounter++;
                }
                if (max <= MIt->second) {
                    max = MIt->second;
                    maxWord= MIt->first;
                    maxCounter++;
                }
            }
            // print out the maximum and minimum words along with its count
            if(maxCounter>1) {
                cout << ">> The largest occurrence of word : " << maxWord << " = " << max << " and " << maxCounter - 1
                     << " more words" << endl;
            }else{cout << ">> The largest occurrence of word : " << maxWord << " = " << max <<endl;

            }
            if(minCounter>1) {
                cout << ">> The smallest occurrence of word : " << minWord << " = " << min << " and " << minCounter - 1
                     << " more words" << endl;
            }else{
                cout << ">> The largest occurrence of word : " << minWord << " = " << min <<endl;
            }
        }
            break;

        //second filter
        case 2 : {
            ptrB=&secondFiltered;
            string temp=ptrB->getNextFilteredWord();

            //get the filtered word until word is an empty string
            while (temp != "") {
                wordcount[temp]++;
                temp= secondFiltered.getNextFilteredWord();
            }
            //print out all the words from the map
            for (map<string, int>::const_iterator MIt = wordcount.begin(); MIt != wordcount.end(); MIt++) {
                cout <<MIt->first << " : " << MIt->second << endl;
            }

            cout<<endl;
            cout<<"Analysing the second filtered function..."<<endl;
            cout<<">> Total entry of word(s): "<<wordcount.size()<<endl;

            //get the maximum and minimum occurrence of word(s)from the map and assigned it to variables

            for (map<string, int>::const_iterator MIt = wordcount.begin();MIt!=wordcount.end(); ++MIt) {
                if (min>= MIt->second) {
                    min = MIt->second;
                    minWord=MIt->first;
                    minCounter++;
                }
                if (max <= MIt->second) {
                    max = MIt->second;
                    maxWord= MIt->first;
                    maxCounter++;
                }
            }
            // print out the maximum and minimum words along with its count
            if(maxCounter>1) {
                cout << ">> The largest occurrence of word : " << maxWord << " = " << max << " and " << maxCounter - 1
                     << " more words" << endl;
            }else{cout << ">> The largest occurrence of word : " << maxWord << " = " << max <<endl;

            }
            if(minCounter>1) {
                cout << ">> The smallest occurrence of word : " << minWord << " = " << min << " and " << minCounter - 1
                     << " more words" << endl;
            }else{
                cout << ">> The largest occurrence of word : " << minWord << " = " << min <<endl;
            }
        }
        break;

        //third filter
        case 3 : {
            ptrC=&thirdFiltered;
            string temp = ptrC->getNextFilteredWord();

            //get the filtered word until word is an empty string
            while (temp!= "") {
                wordcount[temp]++;
                temp = thirdFiltered.getNextFilteredWord();
            }
            //print out all the words from the map
            for (map<string, int>::const_iterator MIt = wordcount.begin(); MIt != wordcount.end(); MIt++) {
                cout <<MIt->first << " : " << MIt->second << endl;
            }

            cout<<endl;
            cout<<"Analysing the third filtered function..."<<endl;
            cout<<">> Total entry of word(s): "<<wordcount.size()<<endl;

            //get the maximum and minimum occurrence of word(s)from the map and assigned it to variables
            for (map<string, int>::const_iterator MIt = wordcount.begin();MIt!=wordcount.end(); ++MIt) {
                if (min>= MIt->second) {
                    min = MIt->second;
                    minWord=MIt->first;
                    minCounter++;
                }
                if (max <= MIt->second) {
                    max = MIt->second;
                    maxWord= MIt->first;
                    maxCounter++;
                }
            }
            // print out the maximum and minimum words along with its count
            if(maxCounter>1) {
                cout << ">> The largest occurrence of word : " << maxWord << " = " << max << " and " << maxCounter - 1
                     << " more words" << endl;
            }else{cout << ">> The largest occurrence of word : " << maxWord << " = " << max <<endl;

            }
            if(minCounter>1) {
                cout << ">> The smallest occurrence of word : " << minWord << " = " << min << " and " << minCounter - 1
                     << " more words" << endl;
            }else{cout << ">> The largest occurrence of word : " << minWord << " = " << min <<endl;
            }
        }
        break;
    }

    wordcount.clear();
    cout<<"______END OF PROGRAM______"<<endl;
    return 0;
}