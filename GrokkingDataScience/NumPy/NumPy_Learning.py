
# coding: utf-8

# In[1]:


[print("Hello Data Science ")]


# In[3]:


import numpy as np


# In[14]:


arr1 = np.array([1,2,3,4], dtype='float32')
print (arr1)
print (type(arr1))
arr2 = np.array([1,2,3,4])
print (arr2)
print (type(arr2))
lists = [[0,1,2], [3,4,5], [6,7,8]]
arr2d = np.array(lists)
print(arr2d)
print(lists)
print(arr2d*2)
print(arr2d* arr2d)


# In[24]:


np.zeros(100, dtype=int)
np.ones((3, 3), dtype=float)
np.arange(0, 20, 3)
np.linspace(0, 1, 100)
np.random.random((3, 3))
np.random.randint(0, 10, (3, 3))
np.random.normal(0, 1, (3, 3))


# In[25]:


import numpy as np

# Create a 3x3 array of random integers in the interval [0, 10)
x = np.random.randint(0, 10, (3, 3))

print("ndim: ", x.ndim)
print("shape:", x.shape)
print("x size: ", x.size)
print("dtype:", x.dtype)
print("itemsize:", x.itemsize, "bytes")
print("nbytes:", x.nbytes, "bytes")


# In[39]:


x1 = np.array([1, 3, 4, 4, 6, 4])
x1[0]
x1[3]
print(x1[-2])
x2 = np.array([[3, 2, 5, 5],[0, 1, 5, 8], [3, 0, 5, 0]])
x2[2,3]



# In[47]:


x1 = np.arange(10) # Input array
x1[1:5]
x1[4:]
x1[4:7]
x1[::2]
x1[::-1]


# In[50]:


x2 = np.array([[0,1,2], [3,4,5], [6,7,8]])
x2[:2,:2]
x2[::-1,]
x2[::-1,::-1]


# In[51]:


import numpy as np
reshaped = np.arange(1, 10).reshape((3, 3))
print(reshaped)


# In[52]:


x = np.array([1, 2, 3])
print(x)

# row vector via reshape
x_rv= x.reshape((1, 3))
print(x_rv)

# column vector via reshape
x_cv = x.reshape((3, 1))
print(x_cv)


# In[56]:


# We can concatenate two or more arrays at once.
x = np.array([1, 2, 3])
y = np.array([3, 2, 1])
z = [11,11,11]

np.concatenate([x, y, z])
#> array([ 1,  2,  3,  3,  2,  1, 11, 11, 11])

# We can also concatenate 2-dimensional arrays.
grid = np.array([[1,2,3] , [4,5,6]])
result =np.concatenate([grid, grid])
#> array([[1, 2, 3],
#>       [4, 5, 6],
#>       [1, 2, 3],
#>       [4, 5, 6]])
print(result)


# In[57]:


x = np.array([3,4,5])
grid = np.array([[1,2,3],[9,10,11]])

np.vstack([x,grid]) # vertically stack the arrays
#> array([[ 3,  4,  5],
#>       [ 1,  2,  3],
#>       [9, 10, 11]])

z = np.array([[19],[19]])
np.hstack([grid,z])  # horizontally stack the arrays
#> array([[ 1,  2,  3, 19],
#>       [9, 10, 11, 19]])


# In[58]:


x = np.arange(10)
#> array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])

x1, x2, x3 = np.split(x,[3,6])
print(x1, x2, x3)


# In[59]:


import numpy as np

grid = np.arange(16).reshape((4, 4))
print(grid, "\n")

# Split vertically and print upper and lower arrays
upper, lower = np.vsplit(grid, [2])
print(upper)
print(lower, "\n")

# Split horizontally and print left and right arrays
left, right = np.hsplit(grid, [2])
print(left)
print(right)



# coding: utf-8

# In[60]:


import numpy as np

x = np.arange(10)

# Native arithmentic operators
print("x =", x)
print("x + 5 =", x + 5)
print("x - 5 =", x - 5)
print("x * 5 =", x * 5)
print("x / 5 =", x / 5)
print("x ** 2 = ", x ** 2)
print("x % 2  = ", x % 2)

# OR we can use explicit functions, ufuncs, e.g. "add" instead of "+"
print(np.add(x, 5))
print(np.subtract(x, 5))
print(np.multiply(x, 5))
print(np.divide(x, 5))
print(np.power(x, 2))
print(np.mod(x, 2))


# In[62]:


theta = np.linspace(0, np.pi, 4)
print("theta      = ", theta)
print("sin(theta) = ", np.sin(theta))
print("cos(theta) = ", np.cos(theta))
print("tan(theta) = ", np.tan(theta))


# In[63]:


x = [1, 2, 3]
print("x     =", x)
print("e^x   =", np.exp(x))
print("2^x   =", np.exp2(x))
print("3^x   =", np.power(3, x))

print("ln(x)    =", np.log(x))
print("log2(x)  =", np.log2(x))
print("log10(x) =", np.log10(x))


# In[64]:


x = np.arange(1, 6)
sum_all = np.add.reduce(x)

print(x)
print(sum_all)


# In[65]:


x = np.arange(1, 6)
sum_acc = np.add.accumulate(x)

print(x)
print(sum_acc)


# In[66]:


import numpy as np

x = np.random.random(100)

# Sum of all the values
print("Sum of values is:", np.sum(x))
# Mean value
print("Mean value is: ", np.mean(x))

#For min, max, sum, and several other NumPy aggregates, 
#a shorter syntax is to use methods of the array object itself,
# i.e. instead of np.sum(x), we can use x.sum()
print("Sum of values is:", x.sum())
print("Mean value is: ", x.mean())
print("Max value is: ", x.max())
print("Min value is: ", x.min())


# In[68]:


import numpy as np

grid = np.random.random((3, 4))
print(grid)

print("Overall sum:", grid.sum())
print("Overall Min:", grid.min())

# Row wise and column wise min
print("Column wise minimum: ", np.amin(grid, axis=0))
print("Row wise minimum: ", np.amin(grid, axis=1))


# In[69]:


import numpy as np

x = np.array([1, 2, 3, 4, 5])

print(x < 2) # less than
print(x >= 4) # greater than or equal


# In[70]:


x = np.array([1, 2, 3, 4, 5])

# Elements for which multiplying by two is the same as the square of the value
(2 * x) == (x ** 2)
#> array([False,  True, False, False, False], dtype=bool)


# In[79]:



x = np.arange(10)
print(x)

# How many values less than 6?
print(np.count_nonzero(x < 6))

# Are there any values greater than 8?
print(np.any(x > 8))

# Are all values less than 10?
print(np.all(x < 10))


# In[80]:


import numpy as np 

# Random integers between [0, 10) of shape 3x3
x = np.random.randint(0, 10, (3, 3))
print(x)

# Boolean array
print(x < 6)

# Boolean mask
print(x[x < 6])


# In[85]:






