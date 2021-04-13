
import pandas as pd

# Input 
data = {'Artist': ['Ariana Grande', 'Taylor Swift', 'Ed Sheeran', 'Justin Bieber', 'Lady Gaga', 'Bruno Mars'],
        'Genre': ['Jazz', 'Rock', 'Jazz', 'Pop', 'Pop', 'Rock'],
        'Listeners': [1300000, 2700000, 5000000, 2000000, 3000000, 1100000]}

labels = ['AG', 'TS', 'ED', 'JB', 'LG', 'BM']

# Your solution goes here
df = pd.DataFrame(data,labels);
# Uncomment the print statement once done
print(df)

# Your solution goes here

col=df['Listeners']
row=df.iloc[0];
# Uncomment the print statement once done
print("Row:\n", row)
print("##########")
print("Col:\n", col)


# Your solution goes here
pop_artists=df[df['Genre']=='Pop']
# Uncomment the print statement once done
print(pop_artists)

# Your solution goes here
top_pop=df[(df['Genre']=='Pop') &(df['Listeners'] > 2000000)]
# Uncomment the print statement once done
print(top_pop)



# Your solution goes here

grouped = df.groupby('Genre').sum()

# Uncomment the print statement once done
print(grouped)

