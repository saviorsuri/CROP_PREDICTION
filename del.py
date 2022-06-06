s = '''Machine learning is an important decision support tool for crop yield prediction, including supporting decisions on what crops to grow and what to do during the growing season of the crops. Several machine learning algorithms have been applied to support crop yield prediction research. In this study, we performed a Systematic Literature Review (SLR) to extract and synthesize the algorithms and features that have been used in crop yield prediction studies. Based on our search criteria, we retrieved 567 relevant studies from six electronic databases, of which we have selected 50 studies for further analysis using inclusion and exclusion criteria. We investigated these selected studies carefully, analyzed the methods and features used, and provided suggestions for further research. According to our analysis, the most used features are temperature, rainfall and soil type.  
The algorithm that I applied is Decision tree regression . We have entered the temperature ,air humidity , Ph value and rainfall as features in our model which predicts the right crop for us. In Decision Trees, for predicting a class label for a record we start from the root of the tree. We compare the values of the root attribute with the record’s attribute. On the basis of comparison, we follow the branch corresponding to that value and jump to the next node.
Future aspects of the project is that we will handle its IOT.The Air humidity, Air temperature, Soil moisture, Soil pH and the GPS sensor modules are integrated with the NodeMCU platform into a portable kit. This kit is installed in the farm to gather the respective data of the soil. The data gathered is transferred in real time to the firebase database for storage and further processing.The atmospheric humidity, temperature, soil moisture, soil pH are sent as it is to the database. The latitude and longitude sent by the GPS module is retrieved in the form of which state they fall under. This enables us to collect the rainfall of that place in the previous year.'''
print(len(s.split( )))
