# ModelViewBase
 
This PoC shows how to manage the lifecycle of the data using different ViewModels, lifecycle aware components based on Android Archicture Components. It shares the information with other system-entities (such as Fragments).

The ViewModels offer a common contract/interface to save/restore instances using Bundles when the Activity recreation happens. 

Fragments bind their user interfaces with changes on the ViewModels using DataBinding (LiveData). When a data is changed (simulated) in the repository it will be automatically received by Fragments, updating their UI/Layouts.

![Overview](https://github.com/JoseMCortes/ModelViewBase/blob/master/docs/architecture.png)

 
