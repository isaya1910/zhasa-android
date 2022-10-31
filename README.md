# zhasa-android
Presentation layer:
  State: abstract represantation of view state
  
  ViewModel: holds states, communicates with view
  
  Action: abstract representation of user or system action(for example: open another screen, load list)
  
  Reducer: changes states according to updoming action

Repository layer:
  
  Repository: saves and gets data from local or remote data source
  
Data layer:
  
  Api: defines all REST operations
  
  DAO: defines all local data base operation
  
