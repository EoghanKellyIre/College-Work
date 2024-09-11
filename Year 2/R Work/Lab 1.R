# Questions
# 1. In Section 2.3 of the lecture notes, we looked at a Pharmaceutical example. Go back to the lecture
# notes on Blackboard and find these values. Read the data values into a vector in R. Construct a
# histogram of the data and find the summary statistics.

x <- c(1.1, 1.8, 2, 2.4, 2.5, 2.8, 2.9, 3, 3.4, 3.4, 4)
hist(x)

# 2. Simulate 1000 values from a standard normal distribution and construct a histogram for the values.
# Use a different seed to before.

set.seed(6124)
n <- 100
x1 <- rnorm(n)
hist(x1)

# 3. Simulate 200 values from a normal distribution with µ = 30 and σ
# 2 = 9. Hint: view the help files for
# rnorm. Use a different seed to before.
?rnorm
set.seed(614)
x2 <- rnorm(200, mean = 30, sd = 3)
hist(x2)

# 4. Repeat the previous step for 20,000 values. What do you notice when you compare the two histograms?

set.seed(614)
x3 <- rnorm(20000, mean = 30, sd = 3)
hist(x3)

# 5. The dataset “Lab1b.csv” is stored on Blackboard with the lab sheet for this session. Save this dataset
# into your module folder and read it into R. Hint: to view the first five lines of the dataset, you can
# run the code head(nameofdataset). Compute summary statistics and generate histograms for each
# variable. How would you describe the distribution of each variable?

Lab1a<-read.csv(file="Lab1a(1).csv", header=TRUE)
SSa=read.csv("Lab1a(1).csv")

Lab1b<-read.csv(file="Lab1b(1).csv", header=TRUE)
SSb=read.csv("Lab1b(1).csv")

summary(Lab1b$x1)
hist(Lab1b$x1)
summary(Lab1b$x2)
hist(Lab1b$x2)
summary(Lab1b$x3)
hist(Lab1b$x3)

?hist