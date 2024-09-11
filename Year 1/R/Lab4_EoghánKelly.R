#Part A)

#1)
# we can extract some of these quantities from a vector like so:
Sample_1 <-rnorm(100,4,5) #simulate some data
n_1 <- length(Sample_1) #size of the sample
x_bar_1 <- mean(Sample_1) #mean of the sample
sd_1 <- sd(Sample_1) #this is the sample SD, in this case we know the population SD is 1 since we simulated our data

Sample_2 <-rnorm(80,3.5,2) #simulate some data
n_2 <- length(Sample_2) #size of the sample
x_bar_2 <- mean(Sample_2) #mean of the sample
sd_2 <- sd(Sample_2) #this is the sample SD, in this case we know the population SD is 1 since we simulated our data

# Find the Standard Error
s <- sqrt(((n_1-1)*(sd_1)^2+(n_2-1)*(sd_2)^2)/(n_1+n_2-2))
se <- (s*(sqrt((1/n_1)+(1/n_2))))

test_stat <- ((abs(x_bar_1-x_bar_2))/se)# Find the Test Statistic
df <- n_1+n_2-2 # Find the Degrees of freedom
p_val <- 2*pt(abs(test_stat), df, lower.tail=FALSE) #p-value for a two-tailed test

#2)
t.test(Sample_1, Sample_2)#Repeating the previous task using the t.test function in the package {stats}.

#Part B)

#1)
#Assuming these variables were known
Prop_1 #The proportion of a sample from Population 1.
n_1    #The size of the sample from Population 1.
Prop_2  #The proportion of a sample from Population 2.
n_2     #The size of the sample from Population 2.

#Finding the Standard Error
pi_bar_o <- ((Prop_1*n_1)+(Prop_2*n_2))/(n_1+n_2)
se <- sqrt((pi_bar_o)*(1-Prop_1)*((1/n_1)+(1/n_2)))

test_stat <- ((abs(Prop_1-Prop_2))/se)# Find the Test Statistic

#2)
#Different Formula for standard Error, now we rejected the null hypothesis
se <- sqrt(((Prop_1*(1-Prop_1))/n_1)+((Prop_2*(2-Prop_2))/n_2))
#Finding the 95% Confidence Interval
left_CI <- (Prop_1 - Prop_2)-1.96(se)(Prop_1 - Prop_2)
right_CI <- (Prop_1 - Prop_2)+1.96(se)(Prop_1 - Prop_2)

#Part C)

#1)
#Read in the csv file survey.csv using code
survey<-read.csv(file="survey.csv", header=TRUE)
#Create a contingency table for the variables Smoke and Exer 
table(survey$Exer, survey$Smoke)
#Run a chi square test
chisq.test(survey$Exer, survey$Smoke)

#2)
#a)
#The code above gave a warning message since n must be >20, all Expected values must be >1 and 
#no more than 20% of the expected values can be <5. In the data set provided, these criteria were not met.

#b)
#H0: There is no relationship between frequency of exercise frequency of 
#smoking in the population

#H1:There is a relationship between frequency of exercise frequency of 
#smoking in the population

#c)
# Results from chi square test
X-squared <- 5.4885
df <- 6
p-value <- 0.4828
# Since the p-value is less than the significance level of 0.05, we reject the null hypothesis.


