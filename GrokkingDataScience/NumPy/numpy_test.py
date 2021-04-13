
# coding: utf-8

# In[19]:


import numpy as np
Z=np.zeros(10);
print(Z)

import numpy as np
arr=np.arange(10)
print(arr)

arr=np.random.random([3,3,3]) 
print(arr)

arr=np.random.random([10,10])
min_val=arr.min()
max_val=arr.max()
print(min_val)
print(max_val)



# 
# 

# In[30]:


import numpy as np
grid=np.arange(1,10).reshape([3, 3])
print(grid)


# In[50]:


arr6 = np.arange(10)
arr6[arr6.argmax()]=-1
print(arr6)


# In[55]:


arr7 = np.arange(9).reshape(3,3)
arr7 = arr7[::1,::-1]

