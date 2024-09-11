#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 21 17:34:20 2021

@author: hyungiso
"""
import pandas as pd
from sklearn.linear_model import LogisticRegression

data=pd.read_csv("titanic_r.csv")

"""
# remove unnamed columns
data=data.drop(columns="Unnamed: 0")

data=data[(data["Age"].isnull()==False) & (data["Embarked"].isnull()==False)]
#--------------------------------------------
# Categorical Data
#--------------------------------------------
# rank (categorical data) -1,2,3,4
# For analysis - we need to change this variable as dummy variables
dummy_sex=pd.get_dummies(data.Sex)
dummy_pclass=pd.get_dummies(data.Pclass, prefix='pclass')
dummy_embarked=pd.get_dummies(data.Embarked, prefix='Embarked')

# genearte final data for analysis including dummy variables
data = data.join(dummy_sex)
data = data.join(dummy_pclass)
data = data.join(dummy_embarked)
"""

# when you use categorical variable for analysis, you need to exclude one varialbe as a base parameter.
#data['intercept']=1
#x=data[['intercept','female', 'pclass_1', 'pclass_2', 'Age']]
x=data[['female', 'pclass_1', 'pclass_2', 'Age']]
y=data['Survived']

# Model Selection
model_sk=LogisticRegression(fit_intercept=True)

# Model Fitting
result_sk=model_sk.fit(x, y)

print(result_sk.coef_)
print(result_sk.intercept_)
print(result_sk.score(x,y))


# Model Perdiction (Rose - female=1, pclass_1=1, pclass_2=0, age=17)
predict=model_sk.predict([[1,1,0,17]])
if predict==0: 
    print("Dead")
elif predict==1:
    print("Survive")

#------------------------------------------
# assignments
#------------------------------------------
# 1) Model Perdiction (male, 3rd class ticket, 20 years old)
# Model Perdiction (Rose - female=1, pclass_1=1, pclass_2=0, age=17)
predict=model_sk.predict([[0,0,0,20]])
if predict==0: 
    print("Dead")
elif predict==1:
    print("Survive")



# 2) predict the probability of survival - sex, embarked



