## Architecture:

The app design has tried to follow **clean architecture**


* **Presenter:** Contains Mainly AndroidUI component and lies on Outer Circle of Architecture

* **Usecase:** Defines different kind of use cases like Get Account Details, Show All Transaction, Transfer Roundup amount  
  etc. 

* **Data:** It's repository layer which is abstraction on database sources

* **FrameWork:** Android backend components which utlises Android networking APIs. It also contains any other Android helper
  components like Preference helper etc. Most of the time it has provided implementation for Data layer.
            
* **Domain:** Actual business logic layer, defines all the models.
