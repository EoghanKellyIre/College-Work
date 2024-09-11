# -*- coding: utf-8 -*-
"""
Created on Sun Mar 19 14:57:44 2023

@author: eogha
"""
import pandas as pd
from sklearn.linear_model import LogisticRegression

df = pd.read_csv("animal_adoption.csv")

#check whether there are null values in the dataset
print("In the dataset there are",df.isna().sum().sum(),"null values")

#drop from the dataset all null values
df_clean = df.dropna(axis = 0)


#create DataFrame called “sample_data” and store only the records of (outcome_type=Euthanasia or outcome_type=Adoption) and (animal_type=Dog)
sample_data = df_clean[((df_clean.loc[:,"outcome_type"] == "Euthanasia") | (df_clean.loc[:,"outcome_type"] == "Adoption"))& (df_clean.loc[:,"animal_type"] == "Dog")]

#--------------------------------------------
# Problem 7- Categoryical Data
#--------------------------------------------
dummy_gender=pd.get_dummies(sample_data.gender)
dummy_outcome=pd.get_dummies(sample_data.outcome_type)
dummy_neutralization=pd.get_dummies(sample_data.neutralization)
#dummy_color=pd.get_dummies(sample_data.color)
#dummy_breed=pd.get_dummies(sample_data.breed)


# genearte final data for analysis including dummy variables
sample_data = sample_data.join(dummy_gender)
sample_data = sample_data.join(dummy_outcome)
sample_data = sample_data.join(dummy_neutralization)
#sample_data = sample_data.join(dummy_color)

#a) Conduct dummy coding for the categorical variable “Embarked”  
#dummy_embarked=pd.get_dummies(sample_data.Embarked, prefix='Embarked')

#b) Join the dummy_embarked DataFrmae to the DataFrame ‘data’
#sample_data = sample_data.join(dummy_embarked)

# revised dataset


# when you use categorical variable for analysis, you need to exclude one varialbe as a base parameter.
#data['intercept']=1
#x=data[['intercept','female', 'pclass_1', 'pclass_2', 'Age']]
x=sample_data[['Female', 'Neutered', 'age_days']]
y=sample_data['Adoption']

# Model Selection
model_sk=LogisticRegression(fit_intercept=True)

# Model Fitting
result_sk=model_sk.fit(x, y)

# Model Perdiction (Dog - female=1, Neutered=1, age_days=170)
predict=model_sk.predict([[1,1,170]])
if predict==1: 
    print("Adoption")
elif predict==0:
    print("Euthanasia")
    

import seaborn as sns
#--------------------------------------------
# Problem 8- Seaboran Graph 
#--------------------------------------------
#a) Generate a categorical bar graph using x-axis as Embarked and y-axis as Survived
sns.catplot(x="gender", y="Euthanasia",kind="bar", data=sample_data)
sns.catplot(x="neutralization", y="Euthanasia",kind="bar", data=sample_data)

#sns.catplot(x="Embarked", y="Survived",kind="bar", data=titanic_r)
#b) Generate a categorical bar graph using x-axis as Sex , y-axis as Survived, hue as Embarked. 
sns.catplot(x="neutralization", y="Euthanasia", hue="gender", kind="bar", data=sample_data)

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
