#include <iostream>
#include "ReadWords.h"
#include "BarGraph.h"
#include <fstream>
#include <cstdlib>

using namespace std;

int main() {
	char fileName[50];
	cout << "Please enter the file name: " << endl;
	cin >> fileName; //assigned user input file name
	ReadWords rw (fileName);
	system("PAUSE");
	return 0;
}