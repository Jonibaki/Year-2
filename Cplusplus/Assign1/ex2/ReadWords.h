/**
* ReadWords Interface for Assignment 1
*/

#ifndef READWORDS_H
#define READWORDS_H
/**
* ReadWords class. Provides mechanisms to read a text file, and return
* capitalized words from that file.
*/
using namespace std;

#include <string>
#include <fstream>

class ReadWords
{
public:

	/**
	* Constructor. Opens the file with the given filename.
	* Prints an error message then terminates the program if file does not exist.
	* @param filename - a C string naming the file to read.
	*/
	ReadWords(const char *filename);

	/**
	* Closes the file.
	*/
	void close();

	/**
	* Returns a string, being the next word in the file. All letters should be
	* converted to lower case
	* Leading and trailing punctuation marks should not be included in the word
	* but punctuation elsewhere should not be removed
	* @return - string - next word.
	*/
	string getNextWord();


	/**
	* Returns true if there is a further word in the file, false if we have reached the
	* end of file.
	* @return - bool - !eof
	*/
	bool isNextWord();


	// working storage - you will need to use the input file stream, but are not obliged to use the other 2 variables
	// they are declared so that you can use them if you wish, since you are not allowed to change this file
private:
	ifstream wordfile;
	string nextword;
	bool eoffound;
};

#endif
