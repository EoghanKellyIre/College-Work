#Setting a variable of number of times the choice to stay wins as 0
n_stay <- 0   

#Setting a variable of number of times the choice to switch wins as 0
n_switch <- 0

#Setting a variable of number of times the random choice wins as 0
n_random <- 0

# Running a loop of this code 100 times
for ( i in 1:100) {
  
  # Making a vector of the 3 doors
  door <- c(1,2,3) 
  
  # Randomly selecting one of the doors as the one with the car
  cardoor <- sample(door,1) 
  
  # Randomly selecting one of the doors as the choice
  choice <- sample(door,1) 
  
  # Making a vector of the goat doors, by looking at all the doors less the cardoor
  goatdoors <- setdiff(door, cardoor) 
  
  # Making a vector of possible reveals, by looking at the goatdoors less the current choice
  reveal_options <- setdiff(goatdoors, choice) 
  
  #if the choice was the cardoor it sets the reveal vector as random option of the reveal options
  #If not set the reveal vector to be the reveal option vector
  if (choice == cardoor) { 
    reveal <- sample(reveal_options,1)
  } else {
    reveal <- reveal_options 
  }
  
  # Sets a vector of the remaining door as all the doors less the one revealed
  remaining_doors <-setdiff(door, reveal)
  
  # Sets a vector of a random choice by choosing one of the remaining doors
  randomchoice <- sample(remaining_doors,1)
  
  # Sets a vector of new choice by by looking at the remaining doors less the original choice
  newchoice <- setdiff(remaining_doors, choice)   
  
  # Adds 1 to the count of staying winning if choice was the same as cardoor
  if (choice == cardoor) {
    n_stay <- n_stay + 1
  }
  # Adds 1 to the count of switching door winning if choice was the same as cardoor
  if (newchoice == cardoor) {
    n_switch <- n_switch + 1
  }
  # Adds 1 to the count of randomly choseing between staying and switching winning if choice was the same as cardoor
  if (randomchoice == cardoor) {
    n_random <- n_random + 1
  }
}
# Displays in console the success rate of staying out of 100
print(n_stay/100)

# Displays in console the success rate of switching out of 100
print(n_switch/100)

# Displays in console the success rate of random choice out of 100
print(n_random/100)