import pandas as pd
  
# reading two csv files
data1 = pd.read_csv('datasets/nutrient_amount.csv')
data2 = pd.read_csv('datasets/nutrient_name.csv')
  
# using merge function by setting how='inner'
output1 = pd.merge(data1, data2, 
                   on='NutrientID', 
                   how='inner')
  
# displaying result
print(output1)
output1.to_csv("nutrient_merged.csv")