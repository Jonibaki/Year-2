/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#ifndef FIRSTFILTERED_H
#define FIRSTFILTERED_H
using namespace std;

#include "ReadFilteredWords.h"


class FirstFiltered: public ReadFilteredWords {
public:
    FirstFiltered(const char *fname):ReadFilteredWords(fname){};

    bool filter(string word);

};


#endif //FIRSTFILTERED_H
