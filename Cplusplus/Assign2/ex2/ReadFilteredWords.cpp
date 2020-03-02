/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */

#include "ReadFilteredWords.h"

using namespace std;

/**
 * Returns a string, being the next word in the file that satisfies the filter.
 * @return - string - next word that satisfies the filter
 * returns empty string if there's no such word
 */
string ReadFilteredWords::getNextFilteredWord(){
    //return filtered word until it reaches the end of the text file
    while (isNextWord()) {
        string satisfiedWord = getNextWord();
        if(!isNextWord()){
            return satisfiedWord="";
        }
        if (filter(satisfiedWord)) {
            return satisfiedWord;
        }
    }
    close();

}