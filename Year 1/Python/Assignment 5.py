# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 11:10:43 2020

@author: Eoghán Kelly
"""

#Run Entire file to have a display to interact with.

def findQuestion():
    try:
        question = int(input("Enter the number of the question: "))
        if question>=0 and question<=7:
            if (question==1):
                whichOdd()
            if (question==2):
                whichDiv()
            if (question==3):
                stringM()
            if (question==4):
                convertB()
            if (question==5):
                rootPower()
            if (question==6):
                stringSum()
            if (question==7):
                isIn()
        else:
            print("Please enter the question number")
            findQuestion()
    except:
        print("Please enter the question number")
        findQuestion()

def whichOdd():
    try:
        print("This function examines three variables and prints the largest odd number among them.")
        numberOne = int(input("Enter the first number: "))
        numberTwo = int(input("Enter the second number: "))
        numberThree = int(input("Enter the third number: "))
        if (numberOne%2==0 and numberTwo%2==0 and numberThree%2==0):
            print("None of these numbers are odd.")
        else:
            oddNumbers = []
            if (numberOne%2!=0):
               oddNumbers.append(numberOne)
            if (numberTwo%2!=0):    
                oddNumbers.append(numberTwo)
            if (numberThree%2!=0):    
               oddNumbers.append(numberThree)
               oddNumbers.sort(reverse = True) 
            print(oddNumbers[0])
    except:
        print("Error. You must enter three integers")
        whichOdd()

def whichDiv():
    try:
        print("This function checks how many numbers between the first number and and the"\
              " second number are divisible by the third number")
        numberOne = int(input("Enter the first number: "))
        numberTwo = int(input("Enter the second number: "))
        numberThree = int(input("Enter the third number: "))
        count = 0;
        for i in range(numberOne+1, numberTwo):
            if (i % numberThree == 0):
                count += 1
        for i in range(numberTwo, numberOne-1):
            if (i % numberThree == 0):
                count += 1
        print(count)
    except:
        print("Error. You must enter three integers, separated by commas.")
        whichDiv()

def stringM():
    try:
        print("This function prints * the amount of times of the integer you enter")
        number = int(input("Enter the amount of times: "))
        for i in range(0, number):
            print("*")
    except:
        print("Error. You must enter a integer")
        stringM()

def convertB():
    try:
        print("This function reads a number and prints the binary of that number.")
        number = int(input("Enter an integer: "))
        if number < 0:
            print("Error, please enter a positive integer")
            convertB()
        binaryString = []
        while (number>0):
            remainer = int(float(number%2))
            binaryString.append(remainer)
            number = (number-remainer)/2
        binary=""
        for i in binaryString[::-1]:
            binary += str(i)
        print(binary)
    except:
        print("Error, please enter an integer")
        convertB()
    
def rootPower():
    try:
        print("This function  asks the user to enter an integer and print two integers, root and pwr,"\
              " such that 0<pwr<6 and root**pwr is equal to the integer entered by user.")
        number = int(input("Enter an integer: "))
        if number < 0:
            print("Error, please enter a positive integer")
            rootPower()
        for i in range(0, number):
            for j in range(0, 7):
                if (i ** j == number):
                    print(i," to the power of ",j)
    except:
        print("Error. Please enter an Integer.")
        rootPower()
    
def stringSum():
    try:
        print("This function gets a string of numbers and prints the sum of those numbers.")
        numbersEntered = str(input("Enter the string of numbersEg.(3,5,3.3): "))
        numbersEntered = numbersEntered.split(',')
        for i in range(0, len(numbersEntered) ):
            numbersEntered[i] = float(numbersEntered[i])
        sumD = round(sum(numbersEntered),4)
        print(sumD)
    except:
        print("Error please enter a string of numbers. Eg.(3,5,3.3)")
        stringSum()
    
def isIn():
    try:
        print("This function returns true if one of the strings entered contain the other, otherwise it returns false.")
        stringOne = str(input("Enter the first string: "))
        stringTwo = str(input("Enter the second string: "))
        if stringTwo in stringOne or stringOne in stringTwo:
            print("True")
            return True
        else:
            print("False")
            return False
    except:
        print("Error. Please enter two strings.")
        isIn()

print("Which Function would you like to test?")
print("To use Q1 (whichOdd) type 1")
print("To use Q2 (whichDiv) type 2")
print("To use Q3 (stringM) type 3")
print("To use Q4 (convertB) type 4")
print("To use Q5 (rootPower) type 5")
print("To use Q6 (stringSum) type 6")
print("To use Q7 (isIn) type 7")
findQuestion()

# To keep python.exe from closing asking for another input.
temp = input()