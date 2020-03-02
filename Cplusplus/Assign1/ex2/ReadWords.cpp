#include <fstream>
#include <iostream>
#include <cstdlib>
#include <map>
#include <cctype>
#include <iterator>
#include <algorithm>
#include <iomanip>
#include "ReadWords.h"

using namespace std;

map<string, int> dictWords;  //using the map function to store each words from the text file 

ReadWords::ReadWords(const char *file) {
	ofstream outputfile; //output file
	ifstream searchfile; //additional file reader

	int counter = 1; //increase the number of the dictionary
	string word; // read and assigned each word from the text file as it reads

	wordfile.open(file);
	if (!wordfile.is_open()) {//terminate immediately if the file name doesn't found
		cout << "Input file could not be opened! Terminating!" << endl;
		exit(1);
	}


	//scan through the text and store each word with key.
	while (wordfile.good()) {
		wordfile >> word;
		//word.erase(remove_if(word.begin(), word.end(), ispunct), word.end()); //remove_if is part of <algorithm class>
		transform(word.begin(), word.end(), word.begin(), ::tolower); //set all the string to lower case
		dictWords[word] += counter; //increase the number of value if the key happens to be occurrs multiple times in the loop
		
	}

	cout << "Please enter a file name to search for words " << endl;
	char searchWord[20];
	cin >> searchWord;
	searchfile.open(searchWord);

	string search;
	 
	if (!searchfile.is_open()) {
		cout << "Input file could not be opened! Terminating!" << endl;
		exit(1);
	}
	//user customised file name that stores all the output
	string user_file;
	cout << "Please enter a file name to save the output :" << endl;
	cin >> user_file; //stores user file name 

	outputfile.open(user_file);
		//read the search file for similar word in the dictionary 
		while (searchfile.good()) {
			getline(searchfile, search);
		
			if (dictWords.find(search) == dictWords.end()) {
				//display it in the console 
				cout.fill(' ');
				cout << setw(15) << left << search;
				cout << "NOT FOUND IN THE SCRIPT !!" << endl;

				//write it output file
				outputfile.fill(' ');
				outputfile << setw(15) << left << search;
				outputfile << "NOT FOUND IN THE SCRIPT !!" << endl;
				
			}
			else {
				//display result in the console
				cout.fill(' ');
				cout << setw(15) << left << search;
				cout.fill('*');
				cout << setw(dictWords.at(search) + 1) << right
					<< dictWords.at(search) << endl;
				
				//write it to output file
				outputfile.fill(' ');
				outputfile << setw(15) << left << search;
				outputfile.fill('*');
				outputfile << setw(dictWords.at(search) + 1) << right
					<< dictWords.at(search) << endl;


			}
		}

	//close all the streams
	wordfile.close();
	searchfile.close();
	outputfile.close();
	cout << "File read/write Successfully !!" << endl;
}
bool isNextWord()
{ 
	return false;
}

string getNextWord()
{

	return string();
}

void close()
{
	
}
