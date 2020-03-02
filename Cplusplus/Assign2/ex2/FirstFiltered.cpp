/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#include "FirstFiltered.h"


using namespace std;

/*function returns true if its argument is
 * a string that contains at least one upper-case
 * letter and no lower-case letters;
 */
bool FirstFiltered::filter(string word) {
    int upperCount = 0;
    int lowerCount=0;
    int punCount =0;

    /*iterate through each character for upper,lower and punc
     * if it is true then increment the counters.
    */
    for (int i = 0; i <= word.size(); i++) {
        if (isupper(word[i])) {
            upperCount++;
        }
        if (islower(word[i])) {
            lowerCount++;
        }
        if (ispunct(word[i])) {
            punCount++;
        }
    }
    //return true only if the word contains 1 or more Upper letter
    if (upperCount>0&& lowerCount==0 && punCount==0) {
        return true;
    }
}