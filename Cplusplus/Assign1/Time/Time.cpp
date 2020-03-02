using namespace std;

#include <iostream>
#include <iomanip>
#include <cmath>
#include "Time.h"

//constructor
Time::Time()
{
	hour = min = sec = 0;
}

//constructor that takes three Integer types variable as its arguments
Time::Time(int h, int m, int s)
{
	setTime(h, m, s);
}
//method sets the value of each variables 
//sets hour as it is unless 0 if it is higher than 24 or less than 0
//and for minutes and second it sets the given value, 0 if it is higher than 60 or less than 0
void Time::setTime(int h, int m, int s)
{
	hour = (h >= 0 && h<24) ? h : 0;
	min = (m >= 0 && m<60) ? m : 0;
	sec = (s >= 0 && s<60) ? s : 0;
}

//Binary operator overloading 
//n second add up with given integer
//add up with minutes and then hours 
Time& Time::operator+=(unsigned int n)
{
	sec += n;
	if (sec >= 60){
		min += sec / 60;
		sec %= 60;
		if (min >= 60){
			hour = (hour + min / 60) % 24;
			min %= 60;
		}
	}
	return *this;
}

//add an integer value to time and it  increases the time n second  
Time Time::operator+(unsigned int n) const
{
	Time tCopy(*this);
	tCopy += n;
	return tCopy;
}

//unary operator overloading 
//increment time by 1 before initialition 
Time& Time::operator++()        // prefix version
{
	*this += 1;
	return *this;
}

//increment time by 1 after initialition 
Time Time::operator++(int n)    // postfix version
{
	Time tCopy(*this);
	*this += 1;
	return tCopy;
}
//return true if time is equal to another time or else it returns false
bool Time::operator==(const Time& t) const {
	if (this->hour == t.hour && this->min == t.min && this->sec==t.sec) {
		return true;
	}
	else
	{
		return false;
	}
}
//comparing between two times and returns true if the time is less than equal or else it returns false
bool Time:: operator<=(const Time& t) const {
	if (*this < t.hour || *this == t.hour) {
		return true;
	}
	else {
		return false;
	}
}
//comparing between two times and returns true if the time is greater than equal or else it returns false
bool Time:: operator>=(const Time& t) const {
	if (*this > t.hour || *this == t.hour) {
		return true;
	}
	else {
		return false;
	}
}
//binary (-) operator overloading 
Time Time :: operator-(unsigned int n) const {
	Time tCopy(*this);
	tCopy -= n;
	return tCopy;
}
Time& Time ::operator-=(unsigned int n) {
	//check for hours values and set it to 24 if it is 0 o'clock 
	if (hour == 0) {
		hour = 24;
	}
	//converting hours and mintures to seconds and use the values to get reminding 
	//hours, minutes and seconds
	hour = hour * 3600;
	min = min * 60;
	int tempTime = hour + min + sec-n; //stores converted time 
	hour = (tempTime / 3600) % 24;
	min = (tempTime % 3600)/60;
	sec = (tempTime % 3600)%60;

	return *this;
}
//decrement times before initialitation 
Time& Time::operator--() //prefix version
{
	*this -= 1;
	return *this;
}


//ostream << overloading which setsfill with '0' and have a width of 2 
ostream& operator<<(ostream &o, const Time &t)
{
	o << setfill('0') << setw(2) << t.hour << ':' << setw(2) << t.min << ':' << setw(2) << t.sec;
	return o;
}
//Comparison operators overloading 

//check the hour of the time if the first time less than second time  then it 
//will return true or else it will retun false
bool operator<(const Time& t1, const Time& t2) {
	if (t1.hour < t2.hour) { return true; }
	else {
		return false;
	}
}
//check the hour of the time if the first time greater than second time  then it 
//will return true or else it will retun false
bool operator>(const Time& t1, const Time& t2) {

	if (t1.hour > t2.hour ) { return true; }
	else
	{
		return false;
	}
}

//boolean returns true if the time is two times values are different than each other
bool operator!=(const Time&t1, const Time&t2) {
	if (t1.hour == t2.hour && t1.min==t2.min && t1.sec==t1.sec) { return false; }
	else {
		return true;
	}
}

//decrement times after initialisation 
Time operator--(Time&t, int n) // postfix version
{
	t= t-1;
	return t;
}

//method returns an integer after substracting from two times
//the elapsed time is converted into seconds.
unsigned int operator-(const Time&t1, const Time&t2) {
	int elapseTime; 
	int tempHour=0;
	int tempMin=0;
	int tempSec=0;

	//finish time is higher than start time
	if (t1>t2) { 
		tempHour = (t1.hour - t2.hour) * 3600; 
		tempMin = (t1.min - t2.min) * 60;
		tempSec = (t1.sec - t2.sec);
	}
	//finish time is less then start time
	else if (t1 < t2) {
		int tempTime= 86400-t2.hour* 3600-t2.min* 60-tempMin+t2.sec ; //convert all the times to seconds,then substract from 24 hours(86400sec) 
		tempHour = t1.hour * 3600;
		tempMin = t1.min * 60;
		tempSec = t1.sec+tempTime;
	}

	return elapseTime = tempHour + tempMin + tempSec;
}

