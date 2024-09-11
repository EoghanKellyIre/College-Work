# -*- coding: utf-8 -*-
"""
Created on Tue Mar 28 18:30:02 2023

@author: eogha
"""
#from IPython.display import display
import requests
import json
import pandas as pd
def getFilmId(QueryForName):
    url = "https://online-movie-database.p.rapidapi.com/title/find"
    
    querystring = {"q":QueryForName}
    
    headers = {
    	"X-RapidAPI-Key": "7b7b6213e3msh74f61c31b9d839fp157124jsnc6b8fd0f0032",
    	"X-RapidAPI-Host": "online-movie-database.p.rapidapi.com"
    }
    
    response = requests.request("GET", url, headers=headers, params=querystring)
    
    text_dict=json.loads(response.text)
    filmId = text_dict['results'][0]['id']
    filmId = filmId.split('/')
    return(filmId[2])

def findRatings(movie_id_inputed):
    url = "https://online-movie-database.p.rapidapi.com/title/get-ratings"
    
    querystring = {"tconst":movie_id_inputed}
    
    headers = {
    	"X-RapidAPI-Key": "7b7b6213e3msh74f61c31b9d839fp157124jsnc6b8fd0f0032",
    	"X-RapidAPI-Host": "online-movie-database.p.rapidapi.com"
    }

    response = requests.request("GET", url, headers=headers, params=querystring)
    text_dict=json.loads(response.text)
    ratings=[]
    ages=[]
    
    for i in text_dict['ratingsHistograms']:
        ratings.append(text_dict['ratingsHistograms'][i]['aggregateRating'])
        ages.append(text_dict['ratingsHistograms'][i]['demographic'])
        
    movie_df=pd.DataFrame({'Ratings':ratings,
                     'Range':ages})
    
    rangesFemales = []
    rangesMales = []
    rangesIMDB = []
    rangesCountry = []
    rangesAges = []
    rangesGender = []
    
    names_of_demos = movie_df["Range"]
    for i in range(0,len(names_of_demos)):
        if 'Females ' in names_of_demos[i]:
            rangesFemales.append(i)
        elif 'Males ' in names_of_demos[i]:
            rangesMales.append(i)
        elif 'IMDb' in names_of_demos[i]:
            rangesIMDB.append(i)
        elif 'US' in names_of_demos[i]:
            rangesCountry.append(i)
        elif 'Aged' in names_of_demos[i]:
            rangesAges.append(i)
        elif 'Female' or 'Male' in names_of_demos[i]:
            rangesGender.append(i)
    
    list_to_sort=[rangesFemales, rangesMales, rangesAges]
    rangesMalesDf = movie_df.loc[movie_df.index[list_to_sort[1]]].reset_index(drop=True)
    rangesFemalesDf = movie_df.loc[movie_df.index[list_to_sort[0]]].reset_index(drop=True)
    rangesAgesDf = movie_df.loc[movie_df.index[list_to_sort[2]]].reset_index(drop=True)
    list_sorted=[rangesFemalesDf, rangesMalesDf, rangesAgesDf]
    for i in range(0,len(list_to_sort)):
        tempvalue=[]
        names_of_rangestempDf = list_sorted[i]["Range"]
        for j in range(0,len(names_of_rangestempDf)):
            num = int(''.join(filter(str.isdigit, names_of_rangestempDf[j])))
            if num>999:
                num= str(num)[2:4]
            tempvalue.append(int(num))
        list_sorted[i]["ordering"]=tempvalue     
        list_sorted[i] = list_sorted[i].sort_values("ordering")
    
    rangesImdbDf = movie_df.loc[movie_df.index[rangesIMDB]].reset_index(drop=True)
    rangesCountryDf = movie_df.loc[movie_df.index[rangesCountry]].reset_index(drop=True)
    rangesGenderDf = movie_df.loc[movie_df.index[rangesGender]].reset_index(drop=True)
    
    list_sorted.append(rangesImdbDf)
    list_sorted.append(rangesCountryDf)
    list_sorted.append(rangesGenderDf)
    for i in range(0,len(list_sorted)):
        list_sorted[i].plot.bar("Range", 'Ratings')
    
    return()

print('Enter a film name to search for:')
userInput = input()
findRatings(getFilmId(userInput))
