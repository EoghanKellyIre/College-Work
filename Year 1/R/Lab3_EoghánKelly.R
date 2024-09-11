#1)

#Simulate a population of 5,000 with a variable from a Normal(5,4) distribution 
x0 <- rnorm(1000,3,5)
#Simulate a population of 5,000 with a variable from an Exponential(1.2) distribution
y0 <- rexp(5000,1.2)
#Take a random sample of size 40 & 100 from x0
x1 <- sample(x0,40)
x2 <- sample(x0,100)
#Take a random sample of size 40 & 100 from y0
y1 <- sample(y0,40)
y2 <- sample(y0,100)

#2)

# record the size, mean and sd of x1
n_x1 <- length(x1)
mean_x1 <- mean(x1)
sd_x1 <- sd(x1)
# record the size, mean and sd of x0
n_x0 <- length(x0)
mean_x0 <- mean(x0)
sd_x0 <- sd(x0)

# record the size, mean and sd of y1
n_y1 <- length(y1)
mean_y1 <- mean(y1)
sd_y1 <- sd(y1)
# record the size, mean and sd of y0
n_y0 <- length(y0)
mean_y0 <- mean(y0)
sd_y0 <- sd(y0)

#calculate the standard error of mean_x1 using known and estimated sd_x0
se_kn_x1 <- sd_x0/sqrt(n_x1)
se_unkn_x1 <- sd_x1/sqrt(n_x1)

#calculate the standard error of mean_y1 using known and estimated sd_y0
se_kn_y1 <- sd_y0/sqrt(n_y1)
se_unkn_y1 <- sd_y1/sqrt(n_y1)


#Calculate Z-score for 95% CI
Z_score_x1 <- qnorm(0.975)
Z_score_y1 <- qnorm(0.975)

#Calculate critical t-value for 95% CI
t_score_x1 <- qt(0.975, n_x1-1)
t_score_y1 <- qt(0.975, n_y1-1)

#Calculate 95% CIs for x1 using ) the Z-score and the known population SD
left_Z95_kn_x1 <- mean_x1-Z_score_x1*se_kn_x1
right_z95_kn_x1 <- mean_x1+Z_score_x1*se_kn_x1

#Calculate 95% CIs for x1 using ) the t-distribution and the sample SD
left_t95_unkn_x1 <- mean_x1-t_score_x1*se_unkn_x1
right_t95_unkn_x1 <- mean_x1+t_score_x1*se_unkn_x1

#Calculate 95% CIs for y1 using ) the Z-score and the known population SD
left_Z95_kn_y1 <- mean_y1-Z_score_y1*se_kn_y1
right_z95_kn_y1 <- mean_y1+Z_score_y1*se_kn_y1

#Calculate 95% CIs for y1 using ) the t-distribution and the sample SD
left_t95_unkn_y1 <- mean_y1-t_score_y1*se_unkn_y1
right_t95_unkn_y1 <- mean_y1+t_score_y1*se_unkn_y1

#show results
paste("var: x0", "mean:", mean_x0, "sd:", sd_x0)
paste("var: x1", "mean:", mean_x1, "sd:", sd_x1, "se w/known pop sd:", se_kn_x1, "se w/unknown pop sd:", se_unkn_x1)
paste("95% CIs for estimate of population mean")
paste("Z-distribution w/known pop sd:", left_Z95_kn_x1, right_z95_kn_x1)
paste("t-distribution w/unknown pop sd:", left_t95_unkn_x1, right_t95_unkn_x1)

paste("var: y0", "mean:", mean_y0, "sd:", sd_y0)
paste("var: y1", "mean:", mean_y1, "sd:", sd_y1, "se w/known pop sd:", se_kn_y1, "se w/unknown pop sd:", se_unkn_y1)
paste("95% CIs for estimate of population mean")
paste("Z-distribution w/known pop sd:", left_Z95_kn_y1, right_z95_kn_y1)
paste("t-distribution w/unknown pop sd:", left_t95_unkn_y1, right_t95_unkn_y1)

#3)

#a)

#make a qqplot and a histogram with normal density curve for x0
qqnorm(x0)
qqline(x0)
hist(x0, freq = FALSE)
xfit_x0 <- seq(min(x0), max(x0), length = 40) 
yfit_x0 <- dnorm(xfit_x0, mean = mean(x0), sd = sd(x0))
lines(xfit_x0, yfit_x0)
#We can see that the population has an normal distribution, with no major deviations on the Q-Q 
#and the histogram also shows this.

#make a qqplot and a histogram with normal density curve for x1
qqnorm(x1)
qqline(x1)
hist(x1, freq = FALSE)
xfit_x1 <- seq(min(x1), max(x1), length = 40) 
yfit_x1 <- dnorm(xfit_x1, mean = mean(x1), sd = sd(x1))
lines(xfit_x1, yfit_x1)
#We can see less clearly if the population has a normal distribution, with some deviations on the Q-Q
#and not a close bell shape on the histogram. Indicating possibly some skewness and/or kurtosis.

#make a qqplot and a histogram with normal density curve for y0
qqnorm(y0)
qqline(y0)
hist(y0, freq = FALSE)
xfit_y0 <- seq(min(y0), max(y0), length = 40) 
yfit_y0 <- dnorm(xfit_y0, mean = mean(y0), sd = sd(y0))
lines(xfit_y0, yfit_y0)
#We can see that the population has an exponential distribution, with deviations at either end of the Q-Q 
#and the histogram showing this.

#make a qqplot and a histogram with normal density curve for y1
qqnorm(y1)
qqline(y1)
hist(y1, freq = FALSE)
xfit_y1 <- seq(min(y1), max(y1), length = 40) 
yfit_y1 <- dnorm(xfit_y1, mean = mean(y1), sd = sd(y1))
lines(xfit_y1, yfit_y1)
#We can see less clearly if the population has an exponential distribution, with deviations on the Q-Q
#and not a bell shape on the histogram. Indicating possibly some skewness and/or kurtosis

#b)

#I would be confident in the intervals from part 2. Using the known population SD, I think would provide better results.
#Although the sample sizes were small, therefore the confidence intervals will be less than perfect. If I used the sample
#of 100, I would be more confident of the confidence intervals.