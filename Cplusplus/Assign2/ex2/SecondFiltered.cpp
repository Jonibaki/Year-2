/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */
#include "SecondFiltered.h"


using  namespace std;

/*function returns true if its argument is a string
 * containing at least one letter and at least one numeric digit
 */
bool SecondFiltered::filter(string word) {

    int letterCount = 0;
    int numCount =0;
    int punCount =0;
    //loop through the each character of the word
    //and check for each character to be a punc, alpha or digit
    //and increment the variables
    for (int i = 0; i <= word.size(); i++) {
        if (ispunct(word[i])) {
            punCount++;
        }
        if(isalpha(word[i])){
            letterCount++;
        }
        if(isdigit(word[i])){
            numCount++;
        }
    }
    //return true if the word contain one or more letters and digits
    if ((letterCount>0&&numCount>0)&&punCount==0) {
        return true;
    }

}