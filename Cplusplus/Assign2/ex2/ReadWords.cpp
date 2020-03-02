/**
 * ReadWords class, the base class for CE221 Assignment 2 (Exercise 2)
 * original version written by Dave Lyons
 * modified by sands
 * Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */
#include "ReadWords.h"


/**
 * Constructor. Opens the file with the given filename.
 * Program exits with an error message if the file does not exist.
 * @param - filename, a C string naming the file to read.
 * After a successful open, the constructor reads the first of the strings,
 * and initialises the eoffound flag.
 */
ReadWords::ReadWords(const char *fname)
{   wordfile.open(fname);//open file

    if (!wordfile)
    {   cout << "cannot open " << fname << endl;
        exit(1);
    }
    wordfile >> nextword;
    eoffound = false;
}

/**
 * Closes the file.
 */
void ReadWords::close()
{   wordfile.close();
}

/**
 * Returns true if there is a further word in the file, false if we have reached the
 * end of file.
 * @return - bool - !eof
 * eoffound will have been set by getNextWord
 */
bool ReadWords::isNextWord()
{   return !eoffound;
}

/**
 * Eliminates punctuations at the beginning and the end if any.
 * @param - string to be fixed.
 * @return - string fixed.
 */
string ReadWords::fix(string word)
{   string s=word;
    int len = s.size();
    string answer = "";

    bool t = false;
    for (int i=0; i<len; ++i)
    {   if(isalnum(s[i])) //find the first alphanumeric character and set the boolean t as true
            t=true;

        if(t)
            if(isalnum(s[i]))
                answer += s[i];
            else if(i!=0 && i!=len-1) // if it is not the first and the last, just store it.
               answer += s[i];
    }

    if(answer.size()>0) //remove punctuations at the end of a word, i.e., "sing...."==>>"sing"
    {   int length = answer.size();
        while(!isalnum(answer[--length]))
            answer.erase(length,1); //remove the last character if it is not alphanumeric
    }

    return answer;
}

/**
 * Returns a string, being the next word in the file.
 * @return - string, fixed nextword.
 */
// note that this function could return an empty string
// if the "word" is a sequence of non-alphanumeric characters the fix function will remove everything!

string ReadWords::getNextWord()
{    string word = nextword;
     wordfile >> nextword;

     if(wordfile.eof()) //nextword doesn't exist.
         eoffound=true;

     return  fix(word);
}

