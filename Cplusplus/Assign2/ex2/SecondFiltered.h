/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#ifndef EX2_SECONDFILTERED_H
#define EX2_SECONDFILTERED_H
using  namespace std;

#include "ReadFilteredWords.h"

class SecondFiltered :public ReadFilteredWords{
public:
    SecondFiltered(const char * fname):ReadFilteredWords(fname){};
    bool filter (string word);


};


#endif //EX2_SECONDFILTERED_H
