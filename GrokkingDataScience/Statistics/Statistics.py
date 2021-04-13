
# coding: utf-8

# In[2]:


import numpy as np 

# The dataset
learning_hours = [1, 2, 6, 4, 10]
scores = [3, 4, 6, 5, 6]

# Applying some stats methods to understand the data:
print("Mean learning time: ", np.mean(learning_hours))
print("Mean score: ", np.mean(scores))
print("Median learning time: ", np.median(learning_hours))
print("Standard deviation: ", np.std(learning_hours))
print("Correlation between learning hours and scores:", np.corrcoef(learning_hours, scores))


#################################
# Import libraries
import numpy as np
import seaborn as sns

# Create some random fake data
x = np.random.random(size=1000000)

# Plot the distribution
sns.distplot(x);

#################################
# Create some data that follows a Normal Distribution
x = np.random.normal(size=1000000)

# Plot the distribution
sns.distplot(x);    

