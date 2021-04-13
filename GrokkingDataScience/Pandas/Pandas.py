
import pandas as pd 
series = pd.Series([0, 1, 2, 3])
print(series)

series=pd.Series([0,1,2,3,4,5])
print("Values:", series.values)
print("Indices:", series.index, "\n" )
print(series[1], "\n")   # Get a single value
print(series[1:4]) # Get a range of values


import pandas as pd 
data = pd.Series([12, 24, 13, 54], 
                index=['a', 'b', 'c', 'd'])

print(data, "\n")
print("Value at index b:", data['b'])


import pandas as pd 
fruit_dict = { 'apples': 10 , 'orange':8, 'banana': 4, 'strawberry': 20}
fruits = pd.Series(fruit_dict)
print("value for apples:", fruits['apples'], fruit_dict['apples'])
print("value for apples:", fruits['apples':'strawberry'])


import pandas as pd 
data_s1 = pd.Series([12,13,14,25], index=['apples','orange', 'banana', 'strawberry'])
dataframe1= pd.DataFrame(data_s1, columns=['quantity']);
print(dataframe1)


dict = {"country": ["Norway", "Sweden", "Spain", "France"],
       "capital": ["Oslo", "Stockholm", "Madrid", "Paris"],
       "SomeColumn": ["100", "200", "300", "400"]}

data = pd.DataFrame(dict)
print(data)



import pandas as pd 
quantity = pd.Series([12,24,33,15], index=['apples','orange','banana','stawberry'])
price = pd.Series([4,4.5,8,7.5],index=['apples','orange','banana','stawberry'])
df =pd.DataFrame({'quantity': quantity, 'price':price})
print(df)



import pandas as pd 

# Given we have a file called data1.csv in our working directory:
df = pd.read_csv('data1.csv')

#given json data
df = pd.read_json('data2.json')



import pandas as pd
movies_df = pd.read_csv("IMDB-Movie-Data.csv");
movies_df_title_indexed = movies_df.set_index('Title')
print(movies_df)




import pandas as pd
movies_df_title_indexed = pd.read_csv("IMDB-Movie-Data.csv", index_col='Title');
print(movies_df_title_indexed)
movies_df = pd.read_csv("IMDB-Movie-Data.csv");
movies_df_title_indexed = movies_df.set_index('Title')
print(movies_df_title_indexed)




movies_df.head(2)



movies_df_title_indexed.head()
movies_df_title_indexed.tail(3)




movies_df_title_indexed.info()




movies_df_title_indexed.shape




movies_df_title_indexed.describe()








import pandas as pd
movies_df = pd.read_csv("IMDB-Movie-Data.csv");
print(movies_df)
genre_col= movies_df["Genre"]
print(genre_col)

# We can select any column using its label:

# To obtain a Series as output
col_as_series = movies_df['Genre']

# Print the object type and the first 5 rows of the series
print(type(col_as_series))
col_as_series.head()


# To obtain a dataFrame as output
col_as_df = movies_df[['Genre']]

# Print the object type and the first 5 rows of the DF
print(type(col_as_df))
col_as_df.head()


movies_df_title_indexed = pd.read_csv("IMDB-Movie-Data.csv", index_col='Title');
gog = movies_df_title_indexed.loc["Guardians of the Galaxy"]
gog = movies_df_title_indexed.iloc[0]
print(gog)

multiple_rows = movies_df_title_indexed.loc['Guardians of the Galaxy':'Sing']

multiple_rows = movies_df_title_indexed.iloc[0:4]

multiple_rows

movies_df_title_indexed.loc[:'Sing',:'Director']
movies_df_title_indexed.iloc[:4,:3]

movies_df_title_indexed.ix[:'Sing', :4]
movies_df_title_indexed.ix[:4, :'Director']

# We can easily filter rows using the values of a specific row.
# For example, for geting all our 2016 movies:
movies_df_title_indexed[movies_df_title_indexed['Year'] == 2016]

# All our movies with a rating higher than 8.0
movies_df_title_indexed[movies_df_title_indexed['Rating'] > 8.0 ]

movies_df_title_indexed[
    ((movies_df_title_indexed['Year'] >= 2010) & (movies_df_title_indexed['Year'] <= 2016))
    & (movies_df_title_indexed['Rating'] < 6.0)
    & (movies_df_title_indexed['Revenue (Millions)'] > movies_df_title_indexed['Revenue (Millions)'].quantile(0.75))
]


# Let’s group our dataset by director and see how much revenue each director has
movies_df.groupby('Director').sum()

# Let’s group our dataset by director and see the average rating of each director
movies_df.groupby('Director')[['Rating']].mean()


movies_df.groupby('Director')[['Revenue (Millions)']].sum().sort_values('Revenue (Millions)', ascending=False)

data_sorted=movies_df_indexed.sort_values(['Revenue (Millions)', 'Rating'], ascending = False)

data_sorted.head(10)


import numpy as np
import pandas as pd
None_Example = np.array([1, 2, None, 5])
print("dtype =", None_Example.dtype)
print(None_Example)


Nan_Example = np.array([1,2,np.nan, 5])
print("dtype=", Nan_Example.dtype)
print(Nan_Example)
print(Nan_Example+4)

movies_df_title_indexed.dropna(axis=1)
movies_df_title_indexed.isnull()
movies_df_title_indexed.isnull().sum()


movies_df_title_indexed.dropna()
movies_df_title_indexed.isnull()
movies_df_title_indexed.dropna().isnull().sum()


df = pd.read_csv("IMDB-Movie-Data.csv");
# Drop columns where all the values are missing
df.dropna(axis='columns', how='all')
# Thresh to specify a minimum number of non-null values
# for the row/column to be kept
df.dropna(axis='rows', thresh = 10)


revenue = movies_df_title_indexed['Revenue (Millions)']
revenue_mean = revenue.mean()
print("Mean Revenue:", revenue_mean)
revenue.fillna(revenue_mean, inplace=True)
movies_df_title_indexed.isnull().sum()

metascore = movies_df_title_indexed['Metascore']
metascore_mean = metascore.mean()
metascore.fillna(metascore_mean, inplace = True)
movies_df_title_indexed.isnull().sum()


movies_df_title_indexed.loc['Mindhorn']

movies_df_title_indexed['Revenue per Min'] = movies_df_title_indexed['Revenue (Millions)']/movies_df_title_indexed['Runtime (Minutes)']

movies_df_title_indexed['Revenue per Min']

# Let's calculate the mean revenue per director but by using a pivot table instead of groupby as seen previously
movies_df_title_indexed.pivot_table('Revenue (Millions)', index='Director',
aggfunc='sum', columns='Year').head()

#################################################################################
# 1. Let's define the function to put movies into buckets based on their rating
def rating_bucket(x):
    if x >= 8.0:
        return "great"
    elif x >= 7.0:
        return "good"
    elif x >= 6.0:
        return "average"
    else:
        return "bad"

# 2. Let's apply the function
movies_df_title_indexed["Rating_Category"] = movies_df_title_indexed["Rating"].apply(rating_bucket)

# 3. Let's see some results
movies_df_title_indexed.head(10)[['Rating','Rating_Category']]


###################################################################################
###    https://pandas.pydata.org/pandas-docs/stable/getting_started/basics.html
###    https://pandas.pydata.org/pandas-docs/stable/getting_started/tutorials.html
###   https://pandas.pydata.org/pandas-docs/stable/user_guide/cookbook.html#cookbook



