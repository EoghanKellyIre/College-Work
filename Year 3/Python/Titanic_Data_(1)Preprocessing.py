#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Aug 18 07:14:02 2021

@author: hyungiso
"""

# import  modules
import pandas as pd
import seaborn as sns

#--------------------------------------------
# import data
#--------------------------------------------
df= pd.read_csv("titanic.csv")

# Explore Data
# view the top 5 rows of the titanic data
df.head(5)
# check the shape of data
df.shape
# count the number of non-null observations
df.count()


#--------------------------------------------
# Missing Data
#--------------------------------------------
# drop missing value
df1=df.drop(columns="Cabin")
df1=df1.dropna()
df1.isnull().sum()
# replace original dataset as the 
data=df1
#--------------------------------------------
# Problem 7- Categoryical Data
#--------------------------------------------
dummy_sex=pd.get_dummies(data.Sex)
dummy_pclass=pd.get_dummies(data.Pclass, prefix='pclass')
# genearte final data for analysis including dummy variables
data = data.join(dummy_sex)
data = data.join(dummy_pclass)

#a) Conduct dummy coding for the categorical variable “Embarked”  
dummy_embarked=pd.get_dummies(data.Embarked, prefix='Embarked')

#b) Join the dummy_embarked DataFrmae to the DataFrame ‘data’
data = data.join(dummy_embarked)

# revised dataset
titanic_r=data
# export data 
titanic_r.to_csv("titanic_r.csv")


titanic_r= pd.read_csv("titanic.csv")
data=titanic_r
#--------------------------------------------
# Problem 8- Seaboran Graph 
#--------------------------------------------
#a) Generate a categorical bar graph using x-axis as Embarked and y-axis as Survived
sns.catplot(x="Embarked", y="Survived",kind="bar", data=titanic_r)
#b) Generate a categorical bar graph using x-axis as Sex , y-axis as Survived, hue as Embarked. 
sns.catplot(x="Sex", y="Survived", hue="Embarked", kind="bar", data=titanic_r)

#c) Interpret the graph created from above a) b)


#--------------------------------------------
#9. Problem - [Group By]
#--------------------------------------------
#a) Count the number of number of passengers(PassengerID) 
#in first, second, and third class (Pclass)
passenger_class=data['PassengerId'].groupby(data["Pclass"]).count()
#b) Find the average of the Age, Fare, Parch, PassengerID, SibSp, and Survived grouping by Sex and Pclass as follows. 
data2=data[["Age", "Fare", "Parch", "PassengerId", "SibSp", "Survived"]]
df=data2.groupby([data['Sex'],data['Pclass']]).mean()
