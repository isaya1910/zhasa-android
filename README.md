# zhasa-android
1. Presentation layer

  State: abstract represantation of view state
  
  ViewModel: holds states, communicates with view
  
  Action: abstract representation of user or system action(for example: open another screen, load list)
  
  Reducer: changes states according to updoming action

2. Repository layer
  
  Repository: saves and gets data from local or remote data source
  
3. Data layer
  
  Api: defines all REST operations
  
  DAO: defines all local data base operation
  
