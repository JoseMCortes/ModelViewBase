# ModelViewBase
 
This PoC shows how to manage the lifecycle of the data using different ViewModels, lifecycle aware components based on Android Archicture Components. It shares the information with other system-entities (such as Fragments).

The ViewModels offer a common contract/interface to save/restore instances using Bundles when the Activity recreation happens. 

Fragments bind their user interfaces with changes on the ViewModels using DataBinding (LiveData). When a data is changed (simulated) in the repository it will be automatically received by Fragments, updating their UI/Layouts.

![Blockchain](https://user-images.githubusercontent.com/4429438/44645574-635efe00-a9d8-11e8-8907-af2706288c5a.png)

 
