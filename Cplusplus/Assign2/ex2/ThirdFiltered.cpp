/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#include "ThirdFiltered.h"

using  namespace std;

/*function returns true if its argument is a string that
 * contains exactly one punctuation character.
 */

bool ThirdFiltered::filter(string word) {
    int punCount = 0;
    //loop through the word and if the contains punc then increment count variable
    for (int i = 0; i <= word.size(); i++) {
        if (ispunct(word[i])) {
            punCount++;
        }
    }
    if (punCount == 1) {
        return true;
    }
}



