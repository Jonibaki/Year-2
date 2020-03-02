/* Student Name- Md Abu Joni
 * Reg NO - 1606072
 * C++ Programming
 * CE221 Assignment 2
 * Deadline - 17/01/2018
 */
#ifndef _PERSON_H_
#define _PERSON_H_

#include <string>

using namespace std;

class Person
{   public:
        Person(const string &name)
        {   this->name = name;
	    }

	    string getName() const
	    {   return name;
	    }

	    void changeName(const string &newName)
	    {   name = newName;
	    }

	protected:
	    string name;
};

#endif
